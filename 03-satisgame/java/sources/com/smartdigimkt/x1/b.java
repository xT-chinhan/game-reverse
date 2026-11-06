package com.smartdigimkt.x1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Handler {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, Looper looper) {
        super(looper);
        this.a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        d dVar = this.a;
        dVar.a(dVar.l);
    }
}
