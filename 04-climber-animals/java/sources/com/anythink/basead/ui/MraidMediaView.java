package com.anythink.basead.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.j.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class MraidMediaView extends BaseMediaATView {
    boolean j;
    boolean k;
    boolean l;
    e m;
    private MraidContainerView n;
    private a o;

    public interface a {
        void a();

        void a(String str);
    }

    public MraidMediaView(Context context) {
        this(context, null, null, false, null, null);
    }

    public MraidMediaView(Context context, w wVar, x xVar, boolean z, BaseMediaATView.a aVar, e eVar) {
        super(context, wVar, xVar, z, aVar);
        this.m = eVar;
    }

    protected final synchronized void a() {
        if (this.j && this.k && !this.l) {
            this.l = true;
            com.anythink.core.common.u.e.a(this.c, this.a);
        }
    }

    public void fireAudioVolumeChange(boolean z) {
        MraidContainerView mraidContainerView = this.n;
        if (mraidContainerView != null) {
            mraidContainerView.fireAudioVolumeChange(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void init(int i, int i2, int i3) {
        super.init(i, i2, i3);
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.a, this.c, this.m, new AnonymousClass1());
        this.n = mraidContainerView;
        mraidContainerView.init();
        if (this.f == null || this.n == null) {
            return;
        }
        this.f.removeAllViews();
        this.f.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_include_4_element_with_feedback", "layout"), (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f.addView(viewInflate, layoutParams);
        this.i = new com.anythink.basead.ui.f.a(this.a, this.c);
        this.i.b(this);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidMediaView$1, reason: invalid class name */
    final class AnonymousClass1 implements MraidContainerView.a {
        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
        }

        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            if (MraidMediaView.this.o != null) {
                MraidMediaView.this.o.a(str);
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            MraidMediaView.this.j = true;
            MraidMediaView.this.a();
            if (MraidMediaView.this.o != null) {
                MraidMediaView.this.o.a();
            }
        }
    }

    private void b() {
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.a, this.c, this.m, new AnonymousClass1());
        this.n = mraidContainerView;
        mraidContainerView.init();
        if (this.f == null || this.n == null) {
            return;
        }
        this.f.removeAllViews();
        this.f.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_include_4_element_with_feedback", "layout"), (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f.addView(viewInflate, layoutParams);
        this.i = new com.anythink.basead.ui.f.a(this.a, this.c);
        this.i.b(this);
    }

    public void setMraidWebViewListener(a aVar) {
        this.o = aVar;
    }

    private static void a(String str) {
        Log.d("MraidMediaView", str);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.n;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = true;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k = false;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.n;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }
}
