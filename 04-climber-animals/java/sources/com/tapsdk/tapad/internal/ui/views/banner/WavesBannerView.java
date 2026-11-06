package com.tapsdk.tapad.internal.ui.views.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WavesBannerView extends RelativeLayout {
    private AdInfo a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private final int f;
    DownloadPresenter g;
    private Button h;
    private ProgressBar i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private View m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private View t;
    private View u;
    private View v;
    private TapBannerAd.BannerInteractionListener w;
    private ValueAnimator x;

    class a implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        a(Activity activity, AdInfo adInfo) {
            this.a = activity;
            this.b = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = this.a;
            AdInfo adInfo = this.b;
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPermissionsLink, adInfo);
        }
    }

    class b implements DownloadPresenter.h {
        b() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            TapADLogger.d("install success");
            WavesBannerView.this.e();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i > 10) {
                WavesBannerView.this.i.setProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            TapADLogger.d("install fail");
            WavesBannerView.this.e();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            WavesBannerView.this.e();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            WavesBannerView.this.e();
            WavesBannerView wavesBannerView = WavesBannerView.this;
            wavesBannerView.g.a(new DownloadPresenter.k(wavesBannerView.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            WavesBannerView.this.e();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;

        c(float f) {
            this.a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (WavesBannerView.this.isAttachedToWindow()) {
                WavesBannerView.this.b.setTranslationY(this.a + (valueAnimator.getAnimatedFraction() * 15.0f));
            }
        }
    }

    class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WavesBannerView.this.x.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ TapBannerAd.BannerInteractionListener c;

        e(AdInfo adInfo, Activity activity, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
            this.a = adInfo;
            this.b = activity;
            this.c = bannerInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (adInfo.viewInteractionInfo == null) {
                return;
            }
            TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
            if (tapADTrackerObject != null) {
                tapADTrackerObject.a(3, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                AdInfo adInfo2 = this.a;
                cVarA.a(adInfo2.clickMonitorUrls, adInfo2.viewInteractionInfo, adInfo2.getClickMonitorHeaderListWrapper());
            }
            com.tapsdk.tapad.internal.s.a.a(this.b, true, this.a, WavesBannerView.this.g);
            TapBannerAd.BannerInteractionListener bannerInteractionListener = this.c;
            if (bannerInteractionListener != null) {
                bannerInteractionListener.onAdClick();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter = WavesBannerView.this.g;
            if (downloadPresenter != null) {
                downloadPresenter.a(new DownloadPresenter.g());
            }
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ Activity a;

        g(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WavesBannerView.this.a(this.a, 0);
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ TapBannerAd.BannerInteractionListener a;

        h(TapBannerAd.BannerInteractionListener bannerInteractionListener) {
            this.a = bannerInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WavesBannerView.this.d();
            TapBannerAd.BannerInteractionListener bannerInteractionListener = this.a;
            if (bannerInteractionListener != null) {
                bannerInteractionListener.onAdClose();
            }
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ Activity a;

        i(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WavesBannerView.this.a(this.a, 1);
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        j(Activity activity, AdInfo adInfo) {
            this.a = activity;
            this.b = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = this.a;
            AdInfo adInfo = this.b;
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appDescUrl, adInfo);
        }
    }

    class k implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        k(Activity activity, AdInfo adInfo) {
            this.a = activity;
            this.b = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = this.a;
            AdInfo adInfo = this.b;
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPrivacyPolicy, adInfo);
        }
    }

    public WavesBannerView(Context context) {
        super(context);
        this.f = 10;
        this.x = ValueAnimator.ofFloat(-1.0f, 1.0f);
        c();
    }

    public WavesBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 10;
        this.x = ValueAnimator.ofFloat(-1.0f, 1.0f);
        c();
    }

    public WavesBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = 10;
        this.x = ValueAnimator.ofFloat(-1.0f, 1.0f);
        c();
    }

    public WavesBannerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f = 10;
        this.x = ValueAnimator.ofFloat(-1.0f, 1.0f);
        c();
    }

    private void a() {
        ProgressBar progressBar;
        int i2;
        boolean z = this.a.renderStyles.d != 1;
        this.n.setVisibility(z ? 8 : 0);
        Glide.with(getContext()).asGif().load(this.a.getBannerWaveGif()).centerCrop().into((ImageView) this.e.findViewById(R.id.wave_gif));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (z) {
            this.t.getLayoutParams().height = (int) TypedValue.applyDimension(1, 68.0f, displayMetrics);
            this.u.getLayoutParams().height = (int) TypedValue.applyDimension(1, 100.0f, displayMetrics);
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            layoutParams.width = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
            layoutParams.height = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            int iApplyDimension = (int) TypedValue.applyDimension(1, 88.0f, displayMetrics);
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, 110.0f, displayMetrics);
            int iApplyDimension3 = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
            marginLayoutParams.leftMargin = iApplyDimension;
            marginLayoutParams.rightMargin = iApplyDimension2;
            marginLayoutParams.bottomMargin = iApplyDimension3;
            ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
            layoutParams2.width = (int) TypedValue.applyDimension(1, 80.0f, displayMetrics);
            layoutParams2.height = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            int iApplyDimension4 = (int) TypedValue.applyDimension(1, 24.0f, displayMetrics);
            int iApplyDimension5 = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
            marginLayoutParams2.rightMargin = iApplyDimension4;
            marginLayoutParams2.bottomMargin = iApplyDimension5;
            this.h.setBackgroundResource(R.drawable.tapad_banner_btn_background);
            ViewGroup.LayoutParams layoutParams3 = this.i.getLayoutParams();
            layoutParams3.width = (int) TypedValue.applyDimension(1, 80.0f, displayMetrics);
            layoutParams3.height = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int iApplyDimension6 = (int) TypedValue.applyDimension(1, 24.0f, displayMetrics);
            int iApplyDimension7 = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
            marginLayoutParams3.rightMargin = iApplyDimension6;
            marginLayoutParams3.bottomMargin = iApplyDimension7;
            this.i.setPadding((int) TypedValue.applyDimension(1, 9.0f, displayMetrics), (int) TypedValue.applyDimension(1, 11.0f, displayMetrics), (int) TypedValue.applyDimension(1, 9.0f, displayMetrics), (int) TypedValue.applyDimension(1, 11.0f, displayMetrics));
            progressBar = this.i;
            i2 = R.drawable.tapad_banner_btn_background;
        } else {
            this.t.getLayoutParams().height = (int) TypedValue.applyDimension(1, 81.0f, getResources().getDisplayMetrics());
            this.u.getLayoutParams().height = (int) TypedValue.applyDimension(1, 113.0f, displayMetrics);
            ViewGroup.LayoutParams layoutParams4 = this.b.getLayoutParams();
            layoutParams4.width = (int) TypedValue.applyDimension(1, 56.0f, getResources().getDisplayMetrics());
            layoutParams4.height = (int) TypedValue.applyDimension(1, 56.0f, getResources().getDisplayMetrics());
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            int iApplyDimension8 = (int) TypedValue.applyDimension(1, 92.0f, displayMetrics);
            int iApplyDimension9 = (int) TypedValue.applyDimension(1, 150.0f, displayMetrics);
            int iApplyDimension10 = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
            marginLayoutParams4.leftMargin = iApplyDimension8;
            marginLayoutParams4.rightMargin = iApplyDimension9;
            marginLayoutParams4.bottomMargin = iApplyDimension10;
            ViewGroup.LayoutParams layoutParams5 = this.h.getLayoutParams();
            layoutParams5.width = (int) TypedValue.applyDimension(1, 114.0f, displayMetrics);
            layoutParams5.height = (int) TypedValue.applyDimension(1, 36.0f, displayMetrics);
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            int iApplyDimension11 = (int) TypedValue.applyDimension(1, 24.0f, displayMetrics);
            int iApplyDimension12 = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
            marginLayoutParams5.rightMargin = iApplyDimension11;
            marginLayoutParams5.bottomMargin = iApplyDimension12;
            this.h.setBackgroundResource(R.drawable.tapad_banner_btn_background_landscape);
            ViewGroup.LayoutParams layoutParams6 = this.i.getLayoutParams();
            layoutParams6.width = (int) TypedValue.applyDimension(1, 114.0f, displayMetrics);
            layoutParams6.height = (int) TypedValue.applyDimension(1, 36.0f, displayMetrics);
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int iApplyDimension13 = (int) TypedValue.applyDimension(1, 24.0f, displayMetrics);
            int iApplyDimension14 = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
            marginLayoutParams6.rightMargin = iApplyDimension13;
            marginLayoutParams6.bottomMargin = iApplyDimension14;
            this.i.setPadding((int) TypedValue.applyDimension(1, 16.0f, displayMetrics), (int) TypedValue.applyDimension(1, 13.0f, displayMetrics), (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), (int) TypedValue.applyDimension(1, 13.0f, displayMetrics));
            progressBar = this.i;
            i2 = R.drawable.tapad_banner_btn_background_landscape;
        }
        progressBar.setBackgroundResource(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i2) {
        DownloadPresenter downloadPresenter;
        com.tapsdk.tapad.internal.b jVar;
        AdInfo adInfo = this.a;
        if (adInfo == null) {
            return;
        }
        TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
        if (tapADTrackerObject != null) {
            tapADTrackerObject.a(i2, null);
        } else {
            com.tapsdk.tapad.internal.tracker.c.a().a(s.a(this.a.clickMonitorUrls, i2), (Map<String, String>) null, this.a.getClickMonitorHeaderListWrapper());
        }
        AdInfo adInfo2 = this.a;
        if (adInfo2.btnInteractionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo2, this.g);
            return;
        }
        DownloadPresenter.DownloadState downloadStateC = this.g.c();
        if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(activity, this.a.appInfo.packageName)) {
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                e();
                downloadPresenter = this.g;
                jVar = new DownloadPresenter.j(this.a);
            } else {
                if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                    return;
                }
                if (com.tapsdk.tapad.internal.a.a(getContext(), this.a).exists()) {
                    downloadPresenter = this.g;
                    jVar = new DownloadPresenter.k(this.a);
                } else {
                    downloadPresenter = this.g;
                    jVar = new DownloadPresenter.i(this.a);
                }
            }
            downloadPresenter.a(jVar);
        } else if (!com.tapsdk.tapad.internal.utils.b.b(activity, this.a.appInfo.packageName)) {
            TapADLogger.d("WavesBannerView 打开异常");
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.w;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onDownloadClick();
        }
    }

    private void b() {
        this.g = new DownloadPresenter(getContext(), new b());
    }

    private void c() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_banner_waves, this);
        this.e = viewInflate;
        this.b = (ImageView) viewInflate.findViewById(R.id.app_icon_view);
        this.h = (Button) this.e.findViewById(R.id.interaction_button);
        this.c = (TextView) this.e.findViewById(R.id.title_text_view);
        this.d = (TextView) this.e.findViewById(R.id.description_text_View);
        this.i = (ProgressBar) this.e.findViewById(R.id.download_progressbar);
        this.j = (ImageView) this.e.findViewById(R.id.close_image_view);
        this.k = (ImageView) this.e.findViewById(R.id.ad_log_icon);
        this.l = (TextView) this.e.findViewById(R.id.ad_log_text);
        this.m = this.e.findViewById(R.id.ad_hot_view);
        this.n = this.e.findViewById(R.id.ad_component_info);
        this.o = (TextView) this.e.findViewById(R.id.app_privacy_version_text);
        this.p = (TextView) this.e.findViewById(R.id.app_supplier_text);
        this.q = (TextView) this.e.findViewById(R.id.app_describe_text);
        this.r = (TextView) this.e.findViewById(R.id.app_privacy_text);
        this.s = (TextView) this.e.findViewById(R.id.app_permission_text);
        this.t = this.e.findViewById(R.id.banner_wave_body);
        this.u = this.e.findViewById(R.id.banner_wave_content);
        this.v = this.e.findViewById(R.id.ad_content_view);
        Glide.with(getContext()).asGif().load("https://tapad-platform.tapimg.com/adn_resources/adn-sdk-resources/ui-styles/tapad_banner_waves_landscape_gif.gif").centerCrop().into((ImageView) this.e.findViewById(R.id.wave_gif));
        this.x.addUpdateListener(new c(this.b.getTranslationY()));
        this.x.addListener(new d());
        this.x.setInterpolator(new CycleInterpolator(1.0f));
        this.x.setDuration(com.tapsdk.tapad.e.a.f);
        this.x.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        DownloadPresenter downloadPresenter;
        Button button;
        int i2;
        AdInfo adInfo = this.a;
        if (adInfo == null || (downloadPresenter = this.g) == null) {
            return;
        }
        if (adInfo.btnInteractionInfo.interactionType != 1) {
            String str = adInfo.btnName;
            if (str == null || str.length() <= 0) {
                this.h.setText(R.string.tapad_banner_open);
                return;
            } else {
                this.h.setText(this.a.btnName);
                return;
            }
        }
        DownloadPresenter.DownloadState downloadStateC = downloadPresenter.c();
        if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), this.a.appInfo.packageName)) {
            this.h.setText(R.string.tapad_banner_open);
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            return;
        }
        int iB = this.g.b();
        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
            AppInfo appInfo = this.a.appInfo;
            if (appInfo.apkSize <= 0 || !q.a(appInfo.appSize)) {
                button = this.h;
                i2 = R.string.tapad_banner_download;
            } else {
                this.h.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.a.appInfo.appSize));
            }
            this.h.setVisibility(0);
            this.i.setVisibility(8);
        }
        if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
            this.i.setProgress(Math.max(iB, 10));
            this.i.setVisibility(0);
            this.h.setVisibility(8);
            return;
        }
        button = this.h;
        i2 = R.string.tapad_banner_install;
        button.setText(i2);
        this.h.setVisibility(0);
        this.i.setVisibility(8);
    }

    public void a(Activity activity, AdInfo adInfo, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
        if (adInfo == null) {
            return;
        }
        this.a = adInfo;
        this.w = bannerInteractionListener;
        if (this.g == null) {
            b();
        }
        Glide.with(activity.getApplicationContext()).load(adInfo.appInfo.appIconImage.imageUrl).into(this.b);
        this.c.setText(adInfo.materialInfo.title);
        this.d.setText(adInfo.materialInfo.description);
        e();
        this.e.setOnClickListener(new e(adInfo, activity, bannerInteractionListener));
        this.i.setOnClickListener(new f());
        this.h.setOnClickListener(new g(activity));
        this.j.setOnClickListener(new h(bannerInteractionListener));
        this.k.setVisibility(adInfo.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getResources().getString(R.string.tapad_str_ads);
        String str = adInfo.logoInfo.logoTitle;
        if (str != null && str.length() > 0 && adInfo.logoInfo.logoTitle.length() < 5) {
            string = adInfo.logoInfo.logoTitle;
        }
        this.l.setText(string);
        this.m.setVisibility(com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo) ? 0 : 8);
        this.m.setOnClickListener(new i(activity));
        String str2 = adInfo.appInfo.appVersion;
        if (str2 != null && str2.length() > 0) {
            this.o.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str3 = adInfo.appInfo.appDeveloper;
        if (str3 != null && str3.length() > 0) {
            this.p.setText(adInfo.appInfo.appDeveloper);
        }
        this.q.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.q.setOnClickListener(new j(activity, adInfo));
        this.r.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.r.setOnClickListener(new k(activity, adInfo));
        this.s.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.s.setOnClickListener(new a(activity, adInfo));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ExposureTrackerObject exposureTrackerObject;
        if (this.a == null) {
            return;
        }
        a();
        super.onAttachedToWindow();
        TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
        if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
        } else {
            exposureTrackerObject.b((Map<String, String>) null);
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.w;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onAdShow();
        }
        this.x.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
        DownloadPresenter downloadPresenter = this.g;
        if (downloadPresenter != null) {
            downloadPresenter.a(new com.tapsdk.tapad.internal.d());
        }
        this.x.cancel();
    }
}
