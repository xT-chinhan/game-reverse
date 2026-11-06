package com.bytedance.sdk.component.panglearmor.ms.xr;

import android.text.TextUtils;
import com.anythink.core.common.m.e;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.internal.utils.i;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    @DungeonFlag
    private static String ms(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(i.b).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void ms(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, ka.ms(list));
    }

    private static JSONObject ms(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        ms(jSONObject, "xml", arrayList, true);
        ms(jSONObject, "png", arrayList2, true);
        ms(jSONObject, AdnName.OTHER, arrayList3, true);
        return jSONObject;
    }

    private static JSONObject xr(List<ms> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (ms msVar : list) {
            if (msVar != null) {
                arrayList.add(ms(msVar.xr()));
                arrayList2.add(String.valueOf(msVar.ms()));
            }
        }
        ms(jSONObject, e.X, arrayList, false);
        ms(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    public static long ms(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j2;
            }
            j2 += (long) i;
        }
    }

    private static void ms(File file, List<ms> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                xr xrVarMs = ah.ms(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms.ms(xrVarMs, com.bytedance.sdk.component.panglearmor.ms.ms.ms.ms.ms(xrVarMs)));
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    public static JSONObject ms(File file) {
        JSONObject jSONObject;
        ZipFile zipFile;
        JSONObject jSONObject2;
        Enumeration<? extends ZipEntry> enumeration;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JSONObject jSONObject3 = new JSONObject();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        JSONObject jSONObject4 = new JSONObject();
        ms(file, arrayList10);
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    long jMs = 0;
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null) {
                            String name = zipEntryNextElement.getName();
                            if (!TextUtils.isEmpty(name) || !zipEntryNextElement.isDirectory()) {
                                String[] strArrSplit = name.split("/");
                                ArrayList arrayList11 = arrayList9;
                                ArrayList arrayList12 = arrayList10;
                                long size = zipEntryNextElement.getSize();
                                enumeration = enumerationEntries;
                                jSONObject2 = jSONObject3;
                                if (name.startsWith("res/drawable/")) {
                                    try {
                                        arrayList3 = arrayList8;
                                        if (name.length() > 13) {
                                            arrayList5.add(strArrSplit[2]);
                                        }
                                        arrayList2 = arrayList11;
                                        arrayList = arrayList12;
                                        arrayList8 = arrayList3;
                                        arrayList10 = arrayList;
                                        enumerationEntries = enumeration;
                                        arrayList9 = arrayList2;
                                        jSONObject3 = jSONObject2;
                                    } catch (Throwable unused) {
                                        jSONObject = jSONObject2;
                                        if (zipFile != null) {
                                            zipFile.close();
                                        }
                                        return jSONObject;
                                    }
                                } else {
                                    arrayList3 = arrayList8;
                                }
                                if (name.startsWith("res/") && strArrSplit.length == 2) {
                                    arrayList6.add(strArrSplit[1]);
                                } else if (name.startsWith("classes") && name.endsWith(".dex")) {
                                    jMs += ms(size, zipFile.getInputStream(zipEntryNextElement));
                                    arrayList9 = arrayList11;
                                    arrayList10 = arrayList12;
                                    enumerationEntries = enumeration;
                                    jSONObject3 = jSONObject2;
                                    arrayList8 = arrayList3;
                                } else if (name.startsWith("assets/") && strArrSplit.length >= 2) {
                                    arrayList4.add(strArrSplit[1]);
                                    if (name.startsWith("assets/assets/resources/native/") && strArrSplit.length >= 6 && jSONObject4.length() < 10) {
                                        if (!TextUtils.isEmpty(strArrSplit[4]) && !jSONObject4.has(strArrSplit[4])) {
                                            jSONObject4.put(strArrSplit[4], ms(size, zipFile.getInputStream(zipEntryNextElement)));
                                        } else if (jSONObject4.has(strArrSplit[4])) {
                                            jSONObject4.put(strArrSplit[4], jSONObject4.getLong(strArrSplit[4]) + ms(size, zipFile.getInputStream(zipEntryNextElement)));
                                        }
                                    }
                                } else {
                                    if (name.startsWith("lib/armeabi/") && name.length() > 12) {
                                        arrayList7.add(strArrSplit[2]);
                                    } else {
                                        if (name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                            arrayList8 = arrayList3;
                                            arrayList8.add(strArrSplit[2]);
                                            arrayList2 = arrayList11;
                                        } else {
                                            arrayList8 = arrayList3;
                                            if (name.startsWith("lib/arm64-v8a/") && name.length() > 14) {
                                                arrayList2 = arrayList11;
                                                arrayList2.add(strArrSplit[2]);
                                            } else {
                                                arrayList2 = arrayList11;
                                                if (((name.startsWith("META-INF/") && name.endsWith(".RSA")) || name.endsWith(".DSA") || name.endsWith(".EC")) && arrayList12.isEmpty()) {
                                                    try {
                                                        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                                        if (certificateFactory != null) {
                                                            for (Certificate certificate : certificateFactory.generateCertificates(zipFile.getInputStream(zipEntryNextElement))) {
                                                                if (certificate instanceof X509Certificate) {
                                                                    ms msVar = new ms(String.valueOf(((X509Certificate) certificate).getSubjectDN()), ((X509Certificate) certificate).getEncoded());
                                                                    arrayList = arrayList12;
                                                                    try {
                                                                        arrayList.add(msVar);
                                                                    } catch (CertificateException unused2) {
                                                                    }
                                                                } else {
                                                                    arrayList = arrayList12;
                                                                }
                                                                arrayList12 = arrayList;
                                                            }
                                                        }
                                                    } catch (CertificateException unused3) {
                                                    }
                                                }
                                            }
                                        }
                                        arrayList = arrayList12;
                                    }
                                    arrayList10 = arrayList;
                                    enumerationEntries = enumeration;
                                    arrayList9 = arrayList2;
                                    jSONObject3 = jSONObject2;
                                }
                                arrayList2 = arrayList11;
                                arrayList = arrayList12;
                                arrayList8 = arrayList3;
                                arrayList10 = arrayList;
                                enumerationEntries = enumeration;
                                arrayList9 = arrayList2;
                                jSONObject3 = jSONObject2;
                            }
                        }
                        jSONObject2 = jSONObject3;
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        enumeration = enumerationEntries;
                        arrayList10 = arrayList;
                        enumerationEntries = enumeration;
                        arrayList9 = arrayList2;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject2 = jSONObject3;
                    ArrayList arrayList13 = arrayList9;
                    ArrayList arrayList14 = arrayList10;
                    jSONObject = jSONObject2;
                    try {
                        jSONObject.put("apkSize", file.length());
                        jSONObject.put("dexSize", jMs);
                        if (jSONObject4.length() > 0) {
                            jSONObject.put("cocos", jSONObject4);
                        }
                        ms(jSONObject, "assets", arrayList4, false);
                        JSONObject jSONObject5 = new JSONObject();
                        ms(jSONObject5, "eabi", arrayList7, false);
                        ms(jSONObject5, "v7a", arrayList8, false);
                        ms(jSONObject5, "v8a", arrayList13, false);
                        if (jSONObject5.length() > 0) {
                            jSONObject.put("lib", jSONObject5);
                        }
                        JSONObject jSONObjectMs = ms(arrayList5);
                        if (jSONObjectMs != null && jSONObjectMs.length() > 0) {
                            jSONObject.put("drawable", jSONObjectMs);
                        }
                        JSONObject jSONObjectMs2 = ms(arrayList6);
                        if (jSONObjectMs2 != null && jSONObjectMs2.length() > 0) {
                            jSONObject.put("res", jSONObjectMs2);
                        }
                        JSONObject jSONObjectXr = xr(arrayList14);
                        if (jSONObjectXr.length() > 0) {
                            jSONObject.put("signInfo", jSONObjectXr);
                        }
                    } catch (Throwable unused4) {
                        if (zipFile != null) {
                        }
                        return jSONObject;
                    }
                } catch (Throwable unused5) {
                    jSONObject = jSONObject3;
                }
            } catch (Throwable unused6) {
                jSONObject = jSONObject3;
                zipFile = null;
            }
            zipFile.close();
        } catch (IOException unused7) {
        }
        return jSONObject;
    }
}
