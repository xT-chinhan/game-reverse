package com.anythink.core.common.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {
    private static final String e = "AppReqCapInterceptor";
    private static final long f = 24;
    private static final long g = 86400000;
    private volatile boolean h;
    private volatile long i;

    public b(Context context) {
        super(context);
        this.h = false;
        this.i = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a6 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:20:0x007c, B:22:0x0084, B:25:0x009e, B:27:0x00a6, B:29:0x00ad, B:30:0x00b6, B:34:0x00bf, B:41:0x010c, B:35:0x00ce, B:24:0x0095, B:36:0x00d8, B:38:0x00de, B:40:0x0102), top: B:57:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ad A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:20:0x007c, B:22:0x0084, B:25:0x009e, B:27:0x00a6, B:29:0x00ad, B:30:0x00b6, B:34:0x00bf, B:41:0x010c, B:35:0x00ce, B:24:0x0095, B:36:0x00d8, B:38:0x00de, B:40:0x0102), top: B:57:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:20:0x007c, B:22:0x0084, B:25:0x009e, B:27:0x00a6, B:29:0x00ad, B:30:0x00b6, B:34:0x00bf, B:41:0x010c, B:35:0x00ce, B:24:0x0095, B:36:0x00d8, B:38:0x00de, B:40:0x0102), top: B:57:0x0057 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.anythink.core.common.m.b.d] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v16 */
    /* JADX WARN: Type inference failed for: r19v17 */
    /* JADX WARN: Type inference failed for: r19v18 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.anythink.core.common.m.b.f] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.anythink.core.common.m.b.f] */
    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.i
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        com.anythink.core.common.m.b.f fVar;
        com.anythink.core.common.m.b.f fVar2;
        long j;
        long j2;
        long j3;
        ?? r2 = 0;
        if (!b((com.anythink.core.common.m.b.d) dVar)) {
            return null;
        }
        String strA = dVar.a();
        String strC = c((com.anythink.core.common.m.b.d) dVar);
        String strB = b(strA);
        String strC2 = c(strA);
        String str = strA + "_req_first_timestamp";
        try {
            com.anythink.core.common.m.b.f fVarA = super.a((com.anythink.core.common.m.b.d) dVar);
            if (fVarA == null) {
                return null;
            }
            try {
                synchronized (this.d) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.anythink.core.common.s.a aVarC = af.c(this.b, "anythink_app_pl_cl_retry");
                        long jLongValue = ((Long) aVarC.b(strC2, Long.valueOf(f))).longValue();
                        try {
                            if (fVarA.e()) {
                                com.anythink.core.common.m.b.f fVar3 = fVarA;
                                if (!this.h) {
                                    this.h = true;
                                    String str2 = strA + "_agent_event";
                                    if (!((Boolean) aVarC.b(str2, Boolean.FALSE)).booleanValue()) {
                                        dVar = fVar3;
                                        dVar = fVar3;
                                        com.anythink.core.common.u.e.a(this.i, jLongValue);
                                        aVarC.a(str2, Boolean.TRUE);
                                        dVar = fVar3;
                                    }
                                }
                            } else {
                                long jLongValue2 = this.i;
                                long jLongValue3 = 0;
                                if (jLongValue2 <= 0) {
                                    jLongValue2 = ((Long) aVarC.b(str, 0L)).longValue();
                                }
                                this.i = jLongValue2;
                                if (this.i > 0) {
                                    com.anythink.core.common.m.b.f fVar4 = fVarA;
                                    fVar = fVar4;
                                    if (jCurrentTimeMillis - this.i < 86400000) {
                                        jLongValue3 = ((Long) aVarC.b(strB, 0L)).longValue();
                                        fVar2 = fVar4;
                                    }
                                    j = 1;
                                    if (jLongValue3 >= jLongValue - 1) {
                                        j2 = this.i + 86400000;
                                        if (this.c != null) {
                                            this.c.put(strC, Long.valueOf(j2));
                                        }
                                        j3 = jLongValue / 4;
                                        if (j3 <= 1) {
                                            j = j3;
                                        }
                                        aVarC.a(strC2, Long.valueOf(j));
                                        aVarC.a(strC, Long.valueOf(j2));
                                        dVar = fVar2;
                                    } else {
                                        aVarC.a(strB, Long.valueOf(jLongValue3 + 1));
                                        dVar = fVar2;
                                    }
                                } else {
                                    fVar = fVarA;
                                }
                                this.i = jCurrentTimeMillis;
                                aVarC.a(str, Long.valueOf(jCurrentTimeMillis));
                                fVar2 = fVar;
                                j = 1;
                                if (jLongValue3 >= jLongValue - 1) {
                                    j2 = this.i + 86400000;
                                    if (this.c != null) {
                                        this.c.put(strC, Long.valueOf(j2));
                                    }
                                    j3 = jLongValue / 4;
                                    if (j3 <= 1) {
                                        j = j3;
                                    }
                                    aVarC.a(strC2, Long.valueOf(j));
                                    aVarC.a(strC, Long.valueOf(j2));
                                    dVar = fVar2;
                                } else {
                                    aVarC.a(strB, Long.valueOf(jLongValue3 + 1));
                                    dVar = fVar2;
                                }
                            }
                            return dVar;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                                r2 = dVar;
                                Object[] objArr = new Object[1];
                                th.getMessage();
                                return r2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dVar = fVarA;
                    }
                }
                throw th;
            } catch (Throwable th4) {
                th = th4;
                dVar = fVarA;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.anythink.core.common.m.c.i
    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
        if (!b(dVar) || fVar == null) {
            return;
        }
        synchronized (this.d) {
            Object[] objArr = new Object[3];
            fVar.b();
            Long.valueOf(fVar.d());
            Integer.valueOf(fVar.c());
            try {
                com.anythink.core.common.s.a aVarC = af.c(this.b, "anythink_app_pl_cl_retry");
                String strA = dVar.a();
                String strC = c(dVar);
                String strC2 = c(strA);
                String strB = b(strA);
                this.c.put(strC, 0L);
                aVarC.a(strC, 0L);
                aVarC.a(strC2, Long.valueOf(f));
                aVarC.a(strB, 0L);
                Object[] objArr2 = new Object[1];
            } catch (Throwable th) {
                Object[] objArr3 = new Object[1];
                th.getMessage();
            }
        }
    }

    private void b(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
        Object[] objArr = new Object[3];
        fVar.b();
        Long.valueOf(fVar.d());
        Integer.valueOf(fVar.c());
        try {
            com.anythink.core.common.s.a aVarC = af.c(this.b, "anythink_app_pl_cl_retry");
            String strA = dVar.a();
            String strC = c(dVar);
            String strC2 = c(strA);
            String strB = b(strA);
            this.c.put(strC, 0L);
            aVarC.a(strC, 0L);
            aVarC.a(strC2, Long.valueOf(f));
            aVarC.a(strB, 0L);
            Object[] objArr2 = new Object[1];
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }

    @Override // com.anythink.core.common.m.c.d
    protected final boolean b(com.anythink.core.common.m.b.d dVar) {
        return this.b != null && dVar != null && com.anythink.core.common.m.b.g.b.equals(dVar.b()) && a(dVar.a());
    }

    private boolean a(String str) {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.b).b(t.b().p());
        if (this.b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return (bVarB == null || !bVarB.k()) && q.a(this.b);
    }

    @Override // com.anythink.core.common.m.c.d
    protected final String c(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.a() + "_req_next_time" : "";
    }

    private static String b(String str) {
        return str + "_req_count";
    }

    private static String c(String str) {
        return str + "_req_count_limit";
    }

    private static String d(String str) {
        return str + "_req_first_timestamp";
    }

    private static String e(String str) {
        return str + "_agent_event";
    }

    private long a(com.anythink.core.common.s.a aVar, String str) {
        long j = this.i;
        return j <= 0 ? ((Long) aVar.b(str, 0L)).longValue() : j;
    }
}
