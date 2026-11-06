package com.byazt.ej;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 113})
public class d implements tj, Function {
    public volatile Function n;
    public volatile tj qg;

    public d(tj tjVar) {
        this.qg = tjVar;
    }

    public d(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        Object cyVar = sparseArray.get(2);
        Object cpVar = sparseArray.get(3);
        if (cyVar != null) {
            cyVar = new cy((Function) cyVar);
        }
        if (cpVar != null) {
            cpVar = new cp((Function) cpVar);
        }
        this.qg.n((Context) obj2, (k) cyVar, (tj.n) cpVar);
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

    @Override // com.byazt.ej.tj
    public void n(Context context, k kVar, tj.n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(2, kVar);
        if (nVar != null) {
            nVar = new cp(nVar);
        }
        sparseArray.put(3, nVar);
        this.n.apply(sparseArray);
    }
}
