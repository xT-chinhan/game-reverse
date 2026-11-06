package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.anythink.basead.ui.a.a.d;
import com.anythink.basead.ui.a.a.e;
import com.anythink.basead.ui.a.a.f;

/* JADX INFO: loaded from: classes.dex */
public class ScanningAnimButton extends Button {
    private com.anythink.basead.ui.a.b a;
    private volatile boolean b;
    private int c;

    public ScanningAnimButton(Context context) {
        this(context, null);
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        setGravity(17);
    }

    private void a() {
        setGravity(17);
    }

    public void startAnimation(int i) {
        com.anythink.basead.ui.a.b fVar;
        this.c = i;
        if (this.b) {
            return;
        }
        this.b = true;
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.d();
        }
        if (i == 2) {
            fVar = new f(this);
        } else if (i == 3) {
            fVar = new d(this);
        } else if (i == 4) {
            fVar = new com.anythink.basead.ui.a.a.c(this);
        } else if (i == 5) {
            fVar = new com.anythink.basead.ui.a.a.b(this);
        } else {
            fVar = new e(this);
        }
        this.a = fVar;
        fVar.a();
    }

    private void b() {
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.b();
        }
    }

    private void c() {
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void stopAnimation() {
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.d();
        }
        this.b = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.c;
        if (i != 0) {
            startAnimation(i);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            com.anythink.basead.ui.a.b bVar = this.a;
            if (bVar != null) {
                bVar.c();
                return;
            }
            return;
        }
        com.anythink.basead.ui.a.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.a(getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.anythink.basead.ui.a.b bVar = this.a;
        if (bVar != null) {
            bVar.a(canvas);
        }
    }
}
