package com.taptap.sdk.update.download.core.interceptor;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.file.MultiPointOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class FetchDataInterceptor implements Interceptor.Fetch {
    private final int blockIndex;
    private final CallbackDispatcher dispatcher = OkDownload.with().callbackDispatcher();
    private final InputStream inputStream;
    private final MultiPointOutputStream outputStream;
    private final byte[] readBuffer;
    private final DownloadTask task;

    public FetchDataInterceptor(int blockIndex, InputStream inputStream, MultiPointOutputStream outputStream, DownloadTask task) {
        this.blockIndex = blockIndex;
        this.inputStream = inputStream;
        this.readBuffer = new byte[task.getReadBufferSize()];
        this.outputStream = outputStream;
        this.task = task;
    }

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain chain) throws IOException {
        if (chain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(chain.getTask());
        int fetchLength = this.inputStream.read(this.readBuffer);
        if (fetchLength == -1) {
            return fetchLength;
        }
        this.outputStream.write(this.blockIndex, this.readBuffer, fetchLength);
        chain.increaseCallbackBytes(fetchLength);
        if (this.dispatcher.isFetchProcessMoment(this.task)) {
            chain.flushNoCallbackIncreaseBytes();
        }
        return fetchLength;
    }
}
