package com.byazt.ts;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.edb.IDownloadHttpService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 62})
public class fw implements IDownloadHttpService {
    public final com.byazt.tuy.zo<String, OkHttpClient> pr = new com.byazt.tuy.zo<>(4, 8);

    @Override // com.byazt.edb.IDownloadHttpService
    public com.byazt.edb.aj downloadWithConnection(int i, String str, List<com.byazt.auw.hn> list) throws IOException {
        String strHw;
        OkHttpClient okHttpClientQa;
        final InputStream gZIPInputStream;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list != null && list.size() > 0) {
            strHw = null;
            for (com.byazt.auw.hn hnVar : list) {
                String strPr = hnVar.pr();
                if (strHw == null && "ss_d_request_host_ip_114".equals(strPr)) {
                    strHw = hnVar.hw();
                } else {
                    builderUrl.addHeader(strPr, com.byazt.tuy.uc.fw(hnVar.hw()));
                }
            }
        } else {
            strHw = null;
        }
        if (!TextUtils.isEmpty(strHw)) {
            okHttpClientQa = pr(str, strHw);
        } else {
            okHttpClientQa = com.byazt.lj.hn.qa();
        }
        if (okHttpClientQa == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientQa.newCall(builderUrl.build());
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
        if (strHeader != null && Constants.CP_GZIP.equalsIgnoreCase(strHeader) && !(inputStreamByteStream instanceof GZIPInputStream)) {
            gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
        } else {
            gZIPInputStream = inputStreamByteStream;
        }
        return new com.byazt.edb.c() { // from class: com.byazt.ts.fw.1
            @Override // com.byazt.edb.aj
            public InputStream pr() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.byazt.edb.fw
            public String pr(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.byazt.edb.fw
            public int hw() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.edb.fw
            public void hn() {
                Call call = callNewCall;
                if (call != null && !call.isCanceled()) {
                    callNewCall.cancel();
                }
            }

            @Override // com.byazt.edb.aj
            public void x() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call != null && !call.isCanceled()) {
                        callNewCall.cancel();
                    }
                } catch (Throwable th) {
                }
            }

            @Override // com.byazt.edb.pr
            public String c() {
                return "";
            }
        };
    }

    private OkHttpClient pr(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.pr) {
                    OkHttpClient okHttpClient = this.pr.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderCz = com.byazt.lj.hn.cz();
                    builderCz.dns(new Dns() { // from class: com.byazt.ts.fw.2
                    });
                    OkHttpClient okHttpClientBuild = builderCz.build();
                    synchronized (this.pr) {
                        this.pr.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
        }
        return com.byazt.lj.hn.qa();
    }
}
