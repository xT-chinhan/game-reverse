package com.anythink.basead;

import android.text.TextUtils;
import com.anythink.basead.d.j;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.g;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static Map<String, Object> a(com.anythink.basead.f.c cVar) {
        if (cVar != null) {
            return a(cVar.d());
        }
        return null;
    }

    public static Map<String, Object> a(com.anythink.basead.h.c cVar) {
        if (cVar != null) {
            return a(cVar.e());
        }
        return null;
    }

    public static Map<String, Object> a(w wVar) {
        if (wVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("offer_id", wVar.v());
        map.put("creative_id", wVar.w());
        map.put(ATAdConst.NETWORK_CUSTOM_KEY.IS_DEEPLINK_OFFER, Integer.valueOf((TextUtils.isEmpty(wVar.u()) && TextUtils.isEmpty(wVar.G())) ? 0 : 1));
        if (wVar instanceof bj) {
            bj bjVar = (bj) wVar;
            map.put("dsp_id", bjVar.aC());
            if (bjVar.r() instanceof bk) {
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.WS_IMP_SWITCH, Integer.valueOf(((bk) bjVar.r()).c()));
            }
            if (wVar instanceof r) {
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.WS_ACTION, new ad.a() { // from class: com.anythink.basead.d.1
                    private j b;

                    {
                        this.b = new j(this.a.q(), "");
                    }

                    @Override // com.anythink.core.common.h.ad.a
                    public final void a(Map<String, Object> map2) {
                        this.b.r = map2;
                        com.anythink.basead.b.b.a(10, this.a, this.b);
                        com.anythink.core.common.a.a.a();
                        com.anythink.core.common.a.a.c(t.b().g(), ((r) this.a).e());
                    }

                    @Override // com.anythink.core.common.h.ad.a
                    public final void b(Map<String, Object> map2) {
                        this.b.r = map2;
                        com.anythink.basead.b.b.a(36, this.a, this.b);
                    }
                });
                if (!wVar.L()) {
                    if (bjVar.r().an() == 1) {
                        map.put(ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE, "6");
                    } else if (bjVar.r().ao() > 0) {
                        map.put(ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE, new StringBuilder().append(bjVar.r().ao()).toString());
                    }
                }
                r rVar = (r) wVar;
                map.put("app_name", rVar.aK());
                map.put("app_publisher", rVar.M());
                map.put("app_version", rVar.N());
                map.put("app_privacy", rVar.O());
                map.put("app_permission", rVar.P());
                map.put(g.a.N, rVar.h());
                map.put("app_url", rVar.H());
            }
        }
        return map;
    }
}
