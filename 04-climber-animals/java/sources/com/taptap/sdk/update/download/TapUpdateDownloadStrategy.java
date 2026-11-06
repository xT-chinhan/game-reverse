package com.taptap.sdk.update.download;

import com.taptap.sdk.update.download.core.download.DownloadStrategy;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapUpdateDownloadStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/update/download/TapUpdateDownloadStrategy;", "Lcom/taptap/sdk/update/download/core/download/DownloadStrategy;", "()V", "determineFilename", "", "responseFileName", "task", "Lcom/taptap/sdk/update/download/DownloadTask;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateDownloadStrategy extends DownloadStrategy {
    @Override // com.taptap.sdk.update.download.core.download.DownloadStrategy
    protected String determineFilename(String responseFileName, DownloadTask task) throws IOException {
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            return super.determineFilename(responseFileName, task);
        } catch (Exception e) {
            e.printStackTrace();
            return "TapTap_latest.apk";
        }
    }
}
