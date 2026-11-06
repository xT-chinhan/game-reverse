package com.smartdigimkt.f4;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.model.AdnName;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public String a;
    public com.smartdigimkt.a4.b b;
    public final com.smartdigimkt.g4.d d;
    public HttpReqEntity e;
    public com.smartdigimkt.e4.a f;
    public long g;
    public boolean h;
    public long i;
    public boolean o;
    public boolean p;
    public boolean q;
    public long j = -1;
    public long k = -1;
    public long l = -1;
    public long m = -1;
    public long n = -1;
    public final IHttpLoaderInterceptor c = SDKContext.getInstance().getHttpLoaderInterceptor();

    public b(com.smartdigimkt.g4.d dVar) {
        this.d = dVar;
    }

    public static String a(b bVar, int i) {
        bVar.getClass();
        if (i >= 200 && i < 300) {
            return "2xx";
        }
        if (i >= 300 && i < 400) {
            return "3xx";
        }
        if (i < 400 || i >= 500) {
            return (i < 500 || i >= 600) ? AdnName.OTHER : "5xx";
        }
        return "4xx";
    }

    public static void b(b bVar, com.smartdigimkt.d4.e eVar, int i) {
        String str;
        boolean z;
        bVar.getClass();
        Throwable th = eVar.d;
        int i2 = eVar.b;
        String str2 = "";
        if (i2 != 0) {
            str = "code='" + String.valueOf(i2) + "', msg='" + (th + "") + "'";
        } else {
            str = th + "";
        }
        String str3 = str;
        if ((th instanceof UnknownHostException) || (th instanceof ConnectException)) {
            z = true;
        } else {
            if (!(th instanceof SSLException) && !(th instanceof SocketException) && !(th instanceof SocketTimeoutException)) {
                boolean z2 = th instanceof ConnectTimeoutException;
            }
            z = false;
        }
        com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a("90002", str3);
        Map map = eVar.f;
        if (map != null && !map.isEmpty() && eVar.b == 699) {
            try {
                List list = (List) map.get("Req-Next-Time");
                if (list != null && !list.isEmpty()) {
                    str2 = (String) list.get(0);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bVar.g = Long.parseLong(str2) * 1000;
                }
            } catch (Throwable unused) {
            }
        }
        bVar.a(i, i2, str3, aVarA, true, z);
    }

    public Object a(Object obj) {
        return obj;
    }

    public void a(int i) {
    }

    public void a(AdError adError) {
    }

    public long b() {
        return 0L;
    }

    public void b(AdError adError) {
    }

    public boolean b(int i) {
        return false;
    }

    public boolean c() {
        return this instanceof d;
    }

    public boolean d() {
        return this instanceof e;
    }

    public boolean e() {
        return !(this instanceof h);
    }

    public final void f() {
        if (a() == null) {
            return;
        }
        synchronized (this) {
            if (this.q) {
                return;
            }
            this.q = true;
            if (this.m >= 0) {
                Math.max(0L, SystemClock.elapsedRealtime() - this.m);
            }
            AtomicBoolean atomicBoolean = com.smartdigimkt.h3.b.q;
            String str = this.d.b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0135  */
    /* JADX WARN: Code duplicated, block: B:76:0x0140  */
    /* JADX WARN: Code duplicated, block: B:77:0x0143  */
    public static void a(b bVar, com.smartdigimkt.d4.e eVar, int i) {
        String strA;
        List list;
        String strJoin;
        long jElapsedRealtime;
        JSONObject jSONObject;
        String strTrim;
        bVar.getClass();
        int i2 = eVar.b;
        com.smartdigimkt.e4.c cVar = eVar.e;
        if (cVar != null) {
            try {
                long jB = bVar.b();
                if (jB > 0) {
                    cVar.a = jB;
                }
                if (bVar.e()) {
                    long jElapsedRealtime2 = bVar.a() != null ? SystemClock.elapsedRealtime() : -1L;
                    if (bVar instanceof g) {
                        strA = cVar.a(true);
                    } else {
                        strA = cVar.a(false);
                    }
                    a(jElapsedRealtime2);
                    bVar.a();
                } else {
                    cVar.a();
                    strA = "";
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    cVar.a();
                }
                list = eVar.g;
                if (list.isEmpty()) {
                    strJoin = bVar.a;
                } else {
                    strJoin = TextUtils.join(" -> ", list);
                }
                String str = th.getMessage() + ", urlChain=" + strJoin;
                String str2 = th + ", urlChain=" + strJoin;
                com.smartdigimkt.n3.k.a("HTTP response error", str2 + "\n" + TextUtils.join("\n", th.getStackTrace()), SDKContext.getInstance().f(), "");
                bVar.a(i, i2, str, com.smartdigimkt.z3.b.a("90002", str2));
            }
        } else {
            strA = "";
        }
        if (!bVar.b(i2) && (i2 == 201 || i2 == 204)) {
            jElapsedRealtime = bVar.a() != null ? SystemClock.elapsedRealtime() : -1L;
            try {
                Object objA = bVar.a((Object) null);
                a(jElapsedRealtime);
                bVar.p = true;
                bVar.a(i, objA);
                return;
            } catch (Throwable th2) {
                a(jElapsedRealtime);
                throw th2;
            }
        }
        if (bVar.d()) {
            long jElapsedRealtime3 = bVar.a() != null ? SystemClock.elapsedRealtime() : -1L;
            if (!TextUtils.isEmpty(strA)) {
                strTrim = strA.trim();
                try {
                    jSONObject = new JSONObject(strTrim);
                } catch (Throwable unused) {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
                strTrim = "";
            }
            int iOptInt = jSONObject.optInt("code", 0);
            if (iOptInt == 0) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.l.f.R);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                a(jElapsedRealtime3);
                jElapsedRealtime = bVar.a() != null ? SystemClock.elapsedRealtime() : -1L;
                try {
                    Object objA2 = bVar.a(jSONObjectOptJSONObject);
                    a(jElapsedRealtime);
                    bVar.p = true;
                    bVar.a(i, objA2);
                    return;
                } catch (Throwable th3) {
                    a(jElapsedRealtime);
                    throw th3;
                }
            }
            String str3 = "code='" + String.valueOf(iOptInt) + "', msg='" + jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE) + "'";
            a(jElapsedRealtime3);
            bVar.p = true;
            bVar.a(i, com.anythink.core.common.l.q.l, strTrim, com.smartdigimkt.z3.b.a("90001", str3));
            return;
        }
        String strTrim2 = strA != null ? strA.trim() : null;
        jElapsedRealtime = bVar.a() != null ? SystemClock.elapsedRealtime() : -1L;
        try {
            Object objA3 = bVar.a(strTrim2);
            a(jElapsedRealtime);
            bVar.p = true;
            bVar.a(i, objA3);
            return;
        } catch (Throwable th4) {
            a(jElapsedRealtime);
            throw th4;
        }
        if (cVar != null) {
            cVar.a();
        }
        list = eVar.g;
        if (list.isEmpty()) {
            strJoin = bVar.a;
        } else {
            strJoin = TextUtils.join(" -> ", list);
        }
        String str4 = th.getMessage() + ", urlChain=" + strJoin;
        String str5 = th + ", urlChain=" + strJoin;
        com.smartdigimkt.n3.k.a("HTTP response error", str5 + "\n" + TextUtils.join("\n", th.getStackTrace()), SDKContext.getInstance().f(), "");
        bVar.a(i, i2, str4, com.smartdigimkt.z3.b.a("90002", str5));
    }

    public static void a(b bVar, com.smartdigimkt.g4.d dVar, byte[] bArr) {
        bVar.getClass();
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.k())) {
                com.smartdigimkt.g4.d dVar2 = bVar.d;
                int iJ = dVar2 != null ? dVar2.j() : 2;
                if ((((iJ == 1 || iJ == 2) && iJ != 2) ? TapHttp.METHOD_POST : TapHttp.METHOD_GET).equals(TapHttp.METHOD_POST) && bArr == null) {
                    throw new IllegalArgumentException("req content is null when request method is POST.");
                }
                return;
            }
            throw new IllegalArgumentException("req url is null or empty.");
        }
        throw new IllegalArgumentException("reqEntity is null.");
    }

    public void a(int i, com.smartdigimkt.a4.b bVar) {
        this.i = System.currentTimeMillis();
        this.j = a() != null ? SystemClock.elapsedRealtime() : -1L;
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = -1L;
        this.o = false;
        this.p = false;
        this.q = false;
        this.b = bVar;
        a aVar = new a(this, i);
        if (c()) {
            com.smartdigimkt.q3.f.a().a(aVar, 1);
        } else {
            com.smartdigimkt.q3.f.a().a(aVar, 10);
        }
    }

    public final void a(int i, int i2, String str, com.smartdigimkt.z3.a aVar) {
        a(i, i2, str, aVar, true, false);
    }

    public final void a(int i, int i2, String str, com.smartdigimkt.z3.a aVar, boolean z, boolean z2) {
        HttpReqEntity httpReqEntity;
        if (this.h) {
            return;
        }
        this.h = true;
        f();
        com.smartdigimkt.a4.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, str, aVar);
        }
        a(i2);
        if (z && this.c != null && (httpReqEntity = this.e) != null) {
            String interceptKey = httpReqEntity.getInterceptKey();
            HttpRespEntity httpRespEntityCreate = HttpRespEntity.create();
            long j = this.g;
            if (j > 0) {
                httpRespEntityCreate.setReqNextTime(j);
            }
            httpRespEntityCreate.setHttpCode(i2);
            httpRespEntityCreate.setUrlKey(interceptKey);
            this.c.handleRespon(httpRespEntityCreate, this.e);
        }
        if (z2) {
            a((AdError) aVar);
        }
        b(aVar);
    }

    public void a(int i, Object obj) {
        a(i, obj, true);
    }

    public final void a(int i, Object obj, boolean z) {
        HttpReqEntity httpReqEntity;
        if (this.h) {
            return;
        }
        this.h = true;
        f();
        com.smartdigimkt.a4.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, obj);
        }
        if (!z || this.c == null || (httpReqEntity = this.e) == null) {
            return;
        }
        String interceptKey = httpReqEntity.getInterceptKey();
        HttpRespEntity httpRespEntityCreate = HttpRespEntity.create();
        long j = this.g;
        if (j > 0) {
            httpRespEntityCreate.setReqNextTime(j);
        }
        httpRespEntityCreate.setHttpCode(200);
        httpRespEntityCreate.setUrlKey(interceptKey);
        this.c.handleRespon(httpRespEntityCreate, this.e);
    }

    public final com.smartdigimkt.h3.b a() {
        com.smartdigimkt.g4.d dVar = this.d;
        if (dVar != null) {
            return dVar.a;
        }
        return null;
    }

    public static long a(long j) {
        if (j < 0) {
            return -1L;
        }
        return Math.max(0L, SystemClock.elapsedRealtime() - j);
    }
}
