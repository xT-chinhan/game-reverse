package com.smartdigimkt.k1;

import android.content.Context;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends d {
    public com.smartdigimkt.j1.a i;
    public BaseSplashATView j;
    public boolean k;

    public p(Context context, com.smartdigimkt.a3.a aVar, String str, boolean z) {
        super(context, aVar, str, z);
    }

    @Override // com.smartdigimkt.k1.d
    public final void c() {
        super.c();
        this.i = null;
        BaseSplashATView baseSplashATView = this.j;
        if (baseSplashATView != null) {
            baseSplashATView.destroy();
            this.j = null;
        }
    }

    @Override // com.smartdigimkt.k1.d
    public final boolean d() {
        try {
            if (a()) {
                return com.smartdigimkt.l1.b.a(this.a).a(this.e, this.b, this.d);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
