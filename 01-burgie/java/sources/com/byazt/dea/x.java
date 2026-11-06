package com.byazt.dea;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, 121})
public class x implements Initializer {
    public final Function<SparseArray<Object>, Object> pr;

    public x(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.pr != null && valueSet != null && context != null) {
            SparseArray<Object> sparseArray = valueSet.sparseArray();
            sparseArray.put(-99999987, -999001);
            sparseArray.put(-998000, context);
            com.byazt.zs.uc.hw(valueSet.stringValue(261001)).pr(sparseArray);
            this.pr.apply(sparseArray);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.pr;
        if (function != null) {
            Object objApply = function.apply(sparseArray);
            if (objApply instanceof Boolean) {
                return ((Boolean) objApply).booleanValue();
            }
            return false;
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.pr != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -999000);
            return new hn((Function) this.pr.apply(sparseArray));
        }
        return null;
    }
}
