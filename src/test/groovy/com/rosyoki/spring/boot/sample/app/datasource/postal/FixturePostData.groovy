package com.rosyoki.spring.boot.sample.app.datasource.postal

import com.rosyoki.spring.boot.sample.app.domain.postal.City
import com.rosyoki.spring.boot.sample.app.domain.postal.NewZip
import com.rosyoki.spring.boot.sample.app.domain.postal.OldZip
import com.rosyoki.spring.boot.sample.app.domain.postal.Postal
import com.rosyoki.spring.boot.sample.app.domain.postal.Pref
import com.rosyoki.spring.boot.sample.app.domain.postal.Town

class FixturePostData {
    static Optional<Postal> get(int n = 0) {
        [
                Optional.of(
                        new Postal(
                                new NewZip("2420007"),
                                new OldZip("242"),
                                new Pref("神奈川県"),
                                new City("大和市"),
                                new Town("中央林間")
                        )
                ),
                Optional.of(
                        new Postal(
                                new NewZip("2420001"),
                                new OldZip("242"),
                                new Pref("神奈川県"),
                                new City("大和市"),
                                new Town("下鶴間")
                        ))
        ].get(n)
    }
}
