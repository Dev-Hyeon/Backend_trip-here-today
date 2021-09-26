package com.devHyun.TodayTrip01.domain.spot;


import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Position {

    private Long mapx;
    private Long mapy;
}
