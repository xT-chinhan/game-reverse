package com.smartdigimkt.r;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public Context a;
    public l b;
    public k c;
    public com.smartdigimkt.q.a d;

    public m(Context context) {
        this.a = context;
    }

    public static void a(m mVar) {
        l lVar;
        Context context = mVar.a;
        if (context == null || (lVar = mVar.b) == null) {
            return;
        }
        try {
            context.unbindService(lVar);
        } catch (Throwable unused) {
        }
        mVar.c = null;
        mVar.a = null;
        mVar.d = null;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        com.smartdigimkt.q.a aVar;
        this.d = bVar;
        if (this.a == null) {
            bVar.a("mContext is null.");
            return;
        }
        this.b = new l(this);
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.a.bindService(intent, this.b, 1) || (aVar = this.d) == null) {
            return;
        }
        aVar.a("Service binding failed.");
    }
}
