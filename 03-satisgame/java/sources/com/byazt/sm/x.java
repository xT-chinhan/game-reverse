package com.byazt.sm;

import com.byazt.uc.k;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 21})
public class x extends w {
    private boolean n(String str, int i, Deque<com.byazt.uk.n> deque) {
        if ('-' == n(i, str)) {
            if (deque.peek() != null && !com.byazt.mn.s.n(deque.peek().n())) {
                return false;
            }
            if (com.byazt.dr.n.s(n(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.byazt.dr.n.s(n(i, str));
    }

    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        char cN;
        if (!n(str, i, deque)) {
            return nVar.n(str, i, deque);
        }
        int i2 = n(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cN = n(i2, str);
            if (!com.byazt.dr.n.s(cN) && (z || cN != '.')) {
                break;
            }
            i2++;
            if (cN == '.') {
                z = true;
            }
        }
        if (cN == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new k(str.substring(i, i2)));
        return i2;
    }
}
