package com.mcto.sspsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends BroadcastReceiver {
    public final /* synthetic */ c1 a;

    public w0(c1 c1Var) {
        this.a = c1Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.a.d.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("taskId");
            c1 c1Var = this.a;
            synchronized (c1Var) {
                d1 d1Var = (d1) c1Var.i.get(stringExtra);
                if (d1Var != null) {
                    d1Var.a();
                }
            }
        }
    }
}
