package com.byazt.sm;

import com.byazt.uc.cy;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 101})
public class fs extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        if (!com.byazt.dr.n.q(n(i, str))) {
            return nVar.n(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{n(i, str), n(i2, str)});
        if (com.byazt.mn.s.n(str2) != null) {
            deque.push(new cy(com.byazt.mn.s.n(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(n(i, str));
        if (com.byazt.mn.s.n(strValueOf) != null) {
            deque.push(new cy(com.byazt.mn.s.n(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
