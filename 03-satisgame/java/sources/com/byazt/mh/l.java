package com.byazt.mh;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1196, 18})
public class l {
    public static Object n(String str, String str2) {
        Map<String, Map<String, Object>> mapN;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.byazt.zh.n nVar = (com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex");
            if (nVar != null && (mapN = nVar.n()) != null && mapN != null && mapN.get(str) != null) {
                return mapN.get(str).get(str2);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void n(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        com.byazt.zh.n nVar = (com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex");
        Set<String> setQg = nVar.qg();
        if (map == null || setQg == null) {
            return;
        }
        Iterator<String> it = setQg.iterator();
        while (it.hasNext()) {
            com.byazt.zh.s sVarQg = nVar.qg(it.next());
            if (sVarQg != null && !TextUtils.isEmpty(sVarQg.w())) {
                map.put("unsupported_" + sVarQg.x() + "_version", sVarQg.w());
                sVarQg.n((String) null);
            }
        }
    }

    public static boolean n(String str) {
        return (str == null || w(str) == null) ? false : true;
    }

    public static Function<SparseArray<Object>, Object> qg(String str) {
        Function<SparseArray<Object>, Object> functionW = w(str);
        if (functionW == null) {
            return null;
        }
        try {
            return (Function) functionW.apply(com.byazt.of.qg.n().n(10000).n(Function.class).qg());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> n(String str, int i) {
        Function<SparseArray<Object>, Object> functionW = w(str);
        if (functionW == null) {
            return null;
        }
        try {
            return (Function) functionW.apply(com.byazt.of.qg.n().n(i).n(Function.class).qg());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> w(String str) {
        com.byazt.zh.s sVarQg = ((com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex")).qg(str);
        if (sVarQg != null && com.byazt.zh.l.n(str)) {
            return sVarQg.l();
        }
        return null;
    }

    public static Function<SparseArray<Object>, Object> s(String str) {
        com.byazt.zh.s sVarQg = ((com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex")).qg(str);
        if (sVarQg != null) {
            return sVarQg.n();
        }
        return null;
    }

    public static Function<SparseArray<Object>, Object> n(String str, int i, int i2) {
        try {
            switch (i) {
                case 1:
                    return n(str, 20001);
                case 2:
                    return n(str, 20004);
                case 3:
                    return n(str, 20007);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i2 == 4) {
                        return n(str, 20005);
                    }
                    if (i2 == 3) {
                        return n(str, 20001);
                    }
                    if (i2 == 5) {
                        return n(str, 20002);
                    }
                    return n(str, 20005);
                case 7:
                    return n(str, 20006);
                case 8:
                    return n(str, 20003);
                case 9:
                    return n(str, 20002);
                case 10:
                    if (i2 == 1) {
                        return n(str, 20004);
                    }
                    if (i2 == 2) {
                        return n(str, 20003);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void n() {
        if (com.byazt.vyf.s.cy().an() && com.byazt.zh.l.l() == 1) {
            ((wo) com.byazt.qp.q.n("thread_service")).n(new Runnable() { // from class: com.byazt.mh.l.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.zh.n nVar;
                    String strN;
                    com.byazt.zh.s sVarQg;
                    boolean z;
                    try {
                        if (!l.s() || (nVar = (com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex")) == null) {
                            return;
                        }
                        Iterator<Map.Entry<String, com.byazt.ws.n>> it = com.byazt.ir.s.n().s().entrySet().iterator();
                        while (it.hasNext()) {
                            com.byazt.ws.n value = it.next().getValue();
                            if (value != null && !value.l() && ((sVarQg = nVar.qg((strN = value.n()))) == null || !TextUtils.isEmpty(sVarQg.q()))) {
                                if (!nVar.n(strN) && com.byazt.zh.l.n(strN)) {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    l.q(strN);
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (sVarQg == null || sVarQg.n() == null) {
                                        z = false;
                                    } else {
                                        com.byazt.ww.n nVar2 = new com.byazt.ww.n(value);
                                        nVar2.s = true;
                                        nVar2.q();
                                        z = true;
                                    }
                                    com.byazt.eji.s.n().n(0L, jCurrentTimeMillis2, z ? 1 : -1, 2);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void n(final Runnable runnable) {
        if (com.byazt.zh.l.l() == 2) {
            com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.mh.l.2
                @Override // java.lang.Runnable
                public void run() {
                    l.s();
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s() {
        boolean zX;
        int i = 2;
        try {
            try {
                if (!com.byazt.zh.l.qg()) {
                    com.byazt.zh.l.n("dex_status", 3);
                    return false;
                }
                if (!com.byazt.vyf.s.cy().an()) {
                    com.byazt.zh.l.n("dex_status", 3);
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.wl.l.n();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (!com.byazt.wl.l.tj("com.byted.mixed")) {
                    com.byazt.zh.l.n("dex_status", 3);
                    return false;
                }
                zX = com.byazt.wl.l.x("com.byted.mixed");
                try {
                    com.byazt.eji.s.n().n(jCurrentTimeMillis2, System.currentTimeMillis() - jCurrentTimeMillis3, 1, 1);
                    com.byazt.zh.l.n("dex_status", zX ? 2 : 3);
                    return zX;
                } catch (Throwable unused) {
                }
                com.byazt.eji.s.n().n(0L, 0L, -1, 1);
                return false;
            } finally {
                com.byazt.zh.l.n("dex_status", zX ? 2 : 3);
            }
        } catch (Throwable unused2) {
            zX = false;
        }
    }

    public static void q(String str) {
        if (l(str)) {
            n(((com.byazt.zh.n) com.byazt.qp.q.n("adapter_dex")).qg(str));
        }
    }

    private static void n(com.byazt.zh.s sVar) {
        JSONObject jSONObjectOptJSONObject;
        Class<?> cls;
        try {
            if (com.byazt.zh.l.s() && sVar != null && sVar.n() == null) {
                String strX = sVar.x();
                if (TextUtils.isEmpty(strX)) {
                    return;
                }
                String strQg = sVar.qg();
                if (TextUtils.isEmpty(strQg)) {
                    return;
                }
                String strS = sVar.s();
                if (TextUtils.isEmpty(strS)) {
                    return;
                }
                String strQ = sVar.q();
                if (TextUtils.isEmpty(strQ)) {
                    com.byazt.zh.l.n(strX, "dex_status", 100);
                    return;
                }
                JSONObject jSONObjectFs = com.byazt.wl.l.fs("com.byted.mixed");
                if (jSONObjectFs != null) {
                    if (jSONObjectFs.has("adn_version") && (jSONObjectOptJSONObject = jSONObjectFs.optJSONObject("adn_version")) != null && jSONObjectOptJSONObject.has(strS)) {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray(strS);
                        if (jSONArray.length() > 0) {
                            boolean z = false;
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (TextUtils.equals(jSONArray.getString(i), strQ)) {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                if (jSONObjectFs.has(strQg)) {
                                    String strOptString = jSONObjectFs.optString(strQg);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        return;
                                    }
                                    try {
                                        if (com.byazt.zh.l.s()) {
                                            cls = com.byazt.wl.l.cp("com.byted.mixed").loadClass(strOptString);
                                        } else {
                                            cls = Class.forName(strOptString);
                                        }
                                        Object objNewInstance = cls.newInstance();
                                        if (objNewInstance instanceof Function) {
                                            sVar.n((Function<SparseArray<Object>, Object>) objNewInstance);
                                            com.byazt.zh.l.n(strX, "dex_status", 500);
                                            return;
                                        }
                                        return;
                                    } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                                        com.byazt.zh.l.n(strX, "dex_status", MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL);
                                        return;
                                    }
                                }
                                return;
                            }
                            com.byazt.zh.l.n(strX, "dex_status", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                            sVar.n(strQ);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.byazt.zh.l.n(strX, "dex_status", 200);
            }
        } catch (Throwable unused2) {
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "sigmob":
            case "xiaomi":
            case "ks":
            case "gdt":
            case "baidu":
                return true;
            default:
                return false;
        }
    }
}
