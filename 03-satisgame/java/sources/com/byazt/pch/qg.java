package com.byazt.pch;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 26})
public class qg {
    public final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public boolean n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266001);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public boolean qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266002);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public boolean s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266003);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public float q() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266004);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.n.apply(sparseArray)).floatValue();
    }

    public boolean l() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266005);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public Map<String, Object> w() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266006);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.n.apply(sparseArray);
    }

    public boolean x() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266007);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public String fs() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266008);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public boolean rv() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266009);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public com.byazt.he.qg tj() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266101);
        sparseArray.put(-99999985, Object.class);
        Object objApply = this.n.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.byazt.he.qg((Function) objApply);
        }
        return null;
    }

    public float cp() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266010);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.n.apply(sparseArray)).floatValue();
    }

    public float d() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266011);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.n.apply(sparseArray)).floatValue();
    }

    public com.byazt.he.s oa() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266102);
        sparseArray.put(-99999985, Object.class);
        return new com.byazt.he.s(com.byazt.mp.s.n(this.n.apply(sparseArray)));
    }

    public String sz() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266103);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public int k() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266104);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.n.apply(sparseArray)).intValue();
    }
}
