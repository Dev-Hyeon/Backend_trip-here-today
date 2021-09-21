package com.devHyun.TodayTrip01.domain.trip;

import com.devHyun.TodayTrip01.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Trip {

    @Id
    @GeneratedValue
    @Column(name = "TRIP_ID")
    private Long id;
    private String tripTitle;                       // 여행이름


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();



}
