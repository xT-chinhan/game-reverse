package com.ss.android.downloadlib.addownload.xr;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile x f4459ms;

    private x() {
    }

    public static x ms() {
        if (f4459ms == null) {
            synchronized (d.class) {
                if (f4459ms == null) {
                    f4459ms = new x();
                }
            }
        }
        return f4459ms;
    }

    public void ms(int i, int i2, com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y());
        if (msVarMs.ms("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= msVarMs.ms("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().xr("api_hijack", jSONObject, xrVar);
    }
}
