package com.bytedance.sdk.openadsdk.core.hi.ah.ah;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private ms ah;
    private com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2574ms;
    private Context xr;
    private boolean d = true;
    private boolean c = false;
    private int ab = 0;
    private boolean x = false;

    public ah(Context context, lm lmVar) {
        this.xr = context;
        this.f2574ms = lmVar;
    }

    public void ms(ms msVar) {
        ms(msVar, this.f2574ms);
    }

    public void ms(ms msVar, lm lmVar) {
        this.ah = msVar;
        if (msVar == null) {
            return;
        }
        msVar.ms(this.xr);
        msVar.ms(lmVar);
        msVar.ms(this.d);
    }

    public void ms(boolean z) {
        this.d = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms msVar) {
        this.ka = msVar;
    }

    public void xr(boolean z) {
        this.c = z;
    }

    public void ms(int i) {
        this.ab = i;
    }

    public void ah(boolean z) {
        this.x = z;
    }

    public boolean d(boolean z) {
        ms msVar = this.ah;
        boolean z2 = true;
        if (msVar == null) {
            return true;
        }
        if (msVar instanceof xr) {
            xr xrVar = (xr) msVar;
            if (!z && !this.x) {
                z2 = false;
            }
            xrVar.ah(z2);
            xrVar.xr(this.c);
            xrVar.ms(this.ab);
        }
        return this.ah.ms();
    }

    public void ms(String str, com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr xrVar) {
        if (this.f2574ms == null) {
            return;
        }
        ms((com.bytedance.sdk.openadsdk.core.nw.d) null, str, xrVar);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr xrVar) {
        lm lmVar = this.f2574ms;
        if (lmVar == null) {
            return;
        }
        if (dVar != null || lmVar.dv() != 2 || (this.ah instanceof ka)) {
            ms(dVar, str, xrVar);
        } else {
            ab.xr(new ny("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    ah.this.ms(re.ms().ms(ah.this.f2574ms, str2), str, xrVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.d dVar, String str, com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr xrVar) {
        String strZx;
        String strXr;
        String strMs;
        com.bytedance.sdk.openadsdk.core.jw.c.ms msVarXr = xr(str, xrVar);
        try {
            if (dVar != null) {
                com.bytedance.sdk.openadsdk.core.nw.c cVarPh = this.f2574ms.ph();
                if (cVarPh != null) {
                    dVar.ms(cVarPh.d());
                    dVar.ms(cVarPh.ah());
                }
                strZx = dVar.c();
                strXr = dVar.ms();
                strMs = dVar.ah();
            } else {
                strZx = this.f2574ms.zx();
                strXr = ub.xr(this.f2574ms);
                g gVarQd = this.f2574ms.qd();
                strMs = gVarQd != null ? gVarQd.ms() : "";
            }
            if (ch.sl(this.f2574ms)) {
                if (!ch.ms(this.xr, this.f2574ms, strXr)) {
                    lm lmVar = this.f2574ms;
                    ms(lmVar, str, ch.xr(this.xr, lmVar, strXr), 0, "");
                }
            } else {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f2574ms, str, "pop_up", ms());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strXr);
            jSONObject.put("dialog_icon_url", strMs);
            jSONObject.put("dialog_app_description", this.f2574ms.fs());
            String strMs2 = ms(strZx);
            xr(str);
            if (ch.ms(this.xr, this.f2574ms, strXr)) {
                ms(str, msVarXr, strMs2, strMs, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(this.xr, this.f2574ms.df(), strMs2, jSONObject.toString(), msVarXr, this.f2574ms);
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    private String ms(String str) {
        int iQv = nw.qv(this.f2574ms);
        try {
            if (iQv != 4) {
                if (iQv != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", nw.t(this.f2574ms));
            jSONObject2.put("ugen_md5", nw.nw(this.f2574ms));
            jSONObject2.put("download_num", xr(this.f2574ms.vi()));
            com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = this.f2574ms.zh();
            if (kaVarZh == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", ah(kaVarZh.ab()));
            jSONObject2.put("comment_num", ms(kaVarZh.c()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private void xr(final String str) {
        if (nw.qv(this.f2574ms) != 4) {
            return;
        }
        TTDelegateActivity.ms(new com.bytedance.sdk.openadsdk.core.ugeno.ab.ab() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str2) {
                ah.this.ms(str, 1, str2);
                TTDelegateActivity.ms((com.bytedance.sdk.openadsdk.core.ugeno.ab.ab) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                ah.this.ms(str, 0, "");
                TTDelegateActivity.ms((com.bytedance.sdk.openadsdk.core.ugeno.ab.ab) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, int i, String str2) {
        JSONObject jSONObjectMs = ms();
        try {
            jSONObjectMs.put("ugen_dl_render_fail_msg", str2);
            jSONObjectMs.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f2574ms, str, "pop_up", jSONObjectMs);
    }

    public String ms(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(j / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String xr(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String ah(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private void ms(String str, com.bytedance.sdk.openadsdk.core.jw.c.ms msVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.xr, this.f2574ms.df(), ch.ms(this.xr, str2, this.f2574ms, str3), jSONObject.toString(), msVar, ah(str), this.f2574ms);
    }

    private com.bytedance.sdk.openadsdk.core.ugeno.ab.ab ah(final String str) {
        return new com.bytedance.sdk.openadsdk.core.ugeno.ab.ab() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str2) {
                ah ahVar = ah.this;
                ahVar.ms(ahVar.f2574ms, str, 6, i, str2);
                TTDelegateActivity.ms((com.bytedance.sdk.openadsdk.core.ugeno.ab.ab) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                ah ahVar2 = ah.this;
                ahVar2.ms(ahVar2.f2574ms, str, 5, 0, "");
                TTDelegateActivity.ms((com.bytedance.sdk.openadsdk.core.ugeno.ab.ab) null);
            }
        };
    }

    private com.bytedance.sdk.openadsdk.core.jw.c.ms xr(final String str, final com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr xrVar) {
        return new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah.4
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms();
                }
                if (ah.this.ka != null) {
                    ah.this.ka.ms();
                }
                c.xr = true;
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(ah.this.f2574ms, str, "pop_up_download", ah.this.ms());
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(ah.this.f2574ms, str, "pop_up_cancel", ah.this.ms());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectMs = ms();
        if (6 == i) {
            try {
                jSONObjectMs.put("easy_dl_render_fail_code", i2);
                if (lmVar != null) {
                    String strAh = lmVar.jc().ah();
                    jSONObjectMs.put("easy_dl_render_fail_msg", str2);
                    jSONObjectMs.put("easy_dl_render_fail_dsl", d(strAh));
                }
            } catch (Exception unused) {
            }
        }
        jSONObjectMs.put("show_easy_dl_dialog_code", i);
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f2574ms, str, "pop_up", jSONObjectMs);
    }

    private String d(String str) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        if (xrVarMs == null) {
            return null;
        }
        return xrVarMs.xr(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            ms msVar = this.ah;
            jSONObject.put(com.anythink.core.common.e.g.a.l, msVar != null ? msVar.xr() : 0);
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObject;
    }
}
