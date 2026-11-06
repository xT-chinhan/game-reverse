package com.anythink.core.common.m.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final long k = 30000;
    private static final long l = 30000;
    private static final long m = 30000;
    private static final TimeUnit n = TimeUnit.MILLISECONDS;
    public long a;
    public TimeUnit b;
    public long c;
    public TimeUnit d;
    public long e;
    public TimeUnit f;
    public ExecutorService g;
    public final List<e> h;
    public d i;
    public int j;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.h = new ArrayList();
    }

    public static class a {
        private ExecutorService h;
        private d i;
        private int j;
        private long b = 30000;
        private TimeUnit c = f.n;
        private long d = 30000;
        private TimeUnit e = f.n;
        private long f = 30000;
        private TimeUnit g = f.n;
        final List<e> a = new ArrayList();

        public final a a(ExecutorService executorService) {
            this.h = executorService;
            return this;
        }

        public final a a(TimeUnit timeUnit) {
            this.b = 60000L;
            this.c = timeUnit;
            return this;
        }

        public final a b(TimeUnit timeUnit) {
            this.d = 60000L;
            this.e = timeUnit;
            return this;
        }

        public final a c(TimeUnit timeUnit) {
            this.f = 60000L;
            this.g = timeUnit;
            return this;
        }

        public final a a(d dVar) {
            this.i = dVar;
            return this;
        }

        public final a a(int i) {
            this.j = i;
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
            fVar.g = this.h;
            fVar.i = this.i;
            fVar.j = this.j;
            if (!this.a.isEmpty()) {
                fVar.h.addAll(new ArrayList(this.a));
            }
            return fVar;
        }
    }
}
