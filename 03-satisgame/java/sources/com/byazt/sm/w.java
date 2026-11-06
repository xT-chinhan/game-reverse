package com.byazt.sm;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, 13})
public abstract class w {
    public abstract int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar);

    public char n(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public int qg(int i, String str) {
        while (com.byazt.dr.n.n(n(i, str))) {
            i++;
        }
        return i;
    }

    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cN = n(i3, str);
            if (!com.byazt.dr.n.qg(cN) && !com.byazt.dr.n.s(cN)) {
                return i3;
            }
            i2++;
        }
    }
}
