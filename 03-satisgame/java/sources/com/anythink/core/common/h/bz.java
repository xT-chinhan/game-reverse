package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class bz {
    private String c;
    private final String a = "anythink_" + getClass().getSimpleName();
    private int b = 1;
    private ConcurrentHashMap<String, bt> d = new ConcurrentHashMap<>(3);

    private interface a {
        boolean a(bt btVar);
    }

    public bz(String str, String str2) {
        this.c = str + "_" + str2;
    }

    public final void a(int i) {
        if (i <= 0) {
            return;
        }
        this.b = i;
    }

    public final synchronized void a(String str, bt btVar) {
        this.d.put(str, btVar);
        a();
    }

    private synchronized void a() {
        bt btVar;
        if (this.d.entrySet() == null) {
            return;
        }
        if (this.d.size() <= this.b) {
            return;
        }
        final bt[] btVarArr = new bt[1];
        a(new a() { // from class: com.anythink.core.common.h.bz.1
            /* JADX WARN: Code duplicated, block: B:16:0x0045  */
            @Override // com.anythink.core.common.h.bz.a
            public final boolean a(bt btVar2) {
                boolean z;
                bt[] btVarArr2 = btVarArr;
                if (btVarArr2[0] == null) {
                    btVarArr2[0] = btVar2;
                } else {
                    if (com.anythink.core.common.u.k.a(btVar2.e(), btVarArr[0].e()) <= 0 && (com.anythink.core.common.u.k.a(btVar2.e(), btVarArr[0].e()) != 0 || btVar2.f() >= btVarArr[0].f())) {
                        z = false;
                    }
                    if (z) {
                        btVarArr[0] = btVar2;
                    }
                    return true;
                }
                z = true;
                if (z) {
                    btVarArr[0] = btVar2;
                }
                return true;
            }
        });
        if (this.d.size() > this.b && (btVar = btVarArr[0]) != null) {
            this.d.remove(btVar.a());
            btVarArr[0].g();
        }
    }

    public final j a(final ad adVar) {
        final j jVar = new j();
        final ArrayList arrayList = new ArrayList(3);
        jVar.a = arrayList;
        a(new a() { // from class: com.anythink.core.common.h.bz.2
            @Override // com.anythink.core.common.h.bz.a
            public final boolean a(bt btVar) {
                if (!jVar.c && btVar.d()) {
                    jVar.c = true;
                }
                c cVarC = btVar.c();
                if (cVarC != null) {
                    if (arrayList.size() == 0) {
                        arrayList.add(cVarC);
                    } else {
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (com.anythink.core.common.u.k.a(cVarC.e().getUnitGroupInfo(), ((c) arrayList.get(i)).e().getUnitGroupInfo()) < 0) {
                                arrayList.add(i, cVarC);
                                break;
                            }
                            if (i == arrayList.size() - 1) {
                                arrayList.add(cVarC);
                                break;
                            }
                        }
                    }
                    ad adVarY = cVarC.e().getUnitGroupInfo().Y();
                    ad adVar2 = adVar;
                    if (adVar2 != null && adVarY != null && TextUtils.equals(adVar2.token, adVarY.token)) {
                        jVar.b = cVarC;
                    }
                }
                return true;
            }
        });
        return jVar;
    }

    public final synchronized void b(final int i) {
        a(new a() { // from class: com.anythink.core.common.h.bz.3
            @Override // com.anythink.core.common.h.bz.a
            public final boolean a(bt btVar) {
                btVar.a(i);
                return true;
            }
        });
    }

    public final synchronized void a(c cVar) {
        if (this.d == null) {
            return;
        }
        if (cVar != null) {
            bt btVar = this.d.get(cVar.i().aR());
            if (btVar != null) {
                btVar.a(cVar);
                if (btVar.b() == 0) {
                    this.d.remove(btVar.a());
                }
            }
        }
    }

    private synchronized void a(a aVar) {
        boolean z;
        ConcurrentHashMap<String, bt> concurrentHashMap = this.d;
        if (concurrentHashMap == null) {
            return;
        }
        Set<Map.Entry<String, bt>> setEntrySet = concurrentHashMap.entrySet();
        if (setEntrySet == null) {
            return;
        }
        for (Map.Entry<String, bt> entry : setEntrySet) {
            bt value = entry.getValue();
            c cVarC = value.c();
            if (value == null || cVarC == null || !cVarC.k()) {
                z = false;
            } else {
                entry.getKey();
                aVar.a(value);
                z = true;
            }
            if (value == null || !z) {
                this.d.remove(entry.getKey());
            }
        }
    }
}
