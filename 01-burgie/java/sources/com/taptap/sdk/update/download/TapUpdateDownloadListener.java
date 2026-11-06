package com.taptap.sdk.update.download;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.update.download.core.cause.EndCause;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapUpdateDownloadListener.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J2\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/update/download/TapUpdateDownloadListener;", "", "onDownloadFailed", "", "cause", "Lcom/taptap/sdk/update/download/core/cause/EndCause;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadProgress", "currentOffset", "", "fileTotalSize", "speedBytes", NotificationCompat.CATEGORY_PROGRESS, "", "speed", "", "onDownloadStart", "fileSize", "onDownloadSuccess", "file", "Ljava/io/File;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapUpdateDownloadListener {
    void onDownloadFailed(EndCause cause, Exception e);

    void onDownloadProgress(long currentOffset, long fileTotalSize, long speedBytes, int progress, String speed);

    void onDownloadStart(long fileSize);

    void onDownloadSuccess(File file);
}
