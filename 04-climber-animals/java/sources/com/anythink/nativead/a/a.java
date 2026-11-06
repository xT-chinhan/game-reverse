package com.anythink.nativead.a;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.c;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.r;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private static Map<String, a> e = new ConcurrentHashMap(3);
    private Context b;
    private String c;
    private f d;

    public static a a(Context context, String str) {
        a aVar = e.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                if (aVar == null) {
                    aVar = new a(context, str);
                    e.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(Context context, String str) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = f.a(context, str, "0");
    }

    private ae a(Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        f fVar = this.d;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        return aeVar;
    }

    public final void a(Context context, com.anythink.core.common.d.a aVar, c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        ar arVar = new ar();
        arVar.a(context);
        arVar.a(aTAdRequest);
        arVar.d = cVar;
        arVar.f = aTAdMultipleLoadedListener;
        arVar.c = 0;
        if (map != null) {
            try {
                arVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            arVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.d.b(this.b, "0", this.c, arVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        return this.d.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.d.a(context, map);
    }

    public final com.anythink.core.common.h.c a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        String scenarioId;
        String showCustomExt;
        ae aeVar = new ae();
        aeVar.a(map);
        f fVar = this.d;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        final com.anythink.core.common.h.c cVarB = this.d.b(this.b, false, true, aeVar);
        if (cVarB == null || !(cVarB.f() instanceof BaseAd) || !(cVarB.e() instanceof CustomNativeAdapter)) {
            return null;
        }
        n detail = cVarB.f().getDetail();
        if (aTShowConfig != null) {
            scenarioId = aTShowConfig.getScenarioId();
            showCustomExt = aTShowConfig.getShowCustomExt();
            r.a(aTShowConfig.getATCustomContentResult(), detail);
        } else {
            scenarioId = "";
            showCustomExt = "";
        }
        detail.F = scenarioId;
        detail.z(showCustomExt);
        cVarB.a(cVarB.c() + 1);
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.nativead.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.a.a().a(cVarB);
            }
        });
        aj.a(map, detail);
        aj.a(this.c, detail);
        return cVarB;
    }
}
