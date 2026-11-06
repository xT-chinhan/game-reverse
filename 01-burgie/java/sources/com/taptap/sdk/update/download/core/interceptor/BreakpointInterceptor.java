package com.taptap.sdk.update.download.core.interceptor;

import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
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
    public DownloadConnection.Connected interceptConnect(DownloadChain chain) throws IOException {
        DownloadConnection.Connected connected = chain.processConnect();
        BreakpointInfo info = chain.getInfo();
        if (chain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        if (info.getBlockCount() == 1 && !info.isChunked()) {
            long blockInstanceLength = getExactContentLengthRangeFrom0(connected);
            long infoInstanceLength = info.getTotalLength();
            if (blockInstanceLength > 0 && blockInstanceLength != infoInstanceLength) {
                Util.d(TAG, "SingleBlock special check: the response instance-length[" + blockInstanceLength + "] isn't equal to the instance length from trial-connection[" + infoInstanceLength + "]");
                BlockInfo blockInfo = info.getBlock(0);
                boolean isFromBreakpoint = blockInfo.getRangeLeft() != 0;
                BlockInfo newBlockInfo = new BlockInfo(0L, blockInstanceLength);
                info.resetBlockInfos();
                info.addBlock(newBlockInfo);
                if (isFromBreakpoint) {
                    Util.w(TAG, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new RetryException("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                OkDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(chain.getTask(), info, ResumeFailedCause.CONTENT_LENGTH_CHANGED);
            }
        }
        DownloadStore store = chain.getDownloadStore();
        try {
            if (!store.update(info)) {
                throw new IOException("Update store failed!");
            }
            return connected;
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain chain) throws IOException {
        long contentLength = chain.getResponseContentLength();
        int blockIndex = chain.getBlockIndex();
        boolean isNotChunked = contentLength != -1;
        long fetchLength = 0;
        MultiPointOutputStream outputStream = chain.getOutputStream();
        while (true) {
            try {
                long processFetchLength = chain.loopFetch();
                if (processFetchLength == -1) {
                    break;
                }
                fetchLength += processFetchLength;
            } catch (Throwable th) {
                chain.flushNoCallbackIncreaseBytes();
                if (!chain.getCache().isUserCanceled()) {
                    outputStream.done(blockIndex);
                }
                throw th;
            }
        }
        chain.flushNoCallbackIncreaseBytes();
        if (!chain.getCache().isUserCanceled()) {
            outputStream.done(blockIndex);
        }
        if (isNotChunked) {
            outputStream.inspectComplete(blockIndex);
            if (fetchLength != contentLength) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + fetchLength + "!= " + contentLength);
            }
        }
        return fetchLength;
    }

    long getExactContentLengthRangeFrom0(DownloadConnection.Connected connected) {
        String contentRangeField = connected.getResponseHeaderField(Util.CONTENT_RANGE);
        long contentLength = -1;
        if (!Util.isEmpty(contentRangeField)) {
            long rightRange = getRangeRightFromContentRange(contentRangeField);
            if (rightRange > 0) {
                contentLength = rightRange + 1;
            }
        }
        if (contentLength < 0) {
            String contentLengthField = connected.getResponseHeaderField(Util.CONTENT_LENGTH);
            if (!Util.isEmpty(contentLengthField)) {
                return Long.parseLong(contentLengthField);
            }
            return contentLength;
        }
        return contentLength;
    }

    static long getRangeRightFromContentRange(String contentRange) {
        Matcher m = CONTENT_RANGE_RIGHT_VALUE.matcher(contentRange);
        if (m.find()) {
            return Long.parseLong(m.group(1));
        }
        return -1L;
    }
}
