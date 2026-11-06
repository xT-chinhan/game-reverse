package com.bytedance.embedapplog;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class nl extends z.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile boolean f506ms = false;

    @Override // com.bytedance.embedapplog.z
    public void ms(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.z
    public void ms(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.f506ms = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean xr() {
        return this.f506ms;
    }
}
