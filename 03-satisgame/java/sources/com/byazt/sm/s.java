package com.byazt.sm;

import com.byazt.uc.ou;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 8})
public class s extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        char cN = n(i, str);
        if (!com.byazt.dr.n.qg(cN) && cN != '$' && cN != '_') {
            return nVar.n(str, i, deque);
        }
        return n(str, i, deque);
    }

    private int n(String str, int i, Deque<com.byazt.uk.n> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cN = n(i2, str);
            if (!com.byazt.dr.n.qg(cN) && !com.byazt.dr.n.s(cN) && '.' != cN && '[' != cN && ']' != cN && '_' != cN && '$' != cN) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.byazt.mn.n.n(strSubstring) != null) {
            deque.push(new com.byazt.uc.x(strSubstring));
        } else {
            deque.push(new ou(strSubstring));
        }
        return i2;
    }
}
