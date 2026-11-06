package com.byazt.sbw;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.gf.q;
import com.byazt.or.qg;
import com.byazt.ya.l;
import com.byazt.ya.s;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2123, 19})
public class n extends q {
    public static final String s = "TTMediationSDK_n";
    public qg q;
    public Function<SparseArray<Object>, Object> x;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public long n = 0;
    public int qg = 0;
    public final Function<SparseArray<Object>, Object> w = s.n(com.byazt.qt.n.d().an()).n();

    public String q() {
        return "0.0";
    }

    public final void n() {
        this.l.set(true);
    }

    public final boolean qg() {
        return this.l.get();
    }

    public final void n(Context context, qg qgVar, Map<String, Object> map) {
        this.l.set(false);
        this.q = qgVar;
        qg(context, qgVar, map);
    }

    public void qg(Context context, qg qgVar, Map<String, Object> map) {
        if (qgVar != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLiveLoaderEnable).n(Void.class).n(8089, com.byazt.qt.n.d().an().sparseArray()).n(8545, com.byazt.hn.s.n(qgVar.n())).n(8400, map).n(8401, this).n(8098, Boolean.TRUE);
            l.n(qgVarN);
            this.w.apply(qgVarN.qg());
        }
    }

    public String s() {
        if (this.x == null) {
            return null;
        }
        Object objApply = this.x.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel).n(String.class).qg());
        return objApply instanceof String ? (String) objApply : "";
    }

    public String n(Context context, Map<String, Object> map) {
        if (this.x == null) {
            return null;
        }
        Object objApply = this.x.apply(com.byazt.of.qg.n().n(8139).n(String.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(8075, map).qg());
        return objApply instanceof String ? (String) objApply : "";
    }

    public String qg(Context context, Map<String, Object> map) {
        if (this.x == null) {
            return null;
        }
        Object objApply = this.x.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue).n(String.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(8075, map).qg());
        return objApply instanceof String ? (String) objApply : "";
    }

    public long l() {
        return this.n;
    }

    public int w() {
        return this.qg;
    }

    public void x() {
        this.qg = 0;
        this.n = 0L;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8216) {
            this.x = (Function) pluginValueSet.objectValue(8402, Function.class);
        } else if (i == 8219) {
            n();
        } else {
            if (i == 8220) {
                return (T) Boolean.valueOf(qg());
            }
            if (i == 8270) {
                long jLongValue = pluginValueSet.longValue(8073);
                this.qg = pluginValueSet.intValue(8557);
                this.n = jLongValue;
            }
        }
        return (T) com.byazt.ef.n.n(cls);
    }
}
