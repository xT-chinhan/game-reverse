package com.byazt.zp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 61})
public class aj {

    @com.byazt.vzx.pr(pr = {0, 1, 1229, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr {
        public Map<String, String> hw;
        public String pr;
    }

    public static pr pr(String str) {
        pr prVar = new pr();
        if (str == null) {
            return prVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return prVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        prVar.pr = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return prVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split("&");
        prVar.hw = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split("=");
            if (strArrSplit3.length >= 2) {
                prVar.hw.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return prVar;
    }

    private static String pr(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = false;
        if (str.contains("?") || str.contains("&")) {
            z = true;
        }
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

    public static String hw(String str) {
        pr prVarPr = pr(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (prVarPr.hw != null) {
            if (prVarPr.hw.containsKey(an.aE)) {
                linkedHashMap.put(an.aE, prVarPr.hw.get(an.aE));
                prVarPr.hw.remove(an.aE);
            }
            for (Map.Entry<String, String> entry : prVarPr.hw.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return pr(prVarPr.pr, linkedHashMap);
    }
}
