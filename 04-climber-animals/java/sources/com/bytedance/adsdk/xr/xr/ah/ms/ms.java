package com.bytedance.adsdk.xr.xr.ah.ms;

import com.bytedance.adsdk.xr.xr.xr.ms.nw;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        if (',' != ms(i, str)) {
            return msVar.ms(str, i, deque);
        }
        deque.push(new nw(com.bytedance.adsdk.xr.xr.d.d.COMMA));
        return i + 1;
    }
}
