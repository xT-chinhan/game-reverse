package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.anythink.basead.b.f;
import com.anythink.basead.exoplayer.ad;
import com.anythink.basead.exoplayer.d;
import com.anythink.basead.exoplayer.h.s;
import com.anythink.basead.exoplayer.i;
import com.anythink.basead.exoplayer.j.q;
import com.anythink.basead.exoplayer.l.g;
import com.anythink.basead.exoplayer.w;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.core.common.a.n;
import com.anythink.core.common.a.o;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PlayerView extends BasePlayerView {
    public static final String TAG = "PlayerView";
    private ad A;
    private s B;
    private TextureView C;
    private String D;
    private String E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private Handler R;
    private boolean S;
    private Thread T;
    private boolean U;
    private boolean V;
    private View W;
    int a;
    private w.c aa;
    private g ab;
    private final long ac;
    private long ad;
    private boolean ae;
    int b;
    int c;
    boolean d;
    String e;
    String f;
    e g;
    Object h;

    static /* synthetic */ boolean B(PlayerView playerView) {
        playerView.V = false;
        return false;
    }

    static /* synthetic */ boolean V(PlayerView playerView) {
        playerView.P = true;
        return true;
    }

    static /* synthetic */ boolean Y(PlayerView playerView) {
        playerView.t = true;
        return true;
    }

    static /* synthetic */ boolean d(PlayerView playerView) {
        playerView.O = true;
        return true;
    }

    static /* synthetic */ boolean l(PlayerView playerView) {
        playerView.K = true;
        return true;
    }

    static /* synthetic */ boolean q(PlayerView playerView) {
        playerView.L = true;
        return true;
    }

    static /* synthetic */ boolean v(PlayerView playerView) {
        playerView.M = true;
        return true;
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = "";
        this.E = "";
        this.F = -1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = "";
        this.f = "";
        this.ac = 5000L;
        this.ad = 0L;
        this.h = new Object();
        this.ae = true;
        setSaveEnabled(true);
        this.R = new Handler(Looper.getMainLooper()) { // from class: com.anythink.basead.ui.PlayerView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (PlayerView.this.w == null) {
                    return;
                }
                PlayerView.this.F = message.what;
                if (!PlayerView.this.O && !PlayerView.this.t) {
                    PlayerView.d(PlayerView.this);
                    if (PlayerView.this.w != null) {
                        PlayerView.this.w.a();
                    }
                    PlayerView.this.a(202);
                }
                if (PlayerView.this.w != null) {
                    PlayerView.this.w.a(PlayerView.this.F);
                }
                if (PlayerView.this.K || PlayerView.this.F < PlayerView.this.H) {
                    if (PlayerView.this.L || PlayerView.this.F < PlayerView.this.I) {
                        if (!PlayerView.this.M && PlayerView.this.F >= PlayerView.this.J) {
                            PlayerView.v(PlayerView.this);
                            if (PlayerView.this.w != null) {
                                PlayerView.this.w.a(75);
                            }
                            PlayerView.this.a(205);
                        }
                    } else {
                        PlayerView.q(PlayerView.this);
                        if (PlayerView.this.w != null) {
                            PlayerView.this.w.a(50);
                        }
                        PlayerView.this.a(204);
                    }
                } else {
                    PlayerView.l(PlayerView.this);
                    if (PlayerView.this.w != null) {
                        PlayerView.this.w.a(25);
                    }
                    PlayerView.this.a(203);
                }
                if (PlayerView.this.ae || !PlayerView.this.V || PlayerView.this.F < PlayerView.this.a || PlayerView.this.w == null) {
                    return;
                }
                PlayerView.B(PlayerView.this);
                PlayerView.this.w.f();
            }
        };
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.h.w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        super.init(wVar, xVar, z, list, eVar);
        this.g = eVar;
        c(z);
        initMuteStatus(z);
        setVideoRateConfig(wVar.r().aa(), wVar.r().ab());
        load(wVar.E(), false);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        try {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
            Bundle bundle = new Bundle();
            bundle.putParcelable("superState", parcelableOnSaveInstanceState);
            bundle.putInt("savePosition", this.F);
            bundle.putBoolean("saveVideoPlay25", this.K);
            bundle.putBoolean("saveVideoPlay50", this.L);
            bundle.putBoolean("saveVideoPlay75", this.M);
            bundle.putBoolean("saveIsVideoStart", this.O);
            bundle.putBoolean("saveIsVideoPlayCompletion", this.t);
            bundle.putBoolean("saveIsMute", this.S);
            bundle.putBoolean("saveVideoNeedResumeByCdRate", this.V);
            bundle.toString();
            return bundle;
        } catch (Throwable unused) {
            return super.onSaveInstanceState();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        try {
            Bundle bundle = (Bundle) parcelable;
            Parcelable parcelable2 = bundle.getParcelable("superState");
            if (parcelable2 == null) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            super.onRestoreInstanceState(parcelable2);
            this.F = bundle.getInt("savePosition");
            this.K = bundle.getBoolean("saveVideoPlay25");
            this.L = bundle.getBoolean("saveVideoPlay50");
            this.M = bundle.getBoolean("saveVideoPlay75");
            this.O = bundle.getBoolean("saveIsVideoStart");
            this.t = bundle.getBoolean("saveIsVideoPlayCompletion");
            this.S = bundle.getBoolean("saveIsMute");
            this.V = bundle.getBoolean("saveVideoNeedResumeByCdRate");
            ad adVar = this.A;
            if (adVar != null) {
                adVar.a(this.S ? 0.0f : 1.0f);
            }
            bundle.toString();
        } catch (Throwable unused) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setListener(BasePlayerView.a aVar) {
        this.w = aVar;
    }

    public void setVideoRateConfig(int i, int i2) {
        this.c = i;
        this.b = i2;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PlayerView$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (PlayerView.this.w != null) {
                PlayerView.this.w.b(1);
            }
        }
    }

    public void setLoadingView(View view) {
        this.W = view;
    }

    private void a() {
        View view = this.W;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void b() {
        View view = this.W;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.T != null) {
            return;
        }
        this.N = true;
        this.ad = 0L;
        Thread thread = new Thread(new Runnable() { // from class: com.anythink.basead.ui.PlayerView.3
            @Override // java.lang.Runnable
            public final void run() {
                while (PlayerView.this.N) {
                    if (!PlayerView.this.t && PlayerView.this.isPlaying() && PlayerView.this.R != null) {
                        PlayerView.this.ad = 0L;
                        try {
                            PlayerView.this.R.sendEmptyMessage((int) PlayerView.this.A.t());
                        } catch (Throwable unused) {
                        }
                        try {
                            Thread.sleep(200L);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        if (PlayerView.this.ad == 0) {
                            PlayerView.this.ad = SystemClock.elapsedRealtime();
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (SystemClock.elapsedRealtime() - PlayerView.this.ad > 5000 && PlayerView.this.ad != 0) {
                            if (PlayerView.this.w != null) {
                                t.b().b(new Runnable() { // from class: com.anythink.basead.ui.PlayerView.3.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        PlayerView.this.b(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, "Video player error!Buffer timeout"));
                                    }
                                });
                            }
                            PlayerView.this.d();
                        }
                    }
                }
            }
        });
        this.T = thread;
        thread.setName("anythink_type_player_progress");
        this.T.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.N = false;
        this.T = null;
        this.ad = 0L;
    }

    public void load(String str, boolean z) {
        boolean z2;
        this.E = str;
        f.a();
        this.D = f.a(4, str);
        if (new File(this.D).exists() || !TextUtils.isEmpty(this.E)) {
            this.U = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, com.anythink.basead.d.g.P));
            return;
        }
        if (this.C == null) {
            TextureView textureView = new TextureView(getContext());
            this.C = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.C, layoutParams);
        }
        if (this.A == null) {
            this.A = i.a(new com.anythink.basead.exoplayer.f(getContext()), new com.anythink.basead.exoplayer.i.c(), new d());
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            this.aa = anonymousClass4;
            this.A.a(anonymousClass4);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            this.ab = anonymousClass5;
            this.A.a(anonymousClass5);
            this.A.a(this.S ? 0.0f : 1.0f);
            this.A.a(z);
            a(f(), false);
        }
        setOnClickListener(new AnonymousClass2());
    }

    private boolean e() {
        if (!new File(this.D).exists() && TextUtils.isEmpty(this.E)) {
            return true;
        }
        this.U = true;
        return false;
    }

    private String f() {
        if (new File(this.D).exists()) {
            return this.D;
        }
        return this.E;
    }

    private void b(boolean z) {
        if (this.A == null) {
            this.A = i.a(new com.anythink.basead.exoplayer.f(getContext()), new com.anythink.basead.exoplayer.i.c(), new d());
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            this.aa = anonymousClass4;
            this.A.a(anonymousClass4);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            this.ab = anonymousClass5;
            this.A.a(anonymousClass5);
            this.A.a(this.S ? 0.0f : 1.0f);
            this.A.a(z);
            a(f(), false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PlayerView$4, reason: invalid class name */
    final class AnonymousClass4 extends w.a {
        AnonymousClass4() {
        }

        @Override // com.anythink.basead.exoplayer.w.a, com.anythink.basead.exoplayer.w.c
        public final void onPlayerError(com.anythink.basead.exoplayer.g gVar) {
            boolean z;
            long jT;
            String str;
            super.onPlayerError(gVar);
            String str2 = "Play error and ExoPlayer have not message.";
            if (gVar != null) {
                int i = gVar.d;
                z = true;
                if (i != 0) {
                    if (i == 1) {
                        str2 = "Play error, because have a RendererException.";
                    } else if (i == 2) {
                        str2 = "Play error, because have a UnexpectedException.";
                    }
                    z = false;
                } else {
                    str2 = "Play error, because have a SourceException.";
                }
                if (gVar.getCause() != null && !TextUtils.isEmpty(gVar.getCause().getMessage())) {
                    str2 = str2 + ",eception:" + gVar.getCause().getMessage();
                }
            } else {
                z = false;
            }
            if (PlayerView.this.d && z) {
                PlayerView.this.f = str2;
                String str3 = PlayerView.TAG;
                PlayerView.this.d = false;
                PlayerView.M(PlayerView.this);
                return;
            }
            String str4 = PlayerView.TAG;
            PlayerView.this.d();
            if (PlayerView.this.w != null) {
                try {
                    jT = PlayerView.this.A.t();
                } catch (Throwable unused) {
                    jT = 0;
                }
                String str5 = jT <= 0 ? com.anythink.basead.d.g.p : com.anythink.basead.d.g.k;
                String str6 = "videoUrl:" + PlayerView.this.E + ",readyRate:" + PlayerView.this.c + ",cdRate:" + PlayerView.this.b + ",play process:" + jT;
                if (TextUtils.isEmpty(PlayerView.this.f)) {
                    str = str6 + ",localFileErrorMsg:" + str2;
                } else {
                    str = str6 + ",localFileErrorMsg:" + PlayerView.this.f + ",errorMsg:" + str2;
                }
                if (PlayerView.this.P) {
                    PlayerView.this.a(com.anythink.basead.d.g.a(str5, com.anythink.basead.d.g.I.concat(String.valueOf(str))));
                } else {
                    PlayerView.this.a(com.anythink.basead.d.g.a(str5, com.anythink.basead.d.g.Q.concat(String.valueOf(str))));
                }
            }
        }

        @Override // com.anythink.basead.exoplayer.w.a, com.anythink.basead.exoplayer.w.c
        public final void onPlayerStateChanged(boolean z, int i) {
            super.onPlayerStateChanged(z, i);
            String str = PlayerView.TAG;
            if (i == 2) {
                if (!PlayerView.this.Q) {
                    PlayerView.this.Q = true;
                    PlayerView.R(PlayerView.this);
                }
                PlayerView playerView = PlayerView.this;
                PlayerView.b(playerView, playerView.A.s());
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                PlayerView.this.d();
                if (PlayerView.this.t) {
                    return;
                }
                PlayerView.Y(PlayerView.this);
                PlayerView playerView2 = PlayerView.this;
                playerView2.F = playerView2.G;
                if (PlayerView.this.w != null) {
                    PlayerView.this.w.c();
                }
                PlayerView.this.a(206);
                PlayerView.this.h();
                return;
            }
            if (!PlayerView.this.P) {
                PlayerView.this.Q = false;
                PlayerView playerView3 = PlayerView.this;
                playerView3.G = (int) playerView3.A.s();
                PlayerView playerView4 = PlayerView.this;
                PlayerView.c(playerView4, playerView4.G);
                if (PlayerView.this.w != null) {
                    PlayerView.this.w.b(PlayerView.this.G);
                }
                PlayerView playerView5 = PlayerView.this;
                playerView5.H = Math.round(playerView5.G * 0.25f);
                PlayerView playerView6 = PlayerView.this;
                playerView6.I = Math.round(playerView6.G * 0.5f);
                PlayerView playerView7 = PlayerView.this;
                playerView7.J = Math.round(playerView7.G * 0.75f);
                PlayerView playerView8 = PlayerView.this;
                PlayerView.b(playerView8, playerView8.G);
                PlayerView.V(PlayerView.this);
            }
            if (PlayerView.this.F > 0 && Math.abs(((long) PlayerView.this.F) - PlayerView.this.A.t()) > 500) {
                PlayerView.this.A.a(PlayerView.this.F);
            }
            if (PlayerView.this.isPlaying()) {
                PlayerView.this.c();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PlayerView$5, reason: invalid class name */
    final class AnonymousClass5 implements g {
        @Override // com.anythink.basead.exoplayer.l.g
        public final void a() {
        }

        AnonymousClass5() {
        }

        @Override // com.anythink.basead.exoplayer.l.g
        public final void a(int i, int i2) {
            PlayerView playerView = PlayerView.this;
            playerView.autoFitVideoSize(i, i2, playerView.C);
        }
    }

    private void a(long j) {
        if (this.ae) {
            return;
        }
        int i = this.c;
        if (i > 0 && i < 100) {
            if (this.b > i) {
                this.b = i / 2;
            }
            int i2 = this.b;
            if (i2 == 0) {
                this.a = 0;
                this.V = true;
            } else if (j > 0) {
                this.a = Math.round(((i2 * 1.0f) / 100.0f) * j) + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
                this.V = true;
            }
            if (this.a > 0 || !this.V || this.w == null) {
                return;
            }
            this.V = false;
            this.w.f();
            return;
        }
        this.V = false;
    }

    private void g() {
        if (this.C == null) {
            TextureView textureView = new TextureView(getContext());
            this.C = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.C, layoutParams);
        }
    }

    private void a(String str, boolean z) {
        while (true) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.A == null) {
                    a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, "Player show fail with some internal error"));
                    return;
                }
                this.d = TextUtils.equals(str, this.D);
                if (TextUtils.equals(str, this.E) && this.c > 0) {
                    if (z) {
                        com.anythink.core.common.u.e.b("Video Play Fail:Play Network Url", "AdxPlayer videoUrl:" + str + ",readyRate:" + this.c + ",maxVideoCacheSize:" + o.a().c() + ",lastRecycleCheckDownloadedFileSize:" + o.a().d() + ",isChaoDi:true,ChaoDiThrowableMsg:" + this.e, t.b().r());
                    } else {
                        com.anythink.core.common.u.e.b("Video Play Fail:Play Network Url", "AdxPlayer videoUrl:" + str + ",readyRate:" + this.c + ",maxVideoCacheSize:" + o.a().c() + ",lastRecycleCheckDownloadedFileSize:" + o.a().d(), t.b().r());
                    }
                }
                Uri uri = Uri.parse(str);
                if (str.toLowerCase().startsWith("http")) {
                    this.B = new com.anythink.basead.exoplayer.h.o.c(new q("Anythink_ExoPlayer")).b(uri);
                    this.ae = true;
                } else {
                    this.B = new com.anythink.basead.exoplayer.h.o.c(new com.anythink.basead.exoplayer.j.o(getContext(), "Anythink_ExoPlayer")).b(uri);
                    this.ae = false;
                }
                this.A.a(this.C);
                this.A.a(this.B);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                if (TextUtils.equals(str, this.E) || z) {
                    a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, th.getMessage()));
                    return;
                } else {
                    this.e = th.getMessage();
                    str = this.E;
                    z = true;
                }
            }
        }
    }

    private void i() {
        if (this.w != null) {
            this.w.f();
        }
        this.A.a(this.B);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        if (isPlaying()) {
            a(207);
        }
        d();
        ad adVar = this.A;
        if (adVar != null) {
            adVar.a(false);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        ad adVar = this.A;
        if (adVar != null) {
            adVar.m();
        }
        h();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void rePlayVideo() {
        if (this.A != null) {
            this.F = 0;
            this.O = false;
            this.t = false;
            synchronized (this.h) {
                this.g = null;
            }
            a(f(), true);
            start();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void release(final int i) {
        final long currentPosition = getCurrentPosition();
        final long videoLength = getVideoLength();
        d();
        h();
        if (!this.t) {
            a(211);
        }
        ad adVar = this.A;
        if (adVar != null) {
            if (adVar.J()) {
                this.A.m();
            }
            w.c cVar = this.aa;
            if (cVar != null) {
                this.A.b(cVar);
            }
            g gVar = this.ab;
            if (gVar != null) {
                this.A.b(gVar);
            }
            this.A.n();
            this.A = null;
        }
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.P = false;
        if (!this.ae) {
            com.anythink.core.common.res.b.c.a().d(this.E);
        }
        if (this.x == null || !this.x.c()) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.ui.PlayerView.6
                @Override // java.lang.Runnable
                public final void run() {
                    long jE;
                    long jD;
                    n nVarA;
                    if (PlayerView.this.y == null || PlayerView.this.x == null) {
                        return;
                    }
                    if (PlayerView.this.x == null || (nVarA = o.a().a(PlayerView.this.x.E())) == null) {
                        jE = 0;
                        jD = 0;
                    } else {
                        jE = nVarA.e();
                        jD = nVarA.d();
                    }
                    com.anythink.core.common.u.e.b(PlayerView.this.y, PlayerView.this.x, i, currentPosition, jE, videoLength, jD);
                }
            }, 8);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        ad adVar = this.A;
        return adVar != null && adVar.J();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.S;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return Math.max(this.F, 0);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        ad adVar = this.A;
        if (adVar != null) {
            return adVar.s();
        }
        return this.G;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.U;
    }

    public void initMuteStatus(boolean z) {
        this.S = z;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.S = z;
        if (z) {
            ad adVar = this.A;
            if (adVar != null) {
                adVar.a(0.0f);
            }
            if (this.w != null) {
                this.w.d();
            }
        } else {
            ad adVar2 = this.A;
            if (adVar2 != null) {
                adVar2.a(1.0f);
            }
            if (this.w != null) {
                this.w.e();
            }
        }
        c(z);
        a(212);
    }

    public void autoFitVideoSize(int i, int i2, View view) {
        float f = i;
        float f2 = i2;
        float fMax = Math.max(f / view.getMeasuredWidth(), f2 / view.getMeasuredHeight());
        int iCeil = (int) Math.ceil(f / fMax);
        int iCeil2 = (int) Math.ceil(f2 / fMax);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = iCeil;
        layoutParams.height = iCeil2;
        view.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean z = this.z;
        if (this.z) {
            return;
        }
        release(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.h) {
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(i, (View) null);
            }
        }
    }

    private void j() {
        synchronized (this.h) {
            this.g = null;
        }
    }

    private void c(boolean z) {
        synchronized (this.h) {
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(z);
            }
        }
    }

    private void b(long j) {
        synchronized (this.h) {
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(j);
            }
        }
    }

    private void a(boolean z) {
        boolean z2;
        if (new File(this.D).exists() || !TextUtils.isEmpty(this.E)) {
            this.U = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, com.anythink.basead.d.g.P));
            return;
        }
        if (this.C == null) {
            TextureView textureView = new TextureView(getContext());
            this.C = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.C, layoutParams);
        }
        if (this.A == null) {
            this.A = i.a(new com.anythink.basead.exoplayer.f(getContext()), new com.anythink.basead.exoplayer.i.c(), new d());
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            this.aa = anonymousClass4;
            this.A.a(anonymousClass4);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            this.ab = anonymousClass5;
            this.A.a(anonymousClass5);
            this.A.a(this.S ? 0.0f : 1.0f);
            this.A.a(z);
            a(f(), false);
        }
        setOnClickListener(new AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        View view = this.W;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!isPlaying()) {
            a(208);
        }
        ad adVar = this.A;
        if (adVar != null) {
            adVar.a(true);
        }
        c();
    }

    static /* synthetic */ void M(PlayerView playerView) {
        if (playerView.w != null) {
            playerView.w.f();
        }
        playerView.A.a(playerView.B);
    }

    static /* synthetic */ void R(PlayerView playerView) {
        View view = playerView.W;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    static /* synthetic */ void b(PlayerView playerView, long j) {
        if (playerView.ae) {
            return;
        }
        int i = playerView.c;
        if (i > 0 && i < 100) {
            if (playerView.b > i) {
                playerView.b = i / 2;
            }
            int i2 = playerView.b;
            if (i2 == 0) {
                playerView.a = 0;
                playerView.V = true;
            } else if (j > 0) {
                int iRound = Math.round(((i2 * 1.0f) / 100.0f) * j);
                playerView.a = iRound;
                playerView.a = iRound + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
                playerView.V = true;
            }
            if (playerView.a > 0 || !playerView.V || playerView.w == null) {
                return;
            }
            playerView.V = false;
            playerView.w.f();
            return;
        }
        playerView.V = false;
    }

    static /* synthetic */ void c(PlayerView playerView, long j) {
        synchronized (playerView.h) {
            e eVar = playerView.g;
            if (eVar != null) {
                eVar.a(j);
            }
        }
    }
}
