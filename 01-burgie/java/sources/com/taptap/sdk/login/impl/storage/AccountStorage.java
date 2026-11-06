package com.taptap.sdk.login.impl.storage;

import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapTapAccount;
import kotlin.Metadata;

/* JADX INFO: compiled from: AccountStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/login/impl/storage/AccountStorage;", "", "clearCache", "", "getAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "getPrivateTapSdkAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "initialize", "saveAccount", "account", "savePrivateTapSdkAccount", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface AccountStorage {
    void clearCache();

    TapTapAccount getAccount();

    PrivateTapSdkAccount getPrivateTapSdkAccount();

    void initialize();

    void saveAccount(TapTapAccount account);

    void savePrivateTapSdkAccount(PrivateTapSdkAccount account);
}
