package com.byazt.jm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
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
import com.byazt.ca.g;
import com.byazt.hg.pq;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 1877})
public class RockView extends LinearLayout {
    public TextView hn;
    public TextView hw;
    public ImageView pr;

    public RockView(Context context) {
        super(context);
        hw(context);
    }

    private View pr(Context context) {
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
        int iHn = er.hn(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(iHn);
        shapeDrawable.setIntrinsicWidth(iHn);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.pr = imageView;
        imageView.setId(2114387566);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        g.pr(context, "tt_splash_rock", this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.pr.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.pr);
        TextView textView = new TextView(context);
        this.hw = textView;
        textView.setId(2114387564);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.hw.setSingleLine();
        this.hw.setText("摇一摇");
        this.hw.setTextColor(-1);
        this.hw.setTextSize(14.0f);
        this.hw.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.hw);
        TextView textView2 = new TextView(context);
        this.hn = textView2;
        textView2.setId(2114387563);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = er.hn(context, 12.0f);
        this.hn.setLayoutParams(layoutParams5);
        this.hn.setText("前往详情页或第三方应用");
        this.hn.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.hn.setTextColor(-1);
        linearLayout.addView(this.hn);
        return linearLayout;
    }

    private void hw(Context context) {
        if (context == null) {
            context = a.getContext();
        }
        View viewPr = pr(context);
        if (viewPr == null) {
            return;
        }
        addView(viewPr);
    }

    public void pr(pq pqVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.hw;
        if (textView != null) {
            textView.setText(pqVar.w());
            this.hw.setTextSize(2, pqVar.m().hw());
        }
        TextView textView2 = this.hn;
        if (textView2 != null) {
            textView2.setText(pqVar.hw());
            this.hn.setTextSize(2, pqVar.k().hw());
            this.hn.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void pr() {
        if (this.pr != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new pr());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.jm.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.byazt.jm.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.pr.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.pr.startAnimation(rotateAnimation);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 1563})
    private static class pr implements Interpolator {
        private pr() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            if (f <= 0.75f) {
                return (f * (-4.0f)) + 3.0f;
            }
            return (f * 2.0f) - 1.5f;
        }
    }
}
