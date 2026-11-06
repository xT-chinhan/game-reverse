package com.bytedance.adsdk.xr.xr.ah.ms;

import com.bytedance.adsdk.xr.xr.xr.ms.b;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        char cMs = ms(i, str);
        if (!com.bytedance.adsdk.xr.xr.ka.ms.xr(cMs) && cMs != '$') {
            return msVar.ms(str, i, deque);
        }
        return ms(str, i, deque);
    }

    private int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cMs = ms(i2, str);
            if (!com.bytedance.adsdk.xr.xr.ka.ms.xr(cMs) && !com.bytedance.adsdk.xr.xr.ka.ms.ah(cMs) && '.' != cMs && '[' != cMs && ']' != cMs && '_' != cMs && '-' != cMs && '$' != cMs) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.xr.xr.d.ms.ms(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.xr.xr.xr.ms.ab(strSubstring));
        } else {
            deque.push(new b(strSubstring));
        }
        return i2;
    }
}
