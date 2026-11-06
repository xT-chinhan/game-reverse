package com.anythink.core.common.t;

import android.text.TextUtils;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";
    private final Map<String, com.anythink.core.common.t.b.e> b = new ConcurrentHashMap();
    private final Map<String, com.anythink.core.common.t.b.a> c = new ConcurrentHashMap();
    private final com.anythink.core.common.t.b.f d;
    private final com.anythink.core.common.t.b.d e;
    private final l f;

    public b() {
        l lVar = new l() { // from class: com.anythink.core.common.t.b.1
            @Override // com.anythink.core.common.d.l
            public final void a(boolean z) {
                if (z || b.this.b.isEmpty()) {
                    return;
                }
                try {
                    for (Map.Entry entry : b.this.b.entrySet()) {
                        com.anythink.core.common.t.b.e eVar = (com.anythink.core.common.t.b.e) entry.getValue();
                        com.anythink.core.common.t.b.a aVar = (com.anythink.core.common.t.b.a) b.this.c.get(entry.getKey());
                        if (eVar != null && aVar != null) {
                            aVar.d(eVar);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.f = lVar;
        com.anythink.core.common.t.b.f fVar = new com.anythink.core.common.t.b.f();
        this.d = fVar;
        this.e = new com.anythink.core.common.t.b.d(fVar);
        s.b().a(lVar);
    }

    private void a() {
        try {
            s.b().b(this.f);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(bx bxVar) {
        byte b;
        try {
            if ((bxVar instanceof n) || !TextUtils.isEmpty(bxVar.aS())) {
                String strAS = bxVar.aS();
                switch (strAS.hashCode()) {
                    case 48:
                        if (!strAS.equals("0")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 49:
                        if (!strAS.equals("1")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 50:
                        if (!strAS.equals("2")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 51:
                        if (!strAS.equals("3")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 52:
                        if (!strAS.equals("4")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0 || b == 1) {
                    if (bxVar instanceof n) {
                        n nVar = (n) bxVar;
                        String strA = a(nVar);
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        com.anythink.core.common.t.b.e eVar = new com.anythink.core.common.t.b.e();
                        eVar.a = strA;
                        eVar.b = nVar;
                        eVar.c = bxVar.aS();
                        com.anythink.core.common.t.b.a aVarB = this.e.b();
                        this.b.put(strA, eVar);
                        this.c.put(strA, aVarB);
                        aVarB.a(eVar);
                        return;
                    }
                    return;
                }
                if ((b == 2 || b == 3 || b == 4) && (bxVar instanceof n)) {
                    n nVar2 = (n) bxVar;
                    String strA2 = a(nVar2);
                    if (TextUtils.isEmpty(strA2)) {
                        return;
                    }
                    com.anythink.core.common.t.b.e eVar2 = new com.anythink.core.common.t.b.e();
                    eVar2.a = strA2;
                    eVar2.b = nVar2;
                    eVar2.c = bxVar.aS();
                    com.anythink.core.common.t.b.a aVarA = this.e.a();
                    this.b.put(strA2, eVar2);
                    this.c.put(strA2, aVarA);
                    aVarA.a(eVar2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void f(bx bxVar) {
        if (bxVar instanceof n) {
            try {
                n nVar = (n) bxVar;
                String strA = a(nVar);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.t.b.e eVar = new com.anythink.core.common.t.b.e();
                eVar.a = strA;
                eVar.b = nVar;
                eVar.c = bxVar.aS();
                com.anythink.core.common.t.b.a aVarA = this.e.a();
                this.b.put(strA, eVar);
                this.c.put(strA, aVarA);
                aVarA.a(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    private void g(bx bxVar) {
        if (bxVar instanceof n) {
            try {
                n nVar = (n) bxVar;
                String strA = a(nVar);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.t.b.e eVar = new com.anythink.core.common.t.b.e();
                eVar.a = strA;
                eVar.b = nVar;
                eVar.c = bxVar.aS();
                com.anythink.core.common.t.b.a aVarB = this.e.b();
                this.b.put(strA, eVar);
                this.c.put(strA, aVarB);
                aVarB.a(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public final void b(bx bxVar) {
        if (bxVar instanceof n) {
            String strA = a((n) bxVar);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.anythink.core.common.t.b.e eVar = this.b.get(strA);
            com.anythink.core.common.t.b.a aVar = this.c.get(strA);
            if (eVar == null || aVar == null) {
                return;
            }
            aVar.b(eVar);
        }
    }

    public final void c(bx bxVar) {
        if (bxVar instanceof n) {
            try {
                String strA = a((n) bxVar);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.t.b.e eVarRemove = this.b.remove(strA);
                com.anythink.core.common.t.b.a aVarRemove = this.c.remove(strA);
                if (aVarRemove != null) {
                    aVarRemove.e(eVarRemove);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        String strAQ = nVar.aQ();
        String strA = nVar.A();
        return strAQ + "_" + (!TextUtils.isEmpty(strA) ? strA.hashCode() & Integer.MAX_VALUE : 0L);
    }

    public final void d(bx bxVar) {
        if (bxVar instanceof n) {
            String strA = a((n) bxVar);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                a(strA);
            } catch (Throwable unused) {
            }
        }
    }

    public final void e(bx bxVar) {
        if (bxVar instanceof n) {
            try {
                String strA = a((n) bxVar);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.t.b.e eVar = this.b.get(strA);
                com.anythink.core.common.t.b.a aVar = this.c.get(strA);
                if (eVar == null || aVar == null) {
                    return;
                }
                aVar.c(eVar);
                a(strA);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str) {
        com.anythink.core.common.t.b.e eVarRemove = this.b.remove(str);
        com.anythink.core.common.t.b.a aVarRemove = this.c.remove(str);
        if (eVarRemove != null && eVarRemove.b != null) {
            a.a(eVarRemove.b.A());
        }
        if (aVarRemove != null) {
            aVarRemove.a(str);
        }
    }
}
