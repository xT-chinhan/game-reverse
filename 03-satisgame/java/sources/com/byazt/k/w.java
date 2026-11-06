package com.byazt.k;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 13})
public class w {
    public int[] n;
    public int[] qg;

    public static w n(q qVar) throws IOException {
        qg.n(qVar, 1835009);
        int iQg = qVar.qg();
        int iQg2 = qVar.qg();
        int iQg3 = qVar.qg();
        qVar.qg();
        int iQg4 = qVar.qg();
        int iQg5 = qVar.qg();
        w wVar = new w();
        wVar.n = qVar.qg(iQg2);
        if (iQg3 != 0) {
            qVar.qg(iQg3);
        }
        int i = (iQg5 == 0 ? iQg : iQg5) - iQg4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        wVar.qg = qVar.qg(i / 4);
        if (iQg5 != 0) {
            int i2 = iQg - iQg5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            qVar.qg(i2 / 4);
        }
        return wVar;
    }

    public String n(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.n) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iN = n(this.qg, i2);
        StringBuilder sb = new StringBuilder(iN);
        while (iN != 0) {
            i2 += 2;
            sb.append((char) n(this.qg, i2));
            iN--;
        }
        return sb.toString();
    }

    private w() {
    }

    private static final int n(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & SupportMenu.USER_MASK : i2 >>> 16;
    }
}
