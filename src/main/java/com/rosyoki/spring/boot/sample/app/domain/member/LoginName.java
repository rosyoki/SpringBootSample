package com.rosyoki.spring.boot.sample.app.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = false)
@RequiredArgsConstructor
@EqualsAndHashCode
public class LoginName {

    @Getter
    public final String value;
}
