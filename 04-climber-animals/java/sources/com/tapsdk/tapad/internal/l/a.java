package com.tapsdk.tapad.internal.l;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.TapFeedAdView;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.feed.views.FeedAdVideoView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.MaterialInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class a implements TapFeedAd {
    private static final int w = 30;
    private WeakReference<Context> b;
    private final AdInfo d;
    private DownloadPresenter e;
    private com.tapsdk.tapad.internal.m.d<TapFeedAd> f;
    private ViewGroup g;
    private final View h;
    private final Map<ViewGroup, FeedAdVideoView> i;
    private final com.tapsdk.tapad.internal.l.b.a j;
    private TapAppDownloadListener k;
    private TapFeedAd.AdInteractionListener l;
    private int n;
    private final l p;
    private final n q;
    private final m r;
    private boolean s;
    private com.tapsdk.tapad.internal.tracker.b t;
    private TapFeedAd.VideoAdListener u;
    private TapFeedAd.ExpressRenderListener v;
    private final List<ImageInfo> a = new ArrayList();
    private AtomicBoolean c = new AtomicBoolean(false);
    CompositeDisposable m = new CompositeDisposable();
    private final TapFeedAd.AdClickPassiveListener o = new c();

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0617a implements View.OnClickListener {
        ViewOnClickListenerC0617a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
            }
            if (activityA == null || a.this.d == null || a.this.d.appInfo == null) {
                return;
            }
            com.tapsdk.tapad.internal.s.a.a(activityA, a.this.d.appInfo.appPermissionsLink, a.this.d);
        }
    }

    class b implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        final /* synthetic */ TapFeedAd.AdInteractionListener a;

        b(TapFeedAd.AdInteractionListener adInteractionListener) {
            this.a = adInteractionListener;
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            TapFeedAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdValidView(a.this);
            }
        }
    }

    class c implements TapFeedAd.AdClickPassiveListener {
        c() {
        }

        @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
        public void adCreativePassiveClick() {
            Activity activityA;
            DownloadPresenter downloadPresenter;
            com.tapsdk.tapad.internal.b jVar;
            if (((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.b, Integer.class, 0)).intValue() == 0 || (activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get())) == null || a.this.d == null || a.this.d.btnInteractionInfo == null) {
                return;
            }
            if (a.this.d.tapADTrackerObject != null) {
                a.this.d.tapADTrackerObject.a(0, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(s.a(a.this.d.clickMonitorUrls, 0), (Map<String, String>) null, a.this.d.getClickMonitorHeaderListWrapper());
            }
            AdInfo adInfoA = com.tapsdk.tapad.internal.j.c.a(a.this.a(), com.tapsdk.tapad.internal.j.c.a(a.this));
            if (adInfoA.btnInteractionInfo.interactionType != 1) {
                com.tapsdk.tapad.internal.s.a.a(activityA, false, adInfoA, a.this.e);
                return;
            }
            DownloadPresenter.DownloadState downloadStateC = a.this.e.c();
            if (downloadStateC != DownloadPresenter.DownloadState.STARTED && adInfoA.materialInfo != null && com.tapsdk.tapad.internal.utils.b.a(activityA, adInfoA.appInfo.packageName)) {
                boolean zB = com.tapsdk.tapad.internal.utils.b.b(activityA, adInfoA.appInfo.packageName);
                if (a.this.k != null) {
                    a.this.k.onInstalled();
                }
                if (zB) {
                    return;
                }
                TapADLogger.d("Feed广告 打开异常");
                return;
            }
            if (adInfoA.btnInteractionInfo.floatingLayerStyle == 1) {
                if (a.this.p != null) {
                    a.this.p.a(a.this);
                    return;
                }
                return;
            }
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                if (adInfoA.materialInfo == null) {
                    return;
                }
                downloadPresenter = a.this.e;
                jVar = new DownloadPresenter.j(adInfoA);
            } else if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                downloadPresenter = a.this.e;
                jVar = new DownloadPresenter.g();
            } else if (com.tapsdk.tapad.internal.a.a(activityA, adInfoA).exists()) {
                if (a.this.k != null) {
                    a.this.k.onDownloadComplete();
                }
                downloadPresenter = a.this.e;
                jVar = new DownloadPresenter.k(adInfoA);
            } else {
                downloadPresenter = a.this.e;
                jVar = new DownloadPresenter.i(adInfoA);
            }
            downloadPresenter.a(jVar);
        }

        @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
        public void adPassiveShow() {
            if (((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.b, Integer.class, 0)).intValue() == 0) {
                return;
            }
            if (a.this.d.tapADTrackerObject == null || a.this.d.tapADTrackerObject.a == null || !a.this.d.tapADTrackerObject.a.a) {
                com.tapsdk.tapad.internal.tracker.c.a().a(a.this.d.viewMonitorUrls, (Map<String, String>) null, a.this.d.getViewMonitorHeaderListWrapper());
            } else {
                a.this.d.tapADTrackerObject.a.b((Map<String, String>) null);
            }
        }
    }

    class d implements DownloadPresenter.h {

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.a$d$a, reason: collision with other inner class name */
        class C0618a implements Consumer<Boolean> {
            C0618a() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) throws Exception {
                if (!bool.booleanValue() || a.this.k == null) {
                    return;
                }
                a.this.k.onInstalled();
            }
        }

        class b implements Consumer<Throwable> {
            b() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        }

        class c implements ObservableOnSubscribe<Boolean> {
            c() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(Boolean.valueOf(a.this.d.materialInfo != null && com.tapsdk.tapad.internal.utils.b.a((Context) a.this.b.get(), a.this.d.appInfo.packageName)));
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.a$d$d, reason: collision with other inner class name */
        class C0619d implements Consumer<Boolean> {
            C0619d() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) throws Exception {
                if (!bool.booleanValue() || a.this.k == null) {
                    return;
                }
                a.this.k.onInstalled();
            }
        }

        class e implements Consumer<Throwable> {
            e() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        }

        class f implements ObservableOnSubscribe<Boolean> {
            f() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(Boolean.valueOf(a.this.e.c() != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a((Context) a.this.b.get(), a.this.d.appInfo.packageName)));
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        }

        d() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            if (a.this.k == null || a.this.d == null || a.this.d.materialInfo == null) {
                return;
            }
            a.this.m.add(Observable.create(new f()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0619d(), new e()));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            if (a.this.k != null) {
                a.this.k.onUpdateDownloadProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            if (a.this.k != null) {
                a.this.k.onDownloadStart();
                a.this.m.add(Observable.create(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0618a(), new b()));
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            a.this.e.a(new DownloadPresenter.k(a.this.d));
            if (a.this.k != null) {
                a.this.k.onDownloadComplete();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            if (a.this.k != null) {
                a.this.k.onDownloadError();
            }
        }
    }

    class e implements ComplianceInfo {
        e() {
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAdLogIconUrl() {
            return (a.this.d.logoInfo == null || a.this.d.logoInfo.logoImage == null) ? "" : a.this.d.logoInfo.logoImage.imageUrl;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAppName() {
            return a.this.d.materialInfo != null ? a.this.d.materialInfo.title : "";
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAppVersion() {
            return a.this.d.appInfo.appVersion;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getDeveloperName() {
            return a.this.d.appInfo.appDeveloper;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getFunctionDescUrl() {
            return a.this.d.appInfo.appDescUrl;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getPermissionUrl() {
            return a.this.d.appInfo.appPermissionsLink;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getPrivacyUrl() {
            return a.this.d.appInfo.appPrivacyPolicy;
        }
    }

    class f implements DownloadPresenter.h {

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.a$f$a, reason: collision with other inner class name */
        class C0620a implements Consumer<Boolean> {
            C0620a() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) throws Exception {
                if (!bool.booleanValue() || a.this.k == null) {
                    return;
                }
                a.this.k.onInstalled();
            }
        }

        class b implements Consumer<Throwable> {
            b() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        }

        class c implements ObservableOnSubscribe<Boolean> {
            c() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(Boolean.valueOf(a.this.d.materialInfo != null && com.tapsdk.tapad.internal.utils.b.a((Context) a.this.b.get(), a.this.d.appInfo.packageName)));
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        }

        class d implements Consumer<Boolean> {
            d() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) throws Exception {
                if (!bool.booleanValue() || a.this.k == null) {
                    return;
                }
                a.this.k.onInstalled();
            }
        }

        class e implements Consumer<Throwable> {
            e() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.a$f$f, reason: collision with other inner class name */
        class C0621f implements ObservableOnSubscribe<Boolean> {
            C0621f() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(Boolean.valueOf(a.this.e.c() != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a((Context) a.this.b.get(), a.this.d.appInfo.packageName)));
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        }

        f() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            if (a.this.k == null || a.this.d == null || a.this.d.materialInfo == null) {
                return;
            }
            a.this.m.add(Observable.create(new C0621f()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e()));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            if (a.this.k != null) {
                a.this.k.onUpdateDownloadProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            if (a.this.k != null) {
                a.this.k.onDownloadStart();
                a.this.m.add(Observable.create(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0620a(), new b()));
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            a.this.e.a(new DownloadPresenter.k(a.this.d));
            if (a.this.k != null) {
                a.this.k.onDownloadComplete();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            if (a.this.k != null) {
                a.this.k.onDownloadError();
            }
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ TapFeedAd.AdInteractionListener a;
        final /* synthetic */ View b;

        g(TapFeedAd.AdInteractionListener adInteractionListener, View view) {
            this.a = adInteractionListener;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.d != null && a.this.d.viewInteractionInfo != null) {
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
                if (activityA == null) {
                    activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
                }
                if (activityA != null) {
                    if (a.this.d.tapADTrackerObject != null) {
                        a.this.d.tapADTrackerObject.a(3, null);
                    } else {
                        com.tapsdk.tapad.internal.tracker.c.a().a(a.this.d.clickMonitorUrls, a.this.d.viewInteractionInfo, a.this.d.getClickMonitorHeaderListWrapper());
                    }
                    if (1 == a.this.d.viewInteractionInfo.interactionType && 1 == a.this.d.viewInteractionInfo.floatingLayerStyle) {
                        a.this.p.a(a.this, true);
                        return;
                    }
                    com.tapsdk.tapad.internal.s.a.a(activityA, true, a.this.d, a.this.e);
                }
            }
            TapFeedAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(this.b, a.this);
            }
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ TapFeedAd.AdInteractionListener a;
        final /* synthetic */ View b;

        h(TapFeedAd.AdInteractionListener adInteractionListener, View view) {
            this.a = adInteractionListener;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter;
            com.tapsdk.tapad.internal.b jVar;
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
            }
            if (activityA != null && a.this.d != null && a.this.d.btnInteractionInfo != null) {
                if (a.this.d.tapADTrackerObject != null) {
                    a.this.d.tapADTrackerObject.a(0, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(a.this.d.clickMonitorUrls), (Map<String, String>) null, a.this.d.getClickMonitorHeaderListWrapper());
                }
                if (a.this.d.btnInteractionInfo.interactionType == 1) {
                    DownloadPresenter.DownloadState downloadStateC = a.this.e.c();
                    if (downloadStateC != DownloadPresenter.DownloadState.STARTED && a.this.d.materialInfo != null && com.tapsdk.tapad.internal.utils.b.a(activityA, a.this.d.appInfo.packageName)) {
                        boolean zB = com.tapsdk.tapad.internal.utils.b.b(activityA, a.this.d.appInfo.packageName);
                        if (a.this.k != null) {
                            a.this.k.onInstalled();
                        }
                        if (!zB) {
                            TapADLogger.d("Feed广告 打开异常");
                        }
                    } else if (a.this.d.btnInteractionInfo.floatingLayerStyle != 1) {
                        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                            if (a.this.d.materialInfo != null) {
                                downloadPresenter = a.this.e;
                                jVar = new DownloadPresenter.j(a.this.d);
                            }
                        } else if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                            downloadPresenter = a.this.e;
                            jVar = new DownloadPresenter.g();
                        } else if (com.tapsdk.tapad.internal.a.a(activityA, a.this.d).exists()) {
                            if (a.this.k != null) {
                                a.this.k.onDownloadComplete();
                            }
                            downloadPresenter = a.this.e;
                            jVar = new DownloadPresenter.k(a.this.d);
                        } else {
                            downloadPresenter = a.this.e;
                            jVar = new DownloadPresenter.i(a.this.d);
                        }
                        downloadPresenter.a(jVar);
                    } else if (a.this.p != null) {
                        a.this.p.a(a.this);
                    }
                } else {
                    com.tapsdk.tapad.internal.s.a.a(activityA, false, a.this.d, a.this.e);
                }
            }
            TapFeedAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdCreativeClick(this.b, a.this);
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
            }
            if (activityA == null || a.this.d == null || a.this.d.appInfo == null) {
                return;
            }
            com.tapsdk.tapad.internal.s.a.a(activityA, a.this.d.appInfo.appDescUrl, a.this.d);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
            }
            if (activityA == null || a.this.d == null || a.this.d.appInfo == null) {
                return;
            }
            com.tapsdk.tapad.internal.s.a.a(activityA, a.this.d.appInfo.appPermissionsLink, a.this.d);
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a((Context) a.this.b.get());
            }
            if (activityA == null || a.this.d == null || a.this.d.appInfo == null) {
                return;
            }
            com.tapsdk.tapad.internal.s.a.a(activityA, a.this.d.appInfo.appPrivacyPolicy, a.this.d);
        }
    }

    public interface l {
        void a(TapFeedAd tapFeedAd);

        void a(TapFeedAd tapFeedAd, boolean z);

        void b(TapFeedAd tapFeedAd);
    }

    public interface m {
        com.tapsdk.tapad.internal.m.d<TapFeedAd> a(Activity activity);
    }

    public interface n {
        void a(AdType adType, boolean z, AdInfo adInfo, Map<String, Object> map);
    }

    public a(AdInfo adInfo, WeakReference<Context> weakReference, com.tapsdk.tapad.internal.m.d<TapFeedAd> dVar, Map<ViewGroup, FeedAdVideoView> map, com.tapsdk.tapad.internal.l.b.a aVar, l lVar, n nVar, m mVar) {
        this.n = 0;
        this.s = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.d, Integer.class, 0)).intValue() == 1;
        this.t = null;
        this.u = null;
        this.d = adInfo;
        this.b = weakReference;
        this.j = aVar;
        this.h = new View(weakReference.get());
        this.f = dVar;
        this.i = map;
        this.p = lVar;
        this.q = nVar;
        this.r = mVar;
        this.e = new DownloadPresenter(weakReference.get(), new d());
        this.n = adInfo.getDefaultOpenWebMode();
    }

    public AdInfo a() {
        return this.d;
    }

    public TapFeedAd.AdInteractionListener b() {
        return this.l;
    }

    public WeakReference<Context> c() {
        return this.b;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void closeDownloadFloatingDialog() {
        this.p.b(this);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void closeVideoVolume() {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView != null && feedAdVideoView.getInUserController()) {
            feedAdVideoView.a();
        }
    }

    public DownloadPresenter d() {
        return this.e;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void dispose() {
        if (!this.m.isDisposed()) {
            this.m.dispose();
        }
        if (this.f != null) {
            try {
                FeedAdVideoView feedAdVideoView = this.i.get(this.g);
                if (feedAdVideoView != null) {
                    feedAdVideoView.m();
                }
            } catch (Throwable unused) {
            }
            this.f.a(this.g);
            this.f.a();
        }
        com.tapsdk.tapad.internal.tracker.b bVar = this.t;
        if (bVar != null) {
            bVar.d();
        }
    }

    public View e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return ((a) obj).d.trackId.equals(this.d.trackId);
        }
        return false;
    }

    public TapAppDownloadListener f() {
        return this.k;
    }

    public boolean g() {
        return this.s;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public TapFeedAd.AdClickPassiveListener getAdClickPassiveListener() {
        return this.o;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public View getAdView() {
        if (this.b.get() == null) {
            return null;
        }
        ViewGroup viewGroup = this.g;
        if (viewGroup == null) {
            return new View(this.b.get());
        }
        FeedAdVideoView feedAdVideoView = this.i.get(viewGroup);
        if (!(feedAdVideoView != null)) {
            FeedAdVideoView feedAdVideoView2 = new FeedAdVideoView(com.tapsdk.tapad.internal.utils.a.a(this.b.get()));
            feedAdVideoView2.setVideoAdListener(this.u);
            feedAdVideoView2.a(this.j);
            this.i.put(this.g, feedAdVideoView2);
            feedAdVideoView2.setExposureHandler(this.t);
            feedAdVideoView = feedAdVideoView2;
        }
        feedAdVideoView.a(this);
        return feedAdVideoView;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public String getApkSize() {
        AppInfo appInfo = this.d.appInfo;
        return (appInfo == null || !q.a(appInfo.appSize)) ? "" : this.d.appInfo.appSize;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public ComplianceInfo getComplianceInfo() {
        return new e();
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public String getDescription() {
        MaterialInfo materialInfo = this.d.materialInfo;
        return materialInfo != null ? materialInfo.description : "";
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public String getIconUrl() {
        ImageInfo imageInfo = this.d.appInfo.appIconImage;
        return imageInfo != null ? imageInfo.imageUrl : "";
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public List<ImageInfo> getImageInfoList() {
        MaterialInfo materialInfo = this.d.materialInfo;
        return materialInfo != null ? materialInfo.imageInfoList : this.a;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public int getImageMode() {
        return this.d.materialInfo.materialType;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public int getInteractionType() {
        InteractionInfo interactionInfo;
        AdInfo adInfo = this.d;
        if (adInfo == null || (interactionInfo = adInfo.btnInteractionInfo) == null) {
            return 0;
        }
        return interactionInfo.interactionType;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public Map<String, Object> getMediaExtraInfo() {
        return this.d.mediaExtraInfoMap;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public float getScore() {
        return this.d.appInfo.tapScore;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public String getTitle() {
        MaterialInfo materialInfo = this.d.materialInfo;
        return materialInfo != null ? materialInfo.title : "";
    }

    public int hashCode() {
        return Objects.hash(this.d.trackId);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void openVideoVolume() {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView != null && feedAdVideoView.getInUserController()) {
            feedAdVideoView.d();
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, TapFeedAd.AdInteractionListener adInteractionListener) {
        if (this.s && this.c.compareAndSet(false, true)) {
            WeakReference<Context> weakReference = new WeakReference<>(viewGroup.getContext());
            this.b = weakReference;
            this.e = new DownloadPresenter(weakReference.get(), new f());
            this.f = this.r.a(activity);
        }
        registerViewForInteraction(viewGroup, list, list2, list3, list4, list5, adInteractionListener);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, TapFeedAd.AdInteractionListener adInteractionListener) {
        if (adInteractionListener != null) {
            this.l = adInteractionListener;
        }
        if (list != null) {
            for (View view : list) {
                view.setOnClickListener(new g(adInteractionListener, view));
            }
        }
        if (list2 != null) {
            for (View view2 : list2) {
                view2.setOnClickListener(new h(adInteractionListener, view2));
            }
            if (list3 != null) {
                Iterator<View> it = list3.iterator();
                while (it.hasNext()) {
                    it.next().setOnClickListener(new i());
                }
            }
            if (list5 != null) {
                Iterator<View> it2 = list5.iterator();
                while (it2.hasNext()) {
                    it2.next().setOnClickListener(new j());
                }
            }
            if (list4 != null) {
                Iterator<View> it3 = list4.iterator();
                while (it3.hasNext()) {
                    it3.next().setOnClickListener(new k());
                }
            }
            if (list5 != null) {
                Iterator<View> it4 = list5.iterator();
                while (it4.hasNext()) {
                    it4.next().setOnClickListener(new ViewOnClickListenerC0617a());
                }
            }
            com.tapsdk.tapad.internal.m.d<TapFeedAd> dVar = this.f;
            if (dVar != null) {
                dVar.a(viewGroup, this, 30);
            }
            this.g = viewGroup;
            if (viewGroup != null) {
                com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewGroup, new b(adInteractionListener));
                this.t = bVar;
                bVar.a(this.d.tapADTrackerObject.a);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:64:0x00cd. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.TapFeedAd
    public void render(Activity activity, FeedOption feedOption) {
        int i2;
        int i3;
        TapFeedAdView tapFeedAdView;
        KeyEvent.Callback progressBar;
        int i4;
        if (activity == null) {
            TapFeedAd.ExpressRenderListener expressRenderListener = this.v;
            if (expressRenderListener != null) {
                expressRenderListener.onRenderFail(null, this, ErrorCodeEnum.COMMON_PARAM_INTERERROR.getCode(), "context 为空");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        String expressFeedAdStyle = this.d.getExpressFeedAdStyle();
        expressFeedAdStyle.hashCode();
        byte b2 = -1;
        switch (expressFeedAdStyle.hashCode()) {
            case -1848412765:
                if (expressFeedAdStyle.equals("feed_mini_text_image_score")) {
                    b2 = 0;
                }
                break;
            case -1550452373:
                if (expressFeedAdStyle.equals("feed_mini_image_text_score")) {
                    b2 = 1;
                }
                break;
            case -823254897:
                if (expressFeedAdStyle.equals("feed_text_image_download_1")) {
                    b2 = 2;
                }
                break;
            case -823254896:
                if (expressFeedAdStyle.equals("feed_text_image_download_2")) {
                    b2 = 3;
                }
                break;
            case -10273062:
                if (expressFeedAdStyle.equals("feed_mini_image_text_default")) {
                    b2 = 4;
                }
                break;
            case 273881101:
                if (expressFeedAdStyle.equals("feed_text_float_default")) {
                    b2 = 5;
                }
                break;
            case 958213973:
                if (expressFeedAdStyle.equals("feed_image_text_download")) {
                    b2 = 6;
                }
                break;
            case 1375964957:
                if (expressFeedAdStyle.equals("feed_text_image_score")) {
                    b2 = 7;
                }
                break;
            case 1412599058:
                if (expressFeedAdStyle.equals("feed_mini_text_image_default")) {
                    b2 = 8;
                }
                break;
            case 1440026976:
                if (expressFeedAdStyle.equals("feed_text_float_only")) {
                    b2 = 9;
                }
                break;
            case 1673925349:
                if (expressFeedAdStyle.equals("feed_image_text_score")) {
                    b2 = 10;
                }
                break;
            case 1694532446:
                if (expressFeedAdStyle.equals("feed_text_float_score")) {
                    b2 = 11;
                }
                break;
            case 1945297364:
                if (expressFeedAdStyle.equals("feed_image_text_default")) {
                    b2 = 12;
                }
                break;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
        switch (b2) {
            case 0:
                i2 = R.layout.tapad_feed_ad_view_mini_text_image_score;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 1:
                i2 = R.layout.tapad_feed_ad_view_mini_image_text_score;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 2:
                i3 = R.layout.tapad_feed_ad_view_text_image_download_first;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i3, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getBtnInteraction());
                progressBar = tapFeedAdView.getProgressBar();
                arrayList.add(progressBar);
                break;
            case 3:
                i3 = R.layout.tapad_feed_ad_view_text_image_download_two;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i3, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getBtnInteraction());
                progressBar = tapFeedAdView.getProgressBar();
                arrayList.add(progressBar);
                break;
            case 4:
                i2 = R.layout.tapad_feed_ad_view_mini_image_text_default;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 5:
                i2 = R.layout.tapad_feed_ad_view_text_float_default;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 6:
                i3 = R.layout.tapad_feed_ad_view_image_text_download;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i3, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getBtnInteraction());
                progressBar = tapFeedAdView.getProgressBar();
                arrayList.add(progressBar);
                break;
            case 7:
                i4 = R.layout.tapad_feed_ad_view_text_image_score;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i4, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                progressBar = tapFeedAdView.getAdVideoView();
                arrayList.add(progressBar);
                break;
            case 8:
                i2 = R.layout.tapad_feed_ad_view_mini_text_image_default;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 9:
                i2 = R.layout.tapad_feed_ad_view_text_float_only;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 10:
                i4 = R.layout.tapad_feed_ad_view_image_text_score;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i4, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                progressBar = tapFeedAdView.getAdVideoView();
                arrayList.add(progressBar);
                break;
            case 11:
                i2 = R.layout.tapad_feed_ad_view_text_float_score;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i2, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                arrayList.add(tapFeedAdView.getAdVideoView());
                tapFeedAdView.setVolumeImageVisible(8);
                break;
            case 12:
                i4 = R.layout.tapad_feed_ad_view_image_text_default;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i4, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                progressBar = tapFeedAdView.getAdVideoView();
                arrayList.add(progressBar);
                break;
            default:
                i4 = R.layout.tapad_feed_ad_view_text_image_default;
                tapFeedAdView = (TapFeedAdView) layoutInflaterFrom.inflate(i4, (ViewGroup) null);
                tapFeedAdView.a(this, feedOption, this.v, this.u);
                arrayList.add(tapFeedAdView.getAdImageView());
                progressBar = tapFeedAdView.getAdVideoView();
                arrayList.add(progressBar);
                break;
        }
        tapFeedAdView.a(arrayList);
        this.v.onRenderSuccess(tapFeedAdView);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void render(FeedOption feedOption) {
        render(com.tapsdk.tapad.internal.utils.a.a(this.b.get()), feedOption);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void sendLossNotification(Map<String, Object> map) {
        n nVar = this.q;
        if (nVar != null) {
            nVar.a(AdType.NativeFeedAd, false, this.d, map);
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void sendWinNotification(Map<String, Object> map) {
        n nVar = this.q;
        if (nVar != null) {
            nVar.a(AdType.NativeFeedAd, true, this.d, map);
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void setDownloadListener(TapAppDownloadListener tapAppDownloadListener) {
        if (tapAppDownloadListener == null) {
            return;
        }
        this.k = tapAppDownloadListener;
        DownloadPresenter.DownloadState downloadStateC = this.e.c();
        if (this.e.d()) {
            this.k.onInstalled();
            return;
        }
        if (downloadStateC.equals(DownloadPresenter.DownloadState.DEFAULT)) {
            this.k.onIdle();
            return;
        }
        if (downloadStateC.equals(DownloadPresenter.DownloadState.ERROR)) {
            this.k.onDownloadError();
            return;
        }
        if (downloadStateC.equals(DownloadPresenter.DownloadState.STARTED)) {
            this.k.onDownloadStart();
            this.k.onUpdateDownloadProgress(this.e.b());
        } else if (downloadStateC.equals(DownloadPresenter.DownloadState.COMPLETE)) {
            this.k.onDownloadComplete();
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void setExpressRenderListener(TapFeedAd.ExpressRenderListener expressRenderListener) {
        this.v = expressRenderListener;
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void setVideoAdListener(TapFeedAd.VideoAdListener videoAdListener) {
        this.u = videoAdListener;
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView == null) {
            return;
        }
        feedAdVideoView.setVideoAdListener(videoAdListener);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void setVideoPlaySelfController(boolean z) {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView == null) {
            return;
        }
        feedAdVideoView.setInUserController(z);
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void setVolumeVisible(boolean z) {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView != null && feedAdVideoView.getInUserController()) {
            feedAdVideoView.setVolumeVisible(z);
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void startVideoPlay() {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView != null && feedAdVideoView.getInUserController()) {
            feedAdVideoView.setFobiddenPlay(false);
            feedAdVideoView.k();
        }
    }

    @Override // com.tapsdk.tapad.TapFeedAd
    public void stopVideoPlay() {
        FeedAdVideoView feedAdVideoView = this.i.get(this.g);
        if (feedAdVideoView != null && feedAdVideoView.getInUserController()) {
            feedAdVideoView.setFobiddenPlay(true);
            feedAdVideoView.l();
        }
    }
}
