package com.smartdigimkt.t2;

import android.content.ContentValues;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.smartdigimkt.d3.c b;
    public final /* synthetic */ e c;

    public a(e eVar, String str, com.smartdigimkt.d3.c cVar) {
        this.c = eVar;
        this.a = str;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.c;
        if (eVar.a == null) {
            eVar.a = com.smartdigimkt.z2.q.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        }
        com.smartdigimkt.z2.q qVar = this.c.a;
        String str = this.a;
        com.smartdigimkt.d3.c cVar = this.b;
        synchronized (qVar) {
            if (qVar.b() != null && cVar != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("placement_id", str);
                    contentValues.put(com.anythink.core.common.f.i.a.d, cVar.A);
                    contentValues.put("network_firm_id", Integer.valueOf(cVar.p));
                    contentValues.put(com.anythink.core.common.f.i.a.c, cVar.e);
                    contentValues.put(com.anythink.core.common.f.i.a.f, cVar.a());
                    contentValues.put(com.anythink.core.common.f.i.a.h, Long.valueOf(cVar.r));
                    if (!TextUtils.isEmpty(cVar.y)) {
                        contentValues.put(com.anythink.core.common.f.i.a.g, cVar.y);
                    }
                    if (qVar.a(cVar.e)) {
                        qVar.b().update(com.anythink.core.common.f.i.a.a, contentValues, "bid_id = ? ", new String[]{cVar.e});
                    } else {
                        qVar.b().insert(com.anythink.core.common.f.i.a.a, null, contentValues);
                    }
                } catch (Exception unused) {
                }
            }
        }
        this.c.b.remove(this.a);
        e eVar2 = this.c;
        com.smartdigimkt.d3.c cVar2 = this.b;
        eVar2.getClass();
        if (cVar2 == null || TextUtils.isEmpty(cVar2.y)) {
            return;
        }
        try {
            if (cVar2.p == 67) {
                JSONObject jSONObject = cVar2.R;
                if (jSONObject == null) {
                    jSONObject = new JSONObject(cVar2.y);
                }
                com.smartdigimkt.b3.b bVarA = k.a(cVar2.e, jSONObject, cVar2.y, cVar2.p, true);
                if (bVarA == null) {
                    return;
                }
                com.smartdigimkt.u2.c.a(SDKContext.getInstance().d()).a(bVarA.a, cVar2.r);
                com.smartdigimkt.u2.b.a(SDKContext.getInstance().d()).a(bVarA.b, cVar2.r);
            }
        } catch (Throwable unused2) {
        }
    }
}
