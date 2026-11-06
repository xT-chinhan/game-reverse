package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class uf extends FrameLayout {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public int f;
    public int g;
    public final float h;
    public final float i;
    public boolean j;
    public final ArrayList k;
    public final HashMap l;
    public final Random m;
    public final Handler n;
    public rf o;
    public w8 p;
    public sf q;
    public long r;
    public long s;

    public uf(Context context) {
        super(context, null, 0);
        this.a = 0;
        this.b = 20;
        this.c = 200L;
        this.d = 2000L;
        this.e = 4000L;
        this.f = 40;
        this.g = 60;
        this.h = -30.0f;
        this.i = 30.0f;
        this.j = false;
        this.k = new ArrayList();
        this.l = new HashMap();
        this.m = new Random();
        this.n = new Handler(Looper.getMainLooper());
        this.r = 0L;
        this.s = 0L;
        setBackground(null);
    }

    public final void a() {
        if (this.j) {
            return;
        }
        if (this.a == 0) {
            r9.a("RedPacketRainView", "start: 红包资源 ID 未设置，请先调用 setRedPacketResId()", null);
            return;
        }
        this.r = 3000L;
        double d = 3000L;
        this.e = (long) (0.7d * d);
        this.d = Math.min(Math.max(2000L, (long) (0.5d * d)), this.e - 500);
        long j = (long) (d * 0.4d);
        long jMax = Math.max(1500L, j);
        this.d = jMax;
        long j2 = this.e;
        if (j2 - jMax < 500) {
            long j3 = j2 - 1000;
            this.d = j3;
            this.d = Math.max(1500L, j3);
        }
        long jMax2 = Math.max(100L, ((this.d + this.e) / 2) / 20);
        this.c = jMax2;
        long jMin = Math.min(500L, jMax2);
        this.c = jMin;
        this.b = Math.max(10, Math.min(200, (int) (j / jMin)));
        if (getWidth() == 0 || getHeight() == 0) {
            post(new qf(this));
        } else {
            b();
        }
    }

    public final void b() {
        this.j = true;
        long j = this.r;
        if (j <= 0) {
            j = (((long) (this.b - 1)) * this.c) + this.e;
        }
        sf sfVar = new sf(this, new long[]{System.currentTimeMillis()}, j);
        this.q = sfVar;
        this.n.post(sfVar);
        this.s = System.currentTimeMillis();
        rf rfVar = new rf(this, j);
        this.o = rfVar;
        this.n.post(rfVar);
    }

    public final void c() {
        this.j = false;
        rf rfVar = this.o;
        if (rfVar != null) {
            this.n.removeCallbacks(rfVar);
            this.o = null;
        }
        sf sfVar = this.q;
        if (sfVar != null) {
            this.n.removeCallbacks(sfVar);
            this.q = null;
        }
        for (Animator animator : new ArrayList(this.l.values())) {
            if (animator != null) {
                animator.cancel();
            }
        }
        this.l.clear();
        for (ImageView imageView : new ArrayList(this.k)) {
            if (imageView != null) {
                imageView.clearAnimation();
                if (imageView.getParent() != null) {
                    ((ViewGroup) imageView.getParent()).removeView(imageView);
                }
            }
        }
        this.k.clear();
        this.r = 0L;
        this.s = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public static void a(uf ufVar) {
        int i;
        if (ufVar.getWidth() == 0 || ufVar.getHeight() == 0) {
            return;
        }
        ImageView imageView = new ImageView(ufVar.getContext());
        imageView.setImageResource(ufVar.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Context context = ufVar.getContext();
        int i2 = ufVar.f;
        int iA = hk.a(context, ufVar.m.nextInt((ufVar.g - i2) + 1) + i2);
        int width = (ufVar.getWidth() - ufVar.getPaddingLeft()) - ufVar.getPaddingRight();
        if (width > iA && (i = width - iA) > 0) {
            int iNextInt = ufVar.m.nextInt(i + 1) + ufVar.getPaddingLeft();
            int i3 = -iA;
            int iMax = Math.max(ufVar.getPaddingLeft(), Math.min((ufVar.m.nextInt(Math.max(iA * 2, width / 5) + 1) * (ufVar.m.nextBoolean() ? 1 : -1)) + iNextInt, (ufVar.getWidth() - ufVar.getPaddingRight()) - iA));
            int height = ufVar.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.leftMargin = iNextInt;
            layoutParams.topMargin = i3;
            imageView.setLayoutParams(layoutParams);
            imageView.setRotation(((ufVar.i - ufVar.h) * ufVar.m.nextFloat()) + ufVar.h);
            ufVar.addView(imageView);
            ufVar.k.add(imageView);
            long j = ufVar.d;
            long jNextInt = j + ((long) ufVar.m.nextInt((int) ((ufVar.e - j) + 1)));
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, height - i3);
            objectAnimatorOfFloat.setDuration(jNextInt);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, iMax - iNextInt);
            objectAnimatorOfFloat2.setDuration(jNextInt);
            float rotation = imageView.getRotation();
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView, "rotation", rotation, (ufVar.m.nextFloat() * (ufVar.m.nextBoolean() ? 1 : -1) * 60.0f) + rotation);
            objectAnimatorOfFloat3.setDuration(jNextInt);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.8f);
            objectAnimatorOfFloat4.setDuration(jNextInt);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            animatorSet.addListener(new tf(ufVar, imageView));
            ufVar.l.put(imageView, animatorSet);
            animatorSet.start();
        }
    }
}
