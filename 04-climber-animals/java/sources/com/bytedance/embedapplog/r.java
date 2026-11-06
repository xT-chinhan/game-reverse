package com.bytedance.embedapplog;

import android.os.Bundle;
import com.umeng.analytics.pro.bk;

/* JADX INFO: loaded from: classes2.dex */
public class r extends z.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile String f519ms = "";

    @Override // com.bytedance.embedapplog.z
    public void ms(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.z
    public void ms(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.f519ms = bundle.getString(bk.c.b);
    }

    public String xr() {
        return this.f519ms;
    }
}
