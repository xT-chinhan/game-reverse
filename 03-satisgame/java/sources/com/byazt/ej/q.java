package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 5})
public class q implements s, Function {
    public volatile Function n;
    public volatile s qg;

    public q(s sVar) {
        this.qg = sVar;
    }

    public q(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.qg.n());
            case 2:
                this.qg.n(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 3:
                return Integer.valueOf(this.qg.qg());
            case 4:
                this.qg.qg(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                return this.qg.s();
            case 6:
                this.qg.n((String) sparseArray.get(1));
                return null;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.ej.s
    public int n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.s
    public void n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.s
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.s
    public int qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.s
    public void qg(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.s
    public String s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }
}
