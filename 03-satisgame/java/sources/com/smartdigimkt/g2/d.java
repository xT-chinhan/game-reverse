package com.smartdigimkt.g2;

import android.text.TextUtils;
import com.smartdigimkt.i0.b0;
import com.smartdigimkt.i0.g;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimplePlayer;
import com.smartdigimkt.x1.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b0 {
    public final /* synthetic */ SimplePlayer a;

    public d(SimplePlayer simplePlayer) {
        this.a = simplePlayer;
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(g gVar) {
        boolean z;
        if (gVar != null) {
            z = gVar.a == 0;
            if (gVar.getCause() != null && !TextUtils.isEmpty(gVar.getCause().getMessage())) {
                gVar.getCause().getMessage();
            }
        } else {
            z = false;
        }
        SimplePlayer simplePlayer = this.a;
        if (!simplePlayer.f || !z) {
            String str = SimplePlayer.TAG;
            return;
        }
        String str2 = SimplePlayer.TAG;
        simplePlayer.f = false;
        simplePlayer.a.a(simplePlayer.b);
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(int i) {
        String str = SimplePlayer.TAG;
        if (i != 3) {
            return;
        }
        SimplePlayer simplePlayer = this.a;
        simplePlayer.i = true;
        f fVar = simplePlayer.j;
        if (fVar != null) {
            ((q) fVar).a.s = true;
        }
    }
}
