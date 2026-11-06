package com.byazt.ly;

import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
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
@com.byazt.vzx.pr(pr = {0, 1, 406, 5})
public class uc {
    @DungeonFlag
    private static String pr(byte[] bArr) {
        if (bArr != null) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }
        return null;
    }

    public static void pr(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject != null && list != null && !list.isEmpty()) {
            if (z) {
                try {
                    jSONObject.put(str + "Size", list.size());
                } catch (JSONException e) {
                    return;
                }
            }
            jSONObject.put(str, c.pr(list));
        }
    }

    private static JSONObject pr(List<String> list) {
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
        pr(jSONObject, "xml", arrayList, true);
        pr(jSONObject, "png", arrayList2, true);
        pr(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    private static JSONObject hw(List<pr> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (pr prVar : list) {
            if (prVar != null) {
                arrayList.add(pr(prVar.hw()));
                arrayList2.add(String.valueOf(prVar.pr()));
            }
        }
        pr(jSONObject, "sign", arrayList, false);
        pr(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    public static long pr(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        long j2 = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                j2 += (long) i;
            } else {
                return j2;
            }
        }
    }

    private static void pr(File file, List<pr> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                hw hwVarPr = hn.pr(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.byazt.pd.pr.pr(hwVarPr, com.byazt.cd.pr.pr(hwVarPr)));
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
        } catch (Throwable th4) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x02a9 A[Catch: IOException -> 0x02ad, TRY_LEAVE, TryCatch #5 {IOException -> 0x02ad, blocks: (B:133:0x02a9, B:123:0x0297), top: B:149:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x00d1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0094 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ac A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b4 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d9 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x013e A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0146 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x015a A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0162 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0176 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x017e A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0192 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x019c A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01a4 A[Catch: all -> 0x029d, TryCatch #6 {all -> 0x029d, blocks: (B:18:0x0080, B:20:0x0088, B:21:0x0094, B:23:0x009c, B:25:0x00a0, B:26:0x00ac, B:28:0x00b4, B:30:0x00bc, B:31:0x00d1, B:33:0x00d9, B:35:0x00dd, B:37:0x00eb, B:39:0x00ef, B:41:0x00f7, B:43:0x0100, B:45:0x0108, B:46:0x011b, B:48:0x0123, B:50:0x013e, B:52:0x0146, B:54:0x014e, B:55:0x015a, B:57:0x0162, B:59:0x016a, B:60:0x0176, B:62:0x017e, B:64:0x0186, B:65:0x0192, B:67:0x019c, B:75:0x01b8, B:77:0x01be, B:79:0x01c6, B:80:0x01d2, B:82:0x01d8, B:84:0x01e2, B:86:0x01fa, B:69:0x01a4, B:71:0x01ac, B:102:0x0226), top: B:151:0x0080 }] */
    @DungeonFlag
    public static JSONObject pr(File file) {
        JSONObject jSONObject;
        ZipFile zipFile;
        JSONObject jSONObject2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Enumeration<? extends ZipEntry> enumeration;
        JSONObject jSONObject3 = new JSONObject();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        JSONObject jSONObject4 = new JSONObject();
        pr(file, arrayList9);
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    long jPr = 0;
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            jSONObject2 = jSONObject3;
                            arrayList = arrayList8;
                            arrayList2 = arrayList9;
                            enumeration = enumerationEntries;
                        } else {
                            String name = zipEntryNextElement.getName();
                            if (TextUtils.isEmpty(name) && zipEntryNextElement.isDirectory()) {
                                jSONObject2 = jSONObject3;
                                arrayList = arrayList8;
                                arrayList2 = arrayList9;
                                enumeration = enumerationEntries;
                            } else {
                                String[] strArrSplit = name.split("/");
                                ArrayList arrayList10 = arrayList8;
                                ArrayList arrayList11 = arrayList9;
                                long size = zipEntryNextElement.getSize();
                                enumeration = enumerationEntries;
                                jSONObject2 = jSONObject3;
                                if (name.startsWith("res/drawable/")) {
                                    try {
                                        if (name.length() > 13) {
                                            arrayList4.add(strArrSplit[2]);
                                            arrayList = arrayList10;
                                            arrayList2 = arrayList11;
                                        } else if (!name.startsWith("res/") && strArrSplit.length == 2) {
                                            arrayList5.add(strArrSplit[1]);
                                            arrayList = arrayList10;
                                            arrayList2 = arrayList11;
                                        } else if (!name.startsWith("classes") && name.endsWith(".dex")) {
                                            jPr += pr(size, zipFile.getInputStream(zipEntryNextElement));
                                            arrayList8 = arrayList10;
                                            arrayList9 = arrayList11;
                                            enumerationEntries = enumeration;
                                            jSONObject3 = jSONObject2;
                                        } else if (!name.startsWith("assets/") && strArrSplit.length >= 2) {
                                            arrayList3.add(strArrSplit[1]);
                                            if (name.startsWith("assets/assets/resources/native/") && strArrSplit.length >= 6 && jSONObject4.length() < 10) {
                                                if (!TextUtils.isEmpty(strArrSplit[4]) && !jSONObject4.has(strArrSplit[4])) {
                                                    jSONObject4.put(strArrSplit[4], pr(size, zipFile.getInputStream(zipEntryNextElement)));
                                                    arrayList = arrayList10;
                                                    arrayList2 = arrayList11;
                                                } else {
                                                    if (jSONObject4.has(strArrSplit[4])) {
                                                        jSONObject4.put(strArrSplit[4], jSONObject4.getLong(strArrSplit[4]) + pr(size, zipFile.getInputStream(zipEntryNextElement)));
                                                    }
                                                    arrayList = arrayList10;
                                                    arrayList2 = arrayList11;
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                arrayList2 = arrayList11;
                                            }
                                        } else if (!name.startsWith("lib/armeabi/") && name.length() > 12) {
                                            arrayList6.add(strArrSplit[2]);
                                            arrayList = arrayList10;
                                            arrayList2 = arrayList11;
                                        } else if (!name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                            arrayList7.add(strArrSplit[2]);
                                            arrayList = arrayList10;
                                            arrayList2 = arrayList11;
                                        } else if (name.startsWith("lib/arm64-v8a/") || name.length() <= 14) {
                                            arrayList = arrayList10;
                                            if ((!name.startsWith("META-INF/") && name.endsWith(".RSA")) || name.endsWith(".DSA") || name.endsWith(".EC")) {
                                                if (!arrayList11.isEmpty()) {
                                                    arrayList2 = arrayList11;
                                                } else {
                                                    try {
                                                        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                                        if (certificateFactory == null) {
                                                            arrayList2 = arrayList11;
                                                        } else {
                                                            for (Certificate certificate : certificateFactory.generateCertificates(zipFile.getInputStream(zipEntryNextElement))) {
                                                                if (!(certificate instanceof X509Certificate)) {
                                                                    arrayList2 = arrayList11;
                                                                } else {
                                                                    pr prVar = new pr(String.valueOf(((X509Certificate) certificate).getSubjectDN()), ((X509Certificate) certificate).getEncoded());
                                                                    arrayList2 = arrayList11;
                                                                    try {
                                                                        arrayList2.add(prVar);
                                                                    } catch (CertificateException e) {
                                                                    }
                                                                }
                                                                arrayList11 = arrayList2;
                                                            }
                                                            arrayList2 = arrayList11;
                                                        }
                                                    } catch (CertificateException e2) {
                                                        arrayList2 = arrayList11;
                                                    }
                                                }
                                            }
                                        } else {
                                            String str = strArrSplit[2];
                                            arrayList = arrayList10;
                                            arrayList.add(str);
                                            arrayList2 = arrayList11;
                                        }
                                    } catch (Throwable th) {
                                        jSONObject = jSONObject2;
                                        if (zipFile != null) {
                                            zipFile.close();
                                        }
                                        return jSONObject;
                                    }
                                } else if (!name.startsWith("res/")) {
                                    if (!name.startsWith("classes")) {
                                    }
                                    if (!name.startsWith("assets/")) {
                                        if (!name.startsWith("lib/armeabi/")) {
                                            if (!name.startsWith("lib/armeabi-v7a/")) {
                                                if (name.startsWith("lib/arm64-v8a/")) {
                                                    arrayList = arrayList10;
                                                    arrayList2 = !name.startsWith("META-INF/") ? arrayList11 : arrayList11;
                                                } else {
                                                    arrayList = arrayList10;
                                                    if (!name.startsWith("META-INF/")) {
                                                    }
                                                }
                                            } else if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (!name.startsWith("lib/armeabi-v7a/")) {
                                            if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (!name.startsWith("lib/armeabi/")) {
                                        if (!name.startsWith("lib/armeabi-v7a/")) {
                                            if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (!name.startsWith("lib/armeabi-v7a/")) {
                                        if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (name.startsWith("lib/arm64-v8a/")) {
                                        arrayList = arrayList10;
                                        if (!name.startsWith("META-INF/")) {
                                        }
                                    } else {
                                        arrayList = arrayList10;
                                        if (!name.startsWith("META-INF/")) {
                                        }
                                    }
                                } else {
                                    if (!name.startsWith("classes")) {
                                    }
                                    if (!name.startsWith("assets/")) {
                                        if (!name.startsWith("lib/armeabi/")) {
                                            if (!name.startsWith("lib/armeabi-v7a/")) {
                                                if (name.startsWith("lib/arm64-v8a/")) {
                                                    arrayList = arrayList10;
                                                    if (!name.startsWith("META-INF/")) {
                                                    }
                                                } else {
                                                    arrayList = arrayList10;
                                                    if (!name.startsWith("META-INF/")) {
                                                    }
                                                }
                                            } else if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (!name.startsWith("lib/armeabi-v7a/")) {
                                            if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (!name.startsWith("lib/armeabi/")) {
                                        if (!name.startsWith("lib/armeabi-v7a/")) {
                                            if (name.startsWith("lib/arm64-v8a/")) {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            } else {
                                                arrayList = arrayList10;
                                                if (!name.startsWith("META-INF/")) {
                                                }
                                            }
                                        } else if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (!name.startsWith("lib/armeabi-v7a/")) {
                                        if (name.startsWith("lib/arm64-v8a/")) {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        } else {
                                            arrayList = arrayList10;
                                            if (!name.startsWith("META-INF/")) {
                                            }
                                        }
                                    } else if (name.startsWith("lib/arm64-v8a/")) {
                                        arrayList = arrayList10;
                                        if (!name.startsWith("META-INF/")) {
                                        }
                                    } else {
                                        arrayList = arrayList10;
                                        if (!name.startsWith("META-INF/")) {
                                        }
                                    }
                                }
                            }
                        }
                        arrayList8 = arrayList;
                        arrayList9 = arrayList2;
                        enumerationEntries = enumeration;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject2 = jSONObject3;
                    ArrayList arrayList12 = arrayList8;
                    ArrayList arrayList13 = arrayList9;
                    jSONObject = jSONObject2;
                    try {
                        jSONObject.put("apkSize", file.length());
                        jSONObject.put("dexSize", jPr);
                        if (jSONObject4.length() > 0) {
                            jSONObject.put("cocos", jSONObject4);
                        }
                        pr(jSONObject, "assets", arrayList3, false);
                        JSONObject jSONObject5 = new JSONObject();
                        pr(jSONObject5, "eabi", arrayList6, false);
                        pr(jSONObject5, "v7a", arrayList7, false);
                        pr(jSONObject5, "v8a", arrayList12, false);
                        if (jSONObject5.length() > 0) {
                            jSONObject.put("lib", jSONObject5);
                        }
                        JSONObject jSONObjectPr = pr(arrayList4);
                        if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                            jSONObject.put("drawable", jSONObjectPr);
                        }
                        JSONObject jSONObjectPr2 = pr(arrayList5);
                        if (jSONObjectPr2 != null && jSONObjectPr2.length() > 0) {
                            jSONObject.put("res", jSONObjectPr2);
                        }
                        JSONObject jSONObjectHw = hw(arrayList13);
                        if (jSONObjectHw.length() > 0) {
                            jSONObject.put("signInfo", jSONObjectHw);
                        }
                        zipFile.close();
                    } catch (Throwable th2) {
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return jSONObject;
                    }
                } catch (Throwable th3) {
                    jSONObject = jSONObject3;
                }
            } catch (Throwable th4) {
                jSONObject = jSONObject3;
                zipFile = null;
            }
        } catch (IOException e3) {
        }
        return jSONObject;
    }
}
