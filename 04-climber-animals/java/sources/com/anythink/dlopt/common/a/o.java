package com.anythink.dlopt.common.a;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class o extends com.anythink.dlopt.common.a.a {
    private static final String v = "o";
    private static final int w = 20971520;
    private d A;
    private final l x;
    private com.anythink.dlopt.common.a.a.InterfaceC0112a y;
    private long z;

    public o(j jVar, d dVar) {
        Pair<Integer, Boolean> pairA;
        super(jVar);
        this.A = dVar;
        if (dVar != null && (pairA = dVar.a(this.b)) != null) {
            jVar.h = ((Integer) pairA.first).intValue();
            jVar.a(((Boolean) pairA.second).booleanValue());
        }
        this.x = new l.a().a(jVar.b).b(jVar.p ? com.anythink.core.common.v.m.i() : "").a(jVar.h).a(jVar.q()).a(jVar.r()).b().c(jVar.s()).a(new a(this, (byte) 0)).a(com.anythink.dlopt.common.a.a.a.a()).a().c();
    }

    @Override // com.anythink.dlopt.common.a.a
    public final void a(com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112a) {
        this.y = interfaceC0112a;
        this.x.a();
    }

    @Override // com.anythink.dlopt.common.a.a
    public final void b() {
        this.x.b();
    }

    @Override // com.anythink.dlopt.common.a.a
    public final void a() {
        this.x.c();
    }

    private class a implements k {
        private a() {
        }

        /* synthetic */ a(o oVar, byte b) {
            this();
        }

        @Override // com.anythink.dlopt.common.a.k
        public final void a(l.g gVar) {
            String unused = o.v;
            Object[] objArr = new Object[1];
            int i = AnonymousClass1.a[gVar.ordinal()];
            if (i == 2) {
                if (o.this.a != null) {
                    o.this.a.j();
                    return;
                }
                return;
            }
            if (i == 3) {
                if (o.this.a != null) {
                    o.this.a.l();
                }
                if (o.this.y == null || o.this.a == null) {
                    return;
                }
                o.this.y.a(o.this.a, o.this.a.g, o.this.a.h, 2);
                return;
            }
            if (i == 4) {
                if (o.this.a != null) {
                    o.this.a.k();
                }
                if (o.this.y == null || o.this.a == null) {
                    return;
                }
                o.this.y.a(o.this.a, o.this.a.g, o.this.a.h, 3);
                return;
            }
            if (i == 5) {
                if (o.this.a != null) {
                    o.this.a.m();
                }
            } else if (i == 6 && o.this.a != null) {
                o.this.a.o();
            }
        }

        @Override // com.anythink.dlopt.common.a.k
        public final void a(long j, long j2, int i) {
            if (o.this.a != null) {
                if (o.this.a.t() <= 0) {
                    o.this.z = System.currentTimeMillis();
                    o.this.a.a(o.this.z);
                }
                o.this.a.h = j2;
                o.this.a.a(i);
                o.this.a.a(o.this.x.e());
            }
            if (o.this.y != null) {
                o.this.y.a(o.this.a, j, j2);
            }
            if (o.this.A == null || o.this.a == null) {
                return;
            }
            try {
                o.this.A.a(o.this.a.b, (int) j2, o.this.x.e());
            } catch (Throwable unused) {
            }
        }

        @Override // com.anythink.dlopt.common.a.k
        public final void a(long j, long j2) {
            if (o.this.a != null) {
                o.this.a.g = j;
            }
            if (o.this.y != null) {
                o.this.y.b(o.this.a, j, j2);
            }
        }

        @Override // com.anythink.dlopt.common.a.k
        public final void a() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - o.this.z;
            if (o.this.a != null) {
                o.this.a.b(jCurrentTimeMillis);
                o.this.a.i = j;
            }
            if (o.this.y != null) {
                o.this.y.a(o.this.a, j);
            }
        }

        @Override // com.anythink.dlopt.common.a.k
        public final void a(l.c cVar, String str) {
            if (o.this.y != null) {
                o.this.y.a(o.this.a, o.a(cVar, str));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a.o$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.g.values().length];
            a = iArr;
            try {
                iArr[l.g.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.g.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.g.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.g.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.g.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[l.g.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static String b(l.c cVar, String str) {
        String str2;
        if (cVar == l.c.HTTP_STATUS) {
            str2 = "10001";
        } else {
            str2 = cVar == l.c.HTTP_TIMEOUT ? "20001" : "10000";
        }
        return "code[ " + str2 + " ],desc[ " + str + " ]";
    }

    static /* synthetic */ String a(l.c cVar, String str) {
        String str2;
        if (cVar == l.c.HTTP_STATUS) {
            str2 = "10001";
        } else {
            str2 = cVar == l.c.HTTP_TIMEOUT ? "20001" : "10000";
        }
        return "code[ " + str2 + " ],desc[ " + str + " ]";
    }
}
