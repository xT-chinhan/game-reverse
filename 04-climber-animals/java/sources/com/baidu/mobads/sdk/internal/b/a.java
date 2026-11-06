package com.baidu.mobads.sdk.internal.b;

import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.taptap.sdk.db.constant.Common;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements IOAdEventListener {

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.internal.b.a$a, reason: collision with other inner class name */
    public static class C0170a {
        public static final String A = "ic_white_cross";
        public static final String B = "ic_gray_complaints";
        public static final String C = "ic_gray_low_quality";
        public static final String D = "ic_gray_repeat";
        public static final String E = "ic_gray_unlike";
        public static final String F = "ic_white_ad_logo_gray_bg";
        public static final String G = "ic_white_bqt_logo_gray_bg";
        public static final String H = "ic_white_shake_gesture";
        public static final String I = "ic_arrow_up";
        public static final String J = "ic_blue_no_ad";
        public static final String K = "ic_fallback_gray";
        public static final String L = "ic_gift_box";
        public static final String M = "ic_gift_ribbon";
        public static final String N = "ic_gold_star";
        public static final String O = "ic_gray_left_quot";
        public static final String P = "ic_gray_right_quot";
        public static final String Q = "ic_gray_star";
        public static final String R = "ic_half_gold_star";
        public static final String S = "ic_orange_cross";
        public static final String T = "ic_twist_phone";
        public static final String U = "ic_white_answer_error";
        public static final String V = "ic_white_answer_right";
        public static final String W = "ic_white_ad_logo";
        public static final String X = "ic_white_cross_in_circle";
        public static final String Y = "ic_black_arrow_left";
        public static final String Z = "ic_black_three_points";
        public static final String a = "rsp_big_red_heart";
        public static final String aA = "ic_white_three_points";
        public static final String aB = "ic_white_voice";
        public static final String aC = "ic_white_voice_mute";
        public static final String aD = "ic_white_pause_gray_round";
        public static final String aE = "ic_yellow_dl_black_bg";
        public static final String aF = "ic_yellow_lp_black_bg";
        public static final String aa = "ic_gray_ad";
        public static final String ab = "ic_gray_ad_logo";
        public static final String ac = "ic_gray_bqt_logo";
        public static final String ad = "ic_gray_cross_black_round";
        public static final String ae = "ic_gray_cross_white_oval";
        public static final String af = "ic_gray_logo";
        public static final String ag = "ic_slide_arrow_duplicate";
        public static final String ah = "ic_slide_arrow_point";
        public static final String ai = "ic_white_ad_gray_bg";
        public static final String aj = "ic_white_arrow_left";
        public static final String ak = "ic_white_arrow_right";
        public static final String al = "ic_white_bqt_gray_bg";
        public static final String am = "ic_white_bqt_logo";
        public static final String an = "ic_white_comments";
        public static final String ao = "ic_white_cross_circle_shadow";
        public static final String ap = "ic_white_finger_shadow";
        public static final String aq = "ic_white_logo";
        public static final String ar = "ic_white_logo_gray_bg";
        public static final String as = "ic_white_replay";
        public static final String at = "ic_white_replay_gray_round";
        public static final String au = "ic_white_speed075";
        public static final String av = "ic_white_speed100";
        public static final String aw = "ic_white_speed125";
        public static final String ax = "ic_white_speed150";
        public static final String ay = "ic_white_speed175";
        public static final String az = "ic_white_speed200";
        public static final String b = "rsp_small_red_heart";
        public static final String c = "bg_blur_white";
        public static final String d = "bg_app_icon";
        public static final String e = "bg_hot_recommendation";
        public static final String f = "bg_black_round_rectangle";
        public static final String g = "bg_red_rectangle";
        public static final String h = "bg_red_circle";
        public static final String i = "bg_red_ribbon_rectangle";
        public static final String j = "bg_red_ribbon_circle";
        public static final String k = "ic_video_play";
        public static final String l = "ic_stars";
        public static final String m = "ic_fallback";
        public static final String n = "ic_guide_circle";
        public static final String o = "ic_guide_finger";
        public static final String p = "ic_white_play";
        public static final String q = "ic_white_pause";
        public static final String r = "ic_white_apo";
        public static final String s = "ic_white_dl";
        public static final String t = "ic_white_link";
        public static final String u = "ic_white_fullscreen_shrink";
        public static final String v = "ic_white_fullscreen_stretch";
        public static final String w = "ic_black_cross";
        public static final String x = "ic_white_cross_dark_round";
        public static final String y = "ic_gray_cross";
        public static final String z = "ic_light_gray_cross";
    }

    private Integer b(String str) {
        return null;
    }

    private Integer c(String str) {
        return null;
    }

    private Integer d(String str) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Integer numD;
        if (iOAdEvent != null) {
            String type = iOAdEvent.getType();
            Map<String, Object> data = iOAdEvent.getData();
            String str = (String) data.get(Common.System.NAME);
            if ("drawable".equals(type)) {
                numD = a(str);
            } else if ("layout".equals(type)) {
                numD = b(str);
            } else if ("string".equals(type)) {
                numD = c(str);
            } else {
                numD = "style".equals(type) ? d(str) : null;
            }
            data.put("id", numD);
        }
    }

    private Integer a(String str) {
        if (C0170a.c.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if (C0170a.d.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_app_icon);
        }
        if (C0170a.e.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_hot_recommendation);
        }
        if (C0170a.f.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_black_round_rectangle);
        }
        if (C0170a.g.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_rect);
        }
        if (C0170a.h.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_circle);
        }
        if (C0170a.i.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_rect);
        }
        if (C0170a.j.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_circle);
        }
        if (C0170a.k.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_video_play);
        }
        if (C0170a.l.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_stars);
        }
        if (C0170a.m.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback);
        }
        if (C0170a.n.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_circle);
        }
        if (C0170a.o.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_finger);
        }
        if (C0170a.p.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_play);
        }
        if (C0170a.q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause);
        }
        if (C0170a.r.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_apo);
        }
        if (C0170a.s.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_dl);
        }
        if (C0170a.t.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_link);
        }
        if (C0170a.u.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_shrink);
        }
        if (C0170a.v.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_stretch);
        }
        if (C0170a.w.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_cross);
        }
        if (C0170a.x.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_dark_round);
        }
        if (C0170a.a.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if (C0170a.b.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if (C0170a.y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross);
        }
        if (C0170a.z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_light_gray_cross);
        }
        if (C0170a.A.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross);
        }
        if (C0170a.B.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_complaints);
        }
        if (C0170a.C.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_low_quality);
        }
        if (C0170a.D.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_repeat);
        }
        if (C0170a.E.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_unlike);
        }
        if (C0170a.F.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo_gray_bg);
        }
        if (C0170a.G.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo_gray_bg);
        }
        if (C0170a.H.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_shake_gesture);
        }
        if (C0170a.I.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_arrow_up);
        }
        if (C0170a.J.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_blue_no_ad);
        }
        if (C0170a.K.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback_gray);
        }
        if (C0170a.L.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_box);
        }
        if (C0170a.M.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_ribbon);
        }
        if (C0170a.N.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gold_star);
        }
        if (C0170a.O.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_left_quot);
        }
        if (C0170a.P.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_right_quot);
        }
        if (C0170a.Q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_star);
        }
        if (C0170a.R.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_half_gold_star);
        }
        if (C0170a.S.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_orange_cross);
        }
        if (C0170a.T.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_twist_phone);
        }
        if (C0170a.W.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo);
        }
        if (C0170a.U.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_error);
        }
        if (C0170a.V.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_right);
        }
        if (C0170a.X.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_in_circle);
        }
        if (C0170a.Y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_arrow_left);
        }
        if (C0170a.Z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_three_points);
        }
        if (C0170a.aa.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad);
        }
        if (C0170a.ab.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad_logo);
        }
        if (C0170a.ac.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_bqt_logo);
        }
        if (C0170a.ad.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_black_round);
        }
        if (C0170a.ae.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_white_oval);
        }
        if (C0170a.af.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_logo);
        }
        if (C0170a.ag.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_duplicate);
        }
        if (C0170a.ah.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_point);
        }
        if (C0170a.ai.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_gray_bg);
        }
        if (C0170a.aj.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_left);
        }
        if (C0170a.ak.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_right);
        }
        if (C0170a.al.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_gray_bg);
        }
        if (C0170a.am.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo);
        }
        if (C0170a.an.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_comments);
        }
        if (C0170a.ao.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_circle_shadow);
        }
        if (C0170a.ap.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_finger_shadow);
        }
        if (C0170a.aq.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo);
        }
        if (C0170a.ar.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo_gray_bg);
        }
        if (C0170a.aD.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause_gray_round);
        }
        if (C0170a.as.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay);
        }
        if (C0170a.at.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay_gray_round);
        }
        if (C0170a.au.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed075);
        }
        if (C0170a.av.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed100);
        }
        if (C0170a.aw.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed125);
        }
        if (C0170a.ax.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed150);
        }
        if (C0170a.ay.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed175);
        }
        if (C0170a.az.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed200);
        }
        if (C0170a.aA.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_three_points);
        }
        if (C0170a.aB.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice);
        }
        if (C0170a.aC.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice_mute);
        }
        if (C0170a.aE.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_dl_black_bg);
        }
        if (C0170a.aF.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_lp_black_bg);
        }
        return null;
    }
}
