package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.ugeno.ah;

/* JADX INFO: loaded from: classes2.dex */
public class UgenLottieView extends LottieAnimationView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f3463ms;

    public UgenLottieView(Context context) {
        super(context);
    }

    public void ms(ah ahVar) {
        this.f3463ms = ahVar;
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f3463ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f3463ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }
}
