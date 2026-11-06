package com.bytedance.sdk.component.c.d;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.c.u;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private byte[] f1186ms;
    private com.bytedance.sdk.component.c.c xr;

    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "decode";
    }

    public ka(byte[] bArr, com.bytedance.sdk.component.c.c cVar) {
        this.f1186ms = bArr;
        this.xr = cVar;
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        com.bytedance.sdk.component.c.ah.c cVarT = ahVar.t();
        com.bytedance.sdk.component.c.ah.xr.ms msVarMs = cVarT.ms(ahVar);
        try {
            u uVarRe = ahVar.re();
            if (uVarRe != null) {
                uVarRe.ms(10, null);
            }
            Bitmap bitmapMs = msVarMs.ms(this.f1186ms);
            if (bitmapMs != null) {
                ahVar.ms(new zb(bitmapMs, this.f1186ms, this.xr, false));
                cVarT.ms(ahVar.nw()).ms(ahVar.ab(), bitmapMs);
            } else {
                ms(1002, "decode failed bitmap null", null, ahVar);
            }
            if (uVarRe != null) {
                uVarRe.ms(11, bitmapMs);
            }
        } catch (Throwable th) {
            ms(1002, "decode failed:" + th.getMessage(), th, ahVar);
        }
    }

    private void ms(int i, String str, Throwable th, com.bytedance.sdk.component.c.ah.ah ahVar) {
        if (this.xr == null) {
            ahVar.ms(new hi());
        } else {
            ahVar.ms(new x(i, str, th));
        }
    }
}
