package com.byazt.vf;

import android.content.Context;
import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 86})
public class cd implements hd, Function {
    public volatile Function n;
    public volatile hd qg;

    public cd(hd hdVar) {
        this.qg = hdVar;
    }

    public cd(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue == -4) {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        } else {
            if (iIntValue == 1) {
                return n((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
            }
            if (iIntValue == 2) {
                return qg((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
            }
            if (iIntValue == 3) {
                return s((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
            }
            if (iIntValue == 4) {
                return n((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (String) sparseArray.get(4));
            }
            if (iIntValue == 5) {
                return q((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
            }
        }
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

    @Override // com.byazt.vf.hd
    public File n(Context context, String str, boolean z, String str2) {
        if (this.qg != null) {
            return this.qg.n(context, str, z, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, str2);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hd
    public File n(Context context, boolean z, String str) {
        if (this.qg != null) {
            return this.qg.n(context, z, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, str);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hd
    public File q(Context context, boolean z, String str) {
        if (this.qg != null) {
            return this.qg.q(context, z, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, str);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hd
    public File qg(Context context, boolean z, String str) {
        if (this.qg != null) {
            return this.qg.qg(context, z, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, str);
        return (File) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hd
    public File s(Context context, boolean z, String str) {
        if (this.qg != null) {
            return this.qg.s(context, z, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, str);
        return (File) this.n.apply(sparseArray);
    }
}
