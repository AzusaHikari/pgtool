package com.azusahikari.pgtools.service;

import java.util.List;
import java.util.Map;

public interface UmaService {
    List<Map<String, Object>> getSupportCard();

    Map<String, Object> uploadMaster(String path);

    List<Map<String, Object>> queryChara();
}
