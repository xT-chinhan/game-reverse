package com.anythink.basead.ui;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.f.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBannerATView extends BaseATView {
    private e A;
    public final String TAG;
    protected com.anythink.basead.g.a a;
    protected CloseImageView b;
    View c;
    protected com.anythink.basead.ui.f.a d;

    @Override // com.anythink.basead.ui.BaseATView
    protected final int r() {
        return 4;
    }

    public BaseBannerATView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    public BaseBannerATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar);
        this.TAG = getClass().getSimpleName();
        this.a = aVar;
        if (xVar != null) {
            if (wVar == null || !wVar.c()) {
                if (xVar.o != null && xVar.o.aq()) {
                    e eVar = new e();
                    this.A = eVar;
                    eVar.a(true).a(new AnonymousClass1());
                } else {
                    e eVar2 = this.A;
                    if (eVar2 != null) {
                        eVar2.a(false);
                    }
                }
            }
        }
    }

    private void a(x xVar, w wVar) {
        if (xVar != null) {
            if (wVar == null || !wVar.c()) {
                if (xVar.o != null && xVar.o.aq()) {
                    e eVar = new e();
                    this.A = eVar;
                    eVar.a(true).a(new AnonymousClass1());
                } else {
                    e eVar2 = this.A;
                    if (eVar2 != null) {
                        eVar2.a(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseBannerATView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.basead.ui.d.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.d.a
        public final void a(int i, int i2) {
            BaseBannerATView.this.a(i, i2);
        }
    }

    protected void b() {
        a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.BaseBannerATView.2
            @Override // java.lang.Runnable
            public final void run() {
                BaseBannerATView.super.j();
            }
        });
    }

    protected void c() {
        this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.basead.ui.BaseBannerATView.3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 || BaseBannerATView.this.a == null) {
                    return true;
                }
                BaseBannerATView.this.a.onAdClosed();
                return true;
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void f() {
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow(new j());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(j jVar) {
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdClick(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, int i2) {
        super.a(i, i2);
        a((b) this.b, true);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(boolean z) {
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final RelativeLayout.LayoutParams q() {
        int measuredHeight = getMeasuredHeight() - q.a(getContext(), 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, measuredHeight, 0, 0);
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            a(110);
        } else {
            a(111);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            if (z) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (!d() && (eVar = this.A) != null) {
            return eVar.a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (!d() && (eVar = this.A) != null) {
            return eVar.a(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean d() {
        if (this.c == null) {
            this.c = findViewById(q.a(getContext(), "myoffer_guide2click_container", "id"));
        }
        View view = this.c;
        return view != null && view.getVisibility() == 0;
    }
}
