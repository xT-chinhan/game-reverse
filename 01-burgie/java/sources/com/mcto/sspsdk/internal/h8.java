package com.mcto.sspsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import com.byazt.ewn.AbsServerManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class h8 extends BroadcastReceiver {
    public x0 a;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public g8 c;

    public final void a() {
        if (this.b.compareAndSet(false, true)) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
                if (Build.VERSION.SDK_INT >= 33) {
                    jd.a.registerReceiver(this, intentFilter, 2);
                } else {
                    jd.a.registerReceiver(this, intentFilter);
                }
            } catch (Exception e) {
                r9.a("ssp_server", "register install re ex:", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data;
        x0 x0Var;
        if ((!"android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) && !"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) || (data = intent.getData()) == null || (x0Var = this.a) == null) {
            return;
        }
        x0Var.a(data.getSchemeSpecificPart(), intent.getAction());
    }
}
