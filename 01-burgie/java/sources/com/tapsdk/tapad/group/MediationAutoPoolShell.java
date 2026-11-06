package com.tapsdk.tapad.group;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.group.ads.DirichletBannerAd;
import com.tapsdk.tapad.group.ads.DirichletInterstitialAd;
import com.tapsdk.tapad.group.ads.DirichletRewardVideoAd;
import com.tapsdk.tapad.group.ads.DirichletSplashAd;
import com.tapsdk.tapad.internal.observability.MediationTelemetryHost;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationPoolCoreBridge;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.login.LoginAction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class MediationAutoPoolShell {
    private static final String FORMAT_BANNER = "banner";
    private static final String FORMAT_INTERSTITIAL = "interstitial";
    private static final String FORMAT_REWARD = "reward";
    private static final String FORMAT_SPLASH = "splash";
    private static final AtomicLong NEXT_SCOPE = new AtomicLong();
    private final WeakReference<Context> context;
    private final DirichletAdNative loader;
    private final String scopeId = "android-" + NEXT_SCOPE.incrementAndGet();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<Locator, Session> sessions = new HashMap();

    public final class BannerController implements View.OnAttachStateChangeListener {
        private volatile Lease currentLease;
        private final WeakReference<ViewGroup> hostContainer;
        private final DirichletAdNative.BannerAutoAdListener listener;
        private final FrameLayout ownedContainer;
        private final AtomicBoolean released = new AtomicBoolean(false);
        private final DirichletAdRequest request;
        private final Session session;

        public BannerController(Session session, DirichletAdRequest dirichletAdRequest, Context context, ViewGroup viewGroup, DirichletAdNative.BannerAutoAdListener bannerAutoAdListener) {
            this.session = session;
            this.request = dirichletAdRequest;
            this.hostContainer = new WeakReference<>(viewGroup);
            this.listener = bannerAutoAdListener;
            this.ownedContainer = new FrameLayout(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void scheduleNext(long j) {
            if (this.released.get() || j <= 0) {
                return;
            }
            MediationAutoPoolShell.this.mainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.BannerController.2
                @Override // java.lang.Runnable
                public void run() {
                    BannerController.this.requestNext();
                }
            }, j);
        }

        /* JADX INFO: renamed from: lambda$requestNext$0$com-tapsdk-tapad-group-MediationAutoPoolShell$BannerController, reason: not valid java name */
        /* synthetic */ void m35lambda$requestNext$0$comtapsdktapadgroupMediationAutoPoolShell$BannerController(Delivery delivery) {
            MediationAutoPoolShell.this.take(this.session, this.request, delivery);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            releaseController();
        }

        public void releaseController() {
            if (this.released.compareAndSet(false, true)) {
                this.ownedContainer.removeOnAttachStateChangeListener(this);
                Lease lease = this.currentLease;
                this.currentLease = null;
                if (lease != null) {
                    MediationAutoPoolShell.this.enqueueLeaseEvent(this.session, lease.handle, lease.leaseId, "release", false, null);
                }
                ViewParent parent = this.ownedContainer.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.ownedContainer);
                }
            }
        }

        public void requestNext() {
            if (this.released.get()) {
                return;
            }
            final Delivery delivery = new Delivery() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.BannerController.1

                /* JADX INFO: renamed from: com.tapsdk.tapad.group.MediationAutoPoolShell$BannerController$1$1, reason: invalid class name and collision with other inner class name */
                public class C02641 implements DirichletBannerAd.BannerInteractionListener {
                    final /* synthetic */ Lease val$lease;

                    public C02641(Lease lease) {
                        this.val$lease = lease;
                    }

                    /* JADX INFO: renamed from: lambda$onAdClose$1$com-tapsdk-tapad-group-MediationAutoPoolShell$BannerController$1$1, reason: not valid java name */
                    /* synthetic */ void m36lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$BannerController$1$1(Lease lease) {
                        if (BannerController.this.currentLease != lease) {
                            return;
                        }
                        BannerController.this.currentLease = null;
                        BannerController.this.releaseController();
                        if (BannerController.this.listener != null) {
                            BannerController.this.listener.onAdClose();
                        }
                    }

                    /* JADX INFO: renamed from: lambda$onAdShow$0$com-tapsdk-tapad-group-MediationAutoPoolShell$BannerController$1$1, reason: not valid java name */
                    /* synthetic */ void m37lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$BannerController$1$1(Lease lease) {
                        if (BannerController.this.currentLease != lease) {
                            return;
                        }
                        if (BannerController.this.listener != null) {
                            BannerController.this.listener.onAdShow();
                        }
                        BannerController.this.scheduleNext(lease.refreshDelayMs);
                    }

                    @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                    public void onAdClick() {
                        Lease lease = BannerController.this.currentLease;
                        Lease lease2 = this.val$lease;
                        if (lease == lease2 && MediationAutoPoolShell.this.isLeaseActive(lease2) && BannerController.this.listener != null) {
                            BannerController.this.listener.onAdClick();
                        }
                    }

                    @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                    public void onAdClose() {
                        if (BannerController.this.currentLease != this.val$lease) {
                            return;
                        }
                        BannerController bannerController = BannerController.this;
                        MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                        Session session = bannerController.session;
                        final Lease lease = this.val$lease;
                        mediationAutoPoolShell.enqueueLeaseEvent(session, lease.handle, lease.leaseId, ILivePush.ClickType.CLOSE, false, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$BannerController$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m36lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$BannerController$1$1(lease);
                            }
                        });
                    }

                    @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                    public void onAdShow() {
                        if (BannerController.this.currentLease != this.val$lease) {
                            return;
                        }
                        BannerController bannerController = BannerController.this;
                        MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                        Session session = bannerController.session;
                        final Lease lease = this.val$lease;
                        mediationAutoPoolShell.enqueueLeaseEvent(session, lease.handle, lease.leaseId, "shown", true, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$BannerController$1$1$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m37lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$BannerController$1$1(lease);
                            }
                        });
                    }
                }

                @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
                public void error(int i, String str) {
                    error(i, str, 0L);
                }

                @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
                public void show(Object obj, Lease lease) {
                    if (!(obj instanceof DirichletBannerAd) || BannerController.this.released.get()) {
                        throw new IllegalStateException("banner provider unavailable");
                    }
                    DirichletBannerAd dirichletBannerAd = (DirichletBannerAd) obj;
                    dirichletBannerAd.setBannerInteractionListener(new C02641(lease));
                    View bannerView = dirichletBannerAd.getBannerView();
                    if (bannerView == null) {
                        BannerController bannerController = BannerController.this;
                        MediationAutoPoolShell.this.enqueueLeaseEvent(bannerController.session, lease.handle, lease.leaseId, "release", false, null);
                        error(LoginAction.LOGIN_CANCEL, "banner view 为空");
                        return;
                    }
                    Lease lease2 = BannerController.this.currentLease;
                    BannerController.this.currentLease = lease;
                    BannerController.this.ownedContainer.removeAllViews();
                    BannerController.this.ownedContainer.addView(bannerView);
                    if (lease2 == null || lease2 == lease) {
                        return;
                    }
                    BannerController bannerController2 = BannerController.this;
                    MediationAutoPoolShell.this.enqueueLeaseEvent(bannerController2.session, lease2.handle, lease2.leaseId, "release", false, null);
                }

                @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
                public void error(int i, String str, long j) {
                    if (BannerController.this.currentLease != null) {
                        BannerController.this.scheduleNext(j);
                    } else if (BannerController.this.listener != null) {
                        BannerController.this.listener.onError(i, str);
                    }
                }
            };
            if (MediationAutoPoolShell.this.runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$BannerController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m35lambda$requestNext$0$comtapsdktapadgroupMediationAutoPoolShell$BannerController(delivery);
                }
            })) {
                return;
            }
            delivery.error(LoginAction.LOGIN_CANCEL, "无填充");
        }

        public void start() {
            ViewGroup viewGroup = this.hostContainer.get();
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this.ownedContainer, new FrameLayout.LayoutParams(-1, -1));
            this.ownedContainer.addOnAttachStateChangeListener(this);
            requestNext();
        }
    }

    public interface Delivery {
        void error(int i, String str);

        default void error(int i, String str, long j) {
            error(i, str);
        }

        void show(Object obj, Lease lease);
    }

    public final class InterstitialDelivery implements Delivery {
        private final WeakReference<Activity> activity;
        private final DirichletAdNative.InterstitialAutoAdListener listener;

        /* JADX INFO: renamed from: com.tapsdk.tapad.group.MediationAutoPoolShell$InterstitialDelivery$1, reason: invalid class name */
        public class AnonymousClass1 implements DirichletInterstitialAd.InterstitialAdInteractionListener {
            final /* synthetic */ Lease val$lease;

            public AnonymousClass1(Lease lease) {
                this.val$lease = lease;
            }

            /* JADX INFO: renamed from: lambda$onAdClose$1$com-tapsdk-tapad-group-MediationAutoPoolShell$InterstitialDelivery$1, reason: not valid java name */
            /* synthetic */ void m38lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$InterstitialDelivery$1() {
                if (InterstitialDelivery.this.listener != null) {
                    InterstitialDelivery.this.listener.onAdClose();
                }
            }

            /* JADX INFO: renamed from: lambda$onAdShow$0$com-tapsdk-tapad-group-MediationAutoPoolShell$InterstitialDelivery$1, reason: not valid java name */
            /* synthetic */ void m39lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$InterstitialDelivery$1() {
                if (InterstitialDelivery.this.listener != null) {
                    InterstitialDelivery.this.listener.onAdShow();
                }
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdClick() {
                if (!MediationAutoPoolShell.this.isLeaseActive(this.val$lease) || InterstitialDelivery.this.listener == null) {
                    return;
                }
                InterstitialDelivery.this.listener.onAdClick();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdClose() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, ILivePush.ClickType.CLOSE, false, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$InterstitialDelivery$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m38lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$InterstitialDelivery$1();
                    }
                });
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdShow() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, "shown", true, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$InterstitialDelivery$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m39lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$InterstitialDelivery$1();
                    }
                });
            }
        }

        public InterstitialDelivery(Activity activity, DirichletAdNative.InterstitialAutoAdListener interstitialAutoAdListener) {
            this.activity = new WeakReference<>(activity);
            this.listener = interstitialAutoAdListener;
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void error(int i, String str) {
            MediationAutoPoolShell.fail(this.listener, i, str);
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void show(Object obj, Lease lease) {
            Activity activity = this.activity.get();
            if (!(obj instanceof DirichletInterstitialAd) || activity == null) {
                throw new IllegalStateException("interstitial provider unavailable");
            }
            DirichletInterstitialAd dirichletInterstitialAd = (DirichletInterstitialAd) obj;
            dirichletInterstitialAd.setInteractionListener(new AnonymousClass1(lease));
            dirichletInterstitialAd.show(activity);
        }
    }

    public static final class Lease {
        final long handle;
        final long leaseId;
        final long refreshDelayMs;
        final Session session;

        public Lease(Session session, long j, long j2, long j3) {
            this.session = session;
            this.handle = j;
            this.leaseId = j2;
            this.refreshDelayMs = j3;
        }
    }

    public static final class LifecycleRelay implements AndroidLifecycleHost.AppStateListener {
        private static final LifecycleRelay INSTANCE = new LifecycleRelay();
        private final CopyOnWriteArrayList<WeakReference<MediationAutoPoolShell>> shells = new CopyOnWriteArrayList<>();

        private LifecycleRelay() {
            try {
                AndroidLifecycleHost.getInstance().addAppStateListener(this);
            } catch (Throwable th) {
            }
        }

        private void broadcast(boolean z) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<MediationAutoPoolShell> weakReference : this.shells) {
                MediationAutoPoolShell mediationAutoPoolShell = weakReference.get();
                if (mediationAutoPoolShell == null) {
                    arrayList.add(weakReference);
                } else {
                    mediationAutoPoolShell.tickAll(z);
                }
            }
            this.shells.removeAll(arrayList);
        }

        public static boolean isForeground() {
            try {
                return AndroidLifecycleHost.getInstance().isAppInForeground();
            } catch (Throwable th) {
                return true;
            }
        }

        public static void register(MediationAutoPoolShell mediationAutoPoolShell) {
            INSTANCE.shells.add(new WeakReference<>(mediationAutoPoolShell));
        }

        @Override // com.tapsdk.tapad.internal.platform.AndroidLifecycleHost.AppStateListener
        public void onAppBackground() {
            broadcast(false);
        }

        @Override // com.tapsdk.tapad.internal.platform.AndroidLifecycleHost.AppStateListener
        public void onAppForeground() {
            broadcast(true);
        }
    }

    public static final class Locator {
        final String format;
        final long spaceId;

        public Locator(long j, String str) {
            this.spaceId = j;
            this.format = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Locator)) {
                return false;
            }
            Locator locator = (Locator) obj;
            return this.spaceId == locator.spaceId && this.format.equals(locator.format);
        }

        public int hashCode() {
            return this.format.hashCode() + (Long.valueOf(this.spaceId).hashCode() * 31);
        }
    }

    public static final class ObjectRecord {
        final long handle;
        final String providerKey;
        final Object providerObject;

        public ObjectRecord(long j, Object obj, String str) {
            this.handle = j;
            this.providerObject = obj;
            this.providerKey = str;
        }

        public JSONObject fact() {
            JSONObject jSONObject = new JSONObject();
            MediationAutoPoolShell.put(jSONObject, "handle", Long.valueOf(this.handle));
            MediationAutoPoolShell.put(jSONObject, "provider_key", this.providerKey);
            MediationAutoPoolShell.put(jSONObject, "valid", Boolean.valueOf(MediationAutoPoolShell.isValid(this.providerObject)));
            this.providerObject.getClass();
            return jSONObject;
        }
    }

    public static final class ProviderIdentity {
        final long handle;
        final WeakReference<Object> providerObject;

        public ProviderIdentity(long j, Object obj) {
            this.handle = j;
            this.providerObject = new WeakReference<>(obj);
        }
    }

    public static final class ProviderSubmission {
        final boolean inserted;
        final ObjectRecord record;

        public ProviderSubmission(ObjectRecord objectRecord, boolean z) {
            this.record = objectRecord;
            this.inserted = z;
        }
    }

    public final class RewardDelivery implements Delivery {
        private final WeakReference<Activity> activity;
        private final DirichletAdNative.RewardVideoAutoAdListener listener;

        /* JADX INFO: renamed from: com.tapsdk.tapad.group.MediationAutoPoolShell$RewardDelivery$1, reason: invalid class name */
        public class AnonymousClass1 implements DirichletRewardVideoAd.RewardAdInteractionListener {
            final /* synthetic */ Lease val$lease;

            public AnonymousClass1(Lease lease) {
                this.val$lease = lease;
            }

            /* JADX INFO: renamed from: lambda$onAdClose$1$com-tapsdk-tapad-group-MediationAutoPoolShell$RewardDelivery$1, reason: not valid java name */
            /* synthetic */ void m40lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$RewardDelivery$1() {
                if (RewardDelivery.this.listener != null) {
                    RewardDelivery.this.listener.onAdClose();
                }
            }

            /* JADX INFO: renamed from: lambda$onAdShow$0$com-tapsdk-tapad-group-MediationAutoPoolShell$RewardDelivery$1, reason: not valid java name */
            /* synthetic */ void m41lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$RewardDelivery$1() {
                if (RewardDelivery.this.listener != null) {
                    RewardDelivery.this.listener.onAdShow();
                }
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdClick() {
                if (!MediationAutoPoolShell.this.isLeaseActive(this.val$lease) || RewardDelivery.this.listener == null) {
                    return;
                }
                RewardDelivery.this.listener.onAdClick();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, ILivePush.ClickType.CLOSE, false, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$RewardDelivery$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m40lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$RewardDelivery$1();
                    }
                });
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, "shown", true, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$RewardDelivery$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m41lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$RewardDelivery$1();
                    }
                });
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                if (!MediationAutoPoolShell.this.isLeaseActive(this.val$lease) || RewardDelivery.this.listener == null) {
                    return;
                }
                RewardDelivery.this.listener.onRewardVerify(z, i, str, i2, str2);
            }
        }

        public RewardDelivery(Activity activity, DirichletAdNative.RewardVideoAutoAdListener rewardVideoAutoAdListener) {
            this.activity = new WeakReference<>(activity);
            this.listener = rewardVideoAutoAdListener;
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void error(int i, String str) {
            MediationAutoPoolShell.fail(this.listener, i, str);
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void show(Object obj, Lease lease) {
            Activity activity = this.activity.get();
            if (!(obj instanceof DirichletRewardVideoAd) || activity == null) {
                throw new IllegalStateException("reward provider unavailable");
            }
            DirichletRewardVideoAd dirichletRewardVideoAd = (DirichletRewardVideoAd) obj;
            dirichletRewardVideoAd.setRewardAdInteractionListener(new AnonymousClass1(lease));
            dirichletRewardVideoAd.showRewardVideoAd(activity);
        }
    }

    public static final class Session {
        final Locator locator;
        final WasmModule module;
        final long poolId;
        final AtomicBoolean destroyed = new AtomicBoolean(false);
        final AtomicLong nextHandle = new AtomicLong();
        final ConcurrentMap<Long, ObjectRecord> objects = new ConcurrentHashMap();
        final ConcurrentMap<Long, Runnable> wakeTasks = new ConcurrentHashMap();
        final List<ProviderIdentity> providerIdentities = new ArrayList();
        final ConcurrentMap<Long, Delivery> pendingDeliveries = new ConcurrentHashMap();
        final ConcurrentMap<Long, Lease> leases = new ConcurrentHashMap();

        public Session(Locator locator, long j, WasmModule wasmModule) {
            this.locator = locator;
            this.poolId = j;
            this.module = wasmModule;
        }
    }

    public final class SplashDelivery implements Delivery {
        private final WeakReference<ViewGroup> container;
        private final DirichletAdNative.SplashAutoAdListener listener;

        /* JADX INFO: renamed from: com.tapsdk.tapad.group.MediationAutoPoolShell$SplashDelivery$1, reason: invalid class name */
        public class AnonymousClass1 implements DirichletSplashAd.AdInteractionListener {
            final /* synthetic */ Lease val$lease;

            public AnonymousClass1(Lease lease) {
                this.val$lease = lease;
            }

            /* JADX INFO: renamed from: lambda$onAdClose$1$com-tapsdk-tapad-group-MediationAutoPoolShell$SplashDelivery$1, reason: not valid java name */
            /* synthetic */ void m42lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$SplashDelivery$1() {
                if (SplashDelivery.this.listener != null) {
                    SplashDelivery.this.listener.onAdClose();
                }
            }

            /* JADX INFO: renamed from: lambda$onAdShow$0$com-tapsdk-tapad-group-MediationAutoPoolShell$SplashDelivery$1, reason: not valid java name */
            /* synthetic */ void m43lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$SplashDelivery$1() {
                if (SplashDelivery.this.listener != null) {
                    SplashDelivery.this.listener.onAdShow();
                }
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdClick() {
                if (!MediationAutoPoolShell.this.isLeaseActive(this.val$lease) || SplashDelivery.this.listener == null) {
                    return;
                }
                SplashDelivery.this.listener.onAdClick();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdClose() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, ILivePush.ClickType.CLOSE, false, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$SplashDelivery$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m42lambda$onAdClose$1$comtapsdktapadgroupMediationAutoPoolShell$SplashDelivery$1();
                    }
                });
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdShow() {
                MediationAutoPoolShell mediationAutoPoolShell = MediationAutoPoolShell.this;
                Lease lease = this.val$lease;
                mediationAutoPoolShell.enqueueLeaseEvent(lease.session, lease.handle, lease.leaseId, "shown", true, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$SplashDelivery$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m43lambda$onAdShow$0$comtapsdktapadgroupMediationAutoPoolShell$SplashDelivery$1();
                    }
                });
            }
        }

        public SplashDelivery(ViewGroup viewGroup, DirichletAdNative.SplashAutoAdListener splashAutoAdListener) {
            this.container = new WeakReference<>(viewGroup);
            this.listener = splashAutoAdListener;
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void error(int i, String str) {
            MediationAutoPoolShell.fail(this.listener, i, str);
        }

        @Override // com.tapsdk.tapad.group.MediationAutoPoolShell.Delivery
        public void show(Object obj, Lease lease) {
            ViewGroup viewGroup = this.container.get();
            if (!(obj instanceof DirichletSplashAd) || viewGroup == null) {
                throw new IllegalStateException("splash provider unavailable");
            }
            DirichletSplashAd dirichletSplashAd = (DirichletSplashAd) obj;
            dirichletSplashAd.setSplashInteractionListener(new AnonymousClass1(lease));
            viewGroup.removeAllViews();
            dirichletSplashAd.show(viewGroup);
        }
    }

    public MediationAutoPoolShell(Context context, DirichletAdNative dirichletAdNative) {
        this.context = new WeakReference<>(context);
        this.loader = dirichletAdNative;
        LifecycleRelay.register(this);
    }

    private JSONObject baseInput(Session session) {
        JSONObject jSONObject = new JSONObject();
        put(jSONObject, "pool_id", Long.valueOf(session.poolId));
        put(jSONObject, "now_ms", Long.valueOf(nowMs()));
        put(jSONObject, "provider_ready", Boolean.valueOf(hostReady()));
        return jSONObject;
    }

    private static String commandKinds(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            String strOptString = "?";
            if (jSONObjectOptJSONObject != null) {
                strOptString = jSONObjectOptJSONObject.optString("kind", "?");
            }
            sb.append(strOptString);
        }
        return sb.append(AbstractJsonLexerKt.END_LIST).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroy(Object obj) {
        try {
            if (obj instanceof DirichletRewardVideoAd) {
                ((DirichletRewardVideoAd) obj).destroy();
                return;
            }
            if (obj instanceof DirichletBannerAd) {
                ((DirichletBannerAd) obj).destroy();
            } else if (obj instanceof DirichletInterstitialAd) {
                ((DirichletInterstitialAd) obj).destroy();
            } else if (obj instanceof DirichletSplashAd) {
                ((DirichletSplashAd) obj).destroy();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueLeaseEvent(final Session session, final long j, final long j2, final String str, final boolean z, final Runnable runnable) {
        runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m24lambda$enqueueLeaseEvent$15$comtapsdktapadgroupMediationAutoPoolShell(session, j, j2, str, z, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueLoadFailure(final Session session, final long j, final int i, final String str, final boolean z) {
        runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m25lambda$enqueueLoadFailure$11$comtapsdktapadgroupMediationAutoPoolShell(session, j, i, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueLoadSuccess(final Session session, final long j, final Object obj) {
        if (runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m26lambda$enqueueLoadSuccess$9$comtapsdktapadgroupMediationAutoPoolShell(session, j, obj);
            }
        })) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MediationAutoPoolShell.destroy(obj);
            }
        });
    }

    private void executeCommands(Session session, JSONArray jSONArray, Delivery delivery) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && "request_opened".equals(jSONObjectOptJSONObject.optString("kind"))) {
                long jOptLong = jSONObjectOptJSONObject.optLong("request_token", 0L);
                if (jOptLong > 0 && delivery != null) {
                    session.pendingDeliveries.put(Long.valueOf(jOptLong), delivery);
                    delivery = null;
                }
            }
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("kind", "");
                if ("load".equals(strOptString)) {
                    executeLoad(session, jSONObjectOptJSONObject2);
                } else if ("deliver".equals(strOptString)) {
                    executeDelivery(session, jSONObjectOptJSONObject2);
                } else if ("terminal".equals(strOptString)) {
                    executeTerminal(session, jSONObjectOptJSONObject2);
                } else if ("release".equals(strOptString)) {
                    executeRelease(session, jSONObjectOptJSONObject2);
                } else if ("wake".equals(strOptString)) {
                    executeWake(session, jSONObjectOptJSONObject2.optLong("at_ms", nowMs()));
                }
            }
        }
    }

    private void executeDelivery(final Session session, JSONObject jSONObject) {
        final long jOptLong = jSONObject.optLong("request_token", 0L);
        final long jOptLong2 = jSONObject.optLong("handle", 0L);
        final long jOptLong3 = jSONObject.optLong("lease_id", 0L);
        long jMax = Math.max(0L, jSONObject.optLong("refresh_delay_ms", 0L));
        final Delivery deliveryRemove = session.pendingDeliveries.remove(Long.valueOf(jOptLong));
        final ObjectRecord objectRecord = session.objects.get(Long.valueOf(jOptLong2));
        if (deliveryRemove == null || objectRecord == null) {
            leaseEvent(session, jOptLong2, jOptLong3, "evict", false);
            if (deliveryRemove != 0) {
                postDeliveryError(deliveryRemove, LoginAction.LOGOUT, "广告已失效");
                return;
            }
            return;
        }
        final Lease lease = new Lease(session, jOptLong2, jOptLong3, jMax);
        session.leases.put(Long.valueOf(jOptLong2), lease);
        trackAutoShow(session, objectRecord);
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.6
            @Override // java.lang.Runnable
            public void run() {
                Lease lease2 = session.leases.get(Long.valueOf(jOptLong2));
                Lease lease3 = lease;
                if (lease2 != lease3) {
                    return;
                }
                try {
                    long j = session.poolId;
                    deliveryRemove.show(objectRecord.providerObject, lease3);
                    long j2 = session.poolId;
                } catch (Throwable th) {
                    MediationAutoPoolShell.this.enqueueLeaseEvent(session, jOptLong2, jOptLong3, "show_failed", MediationAutoPoolShell.isValid(objectRecord.providerObject), null);
                    deliveryRemove.error(LoginAction.LOGOUT, "广告已失效");
                }
            }
        });
    }

    private void executeLoad(final Session session, JSONObject jSONObject) {
        final long jOptLong = jSONObject.optLong("load_token", 0L);
        DirichletAdRequest dirichletAdRequestLoadRequest = loadRequest(session, jSONObject.optJSONObject("load_request"));
        long j = session.poolId;
        String str = session.locator.format;
        jSONObject.optLong("deadline_ms", 0L);
        if (jOptLong <= 0 || dirichletAdRequestLoadRequest == null) {
            submitLoadFailure(session, jOptLong, -1, "missing mechanical request");
            return;
        }
        if (FORMAT_REWARD.equals(session.locator.format)) {
            this.loader.loadRewardVideoAd(dirichletAdRequestLoadRequest, new DirichletAdNative.RewardVideoAdListener() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.1
                @Override // com.tapsdk.tapad.group.CommonListener
                public void onError(int i, String str2) {
                    MediationAutoPoolShell.this.enqueueLoadFailure(session, jOptLong, i, str2, true);
                }

                @Override // com.tapsdk.tapad.group.DirichletAdNative.RewardVideoAdListener
                public void onRewardVideoAdLoad(DirichletRewardVideoAd dirichletRewardVideoAd) {
                    MediationAutoPoolShell.this.enqueueLoadSuccess(session, jOptLong, dirichletRewardVideoAd);
                }
            });
            return;
        }
        if ("banner".equals(session.locator.format)) {
            this.loader.loadBannerAd(dirichletAdRequestLoadRequest, new DirichletAdNative.BannerAdListener() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.2
                @Override // com.tapsdk.tapad.group.DirichletAdNative.BannerAdListener
                public void onBannerAdLoad(DirichletBannerAd dirichletBannerAd) {
                    MediationAutoPoolShell.this.enqueueLoadSuccess(session, jOptLong, dirichletBannerAd);
                }

                @Override // com.tapsdk.tapad.group.CommonListener
                public void onError(int i, String str2) {
                    MediationAutoPoolShell.this.enqueueLoadFailure(session, jOptLong, i, str2, true);
                }
            });
            return;
        }
        if ("interstitial".equals(session.locator.format)) {
            this.loader.loadInterstitialAd(dirichletAdRequestLoadRequest, new DirichletAdNative.InterstitialAdListener() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.3
                @Override // com.tapsdk.tapad.group.CommonListener
                public void onError(int i, String str2) {
                    MediationAutoPoolShell.this.enqueueLoadFailure(session, jOptLong, i, str2, true);
                }

                @Override // com.tapsdk.tapad.group.DirichletAdNative.InterstitialAdListener
                public void onInterstitialAdLoad(DirichletInterstitialAd dirichletInterstitialAd) {
                    MediationAutoPoolShell.this.enqueueLoadSuccess(session, jOptLong, dirichletInterstitialAd);
                }
            });
        } else if ("splash".equals(session.locator.format)) {
            this.loader.loadSplashAd(dirichletAdRequestLoadRequest, new DirichletAdNative.SplashAdListener() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.4
                @Override // com.tapsdk.tapad.group.CommonListener
                public void onError(int i, String str2) {
                    MediationAutoPoolShell.this.enqueueLoadFailure(session, jOptLong, i, str2, true);
                }

                @Override // com.tapsdk.tapad.group.DirichletAdNative.SplashAdListener
                public void onSplashAdLoad(DirichletSplashAd dirichletSplashAd) {
                    MediationAutoPoolShell.this.enqueueLoadSuccess(session, jOptLong, dirichletSplashAd);
                }
            });
        } else {
            submitLoadFailure(session, jOptLong, -1, "unsupported ad format");
        }
    }

    private void executeRelease(Session session, JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("handle", 0L);
        String strOptString = jSONObject.optString(MediationConstant.KEY_REASON, "release");
        final ObjectRecord objectRecordRemove = session.objects.remove(Long.valueOf(jOptLong));
        session.leases.remove(Long.valueOf(jOptLong));
        if (objectRecordRemove == null) {
            return;
        }
        if ("provider_invalid".equals(strOptString) || "ttl_expired".equals(strOptString)) {
            trackInvalid(session, objectRecordRemove);
        }
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.7
            @Override // java.lang.Runnable
            public void run() {
                MediationAutoPoolShell.destroy(objectRecordRemove.providerObject);
            }
        });
    }

    private void executeTerminal(Session session, JSONObject jSONObject) {
        final Delivery deliveryRemove = session.pendingDeliveries.remove(Long.valueOf(jSONObject.optLong("request_token", 0L)));
        jSONObject.optString("outcome");
        jSONObject.optString(MediationConstant.KEY_REASON);
        if (deliveryRemove == null || "canceled".equals(jSONObject.optString("outcome"))) {
            return;
        }
        final int iOptInt = jSONObject.optInt("public_error_code", LoginAction.LOGIN_CANCEL);
        final String strOptString = jSONObject.has("public_error_message") ? jSONObject.optString("public_error_message", "") : "无填充";
        final long jMax = Math.max(0L, jSONObject.optLong("refresh_delay_ms", 0L));
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                deliveryRemove.error(iOptInt, strOptString, jMax);
            }
        });
    }

    private void executeWake(final Session session, final long j) {
        if (j <= 0 || session.destroyed.get()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.8
            @Override // java.lang.Runnable
            public void run() {
                if (session.wakeTasks.remove(Long.valueOf(j), this)) {
                    MediationAutoPoolShell.this.tick(session, LifecycleRelay.isForeground());
                }
            }
        };
        if (session.wakeTasks.putIfAbsent(Long.valueOf(j), runnable) != null) {
            return;
        }
        if (SchedulerNativeBridge.scheduleWakeAt(SystemClock.uptimeMillis() + Math.max(0L, j - nowMs()), runnable) == null) {
            session.wakeTasks.remove(Long.valueOf(j), runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fail(CommonListener commonListener, int i, String str) {
        if (commonListener != null) {
            commonListener.onError(i, str);
        }
    }

    private boolean hostReady() {
        try {
            Context context = this.context.get();
            if (context == null) {
                return false;
            }
            Activity activity = ActivityUtil.getActivity(context);
            return activity == null || !ActivityUtil.isActivityNotAlive(activity);
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean invoke(Session session, int i, JSONObject jSONObject, Delivery delivery) {
        return invokeResult(session, i, jSONObject, delivery) != null;
    }

    private MediationPoolCoreBridge.Result invokeResult(Session session, int i, JSONObject jSONObject, Delivery delivery) {
        if (session == null || session.destroyed.get()) {
            return null;
        }
        put(jSONObject, "pool_id", Long.valueOf(session.poolId));
        put(jSONObject, "now_ms", Long.valueOf(nowMs()));
        MediationPoolCoreBridge.Result resultTransform = MediationPoolCoreBridge.transform(session.module, i, jSONObject);
        if (!resultTransform.isSuccess()) {
            if (isRuntimeFailure(resultTransform.status)) {
                retireSession(session);
            }
            return null;
        }
        JSONObject jSONObjectOptJSONObject = resultTransform.output.optJSONObject("state");
        JSONArray jSONArrayOptJSONArray = resultTransform.output.optJSONArray("commands");
        commandKinds(jSONArrayOptJSONArray);
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optInt("cached_count", -1);
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optInt("available_count", -1);
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optInt("pending_consumer_count", -1);
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optInt("warming_count", -1);
        }
        executeCommands(session, jSONArrayOptJSONArray, delivery);
        return resultTransform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLeaseActive(Lease lease) {
        return lease != null && lease.session.leases.get(Long.valueOf(lease.handle)) == lease;
    }

    private static boolean isRuntimeFailure(int i) {
        return i <= -9811 && i >= -9817;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValid(Object obj) {
        try {
            if (obj instanceof DirichletRewardVideoAd) {
                return ((DirichletRewardVideoAd) obj).isValid();
            }
            if (obj instanceof DirichletBannerAd) {
                return ((DirichletBannerAd) obj).isValid();
            }
            return obj instanceof DirichletInterstitialAd ? ((DirichletInterstitialAd) obj).isValid() : obj instanceof DirichletSplashAd;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean leaseEvent(Session session, long j, long j2, String str, boolean z) {
        Lease lease;
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "handle", Long.valueOf(j));
        put(jSONObjectBaseInput, "lease_id", Long.valueOf(j2));
        put(jSONObjectBaseInput, NotificationCompat.CATEGORY_EVENT, str);
        put(jSONObjectBaseInput, "provider_valid", Boolean.valueOf(z));
        MediationPoolCoreBridge.Result resultInvokeResult = invokeResult(session, 8, jSONObjectBaseInput, null);
        JSONArray jSONArrayOptJSONArray = resultInvokeResult != null ? resultInvokeResult.output.optJSONArray("commands") : null;
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && "lease_ack".equals(jSONObjectOptJSONObject.optString("kind")) && j == jSONObjectOptJSONObject.optLong("handle") && j2 == jSONObjectOptJSONObject.optLong("lease_id") && str.equals(jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_EVENT))) {
                if ("shown".equals(str) || (lease = session.leases.get(Long.valueOf(j))) == null || lease.session != session || lease.leaseId != j2) {
                    return true;
                }
                session.leases.remove(Long.valueOf(j), lease);
                return true;
            }
        }
        return false;
    }

    private static DirichletAdRequest loadRequest(Session session, JSONObject jSONObject) {
        if (session != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong(Constants.Bidding.SPACE_ID, 0L);
            if (jOptLong > 0 && jOptLong == session.locator.spaceId) {
                return new DirichletAdRequest.Builder().withSpaceId(jOptLong).withQuery(jSONObject.optString("query", "")).withUserId(jSONObject.optString("reward_user_id", "")).withExtra1(jSONObject.optString("reward_extra", "")).withRewardName(jSONObject.optString("reward_name", "")).withRewardAmount(jSONObject.optInt("reward_amount", 0)).withExpressViewAcceptedSize(jSONObject.optInt("accepted_width", -1), jSONObject.optInt("accepted_height", -1)).withExpressImageAcceptedSize(jSONObject.optInt("accepted_image_width", -1), jSONObject.optInt("accepted_image_height", -1)).withMinaId(jSONObject.optLong("mina_id", 0L)).withSlideInternal(jSONObject.optInt("slide_interval_seconds", 30)).build();
            }
        }
        return null;
    }

    private static JSONObject loadRequestFacts(DirichletAdRequest dirichletAdRequest) {
        JSONObject jSONObject = new JSONObject();
        if (dirichletAdRequest == null) {
            return jSONObject;
        }
        put(jSONObject, "query", dirichletAdRequest.query);
        put(jSONObject, "reward_user_id", dirichletAdRequest.userId);
        put(jSONObject, "reward_extra", dirichletAdRequest.extra1);
        put(jSONObject, "reward_name", dirichletAdRequest.rewardName);
        put(jSONObject, "reward_amount", Integer.valueOf(dirichletAdRequest.rewardAmount));
        put(jSONObject, "accepted_width", Integer.valueOf(dirichletAdRequest.expressViewAcceptedWidth));
        put(jSONObject, "accepted_height", Integer.valueOf(dirichletAdRequest.expressViewAcceptedHeight));
        put(jSONObject, "accepted_image_width", Integer.valueOf(dirichletAdRequest.expressImageAcceptedWidth));
        put(jSONObject, "accepted_image_height", Integer.valueOf(dirichletAdRequest.expressImageAcceptedHeight));
        put(jSONObject, "mina_id", Long.valueOf(dirichletAdRequest.minaId));
        put(jSONObject, "slide_interval_seconds", Integer.valueOf(dirichletAdRequest.slideInternal));
        return jSONObject;
    }

    private static long nowMs() {
        return SystemClock.elapsedRealtime();
    }

    private JSONArray objectFacts(Session session) {
        JSONArray jSONArray = new JSONArray();
        Iterator<ObjectRecord> it = session.objects.values().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().fact());
        }
        return jSONArray;
    }

    private void postDeliveryError(final Delivery delivery, final int i, final String str) {
        if (delivery == null) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                delivery.error(i, str);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0002, B:5:0x0007, B:22:0x003c, B:19:0x0033, B:6:0x000e, B:8:0x0012, B:9:0x0019, B:11:0x001d, B:12:0x0024, B:14:0x0028), top: B:26:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x003c A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0002, B:5:0x0007, B:22:0x003c, B:19:0x0033, B:6:0x000e, B:8:0x0012, B:9:0x0019, B:11:0x001d, B:12:0x0024, B:14:0x0028), top: B:26:0x0002 }] */
    private static String providerKey(Object obj) {
        Map<String, Object> dirichletExtraInfo;
        try {
            Object obj2 = null;
            if (obj instanceof DirichletRewardVideoAd) {
                dirichletExtraInfo = ((DirichletRewardVideoAd) obj).getDirichletExtraInfo();
            } else if (obj instanceof DirichletBannerAd) {
                dirichletExtraInfo = ((DirichletBannerAd) obj).getDirichletExtraInfo();
            } else {
                if (!(obj instanceof DirichletInterstitialAd)) {
                    if (obj instanceof DirichletSplashAd) {
                        dirichletExtraInfo = ((DirichletSplashAd) obj).getDirichletExtraInfo();
                    } else {
                        dirichletExtraInfo = null;
                    }
                    if (dirichletExtraInfo == null) {
                        obj2 = dirichletExtraInfo.get("track_id");
                    }
                    if (obj2 == null) {
                        return "";
                    }
                    return String.valueOf(obj2);
                }
                dirichletExtraInfo = ((DirichletInterstitialAd) obj).getDirichletExtraInfo();
            }
            if (dirichletExtraInfo == null) {
                obj2 = dirichletExtraInfo.get("track_id");
            }
            if (obj2 == null) {
                return "";
            }
            return String.valueOf(obj2);
        } catch (Throwable th) {
            return "";
        }
    }

    private ProviderSubmission providerSubmission(Session session, Object obj) {
        for (int size = session.providerIdentities.size() - 1; size >= 0; size--) {
            ProviderIdentity providerIdentity = session.providerIdentities.get(size);
            Object obj2 = providerIdentity.providerObject.get();
            if (obj2 == null) {
                session.providerIdentities.remove(size);
            } else if (obj2 == obj) {
                ObjectRecord objectRecord = session.objects.get(Long.valueOf(providerIdentity.handle));
                return objectRecord != null ? new ProviderSubmission(objectRecord, false) : new ProviderSubmission(new ObjectRecord(providerIdentity.handle, obj, providerKey(obj)), false);
            }
        }
        long jIncrementAndGet = session.nextHandle.incrementAndGet();
        ObjectRecord objectRecord2 = new ObjectRecord(jIncrementAndGet, obj, providerKey(obj));
        session.providerIdentities.add(new ProviderIdentity(jIncrementAndGet, obj));
        session.objects.put(Long.valueOf(jIncrementAndGet), objectRecord2);
        return new ProviderSubmission(objectRecord2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void put(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th) {
        }
    }

    private void retireSession(Session session) {
        if (session != null) {
            int i = 0;
            if (session.destroyed.compareAndSet(false, true)) {
                if (this.sessions.get(session.locator) == session) {
                    this.sessions.remove(session.locator);
                }
                Iterator<Runnable> it = session.wakeTasks.values().iterator();
                while (it.hasNext()) {
                    SchedulerNativeBridge.cancelWake(it.next());
                }
                session.wakeTasks.clear();
                JSONObject jSONObjectBaseInput = baseInput(session);
                put(jSONObjectBaseInput, "pool_id", Long.valueOf(session.poolId));
                MediationPoolCoreBridge.Result resultTransform = MediationPoolCoreBridge.transform(session.module, 12, jSONObjectBaseInput);
                if (resultTransform.isSuccess()) {
                    executeCommands(session, resultTransform.output.optJSONArray("commands"), null);
                }
                ArrayList arrayList = new ArrayList(session.pendingDeliveries.values());
                session.pendingDeliveries.clear();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    postDeliveryError((Delivery) obj, LoginAction.LOGIN_CANCEL, "无填充");
                }
                ArrayList arrayList2 = new ArrayList(session.objects.values());
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    ObjectRecord objectRecord = (ObjectRecord) obj2;
                    final ObjectRecord objectRecordRemove = session.objects.remove(Long.valueOf(objectRecord.handle));
                    session.leases.remove(Long.valueOf(objectRecord.handle));
                    if (objectRecordRemove != null) {
                        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.9
                            @Override // java.lang.Runnable
                            public void run() {
                                MediationAutoPoolShell.destroy(objectRecordRemove.providerObject);
                            }
                        });
                    }
                }
                session.providerIdentities.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean runOnPoolQueue(Runnable runnable) {
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (!dirichletRuntime.isOnRuntimeQueue()) {
            return dirichletRuntime.runOnRuntimeQueue(runnable);
        }
        runnable.run();
        return true;
    }

    private Session session(String str, DirichletAdRequest dirichletAdRequest, boolean z) {
        WasmModule module;
        Locator locator = new Locator(dirichletAdRequest.spaceId, str);
        JSONObject jSONObject = new JSONObject();
        put(jSONObject, "platform", "android");
        put(jSONObject, "control_scope", "current");
        put(jSONObject, Constants.Bidding.SPACE_ID, String.valueOf(dirichletAdRequest.spaceId));
        put(jSONObject, "format", str);
        put(jSONObject, "scope_id", this.scopeId);
        put(jSONObject, "mode", "auto");
        put(jSONObject, "explicit_auto", Boolean.valueOf(z));
        put(jSONObject, "loading_enabled", Boolean.FALSE);
        put(jSONObject, "provider_ready", Boolean.valueOf(hostReady()));
        put(jSONObject, "foreground", Boolean.valueOf(LifecycleRelay.isForeground()));
        put(jSONObject, "load_request", loadRequestFacts(dirichletAdRequest));
        put(jSONObject, "now_ms", Long.valueOf(nowMs()));
        try {
            module = DirichletRuntime.getInstance().getModule("core");
        } catch (Throwable th) {
            module = null;
        }
        MediationPoolCoreBridge.Result resultTransform = MediationPoolCoreBridge.transform(module, 1, jSONObject);
        if (!resultTransform.isSuccess()) {
            return null;
        }
        long jOptLong = resultTransform.output.optLong("pool_id", 0L);
        if (jOptLong <= 0) {
            return null;
        }
        Session session = this.sessions.get(locator);
        if (session != null && !session.destroyed.get() && session.poolId == jOptLong && session.module == module) {
            executeCommands(session, resultTransform.output.optJSONArray("commands"), null);
            return session;
        }
        if (session != null) {
            retireSession(session);
        }
        Session session2 = new Session(locator, jOptLong, module);
        this.sessions.put(locator, session2);
        executeCommands(session2, resultTransform.output.optJSONArray("commands"), null);
        return session2;
    }

    private void submitLoadFailure(Session session, long j, int i, String str) {
        m25lambda$enqueueLoadFailure$11$comtapsdktapadgroupMediationAutoPoolShell(session, j, i, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submitLoadSuccess, reason: merged with bridge method [inline-methods] */
    public void m26lambda$enqueueLoadSuccess$9$comtapsdktapadgroupMediationAutoPoolShell(Session session, long j, Object obj) {
        if (obj == null) {
            submitLoadFailure(session, j, -1, "null provider object");
            return;
        }
        ProviderSubmission providerSubmission = providerSubmission(session, obj);
        ObjectRecord objectRecord = providerSubmission.record;
        long j2 = objectRecord.handle;
        long j3 = session.poolId;
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "load_token", Long.valueOf(j));
        put(jSONObjectBaseInput, NotificationCompat.CATEGORY_STATUS, TrackAction.SUCCESS);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(objectRecord.fact());
        put(jSONObjectBaseInput, "objects", jSONArray);
        if (invoke(session, 6, jSONObjectBaseInput, null)) {
            return;
        }
        final ObjectRecord objectRecordRemove = providerSubmission.inserted ? session.objects.remove(Long.valueOf(j2)) : null;
        if (objectRecordRemove != null) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell.5
                @Override // java.lang.Runnable
                public void run() {
                    MediationAutoPoolShell.destroy(objectRecordRemove.providerObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void take(Session session, DirichletAdRequest dirichletAdRequest, Delivery delivery) {
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "objects", objectFacts(session));
        put(jSONObjectBaseInput, "load_request", loadRequestFacts(dirichletAdRequest));
        if (invoke(session, 5, jSONObjectBaseInput, delivery)) {
            return;
        }
        postDeliveryError(delivery, LoginAction.LOGIN_CANCEL, "无填充");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tick(final Session session, final boolean z) {
        runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m33lambda$tick$13$comtapsdktapadgroupMediationAutoPoolShell(session, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tickAll(final boolean z) {
        runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m34lambda$tickAll$14$comtapsdktapadgroupMediationAutoPoolShell(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tickOnPoolQueue, reason: merged with bridge method [inline-methods] */
    public void m33lambda$tick$13$comtapsdktapadgroupMediationAutoPoolShell(Session session, boolean z) {
        if (session == null || session.destroyed.get()) {
            return;
        }
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "foreground", Boolean.valueOf(z));
        put(jSONObjectBaseInput, "objects", objectFacts(session));
        invoke(session, 9, jSONObjectBaseInput, null);
    }

    private void trackAutoShow(Session session, ObjectRecord objectRecord) {
        HashMap map = new HashMap();
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_ID_FIELD, Long.valueOf(session.locator.spaceId));
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_TYPE_FIELD, session.locator.format);
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_TRACK_ID_FIELD, objectRecord.providerKey);
        MediationTelemetryHost.report(1, map);
    }

    private void trackInvalid(Session session, ObjectRecord objectRecord) {
        HashMap map = new HashMap();
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_ID_FIELD, Long.valueOf(session.locator.spaceId));
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_TYPE_FIELD, session.locator.format);
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_TRACK_ID_FIELD, objectRecord.providerKey);
        MediationTelemetryHost.report(27, map);
    }

    private void trackPreload(DirichletAdRequest dirichletAdRequest, AdType adType) {
        HashMap map = new HashMap();
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_ID_FIELD, Long.valueOf(dirichletAdRequest.spaceId));
        map.put(com.tapsdk.tapad.group.constants.Constants.AD_SPACE_TYPE_FIELD, adType);
        MediationTelemetryHost.report(4, map);
    }

    /* JADX INFO: renamed from: lambda$enqueueLeaseEvent$15$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m24lambda$enqueueLeaseEvent$15$comtapsdktapadgroupMediationAutoPoolShell(Session session, long j, long j2, String str, boolean z, Runnable runnable) {
        if (!leaseEvent(session, j, j2, str, z) || runnable == null) {
            return;
        }
        this.mainHandler.post(runnable);
    }

    /* JADX INFO: renamed from: lambda$preloadReward$0$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m27lambda$preloadReward$0$comtapsdktapadgroupMediationAutoPoolShell(DirichletAdRequest dirichletAdRequest) {
        Session session = session(FORMAT_REWARD, dirichletAdRequest, false);
        if (session == null) {
            return;
        }
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "load_request", loadRequestFacts(dirichletAdRequest));
        invoke(session, 4, jSONObjectBaseInput, null);
    }

    /* JADX INFO: renamed from: lambda$showBanner$5$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m28lambda$showBanner$5$comtapsdktapadgroupMediationAutoPoolShell(Session session, DirichletAdRequest dirichletAdRequest, Context context, ViewGroup viewGroup, DirichletAdNative.BannerAutoAdListener bannerAutoAdListener) {
        new BannerController(session, dirichletAdRequest, context, viewGroup, bannerAutoAdListener).start();
    }

    /* JADX INFO: renamed from: lambda$showBanner$6$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m29lambda$showBanner$6$comtapsdktapadgroupMediationAutoPoolShell(final DirichletAdRequest dirichletAdRequest, final DirichletAdNative.BannerAutoAdListener bannerAutoAdListener, final Context context, final ViewGroup viewGroup) {
        final Session session = session("banner", dirichletAdRequest, true);
        if (session == null) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    MediationAutoPoolShell.fail(bannerAutoAdListener, LoginAction.LOGIN_CANCEL, "无填充");
                }
            });
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m28lambda$showBanner$5$comtapsdktapadgroupMediationAutoPoolShell(session, dirichletAdRequest, context, viewGroup, bannerAutoAdListener);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$showInterstitial$2$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m30lambda$showInterstitial$2$comtapsdktapadgroupMediationAutoPoolShell(DirichletAdRequest dirichletAdRequest, Delivery delivery) {
        Session session = session("interstitial", dirichletAdRequest, true);
        if (session == null) {
            postDeliveryError(delivery, LoginAction.LOGIN_CANCEL, "无填充");
        } else {
            take(session, dirichletAdRequest, delivery);
        }
    }

    /* JADX INFO: renamed from: lambda$showReward$1$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m31lambda$showReward$1$comtapsdktapadgroupMediationAutoPoolShell(DirichletAdRequest dirichletAdRequest, Delivery delivery) {
        Session session = session(FORMAT_REWARD, dirichletAdRequest, true);
        if (session == null) {
            postDeliveryError(delivery, LoginAction.LOGIN_CANCEL, "无填充");
        } else {
            take(session, dirichletAdRequest, delivery);
        }
    }

    /* JADX INFO: renamed from: lambda$showSplash$3$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m32lambda$showSplash$3$comtapsdktapadgroupMediationAutoPoolShell(DirichletAdRequest dirichletAdRequest, Delivery delivery) {
        Session session = session("splash", dirichletAdRequest, true);
        if (session == null) {
            postDeliveryError(delivery, LoginAction.LOGIN_CANCEL, "无填充");
        } else {
            take(session, dirichletAdRequest, delivery);
        }
    }

    /* JADX INFO: renamed from: lambda$tickAll$14$com-tapsdk-tapad-group-MediationAutoPoolShell, reason: not valid java name */
    /* synthetic */ void m34lambda$tickAll$14$comtapsdktapadgroupMediationAutoPoolShell(boolean z) {
        ArrayList arrayList = new ArrayList(this.sessions.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            m33lambda$tick$13$comtapsdktapadgroupMediationAutoPoolShell((Session) obj, z);
        }
    }

    public void preloadReward(final DirichletAdRequest dirichletAdRequest) {
        if (dirichletAdRequest == null) {
            return;
        }
        trackPreload(dirichletAdRequest, AdType.RewardedAd);
        runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m27lambda$preloadReward$0$comtapsdktapadgroupMediationAutoPoolShell(dirichletAdRequest);
            }
        });
    }

    public void showBanner(final DirichletAdRequest dirichletAdRequest, final Context context, final ViewGroup viewGroup, final DirichletAdNative.BannerAutoAdListener bannerAutoAdListener) {
        if (dirichletAdRequest == null || context == null || viewGroup == null || runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m29lambda$showBanner$6$comtapsdktapadgroupMediationAutoPoolShell(dirichletAdRequest, bannerAutoAdListener, context, viewGroup);
            }
        })) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                MediationAutoPoolShell.fail(bannerAutoAdListener, LoginAction.LOGIN_CANCEL, "无填充");
            }
        });
    }

    public void showInterstitial(final DirichletAdRequest dirichletAdRequest, Activity activity, DirichletAdNative.InterstitialAutoAdListener interstitialAutoAdListener) {
        if (dirichletAdRequest == null || activity == null) {
            return;
        }
        final InterstitialDelivery interstitialDelivery = new InterstitialDelivery(activity, interstitialAutoAdListener);
        if (runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m30lambda$showInterstitial$2$comtapsdktapadgroupMediationAutoPoolShell(dirichletAdRequest, interstitialDelivery);
            }
        })) {
            return;
        }
        postDeliveryError(interstitialDelivery, LoginAction.LOGIN_CANCEL, "无填充");
    }

    public void showReward(final DirichletAdRequest dirichletAdRequest, Activity activity, DirichletAdNative.RewardVideoAutoAdListener rewardVideoAutoAdListener) {
        if (dirichletAdRequest == null || activity == null) {
            return;
        }
        final RewardDelivery rewardDelivery = new RewardDelivery(activity, rewardVideoAutoAdListener);
        if (runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m31lambda$showReward$1$comtapsdktapadgroupMediationAutoPoolShell(dirichletAdRequest, rewardDelivery);
            }
        })) {
            return;
        }
        postDeliveryError(rewardDelivery, LoginAction.LOGIN_CANCEL, "无填充");
    }

    public void showSplash(final DirichletAdRequest dirichletAdRequest, ViewGroup viewGroup, DirichletAdNative.SplashAutoAdListener splashAutoAdListener) {
        if (viewGroup == null) {
            ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.CONTAINER_NULL;
            fail(splashAutoAdListener, errorCodeEnum.getCode(), errorCodeEnum.getDesc());
        } else {
            if (dirichletAdRequest == null) {
                return;
            }
            final SplashDelivery splashDelivery = new SplashDelivery(viewGroup, splashAutoAdListener);
            if (runOnPoolQueue(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAutoPoolShell$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m32lambda$showSplash$3$comtapsdktapadgroupMediationAutoPoolShell(dirichletAdRequest, splashDelivery);
                }
            })) {
                return;
            }
            postDeliveryError(splashDelivery, LoginAction.LOGIN_CANCEL, "无填充");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submitLoadFailure, reason: merged with bridge method [inline-methods] */
    public void m25lambda$enqueueLoadFailure$11$comtapsdktapadgroupMediationAutoPoolShell(Session session, long j, int i, String str, boolean z) {
        long j2 = session.poolId;
        JSONObject jSONObjectBaseInput = baseInput(session);
        put(jSONObjectBaseInput, "load_token", Long.valueOf(j));
        put(jSONObjectBaseInput, NotificationCompat.CATEGORY_STATUS, "failure");
        put(jSONObjectBaseInput, com.tapsdk.tapad.group.constants.Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        put(jSONObjectBaseInput, "error_message", str);
        put(jSONObjectBaseInput, "provider_error", Boolean.valueOf(z));
        put(jSONObjectBaseInput, "objects", new JSONArray());
        invoke(session, 6, jSONObjectBaseInput, null);
    }
}
