package com.anythink.basead.b.b;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.basead.ui.web.WebLandPageActivity;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.anythink.basead.b.b.a {
    int h;
    boolean i;
    a j;
    com.anythink.basead.d.j k;
    d l;
    private final String m;
    private final int n;

    public c(com.anythink.basead.b.b.a.C0008a c0008a) {
        super(c0008a);
        this.m = "c";
        this.n = 10;
        this.k = null;
        if (this.c != null) {
            this.h = this.c.K();
            if (this.d != null) {
                w wVar = this.c;
                y yVar = this.d.o;
                boolean z = false;
                if (!(wVar instanceof r) ? !(!(wVar instanceof ay) || ((ay) wVar).d() != 1) : !(!(yVar instanceof bk) || ((bk) yVar).b() != 1)) {
                    z = true;
                }
                this.i = z;
            }
        }
    }

    public final void a(d dVar) {
        this.l = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    public final String d() {
        com.anythink.basead.d.e eVar;
        String str;
        String strE;
        com.anythink.basead.d.e eVarA;
        if (this.f != null) {
            this.f.b();
            this.f.a();
        }
        if (this.e != null) {
            this.k = this.e.a();
        }
        String strF = "";
        String strA = com.anythink.basead.b.j.a((this.c.H() != null ? this.c.H() : "").replaceAll("\\{req_id\\}", this.d.d == null ? "" : this.d.d), this.k, System.currentTimeMillis(), this.c, true);
        if (com.anythink.basead.b.e.c(this.c) && this.c.K() == 4) {
            eVar = new com.anythink.basead.d.e("", "", "");
        } else {
            eVar = new com.anythink.basead.d.e(strA, "", "");
        }
        a(eVar);
        int iK = this.c.K();
        if (iK != 1) {
            if (iK == 2 || iK == 3) {
                if (com.anythink.basead.b.e.c(this.c) && !TextUtils.isEmpty(this.c.G())) {
                    strF = e(strA);
                    String strA2 = com.anythink.basead.f.e.a.a.a(strF);
                    eVar.b = strF;
                    eVar.c = strA2;
                    a(eVar);
                }
                return TextUtils.isEmpty(strF) ? eVar.a : strF;
            }
            if (iK == 4) {
                if (com.anythink.basead.b.e.c(this.c) && TextUtils.isEmpty(eVar.a) && (eVarA = com.anythink.basead.f.e.a.a.a(this.d, this.c, strA)) != null) {
                    eVar.a = eVarA.a;
                    eVar.c = eVarA.c;
                }
                a aVar = this.j;
                if (aVar != null && aVar.a()) {
                    strE = this.j.c;
                } else {
                    strE = e(eVar.a);
                    if (!TextUtils.isEmpty(strE)) {
                        this.j = f(strE);
                    }
                }
                eVar.b = strE;
                a(eVar);
                if (TextUtils.isEmpty(strE)) {
                    return eVar.a;
                }
                this.k.l = true;
                return strE;
            }
        } else {
            if (!strA.startsWith("http")) {
                return strA;
            }
            a aVar2 = this.j;
            boolean z = aVar2 != null && aVar2.a();
            if (this.i) {
                strF = this.c.F();
                if (z) {
                    strF = this.j.c;
                }
            }
            if (z) {
                if (TextUtils.isEmpty(strF)) {
                    str = this.j.c;
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } else {
                String strE2 = e(strA);
                if (TextUtils.isEmpty(strF)) {
                    strF = strE2;
                }
                if (!TextUtils.isEmpty(strE2)) {
                    this.j = f(strE2);
                }
            }
            str = strF;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return eVar.a;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01e1  */
    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a(String str, e eVar) {
        n nVarA;
        d dVar;
        new StringBuilder("executeWithDeeplinkHandleType clickUrl:").append(str).append(",deeplinkHandleType").append(eVar);
        if (eVar == e.HANDLE_SUCCESS) {
            return n.a(true, "ClickUrlClickAction execute success with DeeplinkHandleType.HANDLE_SUCCESS before");
        }
        if (eVar == e.NO_HANDLE && (dVar = this.l) != null) {
            n nVarA2 = dVar.a();
            if (nVarA2.a) {
                return nVarA2;
            }
            eVar = e.HANDLE_FAIL;
        }
        boolean z = false;
        if ((!TextUtils.isEmpty(this.c.u()) || !TextUtils.isEmpty(this.c.G())) && this.f != null && eVar == e.HANDLE_FAIL) {
            this.f.a(false);
        }
        if (!TextUtils.isEmpty(this.c.I()) && (this.c.K() == 1 || this.c.K() == 4)) {
            boolean zB = com.anythink.core.basead.a.e.b(this.b, this.c.I());
            com.anythink.basead.d.j jVar = this.k;
            if (jVar != null) {
                jVar.k = new com.anythink.basead.d.b();
                com.anythink.basead.d.e eVarB = b();
                this.k.k.a = eVarB != null ? eVarB.c : "";
                if (this.k.i != null) {
                    this.k.i.j = zB ? 5 : this.k.i.j;
                }
            }
            if (zB) {
                if (this.e != null) {
                    this.e.b();
                }
                com.anythink.basead.b.b.a(25, this.c, this.k);
                if (this.f != null) {
                    this.f.c();
                }
                return n.a(true, "ClickUrlClickAction execute success with openApp");
            }
            com.anythink.basead.b.b.a(26, this.c, this.k);
        }
        com.anythink.basead.d.j jVar2 = this.k;
        if (jVar2 != null && jVar2.i != null && this.c.K() == 4) {
            if (this.k.l) {
                s sVarC = t.b().c();
                this.k.i.j = sVarC != null && sVarC.a() ? sVarC.checkDataFetchType(this.c, this.d) : this.k.i.j;
            } else {
                this.k.i.j = 3;
            }
        }
        if (this.e != null) {
            this.e.b();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.c.F();
        }
        if (TextUtils.isEmpty(str)) {
            if (this.f != null) {
                this.f.c();
            }
            return n.a(false, "ClickUrlClickAction execute fail with empty url");
        }
        if (this.d != null && com.anythink.core.basead.a.e.a(str, this.d.o)) {
            Log.d("anythink", "Offer click result FilterDeeplinkByScheme.");
            com.anythink.core.common.u.e.b(this.c, this.d, 3);
            if (this.f != null) {
                this.f.c();
            }
            return n.a(false, "ClickUrlClickAction execute fail by FilterDeeplinkByScheme");
        }
        int iK = this.c.K();
        if (iK == 1) {
            n nVarA3 = n.a(true, "ClickUrlClickAction execute success with MARKET_TYPE");
            boolean z2 = (str == null || str.startsWith("http")) ? false : true;
            if (!com.anythink.core.basead.a.e.a(this.b, str, this.c, this.d) && !z2) {
                if (this.d.o.u() == 2) {
                    com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
                    cVar.c = this.c;
                    cVar.h = this.d;
                    cVar.f = str;
                    cVar.g = this.g;
                    WebLandPageActivity.a(this.b, cVar);
                } else {
                    com.anythink.core.basead.a.e.b(str);
                }
            }
            nVarA = nVarA3;
        } else if (iK != 2) {
            if (iK == 3) {
                if (this.f != null && !this.f.a(str, this.g)) {
                    com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
                    cVar2.c = this.c;
                    cVar2.h = this.d;
                    cVar2.f = str;
                    cVar2.g = this.g;
                    if (eVar != e.HANDLE_SUCCESS_WITH_WEB_CLICK && eVar != e.HANDLE_DEEPLINK_REFUSE) {
                        z = true;
                    }
                    cVar2.k = z;
                    WebLandPageActivity.a(this.b, cVar2);
                }
                nVarA = n.a(true, "ClickUrlClickAction execute success with INNER_BROWSER_TYPE");
            } else if (iK == 4) {
                com.anythink.basead.d.j jVar3 = this.k;
                if (jVar3 != null && jVar3.l && !TextUtils.isEmpty(str)) {
                    if (!com.anythink.basead.b.b.a(this.b, this.d, this.c, b(), str, new com.anythink.basead.b.i())) {
                        com.anythink.core.basead.a.e.b(str);
                    }
                } else {
                    com.anythink.core.basead.a.e.b(str);
                }
                nVarA = n.a(true, "ClickUrlClickAction execute success with APK_TYPE");
            } else if (iK != 6) {
                nVarA = d(str);
            } else {
                nVarA = d(str);
            }
        } else if (eVar != e.HANDLE_SUCCESS_WITH_WEB_CLICK) {
            com.anythink.core.basead.a.e.b(str);
            nVarA = n.a(true, "ClickUrlClickAction execute success with BROWSER_TYPE");
        } else {
            if (this.f != null) {
                com.anythink.core.basead.b.c cVar3 = new com.anythink.core.basead.b.c();
                cVar3.c = this.c;
                cVar3.h = this.d;
                cVar3.f = str;
                cVar3.g = this.g;
                if (eVar != e.HANDLE_SUCCESS_WITH_WEB_CLICK) {
                    z = true;
                }
                cVar3.k = z;
                WebLandPageActivity.a(this.b, cVar3);
            }
            nVarA = n.a(true, "ClickUrlClickAction execute success with INNER_BROWSER_TYPE");
        }
        if (this.f != null) {
            this.f.c();
        }
        return nVarA;
    }

    private String a(String str, com.anythink.basead.d.e eVar) throws Throwable {
        String strE;
        if (!com.anythink.basead.b.e.c(this.c) || TextUtils.isEmpty(this.c.G())) {
            strE = "";
        } else {
            strE = e(str);
            String strA = com.anythink.basead.f.e.a.a.a(strE);
            eVar.b = strE;
            eVar.c = strA;
            a(eVar);
        }
        return TextUtils.isEmpty(strE) ? eVar.a : strE;
    }

    private String b(String str, com.anythink.basead.d.e eVar) throws Throwable {
        String strE;
        com.anythink.basead.d.e eVarA;
        if (com.anythink.basead.b.e.c(this.c) && TextUtils.isEmpty(eVar.a) && (eVarA = com.anythink.basead.f.e.a.a.a(this.d, this.c, str)) != null) {
            eVar.a = eVarA.a;
            eVar.c = eVarA.c;
        }
        a aVar = this.j;
        if (aVar != null && aVar.a()) {
            strE = this.j.c;
        } else {
            strE = e(eVar.a);
            if (!TextUtils.isEmpty(strE)) {
                this.j = f(strE);
            }
        }
        eVar.b = strE;
        a(eVar);
        if (TextUtils.isEmpty(strE)) {
            return eVar.a;
        }
        this.k.l = true;
        return strE;
    }

    private n b(String str, e eVar) {
        int iK = this.c.K();
        boolean z = false;
        if (iK == 1) {
            n nVarA = n.a(true, "ClickUrlClickAction execute success with MARKET_TYPE");
            if (str != null && !str.startsWith("http")) {
                z = true;
            }
            if (!com.anythink.core.basead.a.e.a(this.b, str, this.c, this.d) && !z) {
                if (this.d.o.u() == 2) {
                    com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
                    cVar.c = this.c;
                    cVar.h = this.d;
                    cVar.f = str;
                    cVar.g = this.g;
                    WebLandPageActivity.a(this.b, cVar);
                } else {
                    com.anythink.core.basead.a.e.b(str);
                }
            }
            return nVarA;
        }
        if (iK != 2) {
            if (iK != 3) {
                if (iK != 4) {
                    if (iK != 6) {
                        return d(str);
                    }
                    return d(str);
                }
                com.anythink.basead.d.j jVar = this.k;
                if (jVar == null || !jVar.l || TextUtils.isEmpty(str) || !com.anythink.basead.b.b.a(this.b, this.d, this.c, b(), str, new com.anythink.basead.b.i())) {
                    com.anythink.core.basead.a.e.b(str);
                }
                return n.a(true, "ClickUrlClickAction execute success with APK_TYPE");
            }
        } else if (eVar != e.HANDLE_SUCCESS_WITH_WEB_CLICK) {
            com.anythink.core.basead.a.e.b(str);
            return n.a(true, "ClickUrlClickAction execute success with BROWSER_TYPE");
        }
        if (this.f != null && !this.f.a(str, this.g)) {
            com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
            cVar2.c = this.c;
            cVar2.h = this.d;
            cVar2.f = str;
            cVar2.g = this.g;
            if (eVar != e.HANDLE_SUCCESS_WITH_WEB_CLICK && eVar != e.HANDLE_DEEPLINK_REFUSE) {
                z = true;
            }
            cVar2.k = z;
            WebLandPageActivity.a(this.b, cVar2);
        }
        return n.a(true, "ClickUrlClickAction execute success with INNER_BROWSER_TYPE");
    }

    private n a(String str) {
        n nVarA = n.a(true, "ClickUrlClickAction execute success with MARKET_TYPE");
        boolean z = (str == null || str.startsWith("http")) ? false : true;
        if (!com.anythink.core.basead.a.e.a(this.b, str, this.c, this.d) && !z) {
            if (this.d.o.u() == 2) {
                com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
                cVar.c = this.c;
                cVar.h = this.d;
                cVar.f = str;
                cVar.g = this.g;
                WebLandPageActivity.a(this.b, cVar);
            } else {
                com.anythink.core.basead.a.e.b(str);
            }
        }
        return nVarA;
    }

    private n c(String str, e eVar) {
        if (this.f != null && !this.f.a(str, this.g)) {
            com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
            cVar.c = this.c;
            cVar.h = this.d;
            cVar.f = str;
            cVar.g = this.g;
            cVar.k = (eVar == e.HANDLE_SUCCESS_WITH_WEB_CLICK || eVar == e.HANDLE_DEEPLINK_REFUSE) ? false : true;
            WebLandPageActivity.a(this.b, cVar);
        }
        return n.a(true, "ClickUrlClickAction execute success with INNER_BROWSER_TYPE");
    }

    private n b(String str) {
        com.anythink.basead.d.j jVar = this.k;
        if (jVar == null || !jVar.l || TextUtils.isEmpty(str) || !com.anythink.basead.b.b.a(this.b, this.d, this.c, b(), str, new com.anythink.basead.b.i())) {
            com.anythink.core.basead.a.e.b(str);
        }
        return n.a(true, "ClickUrlClickAction execute success with APK_TYPE");
    }

    private n c(String str) {
        return d(str);
    }

    private n d(String str) {
        if (this.d.o.u() == 2) {
            com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
            cVar.c = this.c;
            cVar.h = this.d;
            cVar.f = str;
            cVar.g = this.g;
            WebLandPageActivity.a(this.b, cVar);
        } else {
            com.anythink.core.basead.a.e.b(str);
        }
        return n.a(true, "ClickUrlClickAction execute success with DEFAULT");
    }

    private void a(com.anythink.basead.d.e eVar) {
        com.anythink.basead.b.d.a().a(this.c.b(), this.c.v(), eVar);
    }

    private String e(String str) throws Throwable {
        String str2;
        boolean z = false;
        String headerField = str;
        for (int i = 0; i < 10; i++) {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        if (this.d.o != null && com.anythink.basead.b.b.a(9, this.d.o)) {
                            String strI = com.anythink.core.common.v.m.i();
                            if (!TextUtils.isEmpty(strI)) {
                                httpURLConnection2.addRequestProperty("User-Agent", strI);
                            }
                        }
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                            headerField = httpURLConnection2.getHeaderField("Location");
                            if (!com.anythink.core.basead.a.e.c(headerField) && !headerField.contains(com.anythink.dlopt.common.a.a.h) && headerField.startsWith("http")) {
                                httpURLConnection2.disconnect();
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                            }
                            z = true;
                        }
                        if (z || responseCode == 200) {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return headerField;
                        }
                        com.anythink.core.common.u.e.a(this.d, this.c, str, headerField, String.valueOf(responseCode), "");
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return "";
                    } catch (Exception e) {
                        e = e;
                        str2 = headerField;
                        httpURLConnection = httpURLConnection2;
                        com.anythink.core.common.u.e.a(this.d, this.c, str, str2, "", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = headerField;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    static class a {
        long a;
        long b;
        String c;

        a() {
        }

        final boolean a() {
            return System.currentTimeMillis() - this.a <= this.b;
        }
    }

    private synchronized a f(String str) {
        a aVar;
        aVar = new a();
        aVar.c = str;
        aVar.b = this.d.o.X();
        aVar.a = System.currentTimeMillis();
        return aVar;
    }
}
