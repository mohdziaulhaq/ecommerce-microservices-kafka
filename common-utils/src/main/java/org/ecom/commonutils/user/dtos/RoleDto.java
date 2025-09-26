package org.ecom.commonutils.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ecom.commonutils.enums.user.AppRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    private Integer roleId;
    private AppRole roleName;
}
