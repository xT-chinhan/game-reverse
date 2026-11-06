package com.byazt.ls;

import android.content.pm.Signature;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 5})
public class q {
    public static k n(String str, int i) throws Throwable {
        int[] iArr;
        if (i > 3) {
            throw new hd(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    try {
                        w.n(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            s.C0241s c0241sN = s.n(randomAccessFile2, str);
                            Signature[] signatureArrN = n(new Certificate[][]{c0241sN.n});
                            if (c0241sN.qg != null) {
                                int size = c0241sN.qg.n.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[c0241sN.qg.qg.size()];
                                for (int i2 = 0; i2 < size; i2++) {
                                    signatureArr2[i2] = new Signature(c0241sN.qg.n.get(i2).getEncoded());
                                    iArr[i2] = c0241sN.qg.qg.get(i2).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            k kVar = new k(signatureArrN, 3, signatureArr, iArr);
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused) {
                            }
                            return kVar;
                        } catch (sz e) {
                            if (i >= 3) {
                                throw new hd(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e);
                            }
                            if (i > 2) {
                                throw new hd(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                k kVar2 = new k(n(qg.n(randomAccessFile2, str)), 2);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused2) {
                                }
                                return kVar2;
                            } catch (sz e2) {
                                if (i >= 2) {
                                    throw new hd(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e2);
                                }
                                if (i > 1) {
                                    throw new hd(4, "No signature found in package of version " + i + " or newer for package " + str);
                                }
                                k kVarN = n.n(str, true);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused3) {
                                }
                                return kVarN;
                            } catch (Exception e3) {
                                throw new hd(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                            }
                        } catch (Exception e4) {
                            throw new hd(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
                        }
                    } catch (Exception e5) {
                        throw new hd(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
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
            throw new hd(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] n(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.byazt.gx.rv.s()) {
                Constructor constructorN = com.byazt.hx.n.n((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorN != null) {
                    constructorN.setAccessible(true);
                }
                if (constructorN != null && constructorN.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorN.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.byazt.vx.w.n(e);
                    } catch (InstantiationException e2) {
                        com.byazt.vx.w.n(e2);
                    } catch (InvocationTargetException e3) {
                        com.byazt.vx.w.n(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
