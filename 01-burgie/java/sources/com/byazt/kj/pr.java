package com.byazt.kj;

import com.byazt.tki.cz;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 37})
public class pr extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        if (',' != pr(i, str)) {
            return prVar.pr(str, i, deque);
        }
        deque.push(new cz(com.byazt.yiq.x.COMMA));
        return i + 1;
    }
}
