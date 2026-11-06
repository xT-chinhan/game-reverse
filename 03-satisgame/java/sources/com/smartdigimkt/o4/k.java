package com.smartdigimkt.o4;

import android.content.Context;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.smartdigimkt.q3.h {
    public final /* synthetic */ l b;

    public k(l lVar) {
        this.b = lVar;
    }

    @Override // com.smartdigimkt.q3.h
    public final void b() {
        try {
            Context contextD = SDKContext.getInstance().d();
            if (contextD == null) {
                return;
            }
            l lVar = this.b;
            long jCurrentTimeMillis = System.currentTimeMillis();
            lVar.getClass();
            String strA = l.a(jCurrentTimeMillis);
            y.a(contextD, "interaction_control", "last_save_date", strA);
            String str = this.b.l;
            if (str != null) {
                strA = str;
            }
            y.a(contextD, "interaction_control", "daily_count_day", strA);
            y.a(contextD, "interaction_control", "sp_cross_last_time", this.b.c);
            y.a(contextD, "interaction_control", "sp_cross_daily_count", this.b.d);
            y.a(contextD, "interaction_control", "sp_shake_last_time", this.b.e);
            y.a(contextD, "interaction_control", "sp_shake_daily_count", this.b.f);
            y.a(contextD, "interaction_control", "sp_swipe_last_time", this.b.g);
            y.a(contextD, "interaction_control", "sp_swipe_daily_count", this.b.h);
            y.a(contextD, "interaction_control", "sp_twist_last_time", this.b.i);
            y.a(contextD, "interaction_control", "sp_twist_daily_count", this.b.j);
        } catch (Throwable unused) {
        }
    }
}
