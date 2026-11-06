package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tapsdk.tapad.group.ads.entities.ComplianceInfo;
import com.tapsdk.tapad.group.ads.entities.ImageInfo;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletNativeFeedAd {
    private final MediationNativeFeedSession ad;

    public interface AdInteractionListener {
        void onAdClick(View view, DirichletNativeFeedAd dirichletNativeFeedAd);

        void onAdShow(DirichletNativeFeedAd dirichletNativeFeedAd);

        default void onDownloadWindowConfirm(DirichletNativeFeedAd dirichletNativeFeedAd) {
        }
    }

    public interface VideoAdListener {
        void onVideoError(DirichletNativeFeedAd dirichletNativeFeedAd, int i, String str);

        void onVideoPause(DirichletNativeFeedAd dirichletNativeFeedAd);

        void onVideoPrepared(DirichletNativeFeedAd dirichletNativeFeedAd);

        void onVideoStart(DirichletNativeFeedAd dirichletNativeFeedAd);
    }

    public DirichletNativeFeedAd(MediationNativeFeedSession mediationNativeFeedSession) {
        this.ad = mediationNativeFeedSession;
        mediationNativeFeedSession.setOuterAd(this);
    }

    private static boolean areAllViewsInContainer(DirichletAdNativeContainer dirichletAdNativeContainer, List<View> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                if (!isViewInContainer(dirichletAdNativeContainer, it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isViewInContainer(DirichletAdNativeContainer dirichletAdNativeContainer, View view) {
        if (view == null) {
            return false;
        }
        if (view == dirichletAdNativeContainer) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == dirichletAdNativeContainer) {
                return true;
            }
        }
        return false;
    }

    public void cancelDownload() {
        MediationNativeFeedSession mediationNativeFeedSession = this.ad;
        if (mediationNativeFeedSession != null) {
            mediationNativeFeedSession.cancelDownload();
        }
    }

    public void confirmDownload() {
        MediationNativeFeedSession mediationNativeFeedSession = this.ad;
        if (mediationNativeFeedSession != null) {
            mediationNativeFeedSession.confirmDownload();
        }
    }

    public void destroy() {
        this.ad.destroy();
    }

    public long getAdApkSizeBytes() {
        return this.ad.getApkSizeBytes();
    }

    public View getAdView() {
        return this.ad.getAdView();
    }

    @Deprecated
    public String getApkSize() {
        return this.ad.getApkSize();
    }

    public ComplianceInfo getComplianceInfo() {
        return this.ad.getComplianceInfo();
    }

    public String getDescription() {
        return this.ad.getDescription();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public String getIconUrl() {
        return this.ad.getIconUrl();
    }

    public List<ImageInfo> getImageInfoList() {
        return this.ad.getImageInfoList();
    }

    public int getImageMode() {
        return this.ad.getImageMode();
    }

    public int getInteractionType() {
        return this.ad.getInteractionType();
    }

    public float getScore() {
        return this.ad.getScore();
    }

    public String getTitle() {
        return this.ad.getTitle();
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void pauseDownload() {
        MediationNativeFeedSession mediationNativeFeedSession = this.ad;
        if (mediationNativeFeedSession != null) {
            mediationNativeFeedSession.pauseDownload();
        }
    }

    public synchronized void registerViewForInteraction(Activity activity, DirichletAdNativeContainer dirichletAdNativeContainer, List<View> list, List<View> list2, AdInteractionListener adInteractionListener) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                boolean z = true;
                boolean z2 = (list == null || list.isEmpty()) ? false : true;
                if (list2 == null || list2.isEmpty()) {
                    z = false;
                }
                if (!z2 && !z) {
                    throw new RuntimeException("clickViews 或 creativeViews 至少传入一个");
                }
                if (!areAllViewsInContainer(dirichletAdNativeContainer, list)) {
                    throw new RuntimeException("clickViews 中存在不在 container 中的 View");
                }
                if (!areAllViewsInContainer(dirichletAdNativeContainer, list2)) {
                    throw new RuntimeException("creativeViews 中存在不在 container 中的 View");
                }
                MediationNativeFeedSession mediationNativeFeedSession = this.ad;
                if (MediationShowAdmissionBridge.claimInline(mediationNativeFeedSession, 5, dirichletAdNativeContainer, mediationNativeFeedSession.isValid())) {
                    this.ad.registerViewForInteraction(activity, dirichletAdNativeContainer, list, list2, adInteractionListener);
                }
            }
        }
    }

    public void resumeDownload() {
        MediationNativeFeedSession mediationNativeFeedSession = this.ad;
        if (mediationNativeFeedSession != null) {
            mediationNativeFeedSession.resumeDownload();
        }
    }

    public void setDownloadListener(DirichletAppDownloadListener dirichletAppDownloadListener) {
        this.ad.setDownloadListener(dirichletAppDownloadListener);
    }

    public void setIsSelfDoubleWindow(boolean z) {
        this.ad.setIsSelfDoubleWindow(z);
    }

    public void setLogoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.ad.setLogoLayoutParams(layoutParams);
    }

    public void setVideoAdListener(VideoAdListener videoAdListener) {
        this.ad.setVideoAdListener(videoAdListener);
    }

    public void win(long j) {
        this.ad.win(j);
    }
}
