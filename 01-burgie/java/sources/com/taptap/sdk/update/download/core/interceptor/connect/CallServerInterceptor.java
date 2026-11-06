package com.taptap.sdk.update.download.core.interceptor.connect;

import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import com.taptap.sdk.update.download.core.interceptor.Interceptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class CallServerInterceptor implements Interceptor.Connect {
    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain chain) throws IOException {
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(chain.getTask());
        OkDownload.with().downloadStrategy().inspectNetworkAvailable();
        return chain.getConnectionOrCreate().execute();
    }
}
