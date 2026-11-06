package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public final int c;
    public final List d;

    public b(int i, ArrayList arrayList) {
        this.c = i;
        this.d = arrayList;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            JSONArray jSONArray = new JSONArray();
            List list = this.d;
            if (list != null && !list.isEmpty()) {
                for (String str : this.d) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(new JSONObject(str));
                    }
                }
            }
            jSONObjectB.put(com.anythink.core.common.l.f.R, jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return 4;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject g() {
        JSONObject jSONObjectA = com.smartdigimkt.a4.a.a(4, (List) null);
        try {
            jSONObjectA.put(com.anythink.core.common.l.f.S, this.c);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return d.a(i());
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        String str = aVarA != null ? aVarA.m : "";
        return TextUtils.isEmpty(str) ? "https://da.statisticslinks.com/v1/open/da" : str;
    }
}
