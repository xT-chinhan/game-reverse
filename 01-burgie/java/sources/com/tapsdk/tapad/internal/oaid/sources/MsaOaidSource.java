package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.impl.MsaImpl;
import com.tapsdk.tapad.oaid.impl.OAIDFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class MsaOaidSource implements OaidSource {
    private static final String TAG = "MsaOaidSource";

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(OaidSource.OaidFetchCallback oaidFetchCallback, String str) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(final Context context, final OaidSource.OaidFetchCallback oaidFetchCallback) {
        final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        MsaImpl msaImpl = new MsaImpl(context);
        try {
            msaImpl.supported();
            msaImpl.doGet(new IGetter() { // from class: com.tapsdk.tapad.internal.oaid.sources.MsaOaidSource.1
                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    OAIDFactory factory;
                    if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
                        MsaOaidSource.this.notifyCallback(oaidFetchCallback, "");
                        return;
                    }
                    String strSanitize = OaidValidator.sanitize(str);
                    if (!TextUtils.isEmpty(strSanitize) && (factory = OaidSourceHelper.getFactory(context)) != null) {
                        factory.setMsaOaid(strSanitize);
                    }
                    MsaOaidSource.this.notifyCallback(oaidFetchCallback, strSanitize);
                }

                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    OAIDFactory factory = OaidSourceHelper.getFactory(context);
                    if (factory != null) {
                        factory.reportOAIDException(exc);
                    }
                    MsaOaidSource.this.notifyCallback(oaidFetchCallback, "");
                }
            });
        } catch (Exception e) {
            notifyCallback(oaidFetchCallback, "");
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        String str = OAIDFactory.msaOaid;
        return str != null ? str : "";
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "MSA";
    }
}
