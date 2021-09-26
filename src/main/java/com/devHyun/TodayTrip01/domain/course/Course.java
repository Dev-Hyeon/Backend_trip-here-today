package com.devHyun.TodayTrip01.domain.course;

import com.devHyun.TodayTrip01.domain.member.Member;
import com.devHyun.TodayTrip01.domain.spot.Spot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseSpot> courseSpotList = new ArrayList<>();


    private String title;

    private String distance;

    private int price;






}
