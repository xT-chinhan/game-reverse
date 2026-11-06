package com.byazt.vy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm {
    public static <T> void n(List<T> list, Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList, comparator);
            list.clear();
            list.addAll(listAsList);
        }
    }

    public static <T extends Comparable<? super T>> void n(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList);
            list.clear();
            list.addAll(listAsList);
        }
    }
}
