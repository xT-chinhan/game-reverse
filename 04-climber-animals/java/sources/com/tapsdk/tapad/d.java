package com.tapsdk.tapad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.InterErrCode;
import com.tapsdk.tapad.internal.feed.views.FeedAdVideoView;
import com.tapsdk.tapad.internal.ui.views.banner.LandscapeBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.TrainBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.WavesBannerView;
import com.tapsdk.tapad.internal.ui.views.splash.LandscapeSplashView;
import com.tapsdk.tapad.internal.ui.views.splash.PortraitSplashView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdConfiguration;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.MaterialInfo;
import com.tapsdk.tapad.model.entities.TrackBackData;
import com.tapsdk.tapad.stub.activity.Stub_Interstitial_Graphic_Landscape_Activity;
import com.tapsdk.tapad.stub.activity.Stub_Interstitial_Graphic_Portrait_Activity;
import com.tapsdk.tapad.stub.activity.Stub_Interstitial_Video_Landscape_Activity;
import com.tapsdk.tapad.stub.activity.Stub_Interstitial_Video_Portrait_Activity;
import com.tapsdk.tapad.stub.activity.Stub_Standard_Landscape_Activity;
import com.tapsdk.tapad.stub.activity.Stub_Standard_Portrait_Activity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class d implements TapAdNative {
    private static final String w = "TapAdNativeImpl";
    private static final String x = "receiver_action_finish";
    WeakReference<Context> a;
    public final TapAdConfig b;
    private final com.tapsdk.tapad.e.a c;
    private com.tapsdk.tapad.internal.m.d<TapFeedAd> f;
    private final com.tapsdk.tapad.internal.l.b.a m;
    private RelativeLayout n;
    private RelativeLayout o;
    private com.tapsdk.tapad.internal.l.d.a p;
    private final com.tapsdk.tapad.e.n d = new com.tapsdk.tapad.e.n();
    private final CompositeDisposable e = new CompositeDisposable();
    private final Set<com.tapsdk.tapad.internal.m.d.c<?>> g = new HashSet();
    private final Set<com.tapsdk.tapad.internal.m.d.c<?>> h = new HashSet();
    private final List<View> i = new ArrayList();
    private final List<View> j = new ArrayList();
    private final List<com.tapsdk.tapad.internal.m.d.c<?>> k = new ArrayList();
    private final Map<ViewGroup, FeedAdVideoView> l = new WeakHashMap();
    private volatile boolean q = false;
    private Set<String> r = new HashSet();
    private final ConcurrentHashMap<String, Boolean> s = new ConcurrentHashMap<>();
    private WeakHashMap<Context, com.tapsdk.tapad.internal.m.d<TapFeedAd>> t = new WeakHashMap<>();
    private com.tapsdk.tapad.internal.l.a.m u = new a();
    com.tapsdk.tapad.internal.l.a.l v = new l();

    class a implements com.tapsdk.tapad.internal.l.a.m {

        /* JADX INFO: renamed from: com.tapsdk.tapad.d$a$a, reason: collision with other inner class name */
        class C0579a implements com.tapsdk.tapad.internal.m.d.f {

            /* JADX INFO: renamed from: com.tapsdk.tapad.d$a$a$a, reason: collision with other inner class name */
            class C0580a implements Comparator<com.tapsdk.tapad.internal.m.d.c<?>> {
                C0580a() {
                }

                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(com.tapsdk.tapad.internal.m.d.c<?> cVar, com.tapsdk.tapad.internal.m.d.c<?> cVar2) {
                    com.tapsdk.tapad.internal.m.d.b bVar = cVar.e;
                    com.tapsdk.tapad.internal.m.d.b bVar2 = cVar2.e;
                    if (bVar == null) {
                        return -1;
                    }
                    if (bVar2 == null) {
                        return 1;
                    }
                    int i = bVar.a;
                    int i2 = bVar2.a;
                    if (i != i2) {
                        return i2 - i;
                    }
                    int i3 = bVar.c;
                    int i4 = bVar2.c;
                    return i3 != i4 ? i3 - i4 : bVar.b - bVar2.b;
                }
            }

            C0579a() {
            }

            @Override // com.tapsdk.tapad.internal.m.d.f
            public void a(Set<com.tapsdk.tapad.internal.m.d.c<?>> set, Set<com.tapsdk.tapad.internal.m.d.c<?>> set2) {
                if (d.this.q) {
                    return;
                }
                if (set != null && set.size() > 0) {
                    d.this.a(set);
                }
                d.this.h.clear();
                if (set != null) {
                    d.this.h.addAll(set);
                }
                d.this.g.clear();
                if (set2 != null) {
                    d.this.g.addAll(set2);
                }
                d.this.i.clear();
                d.this.k.clear();
                if (set != null) {
                    d.this.k.addAll(set);
                    Collections.sort(d.this.k, new C0580a());
                    Iterator it = d.this.k.iterator();
                    while (it.hasNext()) {
                        FeedAdVideoView feedAdVideoView = (FeedAdVideoView) ((com.tapsdk.tapad.internal.m.d.c) it.next()).a.findViewById(R.id.tapad_feedAdVideoContainerView);
                        if (feedAdVideoView != null) {
                            d.this.i.add(feedAdVideoView);
                        }
                    }
                }
                boolean z = false;
                for (int i = 0; i < d.this.i.size(); i++) {
                    try {
                        FeedAdVideoView feedAdVideoView2 = (FeedAdVideoView) d.this.i.get(i);
                        if (feedAdVideoView2.getForbiddenPlay() || z) {
                            feedAdVideoView2.m();
                        } else {
                            feedAdVideoView2.k();
                            z = true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                d.this.j.clear();
                if (set2 != null) {
                    Iterator<com.tapsdk.tapad.internal.m.d.c<?>> it2 = set2.iterator();
                    while (it2.hasNext()) {
                        FeedAdVideoView feedAdVideoView3 = (FeedAdVideoView) it2.next().a.findViewById(R.id.tapad_feedAdVideoContainerView);
                        if (feedAdVideoView3 != null) {
                            d.this.j.add(feedAdVideoView3);
                        }
                    }
                }
                for (int i2 = 0; i2 < d.this.j.size(); i2++) {
                    try {
                        ((FeedAdVideoView) d.this.j.get(i2)).m();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
            }
        }

        a() {
        }

        @Override // com.tapsdk.tapad.internal.l.a.m
        public com.tapsdk.tapad.internal.m.d<TapFeedAd> a(Activity activity) {
            if (d.this.t.containsKey(activity) && d.this.t.get(activity) != null) {
                return (com.tapsdk.tapad.internal.m.d) d.this.t.get(activity);
            }
            com.tapsdk.tapad.internal.m.d<TapFeedAd> dVar = new com.tapsdk.tapad.internal.m.d<>(activity);
            dVar.a(new C0579a());
            d.this.t.put(activity, dVar);
            return dVar;
        }
    }

    class a0 implements Function<List<AdInfo>, ObservableSource<? extends AdInfo>> {
        final /* synthetic */ AdRequest a;

        a0(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(List<AdInfo> list) throws Exception {
            if (list.size() <= 0) {
                int code = InterErrCode.COMMON_NO_AD_ERROR.getCode();
                String desc = InterErrCode.COMMON_NO_AD_ERROR.getDesc();
                AdRequest adRequest = this.a;
                throw new com.tapsdk.tapad.exceptions.d(code, desc, adRequest.spaceId, adRequest.requestId);
            }
            AdInfo adInfo = list.get(0);
            if (d.this.c(adInfo)) {
                adInfo.mediaId = d.this.b.mMediaId;
                return Observable.just(adInfo);
            }
            int code2 = InterErrCode.COMMON_INIT_ERROR.getCode();
            String desc2 = InterErrCode.COMMON_INIT_ERROR.getDesc();
            AdRequest adRequest2 = this.a;
            throw new com.tapsdk.tapad.exceptions.d(code2, desc2, adRequest2.spaceId, adRequest2.requestId);
        }
    }

    class b implements Function<AdInfo, ObservableSource<AdInfo>> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<AdInfo> apply(AdInfo adInfo) throws Exception {
            return d.this.d.a(adInfo);
        }
    }

    class b0 implements Consumer<AdInfo> {
        final /* synthetic */ TapAdNative.InterstitialAdListener a;
        final /* synthetic */ AdRequest b;

        class a implements TapInterstitialAd {
            TapInterstitialAd.InterstitialAdInteractionListener a;
            final /* synthetic */ AdInfo b;

            a(AdInfo adInfo) {
                this.b = adInfo;
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public void dispose() {
                String str;
                if (this.b.materialInfo.materialType != 2 && ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.e, Integer.class, -1)).intValue() == 1 && (str = this.b.trackId) != null && str.length() > 0) {
                    com.tapsdk.tapad.internal.utils.n.a().a(new com.tapsdk.tapad.stub.activity.a().a("track_id", this.b.trackId));
                }
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public Map<String, Object> getMediaExtraInfo() {
                return this.b.mediaExtraInfoMap;
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public void sendLossNotification(Map<String, Object> map) {
                d.this.a(AdType.InterstitialAd, false, this.b, map);
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public void sendWinNotification(Map<String, Object> map) {
                d.this.a(AdType.InterstitialAd, true, this.b, map);
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public void setInteractionListener(TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
                this.a = interstitialAdInteractionListener;
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd
            public void show(Activity activity) {
                AdInfo adInfo = this.b;
                int i = adInfo.materialInfo.materialType;
                if (i == 2) {
                    if (adInfo.renderStyles.c == 0) {
                        b0 b0Var = b0.this;
                        d.this.b(activity, adInfo, b0Var.b, this.a);
                        return;
                    }
                } else if (i != 1) {
                    return;
                }
                b0 b0Var2 = b0.this;
                d.this.a(activity, adInfo, b0Var2.b, this.a);
            }
        }

        b0(TapAdNative.InterstitialAdListener interstitialAdListener, AdRequest adRequest) {
            this.a = interstitialAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AdInfo adInfo) throws Exception {
            TapAdNative.InterstitialAdListener interstitialAdListener = this.a;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialAdLoad(new a(adInfo));
            }
        }
    }

    class c implements Function<AdInfo, ObservableSource<? extends AdInfo>> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(AdInfo adInfo) throws Exception {
            if (adInfo.materialInfo.imageInfoList.size() > 0) {
                ImageInfo imageInfo = adInfo.materialInfo.imageInfoList.get(0);
                Glide.with((Activity) d.this.a.get()).load(imageInfo.imageUrl).preload(imageInfo.width, imageInfo.height);
            }
            return Observable.just(adInfo);
        }
    }

    class c0 implements Consumer<Throwable> {
        final /* synthetic */ TapAdNative.InterstitialAdListener a;
        final /* synthetic */ AdRequest b;

        c0(TapAdNative.InterstitialAdListener interstitialAdListener, AdRequest adRequest) {
            this.a = interstitialAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            com.tapsdk.tapad.exceptions.b.a(th, this.a, this.b.spaceId, AdType.InterstitialAd);
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.d$d, reason: collision with other inner class name */
    class C0581d implements Function<List<AdInfo>, ObservableSource<? extends AdInfo>> {
        final /* synthetic */ AdRequest a;

        C0581d(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(List<AdInfo> list) throws Exception {
            if (list.size() <= 0) {
                int code = InterErrCode.COMMON_NO_AD_ERROR.getCode();
                String desc = InterErrCode.COMMON_NO_AD_ERROR.getDesc();
                AdRequest adRequest = this.a;
                throw new com.tapsdk.tapad.exceptions.d(code, desc, adRequest.spaceId, adRequest.requestId);
            }
            AdInfo adInfo = list.get(0);
            if (d.this.c(adInfo)) {
                adInfo.mediaId = d.this.b.mMediaId;
                return Observable.just(adInfo);
            }
            int code2 = InterErrCode.COMMON_INIT_ERROR.getCode();
            String desc2 = InterErrCode.COMMON_INIT_ERROR.getDesc();
            AdRequest adRequest2 = this.a;
            throw new com.tapsdk.tapad.exceptions.d(code2, desc2, adRequest2.spaceId, adRequest2.requestId);
        }
    }

    class e implements Consumer<AdInfo> {
        final /* synthetic */ TapAdNative.BannerAdListener a;

        class a implements TapBannerAd {
            View a = null;
            private TapBannerAd.BannerInteractionListener b;
            final /* synthetic */ AdInfo c;

            a(AdInfo adInfo) {
                this.c = adInfo;
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public void dispose() {
                View view = this.a;
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                    this.a = null;
                }
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public View getBannerView() {
                Context context = d.this.a.get();
                View view = this.a;
                if (view != null) {
                    return view;
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    int bannerStyle = this.c.getBannerStyle();
                    if (bannerStyle == 1) {
                        TrainBannerView trainBannerView = new TrainBannerView(activity);
                        this.a = trainBannerView;
                        trainBannerView.a(activity, this.c, this.b);
                    } else if (bannerStyle == 2) {
                        WavesBannerView wavesBannerView = new WavesBannerView(activity);
                        this.a = wavesBannerView;
                        wavesBannerView.a(activity, this.c, this.b);
                    } else if (this.c.renderStyles.d == 1) {
                        LandscapeBannerView landscapeBannerView = new LandscapeBannerView(activity);
                        this.a = landscapeBannerView;
                        landscapeBannerView.render(activity, this.c, null, this.b, true);
                    } else {
                        PortraitBannerView portraitBannerView = new PortraitBannerView(activity, this.c);
                        this.a = portraitBannerView;
                        portraitBannerView.render(activity, this.c, null, this.b, true);
                    }
                }
                return this.a;
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public Map<String, Object> getMediaExtraInfo() {
                return this.c.mediaExtraInfoMap;
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public void sendLossNotification(Map<String, Object> map) {
                d.this.a(AdType.Banner, false, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public void sendWinNotification(Map<String, Object> map) {
                d.this.a(AdType.Banner, true, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public void setBannerInteractionListener(TapBannerAd.BannerInteractionListener bannerInteractionListener) {
                this.b = bannerInteractionListener;
            }

            @Override // com.tapsdk.tapad.TapBannerAd
            public void show(Activity activity, int i, int i2) {
                int i3;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                if (i == 0) {
                    layoutParams.setMargins(0, i2, 0, 0);
                    i3 = 48;
                } else {
                    layoutParams.setMargins(0, 0, 0, i2);
                    i3 = 80;
                }
                layoutParams.gravity = i3;
                ((FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content)).addView(getBannerView(), layoutParams);
            }
        }

        e(TapAdNative.BannerAdListener bannerAdListener) {
            this.a = bannerAdListener;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AdInfo adInfo) throws Exception {
            this.a.onBannerAdLoad(new a(adInfo));
        }
    }

    class f implements Consumer<Throwable> {
        final /* synthetic */ TapAdNative.BannerAdListener a;
        final /* synthetic */ AdRequest b;

        f(TapAdNative.BannerAdListener bannerAdListener, AdRequest adRequest) {
            this.a = bannerAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            com.tapsdk.tapad.exceptions.b.a(th, this.a, this.b.spaceId, AdType.Banner);
        }
    }

    class g implements Function<List<AdInfo>, ObservableSource<? extends AdInfo>> {
        final /* synthetic */ AdRequest a;

        g(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(List<AdInfo> list) throws Exception {
            if (list.size() > 0) {
                AdInfo adInfo = list.get(0);
                adInfo.mediaId = d.this.b.mMediaId;
                return Observable.just(adInfo);
            }
            int code = InterErrCode.COMMON_NO_AD_ERROR.getCode();
            String desc = InterErrCode.COMMON_NO_AD_ERROR.getDesc();
            AdRequest adRequest = this.a;
            throw new com.tapsdk.tapad.exceptions.d(code, desc, adRequest.spaceId, adRequest.requestId);
        }
    }

    class h implements Consumer<AdInfo> {
        final /* synthetic */ TapAdNative.SplashAdListener a;
        final /* synthetic */ AdRequest b;

        class a implements TapSplashAd {
            private TapSplashAd.AdInteractionListener a;
            private View b;
            final /* synthetic */ AdInfo c;

            a(AdInfo adInfo) {
                this.c = adInfo;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void destroyView() {
                View view = this.b;
                if (view != null && view.getParent() != null) {
                    ((ViewGroup) this.b.getParent()).removeView(this.b);
                }
                View view2 = this.b;
                if (view2 != null && (view2 instanceof PortraitSplashView)) {
                    ((PortraitSplashView) view2).destroy();
                }
                View view3 = this.b;
                if (view3 != null && (view3 instanceof LandscapeSplashView)) {
                    ((LandscapeSplashView) view3).destroy();
                }
                this.b = null;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void dispose() {
                this.a = null;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public long getExpirationTimestamp() {
                return this.c.expireTime;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public Map<String, Object> getMediaExtraInfo() {
                return this.c.mediaExtraInfoMap;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public View getSplashView(Activity activity) {
                View view;
                View view2 = this.b;
                if (view2 != null) {
                    return view2;
                }
                if (this.c.renderStyles.d == 1) {
                    LandscapeSplashView landscapeSplashView = new LandscapeSplashView(activity);
                    landscapeSplashView.config(this.c, this.a);
                    view = landscapeSplashView;
                } else {
                    PortraitSplashView portraitSplashView = new PortraitSplashView(activity);
                    AdRequest adRequest = h.this.b;
                    portraitSplashView.resetExpectedAspectRatio(adRequest.expressViewAcceptedWidth, adRequest.expressViewAcceptedHeight);
                    portraitSplashView.config(this.c, this.a);
                    view = portraitSplashView;
                }
                this.b = view;
                return view;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void sendLossNotification(Map<String, Object> map) {
                d.this.a(AdType.SplashAd, false, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void sendWinNotification(Map<String, Object> map) {
                d.this.a(AdType.SplashAd, true, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void setSplashInteractionListener(TapSplashAd.AdInteractionListener adInteractionListener) {
                this.a = adInteractionListener;
            }

            @Override // com.tapsdk.tapad.TapSplashAd
            public void show(Activity activity) {
                ((FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content)).addView(getSplashView(activity));
            }
        }

        h(TapAdNative.SplashAdListener splashAdListener, AdRequest adRequest) {
            this.a = splashAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AdInfo adInfo) throws Exception {
            this.a.onSplashAdLoad(new a(adInfo));
        }
    }

    class i implements Consumer<Throwable> {
        final /* synthetic */ TapAdNative.SplashAdListener a;
        final /* synthetic */ AdRequest b;

        i(TapAdNative.SplashAdListener splashAdListener, AdRequest adRequest) {
            this.a = splashAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            com.tapsdk.tapad.exceptions.b.a(th, this.a, this.b.spaceId, AdType.SplashAd);
            d.this.a(this.b);
        }
    }

    class j implements Action {
        final /* synthetic */ AdRequest a;

        j(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            d.this.a(this.a);
        }
    }

    class k implements Function<AdInfo, ObservableSource<? extends AdInfo>> {
        k() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(AdInfo adInfo) throws Exception {
            MaterialInfo materialInfo;
            Activity activity = (Activity) d.this.a.get();
            if (activity != null && adInfo != null && (materialInfo = adInfo.materialInfo) != null && materialInfo.imageInfoList.size() > 0) {
                Glide.with(activity.getApplicationContext()).load(adInfo.materialInfo.imageInfoList.get(0).imageUrl).preload();
            }
            return Observable.just(adInfo);
        }
    }

    class l implements com.tapsdk.tapad.internal.l.a.l {

        class a implements com.tapsdk.tapad.internal.l.d.a.d {
            a() {
            }

            @Override // com.tapsdk.tapad.internal.l.d.a.d
            public void a() {
            }

            @Override // com.tapsdk.tapad.internal.l.d.a.d
            public void b() {
                d.this.p = null;
            }
        }

        l() {
        }

        @Override // com.tapsdk.tapad.internal.l.a.l
        public void a(TapFeedAd tapFeedAd) {
            a(tapFeedAd, false);
        }

        @Override // com.tapsdk.tapad.internal.l.a.l
        public void a(TapFeedAd tapFeedAd, boolean z) {
            com.tapsdk.tapad.internal.l.a aVar = (com.tapsdk.tapad.internal.l.a) tapFeedAd;
            if (aVar.c().get() == null) {
                return;
            }
            Activity activityA = aVar.e() != null ? com.tapsdk.tapad.internal.utils.a.a(aVar.e().getContext()) : null;
            if (activityA == null) {
                activityA = com.tapsdk.tapad.internal.utils.a.a(aVar.c().get());
            }
            if (com.tapsdk.tapad.internal.utils.a.b(activityA)) {
                return;
            }
            if (d.this.p == null || !d.this.p.isAdded()) {
                d.this.p = com.tapsdk.tapad.internal.l.d.a.a(aVar.a());
                d.this.p.a(aVar.d());
                d.this.p.a(new a());
                d.this.p.show(activityA.getFragmentManager(), com.tapsdk.tapad.internal.l.d.a.i);
                InteractionInfo interactionInfo = z ? aVar.a().viewInteractionInfo : aVar.a().btnInteractionInfo;
                if (interactionInfo == null || !interactionInfo.canStartDownloadInFloatingLayer()) {
                    return;
                }
                aVar.d().a((com.tapsdk.tapad.internal.b) new DownloadPresenter.j(aVar.a()));
            }
        }

        @Override // com.tapsdk.tapad.internal.l.a.l
        public void b(TapFeedAd tapFeedAd) {
            if (d.this.p == null || !d.this.p.isAdded()) {
                return;
            }
            d.this.p.dismiss();
        }
    }

    class m implements Function<List<AdInfo>, ObservableSource<? extends AdInfo>> {
        final /* synthetic */ AdRequest a;

        m(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(List<AdInfo> list) throws Exception {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet(d.this.c.d(this.a, d.this.b, AdType.SplashAd));
            for (AdInfo adInfo : list) {
                if (d.this.d(adInfo) && hashSet.contains(adInfo.trackId)) {
                    arrayList.add(adInfo);
                }
            }
            if (arrayList.size() <= 0) {
                throw new com.tapsdk.tapad.exceptions.d(InterErrCode.COMMON_NO_AD_ERROR.getCode(), InterErrCode.COMMON_NO_AD_ERROR.getDesc(), this.a.spaceId, "");
            }
            AdInfo adInfo2 = (AdInfo) arrayList.get(0);
            d dVar = d.this;
            adInfo2.mediaId = dVar.b.mMediaId;
            dVar.c.a(adInfo2.trackId, this.a, d.this.b, AdType.SplashAd);
            return Observable.just(adInfo2);
        }
    }

    class n implements Consumer<List<TapFeedAd>> {
        final /* synthetic */ TapAdNative.FeedAdListener a;

        n(TapAdNative.FeedAdListener feedAdListener) {
            this.a = feedAdListener;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<TapFeedAd> list) throws Exception {
            this.a.onFeedAdLoad(list);
        }
    }

    class o implements Consumer<Throwable> {
        final /* synthetic */ TapAdNative.FeedAdListener a;
        final /* synthetic */ AdRequest b;

        o(TapAdNative.FeedAdListener feedAdListener, AdRequest adRequest) {
            this.a = feedAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            com.tapsdk.tapad.exceptions.b.a(th, this.a, this.b.spaceId, AdType.NativeFeedAd);
        }
    }

    class p implements Function<List<AdInfo>, ObservableSource<List<TapFeedAd>>> {
        p() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<List<TapFeedAd>> apply(List<AdInfo> list) {
            d dVar = d.this;
            return Observable.just(dVar.a(list, Long.valueOf(dVar.b.mMediaId)));
        }
    }

    class q implements View.OnClickListener {
        final /* synthetic */ PopupWindow a;

        q(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    class r implements com.tapsdk.tapad.internal.e.a {
        final /* synthetic */ TapInterstitialAd.InterstitialAdInteractionListener a;
        final /* synthetic */ AdInfo b;
        final /* synthetic */ AdRequest c;

        r(TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener, AdInfo adInfo, AdRequest adRequest) {
            this.a = interstitialAdInteractionListener;
            this.b = adInfo;
            this.c = adRequest;
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void a(Throwable th) {
            d.this.s.remove(this.b.trackId);
            if (this.a != null) {
                int code = ErrorCodeEnum.COMMON_INTERSTITIAL_ERROR.getCode();
                String message = th.getMessage();
                AdRequest adRequest = this.c;
                com.tapsdk.tapad.exceptions.b.a(new com.tapsdk.tapad.exceptions.d(code, message, adRequest.spaceId, adRequest.requestId), null, this.c.spaceId, AdType.InterstitialAd);
                this.a.onAdError();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdClose() {
            d.this.s.remove(this.b.trackId);
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdClose();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdShow() {
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdShow();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdValidShow() {
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdValidShow();
            }
        }
    }

    class s implements com.tapsdk.tapad.internal.e.a {
        final /* synthetic */ TapInterstitialAd.InterstitialAdInteractionListener a;
        final /* synthetic */ AdInfo b;

        s(TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener, AdInfo adInfo) {
            this.a = interstitialAdInteractionListener;
            this.b = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void a(Throwable th) {
            d.this.s.remove(this.b.trackId);
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdError();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdClose() {
            d.this.s.remove(this.b.trackId);
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdClose();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdShow() {
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdShow();
            }
        }

        @Override // com.tapsdk.tapad.internal.e.a
        public void onAdValidShow() {
            TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.a;
            if (interstitialAdInteractionListener != null) {
                interstitialAdInteractionListener.onAdValidShow();
            }
        }
    }

    class t implements com.tapsdk.tapad.internal.l.a.n {
        t() {
        }

        @Override // com.tapsdk.tapad.internal.l.a.n
        public void a(AdType adType, boolean z, AdInfo adInfo, Map<String, Object> map) {
            d.this.a(adType, z, adInfo, map);
        }
    }

    class u implements Consumer<Boolean> {
        u() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
        }
    }

    class v implements Consumer<Throwable> {
        v() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class w implements Consumer<AdInfo> {
        final /* synthetic */ TapAdNative.RewardVideoAdListener a;
        final /* synthetic */ AdRequest b;

        class a implements TapRewardVideoAd {
            private TapRewardVideoAd.RewardAdInteractionListener a;
            private int b = Integer.MIN_VALUE;
            final /* synthetic */ AdInfo c;

            /* JADX INFO: renamed from: com.tapsdk.tapad.d$w$a$a, reason: collision with other inner class name */
            class C0582a implements com.tapsdk.tapad.internal.f.a {
                C0582a() {
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdClick() {
                    if (a.this.a != null) {
                        a.this.a.onAdClick();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdClose() {
                    if (a.this.a != null) {
                        a.this.a.onAdClose();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdShow() {
                    if (a.this.a != null) {
                        a.this.a.onAdShow();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdValidShow() {
                    if (a.this.a != null) {
                        a.this.a.onAdValidShow();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                    if (a.this.a != null) {
                        a.this.a.onRewardVerify(z, i, str, i2, str2);
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onSkippedVideo() {
                    if (a.this.a != null) {
                        a.this.a.onSkippedVideo();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onVideoComplete() {
                    if (a.this.a != null) {
                        a.this.a.onVideoComplete();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onVideoError() {
                    if (a.this.a != null) {
                        a.this.a.onVideoError();
                    }
                }
            }

            a(AdInfo adInfo) {
                this.c = adInfo;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void dispose() {
                this.a = null;
                int i = this.b;
                if (i != Integer.MIN_VALUE) {
                    com.tapsdk.tapad.internal.f.b(Integer.valueOf(i));
                }
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public Map<String, Object> getMediaExtraInfo() {
                return this.c.mediaExtraInfoMap;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void sendLossNotification(Map<String, Object> map) {
                d.this.a(AdType.RewardedAd, false, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void sendWinNotification(Map<String, Object> map) {
                d.this.a(AdType.RewardedAd, true, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void setRewardAdInteractionListener(TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
                this.a = rewardAdInteractionListener;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void showRewardVideoAd(Activity activity) {
                Intent intent = new Intent(activity, (Class<?>) (this.c.renderStyles.d != 1 ? Stub_Standard_Portrait_Activity.class : Stub_Standard_Landscape_Activity.class));
                C0582a c0582a = new C0582a();
                Bundle bundle = new Bundle();
                if (c0582a.hashCode() != Integer.MIN_VALUE) {
                    int iHashCode = c0582a.hashCode();
                    this.b = iHashCode;
                    com.tapsdk.tapad.internal.f.a(Integer.valueOf(iHashCode), c0582a);
                    TapADLogger.d("input callbackId:" + this.b);
                    bundle.putInt("c_id", this.b);
                }
                bundle.putParcelable("data", this.c);
                bundle.putParcelable("request", w.this.b);
                intent.putExtras(bundle);
                activity.startActivity(intent);
            }
        }

        w(TapAdNative.RewardVideoAdListener rewardVideoAdListener, AdRequest adRequest) {
            this.a = rewardVideoAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AdInfo adInfo) throws Exception {
            TapAdNative.RewardVideoAdListener rewardVideoAdListener = this.a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoCached(new a(adInfo));
            }
        }
    }

    class x implements Consumer<Throwable> {
        final /* synthetic */ TapAdNative.RewardVideoAdListener a;
        final /* synthetic */ AdRequest b;

        x(TapAdNative.RewardVideoAdListener rewardVideoAdListener, AdRequest adRequest) {
            this.a = rewardVideoAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            com.tapsdk.tapad.exceptions.b.a(th, this.a, this.b.spaceId, AdType.RewardedAd);
        }
    }

    class y implements Function<AdInfo, ObservableSource<AdInfo>> {
        y() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<AdInfo> apply(AdInfo adInfo) throws Exception {
            d dVar = d.this;
            adInfo.mediaId = dVar.b.mMediaId;
            return dVar.d.a(adInfo);
        }
    }

    class z implements Function<AdInfo, ObservableSource<? extends AdInfo>> {
        final /* synthetic */ TapAdNative.RewardVideoAdListener a;
        final /* synthetic */ AdRequest b;

        class a implements TapRewardVideoAd {
            private TapRewardVideoAd.RewardAdInteractionListener a;
            private int b = Integer.MIN_VALUE;
            final /* synthetic */ AdInfo c;

            /* JADX INFO: renamed from: com.tapsdk.tapad.d$z$a$a, reason: collision with other inner class name */
            class C0583a implements com.tapsdk.tapad.internal.f.a {
                C0583a() {
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdClick() {
                    if (a.this.a != null) {
                        a.this.a.onAdClick();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdClose() {
                    if (a.this.a != null) {
                        a.this.a.onAdClose();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdShow() {
                    if (a.this.a != null) {
                        a.this.a.onAdShow();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onAdValidShow() {
                    if (a.this.a != null) {
                        a.this.a.onAdValidShow();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                    if (a.this.a != null) {
                        a.this.a.onRewardVerify(z, i, str, i2, str2);
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onSkippedVideo() {
                    if (a.this.a != null) {
                        a.this.a.onSkippedVideo();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onVideoComplete() {
                    if (a.this.a != null) {
                        a.this.a.onVideoComplete();
                    }
                }

                @Override // com.tapsdk.tapad.internal.f.a
                public void onVideoError() {
                    if (a.this.a != null) {
                        a.this.a.onVideoError();
                    }
                }
            }

            a(AdInfo adInfo) {
                this.c = adInfo;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void dispose() {
                this.a = null;
                int i = this.b;
                if (i != Integer.MIN_VALUE) {
                    com.tapsdk.tapad.internal.f.b(Integer.valueOf(i));
                }
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public Map<String, Object> getMediaExtraInfo() {
                return this.c.mediaExtraInfoMap;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void sendLossNotification(Map<String, Object> map) {
                d.this.a(AdType.RewardedAd, false, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void sendWinNotification(Map<String, Object> map) {
                d.this.a(AdType.RewardedAd, true, this.c, map);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void setRewardAdInteractionListener(TapRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
                this.a = rewardAdInteractionListener;
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd
            public void showRewardVideoAd(Activity activity) {
                Intent intent = new Intent(activity, (Class<?>) (this.c.renderStyles.d != 1 ? Stub_Standard_Portrait_Activity.class : Stub_Standard_Landscape_Activity.class));
                C0583a c0583a = new C0583a();
                Bundle bundle = new Bundle();
                if (c0583a.hashCode() != Integer.MIN_VALUE) {
                    int iHashCode = c0583a.hashCode();
                    this.b = iHashCode;
                    com.tapsdk.tapad.internal.f.a(Integer.valueOf(iHashCode), c0583a);
                    TapADLogger.d("input callbackId:" + this.b);
                    bundle.putInt("c_id", this.b);
                }
                bundle.putParcelable("data", this.c);
                bundle.putParcelable("request", z.this.b);
                intent.putExtras(bundle);
                activity.startActivity(intent);
            }
        }

        z(TapAdNative.RewardVideoAdListener rewardVideoAdListener, AdRequest adRequest) {
            this.a = rewardVideoAdListener;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends AdInfo> apply(AdInfo adInfo) throws Exception {
            TapAdNative.RewardVideoAdListener rewardVideoAdListener = this.a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(new a(adInfo));
            }
            return Observable.just(adInfo);
        }
    }

    public d(Context context, TapAdConfig tapAdConfig) {
        this.a = new WeakReference<>(context);
        this.c = new com.tapsdk.tapad.e.a(context);
        this.b = tapAdConfig;
        this.m = new com.tapsdk.tapad.internal.l.b.a(context);
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(context);
        if (activityA != null) {
            try {
                this.f = this.u.a(activityA);
            } catch (Exception unused) {
            }
        }
    }

    private PopupWindow a(Activity activity, AdInfo adInfo) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.tapad_wait_bubble, (ViewGroup) null);
        String strExtractWaitInteractionIconUrl = adInfo.btnInteractionInfo.extractWaitInteractionIconUrl();
        if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
            strExtractWaitInteractionIconUrl = adInfo.appInfo.appIconImage.imageUrl;
        }
        if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
            Glide.with(activity).load(strExtractWaitInteractionIconUrl).into((ImageView) viewInflate.findViewById(R.id.icon_image));
        }
        String strExtractWaitInteractionDescription = adInfo.btnInteractionInfo.extractWaitInteractionDescription();
        if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
            ((TextView) viewInflate.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
        }
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        viewInflate.findViewById(R.id.close_btn).setOnClickListener(new q(popupWindow));
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TapFeedAd> a(List<AdInfo> list, Long l2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AdInfo adInfo = list.get(i2);
            adInfo.mediaId = l2.longValue();
            TapFeedAd tapFeedAdE = e(adInfo);
            if (tapFeedAdE != null) {
                arrayList.add(tapFeedAdE);
            }
        }
        return arrayList;
    }

    private void a() {
        Iterator<Map.Entry<ViewGroup, FeedAdVideoView>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            FeedAdVideoView value = it.next().getValue();
            if (value != null) {
                value.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, AdInfo adInfo, AdRequest adRequest, TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
        if (f(adInfo) || g(adInfo)) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) (!h(adInfo) ? Stub_Interstitial_Graphic_Portrait_Activity.class : Stub_Interstitial_Graphic_Landscape_Activity.class));
        this.s.put(adInfo.trackId, Boolean.TRUE);
        r rVar = new r(interstitialAdInteractionListener, adInfo, adRequest);
        Bundle bundle = new Bundle();
        if (rVar.hashCode() != Integer.MIN_VALUE) {
            int iHashCode = rVar.hashCode();
            com.tapsdk.tapad.internal.e.a(Integer.valueOf(iHashCode), rVar);
            TapADLogger.d("input callbackId:" + iHashCode);
            bundle.putInt("c_id", iHashCode);
        }
        bundle.putParcelable("data", adInfo);
        bundle.putParcelable("request", adRequest);
        bundle.putString("adType", AdType.InterstitialAd.name());
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdRequest adRequest) {
        this.e.add(this.c.e(adRequest, this.b, AdType.SplashAd).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(), new v()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdType adType, boolean z2, AdInfo adInfo, Map<String, Object> map) {
        String str;
        String strA;
        AdConfiguration adConfigurationC = com.tapsdk.tapad.e.d.d().c();
        if (adInfo == null) {
            if (z2) {
                return;
            }
            map.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.n, Long.valueOf(this.b.mMediaId));
            String strB = com.tapsdk.tapad.internal.network.c.a.b(adConfigurationC.loseNoticeTemplate, map);
            System.out.println(strB);
            com.tapsdk.tapad.internal.tracker.c.a().a(strB, (Map<String, String>) null, (List<DynamicHeader>) null);
            return;
        }
        if (adType == null || map == null) {
            str = "reportBiddingResult illegal params";
        } else {
            List<String> list = adInfo.winNoticeUrls;
            if (list != null && list.size() != 0 && com.tapsdk.tapad.internal.network.c.a.c(adInfo.winNoticeUrls.get(0))) {
                String strName = adType.name();
                String str2 = adInfo.winNoticeUrls.get(0);
                TapADLogger.d("reportBiddingResult (adType:" + strName + ",win:" + (z2 ? "win" : "loss") + ", spaceId:" + adInfo.spaceId + ",extras:" + map + ")");
                try {
                    HashMap map2 = new HashMap(map);
                    map2.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.n, Long.valueOf(this.b.mMediaId));
                    map2.put("space_id", adInfo.spaceId);
                    if (z2) {
                        if (map.containsKey(Constants.Bidding.EXPECT_COST_PRICE)) {
                            Object obj = map.get(Constants.Bidding.EXPECT_COST_PRICE);
                            map.remove(Constants.Bidding.EXPECT_COST_PRICE);
                            map.put("price", com.tapsdk.tapad.internal.t.f.a.a(String.valueOf(obj), "YTcbCkg3HhdK47Tq"));
                        }
                        map2.put("dsp_track_id", adInfo.trackId);
                        strA = com.tapsdk.tapad.internal.network.c.a.b(com.tapsdk.tapad.internal.network.c.a.d(str2, map), map2);
                    } else {
                        map2.putAll(map);
                        map2.put(Constants.Bidding.REQ_UUID, adInfo.trackBackData.requestUUID);
                        map2.put("request_id", adInfo.trackBackData.requestId);
                        strA = com.tapsdk.tapad.internal.network.c.a.a(str2, adConfigurationC.loseNoticeTemplate, map2);
                    }
                    com.tapsdk.tapad.internal.tracker.c.a().a(strA, (Map<String, String>) null, (List<DynamicHeader>) null);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            str = "reportBiddingResult illegal url";
        }
        TapADLogger.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Set<com.tapsdk.tapad.internal.m.d.c<?>> set) {
        com.tapsdk.tapad.internal.l.a aVar;
        for (com.tapsdk.tapad.internal.m.d.c<?> cVar : set) {
            if (set.contains(cVar) && !this.h.contains(cVar) && cVar != null && (aVar = (com.tapsdk.tapad.internal.l.a) cVar.d) != null) {
                try {
                    if (aVar.a().tapADTrackerObject == null || aVar.a().tapADTrackerObject.a == null || !aVar.a().tapADTrackerObject.a.a) {
                        com.tapsdk.tapad.internal.tracker.c.a().a(aVar.a().viewMonitorUrls, (Map<String, String>) null, aVar.a().getViewMonitorHeaderListWrapper());
                    } else {
                        aVar.a().tapADTrackerObject.a.b((Map<String, String>) null);
                    }
                    TapFeedAd.AdInteractionListener adInteractionListenerB = aVar.b();
                    if (adInteractionListenerB != null) {
                        AdInfo adInfoA = aVar.a();
                        if (adInfoA != null && adInfoA.trackId != null && adInfoA.trackId.length() > 0 && !this.r.contains(adInfoA.trackId)) {
                            this.r.add(adInfoA.trackId);
                            adInteractionListenerB.onDistinctAdShow(aVar);
                        }
                        adInteractionListenerB.onAdShow(aVar);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private boolean a(long j2) {
        return j2 >= 1000 && j2 <= 5000;
    }

    private boolean a(AdInfo adInfo) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, AdInfo adInfo, AdRequest adRequest, TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
        if (f(adInfo) || g(adInfo)) {
            return;
        }
        this.s.put(adInfo.trackId, Boolean.TRUE);
        Intent intent = new Intent(activity, (Class<?>) (adInfo.renderStyles.d != 1 ? Stub_Interstitial_Video_Portrait_Activity.class : Stub_Interstitial_Video_Landscape_Activity.class));
        s sVar = new s(interstitialAdInteractionListener, adInfo);
        Bundle bundle = new Bundle();
        if (sVar.hashCode() != Integer.MIN_VALUE) {
            int iHashCode = sVar.hashCode();
            com.tapsdk.tapad.internal.e.a(Integer.valueOf(iHashCode), sVar);
            TapADLogger.d("input callbackId:" + iHashCode);
            bundle.putInt("c_id", iHashCode);
        }
        bundle.putParcelable("data", adInfo);
        bundle.putParcelable("request", adRequest);
        bundle.putString("adType", AdType.InterstitialAd.name());
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    private boolean b(AdInfo adInfo) {
        return adInfo.materialInfo != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(AdInfo adInfo) {
        MaterialInfo materialInfo;
        if (adInfo == null || (materialInfo = adInfo.materialInfo) == null || materialInfo.materialType != 2 || materialInfo.videoInfoList.size() <= 0) {
            return true;
        }
        long j2 = adInfo.materialInfo.videoInfoList.get(0).urlExpires;
        return j2 == -1 || j2 >= System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(AdInfo adInfo) {
        MaterialInfo materialInfo = adInfo.materialInfo;
        return (materialInfo == null || materialInfo.imageInfoList.size() == 0) ? false : true;
    }

    private TapFeedAd e(AdInfo adInfo) {
        if (b(adInfo)) {
            return new com.tapsdk.tapad.internal.l.a(adInfo, this.a, this.f, this.l, this.m, this.v, new t(), this.u);
        }
        return null;
    }

    private boolean f(AdInfo adInfo) {
        String str;
        return adInfo == null || (str = adInfo.trackId) == null || str.length() == 0;
    }

    private boolean g(AdInfo adInfo) {
        return this.s.containsKey(adInfo.trackId);
    }

    private boolean h(AdInfo adInfo) {
        return adInfo.renderStyles.d == 1;
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public int canSwitchPassiveConnection() {
        return ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.b, Integer.class, 0)).intValue();
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void dispose() {
        a();
        this.l.clear();
        com.tapsdk.tapad.internal.j.c.b();
        if (this.e.isDisposed()) {
            return;
        }
        this.e.clear();
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadBannerAd(AdRequest adRequest, TapAdNative.BannerAdListener bannerAdListener) {
        TapAdConfig tapAdConfig = this.b;
        if (tapAdConfig == null) {
            bannerAdListener.onError(ErrorCodeEnum.COMMON_INIT_ERROR.getCode(), ErrorCodeEnum.COMMON_INIT_ERROR.getDesc());
        } else {
            this.e.add(this.c.a(adRequest, tapAdConfig).subscribeOn(Schedulers.io()).flatMap(new g(adRequest)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(bannerAdListener), new f(bannerAdListener, adRequest)));
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadFeedAd(AdRequest adRequest, int i2, TapAdNative.FeedAdListener feedAdListener) {
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadFeedAd(AdRequest adRequest, TapAdNative.FeedAdListener feedAdListener) {
        TapADLogger.d("FeedAd start requestId:" + adRequest.requestId);
        if (this.b == null) {
            feedAdListener.onError(ErrorCodeEnum.COMMON_INIT_ERROR.getCode(), ErrorCodeEnum.COMMON_INIT_ERROR.getDesc());
            return;
        }
        TapADLogger.d("FeedAd start call queryAdByTypeBp requestId:" + adRequest.requestId);
        this.e.add(this.c.a(adRequest, this.b).flatMap(new p()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(feedAdListener), new o(feedAdListener, adRequest)));
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadInterstitialAd(AdRequest adRequest, TapAdNative.InterstitialAdListener interstitialAdListener) {
        TapAdConfig tapAdConfig = this.b;
        if (tapAdConfig == null) {
            interstitialAdListener.onError(ErrorCodeEnum.COMMON_INIT_ERROR.getCode(), ErrorCodeEnum.COMMON_INIT_ERROR.getDesc());
        } else {
            this.e.add(this.c.a(adRequest, tapAdConfig).flatMap(new C0581d(adRequest)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new c()).observeOn(Schedulers.io()).flatMap(new b()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b0(interstitialAdListener, adRequest), new c0(interstitialAdListener, adRequest)));
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadRewardVideoAd(AdRequest adRequest, TapAdNative.RewardVideoAdListener rewardVideoAdListener) {
        TapAdConfig tapAdConfig = this.b;
        if (tapAdConfig == null) {
            rewardVideoAdListener.onError(ErrorCodeEnum.COMMON_INIT_ERROR.getCode(), ErrorCodeEnum.COMMON_INIT_ERROR.getDesc());
        } else {
            this.e.add(this.c.a(adRequest, tapAdConfig).flatMap(new a0(adRequest)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new z(rewardVideoAdListener, adRequest)).observeOn(Schedulers.io()).flatMap(new y()).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(rewardVideoAdListener, adRequest), new x(rewardVideoAdListener, adRequest)));
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadSplashAd(AdRequest adRequest, TapAdNative.SplashAdListener splashAdListener) {
        long jE;
        if (this.b == null) {
            splashAdListener.onError(ErrorCodeEnum.COMMON_INIT_ERROR.getCode(), ErrorCodeEnum.COMMON_INIT_ERROR.getDesc());
            return;
        }
        try {
            jE = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("splash_timeout_millisecond", Integer.class, 0)).intValue() * 1000;
        } catch (Throwable unused) {
            jE = -1;
        }
        if (!a(jE)) {
            jE = com.tapsdk.tapad.e.d.d().e();
        }
        if (!a(jE)) {
            jE = com.tapsdk.tapad.e.a.f;
        }
        this.e.add(this.c.g(adRequest, this.b, AdType.SplashAd).flatMap(new m(adRequest)).timeout(jE, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).flatMap(new k()).subscribe(new h(splashAdListener, adRequest), new i(splashAdListener, adRequest), new j(adRequest)));
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void pause() {
        this.q = true;
        Iterator<Map.Entry<ViewGroup, FeedAdVideoView>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            FeedAdVideoView value = it.next().getValue();
            if (value != null) {
                value.l();
            }
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void resume() {
        this.q = false;
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void sendLossNotification(String str, Map<String, Object> map) {
        try {
            TrackBackData trackBackDataA = com.tapsdk.tapad.exceptions.b.a(str);
            if (trackBackDataA != null) {
                if (trackBackDataA.requestId != null && trackBackDataA.requestId.length() > 0) {
                    map.put("request_id", trackBackDataA.requestId);
                }
                if (trackBackDataA.requestUUID != null && trackBackDataA.requestUUID.length() > 0) {
                    map.put(Constants.Bidding.REQ_UUID, trackBackDataA.requestUUID);
                }
                if (trackBackDataA.spaceId >= 0) {
                    map.put("space_id", Long.valueOf(trackBackDataA.spaceId));
                }
                a(AdType.Banner, false, (AdInfo) null, map);
            }
        } catch (Throwable unused) {
        }
    }
}
