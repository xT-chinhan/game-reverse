package com.byazt.tb;

import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 61})
public class aj implements com.byazt.mc.c {
    public com.byazt.pv.c c;
    public boolean x;
    public List<com.byazt.mn.hw> hn = new CopyOnWriteArrayList();
    public boolean pr = false;
    public com.byazt.wt.pr.hw hw = new com.byazt.wt.pr.hw() { // from class: com.byazt.tb.aj.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (com.byazt.sd.zo.nt().y() || aj.this.pr || aj.this.c == null || aj.this.c.ho == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", aj.this.c.hw());
                jSONObject.putOpt("container_rect", aj.this.c.pr);
                jSONObject.putOpt("image_rect", aj.this.c.hw);
                jSONObject.putOpt("video_rect", aj.this.c.hn);
                if (aj.this.c.x > 0) {
                    jSONObject.putOpt("image_mode", Integer.valueOf(aj.this.c.x));
                }
                jSONObject.putOpt("node_line_name", "view_node_line");
                com.byazt.mn.x.pr(jSONObject, aj.this.c, (List<com.byazt.mn.hw>) aj.this.hn, "view");
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

    private void pr(com.byazt.pv.c cVar) {
        if (this.c == null) {
            this.c = cVar;
        }
        if (pr() && !this.pr) {
            this.c = cVar;
            com.byazt.sd.zo.nt().hn().pr(this.hw);
        }
    }

    @Override // com.byazt.mc.c
    public void pr(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "created", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void hw(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        pr(cVar);
        this.x = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "attached", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void hn(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        pr(cVar);
        this.x = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "focused", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void x(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        pr(cVar);
        this.x = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "visibled", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void c(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        pr(cVar);
        this.x = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "invisibled", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void uc(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        pr(cVar);
        this.x = true;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "detached", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
    }

    @Override // com.byazt.mc.c
    public void fw(com.byazt.pv.c cVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (this.pr) {
            return;
        }
        this.pr = true;
        com.byazt.sd.zo.nt().hn().hw(this.hw);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("view", "end", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, cVar.ho, cVar);
        if (this.x) {
            hw(cVar);
        }
    }

    private void hw(com.byazt.pv.c cVar) {
        if (cVar == null || cVar.ho == null) {
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
            jSONObject.putOpt("lifecycle_id", this.c.hw());
            jSONObject.putOpt("container_rect", this.c.pr);
            jSONObject.putOpt("image_rect", this.c.hw);
            jSONObject.putOpt("video_rect", this.c.hn);
            if (this.c.x > 0) {
                jSONObject.putOpt("image_mode", Integer.valueOf(this.c.x));
            }
            com.byazt.mn.x.pr(this.hn, cVar, "view_node_line", jSONObject);
            com.byazt.mn.x.pr(com.byazt.mn.pr.pr("view") + cVar.hw(), cVar.yb);
        } catch (Throwable th) {
        }
    }
}
