package com.taptap.sdk.login.impl.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.taptap.sdk.base.utils.prefs.SharedPreferenceDelegate;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.utils.MigrationHelper;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MigrationAccountStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0001J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0011\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001bH\u0096\u0001J\b\u0010 \u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/login/impl/storage/MigrationAccountStorage;", "Lcom/taptap/sdk/login/impl/storage/AccountStorage;", "delegate", "prefs", "Landroid/content/SharedPreferences;", "(Lcom/taptap/sdk/login/impl/storage/AccountStorage;Landroid/content/SharedPreferences;)V", "<set-?>", "", "legacyProfile", "getLegacyProfile", "()Ljava/lang/String;", "setLegacyProfile", "(Ljava/lang/String;)V", "legacyProfile$delegate", "Lcom/taptap/sdk/base/utils/prefs/SharedPreferenceDelegate;", "legacyToken", "getLegacyToken", "setLegacyToken", "legacyToken$delegate", "migrationChecked", "", "clearCache", "", "clearLegacyData", "getAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "getPrivateTapSdkAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "initialize", "saveAccount", "account", "savePrivateTapSdkAccount", "tryMigrateLegacyData", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MigrationAccountStorage implements AccountStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MigrationAccountStorage.class, "legacyToken", "getLegacyToken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MigrationAccountStorage.class, "legacyProfile", "getLegacyProfile()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile MigrationAccountStorage INSTANCE = null;
    private static final String LEGACY_PROFILE_KEY = "profile";
    private static final String LEGACY_TOKEN_KEY = "token_data";
    private static final String SP_NAME = "taptap_sharepreference";
    private final AccountStorage delegate;

    /* JADX INFO: renamed from: legacyProfile$delegate, reason: from kotlin metadata */
    private final SharedPreferenceDelegate legacyProfile;

    /* JADX INFO: renamed from: legacyToken$delegate, reason: from kotlin metadata */
    private final SharedPreferenceDelegate legacyToken;
    private volatile boolean migrationChecked;

    public /* synthetic */ MigrationAccountStorage(AccountStorage accountStorage, SharedPreferences sharedPreferences, DefaultConstructorMarker defaultConstructorMarker) {
        this(accountStorage, sharedPreferences);
    }

    @JvmStatic
    public static final MigrationAccountStorage getInstance() {
        return INSTANCE.getInstance();
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public PrivateTapSdkAccount getPrivateTapSdkAccount() {
        return this.delegate.getPrivateTapSdkAccount();
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void saveAccount(TapTapAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.delegate.saveAccount(account);
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void savePrivateTapSdkAccount(PrivateTapSdkAccount account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.delegate.savePrivateTapSdkAccount(account);
    }

    private MigrationAccountStorage(AccountStorage delegate, SharedPreferences prefs) {
        this.delegate = delegate;
        this.legacyToken = new SharedPreferenceDelegate(prefs, LEGACY_TOKEN_KEY, "");
        this.legacyProfile = new SharedPreferenceDelegate(prefs, LEGACY_PROFILE_KEY, "");
    }

    private final String getLegacyToken() {
        return (String) this.legacyToken.getValue(this, $$delegatedProperties[0]);
    }

    private final void setLegacyToken(String str) {
        this.legacyToken.setValue(this, $$delegatedProperties[0], str);
    }

    private final String getLegacyProfile() {
        return (String) this.legacyProfile.getValue(this, $$delegatedProperties[1]);
    }

    private final void setLegacyProfile(String str) {
        this.legacyProfile.setValue(this, $$delegatedProperties[1], str);
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public TapTapAccount getAccount() {
        TapTapAccount account = this.delegate.getAccount();
        if (account == null && !this.migrationChecked) {
            this.migrationChecked = true;
            tryMigrateLegacyData();
            return this.delegate.getAccount();
        }
        return account;
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void clearCache() {
        this.delegate.clearCache();
        clearLegacyData();
    }

    @Override // com.taptap.sdk.login.impl.storage.AccountStorage
    public void initialize() {
        this.delegate.initialize();
        if (!this.migrationChecked) {
            this.migrationChecked = true;
            tryMigrateLegacyData();
        }
    }

    private final void tryMigrateLegacyData() {
        if (getLegacyToken().length() == 0) {
            return;
        }
        if (getLegacyProfile().length() == 0) {
            return;
        }
        try {
            TapTapAccount migratedAccount = MigrationHelper.INSTANCE.migrate(getLegacyToken(), getLegacyProfile());
            if (migratedAccount != null) {
                this.delegate.saveAccount(migratedAccount);
                clearLegacyData();
            }
        } catch (Throwable th) {
        }
    }

    private final void clearLegacyData() {
        setLegacyToken("");
        setLegacyProfile("");
    }

    /* JADX INFO: compiled from: MigrationAccountStorage.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/storage/MigrationAccountStorage$Companion;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/login/impl/storage/MigrationAccountStorage;", "LEGACY_PROFILE_KEY", "", "LEGACY_TOKEN_KEY", "SP_NAME", "create", d.R, "Landroid/content/Context;", "getInstance", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MigrationAccountStorage getInstance() {
            MigrationAccountStorage it;
            MigrationAccountStorage migrationAccountStorage = MigrationAccountStorage.INSTANCE;
            if (migrationAccountStorage == null) {
                synchronized (this) {
                    it = MigrationAccountStorage.INSTANCE;
                    if (it == null) {
                        it = MigrationAccountStorage.INSTANCE.create(TapTapKit.INSTANCE.getContext());
                        Companion companion = MigrationAccountStorage.INSTANCE;
                        MigrationAccountStorage.INSTANCE = it;
                    }
                }
                return it;
            }
            return migrationAccountStorage;
        }

        private final MigrationAccountStorage create(Context context) {
            SharedPreferences prefs = context.getSharedPreferences(MigrationAccountStorage.SP_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
            return new MigrationAccountStorage(new BaseAccountStorage(prefs), prefs, null);
        }
    }
}
