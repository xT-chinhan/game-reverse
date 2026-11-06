package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mcto.sspsdk.QyRewardProperty;
import com.taptap.sdk.db.constant.Common;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();
    private static final Map<String, String> c = new HashMap();
    private static int d = 0;
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    static /* synthetic */ String a(long j2) {
        if (j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            return "512M";
        }
        return String.format(Locale.US, "%dG", Long.valueOf(((j2 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + 512) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    static /* synthetic */ Map c(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] strArrSplit = str2.split("=", 3);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class a {
        long a = 0;
        int b = 0;
        Map<String, String> c = new HashMap();
        private String d;
        private boolean e;
        private boolean f;

        a(String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        final void a(String str, long j) {
            long jD = d(str) + j;
            if (jD <= 100) {
                j = jD < 0 ? 0L : jD;
            }
            a(str, String.valueOf(j));
        }

        final boolean a(a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long jD = aVar.d(str);
                    if (jD == 0) {
                        a(str, aVar.a(str));
                    } else if (jD < 100) {
                        a(str, jD);
                    }
                }
            }
            return true;
        }

        final String a(String str) {
            return this.c.get(str);
        }

        final String b(String str) {
            String strA = a(str);
            if (strA == null) {
                return "";
            }
            return strA;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, QyRewardProperty.VERIFY_TYPE_PRE, com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, Common.Predefined.SUB_ROM, Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, "cpu", com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long jO = h.o();
                h.a(sb, Common.Predefined.SUB_RAM, jO);
                h.b(sb, "aram", h.a(jO));
                h.b(sb, "cver", "3.3.2.2");
                h.b(sb, "cseq", "211215141717");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.T());
                h.b(sb, "sver", com.uc.crashsdk.g.U());
                h.b(sb, "seq", com.uc.crashsdk.g.V());
                h.b(sb, "grd", com.uc.crashsdk.b.A() ? "fg" : "bg");
                h.b(sb, "os", "android");
                h.b(sb, "dn", com.uc.crashsdk.e.q());
                String strAb = com.uc.crashsdk.g.ab();
                if (TextUtils.isEmpty(strAb)) {
                    h.b(sb, "k_uid", com.uc.crashsdk.e.q());
                } else {
                    h.b(sb, "k_uid", strAb);
                }
                String strAc = com.uc.crashsdk.g.ac();
                if (!TextUtils.isEmpty(strAc)) {
                    h.b(sb, "k_channel", strAc);
                }
                sb.append("\n");
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.c);
            if (this.e && !z2) {
                if (this.a != 0) {
                    h.b(sb, "up", String.valueOf(this.a));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else if (this.b != 0) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(this.b)));
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long jC = 0;
            HashMap map = new HashMap();
            Map mapC = h.c(str);
            int iC = 0;
            for (String str3 : mapC.keySet()) {
                String str4 = (String) mapC.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    jC = g.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    iC = (int) g.c(str4);
                } else {
                    map.put(str3, str4);
                }
            }
            if (this.d != null && !this.d.equals(str2)) {
                return false;
            }
            this.a = jC;
            this.b = iC;
            this.d = str2;
            this.c = map;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    static void a(String str) {
        synchronized (b) {
            File file = new File(m());
            a aVar = new a("pv", true, true);
            String strC = g.c(file);
            if (!g.a(strC)) {
                aVar.c(strC);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static void a() {
        long j2;
        if (com.uc.crashsdk.b.H()) {
            j2 = 700000;
        } else {
            j2 = 70000;
        }
        a(0, j2);
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void a(int i2, long j2) {
        if (!com.uc.crashsdk.b.F()) {
            return;
        }
        f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean a(String str, String str2) {
        String strReplaceAll;
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            if (g.a(str2)) {
                strReplaceAll = "";
            } else {
                strReplaceAll = str2.replaceAll("[`=]", "-");
            }
            synchronized (c) {
                if (c.get(str3) == null) {
                    if (d >= 20) {
                        return false;
                    }
                    d++;
                }
                c.put(str3, strReplaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    private static void a(a aVar) {
        synchronized (c) {
            for (String str : c.keySet()) {
                aVar.a(str, c.get(str));
            }
        }
    }

    public static boolean e() {
        return j;
    }

    private static void b(int i2, long j2) {
        if (!com.uc.crashsdk.g.Q()) {
            return;
        }
        f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void a(boolean z) throws IOException {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (com.uc.crashsdk.b.d && !z && JNIBridge.nativeIsCrashing()) {
            com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
            return true;
        }
        return false;
    }

    private static void a(int i2, boolean z) throws IOException {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "cr.wa";
        com.uc.crashsdk.b.a(b, str, new e(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, new Object[]{str, Integer.valueOf(i2)}));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0044 A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x005e A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0063 A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x006b  */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074 A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087 A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x009b A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b5 A[Catch: all -> 0x00d1, TryCatch #0 {, blocks: (B:17:0x0021, B:19:0x002c, B:21:0x0030, B:53:0x00cf, B:22:0x0032, B:24:0x003c, B:26:0x0044, B:28:0x005e, B:30:0x0063, B:37:0x0074, B:38:0x007b, B:44:0x008f, B:46:0x009b, B:51:0x00b5, B:52:0x00c8, B:49:0x00ab, B:43:0x0087), top: B:66:0x0021 }] */
    static void a(int i2, Object[] objArr) {
        File file;
        String strC;
        a aVar;
        String str;
        String strQ;
        long j2;
        boolean zC;
        boolean z;
        switch (i2) {
            case 301:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                a(((Integer) objArr[0]).intValue(), false);
                return;
            case 302:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                synchronized (b) {
                    int iIntValue = ((Integer) objArr[0]).intValue();
                    if (iIntValue != 0) {
                        if (com.uc.crashsdk.a.b.equals("2.0") || !com.uc.crashsdk.b.c(C.ENCODING_PCM_MU_LAW)) {
                            file = new File(m());
                            strC = g.c(file);
                            aVar = new a("pv", true, true);
                            if (!g.a(strC)) {
                                aVar.c(strC);
                            }
                            if (iIntValue != 0) {
                                if (iIntValue == 0) {
                                    aVar.a("pv", 1L);
                                    str = "fjv";
                                } else if (iIntValue == 1) {
                                    str = "hpv";
                                } else {
                                    if (iIntValue == 2) {
                                        aVar.a("pv", 1L);
                                        str = "npv";
                                    }
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0 || System.currentTimeMillis() - j2 >= 28800000) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = false;
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                                aVar.a(str, 1L);
                                strQ = com.uc.crashsdk.e.q();
                                j2 = aVar.a;
                                if (j2 != 0) {
                                    zC = c(strQ, aVar.a(true, true, false));
                                } else {
                                    zC = c(strQ, aVar.a(true, true, false));
                                }
                                if (zC) {
                                    aVar.c = new HashMap();
                                    aVar.a = System.currentTimeMillis();
                                    aVar.b = Process.myPid();
                                }
                                g.a(file, aVar.a(false, false, true));
                            } else {
                                if (aVar.b == Process.myPid()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    if (iIntValue == 0) {
                                        aVar.a("pv", 1L);
                                        str = "fjv";
                                    } else if (iIntValue == 1) {
                                        str = "hpv";
                                    } else {
                                        if (iIntValue == 2) {
                                            aVar.a("pv", 1L);
                                            str = "npv";
                                        }
                                        strQ = com.uc.crashsdk.e.q();
                                        j2 = aVar.a;
                                        if (j2 != 0) {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        } else {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        }
                                        if (zC) {
                                            aVar.c = new HashMap();
                                            aVar.a = System.currentTimeMillis();
                                            aVar.b = Process.myPid();
                                        }
                                        g.a(file, aVar.a(false, false, true));
                                    }
                                    aVar.a(str, 1L);
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                            }
                        }
                    } else if (!i) {
                        i = true;
                        if (com.uc.crashsdk.a.b.equals("2.0")) {
                            file = new File(m());
                            strC = g.c(file);
                            aVar = new a("pv", true, true);
                            if (!g.a(strC)) {
                                aVar.c(strC);
                            }
                            if (iIntValue != 0) {
                                if (iIntValue == 0) {
                                    aVar.a("pv", 1L);
                                    str = "fjv";
                                } else if (iIntValue == 1) {
                                    str = "hpv";
                                } else {
                                    if (iIntValue == 2) {
                                        aVar.a("pv", 1L);
                                        str = "npv";
                                    }
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                                aVar.a(str, 1L);
                                strQ = com.uc.crashsdk.e.q();
                                j2 = aVar.a;
                                if (j2 != 0) {
                                    zC = c(strQ, aVar.a(true, true, false));
                                } else {
                                    zC = c(strQ, aVar.a(true, true, false));
                                }
                                if (zC) {
                                    aVar.c = new HashMap();
                                    aVar.a = System.currentTimeMillis();
                                    aVar.b = Process.myPid();
                                }
                                g.a(file, aVar.a(false, false, true));
                            } else {
                                if (aVar.b == Process.myPid()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    if (iIntValue == 0) {
                                        aVar.a("pv", 1L);
                                        str = "fjv";
                                    } else if (iIntValue == 1) {
                                        str = "hpv";
                                    } else {
                                        if (iIntValue == 2) {
                                            aVar.a("pv", 1L);
                                            str = "npv";
                                        }
                                        strQ = com.uc.crashsdk.e.q();
                                        j2 = aVar.a;
                                        if (j2 != 0) {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        } else {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        }
                                        if (zC) {
                                            aVar.c = new HashMap();
                                            aVar.a = System.currentTimeMillis();
                                            aVar.b = Process.myPid();
                                        }
                                        g.a(file, aVar.a(false, false, true));
                                    }
                                    aVar.a(str, 1L);
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                            }
                        } else {
                            file = new File(m());
                            strC = g.c(file);
                            aVar = new a("pv", true, true);
                            if (!g.a(strC)) {
                                aVar.c(strC);
                            }
                            if (iIntValue != 0) {
                                if (iIntValue == 0) {
                                    aVar.a("pv", 1L);
                                    str = "fjv";
                                } else if (iIntValue == 1) {
                                    str = "hpv";
                                } else {
                                    if (iIntValue == 2) {
                                        aVar.a("pv", 1L);
                                        str = "npv";
                                    }
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                                aVar.a(str, 1L);
                                strQ = com.uc.crashsdk.e.q();
                                j2 = aVar.a;
                                if (j2 != 0) {
                                    zC = c(strQ, aVar.a(true, true, false));
                                } else {
                                    zC = c(strQ, aVar.a(true, true, false));
                                }
                                if (zC) {
                                    aVar.c = new HashMap();
                                    aVar.a = System.currentTimeMillis();
                                    aVar.b = Process.myPid();
                                }
                                g.a(file, aVar.a(false, false, true));
                            } else {
                                if (aVar.b == Process.myPid()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    if (iIntValue == 0) {
                                        aVar.a("pv", 1L);
                                        str = "fjv";
                                    } else if (iIntValue == 1) {
                                        str = "hpv";
                                    } else {
                                        if (iIntValue == 2) {
                                            aVar.a("pv", 1L);
                                            str = "npv";
                                        }
                                        strQ = com.uc.crashsdk.e.q();
                                        j2 = aVar.a;
                                        if (j2 != 0) {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        } else {
                                            zC = c(strQ, aVar.a(true, true, false));
                                        }
                                        if (zC) {
                                            aVar.c = new HashMap();
                                            aVar.a = System.currentTimeMillis();
                                            aVar.b = Process.myPid();
                                        }
                                        g.a(file, aVar.a(false, false, true));
                                    }
                                    aVar.a(str, 1L);
                                    strQ = com.uc.crashsdk.e.q();
                                    j2 = aVar.a;
                                    if (j2 != 0) {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    } else {
                                        zC = c(strQ, aVar.a(true, true, false));
                                    }
                                    if (zC) {
                                        aVar.c = new HashMap();
                                        aVar.a = System.currentTimeMillis();
                                        aVar.b = Process.myPid();
                                    }
                                    g.a(file, aVar.a(false, false, true));
                                }
                            }
                        }
                    }
                    break;
                }
                return;
            case 303:
                b(false);
                return;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fc  */
    static boolean b(int i2, Object[] objArr) throws Throwable {
        String str;
        String strValueOf;
        String str2;
        switch (i2) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED /* 351 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str3 = (String) objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                if (iIntValue == 1) {
                    if (j) {
                        return false;
                    }
                    j = true;
                }
                if (!com.uc.crashsdk.g.Z()) {
                    return false;
                }
                File file = new File(str3);
                ArrayList<a> arrayListA = a(file, "crp", 100);
                if (iIntValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (iIntValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.I()));
                        str = "ete";
                        strValueOf = String.valueOf(com.uc.crashsdk.b.J());
                    } else {
                        if (iIntValue == 3) {
                            aVar.a("et", "1");
                        } else {
                            str = iIntValue == 2 ? "hpv" : "ete";
                            aVar.a("prc", com.uc.crashsdk.e.h());
                            if (com.uc.crashsdk.b.F()) {
                                str2 = "1";
                            } else {
                                str2 = "0";
                            }
                            aVar.a(z.c, str2);
                            a(aVar);
                            arrayListA.add(0, aVar);
                        }
                        strValueOf = "1";
                    }
                    aVar.a(str, strValueOf);
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    if (com.uc.crashsdk.b.F()) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    aVar.a(z.c, str2);
                    a(aVar);
                    arrayListA.add(0, aVar);
                }
                if (!arrayListA.isEmpty()) {
                    boolean zC = c(com.uc.crashsdk.e.q(), a((Iterable<a>) arrayListA, true, false).toString());
                    g.b(file);
                    if (!zC) {
                        g.a(file, a((Iterable<a>) arrayListA, false, true).toString());
                    }
                }
                return true;
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT /* 352 */:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS /* 353 */:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY /* 354 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean zC2 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (zC2) {
                    g.b(file2);
                }
                return zC2;
            default:
                return false;
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (!com.uc.crashsdk.g.Q()) {
            return;
        }
        synchronized (f) {
            a aVar = e.get(str);
            if (aVar == null) {
                aVar = new a("cst", false, true);
                e.put(str, aVar);
                a(aVar);
            }
            synchronized (h) {
                if (h.size() == 0) {
                    a(100, "pv");
                    a(102, "hpv");
                    a(1, "all");
                    a(2, "afg");
                    a(101, "abg");
                    a(3, "jfg");
                    a(4, "jbg");
                    a(7, "nfg");
                    a(8, "nbg");
                    a(27, "nafg");
                    a(28, "nabg");
                    a(9, "nho");
                    a(10, "uar");
                    a(29, "ulm");
                    a(30, "ukt");
                    a(31, "uet");
                    a(32, "urs");
                    a(11, "ufg");
                    a(12, "ubg");
                    a(40, "anf");
                    a(41, "anb");
                    a(42, "ancf");
                    a(43, "ancb");
                    a(13, "lup");
                    a(14, "luf");
                    a(15, "lef");
                    a(200, "ltf");
                    a(16, "laf");
                    a(22, "lac");
                    a(23, "lau");
                    a(17, "llf");
                    a(18, "lul");
                    a(19, "lub");
                    a(20, "luc");
                    a(21, "luu");
                    a(24, "lzc");
                    a(201, "lec");
                    a(25, "lrc");
                    a(26, "lss");
                }
            }
            String str2 = h.get(i2);
            if (str2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
            }
            aVar.a("prc", str);
            if (str2 != null) {
                aVar.a(str2, String.valueOf(i3));
            }
        }
    }

    public static void i() {
        if (!com.uc.crashsdk.g.Q()) {
            return;
        }
        f.a(1, new e(303));
    }

    public static void b(boolean z) throws IOException {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "dt.wa";
        com.uc.crashsdk.b.a(f, str, new e(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, new Object[]{str}));
        String strN = n();
        com.uc.crashsdk.b.a(g, strN, new e(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, new Object[]{strN}));
    }

    private static boolean d(String str) {
        boolean zC;
        File file = new File(str);
        for (a aVar : a(file, "cst", 30)) {
            String strA = aVar.a("prc");
            if (!g.a(strA)) {
                a aVar2 = e.get(strA);
                if (aVar2 != null) {
                    aVar2.a(aVar);
                } else {
                    e.put(strA, aVar);
                }
            }
        }
        StringBuilder sbA = a((Iterable<a>) e.values(), true, false);
        if (com.uc.crashsdk.g.aa()) {
            zC = b(com.uc.crashsdk.e.q(), sbA.toString());
        } else {
            zC = c(com.uc.crashsdk.e.q(), sbA.toString());
        }
        g.b(file);
        if (zC || g.a(file, a((Iterable<a>) e.values(), false, true).toString())) {
            e.clear();
        }
        return true;
    }

    private static boolean b(String str, String str2) {
        byte[] bArrA;
        boolean z;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strD = g.d(com.uc.crashsdk.g.e() + str + jCurrentTimeMillis + "AppChk#2014");
        try {
            bArrA = c.a(bytes, strD.substring(strD.length() - 16, strD.length()).getBytes());
            if (bArrA != null) {
                z = true;
            } else {
                bArrA = bytes;
                z = false;
            }
        } catch (Throwable th) {
            g.a(th);
            bArrA = bytes;
            z = false;
        }
        String strSubstring = strD.substring(strD.length() - 8, strD.length());
        StringBuilder sb = new StringBuilder();
        sb.append(com.uc.crashsdk.g.z());
        sb.append("/api/v1/crashtrack/upload?chk=");
        sb.append(strSubstring);
        sb.append("&vno=");
        sb.append(jCurrentTimeMillis);
        sb.append("&uuid=");
        sb.append(str);
        sb.append("&app=");
        sb.append(com.uc.crashsdk.g.e());
        if (z) {
            sb.append("&enc=aes");
        }
        String string = sb.toString();
        return (string == null || (bArrA2 = c.a(string, bArrA)) == null || !new String(bArrA2).contains("retcode=0")) ? false : true;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.Q()) {
            return false;
        }
        return com.uc.crashsdk.b.a(g, n(), new e(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) throws Throwable {
        a aVar;
        File file = new File(n());
        ArrayList<a> arrayListA = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = arrayListA.iterator();
        do {
            if (it.hasNext()) {
                aVar = it.next();
            } else {
                aVar = null;
                break;
            }
        } while (!str3.equals(aVar.b("prc") + aVar.b("typ")));
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            arrayListA.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) arrayListA, false, false).toString());
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) throws Throwable {
        ArrayList<String> arrayListA = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        for (String str2 : arrayListA) {
            a aVar = new a(str, false, false);
            if (aVar.c(str2)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private static String m() {
        return com.uc.crashsdk.g.W() + "pv.wa";
    }

    private static String n() {
        return com.uc.crashsdk.g.W() + "cdt.wa";
    }

    private static boolean c(String str, String str2) {
        byte[] bArrA;
        boolean z;
        String string;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.d());
            bArrA = c.a(bytes, bArr);
            if (bArrA != null) {
                z = true;
            } else {
                bArrA = bytes;
                z = false;
            }
        } catch (Throwable th) {
            g.a(th);
            bArrA = bytes;
            z = false;
        }
        if (str == null) {
            str = "unknown";
        }
        String str3 = com.uc.crashsdk.g.R() ? "4ea4e41a3993" : "28ef1713347d";
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strD = g.d(str3 + str + strValueOf + "AppChk#2014");
        if (strD == null) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(com.uc.crashsdk.g.z());
            sb.append("?chk=");
            sb.append(strD.substring(strD.length() - 8, strD.length()));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(str);
            sb.append("&app=");
            sb.append(str3);
            if (z) {
                sb.append("&enc=aes");
            }
            string = sb.toString();
        }
        return (string == null || (bArrA2 = c.a(string, bArrA)) == null || !new String(bArrA2).contains("retcode=0")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o() {
        for (String str : g.a(new File("/proc/meminfo"), 2)) {
            if (str.contains("MemTotal:")) {
                try {
                    return Long.parseLong(str.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                }
            }
        }
        return 0L;
    }

    static byte[] j() {
        return new byte[]{127, 100, 110, 31};
    }

    static void b(String str) {
        synchronized (k) {
            l = str;
            b.a(com.uc.crashsdk.b.k(), str + "\n");
        }
    }

    public static void k() {
        synchronized (k) {
            l = null;
        }
    }
}
