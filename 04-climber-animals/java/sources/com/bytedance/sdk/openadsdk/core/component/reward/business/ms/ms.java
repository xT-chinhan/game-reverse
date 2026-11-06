package com.bytedance.sdk.openadsdk.core.component.reward.business.ms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.xr.xr;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private TextView ab;
    private ImageView ah;
    private LinearLayout c;
    private final xr ch;
    private ViewGroup d;
    private View ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTBaseVideoActivity f2116ms;
    private ObjectAnimator ny;
    private ObjectAnimator x;
    private final lm xr;

    public ms(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, xr xrVar) {
        this.f2116ms = tTBaseVideoActivity;
        this.xr = lmVar;
        this.ch = xrVar;
    }

    public void ms(ViewGroup viewGroup, View view) {
        this.d = viewGroup;
        this.ka = view;
        this.ah = new ImageView(this.f2116ms);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ul.ah(this.f2116ms, 76.0f));
        layoutParams.gravity = 80;
        this.ah.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.addView(this.ah, layoutParams);
    }

    public void ms() {
        int iQv;
        LinearLayout linearLayout = new LinearLayout(this.f2116ms);
        this.c = linearLayout;
        linearLayout.setGravity(1);
        this.c.setPadding(0, ul.ah(this.f2116ms, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ul.ah(this.f2116ms, 76.0f));
        TextView textView = new TextView(this.f2116ms);
        this.ab = textView;
        textView.setTextSize(12.0f);
        this.ab.setTextColor(-1);
        this.ab.setSingleLine();
        this.ab.setEllipsize(TextUtils.TruncateAt.START);
        this.ab.setGravity(5);
        this.ab.setMaxWidth(ul.ah(this.f2116ms, 260.0f));
        this.c.addView(this.ab);
        TextView textView2 = new TextView(this.f2116ms);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ms.this.d();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ul.ah(this.f2116ms, 10.0f);
        this.c.addView(textView2, layoutParams2);
        ms(25, qr.xr(this.xr));
        int iAh = ul.ah(this.f2116ms, 76.0f);
        this.d.addView(this.c, layoutParams);
        try {
            int iXr = x.xr(this.f2116ms);
            if (ul.d((Activity) this.f2116ms)) {
                iQv = (x.ah(this.f2116ms) - iXr) - xr();
            } else {
                iQv = ul.qv(this.f2116ms);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", iXr, (iXr - iAh) + iQv);
            this.x = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.x.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ka, "translationY", 0.0f, -iAh);
            this.ny = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.ny.start();
        } catch (Throwable th) {
            sl.d("layout", th.getMessage());
        }
    }

    public int xr() {
        int identifier = this.f2116ms.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f2116ms.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void ms(final int i, String str) {
        com.bytedance.sdk.openadsdk.x.xr.ms(str).ah(2).ms(Bitmap.Config.ARGB_8888).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms.2
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi<Bitmap> hiVar) {
                try {
                    Bitmap bitmapAh = hiVar.ah();
                    if (bitmapAh == null) {
                        return;
                    }
                    if (bitmapAh.getConfig() == Bitmap.Config.RGB_565) {
                        bitmapAh = bitmapAh.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(ms.this.f2116ms, bitmapAh, i);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(ms.this.f2116ms.getResources(), bitmapMs);
                    ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ms.this.c != null) {
                                ms.this.c.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (ms.this.ah != null) {
                                ms.this.ah.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    sl.d("layout", th.getMessage());
                }
            }
        }, 4);
    }

    public void ah() {
        d();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ka, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ms.this.ka.setAlpha(1.0f);
                ms.this.ch.ny();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        com.bytedance.sdk.openadsdk.core.nw.hi hiVar = new com.bytedance.sdk.openadsdk.core.nw.hi();
        hiVar.xr(true);
        if (xrVar != null) {
            xrVar.ms(hiVar);
            xrVar.ms(null, hiVar);
        }
    }

    public void d() {
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.x.cancel();
            this.x = null;
        }
        ObjectAnimator objectAnimator2 = this.ny;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.ny.cancel();
            this.ny = null;
        }
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.ka;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.ah;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.ch.x();
    }

    public void ms(long j) {
        TextView textView = this.ab;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
