package com.smartdigimkt.n1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class e4 extends Handler {
    public final /* synthetic */ PlayerView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e4(PlayerView playerView, Looper looper) {
        super(looper);
        this.a = playerView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        com.smartdigimkt.q1.k kVar;
        PlayerView playerView = this.a;
        String str = PlayerView.TAG;
        com.smartdigimkt.q1.k kVar2 = playerView.o;
        if (kVar2 == null) {
            return;
        }
        playerView.y = message.what;
        if (!playerView.G && !playerView.l) {
            playerView.G = true;
            if (kVar2 != null) {
                kVar2.f();
            }
        }
        PlayerView playerView2 = this.a;
        com.smartdigimkt.q1.k kVar3 = playerView2.o;
        if (kVar3 != null) {
            kVar3.b(playerView2.y);
        }
        PlayerView playerView3 = this.a;
        if (!playerView3.D && playerView3.y >= playerView3.A) {
            playerView3.D = true;
            com.smartdigimkt.q1.k kVar4 = playerView3.o;
            if (kVar4 != null) {
                kVar4.a(25);
            }
        } else if (!playerView3.E && playerView3.y >= playerView3.B) {
            playerView3.E = true;
            com.smartdigimkt.q1.k kVar5 = playerView3.o;
            if (kVar5 != null) {
                kVar5.a(50);
            }
        } else if (!playerView3.F && playerView3.y >= playerView3.C) {
            playerView3.F = true;
            com.smartdigimkt.q1.k kVar6 = playerView3.o;
            if (kVar6 != null) {
                kVar6.a(75);
            }
        }
        PlayerView playerView4 = this.a;
        if (playerView4.b0 || !playerView4.P || playerView4.y < playerView4.Q || (kVar = playerView4.o) == null) {
            return;
        }
        playerView4.P = false;
        kVar.e();
    }
}
