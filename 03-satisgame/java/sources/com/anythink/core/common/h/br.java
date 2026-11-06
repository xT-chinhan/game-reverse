package com.anythink.core.common.h;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class br {
    com.anythink.core.e.l a;
    n b;
    List<by> c;
    List<by> d;
    List<by> e;
    List<by> f;
    List<by> g;
    int h;

    public br(com.anythink.core.e.l lVar, n nVar, int i) {
        this.a = lVar;
        this.b = nVar;
        this.h = i;
    }

    public final com.anythink.core.e.l a() {
        return this.a;
    }

    public final int b() {
        return this.h;
    }

    public final n c() {
        return this.b;
    }

    public final List<by> d() {
        return this.c;
    }

    public final void a(List<by> list) {
        this.c = list;
    }

    public final List<by> e() {
        return this.d;
    }

    public final void b(List<by> list) {
        this.d = list;
    }

    public final List<by> f() {
        return this.f;
    }

    public final void c(List<by> list) {
        this.f = list;
    }

    public final List<by> g() {
        return this.g;
    }

    public final void d(List<by> list) {
        this.g = list;
    }

    public final List<by> h() {
        return this.e;
    }

    public final void e(List<by> list) {
        this.e = list;
    }

    public final boolean i() {
        List<by> list = this.c;
        if (list != null && list.size() > 0) {
            return true;
        }
        List<by> list2 = this.d;
        if (list2 != null && list2.size() > 0) {
            return true;
        }
        List<by> list3 = this.e;
        if (list3 != null && list3.size() > 0) {
            return true;
        }
        List<by> list4 = this.f;
        if (list4 != null && list4.size() > 0) {
            return true;
        }
        List<by> list5 = this.g;
        return list5 != null && list5.size() > 0;
    }

    public final boolean j() {
        List<by> list = this.f;
        if (list != null && list.size() > 0) {
            return true;
        }
        List<by> list2 = this.g;
        return list2 != null && list2.size() > 0;
    }

    public final boolean k() {
        List<by> list = this.c;
        if (list != null && list.size() > 0) {
            return false;
        }
        List<by> list2 = this.e;
        return list2 == null || list2.size() <= 0;
    }
}
