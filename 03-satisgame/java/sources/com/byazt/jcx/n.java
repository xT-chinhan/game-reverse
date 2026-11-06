package com.byazt.jcx;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.ej.d;
import com.byazt.ej.qg;
import com.byazt.ej.rv;
import com.byazt.ej.tj;
import com.byazt.ej.x;
import com.byazt.vf.j;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2060, 19})
public class n implements j, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                x xVarN = n((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
                return xVarN != null ? new rv(xVarN) : xVarN;
            case 2:
                x xVarN2 = n((Context) sparseArray.get(1), (String) sparseArray.get(2));
                return xVarN2 != null ? new rv(xVarN2) : xVarN2;
            case 3:
                n((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Integer) sparseArray.get(3)).intValue(), (String[]) sparseArray.get(4), (long[]) sparseArray.get(5), ((Boolean) sparseArray.get(6)).booleanValue());
                return null;
            case 4:
                return Boolean.valueOf(n());
            case 5:
                n(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 6:
                tj tjVarQg = qg();
                return tjVarQg != null ? new d(tjVarQg) : tjVarQg;
            case 7:
                com.byazt.ej.n nVarS = s();
                return nVarS != null ? new qg(nVarS) : nVarS;
            case 8:
                return Integer.valueOf(q());
            default:
                return null;
        }
    }

    @Override // com.byazt.vf.j
    public int q() {
        return 0;
    }

    @Override // com.byazt.vf.j
    public x n(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        return new com.byazt.ix.n(context, z, j, jSONObject, looper);
    }

    @Override // com.byazt.vf.j
    public x n(Context context, String str) {
        return new com.byazt.rq.qg(context, str);
    }

    @Override // com.byazt.vf.j
    public void n(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        com.byazt.rq.qg.n(context, str, i, strArr, jArr, z);
    }

    @Override // com.byazt.vf.j
    public boolean n() {
        return com.byazt.rq.qg.n();
    }

    @Override // com.byazt.vf.j
    public void n(boolean z) {
        com.byazt.rq.n.n(z);
    }

    @Override // com.byazt.vf.j
    public tj qg() {
        return new com.byazt.fy.n();
    }

    @Override // com.byazt.vf.j
    public com.byazt.ej.n s() {
        return new com.byazt.ifq.n();
    }
}
