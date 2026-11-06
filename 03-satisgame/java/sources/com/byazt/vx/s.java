package com.byazt.vx;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1148, 8})
public class s implements Manager {
    public final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, Function.class);
        return new qg((Function) this.n.apply(sparseArray));
    }

    public Function<SparseArray<Object>, Object> n(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        Object objApply = this.n.apply(sparseArray);
        if (objApply instanceof Function) {
            return (Function) objApply;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        Object objApply = this.n.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.byazt.qvu.s.n((SparseArray<Object>) objApply).qg();
        }
        return null;
    }
}
