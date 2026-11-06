package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class GestureG2CV2View extends BaseG2CV2View {
    ImageView d;
    ImageView e;
    TextView f;
    Animation g;
    int h;
    RelativeLayout i;
    c j;
    private boolean k;
    private float l;
    private float m;
    private int n;

    static /* synthetic */ float b(GestureG2CV2View gestureG2CV2View, float f) {
        float f2 = gestureG2CV2View.m + f;
        gestureG2CV2View.m = f2;
        return f2;
    }

    public GestureG2CV2View(Context context) {
        super(context);
        this.k = false;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_gesture", "layout"), this);
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.d = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_slide_finger", "id"));
        this.e = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_white_line", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_slide_hint", "id"));
        this.i = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.h = q.a(getContext(), 36.0f);
        if (i == 1 || i == 3) {
            this.i.setBackgroundResource(q.a(getContext(), "myoffer_g2c_gesture_bg", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(q.a(getContext(), 270.0f), q.a(getContext(), 100.0f));
            layoutParams.addRule(13);
            this.i.setLayoutParams(layoutParams);
            this.e.setVisibility(0);
        } else if (i == 2) {
            this.i.setBackgroundColor(Color.parseColor("#80000000"));
            this.e.setVisibility(0);
            if (this.k) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
                layoutParams2.width = q.a(getContext(), 240.0f);
                this.e.setLayoutParams(layoutParams2);
            }
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.d.getLayoutParams();
            layoutParams3.height = q.a(getContext(), 24.0f);
            layoutParams3.width = q.a(getContext(), 24.0f);
            this.h = q.a(getContext(), 24.0f);
            this.d.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams4.width = q.a(getContext(), 150.0f);
            layoutParams4.height = q.a(getContext(), 4.0f);
            layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, q.a(getContext(), 8.0f));
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams5.setMargins(q.a(getContext(), 8.0f), layoutParams5.topMargin, layoutParams5.rightMargin, layoutParams5.bottomMargin);
            this.f.setTextSize(1, 10.0f);
            setBackgroundColor(Color.parseColor("#80000000"));
            post(new Runnable() { // from class: com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (GestureG2CV2View.this.getMeasuredWidth() < q.a(GestureG2CV2View.this.getContext(), 182.0f)) {
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) GestureG2CV2View.this.e.getLayoutParams();
                        layoutParams6.width = -1;
                        GestureG2CV2View.this.e.setLayoutParams(layoutParams6);
                    }
                    GestureG2CV2View.this.e.setVisibility(0);
                }
            });
        }
        if (this.g == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -this.h, 0.0f, 0.0f);
            this.g = translateAnimation;
            translateAnimation.setDuration(1000L);
            this.g.setRepeatCount(-1);
            this.g.setRepeatMode(2);
            this.d.startAnimation(this.g);
        }
    }

    private void d() {
        if (this.g == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -this.h, 0.0f, 0.0f);
            this.g = translateAnimation;
            translateAnimation.setDuration(1000L);
            this.g.setRepeatCount(-1);
            this.g.setRepeatMode(2);
            this.d.startAnimation(this.g);
        }
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
        this.j = cVar;
        if (cVar != null) {
            cVar.setCallback(new d() { // from class: com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.2
                @Override // com.anythink.basead.ui.guidetoclickv2.d
                public final boolean a(MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        GestureG2CV2View.this.l = motionEvent.getX();
                        return true;
                    }
                    if (action == 1) {
                        if (GestureG2CV2View.this.m <= GestureG2CV2View.this.n) {
                            return false;
                        }
                        if (GestureG2CV2View.this.c != null) {
                            GestureG2CV2View.this.c.a(11, 15);
                        }
                        return true;
                    }
                    if (action != 2) {
                        return false;
                    }
                    GestureG2CV2View.b(GestureG2CV2View.this, Math.abs(motionEvent.getX() - GestureG2CV2View.this.l));
                    GestureG2CV2View.this.l = motionEvent.getX();
                    return false;
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.j;
        if (cVar != null) {
            cVar.setCallback(null);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        Animation animation = this.g;
        if (animation != null) {
            animation.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        Animation animation = this.g;
        if (animation != null) {
            animation.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        Animation animation = this.g;
        if (animation != null) {
            animation.cancel();
        }
    }

    public void setVerticalLandscape(boolean z) {
        this.k = z;
    }

    private c e() {
        for (ViewParent parent = getParent(); parent.getParent() != null; parent = parent.getParent()) {
            if (parent instanceof c) {
                return (c) parent;
            }
        }
        return null;
    }
}
