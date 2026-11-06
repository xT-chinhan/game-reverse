package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.e5;
import com.smartdigimkt.n1.f5;
import com.smartdigimkt.n1.g5;
import com.smartdigimkt.n1.h5;
import com.smartdigimkt.n1.i3;
import com.smartdigimkt.n1.i5;
import com.smartdigimkt.n1.j5;
import com.smartdigimkt.p3.i;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;
import com.smartdigimkt.u1.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class SimplePlayerMediaView extends FrameLayout implements i3 {
    public final String a;
    public d b;
    public WebProgressBarView c;
    public MuteImageView d;
    public long e;
    public SDMNativeAdMediaViewListener f;
    public i g;
    public l h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public View m;
    public View.OnClickListener n;
    public boolean o;
    public final AtomicBoolean p;
    public String q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;

    public SimplePlayerMediaView(Context context) {
        this(context, null);
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_simple_player_media_ad_view", "layout"), this);
    }

    public final void b() {
        if (this.g == null) {
            int i = this.v;
            getContext();
            this.g = new i(i, this.t);
        }
        if (this.o || this.p.get()) {
            return;
        }
        this.p.set(true);
        this.g.a(this, new j5(this));
    }

    @Override // com.smartdigimkt.n1.i3
    public void destroyPlayerView(int i) {
        d dVar = this.b;
        if (dVar != null) {
            BasePlayerView basePlayerView = dVar.h;
            if (basePlayerView != null) {
                basePlayerView.release(i);
            }
            dVar.c();
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public long getVideoCurrentPosition() {
        d dVar = this.b;
        if (dVar != null) {
            return dVar.a();
        }
        return 0L;
    }

    @Override // com.smartdigimkt.n1.i3
    public void initPlayerView(c cVar, a aVar, com.smartdigimkt.u1.c cVar2) {
        e eVar;
        a();
        if (cVar != null && (eVar = cVar.w) != null) {
            this.v = eVar.a();
        }
        this.h = new l(this.v);
        this.c = (WebProgressBarView) findViewById(k.a(getContext(), "myoffer_player_view_progress_bar_id", "id"));
        this.i = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_resume_img_id", "id"));
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_cover_img_id", "id"));
        this.l = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_cover_icon_id", "id"));
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(new e5(this));
        }
        ImageView imageView2 = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_replay_img_id", "id"));
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new f5(this));
        }
        int i = aVar.s.R;
        if (i <= 0) {
            i = 100;
        }
        this.t = i;
        this.m = findViewById(k.a(getContext(), "myoffer_player_view_fail_id", "id"));
        d dVar = new d(this, aVar, cVar, h.y(getContext()));
        this.b = dVar;
        BasePlayerView basePlayerView = dVar.h;
        if (basePlayerView != null) {
            basePlayerView.setNeedInterruptRelease(true);
        }
        d dVar2 = this.b;
        dVar2.j = cVar2;
        dVar2.i = new g5(this, aVar, cVar);
        if (!TextUtils.isEmpty(cVar.f) && this.k != null) {
            m.a(getContext()).a(new o(1, cVar.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new h5(this, cVar));
        }
        setAutoPlay(this.q);
        MuteImageView muteImageView = (MuteImageView) findViewById(k.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.d = muteImageView;
        if (muteImageView != null) {
            muteImageView.setMute(this.r);
            this.d.setOnClickListener(new i5(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.b;
        if (dVar != null && !this.s) {
            this.s = true;
            dVar.a(this.r, null);
        }
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.g;
        if (iVar != null) {
            iVar.a();
            this.g = null;
        }
        this.p.set(false);
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(4);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void pauseVideo() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(3);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void resumeVideo() {
        d dVar = this.b;
        if (dVar != null) {
            if (this.o || !this.h.a(this, dVar.h, 50, 0)) {
                b();
            } else {
                this.b.d();
            }
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setATImproveClickViewController(com.smartdigimkt.b2.c cVar) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.g = cVar;
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setAutoPlay(String str) {
        BasePlayerView basePlayerView;
        NetworkInfo activeNetworkInfo;
        this.q = str;
        str.getClass();
        if (str.equals("1")) {
            return;
        }
        if (str.equals("2")) {
            Context context = getContext();
            char[] cArr = k.a;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 1) {
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.o = true;
        d dVar = this.b;
        if (dVar != null && (basePlayerView = dVar.h) != null && basePlayerView.isPlaying()) {
            this.b.b(1);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setIsMuted(boolean z) {
        this.r = z;
        MuteImageView muteImageView = this.d;
        if (muteImageView != null) {
            muteImageView.setMute(z);
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setPlayerOnClickListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    @Override // com.smartdigimkt.n1.i3
    public void setVideoListener(SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener) {
        this.f = sDMNativeAdMediaViewListener;
    }

    public void setmIsPureMode(boolean z) {
        this.u = z;
    }

    public SimplePlayerMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimplePlayerMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getClass().getSimpleName();
        this.o = false;
        this.p = new AtomicBoolean(false);
        this.q = "1";
        this.r = true;
        this.s = false;
        this.t = 0;
        this.u = false;
        this.v = 1;
    }
}
