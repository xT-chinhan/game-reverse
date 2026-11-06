package com.byazt.zr;

import android.util.SparseArray;
import com.byazt.pch.qg;
import com.byazt.vgx.s;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 993, 19})
public class n {
    public PluginValueSet n;
    public com.byazt.pch.n qg;

    public n(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
        this.qg = new com.byazt.pch.n(sparseArray, s.qg());
    }

    public int n() {
        return this.qg.w();
    }

    public int qg() {
        return this.qg.x();
    }

    public float s() {
        return this.qg.fs();
    }

    public float q() {
        return this.qg.rv();
    }

    public String l() {
        return this.qg.q();
    }

    public qg w() {
        com.byazt.pch.n nVar = this.qg;
        if (nVar != null) {
            return nVar.ur();
        }
        return null;
    }

    public com.byazt.he.s x() {
        if (w() != null) {
            return w().oa();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> fs() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return com.byazt.mp.s.n(pluginValueSet.objectValue(8302, Object.class));
        }
        return null;
    }

    public int rv() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet.intValue(3);
        }
        return 0;
    }
}
