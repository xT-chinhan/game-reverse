package com.anythink.core.common.v;

import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.by;
import com.anythink.core.common.u.k;
import com.anythink.core.common.u.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private List<by> a;

    public i(List<by> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public final synchronized List<by> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return arrayList;
    }

    protected final synchronized void a(by byVar) {
        List<by> list = this.a;
        if (list != null) {
            if (list.size() == 0) {
                byVar.L(0);
                this.a.add(byVar);
                a(byVar, 0, null);
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                by byVar2 = this.a.get(i);
                if (k.a(byVar, byVar2) < 0) {
                    byVar.L(i);
                    this.a.add(i, byVar);
                    a(byVar, i, byVar2);
                    int i2 = i + 1;
                    List<by> list2 = this.a;
                    if (list2 != null && i2 < list2.size()) {
                        while (i2 < list2.size()) {
                            by byVar3 = list2.get(i2);
                            if (byVar3 != null) {
                                byVar3.L(i2);
                            }
                            i2++;
                        }
                    }
                    return;
                }
            }
            byVar.L(this.a.size());
            this.a.add(byVar);
            a(byVar, this.a.size() - 1, null);
        }
    }

    private static void a(int i, List<by> list) {
        if (list != null && i < list.size()) {
            while (i < list.size()) {
                by byVar = list.get(i);
                if (byVar != null) {
                    byVar.L(i);
                }
                i++;
            }
        }
    }

    private void a(by byVar, int i, by byVar2) {
        ad adVarY;
        ad adVarY2;
        if (byVar.w() && (adVarY2 = byVar.Y()) != null) {
            if (byVar2 != null) {
                adVarY2.a(byVar2, o.a(byVar2));
            } else {
                adVarY2.a(byVar, b(byVar));
            }
        }
        if (i > 0) {
            by byVar3 = this.a.get(i - 1);
            if (!byVar3.w() || (adVarY = byVar3.Y()) == null) {
                return;
            }
            adVarY.a(byVar, o.a(byVar));
        }
    }

    private static double b(by byVar) {
        if (byVar.bh() == 2) {
            return 0.0d;
        }
        return o.a(byVar);
    }
}
