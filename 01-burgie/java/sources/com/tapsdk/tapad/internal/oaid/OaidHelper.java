package com.tapsdk.tapad.internal.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.group.ads.DirichletAd$$ExternalSyntheticBackportWithForwarding0;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.oaid.sources.GaidSource;
import com.tapsdk.tapad.internal.oaid.sources.HostAppOaidSource;
import com.tapsdk.tapad.internal.oaid.sources.LegacyCacheOaidSource;
import com.tapsdk.tapad.internal.oaid.sources.ManufacturerOaidSource;
import com.tapsdk.tapad.internal.oaid.sources.MsaOaidSource;
import com.tapsdk.tapad.internal.oaid.sources.TapDbOaidSource;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.internal.runtime.PrivacyFactCache;
import com.tapsdk.tapad.internal.storage.SafeSP;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.tapsdk.tapad.oaid.impl.OAIDCrypto;
import com.tapsdk.tapad.oaid.impl.OAIDFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class OaidHelper {
    private final AtomicBoolean fallbackFetchInProgress;
    private final OaidSourceChain fallbackSourceChain;
    private volatile boolean gaidCollectionAllowed;
    private final GaidSource gaidSource;
    private final HostAppOaidSource hostAppSource;
    private final LegacyCacheOaidSource legacyCacheSource;
    private final ManufacturerOaidSource manufacturerSource;
    private final MsaOaidSource msaSource;
    private final AtomicBoolean providerFetchInProgress;
    private final OaidSourceChain providerSourceChain;
    private final PrivacyFactCache<Boolean> refreshAttempts;
    private final AtomicReference<OaidSnapshot> snapshot;
    private final OaidSourceChain sourceChain;
    private final TapDbOaidSource tapDbSource;

    public static final class Holder {
        static final OaidHelper INSTANCE = new OaidHelper();

        private Holder() {
        }
    }

    public static OaidHelper getInstance() {
        return Holder.INSTANCE;
    }

    private void prefetchFallbackOaids(final Context context) {
        if (AndroidPrivacyPolicy.allowsOaid() && TextUtils.isEmpty(getOaid()) && this.fallbackFetchInProgress.compareAndSet(false, true)) {
            final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
            if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m181lambda$prefetchFallbackOaids$4$comtapsdktapadinternaloaidOaidHelper(jOaidGeneration, context);
                }
            })) {
                return;
            }
            this.fallbackFetchInProgress.set(false);
        }
    }

    private void prefetchProviderOaids(final Context context) {
        if (AndroidPrivacyPolicy.allowsOaid() && this.providerFetchInProgress.compareAndSet(false, true)) {
            final long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
            if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m183lambda$prefetchProviderOaids$2$comtapsdktapadinternaloaidOaidHelper(jOaidGeneration, context);
                }
            })) {
                return;
            }
            this.providerFetchInProgress.set(false);
        }
    }

    private void refreshProviderOaids() {
        OaidSnapshot oaidSnapshot;
        String cached = this.manufacturerSource.getCached();
        String cached2 = this.msaSource.getCached();
        do {
            oaidSnapshot = this.snapshot.get();
        } while (!DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(this.snapshot, oaidSnapshot, oaidSnapshot.withProviderOaids(cached2, cached)));
    }

    private Context safeContext(Context context) {
        if (context != null) {
            return context.getApplicationContext();
        }
        if (AppContextHolder.appContext != null) {
            return AppContextHolder.appContext;
        }
        return null;
    }

    private void updateDeveloperOaid(String str) {
        OaidSnapshot oaidSnapshot;
        do {
            oaidSnapshot = this.snapshot.get();
        } while (!DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(this.snapshot, oaidSnapshot, oaidSnapshot.withDeveloperOaid(str)));
    }

    public void cacheCustomOaid(String str) {
        String strEncrypt;
        if (AndroidPrivacyPolicy.allowsOaid()) {
            String strSanitize = OaidValidator.sanitize(str);
            updateDeveloperOaid(strSanitize);
            if (TextUtils.isEmpty(strSanitize)) {
                return;
            }
            SafeSP sp = SafeSP.getSP(Constants.CacheKeys.PREFERENCES_NAME);
            Context context = AppContextHolder.get();
            if (sp == null || context == null || (strEncrypt = OAIDCrypto.encrypt(strSanitize, OAIDCrypto.deriveKey(context.getPackageName()))) == null) {
                return;
            }
            sp.putString(Constants.CacheKeys.DEVICE_ID, strEncrypt);
            sp.remove("oaid");
        }
    }

    public String getGaid() {
        return !AndroidPrivacyPolicy.allowsOaid() ? "" : this.gaidSource.getCached();
    }

    public String getOaid() {
        if (!AndroidPrivacyPolicy.allowsOaid()) {
            return "";
        }
        String developerOaid = this.snapshot.get().getDeveloperOaid();
        return !developerOaid.isEmpty() ? developerOaid : this.sourceChain.getBestAvailable();
    }

    public String getOaidManufacturer() {
        return !AndroidPrivacyPolicy.allowsOaid() ? "" : this.manufacturerSource.getCached();
    }

    public OaidSnapshot getSnapshot() {
        if (!AndroidPrivacyPolicy.allowsOaid()) {
            return new OaidSnapshot("", "", "");
        }
        refreshProviderOaids();
        return this.snapshot.get();
    }

    public boolean isGaidCollectionAllowed() {
        return this.gaidCollectionAllowed && AndroidPrivacyPolicy.allowsOaid();
    }

    /* JADX INFO: renamed from: lambda$prefetchFallbackOaids$3$com-tapsdk-tapad-internal-oaid-OaidHelper, reason: not valid java name */
    /* synthetic */ void m180lambda$prefetchFallbackOaids$3$comtapsdktapadinternaloaidOaidHelper() {
        this.fallbackFetchInProgress.set(false);
    }

    /* JADX INFO: renamed from: lambda$prefetchFallbackOaids$4$com-tapsdk-tapad-internal-oaid-OaidHelper, reason: not valid java name */
    /* synthetic */ void m181lambda$prefetchFallbackOaids$4$comtapsdktapadinternaloaidOaidHelper(long j, Context context) {
        try {
            if (AndroidPrivacyPolicy.allowsOaidResult(j)) {
                this.fallbackSourceChain.prefetchAll(context, new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m180lambda$prefetchFallbackOaids$3$comtapsdktapadinternaloaidOaidHelper();
                    }
                });
            } else {
                this.fallbackFetchInProgress.set(false);
            }
        } catch (Throwable th) {
            this.fallbackFetchInProgress.set(false);
        }
    }

    /* JADX INFO: renamed from: lambda$prefetchProviderOaids$1$com-tapsdk-tapad-internal-oaid-OaidHelper, reason: not valid java name */
    /* synthetic */ void m182lambda$prefetchProviderOaids$1$comtapsdktapadinternaloaidOaidHelper(long j) {
        try {
            if (AndroidPrivacyPolicy.allowsOaidResult(j)) {
                refreshProviderOaids();
            }
            this.providerFetchInProgress.set(false);
        } catch (Throwable th) {
            this.providerFetchInProgress.set(false);
        }
    }

    /* JADX INFO: renamed from: lambda$prefetchProviderOaids$2$com-tapsdk-tapad-internal-oaid-OaidHelper, reason: not valid java name */
    /* synthetic */ void m183lambda$prefetchProviderOaids$2$comtapsdktapadinternaloaidOaidHelper(final long j, Context context) {
        try {
            if (AndroidPrivacyPolicy.allowsOaidResult(j)) {
                this.providerSourceChain.prefetchAll(context, new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m182lambda$prefetchProviderOaids$1$comtapsdktapadinternaloaidOaidHelper(j);
                    }
                });
            } else {
                this.providerFetchInProgress.set(false);
            }
        } catch (Throwable th) {
            this.providerFetchInProgress.set(false);
        }
    }

    /* JADX INFO: renamed from: lambda$refreshForAdRequest$0$com-tapsdk-tapad-internal-oaid-OaidHelper, reason: not valid java name */
    /* synthetic */ Boolean m184lambda$refreshForAdRequest$0$comtapsdktapadinternaloaidOaidHelper(TapAdCustomController tapAdCustomController, Context context) {
        String devOaid;
        long jOaidGeneration = AndroidPrivacyPolicy.oaidGeneration();
        if (tapAdCustomController != null) {
            try {
                devOaid = tapAdCustomController.getDevOaid();
            } catch (Throwable th) {
                devOaid = "";
            }
            if (AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
                cacheCustomOaid(devOaid);
            }
        }
        if (!AndroidPrivacyPolicy.allowsOaidResult(jOaidGeneration)) {
            return Boolean.FALSE;
        }
        refreshProviderOaids();
        prefetchProviderOaids(context);
        prefetchFallbackOaids(context);
        return Boolean.TRUE;
    }

    public void prefetchAllOaids(Context context) {
        refreshForAdRequest(context, null);
    }

    public void refreshForAdRequest(Context context, final TapAdCustomController tapAdCustomController) {
        final Context contextSafeContext = safeContext(context);
        if (contextSafeContext == null) {
            return;
        }
        this.refreshAttempts.read(new PrivacyFactCache.Permission() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda3
            @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Permission
            public final boolean allowed() {
                return AndroidPrivacyPolicy.allowsOaid();
            }
        }, AndroidPrivacyPolicy.collectionIntervalMs(), new PrivacyFactCache.Probe() { // from class: com.tapsdk.tapad.internal.oaid.OaidHelper$$ExternalSyntheticLambda4
            @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Probe
            public final Object read() {
                return this.f$0.m184lambda$refreshForAdRequest$0$comtapsdktapadinternaloaidOaidHelper(tapAdCustomController, contextSafeContext);
            }
        });
    }

    public void setDeveloperOaid(String str) {
        updateDeveloperOaid(OaidValidator.sanitize(str));
    }

    public void setGaidCollectionAllowed(boolean z) {
        this.gaidCollectionAllowed = z;
        OAIDFactory.setGaidCollectionAllowed(z);
    }

    private OaidHelper() {
        this.refreshAttempts = new PrivacyFactCache<>();
        this.providerFetchInProgress = new AtomicBoolean(false);
        this.fallbackFetchInProgress = new AtomicBoolean(false);
        this.snapshot = new AtomicReference<>(new OaidSnapshot("", "", ""));
        this.gaidCollectionAllowed = false;
        MsaOaidSource msaOaidSource = new MsaOaidSource();
        this.msaSource = msaOaidSource;
        ManufacturerOaidSource manufacturerOaidSource = new ManufacturerOaidSource();
        this.manufacturerSource = manufacturerOaidSource;
        GaidSource gaidSource = new GaidSource();
        this.gaidSource = gaidSource;
        TapDbOaidSource tapDbOaidSource = new TapDbOaidSource();
        this.tapDbSource = tapDbOaidSource;
        HostAppOaidSource hostAppOaidSource = new HostAppOaidSource();
        this.hostAppSource = hostAppOaidSource;
        LegacyCacheOaidSource legacyCacheOaidSource = new LegacyCacheOaidSource();
        this.legacyCacheSource = legacyCacheOaidSource;
        this.sourceChain = new OaidSourceChain.Builder().addSource(msaOaidSource).addSource(manufacturerOaidSource).addSource(gaidSource).addSource(tapDbOaidSource).addSource(hostAppOaidSource).addSource(legacyCacheOaidSource).build();
        this.providerSourceChain = new OaidSourceChain.Builder().addSource(msaOaidSource).addSource(manufacturerOaidSource).build();
        this.fallbackSourceChain = new OaidSourceChain.Builder().addSource(gaidSource).addSource(tapDbOaidSource).addSource(hostAppOaidSource).addSource(legacyCacheOaidSource).build();
    }
}
