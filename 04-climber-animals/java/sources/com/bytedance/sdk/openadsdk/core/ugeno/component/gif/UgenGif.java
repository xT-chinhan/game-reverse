package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.sdk.component.adexpress.widget.GifView;

/* JADX INFO: loaded from: classes2.dex */
public class UgenGif extends GifView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f3432ms;

    public UgenGif(Context context) {
        super(context);
    }

    public void ms(ah ahVar) {
        this.f3432ms = ahVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ah ahVar = this.f3432ms;
        if (ahVar != null) {
            ahVar.ah();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ah ahVar = this.f3432ms;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f3432ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f3432ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f3432ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }
}
