package com.byazt.pi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 118, 2264})
public class TTScrollView extends ScrollView {
    public pr hn;
    public boolean hw;
    public int pr;
    public boolean x;

    public interface pr {
        void pr(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.hw = false;
        this.x = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.hw) {
            try {
                this.hw = true;
                View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = getHeight();
                childAt.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                ho.hw("TTScrollView", "onLayout error" + th.toString());
            }
        }
    }

    public void setListener(pr prVar) {
        this.hn = prVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.pr) {
            if (getScrollY() > this.pr / 2) {
                post(new Runnable() { // from class: com.byazt.pi.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.pr);
                    }
                });
                z = false;
            } else if (getScrollY() > 0) {
                post(new Runnable() { // from class: com.byazt.pi.TTScrollView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView.this.smoothScrollTo(0, 0);
                    }
                });
            } else if (getScrollY() != 0) {
                z = false;
            }
            pr prVar = this.hn;
            if (prVar != null && z != this.x) {
                prVar.pr(z);
            }
            this.x = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pr = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.byazt.pi.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.pr);
            }
        });
    }

    public boolean pr() {
        return this.x;
    }
}
