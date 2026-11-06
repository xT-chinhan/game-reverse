package com.byazt.xa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 13})
public class hw {
    public static final LinkedList<com.byazt.kg.pr> pr = new LinkedList<>();
    public static final LinkedList<com.byazt.kg.pr> hw = new LinkedList<>();

    public static void pr(com.byazt.kg.pr prVar) {
        LinkedList<com.byazt.kg.pr> linkedList = pr;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                com.byazt.kg.pr prVarPoll = linkedList.poll();
                com.byazt.ec.w.hw("drop event in cache", null);
                hw.add(prVarPoll);
            }
            linkedList.add(prVar);
        }
    }

    public static void pr() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<com.byazt.kg.pr> linkedList3 = pr;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<com.byazt.kg.pr> linkedList4 = hw;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            com.byazt.gox.x.pr((com.byazt.kg.pr) linkedList.poll());
        }
    }
}
