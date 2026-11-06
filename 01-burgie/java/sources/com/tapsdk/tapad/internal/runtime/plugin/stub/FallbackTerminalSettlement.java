package com.tapsdk.tapad.internal.runtime.plugin.stub;

/* JADX INFO: loaded from: classes3.dex */
final class FallbackTerminalSettlement {
    static final int CLOSED = 1;
    static final int DESTROYED = 3;
    static final int FAILED = 2;

    private FallbackTerminalSettlement() {
    }

    private static native int nativeSettle(byte[] bArr, int i);

    public static int settle(byte[] bArr, int i) {
        if (bArr != null && bArr.length != 0) {
            try {
                return nativeSettle(bArr, i);
            } catch (Throwable th) {
            }
        }
        return 2;
    }
}
