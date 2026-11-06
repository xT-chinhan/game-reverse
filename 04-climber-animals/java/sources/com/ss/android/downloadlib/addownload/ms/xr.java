package com.ss.android.downloadlib.addownload.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.addownload.hi;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class xr {
    xr() {
    }

    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> ms(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.xr.ms msVarMs = com.ss.android.downloadlib.addownload.xr.ms.ms(jSONObject.optJSONObject(itKeys.next()));
                    if (msVarMs != null) {
                        copyOnWriteArrayList.add(msVarMs);
                    }
                }
            }
        } catch (Exception e) {
            ab.ms(e);
        }
        return copyOnWriteArrayList;
    }

    void ms(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.xr.ms msVar : copyOnWriteArrayList) {
                if (msVar != null) {
                    jSONObject.put(String.valueOf(msVar.xr), msVar.ms());
                }
            }
        } catch (Exception e) {
            ab.ms(e);
        }
        com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    void xr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), str, 0).edit().putString(str2, "").apply();
    }
}
