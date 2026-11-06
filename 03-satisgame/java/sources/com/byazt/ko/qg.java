package com.byazt.ko;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 26})
public class qg {
    public static final LinkedList<com.byazt.yi.n> n = new LinkedList<>();
    public static final LinkedList<com.byazt.yi.n> qg = new LinkedList<>();

    public static void n(com.byazt.yi.n nVar) {
        LinkedList<com.byazt.yi.n> linkedList = n;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                com.byazt.yi.n nVarPoll = linkedList.poll();
                com.byazt.km.cp.qg("drop event in cache", null);
                qg.add(nVarPoll);
            }
            linkedList.add(nVar);
        }
    }

    public static void n() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<com.byazt.yi.n> linkedList3 = n;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<com.byazt.yi.n> linkedList4 = qg;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            com.byazt.fo.q.n((com.byazt.yi.n) linkedList.poll());
        }
    }
}
