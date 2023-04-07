package com.bshdjk.cloud.epp.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * zoo DTO
 *
 * @author zhouxd
 * @date 2023-04-07 10:15:32
 */
public class ZooDTO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("备注")
    private String remark;

	@ApiModelProperty("菜单id列表")
	private List<Long> menuIds;

	@ApiModelProperty("菜单资源id列表")
	private List<Long> menuPermissionIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}

	public List<Long> getMenuPermissionIds() {
		return menuPermissionIds;
	}

	public void setMenuPermissionIds(List<Long> menuPermissionIds) {
		this.menuPermissionIds = menuPermissionIds;
	}

	@Override
	public String toString() {
		return "RoleDTO{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", remark='" + remark + '\'' +
				", menuIds=" + menuIds +
				", menuPermissionIds=" + menuPermissionIds +
				'}';
	}
}