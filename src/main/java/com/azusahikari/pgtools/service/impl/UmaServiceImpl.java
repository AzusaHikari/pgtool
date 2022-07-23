package com.azusahikari.pgtools.service.impl;

import com.azusahikari.pgtools.entities.uma.*;
import com.azusahikari.pgtools.repository.uma.*;
import com.azusahikari.pgtools.service.UmaService;
import com.azusahikari.pgtools.util.SqliteUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UmaServiceImpl implements UmaService {

    @Autowired
    CharaDateRepository charaDateRepository;
    @Autowired
    RaceRepository raceRepository;
    @Autowired
    RaceCourseSetRepository raceCourseSetRepository;
    @Autowired
    RaceInstanceRepository raceInstanceRepository;
    @Autowired
    SingleModeCharaProgramRepository singleModeCharaProgramRepository;
    @Autowired
    SingleModeProgramRepository singleModeProgramRepository;
    @Autowired
    SingleModeWinsSaddleRepository singleModeWinsSaddleRepository;
    @Autowired
    SkillDataRepository skillDataRepository;
    @Autowired
    SuccessionRelationRepository successionRelationRepository;
    @Autowired
    SuccessionRelationMemberRepository successionRelationMemberRepository;
    @Autowired
    SupportCardDataRepository supportCardDataRepository;
    @Autowired
    SupportCardEffectTableRepository supportCardEffectTableRepository;
    @Autowired
    SupportCardUniqueEffectRepository supportCardUniqueEffectRepository;
    @Autowired
    TextDataRepository textDataRepository;


    @Override
    public List<Map<String, Object>> getSupportCard() {
        return textDataRepository.querySupportCard();
    }

    @Override
    public Map<String, Object> uploadMaster(String path) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("CharaDate", getIterableCount(charaDateRepository.saveAll(SqliteUtil.sqliteConnection(path, CharaDate.class))));
            result.put("Race", getIterableCount(raceRepository.saveAll(SqliteUtil.sqliteConnection(path, Race.class))));
            result.put("RaceCourseSet", getIterableCount(raceCourseSetRepository.saveAll(SqliteUtil.sqliteConnection(path, RaceCourseSet.class))));
            result.put("RaceInstance", getIterableCount(raceInstanceRepository.saveAll(SqliteUtil.sqliteConnection(path, RaceInstance.class))));
            result.put("SingleModeCharaProgram", getIterableCount(singleModeCharaProgramRepository.saveAll(SqliteUtil.sqliteConnection(path, SingleModeCharaProgram.class))));
            result.put("SingleModeProgram", getIterableCount(singleModeProgramRepository.saveAll(SqliteUtil.sqliteConnection(path, SingleModeProgram.class))));
            result.put("SingleModeWinsSaddle", getIterableCount(singleModeWinsSaddleRepository.saveAll(SqliteUtil.sqliteConnection(path, SingleModeWinsSaddle.class))));
            result.put("SkillData", getIterableCount(skillDataRepository.saveAll(SqliteUtil.sqliteConnection(path, SkillData.class))));
            result.put("SuccessionRelation", getIterableCount(successionRelationRepository.saveAll(SqliteUtil.sqliteConnection(path, SuccessionRelation.class))));
            result.put("SuccessionRelationMember", getIterableCount(successionRelationMemberRepository.saveAll(SqliteUtil.sqliteConnection(path, SuccessionRelationMember.class))));
            result.put("SupportCardData", getIterableCount(supportCardDataRepository.saveAll(SqliteUtil.sqliteConnection(path, SupportCardData.class))));
            result.put("SupportCardEffectTable", getIterableCount(supportCardEffectTableRepository.saveAll(SqliteUtil.sqliteConnection(path, SupportCardEffectTable.class))));
            result.put("SupportCardUniqueEffect", getIterableCount(supportCardUniqueEffectRepository.saveAll(SqliteUtil.sqliteConnection(path, SupportCardUniqueEffect.class))));
            result.put("TextData", getIterableCount(textDataRepository.saveAll(SqliteUtil.sqliteConnection(path, TextData.class))));
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> queryChara() {
        return textDataRepository.queryChara();
    }

    private <T> Integer getIterableCount(Iterable<T> iterable) {
        if (iterable instanceof List<?>) {
            return ((List<T>) iterable).size();
        }
        return 0;
    }
}
