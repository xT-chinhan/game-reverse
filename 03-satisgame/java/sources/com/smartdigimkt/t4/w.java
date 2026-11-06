package com.smartdigimkt.t4;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements com.smartdigimkt.j1.u {
    public final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // com.smartdigimkt.j1.u
    public final void a(int i) {
        com.smartdigimkt.b3.b bVar = this.a.b.e;
        if (bVar == null || bVar.e() != 2) {
            return;
        }
        com.smartdigimkt.e1.g gVar = this.a.b;
        com.smartdigimkt.b3.b bVar2 = gVar.e;
        if (bVar2 instanceof com.smartdigimkt.b3.l) {
            com.smartdigimkt.f3.a aVar = gVar.l;
            String str = bVar2.c0;
            String str2 = bVar2.a;
            com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
            cVar.a = "1004709";
            cVar.a(aVar);
            cVar.l = String.valueOf(aVar.P);
            cVar.m = aVar.Q;
            cVar.n = aVar.d;
            cVar.o = str;
            cVar.p = str2;
            cVar.q = String.valueOf(i);
            cVar.r = "1";
            com.smartdigimkt.n3.k.a(cVar);
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdClick(com.smartdigimkt.j1.w wVar) {
        this.a.a("click", "success", "", null);
        com.smartdigimkt.h1.k kVar = this.a.c;
        if (kVar.b.p == 67) {
            if (kVar.a(true, false)) {
                com.smartdigimkt.u2.c.a(SDKContext.getInstance().d()).a(this.a.c.b.a, 1, 0);
            }
            if (this.a.c.a(false, false)) {
                com.smartdigimkt.u2.b.a(SDKContext.getInstance().d()).a(this.a.c.b.a, 1, 0);
            }
        }
        if (x.a(this.a)) {
            this.a.g.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdClosed() {
        this.a.a(ILivePush.ClickType.CLOSE, "success", "", null);
        if (x.a(this.a)) {
            this.a.g.onAdClosed();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdShow(com.smartdigimkt.j1.w wVar) {
        this.a.a("impression", "success", "", null);
        x xVar = this.a;
        if (xVar.b.e.p == 67) {
            if (xVar.c.a(true, true)) {
                com.smartdigimkt.u2.c.a(SDKContext.getInstance().d()).a(this.a.c.b.a, 0, 1);
            }
            if (this.a.c.a(false, true)) {
                com.smartdigimkt.u2.b.a(SDKContext.getInstance().d()).a(this.a.c.b.a, 0, 1);
            }
        }
        if (x.a(this.a)) {
            this.a.g.onAdShow();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onShowFailed(com.smartdigimkt.h0.g gVar) {
        String str = gVar != null ? gVar.b : "";
        this.a.a("show_failed", "fail", gVar != null ? gVar.a() : "", new com.smartdigimkt.z3.a(gVar != null ? gVar.a : "", str));
        if (x.a(this.a)) {
            if (gVar != null) {
                this.a.g.onShowFailed(com.smartdigimkt.z3.b.a("20002", gVar.b));
            } else {
                this.a.g.onShowFailed(com.smartdigimkt.z3.b.a("20002", ""));
            }
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onDeeplinkCallback(boolean z) {
        this.a.a(SDMAdConst.NETWORK_CUSTOM_KEY.DEEPLINK, z ? "success" : "fail", "", null);
        if (x.a(this.a)) {
            this.a.g.onDeeplinkCallback(z);
        }
    }
}
