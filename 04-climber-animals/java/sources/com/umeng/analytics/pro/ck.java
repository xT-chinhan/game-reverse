package com.umeng.analytics.pro;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: NccAgent.java */
/* JADX INFO: loaded from: classes4.dex */
public class ck {
    private static cj g;
    private static Object a = new Object();
    private static Object b = new Object();
    private static ArrayList<cg> c = new ArrayList<>();
    private static ArrayList<ci> d = new ArrayList<>();
    private static volatile int e = 0;
    private static volatile long f = 0;
    private static ArrayList<cj.a> h = new ArrayList<>();

    public static void a(cg cgVar) {
        if (cgVar != null) {
            synchronized (a) {
                c.add(cgVar);
            }
        }
    }

    public static void a(ci ciVar) {
        if (ciVar != null) {
            synchronized (b) {
                d.add(ciVar);
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        synchronized (b) {
            int size = d.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    d.get(i).a(jSONObject);
                }
            }
        }
    }

    public static void a(ch chVar) {
        if (chVar != null) {
            chVar.a(cn.a().b(UMGlobalContext.getAppContext()));
        }
    }

    public static void b(JSONObject jSONObject) {
        synchronized (a) {
            int size = c.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    c.get(i).a(jSONObject);
                }
            }
        }
    }

    public static void a(Context context) {
        b(context);
        cn.a().a(context);
    }

    private static void b(Context context) {
        if (g == null) {
            synchronized (ck.class) {
                if (g == null) {
                    cj cjVar = new cj();
                    g = cjVar;
                    if (context instanceof Application) {
                        ((Application) context).registerActivityLifecycleCallbacks(cjVar);
                    } else {
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext instanceof Application) {
                            ((Application) applicationContext).registerActivityLifecycleCallbacks(g);
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: Failed to register ActivityLifecycleCallbacks, context is not Application");
                        }
                    }
                }
            }
        }
    }

    public static void a(cj.a aVar) {
        if (aVar != null) {
            synchronized (h) {
                if (!h.contains(aVar)) {
                    h.add(aVar);
                }
            }
            cj cjVar = g;
            if (cjVar != null) {
                cjVar.a(aVar);
            }
        }
    }

    public static void b(cj.a aVar) {
        if (aVar != null) {
            synchronized (h) {
                h.remove(aVar);
            }
            cj cjVar = g;
            if (cjVar != null) {
                cjVar.b(aVar);
            }
        }
    }

    public static Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("flag", String.valueOf(e));
        map.put("ts", String.valueOf(f));
        return map;
    }

    static int b() {
        return e;
    }

    public static void a(String str, String str2, Bundle bundle) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: umc_cfg: call b a.");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: onActUpEvent: type or token agument is empty string, pls check!");
            return;
        }
        String string = "";
        if (bundle != null) {
            try {
                string = bundle.getString("ss");
            } catch (Throwable unused) {
                return;
            }
        }
        String str3 = string;
        boolean z = true;
        e = 1;
        f = System.currentTimeMillis();
        long initCompleteTs = UMConfigure.getInitCompleteTs();
        if (initCompleteTs != 0 && System.currentTimeMillis() - initCompleteTs > 6000) {
            z = false;
        }
        JSONObject jSONObjectA = cn.a().a(str, str2, str3, f, z);
        if (jSONObjectA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: umc_cfg: upload b a. cd_flag is " + z);
            aw.a(new ar(ar.b, jSONObjectA), 0L, TimeUnit.SECONDS);
            Thread.sleep(com.anythink.basead.exoplayer.i.a.f);
        }
    }
}
