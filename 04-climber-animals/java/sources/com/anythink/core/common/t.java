package com.anythink.core.common;

import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.umeng.analytics.pro.bv;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static volatile t c;
    private String b = bv.aI;
    AtomicInteger a = new AtomicInteger(0);

    private t() {
    }

    public static t a() {
        if (c == null) {
            synchronized (t.class) {
                if (c == null) {
                    c = new t();
                }
            }
        }
        return c;
    }

    public final void a(final int i, final String str, final String str2, final String str3, final String str4) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.t.1
            @Override // java.lang.Runnable
            public final void run() {
                aq aqVar = new aq();
                aqVar.b = i;
                aqVar.d = str;
                aqVar.c = str2;
                aqVar.e = str3;
                aqVar.f = System.currentTimeMillis();
                aqVar.a = com.anythink.core.common.v.o.a(new StringBuilder().append(str).append(aqVar.f).append(str3).toString() != null ? str3 : "");
                aqVar.g = str4;
                String unused = t.this.b;
                aqVar.a();
                com.anythink.core.common.e.k.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).a(aqVar);
            }
        }, 16);
    }

    public final synchronized void b() {
        List<aq> listA;
        int iOptInt;
        if (this.a.get() <= 0 && (listA = com.anythink.core.common.e.k.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).a()) != null && listA.size() > 0) {
            this.a.set(listA.size());
            this.a.get();
            for (final aq aqVar : listA) {
                if (System.currentTimeMillis() - aqVar.f >= 604800000) {
                    this.a.decrementAndGet();
                    com.anythink.core.common.e.k.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).b(aqVar);
                } else {
                    try {
                        iOptInt = new JSONObject(aqVar.g).optInt(aq.h);
                    } catch (Throwable unused) {
                        iOptInt = 1000;
                    }
                    if (aqVar.b == 3) {
                        new com.anythink.core.common.m.d.c(aqVar.e, iOptInt).a(new com.anythink.core.common.m.d.d.a() { // from class: com.anythink.core.common.t.2
                            @Override // com.anythink.core.common.m.d.d.a
                            public final void a(Object obj) {
                                String unused2 = t.this.b;
                                aqVar.a();
                                com.anythink.core.common.e.k.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).b(aqVar);
                                t.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.m.d.d.a
                            public final void a(Throwable th) {
                                String unused2 = t.this.b;
                                aqVar.a();
                                th.getMessage();
                                t.this.a.decrementAndGet();
                            }
                        });
                    } else {
                        final com.anythink.core.common.m.u uVar = new com.anythink.core.common.m.u(aqVar);
                        if (iOptInt == 1001) {
                            uVar.s();
                        }
                        uVar.a(0, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.t.3
                            @Override // com.anythink.core.common.m.q
                            public final void onLoadStart(int i) {
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadFinish(int i, Object obj) {
                                String unused2 = t.this.b;
                                aqVar.a();
                                com.anythink.core.common.e.k.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).b(uVar.t());
                                t.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadError(int i, String str, AdError adError) {
                                String unused2 = t.this.b;
                                aqVar.a();
                                t.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadCanceled(int i) {
                                t.this.a.decrementAndGet();
                            }
                        });
                    }
                }
            }
        }
    }
}
