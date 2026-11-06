package com.bytedance.sdk.component.ah.xr.ms.ms;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.qv;
import com.bytedance.sdk.component.ah.xr.yu;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final yu f1107ms;
    public final cv xr;

    ah(yu yuVar, cv cvVar) {
        this.f1107ms = yuVar;
        this.xr = cvVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.sl().d() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean ms(com.bytedance.sdk.component.ah.xr.cv r3, com.bytedance.sdk.component.ah.xr.yu r4) {
        /*
            int r0 = r3.ah()
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
            java.lang.String r0 = r3.ms(r0)
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.ah.xr.d r0 = r3.sl()
            int r0 = r0.ah()
            r1 = -1
            if (r0 != r1) goto L59
            com.bytedance.sdk.component.ah.xr.d r0 = r3.sl()
            boolean r0 = r0.ka()
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.ah.xr.d r0 = r3.sl()
            boolean r0 = r0.d()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.bytedance.sdk.component.ah.xr.d r3 = r3.sl()
            boolean r3 = r3.xr()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.ah.xr.d r3 = r4.ab()
            boolean r3 = r3.xr()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ah.xr.ms.ms.ah.ms(com.bytedance.sdk.component.ah.xr.cv, com.bytedance.sdk.component.ah.xr.yu):boolean");
    }

    public static class ms {
        private String ab;
        final cv ah;
        private Date c;
        private long ch;
        private Date d;
        private String hi;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final long f1108ms;
        private long ny;
        private int sl;
        private Date x;
        final yu xr;

        public ms(long j, yu yuVar, cv cvVar) {
            this.sl = -1;
            this.f1108ms = j;
            this.xr = yuVar;
            this.ah = cvVar;
            if (cvVar != null) {
                this.ny = cvVar.zb();
                this.ch = cvVar.u();
                qv qvVarAb = cvVar.ab();
                int iMs = qvVarAb.ms();
                for (int i = 0; i < iMs; i++) {
                    String strMs = qvVarAb.ms(i);
                    String strXr = qvVarAb.xr(i);
                    if ("Date".equalsIgnoreCase(strMs)) {
                        this.d = com.bytedance.sdk.component.ah.xr.ms.ah.d.ms(strXr);
                        this.ka = strXr;
                    } else if ("Expires".equalsIgnoreCase(strMs)) {
                        this.x = com.bytedance.sdk.component.ah.xr.ms.ah.d.ms(strXr);
                    } else if ("Last-Modified".equalsIgnoreCase(strMs)) {
                        this.c = com.bytedance.sdk.component.ah.xr.ms.ah.d.ms(strXr);
                        this.ab = strXr;
                    } else if ("ETag".equalsIgnoreCase(strMs)) {
                        this.hi = strXr;
                    } else if ("Age".equalsIgnoreCase(strMs)) {
                        this.sl = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strXr, -1);
                    }
                }
            }
        }

        public ah ms() {
            ah ahVarXr = xr();
            return (ahVarXr.f1107ms == null || !this.xr.ab().ny()) ? ahVarXr : new ah(null, null);
        }

        private ah xr() {
            String str;
            if (this.ah == null) {
                return new ah(this.xr, null);
            }
            if (this.xr.x() && this.ah.c() == null) {
                return new ah(this.xr, null);
            }
            if (!ah.ms(this.ah, this.xr)) {
                return new ah(this.xr, null);
            }
            com.bytedance.sdk.component.ah.xr.d dVarAb = this.xr.ab();
            if (dVarAb.ms() || ms(this.xr)) {
                return new ah(this.xr, null);
            }
            com.bytedance.sdk.component.ah.xr.d dVarSl = this.ah.sl();
            if (dVarSl.ch()) {
                return new ah(null, this.ah);
            }
            long jD = d();
            long jAh = ah();
            if (dVarAb.ah() != -1) {
                jAh = Math.min(jAh, TimeUnit.SECONDS.toMillis(dVarAb.ah()));
            }
            long millis = 0;
            long millis2 = dVarAb.x() != -1 ? TimeUnit.SECONDS.toMillis(dVarAb.x()) : 0L;
            if (!dVarSl.c() && dVarAb.ab() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarAb.ab());
            }
            if (!dVarSl.ms()) {
                long j = millis2 + jD;
                if (j < millis + jAh) {
                    cv.ms msVarNy = this.ah.ny();
                    if (j >= jAh) {
                        msVarNy.ms("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jD > 86400000 && ka()) {
                        msVarNy.ms("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new ah(null, msVarNy.ms());
                }
            }
            String str2 = this.hi;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.c != null) {
                    str2 = this.ab;
                } else if (this.d != null) {
                    str2 = this.ka;
                } else {
                    return new ah(this.xr, null);
                }
                str = "If-Modified-Since";
            }
            qv.ms msVarXr = this.xr.ah().xr();
            com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVarXr, str, str2);
            return new ah(this.xr.c().ms(msVarXr.ms()).ms(), this.ah);
        }

        private long ah() {
            com.bytedance.sdk.component.ah.xr.d dVarSl = this.ah.sl();
            if (dVarSl.ah() != -1) {
                return TimeUnit.SECONDS.toMillis(dVarSl.ah());
            }
            if (this.x != null) {
                Date date = this.d;
                long time = this.x.getTime() - (date != null ? date.getTime() : this.ch);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.c != null && this.ah.ms().ms().query() == null) {
                Date date2 = this.d;
                long time2 = (date2 != null ? date2.getTime() : this.ny) - this.c.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long d() {
            Date date = this.d;
            long jMax = date != null ? Math.max(0L, this.ch - date.getTime()) : 0L;
            if (this.sl != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.sl));
            }
            long j = this.ch;
            return jMax + (j - this.ny) + (this.f1108ms - j);
        }

        private boolean ka() {
            return this.ah.sl().ah() == -1 && this.x == null;
        }

        private static boolean ms(yu yuVar) {
            return (yuVar.ms("If-Modified-Since") == null && yuVar.ms("If-None-Match") == null) ? false : true;
        }
    }
}
