/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.service.postal;

import java.util.List;

import javax.transaction.Transactional;

import com.rosyoki.spring.boot.sample.app.datasource.PostAlRepositryDb;
import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
@Transactional
public class PostAlService {

    @Autowired
    PostAlRepositryDb postAlRepositryDb;

    /**
     * 市名で検索する。
     * 
     * @param city
     * @return
     */
    public List<PostZipData> getPostAlDataByCity(City city) {
       return postAlRepositryDb.getPostAlDataByCity(city);
    }
    
    public PostZipData getPostDataByZip(NewZip newZip) {
        return postAlRepositryDb.getPostDataByZip(newZip);
    }
}
