package com.smartdigimkt.s3;

import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.v2.p;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ com.smartdigimkt.h3.b a;
    public final /* synthetic */ ISDMAdManager.S2SBidTokenCallback b;

    public e(Map map, com.smartdigimkt.h3.b bVar, ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback) {
        this.a = bVar;
        this.b = s2SBidTokenCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        Object obj = j.a;
        try {
            JSONObject jSONObjectB = j.b();
            if (jSONObjectB == null) {
                com.smartdigimkt.h3.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                com.smartdigimkt.q3.f.a().c(new i(this.b, ""));
                return;
            }
            String strF = com.smartdigimkt.r4.e.f(jSONObjectB.toString());
            if (j.d(jSONObjectB)) {
                j.a(strF);
                if (j.d(jSONObjectB)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObjectB.optString("oaid", "")).append('|');
                    sb.append(jSONObjectB.optJSONArray(com.anythink.core.common.l.f.am).toString()).append('|');
                    j.a(sb);
                    string = sb.toString();
                } else {
                    string = "";
                }
                j.h = string;
                j.d.set(false);
                com.smartdigimkt.h3.b bVar2 = this.a;
                if (bVar2 != null) {
                    synchronized (bVar2) {
                    }
                }
            } else {
                j.d.set(true);
                if (j.e.compareAndSet(false, true)) {
                    p.c().a(new g(), (com.smartdigimkt.h3.b) null, "s2sToken");
                }
            }
            com.smartdigimkt.h3.b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.b();
            }
            com.smartdigimkt.q3.f.a().c(new i(this.b, strF));
        } catch (Throwable th) {
            th.getMessage();
            com.smartdigimkt.h3.b bVar4 = this.a;
            Object obj2 = j.a;
            if (bVar4 != null) {
                bVar4.b();
            }
            com.smartdigimkt.q3.f.a().c(new i(this.b, ""));
        }
    }
}
