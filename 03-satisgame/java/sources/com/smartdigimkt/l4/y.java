package com.smartdigimkt.l4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends Handler {
    public final /* synthetic */ b0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Looper looper) {
        super(looper);
        this.a = b0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.a.L.execute(new x(this));
        } else {
            if (i != 2) {
                return;
            }
            b0 b0Var = this.a;
            b0Var.p.execute(new w(b0Var));
        }
    }
}
