package com.hzways.basic;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SpiltUtil {

    public static List<String> spiltEmployees(String string) {
//        String regex = "&|;|=";
        return Arrays.stream(string.split(";")).map(String::trim).collect(Collectors.toList());
    }


    public static Map<String, String> buildEmployee(String str) {

        // name=111   age=ddd
        List<String> keyValues = Arrays.stream(str.split("&")).map(String::trim).collect(Collectors.toList());
        Map<String, String> kvMap = new HashMap<>();
        keyValues.stream().map(kv -> kv.split("=")).forEach(keyVs -> kvMap.put(keyVs[0], keyVs[1]));
        return kvMap;
    }

    public static Employee kvMapToObject(Map<String, String> kvs) {
        Employee employee = new Employee();
        Field[] fields = Employee.class.getDeclaredFields();

        kvs.forEach((key, value) -> {
            for (Field field : fields) {
                if (key.equals(field.getName())) {
                    field.setAccessible(true);
                    try {

                        field.set(employee, judgeClassType(field, value));
                    } catch (IllegalAccessException | ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        return employee;
    }

    private static Object judgeClassType(Field field, String value) throws ParseException {
        // 如果类型是Integer
        if ("class java.lang.Integer".equals(field.getGenericType().toString()) || "int".equals(field.getGenericType().toString())) {
            return Integer.parseInt(value);
        }

        // 如果类型是Double
        if ("class java.lang.Double".equals(field.getGenericType().toString())) {

            return Double.parseDouble(value);
        }

        if ("class java.math.BigDecimal".equals(field.getGenericType().toString())) {

            return new BigDecimal(value);
        }


        // 如果类型是Date
        if ("class java.util.Date".equals(field.getGenericType().toString())) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(value);
        }

        return value;
    }
}
