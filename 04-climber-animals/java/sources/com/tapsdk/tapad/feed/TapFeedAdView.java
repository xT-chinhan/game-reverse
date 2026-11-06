package com.tapsdk.tapad.feed;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TapFeedAdView extends FrameLayout {
    private static final int y = 10;
    private ImageView a;
    private TextView b;
    private TextView c;
    private ExpressAdVideoView d;
    private ImageView e;
    private Button f;
    private ProgressBar g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private ViewGroup q;
    private DownloadPresenter r;
    private int s;
    private final com.tapsdk.tapad.internal.tracker.b t;
    private TapFeedAd u;
    private TapFeedAd.ExpressRenderListener v;
    private TapFeedAd.VideoAdListener w;
    private FeedOption x;

    class a implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (TapFeedAdView.this.v != null) {
                TapFeedAdView.this.v.onAdValidShow(TapFeedAdView.this);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewGroup viewGroup;
            if ((TapFeedAdView.this.getParent() instanceof ViewGroup) && (viewGroup = (ViewGroup) TapFeedAdView.this.getParent()) != null) {
                viewGroup.removeView(TapFeedAdView.this);
            }
            TapFeedAdView.this.v.onAdClosed(TapFeedAdView.this);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfoA;
            if (TapFeedAdView.this.u == null) {
                return;
            }
            try {
                adInfoA = ((com.tapsdk.tapad.internal.l.a) TapFeedAdView.this.u).a();
            } catch (Throwable unused) {
                adInfoA = null;
            }
            com.tapsdk.tapad.internal.s.a.a(com.tapsdk.tapad.internal.utils.a.a(TapFeedAdView.this.getContext()), TapFeedAdView.this.u.getComplianceInfo().getFunctionDescUrl(), adInfoA);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfoA;
            if (TapFeedAdView.this.u == null) {
                return;
            }
            try {
                adInfoA = ((com.tapsdk.tapad.internal.l.a) TapFeedAdView.this.u).a();
            } catch (Throwable unused) {
                adInfoA = null;
            }
            com.tapsdk.tapad.internal.s.a.a(com.tapsdk.tapad.internal.utils.a.a(TapFeedAdView.this.getContext()), TapFeedAdView.this.u.getComplianceInfo().getPrivacyUrl(), adInfoA);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfoA;
            if (TapFeedAdView.this.u == null) {
                return;
            }
            try {
                adInfoA = ((com.tapsdk.tapad.internal.l.a) TapFeedAdView.this.u).a();
            } catch (Throwable unused) {
                adInfoA = null;
            }
            com.tapsdk.tapad.internal.s.a.a(com.tapsdk.tapad.internal.utils.a.a(TapFeedAdView.this.getContext()), TapFeedAdView.this.u.getComplianceInfo().getPermissionUrl(), adInfoA);
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        f(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter;
            com.tapsdk.tapad.internal.b jVar;
            if (this.a.btnInteractionInfo == null) {
                return;
            }
            if (TapFeedAdView.this.v != null) {
                TapFeedAdView.this.v.onAdClicked(TapFeedAdView.this);
            }
            TapFeedAdView.this.d();
            TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
            if (tapADTrackerObject != null) {
                tapADTrackerObject.a(0, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                AdInfo adInfo = this.a;
                cVarA.a(adInfo.clickMonitorUrls, (Map<String, String>) null, adInfo.getClickMonitorHeaderListWrapper());
            }
            if (this.a.btnInteractionInfo.interactionType != 1) {
                com.tapsdk.tapad.internal.s.a.a((Activity) TapFeedAdView.this.getContext(), false, this.a, TapFeedAdView.this.r);
                return;
            }
            if (TapFeedAdView.this.r == null) {
                return;
            }
            if (this.a.btnInteractionInfo.floatingLayerStyle == 1 || TapFeedAdView.this.f == null) {
                TapFeedAdView.this.a(this.a);
                return;
            }
            DownloadPresenter.DownloadState downloadStateC = TapFeedAdView.this.r.c();
            if (downloadStateC != DownloadPresenter.DownloadState.STARTED && this.a.materialInfo != null && com.tapsdk.tapad.internal.utils.b.a(TapFeedAdView.this.getContext(), this.a.appInfo.packageName)) {
                if (com.tapsdk.tapad.internal.utils.b.b(TapFeedAdView.this.getContext(), this.a.appInfo.packageName)) {
                    return;
                }
                TapADLogger.d("Feed广告 打开异常");
                return;
            }
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                if (this.a.materialInfo == null) {
                    return;
                }
                downloadPresenter = TapFeedAdView.this.r;
                jVar = new DownloadPresenter.j(this.a);
            } else if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                downloadPresenter = TapFeedAdView.this.r;
                jVar = new DownloadPresenter.g();
            } else if (com.tapsdk.tapad.internal.a.a(TapFeedAdView.this.getContext(), this.a).exists()) {
                downloadPresenter = TapFeedAdView.this.r;
                jVar = new DownloadPresenter.k(this.a);
            } else {
                downloadPresenter = TapFeedAdView.this.r;
                jVar = new DownloadPresenter.i(this.a);
            }
            downloadPresenter.a(jVar);
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        g(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (adInfo == null || adInfo.viewInteractionInfo == null) {
                return;
            }
            if (TapFeedAdView.this.v != null) {
                TapFeedAdView.this.v.onAdClicked(TapFeedAdView.this);
            }
            TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
            if (tapADTrackerObject != null) {
                tapADTrackerObject.a(3, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                AdInfo adInfo2 = this.a;
                cVarA.a(adInfo2.clickMonitorUrls, adInfo2.viewInteractionInfo, adInfo2.getClickMonitorHeaderListWrapper());
            }
            com.tapsdk.tapad.internal.s.a.a((Activity) TapFeedAdView.this.getContext(), true, this.a, TapFeedAdView.this.r);
        }
    }

    class h implements RequestListener<Drawable> {
        h() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            TapFeedAdView.this.t.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class i implements DownloadPresenter.h {
        i() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            TapADLogger.d("install success");
            TapFeedAdView.this.d();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i <= 10 || TapFeedAdView.this.g == null) {
                return;
            }
            TapFeedAdView.this.g.setProgress(i);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            TapADLogger.d("install fail");
            TapFeedAdView.this.d();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TapFeedAdView.this.d();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            AdInfo adInfoA;
            if (TapFeedAdView.this.u == null || (adInfoA = ((com.tapsdk.tapad.internal.l.a) TapFeedAdView.this.u).a()) == null) {
                return;
            }
            TapFeedAdView.this.d();
            TapFeedAdView.this.r.a(new DownloadPresenter.k(adInfoA));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            TapFeedAdView.this.d();
        }
    }

    public TapFeedAdView(Context context) {
        super(context);
        this.s = 0;
        this.t = new com.tapsdk.tapad.internal.tracker.b(this, new a());
        a();
    }

    public TapFeedAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 0;
        this.t = new com.tapsdk.tapad.internal.tracker.b(this, new a());
        a();
    }

    public TapFeedAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = 0;
        this.t = new com.tapsdk.tapad.internal.tracker.b(this, new a());
        a();
    }

    public TapFeedAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.s = 0;
        this.t = new com.tapsdk.tapad.internal.tracker.b(this, new a());
        a();
    }

    private void a() {
        b();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo) {
        if (this.r == null || adInfo == null) {
            return;
        }
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(getContext());
        if (com.tapsdk.tapad.internal.utils.a.b(activityA)) {
            return;
        }
        com.tapsdk.tapad.internal.l.d.a aVarA = com.tapsdk.tapad.internal.l.d.a.a(adInfo);
        aVarA.a(this.r);
        try {
            aVarA.show(activityA.getFragmentManager(), com.tapsdk.tapad.internal.l.d.a.i);
        } catch (Throwable unused) {
        }
        if (adInfo.btnInteractionInfo.canStartDownloadInFloatingLayer()) {
            this.r.a((com.tapsdk.tapad.internal.b) new DownloadPresenter.j(adInfo));
        }
    }

    private void b() {
        try {
            TapFeedAd tapFeedAd = this.u;
            if (tapFeedAd instanceof com.tapsdk.tapad.internal.l.a) {
                this.s = ((com.tapsdk.tapad.internal.l.a) tapFeedAd).a().getDefaultOpenWebMode();
            }
        } catch (Throwable unused) {
        }
    }

    private void c() {
        this.r = new DownloadPresenter(getContext(), new i());
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        AdInfo adInfoA;
        ProgressBar progressBar;
        Button button;
        int i2;
        TapFeedAd tapFeedAd = this.u;
        if (tapFeedAd == null || (adInfoA = ((com.tapsdk.tapad.internal.l.a) tapFeedAd).a()) == null || this.f == null || (progressBar = this.g) == null) {
            return;
        }
        if (adInfoA.btnInteractionInfo.interactionType != 1) {
            progressBar.setVisibility(8);
            this.f.setVisibility(0);
            String str = adInfoA.btnName;
            if (str != null && str.length() > 0) {
                this.f.setText(adInfoA.btnName);
                return;
            } else {
                button = this.f;
                i2 = R.string.tapad_banner_open;
            }
        } else {
            DownloadPresenter.DownloadState downloadStateC = this.r.c();
            if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), adInfoA.appInfo.packageName)) {
                this.f.setText(R.string.tapad_banner_open);
                this.g.setVisibility(8);
                this.f.setVisibility(0);
                return;
            }
            int iB = this.r.b();
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                AppInfo appInfo = adInfoA.appInfo;
                if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                    this.f.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), adInfoA.appInfo.appSize));
                } else {
                    this.f.setText(R.string.tapad_banner_download);
                }
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                return;
            }
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                this.g.setProgress(Math.max(iB, 10));
                this.g.setVisibility(0);
                this.f.setVisibility(8);
                return;
            } else {
                this.g.setVisibility(8);
                this.f.setVisibility(0);
                button = this.f;
                i2 = R.string.tapad_banner_install;
            }
        }
        button.setText(i2);
    }

    private void e() {
        if (this.x == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        FeedOption feedOption = this.x;
        layoutParams.width = feedOption.expressWidth;
        layoutParams.height = feedOption.expressHeight;
    }

    private void f() {
        this.a = (ImageView) findViewById(R.id.tapad_app_icon_image);
        this.b = (TextView) findViewById(R.id.tapad_app_name);
        this.c = (TextView) findViewById(R.id.tapad_description);
        this.d = (ExpressAdVideoView) findViewById(R.id.tapad_video_view);
        this.e = (ImageView) findViewById(R.id.tapad_image_view);
        this.f = (Button) findViewById(R.id.tapad_interaction_btn);
        this.g = (ProgressBar) findViewById(R.id.tapad_progress_bar);
        this.h = (ImageView) findViewById(R.id.tapad_close_icon);
        this.i = (TextView) findViewById(R.id.privacyVersionTextView);
        this.j = (TextView) findViewById(R.id.supplierTextView);
        this.k = (TextView) findViewById(R.id.describeTextView);
        this.l = (TextView) findViewById(R.id.privacyTextView);
        this.m = (TextView) findViewById(R.id.permissionTextView);
        this.n = (ImageView) findViewById(R.id.tapad_ad_logo_icon);
        this.o = (TextView) findViewById(R.id.tapad_ad_logo_text);
        this.p = (TextView) findViewById(R.id.tapad_score_text);
        this.q = (ViewGroup) findViewById(R.id.tapad_score_container);
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(new c());
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setOnClickListener(new d());
        }
        TextView textView3 = this.m;
        if (textView3 != null) {
            textView3.setOnClickListener(new e());
        }
    }

    public void a(TapFeedAd tapFeedAd, FeedOption feedOption, TapFeedAd.ExpressRenderListener expressRenderListener, TapFeedAd.VideoAdListener videoAdListener) {
        if (tapFeedAd == null) {
            return;
        }
        this.u = tapFeedAd;
        this.v = expressRenderListener;
        this.w = videoAdListener;
        this.x = feedOption;
        if (tapFeedAd instanceof com.tapsdk.tapad.internal.l.a) {
            com.tapsdk.tapad.internal.l.a aVar = (com.tapsdk.tapad.internal.l.a) tapFeedAd;
            if (aVar.a() != null && aVar.a().tapADTrackerObject != null) {
                this.t.a(aVar.a().tapADTrackerObject.a);
            }
        }
        f();
        if (this.a != null) {
            Glide.with(getContext()).load(tapFeedAd.getIconUrl()).into(this.a);
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(tapFeedAd.getComplianceInfo().getAppName());
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(tapFeedAd.getDescription());
        }
        if (this.e != null) {
            String str = tapFeedAd.getImageInfoList().size() > 0 ? tapFeedAd.getImageInfoList().get(0).imageUrl : "";
            if (tapFeedAd.getImageMode() == 1 && !TextUtils.isEmpty(str)) {
                this.e.setVisibility(0);
                Glide.with(this).load(str).addListener(new h()).into(this.e);
            }
        }
        if (this.d != null && tapFeedAd.getImageMode() == 2) {
            this.d.setVisibility(0);
            this.d.setVideoAdListener(videoAdListener);
            this.d.setVideoOption(feedOption.videoOption);
            this.d.b((com.tapsdk.tapad.internal.l.a) tapFeedAd);
        }
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setText("版本 " + tapFeedAd.getComplianceInfo().getAppVersion());
        }
        TextView textView4 = this.j;
        if (textView4 != null) {
            textView4.setText(tapFeedAd.getComplianceInfo().getDeveloperName());
        }
        if (this.n != null && !TextUtils.isEmpty(tapFeedAd.getComplianceInfo().getAdLogIconUrl())) {
            Glide.with(this).load(tapFeedAd.getComplianceInfo().getAdLogIconUrl()).into(this.n);
        }
        if (this.p != null) {
            float score = tapFeedAd.getScore();
            if (score <= 0.0f) {
                this.q.setVisibility(8);
            } else {
                this.q.setVisibility(0);
                this.p.setText(String.valueOf(score));
            }
        }
    }

    public void a(List<View> list) {
        TapFeedAd tapFeedAd;
        AdInfo adInfoA;
        if (list == null || (tapFeedAd = this.u) == null || (adInfoA = ((com.tapsdk.tapad.internal.l.a) tapFeedAd).a()) == null) {
            return;
        }
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(new f(adInfoA));
        }
        setOnClickListener(new g(adInfoA));
    }

    public ImageView getAdImageView() {
        return this.e;
    }

    public ExpressAdVideoView getAdVideoView() {
        return this.d;
    }

    public Button getBtnInteraction() {
        return this.f;
    }

    public ProgressBar getProgressBar() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        AdInfo adInfoA;
        ExposureTrackerObject exposureTrackerObject;
        super.onAttachedToWindow();
        TapFeedAd tapFeedAd = this.u;
        if (tapFeedAd != null && (adInfoA = ((com.tapsdk.tapad.internal.l.a) tapFeedAd).a()) != null) {
            TapADTrackerObject tapADTrackerObject = adInfoA.tapADTrackerObject;
            if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                com.tapsdk.tapad.internal.tracker.c.a().a(adInfoA.viewMonitorUrls, (Map<String, String>) null, adInfoA.getViewMonitorHeaderListWrapper());
            } else {
                exposureTrackerObject.b((Map<String, String>) null);
            }
        }
        TapFeedAd.ExpressRenderListener expressRenderListener = this.v;
        if (expressRenderListener != null) {
            expressRenderListener.onAdShow(this);
        }
        e();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setVolumeImageVisible(int i2) {
        this.d.setVolumeImageViewVisible(i2);
    }
}
