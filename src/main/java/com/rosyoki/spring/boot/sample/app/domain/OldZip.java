package com.rosyoki.spring.boot.sample.app.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = false)
@RequiredArgsConstructor
@EqualsAndHashCode
public class OldZip {

    @Getter
    public final String value;
}
