package com.smartdigimkt.o4;

import android.content.ContentValues;
import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ e b;

    public d(e eVar, JSONObject jSONObject) {
        this.b = eVar;
        this.a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.getClass();
        com.smartdigimkt.z2.e eVarA = com.smartdigimkt.z2.e.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        String strA = SDKContext.getInstance().a();
        String string = this.a.toString();
        synchronized (eVarA) {
            if (eVarA.b() == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(com.anythink.core.common.f.e.a.b, strA);
                contentValues.put("type", com.anythink.core.common.d.t.a.k);
                contentValues.put(com.anythink.core.common.f.e.a.d, string);
                contentValues.put(com.anythink.core.common.f.e.a.e, System.currentTimeMillis() + "");
                if (eVarA.a(strA)) {
                    eVarA.b().update("sdkconfig", contentValues, "key = ? AND type = ?", new String[]{strA, com.anythink.core.common.d.t.a.k});
                } else {
                    eVarA.b().insert("sdkconfig", null, contentValues);
                }
            } catch (Exception unused) {
            }
        }
    }
}
