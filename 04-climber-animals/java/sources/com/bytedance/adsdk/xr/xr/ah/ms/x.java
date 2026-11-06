package com.bytedance.adsdk.xr.xr.ah.ms;

import com.bytedance.adsdk.xr.xr.xr.ms.ao;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class x extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        if (!com.bytedance.adsdk.xr.xr.ka.ms.d(ms(i, str))) {
            return msVar.ms(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{ms(i, str), ms(i2, str)});
        if (com.bytedance.adsdk.xr.xr.d.ah.ms(str2) != null) {
            deque.push(new ao(com.bytedance.adsdk.xr.xr.d.ah.ms(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(ms(i, str));
        if (com.bytedance.adsdk.xr.xr.d.ah.ms(strValueOf) != null) {
            deque.push(new ao(com.bytedance.adsdk.xr.xr.d.ah.ms(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
