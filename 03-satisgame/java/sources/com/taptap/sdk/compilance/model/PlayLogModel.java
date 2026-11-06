package com.taptap.sdk.compilance.model;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.taptap.sdk.compilance.api.IdentityVerifyApi;
import com.taptap.sdk.compilance.bean.AntiPolicy;
import com.taptap.sdk.compilance.bean.CheckPlayResult;
import com.taptap.sdk.compilance.bean.Local;
import com.taptap.sdk.compilance.bean.TimeRangeConfig;
import com.taptap.sdk.compilance.bean.TipsDesc;
import com.taptap.sdk.compilance.bean.UITipsText;
import com.taptap.sdk.compilance.bean.UserAntiConfig;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.http.TapTime;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayLogModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b0\nJ \u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00110\u0010J<\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b0\n2\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/compilance/model/PlayLogModel;", "", "()V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "checkPlayableLocally", "Lkotlin/Triple;", "", "Lcom/taptap/sdk/compilance/bean/CheckPlayResult;", "checkUserState", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lkotlin/Pair;", "uploadPlayLogSync", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PlayLogModel {
    public static final PlayLogModel INSTANCE = new PlayLogModel();
    private static String sessionId = "";

    private PlayLogModel() {
    }

    public final String getSessionId() {
        return sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        sessionId = str;
    }

    public final void checkUserState(TapTapCallback<Pair<Boolean, CheckPlayResult>> callback) {
        AntiPolicy antiAddiction;
        Intrinsics.checkNotNullParameter(callback, "callback");
        UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
        if (Intrinsics.areEqual((currentUserAntiConfig == null || (antiAddiction = currentUserAntiConfig.getAntiAddiction()) == null) ? null : antiAddiction.getPolicyModel(), "local") && Intrinsics.areEqual(currentUserAntiConfig.getAntiAddiction().getPolicyActive(), TapComplianceSettings.TIME_RANGE_MODE)) {
            Triple<Boolean, CheckPlayResult, Boolean> tripleCheckPlayableLocally = checkPlayableLocally();
            callback.onSuccess(new Pair<>(tripleCheckPlayableLocally.getFirst(), tripleCheckPlayableLocally.getSecond()));
        } else {
            SystemExtKt.runAsync(new AnonymousClass1(callback, null));
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.model.PlayLogModel$checkUserState$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayLogModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.model.PlayLogModel$checkUserState$1", f = "PlayLogModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<Pair<Boolean, CheckPlayResult>> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapTapCallback<Pair<Boolean, CheckPlayResult>> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PlayLogModel playLogModel = PlayLogModel.INSTANCE;
            final TapTapCallback<Pair<Boolean, CheckPlayResult>> tapTapCallback = this.$callback;
            playLogModel.uploadPlayLogSync((TapTapCallback) new TapTapCallback<Triple<? extends Boolean, ? extends CheckPlayResult, ? extends Boolean>>() { // from class: com.taptap.sdk.compilance.model.PlayLogModel.checkUserState.1.1
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onCancel() {
                    TapTapCallback.DefaultImpls.onCancel(this);
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public /* bridge */ /* synthetic */ void onSuccess(Triple<? extends Boolean, ? extends CheckPlayResult, ? extends Boolean> triple) {
                    onSuccess2((Triple<Boolean, CheckPlayResult, Boolean>) triple);
                }

                /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
                public void onSuccess2(Triple<Boolean, CheckPlayResult, Boolean> data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    tapTapCallback.onSuccess(new Pair<>(data.getFirst(), data.getSecond()));
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onFail(TapTapException exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    tapTapCallback.onFail(exception);
                }
            });
            return Unit.INSTANCE;
        }
    }

    public final Triple<Boolean, CheckPlayResult, Boolean> checkPlayableLocally() {
        int timeToNightStrict;
        String timeStart;
        String timeEnd;
        TimeRangeConfig timeRange;
        TimeRangeConfig timeRange2;
        TimeRangeConfig timeRange3;
        UITipsText text;
        String title;
        String description;
        TimeRangeConfig timeRange4;
        UITipsText text2;
        UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
        TipsDesc reject = null;
        Local local = currentUserAntiConfig != null ? currentUserAntiConfig.getLocal() : null;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        String str = "";
        if (currentUser != null && currentUser.isAdult()) {
            timeToNightStrict = AVMDLDataLoader.KeyIsEnableEventInfo;
        } else if (TapComplianceSettings.INSTANCE.isHoliday(new Date().getTime())) {
            TapComplianceSettings tapComplianceSettings = TapComplianceSettings.INSTANCE;
            if (local == null || (timeRange2 = local.getTimeRange()) == null || (timeStart = timeRange2.getTimeStart()) == null) {
                timeStart = "";
            }
            if (local == null || (timeRange = local.getTimeRange()) == null || (timeEnd = timeRange.getTimeEnd()) == null) {
                timeEnd = "";
            }
            timeToNightStrict = tapComplianceSettings.getTimeToNightStrict(timeStart, timeEnd, TapTime.INSTANCE.getCurrentTimeInMillis());
        } else {
            timeToNightStrict = 0;
        }
        UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
        if (currentUser2 != null) {
            currentUser2.resetRemainTime(timeToNightStrict);
        }
        CheckPlayResult checkPlayResult = new CheckPlayResult(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        checkPlayResult.setRemainTime(timeToNightStrict);
        if (timeToNightStrict > 0) {
            if (local != null && (timeRange4 = local.getTimeRange()) != null && (text2 = timeRange4.getText()) != null) {
                reject = text2.getAllow();
            }
        } else if (local != null && (timeRange3 = local.getTimeRange()) != null && (text = timeRange3.getText()) != null) {
            reject = text.getReject();
        }
        if (reject == null || (title = reject.getTitle()) == null) {
            title = "";
        }
        checkPlayResult.setTitle(title);
        TapComplianceSettings tapComplianceSettings2 = TapComplianceSettings.INSTANCE;
        if (reject != null && (description = reject.getDescription()) != null) {
            str = description;
        }
        checkPlayResult.setDescription(tapComplianceSettings2.getRestTime(str, timeToNightStrict));
        UserInfo currentUser3 = UserModel.INSTANCE.getCurrentUser();
        if (currentUser3 != null && currentUser3.isAdult()) {
            return new Triple<>(false, checkPlayResult, true);
        }
        return new Triple<>(true, checkPlayResult, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple uploadPlayLogSync$default(PlayLogModel playLogModel, TapTapCallback tapTapCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            tapTapCallback = null;
        }
        return playLogModel.uploadPlayLogSync(tapTapCallback);
    }

    public final Triple<Boolean, CheckPlayResult, Boolean> uploadPlayLogSync(final TapTapCallback<Triple<Boolean, CheckPlayResult, Boolean>> callback) {
        Object objM184constructorimpl;
        AntiPolicy antiAddiction;
        Triple<Boolean, CheckPlayResult, Boolean> triple = new Triple<>(false, new CheckPlayResult(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null), false);
        try {
            Result.Companion companion = Result.INSTANCE;
            PlayLogModel playLogModel = this;
            objM184constructorimpl = Result.m184constructorimpl(IdentityVerifyApi.INSTANCE.checkPlay(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compilance.model.PlayLogModel$uploadPlayLogSync$1$1
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onCancel() {
                    TapTapCallback.DefaultImpls.onCancel(this);
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(CheckPlayResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                    if (currentUser != null) {
                        currentUser.resetRemainTime(result.getRemainTime());
                    }
                    UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
                    if (currentUser2 != null && currentUser2.isAdult()) {
                        TapTapCallback<Triple<Boolean, CheckPlayResult, Boolean>> tapTapCallback = callback;
                        if (tapTapCallback != null) {
                            tapTapCallback.onSuccess(new Triple<>(false, result, false));
                            return;
                        }
                        return;
                    }
                    TapTapCallback<Triple<Boolean, CheckPlayResult, Boolean>> tapTapCallback2 = callback;
                    if (tapTapCallback2 != null) {
                        tapTapCallback2.onSuccess(new Triple<>(true, result, false));
                    }
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onFail(TapTapException exception) {
                    AntiPolicy antiAddiction2;
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
                    if (Intrinsics.areEqual((currentUserAntiConfig == null || (antiAddiction2 = currentUserAntiConfig.getAntiAddiction()) == null) ? null : antiAddiction2.getPolicyActive(), TapComplianceSettings.TIME_RANGE_MODE)) {
                        TapTapCallback<Triple<Boolean, CheckPlayResult, Boolean>> tapTapCallback = callback;
                        if (tapTapCallback != null) {
                            tapTapCallback.onSuccess(this.checkPlayableLocally());
                            return;
                        }
                        return;
                    }
                    throw new RuntimeException(exception);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            thM187exceptionOrNullimpl.printStackTrace();
            UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
            if (!Intrinsics.areEqual((currentUserAntiConfig == null || (antiAddiction = currentUserAntiConfig.getAntiAddiction()) == null) ? null : antiAddiction.getPolicyActive(), TapComplianceSettings.TIME_RANGE_MODE)) {
                throw new RuntimeException(thM187exceptionOrNullimpl);
            }
            if (callback != null) {
                callback.onSuccess(INSTANCE.checkPlayableLocally());
            }
        }
        return triple;
    }
}
