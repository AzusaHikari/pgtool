package com.azusahikari.pgtools.service.impl;

import com.azusahikari.pgtools.service.UmaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UmaServiceImplTest {
    @Autowired
    UmaService umaservice;

    @Test
    void test1() {
        umaservice.getSupportCard();
    }

}
