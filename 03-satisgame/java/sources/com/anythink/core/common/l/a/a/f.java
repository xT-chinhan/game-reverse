package com.anythink.core.common.l.a.a;

import android.text.TextUtils;
import com.anythink.core.common.l.a.i;
import com.anythink.core.common.l.a.j;
import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.ae;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.ag;
import com.anythink.core.common.m.b.u;
import com.anythink.core.common.m.b.x;
import com.anythink.core.common.m.b.z;
import com.anythink.core.common.u.l;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f extends com.anythink.core.common.l.a.a {
    private com.anythink.core.common.m.b.e b;

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    public f(com.anythink.core.common.l.a.f fVar) {
        super(fVar);
    }

    @Override // com.anythink.core.common.l.a.b
    public final j a(i iVar) {
        try {
            com.anythink.core.common.m.b.e eVarA = e.a().a(this.a).a(b(iVar));
            this.b = eVarA;
            return b(iVar, eVarA.b(), null);
        } catch (Throwable th) {
            return b(iVar, null, th);
        }
    }

    @Override // com.anythink.core.common.l.a.b
    public final void a(final i iVar, final com.anythink.core.common.l.a.c cVar) {
        try {
            com.anythink.core.common.m.b.e eVarA = e.a().a(this.a).a(b(iVar));
            this.b = eVarA;
            eVarA.a(new com.anythink.core.common.m.b.f() { // from class: com.anythink.core.common.l.a.a.f.1
                @Override // com.anythink.core.common.m.b.f
                public final void a(IOException iOException) {
                    f.b(iVar, null, iOException);
                }

                @Override // com.anythink.core.common.m.b.f
                public final void a(af afVar) {
                    f.b(iVar, afVar, null);
                }
            });
        } catch (Throwable th) {
            b(iVar, null, th);
        }
    }

    @Override // com.anythink.core.common.l.a.b
    public final void a() {
        try {
            com.anythink.core.common.m.b.e eVar = this.b;
            if (eVar == null || eVar.e()) {
                return;
            }
            this.b.c();
        } catch (Throwable unused) {
        }
    }

    private static z a(com.anythink.core.common.l.a.f fVar) {
        return e.a().a(fVar);
    }

    private static ad b(i iVar) {
        u.a aVar = new u.a();
        Map<String, String> map = iVar.e;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
            if (!map.containsKey(RequestParamsUtils.USER_AGENT_KEY)) {
                String strK = l.k();
                if (!TextUtils.isEmpty(strK)) {
                    aVar.a(RequestParamsUtils.USER_AGENT_KEY, strK);
                }
            }
        } else {
            String strK2 = l.k();
            if (!TextUtils.isEmpty(strK2)) {
                aVar.a(RequestParamsUtils.USER_AGENT_KEY, strK2);
            }
        }
        if (Objects.equals(iVar.b, TapHttp.METHOD_GET)) {
            return new ad.a().a(iVar.a).a().a(aVar.a()).b();
        }
        return new ad.a().a(iVar.a).a(iVar.b, ae.a(x.b(iVar.d), iVar.c)).a(aVar.a()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j b(i iVar, af afVar, Throwable th) {
        j.a aVarA = new j.a().a(iVar).a(th);
        if (afVar != null) {
            try {
                aVarA.a(afVar.c());
                aVarA.a(afVar.e());
                HashMap map = new HashMap();
                u uVarG = afVar.g();
                for (int i = 0; i < uVarG.a(); i++) {
                    String strA = uVarG.a(i);
                    String strB = uVarG.b(i);
                    List<String> list = map.get(strA);
                    if (list != null) {
                        if (!list.contains(strB)) {
                            list.add(strB);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(strB);
                        map.put(strA, arrayList);
                    }
                }
                aVarA.a(map);
                ag agVarH = afVar.h();
                if (agVarH != null) {
                    aVarA.a(new g(agVarH));
                }
            } catch (Throwable th2) {
                aVarA.a(th2);
            }
        }
        return aVarA.a();
    }
}
