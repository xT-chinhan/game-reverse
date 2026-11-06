package com.byazt.xmw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1493, 26})
public class qg {
    public final PluginValueSet n;

    public qg(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public List<String> n() {
        return (List) this.n.objectValue(262114, List.class);
    }

    public List<String> qg() {
        return (List) this.n.objectValue(262115, List.class);
    }

    public boolean s() {
        return this.n.booleanValue(262116);
    }

    public boolean q() {
        return this.n.booleanValue(262117);
    }

    public boolean l() {
        return this.n.booleanValue(262118);
    }
}
