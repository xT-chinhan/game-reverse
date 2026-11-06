package com.anythink.core.common.h;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class bp {
    com.anythink.core.d.l a;
    n b;
    List<bv> c;
    List<bv> d;
    List<bv> e;
    List<bv> f;
    List<bv> g;
    int h;

    public bp(com.anythink.core.d.l lVar, n nVar, int i) {
        this.a = lVar;
        this.b = nVar;
        this.h = i;
    }

    public final com.anythink.core.d.l a() {
        return this.a;
    }

    public final int b() {
        return this.h;
    }

    public final n c() {
        return this.b;
    }

    public final List<bv> d() {
        return this.c;
    }

    public final void a(List<bv> list) {
        this.c = list;
    }

    public final List<bv> e() {
        return this.d;
    }

    public final void b(List<bv> list) {
        this.d = list;
    }

    public final List<bv> f() {
        return this.f;
    }

    public final void c(List<bv> list) {
        this.f = list;
    }

    public final List<bv> g() {
        return this.g;
    }

    public final void d(List<bv> list) {
        this.g = list;
    }

    public final List<bv> h() {
        return this.e;
    }

    public final void e(List<bv> list) {
        this.e = list;
    }

    public final boolean i() {
        List<bv> list = this.c;
        if (list != null && list.size() > 0) {
            return true;
        }
        List<bv> list2 = this.d;
        if (list2 != null && list2.size() > 0) {
            return true;
        }
        List<bv> list3 = this.e;
        if (list3 != null && list3.size() > 0) {
            return true;
        }
        List<bv> list4 = this.f;
        if (list4 != null && list4.size() > 0) {
            return true;
        }
        List<bv> list5 = this.g;
        return list5 != null && list5.size() > 0;
    }

    public final boolean j() {
        List<bv> list = this.f;
        if (list != null && list.size() > 0) {
            return true;
        }
        List<bv> list2 = this.g;
        return list2 != null && list2.size() > 0;
    }

    public final boolean k() {
        List<bv> list = this.c;
        if (list != null && list.size() > 0) {
            return false;
        }
        List<bv> list2 = this.e;
        return list2 == null || list2.size() <= 0;
    }
}
