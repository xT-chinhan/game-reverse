package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class bj extends w<bk> {
    public static final int ao = 1;
    public static final int ap = 2;
    public static final int aq = 3;
    public static final int ar = 4;
    public static final int as = 5;
    public static final int at = 6;
    long aA;
    long aB;
    private String aD;
    private String aE;
    private String aF;
    private String aG;
    private String aH;
    private int aI;
    private int aJ;
    long ak;
    String al;
    String am;
    int an;
    String au;
    String av;
    bl aw;
    int ax;
    String ay;
    long az;
    private int b;
    private int c;
    private int d;
    private int e;
    private final String a = getClass().getSimpleName();
    String aC = "";

    @Override // com.anythink.core.common.h.w
    public final /* synthetic */ List b(y yVar) {
        bk bkVar = (bk) yVar;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(new StringBuilder().append(bkVar.D()).toString(), "2") && this.an == 3 && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        if (TextUtils.equals(String.valueOf(bkVar.D()), "4") && 1 != this.an && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        return arrayList;
    }

    public final void b(long j) {
        this.az = j;
        this.aB = this.aA + j;
    }

    public final void c(long j) {
        this.aA = j;
    }

    public final boolean ax() {
        return System.currentTimeMillis() >= this.aB;
    }

    public final void d(long j) {
        this.aB = j;
    }

    public final long ay() {
        return this.aB;
    }

    private long d() {
        return this.az;
    }

    public final String az() {
        return this.aD;
    }

    public final void X(String str) {
        this.aD = str;
    }

    public final String aA() {
        return this.aE;
    }

    public final void Y(String str) {
        this.aE = str;
    }

    public final String aB() {
        return this.aF;
    }

    public final void Z(String str) {
        this.aF = str;
    }

    public final String aC() {
        return this.aG;
    }

    public final void aa(String str) {
        this.aG = str;
    }

    public final String aD() {
        return this.aH;
    }

    public final void ab(String str) {
        this.aH = str;
    }

    public final int aE() {
        return this.aI;
    }

    public final void r(int i) {
        this.aI = i;
    }

    public final int aF() {
        return this.aJ;
    }

    public final void s(int i) {
        this.aJ = i;
    }

    private int e() {
        return this.ax;
    }

    private void a(int i) {
        this.ax = i;
    }

    public final bl aG() {
        return this.aw;
    }

    public final void a(bl blVar) {
        this.aw = blVar;
    }

    private long f() {
        return this.ak;
    }

    public final void e(long j) {
        this.ak = j;
    }

    private String g() {
        return this.al;
    }

    public final void ac(String str) {
        this.al = str;
    }

    public final String aH() {
        return this.am;
    }

    public final void ad(String str) {
        this.am = str;
    }

    public final int aI() {
        return this.an;
    }

    public final void t(int i) {
        this.an = i;
    }

    public final String aJ() {
        return this.au;
    }

    public final void ae(String str) {
        this.au = str;
    }

    private String aL() {
        return this.av;
    }

    public final void af(String str) {
        this.av = str;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0144  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    @Override // com.anythink.core.common.h.w
    public final List<String> a(bk bkVar) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bkVar.D()), "0") && !TextUtils.isEmpty(this.v)) {
            arrayList.add(this.v);
        }
        if (TextUtils.equals(String.valueOf(bkVar.D()), "1")) {
            if (n()) {
                z = true;
            } else {
                if (!TextUtils.isEmpty(this.q)) {
                    arrayList.add(this.q);
                }
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                    z = true;
                } else {
                    stringBuffer.append("full_u,");
                    z = false;
                }
            }
            if (!TextUtils.isEmpty(this.v)) {
                arrayList.add(this.v);
            } else {
                if (bkVar.an() == 1 || bkVar.ao() > 0) {
                    if (bkVar.ao() != 1) {
                        if (!TextUtils.isEmpty(this.s)) {
                            if (!arrayList.contains(this.s)) {
                                arrayList.add(this.s);
                            }
                        } else {
                            stringBuffer.append("full_u,");
                        }
                    }
                } else {
                    stringBuffer.append("video_u,");
                }
                z = false;
            }
        } else {
            z = true;
        }
        if (TextUtils.equals(String.valueOf(bkVar.D()), "3")) {
            if (!n()) {
                if (!TextUtils.isEmpty(this.q)) {
                    arrayList.add(this.q);
                }
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                } else {
                    stringBuffer.append("full_u,");
                    z = false;
                }
            }
            if (L() && (this.A == 1 || bkVar.aG())) {
                arrayList.add(this.v);
            }
        }
        if (TextUtils.equals(new StringBuilder().append(bkVar.D()).toString(), "2")) {
            int i = this.an;
            if (i != 1) {
                if (i == 2) {
                    if (TextUtils.isEmpty(this.au)) {
                        stringBuffer.append("img_list,");
                        z = false;
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        if (TextUtils.isEmpty(this.au)) {
                            stringBuffer.append("img_list,");
                            z = false;
                        }
                    }
                } else if (TextUtils.isEmpty(this.v)) {
                    if (!TextUtils.isEmpty(this.s)) {
                        arrayList.add(this.s);
                    } else {
                        stringBuffer.append("full_u,");
                        z = false;
                    }
                } else {
                    arrayList.add(this.v);
                    if (!TextUtils.isEmpty(this.s)) {
                        arrayList.add(this.s);
                    }
                }
            } else if (TextUtils.isEmpty(this.v)) {
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                } else {
                    stringBuffer.append("full_u,");
                    z = false;
                }
            } else {
                arrayList.add(this.v);
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                }
            }
        }
        if (TextUtils.equals(String.valueOf(bkVar.D()), "4")) {
            if (TextUtils.isEmpty(this.v)) {
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                } else {
                    stringBuffer.append("full_u,");
                    z = false;
                }
            } else {
                arrayList.add(this.v);
                if (!TextUtils.isEmpty(this.s)) {
                    arrayList.add(this.s);
                }
            }
        }
        if (z) {
            return arrayList;
        }
        this.aC = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    private List<String> b(bk bkVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(new StringBuilder().append(bkVar.D()).toString(), "2") && this.an == 3 && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        if (TextUtils.equals(String.valueOf(bkVar.D()), "4") && 1 != this.an && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        return arrayList;
    }

    @Override // com.anythink.core.common.h.w
    public String a() {
        return this.aC;
    }

    public final String aK() {
        return this.ay;
    }

    public final void ag(String str) {
        this.ay = str;
    }

    private int aM() {
        return this.b;
    }

    public final void u(int i) {
        this.b = i;
    }

    private int aN() {
        return this.c;
    }

    public final void v(int i) {
        this.c = i;
    }

    private int aO() {
        return this.d;
    }

    public final void w(int i) {
        this.d = i;
    }

    private int aP() {
        return this.e;
    }

    public final void x(int i) {
        this.e = i;
    }

    public final boolean a(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                return this.b == 1;
            }
            return this.c == 1;
        }
        if (z2) {
            return this.d == 1;
        }
        return this.e == 1;
    }
}
