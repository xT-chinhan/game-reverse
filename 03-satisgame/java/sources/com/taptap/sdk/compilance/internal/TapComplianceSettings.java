package com.taptap.sdk.compilance.internal;

import android.text.TextUtils;
import android.text.format.DateFormat;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.bean.Local;
import com.taptap.sdk.compilance.bean.RealNameConfig;
import com.taptap.sdk.compilance.bean.TimeRangeConfig;
import com.taptap.sdk.compilance.bean.TipsDesc;
import com.taptap.sdk.compilance.bean.UITipsText;
import com.taptap.sdk.compilance.bean.UserAntiConfig;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.model.UserModel;
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
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TapComplianceSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0$J\b\u0010%\u001a\u0004\u0018\u00010\fJ\b\u0010&\u001a\u0004\u0018\u00010\u0017J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020)J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00063"}, d2 = {"Lcom/taptap/sdk/compilance/internal/TapComplianceSettings;", "", "()V", "SP_KEY_AGE_LIMIT", "", "SP_KEY_REAL_NAME_CONFIG", "SP_KEY_USER_ACCESS_TOKEN", "SP_KEY_USER_ACCESS_TOKEN_V2", "SP_USER_ANTI_CONFIG_KEY", "STRATEGY_LOCAL", "TIME_RANGE_MODE", "realNameConfig", "Lcom/taptap/sdk/compilance/bean/RealNameConfig;", "getRealNameConfig", "()Lcom/taptap/sdk/compilance/bean/RealNameConfig;", "setRealNameConfig", "(Lcom/taptap/sdk/compilance/bean/RealNameConfig;)V", "cacheAccessTokenV2", "Lkotlinx/coroutines/Job;", "accessToken", "cacheRealNameConfig", "cacheUserAntiConfig", "config", "Lcom/taptap/sdk/compilance/bean/UserAntiConfig;", "clearAllCachedToken", "", "userId", "clearLegacyCachedToken", "generateAlertMessage", "", "remainTime", "", "title", SDMAdConst.NETWORK_CUSTOM_KEY.DESC, "getCachedAccessTokenV2", "getCachedLegacyAccessToken", "Lkotlin/Pair;", "getCachedRealNameConfig", "getCachedUserAntiConfig", "getFullTime", "timeInMillis", "", "getRestTime", BundleKey.DESCRIPTION, "getTimeToNightStrict", "nightStrictStartTime", "nightStrictEndTime", "serverTime", "isHoliday", "", "time", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheRealNameConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheRealNameConfig$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04711 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ RealNameConfig $realNameConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04711(RealNameConfig realNameConfig, Continuation<? super C04711> continuation) {
            super(1, continuation);
            this.$realNameConfig = realNameConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04711(this.$realNameConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04711) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TapJson tapJson = TapJson.INSTANCE;
            RealNameConfig realNameConfig = this.$realNameConfig;
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(RealNameConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, realNameConfig);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            if (strEncodeToString != null) {
                KVUtil.putString$default(KVUtil.INSTANCE, TapComplianceSettings.SP_KEY_REAL_NAME_CONFIG, strEncodeToString, null, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final Job cacheRealNameConfig(RealNameConfig realNameConfig2) {
        Intrinsics.checkNotNullParameter(realNameConfig2, "realNameConfig");
        return SystemExtKt.runAsync(new C04711(realNameConfig2, null));
    }

    public final RealNameConfig getCachedRealNameConfig() {
        TapJson tapJson = TapJson.INSTANCE;
        Object objDecodeFromString = null;
        String string$default = KVUtil.getString$default(KVUtil.INSTANCE, SP_KEY_REAL_NAME_CONFIG, null, 2, null);
        String str = string$default;
        if (!(str == null || str.length() == 0)) {
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(RealNameConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = json.decodeFromString(kSerializerSerializer, string$default);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
        }
        return (RealNameConfig) objDecodeFromString;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheAccessTokenV2$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheAccessTokenV2$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$accessToken.length() == 0) {
                return Unit.INSTANCE;
            }
            KVUtil.INSTANCE.putString(TapComplianceSettings.SP_KEY_USER_ACCESS_TOKEN_V2, this.$accessToken, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
            return Unit.INSTANCE;
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
        return new Pair<>(KVUtil.INSTANCE.getString(SP_KEY_USER_ACCESS_TOKEN, "", TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null)), Integer.valueOf(KVUtil.INSTANCE.getInt(SP_KEY_AGE_LIMIT, -1, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null))));
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

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheUserAntiConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapComplianceSettings.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.internal.TapComplianceSettings$cacheUserAntiConfig$1", f = "TapComplianceSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04721 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAntiConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04721(UserAntiConfig userAntiConfig, Continuation<? super C04721> continuation) {
            super(1, continuation);
            this.$config = userAntiConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04721(this.$config, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04721) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TapJson tapJson = TapJson.INSTANCE;
            UserAntiConfig userAntiConfig = this.$config;
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(UserAntiConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, userAntiConfig);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            if (strEncodeToString == null) {
                strEncodeToString = "";
            }
            KVUtil.INSTANCE.putString(TapComplianceSettings.SP_USER_ANTI_CONFIG_KEY, strEncodeToString, TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
            return Unit.INSTANCE;
        }
    }

    public final Job cacheUserAntiConfig(UserAntiConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return SystemExtKt.runAsync(new C04721(config, null));
    }

    public final UserAntiConfig getCachedUserAntiConfig() {
        Object objDecodeFromString = null;
        boolean z = true;
        String string = KVUtil.INSTANCE.getString(SP_USER_ANTI_CONFIG_KEY, "", TapComplianceSettingsKt.getSPNameByUserId$default(null, 1, null));
        TapJson tapJson = TapJson.INSTANCE;
        String str = string;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(UserAntiConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = json.decodeFromString(kSerializerSerializer, string);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
        }
        return (UserAntiConfig) objDecodeFromString;
    }

    public final boolean isHoliday(long time) {
        return UserModel.INSTANCE.getHolidaySet().contains(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(time)));
    }

    public final int getTimeToNightStrict(String nightStrictStartTime, String nightStrictEndTime, long serverTime) {
        Intrinsics.checkNotNullParameter(nightStrictStartTime, "nightStrictStartTime");
        Intrinsics.checkNotNullParameter(nightStrictEndTime, "nightStrictEndTime");
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceSettings tapComplianceSettings = this;
            Date date = new Date(serverTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String str = simpleDateFormat.format(date);
            String str2 = str + ' ' + nightStrictEndTime;
            Date date2 = simpleDateFormat2.parse(str + ' ' + nightStrictStartTime);
            long time = date2 != null ? date2.getTime() : 0L;
            Date date3 = simpleDateFormat2.parse(str2);
            long time2 = date3 != null ? date3.getTime() : 0L;
            if (serverTime >= time && serverTime <= time2) {
                return (int) ((time2 - serverTime) / ((long) 1000));
            }
            return 0;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m184constructorimpl(ResultKt.createFailure(th));
            return 0;
        }
    }

    public final String getFullTime(long timeInMillis) {
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceSettings tapComplianceSettings = this;
            return DateFormat.format("yyyy-MM-dd HH:mm:ss", new Date(timeInMillis)).toString();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m184constructorimpl(ResultKt.createFailure(th));
            return "";
        }
    }

    public final String getRestTime(String description, int remainTime) {
        Intrinsics.checkNotNullParameter(description, "description");
        if (remainTime < 60) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) description, "# ${remaining} #", 0, false, 6, (Object) null);
            if (iIndexOf$default < 0) {
                return description;
            }
            String strSubstring = description.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = description.substring(iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            return strSubstring + StringsKt.replace$default(StringsKt.replace$default(strSubstring2, "# ${remaining} #", String.valueOf(remainTime), false, 4, (Object) null), "分钟", "秒", false, 4, (Object) null);
        }
        return StringsKt.replace$default(description, "# ${remaining} #", String.valueOf((int) Math.ceil((((double) remainTime) * 1.0d) / ((double) 60))), false, 4, (Object) null);
    }

    public final Map<String, Object> generateAlertMessage(int remainTime, String title, String desc) {
        String description;
        TipsDesc allow;
        TipsDesc allow2;
        TipsDesc reject;
        TipsDesc reject2;
        Local local;
        TimeRangeConfig timeRange;
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(desc)) {
            UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
            desc = null;
            UITipsText text = (currentUserAntiConfig == null || (local = currentUserAntiConfig.getLocal()) == null || (timeRange = local.getTimeRange()) == null) ? null : timeRange.getText();
            if (remainTime <= 0) {
                String title2 = (text == null || (reject2 = text.getReject()) == null) ? null : reject2.getTitle();
                if (text != null && (reject = text.getReject()) != null) {
                    desc = reject.getDescription();
                }
                title = title2;
            } else {
                if (text != null && (allow2 = text.getAllow()) != null) {
                    desc = allow2.getTitle();
                }
                if (text == null || (allow = text.getAllow()) == null || (description = allow.getDescription()) == null) {
                    description = "";
                }
                String restTime = getRestTime(description, remainTime);
                title = desc;
                desc = restTime;
            }
        }
        HashMap map = new HashMap();
        if (title == null) {
            title = "";
        }
        map.put("title", title);
        map.put(BundleKey.DESCRIPTION, desc != null ? desc : "");
        return map;
    }
}
