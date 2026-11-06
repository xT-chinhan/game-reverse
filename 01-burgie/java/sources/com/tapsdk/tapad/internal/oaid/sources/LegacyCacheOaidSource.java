package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.storage.SafeSP;
import com.tapsdk.tapad.oaid.impl.OAIDCrypto;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyCacheOaidSource implements OaidSource {
    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(Context context, OaidSource.OaidFetchCallback oaidFetchCallback) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(getCached());
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        Context context;
        String strDecrypt;
        SafeSP sp = SafeSP.getSP(Constants.CacheKeys.PREFERENCES_NAME);
        if (sp == null) {
            return "";
        }
        String string = sp.getString(Constants.CacheKeys.DEVICE_ID, "");
        return (string.isEmpty() || (context = AppContextHolder.get()) == null || (strDecrypt = OAIDCrypto.decrypt(string, OAIDCrypto.deriveKey(context.getPackageName()))) == null) ? sp.getString("oaid", "") : strDecrypt;
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "LegacyCache";
    }
}
