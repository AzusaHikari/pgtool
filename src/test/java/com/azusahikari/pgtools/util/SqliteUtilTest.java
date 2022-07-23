package com.azusahikari.pgtools.util;

import com.azusahikari.pgtools.entities.uma.CharaDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Slf4j
@DisplayName("我的第一个测试用例")
public class SqliteUtilTest {

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("数据库连接测试")
    @Test
    void testSqliteConnection() {
        String dbPath = "master.mdb";
        List<CharaDate> charaDateList = null;
        try {
            charaDateList = SqliteUtil.sqliteConnection(dbPath, CharaDate.class);
            for (CharaDate charaDate : charaDateList) {
                log.info("{}", charaDate);
            }
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(charaDateList);
    }
}