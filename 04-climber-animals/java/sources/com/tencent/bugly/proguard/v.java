package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    private int a;
    private int b;
    private final Context c;
    private final int d;
    private final byte[] e;
    private final com.tencent.bugly.crashreport.common.info.a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;
    private boolean t;

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, z, 2, 30000, z2, null);
    }

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        this.a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = true;
        this.t = false;
        this.c = context;
        this.f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context);
        this.i = u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.s = z;
        this.d = i2;
        if (i3 > 0) {
            this.a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.t = z2;
        this.o = map;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0017  */
    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    private void a(an anVar, boolean z, int i, String str, int i2) {
        String strValueOf;
        int i3 = this.d;
        if (i3 == 630) {
            strValueOf = "crash";
        } else if (i3 == 640) {
            strValueOf = "userinfo";
        } else if (i3 == 830) {
            strValueOf = "crash";
        } else if (i3 != 840) {
            strValueOf = String.valueOf(i3);
        } else {
            strValueOf = "userinfo";
        }
        if (z) {
            x.a("[Upload] Success: %s", strValueOf);
        } else {
            x.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), strValueOf, str);
            if (this.s) {
                this.i.a(i2, (an) null);
            }
        }
        if (this.q + this.r > 0) {
            this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
        }
        t tVar = this.k;
        if (tVar != null) {
            tVar.a(z);
        }
        t tVar2 = this.l;
        if (tVar2 != null) {
            tVar2.a(z);
        }
    }

    private static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        }
        if (anVar.a != 0) {
            x.e("resp result error %d", Byte.valueOf(anVar.a));
            return false;
        }
        try {
            if (!z.a(anVar.d) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(anVar.d)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_ip", anVar.d.getBytes("UTF-8"), (o) null, true);
                aVar.d(anVar.d);
            }
            if (!z.a(anVar.f) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(anVar.f)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_imei", anVar.f.getBytes("UTF-8"), (o) null, true);
                aVar.e(anVar.f);
            }
        } catch (Throwable th) {
            x.a(th);
        }
        aVar.i = anVar.e;
        if (anVar.b == 510) {
            if (anVar.c == null) {
                x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                return false;
            }
            ap apVar = (ap) a.a(anVar.c, ap.class);
            if (apVar == null) {
                x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                return false;
            }
            aVar2.a(apVar);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0343 A[EDGE_INSN: B:100:0x0343->B:105:0x0375 BREAK  A[LOOP:0: B:46:0x013a->B:161:0x013a]] */
    /* JADX WARN: Code duplicated, block: B:154:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0229 A[Catch: all -> 0x0468, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0255 A[Catch: all -> 0x0468, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0263 A[Catch: all -> 0x0468, LOOP:1: B:84:0x025d->B:86:0x0263, LOOP_END, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x02c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x02c2 A[Catch: all -> 0x0468, TRY_ENTER, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02cd A[Catch: all -> 0x0468, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x032a A[Catch: all -> 0x0468, TryCatch #1 {all -> 0x0468, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x005f, B:17:0x0072, B:19:0x0076, B:21:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0092, B:30:0x00b8, B:31:0x00bb, B:33:0x00bf, B:35:0x00f2, B:37:0x00fe, B:39:0x0104, B:41:0x0110, B:43:0x0118, B:45:0x0124, B:46:0x013a, B:49:0x0142, B:51:0x0159, B:52:0x0166, B:54:0x0178, B:55:0x017d, B:58:0x01ae, B:59:0x01c3, B:63:0x01cf, B:66:0x01d6, B:69:0x01de, B:81:0x0229, B:83:0x0255, B:84:0x025d, B:86:0x0263, B:87:0x0284, B:93:0x02c2, B:95:0x02cd, B:96:0x02e2, B:98:0x032a, B:103:0x034b, B:71:0x01e8, B:73:0x01ee, B:74:0x01f6, B:76:0x0204, B:77:0x0210, B:78:0x021d, B:105:0x0375, B:107:0x0387, B:109:0x038a, B:110:0x0392, B:112:0x0398, B:113:0x03b3, B:115:0x03bf, B:117:0x03c7, B:119:0x03d3, B:121:0x03da, B:123:0x03e6, B:125:0x03ee, B:127:0x03fa, B:129:0x03fe, B:130:0x0403, B:134:0x0418, B:136:0x042b, B:138:0x0437, B:133:0x0415, B:140:0x0443, B:142:0x0450, B:144:0x045c), top: B:153:0x0007 }] */
    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.bugly.crashreport.common.strategy.a aVar;
        byte[] bArrA;
        Map<String, String> map;
        boolean z;
        long j;
        int i;
        String str = "Bugly-Version";
        int length = 0;
        try {
            this.p = 0;
            this.q = 0L;
            this.r = 0L;
            byte[] bArrA2 = this.e;
            if (com.tencent.bugly.crashreport.common.info.b.e(this.c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArrA2 != null && bArrA2.length != 0) {
                long jA = this.i.a(this.t);
                int i2 = 2;
                int i3 = 1;
                if (((long) bArrA2.length) + jA >= com.anythink.basead.exoplayer.j.a.c.a) {
                    x.e("[Upload] Upload too much data, try next time: %d/%d", Long.valueOf(jA), Long.valueOf(com.anythink.basead.exoplayer.j.a.c.a));
                    a(null, false, 0, "over net consume: 2048K", 0);
                    return;
                }
                x.c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.d));
                if (this.c != null && this.f != null && (aVar = this.g) != null && this.h != null) {
                    StrategyBean strategyBeanC = aVar.c();
                    if (strategyBeanC == null) {
                        a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("prodId", this.f.f());
                    map2.put("bundleId", this.f.c);
                    map2.put("appVer", this.f.j);
                    Map<String, String> map3 = this.o;
                    if (map3 != null) {
                        map2.putAll(map3);
                    }
                    if (this.s) {
                        map2.put("cmd", Integer.toString(this.d));
                        map2.put("platformId", Byte.toString((byte) 1));
                        this.f.getClass();
                        map2.put("sdkVer", "2.6.5");
                        map2.put("strategylastUpdateTime", Long.toString(strategyBeanC.p));
                        if (!this.i.a(map2)) {
                            a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] bArrA3 = z.a(bArrA2, 2);
                        if (bArrA3 == null) {
                            a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArrA2 = this.i.a(bArrA3);
                        if (bArrA2 == null) {
                            a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    this.i.a(this.j, System.currentTimeMillis());
                    t tVar = this.k;
                    t tVar2 = this.l;
                    int i4 = 0;
                    int i5 = -1;
                    String strA = this.m;
                    i3 = 0;
                    while (true) {
                        i4++;
                        if (i4 < this.a) {
                            if (i4 > 1) {
                                x.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i4));
                                z.b(this.b);
                                if (i4 == this.a) {
                                    x.d("[Upload] Use the back-up url at the last time: %s", this.n);
                                    strA = this.n;
                                }
                            }
                            x.c("[Upload] Send %d bytes", Integer.valueOf(bArrA2.length));
                            if (this.s) {
                                strA = a(strA);
                            }
                            Object[] objArr = new Object[4];
                            objArr[0] = strA;
                            objArr[1] = Integer.valueOf(this.d);
                            objArr[i2] = Integer.valueOf(Process.myPid());
                            objArr[3] = Integer.valueOf(Process.myTid());
                            x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", objArr);
                            bArrA = this.h.a(strA, bArrA2, this, map2);
                            if (bArrA == null) {
                                Object[] objArr2 = new Object[i2];
                                objArr2[0] = 1;
                                objArr2[1] = "Failed to upload for no response!";
                                x.e("[Upload] Failed to upload(%d): %s", objArr2);
                                i3 = 1;
                                i4 = i4;
                            } else {
                                map = this.h.a;
                                if (!this.s) {
                                    break;
                                }
                                if (map == null || map.size() == 0) {
                                    x.d("[Upload] Headers is empty.", new Object[0]);
                                } else if (map.containsKey("status")) {
                                    if (map.containsKey(str)) {
                                        String str2 = map.get(str);
                                        if (str2.contains("bugly")) {
                                            str = str;
                                            x.c("[Upload] Bugly version from headers is: %s", str2);
                                            z = true;
                                        } else {
                                            x.d("[Upload] Bugly version is not valid: %s", str2);
                                        }
                                    } else {
                                        x.d("[Upload] Headers does not contain %s", str);
                                    }
                                    if (!z) {
                                        x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                        if (map != null) {
                                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                                x.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                            }
                                        }
                                        x.c("[Upload] Failed to upload for no status header.", new Object[0]);
                                    } else {
                                        try {
                                            i = Integer.parseInt(map.get("status"));
                                            try {
                                                x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                if (i != 0) {
                                                    i5 = i;
                                                    break;
                                                }
                                                if (i == 2) {
                                                    if (this.q + this.r > 0) {
                                                        this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                                    }
                                                    this.i.a(i, (an) null);
                                                    x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                    this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.a, this.b, true, this.o);
                                                    return;
                                                }
                                                a(null, false, 1, "status of server is " + i, i);
                                                return;
                                            } catch (Throwable unused) {
                                                j = 0;
                                                i5 = i;
                                                x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i5));
                                                i2 = 2;
                                            }
                                        } catch (Throwable unused2) {
                                            j = 0;
                                        }
                                    }
                                    i2 = 2;
                                } else {
                                    x.d("[Upload] Headers does not contain %s", "status");
                                }
                                z = false;
                                if (!z) {
                                    x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                    if (map != null) {
                                        while (r1.hasNext()) {
                                            x.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                        }
                                    }
                                    x.c("[Upload] Failed to upload for no status header.", new Object[0]);
                                } else {
                                    i = Integer.parseInt(map.get("status"));
                                    x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    if (i != 0) {
                                        i5 = i;
                                        break;
                                    }
                                    if (i == 2) {
                                        if (this.q + this.r > 0) {
                                            this.i.a(this.i.a(this.t) + this.q + this.r, this.t);
                                        }
                                        this.i.a(i, (an) null);
                                        x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.a, this.b, true, this.o);
                                        return;
                                    }
                                    a(null, false, 1, "status of server is " + i, i);
                                    return;
                                }
                                i2 = 2;
                            }
                        } else {
                            a(null, false, i3, "failed after many attempts", 0);
                            return;
                        }
                    }
                    x.c("[Upload] Received %d bytes", Integer.valueOf(bArrA.length));
                    if (this.s) {
                        if (bArrA.length == 0) {
                            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                                x.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] bArrB = this.i.b(bArrA);
                        if (bArrB == null) {
                            a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        bArrA = z.b(bArrB, 2);
                        if (bArrA == null) {
                            a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    an anVarA = a.a(bArrA, this.s);
                    if (anVarA == null) {
                        a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.s) {
                        this.i.a(i5, anVarA);
                    }
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(anVarA.b);
                    if (anVarA.c != null) {
                        length = anVarA.c.length;
                    }
                    objArr3[1] = Integer.valueOf(length);
                    x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr3);
                    if (!a(anVarA, this.f, this.g)) {
                        a(anVarA, false, 2, "failed to process response package", 0);
                        return;
                    } else {
                        a(anVarA, true, 2, "successfully uploaded", 0);
                        return;
                    }
                }
                a(null, false, 0, "illegal access error", 0);
                return;
            }
            a(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
