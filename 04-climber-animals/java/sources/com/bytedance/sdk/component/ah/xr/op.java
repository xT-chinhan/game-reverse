package com.bytedance.sdk.component.ah.xr;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class op {
    public abstract nw ms();

    public abstract void ms(com.bytedance.sdk.component.ah.ms.d dVar) throws IOException;

    public long xr() throws IOException {
        return -1L;
    }

    public static op ms(nw nwVar, String str) {
        Charset charsetAh = com.bytedance.sdk.component.ah.xr.ms.ah.ka;
        if (nwVar != null && (charsetAh = nwVar.ah()) == null) {
            charsetAh = com.bytedance.sdk.component.ah.xr.ms.ah.ka;
            nwVar = nw.ms(nwVar + "; charset=utf-8");
        }
        return ms(nwVar, str.getBytes(charsetAh));
    }

    public static op ms(nw nwVar, byte[] bArr) {
        return ms(nwVar, bArr, 0, bArr.length);
    }

    public static op ms(final nw nwVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(bArr.length, i, i2);
        return new op() { // from class: com.bytedance.sdk.component.ah.xr.op.1
            @Override // com.bytedance.sdk.component.ah.xr.op
            public nw ms() {
                return nwVar;
            }

            @Override // com.bytedance.sdk.component.ah.xr.op
            public long xr() {
                return i2;
            }

            @Override // com.bytedance.sdk.component.ah.xr.op
            public void ms(com.bytedance.sdk.component.ah.ms.d dVar) throws IOException {
                dVar.ah(bArr, i, i2);
            }
        };
    }
}
