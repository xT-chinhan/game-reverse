package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static boolean d = true;
    private static int e;
    private String a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
                if ("64_level".equals(next)) {
                    e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0046 A[PHI: r4
      0x0046: PHI (r4v1 boolean) = (r4v0 boolean), (r4v2 boolean) binds: [B:13:0x0018, B:22:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    public static String b() {
        try {
            if (!d) {
                return "KWE_NPN";
            }
            if (e == 0) {
                int i = Build.VERSION.SDK_INT;
                boolean z = true;
                if (i < 33) {
                    boolean z2 = false;
                    if (i >= 29) {
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                            z2 = true;
                        }
                        if (!Build.BRAND.equalsIgnoreCase("HONOR")) {
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                }
                if (!z) {
                    String strGSer = Orange.getInstance().gSer();
                    if (!TextUtils.isEmpty(strGSer) && !strGSer.startsWith("KWE")) {
                        return strGSer;
                    }
                }
            }
            return !TextUtils.isEmpty("") ? "" : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    public static c c() {
        return b.a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.a) ? this.a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0287 A[Catch: all -> 0x038a, TryCatch #6 {all -> 0x038a, blocks: (B:60:0x0156, B:62:0x0163, B:68:0x017f, B:70:0x0188, B:72:0x019b, B:81:0x01d1, B:86:0x0202, B:95:0x0210, B:100:0x022a, B:102:0x0233, B:104:0x0244, B:106:0x024d, B:108:0x026b, B:110:0x0279, B:112:0x0287, B:114:0x028d, B:116:0x0295, B:118:0x029b, B:119:0x02a1, B:124:0x02af, B:128:0x02b8, B:140:0x031b, B:139:0x0318, B:122:0x02aa, B:145:0x0386, B:146:0x0389, B:67:0x017a, B:59:0x0151, B:92:0x020a, B:129:0x02bf, B:132:0x02c8, B:134:0x02e1, B:135:0x02ec, B:136:0x02ef, B:64:0x016c), top: B:174:0x0151, inners: #0, #12, #16, #17 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:132:0x02c8 A[Catch: all -> 0x0317, TryCatch #16 {all -> 0x0317, blocks: (B:129:0x02bf, B:132:0x02c8, B:134:0x02e1, B:135:0x02ec, B:136:0x02ef), top: B:192:0x02bf, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x02e1 A[Catch: all -> 0x0317, TryCatch #16 {all -> 0x0317, blocks: (B:129:0x02bf, B:132:0x02c8, B:134:0x02e1, B:135:0x02ec, B:136:0x02ef), top: B:192:0x02bf, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x03af  */
    /* JADX WARN: Code duplicated, block: B:198:0x02ec A[SYNTHETIC] */
    public String a(Context context, ResponseDfpCallback responseDfpCallback, boolean z) {
        String str;
        String str2;
        long jCurrentTimeMillis;
        String eGidLocal;
        String strReplace;
        long j;
        long j2;
        BufferedReader bufferedReader;
        String strReplace2;
        int i;
        CRC32 crc32;
        String str3;
        String str4 = " ";
        String str5 = "AD_AND";
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            this.c.lock();
            try {
                if (!TextUtils.isEmpty(this.b)) {
                    String str6 = this.b;
                    this.c.unlock();
                    return str6;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k23", f.a(a(Build.MANUFACTURER)));
                jSONObject.put("k61", f.a(a(Build.BRAND)));
                jSONObject.put("k27", f.a(a(Build.MODEL)));
                jSONObject.put("k64", f.a(b()));
                jSONObject.put("k31", f.a(com.yxcorp.kuaishou.addfp.android.b.d.c(false)));
                jSONObject.put("k117", f.a(com.yxcorp.kuaishou.addfp.android.b.d.c(true)));
                jSONObject.put("k66", f.a(com.yxcorp.kuaishou.addfp.android.b.d.a(false)));
                jSONObject.put("k116", f.a(com.yxcorp.kuaishou.addfp.android.b.d.a(true)));
                long j3 = 0;
                try {
                    jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                } catch (Throwable th) {
                    th.printStackTrace();
                    jCurrentTimeMillis = 0;
                }
                jSONObject.put("k39", f.a(Long.toString(jCurrentTimeMillis)));
                jSONObject.put("k101", Orange.getInstance().getResSoc("0"));
                jSONObject.put("k102", f.a("KWE_NPN"));
                jSONObject.put("k57", f.a(com.yxcorp.kuaishou.addfp.android.b.d.b(false)));
                jSONObject.put("k118", f.a(com.yxcorp.kuaishou.addfp.android.b.d.b(true)));
                jSONObject.put("k68", f.a(com.yxcorp.kuaishou.addfp.android.b.d.e(false)));
                jSONObject.put("k120", f.a(com.yxcorp.kuaishou.addfp.android.b.d.e(true)));
                jSONObject.put("k105", f.a(Orange.getInstance().gRdi()));
                try {
                    str = "KWE_N";
                    try {
                        str2 = "KWE_PE";
                        try {
                            eGidLocal = KWEGIDDFP.instance().getEGidLocal(context, c().a(), false);
                            if (TextUtils.isEmpty(eGidLocal)) {
                                eGidLocal = str;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                eGidLocal = str2;
                            } catch (Throwable th3) {
                                th = th3;
                                th.printStackTrace();
                                this.b = str2;
                                responseDfpCallback.onFailed(-1, f.a(th));
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str2 = "KWE_PE";
                        th.printStackTrace();
                        eGidLocal = str2;
                        jSONObject.put("k83", f.a(eGidLocal));
                        jSONObject.put("k86", f.a(com.yxcorp.kuaishou.addfp.c.a.a.a(context)));
                        strReplace = context.getPackageName().replace("=", "").replace("&", "");
                        jSONObject.put("k3", f.a(strReplace));
                        jSONObject.put("k109", f.a(Orange.getInstance().gProps()));
                        jSONObject.put("k36", f.a("1.4.6.83.10f752d7"));
                        jSONObject.put("k14", f.a("AD_AND"));
                        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                        j = jCurrentTimeMillis2;
                        long blockSize = statFs.getBlockSize();
                        try {
                            int blockCount = statFs.getBlockCount();
                            str4 = " ";
                            str5 = "AD_AND";
                            j2 = ((long) blockCount) * blockSize;
                        } catch (Throwable unused) {
                            j2 = 0;
                        }
                        jSONObject.put("k5", f.a(Long.toString(j2)));
                        bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                        try {
                            j3 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * com.anythink.china.a.c.k;
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                }
                                jSONObject.put("k46", f.a(Long.toString(j3)));
                                strReplace2 = Build.VERSION.RELEASE.replace("=", "").replace("&", "");
                                jSONObject.put("k35", f.a(strReplace2));
                                jSONObject.put("k110", f.a(Orange.getInstance().gKpsd()));
                                jSONObject.put("k111", f.a("KWE_NPN"));
                                jSONObject.put("k112", f.a(Orange.getInstance().sted(context, null, false)));
                                jSONObject.put("k113", f.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                                jSONObject.put("k115", f.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                                String strD = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                                if (z) {
                                    i = 1;
                                    jSONObject.put("k97", f.a(strD));
                                    crc32 = new CRC32();
                                    while (i <= 120) {
                                        str3 = "k" + i;
                                        if (jSONObject.has(str3)) {
                                            crc32.update(jSONObject.optString(str3).getBytes());
                                        }
                                        i++;
                                    }
                                    jSONObject.put("k14", f.a(str5 + ":" + String.valueOf(crc32.getValue())));
                                    String str7 = "mimi :" + jSONObject.toString() + str4 + jSONObject.toString().getBytes().length + str4 + (System.currentTimeMillis() - j);
                                    byte[] magicWrapper = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                                    String str8 = "get mini lenth " + magicWrapper.length;
                                    this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper, 0), "utf-8");
                                } else {
                                    i = 1;
                                    jSONObject.put("k97", f.a(strD));
                                    crc32 = new CRC32();
                                    while (i <= 120) {
                                        str3 = "k" + i;
                                        if (jSONObject.has(str3)) {
                                            crc32.update(jSONObject.optString(str3).getBytes());
                                        }
                                        i++;
                                    }
                                    jSONObject.put("k14", f.a(str5 + ":" + String.valueOf(crc32.getValue())));
                                    String str9 = "mimi :" + jSONObject.toString() + str4 + jSONObject.toString().getBytes().length + str4 + (System.currentTimeMillis() - j);
                                    byte[] magicWrapper2 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                                    String str10 = "get mini lenth " + magicWrapper2.length;
                                    this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper2, 0), "utf-8");
                                }
                                this.c.unlock();
                                if (TextUtils.isEmpty(this.b)) {
                                    this.b = str;
                                }
                                return this.b;
                            } catch (Throwable th6) {
                                if (bufferedReader == null) {
                                    throw th6;
                                }
                                try {
                                    bufferedReader.close();
                                    throw th6;
                                } catch (IOException unused2) {
                                    throw th6;
                                }
                            }
                        }
                        bufferedReader.close();
                        jSONObject.put("k46", f.a(Long.toString(j3)));
                        strReplace2 = Build.VERSION.RELEASE.replace("=", "").replace("&", "");
                        jSONObject.put("k35", f.a(strReplace2));
                        jSONObject.put("k110", f.a(Orange.getInstance().gKpsd()));
                        jSONObject.put("k111", f.a("KWE_NPN"));
                        jSONObject.put("k112", f.a(Orange.getInstance().sted(context, null, false)));
                        jSONObject.put("k113", f.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                        jSONObject.put("k115", f.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                        String strD2 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                        if (z) {
                            i = 1;
                            jSONObject.put("k97", f.a(strD2));
                            crc32 = new CRC32();
                            while (i <= 120) {
                                str3 = "k" + i;
                                if (jSONObject.has(str3)) {
                                    crc32.update(jSONObject.optString(str3).getBytes());
                                }
                                i++;
                            }
                            jSONObject.put("k14", f.a(str5 + ":" + String.valueOf(crc32.getValue())));
                            String str11 = "mimi :" + jSONObject.toString() + str4 + jSONObject.toString().getBytes().length + str4 + (System.currentTimeMillis() - j);
                            byte[] magicWrapper3 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                            String str12 = "get mini lenth " + magicWrapper3.length;
                            this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper3, 0), "utf-8");
                        } else {
                            i = 1;
                            jSONObject.put("k97", f.a(strD2));
                            crc32 = new CRC32();
                            while (i <= 120) {
                                str3 = "k" + i;
                                if (jSONObject.has(str3)) {
                                    crc32.update(jSONObject.optString(str3).getBytes());
                                }
                                i++;
                            }
                            jSONObject.put("k14", f.a(str5 + ":" + String.valueOf(crc32.getValue())));
                            String str13 = "mimi :" + jSONObject.toString() + str4 + jSONObject.toString().getBytes().length + str4 + (System.currentTimeMillis() - j);
                            byte[] magicWrapper4 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                            String str14 = "get mini lenth " + magicWrapper4.length;
                            this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper4, 0), "utf-8");
                        }
                        this.c.unlock();
                        if (TextUtils.isEmpty(this.b)) {
                            this.b = str;
                        }
                        return this.b;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = "KWE_N";
                }
                jSONObject.put("k83", f.a(eGidLocal));
                jSONObject.put("k86", f.a(com.yxcorp.kuaishou.addfp.c.a.a.a(context)));
                try {
                    strReplace = context.getPackageName().replace("=", "").replace("&", "");
                } catch (Throwable th8) {
                    th8.printStackTrace();
                    strReplace = str2;
                }
                jSONObject.put("k3", f.a(strReplace));
                jSONObject.put("k109", f.a(Orange.getInstance().gProps()));
                jSONObject.put("k36", f.a("1.4.6.83.10f752d7"));
                jSONObject.put("k14", f.a("AD_AND"));
                try {
                    StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
                    j = jCurrentTimeMillis2;
                    long blockSize2 = statFs2.getBlockSize();
                    int blockCount2 = statFs2.getBlockCount();
                    str4 = " ";
                    str5 = "AD_AND";
                    j2 = ((long) blockCount2) * blockSize2;
                } catch (Throwable unused3) {
                    j = jCurrentTimeMillis2;
                }
                jSONObject.put("k5", f.a(Long.toString(j2)));
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    j3 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * com.anythink.china.a.c.k;
                } catch (Throwable th9) {
                    th = th9;
                    bufferedReader = null;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                jSONObject.put("k46", f.a(Long.toString(j3)));
                try {
                    strReplace2 = Build.VERSION.RELEASE.replace("=", "").replace("&", "");
                } catch (Throwable unused5) {
                    strReplace2 = str2;
                }
                jSONObject.put("k35", f.a(strReplace2));
                jSONObject.put("k110", f.a(Orange.getInstance().gKpsd()));
                jSONObject.put("k111", f.a("KWE_NPN"));
                jSONObject.put("k112", f.a(Orange.getInstance().sted(context, null, false)));
                jSONObject.put("k113", f.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                jSONObject.put("k115", f.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                String strD3 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                if (z || strD3.equals("KWE_NPN") || !strD3.startsWith("KWE")) {
                    i = 1;
                } else {
                    if (Build.VERSION.SDK_INT >= 29) {
                        i = 1;
                        try {
                            new CountDownLatch(1).await(1000L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        i = 1;
                    }
                    strD3 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                }
                jSONObject.put("k97", f.a(strD3));
                try {
                    crc32 = new CRC32();
                    while (i <= 120) {
                        str3 = "k" + i;
                        if (jSONObject.has(str3)) {
                            crc32.update(jSONObject.optString(str3).getBytes());
                        }
                        i++;
                    }
                    jSONObject.put("k14", f.a(str5 + ":" + String.valueOf(crc32.getValue())));
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
                String str15 = "mimi :" + jSONObject.toString() + str4 + jSONObject.toString().getBytes().length + str4 + (System.currentTimeMillis() - j);
                byte[] magicWrapper5 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                String str16 = "get mini lenth " + magicWrapper5.length;
                this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper5, 0), "utf-8");
                this.c.unlock();
                if (TextUtils.isEmpty(this.b)) {
                    this.b = str;
                }
                return this.b;
                th.printStackTrace();
                this.b = str2;
                responseDfpCallback.onFailed(-1, f.a(th));
                this.c.unlock();
                if (TextUtils.isEmpty(this.b)) {
                    this.b = str;
                }
                return this.b;
            } catch (Throwable th11) {
                this.c.unlock();
                throw th11;
            }
        } catch (Throwable th12) {
            th = th12;
            str = "KWE_N";
            str2 = "KWE_PE";
        }
    }

    public void b(String str) {
        this.a = str;
    }
}
