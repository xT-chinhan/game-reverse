package com.byazt.nf;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.byazt.qp.cp;
import com.byazt.qyu.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 1152})
public class TTApplication extends Application {
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Map map;
        super.attachBaseContext(context);
        rv.n(context);
        Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
        if (functionB != null) {
            try {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 15);
                map = (Map) functionB.apply(sparseArray);
            } catch (Exception e) {
                com.byazt.eji.s.n().n("init", e);
                map = null;
            }
        } else {
            map = null;
        }
        ComponentManager.registerActivity("com.byted.pangle", n(map, "STUB_STANDARD_ACTIVITY_T", PluginConstants.STUB_STANDARD_ACTIVITY_T), n.n);
        ComponentManager.registerActivity("com.byted.pangle", n(map, "STUB_STANDARD_PORTRAIT_ACTIVITY_T", PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T), n.qg);
        ComponentManager.registerActivity("com.byted.pangle", n(map, "STUB_STANDARD_ACTIVITY", PluginConstants.STUB_STANDARD_ACTIVITY), n.s);
        ComponentManager.registerActivity("com.byted.pangle", n(map, "STUB_STANDARD_LANDSCAPE_ACTIVITY", PluginConstants.STUB_STANDARD_LANDSCAPE_ACTIVITY), n.q);
        ComponentManager.registerActivity("com.byted.pangle", n(map, "STUB_SINGLE_TASK_ACTIVITY_T", PluginConstants.STUB_SINGLE_TASK_ACTIVITY_T), n.l);
        com.byazt.ag.n.n();
        com.byazt.qit.l.qg(new com.byazt.qit.x("init_init") { // from class: com.byazt.nf.TTApplication.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.qit.rv.qg.oa();
                com.byazt.tk.rv.n();
                String strQg = ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
                if (strQg == null || !strQg.endsWith(":downloader")) {
                    return;
                }
                int iS = com.byazt.wl.l.s("com.byted.pangle", 101);
                if (iS > 0) {
                    tj.l = iS;
                }
                com.byazt.iz.rv.q();
            }
        });
    }

    private String n(Map map, String str, String str2) {
        Object obj;
        return (map == null || (obj = map.get(str)) == null) ? str2 : String.valueOf(obj);
    }

    public Function attach(Function function) {
        if (function != null) {
            com.byazt.vyf.s.cy().n((Function<SparseArray<Object>, Object>) function);
        }
        return com.byazt.xb.qg.n();
    }

    public Function initMainService(Function function) {
        com.byazt.qp.q qVarN = com.byazt.qp.q.n();
        qVarN.n(cp.n);
        if (function == null) {
            return qVarN;
        }
        qVarN.apply(function);
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 2198})
    private static final class n {
        public static final String[] n = {"com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity", "com.bytedance.msdk.api.activity.TTDelegateActivity", "com.bytedance.msdk.api.activity.TTTransparentActivity", "com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity"};
        public static final String[] qg = {"com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity"};
        public static final String[] s = {"com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity"};
        public static final String[] q = {"com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity"};
        public static final String[] l = {"com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity", "com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity", "com.ss.android.downloadlib.activity.TTDelegateActivity"};
    }
}
