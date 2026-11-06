package com.anythink.basead.ui.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.CountDownView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    Context a;
    w b;
    x c;
    com.anythink.basead.ui.improveclick.c.a d;
    int f;
    ViewGroup g;
    com.anythink.basead.ui.improveclick.d.a h;
    Handler i;
    protected Thread k;
    protected long l;
    protected long m;
    protected CountDownView n;
    private f.b p;
    private final String o = getClass().getSimpleName();
    protected boolean j = false;
    com.anythink.basead.ui.improveclick.c.a e = new com.anythink.basead.ui.improveclick.c.a() { // from class: com.anythink.basead.ui.c.a.1
        @Override // com.anythink.basead.ui.improveclick.c.a
        public final void a(int i, int i2) {
            if (a.this.n != null) {
                a.this.n.setClickViewAlpha(1.0d);
            }
            if (a.this.b() != null && (a.this.b() instanceof com.anythink.basead.ui.b)) {
                ((com.anythink.basead.ui.b) a.this.b()).setClickViewAlpha(1.0d);
            }
            if (a.this.d != null) {
                a.this.d.a(i, i2);
            }
        }
    };

    public void a() {
    }

    public void d() {
    }

    public a(Context context, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar, int i, ViewGroup viewGroup) {
        this.a = context.getApplicationContext();
        this.b = wVar;
        this.c = xVar;
        this.d = aVar;
        this.f = i;
        this.g = viewGroup;
        this.p = new f.b((wVar == null || wVar.r() == null) ? 1 : wVar.r().bL());
        this.i = new Handler(Looper.getMainLooper()) { // from class: com.anythink.basead.ui.c.a.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                a aVar2 = a.this;
                aVar2.a(aVar2.l);
            }
        };
    }

    public void a(ViewGroup viewGroup) {
        if (com.anythink.basead.b.e.e(this.b, this.c)) {
            return;
        }
        a(false);
    }

    protected final void a(boolean z) {
        String strValueOf;
        int iAU;
        String strValueOf2;
        int iA = com.anythink.basead.b.e.a(this.c, this.g.getContext());
        y yVar = this.c.o;
        int iAO = yVar.aO();
        if (iAO != 3) {
            if (iAO == 4) {
                strValueOf2 = String.valueOf(yVar.be());
            } else {
                strValueOf2 = iAO != 5 ? "" : String.valueOf(yVar.aW());
            }
            strValueOf = strValueOf2;
            iAU = 0;
        } else {
            strValueOf = String.valueOf(yVar.aV());
            iAU = yVar.aU();
        }
        com.anythink.core.common.u.e.a(this.b, this.c, iA, z, yVar.aO(), strValueOf, iAU, yVar.aO());
    }

    public final void a(com.anythink.basead.ui.improveclick.d.a aVar) {
        this.h = aVar;
    }

    protected final View b() {
        com.anythink.basead.ui.improveclick.d.a aVar = this.h;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private View g() {
        com.anythink.basead.ui.improveclick.d.a aVar = this.h;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    private void h() {
        if (b() != null) {
            am.a(b());
        }
    }

    private void c(long j) {
        if (this.k != null) {
            return;
        }
        this.l = 0L;
        this.m = j;
        this.j = true;
        Thread thread = new Thread(new AnonymousClass3());
        this.k = thread;
        thread.setName("anythink_type_endcard_improve_progress");
        this.k.start();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.c.a$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (a.this.j) {
                if (a.this.g != null && (a.this.f().getParent() instanceof View) && a.this.p.a((View) a.this.f().getParent(), a.this.f(), 50, 0)) {
                    if (a.this.i != null) {
                        try {
                            a.this.i.sendEmptyMessage(1);
                        } catch (Throwable unused) {
                        }
                        try {
                            Thread.sleep(200L);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        try {
                            Thread.sleep(10L);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (a.this.l >= a.this.m) {
                        a.this.c();
                    } else {
                        a.this.l += 200;
                    }
                } else {
                    try {
                        Thread.sleep(1000L);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    protected final void c() {
        this.j = false;
        this.k = null;
    }

    protected void a(long j) {
        CountDownView countDownView = this.n;
        if (countDownView != null) {
            countDownView.refresh(j);
            if (this.l >= this.m) {
                this.n.setVisibility(0);
            }
        }
    }

    public final void e() {
        c();
    }

    protected final void b(long j) {
        View viewB = b();
        if (j > 0) {
            j = Math.min(j, 30L);
        } else if (j < 0) {
            j = Math.max(j, -30L);
        }
        long j2 = j * 1000;
        if (viewB != null) {
            CountDownView countDownView = new CountDownView(this.a);
            this.n = countDownView;
            Context context = this.a;
            countDownView.setCountDownEndDrawable(am.a(context, q.a(context, "myoffer_base_close_icon", "drawable")));
            this.n.setDuration(Math.abs(j2));
            if (Math.abs(j2) > 0) {
                long jAbs = Math.abs(j2);
                if (this.k == null) {
                    this.l = 0L;
                    this.m = jAbs;
                    this.j = true;
                    Thread thread = new Thread(new AnonymousClass3());
                    this.k = thread;
                    thread.setName("anythink_type_endcard_improve_progress");
                    this.k.start();
                }
            } else {
                a(0L);
            }
            if (j2 >= 0) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            View viewB2 = b();
            if (viewB2 == null || this.n == null) {
                return;
            }
            ((ViewGroup) viewB2.getParent()).addView(this.n, viewB2.getLayoutParams());
            if (b() != null) {
                am.a(b());
            }
        }
    }

    private void i() {
        View viewB = b();
        if (viewB == null || this.n == null) {
            return;
        }
        ((ViewGroup) viewB.getParent()).addView(this.n, viewB.getLayoutParams());
        if (b() != null) {
            am.a(b());
        }
    }

    protected View f() {
        return this.g;
    }
}
