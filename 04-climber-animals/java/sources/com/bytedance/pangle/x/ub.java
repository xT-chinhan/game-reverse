package com.bytedance.pangle.x;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ub {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ub f727ms = new ub(null, 0, null, null, null);
    public final int ah;
    public final int[] c;
    public final ArraySet<PublicKey> d;
    public final Signature[] ka;
    public final Signature[] xr;

    public static ArraySet<PublicKey> ms(Signature[] signatureArr) throws CertificateException {
        Method method;
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                } catch (InvocationTargetException e3) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e3);
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e4);
                }
            }
        }
        return arraySet;
    }

    public static boolean ms(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.ms((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.ms((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean ms(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public ub(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.xr = signatureArr;
        this.ah = i;
        this.d = arraySet;
        this.ka = signatureArr2;
        this.c = iArr;
    }

    public ub(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, ms(signatureArr), signatureArr2, iArr);
    }

    public ub(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ub)) {
            return false;
        }
        ub ubVar = (ub) obj;
        if (this.ah != ubVar.ah || !ms(this.xr, ubVar.xr)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.d;
        if (arraySet != null) {
            if (!arraySet.equals(ubVar.d)) {
                return false;
            }
        } else if (ubVar.d != null) {
            return false;
        }
        return Arrays.equals(this.ka, ubVar.ka) && Arrays.equals(this.c, ubVar.c);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.xr) * 31) + this.ah) * 31;
        ArraySet<PublicKey> arraySet = this.d;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.ka)) * 31) + Arrays.hashCode(this.c);
    }
}
