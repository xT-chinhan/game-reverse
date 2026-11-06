package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* JADX INFO: compiled from: LenovoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class af implements aa {
    private static final int a = 1;
    private OpenDeviceId b;
    private boolean c = false;
    private boolean d = false;

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.c) {
            this.b = new OpenDeviceId();
            this.d = this.b.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.c = true;
        }
        am.a("getOAID", "isSupported", Boolean.valueOf(this.d));
        if (!this.d || !this.b.c()) {
            return null;
        }
        return this.b.a();
    }
}
