package com.anythink.core.common.w.a.a;

import android.text.TextUtils;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.al;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";
    private static final long b = 3600000;
    private static final long c = 30000;
    private volatile List<aj> d;

    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    public final void a(al alVar, ak akVar, ai aiVar) {
        List<aj> list;
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new CopyOnWriteArrayList();
                }
            }
        }
        String strA = alVar.a();
        int iD = alVar.d();
        aj ajVarA = a(strA, this.d);
        Object[] objArr = new Object[3];
        Integer.valueOf(iD);
        if (iD != com.anythink.core.common.w.a.a.b.b) {
            if (iD == com.anythink.core.common.w.a.a.b.c) {
                String strA2 = com.anythink.core.common.w.a.d.a.a(alVar.e(), akVar);
                alVar.a(strA2);
                if (!TextUtils.isEmpty(strA2)) {
                    List<aj> list2 = this.d;
                    long j = c;
                    if (ajVarA != null) {
                        long jB = ajVarA.b();
                        if (jB > 0) {
                            j = jB * 2;
                        }
                        if (j >= 3600000) {
                            j = 3600000;
                        }
                        ajVarA.a(j);
                    } else {
                        aj ajVarA2 = aj.a(strA, com.anythink.core.common.w.a.a.C0106a.b);
                        ajVarA2.a(c);
                        if (list2 != null) {
                            list2.add(ajVarA2);
                        }
                    }
                } else {
                    list = this.d;
                    if (ajVarA != null) {
                        list.remove(ajVarA);
                    }
                }
            }
        } else {
            list = this.d;
            if (ajVarA != null && list != null) {
                list.remove(ajVarA);
            }
        }
        aiVar.b(this.d);
    }

    public final void a() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    private static aj a(String str, List<aj> list) {
        if (list != null && !list.isEmpty()) {
            for (aj ajVar : list) {
                if (ajVar.c().equals(str)) {
                    return ajVar;
                }
            }
        }
        return null;
    }

    private static void a(String str, aj ajVar, List<aj> list) {
        long j = c;
        if (ajVar != null) {
            long jB = ajVar.b();
            if (jB > 0) {
                j = 2 * jB;
            }
            if (j >= 3600000) {
                j = 3600000;
            }
            ajVar.a(j);
            return;
        }
        aj ajVarA = aj.a(str, com.anythink.core.common.w.a.a.C0106a.b);
        ajVarA.a(c);
        if (list != null) {
            list.add(ajVarA);
        }
    }

    private static void a(aj ajVar, List<aj> list) {
        if (ajVar == null || list == null) {
            return;
        }
        list.remove(ajVar);
    }
}
