package com.anythink.basead.exoplayer.e.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    private static final String f = "TrackEncryptionBox";
    public final boolean a;
    public final String b;
    public final com.anythink.basead.exoplayer.e.m.a c;
    public final int d;
    public final byte[] e;

    public k(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        byte b = 0;
        int i4 = 1;
        com.anythink.basead.exoplayer.k.a.a((i == 0) ^ (bArr2 == null));
        this.a = z;
        this.b = str;
        this.d = i;
        this.e = bArr2;
        if (str != null) {
            str.hashCode();
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals(com.anythink.basead.exoplayer.b.be)) {
                        b = -1;
                    }
                    break;
                case 3046671:
                    b = !str.equals(com.anythink.basead.exoplayer.b.bg) ? (byte) -1 : (byte) 1;
                    break;
                case 3049879:
                    b = !str.equals(com.anythink.basead.exoplayer.b.bd) ? (byte) -1 : (byte) 2;
                    break;
                case 3049895:
                    b = !str.equals(com.anythink.basead.exoplayer.b.bf) ? (byte) -1 : (byte) 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                    i4 = 2;
                    break;
                case 2:
                case 3:
                    break;
                default:
                    Log.w(f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                    break;
            }
        }
        this.c = new com.anythink.basead.exoplayer.e.m.a(i4, bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(com.anythink.basead.exoplayer.b.be)) {
                    b = 0;
                }
                break;
            case 3046671:
                if (str.equals(com.anythink.basead.exoplayer.b.bg)) {
                    b = 1;
                }
                break;
            case 3049879:
                if (str.equals(com.anythink.basead.exoplayer.b.bd)) {
                    b = 2;
                }
                break;
            case 3049895:
                if (str.equals(com.anythink.basead.exoplayer.b.bf)) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return 2;
            default:
                Log.w(f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
