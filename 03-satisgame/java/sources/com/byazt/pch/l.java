package com.byazt.pch;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 18})
public class l {
    public Function<SparseArray<Object>, Object> n;

    public l(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public int n() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271044);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.n.apply(sparseArray)).intValue();
    }

    public n n(String str) {
        Object objApply = this.n.apply(com.byazt.of.qg.n().n(271045).n(SparseArray.class).qg());
        if (objApply instanceof SparseArray) {
            return new n((SparseArray) objApply, str);
        }
        return null;
    }

    public List<String> qg() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271046);
        sparseArray.put(-99999985, List.class);
        return (List) this.n.apply(sparseArray);
    }
}
