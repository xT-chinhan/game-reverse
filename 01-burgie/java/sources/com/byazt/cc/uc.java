package com.byazt.cc;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, 5})
public class uc {
    public int[] hw;
    public int[] pr;

    public static uc pr(hw hwVar) throws IOException {
        hwVar.hw(1835009);
        int iHw = hwVar.hw();
        int iHw2 = hwVar.hw();
        int iHw3 = hwVar.hw();
        hwVar.hw();
        int iHw4 = hwVar.hw();
        int iHw5 = hwVar.hw();
        uc ucVar = new uc();
        ucVar.pr = hwVar.pr(iHw2);
        if (iHw3 != 0) {
            hwVar.pr(iHw3);
        }
        int i = (iHw5 == 0 ? iHw : iHw5) - iHw4;
        if (i % 4 == 0) {
            ucVar.hw = hwVar.pr(i / 4);
            if (iHw5 != 0) {
                int i2 = iHw - iHw5;
                if (i2 % 4 == 0) {
                    hwVar.pr(i2 / 4);
                } else {
                    throw new IOException();
                }
            }
            return ucVar;
        }
        throw new IOException();
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
