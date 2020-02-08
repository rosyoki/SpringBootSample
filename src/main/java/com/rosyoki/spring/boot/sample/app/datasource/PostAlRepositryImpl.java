package com.rosyoki.spring.boot.sample.app.datasource;

import com.rosyoki.spring.boot.sample.app.domain.City;
import com.rosyoki.spring.boot.sample.app.domain.NewZip;
import com.rosyoki.spring.boot.sample.app.domain.OldZip;
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry;
import com.rosyoki.spring.boot.sample.app.domain.Postal;
import com.rosyoki.spring.boot.sample.app.domain.Pref;
import com.rosyoki.spring.boot.sample.app.domain.Town;
import org.h2.util.New;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rosyoki.spring.boot.sample.app.jooq.public_.tables.PostZipData.POST_ZIP_DATA;

@Repository
public class PostAlRepositryImpl implements PostAlRepositry {

    @Autowired
    private DSLContext dslContext;

    public List<Postal> getPostAlDataByCity(City city) {
        return dslContext.select(
                POST_ZIP_DATA.ZIP,
                POST_ZIP_DATA.OLD_ZIP,
                POST_ZIP_DATA.PREF,
                POST_ZIP_DATA.CITY,
                POST_ZIP_DATA.TOWN
        ).from(POST_ZIP_DATA)
                .where(POST_ZIP_DATA.CITY
                        .eq(city.getValue()))
                .orderBy(POST_ZIP_DATA.ZIP)
                .fetch()
                .stream()
                .map(
                        record -> new Postal(
                                new NewZip(record.getValue(POST_ZIP_DATA.ZIP)),
                                new OldZip(record.getValue(POST_ZIP_DATA.OLD_ZIP)),
                                new Pref(record.getValue(POST_ZIP_DATA.PREF)),
                                new City(record.getValue(POST_ZIP_DATA.CITY)),
                                new Town(record.getValue(POST_ZIP_DATA.TOWN))
                        )
                ).collect(Collectors.toList());
    }

    public Optional<Postal> getPostDataByZip(NewZip newZip) {
       return dslContext.select(
               POST_ZIP_DATA.ZIP,
               POST_ZIP_DATA.OLD_ZIP,
               POST_ZIP_DATA.PREF,
               POST_ZIP_DATA.CITY,
               POST_ZIP_DATA.TOWN
       ).from(POST_ZIP_DATA)
               .where(POST_ZIP_DATA.ZIP.eq(newZip.getValue()))
               .fetchOptional(
                       record -> new Postal(
                               new NewZip(record.getValue(POST_ZIP_DATA.ZIP)),
                               new OldZip(record.getValue(POST_ZIP_DATA.OLD_ZIP)),
                               new Pref(record.getValue(POST_ZIP_DATA.PREF)),
                               new City(record.getValue(POST_ZIP_DATA.CITY)),
                               new Town(record.getValue(POST_ZIP_DATA.TOWN))
                       )
               )
       ;
    }

    public Optional<Postal> getPostDataByCityTown(City city, Town town) {
        return dslContext.select(
                POST_ZIP_DATA.ZIP,
                POST_ZIP_DATA.OLD_ZIP,
                POST_ZIP_DATA.PREF,
                POST_ZIP_DATA.CITY,
                POST_ZIP_DATA.TOWN
        ).from(POST_ZIP_DATA)
                .where(POST_ZIP_DATA.CITY
                        .eq(city.getValue())
                        .and(POST_ZIP_DATA.TOWN.eq(town.getValue())
                ))
                .fetchOptional(
                        record -> new Postal(
                                new NewZip(record.getValue(POST_ZIP_DATA.ZIP)),
                                new OldZip(record.getValue(POST_ZIP_DATA.OLD_ZIP)),
                                new Pref(record.getValue(POST_ZIP_DATA.PREF)),
                                new City(record.getValue(POST_ZIP_DATA.CITY)),
                                new Town(record.getValue(POST_ZIP_DATA.TOWN))
                        )
                );

    }
}
