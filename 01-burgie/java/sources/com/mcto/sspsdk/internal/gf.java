package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyVideoPlayOption;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class gf extends FrameLayout {
    public static final /* synthetic */ int L = 0;
    public df A;
    public p B;
    public int C;
    public p7 D;
    public int E;
    public QyVideoPlayOption F;
    public int G;
    public int H;
    public final xe I;
    public final ye J;
    public final cf K;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public final AtomicBoolean g;
    public final AtomicBoolean h;
    public ScheduledExecutorService i;
    public ff j;
    public v3 k;
    public int l;
    public boolean m;
    public final Context n;
    public ia o;
    public float p;
    public String q;
    public String r;
    public vd s;
    public SurfaceTexture t;
    public Surface u;
    public QYNiceImageView v;
    public ProgressBar w;
    public ImageView x;
    public ImageView y;
    public ze z;

    public gf(Context context) {
        super(context, null, 0);
        this.a = 0;
        this.b = 0;
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = true;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.m = false;
        this.p = 1.0f;
        this.C = -1;
        this.E = 0;
        this.F = QyVideoPlayOption.ALWAYS;
        this.G = 0;
        this.H = 0;
        this.I = new xe(this);
        this.J = new ye(this);
        this.K = new cf(this);
        this.n = context;
        setBackgroundColor(-1);
    }

    public static gf a(Context context, p pVar, QyAdSlot qyAdSlot, boolean z, boolean z2, float f, p7 p7Var) {
        gf gfVar = new gf(context);
        gfVar.F = qyAdSlot.getQyVideoPlayOption();
        int volumeType = qyAdSlot.getVolumeType();
        gfVar.G = volumeType;
        gfVar.d = volumeType != 1;
        gfVar.D = p7Var;
        gfVar.p = f;
        gfVar.B = pVar;
        gfVar.l = pVar.a;
        if (pVar.o()) {
            gfVar.q = pVar.G;
            gfVar.r = !TextUtils.isEmpty(pVar.y0) ? pVar.y0 : pVar.G;
        } else {
            String strOptString = pVar.H.optString("audioUrl");
            gfVar.r = strOptString;
            gfVar.q = strOptString;
            gfVar.m = true;
        }
        gfVar.C = pVar.h;
        QYNiceImageView qYNiceImageView = new QYNiceImageView(gfVar.n);
        gfVar.v = qYNiceImageView;
        qYNiceImageView.a(pVar.h());
        gfVar.v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        gfVar.addView(gfVar.v, new FrameLayout.LayoutParams(-1, -1, 17));
        if (z) {
            if (gfVar.s == null) {
                vd vdVar = new vd(gfVar.I);
                gfVar.s = vdVar;
                int i = gfVar.l;
                boolean z3 = gfVar.m;
                String str = gfVar.q;
                String str2 = gfVar.r;
                vdVar.h = 0;
                vdVar.d = i;
                vdVar.e = gj.c(str);
                vdVar.f = gj.c(str2);
                HashMap map = new HashMap(1);
                vdVar.g = map;
                StringBuilder sb = new StringBuilder();
                y4 y4Var = y4.r;
                map.put("User-Agent", sb.append(y4Var.f()).append(";QYPlayer/Android/").append(y4Var.c()).toString());
                vdVar.i = z3;
                vdVar.b();
            }
            gfVar.a = 1;
            gfVar.s.a();
            if (gfVar.e == 0) {
                gfVar.e = 1;
                l lVarA = l.a();
                p pVar2 = gfVar.B;
                lVarA.getClass();
                l.b(1, pVar2, null);
            }
        }
        if (z2) {
            ImageView imageView = new ImageView(gfVar.n);
            gfVar.x = imageView;
            imageView.setId(R.id.qy_loading_overlay_id);
            gfVar.x.setImageResource(R.color.qy_text_color_black_35alpha);
            gfVar.addView(gfVar.x, new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = new ProgressBar(gfVar.n);
            gfVar.w = progressBar;
            progressBar.setId(R.id.qy_loading_img_id);
            gfVar.w.setIndeterminateDrawable(gfVar.getResources().getDrawable(R.drawable.qy_ic_loading_1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(hk.a(gfVar.n, 30.0f), hk.a(gfVar.n, 30.0f));
            layoutParams.gravity = 17;
            gfVar.addView(gfVar.w, layoutParams);
            ImageView imageView2 = new ImageView(gfVar.n);
            gfVar.y = imageView2;
            imageView2.setImageResource(R.drawable.qy_ic_start_with_bg);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(hk.a(gfVar.n, 60.0f), hk.a(gfVar.n, 60.0f));
            layoutParams2.gravity = 17;
            gfVar.y.setVisibility(8);
            gfVar.addView(gfVar.y, layoutParams2);
        }
        return gfVar;
    }

    public final void b() {
        QYNiceImageView qYNiceImageView = this.v;
        if (qYNiceImageView != null) {
            qYNiceImageView.setVisibility(0);
        }
        this.h.set(false);
        this.b = 3;
        this.a = 0;
        f();
        if (this.z != null) {
            x9.a(this.n).b("android.net.conn.CONNECTIVITY_CHANGE", this.z);
        }
        synchronized (this) {
            v3 v3Var = this.k;
            if (v3Var != null) {
                v3Var.a();
                this.k = null;
            }
        }
        vd vdVar = this.s;
        if (vdVar != null) {
            vdVar.a.release();
            this.s = null;
        }
        ia iaVar = this.o;
        if (iaVar != null) {
            removeView(iaVar);
            this.o = null;
        }
        Surface surface = this.u;
        if (surface != null) {
            surface.release();
            this.u = null;
        }
        SurfaceTexture surfaceTexture = this.t;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.t = null;
        }
        p7 p7Var = this.D;
        if (p7Var != null) {
            p7Var.c(this.B);
        }
    }

    public final void c() {
        int i;
        if (this.c) {
            return;
        }
        vd vdVar = this.s;
        if (vdVar != null && (i = this.a) != -1 && i != 0 && i != 1) {
            vdVar.a.start();
            if (vdVar.i && vdVar.a.isPlaying()) {
                vdVar.b.a();
            }
            int i2 = this.a;
            this.a = 3;
            if (i2 == 4 && this.D != null) {
                e();
                this.D.c();
            }
        } else if (this.a == -1 && vdVar != null) {
            vdVar.b();
            a(0);
        }
        this.b = 3;
    }

    public final void d() {
        QyVideoPlayOption qyVideoPlayOption = this.F;
        QyVideoPlayOption qyVideoPlayOption2 = QyVideoPlayOption.WIFI;
        if (qyVideoPlayOption == qyVideoPlayOption2) {
            if (this.z == null) {
                this.z = new ze(this);
            }
            x9.a(this.n).a("android.net.conn.CONNECTIVITY_CHANGE", this.z);
            return;
        }
        synchronized (this) {
            QyVideoPlayOption qyVideoPlayOption3 = this.F;
            if (qyVideoPlayOption3 != QyVideoPlayOption.MANUAL && (qyVideoPlayOption3 != qyVideoPlayOption2 || this.f)) {
                if (this.k == null) {
                    this.k = new v3(this, this.p, 300L);
                }
                this.k.a(this.K);
            }
        }
    }

    public final void e() {
        if (this.G != 2) {
            if (this.A == null) {
                this.A = new df(this);
            }
            x9.a(this.n).a("android.media.VOLUME_CHANGED_ACTION", this.A);
        }
        synchronized (this.g) {
            if (this.g.compareAndSet(false, true)) {
                if (this.j == null) {
                    this.j = new ff(this);
                }
                if (this.i == null) {
                    this.i = Executors.newScheduledThreadPool(1);
                }
                this.i.scheduleWithFixedDelay(this.j, 0L, 1L, TimeUnit.SECONDS);
            }
        }
    }

    public final void f() {
        if (this.A != null) {
            x9.a(this.n).b("android.media.VOLUME_CHANGED_ACTION", this.A);
        }
        synchronized (this.g) {
            if (this.g.compareAndSet(true, false)) {
                ScheduledExecutorService scheduledExecutorService = this.i;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    this.i = null;
                }
                ff ffVar = this.j;
                if (ffVar != null) {
                    ffVar.cancel();
                    this.j = null;
                }
            }
        }
    }

    public final synchronized void g() {
        v3 v3Var = this.k;
        if (v3Var != null) {
            v3Var.a();
            this.k = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.o == null) {
            ia iaVar = new ia(this.n);
            this.o = iaVar;
            iaVar.setSurfaceTextureListener(this.J);
            ia iaVar2 = this.o;
            iaVar2.c = this.E;
            addView(iaVar2, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view != this) {
            return;
        }
        if (i != 0) {
            a();
            if (this.z != null) {
                x9.a(this.n).b("android.net.conn.CONNECTIVITY_CHANGE", this.z);
            }
            synchronized (this) {
                v3 v3Var = this.k;
                if (v3Var != null) {
                    v3Var.a();
                    this.k = null;
                    return;
                }
                return;
            }
        }
        if (hasFocus()) {
            View view2 = this;
            while (view2 != null) {
                if (view2.getVisibility() == 0) {
                    Object parent = view2.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    } else {
                        view2 = (View) parent;
                    }
                } else {
                    return;
                }
            }
            this.H = i;
            d();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.H != 0) {
                return;
            }
            d();
            return;
        }
        a();
        if (this.z != null) {
            x9.a(this.n).b("android.net.conn.CONNECTIVITY_CHANGE", this.z);
        }
        synchronized (this) {
            v3 v3Var = this.k;
            if (v3Var != null) {
                v3Var.a();
                this.k = null;
            }
        }
    }

    public final void a() {
        int i;
        f();
        vd vdVar = this.s;
        if (vdVar != null && (i = this.a) != -1 && i != 0 && i != 1 && vdVar.a.isPlaying()) {
            this.s.a.pause();
            this.a = 4;
            p7 p7Var = this.D;
            if (p7Var != null) {
                p7Var.a();
            }
        }
        this.b = 4;
    }

    public final void a(boolean z) {
        this.d = z;
        vd vdVar = this.s;
        if (vdVar != null) {
            if (z) {
                vdVar.a.setVolume(0.0f, 0.0f);
            } else {
                vdVar.a.setVolume(1.0f, 1.0f);
            }
        }
    }

    public final void a(int i) {
        try {
            ProgressBar progressBar = this.w;
            if (progressBar != null) {
                progressBar.setVisibility(i);
            }
            ImageView imageView = this.x;
            if (imageView != null) {
                imageView.setVisibility(i);
            }
        } catch (Exception e) {
        }
    }
}
