package com.taptap.sdk.update.download.core.interceptor;

import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.exception.RetryException;
import com.taptap.sdk.update.download.core.file.MultiPointOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    private static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static final String TAG = "BreakpointInterceptor";

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        DownloadConnection.Connected connectedProcessConnect = downloadChain.processConnect();
        BreakpointInfo info = downloadChain.getInfo();
        if (downloadChain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        if (info.getBlockCount() == 1 && !info.isChunked()) {
            long exactContentLengthRangeFrom0 = getExactContentLengthRangeFrom0(connectedProcessConnect);
            long totalLength = info.getTotalLength();
            if (exactContentLengthRangeFrom0 > 0 && exactContentLengthRangeFrom0 != totalLength) {
                Util.d(TAG, "SingleBlock special check: the response instance-length[" + exactContentLengthRangeFrom0 + "] isn't equal to the instance length from trial-connection[" + totalLength + "]");
                boolean z = info.getBlock(0).getRangeLeft() != 0;
                BlockInfo blockInfo = new BlockInfo(0L, exactContentLengthRangeFrom0);
                info.resetBlockInfos();
                info.addBlock(blockInfo);
                if (z) {
                    Util.w(TAG, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new RetryException("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                OkDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(downloadChain.getTask(), info, ResumeFailedCause.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (downloadChain.getDownloadStore().update(info)) {
                return connectedProcessConnect;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        long responseContentLength = downloadChain.getResponseContentLength();
        int blockIndex = downloadChain.getBlockIndex();
        boolean z = responseContentLength != -1;
        MultiPointOutputStream outputStream = downloadChain.getOutputStream();
        long j = 0;
        while (true) {
            try {
                long jLoopFetch = downloadChain.loopFetch();
                if (jLoopFetch == -1) {
                    break;
                }
                j += jLoopFetch;
            } catch (Throwable th) {
                downloadChain.flushNoCallbackIncreaseBytes();
                if (!downloadChain.getCache().isUserCanceled()) {
                    outputStream.done(blockIndex);
                }
                throw th;
            }
        }
        downloadChain.flushNoCallbackIncreaseBytes();
        if (!downloadChain.getCache().isUserCanceled()) {
            outputStream.done(blockIndex);
        }
        if (z) {
            outputStream.inspectComplete(blockIndex);
            if (j != responseContentLength) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j + "!= " + responseContentLength);
            }
        }
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    long getExactContentLengthRangeFrom0(DownloadConnection.Connected connected) {
        long j;
        String responseHeaderField = connected.getResponseHeaderField("Content-Range");
        if (Util.isEmpty(responseHeaderField)) {
            j = -1;
        } else {
            long rangeRightFromContentRange = getRangeRightFromContentRange(responseHeaderField);
            if (rangeRightFromContentRange > 0) {
                j = rangeRightFromContentRange + 1;
            } else {
                j = -1;
            }
        }
        if (j >= 0) {
            return j;
        }
        String responseHeaderField2 = connected.getResponseHeaderField("Content-Length");
        return !Util.isEmpty(responseHeaderField2) ? Long.parseLong(responseHeaderField2) : j;
    }

    static long getRangeRightFromContentRange(String str) {
        Matcher matcher = CONTENT_RANGE_RIGHT_VALUE.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
