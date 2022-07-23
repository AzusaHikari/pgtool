package com.azusahikari.pgtools.repository.uma;

import com.azusahikari.pgtools.entities.uma.TextData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TextDataRepository extends CrudRepository<TextData, String> {
    @Query("SELECT t1.index as id, t1.text as name, t2.text as cv\n" +
            "FROM TextData AS t1\n" +
            "         LEFT JOIN TextData AS t2 on t1.index = t2.index\n" +
            "WHERE t1.category = '170'\n" +
            "  AND t2.category = '7'")
    List<Map<String, Object>> queryChara();

    @Query("SELECT t.index as id,t.text as name  FROM TextData t WHERE t.category='5'")
    List<Map<String, Object>> queryCard();

    @Query("SELECT t.index as id,t.text as name FROM TextData t WHERE t.category='75'")
    List<Map<String, Object>> querySupportCard();
}
