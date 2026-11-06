package com.byazt.lu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 50})
public class vk extends pr {
    public final List<com.byazt.jw.pr> nl;
    public int y;

    public vk(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = new ArrayList();
        this.y = 0;
    }

    public static boolean pr(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        return ve.pr(ofVar);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        com.byazt.xt.vk vkVar = new com.byazt.xt.vk(this.pr, this.hw, z);
        vkVar.pr(new float[]{this.c, this.uc});
        this.aj = vkVar;
        return this.aj;
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        FrameLayout frameLayout = new FrameLayout(this.pr);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    private com.byazt.xt.vk cr() {
        if (this.aj instanceof com.byazt.xt.vk) {
            return (com.byazt.xt.vk) this.aj;
        }
        return null;
    }

    @Override // com.byazt.lu.pr
    public void fo() {
        ((com.byazt.xt.vk) this.aj).hn();
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return false;
    }

    @Override // com.byazt.lu.pr
    public boolean uc() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.lb.pr(false);
        this.lb.hw(false);
        this.lb.c(false);
    }

    @Override // com.byazt.lu.pr
    public void g() {
        super.g();
        ((com.byazt.xt.vk) this.aj).hw();
    }

    @Override // com.byazt.lu.pr
    public void hw(boolean z) {
        super.hw(z);
        ((com.byazt.xt.vk) this.aj).hn();
    }

    @Override // com.byazt.lu.pr
    public void zo() {
        super.zo();
        com.byazt.jw.pr prVar = new com.byazt.jw.pr(this.pr, this.hw, this.k, lv(), true);
        prVar.pr(this.m);
        this.nl.add(prVar);
        if (!ve.hn(this.hw)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hw.kq());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(com.byazt.sd.pr.pr(jSONArray.getJSONObject(i)));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.hw);
            arrayList2.addAll(arrayList);
            if (!ve.pr(arrayList2)) {
                return;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.byazt.jw.pr prVar2 = new com.byazt.jw.pr(this.pr, (of) arrayList.get(i2), this.k, lv(), false);
                prVar2.pr(this.m);
                this.nl.add(prVar2);
            }
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public void hn() {
        this.aj.hn(true);
        if (cr() != null) {
            cr().pr(this.nl);
        }
        this.pr.hw(false, true);
    }

    @Override // com.byazt.lu.pr
    public void z() {
        super.z();
        if (this.aj instanceof com.byazt.xt.vk) {
            ((com.byazt.xt.vk) this.aj).vk();
        }
    }

    @Override // com.byazt.lu.pr
    public int v() {
        return o.hn(this.hw) - this.y;
    }

    @Override // com.byazt.lu.pr
    public void e() {
        super.e();
        if (this.aj instanceof com.byazt.xt.vk) {
            ((com.byazt.xt.vk) this.aj).x();
        }
    }

    @Override // com.byazt.lu.pr
    public int fw(boolean z) {
        if (z) {
            return v();
        }
        return o.fw(this.hw) - this.y;
    }

    @Override // com.byazt.lu.pr
    public int qn() {
        return this.y;
    }

    @Override // com.byazt.lu.pr
    public void c(boolean z) {
        super.c(z);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.wv.hw.pr pr(of ofVar, final com.byazt.wv.vk vkVar) {
        this.pr.qn();
        com.byazt.wv.c cVar = new com.byazt.wv.c(this.pr, ofVar);
        cVar.pr(qi());
        return cVar.hw(new com.byazt.wv.vk() { // from class: com.byazt.lu.vk.1
            @Override // com.byazt.wv.vk
            public void pr() {
                super.pr();
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
                vk.this.pr.of();
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hw();
                }
            }

            @Override // com.byazt.wv.vk
            public void hn() {
                super.hn();
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hn();
                }
                vk.this.pr.of();
                vk.this.pr.f().pr("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.lu.pr
    public void nt() {
        super.nt();
        this.aj.vk();
        List<com.byazt.jw.pr> list = this.nl;
        if (list != null) {
            Iterator<com.byazt.jw.pr> it = list.iterator();
            while (it.hasNext()) {
                it.next().zo();
            }
        }
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 11;
    }

    @Override // com.byazt.lu.pr
    public void pr(Map<String, Object> map) {
        super.pr(map);
        map.put("refresh_num", Integer.valueOf(j()));
    }

    @Override // com.byazt.lu.pr
    public void pr(JSONObject jSONObject) {
        super.pr(jSONObject);
        try {
            jSONObject.put("refresh_num", j());
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.lu.pr
    public void hw(Map<String, Object> map) {
        super.hw(map);
        map.put("refresh_num", Integer.valueOf(j()));
    }

    @Override // com.byazt.lu.pr
    public void pr(View view) {
        super.pr(view);
    }

    @Override // com.byazt.lu.pr
    public void ny() {
        ((com.byazt.xt.vk) this.aj).hw();
    }

    private int j() {
        int iC;
        com.byazt.jw.pr prVar;
        of ofVarPr;
        ve veVarSb;
        com.byazt.xt.vk vkVar = (com.byazt.xt.vk) this.aj;
        if (vkVar == null || (iC = vkVar.c()) < 0 || iC >= this.nl.size() || (prVar = this.nl.get(iC)) == null || (ofVarPr = prVar.pr()) == null || (veVarSb = ofVarPr.sb()) == null) {
            return 0;
        }
        return veVarSb.hn();
    }

    public void aa() {
        ((com.byazt.xt.vk) this.aj).x();
    }

    public void iy() {
        ((com.byazt.xt.vk) this.aj).uc();
    }
}
