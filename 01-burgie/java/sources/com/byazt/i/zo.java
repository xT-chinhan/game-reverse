package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public int c = -1;
    public final int fw;
    public final ArrayList<pr> hn;
    public int uc;
    public final int x;
    public static final Set<String> pr = new HashSet();
    public static final Set<String> hw = new HashSet();

    public zo(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.x = size;
        this.hn = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            pr prVar = new pr(str);
            if (pr.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(prVar);
            } else if (hw.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(prVar);
            } else {
                this.hn.add(prVar);
            }
        }
        if (arrayList != null) {
            this.hn.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.hn.addAll(arrayList2);
        }
        Integer num = x.x;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.x >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.fw = iIntValue;
    }

    public boolean pr() {
        return this.uc < this.fw;
    }

    public pr hw() {
        if (!pr()) {
            throw new NoSuchElementException();
        }
        int i = this.c + 1;
        if (i >= this.x - 1) {
            this.c = -1;
            this.uc++;
        } else {
            this.c = i;
        }
        pr prVar = this.hn.get(i);
        prVar.hw = (this.uc * this.x) + this.c;
        return prVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 673})
    public class pr {
        public int hw;
        public final String pr;

        public pr(String str) {
            this.pr = str;
        }

        public void pr() {
            zo.pr.add(this.pr);
        }

        public void hw() {
            zo.hw.add(this.pr);
        }

        public String toString() {
            return this.pr;
        }
    }
}
