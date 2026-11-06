package com.anythink.basead.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.l.c.ah;
import com.anythink.basead.l.c.at;
import com.anythink.basead.l.c.k;
import com.anythink.basead.l.c.l;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String d = "d";
    c a;
    private Context e;
    private r f;
    private x g;
    private a i;
    private long j;
    private boolean l = true;
    String b = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"/><meta name=\"viewport\"content=\"width=device-width, initial-scale=1.0\"/><title>TopOn</title></head><body>%s</body></html>";
    String c = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"/><meta name=\"viewport\"content=\"width=device-width, initial-scale=1.0\"/><title>TopOn</title></head>%s</html>";
    private a h = new a() { // from class: com.anythink.basead.l.d.1
        /* JADX WARN: Code duplicated, block: B:7:0x0038  */
        @Override // com.anythink.basead.l.d.a
        public final void a(r rVar) {
            boolean z;
            String strA;
            String string = "";
            if (d.this.f.n()) {
                z = true;
                strA = "";
            } else {
                r rVar2 = d.this.f;
                bk bkVar = (bk) d.this.g.o;
                x unused = d.this.g;
                if (rVar2.a(bkVar) == null) {
                    z = false;
                    strA = d.this.f.a();
                } else {
                    z = true;
                    strA = "";
                }
            }
            String unused2 = d.d;
            System.currentTimeMillis();
            long unused3 = d.this.j;
            if (d.this.l) {
                if (z) {
                    x xVar = d.this.g;
                    String str = d.this.g.c;
                    String strAC = d.this.f.aC();
                    String strV = d.this.f.v();
                    long jCurrentTimeMillis = System.currentTimeMillis() - d.this.j;
                    String string2 = new StringBuilder().append(d.this.k).toString();
                    String strE = d.this.f.E();
                    String strH = d.this.f.H();
                    String string3 = d.this.f.aG().f() != null ? Arrays.toString(d.this.f.aG().f()) : "";
                    if (d.this.a != null && d.this.a.a().size() > 0) {
                        string = d.this.a.a().toString();
                    }
                    com.anythink.core.common.u.e.a(xVar, str, strAC, strV, "1", jCurrentTimeMillis, "", string2, strE, strH, string3, string);
                } else {
                    x xVar2 = d.this.g;
                    String str2 = d.this.g.c;
                    String strAC2 = d.this.f.aC();
                    String strV2 = d.this.f.v();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - d.this.j;
                    String string4 = new StringBuilder().append(d.this.k).toString();
                    String strE2 = d.this.f.E();
                    String strH2 = d.this.f.H();
                    String string5 = d.this.f.aG().f() != null ? Arrays.toString(d.this.f.aG().f()) : "";
                    if (d.this.a != null && d.this.a.a().size() > 0) {
                        string = d.this.a.a().toString();
                    }
                    com.anythink.core.common.u.e.a(xVar2, str2, strAC2, strV2, "-4", jCurrentTimeMillis2, strA, string4, strE2, strH2, string5, string);
                }
            }
            if (d.this.i != null) {
                d.this.i.a(rVar);
            }
        }

        @Override // com.anythink.basead.l.d.a
        public final void a(String str, String str2) {
            if (d.this.l) {
                com.anythink.core.common.u.e.a(d.this.g, d.this.g.c, d.this.f.aC(), d.this.f.v(), str, System.currentTimeMillis() - d.this.j, str2, new StringBuilder().append(d.this.k).toString(), d.this.f.E(), d.this.f.H(), d.this.f.aG().f() != null ? Arrays.toString(d.this.f.aG().f()) : "", (d.this.a == null || d.this.a.a().size() <= 0) ? "" : d.this.a.a().toString());
            }
            if (d.this.i != null) {
                d.this.i.a(str, str2);
            }
        }
    };
    private int k = -1;

    public interface a {
        void a(r rVar);

        void a(String str, String str2);
    }

    public d(Context context, r rVar, x xVar) {
        this.e = context;
        this.f = rVar;
        this.g = xVar;
    }

    public final void a(a aVar) {
        String strAf = this.f.af();
        this.i = aVar;
        this.j = System.currentTimeMillis();
        this.l = true;
        c cVar = new c(this.g, new c.a() { // from class: com.anythink.basead.l.d.2
            @Override // com.anythink.basead.l.c.a
            public final void a(int i, String str) {
                String unused = d.d;
                if (d.this.h != null) {
                    d.this.h.a(String.valueOf(i), str);
                }
            }

            @Override // com.anythink.basead.l.c.a
            public final void a(com.anythink.basead.l.b.a[] aVarArr, JSONArray jSONArray) {
                d.a(d.this, aVarArr, jSONArray);
            }
        });
        this.a = cVar;
        cVar.a(strAf);
    }

    public final void a(a aVar, String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            aVar.a("-3", "Local vast parse result is empty.");
            return;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (Throwable unused) {
            aVar.a("-3", "Local vast parse result fail.");
            jSONArray = null;
        }
        if (jSONArray == null) {
            return;
        }
        this.i = aVar;
        this.l = false;
        c cVar = new c(this.g, true, new c.a() { // from class: com.anythink.basead.l.d.3
            @Override // com.anythink.basead.l.c.a
            public final void a(int i, String str2) {
                String unused2 = d.d;
                if (d.this.h != null) {
                    d.this.h.a(String.valueOf(i), str2);
                }
            }

            @Override // com.anythink.basead.l.c.a
            public final void a(com.anythink.basead.l.b.a[] aVarArr, JSONArray jSONArray2) {
                d.a(d.this, aVarArr, jSONArray2);
            }
        });
        this.a = cVar;
        cVar.a(jSONArray);
    }

    private void a(com.anythink.basead.l.b.a[] aVarArr, JSONArray jSONArray) {
        if (aVarArr == null) {
            a aVar = this.h;
            if (aVar != null) {
                aVar.a("-3", "Parsers results are null.");
                return;
            }
            return;
        }
        if (aVarArr.length != 2) {
            a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a("-3", "2 VAST result parsers are required.");
                return;
            }
            return;
        }
        com.anythink.basead.l.b.a aVar3 = aVarArr[0];
        if (((com.anythink.basead.l.b.b) aVar3) != null) {
            com.anythink.basead.l.b.a aVar4 = aVarArr[1];
            if (((com.anythink.basead.l.b.b) aVar4) != null) {
                boolean zA = a((com.anythink.basead.l.b.b) aVar3, (com.anythink.basead.l.b.b) aVar4);
                jSONArray.length();
                a aVar5 = this.h;
                if (aVar5 != null) {
                    if (zA) {
                        if (this.l && jSONArray != null) {
                            com.anythink.core.common.a.a.a().a(this.e, this.g.a, jSONArray.toString());
                        }
                        this.h.a(this.f);
                        return;
                    }
                    aVar5.a("-3", "Do fillAdxOfferFormVast is fail.");
                    return;
                }
                return;
            }
        }
        a aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.a("-3", "One of parsers is null.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean a(com.anythink.basead.l.b.b bVar, com.anythink.basead.l.b.b bVar2) {
        String str;
        String str2;
        int i;
        int i2;
        String strA;
        byte b;
        boolean z = false;
        try {
            bl blVarAG = this.f.aG();
            bVar.b(bVar, 0);
            bVar.a(bVar, 0);
            bVar.c(bVar, 0);
            String strD = com.anythink.basead.l.b.b.d(bVar);
            String strE = com.anythink.basead.l.b.b.e(bVar);
            String strC = com.anythink.basead.l.b.b.c(bVar);
            String strF = bVar.f(bVar);
            String strB = bVar2.b(bVar2);
            bVar2.a(bVar2);
            int iJ = m.j(this.e);
            if (String.valueOf(this.g.j).equals("2") && this.f.aI() == 3) {
                String strB2 = this.g.o.B();
                switch (strB2.hashCode()) {
                    case -559799608:
                        if (strB2.equals(y.c)) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                        break;
                    case 1507809730:
                        if (strB2.equals(y.a)) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                        break;
                    case 1507809854:
                        if (strB2.equals(y.b)) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                        break;
                    case 1622564786:
                        if (strB2.equals(y.d)) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    iJ = q.a(this.e, 67.0f);
                } else if (b == 1) {
                    iJ = q.a(this.e, 90.0f);
                } else if (b == 2) {
                    iJ = q.a(this.e, 300.0f);
                } else if (b == 3) {
                    iJ = q.a(this.e, 120.0f);
                }
            }
            String strA2 = bVar2.a(bVar2, 0, iJ);
            long jB = e.b(strB);
            int iE = bVar2.e();
            int iF = bVar2.f();
            l lVarA = com.anythink.basead.l.b.b.a(bVar2.c().a().get(0).a());
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                String strA3 = "";
                if (lVarA == null || com.anythink.basead.l.b.b.a(lVarA) == null) {
                    str = "";
                    str2 = str;
                    i = -1;
                    i2 = -1;
                } else {
                    new StringBuilder("fillAdxOfferFormVast getCompanionResourceFormat:").append(com.anythink.basead.l.b.b.a(lVarA));
                    int iIntValue = com.anythink.basead.l.b.b.a(lVarA).intValue();
                    if (iIntValue == 1) {
                        this.k = 1;
                        strA = lVarA.e().a();
                        if (!TextUtils.isEmpty(strA)) {
                            strA = a(strA);
                        }
                    } else if (iIntValue != 2) {
                        if (iIntValue == 3) {
                            this.k = 3;
                        }
                        strA = "";
                    } else {
                        this.k = 2;
                        strA3 = lVarA.c().a();
                        strA = "";
                    }
                    if (lVarA.f() != null) {
                        lVarA.f().a();
                    }
                    if (lVarA.g() != null) {
                        arrayList.add(lVarA.g().a());
                    }
                    at atVarA = com.anythink.basead.l.b.b.a(lVarA.h());
                    if (atVarA != null && e.a((CharSequence) atVarA.b())) {
                        arrayList2.add(atVarA.b());
                    }
                    try {
                        i2 = Integer.parseInt(lVarA.a());
                        try {
                            i = Integer.parseInt(lVarA.b());
                            str2 = strA;
                            str = strA3;
                        } catch (Throwable unused) {
                            str2 = strA;
                            str = strA3;
                            i = -1;
                        }
                    } catch (Throwable unused2) {
                        i2 = -1;
                    }
                }
                this.f.m(strD);
                this.f.n(strE);
                this.f.t(strA2);
                if (jB > 0) {
                    this.f.a(jB);
                }
                if (iE > 0) {
                    this.f.k(iE);
                }
                if (iF > 0) {
                    this.f.l(iF);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f.p(str);
                    this.f.q(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.f.f(str2);
                    if (i2 > 0) {
                        this.f.c(i2);
                    }
                    if (i > 0) {
                        this.f.d(i);
                    }
                }
                if (!TextUtils.isEmpty(strF)) {
                    this.f.w(strF);
                }
                if (bVar.a() != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (ah ahVar : bVar.a()) {
                        if (!TextUtils.isEmpty(ahVar.a())) {
                            arrayList3.add(ahVar.a());
                        }
                    }
                    blVarAG.e(a(blVarAG.f(), (String[]) arrayList3.toArray(new String[0])));
                }
                if (bVar.b() != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (k kVar : bVar.b()) {
                        if (!TextUtils.isEmpty(kVar.a())) {
                            arrayList4.add(kVar.a());
                        }
                    }
                    z = false;
                    blVarAG.f(a(blVarAG.g(), (String[]) arrayList4.toArray(new String[0])));
                }
                if (!TextUtils.isEmpty(strC)) {
                    String[] strArrT = blVarAG.T();
                    String[] strArr = new String[1];
                    try {
                        strArr[0] = strC;
                        blVarAG.p(a(strArrT, strArr));
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                for (f.a aVar : f.a.values()) {
                    ArrayList<String> arrayListA = bVar.a(aVar);
                    if (arrayListA.size() > 0) {
                        switch (AnonymousClass4.a[aVar.ordinal()]) {
                            case 1:
                                blVarAG.g(a(blVarAG.h(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 2:
                                blVarAG.h(a(blVarAG.i(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 3:
                                blVarAG.i(a(blVarAG.j(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 4:
                                blVarAG.j(a(blVarAG.k(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 5:
                                blVarAG.k(a(blVarAG.l(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 6:
                                blVarAG.l(a(blVarAG.m(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 7:
                                blVarAG.o(a(blVarAG.R(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 8:
                                blVarAG.n(a(blVarAG.p(), (String[]) arrayListA.toArray(new String[0])));
                                break;
                            case 9:
                                try {
                                    blVarAG.m(a(blVarAG.o(), (String[]) arrayListA.toArray(new String[0])));
                                } catch (Throwable unused4) {
                                    return false;
                                }
                                break;
                        }
                    }
                }
                new StringBuilder("fillAdxOfferFormVast result:\nvideoUrl:").append(this.f.E()).append("\nendCardUrl:").append(this.f.aH()).append("\niconUrl:").append(this.f.z()).append("\ntitle:").append(this.f.x()).append("\nclickUrl:");
                this.f.H();
                this.f.ah();
                return true;
            } catch (Throwable unused5) {
                return false;
            }
        } catch (Throwable unused6) {
            return z;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.l.d$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f.a.values().length];
            a = iArr;
            try {
                iArr[f.a.AD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[f.a.AD_FIRSTQUARTILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[f.a.AD_MIDPOINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[f.a.AD_THIRDQUARTILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[f.a.AD_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[f.a.AD_PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[f.a.AD_RESUME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[f.a.AD_UNMUTE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[f.a.AD_MUTE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[f.a.AD_REWIND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[f.a.AD_FULLSCREEN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[f.a.AD_CLOSE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strReplaceAll = q.e(str).replaceAll("<!DOCTYPE html>", "");
            if (strReplaceAll.contains("<html")) {
                return strReplaceAll;
            }
            return strReplaceAll.startsWith("<body") ? String.format(this.c, strReplaceAll) : String.format(this.b, strReplaceAll);
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String[] a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        if (strArr2 == null || strArr2.length == 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    static /* synthetic */ void a(d dVar, com.anythink.basead.l.b.a[] aVarArr, JSONArray jSONArray) {
        if (aVarArr == null) {
            a aVar = dVar.h;
            if (aVar != null) {
                aVar.a("-3", "Parsers results are null.");
                return;
            }
            return;
        }
        if (aVarArr.length != 2) {
            a aVar2 = dVar.h;
            if (aVar2 != null) {
                aVar2.a("-3", "2 VAST result parsers are required.");
                return;
            }
            return;
        }
        com.anythink.basead.l.b.a aVar3 = aVarArr[0];
        if (((com.anythink.basead.l.b.b) aVar3) != null) {
            com.anythink.basead.l.b.a aVar4 = aVarArr[1];
            if (((com.anythink.basead.l.b.b) aVar4) != null) {
                boolean zA = dVar.a((com.anythink.basead.l.b.b) aVar3, (com.anythink.basead.l.b.b) aVar4);
                jSONArray.length();
                a aVar5 = dVar.h;
                if (aVar5 != null) {
                    if (zA) {
                        if (dVar.l && jSONArray != null) {
                            com.anythink.core.common.a.a.a().a(dVar.e, dVar.g.a, jSONArray.toString());
                        }
                        dVar.h.a(dVar.f);
                        return;
                    }
                    aVar5.a("-3", "Do fillAdxOfferFormVast is fail.");
                    return;
                }
                return;
            }
        }
        a aVar6 = dVar.h;
        if (aVar6 != null) {
            aVar6.a("-3", "One of parsers is null.");
        }
    }
}
