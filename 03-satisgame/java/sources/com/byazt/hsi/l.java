package com.byazt.hsi;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1461, 18})
public class l implements s, Function {
    public volatile Function n;
    public volatile s qg;

    public l(s sVar) {
        this.qg = sVar;
    }

    public l(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue != 1) {
            if (iIntValue != 3) {
                return null;
            }
            return Long.valueOf(this.qg.n());
        }
        this.qg.n((Context) sparseArray.get(1), (Intent) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), ((Integer) sparseArray.get(4)).intValue());
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

    @Override // com.byazt.hsi.s
    public long n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.hsi.s
    public void n(Context context, Intent intent, boolean z, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, intent);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }
}
