package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.anythink.core.common.u.al;

/* JADX INFO: loaded from: classes.dex */
public class CloseFrameLayout extends FrameLayout implements a {
    private static final String a = "CloseFrameLayout";
    private float b;
    private Rect c;
    private float d;

    public CloseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
    }

    @Override // com.anythink.core.common.inner.ui.a
    public void setClickAreaScaleFactor(float f) {
        this.b = f;
        if (f <= 0.0f) {
            this.b = 1.0f;
        }
        float f2 = this.b;
        if (f2 < 1.0f) {
            post(new Runnable() { // from class: com.anythink.core.common.inner.ui.CloseFrameLayout.1
                @Override // java.lang.Runnable
                public final void run() {
                    CloseFrameLayout.this.c = new Rect();
                    CloseFrameLayout closeFrameLayout = CloseFrameLayout.this;
                    closeFrameLayout.getHitRect(closeFrameLayout.c);
                    int iWidth = ((int) (CloseFrameLayout.this.c.width() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    int iHeight = ((int) (CloseFrameLayout.this.c.height() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    CloseFrameLayout.this.c.top -= iHeight;
                    CloseFrameLayout.this.c.bottom += iHeight;
                    CloseFrameLayout.this.c.left -= iWidth;
                    CloseFrameLayout.this.c.right += iWidth;
                }
            });
        } else if (f2 > 1.0f) {
            al.a(this, f2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = this.b;
        if (f > 1.0f) {
            al.a(this, f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        Rect rect;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || (rect = this.c) == null || rect.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.anythink.core.common.inner.ui.a
    public void setClickViewAlpha(double d) {
        if (this.d < 1.0f && d >= 0.0d && d <= 1.0d) {
            float f = (float) d;
            try {
                this.d = f;
                setAlpha(f);
            } catch (Throwable unused) {
            }
        }
    }
}
