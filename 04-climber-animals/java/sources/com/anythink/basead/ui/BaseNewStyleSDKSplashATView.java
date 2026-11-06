package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.b.e;
import com.anythink.basead.b.f;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseNewStyleSDKSplashATView extends BaseSdkSplashATView {
    int A;
    int B;
    private boolean a;

    public BaseNewStyleSDKSplashATView(Context context) {
        super(context);
    }

    public BaseNewStyleSDKSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    protected final void e() {
        super.e();
        String strB = this.g.B();
        if (!TextUtils.isEmpty(strB)) {
            f.a();
            int[] iArrA = h.a(f.a(1, strB));
            if (iArrA != null) {
                this.A = iArrA[0];
                this.B = iArrA[1];
                return;
            }
            return;
        }
        if (this.g.V() <= 0 || this.g.W() <= 0) {
            return;
        }
        this.A = this.g.V();
        this.B = this.g.W();
    }

    private void D() {
        String strB = this.g.B();
        if (!TextUtils.isEmpty(strB)) {
            f.a();
            int[] iArrA = h.a(f.a(1, strB));
            if (iArrA != null) {
                this.A = iArrA[0];
                this.B = iArrA[1];
                return;
            }
            return;
        }
        if (this.g.V() <= 0 || this.g.W() <= 0) {
            return;
        }
        this.A = this.g.V();
        this.B = this.g.W();
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    protected final void a(boolean z, int i) {
        super.a(z, i);
        if (this.a) {
            return;
        }
        this.a = true;
        x xVar = this.f;
        w wVar = this.g;
        e.a(this.f);
        com.anythink.core.common.u.e.a(xVar, wVar, 1, this.A > this.B ? 2 : 1, isSinglePicture(this.g, this.f.o) ? 2 : 1, this.x, this.y);
    }
}
