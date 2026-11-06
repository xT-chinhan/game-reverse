package com.byazt.lx;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.hcx.aj;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.hg.of;
import com.byazt.is.w;
import com.byazt.mp.uc;
import com.byazt.qn.x;
import com.byazt.sd.a;
import com.byazt.tf.hn;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.byazt.zq.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 111, 13})
public class hw {
    public static long c;
    public static String fw;
    public static String uc;
    public static long x;
    public static AtomicInteger pr = new AtomicInteger(0);
    public static int hw = -1;
    public static int hn = -1;
    public static volatile int zo = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static c c(String str) {
        return x.hw(str, "uchain_data");
    }

    public static void pr(String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "95d9ae8de4e66aaf458fdd49879c67fa";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20108/uchain_dsl.bin";
        }
        uc = str;
        fw = str2;
        c = System.currentTimeMillis();
        JSONObject jSONObjectHw = hw(uc, fw, str3);
        if (jSONObjectHw != null && jSONObjectHw.length() > 0) {
            hn = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - c;
            x = jCurrentTimeMillis;
            hw(hw, hn, jCurrentTimeMillis);
            hn(jSONObjectHw);
            return;
        }
        aj ajVarHn = hn.hn(fw);
        final String str4 = uc;
        final String str5 = fw;
        ajVarHn.pr(new fw() { // from class: com.byazt.lx.hw.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                int unused = hw.hn = 1;
                String unused2 = hw.uc = str4;
                String unused3 = hw.fw = str5;
                if (mVar != null) {
                    try {
                        if (mVar.fw()) {
                            JSONObject jSONObjectPr = uc.pr(mVar.x(), "uchain_dsl");
                            long unused4 = hw.x = System.currentTimeMillis() - hw.c;
                            if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                                hw.hw(hw.hw, hw.hn, hw.x);
                                hw.hn(jSONObjectPr);
                                hw.c(str3).pr(str4, ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObjectPr.toString()));
                                return;
                            }
                            hw.uc(str3);
                            return;
                        }
                    } catch (Throwable th) {
                        hw.uc(str3);
                        return;
                    }
                }
                hw.uc(str3);
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str6, Throwable th) {
                int unused = hw.hn = 1;
                hw.uc(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uc(String str) {
        hw = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - c;
        x = jCurrentTimeMillis;
        hw(hw, hn, jCurrentTimeMillis);
        fw(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = hn();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            pr.set(3);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
        if (jSONObjectOptJSONObject != null) {
            zo = jSONObjectOptJSONObject.optInt("version");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("event_template");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            pr.set(3);
        } else {
            com.byazt.re.hw.INSTANCE.pr(jSONObjectOptJSONObject2);
            pr.set(2);
        }
    }

    public static String pr(JSONObject jSONObject) {
        com.byazt.re.hn hnVarPr = com.byazt.re.hw.INSTANCE.pr("clickEvent");
        if (hnVarPr == null) {
            return "";
        }
        ArrayList<com.byazt.re.pr> arrayList = new ArrayList(hnVarPr.pr().values());
        Collections.sort(arrayList, new Comparator<com.byazt.re.pr>() { // from class: com.byazt.lx.hw.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.re.pr prVar, com.byazt.re.pr prVar2) {
                return prVar.c() - prVar2.c();
            }
        });
        for (com.byazt.re.pr prVar : arrayList) {
            if (com.byazt.re.hn.pr(prVar.hn(), jSONObject, new HashMap())) {
                String strHw = prVar.hw();
                if (TextUtils.isEmpty(strHw)) {
                    return "";
                }
                return Uri.parse(strHw).getHost();
            }
        }
        return "";
    }

    public static int pr() {
        return zo;
    }

    public static boolean hw() {
        return pr() >= 3000;
    }

    private static void fw(String str) {
        String strYl;
        String strEj;
        JSONObject jSONObjectHw;
        hw = -1;
        w wVarHw = a.hw();
        if (wVarHw != null && (jSONObjectHw = hw((strYl = wVarHw.yl()), (strEj = wVarHw.ej()), str)) != null && jSONObjectHw.length() > 0) {
            hn = 2;
            uc = strYl;
            fw = strEj;
            long jCurrentTimeMillis = System.currentTimeMillis() - c;
            x = jCurrentTimeMillis;
            hw(hw, hn, jCurrentTimeMillis);
            hn(jSONObjectHw);
            return;
        }
        JSONObject jSONObjectHn = hn();
        if (jSONObjectHn == null || jSONObjectHn.length() <= 0) {
            pr.set(3);
            hw(hw, hn, x);
            return;
        }
        hn = 0;
        fw = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - c;
        x = jCurrentTimeMillis2;
        hw(hw, hn, jCurrentTimeMillis2);
        hn(jSONObjectHn);
    }

    private static JSONObject hw(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strHw = c(str3).hw(str, "");
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            String strX = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(strHw);
            hn = 2;
            uc = str;
            fw = str2;
            return new JSONObject(strX);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final int i, final int i2, final long j) {
        com.byazt.xk.hw.pr().pr("uchain_stats_tracker", new com.byazt.ttf.pr() { // from class: com.byazt.lx.hw.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject2.put("dsl_error_code", i3);
                    }
                    jSONObject2.put("dsl_url", hw.fw);
                    jSONObject2.put("dsl_md5", hw.uc);
                    jSONObject2.put("dsl_load_type", i2);
                    jSONObject2.put("dsl_load_time", j);
                    jSONObject2.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pr(of ofVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3, long j) {
        if (pr.get() != 2) {
            c = System.currentTimeMillis();
            fw(ofVar == null ? null : ofVar.yn());
        }
        if (ofVar == null) {
            return;
        }
        long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        JSONObject jSONObject = ofVar.to();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        JSONArray jSONArray = new JSONArray();
        HashMap map4 = new HashMap();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        StringBuilder sb = new StringBuilder("");
        pr(str, jSONObject, map2, new AnonymousClass4(map4, atomicBoolean, jSONArray, sb), (JSONObject) null);
        if (map != null) {
            map.put("uchain_event_id", uuidRandomUUID);
        }
        com.byazt.pj.pr.hw(ofVar, pr(sb.toString(), ofVar));
        pr(uuidRandomUUID, str, jSONArray, ofVar, str2, j > 0 ? System.currentTimeMillis() - j : -1L, jCurrentTimeMillis, atomicBoolean.get());
    }

    /* JADX INFO: renamed from: com.byazt.lx.hw$4, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 111, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME})
    static class AnonymousClass4 implements com.byazt.kr.hn {
        public final /* synthetic */ JSONArray hn;
        public final /* synthetic */ AtomicBoolean hw;
        public final /* synthetic */ Map pr;
        public final /* synthetic */ StringBuilder x;

        public AnonymousClass4(Map map, AtomicBoolean atomicBoolean, JSONArray jSONArray, StringBuilder sb) {
            this.pr = map;
            this.hw = atomicBoolean;
            this.hn = jSONArray;
            this.x = sb;
        }

        @Override // com.byazt.kr.hn
        public void pr(com.byazt.hws.pr prVar) {
            this.pr.put(prVar.zo().pr(), Long.valueOf(System.currentTimeMillis()));
            prVar.pr(new com.byazt.kr.x() { // from class: com.byazt.lx.hw.4.1
                @Override // com.byazt.kr.x
                public com.byazt.kr.uc hw() {
                    return new com.byazt.kr.uc() { // from class: com.byazt.lx.hw.4.1.1
                        @Override // com.byazt.kr.uc
                        public JSONObject pr(JSONObject jSONObject, com.byazt.hws.pr prVar2) {
                            Map<String, Object> mapPr = prVar2.pr();
                            if (mapPr != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (Map.Entry<String, Object> entry : mapPr.entrySet()) {
                                        jSONObject2.put(entry.getKey(), entry.getValue());
                                    }
                                    jSONObject.put("u_context", jSONObject2);
                                } catch (JSONException e) {
                                }
                            }
                            return jSONObject;
                        }

                        @Override // com.byazt.kr.uc
                        public Map<String, Object> pr(Map<String, Object> map, com.byazt.hws.pr prVar2) {
                            return Collections.emptyMap();
                        }

                        @Override // com.byazt.kr.uc
                        public String pr(String str, com.byazt.hws.pr prVar2) {
                            return "";
                        }
                    };
                }

                @Override // com.byazt.kr.x
                public com.byazt.kr.c hn() {
                    return new com.byazt.kr.c() { // from class: com.byazt.lx.hw.4.1.2
                        @Override // com.byazt.kr.c
                        public void pr(com.byazt.hws.pr prVar2, Map<String, Object> map) {
                            try {
                                com.byazt.re.pr prVarZo = prVar2.zo();
                                String strPr = prVarZo.pr();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strPr);
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, true);
                                Long l = (Long) AnonymousClass4.this.pr.remove(strPr);
                                if (l != null) {
                                    jSONObject.put("duration", System.currentTimeMillis() - l.longValue());
                                }
                                hw.pr(map, jSONObject);
                                AnonymousClass4.this.hw.set(true);
                                AnonymousClass4.this.hn.put(jSONObject);
                                if (!TextUtils.isEmpty(prVarZo.hw())) {
                                    AnonymousClass4.this.x.append(Uri.parse(prVarZo.hw()).getHost());
                                }
                            } catch (JSONException e) {
                            }
                        }

                        @Override // com.byazt.kr.c
                        public void pr(com.byazt.hws.pr prVar2, Map<String, Object> map, final com.byazt.rs.pr prVar3) {
                            if (prVar3 != null) {
                                try {
                                    hw.pr(map, new com.byazt.wb.pr() { // from class: com.byazt.lx.hw.4.1.2.1
                                        @Override // com.byazt.wb.pr
                                        public String hw() {
                                            return prVar3.hw();
                                        }

                                        @Override // com.byazt.wb.pr
                                        public int pr() {
                                            return prVar3.pr();
                                        }
                                    });
                                } catch (JSONException e) {
                                    return;
                                }
                            }
                            String strPr = prVar2.zo().pr();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(NotificationCompat.CATEGORY_EVENT, strPr);
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, false);
                            Long l = (Long) AnonymousClass4.this.pr.remove(strPr);
                            if (l != null) {
                                jSONObject.put("duration", System.currentTimeMillis() - l.longValue());
                            }
                            hw.pr(map, jSONObject);
                            AnonymousClass4.this.hn.put(jSONObject);
                        }
                    };
                }
            });
        }
    }

    public static int pr(String str, of ofVar) {
        if (!"download".equals(str)) {
            return 4;
        }
        String strIc = ofVar.ic();
        if (ofVar.ho() != null && !TextUtils.isEmpty(ofVar.ho().x())) {
            strIc = ofVar.ho().x();
        }
        if (ls.hw(strIc)) {
            return 4;
        }
        return (!TextUtils.isEmpty(ofVar.rc()) || ofVar.gb() == 2 || com.byazt.zp.hw.pr(ofVar)) ? 2 : 1;
    }

    private static void pr(UUID uuid, String str, JSONArray jSONArray, of ofVar, String str2, long j, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uchain_event_id", uuid);
            jSONObject.put("pre_uchain", j2);
            jSONObject.put("duration", j);
            jSONObject.put("run_status", z);
            jSONObject.put("version", pr());
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", ls.k(ofVar));
            com.byazt.pj.pr.hw(ofVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException e) {
        }
    }

    public static boolean pr(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("is_feed_register_direct_download");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public static boolean hw(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("has_show_dl_factors");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return false;
    }

    public static JSONObject hn() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.8\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}&landing_type=${landing_type}&saas_info=${saas_info}\",\"priority\":1,\"condition\":\"${coupon!=null || (ec_schema!=null&&ec_schema!='') || (live_room_id!=null&&live_room_id!='')}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"condition\":\"${wc_miniapp_info!=null}\",\"priority\":2,\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}&orientation=${orientation}&video_voice_control=${video_voice_control}&if_lpua_package=${if_lpua_package}\",\"priority\":4,\"condition\":\"${interaction_type==3||ext.interaction_type==3}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"priority\":3,\"condition\":\"${deep_link!=null||ulink!=null}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"priority\":5,\"condition\":\"${exist(app.download_url, download_url) != null && exist(app.download_url, download_url) != '' && (interaction_type==4||ext.interaction_type==4)}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception e) {
            return null;
        }
    }

    public static void pr(of ofVar, HashMap<String, Object> map, com.byazt.fy.hn hnVar) {
        ls.ve();
        if (hnVar == null || ofVar == null) {
            return;
        }
        String strPr = hnVar.pr("type");
        if (TextUtils.isEmpty(strPr)) {
        }
        JSONObject jSONObject = ofVar.to();
        switch (strPr) {
            case "1":
                String strPr2 = hnVar.pr(Common.System.NAME);
                if (!TextUtils.isEmpty(strPr2)) {
                    pr(strPr2, jSONObject, map);
                    break;
                }
                break;
            case "2":
                String strPr3 = hnVar.pr("data");
                if (!TextUtils.isEmpty(strPr3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strPr3);
                        pr(jSONObject2.keys().next(), jSONObject, map, (com.byazt.kr.hn) null, jSONObject2);
                    } catch (JSONException e) {
                        return;
                    }
                    break;
                }
                break;
            case "3":
                String strPr4 = hnVar.pr("scheme");
                if (!TextUtils.isEmpty(strPr4)) {
                    new com.byazt.hws.hw.pr(strPr4, 2).pr(jSONObject).pr(map).pr().pr();
                    break;
                }
                break;
        }
    }

    public static void pr(of ofVar, HashMap<String, Object> map, com.byazt.dd.fw.pr prVar) {
        String strValueOf;
        ls.ve();
        if (prVar.hn() == null || ofVar == null) {
            return;
        }
        Object obj = prVar.hn().get("type");
        String strValueOf2 = obj != null ? String.valueOf(obj) : "";
        if (TextUtils.isEmpty(strValueOf2)) {
        }
        JSONObject jSONObject = ofVar.to();
        switch (strValueOf2) {
            case "1":
                Object obj2 = prVar.hn().get(Common.System.NAME);
                strValueOf = obj2 != null ? String.valueOf(obj2) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    pr(strValueOf, jSONObject, map);
                    break;
                }
                break;
            case "2":
                Object obj3 = prVar.hn().get("data");
                strValueOf = obj3 != null ? String.valueOf(obj3) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strValueOf);
                        pr(jSONObject2.keys().next(), jSONObject, map, (com.byazt.kr.hn) null, jSONObject2);
                    } catch (JSONException e) {
                        return;
                    }
                    break;
                }
                break;
            case "3":
                Object obj4 = prVar.hn().get("scheme");
                strValueOf = obj4 != null ? String.valueOf(obj4) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    new com.byazt.hws.hw.pr(strValueOf, 2).pr(jSONObject).pr(map).pr().pr();
                    break;
                }
                break;
        }
    }

    public static void pr(String str, JSONObject jSONObject, Map<String, Object> map, final com.byazt.kr.c cVar) {
        ls.ve();
        new com.byazt.hws.hw.pr(str, 3).pr(jSONObject).pr(map).pr(new com.byazt.kr.hn() { // from class: com.byazt.lx.hw.5
            @Override // com.byazt.kr.hn
            public void pr(com.byazt.hws.pr prVar) {
                prVar.pr(new com.byazt.kr.x() { // from class: com.byazt.lx.hw.5.1
                    @Override // com.byazt.kr.x
                    public com.byazt.kr.uc hw() {
                        return null;
                    }

                    @Override // com.byazt.kr.x
                    public com.byazt.kr.c hn() {
                        return cVar;
                    }
                });
            }
        }).pr().pr();
    }

    public static void pr(com.byazt.af.pr prVar, JSONObject jSONObject, Map<String, Object> map, Map<String, Object> map2) {
        if (prVar == null || jSONObject == null) {
            return;
        }
        com.byazt.bxj.pr prVarPr = com.byazt.bxj.pr.pr();
        HashMap map3 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() != null && prVar.pr() != null && prVar.pr().containsKey(key)) {
                    map3.put(prVar.pr().get(key), entry.getValue());
                }
            }
        }
        pr(jSONObject, (Map<String, Object>) map3);
        prVarPr.pr(prVar, map, jSONObject, map2);
    }

    public static void pr(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            pr(jSONObject, entry.getKey(), entry.getValue());
        }
    }

    private static void pr(JSONObject jSONObject, String str, Object obj) {
        String[] strArrSplit = str.split("\\.");
        for (int i = 0; i < strArrSplit.length - 1; i++) {
            try {
                String str2 = strArrSplit[i];
                if (!jSONObject.has(str2)) {
                    return;
                }
                jSONObject = jSONObject.getJSONObject(str2);
            } catch (Exception e) {
                return;
            }
        }
        String str3 = strArrSplit[strArrSplit.length - 1];
        if (jSONObject.has(str3)) {
            jSONObject.put(str3, obj);
        }
    }

    public static of pr(Object obj, Map<String, Object> map) {
        if (obj instanceof of) {
            return (of) obj;
        }
        return hn(map);
    }

    private static of hn(Map<String, Object> map) {
        if (map == null || !map.containsKey("material_meta")) {
            return null;
        }
        return (of) map.get("material_meta");
    }

    public static void pr(Map<String, Object> map, com.byazt.wb.pr prVar) {
        if (map != null) {
            map.put("status_code", Integer.valueOf(prVar.pr()));
            map.put("status_msg", prVar.hw());
        }
    }

    public static void pr(Map<String, Object> map, JSONObject jSONObject) {
        if (map != null && hw()) {
            try {
                jSONObject.put("status_code", map.get("status_code"));
            } catch (JSONException e) {
            }
        }
    }

    public static void pr(of ofVar, Context context, String str, Map<String, Object> map, com.byazt.kr.c cVar) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("material_meta", ofVar);
        map2.put(d.R, context);
        map2.put("event_tag", str);
        map2.put("landing_page_source", Integer.valueOf(ls.x(str)));
        pr("open_landing_page", ofVar.to(), map2, cVar);
    }

    public static void pr(String str, JSONObject jSONObject, Map<String, Object> map) {
        pr(str, jSONObject, map, (com.byazt.kr.hn) null, (JSONObject) null);
    }

    public static void pr(String str, JSONObject jSONObject, Map<String, Object> map, com.byazt.kr.hn hnVar, JSONObject jSONObject2) {
        ls.ve();
        try {
            jSONObject.put("u_setting", a.hw().bd());
        } catch (JSONException e) {
        }
        new com.byazt.hws.hw.pr(str).pr(jSONObject).pr(map).pr(hnVar).hw(jSONObject2).pr().pr();
    }
}
