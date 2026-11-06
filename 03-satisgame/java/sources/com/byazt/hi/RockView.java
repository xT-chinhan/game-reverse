package com.byazt.hi;

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
import com.byazt.gct.el;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 2038})
public class RockView extends LinearLayout {
    public ImageView n;
    public TextView qg;
    public TextView s;

    public RockView(Context context) {
        super(context);
        qg(context);
    }

    private View n(Context context) {
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
        int iS = com.byazt.okk.s.s(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(iS);
        shapeDrawable.setIntrinsicWidth(iS);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.n = imageView;
        imageView.setId(2114387566);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        sz.n(context, "tt_splash_rock", this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.n.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.n);
        TextView textView = new TextView(context);
        this.qg = textView;
        textView.setId(2114387564);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.qg.setSingleLine();
        this.qg.setText("摇一摇");
        this.qg.setTextColor(-1);
        this.qg.setTextSize(14.0f);
        this.qg.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.qg);
        TextView textView2 = new TextView(context);
        this.s = textView2;
        textView2.setId(2114387563);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = com.byazt.okk.s.s(context, 12.0f);
        this.s.setLayoutParams(layoutParams5);
        this.s.setText("前往详情页或第三方应用");
        this.s.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.s.setTextColor(-1);
        linearLayout.addView(this.s);
        return linearLayout;
    }

    private void qg(Context context) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        View viewN = n(context);
        if (viewN == null) {
            return;
        }
        addView(viewN);
    }

    public void n(el elVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.qg;
        if (textView != null) {
            textView.setText(elVar.cp());
            this.qg.setTextSize(2, elVar.oa().qg());
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText(elVar.qg());
            this.s.setTextSize(2, elVar.d().qg());
            this.s.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void n() {
        if (this.n != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new n());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.hi.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.byazt.hi.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.n.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }
            });
            this.n.startAnimation(rotateAnimation);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 123, 1589})
    private static class n implements Interpolator {
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

        private n() {
        }
    }
}
