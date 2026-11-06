package com.tapsdk.tapad.internal.q.b;

import android.content.Context;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.e.h;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.model.entities.TapAdReq;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends EventListener {
    private static final String A = "no cause";
    private static final String B = "no message";
    private static final String C = "NetworkSegmentEventListener";
    private static final Map<String, Integer> D;
    private static final ConcurrentMap<String, f> E;
    private static final long e = 1008239;
    private static final String f = "callStart";
    private static final String g = "dnsStart";
    private static final String h = "dnsEnd";
    private static final String i = "connectStart";
    private static final String j = "secureConnectionStart";
    private static final String k = "secureConnectionEnd";
    private static final String l = "connectEnd";
    private static final String m = "requestHeadersStart";
    private static final String n = "requestHeadersEnd";
    private static final String o = "requestBodyStart";
    private static final String p = "requestBodyEnd";
    private static final String q = "responseHeadersStart";
    private static final String r = "responseHeadersEnd";
    private static final String s = "responseBodyStart";
    private static final String t = "responseBodyEnd";
    private static final String u = "callEnd";
    private static final String v = "bid";
    private static final String w = "adn_sdk";
    private static final String x = "api_v2";
    private static final String y = "cause";
    private static final String z = "message";
    private final Scheduler a = Schedulers.from(Executors.newSingleThreadExecutor());
    e b;
    private final e c;
    private final long d;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.q.b.a$a, reason: collision with other inner class name */
    class C0628a implements e {
        C0628a() {
        }

        @Override // com.tapsdk.tapad.internal.q.b.a.e
        public boolean a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                return false;
            }
            List<String> listPathSegments = httpUrl.pathSegments();
            return listPathSegments.size() >= 3 && "bid".equals(listPathSegments.get(0)) && a.w.equals(listPathSegments.get(1)) && a.x.equals(listPathSegments.get(2));
        }
    }

    class b implements Consumer<Object> {
        b() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
        }
    }

    class c implements Consumer<Throwable> {
        c() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class d implements ObservableOnSubscribe<Object> {
        final /* synthetic */ Call a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Exception d;

        d(Call call, String str, boolean z, Exception exc) {
            this.a = call;
            this.b = str;
            this.c = z;
            this.d = exc;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(a.this.b(this.a, this.b, this.c, this.d));
                observableEmitter.onComplete();
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    public interface e {
        boolean a(HttpUrl httpUrl);
    }

    static class f {
        public final Integer[] a;
        public long b;
        public long c;

        public f() {
            Integer[] numArr = new Integer[16];
            this.a = numArr;
            Arrays.fill((Object[]) numArr, (Object) 0);
        }
    }

    static {
        HashMap map = new HashMap();
        D = map;
        map.put(f, 0);
        map.put(g, 1);
        map.put(h, 2);
        map.put(i, 3);
        map.put(j, 4);
        map.put(k, 5);
        map.put(l, 6);
        map.put(m, 7);
        map.put(n, 8);
        map.put(o, 9);
        map.put(p, 10);
        map.put(q, 11);
        map.put(r, 12);
        map.put(s, 13);
        map.put(t, 14);
        map.put(u, 15);
        E = new ConcurrentHashMap();
    }

    public a() {
        C0628a c0628a = new C0628a();
        this.b = c0628a;
        this.c = c0628a;
        this.d = System.currentTimeMillis();
    }

    private String a(f fVar) {
        Integer[] numArr = fVar.a;
        StringBuilder sb = new StringBuilder();
        if (16 == numArr.length) {
            for (Integer num : numArr) {
                int iIntValue = num.intValue();
                if (iIntValue != 0 && 1 != iIntValue && 2 != iIntValue) {
                    return "";
                }
                sb.append(String.valueOf(iIntValue));
            }
        }
        return sb.toString();
    }

    private void a(Call call, String str, boolean z2) {
        if (z2) {
            a(call, str, z2, null);
        }
    }

    private void a(Call call, String str, boolean z2, Exception exc) {
        Observable.create(new d(call, str, z2, exc)).subscribeOn(this.a).subscribe(new b(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d A[Catch: IOException -> 0x018d, TryCatch #2 {IOException -> 0x018d, blocks: (B:14:0x0037, B:16:0x004f, B:20:0x0062, B:21:0x0065, B:25:0x0071, B:27:0x007d, B:28:0x0083, B:30:0x008b, B:31:0x0091, B:58:0x00e2, B:60:0x00e8, B:62:0x00ee, B:70:0x011e, B:72:0x0126, B:17:0x0055, B:19:0x005d), top: B:80:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x008b A[Catch: IOException -> 0x018d, TryCatch #2 {IOException -> 0x018d, blocks: (B:14:0x0037, B:16:0x004f, B:20:0x0062, B:21:0x0065, B:25:0x0071, B:27:0x007d, B:28:0x0083, B:30:0x008b, B:31:0x0091, B:58:0x00e2, B:60:0x00e8, B:62:0x00ee, B:70:0x011e, B:72:0x0126, B:17:0x0055, B:19:0x005d), top: B:80:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bd A[Catch: all -> 0x00e0, TryCatch #1 {all -> 0x00e0, blocks: (B:32:0x0096, B:35:0x009e, B:39:0x00a8, B:41:0x00ae, B:42:0x00b2, B:43:0x00b7, B:55:0x00db, B:45:0x00bd, B:47:0x00c3, B:50:0x00ca, B:52:0x00d3), top: B:78:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c3 A[Catch: all -> 0x00e0, TRY_LEAVE, TryCatch #1 {all -> 0x00e0, blocks: (B:32:0x0096, B:35:0x009e, B:39:0x00a8, B:41:0x00ae, B:42:0x00b2, B:43:0x00b7, B:55:0x00db, B:45:0x00bd, B:47:0x00c3, B:50:0x00ca, B:52:0x00d3), top: B:78:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d3 A[Catch: all -> 0x00e0, TRY_LEAVE, TryCatch #1 {all -> 0x00e0, blocks: (B:32:0x0096, B:35:0x009e, B:39:0x00a8, B:41:0x00ae, B:42:0x00b2, B:43:0x00b7, B:55:0x00db, B:45:0x00bd, B:47:0x00c3, B:50:0x00ca, B:52:0x00d3), top: B:78:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e8 A[Catch: IOException -> 0x018d, TRY_LEAVE, TryCatch #2 {IOException -> 0x018d, blocks: (B:14:0x0037, B:16:0x004f, B:20:0x0062, B:21:0x0065, B:25:0x0071, B:27:0x007d, B:28:0x0083, B:30:0x008b, B:31:0x0091, B:58:0x00e2, B:60:0x00e8, B:62:0x00ee, B:70:0x011e, B:72:0x0126, B:17:0x0055, B:19:0x005d), top: B:80:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x011c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0126 A[Catch: IOException -> 0x018d, TRY_LEAVE, TryCatch #2 {IOException -> 0x018d, blocks: (B:14:0x0037, B:16:0x004f, B:20:0x0062, B:21:0x0065, B:25:0x0071, B:27:0x007d, B:28:0x0083, B:30:0x008b, B:31:0x0091, B:58:0x00e2, B:60:0x00e8, B:62:0x00ee, B:70:0x011e, B:72:0x0126, B:17:0x0055, B:19:0x005d), top: B:80:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public Object b(Call call, String str, boolean z2, Exception exc) {
        RequestBody requestBodyBody;
        Integer num;
        f fVar;
        int i2;
        JSONObject jSONObject;
        String string;
        long jF;
        int i3;
        Context context;
        Object cause;
        String message;
        Object obj = new Object();
        HttpUrl httpUrlUrl = call.request().url();
        if (!this.c.a(httpUrlUrl) || (requestBodyBody = call.request().body()) == null) {
            return obj;
        }
        Map<String, Integer> map = D;
        if (!map.containsKey(str) || (num = map.get(str)) == null) {
            return obj;
        }
        try {
            TapAdReq.d dVarA = com.tapsdk.tapad.internal.t.f.b.a(requestBodyBody);
            long jM0 = dVarA.Y4().m0();
            String strG = dVarA.g();
            ConcurrentMap<String, f> concurrentMap = E;
            if (concurrentMap.containsKey(strG) && (fVar = concurrentMap.get(strG)) != null) {
                Integer[] numArr = fVar.a;
                int iIntValue = num.intValue();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                numArr[iIntValue] = Integer.valueOf(i2);
                if (num.intValue() == 0) {
                    fVar.b = System.currentTimeMillis();
                }
                if (15 == num.intValue()) {
                    fVar.c = System.currentTimeMillis();
                }
                jSONObject = new JSONObject();
                try {
                    context = com.tapsdk.tapad.c.a;
                    if (context != null || com.tapsdk.tapad.internal.utils.d.g(context)) {
                        if (exc != null) {
                            if (exc.getCause() != null) {
                                cause = exc.getCause();
                            } else {
                                cause = A;
                            }
                            jSONObject.put(y, cause);
                            if (exc.getMessage() != null) {
                                message = exc.getMessage();
                            } else {
                                message = B;
                            }
                        } else {
                            string = "";
                        }
                        if (15 == num.intValue()) {
                            if (1 == ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.n, Integer.class, 0)).intValue()) {
                                try {
                                    jF = dVarA.w0().get(0).f();
                                } catch (Throwable unused) {
                                    jF = Long.MAX_VALUE;
                                }
                                i3 = e == jM0 ? 100 : 0;
                                if (E.containsKey(strG)) {
                                    com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.e().h(httpUrlUrl.toString()).c(httpUrlUrl.host()).d("POST").g(strG).d(jF).a(string).b(com.tapsdk.tapad.internal.utils.e.a(exc)).e(a(fVar)).a(i3).f(h.b().a()).b(fVar.b).a(fVar.c).c(this.d));
                                }
                            }
                        }
                    } else {
                        Object cause2 = "NoNetworkException";
                        if (exc != null && exc.getCause() != null) {
                            cause2 = exc.getCause();
                        }
                        jSONObject.put(y, cause2);
                        message = "no network available";
                    }
                    jSONObject.put(z, message);
                    string = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                if (15 == num.intValue()) {
                    if (1 == ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.n, Integer.class, 0)).intValue()) {
                        jF = dVarA.w0().get(0).f();
                        if (e == jM0) {
                        }
                        if (E.containsKey(strG)) {
                            com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.e().h(httpUrlUrl.toString()).c(httpUrlUrl.host()).d("POST").g(strG).d(jF).a(string).b(com.tapsdk.tapad.internal.utils.e.a(exc)).e(a(fVar)).a(i3).f(h.b().a()).b(fVar.b).a(fVar.c).c(this.d));
                        }
                    }
                }
            } else {
                fVar = new f();
                concurrentMap.put(strG, fVar);
                Integer[] numArr2 = fVar.a;
                int iIntValue2 = num.intValue();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                numArr2[iIntValue2] = Integer.valueOf(i2);
                if (num.intValue() == 0) {
                    fVar.b = System.currentTimeMillis();
                }
                if (15 == num.intValue()) {
                    fVar.c = System.currentTimeMillis();
                }
                jSONObject = new JSONObject();
                context = com.tapsdk.tapad.c.a;
                if (context != null) {
                    if (exc != null) {
                        if (exc.getCause() != null) {
                            cause = exc.getCause();
                        } else {
                            cause = A;
                        }
                        jSONObject.put(y, cause);
                        if (exc.getMessage() != null) {
                            message = exc.getMessage();
                        } else {
                            message = B;
                        }
                    } else {
                        string = "";
                    }
                    if (15 == num.intValue()) {
                        if (1 == ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.n, Integer.class, 0)).intValue()) {
                            jF = dVarA.w0().get(0).f();
                            if (e == jM0) {
                            }
                            if (E.containsKey(strG)) {
                                com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.e().h(httpUrlUrl.toString()).c(httpUrlUrl.host()).d("POST").g(strG).d(jF).a(string).b(com.tapsdk.tapad.internal.utils.e.a(exc)).e(a(fVar)).a(i3).f(h.b().a()).b(fVar.b).a(fVar.c).c(this.d));
                            }
                        }
                    }
                } else {
                    if (exc != null) {
                        if (exc.getCause() != null) {
                            cause = exc.getCause();
                        } else {
                            cause = A;
                        }
                        jSONObject.put(y, cause);
                        if (exc.getMessage() != null) {
                            message = exc.getMessage();
                        } else {
                            message = B;
                        }
                    } else {
                        string = "";
                    }
                    if (15 == num.intValue()) {
                        if (1 == ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.n, Integer.class, 0)).intValue()) {
                            jF = dVarA.w0().get(0).f();
                            if (e == jM0) {
                            }
                            if (E.containsKey(strG)) {
                                com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.e().h(httpUrlUrl.toString()).c(httpUrlUrl.host()).d("POST").g(strG).d(jF).a(string).b(com.tapsdk.tapad.internal.utils.e.a(exc)).e(a(fVar)).a(i3).f(h.b().a()).b(fVar.b).a(fVar.c).c(this.d));
                            }
                        }
                    }
                }
                jSONObject.put(z, message);
                string = jSONObject.toString();
                if (15 == num.intValue()) {
                    if (1 == ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.n, Integer.class, 0)).intValue()) {
                        jF = dVarA.w0().get(0).f();
                        if (e == jM0) {
                        }
                        if (E.containsKey(strG)) {
                            com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.e().h(httpUrlUrl.toString()).c(httpUrlUrl.host()).d("POST").g(strG).d(jF).a(string).b(com.tapsdk.tapad.internal.utils.e.a(exc)).e(a(fVar)).a(i3).f(h.b().a()).b(fVar.b).a(fVar.c).c(this.d));
                        }
                    }
                }
            }
        } catch (IOException unused3) {
        }
        return obj;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        a(call, u, true);
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a(call, u, false, iOException);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        a(call, f, true);
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        a(call, l, true);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        a(call, l, false, iOException);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        a(call, i, true);
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        a(call, h, list.size() > 0, list.size() == 0 ? new RuntimeException("dnsEnd no ip address") : null);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        a(call, g, true);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j2) {
        super.requestBodyEnd(call, j2);
        a(call, p, true);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        a(call, o, true);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        a(call, n, true);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        a(call, m, true);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j2) {
        super.responseBodyEnd(call, j2);
        a(call, t, true);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        a(call, s, true);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        a(call, r, true);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        a(call, q, true);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        a(call, k, true);
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        a(call, j, true);
    }
}
