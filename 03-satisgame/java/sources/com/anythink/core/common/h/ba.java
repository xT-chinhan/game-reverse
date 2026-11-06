package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ba extends w<bc> {
    public static final int a = 1;
    public static final int b = 2;
    private String aA;
    private String ak;
    private String al;
    private String am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    private String at;
    private long au;
    private int av;
    private String aw;
    private String ax;
    private String ay;
    private String az;
    public int c;
    public long d;
    String e = "";

    @Override // com.anythink.core.common.h.w
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.w
    public final /* synthetic */ List b(y yVar) {
        boolean z;
        bc bcVar = (bc) yVar;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bcVar.n()), "0") && !TextUtils.isEmpty(this.v)) {
            arrayList.add(this.v);
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "2")) {
            String strM = bcVar.m();
            if (!TextUtils.isEmpty(this.v)) {
                arrayList.add(this.v);
            }
            String strD = d(bcVar);
            if (!TextUtils.isEmpty(strD)) {
                arrayList.add(strD);
            }
            if (arrayList.size() == 0) {
                stringBuffer.append(strM).append(" url,");
            }
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "1")) {
            if (!TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
                z = true;
            } else {
                stringBuffer.append("icon_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.s)) {
                arrayList.add(this.s);
            } else {
                stringBuffer.append("full_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.v)) {
                arrayList.add(this.v);
            } else {
                stringBuffer.append("video_u,");
                z = false;
            }
        } else {
            z = true;
        }
        if (TextUtils.equals(new StringBuilder().append(bcVar.n()).toString(), "3")) {
            if (!TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
            } else {
                stringBuffer.append("icon_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.s)) {
                arrayList.add(this.s);
            } else {
                stringBuffer.append("full_u,");
                z = false;
            }
            if (this.A == 1) {
                if (!TextUtils.isEmpty(this.v)) {
                    arrayList.add(this.v);
                } else {
                    stringBuffer.append("video_u,");
                    z = false;
                }
            }
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "4")) {
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
        this.e = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    @Override // com.anythink.core.common.h.w
    public final /* synthetic */ List c(y yVar) {
        bc bcVar = (bc) yVar;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(String.valueOf(bcVar.n()), "2")) {
            String strD = d(bcVar);
            if (!TextUtils.isEmpty(strD) && TextUtils.equals(strD, this.s) && !TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
            }
        }
        return arrayList;
    }

    private String M() {
        return this.aA;
    }

    public final void w(String str) {
        this.aA = str;
    }

    private String N() {
        return this.aw;
    }

    public final void x(String str) {
        this.aw = str;
    }

    private String O() {
        return this.ax;
    }

    public final void y(String str) {
        this.ax = str;
    }

    private String P() {
        return this.ay;
    }

    public final void z(String str) {
        this.ay = str;
    }

    private String Q() {
        return this.az;
    }

    public final void A(String str) {
        this.az = str;
    }

    private int R() {
        return this.av;
    }

    public final void d(int i) {
        this.av = i;
    }

    private String S() {
        return this.ak;
    }

    public final void B(String str) {
        this.ak = str;
    }

    private String T() {
        return this.al;
    }

    public final void C(String str) {
        this.al = str;
    }

    private String U() {
        return this.am;
    }

    public final void D(String str) {
        this.am = str;
    }

    private String V() {
        return this.an;
    }

    public final void E(String str) {
        this.an = str;
    }

    private String W() {
        return this.ao;
    }

    public final void F(String str) {
        this.ao = str;
    }

    private String X() {
        return this.ap;
    }

    public final void G(String str) {
        this.ap = str;
    }

    private String Y() {
        return this.aq;
    }

    public final void H(String str) {
        this.aq = str;
    }

    private String Z() {
        return this.ar;
    }

    public final void I(String str) {
        this.ar = str;
    }

    private String aa() {
        return this.as;
    }

    public final void J(String str) {
        this.as = str;
    }

    private String ab() {
        return this.at;
    }

    public final void K(String str) {
        this.at = str;
    }

    private int ac() {
        return this.c;
    }

    private void e(int i) {
        this.c = i;
    }

    private long ad() {
        return this.d;
    }

    private void b(long j) {
        this.d = j;
    }

    private long ae() {
        return this.au;
    }

    public final void a(long j) {
        this.au = j;
    }

    public final boolean a(bc bcVar) {
        return bcVar == null || System.currentTimeMillis() - this.au > bcVar.t();
    }

    private List<String> b(bc bcVar) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bcVar.n()), "0") && !TextUtils.isEmpty(this.v)) {
            arrayList.add(this.v);
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "2")) {
            String strM = bcVar.m();
            if (!TextUtils.isEmpty(this.v)) {
                arrayList.add(this.v);
            }
            String strD = d(bcVar);
            if (!TextUtils.isEmpty(strD)) {
                arrayList.add(strD);
            }
            if (arrayList.size() == 0) {
                stringBuffer.append(strM).append(" url,");
            }
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "1")) {
            if (!TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
                z = true;
            } else {
                stringBuffer.append("icon_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.s)) {
                arrayList.add(this.s);
            } else {
                stringBuffer.append("full_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.v)) {
                arrayList.add(this.v);
            } else {
                stringBuffer.append("video_u,");
                z = false;
            }
        } else {
            z = true;
        }
        if (TextUtils.equals(new StringBuilder().append(bcVar.n()).toString(), "3")) {
            if (!TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
            } else {
                stringBuffer.append("icon_u,");
                z = false;
            }
            if (!TextUtils.isEmpty(this.s)) {
                arrayList.add(this.s);
            } else {
                stringBuffer.append("full_u,");
                z = false;
            }
            if (this.A == 1) {
                if (!TextUtils.isEmpty(this.v)) {
                    arrayList.add(this.v);
                } else {
                    stringBuffer.append("video_u,");
                    z = false;
                }
            }
        }
        if (TextUtils.equals(String.valueOf(bcVar.n()), "4")) {
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
        this.e = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    private List<String> c(bc bcVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(String.valueOf(bcVar.n()), "2")) {
            String strD = d(bcVar);
            if (!TextUtils.isEmpty(strD) && TextUtils.equals(strD, this.s) && !TextUtils.isEmpty(this.q)) {
                arrayList.add(this.q);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    @Override // com.anythink.core.common.h.w
    public String d(bc bcVar) {
        byte b2;
        if (!TextUtils.equals(String.valueOf(bcVar.n()), "2")) {
            return "";
        }
        switch (bcVar.m()) {
            case "300x250":
                b2 = 1;
                break;
            case "320x50":
                b2 = 3;
                break;
            case "320x90":
                b2 = 0;
                break;
            case "728x90":
                b2 = 2;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 == 2) {
                    if (!TextUtils.isEmpty(this.az)) {
                        return this.az;
                    }
                } else if (!TextUtils.isEmpty(this.aw)) {
                    return this.aw;
                }
            } else if (!TextUtils.isEmpty(this.ay)) {
                return this.ay;
            }
        } else if (!TextUtils.isEmpty(this.ax)) {
            return this.ax;
        }
        return this.s;
    }

    @Override // com.anythink.core.common.h.w
    public final String g() {
        return this.e;
    }

    private String L(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.aA);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                str = str.replaceAll("\\{" + next + "\\}", jSONObject.optString(next));
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
