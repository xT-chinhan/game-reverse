package com.byazt.ya;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 8})
public class s {
    public final PluginValueSet n;

    public static s n(PluginValueSet pluginValueSet) {
        return new s(pluginValueSet);
    }

    private s(PluginValueSet pluginValueSet) {
        this.n = pluginValueSet;
    }

    public Function<SparseArray<Object>, Object> n() {
        if (qg()) {
            return (Function) this.n.objectValue(8301, Function.class);
        }
        return null;
    }

    private boolean qg() {
        PluginValueSet pluginValueSet = this.n;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }
}
