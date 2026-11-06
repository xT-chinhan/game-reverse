package com.byazt.kj;

import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 5})
public abstract class uc {
    public abstract int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar);

    public char pr(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public int hw(int i, String str) {
        while (com.byazt.ha.pr.pr(pr(i, str))) {
            i++;
        }
        return i;
    }

    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cPr = pr(i3, str);
            if (com.byazt.ha.pr.hw(cPr) || com.byazt.ha.pr.hn(cPr)) {
                i2++;
            } else {
                return i3;
            }
        }
    }
}
