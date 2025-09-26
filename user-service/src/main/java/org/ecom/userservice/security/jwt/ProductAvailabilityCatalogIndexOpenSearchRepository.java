package org.ecom.userservice.security.jwt; ///** Product Availability Catalog Index OpenSearch Repository. */
//@Log4j2
//public class ProductAvailabilityCatalogIndexOpenSearchRepository extends OpenSearchRepository
//        implements ProductAvailabilityCatalogIndexRepository {
//
//    private final OpenSearchClient openSearchClient;
//    private final ObjectMapper mapper;
//    private final RetryConfig retryConfig;
//    private final RetryRegistry registry;
//    private final Retry retry;
//
//    private static final String INDEX_NAME = "product-availability-catalog";
//    private static final Integer MAX_RESULTS_DEFAULT = 10000;
//
//    /**
//     * Constructs ProductAvailabilityCatalogIndexOpenSearchRepository with the default Retry
//     * Configuration.
//     *
//     * @param openSearchClient openSearchClient
//     * @param objectMapper objectMapper
//     */
//    public ProductAvailabilityCatalogIndexOpenSearchRepository(
//            OpenSearchClient openSearchClient, ObjectMapper objectMapper) {
//        this.openSearchClient = openSearchClient;
//        this.mapper = objectMapper;
//        this.retryConfig = RetryConfigUtil.getDefaultRetryConfig();
//        this.registry = RetryRegistry.of(this.retryConfig);
//        this.retry = registry.retry("ProductAvailabilityCatalogIndexOpenSearchRepository", this.retryConfig);
//    }
//
//    @Override
//    public PaginatedResult<ProductAvailabilityCatalogRecordEntity> listProductAvailabilityCatalog(
//            ProductAvailabilityCatalogIndexFilter filter, PaginatedQuery query) throws InvalidTokenException {
//
//        log.trace("Starting search with Filter: {} and Query: {}", filter, query);
//
//        // Pagination setup
//        Integer maxResults = ObjectUtils.firstNonNull(query.getMaxResults(), MAX_RESULTS_DEFAULT);
//        log.trace("Using maxResults: {}", maxResults);
//
//        List<String> searchAfter = null;
//        final String tokenString = query.getNextToken();
//        if (tokenString != null) {
//            log.trace("Processing pagination token: {}", tokenString);
//            final OpenSearchPaginationToken token = OpenSearchPaginationUtil.getNextToken(mapper, tokenString);
//            if (token != null) {
//                searchAfter = token.getSearchAfter();
//                log.trace("SearchAfter values: {}", searchAfter);
//            }
//        }
//
//        // Building queries
//        List<Query> queryList = new ArrayList<>();
//
//        // Extract filter values
//        final String reference = filter.getReference();
//        final String productId = filter.getProductId();
//        final String parentProductId = filter.getParentProductId();
//        final String productName = filter.getProductName();
//        final String productType = filter.getProductType();
//        final String availabilityStatus = filter.getAvailabilityStatus();
//        final String rootLocationId = filter.getRootLocationId();
//
//        log.info(
//                "Filter values - productId: {}, parentProductId: {}, productName: {}, "
//                        + "productType: {}, availabilityStatus: {}, rootLocationId: {}, reference: {}",
//                productId,
//                parentProductId,
//                productName,
//                productType,
//                availabilityStatus,
//                rootLocationId,
//                reference); // ADD reference HERE
//
//// ADD CATALOG FILTERING LOGIC HERE
////         ADD CATALOG FILTERING LOGIC HERE
//        if ("catalog".equals(reference)) {
//            log.info("Applying catalog-specific filters");
//
//            // 1. Only external products (audience = EXTERNAL)
//            addTermQueryIfNotNull(queryList, "audience", "EXTERNAL");
//
//            // 2. Only active products (activeState = ACTIVE)
//            addTermQueryIfNotNull(queryList, "activeState", "ACTIVE");
//
//            // 3. Exclude test products (no APS_INTEGRATION_RESERVED tag)
//            BoolQuery.Builder excludeTestQuery = new BoolQuery.Builder();
//            excludeTestQuery.mustNot(Query.of(q -> q.exists(e -> e.field("tags.APS_INTEGRATION_RESERVED"))));
//            queryList.add(excludeTestQuery.build().toQuery());
//
//            // 4. Exclude shutdown products (productLifecycleStage != SHUTDOWN)
//            BoolQuery.Builder excludeShutdownQuery = new BoolQuery.Builder();
//            excludeShutdownQuery.mustNot(Query.of(q -> q.term(t -> t.field("productLifecycleStage").value(FieldValue.of("SHUTDOWN")))));
//            queryList.add(excludeShutdownQuery.build().toQuery());
//        }
//
//// Add queries for top-level fields (existing code continues here)
//
//        // Add queries for top-level fields
//        addTermQueryIfNotNull(queryList, "productId", productId);
//        addTermQueryIfNotNull(queryList, "parentProductId", parentProductId);
//        addMatchBoolPrefixQueryIfNotNull(queryList, "productName", productName);
//        addTermQueryIfNotNull(queryList, "productType", productType);
//
//        final BoolQuery.Builder boolQueryBuilder = new BoolQuery.Builder();
//        // Auth query
//        Collection<String> authGroups = filter.getAuthGroups();
//        log.info("Limiting with groups: {}", authGroups);
//        // if auth groups is null then we're read all
//        if (authGroups != null && !authGroups.isEmpty()) {
//            Query authQuery = createCombinedReadGroupsQuery(authGroups);
//            Query publicQuery = createPublicQuery("PUBLIC_INTERNAL");
//            // This is an logical OR query so if it matches either authorization or public. It must also
//            // match at least one of these.
//            boolQueryBuilder.should(publicQuery);
//            boolQueryBuilder.should(authQuery);
//            boolQueryBuilder.minimumShouldMatch("1");
//        }
//
//        log.trace("Top-level queries built. Query list size: {}", queryList.size());
//
//        boolQueryBuilder.must(queryList);
//        log.trace("Built bool query with {} conditions", queryList.size());
//
//        SearchRequest.Builder searchRequestBuilder = new SearchRequest.Builder();
//        searchRequestBuilder.query(boolQueryBuilder.build().toQuery());
//        searchRequestBuilder.index(INDEX_NAME);
//        searchRequestBuilder.size(maxResults);
//
//        final FieldSort fieldSort = SortOptionsBuilders.field()
//                .field("productHierarchyPath.keyword")
//                .order(SortOrder.Asc)
//                .build();
//        searchRequestBuilder.sort(new SortOptions.Builder().field(fieldSort).build());
//        if (searchAfter != null) {
//            searchRequestBuilder.searchAfter(searchAfter);
//        }
//
//        SearchRequest searchRequest = searchRequestBuilder.build();
//        try {
//            log.warn("Final search request: {}", extractQuery(searchRequest));
//        } catch (IOException e) {
//            log.warn("Unable to extract query for logging", e);
//        }
//
//        // Execute search
//        Supplier<SearchResponse<ProductAvailabilityCatalogRecordEntity>> supplier = () -> {
//            try {
//                log.trace("Executing OpenSearch query");
//                return openSearchClient.search(searchRequest, ProductAvailabilityCatalogRecordEntity.class);
//            } catch (NoHttpResponseException e) {
//                log.error("No HTTP response from OpenSearch", e);
//                throw new RepositoryUnavailableException(ErrorMessage.EXCEPTION_NO_HTTP_RESPONSE);
//            } catch (IOException e) {
//                log.error("IO Exception during search", e);
//                throw new RuntimeException(e);
//            } catch (OpenSearchException ose) {
//                log.error("OpenSearch exception with status {}", ose.status(), ose);
//                switch (ose.status()) {
//                    // This is what we were getting from OpenSearch in logs.
//                    case 504:
//                        // The docs says that it's 503
//                    case 503:
//                        // Sometimes opensearch will be throttled and throw this.
//                    case 429:
//                        throw new RepositoryUnavailableException(ErrorMessage.EXCEPTION_REPOSITORY_UNAVAILABLE);
//                    default:
//                        throw ose;
//                }
//            }
//        };
//
//        Supplier<SearchResponse<ProductAvailabilityCatalogRecordEntity>> retryingSearch =
//                Retry.decorateSupplier(retry, supplier);
//
//        SearchResponse<ProductAvailabilityCatalogRecordEntity> searchResponse = retryingSearch.get();
//
//        HitsMetadata<ProductAvailabilityCatalogRecordEntity> hitsMetadata = searchResponse.hits();
//        List<Hit<ProductAvailabilityCatalogRecordEntity>> hits = hitsMetadata.hits();
//        // Process results
//        List<ProductAvailabilityCatalogRecordEntity> items = new ArrayList<>();
//        OpenSearchPaginationToken nextToken = null;
//
//        // We're already getting all items we might as well filter it out ourself so we don't hit the
//        // max limit.
//        if (!hits.isEmpty()) {
//            items.addAll(hits.stream()
//                    .map(hit -> {
//                        ProductAvailabilityCatalogRecordEntity product = hit.source();
//                        if (product == null) {
//                            throw new RuntimeException("Source was empty.");
//                        }
//                        List<LocationAvailability> locations = product.getLocationAvailabilities().stream()
//                                .filter(location -> {
//                                    String rootId = filter.getRootLocationId();
//                                    return rootId != null ? rootId.equals(location.getRootLocationId()) : true;
//                                })
//                                .filter(location -> {
//                                    String status = filter.getAvailabilityStatus();
//                                    return status != null ? status.equals(location.getStatus()) : true;
//                                })
//                                .toList();
//                        product.setLocationAvailabilities(locations);
//                        return product;
//                    })
//                    .toList());
//            List<String> sort = hits.get(hits.size() - 1).sort();
//            if (!sort.isEmpty()) {
//                nextToken = OpenSearchPaginationToken.builder()
//                        .size(maxResults)
//                        .searchAfter(sort)
//                        .build();
//            }
//        }
//
//        // Build final result
//        final PaginatedResult.PaginatedResultBuilder<ProductAvailabilityCatalogRecordEntity> builder =
//                PaginatedResult.builder();
//        if (nextToken != null) {
//            String nextTokenString = OpenSearchPaginationUtil.getNextTokenString(mapper, nextToken);
//            builder.nextToken(nextTokenString);
//        }
//        builder.items(items);
//
//        PaginatedResult<ProductAvailabilityCatalogRecordEntity> result = builder.build();
//        log.trace("Returning result with {} items", result.getItems().size());
//        log.info("abcd++++++ {}",result.getItems());
//
//        return result;
//    }
//
//    private Query createPublicQuery(String publicStatus) {
//        return Query.of(q -> q.match(t -> t.field("publicAccess").query(FieldValue.of(publicStatus))));
//    }
//}