package com.byazt.kf;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, 8})
public abstract class s extends com.byazt.sg.s {
    public Function<SparseArray<Object>, Object> cp;
    public com.byazt.pl.qg tj;

    @Override // com.byazt.sg.s
    public boolean l() {
        return false;
    }

    public s(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        this.tj = qgVar;
        this.cp = function;
    }

    @Override // com.byazt.sg.s
    public Integer w() {
        com.byazt.pl.qg qgVar = this.tj;
        if (qgVar != null) {
            return qgVar.tj();
        }
        return super.w();
    }

    @Override // com.byazt.sg.s
    public void hd() {
        super.hd();
        com.byazt.pl.qg qgVar = this.tj;
        if (qgVar != null) {
            qgVar.d();
        }
    }

    @Override // com.byazt.sg.s
    public void cy() {
        super.cy();
        com.byazt.pl.qg qgVar = this.tj;
        if (qgVar != null) {
            qgVar.cp();
        }
    }

    @Override // com.byazt.sg.s
    public void cd() {
        super.cd();
        com.byazt.pl.qg qgVar = this.tj;
        if (qgVar != null) {
            qgVar.oa();
        }
    }

    @Override // com.byazt.sg.s
    public void n(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int i = 10001;
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue > 0) {
                i = iIntValue;
            }
        } catch (Exception unused) {
        }
        n(false, -1.0d, i, null);
    }

    @Override // com.byazt.sg.s
    public void qg(Map<String, Object> map) {
        n(true, ta(), -1, null);
    }

    public void n(boolean z, double d, int i, Map<String, Object> map) {
        com.byazt.pl.qg qgVar = this.tj;
        if (qgVar != null) {
            qgVar.n(z, d, i, map);
        }
    }
}
