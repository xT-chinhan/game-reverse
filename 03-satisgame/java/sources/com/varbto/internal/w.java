package com.varbto.internal;

import android.content.Context;
import android.text.TextUtils;
import com.aegis.verbanr.VerbAnrHandler;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final Object d = new Object();
    public static volatile w e;
    public VerbAnrHandler a;
    public volatile boolean b;
    public volatile boolean c;

    public static void a(w wVar, r rVar) {
        File file;
        Context applicationContext;
        if (wVar.a == null) {
            VerbAnrHandler verbAnrHandler = new VerbAnrHandler();
            wVar.a = verbAnrHandler;
            VerbAnrHandler.c = verbAnrHandler;
        }
        VerbAnrHandler verbAnrHandler2 = wVar.a;
        verbAnrHandler2.a = rVar;
        Context context = rVar.a;
        String str = rVar.b;
        if (TextUtils.isEmpty(str)) {
            file = null;
        } else {
            file = new File(str);
            if (file.isFile()) {
                throw new IllegalArgumentException(file.getCanonicalPath() + " is a file, need a dir.");
            }
        }
        if (file == null) {
            file = context != null ? new File(context.getCacheDir(), "tktp_anr") : null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        verbAnrHandler2.b = file;
        Context context2 = rVar.a;
        if (o.b.compareAndSet(false, true)) {
            if (context2 == null) {
                applicationContext = null;
            } else {
                try {
                    applicationContext = context2.getApplicationContext();
                } catch (Throwable unused) {
                    applicationContext = null;
                }
            }
            if (applicationContext != null) {
                context2 = applicationContext;
            }
            Thread thread = new Thread(new n(context2), "VerbAnr-SysInfo");
            try {
                thread.setDaemon(true);
                thread.setPriority(1);
                thread.start();
            } catch (Throwable th) {
                o.a("initStaticHeader() >>> start thread failed", th);
                o.a = "";
            }
        }
        int iInitDumpStack = VerbAnrHandler.initDumpStack(verbAnrHandler2.b.getCanonicalPath(), "");
        if (iInitDumpStack != 0) {
            m.a("VerbAnrHandler", "init() >>> Init dump stack fail: %d", null, Integer.valueOf(iInitDumpStack));
            throw new IllegalStateException("Init dump stack fail: " + iInitDumpStack);
        }
        m.a("VerbAnrHandler", "init() >>> start verb anr...", new Object[0]);
        int iInitVerb = VerbAnrHandler.initVerb();
        if (iInitVerb == 0) {
            m.b("init() >>> verb anr monitoring started. stackCollection=%s", rVar.c ? "ON" : "OFF");
        } else {
            m.a("VerbAnrHandler", "init() >>> verb anr fail: %s", null, Integer.valueOf(iInitVerb));
            throw new IllegalStateException("Init verb fail: " + iInitVerb);
        }
    }
}
