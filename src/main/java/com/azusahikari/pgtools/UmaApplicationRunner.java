package com.azusahikari.pgtools;

import com.azusahikari.pgtools.service.UmaService;
import com.azusahikari.pgtools.repository.uma.SupportCardDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class UmaApplicationRunner implements ApplicationRunner {
    final
    SupportCardDataRepository scdRepository;

    final
    UmaService umaService;

    public UmaApplicationRunner(SupportCardDataRepository scdRepository, UmaService umaService) {
        this.scdRepository = scdRepository;
        this.umaService = umaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("=============容器启动完成，准备加载master.mdb=============");
        String masterPath = "src/main/resources/static/master.mdb";
        log.info("master.mdb的地址:{}", masterPath);
        Map<String, Object> result = umaService.uploadMaster(masterPath);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            log.info("{}: {}", key, value);
        }
        log.info("=============master.mdb加载完成=============");
    }
}