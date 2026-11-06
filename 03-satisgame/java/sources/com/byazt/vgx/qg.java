package com.byazt.vgx;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.f.a;
import com.anythink.core.d.b.e;
import com.byazt.ehw.DeviceUtils;
import com.byazt.ep.fs;
import com.byazt.gct.ae;
import com.byazt.gct.b;
import com.byazt.gct.bb;
import com.byazt.gct.cd;
import com.byazt.gct.ci;
import com.byazt.gct.cp;
import com.byazt.gct.cx;
import com.byazt.gct.df;
import com.byazt.gct.dg;
import com.byazt.gct.dh;
import com.byazt.gct.dn;
import com.byazt.gct.el;
import com.byazt.gct.f;
import com.byazt.gct.fl;
import com.byazt.gct.h;
import com.byazt.gct.hd;
import com.byazt.gct.he;
import com.byazt.gct.hf;
import com.byazt.gct.hu;
import com.byazt.gct.i;
import com.byazt.gct.ic;
import com.byazt.gct.j;
import com.byazt.gct.k;
import com.byazt.gct.lh;
import com.byazt.gct.m;
import com.byazt.gct.nf;
import com.byazt.gct.oj;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.py;
import com.byazt.gct.rf;
import com.byazt.gct.sz;
import com.byazt.gct.t;
import com.byazt.gct.ta;
import com.byazt.gct.um;
import com.byazt.gct.ur;
import com.byazt.gct.v;
import com.byazt.gct.wv;
import com.byazt.gct.y;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.kwad.sdk.api.model.AdnName;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 26})
public class qg {
    public static Pair<com.byazt.gct.n, ArrayList<Integer>> n(JSONObject jSONObject, com.byazt.zq.qg qgVar, y yVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.byazt.gct.n nVar = new com.byazt.gct.n();
            nVar.n(jSONObject.optString("request_id"));
            nVar.n(jSONObject.optInt("ret"));
            nVar.qg(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.byazt.ehw.w.n(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (nVar.n() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    i++;
                    pk pkVarN = n(jSONObjectOptJSONObject, qgVar, yVar, i);
                    int iN = n(pkVarN, qgVar != null ? qgVar.a() : 0);
                    boolean zDw = pkVarN.dw();
                    String strHa = pkVarN.ha();
                    if (pkVarN != null && (iN == 200 || ((zOptBoolean || zDw) && !TextUtils.isEmpty(strHa)))) {
                        pkVarN.an(strOptString);
                        pkVarN.s(j);
                        pkVarN.tj(zOptBoolean);
                        nVar.n(pkVarN);
                    } else {
                        arrayList.add(Integer.valueOf(iN));
                    }
                }
            }
            return new Pair<>(nVar, arrayList);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static pk n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return n(jSONObject, (com.byazt.zq.qg) null, (y) null, 0);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:104:0x0609  */
    /* JADX WARN: Code duplicated, block: B:107:0x0612  */
    /* JADX WARN: Code duplicated, block: B:110:0x061d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0628  */
    /* JADX WARN: Code duplicated, block: B:116:0x0633  */
    /* JADX WARN: Code duplicated, block: B:120:0x0641  */
    /* JADX WARN: Code duplicated, block: B:123:0x068f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0691  */
    /* JADX WARN: Code duplicated, block: B:127:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:129:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:130:0x06ae  */
    /* JADX WARN: Code duplicated, block: B:133:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:136:0x0764  */
    /* JADX WARN: Code duplicated, block: B:144:0x084a  */
    /* JADX WARN: Code duplicated, block: B:147:0x08e6  */
    /* JADX WARN: Code duplicated, block: B:150:0x0909  */
    /* JADX WARN: Code duplicated, block: B:153:0x095a  */
    /* JADX WARN: Code duplicated, block: B:156:0x0968  */
    /* JADX WARN: Code duplicated, block: B:163:0x0a2a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0a31 A[LOOP:3: B:164:0x0a2b->B:166:0x0a31, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:169:0x0a4b  */
    /* JADX WARN: Code duplicated, block: B:170:0x0a4e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0591  */
    /* JADX WARN: Code duplicated, block: B:96:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:98:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:99:0x05dd  */
    public static pk n(JSONObject jSONObject, com.byazt.zq.qg qgVar, y yVar, int i) {
        String strS;
        int i2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        boolean z;
        oj ojVar;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        String strOptString;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        Map<String, Object> mapWl;
        String strYk;
        JSONArray jSONArrayOptJSONArray;
        int iOptInt;
        int i3;
        com.byazt.ul.n nVar;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObjectOptJSONObject10;
        JSONObject jSONObjectOptJSONObject11;
        JSONObject jSONObjectOptJSONObject12;
        JSONObject jSONObjectOptJSONObject13;
        com.byazt.ai.n nVarN;
        if (jSONObject == null) {
            return null;
        }
        if (yVar != null && qgVar != null) {
            rv.qg().qg(jSONObject.optInt("settings_open", 1));
        }
        final pk pkVar = new pk();
        pkVar.f(jSONObject.optString("s_sig_ts"));
        pkVar.cp(jSONObject.optLong("ad_rec_stamp", 0L));
        pkVar.fi(jSONObject.optInt("interaction_type"));
        pkVar.um(jSONObject.optString("target_url"));
        pkVar.sz(jSONObject.optInt("use_sdk_player", 0));
        pkVar.oa(jSONObject.optInt("use_media_video_player", 0));
        pkVar.oj(jSONObject.optInt("landing_scroll_percentage", -1));
        pkVar.a(jSONObject.optString("gecko_id"));
        pkVar.d(jSONObject.optBoolean("is_cache"));
        pkVar.y(jSONObject.optInt("cache_type", 100));
        com.byazt.fxc.s.n(pkVar, jSONObject);
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("set_click_type");
            pkVar.qg(jSONObjectOptJSONObject14.optDouble("cta", 2.0d));
            pkVar.n(jSONObjectOptJSONObject14.optDouble(AdnName.OTHER, 2.0d));
        }
        pkVar.d(jSONObject.optInt("feed_video_finish_type"));
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("extension");
        pkVar.w(jSONObjectOptJSONObject15);
        pkVar.x(jSONObject.optJSONObject("overlay"));
        pkVar.h(jSONObject.optString(MediationConstant.EXTRA_ADID));
        pkVar.s(jSONObject.optInt("get_phone_num_status"));
        pkVar.cd(jSONObject.optString("source"));
        pkVar.j(jSONObject.optString("package_name"));
        pkVar.h(jSONObject.optInt("play_bar_show_time", -200));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("icon");
        pkVar.cp(jSONObject.optBoolean("screenshot", false));
        pkVar.py(jSONObject.optInt("play_bar_style", 0));
        String str = "";
        pkVar.v(jSONObject.optString("market_url", ""));
        pkVar.um(jSONObject.optInt("video_adaptation", 0));
        pkVar.hd(jSONObject.optInt("feed_video_opentype", 0));
        pkVar.cd(jSONObject.optInt("feed_reward_type", -1));
        pkVar.fs(jSONObject.optJSONObject("session_params"));
        pkVar.rv(jSONObject.optJSONObject("cache_control"));
        pkVar.an(jSONObject.optString("auction_price", ""));
        pkVar.b(jSONObject.optInt("no_default_ttdsp_price", 0));
        int iOptInt2 = jSONObject.optInt("meta_hashcode", 0);
        pkVar.l(iOptInt2 != 0 ? iOptInt2 : (int) SystemClock.elapsedRealtime());
        String str2 = "width";
        String str3 = "height";
        if (jSONObjectOptJSONObject16 != null) {
            v vVar = new v();
            vVar.n(jSONObjectOptJSONObject16.optString(ImagesContract.URL));
            vVar.qg(jSONObjectOptJSONObject16.optInt("height"));
            vVar.n(jSONObjectOptJSONObject16.optInt("width"));
            pkVar.n(vVar);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray3 != null) {
            int i4 = 0;
            while (i4 < jSONArrayOptJSONArray3.length()) {
                v vVar2 = new v();
                String str4 = str;
                JSONObject jSONObjectOptJSONObject17 = jSONArrayOptJSONArray3.optJSONObject(i4);
                vVar2.n(jSONObjectOptJSONObject17.optString(ImagesContract.URL));
                vVar2.qg(jSONObjectOptJSONObject17.optInt(str3));
                vVar2.n(jSONObjectOptJSONObject17.optInt(str2));
                vVar2.n(jSONObjectOptJSONObject17.optInt(MediationConstant.EXTRA_DURATION));
                vVar2.n(jSONObjectOptJSONObject17.optBoolean("image_preview"));
                vVar2.qg(jSONObjectOptJSONObject17.optString("image_key"));
                pkVar.qg(vVar2);
                i4++;
                str = str4;
                jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                str2 = str2;
                str3 = str3;
            }
        }
        String str5 = str;
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                pkVar.db().add(jSONArrayOptJSONArray4.optString(i5));
            }
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray(SDMAdConst.NETWORK_CUSTOM_KEY.CLICK_URL);
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                pkVar.ov().add(jSONArrayOptJSONArray5.optString(i6));
            }
        }
        pkVar.n(new h(jSONObject.optJSONObject("extension")));
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("game_conf");
        if (jSONObjectOptJSONObject18 != null) {
            pkVar.n(new bb(jSONObjectOptJSONObject18));
        }
        pkVar.n(new rf(jSONObject.optJSONObject("overlay")));
        pkVar.n(new t(jSONObject.optJSONArray("effects")));
        pkVar.ou(jSONObject.optInt("intercept_flag", 0));
        pkVar.wm(jSONObject.optInt("web_inspector", 0));
        pkVar.m(jSONObject.optInt("has_media_cache_action", 0));
        pkVar.hu(jSONObject.optInt("media_height_price_show", 0));
        pkVar.py(jSONObject.optString("phone_num"));
        pkVar.wm(jSONObject.optString("title"));
        pkVar.ou(jSONObject.optString("app_name"));
        pkVar.q(jSONObject.optLong("download_num"));
        pkVar.m(jSONObject.optString(BundleKey.DESCRIPTION));
        pkVar.hu(jSONObject.optString("button_text"));
        pkVar.a(jSONObject.optInt("ad_logo", 1));
        pkVar.l(jSONObject.optBoolean("isDirectDownload", false));
        String strOptString2 = jSONObject.optString("ext");
        pkVar.t(strOptString2);
        try {
            if (TextUtils.isEmpty(strOptString2)) {
                strS = null;
            } else {
                JSONObject jSONObject2 = new JSONObject(strOptString2);
                pkVar.ur(jSONObject2.optString("req_id"));
                pkVar.cp(jSONObject2.optString("req_id"));
                pkVar.bb(jSONObject2.optString(MediationConstant.EXTRA_ADID));
                DeviceUtils.n(jSONObject2.optLong("global_did", -1L));
                strS = jSONObject2.optString("app_id");
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(strS)) {
            strS = s.s();
        }
        pkVar.df(strS);
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject19 != null) {
            pkVar.n(q.n(jSONObjectOptJSONObject19.toString(), strS));
        } else {
            pkVar.n(qgVar);
        }
        pkVar.sz(jSONObject.optString(e.a.h));
        pkVar.pk(jSONObject.optInt("image_mode"));
        pkVar.ri(jSONObject.optInt("orientation", 1));
        pkVar.n((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        pkVar.qg((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        pkVar.s((float) jSONObject.optDouble("corner_radius", 0.0d));
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject(a.C0017a.c);
        JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("download_sdk_conf");
        pkVar.n(qg(jSONObjectOptJSONObject20));
        pkVar.n(w(jSONObjectOptJSONObject21));
        pkVar.qg(jSONObject.optLong("parse_material_ts", System.currentTimeMillis()));
        JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject("deep_link");
        if (jSONObjectOptJSONObject22 != null) {
            pkVar.n(new hd(jSONObjectOptJSONObject22));
        }
        pkVar.n(new cx(jSONObject));
        pkVar.n(new nf(jSONObject, String.valueOf(w.cy(pkVar)), yVar));
        pkVar.n(new b(jSONObject));
        pkVar.n(new cd(jSONObject));
        pkVar.n(new dn(jSONObject));
        pkVar.n(new com.byazt.oj.qg(jSONObject, com.byazt.yo.q.n()));
        pkVar.n(new dh(jSONObject));
        pkVar.n(new f(jSONObject));
        pkVar.n(new com.byazt.gct.e(jSONObject));
        pkVar.n(new pe(jSONObject));
        pkVar.n(new j(jSONObject));
        pkVar.wo(jSONObject.optInt("count_down"));
        pkVar.l(jSONObject.optLong("expiration_time"));
        pkVar.w(jSONObject.optLong("client_expiration_time"));
        pkVar.pk(jSONObject.optString("_child_metas"));
        pkVar.lh(jSONObject.optString("src_req_id"));
        pkVar.an(jSONObject.optInt("video_encode_type", 0));
        pkVar.cx(jSONObject.optInt("player_type", 0));
        pkVar.ae(jSONObject.optInt("video_voice_control", -1));
        pkVar.f(jSONObject.optInt("if_show_win", 1));
        if (!tj.l() && pkVar.io() == 1) {
            pkVar.an(0);
            pkVar.cx(0);
        }
        JSONObject jSONObjectOptJSONObject23 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject23 != null) {
            pkVar.n(new um(jSONObjectOptJSONObject23));
        }
        String strN = com.byazt.ukb.qg.n(jSONObject);
        pkVar.rv(strN);
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("self_reward_callback");
        if (jSONObjectOptJSONObject24 != null) {
            hf hfVar = new hf(jSONObjectOptJSONObject24);
            pkVar.n(hfVar);
            if (hfVar.n()) {
                pkVar.df(n(jSONObject, strN));
            }
        }
        pkVar.rf(jSONObject.optInt("if_both_open"));
        pkVar.dh(jSONObject.optInt("if_double_deeplink"));
        JSONObject jSONObjectOptJSONObject25 = jSONObject.optJSONObject("app_manage");
        if (jSONObjectOptJSONObject25 != null) {
            pkVar.n(l(jSONObjectOptJSONObject25));
            pkVar.hd(jSONObjectOptJSONObject25.toString());
        }
        JSONObject jSONObjectOptJSONObject26 = jSONObject.optJSONObject("easy_dl_dialog");
        if (jSONObjectOptJSONObject26 != null) {
            pkVar.n(s(jSONObjectOptJSONObject26));
        }
        JSONObject jSONObjectOptJSONObject27 = jSONObject.optJSONObject("easy_pl_material");
        if (jSONObjectOptJSONObject27 != null) {
            pkVar.tj(jSONObjectOptJSONObject27);
            pkVar.n(q(jSONObjectOptJSONObject27));
        }
        pkVar.j(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        pkVar.n(jSONObject.optInt("micro_app_type", -1));
        String strOptString3 = jSONObject.optString("app_manage_type", "0");
        if (strOptString3.equals("1")) {
            pkVar.v(1);
        } else {
            if (strOptString3.equals("2")) {
                pkVar.v(2);
            } else {
                i2 = 0;
                pkVar.v(0);
            }
            pkVar.n(x(jSONObject.optJSONObject("media_ext")));
            pkVar.k(jSONObject.optInt("if_block_lp", i2));
            pkVar.t(jSONObject.optInt("cache_sort", 1));
            pkVar.ur(jSONObject.optInt("if_sp_cache", 1));
            pkVar.bb(jSONObject.optInt("splash_timeout_stage", 1));
            pkVar.tj(jSONObject.optInt("page_render_type", 0));
            if (pkVar.el() == 1 && (jSONObjectOptJSONObject13 = jSONObject.optJSONObject("ugeno")) != null) {
                nVarN = n(jSONObjectOptJSONObject13, pkVar);
                pkVar.n(nVarN);
                if (!fs.n().qg(nVarN.n(), nVarN.qg())) {
                    com.byazt.jc.q.n(nVarN, (com.byazt.jc.q.qg) null);
                }
            }
            pkVar.rv(jSONObject.optInt("native_lp_tpl_id"));
            pkVar.w(jSONObject.optString("native_lp_data"));
            pkVar.x(jSONObject.optString("native_lp_ugen_url"));
            pkVar.fs(jSONObject.optString("native_lp_ugen_md5"));
            pkVar.fs(jSONObject.optBoolean("native_lp_is_preload"));
            pkVar.l(jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL));
            if (pkVar.ci()) {
                jSONObjectOptJSONObject12 = jSONObject.optJSONObject("native_lp_content");
                if (jSONObjectOptJSONObject12 != null) {
                    pkVar.q(jSONObjectOptJSONObject12);
                } else {
                    com.byazt.jc.q.n(pkVar.yw(), new com.byazt.jc.q.n() { // from class: com.byazt.vgx.qg.1
                        @Override // com.byazt.jc.q.n
                        public void n(int i7, String str6) {
                        }

                        @Override // com.byazt.jc.q.n
                        public void n(JSONObject jSONObject3) {
                            pkVar.q(jSONObject3);
                        }
                    });
                }
            }
            pkVar.cp(jSONObject.optInt("promotion_type"));
            jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
            if (jSONObjectOptJSONObject != null) {
                nVar = new com.byazt.ul.n();
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("product_infos");
                if (jSONArrayOptJSONArray2 != null) {
                    nVar.n(jSONArrayOptJSONArray2);
                }
                jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("coupon");
                if (jSONObjectOptJSONObject8 != null) {
                    nVar.n(jSONObjectOptJSONObject8);
                }
                jSONObjectOptJSONObject9 = jSONObjectOptJSONObject.optJSONObject("render_config");
                if (jSONObjectOptJSONObject9 != null) {
                    nVar.qg(jSONObjectOptJSONObject9);
                }
                jSONObjectOptJSONObject10 = jSONObjectOptJSONObject.optJSONObject("live_room_data");
                if (jSONObjectOptJSONObject10 != null) {
                    nVar.s(jSONObjectOptJSONObject10);
                }
                jSONObjectOptJSONObject11 = jSONObjectOptJSONObject.optJSONObject("ec_mall_conf");
                if (jSONObjectOptJSONObject11 != null) {
                    nVar.q(jSONObjectOptJSONObject11);
                }
                pkVar.n(nVar);
            }
            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
            if (jSONObjectOptJSONObject2 != null) {
                pkVar.n(n(jSONObjectOptJSONObject2, pkVar.ys()));
            }
            pkVar.ae(jSONObject.optString("ad_info"));
            pkVar.cy(jSONObject.optBoolean("close_on_dislike", false));
            pkVar.fi(jSONObject.optString("adx_name"));
            pkVar.e(jSONObject.optInt("endcard_close_time", 0));
            pkVar.yw(jSONObject.optInt("proportion_watching", 100));
            pkVar.hf(jSONObject.optInt("video_skip_result", 3));
            if (jSONObject.optInt("is_ec_mall", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            pkVar.hd(z);
            ojVar = new oj(jSONObject);
            pkVar.n(ojVar);
            if (ojVar.n()) {
                if (tj.l()) {
                    pkVar.cx(-2);
                } else {
                    pkVar.cx(0);
                }
            }
            pkVar.n(new ta(jSONObject));
            pkVar.n(new py(jSONObject, true));
            pkVar.n(new ae(jSONObject));
            n(pkVar, jSONObject);
            pkVar.cy(jSONObject.optJSONObject("meta_common_config"));
            com.byazt.ivn.s.n().n(pkVar);
            jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
            if (jSONObjectOptJSONObject3 != null) {
                fl flVar = new fl();
                flVar.n(jSONObjectOptJSONObject3.optInt("position", 2));
                flVar.qg(jSONObjectOptJSONObject3.optInt("left_or_right_margin", 16));
                flVar.s(jSONObjectOptJSONObject3.optInt("top_or_bottom_margin", 30));
                flVar.q(jSONObjectOptJSONObject3.optInt("skip_style", 1));
                flVar.l(jSONObjectOptJSONObject3.optInt("hide_native_skip_logo", 0));
                pkVar.n(flVar);
            }
            pkVar.nf(jSONObject.optInt("shake_value", 13));
            pkVar.kc(jSONObject.optInt("deep_shake_value"));
            pkVar.pe(jSONObject.optInt("rotation_angle", 50));
            pkVar.dg(jSONObject.optInt("dynamic_join_type", 0));
            pkVar.u(jSONObject.optInt("dynamic_join_duration", 0));
            pkVar.ln(jSONObject.optInt("calculation_method", 0));
            jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
            if (jSONObjectOptJSONObject4 != null) {
                he heVar = new he();
                heVar.n(jSONObjectOptJSONObject4.optInt("show_type", 0));
                heVar.qg(jSONObjectOptJSONObject4.optInt("blank", 90));
                heVar.s(jSONObjectOptJSONObject4.optInt("half_blank", 90));
                pkVar.n(heVar);
            }
            pkVar.lq(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
            pkVar.s(jSONObject.optBoolean("view_check_by_window", true));
            pkVar.q(jSONObject.optBoolean("view_check_by_click", true));
            pkVar.k(jSONObject.optString("adm"));
            pkVar.rv(jSONObject.optBoolean("is_cache"));
            pkVar.d(jSONObject.optString("log_ext"));
            pkVar.tj(jSONObject.optString("cache_ext"));
            strOptString = jSONObject.optString("req_id");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(pkVar.i())) {
                pkVar.cp(strOptString);
            }
            pkVar.n(jSONObject.optLong("cache_time"));
            pkVar.oa(jSONObject.optString("material_key"));
            pkVar.tj(jSONObject.optBoolean("need_get_materials"));
            pkVar.s(jSONObject.optLong("s_send_ts"));
            pkVar.n(wv.n(jSONObject.optJSONObject("wc_miniapp_info")));
            pkVar.dg(jSONObject.optString("live_room_id", str5));
            pkVar.ic(jSONObject.optInt("ad_type", 0));
            pkVar.ci(jSONObject.optInt("live_interaction_type", 1));
            pkVar.cy(jSONObject.optString("ec_schema", str5));
            pkVar.cy(jSONObject.optInt("draw_video_playcount", 2));
            jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
            if (jSONObjectOptJSONObject5 != null) {
                k kVar = new k();
                kVar.n(jSONObjectOptJSONObject5.optInt("style_type"));
                kVar.n(jSONObjectOptJSONObject5.optString(SDMAdConst.NETWORK_CUSTOM_KEY.IMAGE_URL));
                kVar.qg(jSONObjectOptJSONObject5.optInt("position"));
                kVar.n(jSONObjectOptJSONObject5.optDouble("image_height"));
                kVar.qg(jSONObjectOptJSONObject5.optString("image_gif_url"));
                kVar.qg(jSONObjectOptJSONObject5.optDouble("image_scale_rate"));
                kVar.s(jSONObjectOptJSONObject5.optDouble("image_gif_aspect_ratio"));
                pkVar.n(kVar);
            }
            pkVar.u(jSONObject.optString("ecom_live_params"));
            pkVar.l(jSONObject.optJSONObject("group_info"));
            pkVar.n(sz.n(jSONObject.optJSONObject("coupon")));
            pkVar.n(dg.n(jSONObject.optJSONObject("live_info")));
            pkVar.n(ic.n(jSONObject.optJSONObject("saas_info")));
            pkVar.n(ci.n(jSONObject.optJSONObject("saas_on_click_material")));
            pkVar.el(jSONObject.optInt("live_sdk_status_while_first_click", -1001));
            jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
            if (jSONObjectOptJSONObject6 != null) {
                i iVar = new i();
                iVar.n(jSONObjectOptJSONObject6.optInt("video_adapter_type", 1));
                iVar.qg(jSONObjectOptJSONObject6.optInt("video_mute_type", 1));
                pkVar.n(iVar);
            }
            jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
            if (jSONObjectOptJSONObject7 != null) {
                cp cpVar = new cp();
                cpVar.n(jSONObjectOptJSONObject7.optInt("click_trigger_type"));
                cpVar.n((float) jSONObjectOptJSONObject7.optDouble("shake_start_time", 0.0d));
                cpVar.qg((float) jSONObjectOptJSONObject7.optDouble("shake_end_time", 2.147483648E9d));
                pkVar.n(cpVar);
            }
            pkVar.lh(jSONObject.optInt("calculation_method_twist"));
            pkVar.oj(jSONObject.optString("dynamic_configs"));
            pkVar.z(jSONObject.optInt("gnd_prefetch_timing"));
            pkVar.wo(jSONObject.optString("gnd_prefetch_cache_key"));
            mapWl = pkVar.wl();
            if (mapWl == null) {
                mapWl = new HashMap<>();
                pkVar.n(mapWl);
            }
            strYk = pkVar.yk();
            if (strYk != null) {
                mapWl.put("ad_token", strYk);
                com.byazt.vyf.qg.n().qg(strYk);
            }
            if (jSONObjectOptJSONObject15 != null && h.n(pkVar)) {
                mapWl.put("style_category", Integer.valueOf(h.w(pkVar)));
            }
            pkVar.k(jSONObject.optJSONObject("applist_info"));
            pkVar.dn(jSONObject.optInt("click_freq"));
            pkVar.he(jSONObject.optInt("if_lpua_package"));
            pkVar.cp(jSONObject.optJSONObject("twist_config"));
            pkVar.d(jSONObject.optJSONObject("shake_interact_conf"));
            pkVar.oa(jSONObject.optJSONObject("twist_interact_conf"));
            pkVar.n(ur.n(jSONObject));
            pkVar.q(jSONObject.optString("temp_extra_info"));
            pkVar.qg(jSONObject.optJSONObject("sdk_derive_info"));
            pkVar.s(jSONObject.optJSONObject("c_s_ab_config"));
            pkVar.q(jSONObject.optInt("disable_video_join"));
            pkVar.x(jSONObject.optInt("disable_top_bar"));
            pkVar.fs(jSONObject.optInt("disable_rtn_button"));
            pkVar.qg(jSONObject.optInt("web_monitor_rate", 0));
            pkVar.w(jSONObject.optInt("disable_slide_return"));
            pkVar.vb(jSONObject.optInt("is_height_resize", 1));
            pkVar.qg(jSONObject.optBoolean("disable_safe_area"));
            jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
            if (jSONArrayOptJSONArray != null) {
                for (i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    pkVar.n(new lh(jSONArrayOptJSONArray.optJSONObject(i3)));
                }
            }
            pkVar.sz(jSONObject.optJSONObject("_meta_life_record"));
            if (i > 0) {
                iOptInt = i;
            } else {
                iOptInt = jSONObject.optInt("_ad_index", 1);
            }
            pkVar.sh(iOptInt);
            return pkVar;
        }
        i2 = 0;
        pkVar.n(x(jSONObject.optJSONObject("media_ext")));
        pkVar.k(jSONObject.optInt("if_block_lp", i2));
        pkVar.t(jSONObject.optInt("cache_sort", 1));
        pkVar.ur(jSONObject.optInt("if_sp_cache", 1));
        pkVar.bb(jSONObject.optInt("splash_timeout_stage", 1));
        pkVar.tj(jSONObject.optInt("page_render_type", 0));
        if (pkVar.el() == 1) {
            nVarN = n(jSONObjectOptJSONObject13, pkVar);
            pkVar.n(nVarN);
            if (!fs.n().qg(nVarN.n(), nVarN.qg())) {
                com.byazt.jc.q.n(nVarN, (com.byazt.jc.q.qg) null);
            }
        }
        pkVar.rv(jSONObject.optInt("native_lp_tpl_id"));
        pkVar.w(jSONObject.optString("native_lp_data"));
        pkVar.x(jSONObject.optString("native_lp_ugen_url"));
        pkVar.fs(jSONObject.optString("native_lp_ugen_md5"));
        pkVar.fs(jSONObject.optBoolean("native_lp_is_preload"));
        pkVar.l(jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL));
        if (pkVar.ci()) {
            jSONObjectOptJSONObject12 = jSONObject.optJSONObject("native_lp_content");
            if (jSONObjectOptJSONObject12 != null) {
                pkVar.q(jSONObjectOptJSONObject12);
            } else {
                com.byazt.jc.q.n(pkVar.yw(), new com.byazt.jc.q.n() { // from class: com.byazt.vgx.qg.1
                    @Override // com.byazt.jc.q.n
                    public void n(int i7, String str6) {
                    }

                    @Override // com.byazt.jc.q.n
                    public void n(JSONObject jSONObject3) {
                        pkVar.q(jSONObject3);
                    }
                });
            }
        }
        pkVar.cp(jSONObject.optInt("promotion_type"));
        jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
        if (jSONObjectOptJSONObject != null) {
            nVar = new com.byazt.ul.n();
            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("product_infos");
            if (jSONArrayOptJSONArray2 != null) {
                nVar.n(jSONArrayOptJSONArray2);
            }
            jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("coupon");
            if (jSONObjectOptJSONObject8 != null) {
                nVar.n(jSONObjectOptJSONObject8);
            }
            jSONObjectOptJSONObject9 = jSONObjectOptJSONObject.optJSONObject("render_config");
            if (jSONObjectOptJSONObject9 != null) {
                nVar.qg(jSONObjectOptJSONObject9);
            }
            jSONObjectOptJSONObject10 = jSONObjectOptJSONObject.optJSONObject("live_room_data");
            if (jSONObjectOptJSONObject10 != null) {
                nVar.s(jSONObjectOptJSONObject10);
            }
            jSONObjectOptJSONObject11 = jSONObjectOptJSONObject.optJSONObject("ec_mall_conf");
            if (jSONObjectOptJSONObject11 != null) {
                nVar.q(jSONObjectOptJSONObject11);
            }
            pkVar.n(nVar);
        }
        jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject2 != null) {
            pkVar.n(n(jSONObjectOptJSONObject2, pkVar.ys()));
        }
        pkVar.ae(jSONObject.optString("ad_info"));
        pkVar.cy(jSONObject.optBoolean("close_on_dislike", false));
        pkVar.fi(jSONObject.optString("adx_name"));
        pkVar.e(jSONObject.optInt("endcard_close_time", 0));
        pkVar.yw(jSONObject.optInt("proportion_watching", 100));
        pkVar.hf(jSONObject.optInt("video_skip_result", 3));
        if (jSONObject.optInt("is_ec_mall", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        pkVar.hd(z);
        ojVar = new oj(jSONObject);
        pkVar.n(ojVar);
        if (ojVar.n()) {
            if (tj.l()) {
                pkVar.cx(-2);
            } else {
                pkVar.cx(0);
            }
        }
        pkVar.n(new ta(jSONObject));
        pkVar.n(new py(jSONObject, true));
        pkVar.n(new ae(jSONObject));
        n(pkVar, jSONObject);
        pkVar.cy(jSONObject.optJSONObject("meta_common_config"));
        com.byazt.ivn.s.n().n(pkVar);
        jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
        if (jSONObjectOptJSONObject3 != null) {
            fl flVar2 = new fl();
            flVar2.n(jSONObjectOptJSONObject3.optInt("position", 2));
            flVar2.qg(jSONObjectOptJSONObject3.optInt("left_or_right_margin", 16));
            flVar2.s(jSONObjectOptJSONObject3.optInt("top_or_bottom_margin", 30));
            flVar2.q(jSONObjectOptJSONObject3.optInt("skip_style", 1));
            flVar2.l(jSONObjectOptJSONObject3.optInt("hide_native_skip_logo", 0));
            pkVar.n(flVar2);
        }
        pkVar.nf(jSONObject.optInt("shake_value", 13));
        pkVar.kc(jSONObject.optInt("deep_shake_value"));
        pkVar.pe(jSONObject.optInt("rotation_angle", 50));
        pkVar.dg(jSONObject.optInt("dynamic_join_type", 0));
        pkVar.u(jSONObject.optInt("dynamic_join_duration", 0));
        pkVar.ln(jSONObject.optInt("calculation_method", 0));
        jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
        if (jSONObjectOptJSONObject4 != null) {
            he heVar2 = new he();
            heVar2.n(jSONObjectOptJSONObject4.optInt("show_type", 0));
            heVar2.qg(jSONObjectOptJSONObject4.optInt("blank", 90));
            heVar2.s(jSONObjectOptJSONObject4.optInt("half_blank", 90));
            pkVar.n(heVar2);
        }
        pkVar.lq(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        pkVar.s(jSONObject.optBoolean("view_check_by_window", true));
        pkVar.q(jSONObject.optBoolean("view_check_by_click", true));
        pkVar.k(jSONObject.optString("adm"));
        pkVar.rv(jSONObject.optBoolean("is_cache"));
        pkVar.d(jSONObject.optString("log_ext"));
        pkVar.tj(jSONObject.optString("cache_ext"));
        strOptString = jSONObject.optString("req_id");
        if (!TextUtils.isEmpty(strOptString)) {
            pkVar.cp(strOptString);
        }
        pkVar.n(jSONObject.optLong("cache_time"));
        pkVar.oa(jSONObject.optString("material_key"));
        pkVar.tj(jSONObject.optBoolean("need_get_materials"));
        pkVar.s(jSONObject.optLong("s_send_ts"));
        pkVar.n(wv.n(jSONObject.optJSONObject("wc_miniapp_info")));
        pkVar.dg(jSONObject.optString("live_room_id", str5));
        pkVar.ic(jSONObject.optInt("ad_type", 0));
        pkVar.ci(jSONObject.optInt("live_interaction_type", 1));
        pkVar.cy(jSONObject.optString("ec_schema", str5));
        pkVar.cy(jSONObject.optInt("draw_video_playcount", 2));
        jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (jSONObjectOptJSONObject5 != null) {
            k kVar2 = new k();
            kVar2.n(jSONObjectOptJSONObject5.optInt("style_type"));
            kVar2.n(jSONObjectOptJSONObject5.optString(SDMAdConst.NETWORK_CUSTOM_KEY.IMAGE_URL));
            kVar2.qg(jSONObjectOptJSONObject5.optInt("position"));
            kVar2.n(jSONObjectOptJSONObject5.optDouble("image_height"));
            kVar2.qg(jSONObjectOptJSONObject5.optString("image_gif_url"));
            kVar2.qg(jSONObjectOptJSONObject5.optDouble("image_scale_rate"));
            kVar2.s(jSONObjectOptJSONObject5.optDouble("image_gif_aspect_ratio"));
            pkVar.n(kVar2);
        }
        pkVar.u(jSONObject.optString("ecom_live_params"));
        pkVar.l(jSONObject.optJSONObject("group_info"));
        pkVar.n(sz.n(jSONObject.optJSONObject("coupon")));
        pkVar.n(dg.n(jSONObject.optJSONObject("live_info")));
        pkVar.n(ic.n(jSONObject.optJSONObject("saas_info")));
        pkVar.n(ci.n(jSONObject.optJSONObject("saas_on_click_material")));
        pkVar.el(jSONObject.optInt("live_sdk_status_while_first_click", -1001));
        jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
        if (jSONObjectOptJSONObject6 != null) {
            i iVar2 = new i();
            iVar2.n(jSONObjectOptJSONObject6.optInt("video_adapter_type", 1));
            iVar2.qg(jSONObjectOptJSONObject6.optInt("video_mute_type", 1));
            pkVar.n(iVar2);
        }
        jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
        if (jSONObjectOptJSONObject7 != null) {
            cp cpVar2 = new cp();
            cpVar2.n(jSONObjectOptJSONObject7.optInt("click_trigger_type"));
            cpVar2.n((float) jSONObjectOptJSONObject7.optDouble("shake_start_time", 0.0d));
            cpVar2.qg((float) jSONObjectOptJSONObject7.optDouble("shake_end_time", 2.147483648E9d));
            pkVar.n(cpVar2);
        }
        pkVar.lh(jSONObject.optInt("calculation_method_twist"));
        pkVar.oj(jSONObject.optString("dynamic_configs"));
        pkVar.z(jSONObject.optInt("gnd_prefetch_timing"));
        pkVar.wo(jSONObject.optString("gnd_prefetch_cache_key"));
        mapWl = pkVar.wl();
        if (mapWl == null) {
            mapWl = new HashMap<>();
            pkVar.n(mapWl);
        }
        strYk = pkVar.yk();
        if (strYk != null) {
            mapWl.put("ad_token", strYk);
            com.byazt.vyf.qg.n().qg(strYk);
        }
        if (jSONObjectOptJSONObject15 != null) {
            mapWl.put("style_category", Integer.valueOf(h.w(pkVar)));
        }
        pkVar.k(jSONObject.optJSONObject("applist_info"));
        pkVar.dn(jSONObject.optInt("click_freq"));
        pkVar.he(jSONObject.optInt("if_lpua_package"));
        pkVar.cp(jSONObject.optJSONObject("twist_config"));
        pkVar.d(jSONObject.optJSONObject("shake_interact_conf"));
        pkVar.oa(jSONObject.optJSONObject("twist_interact_conf"));
        pkVar.n(ur.n(jSONObject));
        pkVar.q(jSONObject.optString("temp_extra_info"));
        pkVar.qg(jSONObject.optJSONObject("sdk_derive_info"));
        pkVar.s(jSONObject.optJSONObject("c_s_ab_config"));
        pkVar.q(jSONObject.optInt("disable_video_join"));
        pkVar.x(jSONObject.optInt("disable_top_bar"));
        pkVar.fs(jSONObject.optInt("disable_rtn_button"));
        pkVar.qg(jSONObject.optInt("web_monitor_rate", 0));
        pkVar.w(jSONObject.optInt("disable_slide_return"));
        pkVar.vb(jSONObject.optInt("is_height_resize", 1));
        pkVar.qg(jSONObject.optBoolean("disable_safe_area"));
        jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
        if (jSONArrayOptJSONArray != null) {
            while (i3 < jSONArrayOptJSONArray.length()) {
                pkVar.n(new lh(jSONArrayOptJSONArray.optJSONObject(i3)));
            }
        }
        pkVar.sz(jSONObject.optJSONObject("_meta_life_record"));
        if (i > 0) {
            iOptInt = i;
        } else {
            iOptInt = jSONObject.optInt("_ad_index", 1);
        }
        pkVar.sh(iOptInt);
        return pkVar;
    }

    private static com.byazt.ai.n n(JSONObject jSONObject, pk pkVar) {
        com.byazt.ai.n nVar = new com.byazt.ai.n();
        nVar.n(jSONObject.optString("id"));
        nVar.qg(jSONObject.optString("md5"));
        nVar.s(jSONObject.optString(ImagesContract.URL));
        nVar.n(jSONObject.optInt("scene"));
        return nVar;
    }

    private static void n(pk pkVar, JSONObject jSONObject) {
        hd hdVarSz;
        if (pkVar == null || jSONObject == null) {
            return;
        }
        if ((oj.n(pkVar) || com.byazt.gct.e.n(pkVar)) && (hdVarSz = pkVar.sz()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            df dfVar = new df();
            if (jSONObjectOptJSONObject != null) {
                dfVar.n(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
                dfVar.l(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
                dfVar.qg(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
                dfVar.s(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
                dfVar.q(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                dfVar.n(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
                pkVar.n(dfVar);
            } else {
                Map<String, String> mapN = com.byazt.rd.s.n(hdVarSz.qg());
                if (mapN == null || mapN.size() <= 0) {
                    return;
                }
                dfVar.n(mapN.get("user_id"));
                dfVar.l(mapN.get("request_id"));
                dfVar.qg(mapN.get("room_id"));
                dfVar.s(mapN.get("live_short_touch_params"));
                dfVar.q(mapN.get("extra_pangle_scheme_params"));
                pkVar.n(dfVar);
            }
            pkVar.k(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    public static com.byazt.gct.l qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gct.l lVar = new com.byazt.gct.l();
        lVar.s(jSONObject.optString("app_name"));
        lVar.q(jSONObject.optString("package_name"));
        lVar.qg(jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL));
        lVar.n(jSONObject.optInt("score", 4));
        lVar.qg(jSONObject.optInt("comment_num", 0));
        lVar.s(jSONObject.optInt("app_size", 0));
        lVar.n(jSONObject.optString("quick_app_url", ""));
        return lVar;
    }

    private static com.byazt.gct.a w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gct.a aVar = new com.byazt.gct.a();
        aVar.n(jSONObject.optInt("ah", 1));
        aVar.qg(jSONObject.optInt("am", 1));
        return aVar;
    }

    private static el n(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        el elVar = new el();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        elVar.n((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        elVar.x(jSONObject.optInt("splash_style_id", 0));
        elVar.n(jSONObject.optString("splash_clicktext", ""));
        elVar.qg(jSONObject.optInt("area_height", 50));
        elVar.s(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            elVar.q(jSONObject.optInt("area_blank_height", 32));
        } else {
            elVar.q(jSONObject.optInt("area_blank_height", 82));
        }
        elVar.l(jSONObject.optInt("half_blank_height", 56));
        elVar.qg(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        elVar.s(jSONObject.optString("top_splash_clicktext"));
        elVar.n(jSONObject.optJSONObject("text_config"));
        elVar.qg(jSONObject.optJSONObject("top_text_config"));
        elVar.fs(jSONObject.optInt("sliding_distance", 5));
        elVar.n(jSONObject.optJSONObject("slide_area"), i);
        elVar.w(jSONObject.optInt("splash_load_time_optimization"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mock_interact");
        if (jSONObjectOptJSONObject != null) {
            try {
                elVar.n((float) jSONObjectOptJSONObject.optDouble("enable_ratio", 0.0d));
                elVar.rv(jSONObjectOptJSONObject.optInt("backup_add", 0));
                elVar.tj(jSONObjectOptJSONObject.optInt("slide_direction", 0));
                elVar.cp(jSONObjectOptJSONObject.optInt("slide_threshold", 55));
                elVar.d(jSONObjectOptJSONObject.optInt("view_height_dynamic", 0));
                elVar.qg((float) jSONObjectOptJSONObject.optDouble("view_height_percent", 0.0d));
                elVar.oa(jSONObjectOptJSONObject.optInt("view_post", 100));
                elVar.sz(jSONObjectOptJSONObject.optInt("ignore_up", 0));
                elVar.k(jSONObjectOptJSONObject.optInt("long_press_duration", 0));
                elVar.cy(jSONObjectOptJSONObject.optInt("long_press_threshold", 10));
            } catch (Exception unused) {
                com.byazt.tk.k.qg("SplashControl", "interact parse error");
            }
        }
        return elVar;
    }

    public static m s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        mVar.s(jSONObject.optString("ugen_dialog_md5"));
        mVar.qg(jSONObject.optString("ugen_dialog_url"));
        mVar.n(jSONObject.optString("dialog_style"));
        return mVar;
    }

    public static hu q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hu huVar = new hu();
        huVar.q(jSONObject.optString("bg_url"));
        huVar.s(jSONObject.optString("title"));
        huVar.n(jSONObject.optString("reward_image_url"));
        huVar.qg(jSONObject.optString("reward_title"));
        huVar.l(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return huVar;
    }

    public static com.byazt.gct.w l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gct.w wVar = new com.byazt.gct.w();
        wVar.q(jSONObject.optString("developer_name"));
        wVar.qg(jSONObject.optString("app_version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            wVar.qg(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    wVar.n(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        wVar.n(jSONObject.optString("permissions_url"));
        wVar.n(jSONObject.optInt("score", 0));
        wVar.n(jSONObject.optJSONArray("creative_tags"));
        wVar.l(jSONObject.optString("privacy_policy_url"));
        wVar.w(jSONObject.optString("desc_url"));
        wVar.x(jSONObject.optString("reg_number"));
        wVar.fs(jSONObject.optString("reg_url"));
        wVar.tj(jSONObject.optString("app_name"));
        wVar.rv(jSONObject.optString("package_name"));
        return wVar;
    }

    private static Map<String, Object> x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    public static int n(pk pkVar, int i) {
        if (TextUtils.isEmpty(pkVar.q()) || pkVar.q().length() <= 1) {
            return 401;
        }
        int iN = n(pkVar.sz());
        if (iN != 200) {
            return iN;
        }
        int iN2 = n(pkVar);
        if (iN2 != 200) {
            return iN2;
        }
        int iRv = pkVar.rv();
        if (iRv == 2 || iRv == 3) {
            if (TextUtils.isEmpty(pkVar.fs())) {
                return 405;
            }
        } else if (iRv == 4) {
            iN2 = n(pkVar.k());
            if (iN2 != 200) {
                return iN2;
            }
        } else if (iRv == 5 && TextUtils.isEmpty(pkVar.om())) {
            return TTAdConstant.INTERACTION_TYPE_CODE;
        }
        int iGe = pkVar.ge();
        if (iGe == 2 || iGe == 3 || iGe == 4) {
            iN2 = qg(pkVar.jo());
            if (iN2 != 200) {
            }
        } else if (iGe == 5 || iGe == 15) {
            iN2 = ta.tj(pkVar);
            if (iN2 != 200) {
                return iN2;
            }
        } else if (iGe == 16) {
            iN2 = qg(pkVar.jo());
            if (iN2 != 200) {
            }
        } else if (iGe == 166 && (iN2 = qg(pkVar, i)) != 200) {
            return iN2;
        }
        return iN2;
    }

    private static int qg(pk pkVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!oj.n(pkVar)) {
                return TTAdConstant.LIVE_AD_CODE;
            }
            if (TextUtils.isEmpty(oj.x(pkVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    private static int n(pk pkVar) {
        if (!(pkVar.ge() == 166 && oj.n(pkVar)) || tj.l()) {
            return 200;
        }
        com.byazt.tk.k.n("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int n(hd hdVar) {
        if (hdVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(hdVar.qg()) && !TextUtils.isEmpty(hdVar.q())) {
            return (hdVar.l() == 1 || hdVar.l() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(hdVar.qg())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int n(com.byazt.gct.l lVar) {
        if (lVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(lVar.qg()) ? 407 : 200;
    }

    private static int qg(List<v> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (v vVar : list) {
            if (vVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(vVar.n())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    public static void n(List<pk> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<pk> listSubList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<pk> it = listSubList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pv());
        }
        if (jSONArray.length() > 0) {
            list.get(0).pk(jSONArray.toString());
        }
    }

    private static int n(JSONObject jSONObject, String str) {
        int i = 4;
        if ("download".equals(str)) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(a.C0017a.c);
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("package_name") : null;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString("package_name");
            }
            if (oa.l(rv.getContext(), strOptString)) {
                return 4;
            }
            i = 2;
            if (TextUtils.isEmpty(jSONObject.optString("market_url", ""))) {
                return com.byazt.ges.n.n(jSONObject) ? 2 : 1;
            }
        }
        return i;
    }
}
