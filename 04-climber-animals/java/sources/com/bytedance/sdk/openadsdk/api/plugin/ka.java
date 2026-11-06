package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.Bundle;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static List<Pair<String, JSONObject>> f1818ms = new ArrayList();

    public static void ms(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
            jSONObject.putOpt("isBoost", Boolean.TRUE);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        ah("plugin_load_failed", jSONObject);
    }

    public static void ms(String str, JSONObject jSONObject) {
        ah("zeus_".concat(String.valueOf(str)), jSONObject);
    }

    public static void ms() {
        if (f1818ms.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : f1818ms) {
                if (pair != null) {
                    ah((String) pair.first, (JSONObject) pair.second);
                }
            }
            f1818ms.clear();
        } catch (Exception unused) {
        }
    }

    private static void ah(String str, JSONObject jSONObject) {
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(a.z, 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static void xr(String str, JSONObject jSONObject) {
        f1818ms.add(new Pair<>(str, jSONObject));
    }
}
