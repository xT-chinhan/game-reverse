package com.byazt.dea;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, 20})
public class hn implements Manager {
    public final Function<SparseArray<Object>, Object> pr;

    public hn(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.hn.hw : function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, Function.class);
        return new hw((Function) this.pr.apply(sparseArray));
    }

    public Function<SparseArray<Object>, Object> pr(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        Object objApply = this.pr.apply(sparseArray);
        if (objApply instanceof Function) {
            return (Function) objApply;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        Object objApply = this.pr.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.byazt.ij.hn.pr((SparseArray<Object>) objApply).hw();
        }
        return null;
    }
}
