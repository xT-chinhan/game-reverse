package com.bytedance.sdk.openadsdk.ab;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static ah f1644ms;

    @Override // com.bytedance.sdk.openadsdk.ab.ms
    public String ms() {
        return TKDownloadReason.KSAD_TK_NET;
    }

    public static String ms(com.bytedance.sdk.component.ny.xr.d dVar, String str) {
        Map map;
        ah ahVarXr = xr.xr(TKDownloadReason.KSAD_TK_NET);
        if (ahVarXr == null || (map = (Map) ahVarXr.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                dVar.xr(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void ms(JSONObject jSONObject, int i) {
        try {
            ah ahVarXr = xr.xr(TKDownloadReason.KSAD_TK_NET);
            if (ahVarXr == null) {
                return;
            }
            String string = com.bytedance.sdk.component.utils.ms.ms(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put("body", string);
            map.put("type", Integer.valueOf(i));
            ahVarXr.call(2, map);
        } catch (Throwable unused) {
        }
    }

    public static void xr(JSONObject jSONObject, int i) {
        try {
            ah ahVarXr = xr.xr(TKDownloadReason.KSAD_TK_NET);
            if (ahVarXr != null && jSONObject != null) {
                String string = com.bytedance.sdk.component.utils.ms.ms(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put("body", string);
                map.put("type", Integer.valueOf(i));
                ahVarXr.call(3, map);
            }
        } catch (Throwable unused) {
        }
    }
}
