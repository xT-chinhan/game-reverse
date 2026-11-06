package com.byazt.i;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.m.IDownloadHttpService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 21})
public class x implements IDownloadHttpService {
    public final com.byazt.ta.fs<String, OkHttpClient> n = new com.byazt.ta.fs<>(4, 8);

    @Override // com.byazt.m.IDownloadHttpService
    public com.byazt.m.rv downloadWithConnection(int i, String str, List<com.byazt.wm.s> list) throws IOException {
        String strQg;
        OkHttpClient okHttpClientUm;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strQg = null;
        } else {
            strQg = null;
            for (com.byazt.wm.s sVar : list) {
                String strN = sVar.n();
                if (strQg == null && "ss_d_request_host_ip_114".equals(strN)) {
                    strQg = sVar.qg();
                } else {
                    builderUrl.addHeader(strN, com.byazt.ta.w.x(sVar.qg()));
                }
            }
        }
        if (!TextUtils.isEmpty(strQg)) {
            okHttpClientUm = n(str, strQg);
        } else {
            okHttpClientUm = com.byazt.xv.s.um();
        }
        if (okHttpClientUm == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientUm.newCall(builderUrl.build());
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
        final InputStream gZIPInputStream = (strHeader == null || !"gzip".equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.byazt.m.l() { // from class: com.byazt.i.x.1
            @Override // com.byazt.m.n
            public String l() {
                return "";
            }

            @Override // com.byazt.m.rv
            public InputStream n() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.byazt.m.x
            public String n(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.byazt.m.x
            public int qg() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.m.x
            public void s() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.byazt.m.rv
            public void q() {
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

    private OkHttpClient n(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.n) {
                    OkHttpClient okHttpClient = this.n.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderPy = com.byazt.xv.s.py();
                    builderPy.dns(new Dns() { // from class: com.byazt.i.x.2
                    });
                    OkHttpClient okHttpClientBuild = builderPy.build();
                    synchronized (this.n) {
                        this.n.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable unused) {
        }
        return com.byazt.xv.s.um();
    }
}
