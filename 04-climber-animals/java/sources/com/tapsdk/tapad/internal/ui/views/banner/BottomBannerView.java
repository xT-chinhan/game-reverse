package com.tapsdk.tapad.internal.ui.views.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.animation.j;
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
public class BottomBannerView extends RelativeLayout {
    public static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    private HotZoneFrameLayout bottomBannerViewHotZoneFrameLayout;
    private ImageView bottomSquareBannerAdLogoImageView;
    private TextView bottomSquareBannerAdLogoTextView;
    private TextView bottomSquareBannerDescribeTextView;
    private FrameLayout bottomSquareBannerDownloadFrameLayout;
    private ProgressBar bottomSquareBannerDownloadProgressBar;
    private TextView bottomSquareBannerInteractionTextView;
    private TextView bottomSquareBannerPermissionTextView;
    private TextView bottomSquareBannerPrivacyTextView;
    private TextView bottomSquareBannerPrivacyVersionTextView;
    private TextView bottomSquareBannerRealScoreTextView;
    private RelativeLayout bottomSquareBannerRelativeLayout;
    private RelativeLayout bottomSquareBannerScoreRelativeLayout;
    private TextView bottomSquareBannerSupplierTextView;
    DownloadPresenter downloadPresenter;
    private Drawable greenShakeDrawable;
    private boolean isShakeV2Enable;
    com.tapsdk.tapad.internal.r.a rewardAdInnerBannerEventCallback;
    private com.tapsdk.tapad.internal.animation.l.a shakeAcceleratorDetector;
    private com.tapsdk.tapad.internal.animation.h shakeController;
    private com.tapsdk.tapad.internal.animation.i shakeDetector;
    private boolean shakeEnable;
    private com.tapsdk.tapad.internal.animation.l.b shakeRotationDetector;
    private TagView tagView;
    private Drawable whiteShakeDrawable;

    class a implements com.tapsdk.tapad.internal.animation.e {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            BottomBannerView.this.shakeEnable = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            BottomBannerView.this.onInteractionButtonClick(this.a, i);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadPresenter downloadPresenter = BottomBannerView.this.downloadPresenter;
            if (downloadPresenter != null) {
                downloadPresenter.a(new DownloadPresenter.g());
            }
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ Activity a;

        c(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomBannerView.this.onInteractionButtonClick(this.a, 0);
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;

        d(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter) {
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appDescUrl, adInfo);
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPrivacyPolicy, adInfo);
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
            com.tapsdk.tapad.internal.s.a.a(activity, adInfo.appInfo.appPermissionsLink, adInfo);
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ Activity a;

        h(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomBannerView.this.onInteractionButtonClick(this.a, 1);
        }
    }

    class i implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        i(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            BottomBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            BottomBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            BottomBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TapADLogger.d("downloadStart---");
            BottomBannerView.this.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            BottomBannerView.this.updateInteractionLayout();
            BottomBannerView.this.downloadPresenter.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            BottomBannerView.this.updateInteractionLayout();
        }
    }

    public BottomBannerView(Context context) {
        super(context);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public BottomBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public BottomBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    public BottomBannerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.shakeEnable = false;
        this.isShakeV2Enable = false;
        initView();
    }

    private void initDownloadPresenter(Activity activity, AdInfo adInfo) {
        this.downloadPresenter = new DownloadPresenter(activity, new i(adInfo));
    }

    private void initView() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_banner_h400, this);
        this.bottomSquareBannerInteractionTextView = (TextView) viewInflate.findViewById(R.id.bottomSquareBannerInteractionTextView);
        this.bottomSquareBannerDownloadProgressBar = (ProgressBar) viewInflate.findViewById(R.id.bottomSquareBannerDownloadProgressBar);
        this.bottomSquareBannerScoreRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.bottomSquareBannerScoreRelativeLayout);
        this.bottomSquareBannerRealScoreTextView = (TextView) viewInflate.findViewById(R.id.bottomSquareBannerRealScoreTextView);
        this.bottomSquareBannerPrivacyTextView = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.bottomSquareBannerDescribeTextView = (TextView) viewInflate.findViewById(R.id.describeTextView);
        this.bottomSquareBannerPermissionTextView = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.bottomSquareBannerDownloadFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.bottomSquareBannerDownloadFrameLayout);
        this.bottomSquareBannerPrivacyVersionTextView = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.bottomSquareBannerSupplierTextView = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.bottomSquareBannerAdLogoTextView = (TextView) viewInflate.findViewById(R.id.bottomSquareBannerAdLogoTextView);
        this.bottomSquareBannerAdLogoImageView = (ImageView) viewInflate.findViewById(R.id.bottomSquareBannerAdLogoImageView);
        this.bottomSquareBannerRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.bottomSquareBannerRelativeLayout);
        this.tagView = (TagView) viewInflate.findViewById(R.id.tagView);
        this.bottomBannerViewHotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.bottomBannerViewHotZoneFrameLayout);
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
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            try {
                hVar.a();
            } catch (Exception unused) {
            }
        }
        try {
            DownloadPresenter downloadPresenter = this.downloadPresenter;
            if (downloadPresenter != null) {
                downloadPresenter.a(new com.tapsdk.tapad.internal.d());
            }
        } catch (Throwable unused2) {
        }
    }

    public void onInteractionButtonClick(Activity activity, int i2) {
        DownloadPresenter downloadPresenter;
        com.tapsdk.tapad.internal.b jVar;
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
        AdInfo adInfo = this.adInfo;
        if (adInfo.btnInteractionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo, this.downloadPresenter);
            return;
        }
        if (com.tapsdk.tapad.internal.utils.b.a(activity, adInfo.appInfo.packageName)) {
            if (com.tapsdk.tapad.internal.utils.b.b(activity, this.adInfo.appInfo.packageName)) {
                return;
            }
            TapADLogger.d("BottomBannerView 打开异常");
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
                this.shakeController = com.tapsdk.tapad.internal.animation.h.a(activity, new a(activity));
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
        ((TextView) findViewById(R.id.bottomSquareBannerTitleTextView)).setText(adInfo.materialInfo.title);
        ((TextView) findViewById(R.id.bottomSquareBannerDescriptionTextView)).setText(adInfo.materialInfo.description);
        Glide.with(activity).load(adInfo.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.bottomSquareBannerIconImageView));
        updateInteractionLayout();
        this.bottomSquareBannerDownloadFrameLayout.setOnClickListener(new b());
        this.bottomSquareBannerInteractionTextView.setOnClickListener(new c(activity));
        this.bottomSquareBannerRelativeLayout.setOnClickListener(new d(adInfo, activity, downloadPresenter));
        this.bottomSquareBannerScoreRelativeLayout.setVisibility(adInfo.appInfo.tapScore > 0.0f ? 0 : 8);
        if (adInfo.appInfo.tapScore > 0.0f) {
            try {
                this.bottomSquareBannerRealScoreTextView.setText(new DecimalFormat("#.0").format(adInfo.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        this.bottomSquareBannerDescribeTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.bottomSquareBannerDescribeTextView.setOnClickListener(new e(activity, adInfo));
        this.bottomSquareBannerPrivacyTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.bottomSquareBannerPrivacyTextView.setOnClickListener(new f(activity, adInfo));
        this.bottomSquareBannerPermissionTextView.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.bottomSquareBannerPermissionTextView.setOnClickListener(new g(activity, adInfo));
        String str = adInfo.appInfo.appVersion;
        String str2 = "";
        if (str == null || str.length() <= 0) {
            this.bottomSquareBannerPrivacyVersionTextView.setText("");
        } else {
            this.bottomSquareBannerPrivacyVersionTextView.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str3 = adInfo.appInfo.appDeveloper;
        if (str3 == null || str3.length() <= 0) {
            textView = this.bottomSquareBannerSupplierTextView;
        } else {
            textView = this.bottomSquareBannerSupplierTextView;
            str2 = adInfo.appInfo.appDeveloper;
        }
        textView.setText(str2);
        this.bottomSquareBannerAdLogoImageView.setVisibility(adInfo.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getResources().getString(R.string.tapad_str_ads);
        String str4 = adInfo.logoInfo.logoTitle;
        if (str4 != null && str4.length() > 0 && adInfo.logoInfo.logoTitle.length() < 5) {
            string = adInfo.logoInfo.logoTitle;
        }
        ImageInfo imageInfo = adInfo.logoInfo.logoImage;
        if (imageInfo != null && !TextUtils.isEmpty(imageInfo.imageUrl)) {
            Glide.with(this.bottomSquareBannerAdLogoImageView.getContext()).load(adInfo.logoInfo.logoImage.imageUrl).into(this.bottomSquareBannerAdLogoImageView);
        }
        this.bottomSquareBannerAdLogoTextView.setText(string);
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo);
        this.bottomBannerViewHotZoneFrameLayout.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.bottomBannerViewHotZoneFrameLayout.setOnClickListener(new h(activity));
        }
    }

    public void setTagData(List<TagDetail> list, int i2) {
        this.tagView.b(list, i2, 1, 0);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0178  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public void updateInteractionLayout() {
        boolean z;
        com.tapsdk.tapad.internal.animation.h hVar;
        AdInfo adInfo;
        Drawable drawable = this.whiteShakeDrawable;
        AdInfo adInfo2 = this.adInfo;
        if (adInfo2.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(getContext(), this.adInfo.appInfo.packageName)) {
                this.bottomSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
                this.bottomSquareBannerInteractionTextView.setTextColor(getResources().getColor(android.R.color.white));
                Drawable drawable2 = this.whiteShakeDrawable;
                int iB = this.downloadPresenter.b();
                if (downloadStateC != DownloadPresenter.DownloadState.DEFAULT && downloadStateC != DownloadPresenter.DownloadState.ERROR) {
                    if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                        this.bottomSquareBannerDownloadFrameLayout.setVisibility(0);
                        this.bottomSquareBannerDownloadProgressBar.setProgress(Math.max(iB, 10));
                        this.bottomSquareBannerInteractionTextView.setVisibility(8);
                        drawable = drawable2;
                        z = false;
                    } else {
                        this.bottomSquareBannerDownloadFrameLayout.setVisibility(8);
                        this.bottomSquareBannerInteractionTextView.setVisibility(0);
                        this.bottomSquareBannerInteractionTextView.setText(R.string.tapad_banner_install);
                    }
                    if (z || !this.shakeEnable || (adInfo = this.adInfo) == null || drawable == null || !com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)) {
                        hVar = this.shakeController;
                        if (hVar != null) {
                            hVar.a();
                        }
                    }
                    j jVar = new j(drawable, 0, t.a(getContext(), 4.0f));
                    SpannableString spannableString = new SpannableString("$" + this.bottomSquareBannerInteractionTextView.getText().toString());
                    spannableString.setSpan(jVar, 0, 1, 33);
                    this.bottomSquareBannerInteractionTextView.setText(spannableString);
                    com.tapsdk.tapad.internal.animation.h hVar2 = this.shakeController;
                    if (hVar2 != null && !this.isShakeV2Enable) {
                        hVar2.a((com.tapsdk.tapad.internal.animation.a) this.shakeDetector);
                    }
                    com.tapsdk.tapad.internal.animation.h hVar3 = this.shakeController;
                    if (hVar3 == null || !this.isShakeV2Enable) {
                        return;
                    }
                    hVar3.a((com.tapsdk.tapad.internal.animation.a) this.shakeAcceleratorDetector);
                    this.shakeController.a((com.tapsdk.tapad.internal.animation.a) this.shakeRotationDetector);
                    return;
                }
                AppInfo appInfo = this.adInfo.appInfo;
                if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                    this.bottomSquareBannerInteractionTextView.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.adInfo.appInfo.appSize));
                } else {
                    this.bottomSquareBannerInteractionTextView.setText(R.string.tapad_banner_download);
                }
                this.bottomSquareBannerDownloadFrameLayout.setVisibility(8);
                this.bottomSquareBannerInteractionTextView.setVisibility(0);
                drawable = drawable2;
            } else {
                this.bottomSquareBannerInteractionTextView.setText(R.string.tapad_banner_open);
                this.bottomSquareBannerDownloadFrameLayout.setVisibility(8);
                this.bottomSquareBannerInteractionTextView.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.bottomSquareBannerInteractionTextView.setTextColor(getResources().getColor(R.color.tapad_color_green));
                drawable = this.greenShakeDrawable;
            }
        } else {
            String str = adInfo2.btnName;
            if (str == null || str.length() <= 0) {
                this.bottomSquareBannerInteractionTextView.setText(R.string.tapad_banner_open);
            } else {
                this.bottomSquareBannerInteractionTextView.setText(this.adInfo.btnName);
            }
        }
        z = true;
        if (z) {
        }
        hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
    }
}
