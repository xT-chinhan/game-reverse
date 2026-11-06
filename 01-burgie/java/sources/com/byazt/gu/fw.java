package com.byazt.gu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.ch.g;
import com.byazt.ch.lb;
import com.byazt.hg.cr;
import com.byazt.hg.fo;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.ld.rc;
import com.byazt.qx.w;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.byazt.wt.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.d;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, 62})
public class fw extends c implements pr {
    public long b;
    public com.byazt.so.hw fo;
    public final AtomicBoolean gz;
    public final AtomicBoolean iu;
    public w ny;
    public String rc;
    public final AtomicBoolean ve;
    public boolean z;

    public fw(Context context, of ofVar, hw hwVar, ViewGroup viewGroup) {
        super(context, ofVar, hwVar, viewGroup);
        this.z = false;
        this.b = 0L;
        this.iu = new AtomicBoolean(false);
        this.ve = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.gz = atomicBoolean;
        if (hwVar != null) {
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            x.pr(this.uc, this.pr, hwVar.s(), atomicBoolean2);
            x.pr(this.uc, this.pr, hwVar.s(), atomicBoolean2, atomicBoolean);
        }
        pr(hwVar);
    }

    private String nt() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectC = this.fw != null ? this.fw.c() : null;
        if (jSONObjectC == null || (jSONObjectOptJSONObject = jSONObjectC.optJSONObject("xTemplate")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("meta")) == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("loadFirstUrls")) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        String strOptString = jSONArrayOptJSONArray.optString(0, null);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    private void pr(hw hwVar) {
        String strUc;
        if (hwVar == null) {
            return;
        }
        String strNt = nt();
        if (TextUtils.isEmpty(strNt)) {
            return;
        }
        try {
            String strPr = com.byazt.tn.hw.pr(strNt, hwVar.ww());
            if (!TextUtils.isEmpty(strPr)) {
                strNt = strPr;
            }
        } catch (Throwable th) {
        }
        this.rc = strNt;
        this.b = System.currentTimeMillis();
        if (!TextUtils.isEmpty(hwVar.nt())) {
            strUc = hwVar.nt();
        } else {
            strUc = com.byazt.zp.w.uc();
        }
        boolean z = !com.byazt.ub.hw.pr(this.rc, null, strUc);
        this.z = z;
        if (z && a.hw().k()) {
            try {
                com.byazt.ub.hw.pr(this.rc).hn(3).hn(hwVar.nt()).pr((rc) null);
            } catch (Throwable th2) {
            }
        }
    }

    public void pr(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(this.rc, str) || !this.iu.compareAndSet(false, true)) {
            return;
        }
        com.byazt.xk.hw.pr().pr(this.uc, z, z ? System.currentTimeMillis() - this.b : 0L, this.z);
    }

    private com.byazt.at.x yb() {
        com.byazt.is.w wVarHw = a.hw();
        if (wVarHw != null && wVarHw.jl()) {
            return com.byazt.at.x.pr();
        }
        if (this.ve.compareAndSet(false, true)) {
            com.byazt.wk.pr.pr("switch_off");
            return null;
        }
        return null;
    }

    @Override // com.byazt.gu.c
    public JSONObject pr() {
        return this.fw.c().optJSONObject("xTemplate");
    }

    @Override // com.byazt.gu.c
    public void hw(com.byazt.mq.fw fwVar) {
        lb();
        this.pr.pr((lb) this);
        this.pr.pr((com.byazt.ch.a) this);
        cr crVarZo = ie.zo(this.uc);
        try {
            if (crVarZo != null) {
                this.hn = this.pr.pr(this.x, this.c, crVarZo.c());
            } else {
                this.hn = this.pr.pr(this.x, this.c, (JSONObject) null);
            }
            if (this.pr.pr()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.pr.hw()));
                this.fw.n().pr(jSONObject);
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, "ugen unknown component");
                return;
            }
            if (this.pr.hn()) {
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, "ugen root disable");
                return;
            }
            if (this.hn != null) {
                if (this.cz == null) {
                    this.cz = new com.byazt.bk.pr(this.fw.c());
                }
                this.cz.pr(this.pr, this.hn);
            }
            this.fw.n().hw();
            this.fw.n().hn();
        } catch (NoClassDefFoundError e) {
            if (fwVar != null) {
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError e2) {
            if (fwVar != null) {
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable th) {
            if (fwVar != null) {
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    private void lb() {
        g gVar = new g();
        HashMap map = new HashMap();
        if (this.uc != null) {
            map.put("shake_value", Integer.valueOf(this.uc.tm()));
            map.put("calculation_method", Integer.valueOf(this.uc.gg()));
            map.put("rotation_angle", Integer.valueOf(this.uc.qz()));
            map.put("calculation_method_twist", Integer.valueOf(this.uc.kl()));
            map.put("twist_config", this.uc.gv());
            map.put("image_info", com.byazt.hc.hw.c(this.uc));
            map.put("cache_dir", this.fw != null ? this.fw.nt() : null);
            map.put("shake_interact_conf", this.uc.dj());
            map.put("twist_interact_conf", this.uc.yd());
        }
        map.put("ugen_v3_render", new WeakReference(this));
        gVar.pr(map);
        gVar.pr(this.hw);
        gVar.pr(this.x);
        gVar.hw(this.c);
        if (this.uc != null) {
            gVar.pr(this.uc.cz());
        }
        gVar.pr(yb());
        gVar.pr(com.byazt.at.x.hw);
        this.pr.pr(an.aw, gVar);
    }

    @Override // com.byazt.gu.c
    public com.byazt.ik.hn fw() {
        if (this.hn == null) {
            return null;
        }
        return this.hn.c("VideoV3");
    }

    @Override // com.byazt.gu.c
    public JSONObject w() {
        return this.fw.c();
    }

    @Override // com.byazt.gu.c, com.byazt.ch.lb
    public void pr(final com.byazt.ik.hn hnVar, final String str, final com.byazt.dd.fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            if (this.ho == null || this.ho.get() == null) {
                return;
            }
            n.pr(this.ho, new com.byazt.az.hn() { // from class: com.byazt.gu.fw.1
                @Override // com.byazt.az.hn
                public void pr() {
                    if (fw.this.ho != null && fw.this.ho.get() != null && n.pr(fw.this.ho.get())) {
                        fw.this.hw(hnVar, str, prVar);
                    }
                }
            });
            return;
        }
        hw(hnVar, str, prVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void hw(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
        byte b;
        CharSequence text;
        String strHw = prVar.hw();
        Map<String, Object> mapHn = prVar.hn();
        if (hn()) {
            boolean andSet = this.gz.getAndSet(false);
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.g);
            map.put("convert_action_type", Integer.valueOf(hn(str)));
            map.put("v3_trigger_name", str);
            map.put("is_slide_trigger_by_cancel", Boolean.valueOf(andSet));
            if (com.byazt.fy.pr.pr().pr(prVar, this.uc, this.hw, hnVar, w(), this.m, map)) {
                return;
            }
        }
        if (com.byazt.so.pr.pr.contains(strHw)) {
            com.byazt.so.pr.pr(this.ny, this.fo, this.uc, this.hw, strHw, prVar, this.lb, hnVar);
            return;
        }
        if ("uchain".equals(strHw)) {
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.uc);
            map2.put(d.R, this.hw);
            map2.put("event_tag", ls.hw(this.uc));
            com.byazt.lx.hw.pr(this.uc, (HashMap<String, Object>) map2, prVar);
            return;
        }
        int i = 3;
        switch (strHw.hashCode()) {
            case -1822902106:
                b = !strHw.equals("openAppPermission") ? (byte) -1 : (byte) 4;
                break;
            case -1657551782:
                b = !strHw.equals("openCommonUrl") ? (byte) -1 : (byte) 12;
                break;
            case -1639156586:
                b = !strHw.equals("renderScene") ? (byte) -1 : cc.k;
                break;
            case -511324706:
                b = !strHw.equals("openPrivacy") ? (byte) -1 : (byte) 3;
                break;
            case -87658418:
                b = !strHw.equals("resumeVideo") ? (byte) -1 : (byte) 9;
                break;
            case -55818203:
                b = !strHw.equals("pauseVideo") ? (byte) -1 : (byte) 8;
                break;
            case 3532159:
                b = !strHw.equals("skip") ? (byte) -1 : (byte) 7;
                break;
            case 94756344:
                b = !strHw.equals(ILivePush.ClickType.CLOSE) ? (byte) -1 : (byte) 2;
                break;
            case 293548143:
                b = !strHw.equals("openAppFunction") ? (byte) -1 : (byte) 5;
                break;
            case 421035042:
                b = !strHw.equals("dismissScene") ? (byte) -1 : cc.l;
                break;
            case 804386914:
                b = !strHw.equals("videoControl") ? (byte) -1 : (byte) 10;
                break;
            case 951590323:
                b = !strHw.equals("convert") ? (byte) -1 : (byte) 0;
                break;
            case 1151744482:
                b = !strHw.equals("muteVideo") ? (byte) -1 : (byte) 11;
                break;
            case 1237425033:
                b = !strHw.equals("openAppPolicy") ? (byte) -1 : (byte) 6;
                break;
            case 1671642405:
                b = !strHw.equals(com.byazt.pfl.hw.AD_TAG_DISLIKE) ? (byte) -1 : (byte) 1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                i = 2;
                break;
            case 1:
                break;
            case 2:
                i = 8;
                break;
            case 3:
                i = 7;
                break;
            case 4:
                i = 10;
                break;
            case 5:
                i = 12;
                break;
            case 6:
                i = 9;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                w wVar = this.ny;
                if (wVar != null) {
                    wVar.pr(2);
                    return;
                }
                return;
            case 9:
                w wVar2 = this.ny;
                if (wVar2 != null) {
                    wVar2.pr(3);
                    return;
                }
                return;
            case 10:
                i = 4;
                break;
            case 11:
                i = 5;
                break;
            case 12:
                i = 13;
                break;
            case 13:
                if (mapHn != null) {
                    pr(Objects.toString(mapHn.get("scene"), ""), Objects.toString(mapHn.get("ugen_id"), ""), Objects.toString(mapHn.get("ugen_md5"), ""), Objects.toString(mapHn.get("ugen_url"), ""), Objects.toString(mapHn.get("displayAreaAndroid"), ""), Objects.toString(mapHn.get("render_sequence"), ""));
                    return;
                }
                return;
            case 14:
                if (mapHn != null) {
                    pr(Objects.toString(mapHn.get("scene"), ""));
                    return;
                }
                return;
            default:
                i = 0;
                break;
        }
        fo.pr prVarPr = new fo.pr().x(this.g.lb()).hn(this.g.qa()).hw(this.g.a()).pr(this.g.cz()).pr(hnVar.ww()).hw(this.g.nt()).pr(this.g.yb()).pr(this.gz.getAndSet(false) ? (byte) 7 : hw(str));
        JSONObject jSONObject = new JSONObject();
        int iHn = hn(str);
        if (iHn > 0) {
            try {
                jSONObject.put("convertActionType", iHn);
            } catch (Throwable th) {
            }
        }
        try {
            Object obj = mapHn.get("webUrl");
            Object obj2 = mapHn.get("webTitle");
            String strPr = com.byazt.tn.hw.pr(Objects.toString(obj, ""), w());
            String strPr2 = com.byazt.tn.hw.pr(Objects.toString(obj2, ""), w());
            jSONObject.put("openCommonWebUrl", strPr);
            jSONObject.put("openCommonWebTitle", strPr2);
        } catch (JSONException e) {
        }
        View viewAj = hnVar.aj();
        try {
            if ((viewAj instanceof TextView) && (text = ((TextView) viewAj).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException e2) {
        }
        prVarPr.pr(jSONObject);
        fo foVarPr = prVarPr.pr();
        if (this.aj != null) {
            this.aj.pr(viewAj, i, foVarPr, -1);
        }
    }

    public static byte hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return (byte) 0;
        }
        switch (str) {
            case "tap":
                return (byte) 1;
            case "slide":
                return (byte) 2;
            case "shake":
                return (byte) 3;
            case "twist":
                return (byte) 4;
            case "longTap":
                return (byte) 5;
            default:
                return (byte) 0;
        }
    }

    private int hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        switch (str) {
            case "shake":
                return 1;
            case "twist":
                return 2;
            default:
                return 0;
        }
    }

    @Override // com.byazt.gu.c, com.byazt.imd.x
    public void pr(CharSequence charSequence, int i, int i2, boolean z) {
    }

    public void pr(String str, Map<String, String> map) {
        if (this.hn == null) {
            return;
        }
        com.byazt.dd.fw.pr prVar = new com.byazt.dd.fw.pr();
        prVar.pr(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        prVar.hw("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(Common.System.NAME, str);
        prVar.pr(map2);
        com.byazt.tby.pr.C0193pr.pr(this.hn, "jsb", prVar).pr();
    }

    @Override // com.byazt.gu.pr
    public void pr(w wVar) {
        this.ny = wVar;
    }

    public void pr(com.byazt.so.hw hwVar) {
        this.fo = hwVar;
    }

    @Override // com.byazt.gu.c, com.byazt.mq.x
    public void pr(boolean z) {
        super.pr(z);
        qa();
    }

    private void qa() {
        if (this.uc == null) {
            return;
        }
        try {
            com.byazt.at.x.pr().pr(this.uc.cz());
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
