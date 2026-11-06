package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.collector.Collector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {
    private static boolean ab = false;
    public static ConcurrentHashMap<String, String> ah = new ConcurrentHashMap<>(4);
    private static boolean c = true;
    public static xr d = null;
    private static volatile pc ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static jw f504ms = null;
    private static volatile d x = null;
    public static boolean xr = true;

    public static boolean ab() {
        return true;
    }

    public static void ms(Context context, x xVar) {
        if (ka != null) {
            oh.xr(new RuntimeException("Init Twice!"));
            return;
        }
        if (xVar.g() == null) {
            oh.xr(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        b bVarC = b.c();
        pc pcVar = new pc(application, xVar);
        ka = pcVar;
        jw jwVar = new jw(application, pcVar);
        bVarC.ms(application, pcVar, jwVar, new qv(xVar.ch()));
        f504ms = jwVar;
        if (ka.h()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        oh.d("Inited", null);
    }

    public static void ms(boolean z) {
        xr = z;
    }

    public static void ms() {
        jw jwVar;
        if (!xr || (jwVar = f504ms) == null) {
            return;
        }
        jwVar.d();
    }

    public static void xr() {
        b.ms();
    }

    public static d ah() {
        return x;
    }

    public static xr d() {
        return d;
    }

    public static void ms(HashMap<String, Object> map) {
        jw jwVar = f504ms;
        if (jwVar != null) {
            jwVar.ms(map);
        }
    }

    public static String ka() {
        jw jwVar = f504ms;
        if (jwVar != null) {
            return jwVar.zb();
        }
        return null;
    }

    public static JSONObject c() {
        if (ka != null) {
            return ka.t();
        }
        return null;
    }

    public static <T> T ms(String str, T t) {
        jw jwVar = f504ms;
        if (jwVar != null) {
            return (T) jwVar.ms(str, t);
        }
        return null;
    }

    public static void ms(String str, JSONObject jSONObject) {
        b.ms(new qk(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void ms(String str, JSONObject jSONObject, int i) {
        b.ms(new qk(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void ms(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        oh.xr(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        ms(str, jSONObject);
    }

    public static void ms(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        oh.xr(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        ms(str, jSONObject, i);
    }

    public static void xr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            oh.xr("call onEventData with invalid params, return", null);
            return;
        }
        try {
            b.ms(new v(str, jSONObject));
        } catch (Exception e) {
            oh.ah("call onEventData get exception: ", e);
        }
    }

    public static String x() {
        jw jwVar = f504ms;
        return jwVar != null ? jwVar.ab() : "";
    }

    public static String ny() {
        jw jwVar = f504ms;
        return jwVar != null ? jwVar.ny() : "";
    }

    public static String ch() {
        jw jwVar = f504ms;
        return jwVar != null ? jwVar.ch() : "";
    }

    public static ah hi() {
        return sk.ms();
    }

    public static void ms(ka kaVar) {
        vf.ms(kaVar);
    }

    public static x sl() {
        if (ka != null) {
            return ka.fm();
        }
        return null;
    }
}
