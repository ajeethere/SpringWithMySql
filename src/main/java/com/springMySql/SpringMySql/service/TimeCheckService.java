package com.springMySql.SpringMySql.service;

import com.springMySql.SpringMySql.entity.UserValidity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeCheckService {
    @Autowired
    UserValidityService userValidityService;

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void updateDataBasedOnTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<UserValidity> data = userValidityService.getUserValidityByValid();
        for (UserValidity userValidity : data) {
            if (userValidity.getIsValid() == 1 && currentTime.isAfter(userValidity.getEndTime())) {
                userValidity.setIsValid(0);
                userValidityService.updateUserValidity(userValidity);
            }
        }
    }
}
