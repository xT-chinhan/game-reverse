package com.byazt.vf;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, PointerIconCompat.TYPE_ZOOM_IN})
public class ln implements bb, Function {
    public volatile Function n;
    public volatile bb qg;

    public ln(bb bbVar) {
        this.qg = bbVar;
    }

    public ln(Function function) {
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
                return n();
            }
            if (iIntValue == 2) {
                Object cyVar = sparseArray.get(1);
                if (cyVar != null) {
                    cyVar = new com.byazt.qk.cy((Function) cyVar);
                }
                n((com.byazt.qk.k) cyVar);
            } else if (iIntValue == 3) {
                n(((Boolean) sparseArray.get(1)).booleanValue());
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.bb
    public com.byazt.qk.rv n() {
        ?? dVar;
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            dVar = Apply;
            dVar = new com.byazt.qk.d((Function) Apply);
        }
        dVar = Apply;
        return (com.byazt.qk.rv) dVar;
    }

    @Override // com.byazt.vf.bb
    public void n(com.byazt.qk.k kVar) {
        if (this.qg != null) {
            this.qg.n(kVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (kVar != null) {
            kVar = new com.byazt.qk.cy(kVar);
        }
        sparseArray.put(1, kVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.bb
    public void n(boolean z) {
        if (this.qg != null) {
            this.qg.n(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }
}
