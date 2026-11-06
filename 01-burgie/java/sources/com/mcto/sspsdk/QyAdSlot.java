package com.mcto.sspsdk;

import android.support.v4.internal.view.SupportMenu;
import com.mcto.sspsdk.internal.gj;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class QyAdSlot {
    private static volatile int B = 0;
    public static final int QY_AD_TYPE_BANNER = 2;
    public static final int QY_AD_TYPE_SPLASH = 3;
    public static final int QY_COUNTDOWN_STYLE_DEFAULT = 0;
    public static final int QY_COUNTDOWN_STYLE_PROGRESS = 2;
    public static final int QY_COUNTDOWN_STYLE_TIMER = 1;
    public static final int QY_VOLUME_ALWAYS_MUTE = 2;
    public static final int QY_VOLUME_MUTE = 0;
    public static final int QY_VOLUME_SOUND = 1;
    private final int A;
    private final int a;
    private final String b;
    private final String c;
    private String d;
    private final boolean e;
    private final boolean f;
    private boolean g;
    private int h;
    private final int i;
    private int j;
    private String k;
    private String l;
    private long m;
    private final String n;
    private QyBannerStyle o;
    private int p;
    private int q;
    private final boolean r;
    private final QyVideoPlayOption s;
    private final boolean t;
    private int u;
    private int v;
    private final boolean w;
    private final int x;
    private String y;
    private String z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdType {
    }

    @Deprecated
    public static final class Builder {
        private int mAdCount;
        private String mAlbumId;
        private long mChannelId;
        private String mCodeId;
        private boolean mIsAutoDownloadInLandingPage;
        private boolean mIsMute;
        private String mMediaExtra;
        private QyBannerStyle mQyBannerStyle;
        private int mRewardVideoAdOrientation;
        private int mSplashLogo;
        private int mSplashLogoDark;
        private boolean mSupportDeeplink;
        private boolean mSupportNegativeFeedback;
        private boolean mSupportPreRequest;
        private int mTimeout;
        private String mVideoId;

        public Builder adCount(int i) {
            this.mAdCount = i;
            return this;
        }

        public Builder albumId(String str) {
            this.mAlbumId = str;
            return this;
        }

        public Builder bannerStyle(QyBannerStyle qyBannerStyle) {
            this.mQyBannerStyle = qyBannerStyle;
            return this;
        }

        public QyAdSlot build() {
            return new QyAdSlot(this, 0);
        }

        public Builder channelId(long j) {
            this.mChannelId = j;
            return this;
        }

        public Builder codeId(String str) {
            this.mCodeId = str;
            return this;
        }

        public Builder isMute(boolean z) {
            this.mIsMute = z;
            return this;
        }

        public Builder mediaExtra(String str) {
            this.mMediaExtra = str;
            return this;
        }

        public Builder rewardVideoAdOrientation(int i) {
            this.mRewardVideoAdOrientation = i;
            return this;
        }

        public Builder setAutoDownloadInLandingPage(boolean z) {
            this.mIsAutoDownloadInLandingPage = z;
            return this;
        }

        public Builder splashLogo(int i) {
            this.mSplashLogo = i;
            return this;
        }

        public Builder splashLogoDark(int i) {
            this.mSplashLogoDark = i;
            return this;
        }

        public Builder supportDeeplink(boolean z) {
            this.mSupportDeeplink = z;
            return this;
        }

        public Builder supportNegativeFeedback(boolean z) {
            this.mSupportNegativeFeedback = z;
            return this;
        }

        public Builder supportPreRequest(boolean z) {
            this.mSupportPreRequest = z;
            return this;
        }

        public Builder timeout(int i) {
            this.mTimeout = i;
            return this;
        }

        public Builder videoId(String str) {
            this.mVideoId = str;
            return this;
        }

        private Builder() {
            this.mSupportDeeplink = true;
            this.mSupportPreRequest = true;
            this.mSupportNegativeFeedback = true;
            this.mAdCount = 1;
            this.mSplashLogo = 0;
            this.mSplashLogoDark = 0;
            this.mTimeout = 3000;
            this.mChannelId = Long.MIN_VALUE;
            this.mQyBannerStyle = QyBannerStyle.QYBANNER_FULL;
            this.mRewardVideoAdOrientation = 1;
            this.mIsMute = false;
            this.mIsAutoDownloadInLandingPage = true;
        }
    }

    public static final class BuilderAward {
        private String mAdvanceRewardTips;
        private String mAlbumId;
        private long mChannelId;
        private String mCodeId;
        private boolean mIsAutoDownloadInLandingPage;
        private boolean mIsMute;
        private String mMediaExtra;
        private boolean mPreload;
        private int mRewardAmount;
        private String mRewardTips;
        private int mRewardVideoAdOrientation;
        private String mVideoId;

        public BuilderAward ablumId(String str) {
            this.mAlbumId = str;
            return this;
        }

        public BuilderAward advanceRewardTips(String str) {
            this.mAdvanceRewardTips = str;
            return this;
        }

        public QyAdSlot build() {
            return new QyAdSlot(this);
        }

        public BuilderAward channelId(long j) {
            this.mChannelId = j;
            return this;
        }

        public BuilderAward codeId(String str) {
            this.mCodeId = str;
            return this;
        }

        public BuilderAward isMute(boolean z) {
            this.mIsMute = z;
            return this;
        }

        public BuilderAward mediaExtra(String str) {
            this.mMediaExtra = str;
            return this;
        }

        public BuilderAward preload(boolean z) {
            this.mPreload = z;
            return this;
        }

        public BuilderAward rewardAmount(int i) {
            this.mRewardAmount = i;
            return this;
        }

        public BuilderAward rewardTips(String str) {
            this.mRewardTips = str;
            return this;
        }

        public BuilderAward rewardVideoAdOrientation(int i) {
            this.mRewardVideoAdOrientation = i;
            return this;
        }

        public BuilderAward setAutoDownloadInLandingPage(boolean z) {
            this.mIsAutoDownloadInLandingPage = z;
            return this;
        }

        public BuilderAward videoId(String str) {
            this.mVideoId = str;
            return this;
        }

        private BuilderAward() {
            this.mChannelId = Long.MIN_VALUE;
            this.mRewardVideoAdOrientation = 1;
            this.mIsMute = false;
            this.mIsAutoDownloadInLandingPage = true;
            this.mPreload = false;
            this.mRewardAmount = 1;
            this.mRewardTips = "";
            this.mAdvanceRewardTips = "";
        }
    }

    public static final class BuilderBanner {
        private long mChannelId;
        private String mCodeId;
        private boolean mHideMuteButton;
        private boolean mIsAutoDownloadInLandingPage;
        private boolean mIsMute;
        private String mMediaExtra;
        private QyBannerStyle mQyBannerStyle;
        private QyVideoPlayOption mQyVideoPlayOption;
        private boolean mSupportNegativeFeedback;

        public BuilderBanner bannerStyle(QyBannerStyle qyBannerStyle) {
            this.mQyBannerStyle = qyBannerStyle;
            return this;
        }

        public QyAdSlot build() {
            return new QyAdSlot(this);
        }

        public BuilderBanner channelId(long j) {
            this.mChannelId = j;
            return this;
        }

        public BuilderBanner codeId(String str) {
            this.mCodeId = str;
            return this;
        }

        public BuilderBanner hideMuteButton(boolean z) {
            this.mHideMuteButton = z;
            return this;
        }

        public BuilderBanner isMute(boolean z) {
            this.mIsMute = z;
            return this;
        }

        public BuilderBanner mediaExtra(String str) {
            this.mMediaExtra = str;
            return this;
        }

        public BuilderBanner setAutoDownloadInLandingPage(boolean z) {
            this.mIsAutoDownloadInLandingPage = z;
            return this;
        }

        public BuilderBanner setAutoPlayPolicy(QyVideoPlayOption qyVideoPlayOption) {
            this.mQyVideoPlayOption = qyVideoPlayOption;
            return this;
        }

        public BuilderBanner supportNegativeFeedback(boolean z) {
            this.mSupportNegativeFeedback = z;
            return this;
        }

        private BuilderBanner() {
            this.mSupportNegativeFeedback = true;
            this.mChannelId = Long.MIN_VALUE;
            this.mQyBannerStyle = QyBannerStyle.QYBANNER_FULL;
            this.mQyVideoPlayOption = QyVideoPlayOption.ALWAYS;
            this.mIsMute = true;
            this.mIsAutoDownloadInLandingPage = true;
            this.mHideMuteButton = false;
        }
    }

    public static final class BuilderNative {
        private int mAdCount;
        private int mAdType;
        private String mCodeId;
        private boolean mIsAutoDownloadInLandingPage;
        private String mMediaExtra;
        private QyVideoPlayOption mQyVideoPlayOption;
        private boolean mSupportPreRequest;
        private int mVideoAdOrientation;
        private int mVolumeType;

        public BuilderNative adCount(int i) {
            if (i >= 1) {
                this.mAdCount = i;
            }
            return this;
        }

        public BuilderNative adType(int i) {
            this.mAdType = i;
            return this;
        }

        public BuilderNative autoDownloadInLandingPage(boolean z) {
            this.mIsAutoDownloadInLandingPage = z;
            return this;
        }

        public QyAdSlot build() {
            return new QyAdSlot(this);
        }

        public BuilderNative codeId(String str) {
            this.mCodeId = str;
            return this;
        }

        public BuilderNative mediaExtra(String str) {
            this.mMediaExtra = str;
            return this;
        }

        public BuilderNative setSupportPreRequest(boolean z) {
            this.mSupportPreRequest = z;
            return this;
        }

        public BuilderNative videoAdOrientation(int i) {
            this.mVideoAdOrientation = i;
            return this;
        }

        public BuilderNative videoPlayOption(QyVideoPlayOption qyVideoPlayOption) {
            this.mQyVideoPlayOption = qyVideoPlayOption;
            return this;
        }

        public BuilderNative volumeType(int i) {
            this.mVolumeType = i;
            return this;
        }

        private BuilderNative() {
            this.mAdType = 0;
            this.mVideoAdOrientation = 2;
            this.mVolumeType = 0;
            this.mIsAutoDownloadInLandingPage = true;
            this.mSupportPreRequest = true;
            this.mAdCount = 1;
            this.mQyVideoPlayOption = QyVideoPlayOption.ALWAYS;
        }
    }

    public static final class BuilderSplash {
        private String mCodeId;
        private int mCountdownStyle;
        private boolean mIsAutoDownloadInLandingPage;
        private String mMediaExtra;
        private int mSplashLogo;
        private int mSplashLogoDark;
        private boolean mSupportPreRequest;
        private int mTimeout;

        public QyAdSlot build() {
            return new QyAdSlot(this);
        }

        public BuilderSplash codeId(String str) {
            this.mCodeId = str;
            return this;
        }

        public BuilderSplash mediaExtra(String str) {
            this.mMediaExtra = str;
            return this;
        }

        public BuilderSplash setAutoDownloadInLandingPage(boolean z) {
            this.mIsAutoDownloadInLandingPage = z;
            return this;
        }

        public BuilderSplash setCountdownStyle(int i) {
            this.mCountdownStyle = i;
            return this;
        }

        public BuilderSplash splashLogo(int i) {
            this.mSplashLogo = i;
            return this;
        }

        public BuilderSplash splashLogoDark(int i) {
            this.mSplashLogoDark = i;
            return this;
        }

        public BuilderSplash supportPreRequest(boolean z) {
            this.mSupportPreRequest = z;
            return this;
        }

        public BuilderSplash timeout(int i) {
            this.mTimeout = i;
            return this;
        }

        private BuilderSplash() {
            this.mSupportPreRequest = true;
            this.mSplashLogo = 0;
            this.mSplashLogoDark = 0;
            this.mTimeout = 3000;
            this.mIsAutoDownloadInLandingPage = true;
            this.mCountdownStyle = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QyCountdownStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QyVolumeType {
    }

    /* synthetic */ QyAdSlot(Builder builder, int i) {
        this(builder);
    }

    @Deprecated
    public static Builder newQyAdSlot() {
        return new Builder();
    }

    public static BuilderAward newQyAwardAdSlot() {
        return new BuilderAward();
    }

    public static BuilderBanner newQyBannerAdSlot() {
        return new BuilderBanner();
    }

    public static BuilderNative newQyNativeAdSlot() {
        return new BuilderNative();
    }

    public static BuilderSplash newQySplashAdSlot() {
        return new BuilderSplash();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(String str) {
        this.k = str;
    }

    public final String c() {
        return this.z;
    }

    public final int d() {
        return this.A;
    }

    public final int e() {
        return this.v;
    }

    public final int f() {
        return this.u;
    }

    public final String g() {
        return this.d;
    }

    public int getAdCount() {
        return this.h;
    }

    public int getAdType() {
        return this.a;
    }

    public String getAlbumId() {
        return this.n;
    }

    public long getChannelId() {
        return this.m;
    }

    public String getCodeId() {
        return this.b;
    }

    public boolean getHideMuteButton() {
        return this.t;
    }

    public String getMediaExtra() {
        return this.c;
    }

    public QyBannerStyle getQyBannerStyle() {
        return this.o;
    }

    public QyVideoPlayOption getQyVideoPlayOption() {
        return this.s;
    }

    public int getRewardAmount() {
        return this.x;
    }

    public String getRewardTips() {
        return this.y;
    }

    public int getSplashLogo() {
        return this.i;
    }

    public int getTimeOut() {
        return this.j;
    }

    public int getVideoAdOrientation() {
        int i = this.p;
        if (i < 1 || i > 2) {
            return 1;
        }
        return i;
    }

    public String getVideoId() {
        return this.l;
    }

    public int getVolumeType() {
        return this.q;
    }

    public final String h() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        int i = B + 1;
        B = i;
        B = i % SupportMenu.USER_MASK;
        String strA = gj.a("" + B);
        this.k = strA;
        return strA;
    }

    public final boolean i() {
        return this.w;
    }

    public boolean isAutoDownloadInLandingPage() {
        return this.r;
    }

    public boolean isMute() {
        return this.q != 1;
    }

    public boolean isSupportDeepLink() {
        return this.e;
    }

    public boolean isSupportNegativeFeedback() {
        return this.g;
    }

    public boolean isSupportPreRequest() {
        return this.f;
    }

    public void setAdCount(int i) {
        this.h = i;
    }

    public void setAdvanceRewardTips(String str) {
        this.z = str;
    }

    public void setChannelId(long j) {
        this.m = j;
    }

    public void setQyBannerStyle(QyBannerStyle qyBannerStyle) {
        this.o = qyBannerStyle;
    }

    public void setRewardOrientation(int i) {
        this.p = i;
    }

    public void setRewardTips(String str) {
        this.y = str;
    }

    public void setSupportNegativeFeedback(boolean z) {
        this.g = z;
    }

    public void setTimeOut(int i) {
        this.j = i;
    }

    public void setVideoId(String str) {
        this.l = str;
    }

    public void setVolumeType(int i) {
        this.q = i;
    }

    @Deprecated
    private QyAdSlot(Builder builder) {
        this.a = 0;
        this.f = true;
        this.h = 1;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = "";
        this.z = "";
        this.A = 0;
        this.b = builder.mCodeId;
        this.c = builder.mMediaExtra;
        this.h = builder.mAdCount;
        this.i = builder.mSplashLogo;
        this.f = builder.mSupportPreRequest;
        this.e = builder.mSupportDeeplink;
        this.g = builder.mSupportNegativeFeedback;
        this.m = builder.mChannelId;
        this.l = builder.mVideoId;
        this.j = builder.mTimeout;
        this.o = builder.mQyBannerStyle;
        this.p = builder.mRewardVideoAdOrientation;
        this.q = !builder.mIsMute ? 1 : 0;
        this.r = builder.mIsAutoDownloadInLandingPage;
        this.n = builder.mAlbumId;
    }

    public final void a() {
        this.v++;
    }

    public final void b() {
        this.u++;
    }

    public final void a(int i) {
        this.v += i;
    }

    public QyAdSlot(BuilderBanner builderBanner) {
        this.a = 0;
        this.f = true;
        this.h = 1;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = "";
        this.z = "";
        this.A = 0;
        this.b = builderBanner.mCodeId;
        this.c = builderBanner.mMediaExtra;
        this.g = builderBanner.mSupportNegativeFeedback;
        this.m = builderBanner.mChannelId;
        this.o = builderBanner.mQyBannerStyle;
        this.s = builderBanner.mQyVideoPlayOption;
        this.q = !builderBanner.mIsMute ? 1 : 0;
        this.r = builderBanner.mIsAutoDownloadInLandingPage;
        this.t = builderBanner.mHideMuteButton;
    }

    public QyAdSlot(BuilderSplash builderSplash) {
        this.a = 0;
        this.f = true;
        this.h = 1;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = "";
        this.z = "";
        this.A = 0;
        this.b = builderSplash.mCodeId;
        this.c = builderSplash.mMediaExtra;
        this.i = builderSplash.mSplashLogo;
        this.f = builderSplash.mSupportPreRequest;
        this.j = builderSplash.mTimeout;
        this.r = builderSplash.mIsAutoDownloadInLandingPage;
        this.A = builderSplash.mCountdownStyle;
    }

    public QyAdSlot(BuilderAward builderAward) {
        this.a = 0;
        this.f = true;
        this.h = 1;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = "";
        this.z = "";
        this.A = 0;
        this.b = builderAward.mCodeId;
        this.c = builderAward.mMediaExtra;
        this.m = builderAward.mChannelId;
        this.p = builderAward.mRewardVideoAdOrientation;
        this.q = !builderAward.mIsMute ? 1 : 0;
        this.r = builderAward.mIsAutoDownloadInLandingPage;
        this.l = builderAward.mVideoId;
        this.n = builderAward.mAlbumId;
        this.w = builderAward.mPreload;
        this.x = builderAward.mRewardAmount;
        this.z = builderAward.mAdvanceRewardTips;
        this.y = builderAward.mRewardTips;
    }

    public QyAdSlot(BuilderNative builderNative) {
        this.a = 0;
        this.f = true;
        this.h = 1;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = "";
        this.z = "";
        this.A = 0;
        this.a = builderNative.mAdType;
        this.b = builderNative.mCodeId;
        this.c = builderNative.mMediaExtra;
        this.p = builderNative.mVideoAdOrientation;
        this.q = builderNative.mVolumeType;
        this.r = builderNative.mIsAutoDownloadInLandingPage;
        this.h = builderNative.mAdCount;
        this.s = builderNative.mQyVideoPlayOption;
        this.f = builderNative.mSupportPreRequest;
    }
}
