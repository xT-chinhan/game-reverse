package com.smartdigimkt.l0;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final MediaCodec.CryptoInfo a;
    public final MediaCodec.CryptoInfo.Pattern b = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public b(MediaCodec.CryptoInfo cryptoInfo) {
        this.a = cryptoInfo;
    }

    public static void a(b bVar, int i, int i2) {
        bVar.b.set(i, i2);
        bVar.a.setPattern(bVar.b);
    }
}
