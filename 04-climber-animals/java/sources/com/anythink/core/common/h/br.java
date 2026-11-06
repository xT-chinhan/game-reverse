package com.anythink.core.common.h;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class br {
    private String a;
    private List<c> b;

    public br(String str, List<c> list) {
        this.a = str;
        this.b = list;
    }

    public final String a() {
        return this.a;
    }

    public final synchronized int b() {
        List<c> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final synchronized void a(c cVar) {
        List<c> list = this.b;
        if (list != null) {
            list.remove(cVar);
        }
    }

    public final synchronized c c() {
        List<c> list = this.b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.b.get(0);
    }

    public final synchronized boolean d() {
        List<c> list = this.b;
        c cVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (cVar != null) {
            return cVar.a();
        }
        return false;
    }

    public final synchronized void a(int i) {
        List<c> list = this.b;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().e().getUnitGroupInfo().m = i;
            }
        }
    }

    private synchronized double h() {
        List<c> list = this.b;
        c cVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (cVar != null) {
            return com.anythink.core.common.v.p.a(cVar.e().getUnitGroupInfo());
        }
        return 0.0d;
    }

    public final synchronized bv e() {
        List<c> list = this.b;
        c cVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (cVar != null) {
            return cVar.e().getUnitGroupInfo();
        }
        return null;
    }

    public final synchronized long f() {
        List<c> list = this.b;
        c cVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (cVar != null) {
            return cVar.b();
        }
        return 0L;
    }

    public final synchronized void g() {
        List<c> list = this.b;
        if (list == null) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null) {
                com.anythink.core.b.d.c.a(cVar, true, 26);
                cVar.m();
            }
        }
    }
}
