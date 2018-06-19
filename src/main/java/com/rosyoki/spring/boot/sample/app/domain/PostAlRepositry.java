package com.rosyoki.spring.boot.sample.app.domain;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

import java.util.List;

public interface PostAlRepositry {
    public List<PostZipData> getPostAlDataByCity(City city);
    public PostZipData getPostDataByZip(NewZip newZip);
}
