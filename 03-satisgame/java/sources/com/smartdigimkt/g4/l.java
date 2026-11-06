package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.SDMAdxSetting;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends d {
    public final String c;

    public l(String str) {
        this.c = str;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            jSONObjectB.put(com.anythink.core.common.l.f.bn, this.c);
            jSONObjectB.put(com.anythink.core.common.l.f.bo, SDKContext.getInstance().b(this.c));
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
            if (SDKContext.getInstance().r.b != null) {
                jSONObjectB.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, SDKContext.getInstance().r.b);
            }
            jSONObjectB.put("exclude_myofferid", new JSONArray());
            jSONObjectB.put("deny", com.smartdigimkt.r4.h.q(SDKContext.getInstance().d()));
            if (SDKContext.getInstance().i()) {
                SDKContext.getInstance().A.fillRequestParam(jSONObjectB);
            }
            jSONObjectB.put("is_mo", 1);
            if (SDMAdxSetting.getInstance().isAdxNetworkMode(this.c)) {
                jSONObjectB.put(com.anythink.core.common.l.f.bh, 1);
            }
        } catch (Throwable unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED;
    }

    @Override // com.smartdigimkt.g4.d
    public final List d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        return arrayList;
    }

    @Override // com.smartdigimkt.g4.d
    public final HttpReqEntity f() {
        return HttpReqEntity.create("placement_strategy", this.c);
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final boolean l() {
        return true;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        String str = (aVarA == null || TextUtils.isEmpty(aVarA.Y)) ? "" : aVarA.Y;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SDKContext.getInstance().getClass();
        return "https://adx-strategy-api-cn.statisticslinks.com/sdk/pl_strategy";
    }
}
