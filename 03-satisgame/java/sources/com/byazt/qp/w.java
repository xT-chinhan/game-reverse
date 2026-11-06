package com.byazt.qp;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 13})
public class w implements com.byazt.vf.k, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                n();
                return null;
            case 2:
                return Boolean.valueOf(qg());
            case 3:
                return Integer.valueOf(s());
            case 4:
                return n((byte[]) sparseArray.get(1));
            case 5:
                return qg((byte[]) sparseArray.get(1));
            case 6:
                return n((String) sparseArray.get(1));
            case 7:
                return qg((String) sparseArray.get(1));
            case 8:
                return s((String) sparseArray.get(1));
            case 9:
                return q((String) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.vf.k
    public void n() {
        com.byazt.tka.d.n();
    }

    @Override // com.byazt.vf.k
    public boolean qg() {
        return com.byazt.tka.d.qg();
    }

    @Override // com.byazt.vf.k
    public int s() {
        return com.byazt.tka.d.s();
    }

    @Override // com.byazt.vf.k
    public byte[] n(byte[] bArr) {
        return com.byazt.tka.d.n().n(bArr);
    }

    @Override // com.byazt.vf.k
    public byte[] qg(byte[] bArr) {
        return com.byazt.tka.d.n().qg(bArr);
    }

    @Override // com.byazt.vf.k
    public String n(String str) {
        return com.byazt.tka.d.n().n(str);
    }

    @Override // com.byazt.vf.k
    public String qg(String str) {
        return com.byazt.tka.d.n().qg(str);
    }

    @Override // com.byazt.vf.k
    public String s(String str) {
        com.byazt.tka.d.n();
        return com.byazt.tka.d.s(str);
    }

    @Override // com.byazt.vf.k
    public String q(String str) {
        com.byazt.tka.d.n();
        return com.byazt.tka.d.q(str);
    }
}
