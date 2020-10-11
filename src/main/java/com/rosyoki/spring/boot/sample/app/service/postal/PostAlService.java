/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.service.postal;

import com.rosyoki.spring.boot.sample.app.domain.postal.City;
import com.rosyoki.spring.boot.sample.app.domain.postal.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.postal.PostAlRepositry;
import com.rosyoki.spring.boot.sample.app.domain.postal.Postal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
public class PostAlService {

    @Autowired
    PostAlRepositry postAlRepositry;

    /**
     * 市名で検索する。
     * 
     * @param city
     * @return
     */
    public List<Postal> getPostAlDataByCity(City city) {
       return postAlRepositry.getPostAlDataByCity(city);
    }

    /**
     * 郵便番号で検索する
     *
     * @param newZip
     * @return
     */
    public Postal getPostDataByZip(NewZip newZip) {
        return postAlRepositry.getPostDataByZip(newZip);
    }
}
