package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.gopherhole.androidvibrate.BuildConfig;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.SDMAdxSetting;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends d {
    public final String c;
    public final String d;
    public final com.smartdigimkt.p4.e e;
    public final boolean f;
    public final boolean g;
    public final ArrayList h;
    public final l i;
    public final String j;
    public final String k;

    public e(String str, String str2, com.smartdigimkt.p4.e eVar, List list, boolean z, boolean z2) {
        String str3 = "";
        this.j = "";
        this.k = "";
        this.c = str;
        this.d = str2;
        this.e = eVar;
        this.f = z;
        this.g = z2;
        this.h = list == null ? new ArrayList() : new ArrayList(list);
        this.i = new l(str2);
        if (eVar != null) {
            try {
                str3 = eVar.B;
            } catch (Throwable unused) {
                return;
            }
        }
        this.j = com.smartdigimkt.r4.e.a(str3.getBytes());
        this.k = com.smartdigimkt.r4.e.a(new JSONObject().toString().getBytes());
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObject;
        JSONObject jSONObjectB = super.b();
        com.smartdigimkt.p4.e eVar = this.e;
        String str = eVar != null ? eVar.e : "";
        try {
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            jSONObjectB.put(com.anythink.core.common.l.f.bn, str);
            jSONObjectB.put(com.anythink.core.common.l.f.bo, SDKContext.getInstance().b(str));
            String strG = SDKContext.getInstance().g();
            if (!TextUtils.isEmpty(strG)) {
                jSONObjectB.put("sy_id", strG);
            }
            String strC = SDKContext.getInstance().c();
            if (TextUtils.isEmpty(strC)) {
                String strH = SDKContext.getInstance().h();
                SDKContext sDKContext = SDKContext.getInstance();
                sDKContext.x = strH;
                y.a(sDKContext.c, t.b.f, t.a.C, strH);
                jSONObjectB.put("bk_id", strH);
            } else {
                jSONObjectB.put("bk_id", strC);
            }
            jSONObjectB.put("deny", com.smartdigimkt.r4.h.q(SDKContext.getInstance().d()));
            com.smartdigimkt.s2.a.a().getClass();
            jSONObjectB.put("misk_spt", -1);
            com.smartdigimkt.s2.a.a().getClass();
            jSONObjectB.put("misk_pt_det", "");
            com.smartdigimkt.a4.a.a(jSONObjectB);
            com.smartdigimkt.p4.e eVar2 = this.e;
            if (eVar2 != null && (jSONObject = eVar2.x) != null) {
                jSONObjectB.put(com.anythink.core.e.l.a.aa, jSONObject);
            }
            if (SDMAdxSetting.getInstance().isAdxNetworkMode(str)) {
                jSONObjectB.put(com.anythink.core.common.l.f.bh, 1);
            }
            jSONObjectB.put("bid_ver", 1);
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            if (bVarE != null) {
                bVarE.fillRequestDataForDl(jSONObjectB);
            }
        } catch (Throwable unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT;
    }

    @Override // com.smartdigimkt.g4.d
    public final List d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        return arrayList;
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        map.put("Accept-Encoding", "gzip");
        map.put("KY-V", "UA_6.5.90");
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final HttpReqEntity f() {
        return HttpReqEntity.create("bid");
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject g() {
        return com.smartdigimkt.a4.a.a(MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, d());
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        String strI = i();
        return TextUtils.isEmpty(strI) ? new byte[0] : d.a(strI);
    }

    @Override // com.smartdigimkt.g4.d
    public final String i() {
        String string = this.i.b().toString();
        this.i.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        String string2 = com.smartdigimkt.a4.a.a(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, arrayList).toString();
        HashMap map = new HashMap();
        String strB = com.smartdigimkt.r4.e.b(string);
        String strB2 = com.smartdigimkt.r4.e.b(string2);
        map.put(com.anythink.core.common.l.f.W, strB);
        map.put(com.anythink.core.common.l.f.X, strB2);
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> arrayList2 = new ArrayList();
        arrayList2.add(com.anythink.core.common.l.f.P);
        arrayList2.add(com.anythink.core.common.l.f.W);
        arrayList2.add(com.anythink.core.common.l.f.X);
        Collections.sort(arrayList2);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList2) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str).append("=");
            if (com.anythink.core.common.l.f.P.equals(str)) {
                sb.append("1.0");
            } else if (com.anythink.core.common.l.f.W.equals(str)) {
                sb.append(strB);
            } else {
                sb.append(strB2);
            }
        }
        String strA = com.smartdigimkt.r4.i.a(SDKContext.getInstance().b() + ((Object) sb));
        Iterator it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    com.smartdigimkt.p4.e eVar = this.e;
                    if (eVar != null) {
                        com.smartdigimkt.p4.g gVarA = eVar.a();
                        String str2 = gVarA != null ? gVarA.r : "";
                        if (TextUtils.isEmpty(str2)) {
                            jSONObject2.remove("unit_id");
                            jSONObject2.remove("ad_source_id");
                        } else {
                            jSONObject2.put("unit_id", str2);
                            jSONObject2.put("ad_source_id", str2);
                        }
                        jSONObject2.put("nw_firm_id", 66);
                    } else {
                        jSONObject2.remove("unit_id");
                        jSONObject2.remove("ad_source_id");
                        jSONObject2.remove("nw_firm_id");
                    }
                    jSONObject2.put("pl_s_sw", this.f ? 2 : 1);
                    jSONObject2.put(com.anythink.core.common.l.f.P, "1.0");
                    jSONObject2.put(com.anythink.core.common.l.f.Y, strA);
                    jSONArray.put(jSONObject2);
                } catch (Throwable unused) {
                }
            }
        }
        map.put(com.anythink.core.e.l.a.j, com.smartdigimkt.r4.e.a(jSONArray.toString().getBytes()));
        map.put("request_id", this.c);
        com.smartdigimkt.p4.e eVar2 = this.e;
        int i = eVar2 != null ? eVar2.A : 0;
        if (i > 0) {
            map.put("hb_size", Integer.valueOf(i));
        }
        map.put(com.anythink.core.e.l.a.S, this.j);
        map.put(com.anythink.core.common.l.f.bj, this.k);
        if (SDKContext.getInstance().r.b != null) {
            map.put(com.anythink.core.c.a.a.c, com.smartdigimkt.r4.e.b(SDKContext.getInstance().r.b.toString()));
        }
        if (SDKContext.getInstance().j() && SDKContext.getInstance().B) {
            map.put(BuildConfig.BUILD_TYPE, 1);
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (String str3 : setKeySet) {
                jSONObject3.put(str3, map.get(str3));
            }
            return jSONObject3.toString();
        } catch (Exception unused2) {
            return null;
        } catch (OutOfMemoryError unused3) {
            System.gc();
            return null;
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        com.smartdigimkt.c3.a aVar = aVarA != null ? aVarA.D : null;
        String str = aVar != null ? aVar.b : "";
        return TextUtils.isEmpty(str) ? "https://adx-micro.statisticslinks.com/http_bid" : str;
    }

    @Override // com.smartdigimkt.g4.d
    public final boolean l() {
        return true;
    }
}
