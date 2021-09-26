package com.devHyun.TodayTrip01.service;

import com.devHyun.TodayTrip01.domain.member.Member;
import com.devHyun.TodayTrip01.domain.spot.Spot;
import com.devHyun.TodayTrip01.domain.course.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Transactional
@SpringBootTest
class TripServiceTest {


    @PersistenceContext
    EntityManager em;


//    @DisplayName("여행 생성 테스트")
//    @Test
//    public void createTrip() throws Exception{
//        //given
//
//        // 회원 생성
//        Member member = createMember();
//
//        // 관광지 생성
//        Spot spot = createSpot();
//        Spot spot2 = createSpot2();
//        Spot spot3 = createSpot3();
//
//        // 코스 생성
//
//        Course.addCourse(spot);
//        Course.addCourse(spot2);
//        Course.addCourse(spot3);
//
//        // 여행 생성
//
//        //when
//        Trip.createTrip(member, Course.spotList);
//
//        //then
//    }
//
//
//    private Spot createSpot() {
//
//        Spot spot = new Spot();
//        spot.setTitle("경복궁");
//        spot.setAreacode(22L);
//        em.persist(spot);
//
//        return spot;
//    }
//
//    private Spot createSpot2() {
//
//        Spot spot = new Spot();
//        spot.setTitle("남산타워");
//        spot.setAreacode(20L);
//        em.persist(spot);
//
//        return spot;
//    }
//
//    private Spot createSpot3() {
//
//        Spot spot = new Spot();
//        spot.setTitle("덕수궁");
//        spot.setAreacode(21L);
//        em.persist(spot);
//
//        return spot;
//    }
//
//    private Member createMember() {
//        Member member = new Member();
//        member.setName("dmlgus");
//
//        em.persist(member);
//
//        return member;
//    }
//
}