package com.bytedance.pangle.ab.ms;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int[] f612ms;
    private int[] xr;

    public static c ms(xr xrVar) throws IOException {
        xrVar.xr(1835009);
        int iXr = xrVar.xr();
        int iXr2 = xrVar.xr();
        int iXr3 = xrVar.xr();
        xrVar.xr();
        int iXr4 = xrVar.xr();
        int iXr5 = xrVar.xr();
        c cVar = new c();
        cVar.f612ms = xrVar.ms(iXr2);
        if (iXr3 != 0) {
            xrVar.ms(iXr3);
        }
        int i = (iXr5 == 0 ? iXr : iXr5) - iXr4;
        if (i % 4 == 0) {
            cVar.xr = xrVar.ms(i / 4);
            if (iXr5 != 0) {
                int i2 = iXr - iXr5;
                if (i2 % 4 == 0) {
                    xrVar.ms(i2 / 4);
                } else {
                    throw new IOException();
                }
            }
            return cVar;
        }
        throw new IOException();
    }

    public String ms(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.f612ms) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iMs = ms(this.xr, i2);
        StringBuilder sb = new StringBuilder(iMs);
        while (iMs != 0) {
            i2 += 2;
            sb.append((char) ms(this.xr, i2));
            iMs--;
        }
        return sb.toString();
    }

    private c() {
    }

    private static final int ms(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & SupportMenu.USER_MASK : i2 >>> 16;
    }
}
