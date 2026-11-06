package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.anythink.basead.b.c.d;
import com.anythink.basead.j.e;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.i;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class MraidContainerView extends FrameLayout {
    public static final int ENDCARD_INIT = 1;
    public static final int LOAD_RETRY_CLICK = 3;
    public static final int PRE_LOAD = 5;
    public static final int VISIABLE_CLICK = 4;
    public static final int WINDOW_ATTACH_CHECK = 2;
    private static final String o = "MraidContainerView";
    protected w a;
    protected y b;
    protected x c;
    protected e d;
    protected c e;
    protected ClickToReLoadView f;
    protected MraidWebView g;
    protected a h;
    boolean i;
    boolean j;
    boolean k;
    long l;
    final long m;
    boolean n;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private f.b t;

    public interface a {
        void a();

        void a(String str);

        void b();

        void c();
    }

    static /* synthetic */ boolean b(MraidContainerView mraidContainerView) {
        mraidContainerView.r = false;
        return false;
    }

    public MraidContainerView(Context context) {
        super(context);
        this.m = 5000L;
    }

    public MraidContainerView(Context context, w wVar, x xVar, e eVar, a aVar) {
        super(context);
        this.m = 5000L;
        this.a = wVar;
        this.b = xVar.o;
        this.c = xVar;
        this.d = eVar;
        this.h = aVar;
        setBackgroundDrawable(new com.anythink.basead.ui.b.a());
        this.k = false;
        y yVar = this.b;
        if (yVar != null) {
            this.k = yVar.bH() == 1;
        }
    }

    public void init() {
        if (d.a(this.c, this.a)) {
            b();
            return;
        }
        c cVar = new c(this);
        this.e = cVar;
        cVar.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.l = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0036  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    public synchronized boolean a(String str) {
        boolean z;
        ?? r7;
        z = false;
        if (System.currentTimeMillis() - this.l > 5000) {
            boolean zBm = this.a.r().bm();
            boolean z2 = !zBm;
            if (z2) {
                if (this.t == null) {
                    this.t = new f.b(1);
                }
                if (am.a(this, this.t, 20)) {
                    r7 = zBm;
                    z = z2;
                } else {
                    r7 = 2;
                }
            } else {
                r7 = zBm;
                z = z2;
            }
        } else {
            r7 = 0;
            z = true;
        }
        if (!z) {
            String strAC = "";
            String strW = "";
            String strV = "";
            w wVar = this.a;
            if (wVar != null && (wVar instanceof r)) {
                strAC = ((r) wVar).aC();
                strW = ((r) this.a).w();
                strV = ((r) this.a).v();
            }
            com.anythink.core.common.u.e.a(this.c, strV, strW, strAC, str, (int) r7);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        MraidWebView mraidWebViewB = d.b(d.b(this.c, this.a));
        this.g = mraidWebViewB;
        if (mraidWebViewB != null) {
            f();
            this.s = true;
            if (this.q) {
                this.g.setNeedRegisterVolumeChangeReceiver(true);
            }
            this.g.prepare(getContext(), new com.anythink.basead.mraid.e() { // from class: com.anythink.basead.ui.MraidContainerView.1
                @Override // com.anythink.core.express.b.b
                public final void close() {
                }

                @Override // com.anythink.core.express.b.b
                public final void open(String str) {
                    if (MraidContainerView.this.h == null || !MraidContainerView.this.a(str)) {
                        return;
                    }
                    MraidContainerView.this.h.a(str);
                    MraidContainerView.this.l = 0L;
                }

                @Override // com.anythink.basead.mraid.e
                public final void a() {
                    if (MraidContainerView.this.h != null) {
                        MraidContainerView.this.h.b();
                    }
                }
            });
            c();
            d();
            this.i = true;
            i();
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.g.getParent() == null) {
            this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.g);
        }
    }

    private void d() {
        if (this.a.i() <= 0 || this.a.j() <= 0) {
            return;
        }
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.anythink.basead.ui.MraidContainerView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                try {
                    if (!MraidContainerView.this.n) {
                        MraidContainerView.this.n = true;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) MraidContainerView.this.g.getLayoutParams();
                        layoutParams.width = q.a(t.b().g(), MraidContainerView.this.a.i());
                        layoutParams.height = q.a(t.b().g(), MraidContainerView.this.a.j());
                        int width = (MraidContainerView.this.getWidth() - MraidContainerView.this.getPaddingLeft()) - MraidContainerView.this.getPaddingRight();
                        int height = (MraidContainerView.this.getHeight() - MraidContainerView.this.getPaddingBottom()) - MraidContainerView.this.getPaddingTop();
                        float fI = MraidContainerView.this.a.i() / (MraidContainerView.this.a.j() * 1.0f);
                        layoutParams.width = Math.min(width, layoutParams.width);
                        layoutParams.height = Math.min(height, layoutParams.height);
                        float f = layoutParams.width / (layoutParams.height * 1.0f);
                        if (f > fI) {
                            layoutParams.width = (int) (layoutParams.height * fI);
                        } else if (f < fI) {
                            layoutParams.height = (int) (layoutParams.width / fI);
                        }
                        layoutParams.gravity = 17;
                        MraidContainerView.this.g.setLayoutParams(layoutParams);
                    }
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void loadMraidWebView(final int i) {
        f();
        if (this.r || this.s) {
            return;
        }
        if (!this.k || this.p) {
            this.r = true;
            c cVar = this.e;
            if (cVar != null) {
                cVar.b();
            }
            final String strA = i.a(this.c, this.a);
            if (TextUtils.isEmpty(strA)) {
                this.r = false;
                h();
            } else {
                final String strB = d.b(this.c, this.a);
                t.b().b(new Runnable() { // from class: com.anythink.basead.ui.MraidContainerView.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MraidContainerView.this.g = new MraidWebView(t.b().g());
                            if (MraidContainerView.this.k) {
                                MraidContainerView.this.c();
                            }
                            i.a(strB, strA, MraidContainerView.this.g, new i.a() { // from class: com.anythink.basead.ui.MraidContainerView.3.1
                                @Override // com.anythink.basead.mraid.i.a
                                public final void a() {
                                    String unused = MraidContainerView.o;
                                    MraidContainerView.b(MraidContainerView.this);
                                    MraidContainerView.this.b();
                                    MraidContainerView.this.h();
                                }

                                @Override // com.anythink.basead.mraid.i.a
                                public final void a(com.anythink.basead.d.f fVar) {
                                    MraidContainerView.b(MraidContainerView.this);
                                    String unused = MraidContainerView.o;
                                    fVar.c();
                                    MraidContainerView.e(MraidContainerView.this);
                                    MraidContainerView.this.h();
                                }
                            }, MraidContainerView.this.a, MraidContainerView.this.c, i, MraidContainerView.this.k);
                        } catch (Throwable th) {
                            MraidContainerView.b(MraidContainerView.this);
                            String unused = MraidContainerView.o;
                            th.getMessage();
                            MraidContainerView.this.h();
                            if (MraidContainerView.this.h != null) {
                                a aVar = MraidContainerView.this.h;
                                th.getMessage();
                                aVar.c();
                            }
                        }
                    }
                });
            }
        }
    }

    public void fireMraidIsViewable(boolean z) {
        MraidWebView mraidWebView;
        try {
            if (!this.s || (mraidWebView = this.g) == null) {
                return;
            }
            if (z) {
                com.anythink.basead.mraid.c.a(mraidWebView, true);
            } else {
                com.anythink.basead.mraid.c.a(mraidWebView, false);
            }
        } catch (Throwable unused) {
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.q = z;
    }

    public void fireAudioVolumeChange(boolean z) {
        try {
            if (!this.s || this.g == null) {
                return;
            }
            if (z) {
                com.anythink.core.express.b.a.a();
                com.anythink.core.express.b.a.a(this.g, 0.0d);
            } else {
                com.anythink.core.express.b.a.a();
                com.anythink.core.express.b.a.a(this.g, 1.0d);
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        if (this.f == null) {
            ClickToReLoadView clickToReLoadView = new ClickToReLoadView(getContext());
            this.f = clickToReLoadView;
            clickToReLoadView.setListener(new AnonymousClass4());
        }
        addView(this.f, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidContainerView$4, reason: invalid class name */
    final class AnonymousClass4 implements ClickToReLoadView.a {
        AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.ClickToReLoadView.a
        public final void a() {
            MraidContainerView.this.loadMraidWebView(3);
        }
    }

    private void f() {
        ClickToReLoadView clickToReLoadView = this.f;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
    }

    private void g() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = true;
        i();
        a(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p = false;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.p) {
            a(4);
        }
    }

    private void a(int i) {
        if (d.a(this.c, this.a)) {
            return;
        }
        loadMraidWebView(i);
    }

    public void release() {
        MraidWebView mraidWebView;
        try {
            if (this.s && (mraidWebView = this.g) != null) {
                am.a(mraidWebView);
                this.g.release();
                com.anythink.core.common.res.d.a(t.b().g()).a(this.c, this.a);
            }
            am.a(this);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        if (!this.j && this.p && this.i) {
            this.j = true;
            e eVar = this.d;
            if (eVar == null || !eVar.a()) {
                return;
            }
            this.d.a(201, this.g);
        }
    }

    static /* synthetic */ void e(MraidContainerView mraidContainerView) {
        if (mraidContainerView.f == null) {
            ClickToReLoadView clickToReLoadView = new ClickToReLoadView(mraidContainerView.getContext());
            mraidContainerView.f = clickToReLoadView;
            clickToReLoadView.setListener(mraidContainerView.new AnonymousClass4());
        }
        mraidContainerView.addView(mraidContainerView.f, new FrameLayout.LayoutParams(-1, -1));
    }
}
