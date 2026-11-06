package com.anythink.core.common.l.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {
    private static final String e = "AppReqCapInterceptor";
    private static final long f = 24;
    private static final long g = 86400000;
    private volatile boolean h;
    private volatile long i;
    private volatile long j;

    public b(Context context) {
        super(context);
        this.h = false;
        this.i = 0L;
        this.j = 0L;
    }

    @Override // com.anythink.core.common.l.d.d, com.anythink.core.common.l.d.i
    public final com.anythink.core.common.l.c.f a(com.anythink.core.common.l.c.d dVar) {
        com.anythink.core.common.l.c.f fVar = null;
        if (!b(dVar)) {
            return null;
        }
        String strA = dVar.a();
        String strC = c(dVar);
        String strB = b(strA);
        String strC2 = c(strA);
        String str = strA + "_req_first_timestamp";
        try {
            com.anythink.core.common.l.c.f fVarA = super.a(dVar);
            if (fVarA == null) {
                return null;
            }
            try {
                synchronized (this.d) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.anythink.core.common.r.a aVarC = ad.c(this.b, "anythink_app_pl_cl_retry");
                        long jLongValue = ((Long) aVarC.b(strC2, Long.valueOf(f))).longValue();
                        if (fVarA.e()) {
                            if (!this.h) {
                                this.h = true;
                                String str2 = strA + "_agent_event";
                                if (!((Boolean) aVarC.b(str2, Boolean.FALSE)).booleanValue()) {
                                    com.anythink.core.common.t.f.a(this.i, this.j, jLongValue);
                                    aVarC.a(str2, Boolean.TRUE);
                                }
                            }
                        } else {
                            long jLongValue2 = this.i;
                            long jLongValue3 = 0;
                            if (jLongValue2 <= 0) {
                                jLongValue2 = ((Long) aVarC.b(str, 0L)).longValue();
                            }
                            this.i = jLongValue2;
                            if (this.i <= 0) {
                                this.i = jCurrentTimeMillis;
                                aVarC.a(str, Long.valueOf(jCurrentTimeMillis));
                            } else if (jCurrentTimeMillis - this.i < 86400000) {
                                jLongValue3 = ((Long) aVarC.b(strB, 0L)).longValue();
                            } else {
                                jLongValue3 = 0;
                                this.i = jCurrentTimeMillis;
                                aVarC.a(str, Long.valueOf(jCurrentTimeMillis));
                            }
                            long j = 1;
                            if (jLongValue3 >= jLongValue - 1) {
                                long j2 = this.i + 86400000;
                                if (this.c != null) {
                                    this.c.put(strC, Long.valueOf(j2));
                                }
                                long j3 = jLongValue / 4;
                                if (j3 > 1) {
                                    j = j3;
                                }
                                aVarC.a(strC2, Long.valueOf(j));
                                aVarC.a(strC, Long.valueOf(j2));
                            } else {
                                long j4 = jLongValue3 + 1;
                                this.j = j4;
                                aVarC.a(strB, Long.valueOf(j4));
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return fVarA;
            } catch (Throwable unused) {
                fVar = fVarA;
                return fVar;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.anythink.core.common.l.d.i
    public final void a(com.anythink.core.common.l.c.f fVar, com.anythink.core.common.l.c.d dVar) {
        if (!b(dVar) || fVar == null) {
            return;
        }
        synchronized (this.d) {
            try {
                com.anythink.core.common.r.a aVarC = ad.c(this.b, "anythink_app_pl_cl_retry");
                String strA = dVar.a();
                String strC = c(dVar);
                String strC2 = c(strA);
                String strB = b(strA);
                this.c.put(strC, 0L);
                aVarC.a(strC, 0L);
                aVarC.a(strC2, Long.valueOf(f));
                aVarC.a(strB, 0L);
            } catch (Throwable unused) {
            }
        }
    }

    private void d(com.anythink.core.common.l.c.d dVar) {
        try {
            com.anythink.core.common.r.a aVarC = ad.c(this.b, "anythink_app_pl_cl_retry");
            String strA = dVar.a();
            String strC = c(dVar);
            String strC2 = c(strA);
            String strB = b(strA);
            this.c.put(strC, 0L);
            aVarC.a(strC, 0L);
            aVarC.a(strC2, Long.valueOf(f));
            aVarC.a(strB, 0L);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.l.d.d
    protected final boolean b(com.anythink.core.common.l.c.d dVar) {
        return this.b != null && dVar != null && "app_strategy".equals(dVar.b()) && a(dVar.a());
    }

    private boolean a(String str) {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.b).b(s.b().p());
        if (this.b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return (bVarB == null || !bVarB.j()) && p.a(this.b);
    }

    @Override // com.anythink.core.common.l.d.d
    protected final String c(com.anythink.core.common.l.c.d dVar) {
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

    private long a(com.anythink.core.common.r.a aVar, String str) {
        long j = this.i;
        return j <= 0 ? ((Long) aVar.b(str, 0L)).longValue() : j;
    }
}
