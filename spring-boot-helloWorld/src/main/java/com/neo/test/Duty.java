package com.neo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 答疑排班处理
 *
 * @author: Chen Gong
 * @date：2021/4/8 9:34 上午
 */
public class Duty {

    private static final Integer ON_DUTY = 1;
    private static final Integer NOT_DUTY = 0;

    public static void main(String[] args) {
        Map<String, Integer> dutyMap = getDutyMap();

        JSONArray dutyArray = new JSONArray();

        dutyMap.forEach((k, v) -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(k, v);
            dutyArray.add(jsonObject);

        });
        System.out.println(dutyArray);
        System.out.println(getOnDutyDays(dutyMap, "20210101", "20211231", ON_DUTY));
    }


    private static Map<String, Integer> getDutyMap() {
        Map<String, Integer> dutyMap = new LinkedHashMap<>(32);
        normal(dutyMap);
        holiday(dutyMap);
        return dutyMap;
    }

    /**
     * 获取值班/非值班天数
     *
     * @param dutyMap
     * @param startDay
     * @param endDay
     * @param duty
     * @return
     */
    private static Integer getOnDutyDays(Map<String, Integer> dutyMap, String startDay, String endDay, Integer duty) {
        int dutyDays = 0;
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : dutyMap.entrySet()) {
            if (entry.getKey().equals(startDay)) {
                flag = true;
            }
            if (flag && duty.equals(entry.getValue())) {
                dutyDays++;
            }
            if (entry.getKey().equals(endDay)) {
                flag = false;
            }

        }
        return dutyDays;

    }

    /**
     * 平时时间
     *
     * @param dutyMap
     */
    private static void normal(Map<String, Integer> dutyMap) {
        //请注意月份是从0-11,天数是1， 2021-1-1 至 2021-12-31
        Calendar start = Calendar.getInstance();
        //2021-1-1 开始
        start.set(2021, 0, 1);
        Calendar end = Calendar.getInstance();
        // 2022--0-0结束，2022-1-1不算
        end.set(2022, 0, 0);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        while (start.compareTo(end) <= 0) {
            int w = start.get(Calendar.DAY_OF_WEEK);
            if (w == Calendar.SUNDAY) {
                dutyMap.put(format.format(start.getTime()), NOT_DUTY);
            } else {
                dutyMap.put(format.format(start.getTime()), ON_DUTY);
            }

            //循环，每次天数加1
            start.set(Calendar.DATE, start.get(Calendar.DATE) + 1);
        }
    }

    /**
     * 节假日调休时间
     *
     * @param dutyMap
     */
    private static void holiday(Map<String, Integer> dutyMap) {
        // 放假
        for (int start = 20210101, i = 0; i < 3; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }
        for (int start = 20210211, i = 0; i < 7; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        for (int start = 20210403, i = 0; i < 3; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        for (int start = 20210501, i = 0; i < 5; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        for (int start = 20210612, i = 0; i < 3; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        for (int start = 20210919, i = 0; i < 3; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        for (int start = 20211001, i = 0; i < 7; i++) {
            dutyMap.put(String.valueOf(start + i), NOT_DUTY);
        }

        // 上班
        dutyMap.put("20210207", ON_DUTY);
        dutyMap.put("20210220", ON_DUTY);
        dutyMap.put("20210425", ON_DUTY);
        dutyMap.put("20210508", ON_DUTY);
        dutyMap.put("20210918", ON_DUTY);
        dutyMap.put("20210926", ON_DUTY);
        dutyMap.put("20211009", ON_DUTY);


    }
}
