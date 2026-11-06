package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends xr {
    private TextView ao;
    private TextView h;
    private UpieImageView qv;
    private TTRoundRectImageView u;
    private TextView ub;
    private ImageView zb;

    public ab(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.ny = (FrameLayout) this.xr.findViewById(2114387921);
        ms(this.ab);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.ah)) {
            d();
        } else {
            ah();
            xr();
        }
    }

    private void xr() {
        int i = (int) (this.ka * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        ms(this.d == 1 ? 0.562f : 1.777f);
    }

    private void ms(View view) {
        if (this.ah == null || view == null) {
            return;
        }
        final float fAe = this.ah.ae();
        if (fAe <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ab.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), ul.ah(re.getContext(), fAe));
            }
        });
        view.setClipToOutline(true);
    }

    private void ah() {
        TextView textView;
        this.zb = (ImageView) this.xr.findViewById(2114387718);
        this.u = (TTRoundRectImageView) this.xr.findViewById(2114387728);
        this.ub = (TextView) this.xr.findViewById(2114387708);
        this.ao = (TextView) this.xr.findViewById(2114387962);
        this.h = (TextView) this.xr.findViewById(2114387725);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.ah)) {
            UpieImageView upieImageView = new UpieImageView(this.zb.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.ah), com.bytedance.sdk.openadsdk.ka.ms.ch(this.ah));
            this.qv = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.ah.bn()) && (textView = this.ao) != null) {
            textView.setText(this.ah.bn());
        }
        if (qr.u(this.ah) != null && lm.xr(this.ah)) {
            ul.ms((View) this.zb, 8);
            ul.ms((View) this.ny, 0);
        } else {
            ms(this.zb, this.qv);
            ul.ms((View) this.zb, 0);
            ul.ms((View) this.ny, 8);
        }
        g gVarQd = this.ah.qd();
        if (gVarQd != null) {
            com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(this.u);
        }
        TextView textView2 = this.ub;
        if (textView2 != null) {
            textView2.setText(u());
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            textView3.setText(ub());
        }
        ul.ms((TextView) this.xr.findViewById(2114387664), this.ah);
    }

    private void d() {
        this.hi = (RelativeLayout) this.xr.findViewById(2114387850);
        if (com.bytedance.sdk.openadsdk.core.nw.ul.ms(this.ah)) {
            String strX = com.bytedance.sdk.openadsdk.core.nw.ul.x(this.ah);
            if (TextUtils.isEmpty(strX)) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(strX).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ab.2
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(ab.this.xr, hiVar.ah(), 25);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(ab.this.xr.getResources(), bitmapMs);
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ab.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ab.this.ab != null) {
                                ab.this.ab.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void ms(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fKa = ka();
        float fC = c();
        if (this.d == 2) {
            fMin = Math.max(fKa, fC);
            fMax = Math.min(fKa, fC);
        } else {
            fMin = Math.min(fKa, fC);
            fMax = Math.max(fKa, fC);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.ah.mp());
        if (this.d != 2) {
            fMax -= ul.d(this.xr, ul.hi((Context) this.xr));
        }
        if (this.d != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.xr.getWindow().getDecorView().setPadding(ul.ah(this.xr, f5), ul.ah(this.xr, f4), ul.ah(this.xr, f5), ul.ah(this.xr, f4));
        } catch (Throwable unused) {
        }
    }

    private float ka() {
        return ul.d(this.xr, ul.ny((Context) this.xr));
    }

    private float c() {
        return ul.d(this.xr, ul.ch((Context) this.xr));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.ah)) {
            final com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.xr, this.ah, this.f2216ms, f.xr(this.f2216ms));
            if (this.ny != null) {
                this.ny.setOnClickListener(new com.bytedance.sdk.openadsdk.core.xr.xr(this.xr, this.ah, this.f2216ms, f.xr(this.f2216ms)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ab.3
                    @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
                    public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
                        HashMap map = new HashMap();
                        map.put("click_live_element", "click_live_feed");
                        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
                        msVar.ms(view, hiVar);
                    }
                });
            }
        } else {
            ms(this.ny, xrVar, xrVar);
        }
        ms(this.zb, xrVar, xrVar);
        ms(this.u, xrVar, xrVar);
        ms(this.ub, xrVar, xrVar);
        ms(this.ao, xrVar, xrVar);
        ms(this.h, xrVar, xrVar);
        ms(this.ab, xrVar, xrVar);
        ms(this.qv, xrVar, xrVar);
    }

    private void ms(View view, com.bytedance.sdk.openadsdk.core.xr.xr xrVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(xrVar);
    }
}
