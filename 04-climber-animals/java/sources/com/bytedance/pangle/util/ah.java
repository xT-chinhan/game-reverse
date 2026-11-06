package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static String[] ms(File file) {
        String[] strArrMs = com.bytedance.pangle.util.ms.xr.ms(file);
        return TextUtils.isEmpty(strArrMs[0]) ? com.bytedance.pangle.util.ms.ms.ms(file) : strArrMs;
    }
}
