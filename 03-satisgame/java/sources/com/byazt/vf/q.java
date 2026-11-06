package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 5})
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
                    return n();
                case 2:
                    return n(((Boolean) sparseArray.get(1)).booleanValue());
                case 3:
                    return n((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                case 4:
                    Object qVar = sparseArray.get(1);
                    if (qVar != null) {
                        qVar = new com.byazt.zve.q((Function) qVar);
                    }
                    n((com.byazt.zve.s) qVar);
                    break;
                case 5:
                    qg();
                    break;
                case 6:
                    s();
                    break;
                case 7:
                    return q();
                case 8:
                    return n((String) sparseArray.get(1), (String) sparseArray.get(2));
                case 9:
                    n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                    break;
                case 10:
                    qg((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                    break;
                case 11:
                    return Boolean.valueOf(l());
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

    @Override // com.byazt.vf.s
    public boolean l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.s
    public String n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public String n(String str, String str2) {
        if (this.qg != null) {
            return this.qg.n(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public String n(boolean z) {
        if (this.qg != null) {
            return this.qg.n(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public void n(com.byazt.zve.s sVar) {
        if (this.qg != null) {
            this.qg.n(sVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        if (sVar != null) {
            sVar = new com.byazt.zve.q(sVar);
        }
        sparseArray.put(1, sVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public void n(String str, JSONObject jSONObject) {
        if (this.qg != null) {
            this.qg.n(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public byte[] n(byte[] bArr, int i) {
        if (this.qg != null) {
            return this.qg.n(bArr, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        return (byte[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public String q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public void qg() {
        if (this.qg != null) {
            this.qg.qg();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public void qg(String str, JSONObject jSONObject) {
        if (this.qg != null) {
            this.qg.qg(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.s
    public void s() {
        if (this.qg != null) {
            this.qg.s();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.n.apply(sparseArray);
    }
}
