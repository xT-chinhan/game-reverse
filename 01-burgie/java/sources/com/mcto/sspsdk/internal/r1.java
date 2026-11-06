package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 {
    public static String p;
    public String a;
    public final Context b;
    public final File c;
    public File j;
    public y0 l;
    public q5 m;
    public u0 n;
    public int e = 0;
    public int f = 0;
    public long g = 0;
    public long h = 0;
    public long i = 0;
    public boolean k = false;
    public final ReentrantLock o = new ReentrantLock();
    public final v0 d = v0.a();

    public r1(Context context) {
        this.b = context;
        this.c = ij.a(context);
    }

    /* JADX WARN: Code duplicated, block: B:137:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x010e  */
    /* JADX WARN: Code duplicated, block: B:41:0x011c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0127  */
    /* JADX WARN: Code duplicated, block: B:49:0x014f  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c4 A[Catch: Exception -> 0x02f3, TryCatch #1 {Exception -> 0x02f3, blocks: (B:55:0x018d, B:61:0x01a4, B:64:0x01aa, B:66:0x01ae, B:68:0x01b2, B:72:0x01b8, B:76:0x01c2, B:77:0x01c3, B:87:0x01f6, B:89:0x020f, B:91:0x0220, B:93:0x0224, B:95:0x0228, B:97:0x022c, B:98:0x0239, B:78:0x01c4, B:80:0x01c8, B:82:0x01ce, B:86:0x01d5, B:99:0x0251, B:101:0x0255, B:102:0x0257, B:104:0x026a, B:107:0x0270, B:109:0x0274, B:110:0x0276, B:112:0x0286, B:114:0x028e, B:116:0x0295, B:118:0x0299, B:120:0x029d, B:121:0x02aa, B:123:0x02bd, B:125:0x02dc, B:129:0x02e7, B:69:0x01b3, B:70:0x01b5), top: B:136:0x018d, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01d4  */
    public static void a(r1 r1Var) {
        q5 q5Var;
        int i;
        boolean z;
        u0 u0Var;
        File file;
        if (r1Var.e == 1) {
            return;
        }
        if (e1.c(r1Var.n.i)) {
            e1.a(jd.a, r1Var.n.i);
            return;
        }
        int i2 = 5;
        if (r1Var.e == 5 && (file = r1Var.j) != null && file.exists()) {
            kh.a.a(new l1(r1Var));
            return;
        }
        r1Var.e = 1;
        r1Var.j = new File(r1Var.c, r1Var.n.b());
        r9.a("ssp_downloader", r1Var.a, ",prepareDownload begin status:", Integer.valueOf(r1Var.n.a), ",saveFile.path = " + r1Var.j.getPath());
        int i3 = r1Var.n.a;
        char c = i3 == 2 ? (char) 2 : (char) 0;
        long j = 0;
        if (i3 == 0) {
            if (r1Var.j.exists()) {
                r1Var.j.delete();
            }
            r1Var.g = 0L;
            long jC = c(r1Var.n.d);
            r1Var.i = jC;
            if (jC > 0) {
                HashMap map = new HashMap();
                map.put(v5.KEY_DOWNLOAD_TYPE, "0");
                map.put(v5.KEY_DOWNLOAD_CUSTOM_INFO, "dw:0;apk:" + r1Var.n.i + ";scene:" + r1Var.n.q);
                l lVarA = l.a();
                String str = r1Var.a;
                String str2 = r1Var.n.f;
                lVarA.getClass();
                l.a(str, str2, 33, map);
                c = 1;
                u0Var = r1Var.n;
                u0Var.b = r1Var.i;
                u0Var.a = 1;
                if (c == 1) {
                    r1Var.d.getClass();
                    v0.a(u0Var);
                } else if (c == 2) {
                    r1Var.d.getClass();
                    v0.b(u0Var);
                }
                long j2 = r1Var.i;
                long j3 = r1Var.g;
                if (r1Var.l == null && r1Var.n != null) {
                    kh.a.a(new o1(r1Var, j2, j3));
                }
                j = r1Var.i;
            }
        } else {
            if (!r1Var.j.exists()) {
                r1Var.g = 0L;
                if (r1Var.i <= 0) {
                    long jC2 = c(r1Var.n.d);
                    r1Var.i = jC2;
                    j = jC2 <= 0 ? 0L : 0L;
                }
                c = 2;
            }
            u0Var = r1Var.n;
            u0Var.b = r1Var.i;
            u0Var.a = 1;
            if (c == 1) {
                r1Var.d.getClass();
                v0.a(u0Var);
            } else if (c == 2) {
                r1Var.d.getClass();
                v0.b(u0Var);
            }
            long j4 = r1Var.i;
            long j5 = r1Var.g;
            if (r1Var.l == null) {
            }
            j = r1Var.i;
        }
        r9.a("ssp_downloader", r1Var.a, ",prepareDownload begin file size:", Long.valueOf(j), ",download size:", Long.valueOf(r1Var.g));
        if (j <= j) {
            r1Var.b("code:2;msg:" + p);
            return;
        }
        try {
            r1Var.h = r1Var.g;
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = r1Var.g < r1Var.i;
            long j6 = jCurrentTimeMillis;
            int i4 = 0;
            while (z2) {
                int i5 = r1Var.f;
                if (i5 == 2) {
                    if (r1Var.e == 2) {
                        return;
                    }
                    q5 q5Var2 = r1Var.m;
                    if (q5Var2 != null) {
                        q5Var2.g = true;
                    }
                    r1Var.e = 2;
                    u0 u0Var2 = r1Var.n;
                    u0Var2.a = 2;
                    r1Var.d.getClass();
                    v0.b(u0Var2);
                    return;
                }
                if (i5 == 3) {
                    q5 q5Var3 = r1Var.m;
                    if (q5Var3 != null) {
                        q5Var3.g = true;
                    }
                    r1Var.e = 3;
                    v0 v0Var = r1Var.d;
                    String str3 = r1Var.a;
                    v0Var.getClass();
                    v0.a(str3);
                    r1Var.j.delete();
                    return;
                }
                q5 q5Var4 = r1Var.m;
                if (q5Var4 == null) {
                    q5Var = r1Var.m;
                    if (q5Var != null && q5Var.a()) {
                        i = i4 + 1;
                        if (i4 > 3) {
                            break;
                        } else {
                            i4 = i;
                        }
                    }
                    q5 q5Var5 = new q5(r1Var, r1Var.n.d, r1Var.j, r1Var.i, r1Var.g);
                    r1Var.m = q5Var5;
                    q5Var5.setPriority(i2);
                    r1Var.m.start();
                } else if (!q5Var4.f) {
                    synchronized (q5Var4) {
                        z = q5Var4.h;
                    }
                    if (z || r1Var.m.b()) {
                        q5Var = r1Var.m;
                        if (q5Var != null) {
                            i = i4 + 1;
                            if (i4 > 3) {
                                break;
                                break;
                            }
                            i4 = i;
                        }
                        q5 q5Var6 = new q5(r1Var, r1Var.n.d, r1Var.j, r1Var.i, r1Var.g);
                        r1Var.m = q5Var6;
                        q5Var6.setPriority(i2);
                        r1Var.m.start();
                    }
                }
                long j7 = r1Var.g;
                float f = ((j7 / r1Var.i) * 1000.0f) / 10.0f;
                float fCurrentTimeMillis = (System.currentTimeMillis() - j6) / 1000.0f;
                float f2 = fCurrentTimeMillis > 0.0f ? ((int) ((((r1Var.g - r1Var.h) / fCurrentTimeMillis) / 1024.0f) * 10.0f)) / 10.0f : 0.0f;
                if (r1Var.l != null && r1Var.n != null && r1Var.e == 1) {
                    kh.a.a(new n1(r1Var, j7, f, f2));
                }
                r1Var.h = r1Var.g;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                Thread.sleep(200L);
                j6 = jCurrentTimeMillis2;
                z2 = !r1Var.m.f;
                i2 = 5;
            }
            long j8 = r1Var.g;
            if (j8 != r1Var.i) {
                r9.a("ssp_downloader", r1Var.a, "file download failed.");
                StringBuilder sbAppend = new StringBuilder().append("code:3;msg:");
                q5 q5Var7 = r1Var.m;
                r1Var.b(sbAppend.append((q5Var7 == null || !q5Var7.a()) ? "file_size" : "http_err").toString());
                return;
            }
            if (r1Var.l != null && r1Var.n != null && r1Var.e == 1) {
                kh.a.a(new n1(r1Var, j8, 100.0f, 0.0f));
            }
            r1Var.e = 5;
            r1Var.a(r1Var.j.getAbsolutePath());
            r1Var.j.length();
        } catch (Exception e) {
            r9.a("ssp_downloader", r1Var.a, "file download exception.", e);
            r1Var.b("code:4;msg:exec_err_" + gj.f(e.getMessage()));
        }
    }

    public static long c(String str) {
        p = "";
        try {
            HttpURLConnection httpURLConnectionA = e7.a(5000, str, null);
            if (httpURLConnectionA != null && httpURLConnectionA.getResponseCode() >= 200 && httpURLConnectionA.getResponseCode() < 300) {
                return Build.VERSION.SDK_INT >= 24 ? httpURLConnectionA.getContentLengthLong() : Long.parseLong(httpURLConnectionA.getHeaderField("content-length"));
            }
            p = httpURLConnectionA != null ? "http_code_" + httpURLConnectionA.getResponseCode() : "http_code_null";
            return 0L;
        } catch (Exception e) {
            p = gj.f(e.getMessage());
            r9.a("ssp_downloader", "open HttpURLConnection failed.", e);
            return 0L;
        }
    }

    public final void b(String str) {
        this.e = 3;
        if (this.f != 2) {
            this.f = 3;
        }
        this.n.a = 6;
        this.g = 0L;
        File file = this.j;
        if (file != null) {
            file.delete();
        }
        v0 v0Var = this.d;
        String str2 = this.a;
        v0Var.getClass();
        v0.a(str2);
        if (this.l != null && this.n != null) {
            kh.a.a(new q1(this));
        }
        HashMap map = new HashMap();
        map.put(v5.KEY_DOWNLOAD_CUSTOM_INFO, "dw:0;apk:" + this.n.i + ";");
        map.put(v5.KEY_DOWNLOAD_MSG, str);
        l lVarA = l.a();
        String str3 = this.a;
        String str4 = this.n.f;
        lVarA.getClass();
        l.a(str3, str4, 32, map);
    }

    public final synchronized void a(long j) {
        this.g += j;
    }

    public final void a(String str) {
        String str2;
        try {
            PackageInfo packageArchiveInfo = this.b.getPackageManager().getPackageArchiveInfo(str, 1);
            str2 = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
        } catch (Exception e) {
            r9.a("ssp_downloader", "getApkFileInfo: ", e);
        }
        if (TextUtils.isEmpty(str2)) {
            b("code:5;msg:not_apk_file");
            return;
        }
        if (this.n.a != 5) {
            HashMap map = new HashMap(8);
            if (!TextUtils.equals(str2, this.n.i)) {
                map.put(v5.KEY_REAL_APK_NAME, str2);
            }
            map.put(v5.KEY_DOWNLOAD_TYPE, "0");
            l lVarA = l.a();
            String str3 = this.a;
            String str4 = this.n.f;
            lVarA.getClass();
            l.a(str3, str4, 34, map);
        }
        u0 u0Var = this.n;
        u0Var.a = 5;
        u0Var.i = str2;
        this.d.getClass();
        v0.b(u0Var);
        if (this.l != null && this.n != null) {
            kh.a.a(new p1(this, str));
        }
        e1.b(str);
    }
}
