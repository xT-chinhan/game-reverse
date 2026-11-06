package com.byazt.sf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsGetCustomHttpHeader, 26})
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
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2));
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

    @Override // com.byazt.sf.n
    public void n(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }
}
