package com.byazt.sm;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 18})
public class l extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        char cN;
        int i2 = i;
        while (true) {
            cN = n(i2, str);
            if (!com.byazt.dr.n.qg(cN) && !com.byazt.dr.n.s(cN)) {
                break;
            }
            i2++;
        }
        if (cN != '(') {
            return nVar.n(str, i, deque);
        }
        deque.push(new com.byazt.uc.tj(str.substring(i, i2)));
        return i2 + 1;
    }
}
