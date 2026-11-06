package com.smartdigimkt.y1;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.SwipeG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ SwipeG2CV2View a;

    public e1(SwipeG2CV2View swipeG2CV2View) {
        this.a = swipeG2CV2View;
    }

    public final /* synthetic */ void a() {
        SwipeG2CV2View swipeG2CV2View = this.a;
        int i = SwipeG2CV2View.SWIPE_TYPE_HORIZONTAL;
        swipeG2CV2View.d();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        this.a.h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        SwipeG2CV2View swipeG2CV2View = this.a;
        int i = swipeG2CV2View.t;
        if (i == 1 ? (imageView = swipeG2CV2View.p) == null || imageView.getWidth() <= 0 : i == 2 ? (imageView2 = swipeG2CV2View.q) == null || imageView2.getHeight() <= 0 : (imageView3 = swipeG2CV2View.r) == null || imageView3.getWidth() <= 0 || (imageView4 = swipeG2CV2View.s) == null || imageView4.getHeight() <= 0) {
            this.a.h.post(new Runnable() { // from class: com.smartdigimkt.y1.e1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        } else {
            this.a.d();
        }
    }
}
