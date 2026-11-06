package com.taptap.sdk.update.download.core.interceptor;

import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.download.DownloadCache;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.exception.RetryException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class RetryInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        DownloadCache cache = downloadChain.getCache();
        while (true) {
            try {
                if (cache.isInterrupt()) {
                    throw InterruptException.SIGNAL;
                }
                return downloadChain.processConnect();
            } catch (IOException e) {
                if (e instanceof RetryException) {
                    downloadChain.resetConnectForRetry();
                } else {
                    downloadChain.getCache().catchException(e);
                    downloadChain.getOutputStream().catchBlockConnectException(downloadChain.getBlockIndex());
                    throw e;
                }
            }
        }
    }

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        try {
            return downloadChain.processFetch();
        } catch (IOException e) {
            downloadChain.getCache().catchException(e);
            throw e;
        }
    }
}
