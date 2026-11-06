package com.byazt.kj;

import com.byazt.tki.ho;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 62})
public class fw extends uc {
    private boolean pr(String str, int i, Deque<com.byazt.awu.pr> deque) {
        if ('-' == pr(i, str)) {
            if (deque.peek() != null && !com.byazt.yiq.hn.pr(deque.peek().pr())) {
                return false;
            }
            if (com.byazt.ha.pr.hn(pr(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.byazt.ha.pr.hn(pr(i, str));
    }

    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        int i2;
        char cPr;
        if (!pr(str, i, deque)) {
            return prVar.pr(str, i, deque);
        }
        if (pr(i, str) != '-') {
            i2 = i;
        } else {
            i2 = i + 1;
        }
        boolean z = false;
        while (true) {
            cPr = pr(i2, str);
            if (!com.byazt.ha.pr.hn(cPr) && (z || cPr != '.')) {
                break;
            }
            i2++;
            if (cPr == '.') {
                z = true;
            }
        }
        if (cPr == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new ho(str.substring(i, i2)));
        return i2;
    }
}
