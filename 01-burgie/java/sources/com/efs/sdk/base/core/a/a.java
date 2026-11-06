package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static volatile long b = -1;
    public boolean a;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.a = true;
    }

    /* JADX INFO: renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    static class C0249a {
        private static final a a = new a(0);
    }

    public static a a() {
        return C0249a.a;
    }

    public static long b() {
        if (b == -1) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + b;
    }

    @NonNull
    public final HttpResponse a(String str, c cVar, File file, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        dVarA.a.d = file;
        com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVar.h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.m);
        return dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    public static String a(@NonNull String str, @NonNull c cVar) {
        String str2;
        switch (cVar.g) {
            case 1:
                str2 = "/apm_logs";
                break;
            case 2:
                str2 = "/perf_upload";
                break;
            case 3:
                str2 = "/api/v1/mix/upload";
                break;
            default:
                str2 = "/api/v1/raw/upload";
                break;
        }
        return str + str2;
    }

    static void a(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString(PluginConstants.KEY_ERROR_CODE, "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j - b()) <= 1500000) {
                return;
            }
            b = j - SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }
}
