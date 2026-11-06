package com.anythink.core.common.h;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ae {
    Map<String, Object> a;
    d b;
    ATAdRequest c;
    ATAdInfo d;
    private boolean e = true;

    public final Map<String, Object> a() {
        return this.a;
    }

    public final void a(Map<String, Object> map) {
        this.a = map;
    }

    public final d b() {
        return this.b;
    }

    public final void a(d dVar) {
        this.b = dVar;
    }

    public final ATAdInfo c() {
        return this.d;
    }

    public final void a(ATAdInfo aTAdInfo) {
        this.d = aTAdInfo;
    }

    public final ATAdRequest d() {
        return this.c;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.c = aTAdRequest;
    }

    public final boolean e() {
        return this.e;
    }

    public final void f() {
        this.e = false;
    }
}
