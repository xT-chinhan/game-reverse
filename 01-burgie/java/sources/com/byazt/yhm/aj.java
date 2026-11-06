package com.byazt.yhm;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gx.DynamicBaseWidget;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.cc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 61})
public class aj {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static fw pr(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, com.byazt.rk.vk vkVar, com.byazt.mq.m mVar) {
        if (context == null || dynamicBaseWidget == null || fwVar == null) {
            return null;
        }
        String strQn = fwVar.qn();
        String strB = mVar.b();
        byte b = -1;
        switch (strQn.hashCode()) {
            case 48:
                if (strQn.equals("0")) {
                    b = 17;
                }
                break;
            case 49:
                if (strQn.equals("1")) {
                    b = 21;
                }
                break;
            case 50:
                if (strQn.equals("2")) {
                    b = 8;
                }
                break;
            case 53:
                if (strQn.equals(GlobalSetting.REWARD_VIDEO_AD)) {
                    b = 7;
                }
                break;
            case 54:
                if (strQn.equals(GlobalSetting.NATIVE_UNIFIED_AD)) {
                    b = 3;
                }
                break;
            case 55:
                if (strQn.equals(GlobalSetting.UNIFIED_BANNER_AD)) {
                    b = 9;
                }
                break;
            case 56:
                if (strQn.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 5;
                }
                break;
            case 57:
                if (strQn.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 0;
                }
                break;
            case 1567:
                if (strQn.equals("10")) {
                    b = cc.n;
                }
                break;
            case 1568:
                if (strQn.equals("11")) {
                    b = 4;
                }
                break;
            case 1569:
                if (strQn.equals("12")) {
                    b = 6;
                }
                break;
            case 1570:
                if (strQn.equals("13")) {
                    b = 2;
                }
                break;
            case 1571:
                if (strQn.equals("14")) {
                    b = 10;
                }
                break;
            case 1573:
                if (strQn.equals("16")) {
                    b = 1;
                }
                break;
            case 1574:
                if (strQn.equals("17")) {
                    b = 11;
                }
                break;
            case 1575:
                if (strQn.equals("18")) {
                    b = 12;
                }
                break;
            case 1598:
                if (strQn.equals("20")) {
                    b = cc.k;
                }
                break;
            case 1600:
                if (strQn.equals("22")) {
                    b = cc.l;
                }
                break;
            case 1601:
                if (strQn.equals("23")) {
                    b = 19;
                }
                break;
            case 1602:
                if (strQn.equals("24")) {
                    b = 18;
                }
                break;
            case 1603:
                if (strQn.equals("25")) {
                    b = 20;
                }
                break;
            case 1607:
                if (strQn.equals("29")) {
                    b = cc.m;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return new g(context, dynamicBaseWidget, fwVar, strQn, vkVar, mVar.aj(), mVar.ve());
            case 2:
                return new yb(context, dynamicBaseWidget, fwVar);
            case 3:
            case 4:
                return new m(context, dynamicBaseWidget, fwVar);
            case 5:
                return new k(context, dynamicBaseWidget, fwVar);
            case 6:
                return new nt(context, dynamicBaseWidget, fwVar);
            case 7:
                if (fwVar.ii() == 1) {
                    return new yb(context, dynamicBaseWidget, fwVar, fwVar.od());
                }
                return new nt(context, dynamicBaseWidget, fwVar);
            case 8:
                return new hw(context, dynamicBaseWidget, fwVar);
            case 9:
            case 10:
                return new w(context, dynamicBaseWidget, fwVar);
            case 11:
            case 12:
                return new qa(context, dynamicBaseWidget, fwVar, strQn, vkVar, mVar.aj(), mVar.ve());
            case 13:
                if (com.byazt.dj.x.pr()) {
                    return new vk(context, dynamicBaseWidget, fwVar, strB + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new vk(context, dynamicBaseWidget, fwVar, TextUtils.isEmpty(strB) ? null : strB + "brush_mask.json", "20");
            case 14:
                if (com.byazt.dj.x.pr()) {
                    return new vk(context, dynamicBaseWidget, fwVar, strB + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new lb(context, dynamicBaseWidget, fwVar);
            case 15:
                return new uc(context, dynamicBaseWidget, fwVar, vkVar, mVar.aj(), mVar.ve());
            case 16:
                return new x(context, dynamicBaseWidget, fwVar);
            case 17:
                return new c(context, dynamicBaseWidget, fwVar);
            case 18:
                if (com.byazt.dj.x.pr()) {
                    return new pr(context, dynamicBaseWidget, fwVar);
                }
                return new vk(context, dynamicBaseWidget, fwVar, TextUtils.isEmpty(strB) ? null : strB + "swiper_up_star.json", "24");
            case 19:
                if (!com.byazt.dj.x.pr()) {
                    return null;
                }
                return new vk(context, dynamicBaseWidget, fwVar, strB + "static/lotties/202327swiper-up-star/click.json", "23");
            case 20:
                if (!com.byazt.dj.x.pr()) {
                    return null;
                }
                return new vk(context, dynamicBaseWidget, fwVar, strB + "static/lotties/gesture-slide.json", "25");
            case 21:
                return new hn(context, dynamicBaseWidget, fwVar);
            default:
                return null;
        }
    }
}
