/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.postal.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.mapper.PostAlMapper;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
@Transactional
public class PostAlService {
    @Autowired
    PostAlMapper postAlMappler;
    
    /**
     * IDで検索する。
     * @param Id
     * @return
     */
    public PostZipData getPostData(Long Id) {
        return postAlMappler.select(Id);
    }
    
    /**
     * 市名で検索する。
     * 
     * @param city
     * @return
     */
    public List<PostZipData> getPostAlDataByCity(String city) {
        return postAlMappler.selectByCity(city);
    }
}
