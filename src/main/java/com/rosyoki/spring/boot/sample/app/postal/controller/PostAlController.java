/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.postal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rosyoki.spring.boot.sample.app.postal.service.PostAlService;


/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class PostAlController {

    private Logger logger = Logger.getLogger(PostAlController.class);

    @Autowired
    PostAlService postAlService;

    @RequestMapping(value = "/postal/postalList")
    public String viewPostAlList() {
        logger.debug(">>>>>>>>>>>>>>>>> viewPostalList >>>>>>>>>>>>>>>>");

        return "postal/postalList";
    }
}
