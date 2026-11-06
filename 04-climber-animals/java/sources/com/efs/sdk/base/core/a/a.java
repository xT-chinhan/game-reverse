package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
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
    static class C0344a {
        private static final a a = new a(0);
    }

    public static a a() {
        return C0344a.a;
    }

    public static long b() {
        if (b == -1) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + b;
    }

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
        return dVarA.a("type", cVar.h).a("size", new StringBuilder().append(cVar.o).toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    public final HttpResponse a(String str, c cVar, byte[] bArr, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.a) {
            Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        dVarA.a.c = bArr;
        dVarA.a.g = true;
        return dVarA.a("type", cVar.h).a("size", new StringBuilder().append(cVar.o).toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    private static String a(String str, c cVar) {
        String str2;
        byte b2 = cVar.g;
        if (b2 == 1) {
            str2 = "/apm_logs";
        } else if (b2 != 2) {
            str2 = b2 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload";
        } else {
            str2 = "/perf_upload";
        }
        return str + str2;
    }

    static void a(HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j - b()) > 1500000) {
                b = j - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }
}
