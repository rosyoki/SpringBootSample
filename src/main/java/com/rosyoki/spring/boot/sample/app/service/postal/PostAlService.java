/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.service.postal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.entity.PostZipDataExample;
import com.rosyoki.spring.boot.sample.app.mapper.PostZipDataMapper;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
@Transactional
public class PostAlService {
    @Autowired
    PostZipDataMapper postZipDataMapper;
    
    /**
     * IDで検索する。
     * @param Id
     * @return
     */
    public PostZipData getPostData(Long Id) {
        return postZipDataMapper.selectByPrimaryKey(Id);
    }
    
    /**
     * 市名で検索する。
     * 
     * @param city
     * @return
     */
    public List<PostZipData> getPostAlDataByCity(String city) {
        PostZipDataExample postZipDataExample = new PostZipDataExample();
        postZipDataExample.createCriteria().andCityEqualTo(city);
        
        return postZipDataMapper.selectByExampleWithBLOBs(postZipDataExample);
    }
    
    public PostZipData getPostDataByZip(String zip) {
        PostZipDataExample postZipDataExample = new PostZipDataExample();
        postZipDataExample.createCriteria().andZipEqualTo(zip);
        return postZipDataMapper.selectByExampleWithBLOBs(postZipDataExample).get(0);
    }
}
