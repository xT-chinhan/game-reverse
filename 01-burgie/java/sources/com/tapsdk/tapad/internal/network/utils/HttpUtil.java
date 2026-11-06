package com.tapsdk.tapad.internal.network.utils;

import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUtil {
    public static Map<String, String> convertDynamicHeaderListToHeaderMap(List<DynamicHeader> list) {
        String string;
        HashMap map = new HashMap();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                DynamicHeader dynamicHeader = list.get(i);
                int i2 = dynamicHeader.mode;
                String str = "";
                if (i2 == 0) {
                    str = dynamicHeader.name;
                    string = getStringBuilder(dynamicHeader).toString();
                } else if (i2 == 1) {
                    int iNextInt = Integer.MAX_VALUE;
                    List<String> list2 = dynamicHeader.valueList;
                    if (list2 != null && !list2.isEmpty()) {
                        iNextInt = new Random().nextInt(dynamicHeader.valueList.size());
                    }
                    String str2 = dynamicHeader.name;
                    List<String> list3 = dynamicHeader.valueList;
                    if (list3 != null && list3.size() > iNextInt && dynamicHeader.valueList.get(iNextInt) != null && !dynamicHeader.valueList.get(iNextInt).isEmpty()) {
                        str = dynamicHeader.valueList.get(iNextInt);
                    }
                    string = str;
                    str = str2;
                } else {
                    string = "";
                }
                if (str != null && !str.isEmpty() && string != null && !string.isEmpty()) {
                    map.put(str, string);
                }
            }
        }
        return map;
    }

    public static String ensureHttps(String str) {
        return (str == null || str.isEmpty() || !str.startsWith("http://")) ? str : "https://" + str.substring(7);
    }

    private static StringBuilder getStringBuilder(DynamicHeader dynamicHeader) {
        StringBuilder sb = new StringBuilder();
        List<String> list = dynamicHeader.valueList;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (str != null && !str.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    sb.append(str);
                }
            }
        }
        return sb;
    }
}
