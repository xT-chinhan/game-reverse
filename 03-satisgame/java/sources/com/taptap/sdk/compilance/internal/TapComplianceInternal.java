package com.taptap.sdk.compilance.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.ComplianceAuthorizationCallback;
import com.taptap.sdk.compilance.HealthReminderCallback;
import com.taptap.sdk.compilance.R;
import com.taptap.sdk.compilance.RealNameVerifyCallback;
import com.taptap.sdk.compilance.TapTapComplianceCallback;
import com.taptap.sdk.compilance.api.ConfigApi;
import com.taptap.sdk.compilance.api.IdentityVerifyApi;
import com.taptap.sdk.compilance.api.PaymentApi;
import com.taptap.sdk.compilance.bean.AgeCheckResult;
import com.taptap.sdk.compilance.bean.AntiPolicy;
import com.taptap.sdk.compilance.bean.CheckPaymentResult;
import com.taptap.sdk.compilance.bean.CheckPlayResult;
import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.compilance.bean.RealNameConfig;
import com.taptap.sdk.compilance.bean.UserAntiConfig;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.bean.UserState;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.model.PlayLogModel;
import com.taptap.sdk.compilance.model.TapLoginModel;
import com.taptap.sdk.compilance.model.TimingModel;
import com.taptap.sdk.compilance.model.UserModel;
import com.taptap.sdk.compilance.widget.ComplianceUIHelper;
import com.taptap.sdk.compilance.widget.dialog.HealthReminderDialog;
import com.taptap.sdk.compilance.widget.dialog.RealNameVerifyDialog;
import com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.kit.internal.service.CoreService;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker;
import com.taptap.sdk.openlog.api.OpenLogService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.JsonElement;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: TapComplianceInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u000e2\u0012\b\u0002\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BJ(\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\n2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010BJ\u001a\u0010I\u001a\u00020?2\u0010\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BH\u0002J\b\u0010J\u001a\u00020?H\u0002J\u0010\u0010K\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J(\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\n2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020C\u0018\u00010PH\u0002J\b\u0010Q\u001a\u00020?H\u0002J\u0012\u0010R\u001a\u00020?2\b\u0010E\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010S\u001a\u00020?H\u0002J\u001e\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020V0BH\u0002J\u0006\u0010W\u001a\u00020\u000eJ\u0006\u0010X\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020\nJ\u0010\u0010[\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J\b\u0010\\\u001a\u00020?H\u0002J6\u0010]\u001a\u00020?2\u0006\u0010^\u001a\u00020\n2\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020C\u0018\u00010P2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\u000eH\u0002J\u0010\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020cH\u0002J\u0010\u0010d\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0018\u0010e\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020VH\u0002J\u0012\u0010f\u001a\u00020?2\b\u0010E\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010g\u001a\u00020\fH\u0002J\b\u0010h\u001a\u00020?H\u0002J\b\u0010i\u001a\u00020?H\u0002J&\u0010j\u001a\u00020?2\u0006\u0010^\u001a\u00020\n2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020C\u0018\u00010PJ\u000e\u0010k\u001a\u00020?2\u0006\u0010G\u001a\u00020\u0015J\b\u0010l\u001a\u00020?H\u0002J\u0016\u0010&\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010m\u001a\u00020\fJ\u0010\u0010n\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002JD\u0010o\u001a\u00020?2\u0006\u0010p\u001a\u00020\n2\b\b\u0002\u0010_\u001a\u00020\u000e2\b\b\u0002\u0010q\u001a\u00020\u000e2\b\b\u0002\u0010r\u001a\u00020\u000e2\b\b\u0002\u0010s\u001a\u00020\u000e2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0012\u0010v\u001a\u00020?2\b\u0010E\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010w\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0016\u0010x\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010y\u001a\u00020\u000eJ \u0010z\u001a\u00020?2\u0006\u0010F\u001a\u00020\n2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010BJ\u0006\u0010|\u001a\u00020?J\u0010\u0010}\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0006\u0010~\u001a\u00020?J\b\u0010\u007f\u001a\u00020?H\u0002J\u000f\u0010\u0080\u0001\u001a\u00020?2\u0006\u0010G\u001a\u00020\u0015J\u0011\u0010\u0081\u0001\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020?2\u0006\u0010E\u001a\u00020\u001dH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u0016\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R\u001a\u0010;\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'¨\u0006\u0083\u0001"}, d2 = {"Lcom/taptap/sdk/compilance/internal/TapComplianceInternal;", "Lorg/koin/core/component/KoinComponent;", "()V", "appLifecycleCallback", "com/taptap/sdk/compilance/internal/TapComplianceInternal$appLifecycleCallback$2$1", "getAppLifecycleCallback", "()Lcom/taptap/sdk/compilance/internal/TapComplianceInternal$appLifecycleCallback$2$1;", "appLifecycleCallback$delegate", "Lkotlin/Lazy;", "attachState", "", "canPlay", "", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "complianceCallbacks", "", "Lcom/taptap/sdk/compilance/TapTapComplianceCallback;", "coreService", "Lcom/taptap/sdk/kit/internal/service/CoreService;", "getCoreService", "()Lcom/taptap/sdk/kit/internal/service/CoreService;", "coreService$delegate", "currentActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentSessionId", "destActivity", "gameActivity", "isFirstUseTapRealName", "isManuallyVerify", "isRunning", "isTestEnvironment", "()Z", "setTestEnvironment", "(Z)V", "noticeGameCanPlay", "openLogService", "Lcom/taptap/sdk/openlog/api/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/openlog/api/OpenLogService;", "openLogService$delegate", "regionType", "getRegionType", "()I", "setRegionType", "(I)V", "showSwitchAccount", "getShowSwitchAccount", "setShowSwitchAccount", "testModeTipsView", "Landroid/view/View;", "userId", "getUserId", "setUserId", "withUserAgeInfo", "getWithUserAgeInfo", "setWithUserAgeInfo", "bindUser", "", "accessToken", "bindCallback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "", "checkPayment", "activity", "amount", "callback", "Lcom/taptap/sdk/compilance/bean/CheckPaymentResult;", "checkPlayable", "checkRealNameTips", "checkUserIdentification", "dispatchComplianceMessage", "Lkotlinx/coroutines/Job;", "code", "extra", "", "enterGame", "enterTestEnvironment", "exitTestEnvironment", "fetchUserAntiConfig", "verifyState", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "getCurrentAccessToken", "getCurrentAgeLimit", "getRemainingTime", "getUserAgeRange", "goTapFastAuth", "handleLoginSuccess", "handleRemindType", "type", "title", BundleKey.DESCRIPTION, "handleUnlimitedAge", "result", "Lcom/taptap/sdk/compilance/bean/CheckPlayResult;", "handleVerifyError", "handleVerifyResult", "hideTestEnvironmentTips", "isAdult", "leaveGame", "noticeGamePlayable", "notifyMessageInternal", "registerComplianceCallback", "sendDurationExtra", "isTest", "showRealNameDialog", "showReminderDialog", "remindType", SDMAdConst.NETWORK_CUSTOM_KEY.DESC, "negativeText", "positiveText", "reminderHealthCallback", "Lcom/taptap/sdk/compilance/HealthReminderCallback;", "showTestEnvironmentTips", "showUnderReviewDialog", "startupWithTapTap", "userIdentity", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "switchAccount", "tryUpgradeToken", "unbindUser", "unbindUserWithoutNotification", "unregisterComplianceCallback", "verifyFromServer", "verifyWithTapToken", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceInternal implements KoinComponent {
    public static final TapComplianceInternal INSTANCE;

    /* JADX INFO: renamed from: appLifecycleCallback$delegate, reason: from kotlin metadata */
    private static final Lazy appLifecycleCallback;
    private static volatile int attachState;
    private static boolean canPlay;
    private static String clientId;
    private static final List<TapTapComplianceCallback> complianceCallbacks;

    /* JADX INFO: renamed from: coreService$delegate, reason: from kotlin metadata */
    private static final Lazy coreService;
    private static WeakReference<Activity> currentActivity;
    private static String currentSessionId;
    private static WeakReference<Activity> destActivity;
    private static WeakReference<Activity> gameActivity;
    private static boolean isFirstUseTapRealName;
    private static boolean isManuallyVerify;
    private static volatile boolean isRunning;
    private static boolean isTestEnvironment;
    private static boolean noticeGameCanPlay;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;
    private static int regionType;
    private static boolean showSwitchAccount;
    private static WeakReference<View> testModeTipsView;
    private static String userId;
    private static boolean withUserAgeInfo;

    private TapComplianceInternal() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final boolean getShowSwitchAccount() {
        return showSwitchAccount;
    }

    public final void setShowSwitchAccount(boolean z) {
        showSwitchAccount = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TapComplianceInternal tapComplianceInternal = new TapComplianceInternal();
        INSTANCE = tapComplianceInternal;
        withUserAgeInfo = true;
        clientId = "";
        userId = "";
        attachState = -1;
        currentSessionId = "";
        complianceCallbacks = new ArrayList();
        final TapComplianceInternal tapComplianceInternal2 = tapComplianceInternal;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        coreService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<CoreService>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.kit.internal.service.CoreService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CoreService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapComplianceInternal2;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = objArr;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(CoreService.class), qualifier2, function0);
            }
        });
        final TapComplianceInternal tapComplianceInternal3 = tapComplianceInternal;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        openLogService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode2, (Function0) new Function0<OpenLogService>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.openlog.api.OpenLogService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OpenLogService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapComplianceInternal3;
                Qualifier qualifier2 = objArr2;
                Function0<? extends ParametersHolder> function0 = objArr3;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(OpenLogService.class), qualifier2, function0);
            }
        });
        appLifecycleCallback = LazyKt.lazy(new Function0<TapComplianceInternal$appLifecycleCallback$2.AnonymousClass1>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$appLifecycleCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.taptap.sdk.compilance.internal.TapComplianceInternal$appLifecycleCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$appLifecycleCallback$2.1
                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, bundle);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        TapComplianceInternal.INSTANCE.showTestEnvironmentTips(activity);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        TapComplianceInternal.INSTANCE.hideTestEnvironmentTips(activity);
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
                    public void onForeground(Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        TapComplianceInternal.INSTANCE.enterGame();
                    }

                    @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
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

    public final int getRegionType() {
        return regionType;
    }

    public final void setRegionType(int i) {
        regionType = i;
    }

    public final boolean isTestEnvironment() {
        return isTestEnvironment;
    }

    public final void setTestEnvironment(boolean z) {
        isTestEnvironment = z;
    }

    private final CoreService getCoreService() {
        return (CoreService) coreService.getValue();
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
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "enterGame: current user=" + UserModel.INSTANCE.getCurrentUser() + ", is timing=" + TimingModel.INSTANCE.isTiming() + ", can play=" + canPlay);
        if (UserModel.INSTANCE.getCurrentUser() == null || TimingModel.INSTANCE.isTiming() || !canPlay) {
            return;
        }
        TimingModel.INSTANCE.bind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void leaveGame() {
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "leaveGame: current user=" + UserModel.INSTANCE.getCurrentUser() + ", is timing=" + TimingModel.INSTANCE.isTiming() + ", can play=" + canPlay);
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
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "startup check anti-addiction");
        getCoreService().setGameUserId(userIdentity);
        userId = userIdentity;
        ComplianceUIHelper.showLoading$default(ComplianceUIHelper.INSTANCE, activity, 0L, 2, null);
        ConfigApi.INSTANCE.fetchRealNameConfig(new TapTapCallback<RealNameConfig>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.startupWithTapTap.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(RealNameConfig result) {
                ComplianceUIHelper.INSTANCE.dismissLoading();
                TapComplianceInternal.INSTANCE.checkUserIdentification(activity);
                TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "fetchRealNameConfig success: result=" + result);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                ComplianceUIHelper.INSTANCE.dismissLoading();
                TapLogger.loge(TapComplianceLoggerKt.LOGGER_TAG, "fetchRealNameConfig fail: cause " + exception.getMessage(), exception);
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
        PaymentApi.INSTANCE.checkPayment(amount, new TapTapCallback<CheckPaymentResult>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.checkPayment.1
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
        PaymentApi.INSTANCE.submitPayment(amount, new TapTapCallback<JsonElement>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.submitPayment.1
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
            TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "continue with cached access token v2: token=" + cachedAccessTokenV2);
            handleVerifyResult(activity, new IdentityVerifyState(IdentityVerifyStateKt.VERIFY_STATE_SUCCESS, cachedAccessTokenV2, 0, 4, (DefaultConstructorMarker) null));
        } else {
            tryUpgradeToken(activity);
        }
    }

    private final void tryUpgradeToken(final Activity activity) {
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "try upgrade token");
        IdentityVerifyApi.INSTANCE.upgradeToken(new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.tryUpgradeToken.1
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
                if (TapLoginModel.INSTANCE.checkAccessTokenLocally(null)) {
                    TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "has local oauth access token");
                    TapComplianceInternal.INSTANCE.verifyWithTapToken(activity);
                } else {
                    TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "no local access token, fetch from server");
                    TapComplianceInternal.INSTANCE.verifyFromServer(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyFromServer(final Activity activity) {
        IdentityVerifyApi.INSTANCE.requestIdentityVerifyInfoRemotely(new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.verifyFromServer.1
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
    public final void verifyWithTapToken(final Activity activity) {
        IdentityVerifyApi.INSTANCE.getTokenWithTapToken(null, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.verifyWithTapToken.1
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
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "handle verify result: result=" + verifyState);
        String verifyState2 = verifyState.getVerifyState();
        if (Intrinsics.areEqual(verifyState2, IdentityVerifyStateKt.VERIFY_STATE_SUCCESS)) {
            bindUser$default(this, verifyState.getAccessToken(), null, 2, null);
        } else if (Intrinsics.areEqual(verifyState2, IdentityVerifyStateKt.VERIFY_STATE_WAITING)) {
            showReminderDialog$default(this, 1002, null, null, null, null, new HealthReminderCallback() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.handleVerifyResult.1
                @Override // com.taptap.sdk.compilance.HealthReminderCallback
                public void enterGame() {
                    HealthReminderCallback.DefaultImpls.enterGame(this);
                }

                @Override // com.taptap.sdk.compilance.HealthReminderCallback
                public void checkPending() {
                    TapComplianceInternal.dispatchComplianceMessage$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
                }
            }, 30, null);
        } else {
            goTapFastAuth(activity);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceInternal$dispatchComplianceMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceInternal$dispatchComplianceMessage$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04611 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $code;
        final /* synthetic */ Map<String, Object> $extra;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04611(int i, Map<String, ? extends Object> map, Continuation<? super C04611> continuation) {
            super(1, continuation);
            this.$code = i;
            this.$extra = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04611(this.$code, this.$extra, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04611) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        return SystemExtKt.runOnMain(new C04611(code, extra, null));
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
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "handle verify error");
        goTapFastAuth(activity);
    }

    private final void goTapFastAuth(final Activity activity) {
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "go tap fast auth");
        final boolean z = false;
        isManuallyVerify = false;
        boolean z2 = TapLoginModel.INSTANCE.isTapLoggedIn() && !TapLoginModel.INSTANCE.checkAccessTokenLocally(null);
        RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
        if (realNameConfig != null && realNameConfig.getManualAuthEnable()) {
            z = true;
        }
        TapAuthorizationDialog tapAuthorizationDialogNewInstance = TapAuthorizationDialog.INSTANCE.newInstance(z2, z, new ComplianceAuthorizationCallback() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$goTapFastAuth$dialog$1
            @Override // com.taptap.sdk.compilance.ComplianceAuthorizationCallback
            public void goToRealNameManual(boolean isFallback) {
                TapComplianceInternal.INSTANCE.showRealNameDialog(activity);
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.isManuallyVerify = z;
            }

            @Override // com.taptap.sdk.compilance.ComplianceAuthorizationCallback
            public void onRealNameSuccess(IdentityVerifyState identifyState) {
                Intrinsics.checkNotNullParameter(identifyState, "identifyState");
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.isFirstUseTapRealName = true;
                TapComplianceInternal.bindUser$default(TapComplianceInternal.INSTANCE, identifyState.getAccessToken(), null, 2, null);
            }

            @Override // com.taptap.sdk.compilance.ComplianceAuthorizationCallback
            public void goToUnderReview() {
                TapComplianceInternal.INSTANCE.showUnderReviewDialog(activity);
            }

            @Override // com.taptap.sdk.compilance.ComplianceAuthorizationCallback
            public void onCloseRealName() {
                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9002, null, 2, null);
            }

            @Override // com.taptap.sdk.compilance.ComplianceAuthorizationCallback
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
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        HealthReminderDialog healthReminderDialogNewInstance = HealthReminderDialog.INSTANCE.newInstance(remindType, title, desc, positiveText, negativeText, reminderHealthCallback);
        if (healthReminderDialogNewInstance.isAdded()) {
            return;
        }
        WeakReference<Activity> weakReference2 = gameActivity;
        healthReminderDialogNewInstance.show((weakReference2 == null || (activity = weakReference2.get()) == null) ? null : activity.getFragmentManager(), "HealthReminderDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRealNameDialog(Activity activity) {
        RealNameVerifyDialog realNameVerifyDialogNewInstance$default = RealNameVerifyDialog.Companion.newInstance$default(RealNameVerifyDialog.INSTANCE, userId, false, new RealNameVerifyCallback() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$showRealNameDialog$dialog$1
            @Override // com.taptap.sdk.compilance.RealNameVerifyCallback
            public void onRealNameResult(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TapComplianceInternal.bindUser$default(TapComplianceInternal.INSTANCE, result.getAccessToken(), null, 2, null);
            }

            @Override // com.taptap.sdk.compilance.RealNameVerifyCallback
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
        HealthReminderDialog healthReminderDialogNewInstance$default = HealthReminderDialog.Companion.newInstance$default(HealthReminderDialog.INSTANCE, 1002, null, null, null, null, new HealthReminderCallback() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$showUnderReviewDialog$dialog$1
            @Override // com.taptap.sdk.compilance.HealthReminderCallback
            public void enterGame() {
                HealthReminderCallback.DefaultImpls.enterGame(this);
            }

            @Override // com.taptap.sdk.compilance.HealthReminderCallback
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
        fetchUserAntiConfig(identityVerifyState, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.bindUser.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                UserModel.INSTANCE.updateCurrentUserInfo(new UserInfo((String) null, TapComplianceInternal.INSTANCE.getUserId(), Integer.valueOf(result.getAgeLimit()), result.getAccessToken(), 0, 0L, (String) null, 113, (DefaultConstructorMarker) null));
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
        PlayLogModel.INSTANCE.checkUserState((TapTapCallback) new TapTapCallback<Pair<? extends Boolean, ? extends CheckPlayResult>>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.checkPlayable.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public /* bridge */ /* synthetic */ void onSuccess(Pair<? extends Boolean, ? extends CheckPlayResult> pair) {
                onSuccess2((Pair<Boolean, CheckPlayResult>) pair);
            }

            /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(Pair<Boolean, CheckPlayResult> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (data.getFirst().booleanValue()) {
                    TapComplianceInternal.INSTANCE.handleUnlimitedAge(data.getSecond());
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
        ConfigApi.INSTANCE.fetchUserAntiConfig(new TapTapCallback<UserAntiConfig>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal.fetchUserAntiConfig.1
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
        String userId2;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser != null && (userId2 = currentUser.getUserId()) != null) {
            TapComplianceSettings.INSTANCE.clearAllCachedToken(userId2);
        }
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
        String str3 = str2 != null ? str2 : "";
        if (type == 500) {
            isRunning = false;
            canPlay = true;
            handleLoginSuccess();
            ComplianceTracker.INSTANCE.trackSuccess$tap_compliance_release("startup", currentSessionId, MapsKt.mapOf(TuplesKt.to("identity_verify_type", isManuallyVerify ? "manual_verify" : "fast_verify")));
        } else if (type == 1030 || type == 1050 || type == 1095) {
            handleRemindType(type, extra, str, str3);
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
        SystemExtKt.runOnMain(new C04641(null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceInternal$notifyMessageInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceInternal$notifyMessageInternal$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04641 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C04641(Continuation<? super C04641> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04641(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04641) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            healthReminderCallback = new HealthReminderCallback() { // from class: com.taptap.sdk.compilance.internal.TapComplianceInternal$handleRemindType$callback$1
                @Override // com.taptap.sdk.compilance.HealthReminderCallback
                public void checkPending() {
                    HealthReminderCallback.DefaultImpls.checkPending(this);
                }

                @Override // com.taptap.sdk.compilance.HealthReminderCallback
                public void enterGame() {
                    TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                    TapComplianceInternal.canPlay = true;
                    TapComplianceInternal.INSTANCE.noticeGamePlayable();
                }
            };
        } else {
            canPlay = false;
            healthReminderCallback = null;
        }
        showReminderDialog$default(this, i2, title, description, null, str2, healthReminderCallback, 8, null);
        checkRealNameTips();
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
        if (isAdult()) {
            dispatchComplianceMessage$default(this, 500, null, 2, null);
            sendDurationExtra();
            enterGame();
            checkRealNameTips();
            return;
        }
        noticeGameCanPlay = true;
    }

    private final void checkRealNameTips() {
        if (isFirstUseTapRealName) {
            isFirstUseTapRealName = false;
            ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), R.string.compliance_realname_success);
        }
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

    public final void setTestEnvironment(Activity activity, boolean isTest) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        isTestEnvironment = isTest;
        if (isTest) {
            enterTestEnvironment(activity);
        } else {
            exitTestEnvironment();
        }
    }

    private final void enterTestEnvironment(Activity activity) {
        if (activity == null || attachState > -1) {
            return;
        }
        showTestEnvironmentTips(activity);
        TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks(getAppLifecycleCallback());
    }

    private final void exitTestEnvironment() {
        Activity activity;
        WeakReference<Activity> weakReference = currentActivity;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        TapActivityLifecycleTracker tapActivityLifecycleTracker = TapActivityLifecycleTracker.INSTANCE;
        TapComplianceInternal tapComplianceInternal = INSTANCE;
        tapActivityLifecycleTracker.unregisterActivityLifecycleCallbacks(tapComplianceInternal.getAppLifecycleCallback());
        tapComplianceInternal.hideTestEnvironmentTips(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTestEnvironmentTips(Activity activity) {
        if (isTestEnvironment && activity != null && attachState <= -1) {
            WeakReference<Activity> weakReference = currentActivity;
            if (Intrinsics.areEqual(weakReference != null ? weakReference.get() : null, activity)) {
                return;
            }
            attachState = 0;
            destActivity = new WeakReference<>(activity);
            SystemExtKt.runOnMain(new C04651(activity, null));
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceInternal$showTestEnvironmentTips$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceInternal$showTestEnvironmentTips$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04651 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04651(Activity activity, Continuation<? super C04651> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04651(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04651) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (TapComplianceInternal.attachState != 0) {
                    return Unit.INSTANCE;
                }
                WeakReference weakReference = TapComplianceInternal.currentActivity;
                if (Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, this.$activity)) {
                    return Unit.INSTANCE;
                }
                if (TapComplianceInternal.destActivity != null) {
                    WeakReference weakReference2 = TapComplianceInternal.destActivity;
                    if ((weakReference2 != null ? (Activity) weakReference2.get() : null) != this.$activity) {
                        return Unit.INSTANCE;
                    }
                }
                WindowManager windowManager = this.$activity.getWindowManager();
                WeakReference weakReference3 = TapComplianceInternal.testModeTipsView;
                if ((weakReference3 != null ? (View) weakReference3.get() : null) == null) {
                    TextView textView = new TextView(this.$activity);
                    textView.setTextColor(SupportMenu.CATEGORY_MASK);
                    textView.setText("当前处于防沉迷调试模式");
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                    TapComplianceInternal.testModeTipsView = new WeakReference(textView);
                }
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.width = UIExtKt.toPx(100.0f);
                layoutParams.height = UIExtKt.toPx(50.0f);
                layoutParams.type = 1003;
                layoutParams.token = this.$activity.getWindow().getDecorView().getWindowToken();
                layoutParams.format = -2;
                layoutParams.dimAmount = 0.0f;
                layoutParams.gravity = 8388661;
                layoutParams.flags = 58;
                WeakReference weakReference4 = TapComplianceInternal.testModeTipsView;
                windowManager.addView(weakReference4 != null ? (View) weakReference4.get() : null, layoutParams);
                TapComplianceInternal tapComplianceInternal2 = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.currentActivity = new WeakReference(this.$activity);
                TapComplianceInternal tapComplianceInternal3 = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.attachState = 1;
                TapComplianceInternal tapComplianceInternal4 = TapComplianceInternal.INSTANCE;
                TapComplianceInternal.destActivity = null;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTestEnvironmentTips(Activity activity) {
        if (activity == null || attachState < 0 || activity.isDestroyed()) {
            return;
        }
        attachState = -1;
        WeakReference<Activity> weakReference = currentActivity;
        if (Intrinsics.areEqual(weakReference != null ? weakReference.get() : null, activity)) {
            WindowManager windowManager = activity.getWindowManager();
            WeakReference<View> weakReference2 = testModeTipsView;
            windowManager.removeViewImmediate(weakReference2 != null ? weakReference2.get() : null);
        }
        currentActivity = null;
        destActivity = null;
    }
}
