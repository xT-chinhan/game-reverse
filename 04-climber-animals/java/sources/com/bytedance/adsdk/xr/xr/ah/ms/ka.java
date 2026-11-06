package com.bytedance.adsdk.xr.xr.ah.ms;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        char cMs;
        int i2 = i;
        while (true) {
            cMs = ms(i2, str);
            if (!com.bytedance.adsdk.xr.xr.ka.ms.xr(cMs) && !com.bytedance.adsdk.xr.xr.ka.ms.ah(cMs)) {
                break;
            }
            i2++;
        }
        if (cMs != '(') {
            return msVar.ms(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.xr.xr.xr.ms.ch(str.substring(i, i2)));
        return i2 + 1;
    }
}
