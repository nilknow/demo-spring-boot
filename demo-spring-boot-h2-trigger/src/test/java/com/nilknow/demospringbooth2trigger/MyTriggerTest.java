package com.nilknow.demospringbooth2trigger;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class MyTriggerTest {
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Test
    void testTriggerWhenInsert(){
        loginUserRepository.save(new LoginUser(2L,"nilknow2", DateUtils.truncate(new Date(), Calendar.DATE)));
    }
}
