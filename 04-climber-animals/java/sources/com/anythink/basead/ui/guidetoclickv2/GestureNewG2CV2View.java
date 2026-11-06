package com.anythink.basead.ui.guidetoclickv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class GestureNewG2CV2View extends BaseG2CV2View {
    ImageView d;
    ImageView e;
    TextView f;
    AnimatorSet g;
    int h;
    int i;
    ViewGroup j;
    c k;
    private boolean l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private int v;

    static /* synthetic */ float b(GestureNewG2CV2View gestureNewG2CV2View, float f) {
        float f2 = gestureNewG2CV2View.n + f;
        gestureNewG2CV2View.n = f2;
        return f2;
    }

    public GestureNewG2CV2View(Context context) {
        super(context);
        this.l = false;
        this.p = 80;
        this.q = 110;
        this.r = -1;
        this.s = 10;
        this.t = 11;
        this.u = 12;
        this.v = -1;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_gesture_v2", "layout"), this);
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.d = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_slide_finger", "id"));
        this.e = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_white_line", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_slide_hint", "id"));
        this.j = (ViewGroup) findViewById(q.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.h = q.a(getContext(), 32.0f);
        this.i = q.a(getContext(), 10.0f);
    }

    private void d() {
        if (this.g == null) {
            ImageView imageView = this.d;
            int i = this.h;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", i, -i);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(2);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, (-this.i) / 2, 0.0f);
            objectAnimatorOfFloat2.setDuration(1000L);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat2.setRepeatMode(2);
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.g.start();
        }
    }

    private void e() {
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.g = null;
        }
        if (this.g == null) {
            ImageView imageView = this.d;
            int i = this.h;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", i, -i);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(2);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, (-this.i) / 2, 0.0f);
            objectAnimatorOfFloat2.setDuration(1000L);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat2.setRepeatMode(2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.g = animatorSet2;
            animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.g.start();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() < q.a(getContext(), a.C0062a.b)) {
            c();
            return;
        }
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight < q.a(getContext(), a.C0062a.b)) {
            c();
            return;
        }
        if (measuredHeight >= q.a(getContext(), a.C0062a.b) && measuredHeight < q.a(getContext(), 80.0f)) {
            if (this.v == 12) {
                return;
            }
            this.v = 12;
            this.h = q.a(getContext(), 18.0f);
            this.i = q.a(getContext(), 6.0f);
            ImageView imageView = this.e;
            if (imageView != null) {
                am.a(imageView, q.a(getContext(), 118.0f), q.a(getContext(), 21.0f));
            }
            ImageView imageView2 = this.d;
            if (imageView2 != null) {
                am.a(imageView2, q.a(getContext(), 18.0f), q.a(getContext(), 19.0f));
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(8);
            }
            e();
            return;
        }
        if (measuredHeight >= q.a(getContext(), 80.0f) && measuredHeight <= q.a(getContext(), 110.0f)) {
            if (this.v == 11) {
                return;
            }
            this.v = 11;
            this.h = q.a(getContext(), 22.0f);
            this.i = q.a(getContext(), 6.0f);
            ImageView imageView3 = this.e;
            if (imageView3 != null) {
                am.a(imageView3, q.a(getContext(), 142.0f), q.a(getContext(), 24.0f));
            }
            ImageView imageView4 = this.d;
            if (imageView4 != null) {
                am.a(imageView4, q.a(getContext(), 22.0f), q.a(getContext(), 24.0f));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setVisibility(0);
                if (this.f.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                    layoutParams.topMargin = q.a(getContext(), 2.0f);
                    this.f.setLayoutParams(layoutParams);
                }
            }
            e();
            return;
        }
        if (this.v == 10) {
            return;
        }
        this.v = 10;
        TextView textView3 = this.f;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        c cVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent.getParent() == null) {
                cVar = null;
                break;
            } else {
                if (parent instanceof c) {
                    cVar = (c) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.k = cVar;
        if (cVar != null) {
            cVar.setCallback(new d() { // from class: com.anythink.basead.ui.guidetoclickv2.GestureNewG2CV2View.1
                @Override // com.anythink.basead.ui.guidetoclickv2.d
                public final boolean a(MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        GestureNewG2CV2View.this.m = motionEvent.getX();
                        return true;
                    }
                    if (action == 1) {
                        if (GestureNewG2CV2View.this.n <= GestureNewG2CV2View.this.o) {
                            return false;
                        }
                        if (GestureNewG2CV2View.this.c != null) {
                            GestureNewG2CV2View.this.c.a(11, 46);
                        }
                        return true;
                    }
                    if (action != 2) {
                        return false;
                    }
                    GestureNewG2CV2View.b(GestureNewG2CV2View.this, Math.abs(motionEvent.getX() - GestureNewG2CV2View.this.m));
                    GestureNewG2CV2View.this.m = motionEvent.getX();
                    return false;
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.k;
        if (cVar != null) {
            cVar.setCallback(null);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private c f() {
        for (ViewParent parent = getParent(); parent.getParent() != null; parent = parent.getParent()) {
            if (parent instanceof c) {
                return (c) parent;
            }
        }
        return null;
    }
}
