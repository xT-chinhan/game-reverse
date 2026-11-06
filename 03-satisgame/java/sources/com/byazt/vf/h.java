package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 878})
public class h implements hu, Function {
    public volatile Function n;
    public volatile hu qg;

    public h(hu huVar) {
        this.qg = huVar;
    }

    public h(Function function) {
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
                return n(((Integer) sparseArray.get(1)).intValue());
            }
            if (iIntValue == 2) {
                n(((Integer) sparseArray.get(1)).intValue(), sparseArray.get(2));
            } else {
                if (iIntValue == 3) {
                    Object obj2 = sparseArray.get(1);
                    Object qgVar = sparseArray.get(2);
                    if (qgVar != null) {
                        qgVar = new com.byazt.eau.qg((Function) qgVar);
                    }
                    return n(((Integer) obj2).intValue(), (com.byazt.eau.n) qgVar);
                }
                if (iIntValue == 4) {
                    Object obj3 = sparseArray.get(1);
                    Object obj4 = sparseArray.get(2);
                    Object qgVar2 = sparseArray.get(3);
                    if (qgVar2 != null) {
                        qgVar2 = new com.byazt.eau.qg((Function) qgVar2);
                    }
                    n(((Integer) obj3).intValue(), obj4, (com.byazt.eau.n) qgVar2);
                }
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

    @Override // com.byazt.vf.hu
    public Object n(int i) {
        if (this.qg != null) {
            return this.qg.n(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hu
    public Object n(int i, com.byazt.eau.n nVar) {
        if (this.qg != null) {
            return this.qg.n(i, nVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        if (nVar != null) {
            nVar = new com.byazt.eau.qg(nVar);
        }
        sparseArray.put(2, nVar);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hu
    public void n(int i, Object obj) {
        if (this.qg != null) {
            this.qg.n(i, obj);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.hu
    public void n(int i, Object obj, com.byazt.eau.n nVar) {
        if (this.qg != null) {
            this.qg.n(i, obj, nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        if (nVar != null) {
            nVar = new com.byazt.eau.qg(nVar);
        }
        sparseArray.put(3, nVar);
        this.n.apply(sparseArray);
    }
}
