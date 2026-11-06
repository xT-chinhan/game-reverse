package com.smartdigimkt.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends BroadcastReceiver {
    public final /* synthetic */ u a;

    public m(u uVar) {
        this.a = uVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        com.smartdigimkt.q3.f.a().b(new l(this, context));
    }
}
