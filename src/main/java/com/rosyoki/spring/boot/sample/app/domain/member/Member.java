package com.rosyoki.spring.boot.sample.app.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = false)
@RequiredArgsConstructor
@EqualsAndHashCode
public class Member {

    @Getter
    public final Id id;

    @Getter
    public final LoginName loginName;

    @Getter
    public final Passwd passwd;

}
