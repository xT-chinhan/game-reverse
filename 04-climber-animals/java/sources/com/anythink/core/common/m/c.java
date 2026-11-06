package com.anythink.core.common.m;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    private final com.anythink.core.common.h.t a;
    private long b;
    private long c;

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
    protected final int l() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME;
    }

    public c(com.anythink.core.common.h.t tVar) {
        this.a = tVar;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.q();
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
        com.anythink.core.common.h.t tVar = this.a;
        return tVar != null ? tVar.b() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return com.anythink.core.common.d.t.b().g();
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        com.anythink.core.common.h.t tVar = this.a;
        return tVar != null ? tVar.c() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return Collections.emptyMap();
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        com.anythink.core.common.u.e.a(com.anythink.core.d.b.a.A, adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        com.anythink.core.common.u.e.a(com.anythink.core.d.b.a.A, (String) null, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.c, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    public final void a(int i, q qVar) {
        this.b = System.currentTimeMillis();
        this.c = SystemClock.elapsedRealtime();
        super.a(i, qVar);
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        try {
            HashMap map = new HashMap();
            String strA = com.anythink.core.common.v.k.a(e().toString());
            String strA2 = com.anythink.core.common.v.k.a(f().toString());
            map.put(e.P, o());
            map.put("p", strA);
            map.put(e.W, strA2);
            com.anythink.core.common.h.t tVar = this.a;
            byte[] bArrA = tVar != null ? tVar.a() : null;
            if (bArrA != null && bArrA.length > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enc_d", new String(bArrA));
                map.put("p3", com.anythink.core.common.v.k.a(jSONObject.toString()));
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
            map.put(e.X, com.anythink.core.common.v.o.c(j() + sb.toString()));
            return new JSONObject(map).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            com.anythink.core.common.h.t tVar = this.a;
            jSONObjectE.put("app_id", tVar != null ? tVar.b() : "");
            jSONObjectE.put("nw_ver", com.anythink.core.common.v.m.h());
            String strC = com.anythink.core.common.d.t.b().C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectE.put("sy_id", strC);
            }
            String strD = com.anythink.core.common.d.t.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectE.put("bk_id", strD);
            } else {
                com.anythink.core.common.d.t.b().k(com.anythink.core.common.d.t.b().B());
                jSONObjectE.put("bk_id", com.anythink.core.common.d.t.b().B());
            }
            JSONObject jSONObjectA = e.a();
            if (jSONObjectA != null) {
                jSONObjectE.put("custom", jSONObjectA);
            }
            jSONObjectE.put("deny", com.anythink.core.common.v.m.p(com.anythink.core.common.d.t.b().g()));
            if (com.anythink.core.common.d.t.b().z()) {
                jSONObjectE.put("is_test", 1);
            }
            com.anythink.core.common.c.b.a();
            jSONObjectE.put("pil_offset", com.anythink.core.common.c.b.b());
            try {
                JSONObject jSONObject = new JSONObject();
                com.anythink.core.common.j.a.a().a(jSONObject);
                if (jSONObject.length() > 0) {
                    jSONObjectE.put(e.bg, jSONObject.toString());
                }
            } catch (Throwable unused) {
            }
            jSONObjectE.putOpt(e.bh, 1);
            jSONObjectE.put(e.bp, com.anythink.core.common.d.t.b().E());
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.t.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectE.put(e.bq, ((Integer) pairI.first).intValue());
            }
        } catch (Throwable unused2) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final List<String> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.j.aa.a);
        return arrayList;
    }
}
