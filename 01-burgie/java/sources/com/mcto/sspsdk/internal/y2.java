package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.QyBannerStyle;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.component.interaction.QySharkView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class y2 extends ConstraintLayout implements View.OnClickListener, w3 {
    public String A;
    public String B;
    public String C;
    public String D;
    public e E;
    public boolean F;
    public int G;
    public TextView a;
    public jc b;
    public TextView c;
    public DownloadButtonView d;
    public ImageView e;
    public View f;
    public TextView g;
    public View h;
    public View i;
    public TextView j;
    public boolean k;
    public QyBannerStyle l;
    public boolean m;
    public View n;
    public WeakReference o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public p v;
    public String w;
    public String x;
    public String y;
    public String z;

    public y2(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = true;
        this.m = false;
        this.n = null;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = -999.0f;
        this.s = -999.0f;
        this.t = -999.0f;
        this.u = -999.0f;
        this.F = false;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        qa qaVar;
        int iIntValue = ((Integer) obj).intValue();
        WeakReference weakReference = this.o;
        if (weakReference == null || (qaVar = (qa) weakReference.get()) == null) {
            return;
        }
        qaVar.a(iIntValue);
    }

    public void b() {
        QYNiceImageView qYNiceImageView = new QYNiceImageView(getContext());
        this.n = qYNiceImageView;
        qYNiceImageView.setId(R.id.qy_banner_core);
        ((QYNiceImageView) this.n).a(this);
        ((QYNiceImageView) this.n).a(this.w);
        ((QYNiceImageView) this.n).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public String c() {
        return this.l.getImageRadio();
    }

    public void d() {
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.r = motionEvent.getX();
            this.s = motionEvent.getY();
            this.t = motionEvent.getX();
            this.u = motionEvent.getY();
            this.p = motionEvent.getRawX();
            this.q = motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        z3 z3VarA;
        if (view == this.e) {
            pd pdVar = new pd(getContext());
            pdVar.c = new v2(this);
            pdVar.a(this.e);
            return;
        }
        if (view == this.d) {
            z3VarA = this.g == null ? z3.BUTTON : z3.DIRECT_ACTION_BTN;
        } else {
            z3VarA = a(view);
        }
        a4 a4Var = new a4();
        a4Var.b = z3VarA;
        a4Var.a = view;
        a4Var.e = gj.a(view);
        a4 a4VarA = a4Var.a(this.p, this.q);
        float f = this.r;
        float f2 = this.s;
        float f3 = this.t;
        float f4 = this.u;
        a4VarA.h = f;
        a4VarA.i = f2;
        a4VarA.j = f3;
        a4VarA.k = f4;
        b4 b4Var = new b4(a4VarA);
        DownloadButtonView downloadButtonView = this.d;
        if (downloadButtonView != null) {
            b4Var.a(downloadButtonView.c());
            b4Var.k = this.d.a();
        }
        a(b4Var);
    }

    public static void a(y2 y2Var) {
        if (y2Var.h == null) {
            return;
        }
        int width = y2Var.i.getWidth();
        int height = y2Var.i.getHeight();
        int width2 = y2Var.h.getWidth();
        int height2 = y2Var.h.getHeight();
        int[] iArr = {y2Var.i.getLeft(), y2Var.i.getTop()};
        int left = y2Var.h.getLeft();
        int top = y2Var.h.getTop();
        int[] iArr2 = {left, top};
        float f = width;
        float f2 = height;
        float f3 = width2;
        float f4 = height2;
        y2Var.i.animate().translationXBy(((f3 / 2.0f) + left) - ((f / 2.0f) + iArr[0])).translationYBy(((f4 / 2.0f) + top) - ((f2 / 2.0f) + iArr[1])).scaleX(f3 / f).scaleY(f4 / f2).setDuration(1000L).start();
        TextView textView = y2Var.j;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public final void a() {
        if (this.v.p()) {
            TextView textViewA = j1.a(getContext(), this.v.H0);
            this.g = textViewA;
            textViewA.setGravity(17);
            this.g.setTextColor(-1);
            this.g.setBackgroundResource(R.color.qy_text_color_black_40alpha);
            this.g.setTextSize(1, 8.0f);
        }
    }

    public z3 a(View view) {
        return z3.GRAPHIC;
    }

    public final void a(b4 b4Var) {
        qa qaVar;
        this.F = true;
        try {
            View view = this.i;
            if (view instanceof QySharkView) {
                ((QySharkView) view).b();
                this.i.setVisibility(8);
            }
        } catch (Exception e) {
        }
        WeakReference weakReference = this.o;
        if (weakReference == null || (qaVar = (qa) weakReference.get()) == null) {
            return;
        }
        qaVar.a(b4Var);
    }
}
