package com.byazt.bm;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 37})
public class pr {
    public static SparseArray<Object> pr(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        hnVarPr.pr(261001, adConfig.getAppId());
        hnVarPr.pr(261002, adConfig.getAppName());
        hnVarPr.pr(261003, adConfig.isPaid());
        hnVarPr.pr(261004, adConfig.getKeywords());
        hnVarPr.pr(261005, adConfig.getData());
        hnVarPr.pr(261006, adConfig.getTitleBarTheme());
        hnVarPr.pr(261007, adConfig.isAllowShowNotify());
        hnVarPr.pr(261008, adConfig.isDebug());
        hnVarPr.pr(261009, adConfig.getDirectDownloadNetworkType());
        hnVarPr.pr(261011, adConfig.isSupportMultiProcess());
        hnVarPr.pr(261012, x.pr(adConfig.getCustomController()));
        hnVarPr.pr(261013, new Supplier<Integer>() { // from class: com.byazt.bm.pr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        hnVarPr.pr(261014, new Supplier<Integer>() { // from class: com.byazt.bm.pr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        hnVarPr.pr(261015, new Supplier<Integer>() { // from class: com.byazt.bm.pr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        hnVarPr.pr(261016, adConfig.getMediationConfig() != null ? com.byazt.xs.pr.pr(adConfig.getMediationConfig()) : null);
        hnVarPr.pr(261017, adConfig.isUseMediation());
        hnVarPr.pr(261018, new Supplier<Map<String, Object>>() { // from class: com.byazt.bm.pr.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return adConfig.getInitExtra();
            }
        });
        return hnVarPr.hw().sparseArray();
    }
}
