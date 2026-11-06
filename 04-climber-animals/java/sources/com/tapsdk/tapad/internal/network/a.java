package com.tapsdk.tapad.internal.network;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import com.tapsdk.tapad.model.entities.TapAdReq;
import com.tapsdk.tapad.model.entities.TapAdResp;
import com.tapsdk.tapad.model.entities.TrackBackData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private final String a;
    private final String b;
    private final OkHttpClient c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.network.a$a, reason: collision with other inner class name */
    class C0625a<T> implements ObservableOnSubscribe<T> {
        final /* synthetic */ Class a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;

        C0625a(Class cls, String str, Map map, Map map2) {
            this.a = cls;
            this.b = str;
            this.c = map;
            this.d = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
            try {
                try {
                    observableEmitter.onNext(a.this.a(this.a, this.b, this.c, this.d));
                } finally {
                    observableEmitter.onComplete();
                }
            } catch (Error | Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements ObservableOnSubscribe<T> {
        final /* synthetic */ com.tapsdk.tapad.internal.network.c.c a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;

        b(com.tapsdk.tapad.internal.network.c.c cVar, String str, Map map, Map map2) {
            this.a = cVar;
            this.b = str;
            this.c = map;
            this.d = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
            try {
                try {
                    observableEmitter.onNext(a.this.a(this.a, this.b, this.c, this.d));
                } finally {
                    observableEmitter.onComplete();
                }
            } catch (Error | Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    class c implements ObservableOnSubscribe<String> {
        final /* synthetic */ String a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        c(String str, Map map, Map map2) {
            this.a = str;
            this.b = map;
            this.c = map2;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            try {
                try {
                    observableEmitter.onNext(a.this.a(this.a, this.b, this.c));
                } finally {
                    observableEmitter.onComplete();
                }
            } catch (Error | Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    class d implements ObservableOnSubscribe<TapAdResp.h> {
        final /* synthetic */ String a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;
        final /* synthetic */ TapAdReq.d d;

        d(String str, Map map, Map map2, TapAdReq.d dVar) {
            this.a = str;
            this.b = map;
            this.c = map2;
            this.d = dVar;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<TapAdResp.h> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(a.this.b(this.a, this.b, this.c, this.d));
                observableEmitter.onComplete();
            } catch (Error | Exception e) {
                try {
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                    observableEmitter.onError(e);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements ObservableOnSubscribe<T> {
        final /* synthetic */ Class a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;
        final /* synthetic */ JSONObject e;

        e(Class cls, String str, Map map, Map map2, JSONObject jSONObject) {
            this.a = cls;
            this.b = str;
            this.c = map;
            this.d = map2;
            this.e = jSONObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
            try {
                try {
                    observableEmitter.onNext(a.this.a(this.a, this.b, this.c, this.d, this.e));
                } finally {
                    observableEmitter.onComplete();
                }
            } catch (Error | Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements ObservableOnSubscribe<T> {
        final /* synthetic */ com.tapsdk.tapad.internal.network.c.c a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;
        final /* synthetic */ JSONObject e;

        f(com.tapsdk.tapad.internal.network.c.c cVar, String str, Map map, Map map2, JSONObject jSONObject) {
            this.a = cVar;
            this.b = str;
            this.c = map;
            this.d = map2;
            this.e = jSONObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
            try {
                try {
                    observableEmitter.onNext(a.this.a(this.a, this.b, this.c, this.d, this.e));
                } finally {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onComplete();
                    }
                }
            } catch (Error | Exception e) {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(e);
                }
                if (observableEmitter.isDisposed()) {
                }
            }
        }
    }

    public static class g {
        private String a;
        private String b;
        private OkHttpClient c;

        public g a(String str) {
            this.a = str;
            return this;
        }

        public g a(OkHttpClient okHttpClient) {
            this.c = okHttpClient;
            return this;
        }

        public a a() {
            if (this.a != null) {
                return new a(this, null);
            }
            throw new IllegalStateException("baseUrl required");
        }

        public g b(String str) {
            this.b = str;
            return this;
        }
    }

    private a(g gVar) {
        this.a = gVar.a;
        this.b = gVar.b;
        this.c = gVar.c;
    }

    /* synthetic */ a(g gVar, C0625a c0625a) {
        this(gVar);
    }

    private long a(TapAdReq.d dVar) {
        if (dVar.c1() <= 0) {
            return -1L;
        }
        TapAdReq.n nVarP = dVar.P(0);
        if (nVarP.f() >= 0) {
            return nVarP.f();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e7  */
    private String a(String str, Map<String, String> map, Map<String, String> map2, String str2, String str3) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        String string;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sbAppend;
        String strA = com.tapsdk.tapad.internal.network.c.a.a(this.a + str, map);
        Request.Builder builderUrl = new Request.Builder().url(strA);
        if (map2 != null) {
            string = "";
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                if (entry.getKey().equals("User-Agent")) {
                    string = entry.getValue();
                } else {
                    builderUrl.addHeader(entry.getKey(), entry.getValue());
                }
            }
        } else {
            string = "";
        }
        String strB = v.a().b();
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.f, Integer.class, -1)).intValue() == 1) {
            if (strB == null || strB.length() <= 0) {
                if (string == null || string.length() <= 0) {
                    string = "";
                } else if (v.a().c(strA)) {
                    sb = new StringBuilder();
                    sbAppend = sb.append(string);
                    string = sbAppend.append(" ").append(this.b).toString();
                }
            } else if (v.a().c(strA)) {
                sb2 = new StringBuilder();
                sbAppend = sb2.append(strB);
                string = sbAppend.append(" ").append(this.b).toString();
            } else {
                string = strB;
            }
        } else if (strB != null && strB.length() > 0) {
            sb2 = new StringBuilder();
            sbAppend = sb2.append(strB);
            string = sbAppend.append(" ").append(this.b).toString();
        } else if (string == null || string.length() <= 0) {
            string = "";
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append(string);
            string = sbAppend.append(" ").append(this.b).toString();
        }
        if (string.length() > 0) {
            builderUrl.removeHeader("User-Agent");
            builderUrl.addHeader("User-Agent", string);
        }
        AutoCloseable autoCloseable = null;
        if (str3 == null) {
            builderUrl.method(str2, null);
        } else {
            String str4 = (map2 == null || !map2.containsKey("Content-Type") || map2.get("Content-Type") == null) ? null : map2.get("Content-Type");
            if (str4 == null || str4.length() == 0) {
                str4 = "application/json";
            }
            builderUrl.method(str2, RequestBody.create(MediaType.parse(str4), str3.toString()));
        }
        try {
            Response responseExecute = this.c.newCall(builderUrl.build()).execute();
            if (!responseExecute.isSuccessful()) {
                throw new com.tapsdk.tapad.internal.network.b.a(responseExecute.code(), responseExecute.message(), responseExecute.body() != null ? responseExecute.body().string() : "");
            }
            if ("application/octet-stream".equals(responseExecute.headers().get("Content-Type"))) {
                if (responseExecute != null) {
                    try {
                        responseExecute.close();
                    } catch (Exception unused) {
                    }
                }
                return "";
            }
            if (responseExecute.body() == null) {
                if (responseExecute != null) {
                    try {
                        responseExecute.close();
                    } catch (Exception unused2) {
                    }
                }
                return "";
            }
            String strString = responseExecute.body().string();
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Exception unused3) {
                }
            }
            return strString;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    try {
                        autoCloseable.close();
                    } catch (Throwable th2) {
                        if (0 != 0) {
                            try {
                                autoCloseable.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th2;
                    }
                } catch (Exception unused5) {
                }
            }
            if (th instanceof com.tapsdk.tapad.internal.network.b.a) {
                throw th;
            }
            throw new com.tapsdk.tapad.internal.network.b.a(AVMDLDataLoader.KeyIsEnableEventInfo, th.getMessage(), "");
        }
    }

    public int a(String str, Map<String, String> map, Map<String, String> map2, byte[] bArr) throws IOException {
        Request.Builder builderUrl = new Request.Builder().url(com.tapsdk.tapad.internal.network.c.a.a(this.a + str, map));
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        builderUrl.method("POST", bArr == null ? null : RequestBody.create(MediaType.parse("application/x-protobuf"), bArr));
        return this.c.newCall(builderUrl.build()).execute().code();
    }

    public <T> Observable<T> a(Class<T> cls, String str) {
        return b(cls, str, (Map<String, String>) null);
    }

    public Observable<TapAdResp.h> a(String str, Map<String, String> map, Map<String, String> map2, TapAdReq.d dVar) {
        return Observable.create(new d(str, map, map2, dVar));
    }

    public <T> T a(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) a(cVar, str, (Map<String, String>) null);
    }

    public <T> T a(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) a(cVar, str, map, (Map<String, String>) null);
    }

    public <T> T a(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map, Map<String, String> map2) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) com.tapsdk.tapad.internal.network.c.b.a(a(str, map, map2), cVar);
    }

    public <T> T a(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) com.tapsdk.tapad.internal.network.c.b.a(a(str, map, map2, jSONObject), cVar);
    }

    public <T> T a(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, JSONObject jSONObject) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) a(cVar, str, (Map<String, String>) null, (Map<String, String>) null, jSONObject);
    }

    public <T> T a(Class<T> cls, String str, Map<String, String> map) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) a(cls, str, map, (Map<String, String>) null);
    }

    public <T> T a(Class<T> cls, String str, Map<String, String> map, Map<String, String> map2) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) com.tapsdk.tapad.internal.network.c.b.a(a(str, map, map2), cls);
    }

    public <T> T a(Class<T> cls, String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) com.tapsdk.tapad.internal.network.c.b.a(a(str, map, map2, jSONObject), cls);
    }

    public <T> T a(Class<T> cls, String str, JSONObject jSONObject) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        return (T) a(cls, str, (Map<String, String>) null, (Map<String, String>) null, jSONObject);
    }

    public String a(String str) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, (Map<String, String>) null);
    }

    public String a(String str, Map<String, String> map) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, map, (Map<String, String>) null);
    }

    public String a(String str, Map<String, String> map, Map<String, String> map2) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, map, map2, "GET", (String) null);
    }

    public String a(String str, Map<String, String> map, Map<String, String> map2, String str2) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, map, map2, "POST", str2);
    }

    public String a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, map, map2, "POST", jSONObject.toString());
    }

    public String a(String str, JSONObject jSONObject) throws com.tapsdk.tapad.internal.network.b.a, IOException {
        return a(str, (Map<String, String>) null, (Map<String, String>) null, "POST", jSONObject.toString());
    }

    public TapAdResp.h b(String str, Map<String, String> map, Map<String, String> map2, TapAdReq.d dVar) throws Exception {
        TapADLogger.d("FeedAd start call postWithProtoBuff requestId:" + dVar.g());
        byte[] byteArray = dVar.toByteArray();
        long jA = a(dVar);
        String strA = com.tapsdk.tapad.internal.network.c.a.a(this.a + str, map);
        String strB = v.a().b(this.a);
        Request.Builder builderUrl = new Request.Builder().url(strA);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (!TextUtils.isEmpty(strB)) {
            builderUrl.addHeader("User-Agent", strB);
        }
        TapAdResp.h hVarA = null;
        if (byteArray == null) {
            builderUrl.method("POST", null);
        } else {
            builderUrl.method("POST", RequestBody.create(MediaType.parse("application/x-protobuf"), byteArray));
        }
        try {
            TapADLogger.d("ApiClient start call postWithProtoBuff requestId:" + dVar.g());
            Response responseExecute = this.c.newCall(builderUrl.build()).execute();
            if (responseExecute.body() != null) {
                hVarA = TapAdResp.h.a(responseExecute.body().bytes());
                TapADLogger.d("ApiClient start hasResponse requestId:" + dVar.g());
            }
            TapADLogger.d("ApiClient postWithProtoBuff preGet adResp requestId:" + dVar.g());
            if (hVarA != null) {
                TapADLogger.d("ApiClient postWithProtoBuff get adResp not null requestId:" + dVar.g());
                if (hVarA.t() != 0) {
                    String strH3 = TextUtils.isEmpty(hVarA.h3()) ? "未获取到广告素材:未知错误" : hVarA.h3();
                    TapADLogger.d("ApiClient postWithProtoBuff get code <> 0 requestId:" + dVar.g() + ",code:" + hVarA.t() + ",uuid:" + hVarA.V4() + ",request_id:" + hVarA.g());
                    throw new com.tapsdk.tapad.internal.network.b.a(hVarA.t(), strH3, strH3, new TrackBackData(hVarA.g(), hVarA.V4(), jA));
                }
                TapADLogger.d("ApiClient postWithProtoBuff get response code is 0 requestId:" + dVar.g());
                if (!TextUtils.isEmpty(hVarA.h3())) {
                    TapADLogger.d("ApiClient postWithProtoBuff get response adResp msg is not null:" + dVar.g() + ",msg:" + hVarA.h3());
                    throw new com.tapsdk.tapad.internal.network.b.a(ErrorCodeEnum.COMMON_PARAM_INTERERROR.getCode(), hVarA.h3(), hVarA.h3(), new TrackBackData(hVarA.g(), hVarA.V4(), jA));
                }
                if (hVarA.M2() < 1) {
                    TapADLogger.d("ApiClient postWithProtoBuff get response ad count is 0 requestId:" + dVar.g());
                    throw new com.tapsdk.tapad.exceptions.d(ErrorCodeEnum.COMMON_UNKOWN_ERROR.getCode(), ErrorCodeEnum.COMMON_UNKOWN_ERROR.getDesc(), hVarA.V4(), hVarA.g());
                }
            }
            return hVarA;
        } catch (IOException e2) {
            TapADLogger.d("ApiClient postWithProtoBuff exception requestId:" + dVar.g() + ",cause:" + e2.getCause() + ",message:" + e2.getMessage());
            throw new com.tapsdk.tapad.internal.network.b.a(ErrorCodeEnum.COMMON_NET_ERROR.getCode(), e2.getMessage(), ErrorCodeEnum.COMMON_NET_ERROR.getDesc(), new TrackBackData("", "", jA));
        }
    }

    public <T> Observable<T> b(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str) {
        return b(cVar, str, (Map<String, String>) null);
    }

    public <T> Observable<T> b(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map) {
        return b(cVar, str, map, (Map<String, String>) null);
    }

    public <T> Observable<T> b(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map, Map<String, String> map2) {
        return Observable.create(new b(cVar, str, map, map2));
    }

    public <T> Observable<T> b(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return Observable.create(new f(cVar, str, map, map2, jSONObject));
    }

    public <T> Observable<T> b(com.tapsdk.tapad.internal.network.c.c<T> cVar, String str, JSONObject jSONObject) {
        return b(cVar, str, (Map<String, String>) null, (Map<String, String>) null, jSONObject);
    }

    public <T> Observable<T> b(Class<T> cls, String str, Map<String, String> map) {
        return b(cls, str, map, (Map<String, String>) null);
    }

    public <T> Observable<T> b(Class<T> cls, String str, Map<String, String> map, Map<String, String> map2) {
        return Observable.create(new C0625a(cls, str, map, map2));
    }

    public <T> Observable<T> b(Class<T> cls, String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return Observable.create(new e(cls, str, map, map2, jSONObject));
    }

    public Observable<String> b(String str) {
        return b(str, (Map<String, String>) null);
    }

    public Observable<String> b(String str, Map<String, String> map) {
        return b(str, map, (Map<String, String>) null);
    }

    public Observable<String> b(String str, Map<String, String> map, Map<String, String> map2) {
        return Observable.create(new c(str, map, map2));
    }
}
