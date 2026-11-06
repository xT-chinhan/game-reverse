package com.anythink.core.common.n.b.a.a;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.u;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final ad a;
    public final af b;

    c(ad adVar, af afVar) {
        this.a = adVar;
        this.b = afVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.k().d() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.anythink.core.common.n.b.af r3, com.anythink.core.common.n.b.ad r4) {
        /*
            int r0 = r3.c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L59
            com.anythink.core.common.n.b.d r0 = r3.k()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L59
            com.anythink.core.common.n.b.d r0 = r3.k()
            boolean r0 = r0.e()
            if (r0 != 0) goto L59
            com.anythink.core.common.n.b.d r0 = r3.k()
            boolean r0 = r0.d()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.anythink.core.common.n.b.d r3 = r3.k()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            com.anythink.core.common.n.b.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.n.b.a.a.c.a(com.anythink.core.common.n.b.af, com.anythink.core.common.n.b.ad):boolean");
    }

    public static class a {
        final long a;
        final ad b;
        final af c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, ad adVar, af afVar) {
            this.l = -1;
            this.a = j;
            this.b = adVar;
            this.c = afVar;
            if (afVar != null) {
                this.i = afVar.l();
                this.j = afVar.m();
                u uVarF = afVar.f();
                int iA = uVarF.a();
                for (int i = 0; i < iA; i++) {
                    String strA = uVarF.a(i);
                    String strB = uVarF.b(i);
                    if ("Date".equalsIgnoreCase(strA)) {
                        this.d = com.anythink.core.common.n.b.a.c.d.a(strB);
                        this.e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = com.anythink.core.common.n.b.a.c.d.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f = com.anythink.core.common.n.b.a.c.d.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = com.anythink.core.common.n.b.a.c.e.b(strB, -1);
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:57:0x00fc  */
        private c b() {
            long time;
            long time2;
            long time3;
            if (this.c == null) {
                return new c(this.b, null);
            }
            if (this.b.g() && this.c.e() == null) {
                return new c(this.b, null);
            }
            if (!c.a(this.c, this.b)) {
                return new c(this.b, null);
            }
            com.anythink.core.common.n.b.d dVarF = this.b.f();
            if (!dVarF.a()) {
                ad adVar = this.b;
                String str = "If-Modified-Since";
                if (!((adVar.a("If-Modified-Since") == null && adVar.a("If-None-Match") == null) ? false : true)) {
                    com.anythink.core.common.n.b.d dVarK = this.c.k();
                    Date date = this.d;
                    long millis = 0;
                    long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
                    if (this.l != -1) {
                        jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
                    }
                    long j = this.j;
                    long j2 = jMax + (j - this.i) + (this.a - j);
                    com.anythink.core.common.n.b.d dVarK2 = this.c.k();
                    if (dVarK2.c() != -1) {
                        time2 = TimeUnit.SECONDS.toMillis(dVarK2.c());
                    } else if (this.h != null) {
                        Date date2 = this.d;
                        if (date2 != null) {
                            time3 = date2.getTime();
                        } else {
                            time3 = this.j;
                        }
                        time2 = this.h.getTime() - time3;
                        if (time2 <= 0) {
                            time2 = 0;
                        }
                    } else if (this.f == null || this.c.a().a().k() != null) {
                        time2 = 0;
                    } else {
                        Date date3 = this.d;
                        if (date3 != null) {
                            time = date3.getTime();
                        } else {
                            time = this.i;
                        }
                        long time4 = time - this.f.getTime();
                        if (time4 > 0) {
                            time2 = time4 / 10;
                        } else {
                            time2 = 0;
                        }
                    }
                    if (dVarF.c() != -1) {
                        time2 = Math.min(time2, TimeUnit.SECONDS.toMillis(dVarF.c()));
                    }
                    long millis2 = dVarF.h() != -1 ? TimeUnit.SECONDS.toMillis(dVarF.h()) : 0L;
                    if (!dVarK.f() && dVarF.g() != -1) {
                        millis = TimeUnit.SECONDS.toMillis(dVarF.g());
                    }
                    if (!dVarK.a()) {
                        long j3 = millis2 + j2;
                        if (j3 < millis + time2) {
                            af.a aVarH = this.c.h();
                            if (j3 >= time2) {
                                aVarH.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (j2 > 86400000) {
                                if (this.c.k().c() == -1 && this.h == null) {
                                    aVarH.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            return new c(null, aVarH.a());
                        }
                    }
                    String str2 = this.k;
                    if (str2 != null) {
                        str = "If-None-Match";
                    } else if (this.f != null) {
                        str2 = this.g;
                    } else if (this.d != null) {
                        str2 = this.e;
                    } else {
                        return new c(this.b, null);
                    }
                    u.a aVarB = this.b.c().b();
                    com.anythink.core.common.n.b.a.a.a.a(aVarB, str, str2);
                    return new c(this.b.e().a(aVarB.a()).b(), this.c);
                }
            }
            return new c(this.b, null);
        }

        private long c() {
            long time;
            long time2;
            com.anythink.core.common.n.b.d dVarK = this.c.k();
            if (dVarK.c() != -1) {
                return TimeUnit.SECONDS.toMillis(dVarK.c());
            }
            if (this.h != null) {
                Date date = this.d;
                if (date != null) {
                    time2 = date.getTime();
                } else {
                    time2 = this.j;
                }
                long time3 = this.h.getTime() - time2;
                if (time3 > 0) {
                    return time3;
                }
                return 0L;
            }
            if (this.f != null && this.c.a().a().k() == null) {
                Date date2 = this.d;
                if (date2 != null) {
                    time = date2.getTime();
                } else {
                    time = this.i;
                }
                long time4 = time - this.f.getTime();
                if (time4 > 0) {
                    return time4 / 10;
                }
            }
            return 0L;
        }

        private long d() {
            Date date = this.d;
            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            if (this.l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
            }
            long j = this.j;
            return jMax + (j - this.i) + (this.a - j);
        }

        private boolean e() {
            return this.c.k().c() == -1 && this.h == null;
        }

        private static boolean a(ad adVar) {
            return (adVar.a("If-Modified-Since") == null && adVar.a("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Code duplicated, block: B:55:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:86:0x0188  */
        /* JADX WARN: Code duplicated, block: B:88:0x018c  */
        /* JADX WARN: Code duplicated, block: B:89:0x018f  */
        /* JADX WARN: Code duplicated, block: B:91:0x0193  */
        /* JADX WARN: Code duplicated, block: B:92:0x0196  */
        /* JADX WARN: Code duplicated, block: B:94:0x019a  */
        /* JADX WARN: Code duplicated, block: B:96:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:97:0x01d0  */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v20, types: [com.anythink.core.common.n.b.ad, com.anythink.core.common.n.b.af] */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v9 */
        public final c a() {
            ?? r3;
            c cVar;
            long time;
            long time2;
            long time3;
            String str;
            if (this.c == null) {
                cVar = new c(this.b, null);
            } else {
                if ((this.b.g() && this.c.e() == null) || !c.a(this.c, this.b)) {
                    cVar = new c(this.b, null);
                } else {
                    com.anythink.core.common.n.b.d dVarF = this.b.f();
                    if (dVarF.a()) {
                        r3 = 0;
                        cVar = new c(this.b, null);
                    } else {
                        ad adVar = this.b;
                        String str2 = "If-Modified-Since";
                        if ((adVar.a("If-Modified-Since") == null && adVar.a("If-None-Match") == null) ? false : true) {
                            r3 = 0;
                            cVar = new c(this.b, null);
                        } else {
                            com.anythink.core.common.n.b.d dVarK = this.c.k();
                            Date date = this.d;
                            long millis = 0;
                            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
                            if (this.l != -1) {
                                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
                            }
                            long j = this.j;
                            long j2 = jMax + (j - this.i) + (this.a - j);
                            com.anythink.core.common.n.b.d dVarK2 = this.c.k();
                            if (dVarK2.c() != -1) {
                                time2 = TimeUnit.SECONDS.toMillis(dVarK2.c());
                            } else if (this.h != null) {
                                Date date2 = this.d;
                                if (date2 != null) {
                                    time3 = date2.getTime();
                                } else {
                                    time3 = this.j;
                                }
                                time2 = this.h.getTime() - time3;
                                if (time2 <= 0) {
                                    time2 = 0;
                                }
                            } else if (this.f == null || this.c.a().a().k() != null) {
                                time2 = 0;
                            } else {
                                Date date3 = this.d;
                                if (date3 != null) {
                                    time = date3.getTime();
                                } else {
                                    time = this.i;
                                }
                                long time4 = time - this.f.getTime();
                                if (time4 > 0) {
                                    time2 = time4 / 10;
                                } else {
                                    time2 = 0;
                                }
                            }
                            if (dVarF.c() != -1) {
                                time2 = Math.min(time2, TimeUnit.SECONDS.toMillis(dVarF.c()));
                            }
                            long millis2 = dVarF.h() != -1 ? TimeUnit.SECONDS.toMillis(dVarF.h()) : 0L;
                            if (!dVarK.f() && dVarF.g() != -1) {
                                millis = TimeUnit.SECONDS.toMillis(dVarF.g());
                            }
                            if (dVarK.a()) {
                                str = this.k;
                                if (str != null) {
                                    str2 = "If-None-Match";
                                } else if (this.f != null) {
                                    str = this.g;
                                } else if (this.d != null) {
                                    str = this.e;
                                } else {
                                    r3 = 0;
                                    cVar = new c(this.b, null);
                                }
                                u.a aVarB = this.b.c().b();
                                com.anythink.core.common.n.b.a.a.a.a(aVarB, str2, str);
                                cVar = new c(this.b.e().a(aVarB.a()).b(), this.c);
                                r3 = 0;
                            } else {
                                long j3 = millis2 + j2;
                                if (j3 < millis + time2) {
                                    af.a aVarH = this.c.h();
                                    if (j3 >= time2) {
                                        aVarH.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                                    }
                                    if (j2 > 86400000) {
                                        if (this.c.k().c() == -1 && this.h == null) {
                                            aVarH.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                        }
                                    }
                                    r3 = 0;
                                    cVar = new c(null, aVarH.a());
                                } else {
                                    str = this.k;
                                    if (str != null) {
                                        str2 = "If-None-Match";
                                    } else if (this.f != null) {
                                        str = this.g;
                                    } else if (this.d != null) {
                                        str = this.e;
                                    } else {
                                        r3 = 0;
                                        cVar = new c(this.b, null);
                                    }
                                    u.a aVarB2 = this.b.c().b();
                                    com.anythink.core.common.n.b.a.a.a.a(aVarB2, str2, str);
                                    cVar = new c(this.b.e().a(aVarB2.a()).b(), this.c);
                                    r3 = 0;
                                }
                            }
                        }
                    }
                }
                return (cVar.a == null || !this.b.f().i()) ? cVar : new c(r3, r3);
            }
            r3 = 0;
            if (cVar.a == null) {
                return cVar;
            }
        }
    }
}
