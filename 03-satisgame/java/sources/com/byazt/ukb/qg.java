package com.byazt.ukb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.f;
import com.byazt.cl.q;
import com.byazt.gct.pk;
import com.byazt.gwu.l;
import com.byazt.ivn.w;
import com.byazt.phf.s;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import com.byazt.vf.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 26})
public class qg {
    public static long l;
    public static long q;
    public static String w;
    public static String x;
    public static AtomicInteger n = new AtomicInteger(0);
    public static int qg = -1;
    public static int s = -1;
    public static volatile int fs = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static l l(String str) {
        return com.byazt.lk.l.qg(str, "uchain_data");
    }

    public static void n(String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "95d9ae8de4e66aaf458fdd49879c67fa";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20108/uchain_dsl.bin";
        }
        w = str;
        x = str2;
        l = System.currentTimeMillis();
        JSONObject jSONObjectQg = qg(w, x, str3);
        if (jSONObjectQg != null && jSONObjectQg.length() > 0) {
            s = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - l;
            q = jCurrentTimeMillis;
            qg(qg, s, jCurrentTimeMillis);
            s(jSONObjectQg);
            return;
        }
        rv rvVarS = s.s(x);
        final String str4 = w;
        final String str5 = x;
        rvVarS.n(new x() { // from class: com.byazt.ukb.qg.1
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                int unused = qg.s = 1;
                String unused2 = qg.w = str4;
                String unused3 = qg.x = str5;
                if (oaVar != null) {
                    try {
                        if (oaVar.x()) {
                            JSONObject jSONObjectN = q.n(oaVar.q(), "uchain_dsl");
                            long unused4 = qg.q = System.currentTimeMillis() - qg.l;
                            if (jSONObjectN != null && jSONObjectN.length() > 0) {
                                qg.qg(qg.qg, qg.s, qg.q);
                                qg.s(jSONObjectN);
                                qg.l(str3).n(str4, ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObjectN.toString()));
                                return;
                            }
                            qg.w(str3);
                            return;
                        }
                    } catch (Throwable unused5) {
                        qg.w(str3);
                        return;
                    }
                }
                qg.w(str3);
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str6, Throwable th) {
                int unused = qg.s = 1;
                qg.w(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str) {
        qg = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - l;
        q = jCurrentTimeMillis;
        qg(qg, s, jCurrentTimeMillis);
        x(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = s();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            n.set(3);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
        if (jSONObjectOptJSONObject != null) {
            fs = jSONObjectOptJSONObject.optInt("version");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("event_template");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            n.set(3);
        } else {
            com.byazt.fm.qg.INSTANCE.n(jSONObjectOptJSONObject2);
            n.set(2);
        }
    }

    public static String n(JSONObject jSONObject) {
        com.byazt.fm.s sVarN = com.byazt.fm.qg.INSTANCE.n("clickEvent");
        if (sVarN == null) {
            return "";
        }
        ArrayList<com.byazt.fm.n> arrayList = new ArrayList(sVarN.n().values());
        Collections.sort(arrayList, new Comparator<com.byazt.fm.n>() { // from class: com.byazt.ukb.qg.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.fm.n nVar, com.byazt.fm.n nVar2) {
                return nVar.l() - nVar2.l();
            }
        });
        for (com.byazt.fm.n nVar : arrayList) {
            if (com.byazt.fm.s.n(nVar.s(), jSONObject, new HashMap())) {
                String strQg = nVar.qg();
                return !TextUtils.isEmpty(strQg) ? Uri.parse(strQg).getHost() : "";
            }
        }
        return "";
    }

    public static int n() {
        return fs;
    }

    public static boolean qg() {
        return n() >= 3000;
    }

    private static void x(String str) {
        String strBi;
        String strFw;
        JSONObject jSONObjectQg;
        qg = -1;
        w wVarQg = com.byazt.nf.rv.qg();
        if (wVarQg != null && (jSONObjectQg = qg((strBi = wVarQg.bi()), (strFw = wVarQg.fw()), str)) != null && jSONObjectQg.length() > 0) {
            s = 2;
            w = strBi;
            x = strFw;
            long jCurrentTimeMillis = System.currentTimeMillis() - l;
            q = jCurrentTimeMillis;
            qg(qg, s, jCurrentTimeMillis);
            s(jSONObjectQg);
            return;
        }
        JSONObject jSONObjectS = s();
        if (jSONObjectS == null || jSONObjectS.length() <= 0) {
            n.set(3);
            qg(qg, s, q);
            return;
        }
        s = 0;
        x = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - l;
        q = jCurrentTimeMillis2;
        qg(qg, s, jCurrentTimeMillis2);
        s(jSONObjectS);
    }

    private static JSONObject qg(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strQg = l(str3).qg(str, "");
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(strQg);
            s = 2;
            w = str;
            x = str2;
            return new JSONObject(strQ);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final int i, final int i2, final long j) {
        com.byazt.eji.s.n().n("uchain_stats_tracker", new com.byazt.rs.n() { // from class: com.byazt.ukb.qg.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject2.put("dsl_error_code", i3);
                    }
                    jSONObject2.put("dsl_url", qg.x);
                    jSONObject2.put("dsl_md5", qg.w);
                    jSONObject2.put("dsl_load_type", i2);
                    jSONObject2.put("dsl_load_time", j);
                    jSONObject2.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void n(pk pkVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3, long j) {
        UUID uuid;
        if (n.get() != 2) {
            l = System.currentTimeMillis();
            x(pkVar == null ? null : pkVar.mk());
        }
        if (pkVar == null) {
            return;
        }
        long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        JSONObject jSONObjectPv = pkVar.pv();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObjectPv.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        JSONArray jSONArray = new JSONArray();
        HashMap map4 = new HashMap();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        StringBuilder sb3 = new StringBuilder("");
        n(str, jSONObjectPv, map2, new AnonymousClass4(map4, atomicBoolean, jSONArray, sb, sb2, sb3, pkVar, uuidRandomUUID, str, str2, j, jCurrentTimeMillis), (JSONObject) null);
        if (map != null) {
            uuid = uuidRandomUUID;
            map.put("uchain_event_id", uuid);
        } else {
            uuid = uuidRandomUUID;
        }
        if (qg() && com.byazt.ph.q.tj()) {
            return;
        }
        com.byazt.hm.n.qg(pkVar, n(sb.toString(), pkVar));
        qg(uuid, str, jSONArray, pkVar, str2, j > 0 ? System.currentTimeMillis() - j : -1L, jCurrentTimeMillis, atomicBoolean.get(), sb2.toString(), sb3.toString());
    }

    /* JADX INFO: renamed from: com.byazt.ukb.qg$4, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 117})
    static class AnonymousClass4 implements com.byazt.xvf.s {
        public final /* synthetic */ long cp;
        public final /* synthetic */ long d;
        public final /* synthetic */ UUID fs;
        public final /* synthetic */ StringBuilder l;
        public final /* synthetic */ Map n;
        public final /* synthetic */ StringBuilder q;
        public final /* synthetic */ AtomicBoolean qg;
        public final /* synthetic */ String rv;
        public final /* synthetic */ JSONArray s;
        public final /* synthetic */ String tj;
        public final /* synthetic */ StringBuilder w;
        public final /* synthetic */ pk x;

        public AnonymousClass4(Map map, AtomicBoolean atomicBoolean, JSONArray jSONArray, StringBuilder sb, StringBuilder sb2, StringBuilder sb3, pk pkVar, UUID uuid, String str, String str2, long j, long j2) {
            this.n = map;
            this.qg = atomicBoolean;
            this.s = jSONArray;
            this.q = sb;
            this.l = sb2;
            this.w = sb3;
            this.x = pkVar;
            this.fs = uuid;
            this.rv = str;
            this.tj = str2;
            this.cp = j;
            this.d = j2;
        }

        @Override // com.byazt.xvf.s
        public void n(com.byazt.dm.n nVar) {
            this.n.put(nVar.fs().n(), Long.valueOf(System.currentTimeMillis()));
            nVar.n(new com.byazt.xvf.q() { // from class: com.byazt.ukb.qg.4.1
                @Override // com.byazt.xvf.q
                public com.byazt.xvf.w qg() {
                    return new com.byazt.xvf.w() { // from class: com.byazt.ukb.qg.4.1.1
                        @Override // com.byazt.xvf.w
                        public String n(String str, com.byazt.dm.n nVar2) {
                            return "";
                        }

                        @Override // com.byazt.xvf.w
                        public JSONObject n(JSONObject jSONObject, com.byazt.dm.n nVar2) {
                            Map<String, Object> mapN = nVar2.n();
                            if (mapN != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (Map.Entry<String, Object> entry : mapN.entrySet()) {
                                        jSONObject2.put(entry.getKey(), entry.getValue());
                                    }
                                    jSONObject.put("u_context", jSONObject2);
                                } catch (JSONException unused) {
                                }
                            }
                            return jSONObject;
                        }

                        @Override // com.byazt.xvf.w
                        public Map<String, Object> n(Map<String, Object> map, com.byazt.dm.n nVar2) {
                            return Collections.emptyMap();
                        }
                    };
                }

                @Override // com.byazt.xvf.q
                public com.byazt.xvf.l s() {
                    return new com.byazt.xvf.l() { // from class: com.byazt.ukb.qg.4.1.2
                        @Override // com.byazt.xvf.l
                        public void n(com.byazt.dm.n nVar2, Map<String, Object> map) {
                            try {
                                com.byazt.fm.n nVarFs = nVar2.fs();
                                String strN = nVarFs.n();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strN);
                                jSONObject.put("status", true);
                                Long l = (Long) AnonymousClass4.this.n.remove(strN);
                                if (l != null) {
                                    jSONObject.put(MediationConstant.EXTRA_DURATION, System.currentTimeMillis() - l.longValue());
                                }
                                qg.n(map, jSONObject);
                                AnonymousClass4.this.qg.set(true);
                                AnonymousClass4.this.s.put(jSONObject);
                                if (!TextUtils.isEmpty(nVarFs.qg())) {
                                    AnonymousClass4.this.q.append(Uri.parse(nVarFs.qg()).getHost());
                                }
                                AnonymousClass4.this.l.setLength(0);
                                AnonymousClass4.this.l.append(strN);
                                qg.qg(AnonymousClass4.this.w, strN, true, jSONObject.opt("status_code"));
                            } catch (JSONException unused) {
                            }
                        }

                        @Override // com.byazt.xvf.l
                        public void n(com.byazt.dm.n nVar2, Map<String, Object> map, final com.byazt.bds.n nVar3) {
                            if (nVar3 != null) {
                                try {
                                    qg.n(map, new com.byazt.wr.n() { // from class: com.byazt.ukb.qg.4.1.2.1
                                        @Override // com.byazt.wr.n
                                        public String qg() {
                                            return nVar3.qg();
                                        }

                                        @Override // com.byazt.wr.n
                                        public int n() {
                                            return nVar3.n();
                                        }
                                    });
                                } catch (JSONException unused) {
                                    return;
                                }
                            }
                            String strN = nVar2.fs().n();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(NotificationCompat.CATEGORY_EVENT, strN);
                            jSONObject.put("status", false);
                            Long l = (Long) AnonymousClass4.this.n.remove(strN);
                            if (l != null) {
                                jSONObject.put(MediationConstant.EXTRA_DURATION, System.currentTimeMillis() - l.longValue());
                            }
                            qg.n(map, jSONObject);
                            AnonymousClass4.this.s.put(jSONObject);
                            qg.qg(AnonymousClass4.this.w, strN, false, jSONObject.opt("status_code"));
                        }
                    };
                }
            });
        }

        @Override // com.byazt.xvf.s
        public void n(com.byazt.dm.qg qgVar) {
            if (qg.qg() && com.byazt.ph.q.tj()) {
                com.byazt.hm.n.qg(this.x, qg.n(this.q.toString(), this.x));
                qg.qg(this.fs, this.rv, this.s, this.x, this.tj, this.cp > 0 ? System.currentTimeMillis() - this.cp : -1L, this.d, this.qg.get(), this.l.toString(), this.w.toString());
            }
        }
    }

    public static int n(String str, pk pkVar) {
        int i = 4;
        if ("download".equals(str)) {
            String strEm = pkVar.em();
            if (pkVar.k() != null && !TextUtils.isEmpty(pkVar.k().q())) {
                strEm = pkVar.k().q();
            }
            if (com.byazt.vgx.w.qg(strEm)) {
                return 4;
            }
            i = 2;
            if (TextUtils.isEmpty(pkVar.m()) && pkVar.ev() != 2 && !com.byazt.ges.n.n(pkVar)) {
                return 1;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(UUID uuid, String str, JSONArray jSONArray, pk pkVar, String str2, long j, long j2, boolean z, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDn = pkVar.dn();
            String strN = com.byazt.vgx.n.n(pkVar);
            jSONObject.put("uchain_event_id", uuid);
            jSONObject.put("pre_uchain", j2);
            jSONObject.put(MediationConstant.EXTRA_DURATION, j);
            jSONObject.put("run_status", z);
            jSONObject.put("version", n());
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", com.byazt.vgx.w.d(pkVar));
            jSONObject.put("prefer_event", strDn);
            jSONObject.put("prefer_convert", strN);
            jSONObject.put("action_event", str3);
            jSONObject.put("action_chain", str4);
            com.byazt.hm.n.qg(pkVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(StringBuilder sb, String str, boolean z, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(str).append(":").append(z ? "T" : "F");
        if (obj == null || obj == JSONObject.NULL) {
            return;
        }
        sb.append("(").append(obj).append(")");
    }

    public static boolean n(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static boolean qg(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("has_show_dl_factors");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static JSONObject s() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.8\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}&landing_type=${landing_type}&saas_info=${saas_info}\",\"priority\":1,\"condition\":\"${coupon!=null || (ec_schema!=null&&ec_schema!='') || (live_room_id!=null&&live_room_id!='')}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"condition\":\"${wc_miniapp_info!=null}\",\"priority\":2,\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}&orientation=${orientation}&video_voice_control=${video_voice_control}&if_lpua_package=${if_lpua_package}\",\"priority\":4,\"condition\":\"${interaction_type==3||ext.interaction_type==3}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"priority\":3,\"condition\":\"${deep_link!=null||ulink!=null}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"priority\":5,\"condition\":\"${exist(app.download_url, download_url) != null && exist(app.download_url, download_url) != '' && (interaction_type==4||ext.interaction_type==4)}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n(pk pkVar, HashMap<String, Object> map, com.byazt.li.s sVar) {
        com.byazt.vgx.w.ur();
        if (sVar == null || pkVar == null) {
            return;
        }
        String strN = sVar.n("type");
        if (TextUtils.isEmpty(strN)) {
        }
        JSONObject jSONObjectPv = pkVar.pv();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : sVar.qg().keySet()) {
                jSONObject.put(str, sVar.n(str));
            }
            jSONObjectPv.put("ugen_event_params", jSONObject);
        } catch (JSONException unused) {
        }
        strN.hashCode();
        switch (strN) {
            case "1":
                String strN2 = sVar.n(TapEventParamConstants.PARAM_NAME);
                if (!TextUtils.isEmpty(strN2)) {
                    n(strN2, jSONObjectPv, map);
                    break;
                }
                break;
            case "2":
                String strN3 = sVar.n(f.R);
                if (!TextUtils.isEmpty(strN3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strN3);
                        n(jSONObject2.keys().next(), jSONObjectPv, map, (com.byazt.xvf.s) null, jSONObject2);
                    } catch (JSONException unused2) {
                        return;
                    }
                    break;
                }
                break;
            case "3":
                String strN4 = sVar.n("scheme");
                if (!TextUtils.isEmpty(strN4)) {
                    new com.byazt.dm.qg.n(strN4, 2).n(jSONObjectPv).n(map).n().n();
                    break;
                }
                break;
        }
    }

    public static void n(pk pkVar, HashMap<String, Object> map, com.byazt.xz.x.n nVar) {
        String strValueOf;
        com.byazt.vgx.w.ur();
        if (nVar.s() == null || pkVar == null) {
            return;
        }
        Object obj = nVar.s().get("type");
        String strValueOf2 = obj != null ? String.valueOf(obj) : "";
        if (TextUtils.isEmpty(strValueOf2)) {
        }
        JSONObject jSONObjectPv = pkVar.pv();
        strValueOf2.hashCode();
        switch (strValueOf2) {
            case "1":
                Object obj2 = nVar.s().get(TapEventParamConstants.PARAM_NAME);
                strValueOf = obj2 != null ? String.valueOf(obj2) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    n(strValueOf, jSONObjectPv, map);
                    break;
                }
                break;
            case "2":
                Object obj3 = nVar.s().get(f.R);
                strValueOf = obj3 != null ? String.valueOf(obj3) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strValueOf);
                        n(jSONObject.keys().next(), jSONObjectPv, map, (com.byazt.xvf.s) null, jSONObject);
                    } catch (JSONException unused) {
                        return;
                    }
                    break;
                }
                break;
            case "3":
                Object obj4 = nVar.s().get("scheme");
                strValueOf = obj4 != null ? String.valueOf(obj4) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    new com.byazt.dm.qg.n(strValueOf, 2).n(jSONObjectPv).n(map).n().n();
                    break;
                }
                break;
        }
    }

    public static void n(String str, JSONObject jSONObject, Map<String, Object> map, final com.byazt.xvf.l lVar) {
        com.byazt.vgx.w.ur();
        new com.byazt.dm.qg.n(str, 3).n(jSONObject).n(map).n(new com.byazt.xvf.s() { // from class: com.byazt.ukb.qg.5
            @Override // com.byazt.xvf.s
            public void n(com.byazt.dm.qg qgVar) {
            }

            @Override // com.byazt.xvf.s
            public void n(com.byazt.dm.n nVar) {
                nVar.n(new com.byazt.xvf.q() { // from class: com.byazt.ukb.qg.5.1
                    @Override // com.byazt.xvf.q
                    public com.byazt.xvf.w qg() {
                        return null;
                    }

                    @Override // com.byazt.xvf.q
                    public com.byazt.xvf.l s() {
                        return lVar;
                    }
                });
            }
        }).n().n();
    }

    public static void n(com.byazt.llp.n nVar, JSONObject jSONObject, Map<String, Object> map, Map<String, Object> map2) {
        if (nVar == null || jSONObject == null) {
            return;
        }
        com.byazt.fu.n nVarN = com.byazt.fu.n.n();
        HashMap map3 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() != null && nVar.n() != null && nVar.n().containsKey(key)) {
                    map3.put(nVar.n().get(key), entry.getValue());
                }
            }
        }
        n(jSONObject, (Map<String, Object>) map3);
        nVarN.n(nVar, map, jSONObject, map2);
    }

    public static void n(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            n(jSONObject, entry.getKey(), entry.getValue());
        }
    }

    private static void n(JSONObject jSONObject, String str, Object obj) {
        String[] strArrSplit = str.split("\\.");
        for (int i = 0; i < strArrSplit.length - 1; i++) {
            try {
                String str2 = strArrSplit[i];
                if (!jSONObject.has(str2)) {
                    return;
                }
                jSONObject = jSONObject.getJSONObject(str2);
            } catch (Exception unused) {
                return;
            }
        }
        String str3 = strArrSplit[strArrSplit.length - 1];
        if (jSONObject.has(str3)) {
            jSONObject.put(str3, obj);
        }
    }

    public static pk n(Object obj, Map<String, Object> map) {
        if (obj instanceof pk) {
            return (pk) obj;
        }
        return s(map);
    }

    private static pk s(Map<String, Object> map) {
        if (map == null || !map.containsKey("material_meta")) {
            return null;
        }
        return (pk) map.get("material_meta");
    }

    public static void n(Map<String, Object> map, com.byazt.wr.n nVar) {
        if (map != null) {
            map.put("status_code", Integer.valueOf(nVar.n()));
            map.put("status_msg", nVar.qg());
        }
    }

    public static void n(Map<String, Object> map, JSONObject jSONObject) {
        if (map == null || !qg()) {
            return;
        }
        try {
            jSONObject.put("status_code", map.get("status_code"));
        } catch (JSONException unused) {
        }
    }

    public static void n(pk pkVar, Context context, String str, Map<String, Object> map, com.byazt.xvf.l lVar) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("material_meta", pkVar);
        map2.put("context", context);
        map2.put("event_tag", str);
        map2.put("landing_page_source", Integer.valueOf(com.byazt.vgx.w.q(str)));
        n("open_landing_page", pkVar.pv(), map2, lVar);
    }

    public static void n(String str, JSONObject jSONObject, Map<String, Object> map) {
        n(str, jSONObject, map, (com.byazt.xvf.s) null, (JSONObject) null);
    }

    public static void n(String str, JSONObject jSONObject, Map<String, Object> map, com.byazt.xvf.s sVar, JSONObject jSONObject2) {
        com.byazt.vgx.w.ur();
        try {
            jSONObject.put("u_setting", com.byazt.nf.rv.qg().xm());
        } catch (JSONException unused) {
        }
        new com.byazt.dm.qg.n(str).n(jSONObject).n(map).n(sVar).qg(jSONObject2).n().n();
    }
}
