package com.byazt.pl;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 26})
public abstract class qg extends com.byazt.ua.qg {
    public static final int CLICK_TIMES = 60;
    public static final int SHOW_TIMES = 2;
    public com.byazt.qn.qg cp;
    public int fs;
    public Map<String, Object> l;
    public com.byazt.dd.qg q;
    public com.byazt.or.s qg;
    public String rv;
    public Function<SparseArray<Object>, Object> s;
    public String tj;
    public boolean w;
    public int x;

    public abstract <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public qg(String str, com.byazt.nw.qg qgVar) {
        super(qgVar);
        this.l = new ConcurrentHashMap();
        this.w = false;
        this.x = 0;
        this.fs = 0;
        this.tj = str;
    }

    public void n(int i, String str) {
        n(new com.byazt.mj.n(i, str));
    }

    @Override // com.byazt.ua.qg
    public final void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        this.q = qgVar;
        this.cp = qgVar2;
        this.qg = new com.byazt.or.s(qgVar.ou(), qgVar.d(), qgVar.sz(), qgVar.k(), qgVar.an());
        com.byazt.sbw.n nVarN = com.byazt.ya.n.n(qgVar.oa());
        this.rv = nVarN != null ? nVarN.s() : "";
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.byazt.zo.qg.n() >= 5900) {
            qgVarN.n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.rb.n.n(context));
        } else {
            qgVarN.n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.tj);
        qgVarN.n(8546, com.byazt.hn.s.n(this.qg.n()));
        if (qgVar2.ae() != null) {
            qgVarN.n(8548, com.byazt.hn.s.n(qgVar2.ae()));
        }
        Function<SparseArray<Object>, Object> functionL = com.byazt.zs.n.n().l();
        if (functionL != null) {
            qgVarN.n(Void.class);
            qgVarN.n(8106);
            functionL.apply(qgVarN.qg());
            return;
        }
        n(new com.byazt.mj.n("Adn custom class loader is null"));
    }

    @Override // com.byazt.nw.n
    public String n(String str) {
        return this.rv;
    }

    public void w() {
        this.w = true;
    }

    public String x() {
        com.byazt.dd.qg qgVar = this.q;
        return qgVar != null ? qgVar.hu() : "";
    }

    public Object fs() {
        com.byazt.dd.qg qgVar = this.q;
        return qgVar != null ? qgVar.ae() : "";
    }

    public int rv() {
        com.byazt.dd.qg qgVar = this.q;
        if (qgVar != null) {
            return qgVar.um();
        }
        return 0;
    }

    public void n(Map<String, Object> map) {
        if (map != null) {
            this.l.clear();
            this.l.putAll(map);
        }
    }

    public Integer tj() {
        if (this.s != null) {
            Integer numN = com.byazt.lpr.n.n(this.s.apply(com.byazt.of.qg.n().n(8121).n(Object.class).n(20068, 1).qg()));
            if (numN == null) {
                return 1;
            }
            return numN;
        }
        return 1;
    }

    public void n(boolean z, double d, int i, Map<String, Object> map) {
        if (this.s != null) {
            this.s.apply(com.byazt.of.qg.n().n(8225).n(Void.class).n(8406, Boolean.valueOf(z)).n(8407, Double.valueOf(d)).n(8408, Integer.valueOf(i)).n(8075, map).qg());
        }
    }

    public void cp() {
        if (this.s != null) {
            this.s.apply(com.byazt.of.qg.n().n(8149).n(Void.class).qg());
        }
    }

    public void d() {
        if (this.s != null) {
            this.s.apply(com.byazt.of.qg.n().n(8148).n(Void.class).qg());
        }
    }

    public void oa() {
        if (this.s != null) {
            this.s.apply(com.byazt.of.qg.n().n(8109).n(Void.class).qg());
        }
    }

    @Override // com.byazt.ua.qg, com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8221) {
            this.s = (Function) pluginValueSet.objectValue(8405, Function.class);
        } else {
            if (i == 8137) {
                T t = (T) x();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom loader : getAdm = ".concat(String.valueOf(t)));
                return t;
            }
            if (i == 8224) {
                T t2 = (T) fs();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t2)));
                return t2;
            }
            if (i == 8226) {
                T t3 = (T) Integer.valueOf(rv());
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom loader : getBiddingType = ".concat(String.valueOf(t3)));
                return t3;
            }
            if (i == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                n(map);
            }
        }
        return (T) n(i, pluginValueSet, cls);
    }

    public final void n(com.byazt.xo.n.InterfaceC0394n interfaceC0394n) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0394n != null) {
            interfaceC0394n.n();
        }
    }

    public final void qg(com.byazt.xo.n.InterfaceC0394n interfaceC0394n) {
        if (this.w) {
            int i = this.x;
            if (i < 2) {
                this.x = i + 1;
                if (interfaceC0394n != null) {
                    interfaceC0394n.n();
                    return;
                }
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    public final void s(com.byazt.xo.n.InterfaceC0394n interfaceC0394n) {
        int i = this.fs;
        if (i < 60) {
            this.fs = i + 1;
            if (interfaceC0394n != null) {
                interfaceC0394n.n();
                return;
            }
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
    }

    @Override // com.byazt.ua.qg
    public void n(com.byazt.sg.s sVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sVar);
        n(arrayList);
    }

    public void n(com.byazt.sg.s sVar, double d, Map<String, Object> map) {
        if (d > 0.0d && rv() == 1) {
            sVar.n(d);
        }
        if (map != null) {
            this.l.putAll(map);
        }
        sVar.q(this.l);
        n(sVar);
    }

    @Override // com.byazt.ua.qg, com.byazt.nw.qg
    public void n(List<com.byazt.sg.s> list) {
        for (com.byazt.sg.s sVar : list) {
            sVar.s(this.l);
            sVar.sz(this.q.h());
        }
        super.n(list);
    }
}
