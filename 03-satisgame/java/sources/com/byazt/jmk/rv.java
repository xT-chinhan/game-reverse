package com.byazt.jmk;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.osr.DynamicBaseWidget;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static x n(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, com.byazt.lh.tj tjVar, com.byazt.udb.oa oaVar) {
        if (context == null || dynamicBaseWidget == null || xVar == null) {
            return null;
        }
        String strDg = xVar.dg();
        String strH = oaVar.h();
        strDg.hashCode();
        switch (strDg) {
            case "0":
                return new l(context, dynamicBaseWidget, xVar);
            case "1":
                return new s(context, dynamicBaseWidget, xVar);
            case "2":
                return new qg(context, dynamicBaseWidget, xVar);
            case "5":
                if (xVar.pk() == 1) {
                    return new hd(context, dynamicBaseWidget, xVar, xVar.cx());
                }
                return new cy(context, dynamicBaseWidget, xVar);
            case "6":
            case "11":
                return new oa(context, dynamicBaseWidget, xVar);
            case "7":
            case "14":
                return new cp(context, dynamicBaseWidget, xVar);
            case "8":
                return new d(context, dynamicBaseWidget, xVar);
            case "9":
            case "16":
                return new sz(context, dynamicBaseWidget, xVar, strDg, tjVar, oaVar.rv(), oaVar.ur());
            case "10":
                return new q(context, dynamicBaseWidget, xVar);
            case "12":
                return new cy(context, dynamicBaseWidget, xVar);
            case "13":
                return new hd(context, dynamicBaseWidget, xVar);
            case "17":
            case "18":
                return new um(context, dynamicBaseWidget, xVar, strDg, tjVar, oaVar.rv(), oaVar.ur());
            case "20":
                if (com.byazt.twc.q.n()) {
                    return new tj(context, dynamicBaseWidget, xVar, strH + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new tj(context, dynamicBaseWidget, xVar, TextUtils.isEmpty(strH) ? null : strH + "brush_mask.json", "20");
            case "22":
                if (com.byazt.twc.q.n()) {
                    return new tj(context, dynamicBaseWidget, xVar, strH + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new cd(context, dynamicBaseWidget, xVar);
            case "23":
                if (com.byazt.twc.q.n()) {
                    return new tj(context, dynamicBaseWidget, xVar, strH + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case "24":
                if (com.byazt.twc.q.n()) {
                    return new n(context, dynamicBaseWidget, xVar);
                }
                return new tj(context, dynamicBaseWidget, xVar, TextUtils.isEmpty(strH) ? null : strH + "swiper_up_star.json", "24");
            case "25":
                if (com.byazt.twc.q.n()) {
                    return new tj(context, dynamicBaseWidget, xVar, strH + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case "29":
                return new w(context, dynamicBaseWidget, xVar, tjVar, oaVar.rv(), oaVar.ur());
            default:
                return null;
        }
    }
}
