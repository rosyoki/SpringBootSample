package com.rosyoki.spring.boot.sample.app.datasource

import com.rosyoki.spring.boot.sample.app.domain.City
import com.rosyoki.spring.boot.sample.app.domain.NewZip
import com.rosyoki.spring.boot.sample.app.domain.OldZip
import com.rosyoki.spring.boot.sample.app.domain.Postal
import com.rosyoki.spring.boot.sample.app.domain.Pref
import com.rosyoki.spring.boot.sample.app.domain.Town

class FixturePostData {
    static Postal get() {
        new Postal(
                new NewZip("2420007"),
                new OldZip("242"),
                new Pref("神奈川県"),
                new City("大和市"),
                new Town("中央林間")
        )
    }
}
