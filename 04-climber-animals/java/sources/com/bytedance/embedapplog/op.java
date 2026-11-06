package com.bytedance.embedapplog;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class op {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final LinkedList<tz> f512ms = new LinkedList<>();
    private static final LinkedList<tz> xr = new LinkedList<>();

    public static void ms(tz tzVar) {
        LinkedList<tz> linkedList = f512ms;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                tz tzVarPoll = linkedList.poll();
                oh.xr("drop event in cache", null);
                xr.add(tzVarPoll);
            }
            linkedList.add(tzVar);
        }
    }

    public static void ms() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<tz> linkedList3 = f512ms;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<tz> linkedList4 = xr;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            b.ms((tz) linkedList.poll());
        }
    }
}
