package com.byazt.lro;

import android.content.pm.Signature;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 37})
public class pr {
    public static final AtomicReference<byte[]> pr = new AtomicReference<>();

    public static ho pr(String str, boolean z) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new yb(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] certificateArrPr = pr(jarFile2, jarEntry);
                    if (com.byazt.gs.x.pr(certificateArrPr)) {
                        throw new yb(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] signatureArrPr = x.pr(certificateArrPr);
                    if (z) {
                        Enumeration<JarEntry> enumerationEntries = jarFile2.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            if (!jarEntryNextElement.isDirectory()) {
                                String name = jarEntryNextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                    arrayList.add(jarEntryNextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] certificateArrPr2 = pr(jarFile2, jarEntry2);
                            if (com.byazt.gs.x.pr(certificateArrPr2)) {
                                throw new yb(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                            if (!ho.pr(signatureArrPr, x.pr(certificateArrPr2))) {
                                throw new yb(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    ho hoVar = new ho(signatureArrPr, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception e) {
                    }
                    return hoVar;
                } catch (IOException e2) {
                    e = e2;
                    throw new yb(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e3) {
                    e = e3;
                    throw new yb(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e4) {
                    e = e4;
                    throw new yb(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (RuntimeException e7) {
            e = e7;
        } catch (GeneralSecurityException e8) {
            e = e8;
        }
    }

    private static Certificate[][] pr(JarFile jarFile, JarEntry jarEntry) throws yb {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                pr(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e5) {
            throw new yb(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e5);
        }
    }

    private static void pr(InputStream inputStream) throws IOException {
        byte[] andSet = pr.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        pr.set(andSet);
    }
}
