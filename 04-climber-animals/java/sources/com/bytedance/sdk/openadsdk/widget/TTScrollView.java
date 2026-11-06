package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class TTScrollView extends ScrollView {
    private ms ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f4300ms;
    private boolean xr;

    public interface ms {
        void ms(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.xr = false;
        this.d = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.xr) {
            return;
        }
        try {
            this.xr = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            sl.d("TTScrollView", "onLayout error" + th.toString());
        }
    }

    public void setListener(ms msVar) {
        this.ah = msVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ms msVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.f4300ms) {
            if (getScrollY() > this.f4300ms / 2) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.f4300ms);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                } else if (getScrollY() != 0) {
                }
                msVar = this.ah;
                if (msVar != null && z != this.d) {
                    msVar.ms(z);
                }
                this.d = z;
            }
            z = false;
            msVar = this.ah;
            if (msVar != null) {
                msVar.ms(z);
            }
            this.d = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4300ms = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.f4300ms);
            }
        });
    }

    public boolean ms() {
        return this.d;
    }
}
