package com.tapsdk.tapad.internal.runtime.plugin.download;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.InterErrCode;
import com.tapsdk.tapad.internal.TapADFileProvider;
import com.tapsdk.tapad.internal.observability.InterErrorUtils;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadRequest;
import com.tapsdk.tapad.internal.runtime.download.DownloadUtils;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewDownloadController {
    private static final long COMPLETED_DISMISS_DELAY_MS = 300;
    private static final int DOWNLOAD_BAR_HEIGHT_DP = 70;
    private final String apkMd5;
    private final long apkSize;
    private final int apkVerifyType;
    private final String appName;
    private final ImageView closeIcon;
    private final Context context;
    private AndroidDownloadRequest currentConfig;
    private WebViewDownloadRequest currentRequest;
    private AndroidDownloadHost downloadHost;
    private final View downloadView;
    private final TextView fileNameText;
    private final TextView fileSizeText;
    private final int instanceId;
    private final String packageName;
    private final ProgressBar progressBar;
    private final int sessionId;
    private final ImageView stateIcon;
    private final int surfaceId;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private int currentDownloadId = -1;
    private State state = State.IDLE;
    private boolean destroyed = false;

    public enum State {
        IDLE,
        DOWNLOADING,
        PAUSED,
        FAILED,
        COMPLETED
    }

    public WebViewDownloadController(Context context, ViewGroup viewGroup, String str, String str2, String str3, long j, int i, int i2, int i3, int i4) {
        this.context = context.getApplicationContext();
        this.packageName = str == null ? "" : str;
        this.appName = str2 == null ? "" : str2;
        this.apkMd5 = str3 == null ? "" : str3;
        this.apkSize = j;
        this.apkVerifyType = i;
        this.instanceId = i2;
        this.surfaceId = i3;
        this.sessionId = i4;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tapad_webview_bottom_downloading, viewGroup, false);
        this.downloadView = viewInflate;
        viewGroup.addView(viewInflate, new FrameLayout.LayoutParams(-1, -2, 80));
        viewInflate.setVisibility(8);
        viewInflate.setBackgroundColor(-1);
        viewInflate.setMinimumHeight(dp(70));
        installInsetListener(viewGroup);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.download_progress);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.download_close_icon);
        this.closeIcon = imageView;
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.download_state_icon);
        this.stateIcon = imageView2;
        this.fileNameText = (TextView) viewInflate.findViewById(R.id.download_file_name_text);
        this.fileSizeText = (TextView) viewInflate.findViewById(R.id.download_file_size_text);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m313lambda$new$0$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(view);
                }
            });
        }
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m314lambda$new$1$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(view);
                }
            });
        }
    }

    private void addDownloadCacheRoot(List<File> list, Set<String> set, File file) {
        if (file == null) {
            return;
        }
        try {
            if (set.add(file.getCanonicalPath())) {
                list.add(file);
            }
        } catch (Throwable th) {
            if (set.add(file.getAbsolutePath())) {
                list.add(file);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0035  */
    private AndroidDownloadRequest buildConfig(WebViewDownloadRequest webViewDownloadRequest) {
        long j;
        AndroidDownloadRequest.Builder builderResumable = new AndroidDownloadRequest.Builder().url(webViewDownloadRequest.url).fileName(resolveDownloadFileName(webViewDownloadRequest)).targetDirectory(DownloadUtils.getDefaultDownloadDir(this.context).getAbsolutePath()).resumable(true);
        if (webViewDownloadRequest.isApk()) {
            j = this.apkSize;
            if (j <= 0) {
                j = webViewDownloadRequest.size;
            }
        } else {
            j = webViewDownloadRequest.size;
        }
        if (j > 0) {
            builderResumable.expectedSize(j);
        }
        if (webViewDownloadRequest.isApk()) {
            if (!TextUtils.isEmpty(this.apkMd5)) {
                builderResumable.md5(this.apkMd5);
            }
            int i = this.apkVerifyType;
            if (i >= 0) {
                builderResumable.apkVerifyType(i);
            }
        }
        if (!TextUtils.isEmpty(webViewDownloadRequest.userAgent)) {
            builderResumable.header("User-Agent", webViewDownloadRequest.userAgent);
        }
        return builderResumable.build();
    }

    private void cancelActiveTaskOnly() {
        AndroidDownloadHost androidDownloadHost;
        int i = this.currentDownloadId;
        if (i > 0) {
            State state = this.state;
            if ((state == State.DOWNLOADING || state == State.PAUSED) && (androidDownloadHost = this.downloadHost) != null) {
                androidDownloadHost.cancel(i);
            }
        }
    }

    private void cancelCurrentDownload() {
        cancelActiveTaskOnly();
        this.currentRequest = null;
        this.currentConfig = null;
        this.currentDownloadId = -1;
        this.state = State.IDLE;
        View view = this.downloadView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private List<File> downloadCacheRoots() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        addDownloadCacheRoot(arrayList, hashSet, DownloadUtils.getDefaultDownloadDir(this.context));
        for (File file : DownloadUtils.getLegacyDownloadDirs(this.context)) {
            addDownloadCacheRoot(arrayList, hashSet, file);
        }
        return arrayList;
    }

    private int dp(int i) {
        return (int) ((i * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private File findCachedApkByPackage(AndroidDownloadRequest androidDownloadRequest) {
        if (!TextUtils.isEmpty(this.packageName) && androidDownloadRequest != null) {
            Iterator<File> it = downloadCacheRoots().iterator();
            while (it.hasNext()) {
                File[] fileArrListFiles = it.next().listFiles(new FilenameFilter() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda4
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file, String str) {
                        return WebViewDownloadController.lambda$findCachedApkByPackage$7(file, str);
                    }
                });
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (this.packageName.equals(readPackageNameFromApk(file)) && getDownloadHost().isCompletedFileValid(androidDownloadRequest, file)) {
                            return file;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String formatBytes(long j) {
        if (j <= 0) {
            return "";
        }
        if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j + "B";
        }
        return j < 1048576 ? String.format(Locale.CHINA, "%.1fKB", Double.valueOf(j / 1024.0d)) : String.format(Locale.CHINA, "%.2fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private synchronized AndroidDownloadHost getDownloadHost() {
        if (this.downloadHost == null) {
            this.downloadHost = AndroidDownloadHost.get(this.context);
        }
        return this.downloadHost;
    }

    private void handleApkComplete(final File file) {
        if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m309lambda$handleApkComplete$5$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(file);
            }
        })) {
            return;
        }
        handleError("package inspection executor is saturated");
    }

    private void handleCachedComplete(File file) {
        if (this.destroyed || file == null || !file.exists()) {
            startCurrentDownload();
            return;
        }
        this.state = State.IDLE;
        View view = this.downloadView;
        if (view != null) {
            view.setVisibility(8);
        }
        WebViewDownloadRequest webViewDownloadRequest = this.currentRequest;
        trackMonitorEvent(webViewDownloadRequest != null ? webViewDownloadRequest.url : "", Integer.valueOf(Constants.WebViewEventType.DOWNLOAD_COMPLETE));
        WebViewDownloadRequest webViewDownloadRequest2 = this.currentRequest;
        if (webViewDownloadRequest2 == null || !webViewDownloadRequest2.isApk()) {
            openDownloadedFile(file);
        } else {
            handleApkComplete(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleComplete(String str) {
        if (this.destroyed) {
            return;
        }
        int i = this.currentDownloadId;
        this.state = State.COMPLETED;
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        TextView textView = this.fileSizeText;
        if (textView != null) {
            textView.setText(this.context.getString(R.string.tapad_dirichlet_download_complete));
        }
        WebViewDownloadRequest webViewDownloadRequest = this.currentRequest;
        trackMonitorEvent(webViewDownloadRequest != null ? webViewDownloadRequest.url : "", Integer.valueOf(Constants.WebViewEventType.DOWNLOAD_COMPLETE));
        File file = TextUtils.isEmpty(str) ? null : new File(str);
        if (file == null || !file.exists()) {
            handleError("downloaded file missing");
            return;
        }
        scheduleCompletedUiDismiss(i);
        WebViewDownloadRequest webViewDownloadRequest2 = this.currentRequest;
        if (webViewDownloadRequest2 == null || !webViewDownloadRequest2.isApk()) {
            openDownloadedFile(file);
        } else {
            handleApkComplete(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(String str) {
        if (this.destroyed) {
            return;
        }
        this.state = State.FAILED;
        TextView textView = this.fileSizeText;
        if (textView != null) {
            textView.setText(this.context.getString(R.string.tapad_dirichlet_download_error));
        }
        setStateIconPaused();
    }

    private void handleStateAction() {
        int i;
        int i2;
        if (this.destroyed || this.currentRequest == null) {
            return;
        }
        State state = this.state;
        State state2 = State.DOWNLOADING;
        if (state == state2 && (i2 = this.currentDownloadId) > 0) {
            AndroidDownloadHost androidDownloadHost = this.downloadHost;
            if (androidDownloadHost == null) {
                return;
            }
            androidDownloadHost.pause(i2);
            this.state = State.PAUSED;
            TextView textView = this.fileSizeText;
            if (textView != null) {
                textView.setText(this.context.getString(R.string.tapad_dirichlet_download_paused));
            }
            setStateIconPaused();
            return;
        }
        if (state != State.PAUSED || (i = this.currentDownloadId) <= 0) {
            if (state == State.FAILED) {
                showDownloadingUi();
                this.currentDownloadId = getDownloadHost().start(this.currentConfig, 0, (AndroidDownloadHost.NotificationSpec) null, webViewDownloadObserver());
                return;
            }
            return;
        }
        AndroidDownloadHost androidDownloadHost2 = this.downloadHost;
        if (androidDownloadHost2 == null) {
            return;
        }
        androidDownloadHost2.resume(i);
        this.state = state2;
        setStateIconDownloading();
    }

    private void installInsetListener(ViewGroup viewGroup) {
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.f$0.m312lambda$installInsetListener$8$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(view, windowInsets);
            }
        });
        if (viewGroup.isAttachedToWindow()) {
            viewGroup.requestApplyInsets();
        } else {
            viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    view.requestApplyInsets();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    private boolean isPackageInstalled(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    static /* synthetic */ boolean lambda$findCachedApkByPackage$7(File file, String str) {
        return str != null && str.toLowerCase(Locale.US).endsWith(".apk");
    }

    private void openDownloadedFile(File file) {
        try {
            Uri uriForFile = TapADFileProvider.getUriForFile(this.context, this.context.getPackageName() + ".com.tds.ad.fileprovider", file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.addFlags(1);
            WebViewDownloadRequest webViewDownloadRequest = this.currentRequest;
            intent.setDataAndType(uriForFile, (webViewDownloadRequest == null || TextUtils.isEmpty(webViewDownloadRequest.mimeType)) ? "resource/folder" : this.currentRequest.mimeType);
            this.context.startActivity(intent);
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("source", "WebViewDownloadController");
            InterErrorUtils.trackInternalError(InterErrCode.FAIL_TO_START_ACTION_VIEW, th, map);
        }
    }

    private boolean openInstalledAppIfInstalled(String str) {
        if (!isPackageInstalled(this.packageName)) {
            return false;
        }
        trackMonitorEvent(str, null);
        try {
            Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(this.packageName);
            if (launchIntentForPackage == null) {
                return true;
            }
            launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
            this.context.startActivity(launchIntentForPackage);
            return true;
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("source", "WebViewDownloadController");
            map.put("package_name", this.packageName);
            InterErrorUtils.trackInternalError(InterErrCode.FAIL_TO_START_ACTION_VIEW, th, map);
            return true;
        }
    }

    private String readPackageNameFromApk(File file) {
        PackageInfo packageArchiveInfo;
        if (file != null) {
            try {
                if (file.isFile() && (packageArchiveInfo = this.context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) != null) {
                    return packageArchiveInfo.packageName;
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private String resolveDownloadFileName(WebViewDownloadRequest webViewDownloadRequest) {
        if (webViewDownloadRequest == null || !webViewDownloadRequest.isApk() || TextUtils.isEmpty(this.packageName) || TextUtils.isEmpty(this.apkMd5) || TextUtils.isEmpty(this.appName)) {
            return webViewDownloadRequest != null ? webViewDownloadRequest.fileName : "";
        }
        return DownloadUtils.generateFileName(this.packageName, this.apkMd5, this.appName);
    }

    private void scheduleCompletedUiDismiss(final int i) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m315lambda$scheduleCompletedUiDismiss$6$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(i);
            }
        }, COMPLETED_DISMISS_DELAY_MS);
    }

    private void setStateIconDownloading() {
        ImageView imageView = this.stateIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.tapad_webview_downloading_icon);
        }
    }

    private void setStateIconPaused() {
        ImageView imageView = this.stateIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.tapad_webview_downloading_pause_icon);
        }
    }

    private void showDownloadingUi() {
        WebViewDownloadRequest webViewDownloadRequest;
        WebViewDownloadRequest webViewDownloadRequest2;
        this.state = State.DOWNLOADING;
        View view = this.downloadView;
        if (view != null) {
            view.setVisibility(0);
            this.downloadView.bringToFront();
        }
        TextView textView = this.fileNameText;
        if (textView != null && (webViewDownloadRequest2 = this.currentRequest) != null) {
            textView.setText(webViewDownloadRequest2.fileName);
        }
        TextView textView2 = this.fileSizeText;
        if (textView2 != null && (webViewDownloadRequest = this.currentRequest) != null) {
            long j = webViewDownloadRequest.size;
            textView2.setText(j > 0 ? formatBytes(j) : "");
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        setStateIconDownloading();
    }

    private void startCurrentDownload() {
        if (this.destroyed || this.currentRequest == null || this.currentConfig == null) {
            return;
        }
        showDownloadingUi();
        trackMonitorEvent(this.currentRequest.url, null);
        int iStart = getDownloadHost().start(this.currentConfig, 0, (AndroidDownloadHost.NotificationSpec) null, webViewDownloadObserver());
        this.currentDownloadId = iStart;
        if (iStart <= 0) {
            handleError("download start failed");
        }
    }

    private void trackMonitorEvent(String str, Integer num) {
        int i;
        if (this.sessionId <= 0) {
            return;
        }
        int iIntValue = num == null ? 0 : num.intValue();
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i2 = this.instanceId;
        if (i2 > 0 && (i = this.surfaceId) > 0) {
            dirichletRuntime.triggerInteractionEvent(i2, i, 7, this.sessionId, iIntValue, str != null ? str : "");
            return;
        }
        int i3 = this.sessionId;
        if (str == null) {
            str = "";
        }
        dirichletRuntime.triggerInteractionEvent(7, i3, iIntValue, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(float f, long j, long j2) {
        if (this.destroyed || this.state != State.DOWNLOADING) {
            return;
        }
        int iMax = Math.max(0, Math.min(100, (int) (f * 100.0f)));
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(iMax);
        }
        TextView textView = this.fileSizeText;
        if (textView == null || j2 <= 0) {
            return;
        }
        textView.setText(formatBytes(j) + "/" + formatBytes(j2));
    }

    private AndroidDownloadHost.Observer webViewDownloadObserver() {
        return new AndroidDownloadHost.Observer() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController.1
            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onComplete(int i, int i2, File file) {
                if (i == WebViewDownloadController.this.currentDownloadId) {
                    WebViewDownloadController.this.handleComplete(file.getAbsolutePath());
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onError(int i, int i2, int i3, String str) {
                if (i == WebViewDownloadController.this.currentDownloadId) {
                    WebViewDownloadController.this.handleError(str);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
            public void onProgress(int i, int i2, float f, long j, long j2) {
                if (i == WebViewDownloadController.this.currentDownloadId) {
                    WebViewDownloadController.this.updateProgress(f, j, j2);
                }
            }
        };
    }

    public void applyDownloadBarInsets(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.downloadView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int iMax = Math.max(0, i);
            int iMax2 = Math.max(0, i2);
            int iMax3 = Math.max(0, i3);
            if (layoutParams2.leftMargin == iMax && layoutParams2.rightMargin == iMax2 && layoutParams2.bottomMargin == iMax3) {
                return;
            }
            layoutParams2.leftMargin = iMax;
            layoutParams2.rightMargin = iMax2;
            layoutParams2.bottomMargin = iMax3;
            this.downloadView.setLayoutParams(layoutParams2);
        }
    }

    public void destroy() {
        cancelActiveTaskOnly();
        this.destroyed = true;
    }

    public File findReusableCompletedFile(WebViewDownloadRequest webViewDownloadRequest) {
        if (webViewDownloadRequest == null) {
            return null;
        }
        return findReusableCompletedFile(webViewDownloadRequest, buildConfig(webViewDownloadRequest));
    }

    public void handleDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.destroyed || TextUtils.isEmpty(str)) {
            return;
        }
        cancelActiveTaskOnly();
        this.currentRequest = new WebViewDownloadRequest(str, str2, str3, str4, j);
        this.currentConfig = null;
        this.currentDownloadId = -1;
        this.state = State.IDLE;
        View view = this.downloadView;
        if (view != null) {
            view.setVisibility(8);
        }
        final WebViewDownloadRequest webViewDownloadRequest = this.currentRequest;
        if ((webViewDownloadRequest.isApk() && openInstalledAppIfInstalled(webViewDownloadRequest.url)) || AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m311lambda$handleDownloadStart$3$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(webViewDownloadRequest);
            }
        })) {
            return;
        }
        handleError("download preparation executor is saturated");
    }

    /* JADX INFO: renamed from: hideCompletedDownloadUi, reason: merged with bridge method [inline-methods] */
    public void m315lambda$scheduleCompletedUiDismiss$6$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(int i) {
        if (!this.destroyed && this.state == State.COMPLETED && this.currentDownloadId == i) {
            this.state = State.IDLE;
            this.currentDownloadId = -1;
            View view = this.downloadView;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$handleApkComplete$4$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m308lambda$handleApkComplete$4$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(String str, File file) {
        if (this.destroyed) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.packageName;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("filePath", file.getAbsolutePath()).put(BillingClientConstants.PACKAGE_NAME, str);
            WebViewDownloadRequest webViewDownloadRequest = this.currentRequest;
            DirichletRuntime.getInstance().triggerInstallEvent(4, 0, 0, this.instanceId, this.surfaceId, jSONObjectPut.put("actionUrl", webViewDownloadRequest != null ? webViewDownloadRequest.url : "").toString());
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: renamed from: lambda$handleApkComplete$5$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m309lambda$handleApkComplete$5$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(final File file) {
        final String packageNameFromApk = readPackageNameFromApk(file);
        AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m308lambda$handleApkComplete$4$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(packageNameFromApk, file);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleDownloadStart$2$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m310lambda$handleDownloadStart$2$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(WebViewDownloadRequest webViewDownloadRequest, AndroidDownloadRequest androidDownloadRequest, File file) {
        if (this.destroyed || this.currentRequest != webViewDownloadRequest) {
            return;
        }
        this.currentConfig = androidDownloadRequest;
        if (file == null || !file.exists()) {
            startCurrentDownload();
        } else {
            trackMonitorEvent(webViewDownloadRequest.url, null);
            handleCachedComplete(file);
        }
    }

    /* JADX INFO: renamed from: lambda$handleDownloadStart$3$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m311lambda$handleDownloadStart$3$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(final WebViewDownloadRequest webViewDownloadRequest) {
        final AndroidDownloadRequest androidDownloadRequestBuildConfig = buildConfig(webViewDownloadRequest);
        final File fileFindReusableCompletedFile = findReusableCompletedFile(webViewDownloadRequest, androidDownloadRequestBuildConfig);
        AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m310lambda$handleDownloadStart$2$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(webViewDownloadRequest, androidDownloadRequestBuildConfig, fileFindReusableCompletedFile);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$installInsetListener$8$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ WindowInsets m312lambda$installInsetListener$8$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(View view, WindowInsets windowInsets) {
        applyDownloadBarInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m313lambda$new$0$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(View view) {
        cancelCurrentDownload();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-runtime-plugin-download-WebViewDownloadController, reason: not valid java name */
    /* synthetic */ void m314lambda$new$1$comtapsdktapadinternalruntimeplugindownloadWebViewDownloadController(View view) {
        handleStateAction();
    }

    private File findReusableCompletedFile(WebViewDownloadRequest webViewDownloadRequest, AndroidDownloadRequest androidDownloadRequest) {
        if (webViewDownloadRequest == null) {
            return null;
        }
        File fileFindCompletedFile = getDownloadHost().findCompletedFile(androidDownloadRequest);
        if (fileFindCompletedFile != null) {
            return fileFindCompletedFile;
        }
        if (webViewDownloadRequest.isApk()) {
            return findCachedApkByPackage(androidDownloadRequest);
        }
        return null;
    }
}
