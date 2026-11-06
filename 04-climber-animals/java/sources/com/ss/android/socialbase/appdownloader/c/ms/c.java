package com.ss.android.socialbase.appdownloader.c.ms;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int[] f4565ms;
    private int[] xr;

    public static c ms(d dVar) throws IOException {
        xr.ms(dVar, 1835009);
        int iXr = dVar.xr();
        int iXr2 = dVar.xr();
        int iXr3 = dVar.xr();
        dVar.xr();
        int iXr4 = dVar.xr();
        int iXr5 = dVar.xr();
        c cVar = new c();
        cVar.f4565ms = dVar.xr(iXr2);
        if (iXr3 != 0) {
            dVar.xr(iXr3);
        }
        int i = (iXr5 == 0 ? iXr : iXr5) - iXr4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        cVar.xr = dVar.xr(i / 4);
        if (iXr5 != 0) {
            int i2 = iXr - iXr5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            dVar.xr(i2 / 4);
        }
        return cVar;
    }

    public String ms(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.f4565ms) == null || i >= iArr.length) {
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
