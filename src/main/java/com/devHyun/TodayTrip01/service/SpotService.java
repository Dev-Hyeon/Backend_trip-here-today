package com.devHyun.TodayTrip01.service;


import com.devHyun.TodayTrip01.domain.spot.Spot;
import com.devHyun.TodayTrip01.domain.spot.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
@Service
public class SpotService {


    private final SpotRepository spotRepository;

    // 관광지 등록
    public void save(Spot spot) {
        spotRepository.save(spot);
    }



}
