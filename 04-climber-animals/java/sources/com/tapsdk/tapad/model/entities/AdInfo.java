package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.anythink.core.common.k;
import com.tapsdk.tapad.internal.tracker.ClickTrackerObject;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdInfo implements Parcelable {
    public static final Parcelable.Creator<AdInfo> CREATOR = new a();
    public final AppInfo appInfo;
    public final long bidPrice;
    public final int bidType;
    public final InteractionInfo btnInteractionInfo;
    public final String btnName;
    public String bubbleContent;
    public int bubbleWaitTime;
    public String cachedVideoUri;
    public List<String> clickMonitorUrls;
    public final CloseButtonInfo closeButtonInfo;
    public final ComprehensiveHeaders comprehensiveHeaders;
    public boolean disposed;
    public List<String> downloadFinishUrls;
    public List<String> downloadStartMonitorUrls;
    public List<String> dpFailedMonitorUrlsList;
    public List<String> dpSuccessMonitorUrlsList;
    public int enableSdkDebug;
    public final long expireTime;
    public String extra;
    public final List<TagDetail> highlightTags;
    public final int incentiveTime;
    public List<String> innerBrowserMonitorUrls;
    public final List<String> innerH5OpenFailedMonitorUrls;
    public List<String> installStartMonitorUrls;
    public List<String> installedMonitorUrls;
    public final int interstitialAdKeepTime;
    public boolean isAutoWaitTransferEnable;
    public boolean isCloseTransferEnable;
    public boolean isFirstPassiveTransfer;
    public final LogoInfo logoInfo;
    public final MaterialInfo materialInfo;
    public final Map<String, Object> mediaExtraInfoMap;
    public long mediaId;
    public final int offset;
    public List<String> openDeeplinkMonitorUrls;
    public List<String> reminderActivationMonitorUrls;
    public final RenderStyles renderStyles;
    public int sampleRatioComplianceOpen;
    public int sampleRatioDownload;
    public int sampleRatioFillAd;
    public int sampleRatioInstall;
    public int sampleRatioNetworkState;
    public final Long spaceId;
    public final TapADTrackerObject tapADTrackerObject;
    public TrackBackData trackBackData;
    public final String trackId;
    public List<String> videoViewMonitorUrls;
    public final InteractionInfo viewInteractionInfo;
    public List<String> viewMonitorUrls;
    public List<String> winNoticeUrls;

    static class a implements Parcelable.Creator<AdInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInfo createFromParcel(Parcel parcel) {
            return new AdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInfo[] newArray(int i) {
            return new AdInfo[i];
        }
    }

    protected AdInfo(Parcel parcel) {
        this.winNoticeUrls = new ArrayList();
        this.viewMonitorUrls = new ArrayList();
        this.clickMonitorUrls = new ArrayList();
        this.downloadStartMonitorUrls = new ArrayList();
        this.downloadFinishUrls = new ArrayList();
        this.videoViewMonitorUrls = new ArrayList();
        this.installStartMonitorUrls = new ArrayList();
        this.installedMonitorUrls = new ArrayList();
        this.openDeeplinkMonitorUrls = new ArrayList();
        this.dpSuccessMonitorUrlsList = new ArrayList();
        this.dpFailedMonitorUrlsList = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.highlightTags = arrayList;
        this.disposed = false;
        HashMap map = new HashMap();
        this.mediaExtraInfoMap = map;
        this.isFirstPassiveTransfer = true;
        this.isCloseTransferEnable = false;
        this.isAutoWaitTransferEnable = false;
        this.bubbleWaitTime = 0;
        this.bubbleContent = "";
        this.enableSdkDebug = 0;
        this.sampleRatioDownload = 0;
        this.sampleRatioFillAd = 0;
        this.sampleRatioInstall = 0;
        this.sampleRatioComplianceOpen = 0;
        this.sampleRatioNetworkState = 0;
        this.innerBrowserMonitorUrls = new ArrayList();
        this.reminderActivationMonitorUrls = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.innerH5OpenFailedMonitorUrls = arrayList2;
        this.trackId = parcel.readString();
        long j = parcel.readLong();
        this.bidPrice = j;
        int i = parcel.readInt();
        this.bidType = i;
        this.winNoticeUrls = parcel.createStringArrayList();
        this.viewMonitorUrls = parcel.createStringArrayList();
        this.clickMonitorUrls = parcel.createStringArrayList();
        this.downloadStartMonitorUrls = parcel.createStringArrayList();
        this.downloadFinishUrls = parcel.createStringArrayList();
        this.videoViewMonitorUrls = parcel.createStringArrayList();
        this.installStartMonitorUrls = parcel.createStringArrayList();
        this.installedMonitorUrls = parcel.createStringArrayList();
        this.openDeeplinkMonitorUrls = parcel.createStringArrayList();
        this.appInfo = (AppInfo) parcel.readParcelable(AppInfo.class.getClassLoader());
        this.renderStyles = (RenderStyles) parcel.readParcelable(RenderStyles.class.getClassLoader());
        this.btnInteractionInfo = (InteractionInfo) parcel.readParcelable(InteractionInfo.class.getClassLoader());
        this.viewInteractionInfo = (InteractionInfo) parcel.readParcelable(InteractionInfo.class.getClassLoader());
        this.btnName = parcel.readString();
        this.materialInfo = (MaterialInfo) parcel.readParcelable(MaterialInfo.class.getClassLoader());
        this.spaceId = Long.valueOf(parcel.readLong());
        this.offset = parcel.readInt();
        this.expireTime = parcel.readLong();
        this.incentiveTime = parcel.readInt();
        this.interstitialAdKeepTime = parcel.readInt();
        this.logoInfo = (LogoInfo) parcel.readParcelable(LogoInfo.class.getClassLoader());
        this.closeButtonInfo = (CloseButtonInfo) parcel.readParcelable(CloseButtonInfo.class.getClassLoader());
        this.cachedVideoUri = parcel.readString();
        this.disposed = parcel.readByte() != 0;
        parcel.readTypedList(arrayList, TagDetail.CREATOR);
        if (j >= 0) {
            map.put("bid_price", Long.valueOf(j));
            map.put(k.J, Integer.valueOf(i));
        }
        this.trackBackData = (TrackBackData) parcel.readParcelable(TrackBackData.class.getClassLoader());
        this.isFirstPassiveTransfer = parcel.readByte() != 0;
        this.isCloseTransferEnable = parcel.readByte() != 0;
        this.isAutoWaitTransferEnable = parcel.readByte() != 0;
        this.bubbleWaitTime = parcel.readInt();
        this.bubbleContent = parcel.readString();
        this.mediaId = parcel.readLong();
        this.extra = parcel.readString();
        this.comprehensiveHeaders = (ComprehensiveHeaders) parcel.readParcelable(ComprehensiveHeaders.class.getClassLoader());
        this.innerBrowserMonitorUrls = parcel.createStringArrayList();
        this.dpSuccessMonitorUrlsList = parcel.createStringArrayList();
        this.dpFailedMonitorUrlsList = parcel.createStringArrayList();
        this.reminderActivationMonitorUrls = parcel.createStringArrayList();
        this.tapADTrackerObject = (TapADTrackerObject) parcel.readParcelable(ExposureTrackerObject.class.getClassLoader());
        this.enableSdkDebug = parcel.readInt();
        parcel.readStringList(arrayList2);
        this.sampleRatioDownload = parcel.readInt();
        this.sampleRatioFillAd = parcel.readInt();
        this.sampleRatioInstall = parcel.readInt();
        this.sampleRatioComplianceOpen = parcel.readInt();
        this.sampleRatioNetworkState = parcel.readInt();
    }

    public AdInfo(TapAdResp.b bVar, TrackBackData trackBackData) {
        this.winNoticeUrls = new ArrayList();
        this.viewMonitorUrls = new ArrayList();
        this.clickMonitorUrls = new ArrayList();
        this.downloadStartMonitorUrls = new ArrayList();
        this.downloadFinishUrls = new ArrayList();
        this.videoViewMonitorUrls = new ArrayList();
        this.installStartMonitorUrls = new ArrayList();
        this.installedMonitorUrls = new ArrayList();
        this.openDeeplinkMonitorUrls = new ArrayList();
        this.dpSuccessMonitorUrlsList = new ArrayList();
        this.dpFailedMonitorUrlsList = new ArrayList();
        this.highlightTags = new ArrayList();
        this.disposed = false;
        this.mediaExtraInfoMap = new HashMap();
        this.isFirstPassiveTransfer = true;
        this.isCloseTransferEnable = false;
        this.isAutoWaitTransferEnable = false;
        this.bubbleWaitTime = 0;
        this.bubbleContent = "";
        this.enableSdkDebug = 0;
        this.sampleRatioDownload = 0;
        this.sampleRatioFillAd = 0;
        this.sampleRatioInstall = 0;
        this.sampleRatioComplianceOpen = 0;
        this.sampleRatioNetworkState = 0;
        this.innerBrowserMonitorUrls = new ArrayList();
        this.reminderActivationMonitorUrls = new ArrayList();
        this.innerH5OpenFailedMonitorUrls = new ArrayList();
        this.trackId = bVar.s2();
        long jLongValue = ((Long) com.tapsdk.tapad.internal.j.a.b().a("bid_price", Long.class, -1L)).longValue();
        if (jLongValue != -1) {
            this.bidPrice = jLongValue;
        } else {
            this.bidPrice = bVar.m1();
        }
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(k.J, Integer.class, -1)).intValue();
        if (jLongValue != -1) {
            this.bidType = iIntValue;
        } else {
            this.bidType = bVar.z2().ordinal();
        }
        int iIntValue2 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("banner_close_button_style", Integer.class, -1)).intValue();
        if (iIntValue2 != -1) {
            this.closeButtonInfo = new CloseButtonInfo(iIntValue2);
        } else if (bVar.X()) {
            this.closeButtonInfo = new CloseButtonInfo(bVar.W2());
        } else {
            this.closeButtonInfo = null;
        }
        this.materialInfo = new MaterialInfo(bVar.g0());
        if (bVar.U0()) {
            this.appInfo = new AppInfo(bVar.d5());
        } else {
            this.appInfo = null;
        }
        this.winNoticeUrls.addAll(bVar.E2());
        this.viewMonitorUrls.addAll(bVar.a3());
        this.clickMonitorUrls.addAll(bVar.r2());
        this.downloadStartMonitorUrls.addAll(bVar.d2());
        this.downloadFinishUrls.addAll(bVar.v3());
        this.videoViewMonitorUrls.addAll(bVar.a1());
        this.installStartMonitorUrls.addAll(bVar.k1());
        this.installedMonitorUrls.addAll(bVar.U2());
        if (bVar.E() > 0) {
            this.openDeeplinkMonitorUrls.addAll(bVar.R2());
        }
        this.renderStyles = bVar.G2() ? new RenderStyles(bVar.D()) : new RenderStyles();
        if (bVar.C()) {
            this.btnInteractionInfo = new InteractionInfo(bVar.R3());
        } else {
            this.btnInteractionInfo = null;
        }
        if (bVar.v1()) {
            this.viewInteractionInfo = new InteractionInfo(bVar.p());
        } else {
            this.viewInteractionInfo = null;
        }
        this.btnName = bVar.s4();
        this.spaceId = Long.valueOf(bVar.f());
        int iIntValue3 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("feed_size", Integer.class, -1)).intValue();
        this.offset = iIntValue3 == -1 ? bVar.x() : iIntValue3;
        this.expireTime = bVar.C0();
        this.incentiveTime = bVar.G();
        this.interstitialAdKeepTime = bVar.H3();
        this.logoInfo = new LogoInfo(bVar.F4());
        if (bVar.x5() > 0) {
            Iterator<TapAdResp.b0> it = bVar.y5().iterator();
            while (it.hasNext()) {
                this.highlightTags.add(new TagDetail(it.next()));
            }
        } else {
            ((Integer) com.tapsdk.tapad.internal.j.a.b().a("isTagSet", Integer.class, -1)).intValue();
        }
        long j = this.bidPrice;
        if (j >= 0) {
            this.mediaExtraInfoMap.put("bid_price", Long.valueOf(j));
            this.mediaExtraInfoMap.put(k.J, Integer.valueOf(this.bidType));
        }
        this.trackBackData = trackBackData;
        InteractionInfo interactionInfo = this.btnInteractionInfo;
        if (interactionInfo != null) {
            this.isAutoWaitTransferEnable = interactionInfo.extractWaitInteractionEnable();
            this.isCloseTransferEnable = this.btnInteractionInfo.extractCloseTransferEnable();
            this.bubbleWaitTime = this.btnInteractionInfo.extractWaitInteractionTime();
            this.bubbleContent = this.btnInteractionInfo.extractWaitInteractionContent();
        }
        this.extra = bVar.a();
        if (bVar.E4() != null) {
            this.comprehensiveHeaders = new ComprehensiveHeaders(bVar.E4());
        } else {
            this.comprehensiveHeaders = null;
        }
        if (bVar.L2() != null) {
            this.innerBrowserMonitorUrls.addAll(bVar.L2());
        }
        if (bVar.z5() > 0) {
            this.dpSuccessMonitorUrlsList.addAll(bVar.Z());
        }
        if (bVar.P1() > 0) {
            this.dpFailedMonitorUrlsList.addAll(bVar.T3());
        }
        this.reminderActivationMonitorUrls = bVar.S4();
        this.tapADTrackerObject = new TapADTrackerObject(new ExposureTrackerObject(bVar.n0(), this.viewMonitorUrls, bVar.B2(), bVar.i4(), bVar.a4(), bVar.J4(), bVar.Z0(), getViewMonitorHeaderListWrapper(), isInvalidExposureFlagOpen(), getExposureIntervalMilli()), new ClickTrackerObject(this.clickMonitorUrls, getClickMonitorHeaderListWrapper()));
        this.enableSdkDebug = bVar.v0();
        this.innerH5OpenFailedMonitorUrls.addAll(bVar.A5());
        if (bVar.B4() != null) {
            this.sampleRatioDownload = bVar.B4().M1();
            this.sampleRatioFillAd = bVar.B4().Q0();
            this.sampleRatioInstall = bVar.B4().b2();
            this.sampleRatioComplianceOpen = bVar.B4().h4();
            this.sampleRatioNetworkState = bVar.B4().g5();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBannerStyle() {
        byte b = -1;
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_banner_ui_style", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_banner_ui_style", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = new JSONObject(this.extra);
            if (jSONObject.has("banner_ui_style")) {
                String string = jSONObject.getString("banner_ui_style");
                int iHashCode = string.hashCode();
                if (iHashCode != -1906743252) {
                    if (iHashCode == 1018217269 && string.equals("banner_train")) {
                        b = 0;
                    }
                } else if (string.equals("banner_wave")) {
                    b = 1;
                }
                if (b != 0) {
                    return b != 1 ? 0 : 2;
                }
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public String getBannerTrainRotateGif() {
        String string;
        try {
            JSONObject jSONObject = new JSONObject(this.extra);
            string = jSONObject.has("banner_train_rotate_gif_url") ? jSONObject.getString("banner_train_rotate_gif_url") : "";
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(string) ? string : "https://tapad-platform.tapimg.com/adn_resources/adn-sdk-resources/ui-styles/tapad_banner_train_rotate.gif";
    }

    public String getBannerWaveGif() {
        String string;
        try {
            JSONObject jSONObject = new JSONObject(this.extra);
            string = jSONObject.has("banner_wave_gif_url") ? jSONObject.getString("banner_wave_gif_url") : "";
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string)) {
            return this.renderStyles.d == 1 ? "https://tapad-platform.tapimg.com/adn_resources/adn-sdk-resources/ui-styles/tapad_banner_waves_landscape_gif.gif" : "https://tapad-platform.tapimg.com/adn_resources/adn-sdk-resources/ui-styles/tapad_banner_waves_gif.gif";
        }
        return string;
    }

    public List<DynamicHeader> getClickMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.c;
    }

    public int getDefaultOpenWebMode() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_dl_element_not_webview", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_dl_element_not_webview", Integer.class, -1)).intValue();
        }
        try {
            return new JSONObject(this.extra).getInt("dl_element_not_webview");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public List<DynamicHeader> getDownloadFinishMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.f;
    }

    public List<DynamicHeader> getDownloadStartMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.e;
    }

    public long getExposureIntervalMilli() {
        long j;
        try {
            j = new JSONObject(this.extra).getLong("valid_exposure_interval_millis");
        } catch (Exception unused) {
            j = 10;
        }
        if (j < 50) {
            return 200L;
        }
        return j;
    }

    public String getExpressFeedAdStyle() {
        if (!"".equals(com.tapsdk.tapad.internal.j.a.b().a("exp_feed_express_ui_style", String.class, ""))) {
            return (String) com.tapsdk.tapad.internal.j.a.b().a("exp_feed_express_ui_style", String.class, "feed_text_image_default");
        }
        try {
            JSONObject jSONObject = new JSONObject(this.extra);
            if (jSONObject.has("feed_ui_style")) {
                switch (jSONObject.getInt("feed_ui_style")) {
                    case 2:
                        return "feed_text_image_score";
                    case 3:
                        return "feed_text_image_download_1";
                    case 4:
                        return "feed_text_image_download_2";
                    case 5:
                        return "feed_image_text_default";
                    case 6:
                        return "feed_image_text_score";
                    case 7:
                        return "feed_image_text_download";
                    case 8:
                        return "feed_text_float_only";
                    case 9:
                        return "feed_text_float_default";
                    case 10:
                        return "feed_text_float_score";
                    case 11:
                        return "feed_mini_image_text_default";
                    case 12:
                        return "feed_mini_image_text_score";
                    case 13:
                        return "feed_mini_text_image_default";
                    case 14:
                        return "feed_mini_text_image_score";
                }
            }
        } catch (Exception unused) {
        }
        return "feed_text_image_default";
    }

    public int getInnerWebViewIsSelf() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_inner_browser_is_self_download", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_inner_browser_is_self_download", Integer.class, -1)).intValue();
        }
        try {
            return new JSONObject(this.extra).getInt("web_view_is_self_html");
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getInnerWebViewScreenOrientation() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_inner_browser_screen_orientation", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_inner_browser_screen_orientation", Integer.class, -1)).intValue();
        }
        try {
            return new JSONObject(this.extra).getInt("web_view_screen_orientation");
        } catch (Exception unused) {
            return 1;
        }
    }

    public List<DynamicHeader> getInstallStartMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.g;
    }

    public List<DynamicHeader> getInstalledMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.h;
    }

    public List<DynamicHeader> getLandingHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.a;
    }

    public List<DynamicHeader> getOpenDeepLinkMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.d;
    }

    public int getShowApkOpenDialog() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_show_apk_open_dialog", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_show_apk_open_dialog", Integer.class, -1)).intValue();
        }
        try {
            return new JSONObject(this.extra).getInt("show_apk_open_dialog");
        } catch (Exception unused) {
            return 0;
        }
    }

    public List<DynamicHeader> getVideoViewMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.i;
    }

    public List<DynamicHeader> getViewMonitorHeaderListWrapper() {
        ComprehensiveHeaders comprehensiveHeaders = this.comprehensiveHeaders;
        if (comprehensiveHeaders == null) {
            return null;
        }
        return comprehensiveHeaders.b;
    }

    public Boolean isEnableSdkLog() {
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_enable_sdk_debug", Integer.class, -1)).intValue();
        if (iIntValue != -1) {
            return Boolean.valueOf(iIntValue == 1);
        }
        return Boolean.valueOf(this.enableSdkDebug == 1);
    }

    public boolean isInvalidExposureFlagOpen() {
        try {
            return new JSONObject(this.extra).getInt("is_invalid_exposure_flag_open") == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean splashCanShakeInBack() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_splash_can_shake_in_back", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_splash_can_shake_in_back", Integer.class, -1)).intValue() == 1;
        }
        try {
            return new JSONObject(this.extra).getInt("splash_can_shake_in_back") == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean videoAndImageCanTransfer() {
        try {
            return new JSONObject(this.extra).getInt("reward_video_can_click") == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.trackId);
        parcel.writeLong(this.bidPrice);
        parcel.writeInt(this.bidType);
        parcel.writeStringList(this.winNoticeUrls);
        parcel.writeStringList(this.viewMonitorUrls);
        parcel.writeStringList(this.clickMonitorUrls);
        parcel.writeStringList(this.downloadStartMonitorUrls);
        parcel.writeStringList(this.downloadFinishUrls);
        parcel.writeStringList(this.videoViewMonitorUrls);
        parcel.writeStringList(this.installStartMonitorUrls);
        parcel.writeStringList(this.installedMonitorUrls);
        parcel.writeStringList(this.openDeeplinkMonitorUrls);
        parcel.writeParcelable(this.appInfo, i);
        parcel.writeParcelable(this.renderStyles, i);
        parcel.writeParcelable(this.btnInteractionInfo, i);
        parcel.writeParcelable(this.viewInteractionInfo, i);
        parcel.writeString(this.btnName);
        parcel.writeParcelable(this.materialInfo, i);
        parcel.writeLong(this.spaceId.longValue());
        parcel.writeInt(this.offset);
        parcel.writeLong(this.expireTime);
        parcel.writeInt(this.incentiveTime);
        parcel.writeInt(this.interstitialAdKeepTime);
        parcel.writeParcelable(this.logoInfo, i);
        parcel.writeParcelable(this.closeButtonInfo, i);
        parcel.writeString(this.cachedVideoUri);
        parcel.writeByte(this.disposed ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.highlightTags);
        parcel.writeParcelable(this.trackBackData, i);
        parcel.writeByte(this.isFirstPassiveTransfer ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCloseTransferEnable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAutoWaitTransferEnable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.bubbleWaitTime);
        parcel.writeString(this.bubbleContent);
        parcel.writeLong(this.mediaId);
        parcel.writeString(this.extra);
        parcel.writeParcelable(this.comprehensiveHeaders, i);
        parcel.writeStringList(this.innerBrowserMonitorUrls);
        parcel.writeStringList(this.dpSuccessMonitorUrlsList);
        parcel.writeStringList(this.dpFailedMonitorUrlsList);
        parcel.writeStringList(this.reminderActivationMonitorUrls);
        parcel.writeParcelable(this.tapADTrackerObject, i);
        parcel.writeInt(this.enableSdkDebug);
        parcel.writeStringList(this.innerH5OpenFailedMonitorUrls);
        parcel.writeInt(this.sampleRatioDownload);
        parcel.writeInt(this.sampleRatioFillAd);
        parcel.writeInt(this.sampleRatioInstall);
        parcel.writeInt(this.sampleRatioComplianceOpen);
        parcel.writeInt(this.sampleRatioNetworkState);
    }
}
