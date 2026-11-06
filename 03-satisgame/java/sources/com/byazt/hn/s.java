package com.byazt.hn;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 975, 8})
public class s {
    public static boolean n(int i) {
        return i >= 6803 && i < 7000;
    }

    public static Object n(SparseArray<Object> sparseArray) {
        return n(com.byazt.mlu.n.n().qg()) ? com.byazt.qvu.s.n(sparseArray).qg() : sparseArray;
    }

    public static PluginValueSet n(int i, PluginValueSet pluginValueSet) {
        if (n(com.byazt.mlu.n.n().qg())) {
            return com.byazt.qvu.n.n(((ValueSet) pluginValueSet.objectValue(i, ValueSet.class)).sparseArray()).qg();
        }
        return com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSet.objectValue(i, SparseArray.class)).qg();
    }
}
