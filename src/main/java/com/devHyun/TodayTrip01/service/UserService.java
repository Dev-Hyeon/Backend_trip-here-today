package com.devHyun.TodayTrip01.service;


import com.devHyun.TodayTrip01.domain.user.User;
import com.devHyun.TodayTrip01.domain.user.UserRepository;
import com.devHyun.TodayTrip01.web.dto.member.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    /**
     * 회원가입
     * 1. 중복확인(username)
     * 2. 비밀번호 암호화
     *
     *
     * @param joinDto
     */
    @Transactional
    public void join(JoinDto joinDto) throws Exception {

        User user = joinDto.toEntity();

        
        // 1. 중복확인
        if(!duplicateUsername(user)){

        }
        throw new Exception("현재 사용중인 USERNAME 입니다.");

    }

    // 중복확인
    private Boolean duplicateUsername(User user) {

        return userRepository.existsByUsername(user.getUsername());

    }

}
