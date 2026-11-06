package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.s4.d;
import com.smartdigimkt.z.e0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseNewStyleSDKSplashATView extends BaseSdkSplashATView {
    public int m0;
    public int n0;

    public BaseNewStyleSDKSplashATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public final void a(int i, boolean z) {
        super.a(i, z);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void b() {
        super.b();
        getMaterialRealSize();
    }

    public void getMaterialRealSize() {
        int i;
        int i2;
        String str = this.c.f;
        if (TextUtils.isEmpty(str)) {
            c cVar = this.c;
            int i3 = cVar.G;
            if (i3 <= 0 || (i = cVar.H) <= 0) {
                return;
            }
            this.m0 = i3;
            this.n0 = i;
            return;
        }
        c cVar2 = this.c;
        synchronized (cVar2) {
            i2 = cVar2.E;
        }
        if (i2 > 0 || this.c.b() > 0) {
            this.m0 = this.c.c();
            this.n0 = this.c.b();
            return;
        }
        f.a().getClass();
        if (f.c()) {
            return;
        }
        e0.a().getClass();
        int[] iArrA = d.a(e0.a(1, str));
        if (iArrA != null) {
            this.m0 = iArrA[0];
            this.n0 = iArrA[1];
        }
    }

    public BaseNewStyleSDKSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }
}
