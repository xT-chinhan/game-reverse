package com.byazt.myr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1982, 18})
public class l implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener tTAdInteractionListener;

    public l(TTAdInteractionListener tTAdInteractionListener) {
        this.tTAdInteractionListener = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tTAdInteractionListener == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        if (pluginValueSetQg.intValue(-99999987) == 100101) {
            this.tTAdInteractionListener.onAdEvent(pluginValueSetQg.intValue(0), (Map) pluginValueSetQg.objectValue(1, Map.class));
        }
        return null;
    }
}
