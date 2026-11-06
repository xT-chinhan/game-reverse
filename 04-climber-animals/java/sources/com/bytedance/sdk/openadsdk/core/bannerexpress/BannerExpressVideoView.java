package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressVideoView extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void ah() {
        super.ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void ka() {
        super.ka();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.ms msVar) {
        super.setExpressInteractionListener(msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar) {
        super.setVideoAdListener(ahVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public /* bridge */ /* synthetic */ boolean xr() {
        return super.xr();
    }

    public BannerExpressVideoView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    protected void ms() {
        this.xr = new NativeExpressVideoView(this.f2014ms, this.d, this.ka, this.ch);
        addView(this.xr, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.ms
    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.ah = new NativeExpressVideoView(this.f2014ms, lmVar, xrVar, this.ch);
        this.ah.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, int i) {
                if (BannerExpressVideoView.this.c != null) {
                    BannerExpressVideoView.this.c.ms(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, float f, float f2) {
                BannerExpressVideoView.this.ms(f, f2);
                BannerExpressVideoView.this.c();
            }
        });
        ul.ms((View) this.ah, 8);
        addView(this.ah, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms getVideoModel() {
        if (this.xr != null) {
            return ((NativeExpressVideoView) this.xr).getVideoModel();
        }
        return null;
    }
}
