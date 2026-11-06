package com.tapsdk.tapad.internal.ui.views.banner;

import android.app.Activity;
import android.content.Context;
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
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import java.text.DecimalFormat;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FloatBottomLandscapeBannerView extends RelativeLayout {
    public static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    private DownloadPresenter downloadPresenter;
    private LinearLayout rightBannerMasterLinearLayout;
    private RelativeLayout rightSquareBannerAdsRelativeLayout;
    private TextView rightSquareBannerDescribeTextView;
    private FrameLayout rightSquareBannerDownloadFrameLayout;
    private ProgressBar rightSquareBannerDownloadProgressBar;
    private FrameLayout rightSquareBannerInteractionFrameLayout;
    private TextView rightSquareBannerInteractionTextView;
    private TextView rightSquareBannerPermissionTextView;
    private TextView rightSquareBannerPrivacyTextView;
    private TextView rightSquareBannerPrivacyVersionTextView;
    private TextView rightSquareBannerRealScoreTextView;
    private RelativeLayout rightSquareBannerScoreRelativeLayout;
    private TextView rightSquareBannerSupplierTextView;

    class a implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;

        a(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter) {
            this.a = adInfo;
            this.b = activity;
            this.c = downloadPresenter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter;
            com.tapsdk.tapad.internal.b jVar;
            TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
            if (tapADTrackerObject != null) {
                tapADTrackerObject.a(0, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(s.a(this.a.clickMonitorUrls, 0), (Map<String, String>) null, this.a.getClickMonitorHeaderListWrapper());
            }
            AdInfo adInfo = this.a;
            if (adInfo.btnInteractionInfo.interactionType != 1) {
                com.tapsdk.tapad.internal.s.a.a(this.b, false, adInfo, this.c);
                return;
            }
            if (com.tapsdk.tapad.internal.utils.b.a(this.b, FloatBottomLandscapeBannerView.this.adInfo.appInfo.packageName)) {
                if (com.tapsdk.tapad.internal.utils.b.b(this.b, FloatBottomLandscapeBannerView.this.adInfo.appInfo.packageName)) {
                    return;
                }
                TapADLogger.d("RightBannerView 打开异常");
                return;
            }
            DownloadPresenter.DownloadState downloadStateC = FloatBottomLandscapeBannerView.this.downloadPresenter.c();
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                FloatBottomLandscapeBannerView.this.updateInteractionLayout();
                downloadPresenter = FloatBottomLandscapeBannerView.this.downloadPresenter;
                jVar = new DownloadPresenter.j(FloatBottomLandscapeBannerView.this.adInfo);
            } else {
                if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                    return;
                }
                if (com.tapsdk.tapad.internal.a.a(FloatBottomLandscapeBannerView.this.getContext(), this.a).exists()) {
                    downloadPresenter = this.c;
                    jVar = new DownloadPresenter.k(FloatBottomLandscapeBannerView.this.adInfo);
                } else {
                    downloadPresenter = this.c;
                    jVar = new DownloadPresenter.i(FloatBottomLandscapeBannerView.this.adInfo);
                }
            }
            downloadPresenter.a(jVar);
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;

        b(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter) {
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

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatBottomLandscapeBannerView.this.downloadPresenter.a(new DownloadPresenter.g());
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        d(Activity activity, AdInfo adInfo) {
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

    class e implements View.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        e(Activity activity, AdInfo adInfo) {
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPermissionsLink, adInfo);
        }
    }

    class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (FloatBottomLandscapeBannerView.this.rightBannerMasterLinearLayout.getHeight() > 0) {
                FloatBottomLandscapeBannerView.this.rightBannerMasterLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (FloatBottomLandscapeBannerView.this.rightBannerMasterLinearLayout.getHeight() < FloatBottomLandscapeBannerView.this.rightSquareBannerInteractionFrameLayout.getTop() + FloatBottomLandscapeBannerView.this.rightSquareBannerInteractionFrameLayout.getHeight()) {
                    FloatBottomLandscapeBannerView.this.rightSquareBannerScoreRelativeLayout.setVisibility(8);
                }
            }
        }
    }

    public FloatBottomLandscapeBannerView(Context context) {
        super(context);
        initView();
    }

    public FloatBottomLandscapeBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FloatBottomLandscapeBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public FloatBottomLandscapeBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView();
    }

    private void initView() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_feed_float_landscape, this);
        this.rightSquareBannerInteractionTextView = (TextView) viewInflate.findViewById(R.id.rightSquareBannerInteractionTextView);
        this.rightSquareBannerDownloadProgressBar = (ProgressBar) viewInflate.findViewById(R.id.rightSquareBannerDownloadProgressBar);
        this.rightSquareBannerScoreRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rightSquareBannerScoreRelativeLayout);
        this.rightSquareBannerRealScoreTextView = (TextView) viewInflate.findViewById(R.id.rightSquareBannerRealScoreTextView);
        this.rightSquareBannerDescribeTextView = (TextView) findViewById(R.id.describeTextView);
        this.rightSquareBannerPrivacyTextView = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.rightSquareBannerPermissionTextView = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.rightSquareBannerDownloadFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.rightSquareBannerDownloadFrameLayout);
        this.rightBannerMasterLinearLayout = (LinearLayout) viewInflate.findViewById(R.id.rightBannerMasterLinearLayout);
        this.rightSquareBannerInteractionFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.rightSquareBannerInteractionFrameLayout);
        this.rightSquareBannerPrivacyVersionTextView = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.rightSquareBannerSupplierTextView = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.rightSquareBannerAdsRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rightSquareBannerAdsRelativeLayout);
    }

    private void providePresenter(DownloadPresenter downloadPresenter) {
        this.downloadPresenter = downloadPresenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public void render(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter) {
        providePresenter(downloadPresenter);
        this.adInfo = adInfo;
        ((TextView) findViewById(R.id.rightSquareBannerTitleTextView)).setText(adInfo.materialInfo.title);
        ((TextView) findViewById(R.id.rightSquareBannerDescriptionTextView)).setText(adInfo.materialInfo.description);
        Glide.with(activity).load(adInfo.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.rightSquareBannerIconImageView));
        updateInteractionLayout();
        this.rightSquareBannerInteractionTextView.setOnClickListener(new a(adInfo, activity, downloadPresenter));
        this.rightSquareBannerAdsRelativeLayout.setOnClickListener(new b(adInfo, activity, downloadPresenter));
        this.rightSquareBannerScoreRelativeLayout.setVisibility(adInfo.appInfo.tapScore > 0.0f ? 0 : 8);
        if (adInfo.appInfo.tapScore > 0.0f) {
            try {
                this.rightSquareBannerRealScoreTextView.setText(new DecimalFormat("#.0").format(adInfo.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        this.rightSquareBannerInteractionFrameLayout.setOnClickListener(new c());
        this.rightSquareBannerDescribeTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.rightSquareBannerDescribeTextView.setOnClickListener(new d(activity, adInfo));
        this.rightSquareBannerPrivacyTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.rightSquareBannerPrivacyTextView.setOnClickListener(new e(activity, adInfo));
        this.rightSquareBannerPermissionTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.rightSquareBannerPermissionTextView.setOnClickListener(new f(activity, adInfo));
        this.rightBannerMasterLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new g());
        String str = adInfo.appInfo.appVersion;
        if (str == null || str.length() <= 0) {
            this.rightSquareBannerPrivacyVersionTextView.setText("");
        } else {
            this.rightSquareBannerPrivacyVersionTextView.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str2 = adInfo.appInfo.appDeveloper;
        if (str2 == null || str2.length() <= 0) {
            this.rightSquareBannerSupplierTextView.setText("");
        } else {
            this.rightSquareBannerSupplierTextView.setText(adInfo.appInfo.appDeveloper);
        }
    }

    public void updateInteractionLayout() {
        TextView textView;
        int i;
        AdInfo adInfo = this.adInfo;
        if (adInfo.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
            if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), this.adInfo.appInfo.packageName)) {
                this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_open);
                this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                this.rightSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.rightSquareBannerInteractionTextView.setTextColor(getResources().getColor(R.color.tapad_color_green));
                return;
            }
            this.rightSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
            this.rightSquareBannerInteractionTextView.setTextColor(getResources().getColor(android.R.color.white));
            int iB = this.downloadPresenter.b();
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                AppInfo appInfo = this.adInfo.appInfo;
                if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                    this.rightSquareBannerInteractionTextView.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.adInfo.appInfo.appSize));
                } else {
                    this.rightSquareBannerInteractionTextView.setText(R.string.tapad_banner_download);
                }
                this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                this.rightSquareBannerInteractionTextView.setVisibility(0);
                return;
            }
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                this.rightSquareBannerDownloadFrameLayout.setVisibility(0);
                this.rightSquareBannerDownloadProgressBar.setProgress(Math.max(iB, 10));
                this.rightSquareBannerInteractionTextView.setVisibility(8);
                return;
            } else {
                this.rightSquareBannerDownloadFrameLayout.setVisibility(8);
                this.rightSquareBannerInteractionTextView.setVisibility(0);
                textView = this.rightSquareBannerInteractionTextView;
                i = R.string.tapad_banner_install;
            }
        } else {
            String str = adInfo.btnName;
            if (str != null && str.length() > 0) {
                this.rightSquareBannerInteractionTextView.setText(this.adInfo.btnName);
                return;
            } else {
                textView = this.rightSquareBannerInteractionTextView;
                i = R.string.tapad_banner_open;
            }
        }
        textView.setText(i);
    }
}
