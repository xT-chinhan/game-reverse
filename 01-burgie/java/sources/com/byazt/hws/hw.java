package com.byazt.hws;

import android.text.TextUtils;
import com.byazt.kr.c;
import com.byazt.kr.hn;
import com.byazt.kr.uc;
import com.byazt.kr.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 13})
public class hw implements x {
    public com.byazt.hws.pr c;
    public Map<String, Object> hn;
    public JSONObject hw;
    public String pr;
    public int uc;
    public hn x;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public JSONObject c;
        public hn fw;
        public String hn;
        public String hw;
        public int pr;
        public Map<String, Object> uc;
        public String x;
        public JSONObject zo;

        public pr(String str) {
            this.pr = 1;
            this.hw = str;
            this.pr = 1;
        }

        public pr(String str, int i) {
            this.pr = 1;
            this.pr = i;
            if (i == 3) {
                this.x = str;
            } else if (i == 2) {
                this.hn = str;
            }
        }

        public pr pr(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public pr pr(Map<String, Object> map) {
            this.uc = map;
            return this;
        }

        public pr pr(hn hnVar) {
            this.fw = hnVar;
            return this;
        }

        public pr hw(JSONObject jSONObject) {
            this.zo = jSONObject;
            return this;
        }

        public hw pr() {
            return new hw(this);
        }
    }

    private hw(pr prVar) {
        this.uc = 1;
        this.uc = prVar.pr;
        if (prVar.pr != 2) {
            if (prVar.pr != 3) {
                this.pr = prVar.hw;
                if (prVar.zo != null) {
                    com.byazt.re.hw.INSTANCE.pr(prVar.zo);
                }
            } else {
                this.c = new com.byazt.hws.pr(prVar.x, 3, prVar.c, prVar.uc);
            }
        } else {
            this.c = new com.byazt.hws.pr(prVar.hn, 2, prVar.c, prVar.uc);
        }
        this.hw = prVar.c;
        this.hn = prVar.uc;
        this.x = prVar.fw;
    }

    public void pr() {
        com.byazt.re.hn hnVarPr;
        int i = this.uc;
        if (i == 2 || i == 3) {
            hn hnVar = this.x;
            if (hnVar != null) {
                hnVar.pr(this.c);
            }
            this.c.fw();
            return;
        }
        if (TextUtils.isEmpty(this.pr) || (hnVarPr = com.byazt.re.hw.INSTANCE.pr(this.pr)) == null) {
            return;
        }
        pr(hnVarPr.hw(), this.hn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.re.pr prVar, Map<String, Object> map) {
        if (prVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.byazt.hws.pr prVar2 = new com.byazt.hws.pr(prVar, this.hw, map);
        prVar2.pr(this.pr);
        prVar2.pr(this);
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr(prVar2);
        }
        List<com.byazt.re.pr> listHn = com.byazt.re.hw.INSTANCE.pr(this.pr).hn(prVar, prVar2.hn(), map);
        if (!listHn.isEmpty()) {
            prVar2.pr(true);
        }
        prVar2.fw();
        for (com.byazt.re.pr prVar3 : listHn) {
            if (prVar3 != null) {
                pr(prVar3, map);
            }
        }
    }

    @Override // com.byazt.kr.x
    public uc hw() {
        return null;
    }

    @Override // com.byazt.kr.x
    public c hn() {
        return new c() { // from class: com.byazt.hws.hw.1
            @Override // com.byazt.kr.c
            public void pr(com.byazt.hws.pr prVar, Map<String, Object> map) {
                List<com.byazt.re.pr> listPr = com.byazt.re.hw.INSTANCE.pr(hw.this.pr).pr(prVar.zo(), prVar.hn(), map);
                if (!prVar.uc()) {
                    listPr.isEmpty();
                }
                Iterator<com.byazt.re.pr> it = listPr.iterator();
                while (it.hasNext()) {
                    hw.this.pr(it.next(), map);
                }
            }

            @Override // com.byazt.kr.c
            public void pr(com.byazt.hws.pr prVar, Map<String, Object> map, com.byazt.rs.pr prVar2) {
                List<com.byazt.re.pr> listHw = com.byazt.re.hw.INSTANCE.pr(hw.this.pr).hw(prVar.zo(), prVar.hn(), map);
                if (!prVar.uc()) {
                    listHw.isEmpty();
                }
                Iterator<com.byazt.re.pr> it = listHw.iterator();
                while (it.hasNext()) {
                    hw.this.pr(it.next(), map);
                }
            }
        };
    }
}
