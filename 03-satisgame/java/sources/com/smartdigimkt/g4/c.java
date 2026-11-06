package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.v2.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {
    public Map c;

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            Map map = this.c;
            if (map != null && !map.isEmpty()) {
                jSONObjectB.put("cached", new JSONObject(this.c));
            }
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
            if (SDKContext.getInstance().i()) {
                jSONObjectB.put("is_test", 1);
            }
            p.c().getClass();
            jSONObjectB.put("pil_offset", y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", t.a.E));
            jSONObjectB.put(com.anythink.core.common.l.f.bj, new JSONObject().toString());
            jSONObjectB.putOpt(com.anythink.core.common.l.f.bk, 1);
        } catch (Throwable unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME;
    }

    @Override // com.smartdigimkt.g4.d
    public final List d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        return arrayList;
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        SDKContext.getInstance().getClass();
        return "https://adx-strategy-api-cn.statisticslinks.com/sdk/app_strategy";
    }

    @Override // com.smartdigimkt.g4.d
    public final HttpReqEntity f() {
        return HttpReqEntity.create("app_strategy", SDKContext.getInstance().a());
    }
}
