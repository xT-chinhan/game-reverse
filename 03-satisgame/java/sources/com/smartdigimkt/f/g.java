package com.smartdigimkt.f;

import android.content.Context;
import android.util.Log;
import com.hollywood.nexus.Actor;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ h b;

    public g(h hVar, Context context) {
        this.b = hVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h hVar = this.b;
            String str = hVar.a;
            int i = hVar.k;
            Objects.toString(hVar.i);
            h hVar2 = this.b;
            String str2 = hVar2.a;
            String str3 = hVar2.j;
            boolean z = hVar2.m;
            Actor.getInstance().init(this.a, new f(this));
            Actor.getInstance().notifyForeground(this.b.m);
        } catch (Throwable th) {
            String str4 = this.b.a;
            Log.getStackTraceString(th);
        }
    }
}
