package com.smartdigimkt.f;

import android.text.TextUtils;
import com.byazt.m.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.r4.a0;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.smartdigimkt.g4.d {
    public final String c;
    public final String d;

    public l(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    @Override // com.smartdigimkt.g4.d
    public final String a() {
        return this.d;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("app_id", this.c);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(66), "UA_6.5.90");
                jSONObject.put(String.valueOf(67), "UA_6.5.90");
                jSONObject.put(String.valueOf(35), "UA_6.5.90");
                jSONObjectB.put("nw_ver", jSONObject);
            } catch (Throwable unused) {
            }
            if (SDKContext.getInstance().d() != null) {
                String strG = SDKContext.getInstance().g();
                if (!TextUtils.isEmpty(strG)) {
                    jSONObjectB.put("sy_id", strG);
                }
                String strC = SDKContext.getInstance().c();
                if (TextUtils.isEmpty(strC)) {
                    SDKContext sDKContext = SDKContext.getInstance();
                    String strH = SDKContext.getInstance().h();
                    sDKContext.x = strH;
                    y.a(sDKContext.c, com.anythink.core.common.d.t.b.f, com.anythink.core.common.d.t.a.C, strH);
                    jSONObjectB.put("bk_id", SDKContext.getInstance().h());
                } else {
                    jSONObjectB.put("bk_id", strC);
                }
                jSONObjectB.put("deny", com.smartdigimkt.r4.h.q(SDKContext.getInstance().d()));
                if (SDKContext.getInstance().i()) {
                    jSONObjectB.put("is_test", 1);
                }
            }
            jSONObjectB.putOpt(com.anythink.core.common.l.f.bk, 1);
            if (!TextUtils.isEmpty("")) {
                jSONObjectB.put(com.anythink.core.common.l.f.bp, "");
            }
        } catch (JSONException unused2) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME;
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final HttpReqEntity f() {
        return HttpReqEntity.create("get_plugin", this.c);
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return super.h();
    }

    @Override // com.smartdigimkt.g4.d
    public final String i() {
        try {
            HashMap map = new HashMap();
            String strB = com.smartdigimkt.r4.e.b(b().toString());
            String strB2 = com.smartdigimkt.r4.e.b(com.smartdigimkt.a4.a.a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, (List) null).toString());
            HashMap map2 = u.a().d;
            map.put(cp.n, strB);
            map.put("cp2", strB2);
            u.a().getClass();
            String strB3 = u.b(map2);
            if (!TextUtils.isEmpty(strB3)) {
                map.put("cp3", com.smartdigimkt.r4.e.e(strB3));
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
            map.put(com.anythink.core.common.l.f.Y, com.smartdigimkt.r4.i.a(this.d + sb.toString()));
            return new JSONObject(map).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        return a0.a("kwwsv=22gvs0dsl0fq1phwulfvolqnv1frp2dsl2frqyhuvlrq2sj");
    }
}
