package com.taptap.sdk.update.download.core.download;

import android.net.ConnectivityManager;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointStore;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.connection.DownloadConnection;
import com.taptap.sdk.update.download.core.exception.NetworkPolicyException;
import com.taptap.sdk.update.download.core.exception.ResumeFailedException;
import com.taptap.sdk.update.download.core.exception.ServerCanceledException;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadStrategy {
    private static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    private static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    private static final String TAG = "DownloadStrategy";
    private static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    private static final Pattern TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    private static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    Boolean isHasAccessNetworkStatePermission = null;
    private ConnectivityManager manager = null;

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int blockIndex, BreakpointInfo info) {
        return new ResumeAvailableResponseCheck(connected, blockIndex, info);
    }

    public int determineBlockCount(DownloadTask task, long totalLength) {
        if (task.getSetConnectionCount() != null) {
            return task.getSetConnectionCount().intValue();
        }
        if (totalLength < 1048576) {
            return 1;
        }
        if (totalLength < TWO_CONNECTION_UPPER_LIMIT) {
            return 2;
        }
        if (totalLength < THREE_CONNECTION_UPPER_LIMIT) {
            return 3;
        }
        if (totalLength < FOUR_CONNECTION_UPPER_LIMIT) {
            return 4;
        }
        return 5;
    }

    public long reuseIdledSameInfoThresholdBytes() {
        return 10240L;
    }

    public boolean inspectAnotherSameInfo(DownloadTask task, BreakpointInfo info, long instanceLength) {
        BreakpointStore store;
        BreakpointInfo anotherInfo;
        if (!task.isFilenameFromResponse() || (anotherInfo = (store = OkDownload.with().breakpointStore()).findAnotherInfoFromCompare(task, info)) == null) {
            return false;
        }
        store.remove(anotherInfo.getId());
        if (anotherInfo.getTotalOffset() <= OkDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
            return false;
        }
        if ((anotherInfo.getEtag() != null && !anotherInfo.getEtag().equals(info.getEtag())) || anotherInfo.getTotalLength() != instanceLength || anotherInfo.getFile() == null || !anotherInfo.getFile().exists()) {
            return false;
        }
        info.reuseBlocks(anotherInfo);
        Util.d(TAG, "Reuse another same info: " + info);
        return true;
    }

    public boolean isUseMultiBlock(boolean isAcceptRange) {
        if (OkDownload.with().outputStreamFactory().supportSeek()) {
            return isAcceptRange;
        }
        return false;
    }

    public void inspectFilenameFromResume(String filenameOnStore, DownloadTask task) {
        String filename = task.getFilename();
        if (Util.isEmpty(filename)) {
            task.getFilenameHolder().set(filenameOnStore);
        }
    }

    public void validFilenameFromResponse(String responseFileName, DownloadTask task, BreakpointInfo info) throws IOException {
        if (Util.isEmpty(task.getFilename())) {
            String filename = determineFilename(responseFileName, task);
            if (Util.isEmpty(task.getFilename())) {
                synchronized (task) {
                    if (Util.isEmpty(task.getFilename())) {
                        task.getFilenameHolder().set(filename);
                        info.getFilenameHolder().set(filename);
                    }
                }
            }
        }
    }

    protected String determineFilename(String responseFileName, DownloadTask task) throws IOException {
        if (Util.isEmpty(responseFileName)) {
            String url = task.getUrl();
            Matcher m = TMP_FILE_NAME_PATTERN.matcher(url);
            String filename = null;
            while (m.find()) {
                filename = m.group(1);
            }
            if (Util.isEmpty(filename)) {
                filename = Util.md5(url);
            }
            if (filename == null) {
                throw new IOException("Can't find valid filename.");
            }
            return filename;
        }
        return responseFileName;
    }

    public boolean validFilenameFromStore(DownloadTask task) {
        String filename = OkDownload.with().breakpointStore().getResponseFilename(task.getUrl());
        if (filename == null) {
            return false;
        }
        task.getFilenameHolder().set(filename);
        return true;
    }

    public void validInfoOnCompleted(DownloadTask task, DownloadStore store) {
        long size;
        BreakpointInfo info = store.getAfterCompleted(task.getId());
        if (info == null) {
            info = new BreakpointInfo(task.getId(), task.getUrl(), task.getParentFile(), task.getFilename());
            if (Util.isUriContentScheme(task.getUri())) {
                size = Util.getSizeFromContentUri(task.getUri());
            } else {
                File file = task.getFile();
                if (file == null) {
                    Util.w(TAG, "file is not ready on valid info for task on complete state " + task);
                    size = 0;
                } else {
                    long size2 = file.length();
                    size = size2;
                }
            }
            info.addBlock(new BlockInfo(0L, size, size));
        }
        DownloadTask.TaskHideWrapper.setBreakpointInfo(task, info);
    }

    public static class FilenameHolder {
        private volatile String filename;
        private final boolean filenameProvidedByConstruct = false;

        public FilenameHolder() {
        }

        public FilenameHolder(String filename) {
            this.filename = filename;
        }

        void set(String filename) {
            this.filename = filename;
        }

        public String get() {
            return this.filename;
        }

        public boolean isFilenameProvidedByConstruct() {
            return this.filenameProvidedByConstruct;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof FilenameHolder)) {
                return false;
            }
            if (this.filename == null) {
                return ((FilenameHolder) obj).filename == null;
            }
            return this.filename.equals(((FilenameHolder) obj).filename);
        }

        public int hashCode() {
            if (this.filename == null) {
                return 0;
            }
            return this.filename.hashCode();
        }
    }

    public static class ResumeAvailableResponseCheck {
        private int blockIndex;
        private DownloadConnection.Connected connected;
        private BreakpointInfo info;

        protected ResumeAvailableResponseCheck(DownloadConnection.Connected connected, int blockIndex, BreakpointInfo info) {
            this.connected = connected;
            this.info = info;
            this.blockIndex = blockIndex;
        }

        public void inspect() throws IOException {
            BlockInfo blockInfo = this.info.getBlock(this.blockIndex);
            int code = this.connected.getResponseCode();
            String newEtag = this.connected.getResponseHeaderField(Util.ETAG);
            ResumeFailedCause resumeFailedCause = OkDownload.with().downloadStrategy().getPreconditionFailedCause(code, blockInfo.getCurrentOffset() != 0, this.info, newEtag);
            if (resumeFailedCause != null) {
                throw new ResumeFailedException(resumeFailedCause);
            }
            boolean isServerCancelled = OkDownload.with().downloadStrategy().isServerCanceled(code, blockInfo.getCurrentOffset() != 0);
            if (isServerCancelled) {
                throw new ServerCanceledException(code, blockInfo.getCurrentOffset());
            }
        }
    }

    public ResumeFailedCause getPreconditionFailedCause(int responseCode, boolean isAlreadyProceed, BreakpointInfo info, String responseEtag) {
        String localEtag = info.getEtag();
        if (responseCode == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (!Util.isEmpty(localEtag) && !Util.isEmpty(responseEtag) && !responseEtag.equals(localEtag)) {
            return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
        }
        if (responseCode == 201 && isAlreadyProceed) {
            return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (responseCode == 205 && isAlreadyProceed) {
            return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public boolean isServerCanceled(int responseCode, boolean isAlreadyProceed) {
        if (responseCode != 206 && responseCode != 200) {
            return true;
        }
        if (responseCode == 200 && isAlreadyProceed) {
            return true;
        }
        return false;
    }

    public void inspectNetworkAvailable() throws UnknownHostException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.isHasAccessNetworkStatePermission.booleanValue()) {
            if (this.manager == null) {
                this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
            }
            if (!Util.isNetworkAvailable(this.manager)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void inspectNetworkOnWifi(DownloadTask task) throws IOException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (task.isWifiRequired()) {
            if (!this.isHasAccessNetworkStatePermission.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.manager == null) {
                this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
            }
            if (Util.isNetworkNotOnWifiType(this.manager)) {
                throw new NetworkPolicyException();
            }
        }
    }
}
