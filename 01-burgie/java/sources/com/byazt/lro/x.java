package com.byazt.lro;

import android.content.pm.Signature;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 121})
public class x {
    public static ho pr(String str, int i) throws Throwable {
        Throwable th;
        int[] iArr;
        if (i > 3) {
            throw new yb(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    try {
                        uc.pr(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            hn.C0125hn c0125hnPr = hn.pr(randomAccessFile2, str);
                            Signature[] signatureArrPr = pr(new Certificate[][]{c0125hnPr.pr});
                            if (c0125hnPr.hw != null) {
                                int size = c0125hnPr.hw.pr.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[c0125hnPr.hw.hw.size()];
                                for (int i2 = 0; i2 < size; i2++) {
                                    signatureArr2[i2] = new Signature(c0125hnPr.hw.pr.get(i2).getEncoded());
                                    iArr[i2] = c0125hnPr.hw.hw.get(i2).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            ho hoVar = new ho(signatureArrPr, 3, signatureArr, iArr);
                            try {
                                randomAccessFile2.close();
                            } catch (Exception e) {
                            }
                            return hoVar;
                        } catch (g e2) {
                            if (i >= 3) {
                                throw new yb(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e2);
                            }
                            if (i > 2) {
                                throw new yb(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                try {
                                    ho hoVar2 = new ho(pr(hw.pr(randomAccessFile2, str)), 2);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception e3) {
                                    }
                                    return hoVar2;
                                } catch (Exception e4) {
                                    throw new yb(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e4);
                                }
                            } catch (g e5) {
                                if (i >= 2) {
                                    throw new yb(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e5);
                                }
                                if (i > 1) {
                                    throw new yb(4, "No signature found in package of version " + i + " or newer for package " + str);
                                }
                                ho hoVarPr = pr.pr(str, true);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception e6) {
                                }
                                return hoVarPr;
                            }
                        } catch (Exception e7) {
                            throw new yb(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e7);
                        }
                    } catch (Exception e8) {
                        throw new yb(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e8);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (Exception e9) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e10) {
            throw new yb(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] pr(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.byazt.gs.aj.hn()) {
                Constructor constructorPr = com.byazt.gy.pr.pr((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorPr != null) {
                    constructorPr.setAccessible(true);
                }
                if (constructorPr != null && constructorPr.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorPr.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.byazt.dea.uc.pr(e);
                    } catch (InstantiationException e2) {
                        com.byazt.dea.uc.pr(e2);
                    } catch (InvocationTargetException e3) {
                        com.byazt.dea.uc.pr(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
