package com.umeng.crash;

import android.app.ActivityManager;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
class UCrashJNI {
    static native int init(String str, boolean z);

    static native void onJavaCrashed();

    static native int registerAnr(boolean z);

    static native int registerNative(boolean z);

    UCrashJNI() {
    }

    private static void onAnrSignal() {
        i.a();
        i.b();
    }

    private static void onAnr(String str) {
        String str2;
        i.a();
        UCrash.a().c("UCrash.Native", "onAnr time: " + new Date() + " path:" + str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            f.b bVar = i.a().a;
            if (bVar == null) {
                UCrash.a().d("UCrash.Native", "onAnr config null.");
                k.a((Closeable) null);
                return;
            }
            f.a aVar = bVar.a;
            if (aVar == null) {
                UCrash.a().d("UCrash.Native", "onAnr callback null.");
                k.a((Closeable) null);
                return;
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.a(m.l()));
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.m());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.f());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.h());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.g());
                if (bVar.i) {
                    k.a((OutputStream) bufferedOutputStream2);
                    k.a(bufferedOutputStream2, m.b());
                }
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.j());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.e());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.k());
                if (bVar.p) {
                    k.a((OutputStream) bufferedOutputStream2);
                    k.a(bufferedOutputStream2, m.c());
                }
                aVar.a("anr", bufferedOutputStream2);
                i.a(str, (OutputStream) bufferedOutputStream2, false);
                String str3 = String.format(Locale.US, "Process Name: '%s'\nThread Name: '%s'\nANR Time: %s\n\nANR Info:\n", c.a().f, m.l(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date()));
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, str3);
                bufferedOutputStream2.flush();
                i.a().getClass();
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = m.a();
                if (processErrorStateInfoA != null) {
                    str2 = processErrorStateInfoA.longMsg;
                } else {
                    str2 = "(get failed)";
                    try {
                        UCrash.a().d("UCrash.Native", "checkProcessAnrState false, not ANR.");
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                            UCrash.a().a("UCrash.Native", "close outputStream failed", e);
                        }
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        File file2 = new File(str + ".traces.dp");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        File file3 = new File(str + ".traces.hk");
                        if (file3.exists()) {
                            file3.delete();
                        }
                        k.a((Closeable) bufferedOutputStream2);
                        return;
                    } catch (Exception unused) {
                    }
                }
                k.a(bufferedOutputStream2, str2);
                bufferedOutputStream2.flush();
                i.a(str, (OutputStream) bufferedOutputStream2, true);
                aVar.a("anr", str);
                k.a((Closeable) bufferedOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    UCrash.a().a("UCrash.Native", "onLogGenerated(TYPE_NATIVE) failed", th);
                } finally {
                    k.a((Closeable) bufferedOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void onCrash(String str, boolean z, String str2) {
        i.a();
        i.a(str, z, str2);
    }

    private static String getValue(int i) {
        i iVarA = i.a();
        if (i == 1) {
            return m.i();
        }
        if (i == 100) {
            iVarA.d = System.currentTimeMillis();
            iVarA.c = k.a(iVarA.d, "_jni.log");
            return c.a().c + File.separator + iVarA.c;
        }
        if (i == 101) {
            return m.a("jni", iVarA.d, iVarA.c);
        }
        if (i != 200) {
            return i == 201 ? m.a("anr", iVarA.d, iVarA.c) : "";
        }
        iVarA.d = System.currentTimeMillis();
        iVarA.c = k.a(iVarA.d, "_anr.log");
        return c.a().c + File.separator + iVarA.c;
    }
}
