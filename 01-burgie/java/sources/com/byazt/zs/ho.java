package com.byazt.zs;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.vkw.er;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 19})
public class ho implements er, Function {
    public HashMap<String, AtomicReference<Object>> pr = new HashMap<>();
    public er hw = new com.byazt.cm.hn();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return pr();
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr((String) sparseArray.get(1));
            case 2:
                return Integer.valueOf(hw((String) sparseArray.get(1)));
            case 3:
                return Long.valueOf(hn((String) sparseArray.get(1)));
            case 4:
                return Boolean.valueOf(x((String) sparseArray.get(1)));
            case 5:
                pr((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
        }
    }

    public SparseArray pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.pr);
        return sparseArray;
    }

    public void pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.pr = (HashMap) obj;
        }
    }

    private Pair<AtomicReference<Object>, Boolean> c(String str) {
        AtomicReference<Object> atomicReference = this.pr.get(str);
        if (atomicReference == null) {
            AtomicReference<Object> atomicReference2 = new AtomicReference<>();
            this.pr.put(str, atomicReference2);
            return new Pair<>(atomicReference2, Boolean.TRUE);
        }
        return new Pair<>(atomicReference, Boolean.FALSE);
    }

    @Override // com.byazt.vkw.er
    public String pr(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(this.hw.pr(str));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    @Override // com.byazt.vkw.er
    public int hw(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Integer.valueOf(this.hw.hw(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vkw.er
    public long hn(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Long.valueOf(this.hw.hn(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vkw.er
    public boolean x(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Boolean.valueOf(this.hw.x(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vkw.er
    public void pr(String str, String str2) {
        this.hw.pr(str, str2);
    }
}
