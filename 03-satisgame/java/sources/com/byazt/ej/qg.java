package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 26})
public class qg implements n, Function {
    public volatile Function n;
    public volatile n qg;

    public qg(n nVar) {
        this.qg = nVar;
    }

    public qg(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 2:
                return this.qg.qg();
            case 3:
                return this.qg.s();
            case 4:
                return this.qg.q();
            case 5:
                return this.qg.n();
            case 6:
                this.qg.l();
                return null;
            case 7:
                Object cyVar = sparseArray.get(1);
                if (cyVar != null) {
                    cyVar = new cy((Function) cyVar);
                }
                return Boolean.valueOf(this.qg.n((k) cyVar));
            case 8:
                Object cyVar2 = sparseArray.get(1);
                if (cyVar2 != null) {
                    cyVar2 = new cy((Function) cyVar2);
                }
                return Long.valueOf(this.qg.qg((k) cyVar2));
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

    @Override // com.byazt.ej.n
    public void l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.n
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.n
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.n
    public boolean n(k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.n
    public String q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.n
    public long qg(k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.n
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.n
    public String s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.n.apply(sparseArray);
    }
}
