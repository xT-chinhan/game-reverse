package com.byazt.zs;

import android.util.SparseArray;
import com.byazt.vkw.rc;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 50})
public class vk implements rc, Function {
    public final SparseArray<Object> pr = new SparseArray<>();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return pr(((Integer) sparseArray.get(1)).intValue());
            case 2:
                Object obj2 = sparseArray.get(1);
                pr(((Integer) obj2).intValue(), sparseArray.get(2));
                return null;
            case 3:
                Object obj3 = sparseArray.get(1);
                Object hwVar = sparseArray.get(2);
                if (hwVar != null) {
                    hwVar = new com.byazt.cr.hw((Function) hwVar);
                }
                return pr(((Integer) obj3).intValue(), (com.byazt.cr.pr) hwVar);
            case 4:
                Object obj4 = sparseArray.get(1);
                Object obj5 = sparseArray.get(2);
                Object hwVar2 = sparseArray.get(3);
                if (hwVar2 != null) {
                    hwVar2 = new com.byazt.cr.hw((Function) hwVar2);
                }
                pr(((Integer) obj4).intValue(), obj5, (com.byazt.cr.pr) hwVar2);
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.rc
    public synchronized Object pr(int i) {
        return this.pr.get(i);
    }

    @Override // com.byazt.vkw.rc
    public synchronized void pr(int i, Object obj) {
        this.pr.put(i, obj);
    }

    @Override // com.byazt.vkw.rc
    public synchronized Object pr(int i, com.byazt.cr.pr prVar) {
        Object obj = this.pr.get(i);
        if (prVar == null) {
            return obj;
        }
        if (obj != null) {
            return prVar.pr(obj);
        }
        return null;
    }

    @Override // com.byazt.vkw.rc
    public synchronized void pr(int i, Object obj, com.byazt.cr.pr prVar) {
        try {
            if (prVar == null) {
                this.pr.put(i, obj);
            } else {
                if (obj != null) {
                    this.pr.put(i, prVar.pr(obj));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
