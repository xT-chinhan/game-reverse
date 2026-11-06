package com.smartdigimkt.o4;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.smartdigimkt.a4.b {
    public final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        this.a.c = false;
        e eVar = this.a;
        eVar.getClass();
        if (obj instanceof JSONObject) {
            try {
                com.smartdigimkt.p4.a aVarA = eVar.a((JSONObject) obj);
                if (aVarA != null) {
                    eVar.b = aVarA;
                    e.e();
                    com.smartdigimkt.v3.f.a().a(SDKContext.getInstance().d());
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.a.c = false;
    }
}
