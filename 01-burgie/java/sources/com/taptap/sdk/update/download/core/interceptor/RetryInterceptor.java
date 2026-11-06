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
    public DownloadConnection.Connected interceptConnect(DownloadChain chain) throws IOException {
        DownloadCache cache = chain.getCache();
        while (true) {
            try {
                if (cache.isInterrupt()) {
                    throw InterruptException.SIGNAL;
                }
                return chain.processConnect();
            } catch (IOException e) {
                if (e instanceof RetryException) {
                    chain.resetConnectForRetry();
                } else {
                    chain.getCache().catchException(e);
                    chain.getOutputStream().catchBlockConnectException(chain.getBlockIndex());
                    throw e;
                }
            }
        }
    }

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain chain) throws IOException {
        try {
            return chain.processFetch();
        } catch (IOException e) {
            chain.getCache().catchException(e);
            throw e;
        }
    }
}
