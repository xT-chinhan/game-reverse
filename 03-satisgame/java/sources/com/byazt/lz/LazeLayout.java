package com.byazt.lz;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.tk.rv;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 53, 54})
public class LazeLayout<T extends View> extends View {
    public T fs;
    public AtomicBoolean l;
    public volatile com.byazt.lz.n<T> n;
    public AtomicBoolean q;
    public volatile Context qg;
    public n s;
    public View.OnClickListener w;
    public View.OnTouchListener x;

    public interface n<T extends View> {
        void n(T t);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public LazeLayout(Context context, com.byazt.lz.n nVar, n nVar2) {
        super(context);
        this.q = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.n = nVar;
        this.qg = context;
        this.s = nVar2;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l.set(true);
        if (this.q.get()) {
            return;
        }
        this.q.set(true);
        T t = this.fs;
        if (t != null) {
            n(t, getParent());
        } else {
            rv.s().post(new Runnable() { // from class: com.byazt.lz.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.fs = lazeLayout.n.qg(LazeLayout.this.qg);
                        if (LazeLayout.this.fs == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.n(lazeLayout2.fs, LazeLayout.this.getParent());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.l.get()) {
                rv.s().postDelayed(new Runnable() { // from class: com.byazt.lz.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.n(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.q.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.lz.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.l.get()) {
                        LazeLayout.this.n(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.q.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.qg = null;
        this.n = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.w;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.x;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        n nVar = this.s;
        if (nVar != null) {
            nVar.n(t);
        }
        this.fs = null;
    }

    public void n() {
        this.fs = null;
        this.n = null;
        this.qg = null;
        this.s = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.x = onTouchListener;
    }
}
