package com.byazt.tb;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 109})
public class w implements com.byazt.mc.fw {
    public com.byazt.pv.zo c;
    public boolean x;
    public List<com.byazt.mn.hw> hn = new CopyOnWriteArrayList();
    public boolean pr = false;
    public com.byazt.wt.pr.hw hw = new com.byazt.wt.pr.hw() { // from class: com.byazt.tb.w.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (com.byazt.sd.zo.nt().y() || w.this.pr || w.this.c == null || w.this.c.ho == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", w.this.c.hw());
                if (!TextUtils.isEmpty(w.this.c.hw)) {
                    jSONObject.putOpt("style_id", w.this.c.hw);
                }
                jSONObject.putOpt("style_category", Integer.valueOf(w.this.c.hn));
                jSONObject.putOpt("component_type", Integer.valueOf(w.this.c.pr));
                jSONObject.putOpt("render_sequence", Integer.valueOf(w.this.c.x));
                jSONObject.putOpt("display_area", Integer.valueOf(w.this.c.c));
                jSONObject.putOpt("node_line_name", "easy_play_node_line");
                com.byazt.mn.x.pr(jSONObject, w.this.c, (List<com.byazt.mn.hw>) w.this.hn, "easy_play");
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

    private void pr(com.byazt.pv.zo zoVar) {
        if (this.c == null) {
            this.c = zoVar;
        }
        if (pr() && !this.pr) {
            this.c = zoVar;
            com.byazt.sd.zo.nt().hn().pr(this.hw);
        }
    }

    @Override // com.byazt.mc.fw
    public void pr(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "created", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void hw(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "started", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void hn(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "loaded", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar2));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void x(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "render_started", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void c(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "rendered", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar2));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void uc(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "showed", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar2));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void fw(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        pr(zoVar);
        this.x = true;
        com.byazt.mn.x.pr(zoVar2);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "clicked", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis());
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
    }

    @Override // com.byazt.mc.fw
    public void zo(com.byazt.pv.zo zoVar, com.byazt.ewt.zo zoVar2) {
        com.byazt.mn.x.pr(zoVar2);
        if (this.pr) {
            return;
        }
        this.pr = true;
        com.byazt.sd.zo.nt().hn().hw(this.hw);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("easy_play", "end", zoVar2 != null ? zoVar2.pr() : System.currentTimeMillis(), com.byazt.mn.x.pr(zoVar2));
        this.hn.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, zoVar.ho, zoVar);
        if (this.x) {
            hw(zoVar);
        }
    }

    private void hw(com.byazt.pv.zo zoVar) {
        if (zoVar == null || zoVar.ho == null) {
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
            if (!TextUtils.isEmpty(this.c.hw)) {
                jSONObject.putOpt("style_id", this.c.hw);
            }
            jSONObject.putOpt("style_category", Integer.valueOf(this.c.hn));
            jSONObject.putOpt("component_type", Integer.valueOf(this.c.pr));
            jSONObject.putOpt("render_sequence", Integer.valueOf(this.c.x));
            jSONObject.putOpt("display_area", Integer.valueOf(this.c.c));
            com.byazt.mn.x.pr(this.hn, zoVar, "easy_play_node_line", jSONObject);
            com.byazt.mn.x.pr(com.byazt.mn.pr.pr("easy_play") + zoVar.hw(), zoVar.yb);
        } catch (Throwable th) {
        }
    }
}
