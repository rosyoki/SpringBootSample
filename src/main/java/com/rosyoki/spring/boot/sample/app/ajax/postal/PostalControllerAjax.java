/**
 *
 */
package com.rosyoki.spring.boot.sample.app.ajax.postal;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.service.postal.PostAlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hirofumi_tsutsui
 */
@RestController
@Slf4j
public class PostalControllerAjax {

    @Autowired
    PostAlService postAlService;

    @CrossOrigin
    @RequestMapping(value = "/ajax/postal/{id}", produces = "application/json")
    public PostZipData getPostalData(@PathVariable Long id) {
        log.info(">>>>> start getPostalData >>>>>");

        //郵便番号情報を取得する。
        PostZipData postZipData = postAlService.getPostData(id);

        log.info(">>>>> end getPostalData >>>>>");

        return postZipData;
    }

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/postal/town/{city}", method = RequestMethod.POST, produces = "application/json")
    public List<PostZipData> getPostalDataByCity(@PathVariable String city) {
        log.info(">>>>> start getPostalDataByCity >>>>>");

        if (StringUtils.isEmpty(city)) {
            return null;
        }
        //郵便番号一覧情報を取得する。
        List<PostZipData> postZipDatas = postAlService.getPostAlDataByCity(city);

        //データ取得チェック
        if (postZipDatas == null) {
            return null;
        }

        if (postZipDatas.size() == 0) {
            return null;
        }

        log.info(">>>>> end getPostalDataByCity >>>>>");

        return postZipDatas;
    }

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/postal/zip/{zip}", produces = "application/json")
    public PostZipData getPostalDataByZip(@PathVariable String zip) {
        log.info(">>>>> start getPostalDataByZip >>>>>");

        if (StringUtils.isEmpty(zip)) {
            return null;
        }
        // 郵便番号から住所を取得する。
        PostZipData postZipData = postAlService.getPostDataByZip(zip);
        //データチェック
        if (postZipData == null) {
            return null;
        }
        log.info(">>>>> end getPostalDataByZip >>>>>");

        return postZipData;
    }
}
