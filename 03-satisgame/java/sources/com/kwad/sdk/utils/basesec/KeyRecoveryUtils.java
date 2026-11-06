package com.kwad.sdk.utils.basesec;

import android.util.Log;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyRecoveryUtils {
    private static final String TAG = "KeyRecoveryUtils";

    static int getMaskB() {
        return 31;
    }

    static int getMaskC() {
        return 30;
    }

    static int getMaskA() {
        return ("com.kwad.sdk.utils.EncryptUtils".charAt(0) ^ "com.kwad.sdk.utils.EncryptUtils".charAt(10)) & 255;
    }

    public static byte[] recoverKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int maskA = getMaskA();
        int maskB = getMaskB();
        int maskC = getMaskC();
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        int length2 = bArr2.length;
        byte[] bArr5 = new byte[length2];
        int length3 = bArr3.length;
        byte[] bArr6 = new byte[length3];
        for (int i = 0; i < bArr.length; i++) {
            bArr4[i] = (byte) (((bArr[i] & UByte.MAX_VALUE) ^ maskA) ^ maskB);
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr5[i2] = (byte) (((bArr2[i2] & UByte.MAX_VALUE) ^ maskB) ^ maskC);
        }
        for (int i3 = 0; i3 < bArr3.length; i3++) {
            bArr6[i3] = (byte) (((bArr3[i3] & UByte.MAX_VALUE) ^ maskA) ^ maskC);
        }
        int length4 = bArr.length + bArr2.length + bArr3.length;
        byte[] bArr7 = new byte[length4];
        for (int i4 = 0; i4 < length; i4++) {
            bArr7[i4 * 3] = bArr4[i4];
        }
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = (i5 * 3) + 1;
            if (i6 < length4) {
                bArr7[i6] = bArr5[i5];
            }
        }
        for (int i7 = 0; i7 < length3; i7++) {
            int i8 = (i7 * 3) + 2;
            if (i8 < length4) {
                bArr7[i8] = bArr6[i7];
            }
        }
        return bArr7;
    }

    public static String recoverToString(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return new String(recoverKey(bArr, bArr2, bArr3), "UTF-8");
        } catch (Throwable th) {
            Log.e(TAG, "KeyRecoveryUtils recoverToString failed: " + th.getMessage());
            return "";
        }
    }

    private KeyRecoveryUtils() {
    }
}
