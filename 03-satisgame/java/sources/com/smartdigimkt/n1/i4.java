package com.smartdigimkt.n1;

import android.text.TextUtils;
import android.view.View;
import com.smartdigimkt.sdk.basead.ui.PlayerView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 extends com.smartdigimkt.i0.b0 {
    public final /* synthetic */ PlayerView a;

    public i4(PlayerView playerView) {
        this.a = playerView;
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(com.smartdigimkt.i0.g gVar) {
        boolean z;
        long jF;
        String str;
        String str2 = "Play error and ExoPlayer have not message.";
        if (gVar != null) {
            int i = gVar.a;
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
        PlayerView playerView = this.a;
        if (playerView.W && z) {
            playerView.a0 = str2;
            String str3 = PlayerView.TAG;
            playerView.W = false;
            com.smartdigimkt.q1.k kVar = playerView.o;
            if (kVar != null) {
                kVar.e();
            }
            playerView.t.a(playerView.u);
            return;
        }
        String str4 = PlayerView.TAG;
        synchronized (playerView) {
            playerView.L = null;
            playerView.N = null;
        }
        PlayerView playerView2 = this.a;
        if (playerView2.o != null) {
            try {
                jF = playerView2.t.b.f();
            } catch (Throwable unused) {
                jF = 0;
            }
            String str5 = com.anythink.core.common.inner.b.b.k;
            if (jF <= 0) {
                str5 = com.anythink.core.common.inner.b.b.p;
            }
            String str6 = "videoUrl:" + this.a.x + ",readyRate:" + this.a.S + ",cdRate:" + this.a.R + ",play process:" + jF;
            if (TextUtils.isEmpty(this.a.a0)) {
                str = str6 + ",localFileErrorMsg:" + str2;
            } else {
                str = str6 + ",localFileErrorMsg:" + this.a.a0 + ",errorMsg:" + str2;
            }
            PlayerView playerView3 = this.a;
            if (playerView3.H) {
                playerView3.a(new com.smartdigimkt.h0.g(str5, com.anythink.core.common.inner.b.b.I + str));
            } else {
                playerView3.a(new com.smartdigimkt.h0.g(str5, com.anythink.core.common.inner.b.b.Q + str));
            }
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(int i) {
        String str = PlayerView.TAG;
        if (i == 2) {
            PlayerView playerView = this.a;
            if (!playerView.I) {
                playerView.I = true;
                View view = playerView.T;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            PlayerView playerView2 = this.a;
            PlayerView.a(playerView2, playerView2.t.h());
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            PlayerView playerView3 = this.a;
            synchronized (playerView3) {
                playerView3.L = null;
                playerView3.N = null;
            }
            PlayerView playerView4 = this.a;
            if (playerView4.l) {
                return;
            }
            playerView4.l = true;
            playerView4.y = playerView4.z;
            com.smartdigimkt.q1.k kVar = playerView4.o;
            if (kVar != null) {
                kVar.a();
            }
            this.a.o = null;
            return;
        }
        PlayerView playerView5 = this.a;
        if (!playerView5.H) {
            playerView5.I = false;
            playerView5.z = (int) playerView5.t.h();
            PlayerView playerView6 = this.a;
            com.smartdigimkt.q1.k kVar2 = playerView6.o;
            if (kVar2 != null) {
                kVar2.a(playerView6.z);
            }
            PlayerView playerView7 = this.a;
            playerView7.A = Math.round(playerView7.z * 0.25f);
            PlayerView playerView8 = this.a;
            playerView8.B = Math.round(playerView8.z * 0.5f);
            PlayerView playerView9 = this.a;
            playerView9.C = Math.round(playerView9.z * 0.75f);
            PlayerView playerView10 = this.a;
            PlayerView.a(playerView10, playerView10.z);
            this.a.H = true;
        }
        PlayerView playerView11 = this.a;
        int i2 = playerView11.y;
        if (i2 > 0 && Math.abs(((long) i2) - playerView11.t.b.f()) > 500) {
            PlayerView playerView12 = this.a;
            com.smartdigimkt.i0.i0 i0Var = playerView12.t;
            long j = playerView12.y;
            com.smartdigimkt.j0.c cVar = i0Var.i;
            if (!cVar.d.f) {
                cVar.f();
                cVar.d.f = true;
                Iterator it = cVar.a.iterator();
                if (it.hasNext()) {
                    throw com.smartdigimkt.x.d.a(it);
                }
            }
            i0Var.b.a(j);
        }
        if (this.a.isPlaying()) {
            this.a.a();
        }
    }
}
