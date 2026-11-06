package com.byazt.ea;

import android.content.Context;
import com.byazt.ca.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 62})
public class fw implements com.byazt.qi.x.pr {
    public com.byazt.ik.hn hw;
    public ny pr;

    public fw(Context context, com.byazt.ik.hn hnVar) {
        this.pr = new ny(context, 1, com.byazt.sd.zo.nt().x());
        this.hw = hnVar;
    }

    private int hn() {
        JSONObject jSONObjectVk;
        com.byazt.ik.hn hnVar = this.hw;
        if (hnVar == null || (jSONObjectVk = hnVar.vk()) == null) {
            return 0;
        }
        return jSONObjectVk.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.qi.x.pr
    public void pr() {
        ny nyVar = this.pr;
        if (nyVar != null) {
            nyVar.pr(hn());
        }
    }

    @Override // com.byazt.qi.x.pr
    public void hw() {
        ny nyVar = this.pr;
        if (nyVar != null) {
            nyVar.hw(hn());
        }
    }

    @Override // com.byazt.qi.x.pr
    public void pr(float f) {
        ny nyVar = this.pr;
        if (nyVar != null) {
            nyVar.pr(f);
        }
    }

    @Override // com.byazt.qi.x.pr
    public void pr(final com.byazt.qi.x.hw hwVar) {
        ny nyVar = this.pr;
        if (nyVar != null) {
            nyVar.pr(new ny.pr() { // from class: com.byazt.ea.fw.1
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    com.byazt.qi.x.hw hwVar2 = hwVar;
                    if (hwVar2 != null) {
                        hwVar2.pr(i);
                    }
                }
            });
        }
    }
}
