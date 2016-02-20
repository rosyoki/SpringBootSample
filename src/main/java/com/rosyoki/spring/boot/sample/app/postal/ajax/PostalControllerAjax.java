/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.postal.ajax;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rosyoki.spring.boot.sample.app.postal.service.PostAlService;
import com.rosyoki.spring.boot.sample.app.users.entity.PostZipData;

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
    @RequestMapping(value="/ajax/postal/{id}", method = RequestMethod.GET,produces = "application/json")
    public PostZipData getPostalData(@PathVariable Long id) {
        logger.info(">>>>> start getPostalData >>>>>");
        
        PostZipData postZipData = postAlService.getPostData(id);

        return postZipData;
    }
    
    @CrossOrigin
    @RequestMapping(value="/ajax/getTownData/{city}", method = RequestMethod.POST,produces = "application/json")
    public List<PostZipData> getPostalDataByCity(@PathVariable String city) {
        logger.info(">>>>> start getPostalDataByCity >>>>>");
        
        List<PostZipData> postZipDatas = postAlService.getPostAlDataByCity(city);

        return postZipDatas;
    }
}
