package com.bytedance.sdk.openadsdk.core.ny.ms.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.api.plugin.xr;
import com.bytedance.sdk.openadsdk.core.ah.c;
import com.bytedance.sdk.openadsdk.core.g.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.bytedance.sdk.openadsdk.core.zb.ah;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static String ab;
    private static long c;
    private static long ka;
    private static String x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static SharedPreferences f3121ms = xr.xr(re.getContext(), "uchain_data", 0);
    private static AtomicInteger xr = new AtomicInteger(0);
    private static int ah = -1;
    private static int d = -1;

    public static void ms(final String str, final String str2) {
        ab = str;
        x = str2;
        c = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            xr.set(3);
            return;
        }
        JSONObject jSONObjectXr = xr(str, str2);
        if (jSONObjectXr != null && jSONObjectXr.length() > 0) {
            d = 2;
            ab = str;
            x = str2;
            long jCurrentTimeMillis = System.currentTimeMillis() - c;
            ka = jCurrentTimeMillis;
            xr(ah, d, jCurrentTimeMillis);
            return;
        }
        com.bytedance.sdk.component.ny.xr.ms msVarKa = ka.ms().xr().ka();
        if (msVarKa == null) {
            return;
        }
        msVarKa.ms(str2);
        msVarKa.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.1
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                int unused = ms.d = 1;
                String unused2 = ms.ab = str;
                String unused3 = ms.x = str2;
                if (xrVar != null) {
                    try {
                        if (xrVar.x()) {
                            JSONObject jSONObjectMs = c.ms(xrVar.ch(), "uchain_dsl");
                            long unused4 = ms.ka = System.currentTimeMillis() - ms.c;
                            if (jSONObjectMs != null && jSONObjectMs.length() > 0) {
                                ms.xr(ms.ah, ms.d, ms.ka);
                                ms.xr(jSONObjectMs);
                                ms.f3121ms.edit().putString(str, com.bytedance.sdk.component.utils.ms.xr(jSONObjectMs.toString())).apply();
                                return;
                            }
                            ms.xr(ms.ah, ms.d, ms.ka);
                            ms.ch();
                            return;
                        }
                    } catch (Throwable unused5) {
                        ms.ch();
                        return;
                    }
                }
                ms.ch();
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, IOException iOException) {
                int unused = ms.d = 1;
                ms.ch();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ch() {
        ah = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - c;
        ka = jCurrentTimeMillis;
        xr(ah, d, jCurrentTimeMillis);
        hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            xr.set(3);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
            xr.set(3);
        } else {
            com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(jSONObjectOptJSONObject);
            xr.set(2);
        }
    }

    public static boolean ms() {
        if (xr.get() == 2) {
            return true;
        }
        ch chVarXr = re.xr();
        if (chVarXr == null || !chVarXr.wn()) {
            return false;
        }
        c = System.currentTimeMillis();
        hi();
        return true;
    }

    private static void hi() {
        JSONObject jSONObject;
        String strFg;
        String strSs;
        JSONObject jSONObjectXr;
        ah = -1;
        ch chVarXr = re.xr();
        if (chVarXr != null && (jSONObjectXr = xr((strFg = chVarXr.fg()), (strSs = chVarXr.ss()))) != null && jSONObjectXr.length() > 0) {
            d = 2;
            ab = strFg;
            x = strSs;
            long jCurrentTimeMillis = System.currentTimeMillis() - c;
            ka = jCurrentTimeMillis;
            xr(ah, d, jCurrentTimeMillis);
            xr(jSONObjectXr);
            return;
        }
        try {
            jSONObject = new JSONObject("{\"template_info\":{\"version\":\"2.1.0\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${is_video_lp==true&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||is_video_lp==null||is_video_lp==false}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            xr.set(3);
            xr(ah, d, ka);
            return;
        }
        d = 0;
        x = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - c;
        ka = jCurrentTimeMillis2;
        xr(ah, d, jCurrentTimeMillis2);
        xr(jSONObject);
    }

    public static JSONObject xr(String str, String str2) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string = f3121ms.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String strAh = com.bytedance.sdk.component.utils.ms.ah(string);
            d = 2;
            ab = str;
            x = str2;
            return new JSONObject(strAh);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final int i, final int i2, final long j) {
        com.bytedance.sdk.openadsdk.core.t.xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("dsl_error_code", i3);
                    }
                    jSONObject.put("dsl_url", ms.x);
                    jSONObject.put("dsl_md5", ms.ab);
                    jSONObject.put("dsl_load_type", i2);
                    jSONObject.put("dsl_load_time", j);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("uchain_stats_tracker").xr(jSONObject.toString());
            }
        }, "uchain_stats_tracker", false);
    }

    public static void ms(lm lmVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3) {
        if (lmVar == null) {
            return;
        }
        JSONObject jSONObjectRm = lmVar.rm();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObjectRm.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        JSONArray jSONArray = new JSONArray();
        new com.bytedance.sdk.component.hi.ms.xr.ms(str).ms(jSONObjectRm).ms(map2).ms(new AnonymousClass3(jSONArray)).ms().ms();
        JSONObject jSONObject = new JSONObject();
        UUID uuidRandomUUID = UUID.randomUUID();
        if (map != null) {
            map.put("uchain_event_id", uuidRandomUUID);
        }
        try {
            jSONObject.put("uchain_event_id", uuidRandomUUID);
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", f.x(lmVar));
            ah.xr(lmVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ny.ms.d.ms$3, reason: invalid class name */
    static class AnonymousClass3 implements com.bytedance.sdk.component.hi.d.ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ JSONArray f3124ms;

        AnonymousClass3(JSONArray jSONArray) {
            this.f3124ms = jSONArray;
        }

        @Override // com.bytedance.sdk.component.hi.d.ah
        public void ms(com.bytedance.sdk.component.hi.ms.ms msVar) {
            msVar.ms(new com.bytedance.sdk.component.hi.d.d() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.3.1
                @Override // com.bytedance.sdk.component.hi.d.d
                public com.bytedance.sdk.component.hi.d.ka xr() {
                    return new com.bytedance.sdk.component.hi.d.ka() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.3.1.1
                        @Override // com.bytedance.sdk.component.hi.d.ka
                        public void ms(com.bytedance.sdk.component.hi.ms.ms msVar2, Map<String, Object> map) {
                            try {
                                String strMs = msVar2.ab().ms();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strMs);
                                jSONObject.put("status", true);
                                AnonymousClass3.this.f3124ms.put(jSONObject);
                            } catch (JSONException e) {
                                sl.ms(e);
                            }
                        }

                        @Override // com.bytedance.sdk.component.hi.d.ka
                        public void xr(com.bytedance.sdk.component.hi.ms.ms msVar2, Map<String, Object> map) {
                            try {
                                String strMs = msVar2.ab().ms();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strMs);
                                jSONObject.put("status", false);
                                AnonymousClass3.this.f3124ms.put(jSONObject);
                            } catch (JSONException e) {
                                sl.ms(e);
                            }
                        }
                    };
                }
            });
        }
    }

    public static boolean ms(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
