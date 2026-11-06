package com.anythink.core.common.l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    private final com.anythink.core.common.h.t a;
    private long b;
    private long c;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
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

    public d(com.anythink.core.common.h.t tVar) {
        this.a = tVar;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.m();
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", "gzip");
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
    protected final String e() {
        com.anythink.core.common.h.t tVar = this.a;
        return tVar != null ? tVar.b() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return com.anythink.core.common.d.s.b().g();
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        com.anythink.core.common.h.t tVar = this.a;
        return tVar != null ? tVar.c() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return Collections.emptyMap();
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        String platformCode = adError.getPlatformCode();
        String platformMSG = adError.getPlatformMSG();
        com.anythink.core.common.i.a();
        com.anythink.core.common.t.f.a(com.anythink.core.e.b.a.z, platformCode, platformMSG, com.anythink.core.common.i.m(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        com.anythink.core.common.t.f.a(com.anythink.core.e.b.a.z, (String) null, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.c, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.b = System.currentTimeMillis();
        this.c = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        try {
            HashMap map = new HashMap();
            String strA = com.anythink.core.common.u.j.a(i().toString());
            String strA2 = com.anythink.core.common.u.j.a(j().toString());
            map.put(f.P, q());
            map.put(f.W, strA);
            map.put(f.X, strA2);
            com.anythink.core.common.h.t tVar = this.a;
            byte[] bArrA = tVar != null ? tVar.a() : null;
            if (bArrA != null && bArrA.length > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enc_d", new String(bArrA));
                map.put("p3", com.anythink.core.common.u.j.a(jSONObject.toString()));
            }
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
            map.put(f.Y, com.anythink.core.common.u.n.c(g() + sb.toString()));
            return new JSONObject(map).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            com.anythink.core.common.h.t tVar = this.a;
            jSONObjectI.put("app_id", tVar != null ? tVar.b() : "");
            jSONObjectI.put("nw_ver", com.anythink.core.common.u.l.h());
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
            JSONObject jSONObjectA = f.a();
            if (jSONObjectA != null) {
                jSONObjectI.put("custom", jSONObjectA);
            }
            jSONObjectI.put("deny", com.anythink.core.common.u.l.m(com.anythink.core.common.d.s.b().g()));
            if (com.anythink.core.common.d.s.b().A()) {
                jSONObjectI.put("is_test", 1);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                com.anythink.core.common.i.a.a().a(jSONObject);
                if (jSONObject.length() > 0) {
                    jSONObjectI.put(f.bj, jSONObject.toString());
                }
            } catch (Throwable unused) {
            }
            jSONObjectI.putOpt(f.bk, 1);
            jSONObjectI.put(f.bB, com.anythink.core.common.d.s.b().F());
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectI.put(f.bC, ((Integer) pairI.first).intValue());
            }
        } catch (Throwable unused2) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        return arrayList;
    }
}
