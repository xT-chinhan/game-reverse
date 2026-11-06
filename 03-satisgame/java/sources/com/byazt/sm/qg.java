package com.byazt.sm;

import com.byazt.uc.a;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 26})
public class qg extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        if ('\'' != n(i, str)) {
            return nVar.n(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && n(i3, str) != '\'') {
            i3++;
        }
        if (n(i3, str) != '\'') {
            throw new com.byazt.sc.n("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new a(str.substring(i2, i3)));
        return i3 + 1;
    }
}
