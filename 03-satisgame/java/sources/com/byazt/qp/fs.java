package com.byazt.qp;

import android.util.SparseArray;
import com.byazt.vf.hu;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 101})
public class fs implements hu, Function {
    public final SparseArray<Object> n = new SparseArray<>();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return n(((Integer) sparseArray.get(1)).intValue());
        }
        if (iIntValue == 2) {
            Object obj2 = sparseArray.get(1);
            n(((Integer) obj2).intValue(), sparseArray.get(2));
            return null;
        }
        if (iIntValue == 3) {
            Object obj3 = sparseArray.get(1);
            Object qgVar = sparseArray.get(2);
            if (qgVar != null) {
                qgVar = new com.byazt.eau.qg((Function) qgVar);
            }
            return n(((Integer) obj3).intValue(), (com.byazt.eau.n) qgVar);
        }
        if (iIntValue != 4) {
            return null;
        }
        Object obj4 = sparseArray.get(1);
        Object obj5 = sparseArray.get(2);
        Object qgVar2 = sparseArray.get(3);
        if (qgVar2 != null) {
            qgVar2 = new com.byazt.eau.qg((Function) qgVar2);
        }
        n(((Integer) obj4).intValue(), obj5, (com.byazt.eau.n) qgVar2);
        return null;
    }

    @Override // com.byazt.vf.hu
    public synchronized Object n(int i) {
        return this.n.get(i);
    }

    @Override // com.byazt.vf.hu
    public synchronized void n(int i, Object obj) {
        this.n.put(i, obj);
    }

    @Override // com.byazt.vf.hu
    public synchronized Object n(int i, com.byazt.eau.n nVar) {
        Object obj = this.n.get(i);
        if (nVar == null) {
            return obj;
        }
        if (obj == null) {
            return null;
        }
        return nVar.n(obj);
    }

    @Override // com.byazt.vf.hu
    public synchronized void n(int i, Object obj, com.byazt.eau.n nVar) {
        try {
            if (nVar == null) {
                this.n.put(i, obj);
            } else {
                if (obj != null) {
                    this.n.put(i, nVar.n(obj));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
