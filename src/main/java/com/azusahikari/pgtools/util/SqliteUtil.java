package com.azusahikari.pgtools.util;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class SqliteUtil {

    private SqliteUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> List<T> sqliteConnection(String path, Class<?> clazz) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = null;
        Statement statement = null;
        List<T> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from ");
        Table table = clazz.getAnnotation(Table.class);
        sql.append(table.name());
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    row.put(resultSetMetaData.getColumnName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
                }
                result.add(mapToBean(row, clazz));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 利用反射将map集合封装成bean对象
     *
     * @param map   需要转换的集合
     * @param clazz 转换的类
     * @return 转换结果
     */
    private static <T> T mapToBean(Map<String, Object> map, Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object obj = clazz.getDeclaredConstructor().newInstance();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();    // 属性名
                Object value = entry.getValue();        // 属性值

                Field field = getClassField(clazz, propertyName);    //获取和map的key匹配的属性名称
                if (field == null) {
                    continue;
                }
                Class<?> fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                String setMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }

    /**
     * 根据给定对象类匹配对象中的特定字段
     *
     * @param clazz
     * @param fieldName
     * @return
     */
    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (clazz.isAssignableFrom(Object.class)) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Column.class)) {
                String columnName = field.getAnnotation(Column.class).name();
                if (columnName.equals(fieldName)) {
                    return field;
                }
            }
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> superClass = clazz.getSuperclass();    //如果该类还有父类，将父类对象中的字段也取出
        if (superClass != null) {                        //递归获取
            return getClassField(superClass, fieldName);
        }
        return null;
    }

    /**
     * 将map的value值转为实体类中字段类型匹配的方法
     *
     * @param value          map中的value
     * @param fieldTypeClass 字段类型
     * @return 返回字段
     */
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;
        if (fieldTypeClass.isAssignableFrom(Long.class) || fieldTypeClass.isAssignableFrom(long.class)) {
            retVal = Long.parseLong(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Integer.class) || fieldTypeClass.isAssignableFrom(int.class)) {
            retVal = Integer.parseInt(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Float.class) || fieldTypeClass.isAssignableFrom(float.class)) {
            retVal = Float.parseFloat(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Double.class) || fieldTypeClass.isAssignableFrom(double.class)) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }

}
