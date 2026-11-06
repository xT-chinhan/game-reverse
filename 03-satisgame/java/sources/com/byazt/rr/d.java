package com.byazt.rr;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 180, 113})
public class d implements cp, Function {
    public volatile Function n;
    public volatile cp qg;

    public d(cp cpVar) {
        this.qg = cpVar;
    }

    public d(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        Object obj3 = sparseArray.get(2);
        Object obj4 = sparseArray.get(3);
        Object qVar = sparseArray.get(4);
        Object obj5 = sparseArray.get(5);
        Object tjVar = sparseArray.get(6);
        if (qVar != null) {
            qVar = new q((Function) qVar);
        }
        if (tjVar != null) {
            tjVar = new tj((Function) tjVar);
        }
        this.qg.n((String) obj2, ((Boolean) obj3).booleanValue(), ((Long) obj4).longValue(), (s) qVar, (JSONObject) obj5, (rv) tjVar);
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

    @Override // com.byazt.rr.cp
    public void n(String str, boolean z, long j, s sVar, JSONObject jSONObject, rv rvVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, Long.valueOf(j));
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(4, sVar);
        sparseArray.put(5, jSONObject);
        if (rvVar != null) {
            rvVar = new tj(rvVar);
        }
        sparseArray.put(6, rvVar);
        this.n.apply(sparseArray);
    }
}
