package com.byazt.rd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 896, 5})
public class q {

    @com.byazt.cp.n(n = {0, 1, 896, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public String n;
        public Map<String, String> qg;
    }

    public static n n(String str) {
        n nVar = new n();
        if (str == null) {
            return nVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return nVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        nVar.n = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return nVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split("&");
        nVar.qg = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split("=");
            if (strArrSplit3.length >= 2) {
                nVar.qg.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return nVar;
    }

    private static String n(String str, LinkedHashMap<String, String> linkedHashMap) {
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

    public static String qg(String str) {
        n nVarN = n(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (nVarN.qg != null) {
            if (nVarN.qg.containsKey("v")) {
                linkedHashMap.put("v", nVarN.qg.get("v"));
                nVarN.qg.remove("v");
            }
            for (Map.Entry<String, String> entry : nVarN.qg.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return n(nVarN.n, linkedHashMap);
    }
}
