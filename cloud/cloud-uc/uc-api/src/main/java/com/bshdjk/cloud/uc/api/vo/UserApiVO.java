package com.bshdjk.cloud.uc.api.vo;

import com.bshdjk.cloud.common.serializer.ImgJsonSerializer;
import com.bshdjk.cloud.common.vo.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用户表VO
 *
 * @author YXF
 * @date 2020-12-08 11:18:04
 */
public class UserApiVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long userId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("头像图片路径")
	@JsonSerialize(using = ImgJsonSerializer.class)
    private String pic;

    @ApiModelProperty("状态 1 正常 0 无效")
    private Integer status;

    @ApiModelProperty("是否创建过店铺")

	/**
	 * openId list
	 */
	private List<String> bizUserIdList;

	public List<String> getBizUserIdList() {
		return bizUserIdList;
	}

	public void setBizUserIdList(List<String> bizUserIdList) {
		this.bizUserIdList = bizUserIdList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserApiVO{" +
				"userId=" + userId +
				",createTime=" + createTime +
				",updateTime=" + updateTime +
				",nickName=" + nickName +
				",pic=" + pic +
				",status=" + status +
				'}';
	}
}