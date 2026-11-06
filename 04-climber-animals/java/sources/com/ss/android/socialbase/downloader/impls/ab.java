package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class ab implements IDownloadHttpService {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ny.x<String, OkHttpClient> f4676ms = new com.ss.android.socialbase.downloader.ny.x<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.ny downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws IOException {
        String strXr;
        OkHttpClient okHttpClientY;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strXr = null;
        } else {
            strXr = null;
            for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
                String strMs = ahVar.ms();
                if (strXr == null && "ss_d_request_host_ip_114".equals(strMs)) {
                    strXr = ahVar.xr();
                } else {
                    builderUrl.addHeader(strMs, com.ss.android.socialbase.downloader.ny.c.ab(ahVar.xr()));
                }
            }
        }
        if (!TextUtils.isEmpty(strXr)) {
            okHttpClientY = ms(str, strXr);
        } else {
            okHttpClientY = com.ss.android.socialbase.downloader.downloader.ah.y();
        }
        if (okHttpClientY == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientY.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header("Content-Encoding");
        final InputStream gZIPInputStream = (strHeader == null || !Constants.CP_GZIP.equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.network.ka() { // from class: com.ss.android.socialbase.downloader.impls.ab.1
            @Override // com.ss.android.socialbase.downloader.network.ms
            public String ka() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.ny
            public InputStream ms() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.ab
            public String ms(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.ss.android.socialbase.downloader.network.ab
            public int xr() throws IOException {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.ab
            public void ah() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.ny
            public void d() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private OkHttpClient ms(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f4676ms) {
                    OkHttpClient okHttpClient = this.f4676ms.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderNw = com.ss.android.socialbase.downloader.downloader.ah.nw();
                    builderNw.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.ab.2
                    });
                    OkHttpClient okHttpClientBuild = builderNw.build();
                    synchronized (this.f4676ms) {
                        this.f4676ms.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return com.ss.android.socialbase.downloader.downloader.ah.y();
    }
}
