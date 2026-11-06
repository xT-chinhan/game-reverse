package com.byazt.wj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, 13})
public final class hw {
    public static final ThreadLocal<Deque<String>> pr = new ThreadLocal<Deque<String>>() { // from class: com.byazt.wj.hw.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Deque<String> initialValue() {
            return new ArrayDeque();
        }
    };

    public static void pr(String str) {
        Deque<String> deque = pr.get();
        if (str == null) {
            str = "";
        }
        deque.push(str);
    }

    public static void pr() {
        ThreadLocal<Deque<String>> threadLocal = pr;
        Deque<String> deque = threadLocal.get();
        if (deque.isEmpty()) {
            threadLocal.remove();
            return;
        }
        deque.pop();
        if (deque.isEmpty()) {
            threadLocal.remove();
        }
    }

    public static int hw() {
        return pr.get().size();
    }

    public static String hn() {
        String strPeek = pr.get().peek();
        return strPeek == null ? "" : strPeek;
    }

    public static List<String> x() {
        Deque<String> deque = pr.get();
        if (deque.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(deque);
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static boolean hw(String str) {
        if (str == null) {
            return false;
        }
        Iterator<String> it = pr.get().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
