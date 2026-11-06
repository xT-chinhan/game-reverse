package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.oaid.ExpOAIDClient;
import com.tapsdk.tapad.internal.oaid.OAIDResult;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class HostAppOaidSource implements OaidSource {
    private static final String TAG = "HostAppOaidSource";
    private final ExpOAIDClient client = new ExpOAIDClient();
    private volatile String cachedValue = "";

    private void notifyCallback(OaidSource.OaidFetchCallback oaidFetchCallback, String str) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(final Context context, final OaidSource.OaidFetchCallback oaidFetchCallback) {
        final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            notifyCallback(oaidFetchCallback, "");
        } else if (TextUtils.isEmpty(this.cachedValue)) {
            this.client.init(new ExpOAIDClient.InitListener() { // from class: com.tapsdk.tapad.internal.oaid.sources.HostAppOaidSource$$ExternalSyntheticLambda1
                @Override // com.tapsdk.tapad.internal.oaid.ExpOAIDClient.InitListener
                public final void onResult(OAIDResult oAIDResult) {
                    this.f$0.m186lambda$fetchAsync$1$comtapsdktapadinternaloaidsourcesHostAppOaidSource(jOaidGeneration, oaidFetchCallback, context, oAIDResult);
                }
            }, context);
        } else {
            notifyCallback(oaidFetchCallback, this.cachedValue);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        return this.cachedValue;
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "HostApp";
    }

    /* JADX INFO: renamed from: lambda$fetchAsync$0$com-tapsdk-tapad-internal-oaid-sources-HostAppOaidSource, reason: not valid java name */
    /* synthetic */ void m185lambda$fetchAsync$0$comtapsdktapadinternaloaidsourcesHostAppOaidSource(long j, OaidSource.OaidFetchCallback oaidFetchCallback, OAIDResult oAIDResult, String str) {
        if (!AndroidPrivacyPolicy.allowsOaidResult(j)) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        if (oAIDResult.getResponseCode() != 0) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        String strSanitize = OaidValidator.sanitize(str);
        if (!TextUtils.isEmpty(strSanitize)) {
            this.cachedValue = strSanitize;
        }
        notifyCallback(oaidFetchCallback, strSanitize);
    }

    /* JADX INFO: renamed from: lambda$fetchAsync$1$com-tapsdk-tapad-internal-oaid-sources-HostAppOaidSource, reason: not valid java name */
    /* synthetic */ void m186lambda$fetchAsync$1$comtapsdktapadinternaloaidsourcesHostAppOaidSource(final long j, final OaidSource.OaidFetchCallback oaidFetchCallback, Context context, OAIDResult oAIDResult) {
        if (!AndroidPrivacyPolicy.allowsOaidResult(j)) {
            notifyCallback(oaidFetchCallback, "");
        } else if (oAIDResult.getResponseCode() != 0) {
            notifyCallback(oaidFetchCallback, "");
        } else {
            this.client.fetchOAID(new ExpOAIDClient.FetchOAIDListener() { // from class: com.tapsdk.tapad.internal.oaid.sources.HostAppOaidSource$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.internal.oaid.ExpOAIDClient.FetchOAIDListener
                public final void onResult(OAIDResult oAIDResult2, String str) {
                    this.f$0.m185lambda$fetchAsync$0$comtapsdktapadinternaloaidsourcesHostAppOaidSource(j, oaidFetchCallback, oAIDResult2, str);
                }
            }, context);
        }
    }
}
