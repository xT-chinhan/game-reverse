package com.bytedance.sdk.openadsdk.res.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.op.ab;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class LazeLayout<T extends View> extends View {
    private View.OnTouchListener ab;
    private ms ah;
    private View.OnClickListener c;
    private AtomicBoolean d;
    private AtomicBoolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.res.layout.ms<T> f4086ms;
    private T x;
    private volatile Context xr;

    public interface ms<T extends View> {
        void ms(T t);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public LazeLayout(Context context, com.bytedance.sdk.openadsdk.res.layout.ms msVar, ms msVar2) {
        super(context);
        this.d = new AtomicBoolean(false);
        this.ka = new AtomicBoolean(false);
        this.f4086ms = msVar;
        this.xr = context;
        this.ah = msVar2;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ka.set(true);
        if (this.d.get()) {
            return;
        }
        this.d.set(true);
        T t = this.x;
        if (t != null) {
            ms(t, getParent());
        } else {
            x.ah().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.x = lazeLayout.f4086ms.xr(LazeLayout.this.xr);
                        if (LazeLayout.this.x == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.ms(lazeLayout2.x, LazeLayout.this.getParent());
                    } catch (Exception e) {
                        sl.xr("LazeLayout", "inflate error", e);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ka.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.ka.get()) {
                x.ah().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.ms(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.d.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.ka.get()) {
                        LazeLayout.this.ms(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.d.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.xr = null;
        this.f4086ms = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.c;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.ab;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms(t);
        }
        this.x = null;
    }

    public void ms() {
        this.x = null;
        this.f4086ms = null;
        this.xr = null;
        this.ah = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ab = onTouchListener;
    }
}
