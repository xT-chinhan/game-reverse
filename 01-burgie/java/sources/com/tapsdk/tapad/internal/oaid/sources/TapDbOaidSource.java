package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class TapDbOaidSource implements OaidSource {
    private static final String TAG = "TapDbOaidSource";
    private static final String TAPDB_HELPER_CLASS = "com.tds.tapdb.internal.OaidHelper";
    private volatile String cachedValue = "";

    private String fetchFromTapDb(Context context) {
        try {
            Method declaredMethod = Class.forName(TAPDB_HELPER_CLASS).getDeclaredMethod("getOAID", Context.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, context);
            String strValueOf = objInvoke == null ? "" : String.valueOf(objInvoke);
            String strSanitize = OaidValidator.sanitize(strValueOf);
            return (TextUtils.isEmpty(strValueOf) || !TextUtils.isEmpty(strSanitize)) ? strSanitize : "";
        } catch (Exception e) {
            return "";
        }
    }

    private void notifyCallback(OaidSource.OaidFetchCallback oaidFetchCallback, String str) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(Context context, OaidSource.OaidFetchCallback oaidFetchCallback) {
        long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        if (!TextUtils.isEmpty(this.cachedValue)) {
            notifyCallback(oaidFetchCallback, this.cachedValue);
            return;
        }
        String strFetchFromTapDb = fetchFromTapDb(context);
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        if (!TextUtils.isEmpty(strFetchFromTapDb)) {
            this.cachedValue = strFetchFromTapDb;
        }
        notifyCallback(oaidFetchCallback, strFetchFromTapDb);
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        return this.cachedValue;
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "TapDB";
    }
}
