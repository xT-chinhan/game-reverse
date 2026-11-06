package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* JADX INFO: loaded from: classes2.dex */
public class SSWebViewVideoPage extends SSWebView {
    private boolean ab;
    private float c;
    private boolean ka;
    private ViewParent x;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.ka = true;
        this.c = -1.0f;
        this.ab = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x == null) {
            this.x = ms((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.c = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.c;
            if (y > 0.0f) {
                ms(true);
            } else if (y != 0.0f && y < 0.0f) {
                ms(false);
            }
            this.c = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            c();
            this.ab = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ms(boolean z) {
        if (((ScrollView) this.x).getScrollY() == 0) {
            if (z) {
                c();
                return;
            } else {
                ab();
                return;
            }
        }
        if (!this.ka) {
            c();
        } else if (z) {
            ab();
        } else {
            c();
        }
    }

    public void c() {
        if (this.ab) {
            return;
        }
        this.x.requestDisallowInterceptTouchEvent(true);
        this.ab = true;
    }

    public void ab() {
        if (this.ab) {
            return;
        }
        this.x.requestDisallowInterceptTouchEvent(false);
        this.ab = true;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.ka = true;
        } else {
            this.ka = false;
        }
    }
}
