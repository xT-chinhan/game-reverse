package com.byazt.pm;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.ihe.aj;
import com.byazt.ihe.fw;
import com.byazt.ihe.hw;
import com.byazt.ihe.k;
import com.byazt.ihe.vk;
import com.byazt.vkw.n;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1369, 37})
public class pr implements n, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                fw fwVarPr = pr((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
                return fwVarPr != null ? new aj(fwVarPr) : fwVarPr;
            case 2:
                fw fwVarPr2 = pr((Context) sparseArray.get(1), (String) sparseArray.get(2));
                return fwVarPr2 != null ? new aj(fwVarPr2) : fwVarPr2;
            case 3:
                pr((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Integer) sparseArray.get(3)).intValue(), (String[]) sparseArray.get(4), (long[]) sparseArray.get(5), ((Boolean) sparseArray.get(6)).booleanValue());
                return null;
            case 4:
                return Boolean.valueOf(pr());
            case 5:
                pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 6:
                vk vkVarHw = hw();
                return vkVarHw != null ? new k(vkVarHw) : vkVarHw;
            case 7:
                com.byazt.ihe.pr prVarHn = hn();
                return prVarHn != null ? new hw(prVarHn) : prVarHn;
            case 8:
                return Integer.valueOf(x());
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.n
    public fw pr(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        return new com.byazt.ke.pr(context, z, j, jSONObject, looper);
    }

    @Override // com.byazt.vkw.n
    public fw pr(Context context, String str) {
        return new com.byazt.ms.hw(context, str);
    }

    @Override // com.byazt.vkw.n
    public void pr(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        com.byazt.ms.hw.pr(context, str, i, strArr, jArr, z);
    }

    @Override // com.byazt.vkw.n
    public boolean pr() {
        return com.byazt.ms.hw.pr();
    }

    @Override // com.byazt.vkw.n
    public void pr(boolean z) {
        com.byazt.ms.pr.pr(z);
    }

    @Override // com.byazt.vkw.n
    public vk hw() {
        return new com.byazt.fb.pr();
    }

    @Override // com.byazt.vkw.n
    public com.byazt.ihe.pr hn() {
        return new com.byazt.gn.pr();
    }

    @Override // com.byazt.vkw.n
    public int x() {
        return 0;
    }
}
