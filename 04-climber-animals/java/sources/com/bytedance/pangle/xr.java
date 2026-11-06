package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.log.IZeusReporter;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "start");
        xr().invokeHiddenApiRestrictions();
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "finish");
    }

    private static com.bytedance.pangle.flipped.ah xr() {
        if (ah()) {
            return new FlippedV2Impl();
        }
        if (d()) {
            return new com.bytedance.pangle.flipped.xr();
        }
        return new com.bytedance.pangle.flipped.ms();
    }

    private static boolean ah() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
