package com.byazt.ye;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 985, 26})
public class qg {
    public static void n(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
