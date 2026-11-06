package com.byazt.dh;

import android.text.TextUtils;
import com.byazt.qk.rv;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsTestSpeedVersion, 8})
public final class s extends n {
    public static qg n;

    @Override // com.byazt.dh.n
    public String n() {
        return "net";
    }

    public static String n(rv rvVar, String str) {
        Map map;
        qg qgVarN = com.byazt.lpr.s.n("net");
        if (qgVarN == null || (map = (Map) qgVarN.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get(ImagesContract.URL);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                rvVar.n(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void n(JSONObject jSONObject, int i) {
        try {
            qg qgVarN = com.byazt.lpr.s.n("net");
            if (qgVarN == null) {
                return;
            }
            String string = com.byazt.cl.s.n(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put("body", string);
            map.put("type", Integer.valueOf(i));
            qgVarN.call(2, map);
        } catch (Throwable unused) {
        }
    }

    public static void qg(JSONObject jSONObject, int i) {
        try {
            qg qgVarN = com.byazt.lpr.s.n("net");
            if (qgVarN != null && jSONObject != null) {
                String string = com.byazt.cl.s.n(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put("body", string);
                map.put("type", Integer.valueOf(i));
                qgVarN.call(3, map);
            }
        } catch (Throwable unused) {
        }
    }
}
