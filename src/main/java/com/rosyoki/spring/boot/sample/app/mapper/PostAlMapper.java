/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

/**
 * @author hirofumi_tsutsui
 *
 */
@Mapper
public interface PostAlMapper {
    PostZipData select(Long Id);
}
