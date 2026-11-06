package com.taptap.sdk.update.download.core.download;

import com.taptap.sdk.update.download.DownloadListener;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.exception.DownloadSecurityException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectTrial {
    private static final String TAG = "ConnectTrial";
    private boolean acceptRange;
    private final BreakpointInfo info;
    private long instanceLength;
    private int responseCode;
    private String responseEtag;
    private String responseFilename;
    private final DownloadTask task;
    private static final Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    public ConnectTrial(DownloadTask task, BreakpointInfo info) {
        this.task = task;
        this.info = info;
    }

    public void executeTrial() throws IOException {
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(this.task);
        OkDownload.with().downloadStrategy().inspectNetworkAvailable();
        DownloadConnection connection = OkDownload.with().connectionFactory().create(this.task.getUrl());
        try {
            if (!Util.isEmpty(this.info.getEtag())) {
                connection.addHeader(Util.IF_MATCH, this.info.getEtag());
            }
            connection.addHeader(Util.RANGE, "bytes=0-0");
            Map<String, List<String>> userHeader = this.task.getHeaderMapFields();
            if (userHeader != null) {
                Util.addUserRequestHeaderField(userHeader, connection);
            }
            DownloadListener listener = OkDownload.with().callbackDispatcher().dispatch();
            Map<String, List<String>> requestProperties = connection.getRequestProperties();
            listener.connectTrialStart(this.task, requestProperties);
            DownloadConnection.Connected connected = connection.execute();
            this.task.setRedirectLocation(connected.getRedirectLocation());
            Util.d(TAG, "task[" + this.task.getId() + "] redirect location: " + this.task.getRedirectLocation());
            this.responseCode = connected.getResponseCode();
            this.acceptRange = isAcceptRange(connected);
            this.instanceLength = findInstanceLength(connected);
            this.responseEtag = findEtag(connected);
            this.responseFilename = findFilename(connected);
            Map<String, List<String>> responseHeader = connected.getResponseHeaderFields();
            if (responseHeader == null) {
                responseHeader = new HashMap();
            }
            listener.connectTrialEnd(this.task, this.responseCode, responseHeader);
            boolean isNeedTrialHeadMethod = isNeedTrialHeadMethodForInstanceLength(this.instanceLength, connected);
            connection.release();
            if (isNeedTrialHeadMethod) {
                trialHeadMethodForInstanceLength();
            }
        } catch (Throwable th) {
            connection.release();
            throw th;
        }
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public boolean isChunked() {
        return this.instanceLength == -1;
    }

    public String getResponseEtag() {
        return this.responseEtag;
    }

    public String getResponseFilename() {
        return this.responseFilename;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public boolean isEtagOverdue() {
        return (this.info.getEtag() == null || this.info.getEtag().equals(this.responseEtag)) ? false : true;
    }

    private static boolean isAcceptRange(DownloadConnection.Connected connected) throws IOException {
        if (connected.getResponseCode() == 206) {
            return true;
        }
        String acceptRanges = connected.getResponseHeaderField(Util.ACCEPT_RANGES);
        return "bytes".equals(acceptRanges);
    }

    private static String findFilename(DownloadConnection.Connected connected) throws IOException {
        return parseContentDisposition(connected.getResponseHeaderField(Util.CONTENT_DISPOSITION));
    }

    private static String parseContentDisposition(String contentDisposition) throws IOException {
        if (contentDisposition == null) {
            return null;
        }
        String fileName = null;
        try {
            Matcher m = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(contentDisposition);
            if (m.find()) {
                fileName = m.group(1);
            } else {
                Matcher m2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(contentDisposition);
                if (m2.find()) {
                    fileName = m2.group(1);
                }
            }
            if (fileName != null && fileName.contains("../")) {
                throw new DownloadSecurityException("The filename [" + fileName + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return fileName;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    private static String findEtag(DownloadConnection.Connected connected) {
        return connected.getResponseHeaderField(Util.ETAG);
    }

    private static long findInstanceLength(DownloadConnection.Connected connected) {
        long instanceLength = parseContentRangeFoInstanceLength(connected.getResponseHeaderField(Util.CONTENT_RANGE));
        if (instanceLength != -1) {
            return instanceLength;
        }
        boolean isChunked = parseTransferEncoding(connected.getResponseHeaderField(Util.TRANSFER_ENCODING));
        if (!isChunked) {
            Util.w(TAG, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    boolean isNeedTrialHeadMethodForInstanceLength(long oldInstanceLength, DownloadConnection.Connected connected) {
        String contentLengthField;
        if (oldInstanceLength != -1) {
            return false;
        }
        String contentRange = connected.getResponseHeaderField(Util.CONTENT_RANGE);
        if (contentRange != null && contentRange.length() > 0) {
            return false;
        }
        boolean isChunked = parseTransferEncoding(connected.getResponseHeaderField(Util.TRANSFER_ENCODING));
        return (isChunked || (contentLengthField = connected.getResponseHeaderField(Util.CONTENT_LENGTH)) == null || contentLengthField.length() <= 0) ? false : true;
    }

    void trialHeadMethodForInstanceLength() throws IOException {
        DownloadConnection connection = OkDownload.with().connectionFactory().create(this.task.getUrl());
        DownloadListener listener = OkDownload.with().callbackDispatcher().dispatch();
        try {
            connection.setRequestMethod(Util.METHOD_HEAD);
            Map<String, List<String>> userHeader = this.task.getHeaderMapFields();
            if (userHeader != null) {
                Util.addUserRequestHeaderField(userHeader, connection);
            }
            listener.connectTrialStart(this.task, connection.getRequestProperties());
            DownloadConnection.Connected connectedForContentLength = connection.execute();
            listener.connectTrialEnd(this.task, connectedForContentLength.getResponseCode(), connectedForContentLength.getResponseHeaderFields());
            this.instanceLength = Util.parseContentLength(connectedForContentLength.getResponseHeaderField(Util.CONTENT_LENGTH));
        } finally {
            connection.release();
        }
    }

    private static boolean parseTransferEncoding(String transferEncoding) {
        return transferEncoding != null && transferEncoding.equals("chunked");
    }

    private static long parseContentRangeFoInstanceLength(String contentRange) {
        if (contentRange == null) {
            return -1L;
        }
        String[] session = contentRange.split("/");
        if (session.length >= 2) {
            try {
                return Long.parseLong(session[1]);
            } catch (NumberFormatException e) {
                Util.w(TAG, "parse instance length failed with " + contentRange);
            }
        }
        return -1L;
    }
}
