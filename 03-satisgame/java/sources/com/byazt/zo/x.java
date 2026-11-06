package com.byazt.zo;

import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 21})
public class x {
    public static boolean fs = false;
    public static long l;
    public static long n;
    public static long q;
    public static long qg;
    public static long s;
    public static long w;
    public static long x;

    public static void n() {
        fs = true;
    }

    public static void n(JSONObject jSONObject, String str) {
        if (fs || jSONObject == null || TextUtils.isEmpty(str) || jSONObject.has(str)) {
            return;
        }
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - x);
        } catch (JSONException unused) {
        }
    }

    public static void n(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - j);
        } catch (JSONException unused) {
        }
    }
}
