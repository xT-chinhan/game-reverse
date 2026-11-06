package com.byazt.qp;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.vf.u;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 110})
public class sz implements u, Function {
    public HashMap<String, AtomicReference<Object>> n = new HashMap<>();
    public u qg = new com.byazt.rsb.s();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            n((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return n();
        }
        if (iIntValue == 1) {
            return n((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return Integer.valueOf(qg((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            return Long.valueOf(s((String) sparseArray.get(1)));
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(q((String) sparseArray.get(1)));
        }
        if (iIntValue != 5) {
            return null;
        }
        n((String) sparseArray.get(1), (String) sparseArray.get(2));
        return null;
    }

    public SparseArray n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.n);
        return sparseArray;
    }

    public void n(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.n = (HashMap) obj;
        }
    }

    private Pair<AtomicReference<Object>, Boolean> l(String str) {
        AtomicReference<Object> atomicReference = this.n.get(str);
        if (atomicReference == null) {
            AtomicReference<Object> atomicReference2 = new AtomicReference<>();
            this.n.put(str, atomicReference2);
            return new Pair<>(atomicReference2, Boolean.TRUE);
        }
        return new Pair<>(atomicReference, Boolean.FALSE);
    }

    @Override // com.byazt.vf.u
    public String n(String str) {
        Pair<AtomicReference<Object>, Boolean> pairL = l(str);
        if (((Boolean) pairL.second).booleanValue()) {
            ((AtomicReference) pairL.first).set(this.qg.n(str));
        }
        Object obj = ((AtomicReference) pairL.first).get();
        return obj != null ? obj.toString() : "";
    }

    @Override // com.byazt.vf.u
    public int qg(String str) {
        Pair<AtomicReference<Object>, Boolean> pairL = l(str);
        if (((Boolean) pairL.second).booleanValue()) {
            ((AtomicReference) pairL.first).set(Integer.valueOf(this.qg.qg(str)));
        }
        Object obj = ((AtomicReference) pairL.first).get();
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.u
    public long s(String str) {
        Pair<AtomicReference<Object>, Boolean> pairL = l(str);
        if (((Boolean) pairL.second).booleanValue()) {
            ((AtomicReference) pairL.first).set(Long.valueOf(this.qg.s(str)));
        }
        Object obj = ((AtomicReference) pairL.first).get();
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vf.u
    public boolean q(String str) {
        Pair<AtomicReference<Object>, Boolean> pairL = l(str);
        if (((Boolean) pairL.second).booleanValue()) {
            ((AtomicReference) pairL.first).set(Boolean.valueOf(this.qg.q(str)));
        }
        Object obj = ((AtomicReference) pairL.first).get();
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.u
    public void n(String str, String str2) {
        this.qg.n(str, str2);
    }
}
