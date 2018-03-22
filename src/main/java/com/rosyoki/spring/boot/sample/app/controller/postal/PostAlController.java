/**
 *
 */
package com.rosyoki.spring.boot.sample.app.controller.postal;

import com.rosyoki.spring.boot.sample.app.service.postal.PostAlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author hirofumi_tsutsui
 */
@Controller
@Slf4j
public class PostAlController {

    @Autowired
    PostAlService postAlService;

    @RequestMapping(value = "/postal/postalList")
    public String viewPostAlList() {
        log.debug(">>>>>>>>>>>>>>>>> viewPostalList >>>>>>>>>>>>>>>>");

        return "postal/postalList";
    }
}
