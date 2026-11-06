package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.smartdigimkt.z.s;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends d {
    public final JSONObject c;
    public final int d;
    public final com.smartdigimkt.b3.l e;

    public k(int i, com.smartdigimkt.b3.l lVar, String str, LinkedHashMap linkedHashMap) {
        this.d = i;
        this.e = lVar;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.c = new JSONObject(str);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                this.c.put((String) entry.getKey(), entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        com.smartdigimkt.b3.e eVar;
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        com.smartdigimkt.b3.l lVar = this.e;
        if (lVar != null && (eVar = lVar.w) != null && s.a(eVar, this.d)) {
            String strN = com.smartdigimkt.r4.h.n();
            if (!TextUtils.isEmpty(strN)) {
                map.put(RequestParamsUtils.USER_AGENT_KEY, strN);
            }
        }
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return d.a(this.c.toString());
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.c3.a aVar;
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        String str = "";
        if (aVarA != null && (aVar = aVarA.D) != null) {
            str = aVar.c;
        }
        return TextUtils.isEmpty(str) ? "https://adx-tk-sz.statisticslinks.com/v1" : str;
    }
}
