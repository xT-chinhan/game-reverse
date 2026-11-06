package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class ic implements w7 {
    public final /* synthetic */ jc a;

    public ic(jc jcVar) {
        this.a = jcVar;
    }

    @Override // com.mcto.sspsdk.internal.w7
    public final void a(Bitmap bitmap) {
        try {
            this.a.post(new hc(this, bitmap));
        } catch (Exception e) {
            r9.a("ssp_sdk", "set ad logo error", e);
        }
    }
}
