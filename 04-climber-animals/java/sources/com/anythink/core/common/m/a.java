package com.anythink.core.common.m;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
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
public abstract class a {
    private static final String a = "http.loader";
    public static final int m = 699;
    public static final int n = 700;
    public static final int o = 200;
    public static final String p = "Content-Type";
    public static final String q = "application/json";
    private final com.anythink.core.common.m.c.i b = com.anythink.core.common.d.t.b().X();
    private com.anythink.core.common.m.b.d c;
    private com.anythink.core.common.m.a.b d;
    private long e;
    private boolean f;
    private com.anythink.core.common.m.a.a.a g;
    protected q r;
    protected boolean s;
    protected String t;

    protected abstract int a();

    protected abstract Object a(Object obj);

    protected void a(int i) {
    }

    protected abstract void a(AdError adError);

    protected abstract String b();

    protected abstract void b(AdError adError);

    protected boolean b(int i) {
        return false;
    }

    protected abstract Map<String, String> c();

    protected abstract byte[] d();

    protected boolean d_() {
        return false;
    }

    protected abstract String h();

    protected abstract Context i();

    protected abstract String j();

    protected abstract Map<String, Object> k();

    @Deprecated
    protected int l() {
        return 0;
    }

    protected com.anythink.core.common.m.b.d m() {
        return null;
    }

    protected String o() {
        return "1.0";
    }

    protected boolean p() {
        return false;
    }

    protected List<String> q() {
        return null;
    }

    protected boolean r() {
        return false;
    }

    static /* synthetic */ boolean a(a aVar) {
        aVar.f = false;
        return false;
    }

    public void a(int i, q qVar) {
        this.s = false;
        this.r = qVar;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        if (p()) {
            com.anythink.core.common.v.b.b.a().a((com.anythink.core.common.v.b.d) anonymousClass1, 1);
        } else {
            com.anythink.core.common.v.b.b.a().a((com.anythink.core.common.v.b.d) anonymousClass1, 10);
        }
    }

    private void s() {
        this.s = true;
        com.anythink.core.common.m.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    protected JSONObject e() {
        return e.a(l());
    }

    protected JSONObject f() {
        return e.a(l(), q());
    }

    protected String g() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.v.k.a(e().toString());
        String strA2 = com.anythink.core.common.v.k.a(f().toString());
        map.put(e.P, o());
        map.put("p", strA);
        map.put(e.W, strA2);
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
        map.put(e.X, com.anythink.core.common.v.o.c(j() + sb.toString()));
        if (k() != null) {
            map.putAll(k());
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

    private String t() {
        int iA = a();
        if (iA != 1 && iA != 2) {
            iA = 2;
        }
        return iA == 2 ? "GET" : "POST";
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.a$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.v.b.d {
        final /* synthetic */ int a;

        AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.anythink.core.common.v.b.d
        public final void a() {
            com.anythink.core.common.m.b.f fVarA;
            try {
                if (a.this.s) {
                    a.this.c(this.a);
                    return;
                }
                a.a(a.this);
                com.anythink.core.common.d.t.b().T();
                a aVar = a.this;
                aVar.t = aVar.b();
                int iAS = com.anythink.core.d.d.a().aS();
                String strB = a.b(a.this);
                Object[] objArr = new Object[4];
                a.this.getClass().getSimpleName();
                String str = a.this.t;
                Integer.valueOf(iAS);
                if (a.this.r != null) {
                    a.this.r.onLoadStart(this.a);
                }
                if (a.this.c == null) {
                    a aVar2 = a.this;
                    aVar2.c = aVar2.m();
                }
                if (a.this.c == null || a.this.b == null || (fVarA = a.this.b.a(a.this.c)) == null || !fVarA.e()) {
                    com.anythink.core.common.m.a.b eVar = a.this.d;
                    boolean z = true;
                    if (eVar == null) {
                        if (a.this.g == null) {
                            a.this.g = new com.anythink.core.common.m.a.a.a(a.this.getClass().getName(), a.this.t);
                        }
                        com.anythink.core.common.m.a.f fVarA2 = new com.anythink.core.common.m.a.f.a().a(com.anythink.core.common.v.b.b.a().d()).a(TimeUnit.MILLISECONDS).c(TimeUnit.MILLISECONDS).b(TimeUnit.MILLISECONDS).a(a.this.g.a(a.this.c)).a(iAS).a();
                        eVar = com.anythink.core.d.b.b(fVarA2.j) ? new com.anythink.core.common.m.a.a.e(fVarA2) : new com.anythink.core.common.m.a.a.b(fVarA2);
                        Object[] objArr2 = new Object[1];
                        a.this.d = eVar;
                    }
                    com.anythink.core.common.m.a.j jVarA = eVar.a(new com.anythink.core.common.m.a.i.a().a(a.this.t).b(strB).c(a.h(a.this)).a(a.this.d()).a(a.g(a.this)).a());
                    if (jVarA.b != 200 && jVarA.b != 201 && jVarA.b != 204) {
                        z = false;
                    }
                    if (!z && !a.this.b(jVarA.b)) {
                        a.b(a.this, jVarA, this.a);
                        return;
                    }
                    a.a(a.this, jVarA, this.a);
                    return;
                }
                int iF = fVarA.f();
                String strValueOf = String.valueOf(iF);
                if (iF == 200) {
                    a.this.a(this.a, fVarA.g(), false);
                } else {
                    a.this.a(this.a, iF, "", ErrorCode.getErrorCode(ErrorCode.statuError, strValueOf, ""), false);
                }
            } catch (Throwable th) {
                a.this.a(0, 0, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, "0", th.getMessage()));
            }
        }
    }

    private void d(int i) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        if (p()) {
            com.anythink.core.common.v.b.b.a().a((com.anythink.core.common.v.b.d) anonymousClass1, 1);
        } else {
            com.anythink.core.common.v.b.b.a().a((com.anythink.core.common.v.b.d) anonymousClass1, 10);
        }
    }

    private Map<String, String> u() {
        Map<String, String> mapC = c();
        if (mapC == null) {
            mapC = new HashMap<>();
        }
        if (com.anythink.core.common.d.t.b().c("ua")) {
            mapC.put("User-Agent", com.anythink.core.common.v.p.a());
        }
        return mapC;
    }

    private String v() {
        Map<String, String> mapC = c();
        return (mapC == null || !mapC.containsKey("Content-Type")) ? "application/json" : mapC.get("Content-Type");
    }

    protected void a(int i, int i2, String str, AdError adError) {
        a(i, i2, str, adError, true);
    }

    protected final void a(int i, int i2, String str, AdError adError, boolean z) {
        a(i, i2, str, adError, z, false, false);
    }

    private void a(int i, int i2, String str, AdError adError, boolean z, boolean z2, boolean z3) {
        Object[] objArr = new Object[6];
        getClass().getSimpleName();
        Integer.valueOf(i);
        Integer.valueOf(i2);
        if (this.f) {
            return;
        }
        this.f = true;
        q qVar = this.r;
        if (qVar != null) {
            qVar.onLoadError(i, str, adError);
        }
        if (z3) {
            a(i2, str);
        }
        a(i2);
        if (z) {
            b(i2, (Object) null);
        }
        if (z2) {
            a(adError);
        }
        b(adError);
        w();
    }

    protected final void c(int i) {
        q qVar = this.r;
        if (qVar != null) {
            qVar.onLoadCanceled(i);
        }
    }

    protected void a(int i, Object obj) {
        a(i, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object obj, boolean z) {
        Object[] objArr = new Object[3];
        getClass().getSimpleName();
        Integer.valueOf(i);
        if (this.f) {
            return;
        }
        this.f = true;
        q qVar = this.r;
        if (qVar != null) {
            qVar.onLoadFinish(i, obj);
        }
        if (z) {
            b(200, obj);
            w();
        }
    }

    protected static byte[] b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void a(int i, String str) {
        int iL = l();
        if (ATSDK.isCnSDK() || (iL & 8) != 8) {
            return;
        }
        com.anythink.core.common.g.c.a().a(this.t, i, str, new com.anythink.core.common.g.d() { // from class: com.anythink.core.common.m.a.2
            @Override // com.anythink.core.common.g.d
            public final void a(String str2) {
            }
        });
    }

    private void b(int i, Object obj) {
        com.anythink.core.common.m.b.d dVar;
        if (this.b == null || (dVar = this.c) == null) {
            return;
        }
        String strA = dVar.a();
        String strB = this.c.b();
        com.anythink.core.common.m.b.f fVarA = com.anythink.core.common.m.b.f.a();
        if (obj != null && (com.anythink.core.common.m.b.g.c.equals(strB) || com.anythink.core.common.m.b.g.d.equals(strB))) {
            fVarA.a(obj);
        }
        long j = this.e;
        if (j > 0) {
            fVarA.a(j);
        }
        fVarA.a(i);
        fVarA.a(strA);
        this.b.a(fVarA, this.c);
    }

    private void a(com.anythink.core.common.m.a.j jVar) {
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
            this.e = Long.parseLong(str) * 1000;
        } catch (Throwable unused) {
        }
    }

    private void a(com.anythink.core.common.m.a.j jVar, int i) {
        String strConcat;
        int i2;
        boolean z;
        boolean z2;
        Throwable th = jVar.d;
        int i3 = jVar.b;
        String str = "";
        String message = th != null ? th.getMessage() : "";
        if (th instanceof UnknownHostException) {
            strConcat = "UnknownHostException: ".concat(String.valueOf(message));
            i2 = -1000;
            z = true;
            z2 = false;
        } else {
            if (th instanceof ConnectException) {
                strConcat = "ConnectException: ".concat(String.valueOf(message));
                i2 = -1001;
                z = true;
            } else {
                if (th instanceof SSLException) {
                    strConcat = "SSLException: ".concat(String.valueOf(message));
                    i2 = o.g;
                } else if (th instanceof SocketException) {
                    strConcat = "SocketException: ".concat(String.valueOf(message));
                    i2 = o.h;
                } else if (th instanceof SocketTimeoutException) {
                    strConcat = "SocketTimeoutException: ".concat(String.valueOf(message));
                    i2 = -1002;
                } else if (th instanceof ConnectTimeoutException) {
                    strConcat = "ConnectTimeoutException: ".concat(String.valueOf(message));
                    i2 = o.d;
                } else {
                    if (th instanceof IOException) {
                        strConcat = "IOException: ".concat(String.valueOf(message));
                        i2 = o.i;
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
                    z = false;
                }
                z2 = true;
                z = false;
            }
            z2 = z;
        }
        if (x()) {
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
                    this.e = Long.parseLong(str) * 1000;
                }
            } catch (Throwable unused) {
            }
        }
        a(i, i3, str2, errorCode, true, z, z2);
    }

    private void b(com.anythink.core.common.m.a.j jVar, int i) {
        String strB;
        JSONObject jSONObject;
        int i2 = jVar.b;
        try {
            com.anythink.core.common.m.a.k kVar = jVar.e;
            String strTrim = "";
            if (kVar == null) {
                strB = "";
            } else if (r()) {
                strB = kVar.c();
            } else {
                strB = kVar.b();
            }
            if (!b(i2) && (i2 == 201 || i2 == 204)) {
                a(i, a((Object) null));
                return;
            }
            if (d_()) {
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
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.j.e.e);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    a(i, a(jSONObjectOptJSONObject));
                    return;
                }
                a(i, o.l, strTrim, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(iOptInt), strTrim));
                return;
            }
            a(i, a(strB != null ? strB.trim() : null));
        } catch (Throwable th) {
            a(i, i2, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i2), th.getMessage()));
        }
    }

    private void w() {
        com.anythink.core.common.m.a.a.a aVar;
        if (!x() || (aVar = this.g) == null) {
            return;
        }
        com.anythink.core.common.u.e.a(aVar.a());
    }

    private boolean x() {
        com.anythink.core.common.m.a.a.a aVar = this.g;
        com.anythink.core.common.m.b.a aVarA = aVar != null ? aVar.a() : null;
        return aVarA != null && aVarA.o();
    }

    static /* synthetic */ String b(a aVar) {
        int iA = aVar.a();
        if (iA != 1 && iA != 2) {
            iA = 2;
        }
        return iA == 2 ? "GET" : "POST";
    }

    static /* synthetic */ Map g(a aVar) {
        Map<String, String> mapC = aVar.c();
        if (mapC == null) {
            mapC = new HashMap<>();
        }
        if (com.anythink.core.common.d.t.b().c("ua")) {
            mapC.put("User-Agent", com.anythink.core.common.v.p.a());
        }
        return mapC;
    }

    static /* synthetic */ String h(a aVar) {
        Map<String, String> mapC = aVar.c();
        return (mapC == null || !mapC.containsKey("Content-Type")) ? "application/json" : mapC.get("Content-Type");
    }

    static /* synthetic */ void a(a aVar, com.anythink.core.common.m.a.j jVar, int i) {
        String strB;
        JSONObject jSONObject;
        int i2 = jVar.b;
        try {
            com.anythink.core.common.m.a.k kVar = jVar.e;
            String strTrim = "";
            if (kVar == null) {
                strB = "";
            } else if (aVar.r()) {
                strB = kVar.c();
            } else {
                strB = kVar.b();
            }
            if (!aVar.b(i2) && (i2 == 201 || i2 == 204)) {
                aVar.a(i, aVar.a((Object) null));
                return;
            }
            if (aVar.d_()) {
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
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.j.e.e);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    aVar.a(i, aVar.a(jSONObjectOptJSONObject));
                    return;
                }
                aVar.a(i, o.l, strTrim, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(iOptInt), strTrim));
                return;
            }
            aVar.a(i, aVar.a(strB != null ? strB.trim() : null));
        } catch (Throwable th) {
            aVar.a(i, i2, th.getMessage(), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(i2), th.getMessage()));
        }
    }

    static /* synthetic */ void b(a aVar, com.anythink.core.common.m.a.j jVar, int i) {
        String strConcat;
        int i2;
        boolean z;
        boolean z2;
        Throwable th = jVar.d;
        int i3 = jVar.b;
        String str = "";
        String message = th != null ? th.getMessage() : "";
        if (th instanceof UnknownHostException) {
            strConcat = "UnknownHostException: ".concat(String.valueOf(message));
            i2 = -1000;
            z = true;
            z2 = false;
        } else {
            if (th instanceof ConnectException) {
                strConcat = "ConnectException: ".concat(String.valueOf(message));
                i2 = -1001;
                z = true;
            } else {
                if (th instanceof SSLException) {
                    strConcat = "SSLException: ".concat(String.valueOf(message));
                    i2 = o.g;
                } else if (th instanceof SocketException) {
                    strConcat = "SocketException: ".concat(String.valueOf(message));
                    i2 = o.h;
                } else if (th instanceof SocketTimeoutException) {
                    strConcat = "SocketTimeoutException: ".concat(String.valueOf(message));
                    i2 = -1002;
                } else if (th instanceof ConnectTimeoutException) {
                    strConcat = "ConnectTimeoutException: ".concat(String.valueOf(message));
                    i2 = o.d;
                } else {
                    if (th instanceof IOException) {
                        strConcat = "IOException: ".concat(String.valueOf(message));
                        i2 = o.i;
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
                    z = false;
                }
                z2 = true;
                z = false;
            }
            z2 = z;
        }
        if (aVar.x()) {
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
                    aVar.e = Long.parseLong(str) * 1000;
                }
            } catch (Throwable unused) {
            }
        }
        aVar.a(i, i3, str2, errorCode, true, z, z2);
    }
}
