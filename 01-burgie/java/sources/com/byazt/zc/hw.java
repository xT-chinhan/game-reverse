package com.byazt.zc;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1971, 13})
public class hw {
    public static void pr(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable th2) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
