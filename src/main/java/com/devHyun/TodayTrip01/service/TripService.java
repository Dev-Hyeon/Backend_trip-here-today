package com.devHyun.TodayTrip01.service;

import com.devHyun.TodayTrip01.domain.member.Member;
import com.devHyun.TodayTrip01.domain.member.MemberRepository;
import com.devHyun.TodayTrip01.domain.spot.Spot;
import com.devHyun.TodayTrip01.domain.spot.SpotRepository;
import com.devHyun.TodayTrip01.domain.trip.Course;
import com.devHyun.TodayTrip01.domain.trip.Trip;
import com.devHyun.TodayTrip01.domain.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TripService {



    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TripRepository tripRepository;


    // 여행 생성
    public Long createTrip(Long memberId, List<Spot> spotList) {

        // 회원 생성
        Member member = memberRepository.findById(memberId).get();


        // 여행 생성
        Trip trip = Trip.createTrip(member, spotList);
        tripRepository.save(trip);

        return null;
    }


}
