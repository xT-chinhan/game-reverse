package com.byazt.bs;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ca.aj;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 446, AVMDLDataLoader.KeyIsIsDownloadSource})
public class LazeLayout<T extends View> extends View {
    public AtomicBoolean c;
    public View.OnTouchListener fw;
    public pr hn;
    public volatile Context hw;
    public volatile com.byazt.bs.pr<T> pr;
    public View.OnClickListener uc;
    public AtomicBoolean x;
    public T zo;

    public interface pr<T extends View> {
        void pr(T t);
    }

    public LazeLayout(Context context, com.byazt.bs.pr prVar, pr prVar2) {
        super(context);
        this.x = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.pr = prVar;
        this.hw = context;
        this.hn = prVar2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.set(true);
        if (this.x.get()) {
            return;
        }
        this.x.set(true);
        T t = this.zo;
        if (t != null) {
            pr(t, getParent());
        } else {
            aj.hn().post(new Runnable() { // from class: com.byazt.bs.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.zo = lazeLayout.pr.hw(LazeLayout.this.hw);
                        if (LazeLayout.this.zo == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.pr(lazeLayout2.zo, LazeLayout.this.getParent());
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.c.get()) {
                aj.hn().postDelayed(new Runnable() { // from class: com.byazt.bs.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.pr(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.x.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            zo.pr(new Runnable() { // from class: com.byazt.bs.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.c.get()) {
                        LazeLayout.this.pr(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.x.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.hw = null;
        this.pr = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.uc;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.fw;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr(t);
        }
        this.zo = null;
    }

    public void pr() {
        this.zo = null;
        this.pr = null;
        this.hw = null;
        this.hn = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.uc = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fw = onTouchListener;
    }
}
