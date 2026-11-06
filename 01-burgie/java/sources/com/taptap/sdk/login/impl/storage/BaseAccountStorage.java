package com.taptap.sdk.login.impl.storage;

import android.content.SharedPreferences;
import com.taptap.sdk.base.utils.prefs.SharedPreferenceDelegate;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: BaseAccountStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001dH\u0016R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/taptap/sdk/login/impl/storage/BaseAccountStorage;", "Lcom/taptap/sdk/login/impl/storage/AccountStorage;", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "<set-?>", "", "accountInternalJson", "getAccountInternalJson", "()Ljava/lang/String;", "setAccountInternalJson", "(Ljava/lang/String;)V", "accountInternalJson$delegate", "Lcom/taptap/sdk/base/utils/prefs/SharedPreferenceDelegate;", "accountJson", "getAccountJson", "setAccountJson", "accountJson$delegate", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "Lkotlin/Lazy;", "clearCache", "", "getAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "getPrivateTapSdkAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "initialize", "saveAccount", "account", "savePrivateTapSdkAccount", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BaseAccountStorage implements AccountStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BaseAccountStorage.class, "accountJson", "getAccountJson()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BaseAccountStorage.class, "accountInternalJson", "getAccountInternalJson()Ljava/lang/String;", 0))};
    private static final String KEY_ACCOUNT = "taptap_account";
    private static final String KEY_ACCOUNT_INTERNAL = "taptap_account_internal";

    /* JADX INFO: renamed from: accountInternalJson$delegate, reason: from kotlin metadata */
    private final SharedPreferenceDelegate accountInternalJson;

    /* JADX INFO: renamed from: accountJson$delegate, reason: from kotlin metadata */
    private final SharedPreferenceDelegate accountJson;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private final Lazy openLogService;

    public BaseAccountStorage(SharedPreferences prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        this.openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.login.impl.storage.BaseAccountStorage$special$$inlined$inject$1
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
        this.accountJson = new SharedPreferenceDelegate(prefs, KEY_ACCOUNT, "");
        this.accountInternalJson = new SharedPreferenceDelegate(prefs, KEY_ACCOUNT_INTERNAL, "");
    }

    private final OpenLogService getOpenLogService() {
        return (OpenLogService) this.openLogService.getValue();
    }

    private final String getAccountJson() {
        return (String) this.accountJson.getValue(this, $$delegatedProperties[0]);
    }

    private final void setAccountJson(String str) {
        this.accountJson.setValue(this, $$delegatedProperties[0], str);
    }

    private final String getAccountInternalJson() {
        return (String) this.accountInternalJson.getValue(this, $$delegatedProperties[1]);
    }

    private final void setAccountInternalJson(String str) {
        this.accountInternalJson.setValue(this, $$delegatedProperties[1], str);
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void saveAccount(TapTapAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        TapJson this_$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(TapTapAccount.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, account);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        if (strEncodeToString != null) {
            String value = strEncodeToString;
            setAccountJson(value);
        }
        getOpenLogService().login(account.getOpenId());
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public TapTapAccount getAccount() {
        TapJson this_$iv = TapJson.INSTANCE;
        String jsonString$iv = getAccountJson();
        String str = jsonString$iv;
        Object objDecodeFromString = null;
        if (!(str == null || str.length() == 0)) {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.nullableTypeOf(TapTapAccount.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, jsonString$iv);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
        }
        return (TapTapAccount) objDecodeFromString;
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void savePrivateTapSdkAccount(PrivateTapSdkAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        TapJson this_$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(PrivateTapSdkAccount.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, account);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        if (strEncodeToString != null) {
            String value = strEncodeToString;
            setAccountInternalJson(value);
        }
        getOpenLogService().login(account.getOpenId());
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public PrivateTapSdkAccount getPrivateTapSdkAccount() {
        TapJson this_$iv = TapJson.INSTANCE;
        String jsonString$iv = getAccountInternalJson();
        String str = jsonString$iv;
        Object objDecodeFromString = null;
        if (!(str == null || str.length() == 0)) {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.nullableTypeOf(PrivateTapSdkAccount.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, jsonString$iv);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
        }
        return (PrivateTapSdkAccount) objDecodeFromString;
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void clearCache() {
        setAccountJson("");
        setAccountInternalJson("");
        getOpenLogService().logout();
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void initialize() {
        TapTapAccount account = getAccount();
        if (account != null) {
            getOpenLogService().login(account.getOpenId());
        }
        PrivateTapSdkAccount privateTapSdkAccount = getPrivateTapSdkAccount();
        if (privateTapSdkAccount != null) {
            getOpenLogService().login(privateTapSdkAccount.getOpenId());
        }
    }
}
