package com.byazt.kj;

import com.byazt.tki.a;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 13})
public class hw extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        if ('\'' != pr(i, str)) {
            return prVar.pr(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && pr(i3, str) != '\'') {
            i3++;
        }
        if (pr(i3, str) != '\'') {
            throw new com.byazt.zih.pr("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new a(str.substring(i2, i3)));
        return i3 + 1;
    }
}
