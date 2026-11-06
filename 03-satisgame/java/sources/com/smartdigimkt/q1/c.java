package com.smartdigimkt.q1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Handler {
    public final /* synthetic */ BaseAnimPlayerView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BaseAnimPlayerView baseAnimPlayerView, Looper looper) {
        super(looper);
        this.a = baseAnimPlayerView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseAnimPlayerView baseAnimPlayerView = this.a;
        if (baseAnimPlayerView.o != null && baseAnimPlayerView.j) {
            BaseAnimPlayerView baseAnimPlayerView2 = this.a;
            long jElapsedRealtime = SystemClock.elapsedRealtime() + baseAnimPlayerView2.t;
            BaseAnimPlayerView baseAnimPlayerView3 = this.a;
            baseAnimPlayerView2.b = jElapsedRealtime - baseAnimPlayerView3.u;
            if (!baseAnimPlayerView3.k && !baseAnimPlayerView3.l) {
                baseAnimPlayerView3.k = true;
                k kVar = baseAnimPlayerView3.o;
                if (kVar != null) {
                    kVar.f();
                }
            }
            BaseAnimPlayerView baseAnimPlayerView4 = this.a;
            k kVar2 = baseAnimPlayerView4.o;
            if (kVar2 != null) {
                kVar2.b(baseAnimPlayerView4.b);
            }
            BaseAnimPlayerView baseAnimPlayerView5 = this.a;
            if (!baseAnimPlayerView5.f && baseAnimPlayerView5.b >= baseAnimPlayerView5.c) {
                baseAnimPlayerView5.f = true;
                k kVar3 = baseAnimPlayerView5.o;
                if (kVar3 != null) {
                    kVar3.a(25);
                }
            } else if (!baseAnimPlayerView5.g && baseAnimPlayerView5.b >= baseAnimPlayerView5.d) {
                baseAnimPlayerView5.g = true;
                k kVar4 = baseAnimPlayerView5.o;
                if (kVar4 != null) {
                    kVar4.a(50);
                }
            } else if (!baseAnimPlayerView5.h && baseAnimPlayerView5.b >= baseAnimPlayerView5.e) {
                baseAnimPlayerView5.h = true;
                k kVar5 = baseAnimPlayerView5.o;
                if (kVar5 != null) {
                    kVar5.a(75);
                }
            }
            BaseAnimPlayerView baseAnimPlayerView6 = this.a;
            if (baseAnimPlayerView6.l || baseAnimPlayerView6.b < baseAnimPlayerView6.a) {
                return;
            }
            baseAnimPlayerView6.j = false;
            baseAnimPlayerView6.m = null;
            BaseAnimPlayerView baseAnimPlayerView7 = this.a;
            baseAnimPlayerView7.z = false;
            baseAnimPlayerView7.l = true;
            k kVar6 = baseAnimPlayerView7.o;
            if (kVar6 != null) {
                kVar6.a();
            }
            this.a.o = null;
        }
    }
}
