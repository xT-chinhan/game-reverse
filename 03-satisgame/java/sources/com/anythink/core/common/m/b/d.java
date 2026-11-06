package com.anythink.core.common.m.b;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a;
    public static final d b;
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    static {
        a aVar = new a();
        aVar.a = true;
        a = aVar.a();
        a aVar2 = new a();
        aVar2.f = true;
        long seconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        aVar2.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
        b = aVar2.a();
    }

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    d(a aVar) {
        this.d = aVar.a;
        this.e = aVar.b;
        this.f = aVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    public final boolean a() {
        return this.d;
    }

    public final boolean b() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    private int j() {
        return this.g;
    }

    public final boolean d() {
        return this.h;
    }

    public final boolean e() {
        return this.i;
    }

    public final boolean f() {
        return this.j;
    }

    public final int g() {
        return this.k;
    }

    public final int h() {
        return this.l;
    }

    public final boolean i() {
        return this.m;
    }

    private boolean k() {
        return this.n;
    }

    private boolean l() {
        return this.o;
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
    public static d a(u uVar) {
        int i;
        int iA;
        String strTrim;
        int iA2;
        String strTrim2;
        int iA3 = uVar.a();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int iB = -1;
        int iB2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iB3 = -1;
        int iB4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i2 = 0; i2 < iA3; i2++) {
            String strA = uVar.a(i2);
            String strB = uVar.b(i2);
            if (!strA.equalsIgnoreCase("Cache-Control")) {
                if (strA.equalsIgnoreCase("Pragma")) {
                }
            } else {
                if (str == null) {
                    str = strB;
                }
                for (i = 0; i < strB.length(); i = iA2) {
                    iA = com.anythink.core.common.m.b.a.c.e.a(strB, i, "=,;");
                    strTrim = strB.substring(i, iA).trim();
                    if (iA != strB.length() || strB.charAt(iA) == ',' || strB.charAt(iA) == ';') {
                        iA2 = iA + 1;
                        strTrim2 = null;
                    } else {
                        int iA4 = com.anythink.core.common.m.b.a.c.e.a(strB, iA + 1);
                        if (iA4 < strB.length() && strB.charAt(iA4) == '\"') {
                            int i3 = iA4 + 1;
                            int iA5 = com.anythink.core.common.m.b.a.c.e.a(strB, i3, "\"");
                            strTrim2 = strB.substring(i3, iA5);
                            iA2 = iA5 + 1;
                        } else {
                            iA2 = com.anythink.core.common.m.b.a.c.e.a(strB, iA4, ",;");
                            strTrim2 = strB.substring(iA4, iA2).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        iB = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iB2 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iB3 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iB4 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
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
            while (i < strB.length()) {
                iA = com.anythink.core.common.m.b.a.c.e.a(strB, i, "=,;");
                strTrim = strB.substring(i, iA).trim();
                if (iA != strB.length()) {
                    iA2 = iA + 1;
                    strTrim2 = null;
                } else {
                    iA2 = iA + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iB = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iB2 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iB3 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iB4 = com.anythink.core.common.m.b.a.c.e.b(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
        }
        return new d(z2, z3, iB, iB2, z4, z5, z6, iB3, iB4, z7, z8, z9, !z ? null : str);
    }

    public final String toString() {
        String string;
        String str = this.c;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            string = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        this.c = string;
        return string;
    }

    private String m() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        private a b() {
            this.a = true;
            return this;
        }

        private a c() {
            this.b = true;
            return this;
        }

        private a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxAge < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        private a a(TimeUnit timeUnit) {
            long seconds = timeUnit.toSeconds(2147483647L);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        private a b(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("minFresh < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        private a d() {
            this.f = true;
            return this;
        }

        private a e() {
            this.g = true;
            return this;
        }

        private a f() {
            this.h = true;
            return this;
        }

        public final d a() {
            return new d(this);
        }
    }
}
