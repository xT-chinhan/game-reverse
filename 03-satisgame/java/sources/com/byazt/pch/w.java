package com.byazt.pch;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 13})
public class w {
    public final Function<SparseArray<Object>, Object> n;

    public w(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270032);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(s sVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, sVar);
        sparseArray.put(-99999987, 270033);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
