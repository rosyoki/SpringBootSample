package com.rosyoki.spring.boot.sample.app.domain;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;

import java.util.List;
import java.util.Optional;

public interface PostAlRepositry {
    public List<Postal> getPostAlDataByCity(City city);
    public Optional<Postal> getPostDataByZip(NewZip newZip);
}
