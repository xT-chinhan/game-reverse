package com.smartdigimkt.dlopt.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.smartdigimkt.j.u;
import com.smartdigimkt.k.d0;
import com.smartdigimkt.k.r;
import com.smartdigimkt.m.i;
import com.smartdigimkt.m.j;
import com.smartdigimkt.o.a;
import com.smartdigimkt.o.b;
import com.smartdigimkt.q3.f;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ApkDownloadService extends Service {
    public static final /* synthetic */ int b = 0;
    public final HashMap a = new HashMap();

    public final void a(String str) {
        try {
            u uVarA = u.a(getApplicationContext());
            r rVar = (r) uVarA.c.get(str);
            if (rVar == null) {
                return;
            }
            d0 d0Var = new d0(uVarA.o, rVar);
            d0Var.a(new a(this, uVarA));
            this.a.put(str, d0Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent != null) {
            a(intent.getStringExtra("extra_unique_id"));
        }
        return new b(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        j jVarA = j.a(getApplicationContext());
        jVarA.getClass();
        f.a().a(new i(jVarA));
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
