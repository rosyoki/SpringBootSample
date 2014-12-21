/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.controller.postal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class PostAlController {

    @RequestMapping(value="/postal/postalList")
    public String viewPostAlList() {
        return "postal/postAlList";
    }
}
