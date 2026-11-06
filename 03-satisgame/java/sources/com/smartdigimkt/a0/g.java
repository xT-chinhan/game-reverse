package com.smartdigimkt.a0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.b0;
import com.smartdigimkt.z.j0;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends b {
    public final boolean h;
    public f i;
    public com.smartdigimkt.h0.m j;
    public k k;

    public g(a aVar) {
        com.smartdigimkt.a3.a aVar2;
        super(aVar);
        this.j = null;
        com.smartdigimkt.b3.c cVar = this.c;
        if (cVar == null || (aVar2 = this.d) == null) {
            return;
        }
        com.smartdigimkt.b3.e eVar = aVar2.s;
        boolean z = false;
        if (!(cVar instanceof com.smartdigimkt.b3.b) ? !(!(cVar instanceof com.smartdigimkt.e3.a) || ((com.smartdigimkt.e3.a) cVar).f0 != 1) : !(!(eVar instanceof com.smartdigimkt.b3.m) || ((com.smartdigimkt.b3.m) eVar).X1 != 1)) {
            z = true;
        }
        this.h = z;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0161  */
    /* JADX WARN: Code duplicated, block: B:106:0x0169  */
    /* JADX WARN: Code duplicated, block: B:110:0x016f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0194  */
    /* JADX WARN: Code duplicated, block: B:140:0x0214  */
    /* JADX WARN: Code duplicated, block: B:93:0x0138  */
    public final s a(int i, String str) {
        e eVar;
        s sVar;
        s sVar2;
        e eVar2;
        e eVar3;
        IOfferClickHandler iOfferClickHandler;
        boolean z;
        Intent intent;
        boolean z2;
        com.smartdigimkt.h0.a aVar;
        s sVarA;
        k kVar;
        int i2 = i;
        if (i2 == 2) {
            return new s(true);
        }
        if (i2 == 1 && (kVar = this.k) != null) {
            s sVarB = kVar.b();
            if (sVarB.a) {
                return sVarB;
            }
            i2 = 3;
        }
        if ((!TextUtils.isEmpty(this.c.q) || !TextUtils.isEmpty(this.c.k)) && (eVar = this.f) != null && i2 == 3) {
            eVar.a(false);
        }
        if (!TextUtils.isEmpty(this.c.m) && this.c.o == 4 && (sVarA = a(this.j)) != null) {
            return sVarA;
        }
        com.smartdigimkt.h0.m mVar = this.j;
        if (mVar != null && (aVar = mVar.g) != null && this.c.o == 4) {
            if (mVar.j) {
                com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
                boolean z3 = bVarE != null && bVarE.a();
                com.smartdigimkt.h0.a aVar2 = this.j.g;
                aVar2.j = z3 ? bVarE.checkDataFetchType(this.c, this.d) : aVar2.j;
            } else {
                aVar.j = 3;
            }
        }
        r rVar = this.e;
        if (rVar != null) {
            rVar.a();
        }
        String str2 = TextUtils.isEmpty(str) ? this.c.j : str;
        if (TextUtils.isEmpty(str2)) {
            e eVar4 = this.f;
            if (eVar4 != null) {
                eVar4.c();
            }
            return new s(false);
        }
        com.smartdigimkt.a3.a aVar3 = this.d;
        if (aVar3 != null && com.smartdigimkt.c0.h.a(str2, aVar3.s)) {
            com.smartdigimkt.n3.k.a(3, this.d, this.c);
            e eVar5 = this.f;
            if (eVar5 != null) {
                eVar5.c();
            }
            return new s(false);
        }
        int i3 = this.c.o;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    com.smartdigimkt.j2.d.d = false;
                    eVar3 = this.f;
                    if (eVar3 == null && eVar3.a(str2, this.g)) {
                        boolean z4 = com.smartdigimkt.j2.d.d;
                        com.smartdigimkt.j2.d.d = false;
                        if (!z4) {
                            com.smartdigimkt.j2.d.c.incrementAndGet();
                        }
                        z2 = true;
                    } else {
                        com.smartdigimkt.b3.c cVar = this.c;
                        com.smartdigimkt.a3.a aVar4 = this.d;
                        iOfferClickHandler = this.g;
                        if (i2 != 4 || i2 == 5) {
                            z = false;
                        } else {
                            z = true;
                        }
                        Context context = this.b;
                        com.smartdigimkt.j2.d.b = true;
                        intent = new Intent();
                        intent.setClass(context, WebLandPageActivity.class);
                        intent.putExtra(com.anythink.core.basead.a.C0009a.c, cVar);
                        intent.putExtra(com.anythink.core.basead.a.C0009a.e, aVar4);
                        intent.putExtra(com.anythink.core.basead.a.C0009a.i, str2);
                        intent.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
                        intent.putExtra(com.anythink.core.basead.a.C0009a.q, z);
                        z2 = true;
                        intent.putExtra("extra_need_limit_redirect", true);
                        if (iOfferClickHandler != null) {
                            intent.putExtra(com.anythink.core.basead.a.C0009a.k, iOfferClickHandler);
                        }
                        intent.addFlags(C.ENCODING_PCM_MU_LAW);
                        context.startActivity(intent);
                    }
                    sVar = new s(z2);
                } else if (i3 != 4) {
                    sVar2 = i3 != 6 ? b(str2) : b(str2);
                } else {
                    com.smartdigimkt.h0.m mVar2 = this.j;
                    if (mVar2 == null || !mVar2.j || TextUtils.isEmpty(str2)) {
                        com.smartdigimkt.s4.e.a(str2);
                    } else if (!com.smartdigimkt.z.s.a(this.b, this.d, this.c, a(), str2, new j0())) {
                        com.smartdigimkt.s4.e.a(str2);
                    }
                    sVar2 = new s(true);
                }
            } else if (i2 != 4) {
                com.smartdigimkt.s4.e.a(str2);
                sVar2 = new s(true);
            } else {
                com.smartdigimkt.j2.d.d = false;
                eVar3 = this.f;
                if (eVar3 == null) {
                    com.smartdigimkt.b3.c cVar2 = this.c;
                    com.smartdigimkt.a3.a aVar5 = this.d;
                    iOfferClickHandler = this.g;
                    if (i2 != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    Context context2 = this.b;
                    com.smartdigimkt.j2.d.b = true;
                    intent = new Intent();
                    intent.setClass(context2, WebLandPageActivity.class);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.c, cVar2);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.e, aVar5);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.i, str2);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.q, z);
                    z2 = true;
                    intent.putExtra("extra_need_limit_redirect", true);
                    if (iOfferClickHandler != null) {
                        intent.putExtra(com.anythink.core.basead.a.C0009a.k, iOfferClickHandler);
                    }
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    context2.startActivity(intent);
                } else {
                    com.smartdigimkt.b3.c cVar3 = this.c;
                    com.smartdigimkt.a3.a aVar6 = this.d;
                    iOfferClickHandler = this.g;
                    if (i2 != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    Context context3 = this.b;
                    com.smartdigimkt.j2.d.b = true;
                    intent = new Intent();
                    intent.setClass(context3, WebLandPageActivity.class);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.c, cVar3);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.e, aVar6);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.i, str2);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
                    intent.putExtra(com.anythink.core.basead.a.C0009a.q, z);
                    z2 = true;
                    intent.putExtra("extra_need_limit_redirect", true);
                    if (iOfferClickHandler != null) {
                        intent.putExtra(com.anythink.core.basead.a.C0009a.k, iOfferClickHandler);
                    }
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    context3.startActivity(intent);
                }
                sVar = new s(z2);
            }
            eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.c();
            }
            return sVar2;
        }
        sVar = new s(true);
        boolean z5 = (str2 == null || str2.startsWith("http")) ? false : true;
        int i4 = com.smartdigimkt.c0.h.a(this.b, this.d, this.c, str2).a;
        if (i4 != 0 && i4 != 5 && !z5) {
            com.smartdigimkt.a3.a aVar7 = this.d;
            int i5 = aVar7.s.s;
            if (i5 != 0 && i5 == 2) {
                com.smartdigimkt.b3.c cVar4 = this.c;
                IOfferClickHandler iOfferClickHandler2 = this.g;
                Context context4 = this.b;
                com.smartdigimkt.j2.d.b = true;
                Intent intent2 = new Intent();
                intent2.setClass(context4, WebLandPageActivity.class);
                intent2.putExtra(com.anythink.core.basead.a.C0009a.c, cVar4);
                intent2.putExtra(com.anythink.core.basead.a.C0009a.e, aVar7);
                intent2.putExtra(com.anythink.core.basead.a.C0009a.i, str2);
                intent2.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
                intent2.putExtra(com.anythink.core.basead.a.C0009a.q, true);
                intent2.putExtra("extra_need_limit_redirect", true);
                if (iOfferClickHandler2 != null) {
                    intent2.putExtra(com.anythink.core.basead.a.C0009a.k, iOfferClickHandler2);
                }
                intent2.addFlags(C.ENCODING_PCM_MU_LAW);
                context4.startActivity(intent2);
            } else {
                com.smartdigimkt.s4.e.a(str2);
            }
        }
        sVar2 = sVar;
        eVar2 = this.f;
        if (eVar2 != null) {
            eVar2.c();
        }
        return sVar2;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0161  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v7 */
    public final String b() {
        String strC;
        f fVar;
        HttpURLConnection httpURLConnection;
        e eVar = this.f;
        if (eVar != null) {
            eVar.b();
            this.f.a();
        }
        r rVar = this.e;
        if (rVar != null) {
            this.j = rVar.b;
        }
        String str = this.c.l;
        if (str == null) {
            str = "";
        }
        String str2 = this.d.g;
        if (str2 == null) {
            str2 = "";
        }
        String strA = com.smartdigimkt.c0.k.a(str.replaceAll("\\{req_id\\}", str2), this.j, System.currentTimeMillis(), this.c, true, null);
        com.smartdigimkt.b3.c cVar = this.c;
        com.smartdigimkt.h0.f fVar2 = (cVar != null && cVar.p == 42 && cVar.o == 4) ? new com.smartdigimkt.h0.f("", "") : new com.smartdigimkt.h0.f(strA, "");
        b0.a().a.put(this.c.e() + this.c.a, fVar2);
        String str3 = "";
        com.smartdigimkt.b3.c cVar2 = this.c;
        int i = cVar2.o;
        boolean z = false;
        if (i == 1) {
            if (!strA.startsWith("http")) {
                return strA;
            }
            f fVar3 = this.i;
            if (fVar3 != null && System.currentTimeMillis() - fVar3.a <= fVar3.b) {
                z = true;
            }
            if (this.h) {
                str3 = this.c.j;
                if (z) {
                    str3 = this.i.c;
                }
            }
            if (!z) {
                String strC2 = c(strA);
                if (TextUtils.isEmpty(str3)) {
                    str3 = strC2;
                }
                if (!TextUtils.isEmpty(strC2)) {
                    this.i = a(strC2);
                }
            } else if (TextUtils.isEmpty(str3)) {
                str3 = this.i.c;
            }
            return TextUtils.isEmpty(str3) ? fVar2.a : str3;
        }
        ?? r10 = 0;
        String queryParameter = null;
        fVar = null;
        fVar = null;
        com.smartdigimkt.h0.f fVar4 = null;
        if (i == 2 || i == 3) {
            String strC3 = "";
            if (cVar2.p == 42 && !TextUtils.isEmpty(cVar2.k)) {
                strC3 = c(strA);
                try {
                    queryParameter = Uri.parse(strC3).getQueryParameter("qz_gdt");
                } catch (Throwable unused) {
                }
                fVar2.b = queryParameter;
                b0.a().a.put(this.c.e() + this.c.a, fVar2);
            }
            return TextUtils.isEmpty(strC3) ? fVar2.a : strC3;
        }
        if (i != 4) {
            return fVar2.a;
        }
        if (cVar2.p == 42 && TextUtils.isEmpty(fVar2.a)) {
            com.smartdigimkt.a3.a aVar = this.d;
            com.smartdigimkt.b3.c cVar3 = this.c;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strA).openConnection();
                    try {
                        httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            JSONObject jSONObjectOptJSONObject = new JSONObject(sb.toString()).optJSONObject(com.anythink.core.common.l.f.R);
                            com.smartdigimkt.h0.f fVar5 = new com.smartdigimkt.h0.f(jSONObjectOptJSONObject.optString("dstlink"), jSONObjectOptJSONObject.optString("clickid"));
                            bufferedReader.close();
                            inputStreamReader.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            httpURLConnection.disconnect();
                            fVar4 = fVar5;
                        } else {
                            com.smartdigimkt.n3.k.a(aVar, cVar3, cVar3.l, strA, responseCode + "", "");
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e) {
                        e = e;
                        com.smartdigimkt.n3.k.a(aVar, cVar3, cVar3.l, strA, "", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r10 = cVar2;
                    if (r10 != 0) {
                        r10.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (r10 != 0) {
                    r10.disconnect();
                }
                throw th;
            }
            if (fVar4 != null) {
                fVar2.a = fVar4.a;
                fVar2.b = fVar4.b;
            }
        }
        f fVar6 = this.i;
        if (fVar6 == null || System.currentTimeMillis() - fVar6.a > fVar6.b) {
            strC = c(fVar2.a);
            if (!TextUtils.isEmpty(strC)) {
                synchronized (this) {
                    fVar = new f();
                    fVar.c = strC;
                    fVar.b = this.d.s.N;
                    fVar.a = System.currentTimeMillis();
                }
                this.i = fVar;
            }
        } else {
            strC = this.i.c;
        }
        b0.a().a.put(this.c.e() + this.c.a, fVar2);
        if (TextUtils.isEmpty(strC)) {
            return fVar2.a;
        }
        this.j.j = true;
        return strC;
    }

    public final String c(String str) throws Throwable {
        String str2;
        boolean z = false;
        String headerField = str;
        for (int i = 0; i < 10; i++) {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod(TapHttp.METHOD_GET);
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        com.smartdigimkt.b3.e eVar = this.d.s;
                        if (eVar != null && com.smartdigimkt.z.s.a(eVar, 9)) {
                            String strN = com.smartdigimkt.r4.h.n();
                            if (!TextUtils.isEmpty(strN)) {
                                httpURLConnection2.addRequestProperty(RequestParamsUtils.USER_AGENT_KEY, strN);
                            }
                        }
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                            headerField = httpURLConnection2.getHeaderField("Location");
                            if (!headerField.contains(com.anythink.core.common.d.i.E + com.smartdigimkt.r4.o.g) && headerField.startsWith("http")) {
                                httpURLConnection2.disconnect();
                                httpURLConnection2.disconnect();
                            }
                            z = true;
                        }
                        if (z || responseCode == 200) {
                            httpURLConnection2.disconnect();
                            return headerField;
                        }
                        com.smartdigimkt.n3.k.a(this.d, this.c, str, headerField, responseCode + "", "");
                        httpURLConnection2.disconnect();
                        return "";
                    } catch (Exception e) {
                        e = e;
                        str2 = headerField;
                        httpURLConnection = httpURLConnection2;
                        com.smartdigimkt.n3.k.a(this.d, this.c, str, str2, "", e.getMessage());
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

    public final synchronized f a(String str) {
        f fVar;
        fVar = new f();
        fVar.c = str;
        fVar.b = this.d.s.N;
        fVar.a = System.currentTimeMillis();
        return fVar;
    }

    public final s b(String str) {
        com.smartdigimkt.a3.a aVar = this.d;
        int i = aVar.s.s;
        if (i != 0 && i == 2) {
            com.smartdigimkt.b3.c cVar = this.c;
            IOfferClickHandler iOfferClickHandler = this.g;
            Context context = this.b;
            com.smartdigimkt.j2.d.b = true;
            Intent intent = new Intent();
            intent.setClass(context, WebLandPageActivity.class);
            intent.putExtra(com.anythink.core.basead.a.C0009a.c, cVar);
            intent.putExtra(com.anythink.core.basead.a.C0009a.e, aVar);
            intent.putExtra(com.anythink.core.basead.a.C0009a.i, str);
            intent.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
            intent.putExtra(com.anythink.core.basead.a.C0009a.q, true);
            intent.putExtra("extra_need_limit_redirect", true);
            if (iOfferClickHandler != null) {
                intent.putExtra(com.anythink.core.basead.a.C0009a.k, iOfferClickHandler);
            }
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } else {
            com.smartdigimkt.s4.e.a(str);
        }
        return new s(true);
    }
}
