package com.byazt.tb;

import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 62})
public class fw implements com.byazt.mc.x {
    public com.byazt.pv.x x;
    public List<com.byazt.mn.hw> hn = new CopyOnWriteArrayList();
    public boolean pr = false;
    public com.byazt.wt.pr.hw hw = new com.byazt.wt.pr.hw() { // from class: com.byazt.tb.fw.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (com.byazt.sd.zo.nt().y() || fw.this.pr || fw.this.x == null || fw.this.x.ho == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", fw.this.x.hw());
                jSONObject.putOpt("video_type", Integer.valueOf(fw.this.x.pr));
                jSONObject.putOpt("node_line_name", "video_node_line");
                com.byazt.mn.x.pr(jSONObject, fw.this.x, (List<com.byazt.mn.hw>) fw.this.hn, "video");
            } catch (Throwable th) {
            }
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
        }

        @Override // com.byazt.wt.pr.hw
        public void hn() {
        }

        @Override // com.byazt.wt.pr.hw
        public void x() {
        }
    };

    private boolean pr() {
        return a.hw().hh();
    }

    private void pr(com.byazt.pv.x xVar) {
        if (this.x == null) {
            this.x = xVar;
        }
        if (pr() && !this.pr) {
            this.x = xVar;
            com.byazt.sd.zo.nt().hn().pr(this.hw);
        }
    }

    @Override // com.byazt.mc.x
    public void pr(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "created", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void hw(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "initialized", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void hn(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "started", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void x(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "prepared", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void c(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "played", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void uc(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "buffered", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void fw(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "paused", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void zo(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "stopped", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void aj(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        pr(xVar);
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "completed", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
    }

    @Override // com.byazt.mc.x
    public void vk(com.byazt.pv.x xVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (this.pr) {
            return;
        }
        this.pr = true;
        com.byazt.sd.zo.nt().hn().hw(this.hw);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("video", "end", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, xVar.ho, xVar);
        hw(xVar);
    }

    private void hw(com.byazt.pv.x xVar) {
        if (xVar == null || xVar.ho == null) {
            return;
        }
        com.byazt.mn.x.pr(this.hn);
        Iterator<com.byazt.mn.hw> it = this.hn.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (!pr()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("lifecycle_id", this.x.hw());
            jSONObject.putOpt("video_type", Integer.valueOf(this.x.pr));
            com.byazt.mn.x.pr(this.hn, xVar, "video_node_line", jSONObject);
            com.byazt.mn.x.pr(com.byazt.mn.pr.pr("video") + xVar.hw(), xVar.hn());
        } catch (Throwable th) {
        }
    }
}
