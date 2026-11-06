package com.byazt.vx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1148, 26})
public class qg implements Loader {
    public final Function<SparseArray<Object>, Void> n;

    public qg(Function<SparseArray<Object>, Void> function) {
        this.n = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, SparseArray<Object> sparseArray) {
        if (this.n != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            sparseArray.put(-99999982, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            this.n.apply(sparseArray);
        }
    }
}
