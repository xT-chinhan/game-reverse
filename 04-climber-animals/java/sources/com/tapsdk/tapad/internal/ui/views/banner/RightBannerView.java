package com.tapsdk.tapad.internal.ui.views.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.HotZoneFrameLayout;
import com.tapsdk.tapad.internal.ui.views.TagView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.internal.utils.t;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.tapsdk.tapad.model.entities.TagDetail;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RightBannerView extends RelativeLayout {
    public static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    DownloadPresenter downloadPresenter;
    private Drawable greenShakeDrawable;
    private boolean isShakeV2Enable;
    private com.tapsdk.tapad.internal.r.a rewardAdInnerBannerEventCallback;
    private LinearLayout rightBannerMasterLinearLayout;
    private ImageView rightSquareAdLogoImageView;
    private TextView rightSquareAdLogoTextView;
    private RelativeLayout rightSquareBannerAdsRelativeLayout;
    private TextView rightSquareBannerDescribeTextView;
    private FrameLayout rightSquareBannerDownloadFrameLayout;
    private ProgressBar rightSquareBannerDownloadProgressBar;
    private HotZoneFrameLayout rightSquareBannerHotZoneFrameLayout;
    private FrameLayout rightSquareBannerInteractionFrameLayout;
    private TextView rightSquareBannerInteractionTextView;
    private TextView rightSquareBannerPermissionTextView;
    private TextView rightSquareBannerPrivacyTextView;
    private TextView rightSquareBannerPrivacyVersionTextView;
    private TextView rightSquareBannerRealScoreTextView;
    private RelativeLayout rightSquareBannerScoreRelativeLayout;
    private TextView rightSquareBannerSupplierTextView;
    private com.tapsdk.tapad.internal.animation.l.a shakeAcceleratorDetector;
    private com.tapsdk.tapad.internal.animation.h shakeController;
    private com.tapsdk.tapad.internal.animation.i shakeDetector;
    private boolean shakeEnable;
    private com.tapsdk.tapad.internal.animation.l.b shakeRotationDetector;
    private TagView tagView;
    private Drawable whiteShakeDrawable;

    class a implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            RightBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            RightBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            RightBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TapADLogger.d("downloadStart---");
            RightBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            RightBannerView.this.updateInteractionLayout();
            RightBannerView.this.downloadPresenter.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            RightBannerView.this.updateInteractionLayout();
        }
    }

    class b implements com.tapsdk.tapad.internal.animation.e {
        final /* synthetic */ Activity a;

        b(Activity activity) {
            this.a = activity;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            RightBannerView.this.shakeEnable = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            RightBannerView.this.onInteractionButtonClick(this.a, i);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter = RightBannerView.this.downloadPresenter;
            if (downloadPresenter != null) {
                downloadPresenter.a(new DownloadPresenter.g());
            }
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ Activity a;

        d(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RightBannerView.this.onInteractionButtonClick(this.a, 0);
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;

        e(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter) {
            this.a = adInfo;
            this.b = activity;
            this.c = downloadPresenter;
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
            com.tapsdk.tapad.internal.s.a.a(this.b, true, this.a, this.c);
        }
    }

    class f implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        f(Activity activity, AdInfo adInfo) {
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

    class g implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        g(Activity activity, AdInfo adInfo) {
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

    class h implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        h(Activity activity, AdInfo adInfo) {
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

    class i implements ViewTreeObserver.OnGlobalLayoutListener {
        i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (RightBannerView.this.rightBannerMasterLinearLayout.getHeight() > 0) {
                RightBannerView.this.rightBannerMasterLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RightBannerView.this.rightBannerMasterLinearLayout.getHeight() < RightBannerView.this.rightSquareBannerInteractionFrameLayout.getTop() + RightBannerView.this.rightSquareBannerInteractionFrameLayout.getHeight()) {
                    RightBannerView.this.rightSquareBannerScoreRelativeLayout.setVisibility(8);
                }
            }
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ Activity a;

        j(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RightBannerView.this.onInteractionButtonClick(this.a, 1);
        }
    }

    public RightBannerView(Context context) {
        super(context);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public RightBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public RightBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public RightBannerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    private void initDownloadPresenter(Activity activity, AdInfo adInfo) {
        this.downloadPresenter = new DownloadPresenter(activity, new a(adInfo));
    }

    private void initView() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_banner_w320, this);
        this.rightSquareBannerInteractionTextView = (TextView) viewInflate.findViewById(R.id.rightSquareBannerInteractionTextView);
        this.rightSquareBannerDownloadProgressBar = (ProgressBar) viewInflate.findViewById(R.id.rightSquareBannerDownloadProgressBar);
        this.rightSquareBannerScoreRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rightSquareBannerScoreRelativeLayout);
        this.rightSquareBannerRealScoreTextView = (TextView) viewInflate.findViewById(R.id.rightSquareBannerRealScoreTextView);
        this.rightSquareBannerDescribeTextView = (TextView) viewInflate.findViewById(R.id.describeTextView);
        this.rightSquareBannerPrivacyTextView = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.rightSquareBannerPermissionTextView = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.rightSquareBannerDownloadFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.rightSquareBannerDownloadFrameLayout);
        this.rightBannerMasterLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.rightBannerMasterLinearLayout);
        this.rightSquareBannerInteractionFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.rightSquareBannerInteractionFrameLayout);
        this.rightSquareBannerPrivacyVersionTextView = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.rightSquareBannerSupplierTextView = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.rightSquareAdLogoTextView = (TextView) viewInflate.findViewById(R.id.rightSquareAdLogoTextView);
        this.rightSquareAdLogoImageView = (ImageView) viewInflate.findViewById(R.id.rightSquareAdLogoImageView);
        this.rightSquareBannerAdsRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rightSquareBannerAdsRelativeLayout);
        this.tagView = (TagView) findViewById(R.id.tagView);
        this.rightSquareBannerHotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.rightSquareBannerHotZoneFrameLayout);
    }

    private void providePresenter(DownloadPresenter downloadPresenter) {
        this.downloadPresenter = downloadPresenter;
    }

    public DownloadPresenter getDownloadPresenter() {
        return this.downloadPresenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public void onInteractionButtonClick(Activity activity, int i2) {
        onInteractionButtonClick(activity, i2, true);
    }

    public void onInteractionButtonClick(Activity activity, int i2, boolean z) {
        DownloadPresenter downloadPresenter;
        com.tapsdk.tapad.internal.b jVar;
        if (z) {
            TapADTrackerObject tapADTrackerObject = this.adInfo.tapADTrackerObject;
            if (tapADTrackerObject != null) {
                tapADTrackerObject.a(i2, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(s.a(this.adInfo.clickMonitorUrls, i2), (Map<String, String>) null, this.adInfo.getClickMonitorHeaderListWrapper());
            }
            com.tapsdk.tapad.internal.r.a aVar = this.rewardAdInnerBannerEventCallback;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
        AdInfo adInfo = this.adInfo;
        if (adInfo.btnInteractionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo, this.downloadPresenter);
            return;
        }
        if (com.tapsdk.tapad.internal.utils.b.a(activity, adInfo.appInfo.packageName)) {
            if (com.tapsdk.tapad.internal.utils.b.b(activity, this.adInfo.appInfo.packageName)) {
                return;
            }
            TapADLogger.d("RightBannerView 打开异常");
            return;
        }
        DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
            updateInteractionLayout();
            downloadPresenter = this.downloadPresenter;
            jVar = new DownloadPresenter.j(this.adInfo);
        } else {
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                return;
            }
            if (com.tapsdk.tapad.internal.a.a(getContext(), this.adInfo).exists()) {
                downloadPresenter = this.downloadPresenter;
                jVar = new DownloadPresenter.k(this.adInfo);
            } else {
                downloadPresenter = this.downloadPresenter;
                jVar = new DownloadPresenter.i(this.adInfo);
            }
        }
        downloadPresenter.a(jVar);
    }

    public void onPause() {
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter, boolean z) {
        render(activity, adInfo, downloadPresenter, z, null);
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter, boolean z, com.tapsdk.tapad.internal.r.a aVar) {
        TextView textView;
        this.rewardAdInnerBannerEventCallback = aVar;
        this.shakeEnable = z;
        this.adInfo = adInfo;
        this.isShakeV2Enable = com.tapsdk.tapad.internal.utils.c.c(adInfo.btnInteractionInfo);
        if (z && com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)) {
            if (this.shakeController == null) {
                this.shakeController = com.tapsdk.tapad.internal.animation.h.a(activity, new b(activity));
            }
            if (this.shakeDetector == null && !this.isShakeV2Enable) {
                this.shakeDetector = new com.tapsdk.tapad.internal.animation.i();
                float fExtractShakeAngle = adInfo.btnInteractionInfo.extractShakeAngle();
                if (fExtractShakeAngle > 0.0f) {
                    this.shakeDetector.a(fExtractShakeAngle);
                }
            }
            if (this.shakeAcceleratorDetector == null && this.isShakeV2Enable) {
                com.tapsdk.tapad.internal.animation.l.a aVar2 = new com.tapsdk.tapad.internal.animation.l.a();
                this.shakeAcceleratorDetector = aVar2;
                aVar2.a(adInfo.btnInteractionInfo.extractXShakeSpeedEnable(), adInfo.btnInteractionInfo.extractYShakeSpeedEnable(), adInfo.btnInteractionInfo.extractZShakeSpeedEnable(), adInfo.btnInteractionInfo.extractXShakeSpeed(), adInfo.btnInteractionInfo.extractYShakeSpeed(), adInfo.btnInteractionInfo.extractZShakeSpeed());
            }
            if (this.shakeRotationDetector == null && this.isShakeV2Enable) {
                com.tapsdk.tapad.internal.animation.l.b bVar = new com.tapsdk.tapad.internal.animation.l.b();
                this.shakeRotationDetector = bVar;
                bVar.a(adInfo.btnInteractionInfo.extractXShakeDegreeEnable(), adInfo.btnInteractionInfo.extractYShakeDegreeEnable(), adInfo.btnInteractionInfo.extractZShakeDegreeEnable(), adInfo.btnInteractionInfo.extractXShakeDegree(), adInfo.btnInteractionInfo.extractYShakeDegree(), adInfo.btnInteractionInfo.extractZShakeDegree());
            }
            Drawable drawable = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.greenShakeDrawable = drawable;
            drawable.setBounds(0, 0, t.a(getContext(), 20.0f), t.a(getContext(), 20.0f));
            this.greenShakeDrawable.setTint(getResources().getColor(R.color.tapad_color_green));
            Drawable drawable2 = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.whiteShakeDrawable = drawable2;
            drawable2.setBounds(0, 0, t.a(getContext(), 20.0f), t.a(getContext(), 20.0f));
            this.whiteShakeDrawable.setTint(getResources().getColor(android.R.color.white));
        }
        if (downloadPresenter == null) {
            initDownloadPresenter(activity, adInfo);
        } else {
            providePresenter(downloadPresenter);
        }
        ((TextView) findViewById(R.id.rightSquareBannerTitleTextView)).setText(adInfo.materialInfo.title);
        ((TextView) findViewById(R.id.rightSquareBannerDescriptionTextView)).setText(adInfo.materialInfo.description);
        Glide.with(activity).load(adInfo.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.rightSquareBannerIconImageView));
        updateInteractionLayout();
        this.rightSquareBannerDownloadFrameLayout.setOnClickListener(new c());
        this.rightSquareBannerInteractionTextView.setOnClickListener(new d(activity));
        this.rightSquareBannerAdsRelativeLayout.setOnClickListener(new e(adInfo, activity, downloadPresenter));
        this.rightSquareBannerScoreRelativeLayout.setVisibility(adInfo.appInfo.tapScore > 0.0f ? 0 : 8);
        if (adInfo.appInfo.tapScore > 0.0f) {
            try {
                this.rightSquareBannerRealScoreTextView.setText(new DecimalFormat("#.0").format(adInfo.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        this.rightSquareBannerDescribeTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.rightSquareBannerDescribeTextView.setOnClickListener(new f(activity, adInfo));
        this.rightSquareBannerPrivacyTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.rightSquareBannerPrivacyTextView.setOnClickListener(new g(activity, adInfo));
        this.rightSquareBannerPermissionTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.rightSquareBannerPermissionTextView.setOnClickListener(new h(activity, adInfo));
        this.rightBannerMasterLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new i());
        String str = adInfo.appInfo.appVersion;
        String str2 = "";
        if (str == null || str.length() <= 0) {
            this.rightSquareBannerPrivacyVersionTextView.setText("");
        } else {
            this.rightSquareBannerPrivacyVersionTextView.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str3 = adInfo.appInfo.appDeveloper;
        if (str3 == null || str3.length() <= 0) {
            textView = this.rightSquareBannerSupplierTextView;
        } else {
            textView = this.rightSquareBannerSupplierTextView;
            str2 = adInfo.appInfo.appDeveloper;
        }
        textView.setText(str2);
        this.rightSquareAdLogoImageView.setVisibility(adInfo.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getResources().getString(R.string.tapad_str_ads);
        String str4 = adInfo.logoInfo.logoTitle;
        if (str4 != null && str4.length() > 0 && adInfo.logoInfo.logoTitle.length() < 5) {
            string = adInfo.logoInfo.logoTitle;
        }
        ImageInfo imageInfo = adInfo.logoInfo.logoImage;
        if (imageInfo != null && !TextUtils.isEmpty(imageInfo.imageUrl)) {
            Glide.with(this.rightSquareAdLogoImageView.getContext()).load(adInfo.logoInfo.logoImage.imageUrl).into(this.rightSquareAdLogoImageView);
        }
        this.rightSquareAdLogoTextView.setText(string);
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo);
        this.rightSquareBannerHotZoneFrameLayout.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.rightSquareBannerHotZoneFrameLayout.setOnClickListener(new j(activity));
        }
    }

    public void startTags(List<TagDetail> list) {
        this.tagView.b(list, 10, 1, 0);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0177  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    public void updateInteractionLayout() {
        boolean z;
        com.tapsdk.tapad.internal.animation.h hVar;
        AdInfo adInfo;
        com.tapsdk.tapad.internal.animation.h hVar2;
        com.tapsdk.tapad.internal.animation.a aVar;
        Drawable drawable = this.whiteShakeDrawable;
        AdInfo adInfo2 = this.adInfo;
        if (adInfo2.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(getContext(), this.adInfo.appInfo.packageName)) {
                this.rightSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
                this.rightSquareBannerInteractionTextView.setTextColor(getResources().getColor(android.R.color.white));
                Drawable drawable2 = this.whiteShakeDrawable;
                int iB = this.downloadPresenter.b();
                if (downloadStateC != DownloadPresenter.DownloadState.DEFAULT && downloadStateC != DownloadPresenter.DownloadState.ERROR) {
                    if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                        this.rightSquareBannerDownloadFrameLayout.setVisibility(0);
                        this.rightSquareBannerDownloadProgressBar.setProgress(Math.max(iB, 10));
                        this.rightSquareBannerInteractionTextView.setVisibility(8);
                        drawable = drawable2;
                        z = false;
                    } else {
                        this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                        this.rightSquareBannerInteractionTextView.setVisibility(0);
                        this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_install);
                    }
                    if (z || !this.shakeEnable || (adInfo = this.adInfo) == null || drawable == null || !com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)) {
                        hVar = this.shakeController;
                        if (hVar == null) {
                            return;
                        }
                    } else {
                        com.tapsdk.tapad.internal.animation.j jVar = new com.tapsdk.tapad.internal.animation.j(drawable, 0, t.a(getContext(), 4.0f));
                        SpannableString spannableString = new SpannableString("$" + this.rightSquareBannerInteractionTextView.getText().toString());
                        spannableString.setSpan(jVar, 0, 1, 33);
                        this.rightSquareBannerInteractionTextView.setText(spannableString);
                        if (this.shakeController == null) {
                            return;
                        }
                        if (getVisibility() == 0) {
                            if (this.isShakeV2Enable) {
                                this.shakeController.a((com.tapsdk.tapad.internal.animation.a) this.shakeAcceleratorDetector);
                                hVar2 = this.shakeController;
                                aVar = this.shakeRotationDetector;
                            } else {
                                hVar2 = this.shakeController;
                                aVar = this.shakeDetector;
                            }
                            hVar2.a(aVar);
                            return;
                        }
                        hVar = this.shakeController;
                    }
                    hVar.a();
                }
                AppInfo appInfo = this.adInfo.appInfo;
                if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                    this.rightSquareBannerInteractionTextView.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.adInfo.appInfo.appSize));
                } else {
                    this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_download);
                }
                this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                this.rightSquareBannerInteractionTextView.setVisibility(0);
                drawable = drawable2;
            } else {
                this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_open);
                this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                this.rightSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.rightSquareBannerInteractionTextView.setTextColor(getResources().getColor(R.color.tapad_color_green));
                drawable = this.greenShakeDrawable;
            }
        } else {
            String str = adInfo2.btnName;
            if (str == null || str.length() <= 0) {
                this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_open);
            } else {
                this.rightSquareBannerInteractionTextView.setText(this.adInfo.btnName);
            }
        }
        z = true;
        if (z) {
            hVar = this.shakeController;
            if (hVar == null) {
                return;
            }
        } else {
            hVar = this.shakeController;
            if (hVar == null) {
                return;
            }
        }
        hVar.a();
    }
}
