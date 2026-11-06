package com.byazt.nd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 101})
public class fs {
    public static final Set<String> n = new HashSet();
    public static final Set<String> qg = new HashSet();
    public int l = -1;
    public final int q;
    public final ArrayList<n> s;
    public int w;
    public final int x;

    public fs(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.q = size;
        this.s = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            n nVar = new n(str);
            if (n.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(nVar);
            } else if (qg.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(nVar);
            } else {
                this.s.add(nVar);
            }
        }
        if (arrayList != null) {
            this.s.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.s.addAll(arrayList2);
        }
        Integer num = q.q;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.q >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.x = iIntValue;
    }

    public boolean n() {
        return this.w < this.x;
    }

    public n qg() {
        if (!n()) {
            throw new NoSuchElementException();
        }
        int i = this.l + 1;
        if (i >= this.q - 1) {
            this.l = -1;
            this.w++;
        } else {
            this.l = i;
        }
        n nVar = this.s.get(i);
        nVar.qg = (this.w * this.q) + this.l;
        return nVar;
    }

    @com.byazt.cp.n(n = {0, 1, 674, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public class n {
        public final String n;
        public int qg;

        public n(String str) {
            this.n = str;
        }

        public void n() {
            fs.n.add(this.n);
        }

        public void qg() {
            fs.qg.add(this.n);
        }

        public String toString() {
            return this.n;
        }
    }
}
