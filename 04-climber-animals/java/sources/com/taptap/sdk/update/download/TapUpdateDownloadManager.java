package com.taptap.sdk.update.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.file.FileProvider;
import com.taptap.sdk.update.download.core.listener.DownloadListener4WithSpeed;
import com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend;
import com.taptap.sdk.update.internal.TapUpdateLoggerKt;
import com.taptap.sdk.update.internal.UpdateTracker;
import com.umeng.analytics.pro.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapUpdateDownloadManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J,\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u001a\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/update/download/TapUpdateDownloadManager;", "", "()V", "currentDownloadTask", "Lcom/taptap/sdk/update/download/DownloadTask;", "defaultSaveRootPath", "", "prepared", "", "cancelDownload", "", "clearCache", g.X, "Landroid/content/Context;", "deleteFiles", "file", "Ljava/io/File;", "download", "url", TTDownloadField.TT_FILE_NAME, "listener", "Lcom/taptap/sdk/update/download/TapUpdateDownloadListener;", "getDefaultSaveRootPath", "installAPK", "isManualClick", "prepareDownload", "restartTask", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateDownloadManager {
    private static DownloadTask currentDownloadTask;
    private static boolean prepared;
    public static final TapUpdateDownloadManager INSTANCE = new TapUpdateDownloadManager();
    private static String defaultSaveRootPath = "";

    private TapUpdateDownloadManager() {
    }

    public final void prepareDownload(Context context) {
        if (prepared) {
            return;
        }
        OkDownload.Builder builderDownloadStrategy = new OkDownload.Builder(context).downloadStrategy(new TapUpdateDownloadStrategy());
        Intrinsics.checkNotNullExpressionValue(builderDownloadStrategy, "Builder(context)\n       …UpdateDownloadStrategy())");
        try {
            OkDownload.setSingletonInstance(builderDownloadStrategy.build());
        } catch (Exception unused) {
        }
        prepared = true;
    }

    public final void download(Context context, String url, String fileName, final TapUpdateDownloadListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        prepareDownload(context);
        if (currentDownloadTask == null) {
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(PlatformXUA.getTrackUA());
            map.put("XUA", arrayList);
            DownloadTask downloadTaskBuild = new DownloadTask.Builder(url, getDefaultSaveRootPath(context), fileName).setMinIntervalMillisCallbackProcess(1000).setHeaderMapFields(map).build();
            Intrinsics.checkNotNullExpressionValue(downloadTaskBuild, "Builder(\n               …\n                .build()");
            downloadTaskBuild.setTag(url);
            currentDownloadTask = downloadTaskBuild;
            downloadTaskBuild.enqueue(new DownloadListener4WithSpeed() { // from class: com.taptap.sdk.update.download.TapUpdateDownloadManager.download.1
                @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
                public void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset, SpeedCalculator blockSpeed) {
                }

                @Override // com.taptap.sdk.update.download.DownloadListener
                public void taskStart(DownloadTask task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " start");
                }

                @Override // com.taptap.sdk.update.download.DownloadListener
                public void connectStart(DownloadTask task, int blockIndex, Map<String, ? extends List<String>> requestHeaderFields) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " connect start");
                }

                @Override // com.taptap.sdk.update.download.DownloadListener
                public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, ? extends List<String>> responseHeaderFields) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " connect end");
                }

                @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
                public void infoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint, Listener4SpeedAssistExtend.Listener4SpeedModel model) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(info, "info");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " info ready");
                    TapUpdateDownloadListener tapUpdateDownloadListener = listener;
                    if (tapUpdateDownloadListener != null) {
                        tapUpdateDownloadListener.onDownloadStart(info.getTotalLength());
                    }
                }

                @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
                public void progress(DownloadTask task, long currentOffset, SpeedCalculator taskSpeed) {
                    long totalLength;
                    TapUpdateDownloadListener tapUpdateDownloadListener;
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(taskSpeed, "taskSpeed");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " progress " + currentOffset);
                    if (task.getInfo() != null) {
                        totalLength = task.getInfo().getTotalLength();
                        TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, "APKDownload PROGRESS fileTotalLength = " + totalLength + " currentOffset = " + currentOffset);
                    } else {
                        totalLength = 0;
                    }
                    if (totalLength == 0 || (tapUpdateDownloadListener = listener) == null) {
                        return;
                    }
                    tapUpdateDownloadListener.onDownloadProgress(currentOffset, totalLength, taskSpeed.getBytesPerSecondAndFlush(), (int) ((((long) 100) * currentOffset) / totalLength), taskSpeed.speed());
                }

                @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
                public void blockEnd(DownloadTask task, int blockIndex, BlockInfo info, SpeedCalculator blockSpeed) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task + " block end ");
                }

                @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
                public void taskEnd(DownloadTask task, EndCause cause, Exception realCause, SpeedCalculator taskSpeed) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(cause, "cause");
                    TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, task.toString() + " task end " + cause.name());
                    if (cause == EndCause.COMPLETED) {
                        TapUpdateDownloadListener tapUpdateDownloadListener = listener;
                        if (tapUpdateDownloadListener != null) {
                            tapUpdateDownloadListener.onDownloadSuccess(task.getFile());
                            return;
                        }
                        return;
                    }
                    TapUpdateDownloadListener tapUpdateDownloadListener2 = listener;
                    if (tapUpdateDownloadListener2 != null) {
                        tapUpdateDownloadListener2.onDownloadFailed(cause, realCause);
                    }
                }
            });
            return;
        }
        restartTask();
    }

    public final void restartTask() {
        if (currentDownloadTask != null) {
            OkDownload.with().downloadDispatcher().enqueue(currentDownloadTask);
        }
    }

    public final void cancelDownload() {
        currentDownloadTask = null;
        OkDownload.with().downloadDispatcher().cancelAll();
    }

    public final void installAPK(Context context, File file, boolean isManualClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        UpdateTracker.INSTANCE.trackInstall(isManualClick);
        try {
            TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, "installAPK" + file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435457);
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".com.taptap.sdk.update.internal.fileProvider", file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(\n         …   file\n                )");
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } catch (Exception e) {
            TapLogger.loge$default(TapUpdateLoggerKt.LOGGER_TAG, "installAPK failed " + e.getMessage(), null, 4, null);
        }
    }

    public final void clearCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file = new File(getDefaultSaveRootPath(context));
            if (file.exists()) {
                TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, "clearCache " + file.getAbsolutePath());
                TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, "clearCache result " + deleteFiles(file));
            }
        } catch (Exception e) {
            TapLogger.logd(TapUpdateLoggerKt.LOGGER_TAG, "clearCache failed" + e);
        }
    }

    private final boolean deleteFiles(File file) {
        if (file == null) {
            return true;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return true;
            }
            for (File file2 : fileArrListFiles) {
                deleteFiles(file2);
            }
        }
        return file.delete();
    }

    private final String getDefaultSaveRootPath(Context context) {
        if (TextUtils.isEmpty(defaultSaveRootPath)) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getExternalFilesDir(null);
            }
            String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
            if (absolutePath == null) {
                absolutePath = "";
            }
            defaultSaveRootPath = absolutePath;
            defaultSaveRootPath += File.separator + "taptap" + File.separator + "services" + File.separator + "update";
        }
        return defaultSaveRootPath;
    }
}
