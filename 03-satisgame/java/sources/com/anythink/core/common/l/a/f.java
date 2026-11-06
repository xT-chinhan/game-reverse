package com.anythink.core.common.l.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final long j = 30000;
    private static final long k = 30000;
    private static final long l = 30000;
    private static final TimeUnit m = TimeUnit.MILLISECONDS;
    public long a;
    public TimeUnit b;
    public long c;
    public TimeUnit d;
    public long e;
    public TimeUnit f;
    public final List<e> g;
    public d h;
    public int i;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.g = new ArrayList();
    }

    public static class a {
        private d h;
        private int i;
        private long b = 30000;
        private TimeUnit c = f.m;
        private long d = 30000;
        private TimeUnit e = f.m;
        private long f = 30000;
        private TimeUnit g = f.m;
        final List<e> a = new ArrayList();

        public final a a(TimeUnit timeUnit) {
            this.b = 30000L;
            this.c = timeUnit;
            return this;
        }

        public final a b(TimeUnit timeUnit) {
            this.d = 15000L;
            this.e = timeUnit;
            return this;
        }

        public final a c(TimeUnit timeUnit) {
            this.f = 10000L;
            this.g = timeUnit;
            return this;
        }

        public final a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public final a a(int i) {
            this.i = i;
            return this;
        }

        public final f a() {
            f fVar = new f((byte) 0);
            fVar.e = this.f;
            fVar.f = this.g;
            fVar.c = this.d;
            fVar.d = this.e;
            fVar.a = this.b;
            fVar.b = this.c;
            fVar.h = this.h;
            fVar.i = this.i;
            if (!this.a.isEmpty()) {
                fVar.g.addAll(new ArrayList(this.a));
            }
            return fVar;
        }
    }
}
