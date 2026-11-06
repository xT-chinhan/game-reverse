package com.tapsdk.tapad.group.ads;

import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.AdNetworkType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DirichletAd {
    private static final String ADN_EXTRA_INFO = "adn_extra_info";
    private static final String ADN_TRACK_ID = "adn_track_id";
    private volatile boolean disclosePrice;
    private final AtomicReference<LoadBinding> loadBinding = new AtomicReference<>();
    private final AtomicLong mediationShowLeaseToken = new AtomicLong();
    private volatile SettlementProjection settlement = SettlementProjection.EMPTY;
    private final MediationCandidateEffects effects = new MediationCandidateEffects();
    private WeakReference<Object> outerAd = new WeakReference<>(null);

    public static final class LoadBinding {
        final int acceptedHeight;
        final int acceptedWidth;
        final String adnTrackId;
        final boolean doubleWindow;
        final int nativeSplashClosePosition;
        final AdNetworkType networkType;
        final String requestId;
        final String trackId;

        public LoadBinding(String str, String str2, String str3, AdNetworkType adNetworkType, int i, int i2, boolean z, int i3) {
            this.requestId = safe(str);
            this.trackId = safe(str2);
            this.adnTrackId = safe(str3);
            this.networkType = adNetworkType;
            this.acceptedWidth = i;
            this.acceptedHeight = i2;
            this.doubleWindow = z;
            this.nativeSplashClosePosition = i3;
        }

        private static String safe(String str) {
            return str == null ? "" : str;
        }
    }

    public static final class ProviderFacts {
        static final ProviderFacts EMPTY = new ProviderFacts("", "");
        final String adnExtraInfo;
        final String adnTrackId;

        private ProviderFacts(String str, String str2) {
            this.adnTrackId = str;
            this.adnExtraInfo = str2;
        }

        public static ProviderFacts from(Map<String, Object> map) {
            return (map == null || map.isEmpty()) ? EMPTY : new ProviderFacts(stringValue(map.get(DirichletAd.ADN_TRACK_ID)), stringValue(map.get(DirichletAd.ADN_EXTRA_INFO)));
        }

        private static String stringValue(Object obj) {
            return obj == null ? "" : String.valueOf(obj);
        }
    }

    public static final class SettlementProjection {
        static final SettlementProjection EMPTY = new SettlementProjection(0, 0, -1, -1);
        final long adjustedPrice;
        final long firstPrice;
        final long originalPrice;
        final long secondPrice;

        public SettlementProjection(long j, long j2, long j3, long j4) {
            this.adjustedPrice = j;
            this.originalPrice = j2;
            this.firstPrice = j3;
            this.secondPrice = j4;
        }
    }

    public final int acceptedHeight() {
        LoadBinding loadBinding = this.loadBinding.get();
        if (loadBinding == null) {
            return -1;
        }
        return loadBinding.acceptedHeight;
    }

    public final int acceptedWidth() {
        LoadBinding loadBinding = this.loadBinding.get();
        if (loadBinding == null) {
            return -1;
        }
        return loadBinding.acceptedWidth;
    }

    public final AdNetworkType androidNetworkType() {
        LoadBinding loadBinding = this.loadBinding.get();
        if (loadBinding == null) {
            return null;
        }
        return loadBinding.networkType;
    }

    public final void applySchedulerSettlement(boolean z, long j, long j2, long j3, int i) {
        this.settlement = new SettlementProjection(j, j2, z ? 0L : j3, z ? j3 : 0L);
        AdNetworkType adNetworkForValue = AdNetworkType.getAdNetworkForValue(i);
        try {
            if (z) {
                this.effects.innerWin(this, adNetworkForValue);
            } else {
                this.effects.innerLoss(this, "", adNetworkForValue);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean bindLoad(String str, String str2, String str3, AdNetworkType adNetworkType, int i, int i2, boolean z, int i3) {
        if (str != null && !str.isEmpty() && adNetworkType != null) {
            return DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(this.loadBinding, null, new LoadBinding(str, str2, str3, adNetworkType, i, i2, z, i3));
        }
        return false;
    }

    public final long clearMediationShowLease() {
        return this.mediationShowLeaseToken.getAndSet(0L);
    }

    public void destroy() {
        MediationShowAdmissionBridge.release(this);
        try {
            this.effects.onDestroy(this);
        } catch (Exception e) {
        }
    }

    public final boolean doubleWindow() {
        LoadBinding loadBinding = this.loadBinding.get();
        return loadBinding != null && loadBinding.doubleWindow;
    }

    public final MediationCandidateEffects effects() {
        return this.effects;
    }

    public final String getAdnTrackId() {
        LoadBinding loadBinding = this.loadBinding.get();
        return loadBinding == null ? "" : loadBinding.adnTrackId;
    }

    public final Map<String, Object> getDirichletExtraInfo() {
        HashMap map = new HashMap();
        map.put("track_id", getTrackId());
        if (this.disclosePrice) {
            map.put(IAction.PurchaseKey.Price, Long.valueOf(this.settlement.adjustedPrice));
        }
        return map;
    }

    public abstract Map<String, Object> getMediaExtraInfo();

    public final <F> F getOuterAd() {
        return (F) this.outerAd.get();
    }

    public final String getRequestId() {
        LoadBinding loadBinding = this.loadBinding.get();
        return loadBinding == null ? "" : loadBinding.requestId;
    }

    public final String getTrackId() {
        LoadBinding loadBinding = this.loadBinding.get();
        return loadBinding == null ? "" : loadBinding.trackId;
    }

    public abstract void innerLoss(long j, String str, String str2);

    public abstract void innerWin(long j, long j2, String str);

    public final void installCorePriceDisclosure(boolean z) {
        this.disclosePrice = z;
    }

    public final boolean installMediationShowLease(long j, int i) {
        return j != 0 && i > 0 && this.mediationShowLeaseToken.compareAndSet(0L, j);
    }

    public abstract boolean isValid();

    public final void loss(long j, String str, String str2) {
        try {
            this.effects.mediaLoss(this, j, str, str2);
        } catch (Exception e) {
        }
    }

    public final long mediationShowLeaseToken() {
        return this.mediationShowLeaseToken.get();
    }

    public final int nativeSplashClosePosition() {
        LoadBinding loadBinding = this.loadBinding.get();
        if (loadBinding == null) {
            return 0;
        }
        return loadBinding.nativeSplashClosePosition;
    }

    public final ProviderFacts readProviderFacts() {
        try {
            return ProviderFacts.from(getMediaExtraInfo());
        } catch (Throwable th) {
            return ProviderFacts.EMPTY;
        }
    }

    public abstract long readProviderPrice();

    public final long readProviderPriceFact() {
        try {
            return readProviderPrice();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public final long schedulerFirstPrice() {
        return this.settlement.firstPrice;
    }

    public final long schedulerOriginalPrice() {
        return this.settlement.originalPrice;
    }

    public final long schedulerSecondPrice() {
        return this.settlement.secondPrice;
    }

    public void setOuterAd(Object obj) {
        this.outerAd = new WeakReference<>(obj);
    }

    public final void win(long j) {
        try {
            this.effects.mediaWin(this, j);
        } catch (Exception e) {
        }
    }
}
