package com.anythink.china.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.i;
import com.anythink.core.common.l.s;
import com.anythink.core.common.u.j;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.core.common.l.b {
    private static final String l = "b";
    long a;
    long b;
    Map<String, String> c;
    private String m;
    private String n;
    private String o;
    private Context p;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
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
    protected final int n() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT;
    }

    public b(Context context, String str, String str2, Map<String, String> map) {
        this(context, str, str2, map, "");
    }

    private b(Context context, String str, String str2, Map<String, String> map, String str3) {
        this.m = str;
        this.n = str2;
        this.p = context;
        this.c = map;
        this.o = str3;
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.a = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        i.a();
        return com.anythink.core.common.g.c.a().a(i.h() ? com.anythink.china.b.a.C0008a.b : com.anythink.china.b.a.C0008a.a, "");
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
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
    protected final String e() {
        return this.m;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.p;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.n;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", this.m);
            jSONObjectI.put("nw_ver", l.h());
            String strD = com.anythink.core.common.d.s.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectI.put("sy_id", strD);
            }
            String strE = com.anythink.core.common.d.s.b().E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObjectI.put("bk_id", strE);
            } else {
                com.anythink.core.common.d.s.b().k(com.anythink.core.common.d.s.b().C());
                jSONObjectI.put("bk_id", com.anythink.core.common.d.s.b().C());
            }
            JSONObject jSONObjectA = com.anythink.core.common.l.f.a();
            if (jSONObjectA != null) {
                jSONObjectI.put("custom", jSONObjectA);
            }
            jSONObjectI.put("deny", l.m(com.anythink.core.common.d.s.b().g()));
            if (com.anythink.core.common.d.s.b().A()) {
                jSONObjectI.put("is_test", 1);
            }
            Map<String, String> map = this.c;
            if (map != null && !map.isEmpty()) {
                try {
                    jSONObjectI.put("cached", new JSONObject(this.c));
                } catch (Throwable unused) {
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                com.anythink.core.common.i.a.a().a(jSONObject);
                if (jSONObject.length() > 0) {
                    jSONObjectI.put(com.anythink.core.common.l.f.bj, jSONObject.toString());
                }
            } catch (Throwable unused2) {
            }
            jSONObjectI.putOpt(com.anythink.core.common.l.f.bk, 1);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObjectI.put(com.anythink.core.common.l.f.bp, this.o);
            }
        } catch (JSONException unused3) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject j() {
        return super.j();
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        try {
            HashMap map = new HashMap();
            String strA = j.a(i().toString());
            String strA2 = j.a(j().toString());
            String strA3 = j.a(g.a().a(g.a().b()));
            map.put(com.anythink.core.common.l.f.P, q());
            map.put(com.anythink.core.common.l.f.W, strA);
            map.put(com.anythink.core.common.l.f.X, strA2);
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
            map.put(com.anythink.core.common.l.f.Y, n.c(this.n + sb.toString()));
            return new JSONObject(map).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        com.anythink.core.common.t.f.a("hf", (String) null, this.a, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        com.anythink.core.common.t.f.a("hf", adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a("get_plugin", this.m);
    }
}
