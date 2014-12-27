/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.postal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rosyoki.spring.boot.sample.app.postal.service.PostAlService;
import com.rosyoki.spring.boot.sample.app.users.entity.PostZipData;

/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class PostAlController {
    
    private Logger logger = Logger.getLogger(PostAlController.class);
    
    @Autowired
    PostAlService postAlService;
    
    @RequestMapping(value="/postal/postalList")
    public String viewPostAlList() {
        
        List<PostZipData> postZipDataList = postAlService.getPostAlAllData();
        logger.info(">>>>> " + postZipDataList.size());
        return "postal/postAlList";
    }
}
