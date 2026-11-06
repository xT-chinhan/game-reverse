package com.smartdigimkt.x;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.i3.n;
import com.smartdigimkt.n1.i0;
import com.smartdigimkt.r4.q;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.t2.o;
import com.smartdigimkt.t2.w;
import com.smartdigimkt.t2.z;
import com.smartdigimkt.v2.p;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static volatile j u;
    public ArrayList f;
    public Context g;
    public volatile boolean h;
    public long i;
    public com.smartdigimkt.a0.h j;
    public com.smartdigimkt.a0.j k;
    public volatile Boolean n;
    public volatile Boolean o;
    public volatile boolean p;
    public WeakReference q;
    public final String a = com.anythink.core.e.j.a;
    public volatile boolean c = false;
    public final Object e = new Object();
    public boolean l = false;
    public boolean m = false;
    public final Object r = new Object();
    public boolean b = false;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final CopyOnWriteArrayList s = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList t = new CopyOnWriteArrayList();

    public j() {
        if (SDKContext.getInstance().j()) {
            com.smartdigimkt.r4.j.a();
        }
    }

    public static j a() {
        if (u == null) {
            synchronized (j.class) {
                if (u == null) {
                    u = new j();
                }
            }
        }
        return u;
    }

    public final void b(boolean z) {
        if (!this.p) {
            this.p = true;
        }
        this.h = z;
        if (z) {
            com.smartdigimkt.a0.h hVar = this.j;
            if (hVar != null) {
                long j = this.i;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.smartdigimkt.a0.k kVar = hVar.a;
                com.smartdigimkt.a3.a aVar = kVar.d;
                int i = aVar.c;
                com.smartdigimkt.b3.c cVar = kVar.c;
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(i), null);
                cVar2.a = "1004721";
                cVar2.a(aVar);
                cVar2.l = String.valueOf(j);
                cVar2.m = String.valueOf(jCurrentTimeMillis);
                if (cVar != null) {
                    if (!TextUtils.isEmpty(cVar.K)) {
                        cVar2.n = cVar.K;
                    }
                    cVar2.o = cVar.k;
                    cVar2.p = cVar.a;
                    if (cVar instanceof com.smartdigimkt.b3.b) {
                        cVar2.q = ((com.smartdigimkt.b3.b) cVar).c0;
                    }
                }
                cVar2.r = String.valueOf(i);
                com.smartdigimkt.n3.k.a(cVar2);
                this.j = null;
            }
        } else {
            this.i = System.currentTimeMillis();
        }
        if (!this.s.isEmpty()) {
            for (i0 i0Var : this.s) {
                if (z) {
                    i0Var.a.a(129);
                } else {
                    i0Var.a.a(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                }
            }
        }
        if (this.t.isEmpty()) {
            return;
        }
        Iterator it = this.t.iterator();
        if (it.hasNext()) {
            throw d.a(it);
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2 A[Catch: all -> 0x01a9, TryCatch #6 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0014, B:12:0x0018, B:33:0x0058, B:41:0x0069, B:45:0x006f, B:51:0x0082, B:55:0x00b0, B:85:0x0134, B:96:0x0184, B:98:0x0188, B:99:0x0194, B:84:0x0131, B:54:0x00a2, B:50:0x007f, B:18:0x0027, B:20:0x002b, B:57:0x00b8, B:71:0x00f4, B:73:0x0104, B:74:0x0107, B:76:0x0111, B:78:0x0117, B:60:0x00cb, B:47:0x0075), top: B:124:0x0001, inners: #0, #8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:57:0x00b8, B:71:0x00f4, B:73:0x0104, B:74:0x0107, B:76:0x0111, B:78:0x0117, B:60:0x00cb), top: B:111:0x00b8, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00de A[Catch: all -> 0x00d6, TryCatch #3 {all -> 0x00d6, blocks: (B:63:0x00d8, B:65:0x00de, B:66:0x00e3), top: B:118:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e3 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #3 {all -> 0x00d6, blocks: (B:63:0x00d8, B:65:0x00de, B:66:0x00e3), top: B:118:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x0134 A[Catch: all -> 0x01a9, TRY_LEAVE, TryCatch #6 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0014, B:12:0x0018, B:33:0x0058, B:41:0x0069, B:45:0x006f, B:51:0x0082, B:55:0x00b0, B:85:0x0134, B:96:0x0184, B:98:0x0188, B:99:0x0194, B:84:0x0131, B:54:0x00a2, B:50:0x007f, B:18:0x0027, B:20:0x002b, B:57:0x00b8, B:71:0x00f4, B:73:0x0104, B:74:0x0107, B:76:0x0111, B:78:0x0117, B:60:0x00cb, B:47:0x0075), top: B:124:0x0001, inners: #0, #8 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x014e A[Catch: all -> 0x0184, TRY_ENTER, TryCatch #1 {all -> 0x0184, blocks: (B:87:0x014e, B:91:0x015e, B:94:0x0165, B:88:0x0153), top: B:113:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0153 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:87:0x014e, B:91:0x015e, B:94:0x0165, B:88:0x0153), top: B:113:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:90:0x015d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:91:0x015e A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:87:0x014e, B:91:0x015e, B:94:0x0165, B:88:0x0153), top: B:113:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0188 A[Catch: all -> 0x01a9, TryCatch #6 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0014, B:12:0x0018, B:33:0x0058, B:41:0x0069, B:45:0x006f, B:51:0x0082, B:55:0x00b0, B:85:0x0134, B:96:0x0184, B:98:0x0188, B:99:0x0194, B:84:0x0131, B:54:0x00a2, B:50:0x007f, B:18:0x0027, B:20:0x002b, B:57:0x00b8, B:71:0x00f4, B:73:0x0104, B:74:0x0107, B:76:0x0111, B:78:0x0117, B:60:0x00cb, B:47:0x0075), top: B:124:0x0001, inners: #0, #8 }] */
    public final synchronized void a(Context context, boolean z) {
        File file;
        Application application;
        z zVarA;
        com.smartdigimkt.m1.d dVarA;
        Context contextD;
        Context contextD2;
        File filesDir;
        String strB;
        File file2;
        long jA;
        Context baseContext;
        if (context instanceof Activity) {
            a((Activity) context);
        }
        Context context2 = context;
        int i = 0;
        while (true) {
            file = null;
            if (i < 5 && context2 != null) {
                if (context2 instanceof Application) {
                    application = (Application) context2;
                    break;
                }
                try {
                    Context applicationContext = context2.getApplicationContext();
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else if ((context2 instanceof ContextWrapper) && (baseContext = ((ContextWrapper) context2).getBaseContext()) != context2) {
                        i++;
                        context2 = baseContext;
                    }
                } catch (Throwable unused) {
                }
            }
            application = null;
            break;
        }
        if (application == null) {
            try {
                Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
                application = objInvoke instanceof Application ? (Application) objInvoke : null;
            } catch (Throwable unused2) {
            }
        }
        Context applicationContext2 = application != null ? application.getApplicationContext() : null;
        if (applicationContext2 == null && context != null) {
            try {
                applicationContext2 = context.getApplicationContext();
            } catch (Throwable unused3) {
            }
        }
        if (applicationContext2 != null) {
            context = applicationContext2;
        }
        this.g = context;
        if (context == null) {
            return;
        }
        this.h = z;
        this.p = false;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(new com.smartdigimkt.z.e());
            } catch (Throwable th) {
                th.getMessage();
            }
            z zVarA2 = z.a();
            zVarA2.getClass();
            n.a().getClass();
            zVarA2.e = n.a(4);
            zVarA = z.a();
            if (zVarA.d) {
                com.smartdigimkt.q3.f.a().a(new w(zVarA), 0L, 13);
            }
            n.a().getClass();
            try {
                long jA2 = n.a(1);
                strB = n.a().b(1);
                if (TextUtils.isEmpty(strB)) {
                    file2 = new File(strB);
                    if (!file2.exists()) {
                        try {
                            if (file2.isDirectory()) {
                                jA = q.b(file2);
                            } else {
                                jA = q.a(file2);
                            }
                        } catch (Throwable unused4) {
                            jA = 0;
                        }
                    }
                    if (jA <= 0 && jA > jA2 * 1.5d) {
                        File[] fileArrListFiles = new File(strB).listFiles();
                        ArrayList arrayList = new ArrayList();
                        if (fileArrListFiles != null) {
                            Collections.addAll(arrayList, fileArrListFiles);
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (arrayList.size() > 0) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                File file3 = (File) arrayList.get(i2);
                                if (jCurrentTimeMillis - file3.lastModified() > 172800000) {
                                    try {
                                        file3.delete();
                                    } catch (Throwable unused5) {
                                    }
                                }
                            }
                        }
                        o.b().getClass();
                        dVarA = com.smartdigimkt.m1.d.a();
                        contextD = SDKContext.getInstance().d();
                        dVarA.getClass();
                        if (contextD != null) {
                            contextD2 = contextD.getApplicationContext();
                        } else {
                            contextD2 = SDKContext.getInstance().d();
                        }
                        if (contextD2 != null) {
                            file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                        }
                        dVarA.d = file;
                        if (file != null) {
                            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                        }
                        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
                        eVarA.getClass();
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA));
                        return;
                    }
                    o.b().getClass();
                    dVarA = com.smartdigimkt.m1.d.a();
                    contextD = SDKContext.getInstance().d();
                    dVarA.getClass();
                    try {
                        if (contextD != null) {
                            contextD2 = contextD.getApplicationContext();
                        } else {
                            contextD2 = SDKContext.getInstance().d();
                        }
                        if (contextD2 != null && (filesDir = contextD2.getFilesDir()) != null) {
                            file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                        }
                    } catch (Throwable unused6) {
                    }
                    dVarA.d = file;
                    if (file != null) {
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                    }
                    com.smartdigimkt.t2.e eVarA2 = com.smartdigimkt.t2.e.a();
                    eVarA2.getClass();
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA2));
                    return;
                }
                jA = 0;
                if (jA <= 0) {
                    o.b().getClass();
                    dVarA = com.smartdigimkt.m1.d.a();
                    contextD = SDKContext.getInstance().d();
                    dVarA.getClass();
                    if (contextD != null) {
                        contextD2 = contextD.getApplicationContext();
                    } else {
                        contextD2 = SDKContext.getInstance().d();
                    }
                    if (contextD2 != null) {
                        file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                    }
                    dVarA.d = file;
                    if (file != null) {
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                    }
                    com.smartdigimkt.t2.e eVarA3 = com.smartdigimkt.t2.e.a();
                    eVarA3.getClass();
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA3));
                    return;
                }
                o.b().getClass();
                dVarA = com.smartdigimkt.m1.d.a();
                contextD = SDKContext.getInstance().d();
                dVarA.getClass();
                if (contextD != null) {
                    contextD2 = contextD.getApplicationContext();
                } else {
                    contextD2 = SDKContext.getInstance().d();
                }
                if (contextD2 != null) {
                    file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                }
                dVarA.d = file;
                if (file != null) {
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                }
                com.smartdigimkt.t2.e eVarA4 = com.smartdigimkt.t2.e.a();
                eVarA4.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA4));
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else {
            z zVarA3 = z.a();
            zVarA3.getClass();
            n.a().getClass();
            zVarA3.e = n.a(4);
            zVarA = z.a();
            if (zVarA.d) {
                com.smartdigimkt.q3.f.a().a(new w(zVarA), 0L, 13);
            }
            n.a().getClass();
            long jA3 = n.a(1);
            strB = n.a().b(1);
            if (TextUtils.isEmpty(strB)) {
                file2 = new File(strB);
                if (!file2.exists()) {
                    if (file2.isDirectory()) {
                        jA = q.b(file2);
                    } else {
                        jA = q.a(file2);
                    }
                }
                if (jA <= 0) {
                    o.b().getClass();
                    dVarA = com.smartdigimkt.m1.d.a();
                    contextD = SDKContext.getInstance().d();
                    dVarA.getClass();
                    if (contextD != null) {
                        contextD2 = contextD.getApplicationContext();
                    } else {
                        contextD2 = SDKContext.getInstance().d();
                    }
                    if (contextD2 != null) {
                        file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                    }
                    dVarA.d = file;
                    if (file != null) {
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                    }
                    com.smartdigimkt.t2.e eVarA5 = com.smartdigimkt.t2.e.a();
                    eVarA5.getClass();
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA5));
                    return;
                }
                o.b().getClass();
                dVarA = com.smartdigimkt.m1.d.a();
                contextD = SDKContext.getInstance().d();
                dVarA.getClass();
                if (contextD != null) {
                    contextD2 = contextD.getApplicationContext();
                } else {
                    contextD2 = SDKContext.getInstance().d();
                }
                if (contextD2 != null) {
                    file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                }
                dVarA.d = file;
                if (file != null) {
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                }
                com.smartdigimkt.t2.e eVarA6 = com.smartdigimkt.t2.e.a();
                eVarA6.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA6));
                return;
            }
            jA = 0;
            if (jA <= 0) {
                o.b().getClass();
                dVarA = com.smartdigimkt.m1.d.a();
                contextD = SDKContext.getInstance().d();
                dVarA.getClass();
                if (contextD != null) {
                    contextD2 = contextD.getApplicationContext();
                } else {
                    contextD2 = SDKContext.getInstance().d();
                }
                if (contextD2 != null) {
                    file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
                }
                dVarA.d = file;
                if (file != null) {
                    com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
                }
                com.smartdigimkt.t2.e eVarA7 = com.smartdigimkt.t2.e.a();
                eVarA7.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA7));
                return;
            }
            o.b().getClass();
            dVarA = com.smartdigimkt.m1.d.a();
            contextD = SDKContext.getInstance().d();
            dVarA.getClass();
            if (contextD != null) {
                contextD2 = contextD.getApplicationContext();
            } else {
                contextD2 = SDKContext.getInstance().d();
            }
            if (contextD2 != null) {
                file = new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_optres/");
            }
            dVarA.d = file;
            if (file != null) {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.m1.a(dVarA, contextD));
            }
            com.smartdigimkt.t2.e eVarA8 = com.smartdigimkt.t2.e.a();
            eVarA8.getClass();
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.d(eVarA8));
            return;
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:49:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void a(i iVar) {
        Context context;
        if (this.b) {
            if (iVar != null) {
                ((com.smartdigimkt.s3.l) iVar).a();
                return;
            }
            return;
        }
        synchronized (this.e) {
            if (this.d.get()) {
                if (iVar != null) {
                    this.f.add(iVar);
                }
                return;
            }
            if (this.f == null) {
                this.f = new ArrayList();
            }
            this.d.set(true);
            if (iVar != null) {
                this.f.add(iVar);
            }
            if (!this.c) {
                this.c = true;
            }
            Context context2 = this.g;
            if (context2 != null) {
                try {
                    Boolean bool = (Boolean) com.smartdigimkt.k4.c.a().a(context2, "sdm_adx_rp_sdk").b(Boolean.TRUE, "adx_first_init");
                    if (bool != null && !bool.booleanValue()) {
                        a(true);
                    } else {
                        context = this.g;
                        if (context != null) {
                            com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_sdk").a(Boolean.FALSE, "adx_first_init");
                        }
                        p.c().i();
                        a(true);
                    }
                } catch (Throwable unused) {
                }
            } else {
                context = this.g;
                if (context != null) {
                    try {
                        com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_sdk").a(Boolean.FALSE, "adx_first_init");
                    } catch (Throwable unused2) {
                    }
                }
                p.c().i();
                a(true);
            }
            com.smartdigimkt.q3.f.a().c(new g(this));
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x001e A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x0008, B:9:0x0012, B:12:0x001e, B:13:0x0024, B:15:0x002a, B:16:0x002e, B:17:0x0031, B:18:0x003b), top: B:23:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x0008, B:9:0x0012, B:12:0x001e, B:13:0x0024, B:15:0x002a, B:16:0x002e, B:17:0x0031, B:18:0x003b), top: B:23:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x002a A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x0008, B:9:0x0012, B:12:0x001e, B:13:0x0024, B:15:0x002a, B:16:0x002e, B:17:0x0031, B:18:0x003b), top: B:23:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x002e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x002e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0012 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x0008, B:9:0x0012, B:12:0x001e, B:13:0x0024, B:15:0x002a, B:16:0x002e, B:17:0x0031, B:18:0x003b), top: B:23:0x0006 }] */
    public final void a(boolean z) {
        int size;
        int i;
        i iVar;
        ISDMAdManager.BidTokenCallBack bidTokenCallBack;
        synchronized (this.e) {
            if (z) {
                this.b = true;
                size = this.f.size();
                for (i = 0; i < size; i++) {
                    iVar = (i) this.f.get(i);
                    if (iVar == null) {
                        if (z) {
                            ((com.smartdigimkt.s3.l) iVar).a();
                        } else {
                            bidTokenCallBack = ((com.smartdigimkt.s3.l) iVar).a;
                            if (bidTokenCallBack != null) {
                                bidTokenCallBack.onComplete(null);
                            }
                        }
                    }
                }
                this.f.clear();
                this.d.set(false);
            } else {
                size = this.f.size();
                while (i < size) {
                    iVar = (i) this.f.get(i);
                    if (iVar == null) {
                        if (z) {
                            ((com.smartdigimkt.s3.l) iVar).a();
                        } else {
                            bidTokenCallBack = ((com.smartdigimkt.s3.l) iVar).a;
                            if (bidTokenCallBack != null) {
                                bidTokenCallBack.onComplete(null);
                            }
                        }
                    }
                }
                this.f.clear();
                this.d.set(false);
            }
            throw th;
        }
    }

    public final void a(Activity activity) {
        synchronized (this.r) {
            this.q = new WeakReference(activity);
        }
    }

    public static JSONArray a(Map map) {
        String str = (String) com.smartdigimkt.r4.k.a(map, "nv_tmpl_id", "[\"1\",\"2\",\"3\",\"4\",\"5\"]");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    return jSONArray;
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put("1");
        jSONArray2.put("2");
        jSONArray2.put("3");
        jSONArray2.put("4");
        jSONArray2.put("5");
        return jSONArray2;
    }

    public final boolean b() {
        if (this.o != null && !this.o.booleanValue()) {
            return true;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA.g) {
            return true;
        }
        this.o = Boolean.valueOf(aVarA.O == 1);
        if (!this.o.booleanValue()) {
            return true;
        }
        if (this.n == null) {
            if (this.o == null) {
                com.smartdigimkt.p4.a aVarA2 = com.smartdigimkt.o4.e.c().a();
                if (!aVarA2.g) {
                    this.o = Boolean.valueOf(aVarA2.O == 1);
                }
            }
            if (this.o != null && this.o.booleanValue()) {
                com.smartdigimkt.q3.f.a().a(new h(this));
            }
        }
        if (this.n != null) {
            return this.n.booleanValue();
        }
        return true;
    }
}
