package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class bl extends w<bm> {
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
    bn aw;
    int ax;
    String ay;
    long az;
    private int b;
    private int c;
    private int d;
    private int e;
    private final String a = getClass().getSimpleName();
    String aC = "";

    /* JADX WARN: Code duplicated, block: B:76:0x0146  */
    /* JADX WARN: Code duplicated, block: B:78:0x014e  */
    @Override // com.anythink.core.common.h.w
    public final /* synthetic */ List b(y yVar) {
        boolean z;
        bm bmVar = (bm) yVar;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bmVar.n()), "0") && !TextUtils.isEmpty(this.v)) {
            arrayList.add(this.v);
        }
        if (TextUtils.equals(String.valueOf(bmVar.n()), "1")) {
            if (e()) {
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
                if (bmVar.z() == 1 || bmVar.A() > 0) {
                    if (bmVar.A() != 1) {
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
        if (TextUtils.equals(String.valueOf(bmVar.n()), "3")) {
            if (!e()) {
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
            if (v() && (this.A == 1 || bmVar.E())) {
                arrayList.add(this.v);
            }
        }
        if (TextUtils.equals(new StringBuilder().append(bmVar.n()).toString(), "2")) {
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
        if (TextUtils.equals(String.valueOf(bmVar.n()), "4")) {
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

    @Override // com.anythink.core.common.h.w
    public final /* synthetic */ List c(y yVar) {
        bm bmVar = (bm) yVar;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(new StringBuilder().append(bmVar.n()).toString(), "2") && this.an == 3 && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        if (TextUtils.equals(String.valueOf(bmVar.n()), "4") && 1 != this.an && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        return arrayList;
    }

    private void a(long j) {
        this.az = j;
        this.aB = this.aA + j;
    }

    private void b(long j) {
        this.aA = j;
    }

    private boolean Q() {
        return System.currentTimeMillis() >= this.aB;
    }

    private void c(long j) {
        this.aB = j;
    }

    public final long M() {
        return this.aB;
    }

    private long R() {
        return this.az;
    }

    private String S() {
        return this.aD;
    }

    private void w(String str) {
        this.aD = str;
    }

    private String T() {
        return this.aE;
    }

    private void x(String str) {
        this.aE = str;
    }

    private String U() {
        return this.aF;
    }

    private void y(String str) {
        this.aF = str;
    }

    public final String N() {
        return this.aG;
    }

    private void z(String str) {
        this.aG = str;
    }

    private String V() {
        return this.aH;
    }

    private void A(String str) {
        this.aH = str;
    }

    private int W() {
        return this.aI;
    }

    private void d(int i) {
        this.aI = i;
    }

    private int X() {
        return this.aJ;
    }

    private void e(int i) {
        this.aJ = i;
    }

    private int Y() {
        return this.ax;
    }

    private void f(int i) {
        this.ax = i;
    }

    private bn Z() {
        return this.aw;
    }

    private void a(bn bnVar) {
        this.aw = bnVar;
    }

    private long aa() {
        return this.ak;
    }

    private void d(long j) {
        this.ak = j;
    }

    private String ab() {
        return this.al;
    }

    private void B(String str) {
        this.al = str;
    }

    private String ac() {
        return this.am;
    }

    private void C(String str) {
        this.am = str;
    }

    public final int O() {
        return this.an;
    }

    private void g(int i) {
        this.an = i;
    }

    public final String P() {
        return this.au;
    }

    private void D(String str) {
        this.au = str;
    }

    private String ad() {
        return this.av;
    }

    private void E(String str) {
        this.av = str;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0144  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    private List<String> a(bm bmVar) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bmVar.n()), "0") && !TextUtils.isEmpty(this.v)) {
            arrayList.add(this.v);
        }
        if (TextUtils.equals(String.valueOf(bmVar.n()), "1")) {
            if (e()) {
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
                if (bmVar.z() == 1 || bmVar.A() > 0) {
                    if (bmVar.A() != 1) {
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
        if (TextUtils.equals(String.valueOf(bmVar.n()), "3")) {
            if (!e()) {
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
            if (v() && (this.A == 1 || bmVar.E())) {
                arrayList.add(this.v);
            }
        }
        if (TextUtils.equals(new StringBuilder().append(bmVar.n()).toString(), "2")) {
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
        if (TextUtils.equals(String.valueOf(bmVar.n()), "4")) {
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

    private List<String> b(bm bmVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(new StringBuilder().append(bmVar.n()).toString(), "2") && this.an == 3 && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        if (TextUtils.equals(String.valueOf(bmVar.n()), "4") && 1 != this.an && !TextUtils.isEmpty(this.q)) {
            arrayList.add(this.q);
        }
        return arrayList;
    }

    @Override // com.anythink.core.common.h.w
    public final String g() {
        return this.aC;
    }

    private String ae() {
        return this.ay;
    }

    private void F(String str) {
        this.ay = str;
    }

    private int af() {
        return this.b;
    }

    private void h(int i) {
        this.b = i;
    }

    private int ag() {
        return this.c;
    }

    private void i(int i) {
        this.c = i;
    }

    private int ah() {
        return this.d;
    }

    private void j(int i) {
        this.d = i;
    }

    private int ai() {
        return this.e;
    }

    private void k(int i) {
        this.e = i;
    }

    private boolean a(boolean z, boolean z2) {
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
