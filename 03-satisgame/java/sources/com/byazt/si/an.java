package com.byazt.si;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, 1758})
public class an implements j, Function {
    public volatile Function n;
    public volatile j qg;

    public an(j jVar) {
        this.qg = jVar;
    }

    public an(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object obj2 = sparseArray.get(1);
            Object oaVar = sparseArray.get(2);
            if (oaVar != null) {
                oaVar = new oa((Function) oaVar);
            }
            this.qg.n((String) obj2, (d) oaVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        Object obj3 = sparseArray.get(1);
        Object oaVar2 = sparseArray.get(2);
        if (oaVar2 != null) {
            oaVar2 = new oa((Function) oaVar2);
        }
        this.qg.qg((String) obj3, (d) oaVar2);
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

    @Override // com.byazt.si.j
    public void n(String str, d dVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        if (dVar != null) {
            dVar = new oa(dVar);
        }
        sparseArray.put(2, dVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.j
    public void qg(String str, d dVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        if (dVar != null) {
            dVar = new oa(dVar);
        }
        sparseArray.put(2, dVar);
        this.n.apply(sparseArray);
    }
}
