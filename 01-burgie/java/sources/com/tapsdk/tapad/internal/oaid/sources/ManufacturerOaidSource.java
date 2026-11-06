package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.impl.OAIDFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class ManufacturerOaidSource implements OaidSource {
    private static final String TAG = "ManufacturerOaidSource";

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(OaidSource.OaidFetchCallback oaidFetchCallback, String str) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(Context context, final OaidSource.OaidFetchCallback oaidFetchCallback) {
        final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        final OAIDFactory factory = OaidSourceHelper.getFactory(context);
        if (factory == null) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        IOAID ioaidCreateManufacturerImpl = OAIDFactory.createManufacturerImpl(context);
        if (ioaidCreateManufacturerImpl == null) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        try {
            ioaidCreateManufacturerImpl.supported();
            ioaidCreateManufacturerImpl.doGet(new IGetter() { // from class: com.tapsdk.tapad.internal.oaid.sources.ManufacturerOaidSource.1
                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
                        ManufacturerOaidSource.this.notifyCallback(oaidFetchCallback, "");
                        return;
                    }
                    String strSanitize = OaidValidator.sanitize(str);
                    if (!TextUtils.isEmpty(strSanitize)) {
                        factory.setOAID(strSanitize);
                    }
                    ManufacturerOaidSource.this.notifyCallback(oaidFetchCallback, strSanitize);
                }

                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    factory.reportOAIDException(exc);
                    ManufacturerOaidSource.this.notifyCallback(oaidFetchCallback, "");
                }
            });
        } catch (Exception e) {
            factory.reportOAIDException(e);
            notifyCallback(oaidFetchCallback, "");
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        String str = OAIDFactory.oaid;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Context context = AppContextHolder.get();
        if (context != null) {
            OaidSourceHelper.getFactory(context);
            str = OAIDFactory.oaid;
        }
        return str != null ? str : "";
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "Manufacturer";
    }
}
