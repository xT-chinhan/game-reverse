package com.smartdigimkt.z;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static HashMap a(com.smartdigimkt.b3.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("offer_id", cVar.a);
        map.put("creative_id", cVar.b);
        map.put("is_deeplink", Integer.valueOf((TextUtils.isEmpty(cVar.q) && TextUtils.isEmpty(cVar.k)) ? 0 : 1));
        if (cVar instanceof com.smartdigimkt.b3.l) {
            com.smartdigimkt.b3.l lVar = (com.smartdigimkt.b3.l) cVar;
            map.put("dsp_id", lVar.c0);
            com.smartdigimkt.b3.e eVar = lVar.w;
            if (eVar instanceof com.smartdigimkt.b3.m) {
                map.put("ws_imp_switch", Integer.valueOf(((com.smartdigimkt.b3.m) eVar).Z1));
            }
            if (cVar instanceof com.smartdigimkt.b3.b) {
                if (!cVar.h()) {
                    com.smartdigimkt.b3.e eVar2 = lVar.w;
                    if (eVar2.i0 == 1) {
                        map.put("rv_anim_type", "6");
                    } else if (eVar2.j0 > 0) {
                        map.put("rv_anim_type", "" + lVar.w.j0);
                    }
                }
                com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
                map.put("app_name", bVar.X);
                map.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_PUBLISHER, bVar.r);
                map.put("app_version", bVar.s);
                map.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_PRIVACY, bVar.t);
                map.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_PERMISSION, bVar.u);
                map.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_FUNCTION_URL, bVar.v);
                map.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_CLICK_URL, bVar.l);
            }
        }
        return map;
    }
}
