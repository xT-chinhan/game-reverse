package com.smartdigimkt.u1;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.h0.n;
import com.smartdigimkt.q1.k;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.basead.ui.RoundCornerRelativeLayout;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebContainerView;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements AudioManager.OnAudioFocusChangeListener {
    public final String a = com.anythink.core.e.d.a;
    public final Context b;
    public final com.smartdigimkt.a3.a c;
    public final com.smartdigimkt.b3.c d;
    public final int e;
    public boolean f;
    public com.smartdigimkt.b2.c g;
    public BasePlayerView h;
    public k i;
    public c j;
    public long k;
    public a l;
    public WTWebContainerView m;
    public com.smartdigimkt.y.c n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public final View r;
    public boolean s;
    public ConcurrentHashMap t;

    /* JADX WARN: Code duplicated, block: B:12:0x0052  */
    public d(View view, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, int i) {
        boolean zH;
        this.s = true;
        Context context = view.getContext();
        this.b = context;
        this.c = aVar;
        this.d = cVar;
        this.e = i;
        this.h = (BasePlayerView) view.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_player_view_id", "id"));
        if (aVar == null || cVar == null) {
            zH = false;
        } else {
            String strValueOf = String.valueOf(aVar.c);
            strValueOf.getClass();
            if (strValueOf.equals("1")) {
                zH = !TextUtils.isEmpty(cVar.i);
            } else if (strValueOf.equals("3")) {
                zH = c0.h(cVar, aVar);
            } else {
                zH = false;
            }
        }
        this.o = zH;
        View viewFindViewById = view.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_player_view_container_id", "id"));
        this.r = viewFindViewById;
        if (viewFindViewById != null && (viewFindViewById instanceof RoundCornerRelativeLayout)) {
            ((RoundCornerRelativeLayout) viewFindViewById).setRadius(0);
        }
        this.s = true;
    }

    public final BasePlayerView a(boolean z, List list) {
        this.f = z;
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            a aVar = new a(this);
            this.l = aVar;
            basePlayerView.setListener(aVar);
            this.h.init(this.d, this.c, this.f, list);
        }
        return this.h;
    }

    public final void b() {
        c cVar;
        this.p = false;
        this.q = false;
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            if (basePlayerView.isPlaying() && (cVar = this.j) != null) {
                s.a(11, this.d, cVar.a());
            }
            this.h.pause();
        }
    }

    public final void c() {
        this.p = false;
        this.q = false;
        com.smartdigimkt.y.c cVar = this.n;
        if (cVar != null) {
            cVar.d = null;
            cVar.a();
            this.n = null;
        }
    }

    public final void d() {
        BasePlayerView basePlayerView;
        int iB;
        com.smartdigimkt.y.c cVar;
        c cVar2;
        if (this.s && (basePlayerView = this.h) != null && basePlayerView.hasVideo()) {
            if (!this.f) {
                if (this.o) {
                    if (this.n == null) {
                        com.smartdigimkt.y.c cVar3 = new com.smartdigimkt.y.c();
                        this.n = cVar3;
                        cVar3.d = new WeakReference(this);
                        this.n.a(this.b);
                    }
                    iB = this.n.b();
                } else {
                    iB = 1;
                }
                if (iB != 1) {
                    this.p = false;
                    BasePlayerView basePlayerView2 = this.h;
                    if (basePlayerView2 != null) {
                        if (basePlayerView2.isPlaying() && (cVar2 = this.j) != null) {
                            s.a(11, this.d, cVar2.a());
                        }
                        this.h.pause();
                    }
                    if (iB != 2 && (cVar = this.n) != null) {
                        cVar.d = null;
                        cVar.a();
                        this.n = null;
                    }
                    this.q = true;
                    return;
                }
            }
            this.q = false;
            this.p = true;
            if (!this.h.isPlaying() && this.j != null) {
                System.currentTimeMillis();
                long currentPosition = this.h.getCurrentPosition();
                this.k = currentPosition;
                if (currentPosition != 0) {
                    s.a(15, this.d, this.j.a());
                }
            }
            this.h.start();
        }
    }

    public final void e() {
        BasePlayerView basePlayerView;
        if (this.q && this.s && (basePlayerView = this.h) != null && basePlayerView.isShown() && this.h.hasWindowFocus() && !this.h.isPlayCompletion()) {
            d();
        }
    }

    public final void f() {
        a(124);
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null && basePlayerView.isPlaying()) {
            this.h.stop();
            this.h.removeAllViews();
            c cVar = this.j;
            if (cVar != null) {
                m mVarA = cVar.a();
                mVarA.g = this.j.b();
                s.a(16, this.d, mVarA);
            }
        }
        c();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        com.smartdigimkt.y.c cVar;
        c cVar2;
        boolean z = this.q;
        boolean z2 = true;
        if (i == 1) {
            e();
            return;
        }
        if (this.f) {
            return;
        }
        if (i == -1 || i == -2 || i == -3) {
            if (!this.p && !z) {
                z2 = false;
            }
            this.p = false;
            BasePlayerView basePlayerView = this.h;
            if (basePlayerView != null) {
                if (basePlayerView.isPlaying() && (cVar2 = this.j) != null) {
                    s.a(11, this.d, cVar2.a());
                }
                this.h.pause();
            }
            this.q = z2;
            if (i != -1 || (cVar = this.n) == null) {
                return;
            }
            cVar.d = null;
            cVar.a();
            this.n = null;
        }
    }

    public final void b(int i) {
        BasePlayerView basePlayerView = this.h;
        boolean zIsPlaying = basePlayerView != null ? basePlayerView.isPlaying() : false;
        b();
        if (zIsPlaying) {
            f.a().a(new b(this, i), 0L, 8);
        }
    }

    public final void b(boolean z) {
        if (!z && this.o) {
            if (this.n == null) {
                com.smartdigimkt.y.c cVar = new com.smartdigimkt.y.c();
                this.n = cVar;
                cVar.d = new WeakReference(this);
                this.n.a(this.b);
            }
            if (this.n.b() != 1) {
                z = true;
            }
        }
        this.f = z;
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.setMute(z);
        }
        if (z) {
            com.smartdigimkt.y.c cVar2 = this.n;
            if (cVar2 != null) {
                cVar2.d = null;
                cVar2.a();
                this.n = null;
            }
            e();
        }
    }

    public final void a(int i) {
        com.smartdigimkt.b2.c cVar = this.g;
        if (cVar != null) {
            cVar.a(i);
        }
        WTWebContainerView wTWebContainerView = this.m;
        if (wTWebContainerView != null) {
            com.smartdigimkt.b2.c cVar2 = this.g;
            wTWebContainerView.notifyInnerAdEvent(i, cVar2 != null ? cVar2.f : null);
        }
    }

    public final long a() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.getCurrentPosition();
        }
        return 0L;
    }

    public final n a(boolean z) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView == null || !basePlayerView.hasVideo()) {
            return null;
        }
        n nVar = new n();
        nVar.h = this.e == 2 ? 4 : 1;
        nVar.j = 1;
        BasePlayerView basePlayerView2 = this.h;
        nVar.a = basePlayerView2 != null ? basePlayerView2.getVideoLength() / 1000 : 0L;
        nVar.b = this.k / 1000;
        BasePlayerView basePlayerView3 = this.h;
        nVar.c = basePlayerView3 != null ? basePlayerView3.getCurrentPosition() / 1000 : 0L;
        long j = this.k;
        nVar.d = j == 0 ? 1 : 0;
        nVar.i = j == 0 ? 1 : 2;
        BasePlayerView basePlayerView4 = this.h;
        nVar.e = (basePlayerView4 == null || basePlayerView4.getCurrentPosition() != this.h.getVideoLength()) ? 0 : 1;
        nVar.k = z ? 0 : 2;
        System.currentTimeMillis();
        BasePlayerView basePlayerView5 = this.h;
        nVar.f = basePlayerView5 != null ? basePlayerView5.getCurrentPosition() : 0L;
        nVar.toString();
        return nVar;
    }
}
