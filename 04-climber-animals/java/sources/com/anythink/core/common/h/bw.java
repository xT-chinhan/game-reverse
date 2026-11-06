package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class bw {
    private String c;
    private final String a = "anythink_" + getClass().getSimpleName();
    private int b = 1;
    private ConcurrentHashMap<String, br> d = new ConcurrentHashMap<>(3);

    private interface a {
        boolean a(br brVar);
    }

    public bw(String str, String str2) {
        this.c = str + "_" + str2;
    }

    public final void a(int i) {
        if (i <= 0) {
            return;
        }
        this.b = i;
    }

    public final synchronized void a(String str, br brVar) {
        this.d.put(str, brVar);
        a();
    }

    private synchronized void a() {
        if (this.d.entrySet() == null) {
            return;
        }
        if (this.d.size() <= this.b) {
            return;
        }
        this.d.size();
        final br[] brVarArr = new br[1];
        a(new a() { // from class: com.anythink.core.common.h.bw.1
            /* JADX WARN: Code duplicated, block: B:16:0x0045  */
            @Override // com.anythink.core.common.h.bw.a
            public final boolean a(br brVar) {
                boolean z;
                br[] brVarArr2 = brVarArr;
                if (brVarArr2[0] == null) {
                    brVarArr2[0] = brVar;
                } else {
                    if (com.anythink.core.common.v.l.a(brVar.e(), brVarArr[0].e()) <= 0 && (com.anythink.core.common.v.l.a(brVar.e(), brVarArr[0].e()) != 0 || brVar.f() >= brVarArr[0].f())) {
                        z = false;
                    }
                    if (z) {
                        brVarArr[0] = brVar;
                    }
                    return true;
                }
                z = true;
                if (z) {
                    brVarArr[0] = brVar;
                }
                return true;
            }
        });
        if (this.d.size() <= this.b) {
            this.d.size();
        } else if (brVarArr[0] != null) {
            brVarArr[0].a();
            this.d.remove(brVarArr[0].a());
            brVarArr[0].g();
        }
    }

    public final j a(final ad adVar) {
        final j jVar = new j();
        final ArrayList arrayList = new ArrayList(3);
        jVar.a = arrayList;
        a(new a() { // from class: com.anythink.core.common.h.bw.2
            @Override // com.anythink.core.common.h.bw.a
            public final boolean a(br brVar) {
                if (!jVar.c && brVar.d()) {
                    jVar.c = true;
                }
                c cVarC = brVar.c();
                if (cVarC != null) {
                    if (arrayList.size() == 0) {
                        arrayList.add(cVarC);
                    } else {
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (com.anythink.core.common.v.l.a(cVarC.e().getUnitGroupInfo(), ((c) arrayList.get(i)).e().getUnitGroupInfo()) < 0) {
                                arrayList.add(i, cVarC);
                                break;
                            }
                            if (i == arrayList.size() - 1) {
                                arrayList.add(cVarC);
                                break;
                            }
                        }
                    }
                    ad adVarR = cVarC.e().getUnitGroupInfo().R();
                    ad adVar2 = adVar;
                    if (adVar2 != null && adVarR != null && TextUtils.equals(adVar2.token, adVarR.token)) {
                        jVar.b = cVarC;
                    }
                }
                return true;
            }
        });
        return jVar;
    }

    public final synchronized void b(final int i) {
        a(new a() { // from class: com.anythink.core.common.h.bw.3
            @Override // com.anythink.core.common.h.bw.a
            public final boolean a(br brVar) {
                brVar.a(i);
                return true;
            }
        });
    }

    public final synchronized void a(c cVar) {
        if (this.d == null) {
            return;
        }
        if (cVar != null) {
            br brVar = this.d.get(cVar.i().aJ());
            if (brVar != null) {
                brVar.a(cVar);
                if (brVar.b() == 0) {
                    this.d.remove(brVar.a());
                    brVar.a();
                }
            }
        }
    }

    private synchronized void a(a aVar) {
        boolean z;
        ConcurrentHashMap<String, br> concurrentHashMap = this.d;
        if (concurrentHashMap == null) {
            return;
        }
        Set<Map.Entry<String, br>> setEntrySet = concurrentHashMap.entrySet();
        if (setEntrySet == null) {
            return;
        }
        for (Map.Entry<String, br> entry : setEntrySet) {
            br value = entry.getValue();
            c cVarC = value.c();
            if (value != null && cVarC != null && cVarC.k()) {
                new StringBuilder().append(this.c).append(":traverseVailRequestCacheEntry:RequestId:").append(entry.getKey()).append(" :: traverseAdCache price::").append(com.anythink.core.common.v.p.a(value.e())).append("\n").append(cVarC);
                entry.getKey();
                aVar.a(value);
                z = true;
            } else {
                new StringBuilder().append(this.c).append(":traverseVailRequestCacheEntry:RequestId:").append(entry.getKey());
                z = false;
            }
            if (value == null || !z) {
                new StringBuilder().append(this.c).append(":traverseVailRequestCacheEntry:RequestId:").append(entry.getKey());
                this.d.remove(entry.getKey());
            }
        }
    }
}
