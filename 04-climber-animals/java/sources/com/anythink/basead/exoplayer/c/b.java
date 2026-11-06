package com.anythink.basead.exoplayer.c;

import android.media.MediaCodec;
import com.anythink.basead.exoplayer.k.af;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    public b() {
        MediaCodec.CryptoInfo cryptoInfo = af.a >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.i = cryptoInfo;
        this.j = af.a >= 24 ? new a(cryptoInfo, (byte) 0) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        if (af.a >= 16) {
            this.i.numSubSamples = this.f;
            this.i.numBytesOfClearData = this.d;
            this.i.numBytesOfEncryptedData = this.e;
            this.i.key = this.b;
            this.i.iv = this.a;
            this.i.mode = this.c;
            if (af.a >= 24) {
                a.a(this.j, this.g, this.h);
            }
        }
    }

    public final MediaCodec.CryptoInfo a() {
        return this.i;
    }

    private static MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    private void c() {
        this.i.numSubSamples = this.f;
        this.i.numBytesOfClearData = this.d;
        this.i.numBytesOfEncryptedData = this.e;
        this.i.key = this.b;
        this.i.iv = this.a;
        this.i.mode = this.c;
        if (af.a >= 24) {
            a.a(this.j, this.g, this.h);
        }
    }

    private static final class a {
        private final MediaCodec.CryptoInfo a;
        private final MediaCodec.CryptoInfo.Pattern b;

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        private void a(int i, int i2) {
            this.b.set(i, i2);
            this.a.setPattern(this.b);
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            aVar.b.set(i, i2);
            aVar.a.setPattern(aVar.b);
        }
    }
}
