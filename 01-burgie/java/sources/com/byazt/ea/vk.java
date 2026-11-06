package com.byazt.ea;

import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 50})
public class vk extends com.byazt.ef.hw {
    public volatile pr uc;

    public vk(lb lbVar) {
        super(lbVar);
    }

    @Override // com.byazt.ef.hw
    public void hn(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        if (this.uc == null) {
            this.uc = hw();
        }
        this.uc.pr(ntVar);
        this.uc.pr(hwVar);
        this.uc.pr(prVar);
        JSONObject jSONObjectHn = ntVar.hn();
        if (jSONObjectHn == null) {
            return;
        }
        com.byazt.lx.hw.pr(jSONObjectHn.optString("type"), (JSONObject) null, (Map<String, Object>) null, new com.byazt.kr.hn() { // from class: com.byazt.ea.vk.1
            @Override // com.byazt.kr.hn
            public void pr(com.byazt.hws.pr prVar2) {
                vk.this.pr(prVar2);
            }
        }, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.hws.pr prVar) {
        if (this.c) {
            return;
        }
        pr prVarHw = hw();
        prVarHw.pr(pr(prVarHw.hn, prVar));
        prVar.pr(prVarHw);
    }

    public nt pr(nt ntVar, com.byazt.hws.pr prVar) {
        com.byazt.re.pr prVar2;
        if (ntVar == null || prVar == null) {
            return ntVar;
        }
        nt ntVar2 = new nt();
        com.byazt.ik.hn hnVarPr = ntVar.pr();
        if (hnVarPr == null) {
            return ntVar;
        }
        ntVar2.pr(ntVar.hw());
        com.byazt.re.pr prVarZo = prVar.zo();
        JSONObject jSONObjectPr = pr(hnVarPr, ntVar2, prVarZo);
        com.byazt.re.hn hnVarPr2 = com.byazt.re.hw.INSTANCE.pr(prVar.x());
        List<com.byazt.re.pr> listPr = hnVarPr2.pr(prVarZo, hnVarPr.vk(), new HashMap());
        ntVar2.pr(jSONObjectPr);
        if (!listPr.isEmpty()) {
            com.byazt.re.pr prVar3 = listPr.get(0);
            if (prVar3 == null) {
                return ntVar2;
            }
            nt ntVar3 = new nt();
            ntVar3.pr(pr(hnVarPr, ntVar3, prVar3));
            ntVar3.pr(hnVarPr);
            ntVar2.pr(ntVar3);
        }
        List<com.byazt.re.pr> listHw = hnVarPr2.hw(prVarZo, hnVarPr.vk(), new HashMap());
        if (listHw.isEmpty() || (prVar2 = listHw.get(0)) == null) {
            return ntVar2;
        }
        nt ntVar4 = new nt();
        ntVar4.pr(pr(hnVarPr, ntVar4, prVar2));
        ntVar4.pr(hnVarPr);
        ntVar2.hw(ntVar4);
        return ntVar2;
    }

    private JSONObject pr(com.byazt.ik.hn hnVar, nt ntVar, com.byazt.re.pr prVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (prVar == null) {
                return jSONObject;
            }
            Map<String, String> mapUc = prVar.uc();
            String strPr = prVar.pr();
            ntVar.pr(hnVar);
            jSONObject.put("type", strPr);
            if (mapUc != null && !mapUc.isEmpty()) {
                for (Map.Entry<String, String> entry : mapUc.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    private pr hw() {
        if (this.uc != null) {
            return this.uc;
        }
        synchronized (pr.class) {
            if (this.uc != null) {
                return this.uc;
            }
            this.uc = new pr();
            return this.uc;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 590})
    class pr implements com.byazt.kr.hw {
        public nt hn;
        public lb.pr pr;
        public lb.hw x;

        public pr() {
        }

        public void pr(nt ntVar) {
            this.hn = ntVar;
        }

        public void pr(lb.hw hwVar) {
            this.x = hwVar;
        }

        public void pr(lb.pr prVar) {
            this.pr = prVar;
        }

        @Override // com.byazt.kr.hw
        public void pr() {
            vk.this.hw(this.hn, this.x, this.pr);
        }
    }
}
