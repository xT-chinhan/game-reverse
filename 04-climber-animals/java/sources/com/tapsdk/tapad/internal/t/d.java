package com.tapsdk.tapad.internal.t;

import com.tapsdk.tapad.BuildConfig;
import com.tapsdk.tapad.model.entities.TapAdResp;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class d implements Interceptor {
    private final a a;

    public d(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008e  */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String path;
        ResponseBody responseBodyCreate;
        Response responseProceed = chain.proceed(chain.request());
        if (!responseProceed.isSuccessful()) {
            return responseProceed;
        }
        Response.Builder builderNewBuilder = responseProceed.newBuilder();
        String strHeader = responseProceed.header("Content-Type");
        if (strHeader == null || strHeader.length() == 0) {
            strHeader = "application/json";
        }
        if (responseProceed.body() == null) {
            return responseProceed;
        }
        String strString = responseProceed.body().string();
        a aVar = this.a;
        if (aVar == null) {
            throw new IllegalArgumentException("No encryption strategy");
        }
        try {
            byte[] bArrA = aVar.a(strString);
            if (bArrA == null) {
                return responseProceed;
            }
            try {
                path = responseProceed.request().url().url().getPath();
            } catch (Exception unused) {
                path = null;
            }
            if (com.tapsdk.tapad.b.a() && BuildConfig.BASE_SERVER_URL_PATH_CN.equalsIgnoreCase(path)) {
                TapAdResp.h hVarA = TapAdResp.h.a(bArrA);
                for (int i = 0; i < com.tapsdk.tapad.b.c().size() && hVarA != null; i++) {
                    hVarA = com.tapsdk.tapad.b.c().get(i).a(hVarA);
                }
                if (hVarA != null) {
                    responseBodyCreate = ResponseBody.create(MediaType.parse(strHeader), hVarA.toByteArray());
                } else {
                    responseBodyCreate = ResponseBody.create(MediaType.parse(strHeader), bArrA);
                }
            } else {
                responseBodyCreate = ResponseBody.create(MediaType.parse(strHeader), bArrA);
            }
            builderNewBuilder.body(responseBodyCreate);
            return builderNewBuilder.build();
        } catch (Exception e) {
            String str = e.getCause() != null ? "" + e.getCause() : "";
            if (e.getMessage() != null) {
                if (str.length() > 0) {
                    str = str + " ";
                }
                str = str + e.getMessage();
            }
            throw new RuntimeException("decryptedStr fail:" + str);
        }
    }
}
