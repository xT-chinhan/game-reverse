package com.byazt.dea;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, 13})
public class hw implements Loader {
    public final Function<SparseArray<Object>, Void> pr;

    public hw(Function<SparseArray<Object>, Void> function) {
        this.pr = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, SparseArray<Object> sparseArray) {
        if (this.pr != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            sparseArray.put(-99999982, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            this.pr.apply(sparseArray);
        }
    }
}
