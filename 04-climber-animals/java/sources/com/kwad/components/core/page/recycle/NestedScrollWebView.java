package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int UP;
    private int UQ;
    private final int[] UR;
    private final int[] US;
    private int UT;
    private boolean UU;
    private int UV;
    private int UW;
    private NestedScrollingChildHelper UX;
    private VelocityTracker UY;
    private int UZ;

    public NestedScrollWebView(Context context) {
        super(context);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    private void rF() {
        this.UZ = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.UX = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.UW = viewConfiguration.getScaledMaximumFlingVelocity();
        this.UV = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.UZ != 0) {
            int statusBarHeight = com.kwad.components.core.t.d.tc() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.g((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.UZ, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:46:0x012d  */
    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent;
        float f;
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.UT = 0;
        }
        if (this.UY == null) {
            this.UY = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.UT);
        if (actionMasked == 0) {
            this.UP = y;
            this.UQ = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.US;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.UR;
            iArr2[0] = 0;
            iArr2[1] = 0;
            zOnTouchEvent = super.onTouchEvent(motionEvent);
            this.UU = false;
        } else if (actionMasked == 1) {
            this.UY.addMovement(motionEvent);
            this.UY.computeCurrentVelocity(1000, this.UW);
            f = -VelocityTrackerCompat.getYVelocity(this.UY, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.UV && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean zOnTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.UP) < 10.0f) {
                Math.abs(motionEvent.getX() - this.UQ);
            }
            zOnTouchEvent = zOnTouchEvent2;
            z = true;
        } else if (actionMasked == 2) {
            int i = this.UP - y;
            if (dispatchNestedPreScroll(0, i, this.US, this.UR)) {
                i -= this.US[1];
                motionEventObtain.offsetLocation(0.0f, this.UR[1]);
                this.UT += this.UR[1];
            }
            int scrollY = getScrollY();
            this.UP = y - this.UR[1];
            int iMax = Math.max(0, scrollY + i);
            int i2 = i - (iMax - scrollY);
            if (dispatchNestedScroll(0, iMax - i2, 0, i2, this.UR)) {
                int i3 = this.UP;
                int i4 = this.UR[1];
                this.UP = i3 - i4;
                motionEventObtain.offsetLocation(0.0f, i4);
                this.UT += this.UR[1];
            }
            if (Math.abs(this.US[1]) < 5 && Math.abs(this.UR[1]) < 5) {
                if (this.UU) {
                    this.UU = false;
                    zOnTouchEvent = false;
                } else {
                    zOnTouchEvent = super.onTouchEvent(motionEventObtain);
                }
                motionEventObtain.recycle();
            } else {
                if (!this.UU) {
                    this.UU = true;
                    super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                }
                zOnTouchEvent = false;
            }
        } else if (actionMasked == 3) {
            this.UY.addMovement(motionEvent);
            this.UY.computeCurrentVelocity(1000, this.UW);
            f = -VelocityTrackerCompat.getYVelocity(this.UY, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.UV) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean zOnTouchEvent3 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.UP) < 10.0f) {
                Math.abs(motionEvent.getX() - this.UQ);
            }
            zOnTouchEvent = zOnTouchEvent3;
            z = true;
        } else if (actionMasked != 5) {
            zOnTouchEvent = false;
        } else {
            stopNestedScroll();
            zOnTouchEvent = super.onTouchEvent(motionEvent);
        }
        if (!z) {
            this.UY.addMovement(motionEvent);
        }
        return zOnTouchEvent;
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.UX.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.UX.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.UX.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.UX.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.UX.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.UX.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.UX.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.UX.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.UX.dispatchNestedPreFling(f, f2);
    }
}
