/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.service.postal;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;

import com.rosyoki.spring.boot.sample.app.datasource.PostAlRepositryDb;
import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry;
import com.rosyoki.spring.boot.sample.app.domain.Postal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
@Transactional
public class PostAlService {

    @Autowired
    PostAlRepositry postAlRepositry;

    /**
     * 市名で検索する。
     * 
     * @param city
     * @return
     */
    public Optional<List<Postal>> getPostAlDataByCity(City city) {
       return Optional.ofNullable(
               postAlRepositry.getPostAlDataByCity(city)
       );
    }

    /**
     * 郵便番号で検索する
     *
     * @param newZip
     * @return
     */
    public Optional<Postal> getPostDataByZip(NewZip newZip) {
        return postAlRepositry.getPostDataByZip(newZip);
    }
}
