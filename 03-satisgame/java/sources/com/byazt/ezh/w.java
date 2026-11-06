package com.byazt.ezh;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 13})
public class w {
    public int[] n;
    public int[] qg;

    public static w n(qg qgVar) throws IOException {
        qgVar.qg(1835009);
        int iQg = qgVar.qg();
        int iQg2 = qgVar.qg();
        int iQg3 = qgVar.qg();
        qgVar.qg();
        int iQg4 = qgVar.qg();
        int iQg5 = qgVar.qg();
        w wVar = new w();
        wVar.n = qgVar.n(iQg2);
        if (iQg3 != 0) {
            qgVar.n(iQg3);
        }
        int i = (iQg5 == 0 ? iQg : iQg5) - iQg4;
        if (i % 4 == 0) {
            wVar.qg = qgVar.n(i / 4);
            if (iQg5 != 0) {
                int i2 = iQg - iQg5;
                if (i2 % 4 == 0) {
                    qgVar.n(i2 / 4);
                } else {
                    throw new IOException();
                }
            }
            return wVar;
        }
        throw new IOException();
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
