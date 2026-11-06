package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MediationCandidateEffects {
    private final MediationScreenshotEffect screenshotEffect = new MediationScreenshotEffect();

    private Map<String, Object> getStatusDownloadLogMap(DirichletAd dirichletAd, long j, long j2, long j3, String str, String str2, int i, String str3) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, i, str3, null, null);
        statusLogMap.put(Constants.APK_SIZE_FIELD, Long.valueOf(j));
        statusLogMap.put(Constants.DOWNLOAD_APP_NAME_FIELD, str);
        statusLogMap.put(Constants.DOWNLOAD_TOTAL_BYTES_FIELD, Long.valueOf(j2));
        statusLogMap.put(Constants.DOWNLOAD_TOTAL_CURR_BYTES_FIELD, Long.valueOf(j3));
        statusLogMap.put(Constants.DOWNLOAD_FILE_NAME_FIELD, str2);
        return statusLogMap;
    }

    private Map<String, Object> getStatusLogMap(DirichletAd dirichletAd, int i, String str, Activity activity, View view) {
        return statusFacts(dirichletAd, i, str, activity, view);
    }

    static /* synthetic */ void lambda$runIfProviderBillingClaimed$4(DirichletAd dirichletAd, boolean z, boolean z2, Runnable runnable) {
        if (MediationRuntimeCoreBridge.claimProviderBilling(dirichletAd.getTrackId(), z, z2)) {
            AsyncExecutor.runOnMain(runnable);
        }
    }

    private static void runIfProviderBillingClaimed(final DirichletAd dirichletAd, final boolean z, final boolean z2, final Runnable runnable) {
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        Runnable runnable2 = new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationCandidateEffects$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediationCandidateEffects.lambda$runIfProviderBillingClaimed$4(dirichletAd, z, z2, runnable);
            }
        };
        if (dirichletRuntime.isOnRuntimeQueue()) {
            runnable2.run();
        } else {
            dirichletRuntime.runOnRuntimeQueue(runnable2);
        }
    }

    public static boolean shouldReportDestroy(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public static Map<String, Object> statusFacts(DirichletAd dirichletAd, int i, String str, Activity activity, View view) {
        HashMap map = new HashMap();
        map.put(Constants.AD_TRACK_ID_FIELD, dirichletAd.getTrackId());
        if (i != 0) {
            map.put(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str) || i != 0) {
            map.put(Constants.ERROR_MSG_FIELD, str);
            if (!TextUtils.isEmpty(str)) {
                map.put(Constants.ERROR_MSG_HASH_FIELD, Integer.valueOf(str.hashCode()));
            }
        }
        if (activity != null && activity.getComponentName() != null) {
            map.put(Constants.ACTIVITY_NAME_FIELD, activity.getComponentName().getClassName());
        }
        if (view != null) {
            map.put("width", Integer.valueOf(view.getMeasuredWidth()));
            map.put("height", Integer.valueOf(view.getMeasuredHeight()));
        }
        if (dirichletAd instanceof MediationNativeSplashSession) {
            ((MediationNativeSplashSession) dirichletAd).addTelemetryFacts(map, view);
        }
        return map;
    }

    public void codebitGetView(DirichletAd dirichletAd, View view) {
        reportCandidateFact(7, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void codebitShow(DirichletAd dirichletAd, Activity activity) {
        reportCandidateFact(13, getStatusLogMap(dirichletAd, 0, "", activity, null));
    }

    public void innerLoss(final DirichletAd dirichletAd, final String str, final AdNetworkType adNetworkType) {
        reportCandidateFact(9, getStatusLogMap(dirichletAd, 0, "", null, null));
        runIfProviderBillingClaimed(dirichletAd, true, false, new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationCandidateEffects$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m46lambda$innerLoss$1$comtapsdktapadgroupadsMediationCandidateEffects(dirichletAd, str, adNetworkType);
            }
        });
    }

    public void innerWin(final DirichletAd dirichletAd, final AdNetworkType adNetworkType) {
        reportCandidateFact(14, getStatusLogMap(dirichletAd, 0, "", null, null));
        runIfProviderBillingClaimed(dirichletAd, true, true, new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationCandidateEffects$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m47lambda$innerWin$0$comtapsdktapadgroupadsMediationCandidateEffects(dirichletAd, adNetworkType);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$innerLoss$1$com-tapsdk-tapad-group-ads-MediationCandidateEffects, reason: not valid java name */
    /* synthetic */ void m46lambda$innerLoss$1$comtapsdktapadgroupadsMediationCandidateEffects(DirichletAd dirichletAd, String str, AdNetworkType adNetworkType) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.IS_WIN_FIELD, Boolean.FALSE);
        statusLogMap.put(Constants.LOSS_REASON_FIELD, str);
        statusLogMap.put(Constants.WIN_BIDDER_FIELD, adNetworkType != null ? adNetworkType.getName() : "");
        reportCandidateFact(24, statusLogMap);
        dirichletAd.innerLoss(dirichletAd.schedulerFirstPrice(), "", adNetworkType != null ? adNetworkType.getName() : "");
    }

    /* JADX INFO: renamed from: lambda$innerWin$0$com-tapsdk-tapad-group-ads-MediationCandidateEffects, reason: not valid java name */
    /* synthetic */ void m47lambda$innerWin$0$comtapsdktapadgroupadsMediationCandidateEffects(DirichletAd dirichletAd, AdNetworkType adNetworkType) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.IS_WIN_FIELD, Boolean.TRUE);
        reportCandidateFact(24, statusLogMap);
        dirichletAd.innerWin(dirichletAd.schedulerSecondPrice(), dirichletAd.schedulerOriginalPrice(), adNetworkType == null ? "" : adNetworkType.getName());
    }

    /* JADX INFO: renamed from: lambda$mediaLoss$3$com-tapsdk-tapad-group-ads-MediationCandidateEffects, reason: not valid java name */
    /* synthetic */ void m48lambda$mediaLoss$3$comtapsdktapadgroupadsMediationCandidateEffects(DirichletAd dirichletAd, long j, String str, String str2) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.IS_WIN_FIELD, Boolean.FALSE);
        statusLogMap.put(Constants.FIRST_PRICE_FIELD, Long.valueOf(j));
        statusLogMap.put(Constants.WIN_BIDDER_FIELD, str);
        statusLogMap.put(Constants.LOSS_REASON_FIELD, str2);
        reportCandidateFact(24, statusLogMap);
        dirichletAd.innerLoss(j, str2, str);
    }

    /* JADX INFO: renamed from: lambda$mediaWin$2$com-tapsdk-tapad-group-ads-MediationCandidateEffects, reason: not valid java name */
    /* synthetic */ void m49lambda$mediaWin$2$comtapsdktapadgroupadsMediationCandidateEffects(DirichletAd dirichletAd, long j) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.IS_WIN_FIELD, Boolean.TRUE);
        statusLogMap.put(Constants.SECOND_PRICE_FIELD, Long.valueOf(j));
        reportCandidateFact(24, statusLogMap);
        dirichletAd.innerWin(j, dirichletAd.schedulerOriginalPrice(), "");
    }

    public void mediaLoss(final DirichletAd dirichletAd, final long j, final String str, final String str2) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(com.tapsdk.tapad.constants.Constants.Bidding.WIN_PRICE, Long.valueOf(j));
        statusLogMap.put(Constants.LOSS_REASON_FIELD, str == null ? "" : str);
        statusLogMap.put(Constants.WIN_BIDDER_FIELD, str2 != null ? str2 : "");
        reportCandidateFact(32, statusLogMap);
        runIfProviderBillingClaimed(dirichletAd, false, false, new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationCandidateEffects$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m48lambda$mediaLoss$3$comtapsdktapadgroupadsMediationCandidateEffects(dirichletAd, j, str2, str);
            }
        });
    }

    public void mediaWin(final DirichletAd dirichletAd, final long j) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.SECOND_PRICE_FIELD, Long.valueOf(j));
        reportCandidateFact(33, statusLogMap);
        runIfProviderBillingClaimed(dirichletAd, false, true, new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationCandidateEffects$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m49lambda$mediaWin$2$comtapsdktapadgroupadsMediationCandidateEffects(dirichletAd, j);
            }
        });
    }

    public void onAdTimeOver(DirichletAd dirichletAd) {
        reportCandidateFact(40, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onClick(DirichletAd dirichletAd, View view) {
        reportCandidateFact(39, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void onClose(DirichletAd dirichletAd) {
        this.screenshotEffect.cancel();
        reportCandidateFact(40, getStatusLogMap(dirichletAd, 0, "", null, null));
        dirichletAd.destroy();
    }

    public void onCreativeClick(DirichletAd dirichletAd, View view) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, view);
        statusLogMap.put(Constants.IS_CREATIVE_FIELD, Boolean.TRUE);
        reportCandidateFact(39, statusLogMap);
    }

    public void onDestroy(DirichletAd dirichletAd) {
        this.screenshotEffect.cancel();
        if (shouldReportDestroy(dirichletAd == null ? "" : dirichletAd.getTrackId())) {
            reportCandidateFact(15, getStatusLogMap(dirichletAd, 0, "", null, null));
        }
    }

    public void onDownloadCancel(DirichletAd dirichletAd) {
        reportCandidateFact(29, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onDownloadComplete(DirichletAd dirichletAd, long j, long j2, String str, String str2) {
        reportCandidateFact(42, getStatusDownloadLogMap(dirichletAd, j, j2, 0L, str, str2, 0, ""));
    }

    public void onDownloadConfirm(DirichletAd dirichletAd) {
        reportCandidateFact(30, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onDownloadError(DirichletAd dirichletAd, long j, long j2, long j3, String str, String str2, int i, String str3) {
        reportCandidateFact(41, getStatusDownloadLogMap(dirichletAd, j, j2, j3, str, str2, i, str3));
    }

    public void onDownloadPause(DirichletAd dirichletAd, long j, long j2, long j3, String str, String str2) {
        reportCandidateFact(43, getStatusDownloadLogMap(dirichletAd, j, j2, j3, str, str2, 0, ""));
    }

    public void onDownloadStart(DirichletAd dirichletAd, long j, String str, String str2) {
        reportCandidateFact(44, getStatusDownloadLogMap(dirichletAd, j, 0L, 0L, str, str2, 0, ""));
    }

    public void onDownloadWindowConfirm(DirichletAd dirichletAd) {
        reportCandidateFact(31, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onInstalled(DirichletAd dirichletAd, long j, String str, String str2) {
        reportCandidateFact(45, getStatusDownloadLogMap(dirichletAd, j, 0L, 0L, str, str2, 0, ""));
    }

    public void onInvalidShow(DirichletAd dirichletAd, View view, String str, Object obj) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, view);
        if (str == null) {
            str = "";
        }
        statusLogMap.put(Constants.INVALID_REASON_FIELD, str);
        if (obj != null) {
            statusLogMap.put(Constants.VALUE_FIELD, obj);
        }
        reportCandidateFact(76, statusLogMap);
    }

    public void onItemClick(DirichletAd dirichletAd, View view) {
        reportCandidateFact(46, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void onItemElseClick(DirichletAd dirichletAd, View view) {
        reportCandidateFact(47, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void onItemShow(DirichletAd dirichletAd, View view) {
        reportCandidateFact(48, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void onRenderFail(DirichletAd dirichletAd, View view, int i, String str) {
        reportCandidateFact(49, getStatusLogMap(dirichletAd, i, str, null, view));
    }

    public void onRenderSuccess(DirichletAd dirichletAd, View view) {
        reportCandidateFact(50, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void onRewardVerify(DirichletAd dirichletAd, boolean z, int i, String str, int i2, String str2, String str3) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, i2, str2, null, null);
        statusLogMap.put("reward_amount", Integer.valueOf(i));
        statusLogMap.put("reward_name", str);
        statusLogMap.put("reward_verify", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(str3)) {
            statusLogMap.put("reward_source", str3);
        }
        reportCandidateFact(28, statusLogMap);
    }

    public void onShow(DirichletAd dirichletAd, View view) {
        reportCandidateFact(51, getStatusLogMap(dirichletAd, 0, "", null, view));
        this.screenshotEffect.request(dirichletAd, view);
    }

    public void onSkip(DirichletAd dirichletAd) {
        reportCandidateFact(53, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onVideoComplete(DirichletAd dirichletAd, long j) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", null, null);
        statusLogMap.put(Constants.VIDEO_DURATION_FIELD, Long.valueOf(j));
        reportCandidateFact(54, statusLogMap);
    }

    public void onVideoError(DirichletAd dirichletAd, int i, String str) {
        reportCandidateFact(55, getStatusLogMap(dirichletAd, i, str, null, null));
    }

    public void onVideoPause(DirichletAd dirichletAd) {
        reportCandidateFact(56, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onVideoPrepared(DirichletAd dirichletAd) {
        reportCandidateFact(57, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onVideoResume(DirichletAd dirichletAd) {
        reportCandidateFact(58, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void onVideoStart(DirichletAd dirichletAd) {
        reportCandidateFact(59, getStatusLogMap(dirichletAd, 0, "", null, null));
    }

    public void reportCandidateFact(int i, Map<String, Object> map) {
        MediationControlBridge.submitCandidateFact(i, map);
    }

    public void selfNativeClick(DirichletAd dirichletAd, Activity activity, View view, int i) {
        Map<String, Object> statusLogMap = getStatusLogMap(dirichletAd, 0, "", activity, view);
        if (dirichletAd instanceof MediationNativeSplashSession) {
            ((MediationNativeSplashSession) dirichletAd).addCoreTriggerFact(statusLogMap, i);
        }
        reportCandidateFact(61, statusLogMap);
    }

    public void spaceGetView(DirichletAd dirichletAd, View view) {
        reportCandidateFact(22, getStatusLogMap(dirichletAd, 0, "", null, view));
    }

    public void spaceShow(DirichletAd dirichletAd, Activity activity) {
        reportCandidateFact(23, getStatusLogMap(dirichletAd, 0, "", activity, null));
    }
}
