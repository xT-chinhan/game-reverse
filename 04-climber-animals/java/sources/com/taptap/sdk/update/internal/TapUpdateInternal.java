package com.taptap.sdk.update.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapSdkException;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.taptap.sdk.update.TapTapUpdateCallback;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import com.taptap.sdk.update.constants.LoggerConst;
import com.taptap.sdk.update.dialog.TapForceUpdateDialog;
import com.taptap.sdk.update.dialog.TapUpdateDialogManager;
import com.taptap.sdk.update.extension.SystemExtKt;
import com.taptap.sdk.update.network.UpdateApiService;
import com.taptap.sdk.update.network.UpdateRepository;
import com.taptap.sdk.update.utils.UIUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.json.JSONException;

/* JADX INFO: compiled from: TapUpdateInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0015J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/taptap/sdk/update/internal/TapUpdateInternal;", "", "()V", "apiRepository", "Lcom/taptap/sdk/update/network/UpdateRepository;", "hasInitialed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageReceiver", "Lcom/taptap/sdk/update/internal/TapUpdatePackageReceiver;", "getPackageReceiver", "()Lcom/taptap/sdk/update/internal/TapUpdatePackageReceiver;", "packageReceiver$delegate", "Lkotlin/Lazy;", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "setRegionType", "(Lcom/taptap/sdk/initializer/api/model/RegionType;)V", "updateCallbacks", "", "Lcom/taptap/sdk/update/TapTapUpdateCallback;", "checkForceUpdate", "", "checkInit", TrackAction.INIT, "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "notifyUpdateCancel", "registerPackageInstallReceiver", "registerUpdateCallback", "callback", "showForceUpdateDialog", "Lkotlinx/coroutines/Job;", "result", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "unregisterUpdateCallback", "updateGame", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateInternal {
    private static UpdateRepository apiRepository;
    public static final TapUpdateInternal INSTANCE = new TapUpdateInternal();
    private static RegionType regionType = RegionType.CN;
    private static AtomicBoolean hasInitialed = new AtomicBoolean(false);
    private static final List<TapTapUpdateCallback> updateCallbacks = new ArrayList();

    /* JADX INFO: renamed from: packageReceiver$delegate, reason: from kotlin metadata */
    private static final Lazy packageReceiver = LazyKt.lazy(new Function0<TapUpdatePackageReceiver>() { // from class: com.taptap.sdk.update.internal.TapUpdateInternal$packageReceiver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapUpdatePackageReceiver invoke() {
            return new TapUpdatePackageReceiver();
        }
    });

    private TapUpdateInternal() {
    }

    public final RegionType getRegionType() {
        return regionType;
    }

    public final void setRegionType(RegionType regionType2) {
        Intrinsics.checkNotNullParameter(regionType2, "<set-?>");
        regionType = regionType2;
    }

    private final TapUpdatePackageReceiver getPackageReceiver() {
        return (TapUpdatePackageReceiver) packageReceiver.getValue();
    }

    public final void init(TapTapSdkOptions options) throws JSONException {
        Intrinsics.checkNotNullParameter(options, "options");
        UpdateTracker.INSTANCE.trackInitialize();
        hasInitialed.set(true);
        regionType = options.getRegion();
        Object objCreate = NetworkClientKt.provideRetrofit("https://" + TapUpdateApiKt.getHost(), options).create(UpdateApiService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "provideRetrofit(\n       …teApiService::class.java)");
        apiRepository = new UpdateRepository((UpdateApiService) objCreate);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateInternal$checkForceUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapUpdateInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateInternal$checkForceUpdate$1", f = "TapUpdateInternal.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0045  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UpdateTracker.INSTANCE.updateSessionId();
                UpdateTracker.INSTANCE.trackStart$tap_update_release("checkForceUpdate");
                UpdateRepository updateRepository = TapUpdateInternal.apiRepository;
                if (updateRepository != null) {
                    this.label = 1;
                    if (updateRepository.checkForceUpdate(new TapTapCallback<ForceUpdateResult>() { // from class: com.taptap.sdk.update.internal.TapUpdateInternal.checkForceUpdate.1.1
                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onCancel() {
                            TapTapCallback.DefaultImpls.onCancel(this);
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onSuccess(ForceUpdateResult result) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            UpdateTracker.INSTANCE.setGameId(String.valueOf(result.getAppId()));
                            UpdateTracker.INSTANCE.trackSuccess$tap_update_release("checkForceUpdate");
                            if (result.getUpdateType() == 1) {
                                TapUpdateDialogManager.INSTANCE.setForceUpdateInfo(result);
                                TapUpdateInternal.INSTANCE.showForceUpdateDialog(result);
                            }
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onFail(TapTapException exception) throws JSONException {
                            Intrinsics.checkNotNullParameter(exception, "exception");
                            TapUpdateLoggerKt.logError(exception.getMessage(), exception);
                            SystemExtKt.runOnMain(new TapUpdateInternal$checkForceUpdate$1$1$onFail$1(null));
                            UpdateTracker.INSTANCE.trackFail$tap_update_release("checkForceUpdate", -1, exception.getMessage());
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    unit = null;
                }
                if (unit == null) {
                    TapUpdateInternal tapUpdateInternal = TapUpdateInternal.INSTANCE;
                    UpdateTracker.INSTANCE.trackFail$tap_update_release("checkForceUpdate", Boxing.boxInt(-1), "apiRepository is null");
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            unit = Unit.INSTANCE;
            if (unit == null) {
                TapUpdateInternal tapUpdateInternal2 = TapUpdateInternal.INSTANCE;
                UpdateTracker.INSTANCE.trackFail$tap_update_release("checkForceUpdate", Boxing.boxInt(-1), "apiRepository is null");
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkForceUpdate() {
        SystemExtKt.runAsync(new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateInternal$showForceUpdateDialog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapUpdateInternal.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateInternal$showForceUpdateDialog$1", f = "TapUpdateInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08351 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ForceUpdateResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08351(ForceUpdateResult forceUpdateResult, Continuation<? super C08351> continuation) {
            super(1, continuation);
            this.$result = forceUpdateResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08351(this.$result, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C08351) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final Activity topActivity = TapActivityLifecycleTracker.getTopActivity();
            if (topActivity != null) {
                final ForceUpdateResult forceUpdateResult = this.$result;
                new TapForceUpdateDialog(topActivity, forceUpdateResult, new Function0<Unit>() { // from class: com.taptap.sdk.update.internal.TapUpdateInternal$showForceUpdateDialog$1$1$dialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() throws JSONException {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() throws JSONException {
                        if (!SysExtKt.isTapInstalled()) {
                            TapUpdateInternal.INSTANCE.registerPackageInstallReceiver();
                            TapUpdateDialogManager.INSTANCE.showDownloadDialog(topActivity, forceUpdateResult.getAppInfo(), forceUpdateResult.getLinks(), forceUpdateResult.getDownload().getUrl());
                        } else {
                            TapUpdateDialogManager.INSTANCE.updateInTapApp(topActivity, LoggerConst.OBJECT_TYPE_UPDATE);
                        }
                    }
                }).show();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job showForceUpdateDialog(ForceUpdateResult result) {
        return SystemExtKt.runOnMain(new C08351(result, null));
    }

    public final void updateGame(Activity activity, TapTapUpdateCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkInit();
        if (UIUtil.INSTANCE.isFastClick()) {
            return;
        }
        if (!SysExtKt.isTapInstalled()) {
            registerPackageInstallReceiver();
        }
        updateCallbacks.clear();
        registerUpdateCallback(callback);
        TapUpdateDialogManager.INSTANCE.startUpdateGame(activity);
    }

    public final void registerUpdateCallback(TapTapUpdateCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkInit();
        List<TapTapUpdateCallback> list = updateCallbacks;
        if (list.contains(callback)) {
            return;
        }
        list.add(callback);
    }

    public final void unregisterUpdateCallback(TapTapUpdateCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        updateCallbacks.remove(callback);
    }

    public final void notifyUpdateCancel() {
        checkInit();
        for (Object obj : updateCallbacks.toArray(new TapTapUpdateCallback[0])) {
            ((TapTapUpdateCallback) obj).onCancel();
        }
    }

    private final void checkInit() {
        if (!hasInitialed.get()) {
            throw new TapSdkException("TapUpdate must be initialed, call init() first !");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerPackageInstallReceiver() {
        Object objM174constructorimpl;
        checkInit();
        try {
            Result.Companion companion = Result.INSTANCE;
            TapUpdateInternal tapUpdateInternal = this;
            Context context = TapTapKit.INSTANCE.getContext();
            context.getApplicationContext().unregisterReceiver(getPackageReceiver());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            objM174constructorimpl = Result.m174constructorimpl(context.getApplicationContext().registerReceiver(getPackageReceiver(), intentFilter));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            TapLogger.loge$default(TapUpdateLoggerKt.LOGGER_TAG, "register package install receiver error, cause" + thM177exceptionOrNullimpl.getMessage(), null, 4, null);
        }
    }
}
