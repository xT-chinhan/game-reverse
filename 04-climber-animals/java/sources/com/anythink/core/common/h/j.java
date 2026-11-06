package com.anythink.core.common.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    protected List<c> a;
    protected c b;
    protected boolean c;

    public final c a() {
        List<c> list = this.a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.a.get(0);
    }

    public final c b() {
        List<c> list = this.a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<c> list2 = this.a;
        return list2.get(list2.size() - 1);
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        List<c> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final c e() {
        return this.b;
    }

    public final List<bz.a> f() {
        List<c> list = this.a;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = this.a.iterator();
        while (it.hasNext()) {
            bv unitGroupInfo = it.next().e().getUnitGroupInfo();
            arrayList.add(new bz.a(unitGroupInfo, unitGroupInfo.R()));
        }
        return arrayList;
    }
}
