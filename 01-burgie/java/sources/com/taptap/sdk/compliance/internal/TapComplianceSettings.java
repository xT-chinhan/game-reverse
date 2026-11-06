package com.taptap.sdk.compliance.internal;

import android.text.TextUtils;
import android.text.format.DateFormat;
import com.taptap.sdk.compliance.bean.Local;
import com.taptap.sdk.compliance.bean.RealNameConfig;
import com.taptap.sdk.compliance.bean.TimeRangeConfig;
import com.taptap.sdk.compliance.bean.TipsDesc;
import com.taptap.sdk.compliance.bean.UITipsText;
import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.utils.KVUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: TapComplianceSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0$J\b\u0010%\u001a\u0004\u0018\u00010\fJ\b\u0010&\u001a\u0004\u0018\u00010\u0017J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020)J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00063"}, d2 = {"Lcom/taptap/sdk/compliance/internal/TapComplianceSettings;", "", "()V", "SP_KEY_AGE_LIMIT", "", "SP_KEY_REAL_NAME_CONFIG", "SP_KEY_USER_ACCESS_TOKEN", "SP_KEY_USER_ACCESS_TOKEN_V2", "SP_USER_ANTI_CONFIG_KEY", "STRATEGY_LOCAL", "TIME_RANGE_MODE", "realNameConfig", "Lcom/taptap/sdk/compliance/bean/RealNameConfig;", "getRealNameConfig", "()Lcom/taptap/sdk/compliance/bean/RealNameConfig;", "setRealNameConfig", "(Lcom/taptap/sdk/compliance/bean/RealNameConfig;)V", "cacheAccessTokenV2", "Lkotlinx/coroutines/Job;", "accessToken", "cacheRealNameConfig", "cacheUserAntiConfig", "config", "Lcom/taptap/sdk/compliance/bean/UserAntiConfig;", "clearAllCachedToken", "", "userId", "clearLegacyCachedToken", "generateAlertMessage", "", "remainTime", "", BundleKey.TITLE, "desc", "getCachedAccessTokenV2", "getCachedLegacyAccessToken", "Lkotlin/Pair;", "getCachedRealNameConfig", "getCachedUserAntiConfig", "getFullTime", "timeInMillis", "", "getRestTime", BundleKey.DESCRIPTION, "getTimeToNightStrict", "nightStrictStartTime", "nightStrictEndTime", "serverTime", "isHoliday", "", "time", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceSettings {
    public static final TapComplianceSettings INSTANCE = new TapComplianceSettings();
    private static final String SP_KEY_AGE_LIMIT = "age_limit";
    private static final String SP_KEY_REAL_NAME_CONFIG = "realNameTipKey";
    private static final String SP_KEY_USER_ACCESS_TOKEN = "access_token";
    private static final String SP_KEY_USER_ACCESS_TOKEN_V2 = "access_token_v2";
    private static final String SP_USER_ANTI_CONFIG_KEY = "userAntiConfigKey";
    public static final String STRATEGY_LOCAL = "local";
    public static final String TIME_RANGE_MODE = "time_range";
    private static RealNameConfig realNameConfig;

    private TapComplianceSettings() {
    }

    public final RealNameConfig getRealNameConfig() {
        return realNameConfig;
    }

    public final void setRealNameConfig(RealNameConfig realNameConfig2) {
        realNameConfig = realNameConfig2;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheRealNameConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheRealNameConfig$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03191 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ RealNameConfig $realNameConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03191(RealNameConfig realNameConfig, Continuation<? super C03191> continuation) {
            super(1, continuation);
            this.$realNameConfig = realNameConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03191(this.$realNameConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03191) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String $this$invokeSuspend_u24lambda_u240;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    TapJson this_$iv = TapJson.INSTANCE;
                    RealNameConfig realNameConfig = this.$realNameConfig;
                    try {
                        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(RealNameConfig.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        $this$invokeSuspend_u24lambda_u240 = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, realNameConfig);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        $this$invokeSuspend_u24lambda_u240 = null;
                    }
                    if ($this$invokeSuspend_u24lambda_u240 != null) {
                        KVUtil.putString$default(KVUtil.INSTANCE, TapComplianceSettings.SP_KEY_REAL_NAME_CONFIG, $this$invokeSuspend_u24lambda_u240, null, 4, null);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job cacheRealNameConfig(RealNameConfig realNameConfig2) {
        Intrinsics.checkNotNullParameter(realNameConfig2, "realNameConfig");
        return SystemExtKt.runAsync(new C03191(realNameConfig2, null));
    }

    public final RealNameConfig getCachedRealNameConfig() {
        TapJson this_$iv = TapJson.INSTANCE;
        Object objDecodeFromString = null;
        String jsonString$iv = KVUtil.getString$default(KVUtil.INSTANCE, SP_KEY_REAL_NAME_CONFIG, null, 2, null);
        String str = jsonString$iv;
        if (!(str == null || str.length() == 0)) {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(RealNameConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, jsonString$iv);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
        }
        return (RealNameConfig) objDecodeFromString;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheAccessTokenV2$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheAccessTokenV2$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accessToken;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$accessToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$accessToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (this.$accessToken.length() == 0) {
                        return Unit.INSTANCE;
                    }
                    KVUtil.INSTANCE.putString(TapComplianceSettings.SP_KEY_USER_ACCESS_TOKEN_V2, this.$accessToken, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job cacheAccessTokenV2(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return SystemExtKt.runAsync(new AnonymousClass1(accessToken, null));
    }

    public final String getCachedAccessTokenV2() {
        return KVUtil.INSTANCE.getString(SP_KEY_USER_ACCESS_TOKEN_V2, "", TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
    }

    public final Pair<String, Integer> getCachedLegacyAccessToken() {
        int limit = KVUtil.INSTANCE.getInt(SP_KEY_AGE_LIMIT, -1, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
        String legacyToken = KVUtil.INSTANCE.getString(SP_KEY_USER_ACCESS_TOKEN, "", TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
        return new Pair<>(legacyToken, Integer.valueOf(limit));
    }

    public final void clearLegacyCachedToken(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        KVUtil.INSTANCE.putString(SP_KEY_USER_ACCESS_TOKEN, "", TapComplianceSettingsKt.getSPNameByUserId(userId));
        KVUtil.INSTANCE.putInt(SP_KEY_AGE_LIMIT, -1, TapComplianceSettingsKt.getSPNameByUserId(userId));
    }

    public final void clearAllCachedToken(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        KVUtil.INSTANCE.putString(SP_KEY_USER_ACCESS_TOKEN, "", TapComplianceSettingsKt.getSPNameByUserId(userId));
        KVUtil.INSTANCE.putString(SP_KEY_USER_ACCESS_TOKEN_V2, "", TapComplianceSettingsKt.getSPNameByUserId(userId));
        KVUtil.INSTANCE.putString(SP_USER_ANTI_CONFIG_KEY, "", TapComplianceSettingsKt.getSPNameByUserId(userId));
        KVUtil.INSTANCE.putInt(SP_KEY_AGE_LIMIT, -1, TapComplianceSettingsKt.getSPNameByUserId(userId));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheUserAntiConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceSettings$cacheUserAntiConfig$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03201 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAntiConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03201(UserAntiConfig userAntiConfig, Continuation<? super C03201> continuation) {
            super(1, continuation);
            this.$config = userAntiConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03201(this.$config, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03201) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    TapJson this_$iv = TapJson.INSTANCE;
                    UserAntiConfig userAntiConfig = this.$config;
                    try {
                        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(UserAntiConfig.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, userAntiConfig);
                        break;
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        strEncodeToString = null;
                    }
                    if (strEncodeToString == null) {
                        strEncodeToString = "";
                    }
                    String configString = strEncodeToString;
                    KVUtil.INSTANCE.putString(TapComplianceSettings.SP_USER_ANTI_CONFIG_KEY, configString, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job cacheUserAntiConfig(UserAntiConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return SystemExtKt.runAsync(new C03201(config, null));
    }

    public final UserAntiConfig getCachedUserAntiConfig() {
        Object objDecodeFromString = null;
        boolean z = true;
        String cachedString = KVUtil.INSTANCE.getString(SP_USER_ANTI_CONFIG_KEY, "", TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
        TapJson this_$iv = TapJson.INSTANCE;
        String str = cachedString;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(UserAntiConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, cachedString);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
        }
        return (UserAntiConfig) objDecodeFromString;
    }

    public final boolean isHoliday(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateString = formatter.format(new Date(time));
        return UserModel.INSTANCE.getHolidaySet().contains(dateString);
    }

    public final int getTimeToNightStrict(String nightStrictStartTime, String nightStrictEndTime, long serverTime) {
        Intrinsics.checkNotNullParameter(nightStrictStartTime, "nightStrictStartTime");
        Intrinsics.checkNotNullParameter(nightStrictEndTime, "nightStrictEndTime");
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceSettings tapComplianceSettings = this;
            Date now = new Date(serverTime);
            SimpleDateFormat formatToDay = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dStr = formatToDay.format(now);
            String strictStartStr = dStr + ' ' + nightStrictStartTime;
            String strictEndStr = dStr + ' ' + nightStrictEndTime;
            Date date = formatToDate.parse(strictStartStr);
            long strictStartValue = date != null ? date.getTime() : 0L;
            Date date2 = formatToDate.parse(strictEndStr);
            long strictEndValue = date2 != null ? date2.getTime() : 0L;
            if (serverTime >= strictStartValue && serverTime <= strictEndValue) {
                return (int) ((strictEndValue - serverTime) / ((long) 1000));
            }
            return 0;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m534constructorimpl(ResultKt.createFailure(th));
            return 0;
        }
    }

    public final String getFullTime(long timeInMillis) {
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceSettings tapComplianceSettings = this;
            CharSequence date = DateFormat.format("yyyy-MM-dd HH:mm:ss", new Date(timeInMillis));
            return date.toString();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m534constructorimpl(ResultKt.createFailure(th));
            return "";
        }
    }

    public final String getRestTime(String description, int remainTime) {
        Intrinsics.checkNotNullParameter(description, "description");
        if (remainTime >= 60) {
            int minuets = (int) Math.ceil((((double) remainTime) * 1.0d) / ((double) 60));
            String result = StringsKt.replace$default(description, "# ${remaining} #", String.valueOf(minuets), false, 4, (Object) null);
            return result;
        }
        int index = StringsKt.indexOf$default((CharSequence) description, "# ${remaining} #", 0, false, 6, (Object) null);
        if (index < 0) {
            return description;
        }
        String substring1 = description.substring(0, index);
        Intrinsics.checkNotNullExpressionValue(substring1, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = description.substring(index);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        String result2 = substring1 + StringsKt.replace$default(StringsKt.replace$default(substring2, "# ${remaining} #", String.valueOf(remainTime), false, 4, (Object) null), "分钟", "秒", false, 4, (Object) null);
        return result2;
    }

    public final Map<String, Object> generateAlertMessage(int remainTime, String title, String desc) {
        String description;
        TipsDesc allow;
        TipsDesc allow2;
        TipsDesc reject;
        TipsDesc reject2;
        Local local;
        TimeRangeConfig timeRange;
        String validTitle = title;
        String validContent = desc;
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(desc)) {
            UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
            String title2 = null;
            UITipsText tipText = (currentUserAntiConfig == null || (local = currentUserAntiConfig.getLocal()) == null || (timeRange = local.getTimeRange()) == null) ? null : timeRange.getText();
            if (remainTime <= 0) {
                validTitle = (tipText == null || (reject2 = tipText.getReject()) == null) ? null : reject2.getTitle();
                if (tipText != null && (reject = tipText.getReject()) != null) {
                    title2 = reject.getDescription();
                }
                validContent = title2;
            } else {
                if (tipText != null && (allow2 = tipText.getAllow()) != null) {
                    title2 = allow2.getTitle();
                }
                validTitle = title2;
                if (tipText == null || (allow = tipText.getAllow()) == null || (description = allow.getDescription()) == null) {
                    description = "";
                }
                validContent = getRestTime(description, remainTime);
            }
        }
        Map result = new HashMap();
        result.put(BundleKey.TITLE, validTitle == null ? "" : validTitle);
        result.put(BundleKey.DESCRIPTION, validContent != null ? validContent : "");
        return result;
    }
}
