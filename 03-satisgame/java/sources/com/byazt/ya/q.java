package com.byazt.ya;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.api.ATAdConst;
import com.byazt.jp.sz;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 5})
public class q extends com.byazt.gf.q implements com.byazt.ju.q {
    public Function<SparseArray<Object>, Object> l;
    public s n;
    public Function<SparseArray<Object>, Object> qg;
    public String s;
    public com.byazt.jp.s w;
    public List<com.byazt.ju.s> q = new CopyOnWriteArrayList();
    public long x = 0;
    public int fs = 0;

    @Override // com.byazt.ju.q
    public String s() {
        return null;
    }

    public q() {
        s sVarN = s.n(com.byazt.qt.n.d().an());
        this.n = sVarN;
        this.qg = sVarN.n();
    }

    @Override // com.byazt.ju.qg
    public void n(Context context, Map<String, Object> map, com.byazt.ju.s sVar) {
        int i;
        long jCurrentTimeMillis;
        if (!this.q.contains(sVar)) {
            this.q.add(sVar);
        }
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        l.n(qgVarN);
        qgVarN.n(3, map.get("app_id"));
        qgVarN.n(8550, Boolean.valueOf(com.byazt.vyf.s.cy().sh()));
        qgVarN.n(8, com.byazt.qt.n.d().um());
        qgVarN.n(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.APP_KEY));
        String str = (String) map.get(MediationConstant.EXTRA_ADN_NAME);
        this.s = str;
        qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, n(str));
        qgVarN.n(8560, qg(this.s));
        qgVarN.n(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, map.get(MediationConstant.EXTRA_ADN_NAME));
        qgVarN.n(8410, "5.7.20.1.0");
        qgVarN.n(8411, com.byazt.sg.qg.qg());
        qgVarN.n(8413, "9.4603.0");
        qgVarN.n(8414, "4.701.1571.0");
        qgVarN.n(8417, "4.25.82.0");
        qgVarN.n(8558, "5.3.3.8");
        qgVarN.n(7, Integer.valueOf(tj()));
        qgVarN.n(8425, map);
        qgVarN.n(8300, this);
        n(this.s, "initAdn name: " + this.s);
        int i2 = 0;
        try {
            if (com.byazt.zh.l.n(this.s) && com.byazt.zh.l.l() == 2 && com.byazt.mh.l.s(this.s) == null) {
                jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.mh.l.q(this.s);
            } else {
                jCurrentTimeMillis = -1;
            }
            Function<SparseArray<Object>, Object> functionS = com.byazt.mh.l.s(this.s);
            n(this.s, "initAdn: dexBridge: ".concat(String.valueOf(functionS)));
            if (com.byazt.mh.l.n(this.s)) {
                com.byazt.zh.l.n(this.s, "dex_status", functionS == null ? 10000 : AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
                if (com.byazt.zh.l.l() == 2 && jCurrentTimeMillis != -1) {
                    com.byazt.eji.s.n().n(0L, System.currentTimeMillis() - jCurrentTimeMillis, 1, 2);
                }
            }
            i = 1;
            if (functionS != null) {
                n(this.s, "initAdn: 走dexpl的ADN初始化");
                qgVarN.n(8563, com.byazt.mh.l.n(this.s, "adn_init"));
                try {
                    this.l = functionS;
                    functionS.apply(com.byazt.of.qg.n().n(8240).n(Void.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(8424, qgVarN.qg()).qg());
                    com.byazt.zh.l.n(this.s, "dex_status", 30000);
                } catch (Throwable unused) {
                    i2 = 1;
                    i = i2;
                }
                com.byazt.zh.l.n(this.s, "adn_init", i);
            }
            n(this.s, "initAdn: 走Adapter aar的ADN初始化");
            qgVarN.n(AVMDLDataLoader.KeyIsLiveLoaderEnable).n(Boolean.class);
            Boolean bool = (Boolean) this.qg.apply(qgVarN.qg());
            if (bool != null && bool.booleanValue()) {
            }
            i = i2;
            com.byazt.zh.l.n(this.s, "adn_init", i);
            i2 = 1;
        } catch (Throwable unused2) {
        }
        i = i2;
        com.byazt.zh.l.n(this.s, "adn_init", i);
    }

    private void n(String str, String str2) {
        if (str != null) {
            str.equals(MediationConstant.ADN_GDT);
        }
    }

    private int tj() {
        com.byazt.mt.s sVarQg = com.byazt.qt.n.d().qg();
        if (sVarQg != null) {
            return sVarQg.ur();
        }
        return 0;
    }

    public static String n(String str) {
        str.hashCode();
        switch (str) {
            case "klevin":
                return MediationConstant.KLEVIN_ADN_CLASS_NAME;
            case "sigmob":
                return MediationConstant.SIGMOB_ADN_CLASS_NAME;
            case "xiaomi":
                return MediationConstant.XIAOMI_ADN_CLASS_NAME;
            case "ks":
                return MediationConstant.KS_ADN_CLASS_NAME;
            case "gdt":
                return MediationConstant.GDT_ADN_CLASS_NAME;
            case "baidu":
                return MediationConstant.BAIDU_ADN_CLASS_NAME;
            case "unity":
                return MediationConstant.UNITY_ADN_CLASS_NAME;
            case "mintegral":
                return MediationConstant.MINTEGRAL_ADN_CLASS_NAME;
            default:
                return null;
        }
    }

    public static String qg(String str) {
        str.hashCode();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    @Override // com.byazt.ju.q
    public String n() {
        Function<SparseArray<Object>, Object> function = this.l;
        if (function != null) {
            Object objApply = function.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable).n(String.class).qg());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    @Override // com.byazt.ju.q
    public String n(Context context, Map<String, Object> map) {
        if (this.l != null) {
            Object objApply = this.l.apply(com.byazt.of.qg.n().n(8102).n(String.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).qg());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return null;
    }

    @Override // com.byazt.ju.q
    public Map<String, Object> qg(Context context, Map<String, Object> map) {
        if (this.l != null) {
            Object objApply = this.l.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLiveGetLoaderType).n(String.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).qg());
            if (objApply instanceof Map) {
                return (Map) objApply;
            }
        }
        return null;
    }

    public String fs() {
        return this.s;
    }

    @Override // com.byazt.ju.q
    public String qg() {
        try {
            Function<SparseArray<Object>, Object> function = this.l;
            if (function != null) {
                Object objApply = function.apply(com.byazt.of.qg.n().n(8104).n(String.class).qg());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    @Override // com.byazt.ju.q
    public void n(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.l;
        if (function != null) {
            function.apply(com.byazt.of.qg.n().n(8242).n(Void.class).n(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).qg());
        }
    }

    @Override // com.byazt.ju.q
    public int n(com.byazt.jp.s sVar) {
        Function<SparseArray<Object>, Object> function = this.l;
        if (function != null) {
            this.w = sVar;
            Object objApply = function.apply(com.byazt.of.qg.n().n(8126).n(Integer.class).qg());
            if (objApply != null) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    @Override // com.byazt.ju.q
    public void n(sz szVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.l;
        if (function == null || szVar == null) {
            return;
        }
        function.apply(com.byazt.of.qg.n().n(8124).n(Void.class).n(8517, sparseArray).qg());
    }

    @Override // com.byazt.ju.q
    public void q() {
        try {
            if (com.byazt.mh.l.s(fs()) != null) {
                cp();
            } else {
                d();
            }
        } catch (Exception unused) {
        }
    }

    private void cp() {
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", fs() + "版本号：" + qg() + " , 聚合版本号：" + com.byazt.zo.qg.s());
    }

    private void d() {
        String strS = com.byazt.zo.qg.s();
        if (!TextUtils.isEmpty(n())) {
            com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", fs() + "版本号：" + qg() + " , " + fs() + "Adapter版本号：" + n() + " , 聚合版本号：" + strS);
        } else {
            com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", fs() + "版本号：" + qg() + " , ***" + fs() + "Adapter未接入，请检查***, 聚合版本号：" + strS);
        }
    }

    @Override // com.byazt.ju.q
    public long l() {
        return this.x;
    }

    @Override // com.byazt.ju.q
    public int w() {
        return this.fs;
    }

    @Override // com.byazt.ju.q
    public void x() {
        this.fs = 0;
        this.x = 0L;
    }

    private void oa() {
        Iterator<com.byazt.ju.s> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
        this.q.clear();
    }

    private void n(com.byazt.mj.n nVar) {
        Iterator<com.byazt.ju.s> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().n(nVar);
        }
        this.q.clear();
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8122) {
            this.l = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
            oa();
        } else if (i == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n((SparseArray<Object>) sparseArray).qg();
                n(new com.byazt.mj.n(pluginValueSetQg.intValue(-999900), pluginValueSetQg.stringValue(-999901)));
                return null;
            }
        } else if (i == 8212) {
            if (this.w != null) {
                this.w.n(pluginValueSet.intValue(8095));
            }
        } else if (i == 8266) {
            this.l = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
            sz();
        } else if (i == 8270) {
            this.fs = pluginValueSet.intValue(8557);
            this.x = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
        }
        return null;
    }

    private void sz() {
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ya.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gwu.s sVarL;
                JSONObject jSONObjectQg = com.byazt.ng.q.qg();
                if (jSONObjectQg == null || (sVarL = com.byazt.ri.n.l()) == null) {
                    return;
                }
                sVarL.n("gm_adapter_version_list", jSONObjectQg.toString());
            }
        });
    }

    public static JSONObject rv() {
        com.byazt.gwu.s sVarL = com.byazt.ri.n.l();
        if (sVarL != null) {
            String string = sVarL.getString("gm_adapter_version_list", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
        }
        return null;
    }
}
