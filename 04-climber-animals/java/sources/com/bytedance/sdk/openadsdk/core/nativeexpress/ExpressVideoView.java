package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected int f2937ms;
    private boolean nw;
    private boolean re;
    public ImageView xr;

    public ExpressVideoView(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, false, false, str, false, false);
        this.nw = false;
        if ("draw_ad".equals(str)) {
            this.nw = true;
        }
        this.b = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.d.ah ms(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        if (this.b) {
            return new com.bytedance.sdk.openadsdk.core.video.nativevideo.ah(context, viewGroup, lmVar, str, z, z2, z3);
        }
        return super.ms(context, viewGroup, lmVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void xr() {
        if (this.nw) {
            super.xr(this.f2937ms);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.nw = z;
    }

    public void setVideoPlayStatus(int i) {
        this.f2937ms = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.ka != null) {
            this.ka.ka(z);
        }
    }

    public void ah() {
        if (this.zb != null) {
            ul.ms((View) this.zb, 8);
        }
    }

    public void x_() {
        if (this.zb != null) {
            ul.ms((View) this.zb, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            nw();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            nw();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void x() {
        ul.ms((View) this.ch, 0);
        ul.ms((View) this.hi, 0);
        ul.ms((View) this.zb, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void ms(boolean z) {
        if (this.re) {
            super.ms(z);
        }
    }

    public void xr(boolean z) {
        this.re = z;
    }

    private void nw() {
        hi();
        if (this.ch != null) {
            if (this.ch.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.d)).ms(this.hi);
            ms(this.hi, qr.xr(this.d));
        }
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            ul.ka(this.ch);
        }
        xr(this.f2937ms);
    }

    public void setShowAdInteractionView(boolean z) {
        com.bykv.vk.openvk.component.video.api.d.xr xrVarQv;
        if (this.ka == null || (xrVarQv = this.ka.qv()) == null) {
            return;
        }
        xrVarQv.ms(z);
    }

    protected void y_() {
        hi();
        ul.ms((View) this.ch, 0);
    }

    public void c() {
        if (this.sl != null) {
            ul.ms((View) this.sl, 8);
        }
    }

    public boolean z_() {
        return (this.ka == null || this.ka.h() == null || !this.ka.h().zb()) ? false : true;
    }

    protected void setPauseIcon(boolean z) {
        if (this.xr == null) {
            this.xr = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.ch.ub().e() != null) {
                this.xr.setImageBitmap(com.bytedance.sdk.openadsdk.core.ch.ub().e());
            } else {
                com.bytedance.sdk.component.utils.t.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), "tt_new_play_video", this.xr);
            }
            this.xr.setScaleType(ImageView.ScaleType.FIT_XY);
            int iAh = ul.ah(getContext(), this.ao);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iAh, iAh);
            layoutParams.gravity = 17;
            this.c.addView(this.xr, layoutParams);
        }
        if (z) {
            this.xr.setVisibility(0);
        } else {
            this.xr.setVisibility(8);
        }
    }

    public com.bykv.vk.openvk.component.video.api.d.ah getVideoController() {
        return this.ka;
    }
}
