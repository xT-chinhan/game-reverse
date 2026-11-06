package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.smartdigimkt.h0.a;
import com.smartdigimkt.h1.j;
import com.smartdigimkt.i2.m;
import com.smartdigimkt.n1.w3;
import com.smartdigimkt.y1.g0;
import com.smartdigimkt.y1.h0;

/* JADX INFO: loaded from: classes3.dex */
public class OwnNativeATView extends FrameLayout implements g0 {
    public m a;
    public w3 b;
    public h0 c;

    public OwnNativeATView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        m mVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            m mVar2 = this.a;
            if (mVar2 != null) {
                mVar2.a((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        } else if ((action == 1 || action == 3) && (mVar = this.a) != null) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int iMax = Math.max(0, (int) motionEvent.getX());
            int iMax2 = Math.max(0, (int) motionEvent.getY());
            mVar.c = rawX;
            mVar.d = rawY;
            mVar.g = iMax;
            mVar.h = iMax2;
            mVar.j = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public a getAdClickRecord(int i) {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.a(0, i);
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        synchronized (this) {
            try {
                try {
                    h0 h0Var = this.c;
                    if (h0Var != null && h0Var.a(motionEvent)) {
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused) {
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            w3 w3Var = this.b;
            if (w3Var != null) {
                ((j) w3Var).a.a(110);
                return;
            }
            return;
        }
        w3 w3Var2 = this.b;
        if (w3Var2 != null) {
            ((j) w3Var2).a.a(111);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            if (z) {
                w3 w3Var = this.b;
                if (w3Var != null) {
                    ((j) w3Var).a.a(110);
                    return;
                }
                return;
            }
            w3 w3Var2 = this.b;
            if (w3Var2 != null) {
                ((j) w3Var2).a.a(111);
            }
        }
    }

    public void releaseAllCallback() {
        this.c = null;
        this.a = null;
        this.b = null;
    }

    @Override // com.smartdigimkt.y1.g0
    public void setCallback(h0 h0Var) {
        synchronized (this) {
            this.c = h0Var;
        }
    }

    public void setClickRecordHelper(m mVar) {
        this.a = mVar;
    }

    public void setLifeCallback(w3 w3Var) {
        this.b = w3Var;
    }

    public OwnNativeATView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OwnNativeATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
