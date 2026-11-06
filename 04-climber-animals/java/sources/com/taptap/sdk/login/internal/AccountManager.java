package com.taptap.sdk.login.internal;

import com.anythink.core.common.e.f;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.taptap.sdk.kit.internal.utils.KVUtil;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapAccountInternal;
import com.taptap.sdk.login.internal.legacy.MigrationHelper;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: AccountManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0010@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/internal/AccountManager;", "", "()V", "SP_ACCOUNT_KEY", "", "SP_ACCOUNT_KEY_INTERNAL", "SP_MIGRATION_PROFILE_KEY", "SP_MIGRATION_TOKEN_KEY", "SP_NAME", f.a.d, "Lcom/taptap/sdk/login/TapTapAccount;", "account", "getAccount", "()Lcom/taptap/sdk/login/TapTapAccount;", "setAccount", "(Lcom/taptap/sdk/login/TapTapAccount;)V", "Lcom/taptap/sdk/login/TapTapAccountInternal;", "accountInternal", "getAccountInternal$tap_login_release", "()Lcom/taptap/sdk/login/TapTapAccountInternal;", "setAccountInternal$tap_login_release", "(Lcom/taptap/sdk/login/TapTapAccountInternal;)V", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "Lkotlin/Lazy;", "clearCache", "", TrackAction.INIT, "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccountManager {
    public static final AccountManager INSTANCE = new AccountManager();
    private static final String SP_ACCOUNT_KEY = "taptap_account";
    private static final String SP_ACCOUNT_KEY_INTERNAL = "taptap_account_internal";
    private static final String SP_MIGRATION_PROFILE_KEY = "profile";
    private static final String SP_MIGRATION_TOKEN_KEY = "token_data";
    private static final String SP_NAME = "taptap_sharepreference";
    private static TapTapAccount account;
    private static TapTapAccountInternal accountInternal;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;

    private AccountManager() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.login.internal.AccountManager$special$$inlined$inject$1
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
    }

    private final OpenLogService getOpenLogService() {
        return (OpenLogService) openLogService.getValue();
    }

    public final TapTapAccount getAccount() {
        return account;
    }

    public final void setAccount(TapTapAccount tapTapAccount) {
        String strEncodeToString;
        account = tapTapAccount;
        if (tapTapAccount != null) {
            KVUtil kVUtil = KVUtil.INSTANCE;
            try {
                Json json = TapJson.INSTANCE.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapAccount.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, tapTapAccount);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            kVUtil.putString(SP_ACCOUNT_KEY, strEncodeToString, SP_NAME);
        }
        getOpenLogService().setOpenId(tapTapAccount != null ? tapTapAccount.getOpenId() : null);
    }

    public final TapTapAccountInternal getAccountInternal$tap_login_release() {
        return accountInternal;
    }

    public final void setAccountInternal$tap_login_release(TapTapAccountInternal tapTapAccountInternal) {
        String strEncodeToString;
        accountInternal = tapTapAccountInternal;
        if (tapTapAccountInternal != null) {
            KVUtil kVUtil = KVUtil.INSTANCE;
            try {
                Json json = TapJson.INSTANCE.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapAccountInternal.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, tapTapAccountInternal);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            kVUtil.putString(SP_ACCOUNT_KEY_INTERNAL, strEncodeToString, SP_NAME);
        }
        getOpenLogService().setOpenId(tapTapAccountInternal != null ? tapTapAccountInternal.getOpenId() : null);
    }

    public final void init() {
        TapTapAccount tapTapAccountMigrate;
        Object objDecodeFromString;
        String string = KVUtil.INSTANCE.getString(SP_ACCOUNT_KEY_INTERNAL, SP_NAME);
        Object objDecodeFromString2 = null;
        if (string != null) {
            AccountManager accountManager = INSTANCE;
            TapJson tapJson = TapJson.INSTANCE;
            if (string.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapAccountInternal.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, string);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    objDecodeFromString = null;
                }
            }
            accountManager.setAccountInternal$tap_login_release((TapTapAccountInternal) objDecodeFromString);
        }
        String string2 = KVUtil.INSTANCE.getString(SP_ACCOUNT_KEY, SP_NAME);
        if (string2 != null) {
            AccountManager accountManager2 = INSTANCE;
            TapJson tapJson2 = TapJson.INSTANCE;
            if (!(string2.length() == 0)) {
                try {
                    Json json2 = tapJson2.getJson();
                    KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.typeOf(TapTapAccount.class));
                    Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString2 = json2.decodeFromString(kSerializerSerializer2, string2);
                } catch (Exception e2) {
                    TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                }
            }
            accountManager2.setAccount((TapTapAccount) objDecodeFromString2);
            objDecodeFromString2 = Unit.INSTANCE;
        }
        if (objDecodeFromString2 == null) {
            String string3 = KVUtil.INSTANCE.getString(SP_MIGRATION_TOKEN_KEY, SP_NAME);
            String string4 = KVUtil.INSTANCE.getString(SP_MIGRATION_PROFILE_KEY, SP_NAME);
            if (string3 == null || string4 == null || (tapTapAccountMigrate = MigrationHelper.INSTANCE.migrate(string3, string4)) == null) {
                return;
            }
            setAccount(tapTapAccountMigrate);
        }
    }

    public final void clearCache() {
        KVUtil.INSTANCE.remove(SP_ACCOUNT_KEY, SP_NAME);
        KVUtil.INSTANCE.remove(SP_ACCOUNT_KEY_INTERNAL, SP_NAME);
        KVUtil.INSTANCE.remove(SP_MIGRATION_TOKEN_KEY, SP_NAME);
        KVUtil.INSTANCE.remove(SP_MIGRATION_PROFILE_KEY, SP_NAME);
        setAccount(null);
        setAccountInternal$tap_login_release(null);
    }
}
