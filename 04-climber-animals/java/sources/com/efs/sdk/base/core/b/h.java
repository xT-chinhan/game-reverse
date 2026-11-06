package com.efs.sdk.base.core.b;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    static FileLock b;
    volatile int a;

    /* synthetic */ h(byte b2) {
        this();
    }

    public static class a {
        private static final h a = new h(0);
    }

    private h() {
        this.a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    public final boolean a() {
        if (this.a == 2) {
            return true;
        }
        if (this.a != 0) {
            return false;
        }
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }

    private synchronized void a(final Context context) {
        Log.w("efs.send_log", "tryFileLock start! ");
        this.a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.core.b.h.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLockLock;
                try {
                    File fileA = com.efs.sdk.base.core.util.a.a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    File file = new File(fileA.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        fileLockLock = new FileOutputStream(file).getChannel().lock();
                        h.b = fileLockLock;
                    } while (!fileLockLock.isValid());
                    Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                    h.this.a = 2;
                } catch (Exception e) {
                    Log.w("efs.send_log", "tryFileLock fail! " + e.getMessage());
                    h.this.a = 0;
                }
            }
        }).start();
    }
}
