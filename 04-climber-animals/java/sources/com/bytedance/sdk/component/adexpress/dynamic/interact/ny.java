package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ab ms(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, com.bytedance.sdk.component.adexpress.xr.zb zbVar) {
        if (context == null || dynamicBaseWidget == null || abVar == null) {
            return null;
        }
        String strE = abVar.e();
        String strOp = zbVar.op();
        strE.hashCode();
        byte b = -1;
        switch (strE.hashCode()) {
            case 48:
                if (strE.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (strE.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strE.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strE.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strE.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strE.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strE.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 6;
                }
                break;
            case 57:
                if (strE.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 7;
                }
                break;
            case 1567:
                if (strE.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strE.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (strE.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (strE.equals("13")) {
                    b = 11;
                }
                break;
            case 1571:
                if (strE.equals("14")) {
                    b = 12;
                }
                break;
            case 1573:
                if (strE.equals("16")) {
                    b = ek.k;
                }
                break;
            case 1574:
                if (strE.equals("17")) {
                    b = ek.l;
                }
                break;
            case 1575:
                if (strE.equals("18")) {
                    b = ek.m;
                }
                break;
            case 1598:
                if (strE.equals("20")) {
                    b = ek.n;
                }
                break;
            case 1600:
                if (strE.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (strE.equals("23")) {
                    b = 18;
                }
                break;
            case 1602:
                if (strE.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strE.equals("25")) {
                    b = 20;
                }
                break;
            case 1607:
                if (strE.equals("29")) {
                    b = 21;
                }
                break;
        }
        switch (b) {
            case 0:
                return new ka(context, dynamicBaseWidget, abVar);
            case 1:
                return new ah(context, dynamicBaseWidget, abVar);
            case 2:
                return new xr(context, dynamicBaseWidget, abVar);
            case 3:
                if (abVar.eg() == 1) {
                    return new h(context, dynamicBaseWidget, abVar, abVar.qk());
                }
                return new ao(context, dynamicBaseWidget, abVar);
            case 4:
            case 9:
                return new zb(context, dynamicBaseWidget, abVar);
            case 5:
            case 12:
                return new hi(context, dynamicBaseWidget, abVar);
            case 6:
                return new sl(context, dynamicBaseWidget, abVar);
            case 7:
            case 13:
                return new u(context, dynamicBaseWidget, abVar, strE, chVar, zbVar.ny(), zbVar.cv());
            case 8:
                return new d(context, dynamicBaseWidget, abVar);
            case 10:
                return new ao(context, dynamicBaseWidget, abVar);
            case 11:
                return new h(context, dynamicBaseWidget, abVar);
            case 14:
            case 15:
                return new y(context, dynamicBaseWidget, abVar, strE, chVar, zbVar.ny(), zbVar.cv());
            case 16:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    return new ch(context, dynamicBaseWidget, abVar, strOp + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new ch(context, dynamicBaseWidget, abVar, TextUtils.isEmpty(strOp) ? null : strOp + "brush_mask.json", "20");
            case 17:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    return new ch(context, dynamicBaseWidget, abVar, strOp + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new qv(context, dynamicBaseWidget, abVar);
            case 18:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    return new ch(context, dynamicBaseWidget, abVar, strOp + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case 19:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    return new ms(context, dynamicBaseWidget, abVar);
                }
                return new ch(context, dynamicBaseWidget, abVar, TextUtils.isEmpty(strOp) ? null : strOp + "swiper_up_star.json", "24");
            case 20:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    return new ch(context, dynamicBaseWidget, abVar, strOp + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case 21:
                return new c(context, dynamicBaseWidget, abVar, chVar, zbVar.ny(), zbVar.cv());
            default:
                return null;
        }
    }
}
