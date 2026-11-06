package com.taptap.sdk.update.download.core.interceptor.connect;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.download.DownloadChain;
import com.taptap.sdk.update.download.core.download.DownloadStrategy;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.interceptor.Interceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HeaderInterceptor implements Interceptor.Connect {
    private static final String TAG = "HeaderInterceptor";

    @Override // com.taptap.sdk.update.download.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain chain) throws IOException {
        long contentLength;
        BreakpointInfo info = chain.getInfo();
        DownloadConnection connection = chain.getConnectionOrCreate();
        DownloadTask task = chain.getTask();
        Map<String, List<String>> userHeader = task.getHeaderMapFields();
        if (userHeader != null) {
            Util.addUserRequestHeaderField(userHeader, connection);
        }
        if (userHeader == null || !userHeader.containsKey("User-Agent")) {
            Util.addDefaultUserAgent(connection);
        }
        int blockIndex = chain.getBlockIndex();
        BlockInfo blockInfo = info.getBlock(blockIndex);
        if (blockInfo == null) {
            throw new IOException("No block-info found on " + blockIndex);
        }
        String range = "bytes=" + blockInfo.getRangeLeft() + "-";
        connection.addHeader(Util.RANGE, range + blockInfo.getRangeRight());
        Util.d(TAG, "AssembleHeaderRange (" + task.getId() + ") block(" + blockIndex + ") downloadFrom(" + blockInfo.getRangeLeft() + ") currentOffset(" + blockInfo.getCurrentOffset() + ")");
        String etag = info.getEtag();
        if (!Util.isEmpty(etag)) {
            connection.addHeader(Util.IF_MATCH, etag);
        }
        if (chain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        OkDownload.with().callbackDispatcher().dispatch().connectStart(task, blockIndex, connection.getRequestProperties());
        DownloadConnection.Connected connected = chain.processConnect();
        if (chain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        Map<String, List<String>> responseHeaderFields = connected.getResponseHeaderFields();
        if (responseHeaderFields == null) {
            responseHeaderFields = new HashMap();
        }
        OkDownload.with().callbackDispatcher().dispatch().connectEnd(task, blockIndex, connected.getResponseCode(), responseHeaderFields);
        DownloadStrategy strategy = OkDownload.with().downloadStrategy();
        DownloadStrategy.ResumeAvailableResponseCheck responseCheck = strategy.resumeAvailableResponseCheck(connected, blockIndex, info);
        responseCheck.inspect();
        String contentLengthField = connected.getResponseHeaderField(Util.CONTENT_LENGTH);
        if (contentLengthField == null || contentLengthField.length() == 0) {
            String contentRangeField = connected.getResponseHeaderField(Util.CONTENT_RANGE);
            contentLength = Util.parseContentLengthFromContentRange(contentRangeField);
        } else {
            contentLength = Util.parseContentLength(contentLengthField);
        }
        chain.setResponseContentLength(contentLength);
        return connected;
    }
}
