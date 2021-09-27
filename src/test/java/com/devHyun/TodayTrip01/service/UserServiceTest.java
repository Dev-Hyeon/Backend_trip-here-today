package com.devHyun.TodayTrip01.service;

import com.devHyun.TodayTrip01.domain.user.User;
import com.devHyun.TodayTrip01.domain.user.UserRepository;
import com.devHyun.TodayTrip01.web.dto.member.JoinDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    
    @DisplayName("username 중복확인")
    @Test
    public void duplicateUsername() throws Exception{
        //given
        JoinDto joinDto1 = createJoinDto();
        JoinDto joinDto2 = createJoinDto();

        userRepository.save(joinDto1.toEntity());

        //when
        
        //then
        assertThatThrownBy(() -> userService.join(joinDto2))
                .isInstanceOf(Exception.class)
                .hasMessage("현재 사용중인 USERNAME 입니다.");

    }

    private JoinDto createJoinDto() {

        JoinDto joinDto = new JoinDto();
        joinDto.setName("이의현");
        joinDto.setPassword("1234");
        joinDto.setEmail("sdfds@naver.com");
        joinDto.setUsername("의현");

        return joinDto;
    }

}