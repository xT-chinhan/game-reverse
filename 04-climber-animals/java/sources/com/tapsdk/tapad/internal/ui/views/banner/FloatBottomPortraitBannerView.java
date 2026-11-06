package com.tapsdk.tapad.internal.ui.views.banner;

import android.app.Activity;
import android.content.Context;
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
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import java.text.DecimalFormat;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FloatBottomPortraitBannerView extends RelativeLayout {
    public static final int q = 10;
    private DownloadPresenter a;
    private TextView b;
    private ProgressBar c;
    private FrameLayout d;
    private RelativeLayout e;
    private TextView f;
    private AdInfo g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private RelativeLayout m;
    private TextView n;
    private TextView o;
    private ImageView p;

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
            if (com.tapsdk.tapad.internal.utils.b.a(this.b, FloatBottomPortraitBannerView.this.g.appInfo.packageName)) {
                if (com.tapsdk.tapad.internal.utils.b.b(this.b, FloatBottomPortraitBannerView.this.g.appInfo.packageName)) {
                    return;
                }
                TapADLogger.d("BottomBannerView 打开异常");
                return;
            }
            DownloadPresenter.DownloadState downloadStateC = FloatBottomPortraitBannerView.this.a.c();
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                FloatBottomPortraitBannerView.this.b();
                downloadPresenter = FloatBottomPortraitBannerView.this.a;
                jVar = new DownloadPresenter.j(FloatBottomPortraitBannerView.this.g);
            } else {
                if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                    return;
                }
                if (com.tapsdk.tapad.internal.a.a(FloatBottomPortraitBannerView.this.getContext(), this.a).exists()) {
                    downloadPresenter = this.c;
                    jVar = new DownloadPresenter.k(FloatBottomPortraitBannerView.this.g);
                } else {
                    downloadPresenter = this.c;
                    jVar = new DownloadPresenter.i(FloatBottomPortraitBannerView.this.g);
                }
            }
            downloadPresenter.a(jVar);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatBottomPortraitBannerView.this.a.a(new DownloadPresenter.g());
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ DownloadPresenter c;

        c(AdInfo adInfo, Activity activity, DownloadPresenter downloadPresenter) {
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

    public FloatBottomPortraitBannerView(Context context) {
        super(context);
        a();
    }

    public FloatBottomPortraitBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FloatBottomPortraitBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public FloatBottomPortraitBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_feed_float_h400, this);
        this.b = (TextView) viewInflate.findViewById(R.id.bottomSquareFloatInteractionTextView);
        this.c = (ProgressBar) viewInflate.findViewById(R.id.bottomSquareFloatDownloadProgressBar);
        this.e = (RelativeLayout) viewInflate.findViewById(R.id.bottomSquareFloatScoreRelativeLayout);
        this.f = (TextView) viewInflate.findViewById(R.id.bottomSquareFloatRealScoreTextView);
        this.h = (TextView) findViewById(R.id.describeTextView);
        this.i = (TextView) viewInflate.findViewById(R.id.privacyTextView);
        this.j = (TextView) viewInflate.findViewById(R.id.permissionTextView);
        this.d = (FrameLayout) viewInflate.findViewById(R.id.bottomSquareFloatDownloadFrameLayout);
        this.k = (TextView) viewInflate.findViewById(R.id.privacyVersionTextView);
        this.l = (TextView) viewInflate.findViewById(R.id.supplierTextView);
        this.m = (RelativeLayout) viewInflate.findViewById(R.id.bottomSquareFloatRelativeLayout);
        this.n = (TextView) viewInflate.findViewById(R.id.bottomSquareFloatTitleTextView);
        this.o = (TextView) findViewById(R.id.bottomSquareFloatDescriptionTextView);
        this.p = (ImageView) findViewById(R.id.bottomSquareFloatIconImageView);
    }

    private void a(DownloadPresenter downloadPresenter) {
        this.a = downloadPresenter;
    }

    public void a(Activity activity, AdInfo adInfo, DownloadPresenter downloadPresenter) {
        a(downloadPresenter);
        this.g = adInfo;
        this.n.setText(adInfo.materialInfo.title);
        this.o.setText(adInfo.materialInfo.description);
        Glide.with(activity).load(adInfo.appInfo.appIconImage.imageUrl).into(this.p);
        b();
        this.b.setOnClickListener(new a(adInfo, activity, downloadPresenter));
        this.d.setOnClickListener(new b());
        this.m.setOnClickListener(new c(adInfo, activity, downloadPresenter));
        this.e.setVisibility(adInfo.appInfo.tapScore > 0.0f ? 0 : 8);
        if (adInfo.appInfo.tapScore > 0.0f) {
            try {
                this.f.setText(new DecimalFormat("#.0").format(adInfo.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        this.h.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appDescUrl) ? 8 : 0);
        this.h.setOnClickListener(new d(activity, adInfo));
        this.i.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPrivacyPolicy) ? 8 : 0);
        this.i.setOnClickListener(new e(activity, adInfo));
        this.j.setVisibility(TextUtils.isEmpty(adInfo.appInfo.appPermissionsLink) ? 8 : 0);
        this.j.setOnClickListener(new f(activity, adInfo));
        String str = adInfo.appInfo.appVersion;
        if (str == null || str.length() <= 0) {
            this.k.setText("");
        } else {
            this.k.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), adInfo.appInfo.appVersion));
        }
        String str2 = adInfo.appInfo.appDeveloper;
        if (str2 == null || str2.length() <= 0) {
            this.l.setText("");
        } else {
            this.l.setText(adInfo.appInfo.appDeveloper);
        }
    }

    public void b() {
        TextView textView;
        int i;
        AdInfo adInfo = this.g;
        if (adInfo.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.a.c();
            if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), this.g.appInfo.packageName)) {
                this.b.setText(R.string.tapad_banner_open);
                this.d.setVisibility(8);
                this.b.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.b.setTextColor(getResources().getColor(R.color.tapad_color_green));
                return;
            }
            this.b.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
            this.b.setTextColor(getResources().getColor(android.R.color.white));
            int iB = this.a.b();
            if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
                AppInfo appInfo = this.g.appInfo;
                if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                    this.b.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.g.appInfo.appSize));
                } else {
                    this.b.setText(R.string.tapad_banner_download);
                }
                this.d.setVisibility(8);
                this.b.setVisibility(0);
                return;
            }
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                this.d.setVisibility(0);
                this.c.setProgress(Math.max(iB, 10));
                this.b.setVisibility(8);
                return;
            } else {
                this.d.setVisibility(8);
                this.b.setVisibility(0);
                textView = this.b;
                i = R.string.tapad_banner_install;
            }
        } else {
            String str = adInfo.btnName;
            if (str != null && str.length() > 0) {
                this.b.setText(this.g.btnName);
                return;
            } else {
                textView = this.b;
                i = R.string.tapad_banner_open;
            }
        }
        textView.setText(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("banner onDetachedFromWindow");
        super.onDetachedFromWindow();
    }
}
