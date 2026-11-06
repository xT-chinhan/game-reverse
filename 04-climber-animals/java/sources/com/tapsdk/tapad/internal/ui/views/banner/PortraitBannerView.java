package com.tapsdk.tapad.internal.ui.views.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.HotZoneFrameLayout;
import com.tapsdk.tapad.internal.ui.views.TagView;
import com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView;
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
public class PortraitBannerView extends RelativeLayout {
    public static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    private String adType;
    private RelativeLayout bannerFooterRelativeLayout;
    TapBannerAd.BannerInteractionListener bannerInteractionListener;
    DownloadPresenter downloadPresenter;
    com.tapsdk.tapad.internal.tracker.b exposureHandler;
    private Drawable greenShakeDrawable;
    private ImageView iconImageView;
    private boolean isInnerBrowser;
    private boolean isShakeV2Enable;
    private BottomDownloadingView.d onParentViewListener;
    private RelativeLayout portraitAdsRelativeLayout;
    private HotZoneFrameLayout portraitBannerAdHotZoneFrameLayout;
    private ImageView portraitBannerAdLogoImageView;
    private LinearLayout portraitBannerAdLogoLinearLayout;
    private TextView portraitBannerAdLogoTextView;
    private ImageView portraitCloseBannerImageView;
    private TextView portraitDescribeTextView;
    private FrameLayout portraitDownloadFrameLayout;
    private ProgressBar portraitDownloadProgressBar;
    private TextView portraitInteractionTextView;
    private TextView portraitPermissionTextView;
    private TextView portraitPrivacyTextView;
    private TextView portraitPrivacyVersionTextView;
    private TextView portraitRealScoreTextView;
    private LinearLayout portraitScoreLinearLayout;
    private TextView portraitSupplierTextView;
    private com.tapsdk.tapad.internal.r.a rewardAdInnerBannerEventCallback;
    private com.tapsdk.tapad.internal.animation.l.a shakeAcceleratorDetector;
    private com.tapsdk.tapad.internal.animation.h shakeController;
    private com.tapsdk.tapad.internal.animation.i shakeDetector;
    private boolean shakeEnable;
    private com.tapsdk.tapad.internal.animation.l.b shakeRotationDetector;
    private TagView tagView;
    private boolean useAlone;
    private Drawable whiteShakeDrawable;

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

    class b implements View.OnClickListener {
        final /* synthetic */ Activity a;

        b(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitBannerView.this.onInteractionButtonClick(this.a, 1);
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                PortraitBannerView.this.bannerFooterRelativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (PortraitBannerView.this.bannerFooterRelativeLayout.getTop() < PortraitBannerView.this.iconImageView.getTop() + PortraitBannerView.this.iconImageView.getHeight()) {
                    PortraitBannerView.this.bannerFooterRelativeLayout.setVisibility(8);
                }
            } catch (Throwable unused) {
            }
        }
    }

    class d implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        d() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            TapBannerAd.BannerInteractionListener bannerInteractionListener = PortraitBannerView.this.bannerInteractionListener;
            if (bannerInteractionListener != null) {
                bannerInteractionListener.onAdValidShow();
            }
        }
    }

    class e implements DownloadPresenter.h {
        e() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            TapADLogger.d("install success");
            PortraitBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i > 10) {
                PortraitBannerView.this.portraitDownloadProgressBar.setProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            TapADLogger.d("install fail");
            PortraitBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            PortraitBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            PortraitBannerView.this.updateInteractionLayout();
            PortraitBannerView portraitBannerView = PortraitBannerView.this;
            portraitBannerView.downloadPresenter.a(new DownloadPresenter.k(portraitBannerView.adInfo));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            PortraitBannerView.this.updateInteractionLayout();
        }
    }

    class f implements com.tapsdk.tapad.internal.animation.e {
        final /* synthetic */ Activity a;

        f(Activity activity) {
            this.a = activity;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            PortraitBannerView.this.shakeEnable = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            PortraitBannerView.this.onInteractionButtonClick(this.a, i);
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;
        final /* synthetic */ TapBannerAd.BannerInteractionListener d;

        g(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
            this.a = adInfo;
            this.b = activity;
            this.c = downloadPresenter;
            this.d = bannerInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitBannerView.this.isInnerBrowser) {
                return;
            }
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
            if (this.d == null || !PortraitBannerView.this.useAlone) {
                return;
            }
            this.d.onAdClick();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter = PortraitBannerView.this.downloadPresenter;
            if (downloadPresenter != null) {
                downloadPresenter.a(new DownloadPresenter.g());
                if (PortraitBannerView.this.onParentViewListener != null) {
                    PortraitBannerView.this.onParentViewListener.b();
                }
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
            PortraitBannerView.this.onInteractionButtonClick(this.a, 0);
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ TapBannerAd.BannerInteractionListener c;

        j(AdInfo adInfo, Activity activity, TapBannerAd.BannerInteractionListener bannerInteractionListener) {
            this.a = adInfo;
            this.b = activity;
            this.c = bannerInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitBannerView.this.isInnerBrowser && PortraitBannerView.this.onParentViewListener != null) {
                PortraitBannerView.this.onParentViewListener.a();
                return;
            }
            AdInfo adInfo = this.a;
            if (adInfo != null && adInfo.isFirstPassiveTransfer && adInfo.isCloseTransferEnable) {
                adInfo.isFirstPassiveTransfer = false;
                PortraitBannerView.this.onInteractionButtonClick(this.b, 10);
                return;
            }
            PortraitBannerView.this.tryToRemoveSelf();
            if (this.c == null || !PortraitBannerView.this.useAlone) {
                return;
            }
            this.c.onAdClose();
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appDescUrl, adInfo);
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPrivacyPolicy, adInfo);
        }
    }

    public PortraitBannerView(Context context) {
        super(context);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new d());
        this.shakeEnable = false;
        this.rewardAdInnerBannerEventCallback = null;
        this.isShakeV2Enable = false;
        this.isInnerBrowser = false;
        this.onParentViewListener = null;
        initView();
    }

    public PortraitBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new d());
        this.shakeEnable = false;
        this.rewardAdInnerBannerEventCallback = null;
        this.isShakeV2Enable = false;
        this.isInnerBrowser = false;
        this.onParentViewListener = null;
        initView();
    }

    public PortraitBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new d());
        this.shakeEnable = false;
        this.rewardAdInnerBannerEventCallback = null;
        this.isShakeV2Enable = false;
        this.isInnerBrowser = false;
        this.onParentViewListener = null;
        initView();
    }

    public PortraitBannerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new d());
        this.shakeEnable = false;
        this.rewardAdInnerBannerEventCallback = null;
        this.isShakeV2Enable = false;
        this.isInnerBrowser = false;
        this.onParentViewListener = null;
        initView();
    }

    public PortraitBannerView(Context context, AdInfo adInfo) {
        super(context);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new d());
        this.shakeEnable = false;
        this.rewardAdInnerBannerEventCallback = null;
        this.isShakeV2Enable = false;
        this.isInnerBrowser = false;
        this.onParentViewListener = null;
        initView(adInfo);
    }

    private void initPresenter() {
        this.downloadPresenter = new DownloadPresenter(getContext(), new e());
    }

    private void initView() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_banner_portrait, this);
        this.portraitInteractionTextView = (TextView) viewInflate.findViewById(R.id.portraitInteractionTextView);
        this.portraitDownloadProgressBar = (ProgressBar) viewInflate.findViewById(R.id.portraitDownloadProgressBar);
        this.portraitDownloadFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.portraitDownloadFrameLayout);
        this.portraitScoreLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.portraitScoreLinearLayout);
        this.portraitRealScoreTextView = (TextView) viewInflate.findViewById(R.id.portraitRealScoreTextView);
        this.portraitCloseBannerImageView = (ImageView) viewInflate.findViewById(R.id.portraitCloseBannerImageView);
        this.portraitDescribeTextView = (TextView) findViewById(R.id.describeTextView);
        this.portraitPrivacyTextView = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.portraitPermissionTextView = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.portraitPrivacyVersionTextView = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.portraitSupplierTextView = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.portraitBannerAdLogoTextView = (TextView) viewInflate.findViewById(R.id.portraitBannerAdLogoTextView);
        this.portraitBannerAdLogoImageView = (ImageView) viewInflate.findViewById(R.id.portraitBannerAdLogoImageView);
        this.portraitAdsRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.portraitAdsRelativeLayout);
        this.portraitBannerAdLogoLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.portraitBannerAdLogoLinearLayout);
        this.tagView = (TagView) viewInflate.findViewById(R.id.tagView);
        if (TextUtils.equals(this.adType, AdType.NativeFeedAd.name())) {
            this.portraitBannerAdLogoTextView.setVisibility(8);
            this.portraitBannerAdLogoImageView.setVisibility(8);
            this.portraitBannerAdLogoLinearLayout.setVisibility(8);
        }
        this.portraitBannerAdHotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.portraitBannerAdHotZoneFrameLayout);
    }

    private void initView(AdInfo adInfo) {
        View viewInflate;
        List<TagDetail> list = adInfo.highlightTags;
        if (list == null || list.size() <= 0) {
            viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_banner_portrait_without_tag, this);
        } else {
            viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_banner_portrait, this);
            this.tagView = (TagView) viewInflate.findViewById(R.id.tagView);
        }
        this.portraitInteractionTextView = (TextView) viewInflate.findViewById(R.id.portraitInteractionTextView);
        this.portraitDownloadProgressBar = (ProgressBar) viewInflate.findViewById(R.id.portraitDownloadProgressBar);
        this.portraitDownloadFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.portraitDownloadFrameLayout);
        this.portraitScoreLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.portraitScoreLinearLayout);
        this.portraitRealScoreTextView = (TextView) viewInflate.findViewById(R.id.portraitRealScoreTextView);
        this.portraitCloseBannerImageView = (ImageView) viewInflate.findViewById(R.id.portraitCloseBannerImageView);
        this.portraitDescribeTextView = (TextView) findViewById(R.id.describeTextView);
        this.portraitPrivacyTextView = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.portraitPermissionTextView = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.portraitPrivacyVersionTextView = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.portraitSupplierTextView = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.portraitBannerAdLogoTextView = (TextView) viewInflate.findViewById(R.id.portraitBannerAdLogoTextView);
        this.portraitBannerAdLogoImageView = (ImageView) viewInflate.findViewById(R.id.portraitBannerAdLogoImageView);
        this.portraitAdsRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.portraitAdsRelativeLayout);
        this.portraitBannerAdLogoLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.portraitBannerAdLogoLinearLayout);
        if (TextUtils.equals(this.adType, AdType.NativeFeedAd.name())) {
            this.portraitBannerAdLogoTextView.setVisibility(8);
            this.portraitBannerAdLogoImageView.setVisibility(8);
            this.portraitBannerAdLogoLinearLayout.setVisibility(8);
        }
        this.portraitBannerAdHotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.portraitBannerAdHotZoneFrameLayout);
        this.bannerFooterRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.bannerFooterRelativeLayout);
    }

    private void providePresenter(DownloadPresenter downloadPresenter) {
        this.downloadPresenter = downloadPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToRemoveSelf() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ExposureTrackerObject exposureTrackerObject;
        super.onAttachedToWindow();
        if (this.useAlone) {
            TapADTrackerObject tapADTrackerObject = this.adInfo.tapADTrackerObject;
            if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                AdInfo adInfo = this.adInfo;
                cVarA.a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
            } else {
                exposureTrackerObject.b((Map<String, String>) null);
            }
            TapBannerAd.BannerInteractionListener bannerInteractionListener = this.bannerInteractionListener;
            if (bannerInteractionListener != null) {
                bannerInteractionListener.onAdShow();
            }
            RelativeLayout relativeLayout = this.bannerFooterRelativeLayout;
            if (relativeLayout == null || relativeLayout.getViewTreeObserver() == null) {
                return;
            }
            this.bannerFooterRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
        DownloadPresenter downloadPresenter = this.downloadPresenter;
        if (downloadPresenter != null) {
            downloadPresenter.a(new com.tapsdk.tapad.internal.d());
        }
        if (this.shakeController != null) {
            try {
                TapADLogger.e("TapAdShakeDetector onDetachedFromWindow destroy");
                this.shakeController.a();
            } catch (Exception unused) {
            }
        }
    }

    public void onInteractionButtonClick(Activity activity, int i2) {
        onInteractionButtonClick(activity, i2, true);
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
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
        if (this.adInfo.btnInteractionInfo.interactionType != 1 && !this.isInnerBrowser) {
            TapBannerAd.BannerInteractionListener bannerInteractionListener = this.bannerInteractionListener;
            if (bannerInteractionListener != null && this.useAlone) {
                bannerInteractionListener.onAdClick();
            }
            com.tapsdk.tapad.internal.s.a.a(activity, false, this.adInfo, this.downloadPresenter);
            return;
        }
        DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
        if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(activity, this.adInfo.appInfo.packageName)) {
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
        } else if (!com.tapsdk.tapad.internal.utils.b.b(activity, this.adInfo.appInfo.packageName)) {
            TapADLogger.d("PortraitBannerView 打开异常");
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener2 = this.bannerInteractionListener;
        if (bannerInteractionListener2 == null || !this.useAlone) {
            return;
        }
        bannerInteractionListener2.onDownloadClick();
    }

    public void onPause() {
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.adInfo == null) {
            return;
        }
        if (i2 == 0) {
            updateInteractionLayout();
        } else {
            com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
            if (hVar != null) {
                hVar.a();
            }
        }
        if (this.useAlone && i2 == 0) {
            com.tapsdk.tapad.internal.c.b().a(com.tapsdk.tapad.internal.utils.a.a(getContext()), this.adInfo);
        }
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter, TapBannerAd.BannerInteractionListener bannerInteractionListener, boolean z) {
        render(activity, adInfo, downloadPresenter, bannerInteractionListener, z, null);
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter, TapBannerAd.BannerInteractionListener bannerInteractionListener, boolean z, com.tapsdk.tapad.internal.r.a aVar) {
        TextView textView;
        this.rewardAdInnerBannerEventCallback = aVar;
        this.shakeEnable = z;
        this.adInfo = adInfo;
        this.isShakeV2Enable = com.tapsdk.tapad.internal.utils.c.c(adInfo.btnInteractionInfo);
        if (z && com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)) {
            if (this.shakeController == null) {
                this.shakeController = com.tapsdk.tapad.internal.animation.h.a(activity, new f(activity));
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
            initPresenter();
            this.useAlone = true;
            this.portraitCloseBannerImageView.setVisibility(0);
            if (adInfo.closeButtonInfo.a == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.portraitBannerAdLogoLinearLayout.getLayoutParams();
                layoutParams.addRule(9, -1);
                layoutParams.addRule(20, -1);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.portraitCloseBannerImageView.getLayoutParams();
                layoutParams2.addRule(11, -1);
                layoutParams2.addRule(21, -1);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.portraitBannerAdLogoLinearLayout.getLayoutParams();
                layoutParams3.addRule(11, -1);
                layoutParams3.addRule(21, -1);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.portraitCloseBannerImageView.getLayoutParams();
                layoutParams4.addRule(9, -1);
                layoutParams4.addRule(20, -1);
            }
            this.portraitBannerAdLogoLinearLayout.requestLayout();
            this.portraitCloseBannerImageView.requestLayout();
        } else {
            this.useAlone = false;
            providePresenter(downloadPresenter);
            if (this.isInnerBrowser) {
                this.portraitCloseBannerImageView.setVisibility(0);
            } else {
                this.portraitCloseBannerImageView.setVisibility(8);
            }
        }
        this.bannerInteractionListener = bannerInteractionListener;
        ((TextView) findViewById(R.id.portraitTitleTextView)).setText(adInfo.materialInfo.title);
        ((TextView) findViewById(R.id.portraitDescriptionTextView)).setText(adInfo.materialInfo.description);
        this.iconImageView = (ImageView) findViewById(R.id.portraitIconImageView);
        Glide.with(activity.getApplicationContext()).load(adInfo.appInfo.appIconImage.imageUrl).into(this.iconImageView);
        TagView tagView = this.tagView;
        if (tagView != null) {
            tagView.b(adInfo.highlightTags, 10, 3, 0);
        }
        updateInteractionLayout();
        this.portraitAdsRelativeLayout.setOnClickListener(new g(adInfo, activity, downloadPresenter, bannerInteractionListener));
        this.portraitDownloadFrameLayout.setOnClickListener(new h());
        this.portraitInteractionTextView.setOnClickListener(new i(activity));
        this.portraitScoreLinearLayout.setVisibility(adInfo.appInfo.tapScore > 0.0f ? 0 : 8);
        if (adInfo.appInfo.tapScore > 0.0f) {
            try {
                this.portraitRealScoreTextView.setText(new DecimalFormat("#.0").format(adInfo.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        this.portraitCloseBannerImageView.setOnClickListener(new j(adInfo, activity, bannerInteractionListener));
        this.portraitDescribeTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.portraitDescribeTextView.setOnClickListener(new k(activity, adInfo));
        this.portraitPrivacyTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.portraitPrivacyTextView.setOnClickListener(new l(activity, adInfo));
        this.portraitPermissionTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.portraitPermissionTextView.setOnClickListener(new a(activity, adInfo));
        String str = adInfo.appInfo.appVersion;
        String str2 = "";
        if (str == null || str.length() <= 0) {
            this.portraitPrivacyVersionTextView.setText("");
        } else {
            this.portraitPrivacyVersionTextView.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str3 = adInfo.appInfo.appDeveloper;
        if (str3 == null || str3.length() <= 0) {
            textView = this.portraitSupplierTextView;
        } else {
            textView = this.portraitSupplierTextView;
            str2 = adInfo.appInfo.appDeveloper;
        }
        textView.setText(str2);
        if (TextUtils.equals(this.adType, AdType.NativeFeedAd.name())) {
            this.portraitBannerAdLogoTextView.setVisibility(8);
            this.portraitBannerAdLogoImageView.setVisibility(8);
            this.portraitBannerAdLogoLinearLayout.setVisibility(8);
        } else {
            this.portraitBannerAdLogoImageView.setVisibility(adInfo.logoInfo.logoStatus == 1 ? 0 : 8);
            String string = getResources().getString(R.string.tapad_str_ads);
            String str4 = adInfo.logoInfo.logoTitle;
            if (str4 != null && str4.length() > 0 && adInfo.logoInfo.logoTitle.length() < 5) {
                string = adInfo.logoInfo.logoTitle;
            }
            ImageInfo imageInfo = adInfo.logoInfo.logoImage;
            if (imageInfo != null && !TextUtils.isEmpty(imageInfo.imageUrl)) {
                Glide.with(this.portraitBannerAdLogoImageView.getContext()).load(adInfo.logoInfo.logoImage.imageUrl).into(this.portraitBannerAdLogoImageView);
            }
            this.portraitBannerAdLogoTextView.setText(string);
        }
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo);
        this.portraitBannerAdHotZoneFrameLayout.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.portraitBannerAdHotZoneFrameLayout.setOnClickListener(new b(activity));
        }
        if (this.useAlone) {
            com.tapsdk.tapad.internal.tracker.b bVar2 = this.exposureHandler;
            TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
            bVar2.a(tapADTrackerObject == null ? null : tapADTrackerObject.a);
        }
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter, TapBannerAd.BannerInteractionListener bannerInteractionListener, boolean z, boolean z2, BottomDownloadingView.d dVar) {
        this.isInnerBrowser = z2;
        this.onParentViewListener = dVar;
        render(activity, adInfo, downloadPresenter, bannerInteractionListener, z, null);
    }

    public void setType(String str) {
        this.adType = str;
    }

    public void updateInteractionLayout() {
        TextView textView;
        int i2;
        boolean z;
        com.tapsdk.tapad.internal.animation.h hVar;
        AdInfo adInfo;
        com.tapsdk.tapad.internal.animation.h hVar2;
        com.tapsdk.tapad.internal.animation.a aVar;
        AdInfo adInfo2 = this.adInfo;
        if (adInfo2 == null) {
            return;
        }
        Drawable drawable = this.whiteShakeDrawable;
        if (adInfo2.btnInteractionInfo.interactionType == 1 || this.isInnerBrowser) {
            DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(getContext(), this.adInfo.appInfo.packageName)) {
                this.portraitInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner20dp);
                this.portraitInteractionTextView.setTextColor(getResources().getColor(android.R.color.white));
                drawable = this.whiteShakeDrawable;
                int iB = this.downloadPresenter.b();
                if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                    AppInfo appInfo = this.adInfo.appInfo;
                    if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                        this.portraitInteractionTextView.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.adInfo.appInfo.appSize));
                    } else {
                        this.portraitInteractionTextView.setText(R.string.tapad_banner_download);
                    }
                    this.portraitDownloadFrameLayout.setVisibility(8);
                    this.portraitInteractionTextView.setVisibility(0);
                } else if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                    this.portraitDownloadFrameLayout.setVisibility(0);
                    this.portraitDownloadProgressBar.setProgress(Math.max(iB, 10));
                    this.portraitInteractionTextView.setVisibility(8);
                    z = false;
                } else {
                    this.portraitDownloadFrameLayout.setVisibility(8);
                    this.portraitInteractionTextView.setVisibility(0);
                    textView = this.portraitInteractionTextView;
                    i2 = R.string.tapad_banner_install;
                    textView.setText(i2);
                }
            } else {
                this.portraitInteractionTextView.setText(R.string.tapad_banner_open);
                this.portraitInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner20dp);
                this.portraitInteractionTextView.setTextColor(getResources().getColor(R.color.tapad_color_green));
                this.portraitDownloadFrameLayout.setVisibility(8);
                drawable = this.greenShakeDrawable;
            }
            z = true;
        } else {
            String str = adInfo2.btnName;
            if (str == null || str.length() <= 0) {
                textView = this.portraitInteractionTextView;
                i2 = R.string.tapad_banner_open;
                textView.setText(i2);
            } else {
                this.portraitInteractionTextView.setText(this.adInfo.btnName);
            }
            z = true;
        }
        if (z && this.shakeEnable && (adInfo = this.adInfo) != null && drawable != null && com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)) {
            com.tapsdk.tapad.internal.animation.j jVar = new com.tapsdk.tapad.internal.animation.j(drawable, 0, t.a(getContext(), 4.0f));
            SpannableString spannableString = new SpannableString("$" + this.portraitInteractionTextView.getText().toString());
            spannableString.setSpan(jVar, 0, 1, 33);
            this.portraitInteractionTextView.setText(spannableString);
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
        } else {
            hVar = this.shakeController;
            if (hVar == null) {
                return;
            }
        }
        hVar.a();
    }
}
