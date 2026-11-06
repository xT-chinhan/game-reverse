package com.byazt.yb;

import com.byazt.hg.of;
import com.byazt.mr.vk;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 13})
public class hw extends com.byazt.ra.hw<List<vk>> {
    @Override // com.byazt.ra.hw
    public /* bridge */ /* synthetic */ void pr(com.byazt.qe.hw hwVar, List list, List<vk> list2) {
        pr2(hwVar, (List<of>) list, list2);
    }

    public hw(com.byazt.pe.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.ra.hw
    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.ra.hw.pr<List<vk>> prVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new x(a.getContext(), it.next(), 5, hwVar));
        }
        if (prVar != null) {
            prVar.pr(arrayList);
        }
    }

    /* JADX INFO: renamed from: pr, reason: avoid collision after fix types in other method */
    public void pr2(com.byazt.qe.hw hwVar, List<of> list, List<vk> list2) {
        for (int i = 0; i < list2.size(); i++) {
            of ofVar = list.get(i);
            vk vkVar = list2.get(i);
            if (this.pr != null) {
                this.pr.hw().pr(hwVar, ofVar, (Object) vkVar, false);
            }
        }
    }
}
