package com.byazt.le;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.ch.nt;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.uc;
import com.byazt.hg.x;
import com.byazt.jx.zo;
import com.byazt.sa.c;
import com.byazt.sa.fw;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 953, 37})
public class pr implements hw.pr {
    public com.byazt.ik.hn aj;
    public int c;
    public Activity fw;
    public com.byazt.hd.hw g;
    public com.byazt.ql.pr hn;
    public com.byazt.hl.hw ho;
    public hw hw;
    public x k;
    public String m;
    public com.byazt.mm.pr nt;
    public of pr;
    public com.byazt.pj.x uc;
    public com.byazt.nv.hn vk;
    public JSONObject w;
    public String x;
    public com.byazt.nv.pr yb = new com.byazt.nv.pr() { // from class: com.byazt.le.pr.1
        @Override // com.byazt.nv.pr
        public void pr() {
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.nv.pr
        public void hw(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.nv.pr
        public void hn(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, String str, String str2) {
        }

        @Override // com.byazt.nv.pr
        public void pr(String str, String str2) {
        }
    };
    public ViewGroup zo;

    public pr(Activity activity, ViewGroup viewGroup, com.byazt.pj.x xVar, of ofVar, String str, int i, com.byazt.mm.pr prVar) {
        this.pr = ofVar;
        this.fw = activity;
        this.uc = xVar;
        this.zo = viewGroup;
        this.x = str;
        this.c = i;
        this.nt = prVar;
    }

    public void pr(com.byazt.ql.pr prVar) {
        this.hn = prVar;
    }

    public void pr() {
        this.hw = new hw(this.fw, this.uc, this.x, this.c);
        if (this.pr.jn() != null) {
            try {
                hw(new JSONObject(this.pr.jn().toString()));
                return;
            } catch (JSONException e) {
                return;
            }
        }
        int iIe = this.pr.ie();
        if (iIe == 5 || iIe == 4) {
            hw(new JSONObject());
        } else {
            com.byazt.pk.hn.pr(this.pr.nw(), new com.byazt.pk.hn.pr() { // from class: com.byazt.le.pr.2
                @Override // com.byazt.pk.hn.pr
                public void pr(JSONObject jSONObject) {
                    pr.this.hw(jSONObject);
                }

                @Override // com.byazt.pk.hn.pr
                public void pr(int i, String str) {
                    pr.this.uc.pr(-3, "ad meta info load fail");
                    if (pr.this.hn != null) {
                        pr.this.hn.pr(-3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(JSONObject jSONObject) {
        this.w = jSONObject;
        x(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(final JSONObject jSONObject) {
        c.pr(this.pr.o(), "lp_" + this.pr.ie(), this.pr.f(), new c.pr() { // from class: com.byazt.le.pr.3
            @Override // com.byazt.sa.c.pr
            public void pr(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    pr.this.uc.pr(-1, "template info load fail");
                    if (pr.this.hn != null) {
                        pr.this.hn.pr(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put(ProviderInteractionViews.ROLE_CREATIVE, pr.this.pr.to());
                    pr.this.pr(jSONObject);
                    pr.this.pr(jSONObject2, jSONObject);
                } catch (JSONException e) {
                }
            }
        });
    }

    public void pr(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject, JSONObject jSONObject2) {
        this.uc.hw();
        this.hw.pr(this);
        this.hw.pr(jSONObject, jSONObject2, new fw() { // from class: com.byazt.le.pr.4
            @Override // com.byazt.sa.fw
            public void pr(int i, String str) {
                if (pr.this.hn != null) {
                    pr.this.hn.pr(i);
                }
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                pr.this.aj = hnVar;
                pr.this.zo.addView(hnVar.aj(), new FrameLayout.LayoutParams(hnVar.e(), hnVar.s()));
                if (pr.this.hn != null) {
                    pr.this.hn.pr(hnVar.aj());
                }
                pr.this.c();
                pr.this.pr(hnVar);
            }
        });
    }

    public void pr(com.byazt.ik.hn<View> hnVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        of ofVar = this.pr;
        if (ofVar != null && qv.vk(ofVar) == 200) {
            com.byazt.ik.hn hnVarX = this.aj.x("video");
            if (hnVarX instanceof com.byazt.hd.hw) {
                com.byazt.hd.hw hwVar = (com.byazt.hd.hw) hnVarX;
                this.g = hwVar;
                hwVar.c(true);
                aj();
            }
            com.byazt.ik.hn hnVarX2 = this.aj.x("mute");
            if (hnVarX2 instanceof com.byazt.hl.hw) {
                this.ho = (com.byazt.hl.hw) hnVarX2;
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
                shapeDrawable.setIntrinsicWidth(er.hn(this.fw, 28.0f));
                shapeDrawable.setIntrinsicHeight(er.hn(this.fw, 28.0f));
                this.ho.aj().setBackground(shapeDrawable);
            }
            com.byazt.mm.pr prVar = this.nt;
            if (prVar != null) {
                pr(prVar.zo);
            } else {
                pr(true);
            }
        }
    }

    private void pr(boolean z) {
        com.byazt.hd.hw hwVar = this.g;
        if (hwVar != null) {
            hwVar.x(z);
        }
        com.byazt.hl.hw hwVar2 = this.ho;
        if (hwVar2 != null && hwVar2.aj() != null) {
            g.pr((Context) this.fw, z ? "tt_mute" : "tt_unmute", (ImageView) this.ho.aj(), MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private void x(final JSONObject jSONObject) {
        if (this.k != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.k.zo());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put("app", jSONObject2);
                hn(jSONObject);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        String strUc = uc();
        this.m = strUc;
        if (TextUtils.isEmpty(strUc)) {
            com.byazt.ql.pr prVar = this.hn;
            if (prVar != null) {
                prVar.pr(-4);
                return;
            }
            return;
        }
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("tt_pl_download_check") { // from class: com.byazt.le.pr.5
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3;
                pr.this.k = a.pr().pr(pr.this.pr, pr.this.m);
                try {
                    if (pr.this.k != null) {
                        jSONObject3 = new JSONObject(pr.this.k.zo());
                    } else if (pr.this.pr.xy() != null) {
                        jSONObject3 = new JSONObject(pr.this.pr.xy());
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    jSONObject3.put("is_support_func_desc", "true");
                    jSONObject.put("app", jSONObject3);
                    jSONObject3.put("download_url", pr.this.m);
                    pr.this.hn(jSONObject);
                } catch (Throwable th2) {
                }
            }
        });
    }

    @Override // com.byazt.le.hw.pr
    public void pr(nt ntVar) {
        JSONObject jSONObjectHn;
        com.byazt.hd.hw hwVar;
        if (ntVar == null || ntVar.hw() != 1 || (jSONObjectHn = ntVar.hn()) == null) {
            return;
        }
        switch (jSONObjectHn.optString("type")) {
            case "downloadDirect":
                hn(hw(ntVar));
                break;
            case "downloadEvent":
                hw(true);
                x(hw(ntVar));
                break;
            case "openAppFunctionDesc":
                hn(this.pr);
                break;
            case "openAppPermission":
                pr(this.pr);
                break;
            case "openAppPolicy":
                hw(this.pr);
                break;
            case "openInfringement":
                com.byazt.wt.c.pr(this.fw, this.x, this.pr);
                break;
            case "muteVideo":
                if (this.ho != null && (hwVar = this.g) != null) {
                    pr(!hwVar.zo());
                    break;
                }
                break;
            case "clickVideo":
                com.byazt.hd.hw hwVar2 = this.g;
                if (hwVar2 != null) {
                    hwVar2.d();
                    break;
                }
                break;
        }
    }

    private void hw(boolean z) {
        zo();
        com.byazt.nv.hn hnVar = this.vk;
        if (hnVar instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVar).fw().pr(z);
        }
    }

    private void hn(boolean z) {
        hw(false);
        x(z);
    }

    private boolean hw(nt ntVar) {
        if (ntVar == null) {
            return false;
        }
        View viewAj = ntVar.pr().aj();
        if (!(viewAj instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewAj).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    private void pr(of ofVar) {
        String strXy;
        if (ofVar == null) {
            return;
        }
        if (this.k != null) {
            uc ucVarLb = ofVar.lb();
            if (ucVarLb != null) {
                this.k.pr(ucVarLb.x());
                this.k.pr(ucVarLb.hn());
            }
            strXy = this.k.zo();
        } else {
            strXy = ofVar.xy();
        }
        Activity activity = this.fw;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).k();
        }
        com.byazt.wt.c.pr(this.fw, ofVar.x(), strXy, new com.byazt.wt.c.pr() { // from class: com.byazt.le.pr.6
            @Override // com.byazt.wt.c.pr
            public void pr() {
                pr.this.x(true);
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }
        });
    }

    private void hw(of ofVar) {
        String strXy;
        if (ofVar == null) {
            return;
        }
        if (this.k != null) {
            uc ucVarLb = ofVar.lb();
            if (ucVarLb != null) {
                this.k.pr(ucVarLb.x());
                this.k.pr(ucVarLb.hn());
            }
            strXy = this.k.zo();
        } else {
            strXy = ofVar.xy();
        }
        Activity activity = this.fw;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).k();
        }
        com.byazt.wt.c.pr(this.fw, ofVar.x(), new com.byazt.wt.c.pr() { // from class: com.byazt.le.pr.7
            @Override // com.byazt.wt.c.pr
            public void pr() {
                pr.this.x(true);
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }
        }, strXy);
    }

    private void hn(of ofVar) {
        String strAj;
        if (ofVar == null) {
            return;
        }
        uc ucVarLb = ofVar.lb();
        x xVar = this.k;
        if (xVar != null) {
            strAj = xVar.c();
        } else {
            strAj = ucVarLb == null ? "" : ucVarLb.aj();
        }
        com.byazt.wt.c.hw(this.fw, strAj, ofVar.x(), new com.byazt.wt.c.pr() { // from class: com.byazt.le.pr.8
            @Override // com.byazt.wt.c.pr
            public void pr() {
                pr.this.x(true);
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                if (pr.this.fw instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) pr.this.fw).m();
                }
            }
        });
    }

    private String uc() {
        JSONObject jSONObject = this.w;
        if (jSONObject == null) {
            return fw();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return fw();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return fw();
        }
        String strOptString = jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL);
        if (TextUtils.isEmpty(strOptString)) {
            return fw();
        }
        return strOptString;
    }

    private String fw() {
        return ls.a(this.pr);
    }

    private void zo() {
        if (this.vk == null) {
            com.byazt.nv.hn hnVarPr = zo.pr(this.fw, this.m, this.pr, this.x);
            this.vk = hnVarPr;
            hnVarPr.pr(com.byazt.ri.c.pr(this.pr));
            this.vk.pr(this.yb, false);
            this.vk.pr(false);
        }
        this.vk.pr(this.fw, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        zo();
        com.byazt.az.pr prVar = new com.byazt.az.pr(this.fw, this.pr, "embeded_ad_landingpage", this.c);
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).hn(true);
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(true);
        this.vk.hw(z);
        this.vk.pr(this.pr, false);
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(this.vk);
        this.vk.pr(ls.fo(this.pr), false);
    }

    public void hw() {
        com.byazt.hd.hw hwVar = this.g;
        if (hwVar != null) {
            hwVar.vj();
        }
    }

    private void aj() {
        com.byazt.hd.hw hwVar = this.g;
        if (hwVar != null) {
            hwVar.pr(this.nt);
        }
    }

    public void hn() {
        com.byazt.nv.hn hnVar = this.vk;
        if (hnVar != null) {
            hnVar.hw();
        }
        com.byazt.hd.hw hwVar = this.g;
        if (hwVar != null) {
            hwVar.od();
        }
    }

    public void x() {
        com.byazt.nv.hn hnVar = this.vk;
        if (hnVar != null) {
            hnVar.hn();
        }
    }
}
