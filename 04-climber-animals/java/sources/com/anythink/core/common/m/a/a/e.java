package com.anythink.core.common.m.a.a;

import android.text.TextUtils;
import com.anythink.core.common.m.a.i;
import com.anythink.core.common.m.a.j;
import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.ae;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.ag;
import com.anythink.core.common.n.b.u;
import com.anythink.core.common.n.b.x;
import com.anythink.core.common.n.b.z;
import com.anythink.core.common.v.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.anythink.core.common.m.a.a {
    private com.anythink.core.common.n.b.e b;

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    public e(com.anythink.core.common.m.a.f fVar) {
        super(fVar);
    }

    @Override // com.anythink.core.common.m.a.b
    public final j a(i iVar) {
        try {
            com.anythink.core.common.n.b.e eVarA = a(this.a, iVar).a(b(iVar));
            this.b = eVarA;
            return b(iVar, eVarA.b(), null);
        } catch (Throwable th) {
            return b(iVar, null, th);
        }
    }

    @Override // com.anythink.core.common.m.a.b
    public final void a(final i iVar, final com.anythink.core.common.m.a.c cVar) {
        try {
            com.anythink.core.common.n.b.e eVarA = a(this.a, iVar).a(b(iVar));
            this.b = eVarA;
            eVarA.a(new com.anythink.core.common.n.b.f() { // from class: com.anythink.core.common.m.a.a.e.1
                @Override // com.anythink.core.common.n.b.f
                public final void a(IOException iOException) {
                    e.b(iVar, null, iOException);
                }

                @Override // com.anythink.core.common.n.b.f
                public final void a(af afVar) {
                    e.b(iVar, afVar, null);
                }
            });
        } catch (Throwable th) {
            b(iVar, null, th);
        }
    }

    @Override // com.anythink.core.common.m.a.b
    public final void a() {
        try {
            com.anythink.core.common.n.b.e eVar = this.b;
            if (eVar == null || eVar.e()) {
                return;
            }
            this.b.c();
        } catch (Throwable unused) {
        }
    }

    private static z a(com.anythink.core.common.m.a.f fVar, i iVar) {
        return d.a().a(fVar, iVar);
    }

    private static ad b(i iVar) {
        u.a aVar = new u.a();
        Map<String, String> map = iVar.e;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
            if (!map.containsKey("User-Agent")) {
                String strK = m.k();
                if (!TextUtils.isEmpty(strK)) {
                    aVar.a("User-Agent", strK);
                }
            }
        } else {
            String strK2 = m.k();
            if (!TextUtils.isEmpty(strK2)) {
                aVar.a("User-Agent", strK2);
            }
        }
        if (Objects.equals(iVar.b, "GET")) {
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
                aVarA.a(afVar.d());
                HashMap map = new HashMap();
                u uVarF = afVar.f();
                for (int i = 0; i < uVarF.a(); i++) {
                    String strA = uVarF.a(i);
                    String strB = uVarF.b(i);
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
                ag agVarG = afVar.g();
                if (agVarG != null) {
                    aVarA.a(new f(agVarG));
                }
            } catch (Throwable th2) {
                aVarA.a(th2);
            }
        }
        return aVarA.a();
    }
}
