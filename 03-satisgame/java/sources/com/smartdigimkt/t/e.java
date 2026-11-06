package com.smartdigimkt.t;

import com.smartdigimkt.n3.k;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public e(int i, String str, long j) {
        this.a = i;
        this.b = str;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (SDKContext.getInstance().d() == null) {
            return;
        }
        int iA = y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", "oaid_fail_count");
        if (this.a != 6) {
            if (iA >= 3) {
                return;
            }
            iA++;
            y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", "oaid_fail_count", iA);
        }
        k.a(iA, this.a, this.b, this.c);
    }
}
