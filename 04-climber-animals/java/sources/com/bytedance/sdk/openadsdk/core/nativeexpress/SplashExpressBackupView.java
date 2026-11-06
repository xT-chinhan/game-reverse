package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
public class SplashExpressBackupView extends BackupView implements com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah {
    private TextView ao;
    private Button h;
    private com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah nw;
    private FrameLayout qv;
    private NativeVideoTsView t;
    private View u;
    private GifView ub;
    private com.bytedance.sdk.openadsdk.core.re.ms.xr y;
    private NativeExpressView zb;

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void ms(long j, long j2) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void q_() {
    }

    public SplashExpressBackupView(Context context) {
        super(context);
        this.f2933ms = context;
        this.ka = "splash_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        NativeExpressView nativeExpressView = this.zb;
        if (nativeExpressView != null) {
            nativeExpressView.ms(view, i, iVar);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar, lm lmVar, NativeExpressView nativeExpressView) {
        this.xr = lmVar;
        this.zb = nativeExpressView;
        this.c = ul.ah(this.f2933ms, this.zb.getExpectExpressWidth());
        this.ab = ul.ah(this.f2933ms, this.zb.getExpectExpressWidth());
        this.y = xrVar;
        c();
        this.zb.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.c, this.ab);
        }
        layoutParams.width = this.c;
        layoutParams.height = this.ab;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        ms(this.xr.kz(), this.xr);
    }

    private void ms(int i, lm lmVar) {
        if (!ab()) {
            if (i == 5) {
                hi();
                return;
            } else {
                sl();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        zb();
                        return;
                    }
                }
            }
            if (x()) {
                zb();
                return;
            } else {
                ch();
                return;
            }
        }
        ny();
    }

    private boolean ab() {
        NativeExpressView nativeExpressView = this.zb;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private boolean x() {
        return this.xr != null && this.xr.od() == 2;
    }

    private void ny() {
        u();
        this.ub.setVisibility(0);
        this.qv.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.ub.getLayoutParams();
        layoutParams.height = ul.ah(this.f2933ms, 291.0f);
        this.ub.setLayoutParams(layoutParams);
        ms(this.ub, this.xr, this.y);
        this.ao.setText(this.xr.fs());
        if (this.xr.kk() != null) {
            ul.ms((View) this.h, 8);
        } else {
            ul.ms((View) this.h, 0);
            this.h.setText(this.xr.bn());
            ms((View) this.h, true);
        }
        setExpressBackupListener(this.u);
    }

    private void ch() {
        u();
        this.ub.setVisibility(0);
        this.qv.setVisibility(8);
        ms(this.ub, this.xr, this.y);
        this.ao.setText(this.xr.fs());
        if (this.xr.kk() != null) {
            ul.ms((View) this.h, 8);
        } else {
            ul.ms((View) this.h, 0);
            this.h.setText(this.xr.bn());
            ms((View) this.h, true);
        }
        setExpressBackupListener(this.u);
    }

    private void hi() {
        u();
        this.ub.setVisibility(8);
        this.qv.setVisibility(0);
        if (qr.u(this.xr) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) ms(this.zb);
            this.t = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.t == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.qv.addView(this.t, layoutParams);
        }
        this.ao.setText(this.xr.fs());
        if (this.xr.kk() != null) {
            ul.ms((View) this.h, 8);
        } else {
            ul.ms((View) this.h, 0);
            this.h.setText(this.xr.bn());
            ms((View) this.h, true);
        }
        setExpressBackupListener(this.u);
    }

    private void sl() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) ms(this.zb);
        this.t = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.t;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    public void setVideoAdListener(com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah) {
        this.nw = interfaceC0177ah;
    }

    private void zb() {
        GifView gifView = new GifView(this.f2933ms);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        ms(gifView, this.xr, this.y);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        if (this.xr == null || this.xr.jm() != 1) {
            return;
        }
        ms(view, true);
    }

    private View ms(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        com.bytedance.sdk.component.utils.t.ms(context, "tt_splash_ad_backup_bg", linearLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = ul.ah(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.t.ms(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.ao = textView2;
        textView2.setId(2114387477);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = ul.ah(context, 31.0f);
        layoutParams3.gravity = 1;
        this.ao.setLayoutParams(layoutParams3);
        this.ao.setGravity(1);
        this.ao.setTextSize(2, 15.0f);
        this.ao.setTextColor(Color.parseColor("#895434"));
        this.ao.setSingleLine(false);
        linearLayout.addView(this.ao);
        GifView gifView = new GifView(context);
        this.ub = gifView;
        gifView.setId(2114387476);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = ul.ah(context, 29.0f);
        layoutParams4.setMarginStart(ul.ah(context, 15.0f));
        layoutParams4.setMarginEnd(ul.ah(context, 15.0f));
        layoutParams4.gravity = 1;
        this.ub.setLayoutParams(layoutParams4);
        this.ub.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.ub);
        FrameLayout frameLayout = new FrameLayout(context);
        this.qv = frameLayout;
        frameLayout.setId(2114387475);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(ul.ah(context, 15.0f));
        layoutParams5.setMarginEnd(ul.ah(context, 15.0f));
        this.qv.setLayoutParams(layoutParams5);
        this.qv.setVisibility(8);
        linearLayout.addView(this.qv);
        Button button = new Button(context);
        this.h = button;
        button.setId(2114387474);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = ul.ah(context, 37.0f);
        layoutParams6.gravity = 1;
        this.h.setLayoutParams(layoutParams6);
        this.h.setText(com.bytedance.sdk.component.utils.t.ms(context, "tt_splash_backup_ad_btn"));
        this.h.setTextColor(Color.parseColor("#ffffff"));
        this.h.setTypeface(Typeface.defaultFromStyle(1));
        com.bytedance.sdk.component.utils.t.ms(context, "tt_splash_ad_backup_btn_bg", this.h);
        linearLayout.addView(this.h);
        return linearLayout;
    }

    private void u() {
        View viewMs = ms(this.f2933ms);
        if (viewMs == null) {
            return;
        }
        addView(viewMs);
    }

    private void ms(GifView gifView) {
        g gVar = this.xr.fk().get(0);
        if (gVar != null) {
            com.bytedance.sdk.openadsdk.x.xr.ms(gVar).ms(gifView);
        }
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.xr)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.xr), com.bytedance.sdk.openadsdk.ka.ms.ch(this.xr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.ka.ms.ms(gifView, upieImageView);
        }
    }

    void ms(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.ms(bArr, false);
    }

    void ms(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    void ms(GifView gifView, lm lmVar, com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar) {
        Drawable drawableMs;
        if (xrVar == null) {
            ms(gifView);
            return;
        }
        if (xrVar.ka()) {
            ms(xrVar.ah(), gifView);
            return;
        }
        if (lmVar.fk() == null || lmVar.fk().get(0) == null) {
            return;
        }
        if (xrVar.ms() != null) {
            drawableMs = new BitmapDrawable(xrVar.ms());
        } else {
            drawableMs = com.bytedance.sdk.openadsdk.core.jw.h.ms(xrVar.ah(), lmVar.fk().get(0).xr());
        }
        ms(drawableMs, gifView);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.xr)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.xr), com.bytedance.sdk.openadsdk.ka.ms.ch(this.xr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.ka.ms.ms(gifView, upieImageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void ms(View view, boolean z) {
        if (this.xr == null || this.xr.kk() == null || this.xr.kk().ms() != 1) {
            return;
        }
        super.ms(view, z);
    }

    public com.bykv.vk.openvk.component.video.api.d.ah getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.t;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void C_() {
        com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah = this.nw;
        if (interfaceC0177ah != null) {
            interfaceC0177ah.C_();
        }
    }
}
