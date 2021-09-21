package com.devHyun.TodayTrip01.domain.trip;

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

    public static List<Spot> spotList = new ArrayList<>();


    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;

//    private String title;                // 코스이름
//    private int distance;               // 거리
//    private int price;                  // 금액


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOT_ID")
    private Spot spot;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRIP_ID")
    private Trip trip;


    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public static void addCourse(Spot spot) {
        spotList.add(spot);
    }
}
