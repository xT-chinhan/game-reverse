package com.byazt.vf;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 1758})
public class an implements j, Function {
    public volatile Function n;
    public volatile j qg;

    public an(j jVar) {
        this.qg = jVar;
    }

    public an(Function function) {
        this.n = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue != -4) {
            switch (iIntValue) {
                case 1:
                    return n((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
                case 2:
                    return n((Context) sparseArray.get(1), (String) sparseArray.get(2));
                case 3:
                    n((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Integer) sparseArray.get(3)).intValue(), (String[]) sparseArray.get(4), (long[]) sparseArray.get(5), ((Boolean) sparseArray.get(6)).booleanValue());
                    break;
                case 4:
                    return Boolean.valueOf(n());
                case 5:
                    n(((Boolean) sparseArray.get(1)).booleanValue());
                    break;
                case 6:
                    return qg();
                case 7:
                    return s();
                case 8:
                    return Integer.valueOf(q());
            }
        } else {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
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
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.vf.j
    public com.byazt.ej.x n(Context context, String str) {
        ?? rvVar;
        if (this.qg != null) {
            return this.qg.n(context, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            rvVar = Apply;
            rvVar = new com.byazt.ej.rv((Function) Apply);
        }
        rvVar = Apply;
        return (com.byazt.ej.x) rvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // com.byazt.vf.j
    public com.byazt.ej.x n(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        ?? rvVar;
        if (this.qg != null) {
            return this.qg.n(context, z, j, jSONObject, looper);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, Long.valueOf(j));
        sparseArray.put(4, jSONObject);
        sparseArray.put(5, looper);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            rvVar = Apply;
            rvVar = new com.byazt.ej.rv((Function) Apply);
        }
        rvVar = Apply;
        return (com.byazt.ej.x) rvVar;
    }

    @Override // com.byazt.vf.j
    public void n(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        if (this.qg != null) {
            this.qg.n(context, str, i, strArr, jArr, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, strArr);
        sparseArray.put(5, jArr);
        sparseArray.put(6, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.j
    public void n(boolean z) {
        if (this.qg != null) {
            this.qg.n(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.j
    public boolean n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.j
    public int q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.j
    public com.byazt.ej.tj qg() {
        ?? dVar;
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            dVar = Apply;
            dVar = new com.byazt.ej.d((Function) Apply);
        }
        dVar = Apply;
        return (com.byazt.ej.tj) dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vf.j
    public com.byazt.ej.n s() {
        ?? qgVar;
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qgVar = Apply;
            qgVar = new com.byazt.ej.qg((Function) Apply);
        }
        qgVar = Apply;
        return (com.byazt.ej.n) qgVar;
    }
}
