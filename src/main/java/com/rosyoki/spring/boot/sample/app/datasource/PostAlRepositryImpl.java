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

@Repository
public class PostAlRepositryImpl implements PostAlRepositry {

    @Autowired
    private PostZipDataMapper postZipDataMapper;

    public List<Postal> getPostAlDataByCity(City city) {
        return null;
    }

    public Optional<Postal> getPostDataByZip(NewZip newZip) {

        PostZipData postZipData = postZipDataMapper.selectByPrimaryKey(42453L);
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
