package com.anythink.core.common.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.v.af;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String a = "HttpReqLimitInterceptor";
    private final Object b = new Object();
    private final Context c;
    private final Map<String, Long> d;
    private final a e;
    private long f;

    public h(Context context, Map<String, Long> map, a aVar) {
        this.c = context;
        this.d = map;
        this.e = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar, com.anythink.core.common.m.b.f fVar) {
        long jLongValue;
        if (fVar == null) {
            return null;
        }
        int i = 1;
        try {
            String strA = a(dVar);
            String str = dVar != null ? dVar.b() + "_req_frist_timestamp" : "";
            String strD = d(dVar);
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (this.b) {
                try {
                    com.anythink.core.common.s.a aVarC = af.c(this.c, "anythink_app_pl_cl_retry");
                    a aVar = this.e;
                    if (aVar == null || aVar.c) {
                        long jLongValue2 = ((Long) aVarC.b(f(dVar), 0L)).longValue();
                        String jSONObject = (String) aVarC.b(e(dVar), "");
                        boolean z = jLongValue2 > 0 && System.currentTimeMillis() - jLongValue2 <= a();
                        Object[] objArr = new Object[2];
                        Boolean.valueOf(z);
                        if (!TextUtils.isEmpty(jSONObject) && z) {
                            jSONObject = new JSONObject(jSONObject);
                            try {
                                fVar.a(jSONObject);
                                fVar.b(200);
                                fVar.a(true);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (!fVar.e()) {
                        long jLongValue3 = this.f;
                        if (jLongValue3 <= 0) {
                            jLongValue3 = ((Long) aVarC.b(str, 0L)).longValue();
                        }
                        this.f = jLongValue3;
                        if (jLongValue3 <= 0 || jCurrentTimeMillis - jLongValue3 >= a()) {
                            this.f = jCurrentTimeMillis;
                            aVarC.a(str, Long.valueOf(jCurrentTimeMillis));
                            jLongValue = 0;
                        } else {
                            jLongValue = ((Long) aVarC.b(strD, 0L)).longValue();
                        }
                        a aVar2 = this.e;
                        if (jLongValue == (aVar2 != null ? aVar2.a : 5) - 1) {
                            if (this.f == 0) {
                                this.f = jCurrentTimeMillis;
                            }
                            long jA = this.f + a();
                            Map<String, Long> map = this.d;
                            if (map != null) {
                                map.put(strA, Long.valueOf(jA));
                            }
                            aVarC.a(strA, Long.valueOf(jA));
                        } else {
                            aVarC.a(strD, Long.valueOf(jLongValue + 1));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        i = 1;
                        Object[] objArr2 = new Object[i];
                        th.getMessage();
                        return fVar;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return fVar;
    }

    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
        Object objG = fVar.g();
        try {
            synchronized (this.b) {
                a aVar = this.e;
                if (aVar != null && aVar.c && objG != null) {
                    af.b(this.c, "anythink_app_pl_cl_retry", e(dVar), objG.toString());
                    af.a(this.c, "anythink_app_pl_cl_retry", f(dVar), System.currentTimeMillis());
                }
                String strA = a(dVar);
                String strD = d(dVar);
                this.d.put(strA, 0L);
                com.anythink.core.common.s.a aVarC = af.c(this.c, "anythink_app_pl_cl_retry");
                aVarC.a(strA, 0L);
                aVarC.a(strD, 0L);
            }
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    public static String a(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.b() + "_req_next_timestamp" : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar, com.anythink.core.common.s.a aVar) {
        a aVar2 = this.e;
        if (aVar2 == null || aVar2.c) {
            long jLongValue = ((Long) aVar.b(f(dVar), 0L)).longValue();
            String jSONObject = (String) aVar.b(e(dVar), "");
            boolean z = jLongValue > 0 && System.currentTimeMillis() - jLongValue <= a();
            Object[] objArr = new Object[2];
            Boolean.valueOf(z);
            if (TextUtils.isEmpty(jSONObject) || !z) {
                return;
            }
            try {
                jSONObject = new JSONObject(jSONObject);
            } catch (Throwable unused) {
            }
            try {
                fVar.a(jSONObject);
                fVar.b(200);
                fVar.a(true);
            } catch (Throwable unused2) {
            }
        }
    }

    private void b(com.anythink.core.common.m.b.d dVar) {
        String strA = a(dVar);
        String strD = d(dVar);
        this.d.put(strA, 0L);
        com.anythink.core.common.s.a aVarC = af.c(this.c, "anythink_app_pl_cl_retry");
        aVarC.a(strA, 0L);
        aVarC.a(strD, 0L);
    }

    private static String c(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.b() + "_req_frist_timestamp" : "";
    }

    private static String d(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.b() + "_req_count" : "";
    }

    private static String e(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.b() + "_data" : "";
    }

    private static String f(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.b() + "_data_timestamp" : "";
    }

    private long a(com.anythink.core.common.s.a aVar, String str) {
        long j = this.f;
        return j <= 0 ? ((Long) aVar.b(str, 0L)).longValue() : j;
    }

    private long a() {
        a aVar = this.e;
        if (aVar != null) {
            return aVar.b;
        }
        return 3600000L;
    }

    private int b() {
        a aVar = this.e;
        if (aVar != null) {
            return aVar.a;
        }
        return 5;
    }

    public static class a {
        public long b;
        public boolean c = true;
        public int a = 5;

        public a(long j) {
            this.b = j;
        }
    }
}
