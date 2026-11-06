package com.anythink.dlopt.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.dlopt.common.a.g;
import com.anythink.dlopt.common.a.i;
import com.anythink.dlopt.common.a.j;
import com.anythink.dlopt.common.a.m;
import com.anythink.dlopt.common.a.n;
import com.anythink.dlopt.common.service.ApkDownloadService;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements n {
    public static final String a = "b";
    public static final String b = "at_offer_action_1";
    public static final String c = "at_offer_action_2";
    public static final String d = "at_offer_action_3";
    public static final String e = "at_offer_action_4";
    public static final String f = "receiver_extra_offer_id";
    public static final String g = "receiver_extra_click_id";
    private static volatile b h = null;
    private static final int r = 2;
    private Context i;
    private ConcurrentHashMap<String, j> n;
    private ConcurrentHashMap<String, j> o;
    private ConcurrentHashMap<String, j> p;
    private ConcurrentHashMap<String, j> q;
    private BroadcastReceiver s;
    private ApkDownloadService.a t;
    private BroadcastReceiver u;
    private com.anythink.dlopt.common.a.d w;
    private i x;
    private g y;
    private m z;
    private ServiceConnection v = new ServiceConnection() { // from class: com.anythink.dlopt.common.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = b.a;
            try {
                b.this.t = (ApkDownloadService.a) iBinder;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            String str = b.a;
            b.this.t = null;
        }
    };
    private List<j> j = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, j> k = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, j> l = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, com.anythink.dlopt.common.a.a.InterfaceC0112a> m = new ConcurrentHashMap<>();

    @Override // com.anythink.dlopt.common.a.n
    public final int a() {
        return 2;
    }

    private b(Context context) {
        if (context == null) {
            return;
        }
        this.i = context.getApplicationContext();
        this.w = new com.anythink.dlopt.common.a.d(this.i, com.anythink.core.common.e.g.a(context));
        this.x = new i();
        this.y = new g(this);
        String strA = com.anythink.dlopt.common.c.b.a();
        if (!TextUtils.isEmpty(strA)) {
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            this.u = new BroadcastReceiver() { // from class: com.anythink.dlopt.common.b.7
                @Override // android.content.BroadcastReceiver
                public final void onReceive(final Context context2, Intent intent) {
                    com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.dlopt.common.b.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                                if (connectivityManager == null || !q.a(com.kuaishou.weapon.p0.g.b, context2)) {
                                    return;
                                }
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (q.a(context2) && activeNetworkInfo.getType() == 1) {
                                    b.this.g();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }, 13);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.i.registerReceiver(this.u, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public static b a(Context context) {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b(context);
                }
            }
        }
        return h;
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(final Context context, final x xVar, final w wVar, final String str, final String str2, final Runnable runnable, final com.anythink.core.common.k.b bVar) {
        Object[] objArr = new Object[2];
        wVar.I();
        if (com.anythink.dlopt.common.c.a.a(context, wVar.I())) {
            com.anythink.dlopt.common.c.a.c(context, wVar.I());
            return;
        }
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a(new Runnable() { // from class: com.anythink.dlopt.common.b.8
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(b.this, context, xVar, wVar, str, str2, runnable, bVar);
                }
            });
        }
    }

    private void b(Context context, x xVar, w wVar, String str, String str2, Runnable runnable, com.anythink.core.common.k.b bVar) {
        if (runnable != null) {
            runnable.run();
        }
        j jVar = new j();
        jVar.o = p.a(wVar);
        jVar.a = xVar.d;
        jVar.f = wVar.v();
        jVar.b = str;
        jVar.n = str2;
        jVar.e = wVar.I();
        jVar.c = wVar.x();
        jVar.j = wVar;
        jVar.k = xVar;
        if (xVar.o != null) {
            jVar.p = xVar.o.n() == 1;
            jVar.r = xVar.o.T();
            jVar.q = xVar.o.S();
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        jVar.d = com.anythink.core.common.res.b.a(context).a(new e(1, wVar.z()), iApplyDimension, iApplyDimension);
        if (wVar.G() != null) {
            jVar.l = wVar.G().replaceAll("\\{req_id\\}", xVar.d == null ? "" : xVar.d);
        }
        jVar.m = bVar;
        jVar.a(com.anythink.dlopt.common.c.b.b(jVar.o));
        jVar.b(xVar.b);
        jVar.c(xVar.c);
        jVar.d(String.valueOf(xVar.f));
        ConcurrentHashMap<String, j> concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(jVar.o);
        }
        ConcurrentHashMap<String, j> concurrentHashMap2 = this.q;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(jVar.o);
        }
        String str3 = jVar.o;
        if (com.anythink.dlopt.common.c.a.a(str3)) {
            this.w.a(str3, new AnonymousClass9(jVar));
        } else {
            c(jVar);
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.b$9, reason: invalid class name */
    final class AnonymousClass9 implements com.anythink.dlopt.common.a.d.a {
        final /* synthetic */ j a;

        AnonymousClass9(j jVar) {
            this.a = jVar;
        }

        @Override // com.anythink.dlopt.common.a.d.a
        public final void onCallback(j jVar) {
            if (jVar != null) {
                this.a.a(jVar.t());
                this.a.b(jVar.u());
                this.a.c(jVar.z());
                this.a.d(jVar.A());
                this.a.e(jVar.B());
                this.a.f(jVar.C());
                this.a.f(jVar.D());
                this.a.a(jVar.r());
                this.a.a(jVar.q());
                this.a.h = jVar.h;
                this.a.i = jVar.i;
            }
            b.this.c(this.a);
        }
    }

    private void d(j jVar) {
        c(jVar, -1);
    }

    private synchronized void c(j jVar, int i) {
        if (jVar == null) {
            return;
        }
        Object[] objArr = new Object[1];
        try {
            List<j> list = this.j;
            if (list != null) {
                synchronized (list) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.j.size()) {
                            i2 = -1;
                            break;
                        }
                        j jVar2 = this.j.get(i2);
                        if (jVar2 != null && jVar2.o.equals(jVar.o)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        this.j.remove(i2);
                    }
                    if (i >= 0 && i <= this.j.size()) {
                        this.j.add(i, jVar);
                    } else {
                        this.j.add(jVar);
                    }
                }
                com.anythink.dlopt.common.b.a.a(this.i).b(jVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final boolean a(String str) {
        return com.anythink.dlopt.common.c.a.a(str);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    @Override // com.anythink.dlopt.common.a.n
    public final synchronized void b() {
        j jVar;
        if (this.j.size() == 0) {
            return;
        }
        int size = this.k.size();
        if (size > 0) {
            Iterator<String> it = this.k.keySet().iterator();
            if (it.hasNext()) {
                jVar = this.k.get(it.next());
            } else {
                jVar = null;
            }
        } else {
            jVar = null;
        }
        Object[] objArr = new Object[1];
        Integer.valueOf(this.j.size());
        final j jVarRemove = this.j.remove(0);
        Object[] objArr2 = new Object[4];
        Integer.valueOf(size);
        Integer.valueOf(2);
        Long.valueOf(jVarRemove.h);
        if (size >= 2) {
            Object[] objArr3 = new Object[2];
            Integer.valueOf(size);
            Integer.valueOf(2);
            e(jVarRemove);
            return;
        }
        if (jVar != null) {
            long jP = jVarRemove.p();
            final long jP2 = jVar.p();
            Object[] objArr4 = new Object[2];
            Long.valueOf(jP);
            Long.valueOf(jP2);
            if (jVarRemove.h == 0) {
                this.w.a(jVarRemove, new com.anythink.dlopt.common.a.d.a() { // from class: com.anythink.dlopt.common.b.10
                    @Override // com.anythink.dlopt.common.a.d.a
                    public final void onCallback(j jVar2) {
                        long j = jVar2.h;
                        String str = b.a;
                        Object[] objArr5 = new Object[2];
                        Long.valueOf(j);
                        Long.valueOf(jP2);
                        if (j <= jP2) {
                            b.this.f(jVar2);
                        } else {
                            b.this.e(jVarRemove);
                        }
                    }
                });
                return;
            } else if (jP <= jP2) {
                f(jVarRemove);
                return;
            } else {
                e(jVarRemove);
                return;
            }
        }
        f(jVarRemove);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        try {
            Object[] objArr = new Object[1];
            jVar.f();
            c(jVar, -1);
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final j jVar) {
        if (com.anythink.dlopt.common.c.a.a(jVar.o)) {
            jVar.m();
            j(jVar);
            com.anythink.dlopt.common.a.d dVar = this.w;
            if (dVar != null) {
                dVar.d(jVar);
                return;
            }
            return;
        }
        if (this.k == null) {
            return;
        }
        final String str = jVar.o;
        if (this.k.containsKey(str)) {
            return;
        }
        this.k.put(str, jVar);
        this.m.put(str, new com.anythink.dlopt.common.a.a.InterfaceC0112a() { // from class: com.anythink.dlopt.common.b.11
            @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
            public final void a(j jVar2, long j, long j2) {
                String str2 = b.a;
                Object[] objArr = new Object[4];
                String str3 = jVar2.o;
                Long.valueOf(j);
                Long.valueOf(j2);
                Integer.valueOf(b.this.j.size());
                if (b.this.k != null) {
                    b.this.k.put(jVar2.o, jVar2);
                }
                if (j < j2) {
                    b.this.d("正在下载： " + jVar2.c);
                    com.anythink.dlopt.common.b.a.a(b.this.i).a(true, jVar2, j, j2);
                }
                b.c(b.this, jVar2);
                b.this.a(b.b, jVar2);
                b.this.h(jVar2);
                com.anythink.core.common.u.e.a(jVar2.a, jVar2.f, jVar2.b, 1, (String) null, 0L, j2, jVar2.j != null ? jVar2.j.ap() : null, jVar2.j != null ? jVar2.j.aq() : null);
            }

            @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
            public final void a(j jVar2, long j) {
                if (jVar2 == null) {
                    return;
                }
                String str2 = b.a;
                Object[] objArr = new Object[2];
                String str3 = jVar2.o;
                Long.valueOf(j);
                com.anythink.dlopt.common.b.a.a(b.this.i).a(jVar2);
                b.this.j(jVar2);
                b.c(b.this, jVar2);
                b.this.a(b.c, jVar2);
                b.this.m.remove(jVar2.o);
                b.this.k.remove(jVar2.o);
                if (b.this.n == null) {
                    b.this.n = new ConcurrentHashMap();
                }
                b.this.n.put(jVar2.o, jVar2);
                b.this.b();
                b.this.h(jVar2);
                com.anythink.core.common.u.e.a(jVar2.a, jVar2.f, jVar2.b, 2, (String) null, j, jVar2.h, jVar2.j != null ? jVar2.j.ap() : null, jVar2.j != null ? jVar2.j.aq() : null);
                com.anythink.core.common.u.e.a(jVar2.a, jVar2.v(), jVar2.u(), jVar2.x(), jVar2.w(), p.b(jVar2.j), jVar2.f, jVar2.s(), jVar2.e, jVar2.r(), jVar2.B(), String.valueOf(jVar2.A()), jVar2.z(), jVar2.h, jVar2.i, jVar2.j != null ? jVar2.j.ap() : null, jVar2.j != null ? jVar2.j.aq() : null);
            }

            @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
            public final void b(j jVar2, long j, long j2) {
                if (jVar2 == null) {
                    return;
                }
                com.anythink.dlopt.common.b.a.a(b.this.i).a(false, jVar2, j, j2);
                if (b.this.w != null) {
                    b.this.w.b(jVar2);
                }
                if (b.this.k != null) {
                    if (jVar2.z() != 2) {
                        jVar2.c(b.this.k.size() < 2 ? 1 : 2);
                    }
                }
            }

            @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
            public final void a(j jVar2, String str2) {
                if (jVar2 == null) {
                    return;
                }
                jVar2.e(4);
                String str3 = b.a;
                Object[] objArr = new Object[2];
                String str4 = jVar2.o;
                b.this.d("下载失败： " + jVar2.c);
                com.anythink.dlopt.common.b.a.a(b.this.i).a(true, jVar2, 0L, 100L);
                b.c(b.this, jVar2);
                b.this.m.remove(jVar2.o);
                b.this.k.remove(jVar2.o);
                if (b.this.q == null) {
                    b.this.q = new ConcurrentHashMap();
                }
                b.this.q.put(jVar2.o, jVar2);
                b.this.b();
                b.this.h(jVar2);
                com.anythink.core.common.u.e.a(jVar2.a, jVar2.f, jVar2.b, 3, str2, 0L, jVar2.h, jVar2.j != null ? jVar2.j.ap() : null, jVar2.j != null ? jVar2.j.aq() : null);
            }

            @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
            public final void a(j jVar2, long j, long j2, int i) {
                String str2 = b.a;
                Object[] objArr = new Object[4];
                String str3 = jVar2.o;
                Long.valueOf(j);
                Long.valueOf(j2);
                Integer.valueOf(i);
                jVar2.e(2);
                b.c(b.this, jVar2);
                b.this.k.remove(jVar2.o);
                if (i == 2) {
                    com.anythink.dlopt.common.b.a.a(b.this.i).a(true, jVar2, j, j2);
                    if (b.this.l != null) {
                        b.this.l.put(jVar2.o, jVar2);
                    }
                    b.this.b();
                }
                b.this.h(jVar2);
            }
        });
        Object[] objArr = new Object[1];
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.12
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    jVar.f();
                    if (b.this.t != null) {
                        b.this.t.a(str);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(b.this.i, ApkDownloadService.class);
                    intent.putExtra(ApkDownloadService.a, str);
                    b.this.i.bindService(intent, b.this.v, 1);
                } catch (Throwable th) {
                    String str2 = b.a;
                    Object[] objArr2 = new Object[2];
                    th.getMessage();
                }
            }
        });
    }

    @Override // com.anythink.dlopt.common.a.n
    public final boolean c() {
        return this.i.getPackageManager().canRequestPackageInstalls();
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void d() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.i.getPackageName()));
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        this.i.startActivity(intent);
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(final j jVar) {
        if (this.o == null) {
            this.o = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(jVar.e)) {
            String strG = g(jVar);
            if (!TextUtils.isEmpty(strG)) {
                jVar.e = com.anythink.dlopt.common.c.a.a(this.i, new File(strG));
            }
        }
        this.o.put(jVar.e, jVar);
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.13
            @Override // java.lang.Runnable
            public final void run() {
                y yVarR;
                String str = b.a;
                Object[] objArr = new Object[1];
                b.this.a(b.d, jVar);
                w wVar = jVar.j;
                if (wVar != null && (yVarR = wVar.r()) != null && yVarR.bv() == 1) {
                    b.k(b.this);
                }
                b.this.b(jVar);
                b.this.h(jVar);
            }
        });
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void b(j jVar) {
        Uri uriForFile;
        String strG = g(jVar);
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        com.anythink.core.common.u.e.a(jVar.a, jVar.v(), jVar.x(), jVar.w(), p.b(jVar.j), jVar.f, jVar.e, jVar.y(), jVar.j != null ? jVar.j.ap() : null, jVar.j != null ? jVar.j.aq() : null);
        Object[] objArr = new Object[1];
        File file = new File(strG);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            intent.addFlags(1);
            try {
                uriForFile = FileProvider.getUriForFile(this.i, this.i.getPackageName() + ".anythink.fileProvider", file);
            } catch (Throwable th) {
                th.printStackTrace();
                uriForFile = null;
            }
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            this.i.startActivity(intent);
            com.anythink.core.common.u.e.a(jVar.a, jVar.f, jVar.b, 4, (String) null, 0L, file.length(), jVar.j != null ? jVar.j.ap() : null, jVar.j != null ? jVar.j.aq() : null);
        } catch (Throwable th2) {
            com.anythink.core.common.u.e.a(jVar.a, jVar.f, jVar.b, 10, th2.getMessage(), 0L, file.length(), jVar.j != null ? jVar.j.ap() : null, jVar.j != null ? jVar.j.aq() : null);
            Object[] objArr2 = new Object[1];
            th2.getMessage();
        }
    }

    private static String g(j jVar) {
        return jVar != null ? jVar.s() : "";
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void e() {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a((Runnable) null);
            this.w.a();
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final synchronized void c(j jVar) {
        j jVarRemove;
        if (jVar == null) {
            return;
        }
        Object[] objArr = new Object[1];
        try {
            if (com.anythink.dlopt.common.c.a.a(jVar.o)) {
                jVar.m();
                j(jVar);
                com.anythink.dlopt.common.a.d dVar = this.w;
                if (dVar != null) {
                    dVar.d(jVar);
                }
                return;
            }
            ConcurrentHashMap<String, j> concurrentHashMap = this.k;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(jVar.o)) {
                jVar.j();
                d("正在下载中： " + jVar.c);
                return;
            }
            ConcurrentHashMap<String, j> concurrentHashMap2 = this.l;
            if (concurrentHashMap2 != null && (jVarRemove = concurrentHashMap2.remove(jVar.o)) != null) {
                boolean zA = com.anythink.dlopt.common.c.a.a(jVarRemove);
                Object[] objArr2 = new Object[2];
                String str = jVarRemove.o;
                Boolean.valueOf(zA);
                if (zA) {
                    d("广告已失效，请刷新");
                    com.anythink.dlopt.common.b.a.a(this.i).e(jVar);
                    return;
                } else {
                    c(jVarRemove, 0);
                    b();
                    return;
                }
            }
            c(jVar, -1);
            b();
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(String str, String str2, int i) {
        ApkDownloadService.a aVar;
        j jVar;
        j jVar2;
        j jVarRemove;
        Object[] objArr = new Object[3];
        Integer.valueOf(i);
        try {
            if (str2.equals(com.anythink.dlopt.common.a.c.e.FAIL.toString())) {
                ConcurrentHashMap<String, j> concurrentHashMap = this.q;
                if (concurrentHashMap == null || (jVarRemove = concurrentHashMap.remove(str)) == null) {
                    return;
                }
                String str3 = jVarRemove.c;
                c(jVarRemove);
                return;
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.FINISH.toString())) {
                ConcurrentHashMap<String, j> concurrentHashMap2 = this.n;
                if (concurrentHashMap2 == null || (jVar2 = concurrentHashMap2.get(str)) == null) {
                    return;
                }
                String str4 = jVar2.c;
                com.anythink.dlopt.common.b.a.a(this.i).a(jVar2);
                j(jVar2);
                return;
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.INSTALLED.toString())) {
                ConcurrentHashMap<String, j> concurrentHashMap3 = this.p;
                if (concurrentHashMap3 == null || (jVar = concurrentHashMap3.get(str)) == null) {
                    return;
                }
                String str5 = jVar.c;
                com.anythink.dlopt.common.b.a.a(this.i).e(jVar);
                a(jVar, 2);
                return;
            }
            j jVarRemove2 = null;
            if (str2.equals(com.anythink.dlopt.common.a.c.e.LOADING.toString())) {
                ConcurrentHashMap<String, j> concurrentHashMap4 = this.k;
                jVarRemove2 = concurrentHashMap4 != null ? concurrentHashMap4.remove(str) : null;
                if (jVarRemove2 == null || !jVarRemove2.e()) {
                    return;
                }
                new StringBuilder("onClickNotification() >>> (").append(jVarRemove2.c).append(") : loading -> pause, downloadType: ").append(jVarRemove2.r).append(" ").append(jVarRemove2);
                if (jVarRemove2.r == 2 || (aVar = this.t) == null) {
                    return;
                }
                aVar.b(jVarRemove2.o);
                return;
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.PAUSE.toString())) {
                j jVar3 = this.l.get(str);
                if (jVar3 != null) {
                    new StringBuilder("onClickNotification() >>> (").append(jVar3.c).append(") : pause -> loading. ").append(jVar3);
                    c(jVar3);
                    return;
                }
                return;
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.IDLE.toString())) {
                Object[] objArr2 = new Object[1];
                Integer.valueOf(this.j.size());
                synchronized (this.j) {
                    for (j jVar4 : this.j) {
                        if (jVar4.o.equals(str)) {
                            if (jVar4.r != 2) {
                                jVarRemove2 = jVar4;
                                break;
                            }
                            return;
                        }
                    }
                    Object[] objArr3 = new Object[1];
                    if (jVarRemove2 != null) {
                        jVarRemove2.l();
                        this.k.remove(str);
                        this.j.remove(jVarRemove2);
                        this.l.put(jVarRemove2.o, jVarRemove2);
                        com.anythink.dlopt.common.b.a.a(this.i).e(jVarRemove2);
                        if (jVarRemove2.h > 0) {
                            com.anythink.dlopt.common.b.a.a(this.i).a(jVarRemove2, jVarRemove2.g, jVarRemove2.h, true);
                            return;
                        } else {
                            com.anythink.dlopt.common.b.a.a(this.i).a(jVarRemove2, 0L, 100L, true);
                            return;
                        }
                    }
                    com.anythink.dlopt.common.b.a.a(this.i).a(i);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(String str, String str2) {
        j jVar;
        ConcurrentHashMap<String, j> concurrentHashMap;
        ConcurrentHashMap<String, j> concurrentHashMap2;
        ConcurrentHashMap<String, j> concurrentHashMap3;
        try {
            if (str2.equals(com.anythink.dlopt.common.a.c.e.FAIL.toString()) && (concurrentHashMap3 = this.q) != null && concurrentHashMap3.containsKey(str)) {
                j jVar2 = this.q.get(str);
                String str3 = jVar2.c;
                com.anythink.dlopt.common.b.a.a(this.i).e(jVar2);
                this.q.remove(str);
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.FINISH.toString()) && (concurrentHashMap2 = this.n) != null && concurrentHashMap2.containsKey(str)) {
                j jVar3 = this.n.get(str);
                String str4 = jVar3.c;
                com.anythink.dlopt.common.b.a.a(this.i).e(jVar3);
                this.n.remove(str);
            }
            if (str2.equals(com.anythink.dlopt.common.a.c.e.INSTALLED.toString()) && (concurrentHashMap = this.p) != null && concurrentHashMap.containsKey(str)) {
                j jVar4 = this.p.get(str);
                String str5 = jVar4.c;
                com.anythink.dlopt.common.b.a.a(this.i).e(jVar4);
                this.p.remove(str);
            }
            if (!str2.equals(com.anythink.dlopt.common.a.c.e.PAUSE.toString()) || (jVar = this.l.get(str)) == null) {
                return;
            }
            ApkDownloadService.a aVar = this.t;
            if (aVar != null) {
                aVar.c(jVar.o);
            }
            this.l.remove(str);
            String str6 = jVar.c;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(int i) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.q;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value = it.next().getValue();
                value.d(i);
                Object[] objArr = new Object[1];
                c(value);
                it.remove();
            }
        }
    }

    public final void b(String str) {
        j jVar;
        try {
            if (this.o.containsKey(str) && (jVar = this.o.get(str)) != null) {
                String strG = g(jVar);
                if (!TextUtils.isEmpty(strG)) {
                    new File(strG).delete();
                }
                jVar.n();
                this.o.remove(str);
                if (this.p == null) {
                    this.p = new ConcurrentHashMap<>();
                }
                this.p.put(jVar.o, jVar);
                ConcurrentHashMap<String, j> concurrentHashMap = this.n;
                if (concurrentHashMap != null) {
                    concurrentHashMap.remove(jVar.o);
                }
                com.anythink.dlopt.common.b.a.a(this.i).c(jVar);
                a(e, jVar);
                com.anythink.core.common.u.e.a(jVar.a, jVar.f, jVar.b, 5, (String) null, 0L, 0L, jVar.j != null ? jVar.j.ap() : null, jVar.j != null ? jVar.j.aq() : null);
                if (jVar.D() != 1) {
                    com.anythink.core.common.u.e.a(jVar.a, jVar.k, jVar.v(), jVar.x(), jVar.w(), p.b(jVar.j), jVar.f, jVar.e, jVar.u() > 0 ? System.currentTimeMillis() - jVar.u() : 0L, 1, 1);
                    jVar.f(1);
                }
                if (this.o.size() == 0) {
                    try {
                        BroadcastReceiver broadcastReceiver = this.s;
                        if (broadcastReceiver != null) {
                            this.i.unregisterReceiver(broadcastReceiver);
                            this.s = null;
                        }
                    } catch (Throwable unused) {
                    }
                }
                h(jVar);
                a(jVar, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void j() {
        try {
            if (this.s != null) {
                return;
            }
            this.s = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.i.registerReceiver(this.s, intentFilter);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            BroadcastReceiver broadcastReceiver = this.s;
            if (broadcastReceiver != null) {
                this.i.unregisterReceiver(broadcastReceiver);
                this.s = null;
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(w wVar) {
        String strA = p.a(wVar);
        ConcurrentHashMap<String, j> concurrentHashMap = this.k;
        return concurrentHashMap != null && concurrentHashMap.containsKey(strA);
    }

    public final Map<String, j> f() {
        return this.k;
    }

    public final com.anythink.dlopt.common.a.a.InterfaceC0112a c(String str) {
        return this.m.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.14
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Toast.makeText(b.this.i, str, 0).show();
                } catch (Throwable th) {
                    String str2 = b.a;
                    Object[] objArr = new Object[2];
                    th.getMessage();
                }
            }
        });
    }

    public final int b(w wVar) {
        String strA = p.a(wVar);
        synchronized (this.j) {
            for (int i = 0; i < this.j.size(); i++) {
                j jVar = this.j.get(i);
                if (jVar != null && jVar.o.equals(strA)) {
                    return 0;
                }
            }
            ConcurrentHashMap<String, j> concurrentHashMap = this.k;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(strA)) {
                return 0;
            }
            ConcurrentHashMap<String, j> concurrentHashMap2 = this.l;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(strA)) {
                return 6;
            }
            ConcurrentHashMap<String, j> concurrentHashMap3 = this.n;
            if ((concurrentHashMap3 == null || !concurrentHashMap3.containsKey(strA)) && !com.anythink.dlopt.common.c.a.a(strA)) {
                return com.anythink.dlopt.common.c.a.a(this.i, wVar.I()) ? 5 : 1;
            }
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(j jVar) {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a(jVar);
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void g() {
        Object[] objArr = new Object[1];
        Integer.valueOf(1);
        ConcurrentHashMap<String, j> concurrentHashMap = this.q;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value = it.next().getValue();
                value.d(1);
                Object[] objArr2 = new Object[1];
                c(value);
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.b$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.dlopt.common.a.d.b {
        final /* synthetic */ int a;

        private AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // com.anythink.dlopt.common.a.d.b
        public final void a(List<j> list) {
            int i;
            String str = b.a;
            Object[] objArr = new Object[1];
            Integer.valueOf(list.size());
            if (list.size() == 0) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                j jVar = list.get(i2);
                if (jVar != null) {
                    if (b.this.k == null || !b.this.k.containsKey(jVar.o)) {
                        if (b.this.l != null && b.this.l.containsKey(jVar.o)) {
                            String str2 = b.a;
                            Object[] objArr2 = new Object[1];
                            String str3 = jVar.o;
                        } else {
                            if (!jVar.i()) {
                                if (jVar.e()) {
                                    i = 3;
                                } else {
                                    i = (jVar.c() || jVar.d()) ? 2 : 5;
                                }
                                jVar.e(i);
                            }
                            jVar.d(this.a);
                            b.this.c(jVar);
                        }
                    } else {
                        String str4 = b.a;
                        Object[] objArr3 = new Object[1];
                        String str5 = jVar.o;
                    }
                }
            }
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(com.anythink.dlopt.common.a.d.b bVar) {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(final j jVar, int i) {
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        if (this.x != null) {
            i.a(jVar, i, new com.anythink.core.common.k.c() { // from class: com.anythink.dlopt.common.b.3
                @Override // com.anythink.core.common.k.c
                public final void a(boolean z) {
                    String str = b.a;
                    Object[] objArr2 = new Object[1];
                    Boolean.valueOf(z);
                    if (!z || b.this.w == null) {
                        return;
                    }
                    b.this.w.c(jVar);
                }
            });
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void b(j jVar, int i) {
        g gVar = this.y;
        if (gVar != null) {
            gVar.a(jVar, i);
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(m mVar) {
        this.z = mVar;
    }

    @Override // com.anythink.dlopt.common.a.n
    public final void a(String str, final com.anythink.dlopt.common.a.d.a aVar) {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a(str, new com.anythink.dlopt.common.a.d.a() { // from class: com.anythink.dlopt.common.b.4
                @Override // com.anythink.dlopt.common.a.d.a
                public final void onCallback(j jVar) {
                    if (jVar != null && jVar.e() && (b.this.k == null || !b.this.k.containsKey(jVar.o))) {
                        jVar.l();
                    }
                    com.anythink.dlopt.common.a.d.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onCallback(jVar);
                    }
                }
            });
        }
    }

    @Override // com.anythink.dlopt.common.a.n
    public final com.anythink.dlopt.common.a.c.e c(w wVar) {
        ConcurrentHashMap<String, j> concurrentHashMap;
        if (wVar != null) {
            String strA = p.a(wVar);
            j jVar = null;
            if (!TextUtils.isEmpty(strA)) {
                int i = 0;
                while (true) {
                    if (i < this.j.size()) {
                        j jVar2 = this.j.get(i);
                        if (jVar2 != null && jVar2.o.equals(strA)) {
                            jVar = jVar2;
                            break;
                        }
                        i++;
                    } else {
                        ConcurrentHashMap<String, j> concurrentHashMap2 = this.k;
                        jVar = concurrentHashMap2 != null ? concurrentHashMap2.get(strA) : null;
                        if (jVar != null) {
                            break;
                        }
                        ConcurrentHashMap<String, j> concurrentHashMap3 = this.l;
                        if (concurrentHashMap3 != null) {
                            jVar = concurrentHashMap3.get(strA);
                        }
                        if (jVar != null) {
                            break;
                        }
                        ConcurrentHashMap<String, j> concurrentHashMap4 = this.n;
                        if (concurrentHashMap4 != null) {
                            jVar = concurrentHashMap4.get(strA);
                        }
                        if (jVar != null) {
                            break;
                        }
                        ConcurrentHashMap<String, j> concurrentHashMap5 = this.o;
                        if (concurrentHashMap5 != null) {
                            jVar = concurrentHashMap5.get(strA);
                        }
                        if (jVar != null) {
                            break;
                        }
                        ConcurrentHashMap<String, j> concurrentHashMap6 = this.p;
                        if (concurrentHashMap6 != null) {
                            jVar = concurrentHashMap6.get(strA);
                        }
                        if (jVar != null || (concurrentHashMap = this.q) == null) {
                            break;
                            break;
                        }
                        jVar = concurrentHashMap.get(strA);
                        break;
                    }
                }
            }
            if (jVar != null) {
                return jVar.a();
            }
        }
        return com.anythink.dlopt.common.a.c.e.IDLE;
    }

    private j e(String str) {
        ConcurrentHashMap<String, j> concurrentHashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.j.size(); i++) {
            j jVar = this.j.get(i);
            if (jVar != null && jVar.o.equals(str)) {
                return jVar;
            }
        }
        ConcurrentHashMap<String, j> concurrentHashMap2 = this.k;
        j jVar2 = concurrentHashMap2 != null ? concurrentHashMap2.get(str) : null;
        if (jVar2 != null) {
            return jVar2;
        }
        ConcurrentHashMap<String, j> concurrentHashMap3 = this.l;
        if (concurrentHashMap3 != null) {
            jVar2 = concurrentHashMap3.get(str);
        }
        if (jVar2 != null) {
            return jVar2;
        }
        ConcurrentHashMap<String, j> concurrentHashMap4 = this.n;
        if (concurrentHashMap4 != null) {
            jVar2 = concurrentHashMap4.get(str);
        }
        if (jVar2 != null) {
            return jVar2;
        }
        ConcurrentHashMap<String, j> concurrentHashMap5 = this.o;
        if (concurrentHashMap5 != null) {
            jVar2 = concurrentHashMap5.get(str);
        }
        if (jVar2 != null) {
            return jVar2;
        }
        ConcurrentHashMap<String, j> concurrentHashMap6 = this.p;
        if (concurrentHashMap6 != null) {
            jVar2 = concurrentHashMap6.get(str);
        }
        return (jVar2 == null && (concurrentHashMap = this.q) != null) ? concurrentHashMap.get(str) : jVar2;
    }

    private void i(j jVar) {
        m mVar = this.z;
        if (mVar != null) {
            mVar.onStatusChanged(jVar);
        }
    }

    public final void h() {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.b(new com.anythink.dlopt.common.a.d.b() { // from class: com.anythink.dlopt.common.b.5
                @Override // com.anythink.dlopt.common.a.d.b
                public final void a(List<j> list) {
                }
            });
        }
    }

    public final void a(boolean z) {
        Object[] objArr = new Object[2];
        Boolean.valueOf(z);
        ConcurrentHashMap<String, j> concurrentHashMap = this.p;
        if (this.w == null || concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        if (z) {
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.dlopt.common.b.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.p == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = b.this.p.keySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add((j) b.this.p.get((String) it.next()));
                    }
                    if (b.this.y != null) {
                        b.this.y.a(arrayList);
                    }
                }
            });
            return;
        }
        g gVar = this.y;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(j jVar) {
        b(jVar, t.b().W() ? 1 : 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, j jVar) {
        com.anythink.dlopt.common.a.d dVar = this.w;
        if (dVar != null) {
            dVar.a(str, jVar);
        }
    }

    public final com.anythink.dlopt.common.a.d i() {
        return this.w;
    }

    static /* synthetic */ void a(b bVar, Context context, x xVar, w wVar, String str, String str2, Runnable runnable, com.anythink.core.common.k.b bVar2) {
        if (runnable != null) {
            runnable.run();
        }
        j jVar = new j();
        jVar.o = p.a(wVar);
        jVar.a = xVar.d;
        jVar.f = wVar.v();
        jVar.b = str;
        jVar.n = str2;
        jVar.e = wVar.I();
        jVar.c = wVar.x();
        jVar.j = wVar;
        jVar.k = xVar;
        if (xVar.o != null) {
            jVar.p = xVar.o.n() == 1;
            jVar.r = xVar.o.T();
            jVar.q = xVar.o.S();
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        jVar.d = com.anythink.core.common.res.b.a(context).a(new e(1, wVar.z()), iApplyDimension, iApplyDimension);
        if (wVar.G() != null) {
            jVar.l = wVar.G().replaceAll("\\{req_id\\}", xVar.d == null ? "" : xVar.d);
        }
        jVar.m = bVar2;
        jVar.a(com.anythink.dlopt.common.c.b.b(jVar.o));
        jVar.b(xVar.b);
        jVar.c(xVar.c);
        jVar.d(String.valueOf(xVar.f));
        ConcurrentHashMap<String, j> concurrentHashMap = bVar.p;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(jVar.o);
        }
        ConcurrentHashMap<String, j> concurrentHashMap2 = bVar.q;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(jVar.o);
        }
        String str3 = jVar.o;
        if (com.anythink.dlopt.common.c.a.a(str3)) {
            bVar.w.a(str3, bVar.new AnonymousClass9(jVar));
        } else {
            bVar.c(jVar);
        }
    }

    static /* synthetic */ void c(b bVar, j jVar) {
        m mVar = bVar.z;
        if (mVar != null) {
            mVar.onStatusChanged(jVar);
        }
    }

    static /* synthetic */ void k(b bVar) {
        try {
            if (bVar.s != null) {
                return;
            }
            bVar.s = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            bVar.i.registerReceiver(bVar.s, intentFilter);
        } catch (Throwable unused) {
        }
    }
}
