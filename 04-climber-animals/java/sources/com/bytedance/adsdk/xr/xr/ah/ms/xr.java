package com.bytedance.adsdk.xr.xr.ah.ms;

import com.bytedance.adsdk.xr.xr.xr.ms.t;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        if ('\'' != ms(i, str)) {
            return msVar.ms(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && ms(i3, str) != '\'') {
            i3++;
        }
        if (ms(i3, str) != '\'') {
            throw new com.bytedance.adsdk.xr.ms.ms("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new t(str.substring(i2, i3)));
        return i3 + 1;
    }
}
