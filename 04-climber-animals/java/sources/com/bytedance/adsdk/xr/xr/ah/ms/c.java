package com.bytedance.adsdk.xr.xr.ah.ms;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public abstract int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar);

    protected char ms(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    protected int xr(int i, String str) {
        while (com.bytedance.adsdk.xr.xr.ka.ms.ms(ms(i, str))) {
            i++;
        }
        return i;
    }

    protected int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cMs = ms(i3, str);
            if (!com.bytedance.adsdk.xr.xr.ka.ms.xr(cMs) && !com.bytedance.adsdk.xr.xr.ka.ms.ah(cMs)) {
                return i3;
            }
            i2++;
        }
    }
}
