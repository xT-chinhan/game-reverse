package com.smartdigimkt.l0;

import android.media.MediaCodec;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public final MediaCodec.CryptoInfo d;
    public final b e;

    public c() {
        int i = u.a;
        MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.d = cryptoInfo;
        this.e = i >= 24 ? new b(cryptoInfo) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.b = iArr;
        this.c = iArr2;
        this.a = bArr2;
        int i5 = u.a;
        if (i5 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.d;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i2;
            if (i5 >= 24) {
                b.a(this.e, i3, i4);
            }
        }
    }
}
