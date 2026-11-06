package com.bytedance.sdk.openadsdk.op;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f4080ms;
        public Map<String, String> xr;
    }

    public static ms ms(String str) {
        ms msVar = new ms();
        if (str == null) {
            return msVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return msVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        msVar.f4080ms = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return msVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split("&");
        msVar.xr = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split("=");
            if (strArrSplit3.length >= 2) {
                msVar.xr.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return msVar;
    }

    private static String ms(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = str.contains("?") || str.contains("&");
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z) {
                    sb.append("?");
                    z = true;
                } else {
                    sb.append("&");
                }
                sb.append(str2).append("=").append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }

    public static String xr(String str) {
        ms msVarMs = ms(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (msVarMs.xr != null) {
            if (msVarMs.xr.containsKey("v")) {
                linkedHashMap.put("v", msVarMs.xr.get("v"));
                msVarMs.xr.remove("v");
            }
            for (Map.Entry<String, String> entry : msVarMs.xr.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return ms(msVarMs.f4080ms, linkedHashMap);
    }
}
