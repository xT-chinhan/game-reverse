package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class pa extends FrameLayout implements TextureView.SurfaceTextureListener {
    public int a;
    public final FrameLayout b;
    public final ja c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public zb f;
    public o3 g;
    public SurfaceTexture h;
    public Surface i;
    public String j;
    public p k;
    public int l;
    public int m;
    public ScheduledExecutorService n;
    public oa o;
    public final Object p;
    public int q;
    public int[] r;

    public pa(Context context) {
        super(context, null);
        this.a = 0;
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.l = 0;
        this.m = 0;
        this.p = new Object();
        this.f = new zb(new la(this));
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        ja jaVar = new ja(context);
        this.c = jaVar;
        jaVar.setSurfaceTextureListener(this);
        frameLayout.addView(jaVar, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public final void a(p pVar) {
        try {
            this.k = pVar;
            this.r = pVar.c0;
            this.m = 0;
            this.q = 0;
            e();
        } catch (Exception e) {
            int i = this.k.a;
        }
    }

    public final int b() {
        zb zbVar = this.f;
        int duration = 0;
        if (zbVar == null) {
            return 0;
        }
        zbVar.getClass();
        try {
            MediaPlayer mediaPlayer = zbVar.b;
            if (mediaPlayer != null) {
                duration = mediaPlayer.getDuration();
            }
        } catch (Exception e) {
            r9.a("ssp_media", zbVar.a + ", getDuration: ", e);
        }
        return duration + this.m;
    }

    public final void c() {
        a();
        try {
            zb zbVar = this.f;
            if (zbVar != null) {
                if (zbVar.f.hasMessages(110)) {
                    zbVar.f.removeMessages(110);
                }
                zbVar.c.post(new jb(zbVar));
                this.f = null;
            }
            FrameLayout frameLayout = this.b;
            if (frameLayout != null) {
                frameLayout.removeView(this.c);
            }
            Surface surface = this.i;
            if (surface != null) {
                surface.release();
                this.i = null;
            }
            SurfaceTexture surfaceTexture = this.h;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.h = null;
            }
            this.a = 0;
        } catch (Throwable th) {
            r9.a("ssp_sdk", "releasePlayer", th);
        }
    }

    public final void d() {
        try {
            if (this.h == null) {
                return;
            }
            this.b.setKeepScreenOn(true);
            if (this.i == null) {
                this.i = new Surface(this.h);
            }
            zb zbVar = this.f;
            if (zbVar != null) {
                zbVar.c.post(new sb(zbVar, this.i));
                this.d.set(true);
            }
        } catch (Exception e) {
            r9.a("ssp_player", this.j + ", open player error:", e);
        }
    }

    public final void e() {
        if (this.f == null) {
            int i = this.k.a;
            return;
        }
        if (this.q == 0) {
            this.j = this.k.G;
            l lVarA = l.a();
            p pVar = this.k;
            lVarA.getClass();
            l.b(1, pVar, null);
        } else {
            p pVar2 = this.k;
            this.j = !TextUtils.isEmpty(pVar2.y0) ? pVar2.y0 : pVar2.G;
        }
        int i2 = 12000;
        int[] iArr = this.r;
        if (iArr != null) {
            int length = iArr.length;
            int i3 = this.q;
            if (length > i3) {
                i2 = iArr[i3];
            }
        }
        this.q++;
        this.f.getClass();
        if (i2 > 0) {
            zb.g = i2;
        }
        zb zbVar = this.f;
        int i4 = this.k.a;
        String str = this.j;
        zbVar.a = i4;
        r9.a("ssp_player", i4 + ", data: " + str, null);
        zbVar.c.post(new tb(zbVar, str, i4));
        this.a = 1;
        a(1);
    }

    public final void f() {
        zb zbVar = this.f;
        if (zbVar == null) {
            return;
        }
        try {
            int i = this.k.a;
            int i2 = this.a;
            if (i2 == 1) {
                zbVar.c.post(new vb(zbVar));
                this.a = 1;
                a(1);
                return;
            }
            if (i2 == 5) {
                zbVar.c.post(new vb(zbVar));
                this.a = 4;
                a(4);
                return;
            }
            if (i2 == 7) {
                zbVar.c.post(new vb(zbVar));
                this.a = 6;
                a(6);
                return;
            }
            if (i2 != 8 && i2 != 11) {
                if (i2 != -1) {
                    if (i2 == 10) {
                        this.a = 9;
                        a(9);
                        return;
                    } else {
                        if (i2 == 3) {
                            zbVar.c.post(new vb(zbVar));
                            this.a = 4;
                            return;
                        }
                        return;
                    }
                }
                if (zbVar.f.hasMessages(110)) {
                    zbVar.f.removeMessages(110);
                }
                zbVar.c.post(new wb(zbVar));
                d();
                zb zbVar2 = this.f;
                int i3 = this.k.a;
                String str = this.j;
                zbVar2.a = i3;
                r9.a("ssp_player", i3 + ", data: " + str, null);
                zbVar2.c.post(new tb(zbVar2, str, i3));
                return;
            }
            if (zbVar.f.hasMessages(110)) {
                zbVar.f.removeMessages(110);
            }
            zbVar.c.post(new ib(zbVar));
            zb zbVar3 = this.f;
            zbVar3.c.post(new ub(zbVar3));
        } catch (Exception e) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        int i3 = this.k.a;
        SurfaceTexture surfaceTexture2 = this.h;
        if (surfaceTexture2 == null) {
            this.h = surfaceTexture;
            d();
        } else {
            this.c.setSurfaceTexture(surfaceTexture2);
        }
        int i4 = this.a;
        if (i4 == 2) {
            this.a = 3;
            a(3);
        } else if (i4 == -1) {
            a(i4);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return this.h == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public final void a(float f) {
        try {
            zb zbVar = this.f;
            if (zbVar != null) {
                zbVar.c.post(new yb(zbVar, f));
            }
        } catch (Exception e) {
            r9.a("ssp_player", "" + this.k.a, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    public final void a(int i) {
        int i2 = this.k.a;
        if (i == -1 || i == 11) {
            a();
        } else if (i == 4) {
            a();
            synchronized (this.p) {
                int i3 = this.k.a;
                if (this.o == null) {
                    this.o = new oa(this);
                }
                if (this.n == null) {
                    this.n = Executors.newScheduledThreadPool(1);
                }
                this.n.scheduleAtFixedRate(this.o, 0L, 1L, TimeUnit.SECONDS);
            }
        } else if (i == 5) {
            a();
        }
        kh.a.a(new ma(this, i));
    }

    public final void a() {
        synchronized (this.p) {
            int i = this.k.a;
            ScheduledExecutorService scheduledExecutorService = this.n;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.n = null;
            }
            oa oaVar = this.o;
            if (oaVar != null) {
                oaVar.cancel();
                this.o = null;
            }
        }
    }
}
