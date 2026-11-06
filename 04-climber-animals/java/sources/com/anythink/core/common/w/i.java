package com.anythink.core.common.w;

import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.l;
import com.anythink.core.common.v.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private List<bv> a;

    public i(List<bv> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public final synchronized List<bv> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return arrayList;
    }

    protected final synchronized void a(bv bvVar) {
        List<bv> list = this.a;
        if (list != null) {
            if (list.size() == 0) {
                bvVar.H(0);
                this.a.add(bvVar);
                a(bvVar, 0, null);
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                bv bvVar2 = this.a.get(i);
                if (l.a(bvVar, bvVar2) < 0) {
                    bvVar.H(i);
                    this.a.add(i, bvVar);
                    a(bvVar, i, bvVar2);
                    int i2 = i + 1;
                    List<bv> list2 = this.a;
                    if (list2 != null && i2 < list2.size()) {
                        while (i2 < list2.size()) {
                            bv bvVar3 = list2.get(i2);
                            if (bvVar3 != null) {
                                bvVar3.H(i2);
                            }
                            i2++;
                        }
                    }
                    return;
                }
            }
            bvVar.H(this.a.size());
            this.a.add(bvVar);
            a(bvVar, this.a.size() - 1, null);
        }
    }

    private static void a(int i, List<bv> list) {
        if (list != null && i < list.size()) {
            while (i < list.size()) {
                bv bvVar = list.get(i);
                if (bvVar != null) {
                    bvVar.H(i);
                }
                i++;
            }
        }
    }

    private void a(bv bvVar, int i, bv bvVar2) {
        ad adVarR;
        ad adVarR2;
        if (bvVar.o() && (adVarR2 = bvVar.R()) != null) {
            if (bvVar2 != null) {
                adVarR2.a(bvVar2, p.a(bvVar2));
            } else {
                adVarR2.a(bvVar, b(bvVar));
            }
        }
        if (i > 0) {
            bv bvVar3 = this.a.get(i - 1);
            if (!bvVar3.o() || (adVarR = bvVar3.R()) == null) {
                return;
            }
            adVarR.a(bvVar, p.a(bvVar));
        }
    }

    private static double b(bv bvVar) {
        if (bvVar.aZ() == 2) {
            return 0.0d;
        }
        return p.a(bvVar);
    }
}
