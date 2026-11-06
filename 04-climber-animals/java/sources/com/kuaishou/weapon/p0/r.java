package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static r c;
    private static Application d;
    public boolean a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    private r() {
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (TextUtils.isEmpty(sVar.c) || TextUtils.isEmpty(sVar.e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                                String str = sVar.m + "/dex";
                                String str2 = sVar.m + "/lib/" + this.e;
                                dn.c(sVar.m + "/lib");
                                String str3 = str2 + "/" + f.nextInt();
                                e(str);
                                dn.a(str, Boolean.FALSE);
                                e(str3);
                                a(sVar, str3, str, false);
                                h.put(sVar.c, sVar);
                                g.put(sVar.e, sVar);
                            } catch (Throwable unused) {
                                a(sVar.e);
                                z = true;
                            }
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageArchiveInfo = sVar.r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.packageName) || !packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            throw new Exception("weapon package name check failed");
                        }
                        if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                            return false;
                        }
                        sVar.c = packageArchiveInfo.packageName;
                        sVar.o = packageArchiveInfo.applicationInfo.className;
                        sVar.d = packageArchiveInfo.versionName;
                        sVar.l = packageArchiveInfo.activities;
                        sVar.q = packageArchiveInfo.applicationInfo.theme;
                        sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                        String str4 = sVar.m + "/dex";
                        String str5 = sVar.m + "/lib/" + this.e;
                        dn.c(sVar.m + "/lib");
                        String str6 = str5 + "/" + f.nextInt();
                        e(str4);
                        dn.a(str4, Boolean.FALSE);
                        e(str6);
                        a(sVar, str6, str4, true);
                        h.put(sVar.c, sVar);
                        g.put(sVar.e, sVar);
                        b.add(Integer.valueOf(sVar.a));
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!dn.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String strA = f.a(file);
        if (TextUtils.isEmpty(strA)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (!strA.equalsIgnoreCase(str)) {
            return new Pair<>(Boolean.FALSE, strA);
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public Map<String, s> b() {
        return h;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0209  */
    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:148:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:150:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:158:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:160:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:168:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:170:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:172:0x02fa A[PHI: r11 r17 r18 r21 r22
      0x02fa: PHI (r11v11 ??) = (r11v8 ??), (r11v9 ??), (r11v12 ??), (r11v16 ??) binds: [B:151:0x02bc, B:171:0x02f8, B:161:0x02da, B:119:0x022f] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r17v12 java.io.InputStream) = (r17v9 java.io.InputStream), (r17v10 java.io.InputStream), (r17v13 java.io.InputStream), (r17v20 java.io.InputStream) binds: [B:151:0x02bc, B:171:0x02f8, B:161:0x02da, B:119:0x022f] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r18v9 ??) = (r18v6 ??), (r18v7 ??), (r18v10 ??), (r18v14 ??) binds: [B:151:0x02bc, B:171:0x02f8, B:161:0x02da, B:119:0x022f] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r21v12 ??) = (r21v8 ??), (r21v9 ??), (r21v13 ??), (r21v23 ??) binds: [B:151:0x02bc, B:171:0x02f8, B:161:0x02da, B:119:0x022f] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r22v12 java.lang.String) = (r22v8 java.lang.String), (r22v9 java.lang.String), (r22v13 java.lang.String), (r22v23 java.lang.String) binds: [B:151:0x02bc, B:171:0x02f8, B:161:0x02da, B:119:0x022f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:175:0x030b  */
    /* JADX WARN: Code duplicated, block: B:178:0x032a A[Catch: all -> 0x0343, TRY_LEAVE, TryCatch #25 {all -> 0x0343, blocks: (B:176:0x0322, B:178:0x032a), top: B:253:0x0322 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0347  */
    /* JADX WARN: Code duplicated, block: B:183:0x0369  */
    /* JADX WARN: Code duplicated, block: B:186:0x038b A[Catch: all -> 0x03b0, TRY_LEAVE, TryCatch #9 {all -> 0x03b0, blocks: (B:184:0x0383, B:186:0x038b), top: B:238:0x0383 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:191:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:193:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:195:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:204:0x041a A[Catch: all -> 0x0499, TryCatch #40 {all -> 0x0499, blocks: (B:201:0x03f9, B:202:0x040c, B:204:0x041a, B:206:0x0424, B:210:0x0474, B:211:0x0498, B:208:0x042e), top: B:261:0x03f9, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0424 A[Catch: all -> 0x0499, TRY_LEAVE, TryCatch #40 {all -> 0x0499, blocks: (B:201:0x03f9, B:202:0x040c, B:204:0x041a, B:206:0x0424, B:210:0x0474, B:211:0x0498, B:208:0x042e), top: B:261:0x03f9, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0499 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:216:0x049f  */
    /* JADX WARN: Code duplicated, block: B:218:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:220:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:238:0x0383 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x022f, code lost:
    
        if (r18 != 0) goto L172;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r18v31 */
    /* JADX WARN: Type inference failed for: r18v32 */
    /* JADX WARN: Type inference failed for: r18v33 */
    /* JADX WARN: Type inference failed for: r18v34 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v12 */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r21v25 */
    /* JADX WARN: Type inference failed for: r21v28 */
    /* JADX WARN: Type inference failed for: r21v29 */
    /* JADX WARN: Type inference failed for: r21v30 */
    /* JADX WARN: Type inference failed for: r21v31 */
    /* JADX WARN: Type inference failed for: r21v35 */
    /* JADX WARN: Type inference failed for: r21v36 */
    /* JADX WARN: Type inference failed for: r21v37 */
    /* JADX WARN: Type inference failed for: r21v38 */
    /* JADX WARN: Type inference failed for: r21v39 */
    /* JADX WARN: Type inference failed for: r21v40 */
    /* JADX WARN: Type inference failed for: r21v41 */
    /* JADX WARN: Type inference failed for: r21v42 */
    /* JADX WARN: Type inference failed for: r21v43 */
    /* JADX WARN: Type inference failed for: r21v44 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r25, java.lang.String r26, java.lang.String r27, boolean r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) throws Throwable {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            String str5 = str + name.substring(3).replace(".so", str2 + ".so");
                            String strSubstring = str5.substring(0, str5.lastIndexOf(47));
                            hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                            e(strSubstring);
                            File file2 = new File(str5);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str5);
                            while (true) {
                                try {
                                    int i = zipInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, i);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            dn.a(str5, Boolean.TRUE);
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                            String str6 = sVar.m;
                            e(str6);
                            file = new File(str6, sVar.a + "-" + sVar.d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i2 = zipInputStream.read(bArr);
                                        if (i2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, i2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dn.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
