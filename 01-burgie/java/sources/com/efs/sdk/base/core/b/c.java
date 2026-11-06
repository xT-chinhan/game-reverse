package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Handler implements Runnable {
    public boolean a;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }

    static class a {
        private static final c a = new c(0);
    }

    public static c a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 2) {
            Log.w("efs.cache", "disk listener not support command: " + message.what);
            return;
        }
        WorkThreadUtil.submit(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        com.efs.sdk.base.core.b.a unused = com.efs.sdk.base.core.b.a.b.a;
        File fileF = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileF.exists()) {
            for (File file : com.efs.sdk.base.core.util.b.d(fileF)) {
                if (com.efs.sdk.base.core.b.a.a(file.getName())) {
                    com.efs.sdk.base.core.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.core.config.a.c cVarA = com.efs.sdk.base.core.config.a.c.a();
        if (cVarA.d.f.containsKey("disk_bytes")) {
            str = cVarA.d.f.get("disk_bytes");
        } else {
            str = "4194304";
        }
        if (TextUtils.isEmpty(str)) {
            str = "4194304";
        }
        long j = Long.parseLong(str);
        long jC = com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        this.a = jC < j;
        if (!this.a) {
            Log.w("efs.cache", "Cache Limited! curr " + jC + "byte, max " + j + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
