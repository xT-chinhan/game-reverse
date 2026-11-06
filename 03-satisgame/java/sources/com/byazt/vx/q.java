package com.byazt.vx;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1148, 5})
public class q implements Initializer {
    public final Function<SparseArray<Object>, Object> n;

    public q(Function<SparseArray<Object>, Object> function) {
        this.n = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.n == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        com.byazt.qp.q.qg(valueSet.stringValue(261001)).n(sparseArray);
        this.n.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.n;
        if (function == null) {
            return false;
        }
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.n == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999000);
        return new s((Function) this.n.apply(sparseArray));
    }
}
