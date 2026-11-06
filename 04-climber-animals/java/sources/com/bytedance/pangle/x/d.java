package com.bytedance.pangle.x;

import android.content.pm.Signature;
import com.kuaishou.weapon.p0.t;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static ub ms(String str, int i) throws Throwable {
        int[] iArr;
        if (i > 3) {
            throw new h(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
                try {
                    try {
                        c.ms(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            try {
                                ah.C0228ah c0228ahMs = ah.ms(randomAccessFile2, str);
                                Signature[] signatureArrMs = ms(new Certificate[][]{c0228ahMs.f718ms});
                                if (c0228ahMs.xr != null) {
                                    int size = c0228ahMs.xr.f719ms.size();
                                    Signature[] signatureArr2 = new Signature[size];
                                    iArr = new int[c0228ahMs.xr.xr.size()];
                                    for (int i2 = 0; i2 < size; i2++) {
                                        signatureArr2[i2] = new Signature(c0228ahMs.xr.f719ms.get(i2).getEncoded());
                                        iArr[i2] = c0228ahMs.xr.xr.get(i2).intValue();
                                    }
                                    signatureArr = signatureArr2;
                                } else {
                                    iArr = null;
                                }
                                ub ubVar = new ub(signatureArrMs, 3, signatureArr, iArr);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused) {
                                }
                                return ubVar;
                            } catch (Exception e) {
                                throw new h(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e);
                            }
                        } catch (u e2) {
                            if (i >= 3) {
                                throw new h(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e2);
                            }
                            if (i > 2) {
                                throw new h(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                try {
                                    ub ubVar2 = new ub(ms(xr.ms(randomAccessFile2, str)), 2);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused2) {
                                    }
                                    return ubVar2;
                                } catch (Exception e3) {
                                    throw new h(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                                }
                            } catch (u e4) {
                                if (i >= 2) {
                                    throw new h(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e4);
                                }
                                if (i > 1) {
                                    throw new h(4, "No signature found in package of version " + i + " or newer for package " + str);
                                }
                                ub ubVarMs = ms.ms(str, true);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused3) {
                                }
                                return ubVarMs;
                            }
                        }
                    } catch (Exception e5) {
                        throw new h(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            throw new h(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] ms(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.bytedance.pangle.util.ny.d()) {
                Constructor constructorMs = com.bytedance.pangle.xr.xr.ms.ms((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorMs != null) {
                    constructorMs.setAccessible(true);
                }
                if (constructorMs != null && constructorMs.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorMs.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    } catch (InstantiationException e2) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                    } catch (InvocationTargetException e3) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
