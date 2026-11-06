package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.n1.a0;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.c1;
import com.smartdigimkt.y1.d1;
import com.smartdigimkt.y1.e1;
import com.smartdigimkt.y1.f1;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeG2CV2View extends BaseG2CV2View {
    public static final int SWIPE_TYPE_ALL = 3;
    public static final int SWIPE_TYPE_HORIZONTAL = 1;
    public static final int SWIPE_TYPE_VERTICAL = 2;
    public final c1 A;
    public AnimatorSet B;
    public boolean C;
    public LinearLayout h;
    public FrameLayout i;
    public FrameLayout j;
    public FrameLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public int t;
    public boolean u;
    public FrameLayout v;
    public boolean w;
    public TextView x;
    public int y;
    public int z;

    public SwipeG2CV2View(Context context) {
        super(context);
        this.t = 3;
        this.y = -1;
        this.A = new c1(this);
    }

    public static void a(SwipeG2CV2View swipeG2CV2View) {
        swipeG2CV2View.getClass();
        try {
            AnimatorSet animatorSet = swipeG2CV2View.B;
            if (animatorSet != null) {
                animatorSet.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void applyBannerForegroundProfile(a0 a0Var) {
        FrameLayout frameLayout;
        int i;
        int i2;
        if (!this.u || a0Var == null || (frameLayout = this.v) == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.v.setClipChildren(true);
        this.v.setClipToPadding(true);
        FrameLayout frameLayout2 = this.v;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{0, Integer.MIN_VALUE});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setCornerRadius(k.a(getContext(), a0Var.b == 1 ? 4 : 5));
        frameLayout2.setBackground(gradientDrawable);
        Context context = getContext();
        if (a0Var.a != 3) {
            i = 0;
        } else {
            i = a0Var.b == 1 ? 20 : 7;
        }
        int iA = k.a(context, i);
        Context context2 = getContext();
        if (a0Var.a != 3) {
            i2 = 0;
        } else {
            i2 = a0Var.b == 1 ? 8 : 14;
        }
        int iA2 = k.a(context2, i2);
        ImageView imageViewA = a(a0Var, true);
        ImageView imageViewA2 = a(a0Var, false);
        TextView textView = new TextView(getContext());
        textView.setText(k.a(getContext(), "g2c_swipe_hint_text", "string"));
        textView.setTextColor(-1);
        textView.setTextSize(2, 10);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine(true);
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setClickable(false);
        textView.setLongClickable(false);
        textView.setFocusable(false);
        textView.setImportantForAccessibility(2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        int iA3 = k.a(getContext(), 4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams.rightMargin = iA3;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams3.leftMargin = iA3;
        linearLayout.addView(imageViewA, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(imageViewA2, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.v.addView(linearLayout, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = this.v.getLayoutParams() instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) this.v.getLayoutParams() : new RelativeLayout.LayoutParams(0, 0);
        layoutParams5.width = k.a(getContext(), a0Var.d);
        layoutParams5.height = k.a(getContext(), a0Var.e);
        layoutParams5.setMargins(0, 0, 0, 0);
        layoutParams5.addRule(13, 0);
        layoutParams5.addRule(12, 0);
        layoutParams5.addRule(14, 0);
        if (a0Var.c) {
            layoutParams5.addRule(13, -1);
        } else {
            layoutParams5.addRule(12, -1);
            layoutParams5.addRule(14, -1);
        }
        this.v.setLayoutParams(layoutParams5);
    }

    public final void b() {
        TextView textView = this.x;
        if (textView == null) {
            return;
        }
        textView.setTextSize(2, 8.0f);
        this.x.setTextColor(-1);
        this.x.setIncludeFontPadding(false);
        this.x.setMinHeight(k.a(getContext(), 18.0f));
        int iA = k.a(getContext(), 10.0f);
        int iA2 = k.a(getContext(), 4.0f);
        this.x.setPadding(iA, iA2, iA, iA2);
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int iA3 = k.a(getContext(), 8.0f);
            marginLayoutParams.leftMargin = iA3;
            marginLayoutParams.rightMargin = iA3;
            this.x.setLayoutParams(marginLayoutParams);
        }
    }

    public final void c() {
        try {
            AnimatorSet animatorSet = this.B;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.B = null;
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        TextView textView = this.x;
        if (textView == null || this.h == null) {
            return;
        }
        if (textView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.x.getParent()).removeView(this.x);
        }
        int id = this.x.getId();
        if (id == -1) {
            id = View.generateViewId();
            this.x.setId(id);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(this.x, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams2.addRule(12, 0);
        layoutParams2.addRule(13, 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, id);
        this.h.setLayoutParams(layoutParams2);
    }

    public final void f() {
        LinearLayout linearLayout = this.h;
        if (linearLayout == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            this.h.post(new Runnable() { // from class: com.smartdigimkt.sdk.basead.ui.guidetoclickv2.SwipeG2CV2View$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        } else {
            viewTreeObserver.addOnGlobalLayoutListener(new e1(this));
        }
    }

    public final void g() {
        try {
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            FrameLayout frameLayout2 = this.j;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            FrameLayout frameLayout3 = this.k;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            int i = this.t;
            if (i == 1) {
                FrameLayout frameLayout4 = this.i;
                if (frameLayout4 != null) {
                    frameLayout4.setVisibility(0);
                }
                this.o = this.l;
                return;
            }
            if (i != 2) {
                FrameLayout frameLayout5 = this.k;
                if (frameLayout5 != null) {
                    frameLayout5.setVisibility(0);
                }
                this.o = this.n;
                return;
            }
            FrameLayout frameLayout6 = this.j;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(0);
            }
            this.o = this.m;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void d() {
        if (this.C) {
            return;
        }
        try {
            if (this.o == null) {
                return;
            }
            c();
            this.o.setTranslationX(0.0f);
            this.o.setTranslationY(0.0f);
            int i = this.t;
            float fMax = 10.0f;
            if (i == 1) {
                ImageView imageView = this.p;
                if (imageView == null) {
                    return;
                }
                int width = imageView.getWidth();
                int width2 = this.o.getWidth();
                if (width > 0) {
                    fMax = Math.max(10.0f, (width - Math.max(0, width2)) / 2.0f);
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, -fMax, 0.0f, fMax, 0.0f);
                objectAnimatorOfFloat.setDuration(6000L);
                objectAnimatorOfFloat.setRepeatCount(-1);
                AnimatorSet animatorSet = new AnimatorSet();
                this.B = animatorSet;
                animatorSet.play(objectAnimatorOfFloat);
                this.B.start();
                this.C = true;
                return;
            }
            if (i == 2) {
                ImageView imageView2 = this.q;
                if (imageView2 == null) {
                    return;
                }
                int height = imageView2.getHeight();
                int height2 = this.o.getHeight();
                if (height > 0) {
                    fMax = Math.max(10.0f, (height - Math.max(0, height2)) / 2.0f);
                }
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.o, "translationY", 0.0f, -fMax, 0.0f);
                objectAnimatorOfFloat2.setDuration(4200L);
                objectAnimatorOfFloat2.setRepeatCount(-1);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.B = animatorSet2;
                animatorSet2.play(objectAnimatorOfFloat2);
                this.B.start();
                this.C = true;
                return;
            }
            ImageView imageView3 = this.r;
            if (imageView3 != null && this.s != null) {
                int width3 = imageView3.getWidth();
                float fMax2 = width3 <= 0 ? 10.0f : Math.max(10.0f, (width3 - Math.max(0, this.o.getWidth())) / 2.0f);
                int height3 = this.s.getHeight();
                int height4 = this.o.getHeight();
                if (height3 > 0) {
                    fMax = Math.max(10.0f, (height3 - Math.max(0, height4)) / 2.0f);
                }
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, -fMax2, 0.0f, fMax2, 0.0f);
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.o, "translationY", 0.0f, -fMax, 0.0f, fMax, 0.0f);
                objectAnimatorOfFloat3.setDuration(6000L);
                objectAnimatorOfFloat4.setDuration(6000L);
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.B = animatorSet3;
                animatorSet3.playSequentially(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
                this.B.addListener(new f1(this));
                this.B.start();
                this.C = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void initView(int i, int i2) {
        ?? r7;
        try {
            if (getContext() == null) {
                return;
            }
            setClickable(false);
            setFocusable(false);
            setBackgroundColor(0);
            if (i == 4) {
                this.u = true;
                setClipChildren(false);
                setClipToPadding(false);
                a(a0.a(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 50, 3));
                return;
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(k.a(getContext(), "swipe_g2c_v2_guide", "layout"), (ViewGroup) this, false);
            this.h = linearLayout;
            linearLayout.setClipChildren(false);
            this.h.setBackgroundColor(0);
            int iA = k.a(getContext(), "swipe_stack_horizontal", "id");
            int iA2 = k.a(getContext(), "swipe_stack_vertical", "id");
            int iA3 = k.a(getContext(), "swipe_stack_cross", "id");
            int iA4 = k.a(getContext(), "swipe_finger_horizontal", "id");
            int iA5 = k.a(getContext(), "swipe_finger_vertical", "id");
            int iA6 = k.a(getContext(), "swipe_finger_cross", "id");
            int iA7 = k.a(getContext(), "swipe_arrow_horizontal_full", "id");
            int iA8 = k.a(getContext(), "swipe_arrow_vertical_full", "id");
            int iA9 = k.a(getContext(), "swipe_cross_horizontal_full", "id");
            int iA10 = k.a(getContext(), "swipe_cross_vertical_full", "id");
            int iA11 = k.a(getContext(), "swipe_hint_text", "id");
            int iA12 = k.a(getContext(), "g2c_swipe_hint_text", "string");
            String string = iA12 > 0 ? getContext().getString(iA12) : "";
            this.i = (FrameLayout) this.h.findViewById(iA);
            this.j = (FrameLayout) this.h.findViewById(iA2);
            this.k = (FrameLayout) this.h.findViewById(iA3);
            this.l = (ImageView) this.h.findViewById(iA4);
            this.m = (ImageView) this.h.findViewById(iA5);
            this.n = (ImageView) this.h.findViewById(iA6);
            TextView textView = (TextView) this.h.findViewById(iA11);
            if (textView != null) {
                textView.setTextSize(2, 12.0f);
                textView.setText(string);
            }
            this.x = textView;
            this.p = (ImageView) this.h.findViewById(iA7);
            this.q = (ImageView) this.h.findViewById(iA8);
            this.r = (ImageView) this.h.findViewById(iA9);
            this.s = (ImageView) this.h.findViewById(iA10);
            g();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            boolean z = i == 2;
            boolean z2 = i == 5 || i == 6;
            boolean z3 = i == 4;
            boolean zB = k.b(getContext());
            if (z2) {
                b();
                r7 = 0;
                setClipChildren(false);
                setClipToPadding(false);
            } else {
                r7 = 0;
            }
            if (z3) {
                this.u = true;
                setClipChildren(r7);
                setClipToPadding(r7);
                layoutParams.addRule(12, r7);
                layoutParams.addRule(13);
            } else if (z2 && this.w) {
                layoutParams.addRule(12, 0);
                layoutParams.addRule(13);
            } else if (!z && !z2 && !zB) {
                layoutParams.bottomMargin = k.a(getContext(), 195.0f);
            }
            addView(this.h, layoutParams);
            if (z2) {
                e();
            }
            if (!this.u && this.w) {
                this.z = 0;
                removeCallbacks(this.A);
                post(this.A);
            }
            f();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u) {
            post(new d1(this));
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        boolean z = this.u;
        if (z && i > 0 && i2 > 0) {
            applyBannerForegroundProfile(a0.a(k.b(getContext(), i), k.b(getContext(), i2), 3));
            return;
        }
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (!z && this.w) {
            a(0);
        }
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        if (i == i3 && i2 == i4) {
            return;
        }
        this.C = false;
        c();
        f();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void pauseAnim() {
        try {
            AnimatorSet animatorSet = this.B;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        try {
            removeCallbacks(this.A);
            c();
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FrameLayout frameLayout = this.v;
            if (frameLayout != null) {
                removeView(frameLayout);
                this.v = null;
            }
            this.C = false;
        } catch (Throwable unused) {
        }
        super.release();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void resumeAnim() {
        try {
            AnimatorSet animatorSet = this.B;
            if (animatorSet != null) {
                animatorSet.resume();
            }
        } catch (Throwable unused) {
        }
    }

    public void setNativeSmallCompactScale(boolean z) {
        this.w = z;
    }

    public void setSwipeType(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 3;
        }
        this.t = i;
    }

    public final void a(a0 a0Var) {
        if (this.v == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.v = frameLayout;
            frameLayout.setClickable(false);
            this.v.setLongClickable(false);
            this.v.setFocusable(false);
            this.v.setImportantForAccessibility(2);
            addView(this.v);
        }
        applyBannerForegroundProfile(a0Var);
    }

    public final ImageView a(a0 a0Var, boolean z) {
        int iA;
        ImageView imageView = new ImageView(getContext());
        if (a0Var.b == 1) {
            iA = k.a(getContext(), z ? "banner_interaction_swipe_narrow_left" : "banner_interaction_swipe_narrow_right", "drawable");
        } else {
            iA = k.a(getContext(), z ? "banner_interaction_swipe_large_left" : "banner_interaction_swipe_large_right", "drawable");
        }
        if (iA != 0) {
            imageView.setImageResource(iA);
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setContentDescription(null);
        imageView.setClickable(false);
        imageView.setLongClickable(false);
        imageView.setFocusable(false);
        imageView.setImportantForAccessibility(2);
        return imageView;
    }

    public SwipeG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.t = 3;
        this.y = -1;
        this.A = new c1(this);
    }

    public SwipeG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = 3;
        this.y = -1;
        this.A = new c1(this);
    }

    public final void a(ImageView imageView, int i, int i2) {
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = k.a(getContext(), i);
            marginLayoutParams.leftMargin = k.a(getContext(), i2);
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    public final void a(int i) {
        float f;
        float f2;
        int i2;
        int i3;
        if (this.h == null) {
            return;
        }
        boolean z = true;
        if (getHeight() <= 0 || getWidth() <= 0) {
            if (i < 2) {
                this.z = i + 1;
                removeCallbacks(this.A);
                post(this.A);
                return;
            }
            return;
        }
        int iB = k.b(getContext(), getHeight());
        if (this.u && iB != this.y) {
            this.y = iB;
            if (iB <= 56) {
                i3 = 10;
                i2 = 8;
            } else {
                i2 = 16;
                if (iB <= 100) {
                    i3 = 14;
                } else {
                    z = false;
                    i2 = 20;
                    i3 = 16;
                }
            }
            TextView textView = this.x;
            if (textView != null) {
                textView.setVisibility(z ? 8 : 0);
                if (!z) {
                    this.x.setTextSize(2, 10.0f);
                }
            }
            a(this.l, i2, i3);
            a(this.m, i2, i3);
            a(this.n, i2, i3);
            this.h.requestLayout();
            this.z = 0;
            removeCallbacks(this.A);
            post(this.A);
            return;
        }
        if (this.h.getHeight() <= 0 || this.h.getWidth() <= 0) {
            if (i < 2) {
                this.z = i + 1;
                removeCallbacks(this.A);
                post(this.A);
                return;
            }
            return;
        }
        float f3 = 0.85f;
        if (this.u) {
            f = 0.88f;
            if (iB <= 56) {
                f2 = 0.9f;
            } else {
                f2 = iB <= 100 ? 0.94f : 0.88f;
            }
            if (iB > 56) {
                f = iB <= 100 ? 0.92f : 0.85f;
            }
            f3 = f2;
        } else {
            f = 0.85f;
        }
        float fMin = Math.min(1.0f, Math.min((getHeight() * f3) / this.h.getHeight(), (getWidth() * f) / this.h.getWidth()));
        LinearLayout linearLayout = this.h;
        linearLayout.setPivotX(linearLayout.getWidth() / 2.0f);
        LinearLayout linearLayout2 = this.h;
        linearLayout2.setPivotY(linearLayout2.getHeight() / 2.0f);
        this.h.setScaleX(fMin);
        this.h.setScaleY(fMin);
        getWidth();
        getHeight();
        this.h.getWidth();
        this.h.getHeight();
    }
}
