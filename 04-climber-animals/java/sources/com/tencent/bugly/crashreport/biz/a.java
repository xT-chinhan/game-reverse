package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.ar;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private Context a;
    private long b;
    private int c;
    private boolean d;

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> listA;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (listA = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.a).d)) != null && listA.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listA.size()));
                return;
            }
            long jA = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (jA >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jA));
                userInfoBean.a = jA;
            }
        }
    }

    public a(Context context, boolean z) {
        this.a = context;
        this.d = z;
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null && !aVarA.c().h && i != 1 && i != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.c++;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.c = aVarA2.d;
        userInfoBean.d = aVarA2.g();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = aVarA2.j;
        userInfoBean.o = i == 1 ? 1 : 0;
        userInfoBean.l = aVarA2.a();
        userInfoBean.m = aVarA2.p;
        userInfoBean.g = aVarA2.q;
        userInfoBean.h = aVarA2.r;
        userInfoBean.i = aVarA2.s;
        userInfoBean.k = aVarA2.t;
        userInfoBean.r = aVarA2.z();
        userInfoBean.s = aVarA2.E();
        userInfoBean.p = aVarA2.F();
        userInfoBean.q = aVarA2.G();
        w.a().a(new RunnableC0659a(userInfoBean, z), 0L);
    }

    public final void a() {
        this.b = z.b() + 86400000;
        w.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BUGLY */
    class RunnableC0659a implements Runnable {
        private boolean a;
        private UserInfoBean b;

        public RunnableC0659a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a aVarB;
            try {
                UserInfoBean userInfoBean = this.b;
                if (userInfoBean != null) {
                    if (userInfoBean != null && (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = aVarB.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.a) {
                    a aVar = a.this;
                    w wVarA = w.a();
                    if (wVarA != null) {
                        wVarA.a(aVar.new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x017a  */
    /* JADX WARN: Code duplicated, block: B:102:0x017c  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f2 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0114  */
    /* JADX WARN: Code duplicated, block: B:71:0x0116  */
    /* JADX WARN: Code duplicated, block: B:74:0x011d A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0126 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x012c A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0135 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0139  */
    /* JADX WARN: Code duplicated, block: B:85:0x013c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0146 A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x014f A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0160 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0163 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x016a A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x016d A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    public synchronized void c() {
        boolean z;
        int i;
        ar arVarA;
        byte[] bArrA;
        int i2;
        am amVarA;
        StrategyBean strategyBeanC;
        String str;
        String str2;
        boolean z2;
        if (this.d) {
            u uVarA = u.a();
            if (uVarA == null) {
                return;
            }
            com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
            if (aVarA == null) {
                return;
            }
            if (!aVarA.b() || uVarA.b(1001)) {
                String str3 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
                ArrayList arrayList = new ArrayList();
                final List<UserInfoBean> listA = a(str3);
                if (listA != null) {
                    int size = listA.size() - 20;
                    if (size > 0) {
                        int i3 = 0;
                        while (i3 < listA.size() - 1) {
                            int i4 = i3 + 1;
                            for (int i5 = i4; i5 < listA.size(); i5++) {
                                if (listA.get(i3).e > listA.get(i5).e) {
                                    UserInfoBean userInfoBean = listA.get(i3);
                                    listA.set(i3, listA.get(i5));
                                    listA.set(i5, userInfoBean);
                                }
                            }
                            i3 = i4;
                        }
                        for (int i6 = 0; i6 < size; i6++) {
                            arrayList.add(listA.get(i6));
                        }
                    }
                    Iterator<UserInfoBean> it = listA.iterator();
                    int i7 = 0;
                    while (it.hasNext()) {
                        UserInfoBean next = it.next();
                        if (next.f != -1) {
                            it.remove();
                            if (next.e < z.b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.e > System.currentTimeMillis() - 600000 && (next.b == 1 || next.b == 4 || next.b == 3)) {
                            i7++;
                        }
                    }
                    if (i7 > 15) {
                        x.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i7));
                        z = false;
                    }
                    if (arrayList.size() > 0) {
                        a(arrayList);
                    }
                    if (z && listA.size() != 0) {
                        x.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                        if (this.c == 1) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        arVarA = com.tencent.bugly.proguard.a.a(listA, i);
                        if (arVarA == null) {
                            x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                            return;
                        }
                        bArrA = com.tencent.bugly.proguard.a.a((k) arVarA);
                        if (bArrA == null) {
                            x.d("[UserInfo] Failed to encode data.", new Object[0]);
                            return;
                        }
                        if (uVarA.a) {
                            i2 = 840;
                        } else {
                            i2 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                        }
                        amVarA = com.tencent.bugly.proguard.a.a(this.a, i2, bArrA);
                        if (amVarA == null) {
                            x.d("[UserInfo] Request package is null.", new Object[0]);
                            return;
                        }
                        t tVar = new t() { // from class: com.tencent.bugly.crashreport.biz.a.1
                            @Override // com.tencent.bugly.proguard.t
                            public final void a(boolean z3) {
                                if (z3) {
                                    x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    for (UserInfoBean userInfoBean2 : listA) {
                                        userInfoBean2.f = jCurrentTimeMillis;
                                        a.a(a.this, userInfoBean2, true);
                                    }
                                }
                            }
                        };
                        strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                        if (uVarA.a) {
                            str = strategyBeanC.r;
                        } else {
                            str = strategyBeanC.t;
                        }
                        String str4 = str;
                        if (uVarA.a) {
                            str2 = StrategyBean.b;
                        } else {
                            str2 = StrategyBean.a;
                        }
                        String str5 = str2;
                        u uVarA2 = u.a();
                        if (this.c == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        uVarA2.a(1001, amVarA, str4, str5, tVar, z2);
                        return;
                    }
                    x.c("[UserInfo] There is no user info in local database.", new Object[0]);
                }
                listA = new ArrayList<>();
                z = true;
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                if (z) {
                    x.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                    if (this.c == 1) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    arVarA = com.tencent.bugly.proguard.a.a(listA, i);
                    if (arVarA == null) {
                        x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                        return;
                    }
                    bArrA = com.tencent.bugly.proguard.a.a((k) arVarA);
                    if (bArrA == null) {
                        x.d("[UserInfo] Failed to encode data.", new Object[0]);
                        return;
                    }
                    if (uVarA.a) {
                        i2 = 840;
                    } else {
                        i2 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                    }
                    amVarA = com.tencent.bugly.proguard.a.a(this.a, i2, bArrA);
                    if (amVarA == null) {
                        x.d("[UserInfo] Request package is null.", new Object[0]);
                        return;
                    }
                    t tVar2 = new t() { // from class: com.tencent.bugly.crashreport.biz.a.1
                        @Override // com.tencent.bugly.proguard.t
                        public final void a(boolean z3) {
                            if (z3) {
                                x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                for (UserInfoBean userInfoBean2 : listA) {
                                    userInfoBean2.f = jCurrentTimeMillis;
                                    a.a(a.this, userInfoBean2, true);
                                }
                            }
                        }
                    };
                    strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                    if (uVarA.a) {
                        str = strategyBeanC.r;
                    } else {
                        str = strategyBeanC.t;
                    }
                    String str6 = str;
                    if (uVarA.a) {
                        str2 = StrategyBean.b;
                    } else {
                        str2 = StrategyBean.a;
                    }
                    String str7 = str2;
                    u uVarA3 = u.a();
                    if (this.c == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    uVarA3.a(1001, amVarA, str6, str7, tVar2, z2);
                    return;
                }
                x.c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        }
    }

    public final void b() {
        w wVarA = w.a();
        if (wVarA != null) {
            wVarA.a(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: BUGLY */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < a.this.b) {
                w.a().a(a.this.new b(), (a.this.b - jCurrentTimeMillis) + 5000);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class c implements Runnable {
        private long a;

        public c(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w wVarA = w.a();
            if (wVarA != null) {
                wVarA.a(aVar.new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j = this.a;
            w.a().a(aVar2.new c(j), j);
        }
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursorA;
        try {
            cursorA = p.a().a("t_ui", null, z.a(str) ? null : "_pc = '" + str + "'", null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorA.moveToNext()) {
                    UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            sb.append(" or _id").append(" = ").append(cursorA.getLong(cursorA.getColumnIndex(bz.d)));
                        } catch (Throwable unused) {
                            x.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", string.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            sb.append(" or _id = ").append(list.get(i).a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        String str = string;
        sb.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.a > 0) {
                contentValues.put(bz.d, Long.valueOf(userInfoBean.a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put(bz.e, Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(bz.d));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
