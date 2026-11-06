package com.byazt.xi;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2018, 37})
public class pr {
    public static SparseArray<Object> pr(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(hw.pr().pr(-99999986).pr(SparseArray.class).hw());
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static PluginValueSet hw(Function<SparseArray<Object>, Object> function) {
        Object objApply;
        if (function == null) {
            return com.byazt.ij.pr.pr().hw();
        }
        if ((function instanceof Supplier) && pr(com.byazt.q.pr.pr().hw())) {
            objApply = ((Supplier) function).get();
        } else {
            objApply = function.apply(hw.pr().pr(-99999986).pr(SparseArray.class).hw());
        }
        if (objApply instanceof SparseArray) {
            return com.byazt.ij.pr.pr((SparseArray<Object>) objApply).hw();
        }
        return com.byazt.ij.pr.pr().hw();
    }

    public static boolean pr(int i) {
        return i >= 6803 && i < 7000;
    }
}
