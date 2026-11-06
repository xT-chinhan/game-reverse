package com.byazt.sm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1534, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends w {
    @Override // com.byazt.sm.w
    public int n(String str, int i, Deque<com.byazt.uk.n> deque, com.byazt.bm.n nVar) {
        com.byazt.uk.n nVarPollFirst;
        if (')' != n(i, str)) {
            return nVar.n(str, i, deque);
        }
        LinkedList<com.byazt.uk.n> linkedList = new LinkedList();
        while (true) {
            nVarPollFirst = deque.pollFirst();
            if (nVarPollFirst == null || nVarPollFirst.n() == com.byazt.mn.q.LEFT_PAREN || ((nVarPollFirst instanceof com.byazt.uc.tj) && nVarPollFirst.n() == com.byazt.mn.qg.METHOD && !((com.byazt.uc.tj) nVarPollFirst).s())) {
                break;
            }
            linkedList.addFirst(nVarPollFirst);
        }
        if (nVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (nVarPollFirst.n() != com.byazt.mn.qg.METHOD) {
            deque.push(com.byazt.dr.qg.n(linkedList, str, i));
            return i + 1;
        }
        com.byazt.uc.tj tjVar = (com.byazt.uc.tj) nVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.byazt.uk.n nVar2 : linkedList) {
            if (nVar2.n() == com.byazt.mn.q.COMMA) {
                linkedList2.add(com.byazt.dr.qg.n(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(nVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.byazt.dr.qg.n(linkedList3, str, i));
        }
        tjVar.n((com.byazt.uk.n[]) linkedList2.toArray(new com.byazt.uk.n[linkedList2.size()]));
        tjVar.n(true);
        int i2 = i + 1;
        deque.push(tjVar);
        return i2;
    }
}
