package com.tapsdk.tapad.lib_gdtadapter.utils;

import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    private static final String GDT_BIDDER_NAME = "GDT";

    public static Map<String, Object> getWinMap(long secondPrice, long winPrice) {
        Map<String, Object> map = new HashMap<>();
        map.put(IBidding.EXPECT_COST_PRICE, Long.valueOf(winPrice));
        map.put(IBidding.HIGHEST_LOSS_PRICE, Long.valueOf(secondPrice));
        return map;
    }

    public static Map<String, Object> getLossMap(long winPrice, String lossReason, String winBidder) {
        Map<String, Object> map = new HashMap<>();
        map.put(IBidding.WIN_PRICE, Long.valueOf(winPrice));
        map.put(IBidding.LOSS_REASON, 1);
        map.put(IBidding.ADN_ID, Integer.valueOf(Objects.equals(winBidder, GDT_BIDDER_NAME) ? 1 : 2));
        return map;
    }

    public static String getOldAppId() {
        Object object = GDTAdSdk.getGDTAdManger();
        if (object == null) {
            return "";
        }
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(object);
                if ((value instanceof String) && ((String) value).length() == 10) {
                    return (String) value;
                }
            } catch (Exception e) {
            }
        }
        return "";
    }
}
