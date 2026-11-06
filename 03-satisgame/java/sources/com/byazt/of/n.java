package com.byazt.of;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1170, 19})
public class n {
    public static boolean n(int i) {
        return i >= 6803 && i < 7000;
    }

    public static SparseArray<Object> n(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(qg.n().n(-99999986).n(SparseArray.class).qg());
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static PluginValueSet qg(Function<SparseArray<Object>, Object> function) {
        Object objApply;
        if (function == null) {
            return com.byazt.qvu.n.n().qg();
        }
        if ((function instanceof Supplier) && n(com.byazt.mlu.n.n().qg())) {
            objApply = ((Supplier) function).get();
        } else {
            objApply = function.apply(qg.n().n(-99999986).n(SparseArray.class).qg());
        }
        if (objApply instanceof SparseArray) {
            return com.byazt.qvu.n.n((SparseArray<Object>) objApply).qg();
        }
        return com.byazt.qvu.n.n().qg();
    }
}
