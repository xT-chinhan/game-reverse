package com.byazt.mh;

import android.util.SparseArray;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1196, 19})
public class n implements com.byazt.zh.n, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return n();
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(n((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            com.byazt.zh.s sVarQg = qg((String) sparseArray.get(1));
            return sVarQg != null ? new com.byazt.zh.q(sVarQg) : sVarQg;
        }
        if (iIntValue != 4) {
            return null;
        }
        return qg();
    }

    @Override // com.byazt.zh.n
    public Map<String, Map<String, Object>> n() {
        return qg.n();
    }

    @Override // com.byazt.zh.n
    public boolean n(String str) {
        return qg.n(str);
    }

    @Override // com.byazt.zh.n
    public com.byazt.zh.s qg(String str) {
        return q.n(str);
    }

    @Override // com.byazt.zh.n
    public Set<String> qg() {
        return q.n();
    }
}
