package com.anythink.core.e;

import android.util.Log;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bo;

/* JADX INFO: loaded from: classes.dex */
public class m implements com.anythink.core.common.l.s {
    private static final String a = "m";
    private final n b;
    private final bo c;
    private final n.b d;
    private final l e;
    private com.anythink.core.common.s.a f;
    private boolean[] g;
    private com.anythink.core.common.u.b.d h;

    public m(n nVar, bo boVar, n.b bVar, l lVar) {
        this.b = nVar;
        this.c = boVar;
        this.d = bVar;
        this.e = lVar;
    }

    public m(n nVar, bo boVar, n.b bVar, l lVar, com.anythink.core.common.s.a aVar, com.anythink.core.common.u.b.d dVar, boolean[] zArr) {
        this.b = nVar;
        this.c = boVar;
        this.d = bVar;
        this.f = aVar;
        this.g = zArr;
        this.h = dVar;
        this.e = lVar;
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadStart(int i) {
        n.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadFinish(int i, Object obj) {
        a();
        n.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.a(i, obj, this.c, this.d, this.g, this.e);
        }
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadError(int i, String str, AdError adError) {
        n.b bVar;
        a();
        if (this.c != null) {
            if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                this.c.b();
                this.c.d();
                this.c.c();
                if (com.anythink.core.common.d.s.b().G()) {
                    Log.e("anythink", "Please check these params in your code (AppId: " + this.c.b() + ", AppKey: " + this.c.c() + ", PlacementId: " + this.c.d() + ")");
                }
            }
            if ("699".equals(adError.getPlatformCode())) {
                this.b.a(this.c.b(), this.c.d(), this.e);
                n.b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.a(adError);
                    return;
                }
                return;
            }
        }
        l lVar = this.e;
        if (lVar == null && (bVar = this.d) != null) {
            bVar.a(adError);
            return;
        }
        n.b bVar3 = this.d;
        if (bVar3 != null) {
            bVar3.a(lVar);
        }
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadCanceled(int i) {
        a();
        n.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        l lVar = this.e;
        if (lVar == null) {
            bVar.a(ErrorCode.getErrorCode(ErrorCode.exception, "", "by canceled"));
        } else {
            bVar.a(lVar);
        }
    }

    private void a() {
        com.anythink.core.common.u.b.d dVar;
        com.anythink.core.common.s.a aVar = this.f;
        if (aVar == null || (dVar = this.h) == null) {
            return;
        }
        aVar.a(dVar);
    }
}
