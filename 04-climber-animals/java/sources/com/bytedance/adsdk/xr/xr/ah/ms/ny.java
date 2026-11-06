package com.bytedance.adsdk.xr.xr.ah.ms;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends c {
    @Override // com.bytedance.adsdk.xr.xr.ah.ms.c
    public int ms(String str, int i, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        com.bytedance.adsdk.xr.xr.xr.ms msVarPollFirst;
        if (')' != ms(i, str)) {
            return msVar.ms(str, i, deque);
        }
        LinkedList<com.bytedance.adsdk.xr.xr.xr.ms> linkedList = new LinkedList();
        while (true) {
            msVarPollFirst = deque.pollFirst();
            if (msVarPollFirst == null || msVarPollFirst.ms() == com.bytedance.adsdk.xr.xr.d.xr.METHOD || msVarPollFirst.ms() == com.bytedance.adsdk.xr.xr.d.d.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(msVarPollFirst);
        }
        if (msVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (msVarPollFirst.ms() != com.bytedance.adsdk.xr.xr.d.xr.METHOD) {
            deque.push(com.bytedance.adsdk.xr.xr.ka.xr.ms(linkedList, str, i));
            return i + 1;
        }
        com.bytedance.adsdk.xr.xr.xr.ms.ch chVar = (com.bytedance.adsdk.xr.xr.xr.ms.ch) msVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.xr.xr.xr.ms msVar2 : linkedList) {
            if (msVar2.ms() == com.bytedance.adsdk.xr.xr.d.d.COMMA) {
                linkedList2.add(com.bytedance.adsdk.xr.xr.ka.xr.ms(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(msVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.xr.xr.ka.xr.ms(linkedList3, str, i));
        }
        chVar.ms((com.bytedance.adsdk.xr.xr.xr.ms[]) linkedList2.toArray(new com.bytedance.adsdk.xr.xr.xr.ms[linkedList2.size()]));
        int i2 = i + 1;
        deque.push(chVar);
        return i2;
    }
}
