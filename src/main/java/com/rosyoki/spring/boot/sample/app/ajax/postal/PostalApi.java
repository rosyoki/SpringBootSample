/**
 *
 */
package com.rosyoki.spring.boot.sample.app.ajax.postal;

import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.Postal;
import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import com.rosyoki.spring.boot.sample.app.service.postal.PostAlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * @author hirofumi_tsutsui
 */
@RestController
@Slf4j
public class PostalApi {

    @Autowired
    PostAlService postAlService;

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/api/postal/town/{city}", method = RequestMethod.POST, produces = "application/json")
    public List<Postal> getPostalDataByCity(@PathVariable @Valid @NotNull String city) {
        log.info(">>>>> start getPostalDataByCity >>>>>");

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
    @RequestMapping(value = "/api/postal/zip/{zip}", produces = "application/json")
    public ResponseEntity<Postal> getPostalDataByZip(@PathVariable @NotNull String zip) {
        log.info(">>>>> start getPostalDataByZip >>>>>");

        // 郵便番号から住所を取得する。
        Optional<Postal> postZipData = postAlService.getPostDataByZip(new NewZip(zip));
        log.info(">>>>> end getPostalDataByZip >>>>>");

        return new ResponseEntity<Postal>(postZipData.orElseThrow(
                () -> new NotFoundException(zip + ":住所が見つかりませんでした。")
        ),HttpStatus.OK);
    }
}
