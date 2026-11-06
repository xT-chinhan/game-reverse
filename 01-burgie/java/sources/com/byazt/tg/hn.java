package com.byazt.tg;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.b;
import com.byazt.hg.m;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.uq.PlayableFeedWebView;
import com.byazt.wt.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 20})
public class hn extends com.byazt.uq.hw {
    public final com.byazt.uq.fw c;
    public PlayableFeedWebView x;

    public hn(of ofVar, com.byazt.uq.pr prVar) {
        super(ofVar, prVar);
        this.c = new com.byazt.uq.fw() { // from class: com.byazt.tg.hn.1
            @Override // com.byazt.uq.fw
            public void pr() {
                if (hn.this.x != null) {
                    hn.this.x.uc();
                }
            }

            @Override // com.byazt.uq.fw
            public void pr(boolean z) {
                if (hn.this.x != null) {
                    hn.this.x.hw(z);
                }
            }

            @Override // com.byazt.uq.fw
            public void hw() {
                if (hn.this.x != null) {
                    hn.this.x.fw();
                }
            }

            @Override // com.byazt.uq.fw
            public void hn() {
                if (hn.this.x != null) {
                    hn.this.x.zo();
                }
            }

            @Override // com.byazt.uq.fw
            public void x() {
                if (b.pr() && hn.this.hn != null) {
                    hn.this.hn.pr(hn.this.pr);
                }
            }

            @Override // com.byazt.uq.fw
            public void c() {
            }

            @Override // com.byazt.uq.fw
            public void pr(int i) {
            }
        };
        this.hn = new com.byazt.fq.pr(ofVar, hw());
    }

    public boolean pr(ViewGroup viewGroup, View view) {
        if (hw() == null || view == null || viewGroup == null) {
            com.byazt.uq.hn.pr(this.pr, hw(), false, 5);
            return false;
        }
        if (!b.x(this.pr)) {
            com.byazt.uq.hn.pr(this.pr, hw(), false, 6);
            return false;
        }
        if (com.byazt.uq.x.pr(viewGroup)) {
            String name = viewGroup.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("container_name", name);
                jSONObject.put("enable_layout_restrict", a.hw().yc());
            } catch (JSONException e) {
            }
            com.byazt.uq.hn.pr(this.pr, hw(), false, 1, jSONObject);
            return false;
        }
        if (com.byazt.uq.x.pr(this.pr, false)) {
            return true;
        }
        com.byazt.uq.hn.pr(this.pr, hw(), false, 2);
        return false;
    }

    public void hw(final ViewGroup viewGroup, final View view) {
        if (!pr(viewGroup, view)) {
            com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(this.pr), 2);
            return;
        }
        com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(this.pr), 1);
        com.byazt.uq.hn.pr(this.pr, hw(), true);
        this.x = new PlayableFeedWebView(this.hn, viewGroup);
        this.hn.pr(this.x);
        this.x.setMaterialMeta(e.pr(this.pr));
        this.x.setEasyPlayableListener(this.hw);
        viewGroup.post(new Runnable() { // from class: com.byazt.tg.hn.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.uq.hn.hw(hn.this.pr, hn.this.hw(), true);
                hn hnVar = hn.this;
                hnVar.pr(viewGroup, view, hnVar.x, (float[]) null);
            }
        });
    }

    public void x() {
        PlayableFeedWebView playableFeedWebView = this.x;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    @Override // com.byazt.uq.hw
    public m hw() {
        return b.zo(this.pr);
    }

    @Override // com.byazt.uq.hw
    public com.byazt.uq.fw pr() {
        return this.c;
    }
}
