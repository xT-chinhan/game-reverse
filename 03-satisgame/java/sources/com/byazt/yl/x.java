package com.byazt.yl;

import android.util.SparseArray;
import java.io.File;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1845, 21})
public class x implements qg, Function {
    public volatile Function n;
    public volatile qg qg;

    public x(qg qgVar) {
        this.qg = qgVar;
    }

    public x(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return Boolean.valueOf(this.qg.n((String) sparseArray.get(1), (byte[]) sparseArray.get(2)));
            case 3:
                return Boolean.valueOf(this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 4:
                return this.qg.n((String) sparseArray.get(1));
            case 5:
                return this.qg.qg((String) sparseArray.get(1));
            case 6:
                return this.qg.s((String) sparseArray.get(1));
            case 7:
                return Boolean.valueOf(this.qg.q((String) sparseArray.get(1)));
            case 8:
                return Boolean.valueOf(this.qg.l((String) sparseArray.get(1)));
            case 9:
                this.qg.qg();
                return null;
            case 10:
                this.qg.n(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 11:
                return Integer.valueOf(this.qg.s());
            case 12:
                return Long.valueOf(this.qg.q());
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

    @Override // com.byazt.yl.qg
    public boolean l(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.yl.qg
    public File n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.qg
    public void n(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.qg
    public boolean n(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.yl.qg
    public boolean n(String str, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, bArr);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.yl.qg
    public byte[] n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return (byte[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.qg
    public long q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.yl.qg
    public boolean q(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.yl.qg
    public String qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.qg
    public void qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.yl.qg
    public int s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.yl.qg
    public InputStream s(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return (InputStream) this.n.apply(sparseArray);
    }
}
