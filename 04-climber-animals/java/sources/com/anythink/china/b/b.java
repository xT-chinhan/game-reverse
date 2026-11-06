package com.anythink.china.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.i;
import com.anythink.core.common.m.b.g;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.o;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.core.common.m.a {
    private static final String d = "b";
    long a;
    long b;
    Map<String, String> c;
    private String e;
    private String f;
    private String g;
    private Context h;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean d_() {
        return true;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME;
    }

    public b(Context context, String str, String str2, Map<String, String> map) {
        this(context, str, str2, map, "");
    }

    private b(Context context, String str, String str2, Map<String, String> map, String str3) {
        this.e = str;
        this.f = str2;
        this.h = context;
        this.c = map;
        this.g = str3;
    }

    @Override // com.anythink.core.common.m.a
    public final void a(int i, q qVar) {
        this.a = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        super.a(i, qVar);
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        i.a();
        return com.anythink.core.common.g.c.a().a(i.l() ? com.anythink.china.a.a.C0072a.b : com.anythink.china.a.a.C0072a.a);
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", Constants.CP_GZIP);
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return this.e;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.h;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return this.f;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", this.e);
            jSONObjectE.put("nw_ver", m.h());
            String strC = t.b().C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectE.put("sy_id", strC);
            }
            String strD = t.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectE.put("bk_id", strD);
            } else {
                t.b().k(t.b().B());
                jSONObjectE.put("bk_id", t.b().B());
            }
            JSONObject jSONObjectA = com.anythink.core.common.m.e.a();
            if (jSONObjectA != null) {
                jSONObjectE.put("custom", jSONObjectA);
            }
            jSONObjectE.put("deny", m.p(t.b().g()));
            if (t.b().z()) {
                jSONObjectE.put("is_test", 1);
            }
            com.anythink.core.common.c.b.a();
            jSONObjectE.put("pil_offset", com.anythink.core.common.c.b.b());
            Map<String, String> map = this.c;
            if (map != null && !map.isEmpty()) {
                try {
                    jSONObjectE.put("cached", new JSONObject(this.c));
                } catch (Throwable unused) {
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                com.anythink.core.common.j.a.a().a(jSONObject);
                if (jSONObject.length() > 0) {
                    jSONObjectE.put(com.anythink.core.common.m.e.bg, jSONObject.toString());
                }
            } catch (Throwable unused2) {
            }
            jSONObjectE.putOpt(com.anythink.core.common.m.e.bh, 1);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObjectE.put(com.anythink.core.common.m.e.bm, this.g);
            }
        } catch (JSONException unused3) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        return super.f();
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        try {
            HashMap map = new HashMap();
            String strA = k.a(e().toString());
            String strA2 = k.a(f().toString());
            String strA3 = k.a(f.a().a(f.a().b()));
            map.put(com.anythink.core.common.m.e.P, o());
            map.put("p", strA);
            map.put(com.anythink.core.common.m.e.W, strA2);
            map.put("p3", strA3);
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
            map.put(com.anythink.core.common.m.e.X, o.c(this.f + sb.toString()));
            return new JSONObject(map).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        com.anythink.core.common.u.e.a("hf", (String) null, this.a, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        com.anythink.core.common.u.e.a("hf", adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a(g.e, this.e);
    }
}
