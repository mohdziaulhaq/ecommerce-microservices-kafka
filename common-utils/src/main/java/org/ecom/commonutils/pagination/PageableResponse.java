package org.ecom.commonutils.pagination;

import java.util.List;

public class PageableResponse<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private long totalPages;
    private boolean lastPage;

    public PageableResponse(List<T> content, int pageNumber, int pageSize, long totalElements, long totalPages, boolean lastPage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.lastPage = lastPage;
    }

    public PageableResponse() {
    }

    public static <T> PageableResponseBuilder<T> builder() {
        return new PageableResponseBuilder<T>();
    }

    public List<T> getContent() {
        return this.content;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public long getTotalPages() {
        return this.totalPages;
    }

    public boolean isLastPage() {
        return this.lastPage;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public static class PageableResponseBuilder<T> {
        private List<T> content;
        private int pageNumber;
        private int pageSize;
        private long totalElements;
        private long totalPages;
        private boolean lastPage;

        PageableResponseBuilder() {
        }

        public PageableResponseBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PageableResponseBuilder<T> pageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public PageableResponseBuilder<T> pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PageableResponseBuilder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageableResponseBuilder<T> totalPages(long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PageableResponseBuilder<T> lastPage(boolean lastPage) {
            this.lastPage = lastPage;
            return this;
        }

        public PageableResponse<T> build() {
            return new PageableResponse<T>(this.content, this.pageNumber, this.pageSize, this.totalElements, this.totalPages, this.lastPage);
        }

        public String toString() {
            return "PageableResponse.PageableResponseBuilder(content=" + this.content + ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", totalElements=" + this.totalElements + ", totalPages=" + this.totalPages + ", lastPage=" + this.lastPage + ")";
        }
    }
}