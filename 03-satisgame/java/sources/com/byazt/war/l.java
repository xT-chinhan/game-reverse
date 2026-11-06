package com.byazt.war;

import android.graphics.Bitmap;
import com.byazt.si.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 18})
public class l extends n {
    public byte[] n;
    public com.byazt.si.x qg;

    @Override // com.byazt.war.rv
    public String n() {
        return "decode";
    }

    public l(byte[] bArr, com.byazt.si.x xVar) {
        this.n = bArr;
        this.qg = xVar;
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        com.byazt.gxb.w wVarPy = sVar.py();
        com.byazt.gms.n nVarN = wVarPy.n(sVar);
        try {
            a aVarM = sVar.m();
            if (aVarM != null) {
                aVarM.n(10, null);
            }
            Bitmap bitmapN = nVarN.n(this.n);
            if (bitmapN != null) {
                sVar.n(new sz(bitmapN, this.n, this.qg, false));
                String strX = sVar.x();
                if (!sVar.hd() || sVar.ou().s()) {
                    wVarPy.n(sVar.ou()).n(strX, bitmapN);
                }
            } else {
                n(1002, "decode failed bitmap null", null, sVar);
            }
            if (aVarM != null) {
                aVarM.n(11, bitmapN);
            }
        } catch (Throwable th) {
            n(1002, "decode failed:" + th.getMessage(), th, sVar);
        }
    }

    private void n(int i, String str, Throwable th, com.byazt.gxb.s sVar) {
        if (this.qg == null) {
            sVar.n(new cp());
        } else {
            sVar.n(new fs(i, str, th));
        }
    }
}
