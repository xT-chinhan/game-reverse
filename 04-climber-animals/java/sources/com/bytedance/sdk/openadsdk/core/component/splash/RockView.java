package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.v;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class RockView extends LinearLayout {
    private TextView ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f2319ms;
    private TextView xr;

    public RockView(Context context) {
        super(context);
        xr(context);
    }

    private View ms(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int iAh = ul.ah(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(iAh);
        shapeDrawable.setIntrinsicWidth(iAh);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.f2319ms = imageView;
        imageView.setId(2114387572);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        Drawable drawableAh = t.ah(context, "tt_splash_rock");
        if (drawableAh != null) {
            this.f2319ms.setImageDrawable(drawableAh);
        } else {
            com.bytedance.sdk.openadsdk.x.xr.ms(com.bytedance.sdk.openadsdk.core.x.ah.ms("splash_rock.png")).ms(this.f2319ms);
        }
        this.f2319ms.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f2319ms);
        TextView textView = new TextView(context);
        this.xr = textView;
        textView.setId(2114387570);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.xr.setSingleLine();
        this.xr.setText(t.ms(context, "tt_splash_rock_top"));
        this.xr.setTextColor(-1);
        this.xr.setTextSize(14.0f);
        this.xr.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.xr);
        TextView textView2 = new TextView(context);
        this.ah = textView2;
        textView2.setId(2114387569);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = ul.ah(context, 12.0f);
        this.ah.setLayoutParams(layoutParams5);
        this.ah.setText(t.ms(context, "tt_splash_rock_desc"));
        this.ah.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.ah.setTextColor(-1);
        linearLayout.addView(this.ah);
        return linearLayout;
    }

    private void xr(Context context) {
        if (context == null) {
            context = re.getContext();
        }
        View viewMs = ms(context);
        if (viewMs == null) {
            return;
        }
        addView(viewMs);
    }

    public void ms(v vVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.xr;
        if (textView != null) {
            textView.setText(vVar.hi());
            this.xr.setTextSize(2, vVar.zb().xr());
        }
        TextView textView2 = this.ah;
        if (textView2 != null) {
            textView2.setText(vVar.xr());
            this.ah.setTextSize(2, vVar.sl().xr());
            this.ah.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void ms() {
        if (this.f2319ms != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new ms());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.f2319ms.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }
            });
            this.f2319ms.startAnimation(rotateAnimation);
        }
    }

    private static class ms implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private ms() {
        }
    }
}
