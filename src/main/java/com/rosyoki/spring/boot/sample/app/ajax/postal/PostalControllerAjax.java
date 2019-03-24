/**
 *
 */
package com.rosyoki.spring.boot.sample.app.ajax.postal;

import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.Postal;
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

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/postal/town/{city}", method = RequestMethod.POST, produces = "application/json")
    public List<Postal> getPostalDataByCity(@PathVariable String city) {
        log.info(">>>>> start getPostalDataByCity >>>>>");

        if (StringUtils.isEmpty(city)) {
            return null;
        }
        //郵便番号一覧情報を取得する。
        List<Postal> postals = postAlService.getPostAlDataByCity(new City(city));

        //データ取得チェック
        if (postals == null) {
            return null;
        }

        if (postals.size() == 0) {
            return null;
        }

        log.info(">>>>> end getPostalDataByCity >>>>>");

        return postals;
    }

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/postal/zip/{zip}", produces = "application/json")
    public Postal getPostalDataByZip(@PathVariable String zip) {
        log.info(">>>>> start getPostalDataByZip >>>>>");

        if (StringUtils.isEmpty(zip)) {
            return null;
        }
        // 郵便番号から住所を取得する。

        Postal postZipData = postAlService.getPostDataByZip(new NewZip(zip));
        //データチェック
        if (postZipData == null) {
            return null;
        }
        log.info(">>>>> end getPostalDataByZip >>>>>");

        return postZipData;
    }
}
