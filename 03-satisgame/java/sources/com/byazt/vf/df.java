package com.byazt.vf;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 34})
public class df implements fi, Function {
    public volatile Function n;
    public volatile fi qg;

    public df(fi fiVar) {
        this.qg = fiVar;
    }

    public df(Function function) {
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
                return Integer.valueOf(n((String) sparseArray.get(1)));
            }
            if (iIntValue == 2) {
                return n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
            }
            if (iIntValue == 3) {
                return n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (JSONObject) sparseArray.get(3));
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

    @Override // com.byazt.vf.fi
    public int n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.fi
    public JSONObject n(String str, JSONObject jSONObject) {
        if (this.qg != null) {
            return this.qg.n(str, jSONObject);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.fi
    public JSONObject n(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.qg != null) {
            return this.qg.n(str, jSONObject, jSONObject2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, jSONObject2);
        return (JSONObject) this.n.apply(sparseArray);
    }
}
