package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 {
    public final /* synthetic */ BaseScreenATView a;

    public f1(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    public final void a(List list) {
        com.smartdigimkt.u1.d dVar;
        com.smartdigimkt.u1.d dVar2;
        if (this.a.P == 5 && (list == null || list.size() == 0)) {
            this.a.P = 1;
        }
        if (this.a.P == 2 && !com.smartdigimkt.m1.d.a().c(com.anythink.core.common.a.b.d.i)) {
            this.a.P = 1;
        }
        this.a.a(list);
        BaseScreenATView baseScreenATView = this.a;
        if (!baseScreenATView.U || (dVar = baseScreenATView.n) == null) {
            return;
        }
        BasePlayerView basePlayerView = dVar.h;
        if ((basePlayerView == null || !basePlayerView.isPlaying()) && (dVar2 = this.a.n) != null) {
            dVar2.d();
        }
    }
}
