package com.byazt.tit;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 91})
public class rc {
    public static Object pr(com.byazt.dg.pr prVar) {
        nt ntVarPr;
        if (prVar != null && (ntVarPr = pr(prVar.pr())) != null) {
            return ntVarPr.pr(null, prVar.hw());
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static nt pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1919300188:
                if (str.equals("toNumber")) {
                    b = cc.k;
                }
                break;
            case -1776922004:
                if (str.equals("toString")) {
                    b = 12;
                }
                break;
            case -1368121510:
                if (str.equals("formatDecimal")) {
                    b = 10;
                }
                break;
            case -979207434:
                if (str.equals("feature")) {
                    b = 1;
                }
                break;
            case -652088201:
                if (str.equals("modArray")) {
                    b = 7;
                }
                break;
            case 3143097:
                if (str.equals("find")) {
                    b = 0;
                }
                break;
            case 3267882:
                if (str.equals("join")) {
                    b = cc.m;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    b = 11;
                }
                break;
            case 90259659:
                if (str.equals("includes")) {
                    b = cc.n;
                }
                break;
            case 94642797:
                if (str.equals("chunk")) {
                    b = 6;
                }
                break;
            case 96955127:
                if (str.equals("exist")) {
                    b = 3;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = 18;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = cc.l;
                }
                break;
            case 155244869:
                if (str.equals("dateFormat")) {
                    b = 2;
                }
                break;
            case 515198113:
                if (str.equals("decodeUrl")) {
                    b = 9;
                }
                break;
            case 547775784:
                if (str.equals("formatCurrency")) {
                    b = 19;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 5;
                }
                break;
            case 1204859691:
                if (str.equals("compactFormatCurrency")) {
                    b = 20;
                }
                break;
            case 1508134777:
                if (str.equals("encodeUrl")) {
                    b = 8;
                }
                break;
            case 2056988195:
                if (str.equals("isDigit")) {
                    b = 4;
                }
                break;
            case 2058039875:
                if (str.equals("isEmpty")) {
                    b = 17;
                }
                break;
        }
        switch (b) {
            case 0:
                return new aj();
            case 1:
                return new zo();
            case 2:
                return new hn();
            case 3:
                return new fw();
            case 4:
                return new m();
            case 5:
                return new fo();
            case 6:
                return new pr();
            case 7:
                return new yb();
            case 8:
                return new uc();
            case 9:
                return new x();
            case 10:
                return new w();
            case 11:
                return new lb();
            case 12:
                return new ny();
            case 13:
                return new cz();
            case 14:
                return new a();
            case 15:
                return new ho();
            case 16:
                return new k();
            case 17:
                return new g();
            case 18:
                return new qa();
            case 19:
                return new vk();
            case 20:
                return new hw();
            default:
                return null;
        }
    }
}
