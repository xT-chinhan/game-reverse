package com.byazt.sm;

import com.byazt.uc.py;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 5})
public class q extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        if ('(' != n(i, str)) {
            return nVar.n(str, i, deque);
        }
        deque.push(new py(com.byazt.mn.q.LEFT_PAREN));
        return i + 1;
    }
}
