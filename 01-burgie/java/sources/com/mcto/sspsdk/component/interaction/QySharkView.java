package com.mcto.sspsdk.component.interaction;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.n7;
import com.mcto.sspsdk.internal.qh;
import com.mcto.sspsdk.internal.td;
import com.mcto.sspsdk.internal.v3;

/* JADX INFO: loaded from: classes2.dex */
public class QySharkView extends AppCompatImageView implements n7 {
    private final qh a;
    private boolean b;
    private boolean c;
    private td d;
    private v3 e;
    private final Handler f;
    private boolean g;
    private final a h;
    private final b i;

    public QySharkView(Context context) {
        this(context, null, 0);
    }

    static void d(QySharkView qySharkView) {
        qySharkView.f.removeCallbacks(qySharkView.h);
        qySharkView.a.b(qySharkView.d);
    }

    public final void c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(getResources().getColor(R.color.qy_text_color_black_60alpha));
        setBackground(gradientDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == null) {
            this.e = new v3(this, 0.01f, 200L);
        }
        this.e.a(this.i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.removeCallbacks(this.h);
        this.a.b(this.d);
        v3 v3Var = this.e;
        if (v3Var != null) {
            v3Var.a();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && getWindowVisibility() == 0) {
            if (this.e == null) {
                this.e = new v3(this, 0.01f, 200L);
            }
            this.e.a(this.i);
        } else {
            this.f.removeCallbacks(this.h);
            this.a.b(this.d);
            v3 v3Var = this.e;
            if (v3Var != null) {
                v3Var.a();
            }
        }
    }

    public QySharkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QySharkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.c = false;
        this.f = new Handler(Looper.getMainLooper());
        this.g = true;
        this.h = new a(this);
        this.i = new b(this);
        this.a = qh.a();
    }

    public final void a(td tdVar) {
        this.d = tdVar;
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void b() {
        this.b = false;
        this.f.removeCallbacks(this.h);
        this.a.b(this.d);
    }

    public final void a(int i, float f, int i2) {
        qh qhVar = this.a;
        qhVar.g = i;
        qhVar.i = Math.max(i2, 1);
        qhVar.h = f;
    }

    static void c(QySharkView qySharkView) {
        if (qySharkView.b) {
            qySharkView.f.postDelayed(qySharkView.h, 0L);
            qySharkView.a.a(qySharkView.d);
        }
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void a() {
        this.b = true;
        if (this.c) {
            this.f.postDelayed(this.h, 0L);
            this.a.a(this.d);
        }
    }
}
