package com.anythink.core.common.v.a.a;

import android.text.TextUtils;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.am;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";
    private static final long b = 3600000;
    private static final long c = 30000;
    private volatile List<ak> d;

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    public final void a(am amVar, al alVar, aj ajVar) {
        List<ak> list;
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new CopyOnWriteArrayList();
                }
            }
        }
        String strA = amVar.a();
        int iD = amVar.d();
        ak akVarA = a(strA, this.d);
        if (iD != com.anythink.core.common.v.a.a.b.b) {
            if (iD == com.anythink.core.common.v.a.a.b.c) {
                String strA2 = com.anythink.core.common.v.a.d.a.a(amVar.e(), alVar);
                amVar.a(strA2);
                if (!TextUtils.isEmpty(strA2)) {
                    List<ak> list2 = this.d;
                    long j = c;
                    if (akVarA != null) {
                        long jB = akVarA.b();
                        if (jB > 0) {
                            j = jB * 2;
                        }
                        if (j >= b) {
                            j = 3600000;
                        }
                        akVarA.a(j);
                    } else {
                        ak akVarA2 = ak.a(strA, com.anythink.core.common.v.a.a.C0054a.b);
                        akVarA2.a(c);
                        if (list2 != null) {
                            list2.add(akVarA2);
                        }
                    }
                } else {
                    list = this.d;
                    if (akVarA != null) {
                        list.remove(akVarA);
                    }
                }
            }
        } else {
            list = this.d;
            if (akVarA != null && list != null) {
                list.remove(akVarA);
            }
        }
        ajVar.b(this.d);
    }

    public final void a() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    private static ak a(String str, List<ak> list) {
        if (list != null && !list.isEmpty()) {
            for (ak akVar : list) {
                if (akVar.c().equals(str)) {
                    return akVar;
                }
            }
        }
        return null;
    }

    private static void a(String str, ak akVar, List<ak> list) {
        long j = c;
        if (akVar != null) {
            long jB = akVar.b();
            if (jB > 0) {
                j = 2 * jB;
            }
            if (j >= b) {
                j = 3600000;
            }
            akVar.a(j);
            return;
        }
        ak akVarA = ak.a(str, com.anythink.core.common.v.a.a.C0054a.b);
        akVarA.a(c);
        if (list != null) {
            list.add(akVarA);
        }
    }

    private static void a(ak akVar, List<ak> list) {
        if (akVar == null || list == null) {
            return;
        }
        list.remove(akVar);
    }
}
