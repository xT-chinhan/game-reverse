package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.e.a;
import com.anythink.network.tap.TapATInitManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.nw.am;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.eg;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.rt;
import com.bytedance.sdk.openadsdk.core.nw.s;
import com.bytedance.sdk.openadsdk.core.nw.ti;
import com.bytedance.sdk.openadsdk.core.nw.v;
import com.bytedance.sdk.openadsdk.core.nw.vm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.nw.zf;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.constants.Constants;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.umeng.analytics.pro.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static Pair<com.bytedance.sdk.openadsdk.core.nw.ms, ArrayList<Integer>> ms(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.nw.ms msVar = new com.bytedance.sdk.openadsdk.core.nw.ms();
            msVar.ms(jSONObject.optString("request_id"));
            msVar.ms(jSONObject.optInt("ret"));
            msVar.xr(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.jw.ch.xr(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (msVar.ms() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    lm lmVarMs = ms(jSONArrayOptJSONArray.optJSONObject(i), xrVar, eVar);
                    int iMs = ms(lmVarMs, xrVar != null ? xrVar.t() : 0);
                    boolean zG = lmVarMs.g();
                    String strP = lmVarMs.p();
                    if (lmVarMs != null && (iMs == 200 || ((zOptBoolean || zG) && !TextUtils.isEmpty(strP)))) {
                        lmVarMs.le(strOptString);
                        lmVarMs.ah(j);
                        lmVarMs.c(zOptBoolean);
                        msVar.ms(lmVarMs);
                    } else {
                        arrayList.add(Integer.valueOf(iMs));
                    }
                }
            }
            return new Pair<>(msVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }

    public static lm ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return ms(jSONObject, null, null);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static lm ms(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        if (eVar != null && xrVar != null) {
            re.xr().ah(jSONObject.optInt("settings_open", 1));
        }
        lm lmVar = new lm();
        lmVar.g(jSONObject.optString("s_sig_ts"));
        lmVar.ny(jSONObject.optLong("ad_rec_stamp", 0L));
        lmVar.p(jSONObject.optInt("interaction_type"));
        lmVar.u(jSONObject.optString("target_url"));
        lmVar.sl(jSONObject.optInt("use_media_video_player", 0));
        lmVar.pc(jSONObject.optInt("landing_scroll_percentage", -1));
        lmVar.ub(jSONObject.optString("gecko_id"));
        lmVar.x(jSONObject.optBoolean("is_from_local_cache"));
        lmVar.az(jSONObject.optInt("is_from_cache_type", -1));
        lmVar.ab(jSONObject.optLong("correct_action_code", -1L));
        lmVar.x(jSONObject.optLong("correct_result_code", -1L));
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("set_click_type");
            lmVar.xr(jSONObjectOptJSONObject2.optDouble(com.anythink.basead.c.b.a.k, 2.0d));
            lmVar.ms(jSONObjectOptJSONObject2.optDouble(AdnName.OTHER, 2.0d));
        }
        lmVar.hi(jSONObject.optInt("feed_video_finish_type"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("extension");
        lmVar.ka(jSONObjectOptJSONObject3);
        lmVar.c(jSONObject.optJSONObject("overlay"));
        lmVar.t(jSONObject.optString("ad_id"));
        lmVar.xr(jSONObject.optInt("get_phone_num_status"));
        lmVar.zb(jSONObject.optString("source"));
        lmVar.op(jSONObject.optString("package_name"));
        lmVar.re(jSONObject.optInt("play_bar_show_time", IOfflineCompo.Priority.HIGHEST));
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("icon");
        lmVar.ab(jSONObject.optBoolean("screenshot", false));
        lmVar.t(jSONObject.optInt("play_bar_style", 0));
        lmVar.yu(jSONObject.optString("market_url", ""));
        lmVar.qv(jSONObject.optInt("video_adaptation", 0));
        lmVar.ao(jSONObject.optInt("feed_video_opentype", 0));
        lmVar.h(jSONObject.optInt("feed_reward_type", -1));
        lmVar.ab(jSONObject.optJSONObject("session_params"));
        lmVar.x(jSONObject.optJSONObject("cache_control"));
        lmVar.le(jSONObject.optString("auction_price", ""));
        lmVar.xn(jSONObject.optInt("no_default_ttdsp_price", 0));
        int iOptInt = jSONObject.optInt("meta_hashcode", 0);
        if (iOptInt == 0) {
            iOptInt = (int) SystemClock.elapsedRealtime();
        }
        lmVar.d(iOptInt);
        lmVar.zb(jSONObject.optInt("render_control", eVar != null ? eVar.c : 1));
        if (jSONObjectOptJSONObject4 != null) {
            com.bytedance.sdk.openadsdk.core.nw.g gVar = new com.bytedance.sdk.openadsdk.core.nw.g();
            gVar.ms(jSONObjectOptJSONObject4.optString("url"));
            gVar.xr(jSONObjectOptJSONObject4.optInt("height"));
            gVar.ms(jSONObjectOptJSONObject4.optInt("width"));
            lmVar.ms(gVar);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                com.bytedance.sdk.openadsdk.core.nw.g gVar2 = new com.bytedance.sdk.openadsdk.core.nw.g();
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i);
                gVar2.ms(jSONObjectOptJSONObject5.optString("url"));
                gVar2.xr(jSONObjectOptJSONObject5.optInt("height"));
                gVar2.ms(jSONObjectOptJSONObject5.optInt("width"));
                lm lmVar2 = lmVar;
                gVar2.ms(jSONObjectOptJSONObject5.optInt("duration"));
                gVar2.ms(jSONObjectOptJSONObject5.optBoolean("image_preview"));
                gVar2.xr(jSONObjectOptJSONObject5.optString("image_key"));
                lmVar2.xr(gVar2);
                i++;
                lmVar = lmVar2;
            }
        }
        final lm lmVar3 = lmVar;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                lmVar3.qe().add(jSONArrayOptJSONArray2.optString(i2));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.anythink.basead.c.b.a.p);
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                lmVar3.ue().add(jSONArrayOptJSONArray3.optString(i3));
            }
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject(com.anythink.basead.ui.improveclick.g.a.g);
        if (jSONObjectOptJSONObject6 != null) {
            com.bytedance.sdk.openadsdk.core.nw.ny nyVar = new com.bytedance.sdk.openadsdk.core.nw.ny();
            nyVar.f3071ms = jSONObjectOptJSONObject6.optBoolean("click_upper_content_area", true);
            nyVar.xr = jSONObjectOptJSONObject6.optBoolean("click_upper_non_content_area", true);
            nyVar.ah = jSONObjectOptJSONObject6.optBoolean("click_lower_content_area", true);
            nyVar.d = jSONObjectOptJSONObject6.optBoolean("click_lower_non_content_area", true);
            nyVar.ka = jSONObjectOptJSONObject6.optBoolean("click_button_area", true);
            nyVar.c = jSONObjectOptJSONObject6.optBoolean("click_video_area", true);
            lmVar3.ms(nyVar);
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("adslot");
        lmVar3.ms(jSONObjectOptJSONObject7 != null ? com.bytedance.sdk.openadsdk.core.jw.op.ms(jSONObjectOptJSONObject7.toString()) : xrVar);
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.op(jSONObject.optJSONObject("extension")));
        lmVar3.nw(jSONObject.optInt("intercept_flag", 0));
        lmVar3.b(jSONObject.optInt("web_inspector", 0));
        lmVar3.ao(jSONObject.optString("phone_num"));
        lmVar3.h(jSONObject.optString("title"));
        lmVar3.d(jSONObject.optLong("download_num"));
        lmVar3.qv(jSONObject.optString(BundleKey.DESCRIPTION));
        lmVar3.y(jSONObject.optString("button_text"));
        lmVar3.y(jSONObject.optInt("ad_logo", 1));
        lmVar3.ah(jSONObject.optBoolean("isDirectDownload", false));
        String strOptString = jSONObject.optString("ext");
        lmVar3.nw(strOptString);
        try {
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                lmVar3.b(jSONObject2.optString("req_id"));
                lmVar3.c(jSONObject2.optString("req_id"));
                lmVar3.re(jSONObject2.optString("ad_id"));
                com.bytedance.sdk.openadsdk.core.jw.ch.ms(jSONObject2.optLong("global_did", -1L));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        lmVar3.ny(jSONObject.optString("price"));
        lmVar3.f(jSONObject.optInt("image_mode"));
        lmVar3.il(jSONObject.optInt(TapATInitManager.ORIENTATION_KEY, 1));
        lmVar3.ms((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        lmVar3.xr((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        lmVar3.ah((float) jSONObject.optDouble("corner_radius", 0.0d));
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject(a.C0080a.c);
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("download_sdk_conf");
        lmVar3.ms(xr(jSONObjectOptJSONObject8));
        lmVar3.ms(c(jSONObjectOptJSONObject9));
        lmVar3.xr(jSONObject.optLong("parse_material_ts", System.currentTimeMillis()));
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("deep_link");
        if (jSONObjectOptJSONObject10 != null) {
            lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.h(jSONObjectOptJSONObject10));
        }
        lmVar3.ms(new qf(jSONObject));
        lmVar3.ms(new eg(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.t(jSONObject));
        lmVar3.ms(new ti(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.dislike.ah.xr(jSONObject, com.bytedance.sdk.openadsdk.core.dislike.xr.ms()));
        lmVar3.ms(new k(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.pc(jSONObject));
        lmVar3.ms(new xn(jSONObject));
        lmVar3.ms(new fm(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.of(jSONObject));
        lmVar3.ul(jSONObject.optInt("count_down"));
        lmVar3.ka(jSONObject.optLong("expiration_time"));
        lmVar3.f(jSONObject.optString("_child_metas"));
        lmVar3.w(jSONObject.optString("src_req_id"));
        lmVar3.of(jSONObject.optInt("video_encode_type", 0));
        lmVar3.tz(jSONObject.optInt("player_type", 0));
        if (!g.d() && lmVar3.pd() == 1) {
            lmVar3.of(0);
            lmVar3.tz(0);
        }
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject11 != null) {
            lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.nw(jSONObjectOptJSONObject11));
        }
        lmVar3.m(jSONObject.optInt("if_both_open"));
        lmVar3.lm(jSONObject.optInt("if_double_deeplink"));
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("app_manage");
        if (jSONObjectOptJSONObject12 != null) {
            lmVar3.ms(ka(jSONObjectOptJSONObject12));
            lmVar3.sl(jSONObjectOptJSONObject12.toString());
        }
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("easy_dl_dialog");
        if (jSONObjectOptJSONObject13 != null) {
            lmVar3.ms(ah(jSONObjectOptJSONObject13));
        }
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("easy_pl_material");
        if (jSONObjectOptJSONObject14 != null) {
            lmVar3.ny(jSONObjectOptJSONObject14);
            lmVar3.ms(d(jSONObjectOptJSONObject14));
        }
        lmVar3.g(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        String strOptString2 = jSONObject.optString("app_manage_type", "0");
        if (strOptString2.equals("1")) {
            lmVar3.cv(1);
        } else if (strOptString2.equals("2")) {
            lmVar3.cv(2);
        } else {
            lmVar3.cv(0);
        }
        lmVar3.ms(ab(jSONObject.optJSONObject("media_ext")));
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject15 != null) {
            lm.ms msVar = new lm.ms();
            msVar.xr(jSONObjectOptJSONObject15.optString("id"));
            msVar.ah(jSONObjectOptJSONObject15.optString("md5"));
            msVar.d(jSONObjectOptJSONObject15.optString("url"));
            msVar.ka(jSONObjectOptJSONObject15.optString("data"));
            msVar.c(jSONObjectOptJSONObject15.optString("diff_data"));
            msVar.ab(jSONObjectOptJSONObject15.optString("dynamic_creative"));
            msVar.ms(jSONObjectOptJSONObject15.optString("version"));
            msVar.x(jSONObjectOptJSONObject15.optString("material_type"));
            msVar.ny(jSONObjectOptJSONObject15.optString("ugen_url"));
            msVar.ch(jSONObjectOptJSONObject15.optString("ugen_md5"));
            msVar.sl(jSONObjectOptJSONObject15.optString("express_gesture_priority"));
            msVar.hi(jSONObjectOptJSONObject15.optString("engine_version"));
            lmVar3.ms(msVar);
        }
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject16 != null) {
            rt rtVarMs = rt.ms(jSONObjectOptJSONObject16);
            lmVar3.ms(rtVarMs);
            com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.ms().ms(rtVarMs, String.valueOf(com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar3)), bv.aw);
        }
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject17 != null) {
            lmVar3.ah(jSONObjectOptJSONObject17);
        }
        lmVar3.u(jSONObject.optInt("if_block_lp", 0));
        lmVar3.i(jSONObject.optInt("cache_sort", 1));
        lmVar3.w(jSONObject.optInt("if_sp_cache", 1));
        lmVar3.yu(jSONObject.optInt("splash_timeout_stage", 1));
        lmVar3.ny(jSONObject.optInt("page_render_type", 0));
        if (lmVar3.yu() == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("ugeno")) != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarMs = ms(jSONObjectOptJSONObject, lmVar3);
            lmVar3.ms(msVarMs);
            if (!com.bytedance.sdk.openadsdk.core.ugeno.ab.ms().xr(msVarMs.ms(), msVarMs.xr())) {
                com.bytedance.sdk.openadsdk.core.re.xr.ms(msVarMs, (com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr) null);
            }
        }
        lmVar3.x(jSONObject.optInt("native_lp_tpl_id"));
        lmVar3.xr(jSONObject.optString("native_lp_data"));
        lmVar3.ah(jSONObject.optString("native_lp_ugen_url"));
        lmVar3.d(jSONObject.optString("native_lp_ugen_md5"));
        lmVar3.d(jSONObject.optBoolean("native_lp_is_preload"));
        lmVar3.ms(jSONObject.optString("download_url"));
        if (lmVar3.nw()) {
            JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("native_lp_content");
            if (jSONObjectOptJSONObject18 != null) {
                lmVar3.xr(jSONObjectOptJSONObject18);
            } else {
                com.bytedance.sdk.openadsdk.core.re.xr.ms(lmVar3.h(), new com.bytedance.sdk.openadsdk.core.re.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ms.1
                    @Override // com.bytedance.sdk.openadsdk.core.re.xr.ms
                    public void ms(int i4, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.re.xr.ms
                    public void ms(JSONObject jSONObject3) {
                        lmVar3.xr(jSONObject3);
                    }
                });
            }
        }
        lmVar3.ch(jSONObject.optInt("promotion_type"));
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject("dylite_info");
        if (jSONObjectOptJSONObject19 != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.ny.ms();
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject19.optJSONArray("product_infos");
            if (jSONArrayOptJSONArray4 != null) {
                msVar2.ms(jSONArrayOptJSONArray4);
            }
            JSONObject jSONObjectOptJSONObject20 = jSONObjectOptJSONObject19.optJSONObject("coupon");
            if (jSONObjectOptJSONObject20 != null) {
                msVar2.ms(jSONObjectOptJSONObject20);
            }
            JSONObject jSONObjectOptJSONObject21 = jSONObjectOptJSONObject19.optJSONObject("render_config");
            if (jSONObjectOptJSONObject21 != null) {
                msVar2.xr(jSONObjectOptJSONObject21);
            }
            JSONObject jSONObjectOptJSONObject22 = jSONObjectOptJSONObject19.optJSONObject("live_room_data");
            if (jSONObjectOptJSONObject22 != null) {
                msVar2.ah(jSONObjectOptJSONObject22);
            }
            JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject19.optJSONObject("ec_mall_conf");
            if (jSONObjectOptJSONObject23 != null) {
                msVar2.d(jSONObjectOptJSONObject23);
            }
            lmVar3.ms(msVar2);
        }
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject24 != null) {
            lmVar3.e(jSONObjectOptJSONObject24.optInt("render_sequence", 0));
            lmVar3.k(jSONObjectOptJSONObject24.optInt("backup_render_control", 1));
            lmVar3.eg(jSONObjectOptJSONObject24.optInt("render_thread", 0));
            lmVar3.fm(jSONObjectOptJSONObject24.optInt("reserve_time", 100));
        }
        JSONObject jSONObjectOptJSONObject25 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject25 != null) {
            lmVar3.ms(ms(jSONObjectOptJSONObject25, lmVar3.od()));
        }
        lmVar3.cv(jSONObject.optString(Constants.p.a));
        lmVar3.hi(jSONObject.optBoolean("close_on_dislike", false));
        lmVar3.of(jSONObject.optString("adx_name"));
        lmVar3.am(jSONObject.optInt("endcard_close_time", 0));
        lmVar3.sa(jSONObject.optInt("proportion_watching", 100));
        lmVar3.qk(jSONObject.optInt("video_skip_result", 3));
        com.bytedance.sdk.openadsdk.core.nw.ul ulVar = new com.bytedance.sdk.openadsdk.core.nw.ul(jSONObject);
        lmVar3.ms(ulVar);
        if (ulVar.ms()) {
            if (g.d()) {
                lmVar3.tz(-2);
            } else {
                lmVar3.tz(0);
            }
        }
        lmVar3.ms(new qr(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.re(jSONObject));
        lmVar3.ms(new com.bytedance.sdk.openadsdk.core.nw.p(jSONObject));
        ms(lmVar3, jSONObject);
        JSONObject jSONObjectOptJSONObject26 = jSONObject.optJSONObject("skip_control");
        if (jSONObjectOptJSONObject26 != null) {
            vm vmVar = new vm();
            vmVar.ms(jSONObjectOptJSONObject26.optInt("position", 2));
            vmVar.xr(jSONObjectOptJSONObject26.optInt("left_or_right_margin", 16));
            vmVar.ah(jSONObjectOptJSONObject26.optInt("top_or_bottom_margin", 30));
            vmVar.d(jSONObjectOptJSONObject26.optInt("skip_style", 1));
            vmVar.ka(jSONObjectOptJSONObject26.optInt("hide_native_skip_logo", 0));
            lmVar3.ms(vmVar);
        }
        lmVar3.qf(jSONObject.optInt("shake_value", 13));
        lmVar3.vm(jSONObject.optInt("deep_shake_value"));
        lmVar3.l(jSONObject.optInt("rotation_angle", 50));
        lmVar3.jw(jSONObject.optInt("dynamic_join_type", 0));
        lmVar3.op(jSONObject.optInt("calculation_method", 0));
        JSONObject jSONObjectOptJSONObject27 = jSONObject.optJSONObject("splash_compliance_bar");
        if (jSONObjectOptJSONObject27 != null) {
            s sVar = new s();
            sVar.ms(jSONObjectOptJSONObject27.optInt("show_type", 0));
            sVar.xr(jSONObjectOptJSONObject27.optInt("blank", 90));
            sVar.ah(jSONObjectOptJSONObject27.optInt("half_blank", 90));
            lmVar3.ms(sVar);
        }
        lmVar3.ti(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        lmVar3.ch(jSONObject.optString("adm"));
        lmVar3.ka(jSONObject.optBoolean("is_cache"));
        lmVar3.ab(jSONObject.optString("log_ext"));
        lmVar3.ka(jSONObject.optString("cache_ext"));
        String strOptString3 = jSONObject.optString("req_id");
        if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(lmVar3.cv())) {
            lmVar3.c(strOptString3);
        }
        lmVar3.ms(jSONObject.optLong("cache_time"));
        lmVar3.x(jSONObject.optString("material_key"));
        lmVar3.c(jSONObject.optBoolean("need_get_materials"));
        lmVar3.ah(jSONObject.optLong("s_send_ts"));
        lmVar3.ms(ce.ms(jSONObject.optJSONObject("wc_miniapp_info")));
        lmVar3.pc(jSONObject.optString("live_room_id", ""));
        lmVar3.s(jSONObject.optInt("ad_type", 0));
        lmVar3.v(jSONObject.optInt("live_interaction_type", 1));
        lmVar3.hi(jSONObject.optString("ec_schema", ""));
        lmVar3.ub(jSONObject.optInt("draw_video_playcount", 2));
        JSONObject jSONObjectOptJSONObject28 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (jSONObjectOptJSONObject28 != null) {
            com.bytedance.sdk.openadsdk.core.nw.ub ubVar = new com.bytedance.sdk.openadsdk.core.nw.ub();
            ubVar.ms(jSONObjectOptJSONObject28.optInt("style_type"));
            ubVar.ms(jSONObjectOptJSONObject28.optString(com.anythink.basead.c.b.a.h));
            ubVar.xr(jSONObjectOptJSONObject28.optInt("position"));
            ubVar.ms(jSONObjectOptJSONObject28.optDouble("image_height"));
            ubVar.xr(jSONObjectOptJSONObject28.optString("image_gif_url"));
            ubVar.xr(jSONObjectOptJSONObject28.optDouble("image_scale_rate"));
            ubVar.ah(jSONObjectOptJSONObject28.optDouble("image_gif_aspect_ratio"));
            lmVar3.ms(ubVar);
        }
        lmVar3.jw(jSONObject.optString("ecom_live_params"));
        lmVar3.d(jSONObject.optJSONObject(com.umeng.analytics.pro.g.K));
        lmVar3.ms(com.bytedance.sdk.openadsdk.core.nw.u.ms(jSONObject.optJSONObject("coupon")));
        lmVar3.ms(com.bytedance.sdk.openadsdk.core.nw.az.ms(jSONObject.optJSONObject("live_info")));
        lmVar3.ms(am.ms(jSONObject.optJSONObject("saas_info")));
        JSONObject jSONObjectOptJSONObject29 = jSONObject.optJSONObject("video_config");
        if (jSONObjectOptJSONObject29 != null) {
            zf zfVar = new zf();
            zfVar.ms(jSONObjectOptJSONObject29.optInt("video_adapter_type", 1));
            zfVar.xr(jSONObjectOptJSONObject29.optInt("video_mute_type", 1));
            lmVar3.ms(zfVar);
        }
        JSONObject jSONObjectOptJSONObject30 = jSONObject.optJSONObject("click_trigger_config");
        if (jSONObjectOptJSONObject30 != null) {
            com.bytedance.sdk.openadsdk.core.nw.sl slVar = new com.bytedance.sdk.openadsdk.core.nw.sl();
            slVar.ms(jSONObjectOptJSONObject30.optInt("click_trigger_type"));
            slVar.ms((float) jSONObjectOptJSONObject30.optDouble("shake_start_time", 0.0d));
            slVar.xr((float) jSONObjectOptJSONObject30.optDouble("shake_end_time", 2.147483648E9d));
            lmVar3.ms(slVar);
        }
        lmVar3.le(jSONObject.optInt("calculation_method_twist"));
        lmVar3.p(jSONObject.optString("dynamic_configs"));
        lmVar3.zf(jSONObject.optInt("gnd_prefetch_timing"));
        lmVar3.ul(jSONObject.optString("gnd_prefetch_cache_key"));
        Map<String, Object> mapOu = lmVar3.ou();
        if (mapOu == null) {
            mapOu = new HashMap<>();
            lmVar3.ms(mapOu);
        }
        String strZg = lmVar3.zg();
        if (strZg != null) {
            mapOu.put("ad_token", strZg);
            d.ms().xr(strZg);
        }
        if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.optInt("style_category") != 0) {
            mapOu.put("style_category", Integer.valueOf(jSONObjectOptJSONObject3.optInt("style_category")));
        }
        lmVar3.rt(jSONObject.optInt("click_freq"));
        lmVar3.vy(jSONObject.optInt("if_lpua_package"));
        lmVar3.ch(jSONObject.optJSONObject("twist_config"));
        lmVar3.hi(jSONObject.optJSONObject("shake_interact_conf"));
        lmVar3.sl(jSONObject.optJSONObject("twist_interact_conf"));
        lmVar3.ms(com.bytedance.sdk.openadsdk.core.nw.le.ms(jSONObject));
        lmVar3.ms(jSONObject.optJSONObject("sdk_derive_info"));
        lmVar3.ah(jSONObject.optInt("disable_video_join"));
        lmVar3.c(jSONObject.optInt("disable_top_bar"));
        lmVar3.ab(jSONObject.optInt("disable_rtn_button"));
        lmVar3.ms(jSONObject.optInt("web_monitor_rate", 0));
        lmVar3.ka(jSONObject.optInt("disable_slide_return"));
        lmVar3.xr(jSONObject.optBoolean("disable_safe_area"));
        return lmVar3;
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.c.ms ms(JSONObject jSONObject, lm lmVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
        msVar.ms(jSONObject.optString("id"));
        msVar.xr(jSONObject.optString("md5"));
        msVar.ah(jSONObject.optString("url"));
        msVar.ms(jSONObject.optInt(com.umeng.ccg.a.j));
        return msVar;
    }

    private static void ms(lm lmVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.nw.h hVarTc;
        if (lmVar == null || jSONObject == null) {
            return;
        }
        if ((com.bytedance.sdk.openadsdk.core.nw.ul.ms(lmVar) || xn.ms(lmVar)) && (hVarTc = lmVar.tc()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.nw.f fVar = new com.bytedance.sdk.openadsdk.core.nw.f();
            if (jSONObjectOptJSONObject != null) {
                fVar.ms(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
                fVar.ka(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
                fVar.xr(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
                fVar.ah(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
                fVar.d(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                fVar.ms(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
                lmVar.ms(fVar);
            } else {
                Map<String, String> mapMs = com.bytedance.sdk.openadsdk.core.jw.az.ms(hVarTc.xr());
                if (mapMs == null || mapMs.size() <= 0) {
                    return;
                }
                fVar.ms(mapMs.get("user_id"));
                fVar.ka(mapMs.get("request_id"));
                fVar.xr(mapMs.get("room_id"));
                fVar.ah(mapMs.get("live_short_touch_params"));
                fVar.d(mapMs.get("extra_pangle_scheme_params"));
                lmVar.ms(fVar);
            }
            lmVar.ch(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.nw.ka xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.ka kaVar = new com.bytedance.sdk.openadsdk.core.nw.ka();
        kaVar.ah(jSONObject.optString("app_name"));
        kaVar.d(jSONObject.optString("package_name"));
        kaVar.xr(jSONObject.optString("download_url"));
        kaVar.ms(jSONObject.optInt("score", 4));
        kaVar.xr(jSONObject.optInt("comment_num", 0));
        kaVar.ah(jSONObject.optInt("app_size", 0));
        kaVar.ms(jSONObject.optString("quick_app_url", ""));
        return kaVar;
    }

    private static com.bytedance.sdk.openadsdk.core.nw.b c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.b bVar = new com.bytedance.sdk.openadsdk.core.nw.b();
        bVar.ms(jSONObject.optInt("ah", 1));
        bVar.xr(jSONObject.optInt("am", 1));
        return bVar;
    }

    private static v ms(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        v vVar = new v();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        vVar.ms((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        vVar.ab(jSONObject.optInt("splash_style_id", 0));
        vVar.ms(jSONObject.optString("splash_clicktext", ""));
        vVar.xr(jSONObject.optInt("area_height", 50));
        vVar.ah(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            vVar.d(jSONObject.optInt("area_blank_height", 32));
        } else {
            vVar.d(jSONObject.optInt("area_blank_height", 82));
        }
        vVar.ka(jSONObject.optInt("half_blank_height", 56));
        vVar.xr(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        vVar.ah(jSONObject.optString("top_splash_clicktext"));
        vVar.ms(jSONObject.optJSONObject("text_config"));
        vVar.xr(jSONObject.optJSONObject("top_text_config"));
        vVar.x(jSONObject.optInt("sliding_distance", 5));
        vVar.ms(jSONObject.optJSONObject("slide_area"), i);
        vVar.c(jSONObject.optInt("splash_load_time_optimization"));
        return vVar;
    }

    public static com.bytedance.sdk.openadsdk.core.nw.w ah(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.w wVar = new com.bytedance.sdk.openadsdk.core.nw.w();
        wVar.ah(jSONObject.optString("ugen_dialog_md5"));
        wVar.xr(jSONObject.optString("ugen_dialog_url"));
        wVar.ms(jSONObject.optString("dialog_style"));
        return wVar;
    }

    public static com.bytedance.sdk.openadsdk.core.nw.yu d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.yu yuVar = new com.bytedance.sdk.openadsdk.core.nw.yu();
        yuVar.d(jSONObject.optString("bg_url"));
        yuVar.ah(jSONObject.optString("title"));
        yuVar.ms(jSONObject.optString("reward_image_url"));
        yuVar.xr(jSONObject.optString("reward_title"));
        yuVar.ka(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return yuVar;
    }

    public static com.bytedance.sdk.openadsdk.core.nw.c ka(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.c cVar = new com.bytedance.sdk.openadsdk.core.nw.c();
        cVar.d(jSONObject.optString("developer_name"));
        cVar.xr(jSONObject.optString("app_version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            cVar.xr(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    cVar.ms(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        cVar.ms(jSONObject.optString("permissions_url"));
        cVar.ms(jSONObject.optInt("score", 0));
        cVar.ms(jSONObject.optJSONArray("creative_tags"));
        cVar.ka(jSONObject.optString("privacy_policy_url"));
        cVar.c(jSONObject.optString("desc_url"));
        cVar.ab(jSONObject.optString("reg_number"));
        cVar.x(jSONObject.optString("reg_url"));
        cVar.ch(jSONObject.optString("app_name"));
        cVar.ny(jSONObject.optString("package_name"));
        return cVar;
    }

    private static Map<String, Object> ab(JSONObject jSONObject) {
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
    public static int ms(lm lmVar, int i) {
        if (TextUtils.isEmpty(lmVar.df()) || lmVar.df().length() <= 1) {
            return 401;
        }
        int iMs = ms(lmVar.tc());
        if (iMs != 200) {
            return iMs;
        }
        int iMs2 = ms(lmVar);
        if (iMs2 != 200) {
            return iMs2;
        }
        int iJr = lmVar.jr();
        if (iJr == 2 || iJr == 3) {
            if (TextUtils.isEmpty(lmVar.ir())) {
                return 405;
            }
        } else if (iJr == 4) {
            iMs2 = ms(lmVar.zh());
            if (iMs2 != 200) {
                return iMs2;
            }
        } else if (iJr == 5 && TextUtils.isEmpty(lmVar.wc())) {
            return TTAdConstant.INTERACTION_TYPE_CODE;
        }
        int iKz = lmVar.kz();
        if (iKz == 2 || iKz == 3 || iKz == 4) {
            iMs2 = ms(lmVar.fk());
            if (iMs2 != 200) {
            }
        } else if (iKz == 5 || iKz == 15) {
            iMs2 = qr.ny(lmVar);
            if (iMs2 != 200) {
                return iMs2;
            }
        } else if (iKz == 16) {
            iMs2 = ms(lmVar.fk());
            if (iMs2 != 200) {
            }
        } else if (iKz == 166 && (iMs2 = xr(lmVar, i)) != 200) {
            return iMs2;
        }
        return iMs2;
    }

    private static int xr(lm lmVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!com.bytedance.sdk.openadsdk.core.nw.ul.ms(lmVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.nw.ul.ab(lmVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    private static int ms(lm lmVar) {
        if (!(lmVar.kz() == 166 && com.bytedance.sdk.openadsdk.core.nw.ul.ms(lmVar)) || g.d()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.sl.xr("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int ms(com.bytedance.sdk.openadsdk.core.nw.h hVar) {
        if (hVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(hVar.xr()) && !TextUtils.isEmpty(hVar.d())) {
            return (hVar.ka() == 1 || hVar.ka() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(hVar.xr())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int ms(com.bytedance.sdk.openadsdk.core.nw.ka kaVar) {
        if (kaVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(kaVar.xr()) ? 407 : 200;
    }

    private static int ms(List<com.bytedance.sdk.openadsdk.core.nw.g> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.nw.g gVar : list) {
            if (gVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(gVar.ms())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }
}
