package com.byazt.kj;

import com.byazt.tki.ny;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 20})
public class hn extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        char cPr = pr(i, str);
        if (!com.byazt.ha.pr.hw(cPr) && cPr != '$') {
            return prVar.pr(str, i, deque);
        }
        return pr(str, i, deque);
    }

    private int pr(String str, int i, Deque<com.byazt.awu.pr> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cPr = pr(i2, str);
            if (!com.byazt.ha.pr.hw(cPr) && !com.byazt.ha.pr.hn(cPr) && '.' != cPr && '[' != cPr && ']' != cPr && '_' != cPr && '$' != cPr) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.byazt.yiq.pr.pr(strSubstring) != null) {
            deque.push(new com.byazt.tki.fw(strSubstring));
        } else {
            deque.push(new ny(strSubstring));
        }
        return i2;
    }
}
