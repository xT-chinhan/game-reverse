package com.byazt.wgd;

import com.byazt.ld.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public String hn;
    public int hw;
    public Throwable pr;

    public zo(int i, String str, Throwable th) {
        this.hw = i;
        this.hn = str;
        this.pr = th;
    }

    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        hnVar.pr(new com.byazt.sl.pr(this.hw, this.hn, this.pr));
        String strZ = hnVar.z();
        Map<String, List<com.byazt.sl.hn>> mapFw = hnVar.cz().fw();
        List<com.byazt.sl.hn> list = mapFw.get(strZ);
        if (list == null) {
            hw(hnVar);
            return;
        }
        synchronized (list) {
            Iterator<com.byazt.sl.hn> it = list.iterator();
            while (it.hasNext()) {
                hw(it.next());
            }
            list.clear();
            mapFw.remove(strZ);
        }
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return IdentityVerifyStateKt.VERIFY_STATE_FAILED;
    }

    private void hw(com.byazt.sl.hn hnVar) {
        rc rcVarW = hnVar.w();
        if (rcVarW != null) {
            rcVarW.pr(this.hw, this.hn, this.pr);
        }
    }
}
