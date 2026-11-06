package com.byazt.lro;

import android.content.pm.Signature;
import android.util.ArraySet;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 19})
public final class ho {
    public static final ho pr = new ho(null, 0, null, null, null);
    public final Signature[] c;
    public final int hn;
    public final Signature[] hw;
    public final int[] uc;
    public final ArraySet<PublicKey> x;

    public static ArraySet<PublicKey> pr(Signature[] signatureArr) throws CertificateException {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.byazt.dea.uc.pr(e);
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.byazt.dea.uc.pr(e2);
                } catch (InvocationTargetException e3) {
                    com.byazt.dea.uc.pr(e3);
                } catch (Exception e4) {
                    com.byazt.dea.uc.pr(e4);
                }
            }
        }
        return arraySet;
    }

    public static boolean pr(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.byazt.gs.x.pr((Object[]) signatureArr, (Object[]) signatureArr2) && com.byazt.gs.x.pr((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean pr(byte[] bArr, byte[] bArr2) {
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

    public ho(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.hw = signatureArr;
        this.hn = i;
        this.x = arraySet;
        this.c = signatureArr2;
        this.uc = iArr;
    }

    public ho(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, pr(signatureArr), signatureArr2, iArr);
    }

    public ho(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ho)) {
            return false;
        }
        ho hoVar = (ho) obj;
        if (this.hn != hoVar.hn || !pr(this.hw, hoVar.hw)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.x;
        if (arraySet != null) {
            if (!arraySet.equals(hoVar.x)) {
                return false;
            }
        } else if (hoVar.x != null) {
            return false;
        }
        return Arrays.equals(this.c, hoVar.c) && Arrays.equals(this.uc, hoVar.uc);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.hw) * 31) + this.hn) * 31;
        ArraySet<PublicKey> arraySet = this.x;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.uc);
    }
}
