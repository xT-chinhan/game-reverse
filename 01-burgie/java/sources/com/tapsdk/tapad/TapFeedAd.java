package com.tapsdk.tapad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.VideoOption;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface TapFeedAd {

    public interface AdClickPassiveListener {
        void adCreativePassiveClick();

        void adPassiveShow();
    }

    public interface AdInteractionListener {
        void onAdClicked(View view, TapFeedAd tapFeedAd);

        void onAdCreativeClick(View view, TapFeedAd tapFeedAd);

        void onAdShow(TapFeedAd tapFeedAd);

        void onAdValidView(TapFeedAd tapFeedAd);

        void onDistinctAdShow(TapFeedAd tapFeedAd);

        default void onDownloadWindowConfirm(TapFeedAd tapFeedAd) {
        }
    }

    public interface ExpressRenderListener {
        void onAdClicked(View view);

        void onAdClosed(View view);

        void onAdShow(View view);

        void onAdValidShow(View view);

        void onRenderFail(View view, TapFeedAd tapFeedAd, int i, String str);

        void onRenderSuccess(View view);
    }

    public interface VideoAdListener {
        void onVideoError(TapFeedAd tapFeedAd, int i, String str);

        void onVideoPause(TapFeedAd tapFeedAd);

        void onVideoPrepared(TapFeedAd tapFeedAd);

        void onVideoStart(TapFeedAd tapFeedAd);

        void onVideoVolumeClose(TapFeedAd tapFeedAd);

        void onVideoVolumeOpen(TapFeedAd tapFeedAd);
    }

    void cancelDownload();

    void closeDownloadFloatingDialog();

    void closeVideoVolume();

    void confirmDownload();

    void dispose();

    AdClickPassiveListener getAdClickPassiveListener();

    View getAdView();

    @Deprecated
    String getApkSize();

    long getApkSizeBytes();

    ComplianceInfo getComplianceInfo();

    String getDescription();

    String getIconUrl();

    List<ImageInfo> getImageInfoList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    long getPrice();

    float getScore();

    String getTitle();

    boolean isValid();

    void openVideoVolume();

    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, AdInteractionListener adInteractionListener);

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, AdInteractionListener adInteractionListener);

    void render(Activity activity, FeedOption feedOption);

    void render(FeedOption feedOption);

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setDownloadListener(TapAppDownloadListener tapAppDownloadListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    void setIsSelfDoubleWindow(boolean z);

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlaySelfController(boolean z);

    void setVolumeVisible(boolean z);

    void startVideoPlay();

    void stopVideoPlay();
}
