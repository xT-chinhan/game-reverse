package com.byazt.fj;

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
import com.anythink.core.common.f.a;
import com.byazt.gct.pk;
import com.byazt.gct.q;
import com.byazt.gct.ta;
import com.byazt.gct.w;
import com.byazt.iz.fs;
import com.byazt.nf.rv;
import com.byazt.ozc.l;
import com.byazt.ozc.x;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.tk.sz;
import com.byazt.vh.cy;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 695, 19})
public class n implements qg.n {
    public JSONObject cp;
    public com.byazt.cs.n cy;
    public q d;
    public ViewGroup fs;
    public AppDownloadListener hd = new AppDownloadListener() { // from class: com.byazt.fj.n.1
        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onIdle() {
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onInstalled(String str, String str2) {
        }
    };
    public com.byazt.jm.s k;
    public int l;
    public pk n;
    public String oa;
    public String q;
    public qg qg;
    public com.byazt.ih.s rv;
    public com.byazt.au.n s;
    public com.byazt.kx.qg sz;
    public ITTInnerDownloadAdapter tj;
    public com.byazt.hm.q w;
    public Activity x;

    public void n(com.byazt.ih.s<View> sVar) {
    }

    public void n(JSONObject jSONObject) {
    }

    public n(Activity activity, ViewGroup viewGroup, com.byazt.hm.q qVar, pk pkVar, String str, int i, com.byazt.cs.n nVar) {
        this.n = pkVar;
        this.x = activity;
        this.w = qVar;
        this.fs = viewGroup;
        this.q = str;
        this.l = i;
        this.cy = nVar;
    }

    public void n(com.byazt.au.n nVar) {
        this.s = nVar;
    }

    public void n() {
        this.qg = new qg(this.x, this.w, this.q, this.l);
        if (this.n.hf() != null) {
            try {
                qg(new JSONObject(this.n.hf().toString()));
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        int iCx = this.n.cx();
        if (iCx == 5 || iCx == 4) {
            qg(new JSONObject());
        } else {
            com.byazt.jc.q.n(this.n.yw(), new com.byazt.jc.q.n() { // from class: com.byazt.fj.n.2
                @Override // com.byazt.jc.q.n
                public void n(JSONObject jSONObject) {
                    n.this.qg(jSONObject);
                }

                @Override // com.byazt.jc.q.n
                public void n(int i, String str) {
                    n.this.w.n(-3, "ad meta info load fail");
                    if (n.this.s != null) {
                        n.this.s.n(-3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject) {
        this.cp = jSONObject;
        q(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final JSONObject jSONObject) {
        l.n(this.n.lq(), "lp_" + this.n.cx(), this.n.ic(), new l.n() { // from class: com.byazt.fj.n.3
            @Override // com.byazt.ozc.l.n
            public void n(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    n.this.w.n(-1, "template info load fail");
                    if (n.this.s != null) {
                        n.this.s.n(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", n.this.n.pv());
                    n.this.n(jSONObject);
                    n.this.n(jSONObject2, jSONObject);
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, JSONObject jSONObject2) {
        this.w.qg();
        this.qg.n(this);
        this.qg.n(jSONObject, jSONObject2, new x() { // from class: com.byazt.fj.n.4
            @Override // com.byazt.ozc.x
            public void n(int i, String str) {
                if (n.this.s != null) {
                    n.this.s.n(i);
                }
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                n.this.rv = sVar;
                n.this.fs.addView(sVar.rv(), new FrameLayout.LayoutParams(sVar.an(), sVar.ae()));
                if (n.this.s != null) {
                    n.this.s.n(sVar.rv());
                }
                n.this.l();
                n.this.n(sVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        pk pkVar = this.n;
        if (pkVar == null || ta.tj(pkVar) != 200) {
            return;
        }
        com.byazt.ih.s sVarQ = this.rv.q(MediaFormat.KEY_VIDEO);
        if (sVarQ instanceof com.byazt.kx.qg) {
            com.byazt.kx.qg qgVar = (com.byazt.kx.qg) sVarQ;
            this.sz = qgVar;
            qgVar.l(true);
            rv();
        }
        com.byazt.ih.s sVarQ2 = this.rv.q("mute");
        if (sVarQ2 instanceof com.byazt.jm.s) {
            this.k = (com.byazt.jm.s) sVarQ2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(com.byazt.okk.s.s(this.x, 28.0f));
            shapeDrawable.setIntrinsicHeight(com.byazt.okk.s.s(this.x, 28.0f));
            this.k.rv().setBackground(shapeDrawable);
        }
        com.byazt.cs.n nVar = this.cy;
        if (nVar != null) {
            n(nVar.fs);
        } else {
            n(true);
        }
    }

    private void n(boolean z) {
        com.byazt.kx.qg qgVar = this.sz;
        if (qgVar != null) {
            qgVar.q(z);
        }
        com.byazt.jm.s sVar = this.k;
        if (sVar == null || sVar.rv() == null) {
            return;
        }
        sz.n((Context) this.x, z ? "tt_mute" : "tt_unmute", (ImageView) this.k.rv(), MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    private void q(final JSONObject jSONObject) {
        if (this.d != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.d.fs());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put(a.C0017a.c, jSONObject2);
                s(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String strW = w();
        this.oa = strW;
        if (TextUtils.isEmpty(strW)) {
            com.byazt.au.n nVar = this.s;
            if (nVar != null) {
                nVar.n(-4);
                return;
            }
            return;
        }
        com.byazt.qit.l.qg(new com.byazt.qit.x("tt_pl_download_check") { // from class: com.byazt.fj.n.5
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3;
                n.this.d = rv.n().n(n.this.n, n.this.oa);
                try {
                    if (n.this.d != null) {
                        jSONObject3 = new JSONObject(n.this.d.fs());
                    } else if (n.this.n.nn() != null) {
                        jSONObject3 = new JSONObject(n.this.n.nn());
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    jSONObject3.put("is_support_func_desc", "true");
                    jSONObject.put(a.C0017a.c, jSONObject3);
                    jSONObject3.put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, n.this.oa);
                    n.this.s(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    @Override // com.byazt.fj.qg.n
    public void n(cy cyVar) {
        JSONObject jSONObjectS;
        com.byazt.kx.qg qgVar;
        if (cyVar == null || cyVar.qg() != 1 || (jSONObjectS = cyVar.s()) == null) {
            return;
        }
        String strOptString = jSONObjectS.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                n(this.n);
                break;
            case "clickVideo":
                com.byazt.kx.qg qgVar2 = this.sz;
                if (qgVar2 != null) {
                    qgVar2.z();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                s(this.n);
                break;
            case "downloadEvent":
                qg(true);
                q(qg(cyVar));
                break;
            case "downloadDirect":
                s(qg(cyVar));
                break;
            case "muteVideo":
                if (this.k != null && (qgVar = this.sz) != null) {
                    n(!qgVar.fs());
                    break;
                }
                break;
            case "openAppPolicy":
                qg(this.n);
                break;
            case "openInfringement":
                com.byazt.okk.n.n(this.x, this.q, this.n);
                break;
        }
    }

    private void qg(boolean z) {
        fs();
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter instanceof com.byazt.oh.n) {
            ((com.byazt.oh.n) iTTInnerDownloadAdapter).n().n(z);
        }
    }

    private void s(boolean z) {
        qg(false);
        q(z);
    }

    private boolean qg(cy cyVar) {
        if (cyVar == null) {
            return false;
        }
        View viewRv = cyVar.n().rv();
        if (!(viewRv instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewRv).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    private void n(pk pkVar) {
        String strNn;
        if (pkVar == null) {
            return;
        }
        if (this.d != null) {
            w wVarCd = pkVar.cd();
            if (wVarCd != null) {
                this.d.n(wVarCd.q());
                this.d.n(wVarCd.s());
            }
            strNn = this.d.fs();
        } else {
            strNn = pkVar.nn();
        }
        Activity activity = this.x;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).d();
        }
        com.byazt.okk.n.n(this.x, pkVar.q(), strNn, new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.fj.n.6
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.this.q(true);
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }
        });
    }

    private void qg(pk pkVar) {
        String strNn;
        if (pkVar == null) {
            return;
        }
        if (this.d != null) {
            w wVarCd = pkVar.cd();
            if (wVarCd != null) {
                this.d.n(wVarCd.q());
                this.d.n(wVarCd.s());
            }
            strNn = this.d.fs();
        } else {
            strNn = pkVar.nn();
        }
        Activity activity = this.x;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).d();
        }
        com.byazt.okk.n.n(this.x, pkVar.q(), new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.fj.n.7
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.this.q(true);
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }
        }, strNn);
    }

    private void s(pk pkVar) {
        String strRv;
        if (pkVar == null) {
            return;
        }
        w wVarCd = pkVar.cd();
        q qVar = this.d;
        if (qVar != null) {
            strRv = qVar.l();
        } else {
            strRv = wVarCd == null ? "" : wVarCd.rv();
        }
        com.byazt.okk.n.qg(this.x, strRv, pkVar.q(), new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.fj.n.8
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.this.q(true);
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                if (n.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) n.this.x).oa();
                }
            }
        });
    }

    private String w() {
        JSONObject jSONObject = this.cp;
        if (jSONObject == null) {
            return x();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return x();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return x();
        }
        String strOptString = jSONObjectOptJSONObject.optString(ImagesContract.URL);
        return TextUtils.isEmpty(strOptString) ? x() : strOptString;
    }

    private String x() {
        return com.byazt.vgx.w.wm(this.n);
    }

    private void fs() {
        if (this.tj == null) {
            ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = fs.n(this.x, this.oa, this.n, this.q);
            this.tj = iTTInnerDownloadAdapterN;
            iTTInnerDownloadAdapterN.setCheckCompliance(com.byazt.oh.l.n(this.n));
            this.tj.addAppDownloadListener(this.hd, false);
            this.tj.setCheckReplaceDialogWithLp(false);
        }
        this.tj.setActivity(this.x, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        fs();
        com.byazt.ys.n nVar = new com.byazt.ys.n(this.x, this.n, "embeded_ad_landingpage", this.l);
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).s(true);
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(true);
        this.tj.setOpenMarketInterceptorForDSP(z);
        this.tj.handleAdClick(this.n, false);
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(this.tj);
        this.tj.changeDownloadStatus(com.byazt.vgx.w.h(this.n), false);
    }

    public void qg() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onPause();
        }
        com.byazt.kx.qg qgVar = this.sz;
        if (qgVar != null) {
            qgVar.ic();
        }
    }

    private void rv() {
        com.byazt.kx.qg qgVar = this.sz;
        if (qgVar != null) {
            qgVar.n(this.cy);
        }
    }

    public void s() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onResume();
        }
        com.byazt.kx.qg qgVar = this.sz;
        if (qgVar != null) {
            qgVar.lq();
        }
    }

    public void q() {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.tj;
        if (iTTInnerDownloadAdapter != null) {
            iTTInnerDownloadAdapter.onDestroy();
        }
    }
}
