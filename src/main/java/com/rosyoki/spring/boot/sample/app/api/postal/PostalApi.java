/**
 *
 */
package com.rosyoki.spring.boot.sample.app.api.postal;

import com.rosyoki.spring.boot.sample.app.domain.postal.City;
import com.rosyoki.spring.boot.sample.app.domain.postal.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.postal.Postal;
import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import com.rosyoki.spring.boot.sample.app.service.postal.PostAlService;
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

/**
 * @author hirofumi_tsutsui
 */
@RestController
public class PostalApi {

    @Autowired
    PostAlService postAlService;

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/api/postal/town/{city}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<Postal>> getPostalDataByCity(@PathVariable @Valid @NotNull String city) {
        return new ResponseEntity<List<Postal>>(
                postAlService.getPostAlDataByCity(new City(city))
                        .orElseThrow(
                                () -> new RuntimeException("List Error")
                        ),HttpStatus.OK
        );
    }

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/api/postal/zip/{zip}", produces = "application/json")
    public ResponseEntity<Postal> getPostalDataByZip(@PathVariable @NotNull String zip) {
        return new ResponseEntity<Postal>(
                postAlService.getPostDataByZip(new NewZip(zip))
                        .orElseThrow(
                                () -> new NotFoundException(zip + ":住所が見つかりませんでした。")
                        ),HttpStatus.OK);
    }
}
