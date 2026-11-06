package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public final class qb extends Handler {
    public final /* synthetic */ zb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb(zb zbVar, Looper looper) {
        super(looper);
        this.a = zbVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        new StringBuilder().append(this.a.a).append(", handleMessage: ").append(message.what);
        if (message.what == 110) {
            zb zbVar = this.a;
            zbVar.e.set(true);
            zbVar.onError(zbVar.b, -110, 0);
        }
    }
}
