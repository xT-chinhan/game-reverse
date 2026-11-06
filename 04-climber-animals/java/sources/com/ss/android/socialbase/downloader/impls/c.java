package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.ss.android.socialbase.downloader.network.x {
    @Override // com.ss.android.socialbase.downloader.network.x
    public com.ss.android.socialbase.downloader.network.ab ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws IOException {
        OkHttpClient okHttpClientY = com.ss.android.socialbase.downloader.downloader.ah.y();
        if (okHttpClientY == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
                builderHead.addHeader(ahVar.ms(), com.ss.android.socialbase.downloader.ny.c.ab(ahVar.xr()));
            }
        }
        final Call callNewCall = okHttpClientY.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.ny.ms.ms(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.network.ab() { // from class: com.ss.android.socialbase.downloader.impls.c.1
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
        };
    }
}
