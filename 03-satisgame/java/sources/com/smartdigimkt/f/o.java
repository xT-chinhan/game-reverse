package com.smartdigimkt.f;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.AdError;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.a4.b {
    public final /* synthetic */ long a;
    public final /* synthetic */ r b;

    public o(r rVar, long j) {
        this.b = rVar;
        this.a = j;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
        this.b.e = true;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        Objects.toString(obj);
        try {
            this.b.e = false;
            if (!(obj instanceof String) || TextUtils.isEmpty((String) obj)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(String.valueOf(obj));
            if (jSONObject.getInt("code") == 200) {
                String.valueOf(com.anythink.core.common.g.c.a);
                com.smartdigimkt.n3.k.a("1", "", "", "1", "", this.a);
                JSONArray jSONArrayOptJSONArray = new JSONObject(com.smartdigimkt.r4.e.d(jSONObject.getString(com.anythink.core.common.l.f.R))).optJSONArray("pg_items");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
                this.b.c = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    this.b.a(jSONArrayOptJSONArray.getJSONObject(i2));
                }
                return;
            }
            String string = jSONObject.toString();
            String.valueOf(com.anythink.core.common.g.c.a);
            com.smartdigimkt.n3.k.a("1", "", "", "2", string, this.a);
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.b.e = false;
        String errorInfo = adError.getErrorInfo();
        String.valueOf(com.anythink.core.common.g.c.a);
        com.smartdigimkt.n3.k.a("1", "", "", "2", errorInfo, this.a);
        s sVar = this.b.a;
        if (sVar != null) {
            u.a(sVar.a, new ArrayList());
        }
    }
}
