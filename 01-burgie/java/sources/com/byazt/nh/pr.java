package com.byazt.nh;

import android.text.TextUtils;
import com.byazt.at.hn;
import com.byazt.at.hw;
import com.byazt.dd.c;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 958, 37})
public class pr implements hn, com.byazt.at.pr {
    public final Map<String, String> pr = new HashMap();

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "animateState".equals(str);
    }

    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, c cVar) {
        String strPr = pr(map);
        this.pr.put(hw.pr(str, i), strPr);
        String strHw = hw(map2);
        if (TextUtils.isEmpty(strHw)) {
            return false;
        }
        switch (strHw) {
            case "start":
                return pr(str, i, str2, strPr, cVar);
            case "complete":
                return hw(str, i, str2, strPr, cVar);
            default:
                if (!TextUtils.isEmpty(strPr) && !TextUtils.equals(strPr, strHw)) {
                    return false;
                }
                pr(str2, strHw, str, i, cVar);
                return true;
        }
    }

    private static boolean pr(String str, int i, String str2, String str3, c cVar) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, TrackAction.START)) {
            return false;
        }
        pr(str2, TrackAction.START, str, i, cVar);
        return true;
    }

    private static boolean hw(String str, int i, String str2, String str3, c cVar) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, "complete")) {
            return false;
        }
        pr(str2, "complete", str, i, cVar);
        return true;
    }

    private static void pr(String str, String str2, String str3, int i, c cVar) {
        if (cVar != null) {
            cVar.pr();
        }
    }

    private static String pr(Map<String, Object> map) {
        Object obj;
        return (map == null || (obj = map.get("state")) == null) ? "" : String.valueOf(obj);
    }

    private static String hw(Map<String, Object> map) {
        Object obj;
        if (map == null) {
            return "";
        }
        Object obj2 = map.get("args");
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (objArr.length > 0 && (obj = objArr[0]) != null) {
                return String.valueOf(obj);
            }
        }
        Object obj3 = map.get("state");
        return obj3 == null ? "" : String.valueOf(obj3);
    }

    @Override // com.byazt.at.pr
    public void pr(String str) {
        String strPr = hw.pr(str);
        Iterator<Map.Entry<String, String>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strPr)) {
                it.remove();
            }
        }
    }
}
