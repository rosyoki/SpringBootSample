/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.rosyoki.spring.boot.sample.app.entity.Users;

/**
 * @author hirofumi_tsutsui
 *
 */
@Mapper
public interface UsersMapper {
    Users select(Integer Id);
}
