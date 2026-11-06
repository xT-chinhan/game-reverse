package com.tapsdk.tapad.lib_csjadapter.utils;

import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.mar.sdk.IAction;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public static long getCSJPrice(TTClientBidding ad) {
        try {
            Method method = ad.getClass().getMethod("getMediaExtraInfo", new Class[0]);
            Object extraInfo = method.invoke(ad, new Object[0]);
            if (!(extraInfo instanceof Map)) {
                return 0L;
            }
            Map<?, ?> map = (Map) extraInfo;
            Object price = map.get(IAction.PurchaseKey.Price);
            if (price instanceof Number) {
                return ((Number) price).longValue();
            }
            if (price instanceof String) {
                return Long.parseLong((String) price);
            }
            return 0L;
        } catch (Exception e) {
        }
    }

    public static String getAppId() {
        Field[] fields = TTAdSdk.class.getDeclaredFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Field field = fields[i];
            try {
                field.setAccessible(true);
                Object value = field.get(null);
                if (value instanceof TTAdConfig) {
                    TTAdConfig config = (TTAdConfig) value;
                    return config.getAppId();
                }
                continue;
            } catch (Exception e) {
            }
        }
        return "";
    }
}
