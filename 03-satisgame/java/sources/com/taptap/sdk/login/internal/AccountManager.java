package com.taptap.sdk.login.internal;

import com.anythink.core.common.f.e;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.service.CoreService;
import com.taptap.sdk.kit.internal.utils.KVUtil;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.internal.legacy.MigrationHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: AccountManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/login/internal/AccountManager;", "Lorg/koin/core/component/KoinComponent;", "()V", "SP_ACCOUNT_KEY", "", "SP_MIGRATION_PROFILE_KEY", "SP_MIGRATION_TOKEN_KEY", "SP_NAME", e.a.d, "Lcom/taptap/sdk/login/TapTapAccount;", "account", "getAccount", "()Lcom/taptap/sdk/login/TapTapAccount;", "setAccount", "(Lcom/taptap/sdk/login/TapTapAccount;)V", "coreService", "Lcom/taptap/sdk/kit/internal/service/CoreService;", "getCoreService", "()Lcom/taptap/sdk/kit/internal/service/CoreService;", "coreService$delegate", "Lkotlin/Lazy;", "clearCache", "", "init", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccountManager implements KoinComponent {
    public static final AccountManager INSTANCE;
    private static final String SP_ACCOUNT_KEY = "taptap_account";
    private static final String SP_MIGRATION_PROFILE_KEY = "profile";
    private static final String SP_MIGRATION_TOKEN_KEY = "token_data";
    private static final String SP_NAME = "taptap_sharepreference";
    private static TapTapAccount account;

    /* JADX INFO: renamed from: coreService$delegate, reason: from kotlin metadata */
    private static final Lazy coreService;

    private AccountManager() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AccountManager accountManager = new AccountManager();
        INSTANCE = accountManager;
        final AccountManager accountManager2 = accountManager;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        coreService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<CoreService>() { // from class: com.taptap.sdk.login.internal.AccountManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.kit.internal.service.CoreService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CoreService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = accountManager2;
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
    }

    private final CoreService getCoreService() {
        return (CoreService) coreService.getValue();
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
        getCoreService().setOpenId(tapTapAccount != null ? tapTapAccount.getOpenId() : null);
    }

    public final void init() {
        TapTapAccount tapTapAccountMigrate;
        String string = KVUtil.INSTANCE.getString(SP_ACCOUNT_KEY, SP_NAME);
        Object objDecodeFromString = null;
        if (string != null) {
            AccountManager accountManager = INSTANCE;
            TapJson tapJson = TapJson.INSTANCE;
            if (!(string.length() == 0)) {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapAccount.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, string);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                }
            }
            accountManager.setAccount((TapTapAccount) objDecodeFromString);
            objDecodeFromString = Unit.INSTANCE;
        }
        if (objDecodeFromString == null) {
            String string2 = KVUtil.INSTANCE.getString(SP_MIGRATION_TOKEN_KEY, SP_NAME);
            String string3 = KVUtil.INSTANCE.getString("profile", SP_NAME);
            if (string2 == null || string3 == null || (tapTapAccountMigrate = MigrationHelper.INSTANCE.migrate(string2, string3)) == null) {
                return;
            }
            setAccount(tapTapAccountMigrate);
        }
    }

    public final void clearCache() {
        KVUtil.INSTANCE.remove(SP_ACCOUNT_KEY, SP_NAME);
        KVUtil.INSTANCE.remove(SP_MIGRATION_TOKEN_KEY, SP_NAME);
        KVUtil.INSTANCE.remove("profile", SP_NAME);
        setAccount(null);
    }
}
