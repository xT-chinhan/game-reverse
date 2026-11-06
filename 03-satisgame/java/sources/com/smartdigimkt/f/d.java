package com.smartdigimkt.f;

import android.util.Log;
import com.hollywood.nexus.Actor;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ h b;

    public d(h hVar, boolean z) {
        this.b = hVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.d.get()) {
            try {
                Actor.getInstance().notifyForeground(this.a);
            } catch (Throwable th) {
                String str = this.b.a;
                Log.getStackTraceString(th);
            }
        }
    }
}
