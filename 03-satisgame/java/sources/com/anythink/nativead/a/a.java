package com.anythink.nativead.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.c;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.q;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private static Map<String, a> f = new ConcurrentHashMap(3);
    ATAdCreateConfig b;
    private Context c;
    private String d;
    private final f e;

    private static a a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = f.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                if (aVar == null) {
                    aVar = new a(context, str);
                    f.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.c = context.getApplicationContext();
        this.d = str;
        this.b = aTAdCreateConfig;
        if (aTAdCreateConfig != null) {
            if (aTAdCreateConfig.isMultiton()) {
                f fVar = new f(context, str, "0");
                this.e = fVar;
                fVar.u();
                return;
            }
            this.e = f.a(context, str, "0");
            return;
        }
        this.e = f.a(context, str, "0");
    }

    public final boolean a() {
        ATAdCreateConfig aTAdCreateConfig = this.b;
        return aTAdCreateConfig != null && aTAdCreateConfig.isMultiton();
    }

    public final f b() {
        return this.e;
    }

    public final c a(Map<String, Object> map) {
        ae aeVarD = d(map);
        aeVarD.f();
        f fVar = this.e;
        if (fVar != null) {
            return fVar.b(this.c, false, false, aeVarD);
        }
        return null;
    }

    public final c a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        String scenarioId;
        String showCustomExt;
        final c cVarB = this.e.b(this.c, false, true, d(map));
        if (cVarB == null || !(cVarB.f() instanceof BaseAd) || !(cVarB.e() instanceof CustomNativeAdapter)) {
            return null;
        }
        n detail = cVarB.f().getDetail();
        ai.a(this.e.n(), detail);
        if (aTShowConfig != null) {
            scenarioId = aTShowConfig.getScenarioId();
            showCustomExt = aTShowConfig.getShowCustomExt();
            q.a(aTShowConfig.getATCustomContentResult(), detail);
        } else {
            scenarioId = "";
            showCustomExt = "";
        }
        detail.H = scenarioId;
        detail.y(showCustomExt);
        final f fVarA = detail.a();
        if (fVarA != null) {
            detail.z = fVarA.m();
        }
        cVarB.a(cVarB.c() + 1);
        com.anythink.core.common.u.b.c.a().b(new d(e.v, new Runnable() { // from class: com.anythink.nativead.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = fVarA;
                if (fVar == null || fVar.e() == null) {
                    return;
                }
                fVarA.e().a(cVarB, 5);
            }
        }));
        ai.a(map, detail);
        ai.a(this.d, detail);
        return cVarB;
    }

    private ae d(Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        f fVar = this.e;
        if (fVar != null) {
            aeVar.a(fVar.n());
        }
        return aeVar;
    }

    public final void a(Context context, com.anythink.core.common.d.a aVar, com.anythink.core.common.d.c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        as asVar = new as();
        asVar.a(context);
        asVar.a(aTAdRequest);
        asVar.d = cVar;
        asVar.f = aTAdMultipleLoadedListener;
        asVar.c = 0;
        if (map != null) {
            try {
                asVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            asVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.e.b(this.c, "0", this.d, asVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        return this.e.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.e.a(context, map);
    }

    public final void a(int i) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public final void a(List<ATAdInfo> list) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(list);
        }
    }

    public final void b(Map<String, Object> map) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    public final void c() {
        f fVar;
        ATAdCreateConfig aTAdCreateConfig = this.b;
        if (aTAdCreateConfig == null || !aTAdCreateConfig.isMultiton() || (fVar = this.e) == null) {
            return;
        }
        fVar.p();
    }

    public final void c(Map<String, Object> map) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.b(map);
        }
    }
}
