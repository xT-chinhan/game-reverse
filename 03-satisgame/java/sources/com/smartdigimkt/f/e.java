package com.smartdigimkt.f;

import android.os.Bundle;
import android.util.Log;
import com.hollywood.nexus.Actor;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ h c;

    public e(h hVar, int i, Bundle bundle) {
        this.c = hVar;
        this.a = i;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.c.a;
        Objects.toString(this.b);
        if (this.c.d.get()) {
            try {
                int i = this.a;
                if (i == 5) {
                    Actor.getInstance().notifyAdl(this.b);
                } else if (i == 6) {
                    Actor.getInstance().notifyAds(this.b);
                } else if (i == 7) {
                    Actor.getInstance().notifyAdc(this.b);
                }
            } catch (Throwable th) {
                String str2 = this.c.a;
                Log.getStackTraceString(th);
            }
        }
    }
}
