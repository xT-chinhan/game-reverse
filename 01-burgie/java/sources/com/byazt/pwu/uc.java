package com.byazt.pwu;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, 5})
public class uc {
    public int[] hw;
    public int[] pr;

    public static uc pr(x xVar) throws IOException {
        hw.pr(xVar, 1835009);
        int iHw = xVar.hw();
        int iHw2 = xVar.hw();
        int iHw3 = xVar.hw();
        xVar.hw();
        int iHw4 = xVar.hw();
        int iHw5 = xVar.hw();
        uc ucVar = new uc();
        ucVar.pr = xVar.hw(iHw2);
        if (iHw3 != 0) {
            xVar.hw(iHw3);
        }
        int i = (iHw5 == 0 ? iHw : iHw5) - iHw4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        ucVar.hw = xVar.hw(i / 4);
        if (iHw5 != 0) {
            int i2 = iHw - iHw5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            xVar.hw(i2 / 4);
        }
        return ucVar;
    }

    public String pr(int i) {
        int[] iArr;
        if (i >= 0 && (iArr = this.pr) != null && i < iArr.length) {
            int i2 = iArr[i];
            int iPr = pr(this.hw, i2);
            StringBuilder sb = new StringBuilder(iPr);
            while (iPr != 0) {
                i2 += 2;
                sb.append((char) pr(this.hw, i2));
                iPr--;
            }
            return sb.toString();
        }
        return null;
    }

    private uc() {
    }

    private static final int pr(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & SupportMenu.USER_MASK : i2 >>> 16;
    }
}
