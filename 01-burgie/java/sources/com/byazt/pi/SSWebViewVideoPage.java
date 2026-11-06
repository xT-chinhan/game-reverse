package com.byazt.pi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.byazt.fj.SSWebView;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 1523})
public class SSWebViewVideoPage extends SSWebView {
    public boolean c;
    public boolean fw;
    public float uc;
    public ViewParent zo;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.c = true;
        this.uc = -1.0f;
        this.fw = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zo == null) {
            this.zo = pr((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.uc = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.uc;
            if (y > 0.0f) {
                hw(true);
            } else if (y != 0.0f && y < 0.0f) {
                hw(false);
            }
            this.uc = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            uc();
            this.fw = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void hw(boolean z) {
        if (((ScrollView) this.zo).getScrollY() == 0) {
            if (z) {
                uc();
                return;
            } else {
                fw();
                return;
            }
        }
        if (this.c) {
            if (z) {
                fw();
                return;
            } else {
                uc();
                return;
            }
        }
        uc();
    }

    public void uc() {
        if (this.fw) {
            return;
        }
        this.zo.requestDisallowInterceptTouchEvent(true);
        this.fw = true;
    }

    public void fw() {
        if (this.fw) {
            return;
        }
        this.zo.requestDisallowInterceptTouchEvent(false);
        this.fw = true;
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.c = true;
        } else {
            this.c = false;
        }
    }
}
