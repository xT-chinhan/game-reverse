package com.bytedance.sdk.component.ah.xr;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final d f1039ms = new ms().ms().ah();
    public static final d xr = new ms().xr().ms(Integer.MAX_VALUE, TimeUnit.SECONDS).ah();
    private final int ab;
    String ah;
    private final int c;
    private final boolean ch;
    private final boolean d;
    private final int hi;
    private final boolean ka;
    private final boolean ny;
    private final int sl;
    private final boolean u;
    private final boolean ub;
    private final boolean x;
    private final boolean zb;

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.d = z;
        this.ka = z2;
        this.c = i;
        this.ab = i2;
        this.x = z3;
        this.ny = z4;
        this.ch = z5;
        this.hi = i3;
        this.sl = i4;
        this.zb = z6;
        this.u = z7;
        this.ub = z8;
        this.ah = str;
    }

    d(ms msVar) {
        this.d = msVar.f1040ms;
        this.ka = msVar.xr;
        this.c = msVar.ah;
        this.ab = -1;
        this.x = false;
        this.ny = false;
        this.ch = false;
        this.hi = msVar.d;
        this.sl = msVar.ka;
        this.zb = msVar.c;
        this.u = msVar.ab;
        this.ub = msVar.x;
    }

    public boolean ms() {
        return this.d;
    }

    public boolean xr() {
        return this.ka;
    }

    public int ah() {
        return this.c;
    }

    public boolean d() {
        return this.x;
    }

    public boolean ka() {
        return this.ny;
    }

    public boolean c() {
        return this.ch;
    }

    public int ab() {
        return this.hi;
    }

    public int x() {
        return this.sl;
    }

    public boolean ny() {
        return this.zb;
    }

    public boolean ch() {
        return this.ub;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106  */
    /* JADX WARN: Code duplicated, block: B:57:0x010c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0115  */
    /* JADX WARN: Code duplicated, block: B:60:0x0118  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:86:0x00a6 A[SYNTHETIC] */
    public static d ms(qv qvVar) {
        int i;
        int iMs;
        String strTrim;
        int iMs2;
        String strTrim2;
        int iMs3 = qvVar.ms();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int iXr = -1;
        int iXr2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iXr3 = -1;
        int iXr4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i2 = 0; i2 < iMs3; i2++) {
            String strMs = qvVar.ms(i2);
            String strXr = qvVar.xr(i2);
            if (!strMs.equalsIgnoreCase("Cache-Control")) {
                if (strMs.equalsIgnoreCase("Pragma")) {
                }
            } else {
                if (str == null) {
                    str = strXr;
                }
                for (i = 0; i < strXr.length(); i = iMs2) {
                    iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(strXr, i, "=,;");
                    strTrim = strXr.substring(i, iMs).trim();
                    if (iMs != strXr.length() || strXr.charAt(iMs) == ',' || strXr.charAt(iMs) == ';') {
                        iMs2 = iMs + 1;
                        strTrim2 = null;
                    } else {
                        int iMs4 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(strXr, iMs + 1);
                        if (iMs4 < strXr.length() && strXr.charAt(iMs4) == '\"') {
                            int i3 = iMs4 + 1;
                            int iMs5 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(strXr, i3, "\"");
                            strTrim2 = strXr.substring(i3, iMs5);
                            iMs2 = iMs5 + 1;
                        } else {
                            iMs2 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(strXr, iMs4, ",;");
                            strTrim2 = strXr.substring(iMs4, iMs2).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        iXr = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iXr2 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iXr3 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iXr4 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    }
                }
            }
            z = false;
            while (i < strXr.length()) {
                iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(strXr, i, "=,;");
                strTrim = strXr.substring(i, iMs).trim();
                if (iMs != strXr.length()) {
                    iMs2 = iMs + 1;
                    strTrim2 = null;
                } else {
                    iMs2 = iMs + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iXr = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iXr2 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iXr3 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iXr4 = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
        }
        return new d(z2, z3, iXr, iXr2, z4, z5, z6, iXr3, iXr4, z7, z8, z9, !z ? null : str);
    }

    public String toString() {
        String str = this.ah;
        if (str != null) {
            return str;
        }
        String strHi = hi();
        this.ah = strHi;
        return strHi;
    }

    private String hi() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.ka) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=").append(this.c).append(", ");
        }
        if (this.ab != -1) {
            sb.append("s-maxage=").append(this.ab).append(", ");
        }
        if (this.x) {
            sb.append("private, ");
        }
        if (this.ny) {
            sb.append("public, ");
        }
        if (this.ch) {
            sb.append("must-revalidate, ");
        }
        if (this.hi != -1) {
            sb.append("max-stale=").append(this.hi).append(", ");
        }
        if (this.sl != -1) {
            sb.append("min-fresh=").append(this.sl).append(", ");
        }
        if (this.zb) {
            sb.append("only-if-cached, ");
        }
        if (this.u) {
            sb.append("no-transform, ");
        }
        if (this.ub) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class ms {
        boolean ab;
        boolean c;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1040ms;
        boolean x;
        boolean xr;
        int ah = -1;
        int d = -1;
        int ka = -1;

        public ms ms() {
            this.f1040ms = true;
            return this;
        }

        public ms ms(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public ms xr() {
            this.c = true;
            return this;
        }

        public d ah() {
            return new d(this);
        }
    }
}
