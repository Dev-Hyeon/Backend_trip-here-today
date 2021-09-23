package com.devHyun.TodayTrip01.domain.spot;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Spot {

    @Id
    @GeneratedValue
    @Column(name = "SPOT_ID")
    private Long id;                    // contentid
    private String title;               // 관광지 이름

    private String detail;              // 관광지 상세정보(overview)
    private String image;          // 관광지 이미지

    private String address;             // 주소
    private String homepage;            // 홈페이지

    @Embedded
    private Position position;          // 위치(x,y)

    private Long areacode;              // 지역코드
    private String zipcode;             // zipcode


}
