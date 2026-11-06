package com.smartdigimkt.g1;

import com.smartdigimkt.j1.d;
import com.smartdigimkt.j1.e;
import com.smartdigimkt.j1.g;
import com.smartdigimkt.j1.w;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public final /* synthetic */ String d;
    public final /* synthetic */ c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Map map, String str, String str2) {
        super(str, map);
        this.e = cVar;
        this.d = str2;
    }

    @Override // com.smartdigimkt.j1.d
    public final void a() {
        if (!this.c) {
            this.c = true;
            Map map = this.a;
            if (map != null) {
                map.put(com.anythink.core.common.a.b.C0013b.a, Integer.valueOf(this.b));
            }
        }
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar != null) {
            aVar.onAdClosed();
        }
        e eVar = com.smartdigimkt.j1.b.a;
        eVar.a.remove(this.d);
    }

    @Override // com.smartdigimkt.j1.d
    public final void b() {
    }

    @Override // com.smartdigimkt.j1.d
    public final void b(w wVar) {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar != null) {
            aVar.onAdShow(wVar);
        }
        this.e.a = null;
    }

    @Override // com.smartdigimkt.j1.d
    public final void d() {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar == null || !(aVar instanceof g)) {
            return;
        }
        ((g) aVar).onVideoAdPlayEnd();
    }

    @Override // com.smartdigimkt.j1.d
    public final void e() {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar == null || !(aVar instanceof g)) {
            return;
        }
        ((g) aVar).onVideoAdPlayStart();
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(com.smartdigimkt.h0.g gVar) {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar != null) {
            aVar.onShowFailed(gVar);
        }
        this.e.a = null;
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(w wVar) {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar != null) {
            aVar.onAdClick(wVar);
        }
    }

    @Override // com.smartdigimkt.j1.d
    public final void a(boolean z) {
        com.smartdigimkt.j1.a aVar = this.e.c;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }
}
