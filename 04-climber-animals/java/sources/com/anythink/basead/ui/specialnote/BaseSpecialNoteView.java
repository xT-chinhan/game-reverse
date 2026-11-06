package com.anythink.basead.ui.specialnote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.basead.b.k;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.a.c;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSpecialNoteView extends LinearLayout {
    public static final long SEPECIAL_NOTE_INTERVAL_TIME = 500;
    final String a;
    final long b;
    final int c;
    long d;
    long e;
    long f;
    long g;
    a h;
    Runnable i;
    c j;
    f.b k;
    TextView l;
    TextView m;
    String n;
    private View o;
    private int p;
    private boolean q;

    public interface a {
        void a(int i);
    }

    protected abstract void b();

    protected abstract boolean d();

    public BaseSpecialNoteView(Context context) {
        super(context);
        this.a = getClass().getSimpleName();
        this.b = 500L;
        this.c = 50;
        this.n = "";
        this.q = false;
    }

    public BaseSpecialNoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.b = 500L;
        this.c = 50;
        this.n = "";
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        resume();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pause();
    }

    public void initSetting(View view, int i, a aVar, long j, long j2) {
        this.p = i;
        a();
        b();
        setVisibility(4);
        this.j = k.a().b();
        this.k = k.a().c();
        this.o = view;
        this.h = aVar;
        this.d = j;
        this.f = j2;
        this.e = j;
        this.g = j2;
        this.i = new Runnable() { // from class: com.anythink.basead.ui.specialnote.BaseSpecialNoteView.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseSpecialNoteView.a(BaseSpecialNoteView.this);
            }
        };
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.specialnote.BaseSpecialNoteView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        TextView textView = this.m;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.specialnote.BaseSpecialNoteView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseSpecialNoteView.this.release();
                }
            });
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(Html.fromHtml(String.format(this.n, Integer.valueOf(((int) (this.g / 1000)) + 1))));
        }
    }

    protected void a() {
        this.n = getContext().getString(q.a(t.b().g(), "myoffer_special_note_delay_click", "string"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.h == null) {
            return;
        }
        postDelayed(this.i, 500L);
    }

    private void f() {
        View view = this.o;
        if (view == null) {
            return;
        }
        this.j.a(view, new AnonymousClass4());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.core.common.v.a.a {
        @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
        public final int getImpressionMinPercentageViewed() {
            return 50;
        }

        AnonymousClass4() {
        }

        @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
        public final void recordImpression(View view) {
            BaseSpecialNoteView.this.e();
        }
    }

    private void g() {
        if (getWindowVisibility() == 0) {
            if (j()) {
                long j = this.e;
                if (j > 0) {
                    this.e = j - 500;
                } else {
                    long j2 = this.g;
                    if (j2 > 0) {
                        this.g = j2 - 500;
                    }
                }
                h();
                e();
                return;
            }
        } else if (d()) {
            k();
        }
        View view = this.o;
        if (view != null) {
            this.j.a(view, new AnonymousClass4());
        }
    }

    private void h() {
        if (this.e > 0) {
            if (getVisibility() == 0) {
                setVisibility(4);
                return;
            }
            return;
        }
        long j = this.g;
        if (j > 0) {
            this.l.setText(Html.fromHtml(String.format(this.n, Integer.valueOf(((int) (j / 1000)) + 1))));
            if (getVisibility() != 0) {
                this.q = true;
                c();
                return;
            }
            return;
        }
        i();
    }

    private void i() {
        if (this.o == null) {
            return;
        }
        int i = this.p;
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(i);
        }
        release();
    }

    private boolean j() {
        View view = this.o;
        if (view != null && view.getParent() != null) {
            Object parent = this.o.getParent();
            if (parent instanceof View) {
                return this.k.a((View) parent, this.o, 50, 0);
            }
        }
        return false;
    }

    protected void c() {
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.specialnote.BaseSpecialNoteView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseSpecialNoteView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.specialnote.BaseSpecialNoteView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                BaseSpecialNoteView.this.setAlpha(((Float) valueAnimatorOfFloat.getAnimatedValue()).floatValue());
                BaseSpecialNoteView.this.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BaseSpecialNoteView.this.setAlpha(1.0f);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public void resume() {
        if (j()) {
            h();
        }
        e();
    }

    public void pause() {
        setVisibility(4);
        Runnable runnable = this.i;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        View view = this.o;
        if (view != null) {
            this.j.a(view);
        }
    }

    private void k() {
        this.e = this.d;
        this.g = this.f;
        setVisibility(4);
        this.q = false;
    }

    public void reset(int i, long j, long j2) {
        this.p = i;
        this.d = j;
        this.f = j2;
        k();
    }

    public void release() {
        if (this.h != null) {
            pause();
            this.h = null;
            this.o = null;
        }
    }

    public boolean hasBeenShow() {
        return this.q;
    }

    static /* synthetic */ void a(BaseSpecialNoteView baseSpecialNoteView) {
        if (baseSpecialNoteView.getWindowVisibility() == 0) {
            if (baseSpecialNoteView.j()) {
                long j = baseSpecialNoteView.e;
                if (j > 0) {
                    baseSpecialNoteView.e = j - 500;
                } else {
                    long j2 = baseSpecialNoteView.g;
                    if (j2 > 0) {
                        baseSpecialNoteView.g = j2 - 500;
                    }
                }
                baseSpecialNoteView.h();
                baseSpecialNoteView.e();
                return;
            }
        } else if (baseSpecialNoteView.d()) {
            baseSpecialNoteView.k();
        }
        View view = baseSpecialNoteView.o;
        if (view != null) {
            baseSpecialNoteView.j.a(view, baseSpecialNoteView.new AnonymousClass4());
        }
    }
}
