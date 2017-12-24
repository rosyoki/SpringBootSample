/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.ajax.postal;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.service.postal.PostAlService;

/**
 * @author hirofumi_tsutsui
 *
 */
@RestController
public class PostalControllerAjax {
    
    @Autowired
    PostAlService postAlService;
    
    private Logger logger = Logger.getLogger(PostalControllerAjax.class);
    
    @CrossOrigin
    @RequestMapping(value="/ajax/postal/{id}", produces = "application/json")
    public PostZipData getPostalData(@PathVariable Long id) {
        logger.info(">>>>> start getPostalData >>>>>");
        
        //郵便番号情報を取得する。
        PostZipData postZipData = postAlService.getPostData(id);

        logger.info(">>>>> end getPostalData >>>>>");
        
        return postZipData;
    }
    
    @CrossOrigin(origins={"http://localhost","http://server1.rosyoki.com"})
    @RequestMapping(value="/ajax/postal/town/{city}", method = RequestMethod.POST,produces = "application/json")
    public List<PostZipData> getPostalDataByCity(@PathVariable String city) {
        logger.info(">>>>> start getPostalDataByCity >>>>>");
        
        if(StringUtils.isEmpty(city)) {
        	return null;
        }
        //郵便番号一覧情報を取得する。
        List<PostZipData> postZipDatas = postAlService.getPostAlDataByCity(city);
        
        //データ取得チェック
        if(postZipDatas == null) {
        	return null;
        }
        
        if(postZipDatas.size() == 0) {
        	return null;
        }
        
        logger.info(">>>>> end getPostalDataByCity >>>>>");
        
        return postZipDatas;
    }
    
    @CrossOrigin(origins={"http://localhost","http://server1.rosyoki.com"})
    @RequestMapping(value="/ajax/postal/zip/{zip}",produces = "application/json")
    public PostZipData getPostalDataByZip(@PathVariable String zip) {
        logger.info(">>>>> start getPostalDataByZip >>>>>");

        if(StringUtils.isEmpty(zip)) {
        	return null;
        }
        // 郵便番号から住所を取得する。
        PostZipData postZipData = postAlService.getPostDataByZip(zip);
        //データチェック
        if(postZipData == null) {
        	return null;
        }
        logger.info(">>>>> end getPostalDataByZip >>>>>");
        
        return postZipData;
    }
}
