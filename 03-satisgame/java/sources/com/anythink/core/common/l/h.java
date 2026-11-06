package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h extends b {
    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean m() {
        return true;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.g.c.a().a(com.anythink.core.common.i.h() ? com.anythink.core.common.d.i.e.P : com.anythink.core.common.d.i.e.u);
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        try {
            return k().getBytes("utf-8");
        } catch (Exception unused) {
            return k().getBytes();
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", com.anythink.core.common.d.s.b().p());
            jSONObjectI.put("curr_ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.u.j.a(i().toString());
        map.put(f.P, "1.0");
        map.put(f.W, strA);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        try {
            map.put(f.Y, URLEncoder.encode(com.anythink.core.common.u.n.c(com.anythink.core.common.d.s.b().q() + sb.toString()), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new JSONObject(map).toString();
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return com.anythink.core.common.d.s.b().p();
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return com.anythink.core.common.d.s.b().q();
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a(com.anythink.core.common.l.c.g.d);
    }
}
