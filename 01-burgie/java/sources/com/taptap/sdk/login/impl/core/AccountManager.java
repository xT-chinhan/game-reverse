package com.taptap.sdk.login.impl.core;

import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.repository.LoginRepository;
import com.taptap.sdk.login.impl.storage.AccountStorage;
import com.taptap.sdk.login.impl.storage.MigrationAccountStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AccountManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH\u0002J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/login/impl/core/AccountManager;", "", "builder", "Lcom/taptap/sdk/login/impl/core/AccountManager$Builder;", "(Lcom/taptap/sdk/login/impl/core/AccountManager$Builder;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "repository", "Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/taptap/sdk/login/impl/repository/LoginRepository;)V", "storage", "Lcom/taptap/sdk/login/impl/storage/AccountStorage;", "clearCache", "", "getAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "getPrivateTapSdkAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "initialize", "refreshToken", "saveAccount", "account", "savePrivateTapSdkAccount", "Builder", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccountManager {
    private static volatile Builder BUILDER;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile AccountManager INSTANCE;
    private final LoginRepository repository;
    private final CoroutineScope scope;
    private final AccountStorage storage;

    public /* synthetic */ AccountManager(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AccountManager(CoroutineScope scope, LoginRepository repository) {
        this.scope = scope;
        this.repository = repository;
        this.storage = MigrationAccountStorage.INSTANCE.getInstance();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private AccountManager(Builder builder) {
        CoroutineScope scope = builder.getScope();
        if (scope == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        LoginRepository repository = builder.getRepository();
        if (repository != null) {
            this(scope, repository);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void saveAccount(TapTapAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.storage.saveAccount(account);
    }

    public final TapTapAccount getAccount() {
        return this.storage.getAccount();
    }

    public final void savePrivateTapSdkAccount(PrivateTapSdkAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.storage.savePrivateTapSdkAccount(account);
    }

    public final PrivateTapSdkAccount getPrivateTapSdkAccount() {
        return this.storage.getPrivateTapSdkAccount();
    }

    public final void initialize() {
        this.storage.initialize();
        refreshToken();
    }

    public final void clearCache() {
        this.storage.clearCache();
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.AccountManager$refreshToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccountManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.impl.core.AccountManager$refreshToken$1", f = "AccountManager.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 th;
            AnonymousClass1 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    try {
                        if (AccountManager.this.getAccount() == null && AccountManager.this.getPrivateTapSdkAccount() == null) {
                            return Unit.INSTANCE;
                        }
                        anonymousClass1.label = 1;
                        Object objLoginByToken = AccountManager.this.repository.loginByToken(anonymousClass1);
                        if (objLoginByToken == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objLoginByToken;
                        try {
                            PrivateTapSdkAccount privateTapSdkAccount = (PrivateTapSdkAccount) $result;
                            AccountManager.this.saveAccount(privateTapSdkAccount.convertAsTapTapAccount());
                            AccountManager.this.savePrivateTapSdkAccount(privateTapSdkAccount);
                            break;
                        } catch (Throwable th2) {
                            AnonymousClass1 anonymousClass3 = anonymousClass1;
                            th = th2;
                            $result = $result;
                            anonymousClass2 = anonymousClass3;
                            if ((th instanceof TapNetworkException) && Intrinsics.areEqual(((TapNetworkException) th).getErr().getApiErr(), ApiErr.INVALID_GRANT.INSTANCE)) {
                                AccountManager.this.clearCache();
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable $result2) {
                        th = $result2;
                        anonymousClass2 = anonymousClass1;
                        if (th instanceof TapNetworkException) {
                            AccountManager.this.clearCache();
                        }
                        return Unit.INSTANCE;
                    }
                case 1:
                    anonymousClass2 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = anonymousClass2;
                        PrivateTapSdkAccount privateTapSdkAccount2 = (PrivateTapSdkAccount) $result;
                        AccountManager.this.saveAccount(privateTapSdkAccount2.convertAsTapTapAccount());
                        AccountManager.this.savePrivateTapSdkAccount(privateTapSdkAccount2);
                        break;
                    } catch (Throwable th3) {
                        th = th3;
                        if (th instanceof TapNetworkException) {
                            AccountManager.this.clearCache();
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void refreshToken() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: compiled from: AccountManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0006R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/impl/core/AccountManager$Builder;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "repository", "getRepository$tap_login_release", "()Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "applyRepository", "loginRepository", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private LoginRepository repository;
        private final CoroutineScope scope;

        public Builder(CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        /* JADX INFO: renamed from: getRepository$tap_login_release, reason: from getter */
        public final LoginRepository getRepository() {
            return this.repository;
        }

        public final Builder applyRepository(LoginRepository loginRepository) {
            Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
            Builder $this$applyRepository_u24lambda_u240 = this;
            $this$applyRepository_u24lambda_u240.repository = loginRepository;
            return this;
        }
    }

    /* JADX INFO: compiled from: AccountManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/core/AccountManager$Companion;", "", "()V", "BUILDER", "Lcom/taptap/sdk/login/impl/core/AccountManager$Builder;", "INSTANCE", "Lcom/taptap/sdk/login/impl/core/AccountManager;", "applyBuilder", "", "builder", "configure", "create", "getInstance", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccountManager configure(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            applyBuilder(builder);
            return getInstance();
        }

        public final AccountManager getInstance() {
            AccountManager it;
            AccountManager accountManager = AccountManager.INSTANCE;
            if (accountManager != null) {
                return accountManager;
            }
            synchronized (this) {
                it = AccountManager.INSTANCE;
                if (it == null) {
                    it = AccountManager.INSTANCE.create();
                    Companion companion = AccountManager.INSTANCE;
                    AccountManager.INSTANCE = it;
                }
            }
            return it;
        }

        private final void applyBuilder(Builder builder) {
            AccountManager.BUILDER = builder;
        }

        private final AccountManager create() {
            Builder builder = AccountManager.BUILDER;
            if (builder == null) {
                throw new IllegalStateException("AccountManager must be configured before use. Call AccountManager.configure() first.".toString());
            }
            return new AccountManager(builder, (DefaultConstructorMarker) null);
        }
    }
}
