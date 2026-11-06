package com.efs.sdk.base.core.config;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public com.efs.sdk.base.core.config.a a;
    public Context b;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    public static class a {
        private static final b a = new b(0);
    }

    public final String a() {
        return this.a.b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }
}
