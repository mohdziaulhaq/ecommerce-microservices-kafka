package org.ecom.commonutils.user.dtos;

import org.ecom.commonutils.enums.user.AppRole;

public class RoleDto {
    private Integer roleId;
    private AppRole roleName;

    public RoleDto(Integer roleId, AppRole roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleDto() {
    }

    public static RoleDtoBuilder builder() {
        return new RoleDtoBuilder();
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public AppRole getRoleName() {
        return this.roleName;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(AppRole roleName) {
        this.roleName = roleName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleDto)) return false;
        final RoleDto other = (RoleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        final Object this$roleName = this.getRoleName();
        final Object other$roleName = other.getRoleName();
        if (this$roleName == null ? other$roleName != null : !this$roleName.equals(other$roleName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $roleName = this.getRoleName();
        result = result * PRIME + ($roleName == null ? 43 : $roleName.hashCode());
        return result;
    }

    public String toString() {
        return "RoleDto(roleId=" + this.getRoleId() + ", roleName=" + this.getRoleName() + ")";
    }

    public static class RoleDtoBuilder {
        private Integer roleId;
        private AppRole roleName;

        RoleDtoBuilder() {
        }

        public RoleDtoBuilder roleId(Integer roleId) {
            this.roleId = roleId;
            return this;
        }

        public RoleDtoBuilder roleName(AppRole roleName) {
            this.roleName = roleName;
            return this;
        }

        public RoleDto build() {
            return new RoleDto(this.roleId, this.roleName);
        }

        public String toString() {
            return "RoleDto.RoleDtoBuilder(roleId=" + this.roleId + ", roleName=" + this.roleName + ")";
        }
    }
}
