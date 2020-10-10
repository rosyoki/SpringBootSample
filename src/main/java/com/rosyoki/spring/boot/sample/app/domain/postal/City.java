package com.rosyoki.spring.boot.sample.app.domain.postal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = false)
@RequiredArgsConstructor
@EqualsAndHashCode
public class City {

    @Getter
    public final String value;
}
