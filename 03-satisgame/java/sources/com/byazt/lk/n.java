package com.byazt.lk;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.vf.hd;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1266, 19})
public final class n implements hd, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return n((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
        }
        if (iIntValue == 2) {
            return qg((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
        }
        if (iIntValue == 3) {
            return s((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
        }
        if (iIntValue == 4) {
            return n((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (String) sparseArray.get(4));
        }
        if (iIntValue != 5) {
            return null;
        }
        return q((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), (String) sparseArray.get(3));
    }

    @Override // com.byazt.vf.hd
    public File n(Context context, boolean z, String str) {
        File fileN;
        if (context == null || (fileN = com.byazt.qyu.qg.n(context)) == null) {
            return null;
        }
        return (!z || str == null || str.length() <= 0) ? fileN : new File(fileN.getParent(), fileN.getName() + "_" + str);
    }

    @Override // com.byazt.vf.hd
    public File qg(Context context, boolean z, String str) {
        File fileS;
        if (context == null || (fileS = com.byazt.qyu.qg.s(context)) == null) {
            return null;
        }
        return (!z || str == null || str.length() <= 0) ? fileS : new File(fileS.getParent(), fileS.getName() + "_" + str);
    }

    @Override // com.byazt.vf.hd
    public File s(Context context, boolean z, String str) {
        return n(context, null, z, str);
    }

    @Override // com.byazt.vf.hd
    public File n(Context context, String str, boolean z, String str2) {
        File fileN;
        if (context == null || (fileN = com.byazt.qyu.qg.n(context, str)) == null) {
            return null;
        }
        return (!z || str2 == null || str2.length() <= 0) ? fileN : new File(fileN.getParent(), fileN.getName() + "_" + str2);
    }

    @Override // com.byazt.vf.hd
    public File q(Context context, boolean z, String str) {
        File fileQ;
        if (context == null || (fileQ = com.byazt.qyu.qg.q(context)) == null) {
            return null;
        }
        return (!z || str == null || str.length() <= 0) ? fileQ : new File(fileQ.getParent(), fileQ.getName() + "_" + str);
    }
}
