package com.byazt.ek;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.rr.cp;
import com.byazt.rr.d;
import com.byazt.rr.fs;
import com.byazt.rr.l;
import com.byazt.rr.w;
import com.byazt.rr.x;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1032, 5})
public class q implements s, Function {
    public volatile Function n;
    public volatile s qg;

    public q(s sVar) {
        this.qg = sVar;
    }

    public q(Function function) {
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
                    Object obj2 = sparseArray.get(1);
                    Object wVar = sparseArray.get(2);
                    if (wVar != null) {
                        wVar = new w((Function) wVar);
                    }
                    n((Context) obj2, (l) wVar);
                    break;
                case 2:
                    n((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 3:
                    Object obj3 = sparseArray.get(1);
                    Object obj4 = sparseArray.get(2);
                    Object obj5 = sparseArray.get(3);
                    Object obj6 = sparseArray.get(4);
                    Object dVar = sparseArray.get(5);
                    if (dVar != null) {
                        dVar = new d((Function) dVar);
                    }
                    n((String) obj3, (JSONObject) obj4, ((Boolean) obj5).booleanValue(), ((Long) obj6).longValue(), (cp) dVar);
                    break;
                case 4:
                    Object obj7 = sparseArray.get(1);
                    Object qgVar = sparseArray.get(2);
                    if (qgVar != null) {
                        qgVar = new com.byazt.rr.qg((Function) qgVar);
                    }
                    n((String) obj7, (com.byazt.rr.n) qgVar);
                    break;
                case 5:
                    Object obj8 = sparseArray.get(1);
                    Object qgVar2 = sparseArray.get(2);
                    if (qgVar2 != null) {
                        qgVar2 = new com.byazt.rr.qg((Function) qgVar2);
                    }
                    qg((String) obj8, (com.byazt.rr.n) qgVar2);
                    break;
                case 6:
                    n();
                    break;
                case 7:
                    n(((Integer) sparseArray.get(1)).intValue());
                    break;
                case 8:
                    return Integer.valueOf(qg());
                case 9:
                    return s();
                case 10:
                    n((String) sparseArray.get(1));
                    break;
                case 11:
                    qg((String) sparseArray.get(1));
                    break;
                case 12:
                    Object obj9 = sparseArray.get(1);
                    Object fsVar = sparseArray.get(2);
                    if (fsVar != null) {
                        fsVar = new fs((Function) fsVar);
                    }
                    n((String) obj9, (x) fsVar);
                    break;
                case 13:
                    s((String) sparseArray.get(1));
                    break;
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

    @Override // com.byazt.ek.s
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(int i) {
        if (this.qg != null) {
            this.qg.n(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(Context context, l lVar) {
        if (this.qg != null) {
            this.qg.n(context, lVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        if (lVar != null) {
            lVar = new w(lVar);
        }
        sparseArray.put(2, lVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(String str) {
        if (this.qg != null) {
            this.qg.n(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(String str, com.byazt.rr.n nVar) {
        if (this.qg != null) {
            this.qg.n(str, nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        if (nVar != null) {
            nVar = new com.byazt.rr.qg(nVar);
        }
        sparseArray.put(2, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(String str, x xVar) {
        if (this.qg != null) {
            this.qg.n(str, xVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        if (xVar != null) {
            xVar = new fs(xVar);
        }
        sparseArray.put(2, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(String str, String str2) {
        if (this.qg != null) {
            this.qg.n(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void n(String str, JSONObject jSONObject, boolean z, long j, cp cpVar) {
        if (this.qg != null) {
            this.qg.n(str, jSONObject, z, j, cpVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, Long.valueOf(j));
        if (cpVar != null) {
            cpVar = new d(cpVar);
        }
        sparseArray.put(5, cpVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public int qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ek.s
    public void qg(String str) {
        if (this.qg != null) {
            this.qg.qg(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void qg(String str, com.byazt.rr.n nVar) {
        if (this.qg != null) {
            this.qg.qg(str, nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        if (nVar != null) {
            nVar = new com.byazt.rr.qg(nVar);
        }
        sparseArray.put(2, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.s
    public void s(String str) {
        if (this.qg != null) {
            this.qg.s(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }
}
