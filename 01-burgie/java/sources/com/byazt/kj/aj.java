package com.byazt.kj;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, 61})
public class aj extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        com.byazt.awu.pr prVarPollFirst;
        if (')' != pr(i, str)) {
            return prVar.pr(str, i, deque);
        }
        LinkedList<com.byazt.awu.pr> linkedList = new LinkedList();
        while (true) {
            prVarPollFirst = deque.pollFirst();
            if (prVarPollFirst == null || prVarPollFirst.pr() == com.byazt.yiq.x.LEFT_PAREN || ((prVarPollFirst instanceof com.byazt.tki.vk) && prVarPollFirst.pr() == com.byazt.yiq.hw.METHOD && !((com.byazt.tki.vk) prVarPollFirst).hn())) {
                break;
            }
            linkedList.addFirst(prVarPollFirst);
        }
        if (prVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (prVarPollFirst.pr() == com.byazt.yiq.hw.METHOD) {
            com.byazt.tki.vk vkVar = (com.byazt.tki.vk) prVarPollFirst;
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            for (com.byazt.awu.pr prVar2 : linkedList) {
                if (prVar2.pr() == com.byazt.yiq.x.COMMA) {
                    linkedList2.add(com.byazt.ha.hw.pr(linkedList3, str, i));
                    linkedList3.clear();
                } else {
                    linkedList3.addLast(prVar2);
                }
            }
            if (!linkedList3.isEmpty()) {
                linkedList2.add(com.byazt.ha.hw.pr(linkedList3, str, i));
            }
            vkVar.pr((com.byazt.awu.pr[]) linkedList2.toArray(new com.byazt.awu.pr[linkedList2.size()]));
            vkVar.pr(true);
            int i2 = i + 1;
            deque.push(vkVar);
            return i2;
        }
        deque.push(com.byazt.ha.hw.pr(linkedList, str, i));
        return i + 1;
    }
}
