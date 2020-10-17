package com.rosyoki.spring.boot.sample.app.datasource.postal

import com.rosyoki.spring.boot.sample.app.domain.postal.*

class FixturePostData {
    static Postal get(int n = 0) {
        [
                new Postal(
                        new NewZip("2420007"),
                        new OldZip("242"),
                        new Pref("神奈川県"),
                        new City("大和市"),
                        new Town("中央林間")
                ),
                new Postal(
                        new NewZip("2420001"),
                        new OldZip("242"),
                        new Pref("神奈川県"),
                        new City("大和市"),
                        new Town("下鶴間")
                )
        ].get(n)
    }
}
