package com.smartdigimkt.china.formatbusiness.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.smartdigimkt.e.b;
import com.smartdigimkt.e.c;
import com.smartdigimkt.e.d;
import com.smartdigimkt.e.e;
import com.smartdigimkt.e.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BubbleDropChildView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class BubbleVibrationFallLayer extends FrameLayout implements Handler.Callback {
    public static final String[] m = {"myoffer_splash_skip_area", "myoffer_feedback_ll_id", "myoffer_btn_mute_id", "myoffer_splash_ad_cta_layout", "myoffer_panel_cta_layout", "myoffer_splash_enter_immediately_area"};
    public BubbleDropChildView a;
    public ObjectAnimator b;
    public final Handler c;
    public int d;
    public Bitmap e;
    public boolean f;
    public Runnable g;
    public Runnable h;
    public WeakReference i;
    public int j;
    public boolean k;
    public boolean l;

    public BubbleVibrationFallLayer(Context context) {
        super(context);
        this.c = new Handler(Looper.getMainLooper(), this);
        a();
    }

    public final void a() {
        setClipChildren(false);
        BubbleDropChildView bubbleDropChildView = new BubbleDropChildView(getContext());
        this.a = bubbleDropChildView;
        bubbleDropChildView.initSetting(new b(this));
        addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        this.a.setVisibility(4);
    }

    public final void b() {
        Bitmap bitmap;
        if (this.f || this.a == null || (bitmap = this.e) == null || bitmap.isRecycled()) {
            this.k = false;
            return;
        }
        if (this.a.getMeasuredWidth() <= 0 || this.a.getMeasuredHeight() <= 0) {
            int i = this.j;
            if (i >= 48) {
                this.k = false;
                return;
            } else {
                this.j = i + 1;
                post(new e(this));
                return;
            }
        }
        this.j = 0;
        int height = this.d;
        if (height <= 0) {
            height = getMeasuredHeight();
        }
        if (height <= 0 && (getParent() instanceof View)) {
            height = ((View) getParent()).getHeight();
        }
        if (height <= 0) {
            height = getResources().getDisplayMetrics().heightPixels;
        }
        if (height <= 0) {
            this.k = false;
            return;
        }
        float f = -height;
        this.a.setTranslationY(f);
        this.a.setVisibility(0);
        this.a.initRedPacketList(this.e);
        this.k = false;
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "translationY", f, height);
            this.b = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setRepeatCount(0);
            this.b.setDuration(4000L);
            this.b.setInterpolator(new LinearInterpolator());
            this.b.addListener(new f(this));
        } else {
            objectAnimator.setFloatValues(f, height);
        }
        ObjectAnimator objectAnimator2 = this.b;
        if (objectAnimator2 == null || objectAnimator2.isStarted()) {
            return;
        }
        this.b.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        WeakReference weakReference;
        View view;
        View viewFindViewById;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            BubbleDropChildView bubbleDropChildView = this.a;
            this.l = (bubbleDropChildView == null || bubbleDropChildView.getVisibility() != 0) ? false : this.a.isTouchOnAnyBubble((motionEvent.getX() - this.a.getLeft()) - this.a.getTranslationX(), (motionEvent.getY() - this.a.getTop()) - this.a.getTranslationY());
        }
        if (!this.l && (weakReference = this.i) != null && (view = (View) weakReference.get()) != null) {
            Context context = view.getContext();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            String[] strArr = m;
            for (int i = 0; i < 6; i++) {
                int iA = k.a(context, strArr[i], "id");
                if (iA != 0 && (viewFindViewById = view.findViewById(iA)) != null && viewFindViewById.getVisibility() == 0) {
                    int[] iArr = new int[2];
                    viewFindViewById.getLocationOnScreen(iArr);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    int width = viewFindViewById.getWidth() + i2;
                    int height = viewFindViewById.getHeight() + i3;
                    if (rawX >= i2 && rawX < width && rawY >= i3 && rawY < height) {
                        return false;
                    }
                }
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 101 || this.f) {
            return false;
        }
        b();
        return false;
    }

    public boolean hasEffectiveBubbleDisplay() {
        BubbleDropChildView bubbleDropChildView;
        return (this.f || (bubbleDropChildView = this.a) == null || bubbleDropChildView.getVisibility() != 0) ? false : true;
    }

    public boolean isBubbleStartStillPending() {
        return !this.f && this.k;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = getMeasuredHeight();
    }

    public void release() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        this.i = null;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.b = null;
        }
        BubbleDropChildView bubbleDropChildView = this.a;
        if (bubbleDropChildView != null) {
            bubbleDropChildView.release();
        }
    }

    public void setClickActions(Runnable runnable, Runnable runnable2) {
        this.g = runnable;
        this.h = runnable2;
        setOnClickListener(runnable != null ? new c(this) : null);
        setClickable(runnable != null);
    }

    public void setSplashChromePassthroughHost(View view) {
        this.i = view != null ? new WeakReference(view) : null;
    }

    public void startWithBitmap(Bitmap bitmap) {
        if (this.f || bitmap.isRecycled()) {
            return;
        }
        this.e = bitmap;
        this.k = true;
        post(new d(this));
    }

    public BubbleVibrationFallLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Handler(Looper.getMainLooper(), this);
        a();
    }

    public BubbleVibrationFallLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Handler(Looper.getMainLooper(), this);
        a();
    }
}
