package com.smartdigimkt.k1;

import com.smartdigimkt.j1.w;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.smartdigimkt.j1.d {
    public final /* synthetic */ String d;
    public final /* synthetic */ n e;

    public m(n nVar, String str) {
        this.e = nVar;
        this.d = str;
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(com.smartdigimkt.h0.g gVar) {
        gVar.a();
        com.smartdigimkt.j1.g gVar2 = this.e.i;
        if (gVar2 != null) {
            gVar2.onShowFailed(gVar);
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void b(w wVar) {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onAdShow(wVar);
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void d() {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onVideoAdPlayEnd();
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void e() {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onVideoAdPlayStart();
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void b() {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onRewarded();
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void a() {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onAdClosed();
        }
        com.smartdigimkt.j1.e eVar = com.smartdigimkt.j1.b.a;
        eVar.a.remove(this.d);
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(w wVar) {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onAdClick(wVar);
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(boolean z) {
        com.smartdigimkt.j1.g gVar = this.e.i;
        if (gVar != null) {
            gVar.onDeeplinkCallback(z);
        }
    }
}
