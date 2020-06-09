package com.rosyoki.spring.boot.sample.app.datasource;

import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.OldZip;
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry;
import com.rosyoki.spring.boot.sample.app.domain.Postal;
import com.rosyoki.spring.boot.sample.app.domain.Pref;
import com.rosyoki.spring.boot.sample.app.domain.Town;
import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.mapper.PostZipDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostAlRepositryImpl implements PostAlRepositry {

    @Autowired
    private PostZipDataMapper postZipDataMapper;

    public List<Postal> getPostAlDataByCity(City city) {

        return postZipDataMapper.selectByCity(city.getValue())
                .stream().map(
                        record -> new Postal(
                                new NewZip(record.getZip()),
                                 new OldZip(record.getOldZip()),
                                new Pref(record.getPref()),
                                new City(record.getCity()),
                                new Town(record.getTown())
                        )
        ).collect(Collectors.toList());
    }

    public Optional<Postal> getPostDataByZip(NewZip newZip) {

        PostZipData postZipData = postZipDataMapper.selectByNewCode(newZip.getValue());
        if(postZipData != null) {
            return Optional.of(
                    new Postal(
                            new NewZip(postZipData.getZip()),
                            new OldZip(postZipData.getOldZip()),
                            new Pref(postZipData.getPref()),
                            new City(postZipData.getCity()),
                            new Town(postZipData.getTown())
                    )
            );
        } else {
            return Optional.empty();
        }
    }

    public Optional<Postal> getPostDataByCityTown(City city, Town town) {
        return null;
    }
}
