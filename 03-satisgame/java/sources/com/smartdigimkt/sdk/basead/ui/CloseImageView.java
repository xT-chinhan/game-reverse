package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.p2;
import com.smartdigimkt.o3.c;

/* JADX INFO: loaded from: classes3.dex */
public class CloseImageView extends ImageView implements j3 {
    public float a;
    public Rect b;
    public float c;

    public CloseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.0f;
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        float f = this.a;
        if (f <= 1.0f || (view = (View) getParent()) == null) {
            return;
        }
        view.post(new c(this, f, view));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        Rect rect;
        if (this.a >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || (rect = this.b) == null || rect.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.smartdigimkt.n1.j3
    public void setClickAreaScaleFactor(float f) {
        View view;
        this.a = f;
        if (f <= 0.0f) {
            this.a = 1.0f;
        }
        float f2 = this.a;
        if (f2 < 1.0f) {
            post(new p2(this));
        } else {
            if (f2 <= 1.0f || (view = (View) getParent()) == null) {
                return;
            }
            view.post(new c(this, f2, view));
        }
    }

    @Override // com.smartdigimkt.n1.j3
    public void setClickViewAlpha(double d) {
        if (this.c < 1.0f && d >= 0.0d && d <= 1.0d) {
            float f = (float) d;
            try {
                this.c = f;
                setAlpha(f);
            } catch (Throwable unused) {
            }
        }
    }
}
