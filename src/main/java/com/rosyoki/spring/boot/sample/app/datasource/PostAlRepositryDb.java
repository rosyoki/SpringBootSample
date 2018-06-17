package com.rosyoki.spring.boot.sample.app.datasource;

import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.entity.PostZipDataExample;
import com.rosyoki.spring.boot.sample.app.mapper.PostZipDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostAlRepositryDb {

    @Autowired
    PostZipDataMapper postZipDataMapper;

    public List<PostZipData> getPostAlDataByCity(City city) {
        PostZipDataExample postZipDataExample = new PostZipDataExample();
        postZipDataExample.createCriteria().andCityEqualTo(city.getValue());

        return postZipDataMapper.selectByExampleWithBLOBs(postZipDataExample);
    }

    public PostZipData getPostDataByZip(NewZip newZip) {
        PostZipDataExample postZipDataExample = new PostZipDataExample();
        postZipDataExample.createCriteria().andZipEqualTo(newZip.getValue());
        return postZipDataMapper.selectByExampleWithBLOBs(postZipDataExample).get(0);
    }
}
