package com.bytedance.pangle.x;

import android.content.pm.Signature;
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
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final AtomicReference<byte[]> f724ms = new AtomicReference<>();

    public static ub ms(String str, boolean z) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new h(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] certificateArrMs = ms(jarFile2, jarEntry);
                    if (com.bytedance.pangle.util.d.ms(certificateArrMs)) {
                        throw new h(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] signatureArrMs = d.ms(certificateArrMs);
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
                            Certificate[][] certificateArrMs2 = ms(jarFile2, jarEntry2);
                            if (com.bytedance.pangle.util.d.ms(certificateArrMs2)) {
                                throw new h(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                            if (!ub.ms(signatureArrMs, d.ms(certificateArrMs2))) {
                                throw new h(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    ub ubVar = new ub(signatureArrMs, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception unused) {
                    }
                    return ubVar;
                } catch (IOException e) {
                    e = e;
                    throw new h(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e2) {
                    e = e2;
                    throw new h(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    throw new h(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (RuntimeException e5) {
            e = e5;
        } catch (GeneralSecurityException e6) {
            e = e6;
        }
    }

    private static Certificate[][] ms(JarFile jarFile, JarEntry jarEntry) throws h {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                ms(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e3) {
            throw new h(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e3);
        }
    }

    private static void ms(InputStream inputStream) throws IOException {
        byte[] andSet = f724ms.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        f724ms.set(andSet);
    }
}
