package com.byazt.ya;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 19})
public class n {
    public final AtomicBoolean n = new AtomicBoolean(false);
    public final AtomicBoolean qg = new AtomicBoolean(false);
    public com.byazt.ti.qg s;
    public boolean w;
    public boolean x;
    public static final com.byazt.ti.n q = new com.byazt.ti.n();
    public static Map<String, Pair<Boolean, String>> l = new ConcurrentHashMap();
    public static final Map<String, Boolean> fs = new ConcurrentHashMap();

    public static void n(String str, Pair<Boolean, String> pair) {
        l.put(str, pair);
    }

    public static int n() {
        return l.size();
    }

    public static n qg() {
        return new n();
    }

    public static synchronized void s() {
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ya.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                for (Map.Entry entry : n.l.entrySet()) {
                    if (entry.getValue() != null) {
                        if (((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                            if (com.byazt.qt.qg.n().s((String) entry.getKey())) {
                                com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                            } else {
                                com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                            }
                        } else {
                            com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                        }
                    }
                }
                com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
            }
        });
    }

    public static com.byazt.ti.n q() {
        return q;
    }

    public static String n(Map<String, Object> map, String str) {
        return q.n(com.byazt.qt.qg.getContext(), map, str);
    }

    public static Map<String, Object> qg(Map<String, Object> map, String str) {
        return q.qg(com.byazt.qt.qg.getContext(), map, str);
    }

    public static com.byazt.sbw.n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return q.n(str);
    }

    public void n(Map<String, com.byazt.ws.n> map) {
        com.byazt.ws.n nVarRemove;
        if (map == null || (nVarRemove = map.remove(MediationConstant.ADN_GDT)) == null) {
            return;
        }
        new com.byazt.ww.n(nVarRemove).q();
    }

    public void qg(Map<String, com.byazt.ws.n> map) {
        if (map == null) {
            return;
        }
        com.byazt.ws.n nVarRemove = map.remove(MediationConstant.ADN_MINTEGRAL);
        final ArrayList arrayList = new ArrayList();
        if (nVarRemove != null) {
            arrayList.add(nVarRemove);
        }
        Runnable runnable = new Runnable() { // from class: com.byazt.ya.n.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    new com.byazt.ww.n((com.byazt.ws.n) it.next()).q();
                }
                n.this.n.set(true);
                n.this.w();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.byazt.rb.l.s(runnable);
        }
    }

    public void n(final Context context, Map<String, com.byazt.ws.n> map) {
        if (map == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.ws.n>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            com.byazt.ws.n value = it.next().getValue();
            if (value != null) {
                if (value.l()) {
                    arrayList.add(value);
                } else {
                    arrayList2.add(value);
                }
            }
        }
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ya.n.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    new com.byazt.ww.n((com.byazt.ws.n) it2.next()).q();
                }
                com.byazt.it.qg.n(context, (List<com.byazt.ws.n>) arrayList);
                n.this.qg.set(true);
                n.this.w();
            }
        });
    }

    public void n(Context context, boolean z, boolean z2, JSONObject jSONObject, com.byazt.ti.qg qgVar) {
        this.s = qgVar;
        this.n.set(false);
        this.qg.set(false);
        this.w = z;
        this.x = z2;
        n(context, jSONObject);
    }

    public void n(Context context, JSONObject jSONObject) {
        Map<String, com.byazt.ws.n> mapS = com.byazt.ir.s.n().s();
        if (com.byazt.qt.qg.n().s()) {
            l();
            n(mapS);
            com.byazt.zo.x.n(jSONObject, "s-gdt");
        } else {
            n(mapS);
            com.byazt.zo.x.n(jSONObject, "s-gdt");
            l();
        }
        qg(mapS);
        n(context, mapS);
    }

    public void l() {
        if (com.byazt.qt.qg.n().s()) {
            com.byazt.ti.qg qgVar = this.s;
            if (qgVar != null) {
                qgVar.n();
                return;
            }
            return;
        }
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ya.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.s != null) {
                    n.this.s.n();
                }
            }
        });
    }

    public void w() {
        if (!this.w && this.x && this.n.get() && this.qg.get()) {
            com.byazt.it.n.n();
            s();
        }
    }

    public static void n(String str, boolean z) {
        com.byazt.ws.n nVarN;
        if (TextUtils.isEmpty(str) || TextUtils.equals(MediationConstant.ADN_PANGLE, str) || s(str, z) || (nVarN = com.byazt.qt.qg.n().n(str)) == null) {
            return;
        }
        final com.byazt.ww.n nVar = new com.byazt.ww.n(nVarN);
        if ((TextUtils.equals(MediationConstant.ADN_MINTEGRAL, str) || TextUtils.equals(MediationConstant.ADN_KLEVIN, str)) && !com.byazt.rb.l.l()) {
            com.byazt.rb.l.qg(new Runnable() { // from class: com.byazt.ya.n.5
                @Override // java.lang.Runnable
                public void run() {
                    nVar.q();
                }
            });
        } else {
            nVar.q();
        }
    }

    public static final synchronized void qg(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = str + "_pl";
            }
            fs.put(str, Boolean.TRUE);
        }
    }

    public static final synchronized boolean s(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = str + "_pl";
            }
            Boolean bool = fs.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }
}
