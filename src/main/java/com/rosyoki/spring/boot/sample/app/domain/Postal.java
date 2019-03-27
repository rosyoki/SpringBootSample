package com.rosyoki.spring.boot.sample.app.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = false)
@RequiredArgsConstructor
@EqualsAndHashCode
public class Postal {

    @Getter
    public final NewZip newZip;

    @Getter
    public final OldZip oldZip;

    @Getter
    public final Pref pref;

    @Getter
    public final City city;

    @Getter
    public final Town town;
}
