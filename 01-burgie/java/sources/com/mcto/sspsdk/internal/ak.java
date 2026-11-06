package com.mcto.sspsdk.internal;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.kit.internal.p001const.TrackAction;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class ak {
    public static /* synthetic */ String a(int i) {
        switch (i) {
            case 1:
                return "impression";
            case 2:
                return "click";
            case 3:
                return "trueview";
            case 4:
                return ILivePush.ClickType.CLOSE;
            case 5:
                return TrackAction.START;
            case 6:
                return "firstQuartile";
            case 7:
                return "midpoint";
            case 8:
                return "thirdQuartile";
            case 9:
                return "complete";
            case 10:
                return "downloadStart";
            case 11:
                return "downloaded";
            case 12:
                return "installed";
            case 13:
                return "conversion";
            case 14:
                return "incentiveTask";
            case 15:
                return "goldCoin";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String b(int i) {
        switch (i) {
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return GlobalSetting.SPLASH_AD;
            case 4:
                return GlobalSetting.NATIVE_EXPRESS_AD;
            case 5:
                return "10";
            case 6:
                return "11";
            case 7:
                return "12";
            case 8:
                return "13";
            case 9:
                return "14";
            case 10:
                return "20";
            case 11:
                return "21";
            case 12:
                return "22";
            case 13:
                return "23";
            case 14:
                return "27";
            case 15:
                return "37";
            default:
                throw null;
        }
    }
}
