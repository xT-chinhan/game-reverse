package com.byazt.zrg;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.cl.Collector;
import com.byazt.ec.w;
import com.byazt.xa.aj;
import com.byazt.xa.zo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 400, 37})
public final class pr {
    public static volatile zo c;
    public static aj pr;
    public static hn x;
    public static volatile c zo;
    public static boolean hw = true;
    public static boolean uc = true;
    public static boolean fw = false;
    public static ConcurrentHashMap<String, String> hn = new ConcurrentHashMap<>(4);

    public static void pr(Context context, fw fwVar) {
        if (c != null) {
            w.hw(new RuntimeException("Init Twice!"));
            return;
        }
        if (fwVar.y() == null) {
            w.hw(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        com.byazt.gox.x xVarC = com.byazt.gox.x.c();
        zo zoVar = new zo(application, fwVar);
        c = zoVar;
        aj ajVar = new aj(application, zoVar);
        xVarC.pr(application, zoVar, ajVar, new com.byazt.cl.pr(fwVar.aj()));
        pr = ajVar;
        if (c.yb()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        w.x("Inited", null);
    }

    public static void pr(boolean z) {
        hw = z;
    }

    public static void pr() {
        aj ajVar;
        if (hw && (ajVar = pr) != null) {
            ajVar.x();
        }
    }

    public static void hw() {
        com.byazt.gox.x.pr();
    }

    public static c hn() {
        return zo;
    }

    public static hn x() {
        return x;
    }

    public static void pr(HashMap<String, Object> map) {
        aj ajVar = pr;
        if (ajVar != null) {
            ajVar.pr(map);
        }
    }

    public static String c() {
        aj ajVar = pr;
        if (ajVar != null) {
            return ajVar.g();
        }
        return null;
    }

    public static JSONObject uc() {
        if (c != null) {
            return c.a();
        }
        return null;
    }

    public static String fw() {
        aj ajVar = pr;
        if (ajVar != null) {
            return ajVar.zo();
        }
        return "";
    }

    public static <T> T pr(String str, T t) {
        aj ajVar = pr;
        if (ajVar != null) {
            return (T) ajVar.pr(str, t);
        }
        return null;
    }

    public static void pr(String str, JSONObject jSONObject) {
        com.byazt.gox.x.pr(new com.byazt.kg.c(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void pr(String str, JSONObject jSONObject, int i) {
        com.byazt.gox.x.pr(new com.byazt.kg.c(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void pr(String str, Bundle bundle) {
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
                        w.hw(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        pr(str, jSONObject);
    }

    public static void pr(String str, Bundle bundle, int i) {
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
                        w.hw(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        pr(str, jSONObject, i);
    }

    public static void hw(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            w.hw("call onEventData with invalid params, return", null);
            return;
        }
        try {
            com.byazt.gox.x.pr(new com.byazt.kg.x(str, jSONObject));
        } catch (Exception e) {
            w.hn("call onEventData get exception: ", e);
        }
    }

    public static boolean zo() {
        return true;
    }

    public static String aj() {
        aj ajVar = pr;
        if (ajVar != null) {
            return ajVar.fw();
        }
        return "";
    }

    public static String vk() {
        aj ajVar = pr;
        if (ajVar != null) {
            return ajVar.vk();
        }
        return "";
    }

    public static String w() {
        aj ajVar = pr;
        if (ajVar != null) {
            return ajVar.w();
        }
        return "";
    }

    public static x k() {
        return com.byazt.ec.hw.pr();
    }

    public static void pr(com.byazt.lq.hn hnVar) {
        com.byazt.xev.fw.pr(hnVar);
    }

    public static void hw(com.byazt.lq.hn hnVar) {
        com.byazt.xev.fw.hw(hnVar);
    }

    public static fw m() {
        if (c != null) {
            return c.i();
        }
        return null;
    }

    public static void g() {
        com.byazt.gox.x.c().aj();
    }

    public static void ho() {
        com.byazt.gox.x.c().vk();
    }
}
