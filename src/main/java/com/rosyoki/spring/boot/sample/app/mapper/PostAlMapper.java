/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

/**
 * @author hirofumi_tsutsui
 *
 */
@Mapper
public interface PostAlMapper {
    PostZipData select(Long Id);
    List<PostZipData> selectByCity(String city);
    PostZipData selectByZip(String zip);
}
