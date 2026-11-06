package com.tapsdk.tapad.internal.tracker.experiment.j;

import com.tapadn.lz4.LZ4Factory;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static byte[] a(byte[] bArr) {
        return LZ4Factory.fastestInstance().fastCompressor().compress(bArr);
    }

    public static byte[] a(byte[] bArr, int i) {
        return LZ4Factory.fastestInstance().fastDecompressor().decompress(bArr, i);
    }
}
