package com.byazt.ls;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 210})
public final class k {
    public static final k n = new k(null, 0, null, null, null);
    public final Signature[] l;
    public final ArraySet<PublicKey> q;
    public final Signature[] qg;
    public final int s;
    public final int[] w;

    public static ArraySet<PublicKey> n(Signature[] signatureArr) throws CertificateException {
        Method method;
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.byazt.vx.w.n(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.byazt.vx.w.n(e2);
                } catch (InvocationTargetException e3) {
                    com.byazt.vx.w.n(e3);
                } catch (Exception e4) {
                    com.byazt.vx.w.n(e4);
                }
            }
        }
        return arraySet;
    }

    public static boolean n(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.byazt.gx.q.n((Object[]) signatureArr, (Object[]) signatureArr2) && com.byazt.gx.q.n((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean n(byte[] bArr, byte[] bArr2) {
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

    public k(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.qg = signatureArr;
        this.s = i;
        this.q = arraySet;
        this.l = signatureArr2;
        this.w = iArr;
    }

    public k(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, n(signatureArr), signatureArr2, iArr);
    }

    public k(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.s != kVar.s || !n(this.qg, kVar.qg)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.q;
        if (arraySet != null) {
            if (!arraySet.equals(kVar.q)) {
                return false;
            }
        } else if (kVar.q != null) {
            return false;
        }
        return Arrays.equals(this.l, kVar.l) && Arrays.equals(this.w, kVar.w);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.qg) * 31) + this.s) * 31;
        ArraySet<PublicKey> arraySet = this.q;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.l)) * 31) + Arrays.hashCode(this.w);
    }
}
