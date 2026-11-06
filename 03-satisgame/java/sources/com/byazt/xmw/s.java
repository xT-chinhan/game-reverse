package com.byazt.xmw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1493, 8})
public class s {
    public final PluginValueSet n;

    public s(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public Map<String, String> n() {
        return (Map) this.n.objectValue(265007, Map.class);
    }

    public String qg() {
        return (String) this.n.objectValue(265001, String.class);
    }

    public String s() {
        return (String) this.n.objectValue(265002, String.class);
    }

    public String q() {
        return (String) this.n.objectValue(265003, String.class);
    }

    public int l() {
        return this.n.intValue(265004);
    }

    public String w() {
        return (String) this.n.objectValue(265005, String.class);
    }

    public String x() {
        return (String) this.n.objectValue(265006, String.class);
    }
}
