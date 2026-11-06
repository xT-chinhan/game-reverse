package com.byazt.fp;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 62})
public class fw {
    public static final List<String> pr = new ArrayList(Arrays.asList("1", GlobalSetting.SPLASH_AD, "2"));

    public static String pr(Context context, com.byazt.vkw.pr prVar) {
        return pr(hn.pr(context, prVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    public static String pr(String str) {
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46003":
            case "46005":
            case "46011":
                return GlobalSetting.SPLASH_AD;
            case "46001":
            case "46006":
            case "46009":
                return "2";
            default:
                return "0";
        }
    }

    public static String pr(com.byazt.vkw.pr prVar, Context context) {
        String strC = hn.c(prVar, context);
        String strFw = hn.fw(prVar, context);
        String strUc = hn.uc(prVar, context);
        String strZo = hn.zo(prVar, context);
        if (!hn.hw(context)) {
            return GlobalSetting.REWARD_VIDEO_AD;
        }
        if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strFw)) {
            if (TextUtils.isEmpty(strUc) || TextUtils.isEmpty(strZo)) {
                return GlobalSetting.NATIVE_EXPRESS_AD;
            }
            return pr(strUc + strZo);
        }
        if (TextUtils.isEmpty(strUc) || TextUtils.isEmpty(strZo)) {
            return pr(strC + strFw);
        }
        String strPr = pr(strC + strFw);
        String strPr2 = pr(strUc + strZo);
        List<String> list = pr;
        if (list.contains(strPr) && list.contains(strPr2) && !strPr2.equals(strPr)) {
            return GlobalSetting.NATIVE_UNIFIED_AD;
        }
        if (list.contains(strPr)) {
            return strPr;
        }
        if (list.contains(strPr2)) {
            return strPr2;
        }
        return "0";
    }
}
