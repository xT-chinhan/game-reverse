package com.byazt.dm;

import android.text.TextUtils;
import com.byazt.xvf.l;
import com.byazt.xvf.q;
import com.byazt.xvf.s;
import com.byazt.xvf.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 26})
public class qg implements q {
    public com.byazt.dm.n l;
    public String n;
    public s q;
    public JSONObject qg;
    public Map<String, Object> s;
    public int w;

    @Override // com.byazt.xvf.q
    public w qg() {
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 48})
    public static class n {
        public JSONObject fs;
        public JSONObject l;
        public int n;
        public String q;
        public String qg;
        public String s;
        public Map<String, Object> w;
        public s x;

        public n(String str) {
            this.qg = str;
            this.n = 1;
        }

        public n(String str, int i) {
            this.n = i;
            if (i == 3) {
                this.q = str;
            } else if (i == 2) {
                this.s = str;
            }
        }

        public n n(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public n n(Map<String, Object> map) {
            this.w = map;
            return this;
        }

        public n n(s sVar) {
            this.x = sVar;
            return this;
        }

        public n qg(JSONObject jSONObject) {
            this.fs = jSONObject;
            return this;
        }

        public qg n() {
            return new qg(this);
        }
    }

    private qg(n nVar) {
        this.w = 1;
        this.w = nVar.n;
        if (nVar.n != 2) {
            if (nVar.n != 3) {
                this.n = nVar.qg;
                if (nVar.fs != null) {
                    com.byazt.fm.qg.INSTANCE.n(nVar.fs);
                }
            } else {
                this.l = new com.byazt.dm.n(nVar.q, 3, nVar.l, nVar.w);
            }
        } else {
            this.l = new com.byazt.dm.n(nVar.s, 2, nVar.l, nVar.w);
        }
        this.qg = nVar.l;
        this.s = nVar.w;
        this.q = nVar.x;
    }

    public void n() {
        com.byazt.fm.s sVarN;
        int i = this.w;
        if (i == 2 || i == 3) {
            s sVar = this.q;
            if (sVar != null) {
                sVar.n(this.l);
            }
            this.l.x();
            return;
        }
        if (TextUtils.isEmpty(this.n) || (sVarN = com.byazt.fm.qg.INSTANCE.n(this.n)) == null) {
            return;
        }
        n(sVarN.qg(), this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.fm.n nVar, Map<String, Object> map) {
        if (nVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.byazt.dm.n nVar2 = new com.byazt.dm.n(nVar, this.qg, map);
        nVar2.n(this.n);
        nVar2.n(this);
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(nVar2);
        }
        List<com.byazt.fm.n> listS = com.byazt.fm.qg.INSTANCE.n(this.n).s(nVar, nVar2.s(), map);
        if (!listS.isEmpty()) {
            nVar2.n(true);
        }
        nVar2.x();
        for (com.byazt.fm.n nVar3 : listS) {
            if (nVar3 != null) {
                n(nVar3, map);
            }
        }
    }

    @Override // com.byazt.xvf.q
    public l s() {
        return new l() { // from class: com.byazt.dm.qg.1
            @Override // com.byazt.xvf.l
            public void n(com.byazt.dm.n nVar, Map<String, Object> map) {
                List<com.byazt.fm.n> listN = com.byazt.fm.qg.INSTANCE.n(qg.this.n).n(nVar.fs(), nVar.s(), map);
                if (!nVar.w() && listN.isEmpty()) {
                    qg.this.q();
                }
                Iterator<com.byazt.fm.n> it = listN.iterator();
                while (it.hasNext()) {
                    qg.this.n(it.next(), map);
                }
            }

            @Override // com.byazt.xvf.l
            public void n(com.byazt.dm.n nVar, Map<String, Object> map, com.byazt.bds.n nVar2) {
                List<com.byazt.fm.n> listQg = com.byazt.fm.qg.INSTANCE.n(qg.this.n).qg(nVar.fs(), nVar.s(), map);
                if (!nVar.w() && listQg.isEmpty()) {
                    qg.this.q();
                }
                Iterator<com.byazt.fm.n> it = listQg.iterator();
                while (it.hasNext()) {
                    qg.this.n(it.next(), map);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(this);
        }
    }
}
