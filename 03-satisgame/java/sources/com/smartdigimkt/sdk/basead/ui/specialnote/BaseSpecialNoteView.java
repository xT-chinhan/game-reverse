package com.smartdigimkt.sdk.basead.ui.specialnote;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartdigimkt.b2.h0;
import com.smartdigimkt.h2.a;
import com.smartdigimkt.h2.b;
import com.smartdigimkt.h2.c;
import com.smartdigimkt.h2.e;
import com.smartdigimkt.h2.f;
import com.smartdigimkt.h2.g;
import com.smartdigimkt.p3.i;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.k0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSpecialNoteView extends LinearLayout {
    public static final long SEPECIAL_NOTE_INTERVAL_TIME = 500;
    public static final /* synthetic */ int o = 0;
    public long a;
    public long b;
    public long c;
    public long d;
    public View e;
    public g f;
    public a g;
    public i h;
    public l i;
    public TextView j;
    public TextView k;
    public String l;
    public int m;
    public boolean n;

    public BaseSpecialNoteView(Context context) {
        super(context);
        this.l = "";
        this.n = false;
    }

    public void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new e(this));
        valueAnimatorOfFloat.addListener(new f(this, valueAnimatorOfFloat));
        valueAnimatorOfFloat.start();
    }

    public final void b() {
        com.smartdigimkt.b2.e eVar;
        if (this.b > 0) {
            if (getVisibility() == 0) {
                setVisibility(4);
                return;
            }
            return;
        }
        long j = this.d;
        if (j > 0) {
            this.j.setText(Html.fromHtml(String.format(this.l, Integer.valueOf(((int) (j / 1000)) + 1))));
            if (getVisibility() != 0) {
                this.n = true;
                a();
                return;
            }
            return;
        }
        if (this.e == null) {
            return;
        }
        int i = this.m;
        g gVar = this.f;
        if (gVar != null && (eVar = ((h0) gVar).a.d.h) != null) {
            eVar.a(i, 4);
        }
        release();
    }

    public void c() {
        this.l = getContext().getString(k.a(SDKContext.getInstance().d(), "myoffer_special_note_delay_click", "string"));
    }

    public abstract void d();

    public abstract boolean e();

    public boolean hasBeenShow() {
        return this.n;
    }

    public void initSetting(View view, int i, g gVar, long j, long j2) {
        this.m = i;
        c();
        d();
        setVisibility(4);
        this.h = k0.a().a;
        this.i = k0.a().b;
        this.e = view;
        this.f = gVar;
        this.a = j;
        this.c = j2;
        this.b = j;
        this.d = j2;
        this.g = new a(this);
        setOnClickListener(new b());
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(new c(this));
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setText(Html.fromHtml(String.format(this.l, Integer.valueOf(((int) (this.d / 1000)) + 1))));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        resume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pause();
    }

    public void pause() {
        setVisibility(4);
        a aVar = this.g;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        View view = this.e;
        if (view != null) {
            i iVar = this.h;
            iVar.b.remove(view);
            iVar.c.remove(view);
            iVar.a.e.remove(view);
        }
    }

    public void release() {
        if (this.f != null) {
            pause();
            this.f = null;
            this.e = null;
        }
    }

    public void reset(int i, long j, long j2) {
        this.m = i;
        this.a = j;
        this.c = j2;
        this.b = j;
        this.d = j2;
        setVisibility(4);
        this.n = false;
    }

    public void resume() {
        View view = this.e;
        if (view != null && view.getParent() != null) {
            Object parent = this.e.getParent();
            if ((parent instanceof View) && this.i.a((View) parent, this.e, 50, 0)) {
                b();
            }
        }
        if (this.f == null) {
            return;
        }
        postDelayed(this.g, 500L);
    }

    public BaseSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = "";
        this.n = false;
    }
}
