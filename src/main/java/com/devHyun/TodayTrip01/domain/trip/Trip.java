package com.devHyun.TodayTrip01.domain.trip;

import com.devHyun.TodayTrip01.domain.member.Member;
import com.devHyun.TodayTrip01.domain.spot.Spot;
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


    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Course course;

                                                    // list, 엔티티
    // 여행 생성                                    // 관광코스(경복궁-남산타워-63빌딩)
    public static Trip createTrip(Member member, List<Spot> spotList, String tripTitle) {       // 엔티티, 리스트

        Trip trip = new Trip();
        trip.setMember(member);
        trip.setTripTitle(tripTitle);
        for (Spot spot : spotList) {
            trip.addCourse();
        }


        return null;
    }


    // 연관관계 메소드

    // Member
    public void setMember(Member member) {
        this.member = member;
        member.getTrips().add(this);
    }

    // Course
    public void addCourse(Course course) {
        courses.add(course);
        course.setTrip(this);
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }
}
