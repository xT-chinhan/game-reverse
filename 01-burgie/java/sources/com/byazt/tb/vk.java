package com.byazt.tb;

import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 50})
public class vk implements com.byazt.mc.uc {
    public List<com.byazt.mn.hw> hw = new CopyOnWriteArrayList();
    public boolean pr = false;

    private boolean pr() {
        return a.hw().hh();
    }

    @Override // com.byazt.mc.uc
    public void pr(com.byazt.pv.uc ucVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("app", "started", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hw.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, ucVar.ho, ucVar);
    }

    @Override // com.byazt.mc.uc
    public void hw(com.byazt.pv.uc ucVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("app", "foregrounded", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hw.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, ucVar.ho, ucVar);
    }

    @Override // com.byazt.mc.uc
    public void hn(com.byazt.pv.uc ucVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("app", "backgrounded", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hw.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, ucVar.ho, ucVar);
        if (this.pr || ucVar == null) {
            return;
        }
        pr(ucVar);
    }

    @Override // com.byazt.mc.uc
    public void x(com.byazt.pv.uc ucVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (this.pr) {
            return;
        }
        this.pr = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("app", "end", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hw.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, ucVar.ho, ucVar);
        pr(ucVar);
    }

    private void pr(com.byazt.pv.uc ucVar) {
        if (ucVar == null) {
            return;
        }
        com.byazt.mn.x.pr(this.hw);
        Iterator<com.byazt.mn.hw> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (!pr()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("lifecycle_id", ucVar.hw());
            jSONObject.putOpt("node_line_name", "app_node_line");
            com.byazt.mn.x.pr(jSONObject, ucVar, this.hw, "app");
        } catch (Throwable th) {
        }
    }
}
