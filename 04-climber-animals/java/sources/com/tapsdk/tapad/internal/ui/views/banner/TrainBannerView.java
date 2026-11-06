package com.tapsdk.tapad.internal.ui.views.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TrainBannerView extends RelativeLayout {
    DownloadPresenter A;
    private View a;
    private View b;
    private ImageView c;
    private View d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private TrainProgressBar h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private View n;
    private View o;
    private View p;
    private View q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TapBannerAd.BannerInteractionListener y;
    private AdInfo z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TrainBannerView.this.isAttachedToWindow()) {
                TrainBannerView.this.e();
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (TrainBannerView.this.isAttachedToWindow()) {
                TrainBannerView.this.c.setTranslationX(fFloatValue);
                TrainBannerView.this.d.setTranslationX(fFloatValue + this.a);
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TrainBannerView.this.c.setTranslationX(0.0f);
            TrainBannerView.this.d.setTranslationX(0.0f);
            TrainBannerView.this.getParent().requestLayout();
            if (TrainBannerView.this.isAttachedToWindow()) {
                TrainBannerView.this.d();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (TrainBannerView.this.isAttachedToWindow()) {
                TrainBannerView.this.e.setTranslationX((-1.0f) * fFloatValue);
                TrainBannerView.this.f.setTranslationX(fFloatValue);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrainBannerView.this.f();
            if (TrainBannerView.this.y != null) {
                TrainBannerView.this.y.onAdClose();
            }
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ TapBannerAd.BannerInteractionListener c;

        f(AdInfo adInfo, Activity activity, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
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
            com.tapsdk.tapad.internal.s.a.a(this.b, true, this.a, TrainBannerView.this.A);
            TapBannerAd.BannerInteractionListener bannerInteractionListener = this.c;
            if (bannerInteractionListener != null) {
                bannerInteractionListener.onAdClick();
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter = TrainBannerView.this.A;
            if (downloadPresenter != null) {
                downloadPresenter.a(new DownloadPresenter.g());
            }
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ Activity a;

        h(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrainBannerView.this.a(this.a, 0);
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ Activity a;

        i(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrainBannerView.this.a(this.a, 1);
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

    class l implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        l(Activity activity, AdInfo adInfo) {
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

    class m implements DownloadPresenter.h {
        m() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            TapADLogger.d("install success");
            TrainBannerView.this.g();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i % 5 == 0) {
                TrainBannerView.this.h.setProgress(i);
            }
            TrainBannerView.this.w.setText(i + "%");
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            TapADLogger.d("install fail");
            TrainBannerView.this.g();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TrainBannerView.this.g();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            TrainBannerView.this.g();
            TrainBannerView trainBannerView = TrainBannerView.this;
            trainBannerView.A.a(new DownloadPresenter.k(trainBannerView.z));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            TrainBannerView.this.g();
        }
    }

    public TrainBannerView(Context context) {
        super(context);
        c();
    }

    public TrainBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public TrainBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    public TrainBannerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        c();
    }

    private void a() {
        this.q.setVisibility(this.z.renderStyles.d == 1 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i2) {
        DownloadPresenter downloadPresenter;
        com.tapsdk.tapad.internal.b jVar;
        AdInfo adInfo = this.z;
        if (adInfo == null) {
            return;
        }
        TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
        if (tapADTrackerObject != null) {
            tapADTrackerObject.a(i2, null);
        } else {
            com.tapsdk.tapad.internal.tracker.c.a().a(s.a(this.z.clickMonitorUrls, i2), (Map<String, String>) null, this.z.getClickMonitorHeaderListWrapper());
        }
        AdInfo adInfo2 = this.z;
        if (adInfo2.btnInteractionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo2, this.A);
            return;
        }
        DownloadPresenter.DownloadState downloadStateC = this.A.c();
        if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(activity, this.z.appInfo.packageName)) {
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                g();
                downloadPresenter = this.A;
                jVar = new DownloadPresenter.j(this.z);
            } else {
                if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                    return;
                }
                if (com.tapsdk.tapad.internal.a.a(getContext(), this.z).exists()) {
                    downloadPresenter = this.A;
                    jVar = new DownloadPresenter.k(this.z);
                } else {
                    downloadPresenter = this.A;
                    jVar = new DownloadPresenter.i(this.z);
                }
            }
            downloadPresenter.a(jVar);
        } else if (!com.tapsdk.tapad.internal.utils.b.b(activity, this.z.appInfo.packageName)) {
            TapADLogger.d("WavesBannerView 打开异常");
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.y;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onDownloadClick();
        }
    }

    private void b() {
        this.A = new DownloadPresenter(getContext(), new m());
    }

    private void c() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_banner_train, this);
        this.a = viewInflate;
        this.b = viewInflate.findViewById(R.id.close_image_view);
        this.c = (ImageView) this.a.findViewById(R.id.train_body_enter_view);
        this.d = this.a.findViewById(R.id.banner_body_view);
        this.e = (ImageView) this.a.findViewById(R.id.train_left_door);
        this.f = (ImageView) this.a.findViewById(R.id.train_right_door);
        this.g = (ImageView) this.a.findViewById(R.id.interaction_rotate_view);
        this.h = (TrainProgressBar) this.a.findViewById(R.id.download_progressbar);
        this.o = this.a.findViewById(R.id.interaction_body_content);
        this.i = (ImageView) this.a.findViewById(R.id.app_icon_view);
        this.j = (TextView) this.a.findViewById(R.id.title_text_view);
        this.k = (TextView) this.a.findViewById(R.id.description_text_View);
        this.l = (ImageView) this.a.findViewById(R.id.ad_log_icon);
        this.m = (TextView) this.a.findViewById(R.id.ad_log_text);
        this.n = this.a.findViewById(R.id.ad_hot_view);
        this.p = this.a.findViewById(R.id.download_progressbar_content);
        this.q = this.a.findViewById(R.id.ad_component_info);
        this.r = (TextView) this.a.findViewById(R.id.app_privacy_version_text);
        this.s = (TextView) this.a.findViewById(R.id.app_supplier_text);
        this.t = (TextView) this.a.findViewById(R.id.app_describe_text);
        this.u = (TextView) this.a.findViewById(R.id.app_privacy_text);
        this.v = (TextView) this.a.findViewById(R.id.app_permission_text);
        this.w = (TextView) this.a.findViewById(R.id.interaction_title);
        this.x = (TextView) this.a.findViewById(R.id.interaction_description);
        this.b.setOnClickListener(new e());
        Glide.with(getContext()).asGif().load("https://tapad-platform.tapimg.com/adn_resources/adn-sdk-resources/ui-styles/tapad_banner_train_rotate.gif").into(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, TypedValue.applyDimension(1, 34.0f, getResources().getDisplayMetrics()));
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new d());
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        int measuredWidth = getMeasuredWidth();
        float fApplyDimension = TypedValue.applyDimension(1, 54.0f, getResources().getDisplayMetrics());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(measuredWidth, (-1.0f) * fApplyDimension);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.addUpdateListener(new b(fApplyDimension));
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView;
        int i2;
        AdInfo adInfo = this.z;
        if (adInfo == null || this.A == null || adInfo.btnInteractionInfo.interactionType != 1) {
            return;
        }
        this.x.setText(R.string.tapad_banner_train_interaction_desc_download);
        DownloadPresenter.DownloadState downloadStateC = this.A.c();
        if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), this.z.appInfo.packageName)) {
            this.p.setVisibility(8);
            this.w.setText(R.string.tapad_banner_train_interaction_title_open);
            return;
        }
        int iB = this.A.b();
        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
            textView = this.w;
            i2 = R.string.tapad_banner_train_interaction_title_download;
        } else if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
            this.h.setProgress(iB);
            this.p.setVisibility(0);
            return;
        } else {
            textView = this.w;
            i2 = R.string.tapad_banner_train_interaction_title_install;
        }
        textView.setText(i2);
        this.p.setVisibility(8);
    }

    public void a(Activity activity, AdInfo adInfo, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
        if (adInfo == null) {
            return;
        }
        this.z = adInfo;
        this.y = bannerInteractionListener;
        if (this.A == null) {
            b();
        }
        a();
        Glide.with(activity.getApplicationContext()).load(adInfo.appInfo.appIconImage.imageUrl).into(this.i);
        Glide.with(getContext()).asGif().load(adInfo.getBannerTrainRotateGif()).into(this.g);
        this.j.setText(adInfo.materialInfo.title);
        this.k.setText(adInfo.materialInfo.description);
        g();
        this.a.setOnClickListener(new f(adInfo, activity, bannerInteractionListener));
        this.h.setOnClickListener(new g());
        this.o.setOnClickListener(new h(activity));
        this.l.setVisibility(adInfo.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getResources().getString(R.string.tapad_str_ads);
        String str = adInfo.logoInfo.logoTitle;
        if (str != null && str.length() > 0 && adInfo.logoInfo.logoTitle.length() < 5) {
            string = adInfo.logoInfo.logoTitle;
        }
        this.m.setText(string);
        this.n.setVisibility(com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo) ? 0 : 8);
        this.n.setOnClickListener(new i(activity));
        String str2 = adInfo.appInfo.appVersion;
        if (str2 != null && str2.length() > 0) {
            this.r.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str3 = adInfo.appInfo.appDeveloper;
        if (str3 != null && str3.length() > 0) {
            this.s.setText(adInfo.appInfo.appDeveloper);
        }
        this.t.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.t.setOnClickListener(new j(activity, adInfo));
        this.u.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.u.setOnClickListener(new k(activity, adInfo));
        this.v.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.v.setOnClickListener(new l(activity, adInfo));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ExposureTrackerObject exposureTrackerObject;
        super.onAttachedToWindow();
        if (this.z == null) {
            return;
        }
        this.c.setAlpha(0.0f);
        this.d.setAlpha(0.0f);
        postDelayed(new a(), 300L);
        TapADTrackerObject tapADTrackerObject = this.z.tapADTrackerObject;
        if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.z;
            cVarA.a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
        } else {
            exposureTrackerObject.b((Map<String, String>) null);
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.y;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onAdShow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
        DownloadPresenter downloadPresenter = this.A;
        if (downloadPresenter != null) {
            downloadPresenter.a(new com.tapsdk.tapad.internal.d());
        }
    }
}
