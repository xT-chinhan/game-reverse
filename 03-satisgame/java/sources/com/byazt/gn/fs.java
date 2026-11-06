package com.byazt.gn;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.gct.h;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.gct.wm;
import com.byazt.nf.rv;
import com.byazt.si.m;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.sz;
import com.byazt.xz.cy;
import com.byazt.za.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 101})
public class fs extends w implements qg {
    public final AtomicBoolean bb;
    public boolean h;
    public String hu;
    public com.byazt.tn.qg m;
    public long t;
    public final AtomicBoolean ur;
    public d wm;

    @Override // com.byazt.gn.w, com.byazt.tq.q
    public void n(CharSequence charSequence, int i, int i2, boolean z) {
    }

    public fs(Context context, pk pkVar, s sVar, ViewGroup viewGroup) {
        super(context, pkVar, sVar, viewGroup);
        this.h = false;
        this.t = 0L;
        this.ur = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.bb = atomicBoolean;
        if (sVar != null) {
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            l.n(this.w, this.n, sVar.ae(), atomicBoolean2);
            l.n(this.w, this.n, sVar.ae(), atomicBoolean2, atomicBoolean);
        }
        n(sVar);
    }

    private String py() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectL = this.x != null ? this.x.l() : null;
        if (jSONObjectL == null || (jSONObjectOptJSONObject = jSONObjectL.optJSONObject("xTemplate")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("meta")) == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("loadFirstUrls")) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        String strOptString = jSONArrayOptJSONArray.optString(0, null);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    private void n(s sVar) {
        String strW;
        if (sVar == null) {
            return;
        }
        String strPy = py();
        if (TextUtils.isEmpty(strPy)) {
            return;
        }
        try {
            String strN = com.byazt.mcb.qg.n(strPy, sVar.v());
            if (!TextUtils.isEmpty(strN)) {
                strPy = strN;
            }
        } catch (Throwable unused) {
        }
        this.hu = strPy;
        this.t = System.currentTimeMillis();
        if (!TextUtils.isEmpty(sVar.cy())) {
            strW = sVar.cy();
        } else {
            strW = com.byazt.ql.qg.w();
        }
        boolean z = !com.byazt.imu.s.n(this.hu, null, strW);
        this.h = z;
        if (z && rv.qg().d()) {
            try {
                com.byazt.imu.s.n(this.hu).s(3).s(sVar.cy()).n((m) null);
            } catch (Throwable unused2) {
            }
        }
    }

    public void n(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(this.hu, str) && this.ur.compareAndSet(false, true)) {
            com.byazt.eji.s.n().n(this.w, z, z ? System.currentTimeMillis() - this.t : 0L, this.h);
        }
    }

    private com.byazt.sx.q ou() {
        com.byazt.ivn.w wVarQg = rv.qg();
        if (wVarQg == null || !wVarQg.du()) {
            return null;
        }
        return com.byazt.sx.q.n();
    }

    @Override // com.byazt.gn.w
    public JSONObject n() {
        return this.x.l().optJSONObject("xTemplate");
    }

    @Override // com.byazt.gn.w
    public void qg(com.byazt.udb.x xVar) {
        m();
        this.n.n((cd) this);
        this.n.n((a) this);
        su suVarFs = nf.fs(this.w);
        try {
            if (suVarFs != null) {
                this.s = this.n.n(this.q, this.l, suVarFs.l());
            } else {
                this.s = this.n.n(this.q, this.l, (JSONObject) null);
            }
            if (this.n.n()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.n.qg()));
                this.x.j().n(jSONObject);
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, "ugen unknown component");
                return;
            }
            if (this.n.s()) {
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, "ugen root disable");
                return;
            }
            if (this.s != null) {
                if (this.ou == null) {
                    this.ou = new com.byazt.ve.n(this.x.l());
                }
                this.ou.n(this.n, this.s);
                wm();
            }
            this.x.j().qg();
            this.x.j().s();
        } catch (NoClassDefFoundError unused) {
            if (xVar != null) {
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (xVar != null) {
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (xVar != null) {
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    private void wm() {
        JSONObject jSONObjectSz;
        if (this.w == null || this.s == null || (jSONObjectSz = nf.sz(this.w)) == null || jSONObjectSz.optInt("close_computed_color", 0) != 1) {
            return;
        }
        n.n(this.s);
    }

    private void m() {
        sz szVar = new sz();
        HashMap map = new HashMap();
        if (this.w != null) {
            map.put("shake_value", Integer.valueOf(this.w.mp()));
            map.put("calculation_method", Integer.valueOf(this.w.qd()));
            map.put("rotation_angle", Integer.valueOf(this.w.eu()));
            map.put("calculation_method_twist", Integer.valueOf(this.w.on()));
            map.put("twist_config", this.w.kv());
            map.put("image_info", com.byazt.ns.qg.l(this.w));
            map.put("cache_dir", this.x != null ? this.x.cy() : null);
            map.put("shake_interact_conf", this.w.rk());
            map.put("twist_interact_conf", this.w.bs());
        }
        map.put("ugen_v3_render", new WeakReference(this));
        szVar.qg(map);
        szVar.n(this.qg);
        szVar.n(this.q);
        szVar.qg(this.l);
        n(szVar);
        this.n.n("ad", szVar);
    }

    @Override // com.byazt.gn.w
    public com.byazt.ih.s x() {
        if (this.s == null) {
            return null;
        }
        return this.s.l("VideoV3");
    }

    @Override // com.byazt.gn.w
    public JSONObject d() {
        return this.x.l();
    }

    @Override // com.byazt.gn.w, com.byazt.vh.cd
    public void n(final com.byazt.ih.s sVar, final String str, final com.byazt.xz.x.n nVar) {
        if (nVar == null) {
            return;
        }
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            if (this.k == null || this.k.get() == null) {
                return;
            }
            com.byazt.cd.qg.n(this.k, new com.byazt.ys.q() { // from class: com.byazt.gn.fs.1
                @Override // com.byazt.ys.q
                public void n() {
                    if (fs.this.k == null || fs.this.k.get() == null || !com.byazt.cd.qg.n(fs.this.k.get())) {
                        return;
                    }
                    fs.this.qg(sVar, str, nVar);
                }
            });
            return;
        }
        qg(sVar, str, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        CharSequence text;
        String strQg = nVar.qg();
        Map<String, Object> mapS = nVar.s();
        if (s()) {
            boolean andSet = this.bb.getAndSet(false);
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.sz);
            map.put("convert_action_type", Integer.valueOf(s(str)));
            map.put("v3_trigger_name", str);
            map.put("is_slide_trigger_by_cancel", Boolean.valueOf(andSet));
            if (com.byazt.li.n.n().n(nVar, this.w, this.qg, sVar, d(), this.oa, map)) {
                return;
            }
        }
        if (com.byazt.tn.n.n.contains(strQg)) {
            com.byazt.tn.n.n(this.wm, this.m, this.w, this.qg, strQg, nVar, this.um, sVar);
            return;
        }
        if ("uchain".equals(strQg)) {
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.w);
            map2.put("context", this.qg);
            map2.put("event_tag", com.byazt.vgx.w.qg(this.w));
            com.byazt.ukb.qg.n(this.w, (HashMap<String, Object>) map2, nVar);
            return;
        }
        strQg.hashCode();
        int i = 3;
        switch (strQg) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "renderScene":
                if (mapS != null) {
                    n(Objects.toString(mapS.get("scene"), ""), Objects.toString(mapS.get("ugen_id"), ""), Objects.toString(mapS.get("ugen_md5"), ""), Objects.toString(mapS.get("ugen_url"), ""), Objects.toString(mapS.get("displayAreaAndroid"), ""), Objects.toString(mapS.get("render_sequence"), ""));
                    return;
                }
                return;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                d dVar = this.wm;
                if (dVar != null) {
                    dVar.n(3);
                    return;
                }
                return;
            case "pauseVideo":
                d dVar2 = this.wm;
                if (dVar2 != null) {
                    dVar2.n(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                i = 12;
                break;
            case "dismissScene":
                if (mapS != null) {
                    n(Objects.toString(mapS.get("scene"), ""));
                    return;
                }
                return;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                i = 5;
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                break;
            default:
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("event_name", strQg);
                    if (this.w != null) {
                        jSONObject.put("req_id", this.w.ou());
                        su suVarFs = nf.fs(this.w);
                        if (suVarFs != null) {
                            jSONObject.put("tpl_v3_id", suVarFs.n());
                        }
                        jSONObject.put("extension_ugen_id", h.l(this.w));
                    }
                    com.byazt.eji.s.n().n("ugen_v3_render_unknown_event", jSONObject, (Throwable) null);
                    break;
                } catch (JSONException unused) {
                }
                if (rv.qg().to()) {
                    i = 0;
                    break;
                } else {
                    return;
                }
                break;
        }
        wm.n nVarN = new wm.n().q(this.sz.cd()).s(this.sz.um()).qg(this.sz.a()).n(this.sz.py()).n(sVar.v()).qg(this.sz.cy()).n(this.sz.hd()).n(this.bb.getAndSet(false) ? (byte) 7 : qg(str));
        JSONObject jSONObject2 = new JSONObject();
        int iS = s(str);
        if (iS > 0) {
            try {
                jSONObject2.put("convertActionType", iS);
            } catch (Throwable unused2) {
            }
        }
        try {
            Object obj = mapS.get("webUrl");
            Object obj2 = mapS.get("webTitle");
            String strN = com.byazt.mcb.qg.n(Objects.toString(obj, ""), d());
            String strN2 = com.byazt.mcb.qg.n(Objects.toString(obj2, ""), d());
            jSONObject2.put("openCommonWebUrl", strN);
            jSONObject2.put("openCommonWebTitle", strN2);
        } catch (JSONException unused3) {
        }
        View viewRv = sVar.rv();
        try {
            if ((viewRv instanceof TextView) && (text = ((TextView) viewRv).getText()) != null && text.toString().contains("下载")) {
                jSONObject2.put("is_compliant_download", true);
            }
        } catch (JSONException unused4) {
        }
        nVarN.n(jSONObject2);
        wm wmVarN = nVarN.n();
        if (this.rv != null) {
            this.rv.n(viewRv, i, wmVarN, -1);
        }
    }

    public static byte qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return (byte) 0;
        }
        str.hashCode();
        switch (str) {
            case "tap":
                return (byte) 1;
            case "shake":
                return (byte) 3;
            case "slide":
                return (byte) 2;
            case "twist":
                return (byte) 4;
            case "longTap":
                return (byte) 5;
            default:
                return (byte) 0;
        }
    }

    private int s(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        if (str.equals("shake")) {
            return 1;
        }
        return !str.equals("twist") ? 0 : 2;
    }

    public void n(String str, Map<String, String> map) {
        if (this.s == null) {
            return;
        }
        com.byazt.xz.x.n nVar = new com.byazt.xz.x.n();
        nVar.n("custom");
        nVar.qg("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(TapEventParamConstants.PARAM_NAME, str);
        nVar.n(map2);
        com.byazt.ss.n.C0336n.n(this.s, "jsb", nVar).n();
    }

    @Override // com.byazt.gn.qg
    public void n(d dVar) {
        this.wm = dVar;
    }

    public void n(com.byazt.tn.qg qgVar) {
        this.m = qgVar;
    }

    @Override // com.byazt.gn.w, com.byazt.udb.q
    public void n(boolean z) {
        n.qg(this.s);
        super.n(z);
        hu();
    }

    private void n(sz szVar) {
        if (this.w != null) {
            szVar.n(this.w.py());
        }
        szVar.n((cy) ou());
        szVar.qg(com.byazt.sx.q.qg);
    }

    private void hu() {
        if (this.w == null) {
            return;
        }
        try {
            com.byazt.sx.q.n().n(this.w.py());
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
