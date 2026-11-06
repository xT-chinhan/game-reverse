package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.smartdigimkt.o1.a;
import com.smartdigimkt.p1.b;

/* JADX INFO: loaded from: classes3.dex */
public class ScanningAnimButton extends Button {
    public b a;
    public volatile boolean b;
    public int c;

    public ScanningAnimButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.c;
        if (i != 0) {
            startAnimation(i);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.pause();
        }
    }

    public void startAnimation(int i) {
        this.c = i;
        if (this.b) {
            return;
        }
        this.b = true;
        b bVar = this.a;
        if (bVar != null) {
            bVar.stop();
        }
        b bVarA = a.a(this, i);
        this.a = bVarA;
        bVarA.start();
    }

    public void stopAnimation() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.stop();
        }
        this.b = false;
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        setGravity(17);
    }
}
