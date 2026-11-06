package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public a(com.smartdigimkt.a3.a aVar) {
        this.c = aVar.j;
        this.d = aVar.g;
        this.e = aVar.b;
        this.f = aVar.p;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            jSONObjectB.put(com.anythink.core.common.l.f.bn, this.e);
            jSONObjectB.put(com.anythink.core.common.l.f.bo, SDKContext.getInstance().b(this.e));
            String strG = SDKContext.getInstance().g();
            if (!TextUtils.isEmpty(strG)) {
                jSONObjectB.put("sy_id", strG);
            }
            jSONObjectB.put("deny", com.smartdigimkt.r4.h.q(SDKContext.getInstance().d()));
        } catch (Exception unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return 34;
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        map.put("Accept-Encoding", "gzip");
        map.remove("Content-Encoding");
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final HttpReqEntity f() {
        return HttpReqEntity.create("request");
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        String strI = i();
        if (TextUtils.isEmpty(strI)) {
            return new byte[0];
        }
        try {
            return strI.getBytes("utf-8");
        } catch (Throwable unused) {
            return strI.getBytes();
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final String i() {
        HashMap map = new HashMap();
        String strB = com.smartdigimkt.r4.e.b(b().toString());
        String strB2 = com.smartdigimkt.r4.e.b(com.smartdigimkt.a4.a.a(34, (List) null).toString());
        map.put(com.anythink.core.common.l.f.W, strB);
        map.put(com.anythink.core.common.l.f.X, strB2);
        map.put("request_id", this.d);
        map.put(com.anythink.core.common.f.i.a.c, this.c);
        return new JSONObject(map).toString();
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.c3.a aVar;
        if (!TextUtils.isEmpty(this.f)) {
            return this.f;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        String str = "";
        if (aVarA != null && (aVar = aVarA.D) != null) {
            str = aVar.a;
        }
        return TextUtils.isEmpty(str) ? "https://adx-micro.statisticslinks.com/request" : str;
    }
}
