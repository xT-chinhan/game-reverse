package com.byazt.sd;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.hg.aa;
import com.byazt.hg.d;
import com.byazt.hg.er;
import com.byazt.hg.f;
import com.byazt.hg.gu;
import com.byazt.hg.hs;
import com.byazt.hg.i;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.lv;
import com.byazt.hg.nw;
import com.byazt.hg.o;
import com.byazt.hg.od;
import com.byazt.hg.of;
import com.byazt.hg.pq;
import com.byazt.hg.qi;
import com.byazt.hg.qv;
import com.byazt.hg.r;
import com.byazt.hg.s;
import com.byazt.hg.u;
import com.byazt.hg.v;
import com.byazt.hg.vj;
import com.byazt.hg.wt;
import com.byazt.mg.PluginConstants;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 37})
public class pr {
    public static Pair<com.byazt.hg.pr, ArrayList<Integer>> pr(JSONObject jSONObject, com.byazt.qe.hw hwVar, i iVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.byazt.hg.pr prVar = new com.byazt.hg.pr();
            prVar.pr(jSONObject.optString(Constants.Bidding.REQUEST_ID));
            prVar.pr(jSONObject.optInt("ret"));
            prVar.hw(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.byazt.wt.a.pr(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (prVar.pr() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    i++;
                    of ofVarPr = pr(jSONObjectOptJSONObject, hwVar, iVar, i);
                    int iPr = pr(ofVarPr, hwVar != null ? hwVar.a() : 0);
                    boolean zD = ofVarPr.d();
                    String strJw = ofVarPr.jw();
                    if (ofVarPr != null) {
                        if (iPr != 200) {
                            if (zOptBoolean || zD) {
                                if (!TextUtils.isEmpty(strJw)) {
                                }
                            }
                        }
                        ofVarPr.ww(strOptString);
                        ofVarPr.hn(j);
                        ofVarPr.zo(zOptBoolean);
                        prVar.pr(ofVarPr);
                    }
                    arrayList.add(Integer.valueOf(iPr));
                }
            }
            return new Pair<>(prVar, arrayList);
        } catch (Throwable th) {
            return null;
        }
    }

    public static of pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return pr(jSONObject, (com.byazt.qe.hw) null, (i) null, 0);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static of pr(JSONObject jSONObject, com.byazt.qe.hw hwVar, i iVar, int i) {
        JSONObject jSONObject2;
        String strHn;
        int i2;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        if (iVar != null && hwVar != null) {
            a.hw().hn(jSONObject.optInt("settings_open", 1));
        }
        final of ofVar = new of();
        ofVar.e(jSONObject.optString("s_sig_ts"));
        ofVar.w(jSONObject.optLong("ad_rec_stamp", 0L));
        ofVar.s(jSONObject.optInt("interaction_type"));
        ofVar.lb(jSONObject.optString("target_url"));
        ofVar.g(jSONObject.optInt("use_sdk_player", 0));
        ofVar.m(jSONObject.optInt("use_media_video_player", 0));
        ofVar.er(jSONObject.optInt("landing_scroll_percentage", -1));
        ofVar.qa(jSONObject.optString("gecko_id"));
        ofVar.vk(jSONObject.optBoolean("is_cache"));
        ofVar.i(jSONObject.optInt("cache_type", 100));
        com.byazt.xe.hn.pr(ofVar, jSONObject);
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("set_click_type");
            ofVar.hw(jSONObjectOptJSONObject2.optDouble("cta", 2.0d));
            ofVar.pr(jSONObjectOptJSONObject2.optDouble("other", 2.0d));
        }
        ofVar.k(jSONObject.optInt("feed_video_finish_type"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("extension");
        ofVar.x(jSONObjectOptJSONObject3);
        ofVar.c(jSONObject.optJSONObject("overlay"));
        ofVar.rc(jSONObject.optString(MediationConstant.EXTRA_ADID));
        ofVar.hn(jSONObject.optInt("get_phone_num_status"));
        ofVar.yb(jSONObject.optString("source"));
        ofVar.y(jSONObject.optString("package_name"));
        ofVar.rc(jSONObject.optInt("play_bar_show_time", -200));
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("icon");
        ofVar.aj(jSONObject.optBoolean("screenshot", false));
        ofVar.cz(jSONObject.optInt("play_bar_style", 0));
        ofVar.nl(jSONObject.optString("market_url", ""));
        ofVar.qa(jSONObject.optInt("video_adaptation", 0));
        ofVar.yb(jSONObject.optInt("feed_video_opentype", 0));
        ofVar.lb(jSONObject.optInt("feed_reward_type", -1));
        ofVar.uc(jSONObject.optJSONObject("session_params"));
        ofVar.fw(jSONObject.optJSONObject("cache_control"));
        ofVar.ww(jSONObject.optString("auction_price", ""));
        ofVar.nw(jSONObject.optInt("no_default_ttdsp_price", 0));
        int iOptInt = jSONObject.optInt("meta_hashcode", 0);
        ofVar.c(iOptInt != 0 ? iOptInt : (int) SystemClock.elapsedRealtime());
        String str = "width";
        String str2 = "height";
        if (jSONObjectOptJSONObject4 != null) {
            com.byazt.hg.y yVar = new com.byazt.hg.y();
            yVar.pr(jSONObjectOptJSONObject4.optString(BreakpointSQLiteKey.URL));
            yVar.hw(jSONObjectOptJSONObject4.optInt("height"));
            yVar.pr(jSONObjectOptJSONObject4.optInt("width"));
            ofVar.pr(yVar);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ImageViewManager.NAME);
        if (jSONArrayOptJSONArray == null) {
            jSONObject2 = jSONObjectOptJSONObject3;
        } else {
            int i3 = 0;
            while (i3 < jSONArrayOptJSONArray.length()) {
                com.byazt.hg.y yVar2 = new com.byazt.hg.y();
                JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i3);
                yVar2.pr(jSONObjectOptJSONObject5.optString(BreakpointSQLiteKey.URL));
                yVar2.hw(jSONObjectOptJSONObject5.optInt(str2));
                yVar2.pr(jSONObjectOptJSONObject5.optInt(str));
                yVar2.pr(jSONObjectOptJSONObject5.optInt("duration"));
                yVar2.pr(jSONObjectOptJSONObject5.optBoolean("image_preview"));
                yVar2.hw(jSONObjectOptJSONObject5.optString("image_key"));
                ofVar.hw(yVar2);
                i3++;
                jSONObjectOptJSONObject3 = jSONObject3;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                str = str;
                str2 = str2;
            }
            jSONObject2 = jSONObjectOptJSONObject3;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                ofVar.df().add(jSONArrayOptJSONArray2.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("click_url");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                ofVar.tt().add(jSONArrayOptJSONArray3.optString(i5));
            }
        }
        ofVar.pr(new com.byazt.hg.b(jSONObject.optJSONObject("extension")));
        ofVar.pr(new r(jSONObject.optJSONObject("overlay")));
        ofVar.pr(new com.byazt.hg.iu(jSONObject.optJSONArray("effects")));
        ofVar.ny(jSONObject.optInt("intercept_flag", 0));
        ofVar.fo(jSONObject.optInt("web_inspector", 0));
        ofVar.a(jSONObject.optString("phone_num"));
        ofVar.cz(jSONObject.optString(BundleKey.TITLE));
        ofVar.x(jSONObject.optLong("download_num"));
        ofVar.ny(jSONObject.optString(BundleKey.DESCRIPTION));
        ofVar.fo(jSONObject.optString("button_text"));
        ofVar.a(jSONObject.optInt("ad_logo", 1));
        ofVar.hn(jSONObject.optBoolean("isDirectDownload", false));
        String strOptString = jSONObject.optString("ext");
        ofVar.z(strOptString);
        try {
            if (TextUtils.isEmpty(strOptString)) {
                strHn = null;
            } else {
                JSONObject jSONObject4 = new JSONObject(strOptString);
                ofVar.b(jSONObject4.optString("req_id"));
                ofVar.vk(jSONObject4.optString("req_id"));
                ofVar.iu(jSONObject4.optString(MediationConstant.EXTRA_ADID));
                DeviceUtils.pr(jSONObject4.optLong("global_did", -1L));
                strHn = jSONObject4.optString(PluginConstants.KEY_APP_ID);
            }
        } catch (Exception e) {
            strHn = null;
        }
        if (TextUtils.isEmpty(strHn)) {
            strHn = com.byazt.zb.pr.hn();
        }
        ofVar.ls(strHn);
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject6 != null) {
            ofVar.pr(com.byazt.wt.ve.pr(jSONObjectOptJSONObject6.toString(), strHn));
        } else {
            ofVar.pr(hwVar);
        }
        ofVar.m(jSONObject.optString(IAction.PurchaseKey.Price));
        ofVar.qn(jSONObject.optInt("image_mode"));
        ofVar.ie(jSONObject.optInt("orientation", 1));
        ofVar.pr((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        ofVar.hw((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        ofVar.hn((float) jSONObject.optDouble("corner_radius", 0.0d));
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("app");
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("download_sdk_conf");
        ofVar.pr(hw(jSONObjectOptJSONObject7));
        ofVar.pr(uc(jSONObjectOptJSONObject8));
        ofVar.hw(jSONObject.optLong("parse_material_ts", System.currentTimeMillis()));
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("deep_link");
        if (jSONObjectOptJSONObject9 != null) {
            ofVar.pr(new com.byazt.hg.yb(jSONObjectOptJSONObject9));
        }
        ofVar.pr(new jn(jSONObject));
        ofVar.pr(new ie(jSONObject, String.valueOf(ls.m(ofVar)), iVar));
        ofVar.pr(new nw(jSONObject));
        ofVar.pr(new com.byazt.hg.lb(jSONObject));
        ofVar.pr(new gu(jSONObject));
        ofVar.pr(new com.byazt.dw.hw(jSONObject, com.byazt.pw.x.pr()));
        ofVar.pr(new hs(jSONObject));
        ofVar.pr(new s(jSONObject));
        ofVar.pr(new f(jSONObject));
        ofVar.pr(new o(jSONObject));
        ofVar.pr(new com.byazt.hg.ww(jSONObject));
        ofVar.of(jSONObject.optInt("count_down"));
        ofVar.c(jSONObject.optLong("expiration_time"));
        ofVar.uc(jSONObject.optLong("client_expiration_time"));
        ofVar.qn(jSONObject.optString("_child_metas"));
        ofVar.gz(jSONObject.optString("src_req_id"));
        ofVar.ww(jSONObject.optInt("video_encode_type", 0));
        ofVar.l(jSONObject.optInt("player_type", 0));
        ofVar.n(jSONObject.optInt("video_voice_control", -1));
        ofVar.e(jSONObject.optInt("if_show_win", 1));
        if (!iu.x() && ofVar.sd() == 1) {
            ofVar.ww(0);
            ofVar.l(0);
        }
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject10 != null) {
            ofVar.pr(new com.byazt.hg.qa(jSONObjectOptJSONObject10));
        }
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("self_reward_callback");
        if (jSONObjectOptJSONObject11 != null) {
            vj vjVar = new vj(jSONObjectOptJSONObject11);
            ofVar.pr(vjVar);
            if (vjVar.pr()) {
                ofVar.ls(zo(jSONObject));
            }
        }
        ofVar.r(jSONObject.optInt("if_both_open"));
        ofVar.hs(jSONObject.optInt("if_double_deeplink"));
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("app_manage");
        if (jSONObjectOptJSONObject12 != null) {
            ofVar.pr(c(jSONObjectOptJSONObject12));
            ofVar.nt(jSONObjectOptJSONObject12.toString());
        }
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("easy_dl_dialog");
        if (jSONObjectOptJSONObject13 != null) {
            ofVar.pr(hn(jSONObjectOptJSONObject13));
        }
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("easy_pl_material");
        if (jSONObjectOptJSONObject14 != null) {
            ofVar.zo(jSONObjectOptJSONObject14);
            ofVar.pr(x(jSONObjectOptJSONObject14));
        }
        ofVar.y(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        ofVar.pr(jSONObject.optInt("micro_app_type", -1));
        String strOptString2 = jSONObject.optString("app_manage_type", "0");
        if (strOptString2.equals("1")) {
            ofVar.nl(1);
            i2 = 0;
        } else if (strOptString2.equals("2")) {
            ofVar.nl(2);
            i2 = 0;
        } else {
            i2 = 0;
            ofVar.nl(0);
        }
        ofVar.pr(fw(jSONObject.optJSONObject("media_ext")));
        ofVar.ho(jSONObject.optInt("if_block_lp", i2));
        ofVar.z(jSONObject.optInt("cache_sort", 1));
        ofVar.b(jSONObject.optInt("if_sp_cache", 1));
        ofVar.iu(jSONObject.optInt("splash_timeout_stage", 1));
        ofVar.vk(jSONObject.optInt("page_render_type", 0));
        if (ofVar.vj() == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("ugeno")) != null) {
            com.byazt.qk.pr prVarPr = pr(jSONObjectOptJSONObject, ofVar);
            ofVar.pr(prVarPr);
            if (!com.byazt.ea.zo.pr().hw(prVarPr.pr(), prVarPr.hw())) {
                com.byazt.pk.hn.pr(prVarPr, (com.byazt.pk.hn.hw) null);
            }
        }
        ofVar.aj(jSONObject.optInt("native_lp_tpl_id"));
        ofVar.uc(jSONObject.optString("native_lp_data"));
        ofVar.fw(jSONObject.optString("native_lp_ugen_url"));
        ofVar.zo(jSONObject.optString("native_lp_ugen_md5"));
        ofVar.uc(jSONObject.optBoolean("native_lp_is_preload"));
        ofVar.c(jSONObject.optString("download_url"));
        if (ofVar.bm()) {
            JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("native_lp_content");
            if (jSONObjectOptJSONObject15 != null) {
                ofVar.hw(jSONObjectOptJSONObject15);
            } else {
                com.byazt.pk.hn.pr(ofVar.nw(), new com.byazt.pk.hn.pr() { // from class: com.byazt.sd.pr.1
                    @Override // com.byazt.pk.hn.pr
                    public void pr(JSONObject jSONObject5) {
                        ofVar.hw(jSONObject5);
                    }

                    @Override // com.byazt.pk.hn.pr
                    public void pr(int i6, String str3) {
                    }
                });
            }
        }
        ofVar.w(jSONObject.optInt("promotion_type"));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("dylite_info");
        if (jSONObjectOptJSONObject16 != null) {
            com.byazt.ze.pr prVar = new com.byazt.ze.pr();
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject16.optJSONArray("product_infos");
            if (jSONArrayOptJSONArray4 != null) {
                prVar.pr(jSONArrayOptJSONArray4);
            }
            JSONObject jSONObjectOptJSONObject17 = jSONObjectOptJSONObject16.optJSONObject("coupon");
            if (jSONObjectOptJSONObject17 != null) {
                prVar.pr(jSONObjectOptJSONObject17);
            }
            JSONObject jSONObjectOptJSONObject18 = jSONObjectOptJSONObject16.optJSONObject("render_config");
            if (jSONObjectOptJSONObject18 != null) {
                prVar.hw(jSONObjectOptJSONObject18);
            }
            JSONObject jSONObjectOptJSONObject19 = jSONObjectOptJSONObject16.optJSONObject("live_room_data");
            if (jSONObjectOptJSONObject19 != null) {
                prVar.hn(jSONObjectOptJSONObject19);
            }
            JSONObject jSONObjectOptJSONObject20 = jSONObjectOptJSONObject16.optJSONObject("ec_mall_conf");
            if (jSONObjectOptJSONObject20 != null) {
                prVar.x(jSONObjectOptJSONObject20);
            }
            ofVar.pr(prVar);
        }
        JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject21 != null) {
            ofVar.pr(pr(jSONObjectOptJSONObject21, ofVar.rf()));
        }
        ofVar.n(jSONObject.optString("ad_info"));
        ofVar.g(jSONObject.optBoolean("close_on_dislike", false));
        ofVar.s(jSONObject.optString("adx_name"));
        ofVar.bm(jSONObject.optInt("endcard_close_time", 0));
        ofVar.jn(jSONObject.optInt("proportion_watching", 100));
        ofVar.mw(jSONObject.optInt("video_skip_result", 3));
        ofVar.ho(jSONObject.optInt("is_ec_mall", 0) == 1);
        v vVar = new v(jSONObject);
        ofVar.pr(vVar);
        if (vVar.pr()) {
            if (iu.x()) {
                ofVar.l(-2);
            } else {
                ofVar.l(0);
            }
        }
        ofVar.pr(new qv(jSONObject));
        ofVar.pr(new com.byazt.hg.cz(jSONObject, true));
        ofVar.pr(new com.byazt.hg.e(jSONObject));
        pr(ofVar, jSONObject);
        JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject("skip_control");
        if (jSONObjectOptJSONObject22 != null) {
            wt wtVar = new wt();
            wtVar.pr(jSONObjectOptJSONObject22.optInt("position", 2));
            wtVar.hw(jSONObjectOptJSONObject22.optInt("left_or_right_margin", 16));
            wtVar.hn(jSONObjectOptJSONObject22.optInt("top_or_bottom_margin", 30));
            wtVar.x(jSONObjectOptJSONObject22.optInt("skip_style", 1));
            wtVar.c(jSONObjectOptJSONObject22.optInt("hide_native_skip_logo", 0));
            ofVar.pr(wtVar);
        }
        ofVar.o(jSONObject.optInt("shake_value", 13));
        ofVar.sv(jSONObject.optInt("deep_shake_value"));
        ofVar.f(jSONObject.optInt("rotation_angle", 50));
        ofVar.v(jSONObject.optInt("dynamic_join_type", 0));
        ofVar.qi(jSONObject.optInt("dynamic_join_duration", 0));
        ofVar.ve(jSONObject.optInt("calculation_method", 0));
        JSONObject jSONObjectOptJSONObject23 = jSONObject.optJSONObject("splash_compliance_bar");
        if (jSONObjectOptJSONObject23 != null) {
            d dVar = new d();
            dVar.pr(jSONObjectOptJSONObject23.optInt("show_type", 0));
            dVar.hw(jSONObjectOptJSONObject23.optInt("blank", 90));
            dVar.hn(jSONObjectOptJSONObject23.optInt("half_blank", 90));
            ofVar.pr(dVar);
        }
        ofVar.lv(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        ofVar.g(jSONObject.optString("adm"));
        ofVar.fw(jSONObject.optBoolean("is_cache"));
        ofVar.w(jSONObject.optString("log_ext"));
        ofVar.aj(jSONObject.optString("cache_ext"));
        String strOptString3 = jSONObject.optString("req_id");
        if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(ofVar.gu())) {
            ofVar.vk(strOptString3);
        }
        ofVar.pr(jSONObject.optLong("cache_time"));
        ofVar.k(jSONObject.optString("material_key"));
        ofVar.zo(jSONObject.optBoolean("need_get_materials"));
        ofVar.hn(jSONObject.optLong("s_send_ts"));
        ofVar.pr(u.pr(jSONObject.optJSONObject("wc_miniapp_info")));
        ofVar.v(jSONObject.optString("live_room_id", ""));
        ofVar.od(jSONObject.optInt("ad_type", 0));
        ofVar.vj(jSONObject.optInt("live_interaction_type", 1));
        ofVar.ho(jSONObject.optString("ec_schema", ""));
        ofVar.nt(jSONObject.optInt("draw_video_playcount", 2));
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (jSONObjectOptJSONObject24 != null) {
            com.byazt.hg.ho hoVar = new com.byazt.hg.ho();
            hoVar.pr(jSONObjectOptJSONObject24.optInt("style_type"));
            hoVar.pr(jSONObjectOptJSONObject24.optString("image_url"));
            hoVar.hw(jSONObjectOptJSONObject24.optInt("position"));
            hoVar.pr(jSONObjectOptJSONObject24.optDouble("image_height"));
            hoVar.hw(jSONObjectOptJSONObject24.optString("image_gif_url"));
            hoVar.hw(jSONObjectOptJSONObject24.optDouble("image_scale_rate"));
            hoVar.hn(jSONObjectOptJSONObject24.optDouble("image_gif_aspect_ratio"));
            ofVar.pr(hoVar);
        }
        ofVar.qi(jSONObject.optString("ecom_live_params"));
        ofVar.hn(jSONObject.optJSONObject(com.umeng.analytics.pro.d.K));
        ofVar.pr(com.byazt.hg.g.pr(jSONObject.optJSONObject("coupon")));
        ofVar.pr(qi.pr(jSONObject.optJSONObject("live_info")));
        ofVar.pr(lv.pr(jSONObject.optJSONObject("saas_info")));
        ofVar.pr(od.pr(jSONObject.optJSONObject("saas_on_click_material")));
        ofVar.jw(jSONObject.optInt("live_sdk_status_while_first_click", AVMDLDataLoader.AVMDLErrorIsTheSameKeyTask));
        JSONObject jSONObjectOptJSONObject25 = jSONObject.optJSONObject("video_config");
        if (jSONObjectOptJSONObject25 != null) {
            aa aaVar = new aa();
            aaVar.pr(jSONObjectOptJSONObject25.optInt("video_adapter_type", 1));
            aaVar.hw(jSONObjectOptJSONObject25.optInt("video_mute_type", 1));
            ofVar.pr(aaVar);
        }
        JSONObject jSONObjectOptJSONObject26 = jSONObject.optJSONObject("click_trigger_config");
        if (jSONObjectOptJSONObject26 != null) {
            com.byazt.hg.w wVar = new com.byazt.hg.w();
            wVar.pr(jSONObjectOptJSONObject26.optInt("click_trigger_type"));
            wVar.pr((float) jSONObjectOptJSONObject26.optDouble("shake_start_time", 0.0d));
            wVar.hw((float) jSONObjectOptJSONObject26.optDouble("shake_end_time", 2.147483648E9d));
            ofVar.pr(wVar);
        }
        ofVar.gz(jSONObject.optInt("calculation_method_twist"));
        ofVar.er(jSONObject.optString("dynamic_configs"));
        ofVar.gu(jSONObject.optInt("gnd_prefetch_timing"));
        ofVar.of(jSONObject.optString("gnd_prefetch_cache_key"));
        Map<String, Object> mapZc = ofVar.zc();
        if (mapZc == null) {
            mapZc = new HashMap<>();
            ofVar.pr(mapZc);
        }
        String strTd = ofVar.td();
        if (strTd != null) {
            mapZc.put("ad_token", strTd);
            x.pr().hw(strTd);
        }
        if (jSONObject2 != null && com.byazt.hg.b.pr(ofVar)) {
            mapZc.put("style_category", Integer.valueOf(com.byazt.hg.b.c(ofVar)));
        }
        ofVar.m(jSONObject.optJSONObject("applist_info"));
        ofVar.d(jSONObject.optInt("click_freq"));
        ofVar.pq(jSONObject.optInt("if_lpua_package"));
        ofVar.aj(jSONObject.optJSONObject("twist_config"));
        ofVar.vk(jSONObject.optJSONObject("shake_interact_conf"));
        ofVar.w(jSONObject.optJSONObject("twist_interact_conf"));
        ofVar.pr(com.byazt.hg.ve.pr(jSONObject));
        ofVar.x(jSONObject.optString("temp_extra_info"));
        ofVar.pr(jSONObject.optJSONObject("sdk_derive_info"));
        ofVar.x(jSONObject.optInt("disable_video_join"));
        ofVar.fw(jSONObject.optInt("disable_top_bar"));
        ofVar.zo(jSONObject.optInt("disable_rtn_button"));
        ofVar.hw(jSONObject.optInt("web_monitor_rate", 0));
        ofVar.uc(jSONObject.optInt("disable_slide_return"));
        ofVar.wt(jSONObject.optInt("is_height_resize", 1));
        ofVar.hw(jSONObject.optBoolean("disable_safe_area"));
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("haptic");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                ofVar.pr(new com.byazt.hg.nl(jSONArrayOptJSONArray5.optJSONObject(i6)));
            }
        }
        ofVar.k(jSONObject.optJSONObject("_meta_life_record"));
        ofVar.ii(i > 0 ? i : jSONObject.optInt("_ad_index", 1));
        return ofVar;
    }

    private static com.byazt.qk.pr pr(JSONObject jSONObject, of ofVar) {
        com.byazt.qk.pr prVar = new com.byazt.qk.pr();
        prVar.pr(jSONObject.optString("id"));
        prVar.hw(jSONObject.optString("md5"));
        prVar.hn(jSONObject.optString(BreakpointSQLiteKey.URL));
        prVar.pr(jSONObject.optInt("scene"));
        return prVar;
    }

    private static void pr(of ofVar, JSONObject jSONObject) {
        com.byazt.hg.yb ybVarG;
        if (ofVar == null || jSONObject == null) {
            return;
        }
        if ((!v.pr(ofVar) && !f.pr(ofVar)) || (ybVarG = ofVar.g()) == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
        er erVar = new er();
        if (jSONObjectOptJSONObject != null) {
            erVar.pr(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
            erVar.c(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
            erVar.hw(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
            erVar.hn(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
            erVar.x(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
            erVar.pr(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
            ofVar.pr(erVar);
        } else {
            Map<String, String> mapPr = com.byazt.wt.v.pr(ybVarG.hw());
            if (mapPr == null || mapPr.size() <= 0) {
                return;
            }
            erVar.pr(mapPr.get(Common.System.USER_ID));
            erVar.c(mapPr.get(Constants.Bidding.REQUEST_ID));
            erVar.hw(mapPr.get("room_id"));
            erVar.hn(mapPr.get("live_short_touch_params"));
            erVar.x(mapPr.get("extra_pangle_scheme_params"));
            ofVar.pr(erVar);
        }
        ofVar.m(jSONObject.optBoolean("not_valid_download_url", false));
    }

    public static com.byazt.hg.c hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.hg.c cVar = new com.byazt.hg.c();
        cVar.hn(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        cVar.x(jSONObject.optString("package_name"));
        cVar.hw(jSONObject.optString("download_url"));
        cVar.pr(jSONObject.optInt("score", 4));
        cVar.hw(jSONObject.optInt("comment_num", 0));
        cVar.hn(jSONObject.optInt("app_size", 0));
        cVar.pr(jSONObject.optString("quick_app_url", ""));
        return cVar;
    }

    private static com.byazt.hg.a uc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.hg.a aVar = new com.byazt.hg.a();
        aVar.pr(jSONObject.optInt("ah", 1));
        aVar.hw(jSONObject.optInt("am", 1));
        return aVar;
    }

    private static pq pr(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        pq pqVar = new pq();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        pqVar.pr((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        pqVar.fw(jSONObject.optInt("splash_style_id", 0));
        pqVar.pr(jSONObject.optString("splash_clicktext", ""));
        pqVar.hw(jSONObject.optInt("area_height", 50));
        pqVar.hn(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            pqVar.x(jSONObject.optInt("area_blank_height", 32));
        } else {
            pqVar.x(jSONObject.optInt("area_blank_height", 82));
        }
        pqVar.c(jSONObject.optInt("half_blank_height", 56));
        pqVar.hw(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        pqVar.hn(jSONObject.optString("top_splash_clicktext"));
        pqVar.pr(jSONObject.optJSONObject("text_config"));
        pqVar.hw(jSONObject.optJSONObject("top_text_config"));
        pqVar.zo(jSONObject.optInt("sliding_distance", 5));
        pqVar.pr(jSONObject.optJSONObject("slide_area"), i);
        pqVar.uc(jSONObject.optInt("splash_load_time_optimization"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mock_interact");
        if (jSONObjectOptJSONObject != null) {
            try {
                pqVar.pr((float) jSONObjectOptJSONObject.optDouble("enable_ratio", 0.0d));
                pqVar.aj(jSONObjectOptJSONObject.optInt("backup_add", 0));
                pqVar.vk(jSONObjectOptJSONObject.optInt("slide_direction", 0));
                pqVar.w(jSONObjectOptJSONObject.optInt("slide_threshold", 55));
                pqVar.k(jSONObjectOptJSONObject.optInt("view_height_dynamic", 0));
                pqVar.hw((float) jSONObjectOptJSONObject.optDouble("view_height_percent", 0.0d));
                pqVar.m(jSONObjectOptJSONObject.optInt("view_post", 100));
                pqVar.g(jSONObjectOptJSONObject.optInt("ignore_up", 0));
                pqVar.ho(jSONObjectOptJSONObject.optInt("long_press_duration", 0));
                pqVar.nt(jSONObjectOptJSONObject.optInt("long_press_threshold", 10));
            } catch (Exception e) {
                com.byazt.ca.ho.hw("SplashControl", "interact parse error");
            }
        }
        return pqVar;
    }

    public static com.byazt.hg.rc hn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.hg.rc rcVar = new com.byazt.hg.rc();
        rcVar.hn(jSONObject.optString("ugen_dialog_md5"));
        rcVar.hw(jSONObject.optString("ugen_dialog_url"));
        rcVar.pr(jSONObject.optString("dialog_style"));
        return rcVar;
    }

    public static com.byazt.hg.z x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.hg.z zVar = new com.byazt.hg.z();
        zVar.x(jSONObject.optString("bg_url"));
        zVar.hn(jSONObject.optString(BundleKey.TITLE));
        zVar.pr(jSONObject.optString("reward_image_url"));
        zVar.hw(jSONObject.optString("reward_title"));
        zVar.c(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return zVar;
    }

    public static com.byazt.hg.uc c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.hg.uc ucVar = new com.byazt.hg.uc();
        ucVar.x(jSONObject.optString("developer_name"));
        ucVar.hw(jSONObject.optString("app_version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            ucVar.hw(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    ucVar.pr(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        ucVar.pr(jSONObject.optString("permissions_url"));
        ucVar.pr(jSONObject.optInt("score", 0));
        ucVar.pr(jSONObject.optJSONArray("creative_tags"));
        ucVar.c(jSONObject.optString("privacy_policy_url"));
        ucVar.uc(jSONObject.optString("desc_url"));
        ucVar.fw(jSONObject.optString("reg_number"));
        ucVar.zo(jSONObject.optString("reg_url"));
        ucVar.vk(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        ucVar.aj(jSONObject.optString("package_name"));
        return ucVar;
    }

    private static Map<String, Object> fw(JSONObject jSONObject) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x0078 A[PHI: r0
      0x0078: PHI (r0v8 int) = (r0v7 int), (r0v9 int), (r0v10 int), (r0v11 int) binds: [B:28:0x005b, B:37:0x0075, B:34:0x006a, B:31:0x0063] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    public static int pr(of ofVar, int i) {
        if (TextUtils.isEmpty(ofVar.x()) || ofVar.x().length() <= 1) {
            return 401;
        }
        int iPr = pr(ofVar.g());
        if (iPr != 200) {
            return iPr;
        }
        int iPr2 = pr(ofVar);
        if (iPr2 != 200) {
            return iPr2;
        }
        switch (ofVar.aj()) {
            case 2:
            case 3:
                if (TextUtils.isEmpty(ofVar.zo())) {
                    return 405;
                }
                break;
            case 4:
                iPr2 = pr(ofVar.ho());
                if (iPr2 != 200) {
                    return iPr2;
                }
                break;
            case 5:
                if (TextUtils.isEmpty(ofVar.gx())) {
                    return TTAdConstant.INTERACTION_TYPE_CODE;
                }
                break;
        }
        switch (ofVar.jg()) {
            case 2:
            case 3:
            case 4:
            case 16:
                iPr2 = hw(ofVar.de());
                if (iPr2 != 200) {
                    return iPr2;
                }
                return iPr2;
            case 5:
            case 15:
                iPr2 = qv.vk(ofVar);
                if (iPr2 != 200) {
                    return iPr2;
                }
                return iPr2;
            case 166:
                iPr2 = hw(ofVar, i);
                if (iPr2 != 200) {
                    return iPr2;
                }
                return iPr2;
            default:
                return iPr2;
        }
    }

    private static int hw(of ofVar, int i) {
        if (i == 3 || i == 4 || i == 0) {
            return 200;
        }
        if (!v.pr(ofVar)) {
            return 416;
        }
        if (!TextUtils.isEmpty(v.fw(ofVar))) {
            return 200;
        }
        return TTAdConstant.LIVE_FEED_URL_CODE;
    }

    private static int pr(of ofVar) {
        if (!(ofVar.jg() == 166 && v.pr(ofVar)) || iu.x()) {
            return 200;
        }
        com.byazt.ca.ho.pr("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int pr(com.byazt.hg.yb ybVar) {
        if (ybVar == null) {
            return 200;
        }
        if (TextUtils.isEmpty(ybVar.hw()) || TextUtils.isEmpty(ybVar.x())) {
            if (TextUtils.isEmpty(ybVar.hw())) {
                return 402;
            }
            return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
        }
        if (ybVar.c() == 1 || ybVar.c() == 2) {
            return 200;
        }
        return 403;
    }

    private static int pr(com.byazt.hg.c cVar) {
        if (cVar == null) {
            return 406;
        }
        if (TextUtils.isEmpty(cVar.hw())) {
            return 407;
        }
        return 200;
    }

    private static int hw(List<com.byazt.hg.y> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.byazt.hg.y yVar : list) {
            if (yVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(yVar.pr())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    public static void pr(List<of> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<of> listSubList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<of> it = listSubList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().to());
        }
        if (jSONArray.length() > 0) {
            list.get(0).qn(jSONArray.toString());
        }
    }

    private static int zo(JSONObject jSONObject) {
        if (!"download".equals(com.byazt.lx.hw.pr(jSONObject))) {
            return 4;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("package_name") : null;
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("package_name");
        }
        if (com.byazt.uk.m.c(a.getContext(), strOptString)) {
            return 4;
        }
        return (!TextUtils.isEmpty(jSONObject.optString("market_url", "")) || com.byazt.zp.hw.pr(jSONObject)) ? 2 : 1;
    }
}
