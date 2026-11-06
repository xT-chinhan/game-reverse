package com.bytedance.adsdk.xr.xr.ah.ms;

import com.bytedance.adsdk.xr.xr.xr.ms.ub;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends c {
    private boolean ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque) {
        if ('-' == ms(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.xr.xr.d.ah.ms(deque.peek().ms())) {
                return false;
            }
            if (com.bytedance.adsdk.xr.xr.ka.ms.ah(ms(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.xr.xr.ka.ms.ah(ms(i, str));
    }

    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        char cMs;
        if (!ms(str, i, deque)) {
            return msVar.ms(str, i, deque);
        }
        int i2 = ms(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cMs = ms(i2, str);
            if (!com.bytedance.adsdk.xr.xr.ka.ms.ah(cMs) && (z || cMs != '.')) {
                break;
            }
            i2++;
            if (cMs == '.') {
                z = true;
            }
        }
        if (cMs == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new ub(str.substring(i, i2)));
        return i2;
    }
}
