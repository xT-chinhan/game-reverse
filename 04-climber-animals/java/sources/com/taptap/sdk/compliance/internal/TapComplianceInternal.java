package com.taptap.sdk.compliance.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.anythink.basead.c.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.compliance.ComplianceAuthorizationCallback;
import com.taptap.sdk.compliance.HealthReminderCallback;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.RealNameVerifyCallback;
import com.taptap.sdk.compliance.TapTapComplianceCallback;
import com.taptap.sdk.compliance.api.ConfigApi;
import com.taptap.sdk.compliance.api.IdentityVerifyApi;
import com.taptap.sdk.compliance.api.PaymentApi;
import com.taptap.sdk.compliance.bean.AgeCheckResult;
import com.taptap.sdk.compliance.bean.AntiPolicy;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.bean.IdentityVerifyState;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.compliance.bean.RealNameConfig;
import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.bean.UserState;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.model.PlayLogModel;
import com.taptap.sdk.compliance.model.TapLoginModel;
import com.taptap.sdk.compliance.model.TimingModel;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.compliance.widget.ComplianceUIHelper;
import com.taptap.sdk.compliance.widget.dialog.HealthReminderDialog;
import com.taptap.sdk.compliance.widget.dialog.RealNameVerifyDialog;
import com.taptap.sdk.compliance.widget.dialog.TapAuthorizationDialog;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.utils.KVUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: TapComplianceInternal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\f2\u0012\b\u0002\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000108J(\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00152\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u000108J\u001a\u0010>\u001a\u0002052\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000108H\u0002J\u0010\u0010?\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002J(\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00152\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010DH\u0002J\b\u0010E\u001a\u000205H\u0002J\u001e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020H2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020H08H\u0002J\u0006\u0010I\u001a\u00020\fJ\u0006\u0010J\u001a\u00020\u0015J\u0006\u0010K\u001a\u00020\u0015J\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010M\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002J\b\u0010N\u001a\u000205H\u0002J6\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\u00152\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010D2\u0006\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020\fH\u0002J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002J\u0018\u0010W\u001a\u0002052\u0006\u0010:\u001a\u00020\u00192\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010X\u001a\u00020\nH\u0002J\b\u0010Y\u001a\u000205H\u0002J\b\u0010Z\u001a\u000205H\u0002J&\u0010[\u001a\u0002052\u0006\u0010P\u001a\u00020\u00152\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010DJ\u000e\u0010\\\u001a\u0002052\u0006\u0010<\u001a\u00020\u0013J\b\u0010]\u001a\u000205H\u0002J\u0010\u0010^\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002JD\u0010_\u001a\u0002052\u0006\u0010`\u001a\u00020\u00152\b\b\u0002\u0010Q\u001a\u00020\f2\b\b\u0002\u0010a\u001a\u00020\f2\b\b\u0002\u0010b\u001a\u00020\f2\b\b\u0002\u0010c\u001a\u00020\f2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0010\u0010f\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002J\u0016\u0010g\u001a\u0002052\u0006\u0010:\u001a\u00020\u00192\u0006\u0010h\u001a\u00020\fJ \u0010i\u001a\u0002052\u0006\u0010;\u001a\u00020\u00152\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020j\u0018\u000108J\u0006\u0010k\u001a\u000205J\u0006\u0010l\u001a\u000205J\b\u0010m\u001a\u000205H\u0002J\u000e\u0010n\u001a\u0002052\u0006\u0010<\u001a\u00020\u0013J\u0010\u0010o\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002J\u0010\u0010p\u001a\u0002052\u0006\u0010:\u001a\u00020\u0019H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001a\u00101\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-¨\u0006q"}, d2 = {"Lcom/taptap/sdk/compliance/internal/TapComplianceInternal;", "", "()V", "appLifecycleCallback", "com/taptap/sdk/compliance/internal/TapComplianceInternal$appLifecycleCallback$2$1", "getAppLifecycleCallback", "()Lcom/taptap/sdk/compliance/internal/TapComplianceInternal$appLifecycleCallback$2$1;", "appLifecycleCallback$delegate", "Lkotlin/Lazy;", "canPlay", "", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "complianceCallbacks", "", "Lcom/taptap/sdk/compliance/TapTapComplianceCallback;", "currentRemindType", "", "currentSessionId", "gameActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "isFirstUseTapRealName", "isManuallyVerify", "isRunning", "noticeGameCanPlay", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "setRegionType", "(Lcom/taptap/sdk/initializer/api/model/RegionType;)V", "showSwitchAccount", "getShowSwitchAccount", "()Z", "setShowSwitchAccount", "(Z)V", "userId", "getUserId", "setUserId", "withUserAgeInfo", "getWithUserAgeInfo", "setWithUserAgeInfo", "bindUser", "", "accessToken", "bindCallback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "checkPayment", TTDownloadField.TT_ACTIVITY, d.q, "callback", "Lcom/taptap/sdk/compliance/bean/CheckPaymentResult;", "checkPlayable", "checkUserIdentification", "dispatchComplianceMessage", "Lkotlinx/coroutines/Job;", "code", "extra", "", "enterGame", "fetchUserAntiConfig", "verifyState", "Lcom/taptap/sdk/compliance/bean/IdentityVerifyState;", "getCurrentAccessToken", "getCurrentAgeLimit", "getRemainingTime", "getUserAgeRange", "goTapFastAuth", "handleLoginSuccess", "handleRemindType", "type", "title", BundleKey.DESCRIPTION, "handleUnlimitedAge", "result", "Lcom/taptap/sdk/compliance/bean/CheckPlayResult;", "handleVerifyError", "handleVerifyResult", "isAdult", "leaveGame", "noticeGamePlayable", "notifyMessageInternal", "registerComplianceCallback", "sendDurationExtra", "showRealNameDialog", "showReminderDialog", "remindType", b.a.f, "negativeText", "positiveText", "reminderHealthCallback", "Lcom/taptap/sdk/compliance/HealthReminderCallback;", "showUnderReviewDialog", "startupWithTapTap", "userIdentity", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "switchAccount", "unbindUser", "unbindUserWithoutNotification", "unregisterComplianceCallback", "verifyFromServer", "verifyWithTapToken", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceInternal {

    /* JADX INFO: renamed from: appLifecycleCallback$delegate, reason: from kotlin metadata */
    private static final Lazy appLifecycleCallback;
    private static boolean canPlay;
    private static WeakReference<Activity> gameActivity;
    private static boolean isFirstUseTapRealName;
    private static boolean isManuallyVerify;
    private static volatile boolean isRunning;
    private static boolean noticeGameCanPlay;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;
    private static boolean showSwitchAccount;
    public static final TapComplianceInternal INSTANCE = new TapComplianceInternal();
    private static boolean withUserAgeInfo = true;
    private static String clientId = "";
    private static String userId = "";
    private static RegionType regionType = RegionType.CN;
    private static int currentRemindType = -1;
    private static String currentSessionId = "";
    private static final List<TapTapComplianceCallback> complianceCallbacks = new ArrayList();

    private TapComplianceInternal() {
    }

    public final boolean getShowSwitchAccount() {
        return showSwitchAccount;
    }

    public final void setShowSwitchAccount(boolean z) {
        showSwitchAccount = z;
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$special$$inlined$inject$1
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
        appLifecycleCallback = LazyKt.lazy(new Function0<TapComplianceInternal$appLifecycleCallback$2.AnonymousClass1>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$appLifecycleCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.taptap.sdk.compliance.internal.TapComplianceInternal$appLifecycleCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$appLifecycleCallback$2.1
                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, bundle);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityPaused(this, activity);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityResumed(this, activity);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
                    public void onForeground(Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        TapComplianceInternal.INSTANCE.enterGame();
                    }

                    @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
                    public void onBackground(Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        TapComplianceInternal.INSTANCE.leaveGame();
                    }
                };
            }
        });
    }

    public final boolean getWithUserAgeInfo() {
        return withUserAgeInfo;
    }

    public final void setWithUserAgeInfo(boolean z) {
        withUserAgeInfo = z;
    }

    public final String getClientId() {
        return clientId;
    }

    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientId = str;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        userId = str;
    }

    public final RegionType getRegionType() {
        return regionType;
    }

    public final void setRegionType(RegionType regionType2) {
        Intrinsics.checkNotNullParameter(regionType2, "<set-?>");
        regionType = regionType2;
    }

    private final OpenLogService getOpenLogService() {
        return (OpenLogService) openLogService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapComplianceInternal$appLifecycleCallback$2.AnonymousClass1 getAppLifecycleCallback() {
        return (TapComplianceInternal$appLifecycleCallback$2.AnonymousClass1) appLifecycleCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterGame() {
        TapComplianceLoggerKt.logInfo("enterGame: current user=" + UserModel.INSTANCE.getCurrentUser() + ", is timing=" + TimingModel.INSTANCE.isTiming() + ", can play=" + canPlay);
        if (UserModel.INSTANCE.getCurrentUser() == null || TimingModel.INSTANCE.isTiming() || !canPlay) {
            return;
        }
        TimingModel.INSTANCE.bind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void leaveGame() {
        TapComplianceLoggerKt.logInfo("leaveGame: current user=" + UserModel.INSTANCE.getCurrentUser() + ", is timing=" + TimingModel.INSTANCE.isTiming() + ", can play=" + canPlay);
        if (UserModel.INSTANCE.getCurrentUser() == null || !canPlay) {
            return;
        }
        TimingModel.INSTANCE.unbind();
    }

    public final synchronized void registerComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapTapComplianceCallback> list = complianceCallbacks;
        if (!list.contains(callback)) {
            list.add(callback);
        }
    }

    public final void unregisterComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        complianceCallbacks.remove(callback);
    }

    public final void startupWithTapTap(final Activity activity, String userIdentity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userIdentity, "userIdentity");
        if (isRunning) {
            TapComplianceLoggerKt.logInfo("try startup failed, cause another check is running");
            return;
        }
        isRunning = true;
        currentSessionId = StringExtKt.generateSessionId();
        ComplianceTracker.trackStart$tap_compliance_release$default(ComplianceTracker.INSTANCE, "startup", currentSessionId, null, 4, null);
        gameActivity = new WeakReference<>(activity);
        TapComplianceLoggerKt.logInfo("startup check anti-addiction");
        userId = userIdentity;
        ComplianceUIHelper.showLoading$default(ComplianceUIHelper.INSTANCE, activity, 0L, 2, null);
        ConfigApi.INSTANCE.fetchRealNameConfig(new TapTapCallback<RealNameConfig>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.startupWithTapTap.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(RealNameConfig result) {
                ComplianceUIHelper.INSTANCE.dismissLoading();
                TapComplianceInternal.INSTANCE.checkUserIdentification(activity);
                TapComplianceLoggerKt.logInfo("fetchRealNameConfig success: result=" + result);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                ComplianceUIHelper.INSTANCE.dismissLoading();
                TapComplianceLoggerKt.logError("fetchRealNameConfig fail: cause " + exception.getMessage(), exception);
                TapComplianceInternal.INSTANCE.notifyMessageInternal(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, MapsKt.mapOf(TuplesKt.to(BundleKey.DESCRIPTION, "应用配置参数无效")));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkPayment$default(TapComplianceInternal tapComplianceInternal, Activity activity, int i, TapTapCallback tapTapCallback, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            tapTapCallback = null;
        }
        tapComplianceInternal.checkPayment(activity, i, tapTapCallback);
    }

    public final void checkPayment(final Activity activity, int amount, final TapTapCallback<CheckPaymentResult> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (UserModel.INSTANCE.getCurrentUser() == null) {
            return;
        }
        PaymentApi.INSTANCE.checkPayment(amount, new TapTapCallback<CheckPaymentResult>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.checkPayment.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPaymentResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapTapCallback<CheckPaymentResult> tapTapCallback = callback;
                if (tapTapCallback != null) {
                    tapTapCallback.onSuccess(result);
                }
                if (result.getStatus()) {
                    return;
                }
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                String title = result.getTitle();
                String description = result.getDescription();
                String string = activity.getString(R.string.compliance_return_game);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…g.compliance_return_game)");
                TapComplianceInternal.showReminderDialog$default(tapComplianceInternal, 1005, title, description, null, string, null, 40, null);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapTapCallback<CheckPaymentResult> tapTapCallback = callback;
                if (tapTapCallback != null) {
                    tapTapCallback.onFail(exception);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void submitPayment$default(TapComplianceInternal tapComplianceInternal, int i, TapTapCallback tapTapCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            tapTapCallback = null;
        }
        tapComplianceInternal.submitPayment(i, tapTapCallback);
    }

    public final void submitPayment(int amount, final TapTapCallback<JsonElement> callback) {
        if (UserModel.INSTANCE.getCurrentUser() == null) {
            return;
        }
        PaymentApi.INSTANCE.submitPayment(amount, new TapTapCallback<JsonElement>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.submitPayment.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(JsonElement result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapTapCallback<JsonElement> tapTapCallback = callback;
                if (tapTapCallback != null) {
                    tapTapCallback.onSuccess(result);
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapTapCallback<JsonElement> tapTapCallback = callback;
                if (tapTapCallback != null) {
                    tapTapCallback.onFail(exception);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUserIdentification(Activity activity) {
        String cachedAccessTokenV2 = TapComplianceSettings.INSTANCE.getCachedAccessTokenV2();
        if (cachedAccessTokenV2.length() > 0) {
            TapComplianceLoggerKt.logInfo("continue with cached access token v2: token=" + cachedAccessTokenV2);
            handleVerifyResult(activity, new IdentityVerifyState(IdentityVerifyStateKt.VERIFY_STATE_SUCCESS, cachedAccessTokenV2, 0, 4, (DefaultConstructorMarker) null));
        } else if (TapLoginModel.INSTANCE.checkAccessTokenLocally(null)) {
            TapComplianceLoggerKt.logInfo("has local oauth access token");
            verifyWithTapToken(activity);
        } else {
            TapComplianceLoggerKt.logInfo("no local access token, fetch from server");
            verifyFromServer(activity);
        }
    }

    private final void verifyFromServer(final Activity activity) {
        IdentityVerifyApi.INSTANCE.requestIdentityVerifyInfoRemotely(new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.verifyFromServer.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapComplianceInternal.INSTANCE.handleVerifyResult(activity, result);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceInternal.INSTANCE.handleVerifyError(activity);
            }
        });
    }

    private final void verifyWithTapToken(final Activity activity) {
        IdentityVerifyApi.INSTANCE.getTokenWithTapToken(null, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.verifyWithTapToken.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapComplianceInternal.INSTANCE.handleVerifyResult(activity, result);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceInternal.INSTANCE.handleVerifyError(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleVerifyResult(Activity activity, IdentityVerifyState verifyState) {
        TapComplianceLoggerKt.logInfo("handle verify result: result=" + verifyState);
        String verifyState2 = verifyState.getVerifyState();
        if (Intrinsics.areEqual(verifyState2, IdentityVerifyStateKt.VERIFY_STATE_SUCCESS)) {
            bindUser$default(this, verifyState.getAccessToken(), null, 2, null);
        } else if (Intrinsics.areEqual(verifyState2, IdentityVerifyStateKt.VERIFY_STATE_WAITING)) {
            showReminderDialog$default(this, 1002, null, null, null, null, new HealthReminderCallback() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.handleVerifyResult.1
                @Override // com.taptap.sdk.compliance.HealthReminderCallback
                public void enterGame() {
                    HealthReminderCallback.DefaultImpls.enterGame(this);
                }

                @Override // com.taptap.sdk.compliance.HealthReminderCallback
                public void checkPending() {
                    TapComplianceInternal.dispatchComplianceMessage$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
                }
            }, 30, null);
        } else {
            goTapFastAuth(activity);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.internal.TapComplianceInternal$dispatchComplianceMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceInternal$dispatchComplianceMessage$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07871 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $code;
        final /* synthetic */ Map<String, Object> $extra;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07871(int i, Map<String, ? extends Object> map, Continuation<? super C07871> continuation) {
            super(1, continuation);
            this.$code = i;
            this.$extra = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C07871(this.$code, this.$extra, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C07871) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object[] array = TapComplianceInternal.complianceCallbacks.toArray(new TapTapComplianceCallback[0]);
            int i = this.$code;
            Map<String, ? extends Object> map = this.$extra;
            for (Object obj2 : array) {
                ((TapTapComplianceCallback) obj2).onComplianceResult(i, map);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job dispatchComplianceMessage(int code, Map<String, ? extends Object> extra) {
        return SystemExtKt.runOnMain(new C07871(code, extra, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Job dispatchComplianceMessage$default(TapComplianceInternal tapComplianceInternal, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        return tapComplianceInternal.dispatchComplianceMessage(i, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleVerifyError(Activity activity) {
        TapComplianceLoggerKt.logInfo("handle verify error");
        goTapFastAuth(activity);
    }

    private final void goTapFastAuth(final Activity activity) {
        TapComplianceLoggerKt.logInfo("go tap fast auth");
        final boolean z = false;
        isManuallyVerify = false;
        boolean z2 = TapLoginModel.INSTANCE.isTapLoggedIn() && !TapLoginModel.INSTANCE.checkAccessTokenLocally(null);
        RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
        if (realNameConfig != null && realNameConfig.getManualAuthEnable()) {
            z = true;
        }
        TapAuthorizationDialog tapAuthorizationDialogNewInstance = TapAuthorizationDialog.INSTANCE.newInstance(z2, z, new ComplianceAuthorizationCallback() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$goTapFastAuth$dialog$1
            @Override // com.taptap.sdk.compliance.ComplianceAuthorizationCallback
            public void goToRealNameManual(boolean isFallback) {
                TapComplianceInternal.INSTANCE.showRealNameDialog(activity);
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.isManuallyVerify = z;
            }

            @Override // com.taptap.sdk.compliance.ComplianceAuthorizationCallback
            public void onRealNameSuccess(IdentityVerifyState identifyState) {
                Intrinsics.checkNotNullParameter(identifyState, "identifyState");
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.isFirstUseTapRealName = true;
                TapComplianceInternal.bindUser$default(TapComplianceInternal.INSTANCE, identifyState.getAccessToken(), null, 2, null);
            }

            @Override // com.taptap.sdk.compliance.ComplianceAuthorizationCallback
            public void goToUnderReview() {
                TapComplianceInternal.INSTANCE.showUnderReviewDialog(activity);
            }

            @Override // com.taptap.sdk.compliance.ComplianceAuthorizationCallback
            public void onCloseRealName() {
                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
            }

            @Override // com.taptap.sdk.compliance.ComplianceAuthorizationCallback
            public void onCancel() {
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.isRunning = false;
                ComplianceTracker.INSTANCE.trackCancel$tap_compliance_release("startup", TapComplianceInternal.currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", TapComplianceInternal.isManuallyVerify ? "manual_verify" : "fast_verify")));
            }
        });
        if (tapAuthorizationDialogNewInstance.isAdded()) {
            return;
        }
        tapAuthorizationDialogNewInstance.show(activity.getFragmentManager(), "TapAuthorizationDialog");
    }

    static /* synthetic */ void showReminderDialog$default(TapComplianceInternal tapComplianceInternal, int i, String str, String str2, String str3, String str4, HealthReminderCallback healthReminderCallback, int i2, Object obj) {
        tapComplianceInternal.showReminderDialog(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? null : healthReminderCallback);
    }

    private final void showReminderDialog(int remindType, String title, String desc, String negativeText, String positiveText, HealthReminderCallback reminderHealthCallback) {
        Activity activity;
        WeakReference<Activity> weakReference = gameActivity;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("HealthReminderDialog");
        HealthReminderDialog healthReminderDialog = fragmentFindFragmentByTag instanceof HealthReminderDialog ? (HealthReminderDialog) fragmentFindFragmentByTag : null;
        if (currentRemindType == remindType) {
            boolean z = false;
            if (healthReminderDialog != null && healthReminderDialog.isVisible()) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        currentRemindType = remindType;
        if (healthReminderDialog != null) {
            healthReminderDialog.dismissAllowingStateLoss();
        }
        HealthReminderDialog healthReminderDialogNewInstance = HealthReminderDialog.INSTANCE.newInstance(remindType, title, desc, positiveText, negativeText, reminderHealthCallback);
        if (healthReminderDialogNewInstance.isAdded()) {
            return;
        }
        healthReminderDialogNewInstance.show(activity.getFragmentManager(), "HealthReminderDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRealNameDialog(Activity activity) {
        RealNameVerifyDialog realNameVerifyDialogNewInstance$default = RealNameVerifyDialog.Companion.newInstance$default(RealNameVerifyDialog.INSTANCE, userId, false, new RealNameVerifyCallback() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$showRealNameDialog$dialog$1
            @Override // com.taptap.sdk.compliance.RealNameVerifyCallback
            public void onRealNameResult(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapComplianceInternal.bindUser$default(TapComplianceInternal.INSTANCE, result.getAccessToken(), null, 2, null);
            }

            @Override // com.taptap.sdk.compliance.RealNameVerifyCallback
            public void onCloseRealName() {
                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
            }
        }, 2, null);
        if (realNameVerifyDialogNewInstance$default.isAdded()) {
            return;
        }
        realNameVerifyDialogNewInstance$default.show(activity.getFragmentManager(), "RealNameVerifyDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUnderReviewDialog(Activity activity) {
        HealthReminderDialog healthReminderDialogNewInstance$default = HealthReminderDialog.Companion.newInstance$default(HealthReminderDialog.INSTANCE, 1002, null, null, null, null, new HealthReminderCallback() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$showUnderReviewDialog$dialog$1
            @Override // com.taptap.sdk.compliance.HealthReminderCallback
            public void enterGame() {
                HealthReminderCallback.DefaultImpls.enterGame(this);
            }

            @Override // com.taptap.sdk.compliance.HealthReminderCallback
            public void checkPending() {
                TapComplianceInternal.dispatchComplianceMessage$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
            }
        }, 30, null);
        if (healthReminderDialogNewInstance$default.isAdded()) {
            return;
        }
        healthReminderDialogNewInstance$default.show(activity.getFragmentManager(), "UnderReviewDialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bindUser$default(TapComplianceInternal tapComplianceInternal, String str, TapTapCallback tapTapCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            tapTapCallback = null;
        }
        tapComplianceInternal.bindUser(str, tapTapCallback);
    }

    public final void bindUser(String accessToken, final TapTapCallback<Object> bindCallback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        unbindUserWithoutNotification();
        IdentityVerifyState identityVerifyState = new IdentityVerifyState(IdentityVerifyStateKt.VERIFY_STATE_SUCCESS, accessToken, 0, 4, (DefaultConstructorMarker) null);
        UserModel.INSTANCE.updateIdentifyState(identityVerifyState);
        TapComplianceSettings.INSTANCE.cacheAccessTokenV2(accessToken);
        fetchUserAntiConfig(identityVerifyState, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.bindUser.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = null;
                UserModel.INSTANCE.updateCurrentUserInfo(new UserInfo(str, TapComplianceInternal.INSTANCE.getUserId(), Integer.valueOf(result.getAgeLimit()), result.getAccessToken(), 0, 0L, (String) null, 113, (DefaultConstructorMarker) null));
                TapComplianceInternal.INSTANCE.checkPlayable(bindCallback);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapTapCallback<Object> tapTapCallback = bindCallback;
                if (tapTapCallback != null) {
                    tapTapCallback.onFail(exception);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPlayable(final TapTapCallback<Object> bindCallback) {
        PlayLogModel.INSTANCE.checkUserState((TapTapCallback) new TapTapCallback<Pair<? extends Boolean, ? extends CheckPlayResult>>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.checkPlayable.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public /* bridge */ /* synthetic */ void onSuccess(Pair<? extends Boolean, ? extends CheckPlayResult> pair) {
                onSuccess2((Pair<Boolean, CheckPlayResult>) pair);
            }

            /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(Pair<Boolean, CheckPlayResult> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getFirst().booleanValue()) {
                    TapComplianceInternal.INSTANCE.handleUnlimitedAge(result.getSecond());
                } else {
                    TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 500, null, 2, null);
                }
                TapTapCallback<Object> tapTapCallback = bindCallback;
                if (tapTapCallback != null) {
                    tapTapCallback.onSuccess(null);
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapTapCallback<Object> tapTapCallback = bindCallback;
                if (tapTapCallback != null) {
                    tapTapCallback.onFail(exception);
                }
                TapComplianceInternal.INSTANCE.notifyMessageInternal(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, MapsKt.mapOf(TuplesKt.to(BundleKey.DESCRIPTION, "网络异常，请稍后重试")));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void handleUnlimitedAge(CheckPlayResult result) {
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        boolean z = false;
        if (currentUser != null && currentUser.isAdult()) {
            z = true;
        }
        if (z) {
            notifyMessageInternal$default(this, 500, null, 2, null);
        } else if (result.getRemainTime() <= 0) {
            notifyMessageInternal(1030, TapComplianceSettings.INSTANCE.generateAlertMessage(result.getRemainTime(), result.getTitle(), result.getDescription()));
        } else {
            notifyMessageInternal$default(this, 500, null, 2, null);
            notifyMessageInternal(ComplianceMessage.OPEN_ALERT_TIP, TapComplianceSettings.INSTANCE.generateAlertMessage(result.getRemainTime(), result.getTitle(), result.getDescription()));
        }
    }

    private final void fetchUserAntiConfig(final IdentityVerifyState verifyState, final TapTapCallback<IdentityVerifyState> callback) {
        ConfigApi.INSTANCE.fetchUserAntiConfig(new TapTapCallback<UserAntiConfig>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal.fetchUserAntiConfig.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(UserAntiConfig result) {
                Integer ageLimit;
                Integer policyHeartbeatInterval;
                Intrinsics.checkNotNullParameter(result, "result");
                UserState realNameState = result.getRealNameState();
                if (realNameState == null || (ageLimit = realNameState.getAgeLimit()) == null) {
                    return;
                }
                IdentityVerifyState identityVerifyState = verifyState;
                TapTapCallback<IdentityVerifyState> tapTapCallback = callback;
                int iIntValue = ageLimit.intValue();
                if (iIntValue > -1) {
                    identityVerifyState.setAgeLimit(iIntValue);
                } else {
                    identityVerifyState.setAgeLimit(Intrinsics.areEqual((Object) result.getRealNameState().isAdult(), (Object) true) ? 110 : 100);
                }
                TimingModel timingModel = TimingModel.INSTANCE;
                AntiPolicy antiAddiction = result.getAntiAddiction();
                timingModel.setTimingInterval((antiAddiction == null || (policyHeartbeatInterval = antiAddiction.getPolicyHeartbeatInterval()) == null) ? 120 : policyHeartbeatInterval.intValue());
                PlayLogModel.INSTANCE.setSessionId(SystemExtKt.getRandomString(32));
                AgeCheckResult ageCheckResult = result.getAgeCheckResult();
                if (!(ageCheckResult != null && ageCheckResult.getAllow())) {
                    TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 1100, null, 2, null);
                    tapTapCallback.onFail(new TapTapException("age check result: not allow"));
                } else {
                    tapTapCallback.onSuccess(identityVerifyState);
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceInternal.INSTANCE.notifyMessageInternal(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, MapsKt.mapOf(TuplesKt.to(BundleKey.DESCRIPTION, "网络异常，请稍后重试")));
                callback.onFail(exception);
            }
        });
    }

    public final void unbindUser() {
        String userId2;
        notifyMessageInternal$default(this, 1000, null, 2, null);
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser != null && (userId2 = currentUser.getUserId()) != null) {
            TapComplianceSettings.INSTANCE.clearAllCachedToken(userId2);
        }
        UserModel.INSTANCE.unbindUser();
        TimingModel.INSTANCE.unbind();
        canPlay = false;
        TapActivityLifecycleTracker.INSTANCE.unregisterActivityLifecycleCallbacks(getAppLifecycleCallback());
    }

    private final void unbindUserWithoutNotification() {
        UserModel.INSTANCE.unbindUser();
        TimingModel.INSTANCE.unbind();
        canPlay = false;
        TapActivityLifecycleTracker.INSTANCE.unregisterActivityLifecycleCallbacks(getAppLifecycleCallback());
    }

    public final int getUserAgeRange() {
        UserInfo currentUser;
        Integer ageLimit;
        if (!withUserAgeInfo || (currentUser = UserModel.INSTANCE.getCurrentUser()) == null) {
            return -1;
        }
        Integer ageLimit2 = currentUser.getAgeLimit();
        if (ageLimit2 != null && ageLimit2.intValue() == 100) {
            return -1;
        }
        Integer ageLimit3 = currentUser.getAgeLimit();
        if ((ageLimit3 != null && ageLimit3.intValue() == 110) || (ageLimit = currentUser.getAgeLimit()) == null) {
            return -1;
        }
        return ageLimit.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void notifyMessageInternal$default(TapComplianceInternal tapComplianceInternal, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        tapComplianceInternal.notifyMessageInternal(i, map);
    }

    public final void notifyMessageInternal(int type, Map<String, ? extends Object> extra) {
        Object obj = extra != null ? extra.get("title") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        Object obj2 = extra != null ? extra.get(BundleKey.DESCRIPTION) : null;
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            str2 = "";
        }
        if (type == 500) {
            isRunning = false;
            canPlay = true;
            handleLoginSuccess();
            ComplianceTracker.INSTANCE.trackSuccess$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")));
        } else if (type == 1030 || type == 1050 || type == 1095) {
            handleRemindType(type, extra, str, str2);
            ComplianceTracker.INSTANCE.trackSuccess$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")));
        } else if (type == 1100) {
            isRunning = false;
            canPlay = false;
            dispatchComplianceMessage$default(this, 1100, null, 2, null);
            ComplianceTracker.INSTANCE.trackSuccess$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")));
        } else if (type == 1200) {
            isRunning = false;
            canPlay = false;
            dispatchComplianceMessage(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, extra);
            ComplianceTracker.INSTANCE.trackFail$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")), Integer.valueOf(type), "invalid client or network error");
        } else if (type == 1000) {
            canPlay = false;
            userId = "";
            PlayLogModel.INSTANCE.setSessionId("");
            sendDurationExtra();
            dispatchComplianceMessage$default(this, 1000, null, 2, null);
        } else if (type == 1001) {
            isRunning = false;
            canPlay = false;
            sendDurationExtra();
            dispatchComplianceMessage$default(this, 1001, null, 2, null);
        } else if (type == 9001) {
            unbindUser();
        } else if (type == 9002) {
            isRunning = false;
            ComplianceTracker.INSTANCE.trackCancel$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")));
            dispatchComplianceMessage$default(this, 9002, null, 2, null);
        }
        SystemExtKt.runOnMain(new C07901(null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.internal.TapComplianceInternal$notifyMessageInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceInternal$notifyMessageInternal$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07901 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C07901(Continuation<? super C07901> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C07901(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C07901) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (TapComplianceInternal.canPlay) {
                    TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks(TapComplianceInternal.INSTANCE.getAppLifecycleCallback());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void handleRemindType(int type, Map<String, ? extends Object> extra, String title, String description) {
        int i;
        String str;
        HealthReminderCallback healthReminderCallback;
        if (type != 1030) {
            i = type != 1050 ? 1004 : 1001;
        } else {
            i = 1003;
        }
        int i2 = i;
        if (type == 1095) {
            str = "进入游戏";
        } else {
            dispatchComplianceMessage(type, extra);
            str = "退出游戏";
        }
        String str2 = str;
        if (type == 1095) {
            healthReminderCallback = new HealthReminderCallback() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$handleRemindType$callback$1
                @Override // com.taptap.sdk.compliance.HealthReminderCallback
                public void checkPending() {
                    HealthReminderCallback.DefaultImpls.checkPending(this);
                }

                @Override // com.taptap.sdk.compliance.HealthReminderCallback
                public void enterGame() {
                    TimingModel.INSTANCE.checkPlayable(new TapTapCallback<Boolean>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceInternal$handleRemindType$callback$1$enterGame$1
                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onCancel() {
                            TapTapCallback.DefaultImpls.onCancel(this);
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public /* bridge */ /* synthetic */ void onSuccess(Boolean bool) {
                            onSuccess(bool.booleanValue());
                        }

                        public void onSuccess(boolean result) {
                            if (result) {
                                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                                TapComplianceInternal.canPlay = true;
                                TapComplianceInternal.INSTANCE.noticeGamePlayable();
                            }
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onFail(TapTapException exception) {
                            Intrinsics.checkNotNullParameter(exception, "exception");
                            TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                            TapComplianceInternal.canPlay = false;
                            SysExtKt.showToast(exception.getMessage());
                        }
                    });
                }
            };
        } else {
            canPlay = false;
            healthReminderCallback = null;
        }
        showReminderDialog$default(this, i2, title, description, null, str2, healthReminderCallback, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void noticeGamePlayable() {
        if (noticeGameCanPlay) {
            dispatchComplianceMessage$default(this, 500, null, 2, null);
            sendDurationExtra();
            enterGame();
            noticeGameCanPlay = false;
        }
    }

    private final void handleLoginSuccess() {
        String userId2;
        if (isAdult()) {
            dispatchComplianceMessage$default(this, 500, null, 2, null);
            sendDurationExtra();
            enterGame();
        } else {
            noticeGameCanPlay = true;
        }
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || (userId2 = currentUser.getUserId()) == null || KVUtil.getBoolean$default(KVUtil.INSTANCE, userId2, null, 2, null)) {
            return;
        }
        SystemExtKt.runOnMain(new TapComplianceInternal$handleLoginSuccess$1$1(null));
        KVUtil.putBoolean$default(KVUtil.INSTANCE, userId2, true, null, 4, null);
    }

    public final void switchAccount() {
        unbindUserWithoutNotification();
        notifyMessageInternal$default(this, 1001, null, 2, null);
    }

    public final String getCurrentAccessToken() {
        String accessToken;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        return (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) ? "" : accessToken;
    }

    public final int getCurrentAgeLimit() {
        UserInfo currentUser;
        Integer ageLimit;
        if (!withUserAgeInfo) {
            return -1;
        }
        UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
        Integer ageLimit2 = currentUser2 != null ? currentUser2.getAgeLimit() : null;
        boolean z = true;
        if ((ageLimit2 == null || ageLimit2.intValue() != 100) && (ageLimit2 == null || ageLimit2.intValue() != 110)) {
            z = false;
        }
        if (z || (currentUser = UserModel.INSTANCE.getCurrentUser()) == null || (ageLimit = currentUser.getAgeLimit()) == null) {
            return -1;
        }
        return ageLimit.intValue();
    }

    private final boolean isAdult() {
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        return currentUser != null && currentUser.isAdult();
    }

    public final int getRemainingTime() {
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser != null) {
            return currentUser.getRemainTime();
        }
        return 0;
    }

    private final void sendDurationExtra() {
        getOpenLogService().setExtraAppDurationParams(MapsKt.mapOf(TuplesKt.to(BundleKey.ANTI_ADDICTION_USER_ID, userId), TuplesKt.to(BundleKey.ANTI_ADDICTION_SESSION_ID, PlayLogModel.INSTANCE.getSessionId())));
    }
}
