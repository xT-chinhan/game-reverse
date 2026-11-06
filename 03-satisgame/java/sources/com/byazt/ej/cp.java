package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 29})
public class cp implements tj.n, Function {
    public volatile Function n;
    public volatile tj.n qg;

    public cp(tj.n nVar) {
        this.qg = nVar;
    }

    public cp(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object cyVar = sparseArray.get(1);
            Object obj2 = sparseArray.get(2);
            if (cyVar != null) {
                cyVar = new cy((Function) cyVar);
            }
            this.qg.qg((k) cyVar, ((Integer) obj2).intValue());
            return null;
        }
        if (iIntValue == 2) {
            Object cyVar2 = sparseArray.get(1);
            Object obj3 = sparseArray.get(2);
            Object obj4 = sparseArray.get(3);
            if (cyVar2 != null) {
                cyVar2 = new cy((Function) cyVar2);
            }
            this.qg.n((k) cyVar2, ((Integer) obj3).intValue(), (String) obj4);
            return null;
        }
        if (iIntValue != 3) {
            return null;
        }
        Object cyVar3 = sparseArray.get(1);
        Object obj5 = sparseArray.get(2);
        if (cyVar3 != null) {
            cyVar3 = new cy((Function) cyVar3);
        }
        this.qg.n((k) cyVar3, ((Integer) obj5).intValue());
        return null;
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

    @Override // com.byazt.ej.tj.n
    public void n(k kVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.tj.n
    public void n(k kVar, int i, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.tj.n
    public void qg(k kVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }
}
