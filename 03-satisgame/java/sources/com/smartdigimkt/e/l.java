package com.smartdigimkt.e;

import android.content.Context;
import android.os.SystemClock;
import com.smartdigimkt.sdk.R;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ BaseSdkSplashATView a;
    public final /* synthetic */ Runnable[] b;
    public final /* synthetic */ long[] c;
    public final /* synthetic */ com.smartdigimkt.a3.a d;
    public final /* synthetic */ p e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    public l(BaseSdkSplashATView baseSdkSplashATView, Runnable[] runnableArr, long[] jArr, com.smartdigimkt.a3.a aVar, p pVar, boolean z, String str) {
        this.a = baseSdkSplashATView;
        this.b = runnableArr;
        this.c = jArr;
        this.d = aVar;
        this.e = pVar;
        this.f = z;
        this.g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.getTag(R.id.sdm_bubble_delay_runnable_tag) != this.b[0]) {
            return;
        }
        if (!q.a(this.a)) {
            this.a.setTag(R.id.sdm_bubble_delay_runnable_tag, null);
            return;
        }
        long[] jArr = this.c;
        if (jArr[0] < 0) {
            jArr[0] = SystemClock.elapsedRealtime() + 2500;
        }
        if (!q.a(this.a, this.c[0])) {
            this.a.postDelayed(this.b[0], 50L);
            return;
        }
        Context context = this.a.getContext();
        if (q.c(this.a) && com.smartdigimkt.z.c0.b(this.d) && !com.smartdigimkt.z.c0.c(this.d)) {
            q.a(context, this.a);
        }
        int i = this.d.s.e;
        h hVar = new h(this);
        i iVar = i == 0 ? new i(this) : null;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        char[] cArr = com.smartdigimkt.r4.k.a;
        int iMax = Math.max((int) ((context.getResources().getDisplayMetrics().density * 64.0f) + 0.5f), Math.min(i2, i3) / 2);
        if (this.f) {
            com.smartdigimkt.i3.m.a(context).a(new com.smartdigimkt.i3.o(1, this.g), iMax, iMax, new k(this, context, iMax, iVar, hVar, i));
        } else {
            q.a(context, this.a, iMax, iVar, hVar, i, this.b[0]);
        }
    }
}
