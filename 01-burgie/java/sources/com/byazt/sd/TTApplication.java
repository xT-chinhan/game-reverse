package com.byazt.sd;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 1064})
public class TTApplication extends Application {
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Map map;
        super.attachBaseContext(context);
        a.pr(context);
        Function<SparseArray<Object>, Object> functionIe = zo.nt().ie();
        if (functionIe != null) {
            try {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 15);
                map = (Map) functionIe.apply(sparseArray);
            } catch (Exception e) {
                com.byazt.xk.hw.pr().pr(TrackAction.INIT, e);
                map = null;
            }
        } else {
            map = null;
        }
        ComponentManager.registerActivity("com.byted.pangle", pr(map, "STUB_STANDARD_ACTIVITY_T", PluginConstants.STUB_STANDARD_ACTIVITY_T), pr.pr);
        ComponentManager.registerActivity("com.byted.pangle", pr(map, "STUB_STANDARD_PORTRAIT_ACTIVITY_T", PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T), pr.hw);
        ComponentManager.registerActivity("com.byted.pangle", pr(map, "STUB_STANDARD_ACTIVITY", PluginConstants.STUB_STANDARD_ACTIVITY), pr.hn);
        ComponentManager.registerActivity("com.byted.pangle", pr(map, "STUB_STANDARD_LANDSCAPE_ACTIVITY", PluginConstants.STUB_STANDARD_LANDSCAPE_ACTIVITY), pr.x);
        ComponentManager.registerActivity("com.byted.pangle", pr(map, "STUB_SINGLE_TASK_ACTIVITY_T", PluginConstants.STUB_SINGLE_TASK_ACTIVITY_T), pr.c);
        com.byazt.jp.pr.pr();
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("init_init") { // from class: com.byazt.sd.TTApplication.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.xlm.aj.hw.k();
                com.byazt.ca.aj.pr();
                String strHw = ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).hw();
                if (strHw != null && strHw.endsWith(":downloader")) {
                    int iHn = com.byazt.zp.m.hn("com.byted.pangle", 101);
                    if (iHn > 0) {
                        iu.x = iHn;
                    }
                    com.byazt.jx.aj.x();
                }
            }
        });
    }

    private String pr(Map map, String str, String str2) {
        Object obj;
        return (map == null || (obj = map.get(str)) == null) ? str2 : String.valueOf(obj);
    }

    public Function attach(Function function) {
        if (function != null) {
            zo.nt().pr((Function<SparseArray<Object>, Object>) function);
        }
        return b.pr();
    }

    public Function initMainService(Function function) {
        com.byazt.zs.uc ucVarPr = com.byazt.zs.uc.pr();
        ucVarPr.pr(com.byazt.zs.m.pr);
        if (function == null) {
            return ucVarPr;
        }
        ucVarPr.apply(function);
        return null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME})
    private static final class pr {
        public static final String[] pr = {"com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity", "com.bytedance.msdk.api.activity.TTDelegateActivity", "com.bytedance.msdk.api.activity.TTTransparentActivity", "com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity"};
        public static final String[] hw = {"com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity"};
        public static final String[] hn = {"com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity"};
        public static final String[] x = {"com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity"};
        public static final String[] c = {"com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity", "com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity", "com.ss.android.downloadlib.activity.TTDelegateActivity"};
    }
}
