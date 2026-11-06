package com.taptap.sdk.update.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.update.TapUpdateApiCallback;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import com.taptap.sdk.update.bean.UIInformation;
import com.taptap.sdk.update.bean.UpdateDownloadInfo;
import com.taptap.sdk.update.bean.UpdateFuncLink;
import com.taptap.sdk.update.bean.UpdateResult;
import com.taptap.sdk.update.constants.LoggerConst;
import com.taptap.sdk.update.download.TapUpdateDownloadListener;
import com.taptap.sdk.update.download.TapUpdateDownloadManager;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.exception.ServerCanceledException;
import com.taptap.sdk.update.extension.SystemExtKt;
import com.taptap.sdk.update.internal.TapUpdateApi;
import com.taptap.sdk.update.internal.TapUpdateInternal;
import com.taptap.sdk.update.internal.UpdateTracker;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: TapUpdateDialogManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J2\u0010#\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u00192\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010(\u001a\u00020\u0019J \u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001dH\u0002J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\"\u00102\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00103\u001a\u00020\u001dH\u0002J\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u000206J\u0016\u00107\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateDialogManager;", "", "()V", "forceUpdateInfo", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "getForceUpdateInfo", "()Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "setForceUpdateInfo", "(Lcom/taptap/sdk/update/bean/ForceUpdateResult;)V", "installConfirmDialog", "Lcom/taptap/sdk/update/dialog/TapUpdateInstallConfirmDialog;", "loadingDialog", "Lcom/taptap/sdk/update/dialog/TapUpdateLoadingDialog;", "retryCount", "", "updateDialog", "Lcom/taptap/sdk/update/dialog/TapUpdateDialog;", "updateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", "getUpdateDialog", d.R, "Landroid/content/Context;", "getWebInstallSpannableString", "Landroid/text/SpannableString;", TextViewManager.NAME, "", TrackAction.START, "end", "fromInstall", "", "hideLoadingDialog", "", "hideUpdateDialog", "installSuccess", "showConfirmDownloadDialog", "showDownloadDialog", "appInfo", "links", "", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "downloadUrl", "showErrorAndRetry", "errorTips", "needRetry", "showInstallDialog", "file", "Ljava/io/File;", "showLoadingDialog", "showOpenDialog", "showUpdateDialog", "startInstallAPK", "isManualClick", "startUpdateGame", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "updateInTapApp", "objectType", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateDialogManager {
    public static final TapUpdateDialogManager INSTANCE = new TapUpdateDialogManager();
    private static ForceUpdateResult forceUpdateInfo;
    private static TapUpdateInstallConfirmDialog installConfirmDialog;
    private static TapUpdateLoadingDialog loadingDialog;
    private static int retryCount;
    private static TapUpdateDialog updateDialog;
    private static UpdateResult updateInfo;

    private TapUpdateDialogManager() {
    }

    public final ForceUpdateResult getForceUpdateInfo() {
        return forceUpdateInfo;
    }

    public final void setForceUpdateInfo(ForceUpdateResult forceUpdateResult) {
        forceUpdateInfo = forceUpdateResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapUpdateDialog getUpdateDialog(Context context) {
        if (updateDialog == null) {
            TapUpdateDialog tapUpdateDialog = new TapUpdateDialog(context);
            updateDialog = tapUpdateDialog;
            tapUpdateDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TapUpdateDialogManager.getUpdateDialog$lambda$0(dialogInterface);
                }
            });
            TapUpdateDialog tapUpdateDialog2 = updateDialog;
            if (tapUpdateDialog2 != null) {
                tapUpdateDialog2.setUpdateCancelListener(new TapUpdateDialog.IUpdateCancelListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager.getUpdateDialog.2

                    /* JADX INFO: renamed from: com.taptap.sdk.update.dialog.TapUpdateDialogManager$getUpdateDialog$2$WhenMappings */
                    /* JADX INFO: compiled from: TapUpdateDialogManager.kt */
                    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[TapUpdateDialogState.values().length];
                            try {
                                iArr[TapUpdateDialogState.CONFIRM.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[TapUpdateDialogState.DOWNLOAD.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[TapUpdateDialogState.INSTALL.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            try {
                                iArr[TapUpdateDialogState.UPDATE.ordinal()] = 4;
                            } catch (NoSuchFieldError e4) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // com.taptap.sdk.update.dialog.TapUpdateDialog.IUpdateCancelListener
                    public void onUpdateCancel(TapUpdateDialogState state, boolean fromCloseButton) throws JSONException {
                        switch (state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                            case 1:
                                UpdateTracker.INSTANCE.trackUpdateCancelButtonClick();
                                break;
                            case 2:
                                UpdateTracker.INSTANCE.trackUpdateCloseButtonClick();
                                break;
                            case 3:
                                UpdateTracker.INSTANCE.trackInstallCloseButtonClick();
                                break;
                            case 4:
                                UpdateTracker.INSTANCE.trackToTapUpdateCloseButtonClick();
                                break;
                        }
                        TapUpdateDownloadManager.INSTANCE.cancelDownload();
                        TapUpdateInternal.INSTANCE.notifyUpdateCancel();
                        TapUpdateDialogManager.INSTANCE.hideUpdateDialog();
                        UpdateTracker.INSTANCE.trackUpdateGameCancel();
                    }
                });
            }
        }
        TapUpdateDialog tapUpdateDialog3 = updateDialog;
        return tapUpdateDialog3 == null ? new TapUpdateDialog(context) : tapUpdateDialog3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUpdateDialog$lambda$0(DialogInterface it) {
        updateDialog = null;
        updateInfo = null;
        retryCount = 0;
    }

    public final void startUpdateGame(Activity activity) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        hideUpdateDialog();
        showLoadingDialog(activity);
        UpdateTracker.INSTANCE.updateSessionId();
        UpdateTracker.INSTANCE.trackUpdateGameStart();
        String packageName = activity.getPackageName();
        int versionCode = SysExtKt.getTapVersionCode();
        TapUpdateApi tapUpdateApi = TapUpdateApi.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        tapUpdateApi.requestUpdateInfo(packageName, versionCode, new C03611(activity));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.dialog.TapUpdateDialogManager$startUpdateGame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapUpdateDialogManager.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/taptap/sdk/update/dialog/TapUpdateDialogManager$startUpdateGame$1", "Lcom/taptap/sdk/update/TapUpdateApiCallback;", "onError", "", "throwable", "", "onSuccess", "updateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class C03611 implements TapUpdateApiCallback {
        final /* synthetic */ Activity $activity;

        C03611(Activity $activity) {
            this.$activity = $activity;
        }

        @Override // com.taptap.sdk.update.TapUpdateApiCallback
        public void onSuccess(UpdateResult updateInfo) throws JSONException {
            TapLoggerKt.logInfo("requestUpdateInfo success: result=" + updateInfo);
            TapUpdateDialogManager.INSTANCE.hideLoadingDialog();
            if (!(updateInfo != null && updateInfo.isDataValid())) {
                TapUpdateDialog updateDialog = TapUpdateDialogManager.INSTANCE.getUpdateDialog(this.$activity);
                final Activity activity = this.$activity;
                updateDialog.onDownloadReady(false, new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$startUpdateGame$1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws JSONException {
                        TapUpdateDialogManager.C03611.onSuccess$lambda$0(activity, view);
                    }
                });
                TapUpdateDialogManager.INSTANCE.showUpdateDialog();
                return;
            }
            TapUpdateDialogManager tapUpdateDialogManager = TapUpdateDialogManager.INSTANCE;
            TapUpdateDialogManager.updateInfo = updateInfo;
            UpdateTracker.INSTANCE.setGameId(String.valueOf(updateInfo.getAppId()));
            TapUpdateDialogManager.INSTANCE.showConfirmDownloadDialog(this.$activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$0(Activity activity, View it) throws JSONException {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            UpdateTracker.INSTANCE.trackRequestFailedPositiveButtonClick();
            TapUpdateDialogManager.INSTANCE.startUpdateGame(activity);
        }

        @Override // com.taptap.sdk.update.TapUpdateApiCallback
        public void onError(Throwable throwable) throws JSONException {
            TapLoggerKt.logInfo("requestUpdateInfo failed: cause=" + throwable);
            UpdateTracker.INSTANCE.trackUpdateGameFail(-1, String.valueOf(throwable));
            TapUpdateDialogManager.INSTANCE.hideLoadingDialog();
            TapUpdateDialog updateDialog = TapUpdateDialogManager.INSTANCE.getUpdateDialog(this.$activity);
            final Activity activity = this.$activity;
            updateDialog.onDownloadReady(false, new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$startUpdateGame$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    TapUpdateDialogManager.C03611.onError$lambda$1(activity, view);
                }
            });
            TapUpdateDialogManager.INSTANCE.showUpdateDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onError$lambda$1(Activity activity, View it) throws JSONException {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            UpdateTracker.INSTANCE.trackRequestFailedPositiveButtonClick();
            TapUpdateDialogManager.INSTANCE.startUpdateGame(activity);
        }
    }

    private final void showLoadingDialog(Context context) {
        Unit unit;
        TapUpdateLoadingDialog tapUpdateLoadingDialog = loadingDialog;
        if (tapUpdateLoadingDialog != null) {
            tapUpdateLoadingDialog.show();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            TapUpdateLoadingDialog $this$showLoadingDialog_u24lambda_u242_u24lambda_u241 = new TapUpdateLoadingDialog(context);
            $this$showLoadingDialog_u24lambda_u242_u24lambda_u241.show();
            loadingDialog = $this$showLoadingDialog_u24lambda_u242_u24lambda_u241;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingDialog() {
        TapUpdateLoadingDialog tapUpdateLoadingDialog;
        TapUpdateLoadingDialog tapUpdateLoadingDialog2 = loadingDialog;
        if ((tapUpdateLoadingDialog2 != null && tapUpdateLoadingDialog2.isShowing()) && (tapUpdateLoadingDialog = loadingDialog) != null) {
            tapUpdateLoadingDialog.dismiss();
        }
        loadingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUpdateDialog() {
        TapUpdateDialog tapUpdateDialog;
        hideLoadingDialog();
        TapUpdateDialog tapUpdateDialog2 = updateDialog;
        if ((tapUpdateDialog2 != null && tapUpdateDialog2.isShowing()) || (tapUpdateDialog = updateDialog) == null) {
            return;
        }
        tapUpdateDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideUpdateDialog() {
        TapUpdateDialog tapUpdateDialog;
        TapUpdateDialog tapUpdateDialog2 = updateDialog;
        if ((tapUpdateDialog2 != null && tapUpdateDialog2.isShowing()) && (tapUpdateDialog = updateDialog) != null) {
            tapUpdateDialog.dismiss();
        }
        updateDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConfirmDownloadDialog(final Context context) throws JSONException {
        String urlTpl;
        if (SysExtKt.isTapInstalled()) {
            updateInTapApp(context, LoggerConst.OBJECT_TYPE_UPDATE);
            return;
        }
        final UpdateResult $this$showConfirmDownloadDialog_u24lambda_u244 = updateInfo;
        if ($this$showConfirmDownloadDialog_u24lambda_u244 != null) {
            if ($this$showConfirmDownloadDialog_u24lambda_u244.getNotify()) {
                INSTANCE.getUpdateDialog(context).onDownloadReady(true, new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws JSONException {
                        TapUpdateDialogManager.showConfirmDownloadDialog$lambda$4$lambda$3(context, $this$showConfirmDownloadDialog_u24lambda_u244, view);
                    }
                });
            } else {
                TapUpdateDialogManager tapUpdateDialogManager = INSTANCE;
                String appInfo = $this$showConfirmDownloadDialog_u24lambda_u244.getAppInfo();
                List<UpdateFuncLink> links = $this$showConfirmDownloadDialog_u24lambda_u244.getLinks();
                UpdateDownloadInfo download = $this$showConfirmDownloadDialog_u24lambda_u244.getDownload();
                if (download == null || (urlTpl = download.getUrlTpl()) == null) {
                    urlTpl = "";
                }
                tapUpdateDialogManager.showDownloadDialog(context, appInfo, links, urlTpl);
            }
        }
        showUpdateDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDownloadDialog$lambda$4$lambda$3(Context context, UpdateResult this_apply, View it) throws JSONException {
        String urlTpl;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        UpdateTracker.INSTANCE.trackUpdateConfirmButtonClick();
        TapUpdateDialogManager tapUpdateDialogManager = INSTANCE;
        String appInfo = this_apply.getAppInfo();
        List<UpdateFuncLink> links = this_apply.getLinks();
        UpdateDownloadInfo download = this_apply.getDownload();
        if (download == null || (urlTpl = download.getUrlTpl()) == null) {
            urlTpl = "";
        }
        tapUpdateDialogManager.showDownloadDialog(context, appInfo, links, urlTpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showDownloadDialog$default(TapUpdateDialogManager tapUpdateDialogManager, Context context, String str, List list, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            str2 = "";
        }
        tapUpdateDialogManager.showDownloadDialog(context, str, list, str2);
    }

    public final void showDownloadDialog(final Context context, String appInfo, List<UpdateFuncLink> links, String downloadUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        if (!(context instanceof Activity) || ((Activity) context).isDestroyed() || ((Activity) context).isFinishing()) {
            return;
        }
        try {
            final TapUpdateDialog dialog = getUpdateDialog(context);
            dialog.updateUIInformation(UIInformation.INSTANCE.newBuilder().setUpdateTitle("更新游戏，需安装 TapTap 客户端").setAppInfo(appInfo).setLinkList(links).build());
            dialog.showDownloadPage();
            dialog.showCloseButton(false);
            dialog.updateDownloadContentTitle("正在下载 TapTap");
            dialog.showDownloadErrorTips(null, false, null, null);
            dialog.setMaxProgress(100);
            dialog.updateSpeed("0 B/s");
            if (!dialog.isShowing()) {
                dialog.show();
            }
            retryCount = 0;
            UpdateTracker.INSTANCE.trackDownloadDialogVisible();
            TapUpdateDownloadManager.INSTANCE.clearCache(context);
            if (!URLUtil.isNetworkUrl(downloadUrl)) {
                UpdateTracker.INSTANCE.trackDownloadFailed(-20, "download url is not valid :" + downloadUrl);
                showErrorAndRetry("文件下载链接异常,请通过浏览器链接重试", context, false);
            } else {
                TapUpdateDownloadManager.INSTANCE.download(context, downloadUrl, null, new TapUpdateDownloadListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager.showDownloadDialog.1
                    @Override // com.taptap.sdk.update.download.TapUpdateDownloadListener
                    public void onDownloadStart(long fileSize) throws JSONException {
                        if (((Activity) context).isDestroyed() || ((Activity) context).isFinishing()) {
                            return;
                        }
                        TapLoggerKt.logInfo("download start");
                        TapUpdateDialog updateDialog2 = TapUpdateDialogManager.INSTANCE.getUpdateDialog(context);
                        updateDialog2.updateDownloadContentTitle("正在下载 TapTap (大小：" + Util.humanReadableBytes(fileSize, true) + (char) 65289);
                        updateDialog2.showDownloadErrorTips(null, false, null, null);
                        updateDialog2.hideDownloadErrorTips();
                        updateDialog2.updateSpeed("0 B/s");
                        UpdateTracker.INSTANCE.trackDownloadStart();
                    }

                    @Override // com.taptap.sdk.update.download.TapUpdateDownloadListener
                    public void onDownloadProgress(long currentOffset, long fileTotalSize, long speedBytes, int progress, String speed) throws JSONException {
                        if (!((Activity) context).isDestroyed() && !((Activity) context).isFinishing()) {
                            TapUpdateDialog dialog2 = TapUpdateDialogManager.INSTANCE.getUpdateDialog(context);
                            dialog2.showDownloadErrorTips(null, false, null, null);
                            dialog2.hideDownloadErrorTips();
                            dialog2.updateProgress(progress);
                            dialog2.updateSpeed(speed);
                            UpdateTracker.INSTANCE.trackDownloadingSpeed(String.valueOf(fileTotalSize), String.valueOf(currentOffset), String.valueOf(speedBytes));
                        }
                    }

                    @Override // com.taptap.sdk.update.download.TapUpdateDownloadListener
                    public void onDownloadSuccess(File file) throws JSONException {
                        if (((Activity) context).isDestroyed() || ((Activity) context).isFinishing()) {
                            return;
                        }
                        int errorCode = SysExtKt.checkApkFile(context, file);
                        TapLoggerKt.logInfo("check apk file result = " + errorCode);
                        if (errorCode < 0) {
                            String errorLog = errorCode < -1 ? "package info is not valid" : "not a apk file";
                            UpdateTracker.INSTANCE.trackDownloadFailed(-50, errorLog);
                            TapUpdateDownloadManager.INSTANCE.clearCache(context);
                            TapUpdateDialogManager.INSTANCE.showErrorAndRetry("文件下载异常，请重试", context, true);
                            return;
                        }
                        UpdateTracker.INSTANCE.trackDownloadComplete();
                        TapUpdateDialogManager.INSTANCE.showInstallDialog(context, file);
                    }

                    @Override // com.taptap.sdk.update.download.TapUpdateDownloadListener
                    public void onDownloadFailed(EndCause cause, Exception e) throws JSONException {
                        if (((Activity) context).isDestroyed() || ((Activity) context).isFinishing() || cause == EndCause.CANCELED) {
                            return;
                        }
                        dialog.updateSpeed("0 B/s");
                        String errorTip = "网络异常，请重试";
                        String errorLog = "error : " + cause;
                        if (e != null) {
                            errorLog = e.toString();
                        }
                        int errorCode = -30;
                        if (cause == EndCause.PRE_ALLOCATE_FAILED) {
                            errorLog = "设备存储空间不足，无法继续下载";
                            errorTip = "设备存储空间不足，无法继续下载";
                            errorCode = -40;
                        } else if (cause == EndCause.FILE_BUSY) {
                            errorLog = "文件被占用";
                        } else if (e instanceof ServerCanceledException) {
                            errorCode = -15;
                        } else if ((e instanceof UnknownHostException) || (e instanceof SocketException)) {
                            errorCode = -10;
                            if (NetworkUtil.isNetworkAvailable(context)) {
                                errorCode = -13;
                            }
                        } else if (e instanceof SSLException) {
                            errorCode = -14;
                        } else if (e instanceof IOException) {
                            errorCode = -12;
                            if (e instanceof SocketTimeoutException) {
                                errorCode = -11;
                            }
                        }
                        TapLoggerKt.logInfo("errorCode = " + errorCode + " , errorLog = " + errorLog);
                        UpdateTracker.INSTANCE.trackDownloadFailed(errorCode, errorLog);
                        TapUpdateDialogManager.INSTANCE.showErrorAndRetry(errorTip, context, true);
                    }
                });
            }
        } catch (Exception e) {
            TapLoggerKt.logError$default("showDownloadDialog error: " + e.getMessage(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorAndRetry(String errorTips, Context context, boolean needRetry) {
        SpannableString webInstallSS = null;
        if (retryCount >= 1 || !needRetry) {
            getUpdateDialog(context).showCloseButton(true);
        }
        if (retryCount >= 2 || !needRetry) {
            webInstallSS = getWebInstallSpannableString("或点击此 链接 前往浏览器安装", 4, 8, context, false);
        }
        int i = retryCount;
        if (i > 2 && i % 3 == 0) {
            TapUpdateDownloadManager.INSTANCE.clearCache(context);
        }
        getUpdateDialog(context).showDownloadErrorTips(errorTips, needRetry, webInstallSS, new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateDialogManager.showErrorAndRetry$lambda$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorAndRetry$lambda$5(View it) throws JSONException {
        UpdateTracker.INSTANCE.trackDownloadRetryButtonClick();
        retryCount++;
        TapUpdateDownloadManager.INSTANCE.restartTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInstallDialog(final Context context, final File file) throws JSONException {
        getUpdateDialog(context).showCloseButton(true);
        getUpdateDialog(context).showFuncViewWithTips("安装 TapTap", getWebInstallSpannableString("安装失败？可点击此 链接 前往浏览器安装", 9, 13, context, true), new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateDialogManager.showInstallDialog$lambda$6(file, context, view);
            }
        });
        getUpdateDialog(context).setDialogState(TapUpdateDialogState.INSTALL);
        UpdateTracker.INSTANCE.trackInstallDialogVisible();
        startInstallAPK(context, file, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallDialog$lambda$6(File $file, Context context, View it) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "$context");
        if ($file != null) {
            INSTANCE.startInstallAPK(context, $file, true);
        }
        UpdateTracker.INSTANCE.trackInstallConfirmButtonClick();
    }

    private final void startInstallAPK(Context context, File file, boolean isManualClick) {
        if (file == null) {
            return;
        }
        TapUpdateDownloadManager.INSTANCE.installAPK(context, file, isManualClick);
        SystemExtKt.runOnMainWithDelay(300L, new C03601(context, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.dialog.TapUpdateDialogManager$startInstallAPK$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapUpdateDialogManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.dialog.TapUpdateDialogManager$startInstallAPK$1", f = "TapUpdateDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03601 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03601(Context context, Continuation<? super C03601> continuation) {
            super(1, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03601(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03601) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (TapUpdateDialogManager.installConfirmDialog == null) {
                        TapUpdateDialogManager tapUpdateDialogManager = TapUpdateDialogManager.INSTANCE;
                        TapUpdateDialogManager.installConfirmDialog = new TapUpdateInstallConfirmDialog(this.$context);
                    }
                    TapUpdateInstallConfirmDialog tapUpdateInstallConfirmDialog = TapUpdateDialogManager.installConfirmDialog;
                    if (tapUpdateInstallConfirmDialog != null) {
                        tapUpdateInstallConfirmDialog.switchState(TapUpdateInstallConfirmDialog.TapUpdateConfirmDialogType.INSTALL_CONFIRM);
                    }
                    TapUpdateInstallConfirmDialog tapUpdateInstallConfirmDialog2 = TapUpdateDialogManager.installConfirmDialog;
                    if (tapUpdateInstallConfirmDialog2 != null) {
                        tapUpdateInstallConfirmDialog2.show();
                    }
                    UpdateTracker.INSTANCE.trackInstallConfirmDialogVisible();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void updateInTapApp(Context context, String objectType) throws JSONException {
        Object objM534constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        try {
            Result.Companion companion = Result.INSTANCE;
            TapUpdateDialogManager tapUpdateDialogManager = this;
            UpdateTracker.INSTANCE.trackOpenTapClient(objectType);
            UpdateResult updateResult = updateInfo;
            Uri uri = null;
            if (updateResult != null) {
                uri = Uri.parse(updateResult != null ? updateResult.getUpdateUriTpl() : null);
            } else {
                ForceUpdateResult forceUpdateResult = forceUpdateInfo;
                if (forceUpdateResult != null) {
                    uri = Uri.parse(forceUpdateResult != null ? forceUpdateResult.getUpdateUri() : null);
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            UpdateTracker.INSTANCE.trackUpdateGameSuccess();
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m537exceptionOrNullimpl(objM534constructorimpl) != null) {
            SysExtKt.showToast("打开失败，请重试");
            UpdateTracker.INSTANCE.trackUpdateGameFail(-1, "open taptap client failed");
        }
    }

    private final SpannableString getWebInstallSpannableString(String text, int start, int end, final Context context, final boolean fromInstall) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ClickableSpan() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager.getWebInstallSpannableString.1
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.setColor(Color.parseColor("#00D9C5"));
                ds.setUnderlineText(false);
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) throws JSONException {
                Uri uri;
                Intrinsics.checkNotNullParameter(widget, "widget");
                try {
                    if (TapUpdateDialogManager.updateInfo != null) {
                        UpdateResult updateResult = TapUpdateDialogManager.updateInfo;
                        uri = Uri.parse(updateResult != null ? updateResult.getUpdateUrlTpl() : null);
                    } else if (TapUpdateDialogManager.INSTANCE.getForceUpdateInfo() != null) {
                        ForceUpdateResult forceUpdateInfo2 = TapUpdateDialogManager.INSTANCE.getForceUpdateInfo();
                        uri = Uri.parse(forceUpdateInfo2 != null ? forceUpdateInfo2.getUpdateUrl() : null);
                    } else {
                        uri = null;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    context.startActivity(intent);
                } catch (Exception e) {
                    TapLoggerKt.logError$default(e.getMessage(), null, 2, null);
                }
                if (fromInstall) {
                    UpdateTracker.INSTANCE.trackInstallLinkButtonClick();
                } else {
                    UpdateTracker.INSTANCE.trackDownloadLinkButtonClick();
                }
            }
        }, start, end, 33);
        return ss;
    }

    public final void installSuccess(Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        TapUpdateInstallConfirmDialog tapUpdateInstallConfirmDialog = installConfirmDialog;
        if (tapUpdateInstallConfirmDialog != null) {
            tapUpdateInstallConfirmDialog.dismiss();
        }
        UpdateTracker.INSTANCE.trackInstallComplete();
        showOpenDialog(context);
        TapUpdateDownloadManager.INSTANCE.clearCache(context);
    }

    private final void showOpenDialog(final Context context) throws JSONException {
        String appInfo;
        List<UpdateFuncLink> links;
        UpdateResult updateResult = updateInfo;
        if (updateResult == null || (appInfo = updateResult.getAppInfo()) == null) {
            ForceUpdateResult forceUpdateResult = forceUpdateInfo;
            appInfo = forceUpdateResult != null ? forceUpdateResult.getAppInfo() : null;
        }
        UpdateResult updateResult2 = updateInfo;
        if (updateResult2 == null || (links = updateResult2.getLinks()) == null) {
            ForceUpdateResult forceUpdateResult2 = forceUpdateInfo;
            links = forceUpdateResult2 != null ? forceUpdateResult2.getLinks() : null;
        }
        TapUpdateDialog $this$showOpenDialog_u24lambda_u2412 = getUpdateDialog(context);
        $this$showOpenDialog_u24lambda_u2412.updateUIInformation(UIInformation.INSTANCE.newBuilder().setUpdateTitle("更新游戏，需使用 TapTap 客户端").setAppInfo(appInfo).setLinkList(links).build());
        TapUpdateDialog.showFuncViewWithTips$default($this$showOpenDialog_u24lambda_u2412, "打开 TapTap 去更新", null, new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialogManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateDialogManager.showOpenDialog$lambda$12$lambda$11(context, view);
            }
        }, 2, null);
        $this$showOpenDialog_u24lambda_u2412.setDialogState(TapUpdateDialogState.UPDATE);
        UpdateTracker.INSTANCE.trackUpdateDialogVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOpenDialog$lambda$12$lambda$11(Context context, View it) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "$context");
        INSTANCE.updateInTapApp(context, LoggerConst.OBJECT_TYPE_UPDATE_GO_TAP);
        UpdateTracker.INSTANCE.trackToTapUpdateButtonClick();
    }
}
