package com.byazt.ie;

import com.byazt.hh.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 585, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.hh.x {
    public List<com.byazt.hi.pr> pr;

    public c(Queue<String> queue, com.byazt.hh.hw hwVar, com.byazt.vkw.pr prVar) {
        uc ucVarHn;
        ArrayList arrayList = new ArrayList();
        this.pr = arrayList;
        arrayList.add(new com.byazt.hi.hn(hwVar.hw() == null ? com.byazt.jwj.pr.x(prVar) : hwVar.hw(), queue, prVar));
        if (hwVar.c() != null) {
            ucVarHn = hwVar.c();
        } else {
            ucVarHn = hwVar.hn();
        }
        this.pr.add(new com.byazt.hi.x(ucVarHn == null ? com.byazt.jwj.pr.pr(prVar) : ucVarHn, queue, prVar));
        this.pr.add(new com.byazt.hi.c(hwVar.hn() == null ? com.byazt.jwj.pr.hn(prVar) : hwVar.hn(), queue, prVar));
        this.pr.add(new com.byazt.hi.uc(hwVar.hn() == null ? com.byazt.jwj.pr.hn(prVar) : hwVar.hn(), queue, prVar));
        this.pr.add(new com.byazt.hi.hw(hwVar.x() == null ? com.byazt.jwj.pr.hw(prVar) : hwVar.x(), queue, prVar));
    }

    @Override // com.byazt.hh.x
    public void pr(com.byazt.hh.pr prVar, int i, boolean z) {
        Iterator<com.byazt.hi.pr> it = this.pr.iterator();
        while (it.hasNext()) {
            it.next().hw(prVar);
        }
    }

    @Override // com.byazt.hh.x
    public hw pr(int i, List<com.byazt.hh.pr> list, int i2) {
        Iterator<com.byazt.hi.pr> it = this.pr.iterator();
        hw hwVarPr = null;
        while (it.hasNext()) {
            hwVarPr = it.next().pr(i, list, i2);
            if (hwVarPr.pr()) {
                break;
            }
        }
        return hwVarPr;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, List<String> list) {
        Iterator<com.byazt.hi.pr> it = this.pr.iterator();
        while (it.hasNext()) {
            List<com.byazt.hh.pr> listPr = it.next().pr(i, prVar, z, list, "get");
            if (listPr != null && listPr.size() != 0) {
                return listPr;
            }
        }
        return null;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, String str) {
        return null;
    }

    @Override // com.byazt.hh.x
    public boolean pr(int i, String str, com.byazt.hh.pr prVar) {
        Iterator<com.byazt.hi.pr> it = this.pr.iterator();
        while (it.hasNext()) {
            if (it.next().pr(i, str, prVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.hh.x
    public int pr() {
        int size = this.pr.size();
        int iPr = 0;
        for (int i = 0; i < size; i++) {
            iPr += this.pr.get(i).pr();
        }
        return iPr;
    }

    @Override // com.byazt.hh.x
    public int hw() {
        return 0;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i) {
        return new ArrayList();
    }
}
