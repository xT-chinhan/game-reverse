package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import com.tapsdk.tapad.internal.oaid.OaidHelper;
import com.tapsdk.tapad.internal.oaid.OaidSource;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.impl.GmsImpl;
import com.tapsdk.tapad.oaid.impl.OAIDFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class GaidSource implements OaidSource {
    private static final AtomicBoolean PROCESS_FETCH_ATTEMPTED = new AtomicBoolean(false);
    private static final String TAG = "GaidSource";
    private final AtomicBoolean fetchAttempted;
    private final GmsProviderFactory providerFactory;

    public interface GmsProviderFactory {
        IOAID create(Context context);
    }

    public GaidSource() {
        this(new GmsProviderFactory() { // from class: com.tapsdk.tapad.internal.oaid.sources.GaidSource$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.oaid.sources.GaidSource.GmsProviderFactory
            public final IOAID create(Context context) {
                return new GmsImpl(context);
            }
        }, PROCESS_FETCH_ATTEMPTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(OaidSource.OaidFetchCallback oaidFetchCallback, String str) {
        if (oaidFetchCallback != null) {
            oaidFetchCallback.onComplete(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public void fetchAsync(final Context context, final OaidSource.OaidFetchCallback oaidFetchCallback) {
        final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (!OaidHelper.getInstance().isGaidCollectionAllowed()) {
            notifyCallback(oaidFetchCallback, "");
            return;
        }
        String cached = getCached();
        if (!isEmpty(cached)) {
            notifyCallback(oaidFetchCallback, cached);
            return;
        }
        if (!this.fetchAttempted.compareAndSet(false, true)) {
            notifyCallback(oaidFetchCallback, getCached());
            return;
        }
        try {
            IOAID ioaidCreate = this.providerFactory.create(context);
            ioaidCreate.supported();
            ioaidCreate.doGet(new IGetter() { // from class: com.tapsdk.tapad.internal.oaid.sources.GaidSource.1
                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    OAIDFactory factory;
                    String strSanitize = OaidValidator.sanitize(str);
                    if (!OaidHelper.getInstance().isGaidCollectionAllowed() || !AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
                        GaidSource.this.fetchAttempted.set(false);
                        GaidSource.this.notifyCallback(oaidFetchCallback, "");
                    } else {
                        if (!GaidSource.isEmpty(strSanitize) && (factory = OaidSourceHelper.getFactory(context)) != null) {
                            factory.setGaid(strSanitize);
                        }
                        GaidSource.this.notifyCallback(oaidFetchCallback, strSanitize);
                    }
                }

                @Override // com.tapsdk.tapad.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    OAIDFactory factory = OaidSourceHelper.getFactory(context);
                    if (factory != null) {
                        factory.reportOAIDException(exc);
                    }
                    GaidSource.this.notifyCallback(oaidFetchCallback, "");
                }
            });
        } catch (Exception e) {
            notifyCallback(oaidFetchCallback, "");
        }
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getCached() {
        String str;
        return (OaidHelper.getInstance().isGaidCollectionAllowed() && (str = OAIDFactory.gaid) != null) ? str : "";
    }

    @Override // com.tapsdk.tapad.internal.oaid.OaidSource
    public String getName() {
        return "GAID";
    }

    public GaidSource(GmsProviderFactory gmsProviderFactory) {
        this(gmsProviderFactory, new AtomicBoolean(false));
    }

    public GaidSource(GmsProviderFactory gmsProviderFactory, AtomicBoolean atomicBoolean) {
        this.providerFactory = gmsProviderFactory;
        this.fetchAttempted = atomicBoolean;
    }
}
