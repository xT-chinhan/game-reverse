package com.taptap.sdk.update.download.core.interceptor;

import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {

    public interface Connect {
        DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException;
    }

    public interface Fetch {
        long interceptFetch(DownloadChain downloadChain) throws IOException;
    }
}
