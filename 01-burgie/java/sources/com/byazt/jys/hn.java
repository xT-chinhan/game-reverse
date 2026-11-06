package com.byazt.jys;

import android.text.TextUtils;
import com.byazt.hcx.aj;
import com.byazt.wt.rc;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1564, 20})
public final class hn extends pr {
    public static hw pr = null;

    @Override // com.byazt.jys.pr
    public String pr() {
        return "net";
    }

    public static String pr(aj ajVar, String str) {
        Map map;
        hw hwVarPr = com.byazt.nq.pr.pr("net");
        if (hwVarPr == null || (map = (Map) hwVarPr.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get(BreakpointSQLiteKey.URL);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                ajVar.pr(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void pr(JSONObject jSONObject, int i) {
        try {
            hw hwVarPr = com.byazt.nq.pr.pr("net");
            if (hwVarPr == null) {
                return;
            }
            String string = rc.pr(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put("body", string);
            map.put("type", Integer.valueOf(i));
            hwVarPr.call(2, map);
        } catch (Throwable th) {
        }
    }

    public static void hw(JSONObject jSONObject, int i) {
        try {
            hw hwVarPr = com.byazt.nq.pr.pr("net");
            if (hwVarPr != null && jSONObject != null) {
                String string = rc.pr(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put("body", string);
                map.put("type", Integer.valueOf(i));
                hwVarPr.call(3, map);
            }
        } catch (Throwable th) {
        }
    }
}
