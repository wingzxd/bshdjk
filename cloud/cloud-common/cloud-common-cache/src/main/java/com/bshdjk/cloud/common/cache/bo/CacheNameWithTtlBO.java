package com.bshdjk.cloud.common.cache.bo;

import lombok.Data;

/**
 * 通过 cacheName 配置 和 时间告诉缓存多久清除一遍
 *
 * @author FrozenWatermelon
 * @since 2020/7/4
 */
@Data
public class CacheNameWithTtlBO {

	private String cacheName;

	private Integer ttl;

	public CacheNameWithTtlBO(String cacheName, Integer ttl) {
		this.cacheName = cacheName;
		this.ttl = ttl;
	}

	@Override
	public String toString() {
		return "CacheNameWithTtlBO{" + "cacheName='" + cacheName + '\'' + ", ttl=" + ttl + '}';
	}
}
