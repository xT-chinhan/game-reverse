package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.anythink.core.common.inner.b.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.i0.f;
import com.smartdigimkt.i0.i0;
import com.smartdigimkt.l3.d;
import com.smartdigimkt.n1.e4;
import com.smartdigimkt.n1.f4;
import com.smartdigimkt.n1.g4;
import com.smartdigimkt.n1.i4;
import com.smartdigimkt.n1.j4;
import com.smartdigimkt.n1.k4;
import com.smartdigimkt.q1.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.v0.j;
import com.smartdigimkt.y0.n;
import com.smartdigimkt.y0.p;
import com.smartdigimkt.z.e0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PlayerView extends BasePlayerView {
    public static final String TAG = "PlayerView";
    public int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public final e4 J;
    public boolean K;
    public volatile Thread L;
    public volatile boolean M;
    public Thread N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public int S;
    public View T;
    public i4 U;
    public j4 V;
    public boolean W;
    public String a0;
    public boolean b0;
    public i0 t;
    public j u;
    public TextureView v;
    public String w;
    public String x;
    public int y;
    public int z;

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = "";
        this.x = "";
        this.y = -1;
        this.G = false;
        this.H = false;
        this.I = false;
        this.R = 0;
        this.S = 0;
        this.W = false;
        this.a0 = "";
        this.b0 = true;
        setSaveEnabled(true);
        this.J = new e4(this, Looper.getMainLooper());
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private String getValidVideoPath() {
        return !TextUtils.isEmpty(this.w) ? this.w : this.x;
    }

    public final synchronized void a() {
        if (!this.M && this.L == null) {
            this.N = null;
            this.L = new Thread(new g4(this));
            this.L.setName("sdm_type_player_progress");
            this.L.start();
        }
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

    public final synchronized void b() {
        this.L = null;
        this.N = null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return Math.max(this.y, 0);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        i0 i0Var = this.t;
        return i0Var != null ? i0Var.h() : this.z;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.O;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, a aVar, boolean z, List<Bitmap> list) {
        super.init(cVar, aVar, z, list);
        initMuteStatus(z);
        e eVar = cVar.w;
        setVideoRateConfig(eVar.S, eVar.T);
        load(cVar.i, false);
    }

    public void initMuteStatus(boolean z) {
        this.K = z;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.K;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        i0 i0Var = this.t;
        return i0Var != null && i0Var.i();
    }

    public void load(String str, boolean z) {
        this.x = str;
        if (this.S > 0) {
            e0.a().getClass();
            this.w = e0.a(4, str);
        }
        if (TextUtils.isEmpty(this.w) && TextUtils.isEmpty(this.x)) {
            a(new g(b.k, b.P));
            return;
        }
        this.O = true;
        if (this.v == null) {
            TextureView textureView = new TextureView(getContext());
            this.v = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.v, layoutParams);
        }
        if (this.t == null) {
            i0 i0Var = new i0(new f(getContext()), new com.smartdigimkt.x0.g(), new com.smartdigimkt.i0.c());
            this.t = i0Var;
            i4 i4Var = new i4(this);
            this.U = i4Var;
            i0Var.b.g.add(i4Var);
            j4 j4Var = new j4(this);
            this.V = j4Var;
            this.t.e.add(j4Var);
            this.t.a(this.K ? 0.0f : 1.0f);
            this.t.a(z);
            a(getValidVideoPath(), false);
        }
        setOnClickListener(new f4(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.r) {
            return;
        }
        release(5);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
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
            this.y = bundle.getInt("savePosition");
            this.D = bundle.getBoolean("saveVideoPlay25");
            this.E = bundle.getBoolean("saveVideoPlay50");
            this.F = bundle.getBoolean("saveVideoPlay75");
            this.G = bundle.getBoolean("saveIsVideoStart");
            this.l = bundle.getBoolean("saveIsVideoPlayCompletion");
            this.K = bundle.getBoolean("saveIsMute");
            this.P = bundle.getBoolean("saveVideoNeedResumeByCdRate");
            i0 i0Var = this.t;
            if (i0Var != null) {
                i0Var.a(this.K ? 0.0f : 1.0f);
            }
            bundle.toString();
        } catch (Throwable unused) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        try {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
            Bundle bundle = new Bundle();
            bundle.putParcelable("superState", parcelableOnSaveInstanceState);
            bundle.putInt("savePosition", this.y);
            bundle.putBoolean("saveVideoPlay25", this.D);
            bundle.putBoolean("saveVideoPlay50", this.E);
            bundle.putBoolean("saveVideoPlay75", this.F);
            bundle.putBoolean("saveIsVideoStart", this.G);
            bundle.putBoolean("saveIsVideoPlayCompletion", this.l);
            bundle.putBoolean("saveIsMute", this.K);
            bundle.putBoolean("saveVideoNeedResumeByCdRate", this.P);
            bundle.toString();
            return bundle;
        } catch (Throwable unused) {
            return super.onSaveInstanceState();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        try {
            synchronized (this) {
                this.L = null;
                this.N = null;
            }
            i0 i0Var = this.t;
            if (i0Var != null) {
                i0Var.a(false);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void rePlayVideo() {
        if (this.t != null) {
            this.y = 0;
            this.G = false;
            this.l = false;
            a(getValidVideoPath(), true);
            start();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void release(int i) {
        this.M = true;
        synchronized (this) {
            this.L = null;
            this.N = null;
        }
        long currentPosition = getCurrentPosition();
        long videoLength = getVideoLength();
        this.o = null;
        i0 i0Var = this.t;
        if (i0Var != null) {
            if (i0Var.i()) {
                this.t.k();
            }
            i4 i4Var = this.U;
            if (i4Var != null) {
                this.t.b.g.remove(i4Var);
            }
            j4 j4Var = this.V;
            if (j4Var != null) {
                this.t.e.remove(j4Var);
            }
            this.t.j();
            this.t = null;
        }
        e4 e4Var = this.J;
        if (e4Var != null) {
            e4Var.removeCallbacksAndMessages(null);
        }
        this.H = false;
        if (!this.b0) {
            d.a().a(this.x);
        }
        com.smartdigimkt.q3.f.a().a(new k4(this, i, currentPosition, videoLength), 0L, 8);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void setListener(k kVar) {
        this.o = kVar;
    }

    public void setLoadingView(View view) {
        this.T = view;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.K = z;
        if (z) {
            i0 i0Var = this.t;
            if (i0Var != null) {
                i0Var.a(0.0f);
            }
            k kVar = this.o;
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        i0 i0Var2 = this.t;
        if (i0Var2 != null) {
            i0Var2.a(1.0f);
        }
        k kVar2 = this.o;
        if (kVar2 != null) {
            kVar2.d();
        }
    }

    public void setVideoRateConfig(int i, int i2) {
        this.S = i;
        this.R = i2;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void start() {
        if (this.M) {
            return;
        }
        View view = this.T;
        if (view != null) {
            view.setVisibility(8);
        }
        i0 i0Var = this.t;
        if (i0Var != null) {
            i0Var.a(true);
        }
        synchronized (this) {
            if (!this.M && this.L == null) {
                this.N = null;
                this.L = new Thread(new g4(this));
                this.L.setName("sdm_type_player_progress");
                this.L.start();
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        i0 i0Var = this.t;
        if (i0Var != null) {
            i0Var.k();
        }
        k kVar = this.o;
        if (kVar != null) {
            kVar.c();
        }
        this.o = null;
    }

    public static void a(PlayerView playerView, long j) {
        k kVar;
        if (playerView.b0) {
            return;
        }
        int i = playerView.S;
        if (i > 0 && i < 100) {
            if (playerView.R > i) {
                playerView.R = i / 2;
            }
            int i2 = playerView.R;
            if (i2 == 0) {
                playerView.Q = 0;
                playerView.P = true;
            } else if (j > 0) {
                playerView.Q = Math.round(((i2 * 1.0f) / 100.0f) * j) + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
                playerView.P = true;
            }
            if (playerView.Q > 0 || !playerView.P || (kVar = playerView.o) == null) {
                return;
            }
            playerView.P = false;
            kVar.e();
            return;
        }
        playerView.P = false;
    }

    public final void a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.t == null) {
                a(new g(b.k, "Player show fail with some internal error"));
                return;
            }
            this.W = TextUtils.equals(str, this.w);
            Uri uri = Uri.parse(str);
            if (str.toLowerCase().startsWith("http")) {
                this.u = new j(uri, new p(), new com.smartdigimkt.n0.d());
                this.b0 = true;
            } else {
                this.u = new j(uri, new n(getContext()), new com.smartdigimkt.n0.d());
                this.b0 = false;
            }
            this.t.a(this.v);
            this.t.a(this.u);
        } catch (Throwable th) {
            th.printStackTrace();
            if (!TextUtils.equals(str, this.x) && !z) {
                th.getMessage();
                a(this.x, true);
            } else {
                a(new g(b.k, th.getMessage()));
            }
        }
    }
}
