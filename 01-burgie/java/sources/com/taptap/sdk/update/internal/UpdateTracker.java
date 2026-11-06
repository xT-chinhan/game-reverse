package com.taptap.sdk.update.internal;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import com.taptap.sdk.update.constants.LoggerConst;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdateTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b!\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\u0004J(\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040 H\u0002J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0019J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020\u0019J\u0006\u0010+\u001a\u00020\u0019J\u001e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J/\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00042\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b4\u00105J\u0006\u00106\u001a\u00020\u0019J\u000e\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020\u0019J\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u000209J\u0006\u0010?\u001a\u00020\u0019J\u000e\u0010@\u001a\u00020\u00192\u0006\u0010>\u001a\u000209J\u0006\u0010A\u001a\u00020\u0019J\u0006\u0010B\u001a\u00020\u0019J\u0006\u0010C\u001a\u00020\u0019J\u000e\u0010D\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0019J\u0006\u0010G\u001a\u00020\u0019J\u0015\u0010H\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0004H\u0000¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0004H\u0000¢\u0006\u0002\bKJ\u0006\u0010L\u001a\u00020\u0019J\u0006\u0010M\u001a\u00020\u0019J\u0006\u0010N\u001a\u00020\u0019J\u0006\u0010O\u001a\u00020\u0019J\u0006\u0010P\u001a\u00020\u0019J\u0006\u0010Q\u001a\u00020\u0019J\u0006\u0010R\u001a\u00020\u0019J\u0006\u0010S\u001a\u00020\u0019J\u0016\u0010T\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0004J\u0006\u0010V\u001a\u00020\u0019J\u0006\u0010W\u001a\u00020\u0019J\u000e\u0010X\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010Y\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/taptap/sdk/update/internal/UpdateTracker;", "", "()V", "currentChainId", "", "currentSessionId", "gameId", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "loggerHelper", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getLoggerHelper", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "loggerHelper$delegate", "Lkotlin/Lazy;", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "speedCount", "", "clearChainId", "", "createSessionId", "getChainId", "getSessionId", "reportBizLog", "action", "paramMap", "", "trackClick", "block", "objectType", "trackDownloadComplete", "trackDownloadDialogVisible", "trackDownloadFailed", PluginConstants.KEY_ERROR_CODE, "cause", "trackDownloadLinkButtonClick", "trackDownloadRetryButtonClick", "trackDownloadStart", "trackDownloadingSpeed", "apkSize", "currentSize", "speed", "trackFail", "funcName", MediationConstant.KEY_ERROR_CODE, "errorMessage", "trackFail$tap_update_release", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "trackInitialize", "trackInstall", "manualClick", "", "trackInstallCloseButtonClick", "trackInstallComplete", "trackInstallConfirmButtonClick", "trackInstallConfirmCancelButtonClick", "fromConfirm", "trackInstallConfirmDialogVisible", "trackInstallConfirmPositiveButtonClick", "trackInstallDialogVisible", "trackInstallLinkButtonClick", "trackNotInstallDialogVisible", "trackOpenTapClient", "trackRequestFailDialogVisible", "trackRequestFailNegativeButtonClick", "trackRequestFailedPositiveButtonClick", "trackStart", "trackStart$tap_update_release", "trackSuccess", "trackSuccess$tap_update_release", "trackToTapUpdateButtonClick", "trackToTapUpdateCloseButtonClick", "trackUpdateCancelButtonClick", "trackUpdateCloseButtonClick", "trackUpdateConfirmButtonClick", "trackUpdateConfirmDialogVisible", "trackUpdateDialogVisible", "trackUpdateGameCancel", "trackUpdateGameFail", MediationConstant.KEY_ERROR_MSG, "trackUpdateGameStart", "trackUpdateGameSuccess", "trackView", "updateSessionId", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateTracker {
    public static final UpdateTracker INSTANCE = new UpdateTracker();
    private static String currentChainId;
    private static volatile String currentSessionId;
    private static volatile String gameId;

    /* JADX INFO: renamed from: loggerHelper$delegate, reason: from kotlin metadata */
    private static final Lazy loggerHelper;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;
    private static int speedCount;

    private UpdateTracker() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.update.internal.UpdateTracker$special$$inlined$inject$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OpenLogService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(OpenLogService.class);
                if (service != null) {
                    return (OpenLogService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.common.services.OpenLogService");
            }
        });
        loggerHelper = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.update.internal.UpdateTracker$loggerHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return UpdateTracker.INSTANCE.getOpenLogService().obtainOpenlog(SdkModules.UPDATE, "4.10.9");
            }
        });
        currentSessionId = "";
        currentChainId = "";
        gameId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenLogService getOpenLogService() {
        return (OpenLogService) openLogService.getValue();
    }

    private final ITapOpenlog getLoggerHelper() {
        return (ITapOpenlog) loggerHelper.getValue();
    }

    public final String getGameId() {
        return gameId;
    }

    public final void setGameId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        gameId = str;
    }

    private final String createSessionId() {
        currentSessionId = StringExtKt.generateSessionId();
        return currentSessionId;
    }

    private final String getChainId() {
        if (TextUtils.isEmpty(currentChainId)) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            currentChainId = string;
        }
        return currentChainId;
    }

    public final void clearChainId() {
        currentChainId = "";
    }

    public final String getSessionId() {
        return currentSessionId.length() == 0 ? createSessionId() : currentSessionId;
    }

    public final void updateSessionId() {
        currentSessionId = StringExtKt.generateSessionId();
    }

    public final void trackUpdateCancelButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_CONFIRM);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "tap_update_cancel_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackUpdateCloseButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_DOWNLOAD);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.OBJECT_TYPE_UPDATE_CLOSE), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackInstallCloseButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_INSTALL);
        extraJson.put("update_id", getSessionId());
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.OBJECT_TYPE_UPDATE_CLOSE), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackToTapUpdateCloseButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_UPDATE);
        extraJson.put("update_id", getSessionId());
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.OBJECT_TYPE_UPDATE_CLOSE), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackOpenTapClient(String objectType) throws JSONException {
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        reportBizLog(LoggerConst.ACTION_OPEN_TAP_CLIENT, MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, objectType)));
    }

    public final void trackUpdateConfirmButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_CONFIRM);
        extraJson.put("update_id", getSessionId());
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "tap_update_confirm_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackDownloadDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_DOWNLOAD)));
    }

    public final void trackDownloadFailed(int code, String cause) throws JSONException {
        Intrinsics.checkNotNullParameter(cause, "cause");
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        argsJson.put("failed_code", code);
        argsJson.put("failed_reason", cause);
        reportBizLog(LoggerConst.ACTION_DOWNLOAD_FAILED, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString())));
    }

    public final void trackInstallLinkButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_INSTALL);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "tap_install_link_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackDownloadLinkButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_DOWNLOAD);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "tap_download_link_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackDownloadRetryButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_DOWNLOAD);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "download_retry_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackDownloadStart() throws JSONException {
        speedCount = 0;
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        reportBizLog(LoggerConst.ACTION_START_DOWNLOAD, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString())));
    }

    public final void trackDownloadingSpeed(String apkSize, String currentSize, String speed) throws JSONException {
        Intrinsics.checkNotNullParameter(apkSize, "apkSize");
        Intrinsics.checkNotNullParameter(currentSize, "currentSize");
        Intrinsics.checkNotNullParameter(speed, "speed");
        int i = speedCount;
        speedCount = i + 1;
        if (i % 5 != 0) {
            return;
        }
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        argsJson.put(Constants.APK_SIZE_FIELD, apkSize);
        argsJson.put("download_size", currentSize);
        argsJson.put("download_rate", speed);
        reportBizLog(LoggerConst.ACTION_DOWNLOAD_RUNNING, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString())));
    }

    public final void trackDownloadComplete() throws JSONException {
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        reportBizLog(LoggerConst.ACTION_DOWNLOAD_COMPLETE, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString())));
    }

    public final void trackInstallConfirmButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_INSTALL);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.OBJECT_TYPE_UPDATE_INSTALL_TAP), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackInstallDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_INSTALL)));
    }

    public final void trackInstallConfirmCancelButtonClick(boolean fromConfirm) throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", fromConfirm ? LoggerConst.DIALOG_TYPE_INSTALL_CONFIRM : LoggerConst.DIALOG_TYPE_NOT_INSTALL);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "install_cancel_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackInstallConfirmPositiveButtonClick(boolean fromConfirm) throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", fromConfirm ? LoggerConst.DIALOG_TYPE_INSTALL_CONFIRM : LoggerConst.DIALOG_TYPE_NOT_INSTALL);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, fromConfirm ? "install_success_but" : "reinstall_but");
        pairArr[1] = TuplesKt.to("extra", extraJson.toString());
        reportBizLog("click", MapsKt.mapOf(pairArr));
    }

    public final void trackInstallComplete() throws JSONException {
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        reportBizLog(LoggerConst.ACTION_INSTALL_COMPLETE, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString())));
        clearChainId();
    }

    public final void trackToTapUpdateButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_UPDATE);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.OBJECT_TYPE_UPDATE_GO_TAP), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackUpdateDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_UPDATE)));
    }

    public final void trackRequestFailDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_REQUEST_FAIL)));
    }

    public final void trackUpdateConfirmDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_CONFIRM)));
    }

    public final void trackInstallConfirmDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_INSTALL_CONFIRM)));
    }

    public final void trackNotInstallDialogVisible() throws JSONException {
        reportBizLog("view", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, LoggerConst.DIALOG_TYPE_NOT_INSTALL)));
    }

    public final void trackRequestFailNegativeButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_REQUEST_FAIL);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "install_cancel_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackRequestFailedPositiveButtonClick() throws JSONException {
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", LoggerConst.DIALOG_TYPE_REQUEST_FAIL);
        reportBizLog("click", MapsKt.mapOf(TuplesKt.to(LoggerConst.KEY_OBJECT_TYPE, "install_retry_but"), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackInstall(boolean manualClick) throws JSONException {
        JSONObject extraJson = new JSONObject();
        JSONObject argsJson = new JSONObject();
        argsJson.put("chain_id", getChainId());
        extraJson.put("install_type", manualClick ? "click_install" : "auto_install");
        reportBizLog(LoggerConst.ACTION_INSTALL, MapsKt.mapOf(TuplesKt.to("args", argsJson.toString()), TuplesKt.to("extra", extraJson.toString())));
    }

    public final void trackUpdateGameStart() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("func_name", "updateGame");
        json.put("session_id", currentSessionId);
        reportBizLog(TrackAction.START, MapsKt.mapOf(TuplesKt.to("args", json.toString())));
    }

    public final void trackUpdateGameCancel() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("func_name", "updateGame");
        json.put("session_id", currentSessionId);
        reportBizLog(TrackAction.CANCEL, MapsKt.mapOf(TuplesKt.to("args", json.toString())));
    }

    public final void trackUpdateGameFail(int errorCode, String errorMsg) throws JSONException {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        JSONObject json = new JSONObject();
        json.put("func_name", "updateGame");
        json.put(Constants.ERROR_CODE_FIELD, errorCode);
        json.put("session_id", currentSessionId);
        json.put(Constants.ERROR_MSG_FIELD, errorMsg);
        reportBizLog(TrackAction.FAIL, MapsKt.mapOf(TuplesKt.to("args", json.toString())));
    }

    public final void trackUpdateGameSuccess() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("session_id", currentSessionId);
        json.put("func_name", "updateGame");
        reportBizLog(TrackAction.SUCCESS, MapsKt.mapOf(TuplesKt.to("args", json.toString())));
    }

    public final void trackInitialize() throws JSONException {
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", TrackAction.INIT));
        TapJson this_$iv$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.INIT, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public final void trackStart$tap_update_release(String funcName) throws JSONException {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", getSessionId()));
        TapJson this_$iv$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.START, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public final void trackSuccess$tap_update_release(String funcName) throws JSONException {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", getSessionId()));
        TapJson this_$iv$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.SUCCESS, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public static /* synthetic */ void trackFail$tap_update_release$default(UpdateTracker updateTracker, String str, Integer num, String str2, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        updateTracker.trackFail$tap_update_release(str, num, str2);
    }

    public final void trackFail$tap_update_release(String funcName, Integer errorCode, String errorMessage) throws JSONException {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", getSessionId()));
        if (errorCode != null) {
            int it = errorCode.intValue();
            argsMap.put(Constants.ERROR_CODE_FIELD, String.valueOf(it));
        }
        if (errorMessage != null) {
            argsMap.put(Constants.ERROR_MSG_FIELD, errorMessage);
        }
        TapJson this_$iv$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.FAIL, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public final void trackView(String objectType) throws JSONException {
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        Map paramMap = new LinkedHashMap();
        paramMap.put("page", "tapsdk_update");
        paramMap.put(LoggerConst.KEY_OBJECT_TYPE, objectType);
        reportBizLog("view", paramMap);
    }

    public final void trackClick(String block, String objectType) throws JSONException {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        Map paramMap = new LinkedHashMap();
        JSONObject extraJson = new JSONObject();
        extraJson.put("block", block);
        paramMap.put("page", "tapsdk_update");
        String string = extraJson.toString();
        Intrinsics.checkNotNullExpressionValue(string, "extraJson.toString()");
        paramMap.put("extra", string);
        paramMap.put(LoggerConst.KEY_OBJECT_TYPE, objectType);
        reportBizLog("click", paramMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportBizLog$default(UpdateTracker updateTracker, String str, Map map, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        updateTracker.reportBizLog(str, map);
    }

    private final void reportBizLog(String action, Map<String, String> paramMap) throws JSONException {
        JSONObject jSONObject;
        Map params = MapsKt.toMutableMap(paramMap);
        String extraString = paramMap.get("extra");
        String str = extraString;
        if (str == null || str.length() == 0) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(extraString);
        }
        JSONObject extraJson = jSONObject;
        extraJson.put("update_id", getSessionId());
        JSONObject $this$reportBizLog_u24lambda_u246 = new JSONObject();
        $this$reportBizLog_u24lambda_u246.put("game_id", gameId);
        params.put("extra", extraJson.toString());
        params.put("ctx", $this$reportBizLog_u24lambda_u246.toString());
        TapLoggerKt.logInfo("reportBizLog: action=" + action + ", params=" + params);
        ITapOpenlog loggerHelper2 = getLoggerHelper();
        if (loggerHelper2 != null) {
            ITapOpenlog.DefaultImpls.reportBusinessLog$default(loggerHelper2, null, action, params, 1, null);
        }
    }
}
