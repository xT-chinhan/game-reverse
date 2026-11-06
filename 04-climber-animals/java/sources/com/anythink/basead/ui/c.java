package com.anythink.basead.ui;

import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private ViewGroup a;
    private ImageView b;
    private int c;

    public c(ViewGroup viewGroup) {
        this.a = viewGroup;
        ImageView imageView = new ImageView(this.a.getContext());
        this.b = imageView;
        imageView.setId(q.a(this.a.getContext(), "myoffer_loading_id", "id"));
        this.b.setImageResource(q.a(this.a.getContext(), "myoffer_loading", "drawable"));
        this.c = (int) TypedValue.applyDimension(1, 50.0f, this.a.getResources().getDisplayMetrics());
    }

    public final void a() {
        this.c = (int) TypedValue.applyDimension(1, 30.0f, this.a.getResources().getDisplayMetrics());
    }

    private void d() {
        ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.c$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!(c.this.a instanceof RelativeLayout)) {
                    if (c.this.a instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.this.c, c.this.c);
                        layoutParams.gravity = 17;
                        c.this.a.addView(c.this.b, layoutParams);
                        return;
                    }
                    return;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(c.this.c, c.this.c);
                layoutParams2.addRule(13);
                c.this.a.addView(c.this.b, layoutParams2);
            } catch (Throwable unused) {
            }
        }
    }

    public final void c() {
        if (this.b != null) {
            this.a.post(new Runnable() { // from class: com.anythink.basead.ui.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c.this.b.clearAnimation();
                        c.this.b.setAlpha(0.0f);
                        c.this.a.removeView(c.this.b);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public final void b() {
        ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new AnonymousClass1());
        this.b.post(new Runnable() { // from class: com.anythink.basead.ui.c.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.this.b.setAlpha(1.0f);
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setDuration(1000L);
                    rotateAnimation.setInterpolator(new LinearInterpolator());
                    rotateAnimation.setRepeatCount(-1);
                    c.this.b.startAnimation(rotateAnimation);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
