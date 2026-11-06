package com.anythink.core.d;

import android.util.Log;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bm;
import com.anythink.core.common.v.af;

/* JADX INFO: loaded from: classes.dex */
public class m implements com.anythink.core.common.m.q {
    private static final String a = "m";
    private final n b;
    private final bm c;
    private final n.b d;
    private final l e;
    private com.anythink.core.common.t.a f;
    private boolean[] g;
    private com.anythink.core.common.t.b h;

    public m(n nVar, bm bmVar, n.b bVar, l lVar) {
        this.b = nVar;
        this.c = bmVar;
        this.d = bVar;
        this.e = lVar;
    }

    public m(n nVar, bm bmVar, n.b bVar, l lVar, com.anythink.core.common.t.a aVar, com.anythink.core.common.t.b bVar2, boolean[] zArr) {
        this.b = nVar;
        this.c = bmVar;
        this.d = bVar;
        this.f = aVar;
        this.g = zArr;
        this.h = bVar2;
        this.e = lVar;
    }

    @Override // com.anythink.core.common.m.q
    public void onLoadStart(int i) {
        n.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.anythink.core.common.m.q
    public void onLoadFinish(int i, Object obj) {
        a();
        n.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.a(obj, this.c, this.d, this.g, this.e);
        }
    }

    @Override // com.anythink.core.common.m.q
    public void onLoadError(int i, String str, AdError adError) {
        n.b bVar;
        a();
        if (this.c != null) {
            if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                String str2 = this.c.b() + this.c.d() + this.c.c();
                adError.getPlatformCode();
                adError.getPlatformMSG();
                af.a(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.j, str2, System.currentTimeMillis());
                if (com.anythink.core.common.d.t.b().F()) {
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
        } else if (this.d != null) {
            if (lVar.bl()) {
                this.d.a(adError);
            } else {
                this.d.a(this.e);
            }
        }
    }

    @Override // com.anythink.core.common.m.q
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
        com.anythink.core.common.t.b bVar;
        com.anythink.core.common.t.a aVar = this.f;
        if (aVar == null || (bVar = this.h) == null) {
            return;
        }
        aVar.b(bVar);
    }
}
