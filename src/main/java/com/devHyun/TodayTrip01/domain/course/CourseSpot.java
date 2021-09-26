package com.devHyun.TodayTrip01.domain.course;

import com.devHyun.TodayTrip01.domain.spot.Spot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class CourseSpot {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_SPOT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOT_ID")
    private Spot spot;

}
