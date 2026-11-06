package com.anythink.core.common.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private static final String a = "http.loader";
    public static final int d = 699;
    public static final int e = 700;
    public static final int f = 200;
    public static final String g = "Content-Type";
    public static final String h = "application/json";
    private final com.anythink.core.common.l.d.i b = com.anythink.core.common.d.s.b().X();
    private com.anythink.core.common.l.c.d c;
    protected s i;
    protected boolean j;
    protected String k;
    private com.anythink.core.common.l.a.b l;
    private long m;
    private boolean n;
    private com.anythink.core.common.l.a.a.a o;

    private static void x() {
    }

    private static void y() {
    }

    protected abstract int a();

    protected abstract Object a(Object obj);

    protected abstract void a(AdError adError);

    protected boolean a(int i) {
        return false;
    }

    protected abstract String b();

    protected abstract Map<String, String> c();

    protected abstract byte[] d();

    protected abstract String e();

    protected abstract Context f();

    protected abstract String g();

    protected abstract Map<String, Object> h();

    protected abstract void l();

    protected boolean m() {
        return false;
    }

    @Deprecated
    protected int n() {
        return 0;
    }

    protected com.anythink.core.common.l.c.d o() {
        return null;
    }

    protected boolean p() {
        return false;
    }

    protected String q() {
        return "1.0";
    }

    protected List<String> r() {
        return null;
    }

    protected boolean s() {
        return false;
    }

    public void a(int i, s sVar) {
        this.j = false;
        this.i = sVar;
        b$$ExternalSyntheticLambda0 b__externalsyntheticlambda0 = new b$$ExternalSyntheticLambda0(this, i);
        if (p()) {
            com.anythink.core.common.t.a.a.a();
            com.anythink.core.common.t.a.a.a(b__externalsyntheticlambda0);
        } else {
            com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, b__externalsyntheticlambda0));
        }
    }

    private void t() {
        this.j = true;
        com.anythink.core.common.l.a.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
    }

    protected JSONObject i() {
        return f.a(n(), r());
    }

    protected JSONObject j() {
        return f.b(n(), r());
    }

    protected String k() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.u.j.a(i().toString());
        String strA2 = com.anythink.core.common.u.j.a(j().toString());
        map.put(f.P, q());
        map.put(f.W, strA);
        map.put(f.X, strA2);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        map.put(f.Y, com.anythink.core.common.u.n.c(g() + sb.toString()));
        if (h() != null) {
            map.putAll(h());
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : setKeySet) {
                jSONObject.put(str2, String.valueOf(map.get(str2)));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return null;
        }
    }

    private String u() {
        int iA = a();
        if (iA != 1 && iA != 2) {
            iA = 2;
        }
        return iA == 2 ? TapHttp.METHOD_GET : TapHttp.METHOD_POST;
    }

    private void b(int i) {
        b$$ExternalSyntheticLambda0 b__externalsyntheticlambda0 = new b$$ExternalSyntheticLambda0(this, i);
        if (p()) {
            com.anythink.core.common.t.a.a.a();
            com.anythink.core.common.t.a.a.a(b__externalsyntheticlambda0);
        } else {
            com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, b__externalsyntheticlambda0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void d(int i) {
        String strB;
        JSONObject jSONObject;
        String strConcat;
        int i2;
        com.anythink.core.common.l.d.i iVar;
        com.anythink.core.common.l.c.f fVarA;
        try {
            if (!this.j) {
                this.n = false;
                com.anythink.core.common.d.s.b().T();
                this.k = b();
                int iAC = com.anythink.core.e.d.a().aC();
                int iA = a();
                boolean z = true;
                if (iA != 1 && iA != 2) {
                    iA = 2;
                }
                String str = iA == 2 ? TapHttp.METHOD_GET : TapHttp.METHOD_POST;
                s sVar = this.i;
                if (sVar != null) {
                    sVar.onLoadStart(i);
                }
                if (this.c == null) {
                    this.c = o();
                }
                com.anythink.core.common.l.c.d dVar = this.c;
                String strTrim = "";
                if (dVar != null && (iVar = this.b) != null && (fVarA = iVar.a(dVar)) != null && fVarA.e()) {
                    int iF = fVarA.f();
                    String strValueOf = String.valueOf(iF);
                    if (iF != 200) {
                        a(i, iF, "", ErrorCode.getErrorCode(ErrorCode.statuError, strValueOf, ""), false);
                        return;
                    } else {
                        a(i, fVarA.g(), false);
                        return;
                    }
                }
                com.anythink.core.common.l.a.b fVar = this.l;
                if (fVar == null) {
                    if (this.o == null) {
                        this.o = new com.anythink.core.common.l.a.a.a(getClass().getName(), this.k);
                    }
                    com.anythink.core.common.l.a.f fVarA2 = new com.anythink.core.common.l.a.f.a().a(TimeUnit.MILLISECONDS).c(TimeUnit.MILLISECONDS).b(TimeUnit.MILLISECONDS).a(this.o.a(this.c)).a(iAC).a();
                    fVar = com.anythink.core.e.b.b(fVarA2.i) ? new com.anythink.core.common.l.a.a.f(fVarA2) : new com.anythink.core.common.l.a.a.b(fVarA2);
                    this.l = fVar;
                }
                com.anythink.core.common.l.a.i.a aVarB = new com.anythink.core.common.l.a.i.a().a(this.k).b(str);
                String str2 = h;
                Map<String, String> mapC = c();
                if (mapC != null && mapC.containsKey(g)) {
                    str2 = mapC.get(g);
                }
                com.anythink.core.common.l.a.i.a aVarA = aVarB.c(str2).a(d());
                Map<String, String> mapC2 = c();
                if (mapC2 == null) {
                    mapC2 = new HashMap<>();
                }
                if (com.anythink.core.common.d.s.b().c("ua")) {
                    mapC2.put(RequestParamsUtils.USER_AGENT_KEY, com.anythink.core.common.u.o.a());
                }
                com.anythink.core.common.l.a.j jVarA = fVar.a(aVarA.a(mapC2).a());
                if ((jVarA.b == 200 || jVarA.b == 201 || jVarA.b == 204) != false || a(jVarA.b)) {
                    int i3 = jVarA.b;
                    try {
                        com.anythink.core.common.l.a.k kVar = jVarA.e;
                        if (kVar == null) {
                            strB = "";
                        } else if (s()) {
                            strB = kVar.c();
                        } else {
                            strB = kVar.b();
                        }
                        if (!a(i3) && (i3 == 201 || i3 == 204)) {
                            a(i, a((Object) null));
                            return;
                        }
                        if (m()) {
                            if (!TextUtils.isEmpty(strB)) {
                                strTrim = strB.trim();
                                try {
                                    jSONObject = new JSONObject(strTrim);
                                } catch (Throwable unused) {
                                    jSONObject = new JSONObject();
                                }
                            } else {
                                jSONObject = new JSONObject();
                            }
                            int iOptInt = jSONObject.optInt("code", 0);
                            if (iOptInt == 0) {
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.i.e.e);
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                a(i, a(jSONObjectOptJSONObject));
                                return;
                            }
                            a(i, q.l, strTrim, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(iOptInt), strTrim));
                            return;
                        }
                        a(i, a((Object) (strB != null ? strB.trim() : null)));
                        return;
                    } catch (Throwable th) {
                        a(i, i3, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i3), th.getMessage()));
                        return;
                    }
                }
                Throwable th2 = jVarA.d;
                int i4 = jVarA.b;
                String message = th2 != null ? th2.getMessage() : "";
                if (th2 instanceof UnknownHostException) {
                    strConcat = "UnknownHostException: ".concat(String.valueOf(message));
                    i2 = -1000;
                } else if (th2 instanceof ConnectException) {
                    strConcat = "ConnectException: ".concat(String.valueOf(message));
                    i2 = -1001;
                } else if (th2 instanceof SSLException) {
                    strConcat = "SSLException: ".concat(String.valueOf(message));
                    i2 = q.g;
                } else if (th2 instanceof SocketException) {
                    strConcat = "SocketException: ".concat(String.valueOf(message));
                    i2 = q.h;
                } else if (th2 instanceof SocketTimeoutException) {
                    strConcat = "SocketTimeoutException: ".concat(String.valueOf(message));
                    i2 = -1002;
                } else if (th2 instanceof ConnectTimeoutException) {
                    strConcat = "ConnectTimeoutException: ".concat(String.valueOf(message));
                    i2 = q.d;
                } else if (th2 instanceof IOException) {
                    strConcat = "IOException: ".concat(String.valueOf(message));
                    i2 = q.i;
                } else {
                    if (th2 == null) {
                        strConcat = jVarA.c;
                    } else if (!TextUtils.isEmpty(jVarA.c)) {
                        strConcat = "Msg: " + jVarA.c + "Exception: " + th2 + ", Message: " + message;
                    } else {
                        strConcat = "Exception: " + th2 + ", Message: " + message;
                    }
                    i2 = -9998;
                }
                com.anythink.core.common.l.a.a.a aVar = this.o;
                com.anythink.core.common.l.c.a aVarA2 = aVar != null ? aVar.a() : null;
                if (aVarA2 == null || !aVarA2.n()) {
                    z = false;
                }
                if (z) {
                    strConcat = "cus-dns,".concat(String.valueOf(strConcat));
                }
                String str3 = strConcat;
                AdError errorCode = ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i2), str3);
                Map<String, List<String>> map = jVarA.f;
                if (map != null && !map.isEmpty() && jVarA.b == 699) {
                    try {
                        List<String> list = map.get("Req-Next-Time");
                        if (list != null && !list.isEmpty()) {
                            strTrim = list.get(0);
                        }
                        if (!TextUtils.isEmpty(strTrim)) {
                            this.m = Long.parseLong(strTrim) * 1000;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    b(i, i4, str3, errorCode, true);
                    return;
                } finally {
                    a(jVarA.e);
                }
                a(0, 0, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, "0", th.getMessage()));
            }
            s sVar2 = this.i;
            if (sVar2 != null) {
                sVar2.onLoadCanceled(i);
            }
        } catch (Throwable th3) {
            a(0, 0, th3.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, "0", th3.getMessage()));
        }
    }

    private Map<String, String> v() {
        Map<String, String> mapC = c();
        if (mapC == null) {
            mapC = new HashMap<>();
        }
        if (com.anythink.core.common.d.s.b().c("ua")) {
            mapC.put(RequestParamsUtils.USER_AGENT_KEY, com.anythink.core.common.u.o.a());
        }
        return mapC;
    }

    private String w() {
        Map<String, String> mapC = c();
        return (mapC == null || !mapC.containsKey(g)) ? h : mapC.get(g);
    }

    private void a(int i, int i2, String str, AdError adError) {
        a(i, i2, str, adError, true);
    }

    private void a(int i, int i2, String str, AdError adError, boolean z) {
        b(i, i2, str, adError, z);
    }

    private void b(int i, int i2, String str, AdError adError, boolean z) {
        if (this.n) {
            return;
        }
        this.n = true;
        s sVar = this.i;
        if (sVar != null) {
            sVar.onLoadError(i, str, adError);
        }
        if (z) {
            b(i2, (Object) null);
        }
        a(adError);
        z();
    }

    private void c(int i) {
        s sVar = this.i;
        if (sVar != null) {
            sVar.onLoadCanceled(i);
        }
    }

    protected void a(int i, Object obj) {
        a(i, obj, true);
    }

    private void a(int i, Object obj, boolean z) {
        if (this.n) {
            return;
        }
        this.n = true;
        s sVar = this.i;
        if (sVar != null) {
            sVar.onLoadFinish(i, obj);
        }
        if (z) {
            b(200, obj);
            z();
        }
    }

    protected static byte[] a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void b(int i, Object obj) {
        com.anythink.core.common.l.c.d dVar;
        if (this.b == null || (dVar = this.c) == null) {
            return;
        }
        String strA = dVar.a();
        String strB = this.c.b();
        com.anythink.core.common.l.c.f fVarA = com.anythink.core.common.l.c.f.a();
        if (obj != null && (com.anythink.core.common.l.c.g.c.equals(strB) || com.anythink.core.common.l.c.g.d.equals(strB))) {
            fVarA.a(obj);
        }
        long j = this.m;
        if (j > 0) {
            fVarA.a(j);
        }
        fVarA.a(i);
        fVarA.a(strA);
        this.b.a(fVarA, this.c);
    }

    private void a(com.anythink.core.common.l.a.j jVar) {
        Map<String, List<String>> map = jVar.f;
        if (map == null || map.isEmpty() || jVar.b != 699) {
            return;
        }
        try {
            List<String> list = map.get("Req-Next-Time");
            String str = (list == null || list.isEmpty()) ? "" : list.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.m = Long.parseLong(str) * 1000;
        } catch (Throwable unused) {
        }
    }

    private void a(com.anythink.core.common.l.a.j jVar, int i) {
        String strConcat;
        int i2;
        Throwable th = jVar.d;
        int i3 = jVar.b;
        String str = "";
        String message = th != null ? th.getMessage() : "";
        if (th instanceof UnknownHostException) {
            strConcat = "UnknownHostException: ".concat(String.valueOf(message));
            i2 = -1000;
        } else if (th instanceof ConnectException) {
            strConcat = "ConnectException: ".concat(String.valueOf(message));
            i2 = -1001;
        } else if (th instanceof SSLException) {
            strConcat = "SSLException: ".concat(String.valueOf(message));
            i2 = q.g;
        } else if (th instanceof SocketException) {
            strConcat = "SocketException: ".concat(String.valueOf(message));
            i2 = q.h;
        } else if (th instanceof SocketTimeoutException) {
            strConcat = "SocketTimeoutException: ".concat(String.valueOf(message));
            i2 = -1002;
        } else if (th instanceof ConnectTimeoutException) {
            strConcat = "ConnectTimeoutException: ".concat(String.valueOf(message));
            i2 = q.d;
        } else if (th instanceof IOException) {
            strConcat = "IOException: ".concat(String.valueOf(message));
            i2 = q.i;
        } else {
            if (th == null) {
                strConcat = jVar.c;
            } else if (!TextUtils.isEmpty(jVar.c)) {
                strConcat = "Msg: " + jVar.c + "Exception: " + th + ", Message: " + message;
            } else {
                strConcat = "Exception: " + th + ", Message: " + message;
            }
            i2 = -9998;
        }
        com.anythink.core.common.l.a.a.a aVar = this.o;
        com.anythink.core.common.l.c.a aVarA = aVar != null ? aVar.a() : null;
        if (aVarA != null && aVarA.n()) {
            strConcat = "cus-dns,".concat(String.valueOf(strConcat));
        }
        String str2 = strConcat;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i2), str2);
        Map<String, List<String>> map = jVar.f;
        if (map != null && !map.isEmpty() && jVar.b == 699) {
            try {
                List<String> list = map.get("Req-Next-Time");
                if (list != null && !list.isEmpty()) {
                    str = list.get(0);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.m = Long.parseLong(str) * 1000;
                }
            } catch (Throwable unused) {
            }
        }
        try {
            b(i, i3, str2, errorCode, true);
        } finally {
            a(jVar.e);
        }
    }

    private static void a(com.anythink.core.common.l.a.k kVar) {
        if (kVar == null) {
            return;
        }
        try {
            kVar.d();
        } catch (Throwable unused) {
        }
    }

    private void b(com.anythink.core.common.l.a.j jVar, int i) {
        String strB;
        JSONObject jSONObject;
        int i2 = jVar.b;
        try {
            com.anythink.core.common.l.a.k kVar = jVar.e;
            String strTrim = "";
            if (kVar == null) {
                strB = "";
            } else if (s()) {
                strB = kVar.c();
            } else {
                strB = kVar.b();
            }
            if (!a(i2) && (i2 == 201 || i2 == 204)) {
                a(i, a((Object) null));
                return;
            }
            if (m()) {
                if (!TextUtils.isEmpty(strB)) {
                    strTrim = strB.trim();
                    try {
                        jSONObject = new JSONObject(strTrim);
                    } catch (Throwable unused) {
                        jSONObject = new JSONObject();
                    }
                } else {
                    jSONObject = new JSONObject();
                }
                int iOptInt = jSONObject.optInt("code", 0);
                if (iOptInt == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.i.e.e);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    a(i, a(jSONObjectOptJSONObject));
                    return;
                }
                a(i, q.l, strTrim, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(iOptInt), strTrim));
                return;
            }
            a(i, a((Object) (strB != null ? strB.trim() : null)));
        } catch (Throwable th) {
            a(i, i2, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i2), th.getMessage()));
        }
    }

    private void z() {
        com.anythink.core.common.l.a.a.a aVar = this.o;
        com.anythink.core.common.l.c.a aVarA = aVar != null ? aVar.a() : null;
        if (aVarA == null || !aVarA.p()) {
            return;
        }
        com.anythink.core.common.t.f.a(aVarA);
    }

    private boolean A() {
        com.anythink.core.common.l.a.a.a aVar = this.o;
        com.anythink.core.common.l.c.a aVarA = aVar != null ? aVar.a() : null;
        return aVarA != null && aVarA.n();
    }
}
