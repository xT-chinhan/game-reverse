package com.smartdigimkt.n3;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;

    public g(Context context, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = new Intent();
        intent.setAction(this.a + "_log_agent");
        intent.putExtra(com.smartdigimkt.f.i.a(new StringBuilder(), this.a, "_log_agent_data"), this.b);
        intent.addFlags(8);
        com.smartdigimkt.w2.a.a(this.c).a(intent);
    }
}
