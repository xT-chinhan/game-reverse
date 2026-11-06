package com.smartdigimkt.e;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.R;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ BaseSdkSplashATView b;
    public final /* synthetic */ Bitmap c;
    public final /* synthetic */ Runnable d;
    public final /* synthetic */ Runnable e;

    public m(Runnable runnable, BaseSdkSplashATView baseSdkSplashATView, Bitmap bitmap, Runnable runnable2, Runnable runnable3, int i) {
        this.a = runnable;
        this.b = baseSdkSplashATView;
        this.c = bitmap;
        this.d = runnable2;
        this.e = runnable3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a == null || this.b.getTag(R.id.sdm_bubble_delay_runnable_tag) == this.a) {
            if (q.a(this.b)) {
                q.a(this.b, this.c, this.d, this.e, this.a);
            } else {
                q.b(this.b, this.a);
            }
        }
    }
}
