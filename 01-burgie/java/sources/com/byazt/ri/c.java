package com.byazt.ri;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.auw.DownloadInfo;
import com.byazt.ca.b;
import com.byazt.hg.aj;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.uc;
import com.byazt.lj.vk;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 697, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static int pr(of ofVar) {
        if (ofVar == null || ofVar.fl() != 1) {
            return 0;
        }
        if (ofVar.cb() == 0) {
            return 1;
        }
        if (ofVar.cb() == 1) {
            return fw(ofVar) ? 0 : 1;
        }
        return ofVar.cb() == 2 ? 2 : 1;
    }

    public static String pr(of ofVar, String str, boolean z) {
        int iW = qa.w(ofVar);
        String strPr = zo.nt().pr(ofVar);
        if (!TextUtils.isEmpty(strPr) && !TextUtils.isEmpty(str) && iW > 0) {
            strPr = strPr + File.separator + com.byazt.ca.c.hw(str);
        }
        if (TextUtils.isEmpty(str) && !z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", "download_url is null");
                if (ofVar != null) {
                    jSONObject.put("reqId", ofVar.ny());
                    jSONObject.put("cid", ofVar.x());
                    jSONObject.put("rit", ls.pr(ofVar, ""));
                }
            } catch (Exception e) {
            }
            com.byazt.xk.hw.pr().pr("dl_download_url_empty", jSONObject, (Throwable) null);
        }
        return strPr;
    }

    public static int hw(of ofVar) {
        if (ofVar == null) {
            return Integer.MIN_VALUE;
        }
        try {
            vk vkVarZ = com.byazt.lj.hn.z();
            if (vkVarZ == null) {
                return Integer.MIN_VALUE;
            }
            DownloadInfo downloadInfoHw = null;
            if (ofVar.ho() == null || TextUtils.isEmpty(ofVar.ho().hw())) {
                String strIu = ls.iu(ofVar);
                List<DownloadInfo> listHw = vkVarZ.hw();
                if (listHw != null) {
                    for (DownloadInfo downloadInfo : listHw) {
                        if (downloadInfo != null && TextUtils.equals(strIu, downloadInfo.getPackageName())) {
                            downloadInfoHw = downloadInfo;
                            break;
                        }
                    }
                }
            } else {
                String strHw = ofVar.ho().hw();
                downloadInfoHw = vkVarZ.hw(com.byazt.lj.hn.pr(strHw, pr(ofVar, strHw, true)));
            }
            if (downloadInfoHw == null) {
                return Integer.MIN_VALUE;
            }
            int status = downloadInfoHw.getStatus();
            downloadInfoHw.getStatusAtDbInit();
            downloadInfoHw.getRealStatus();
            return status;
        } catch (Exception e) {
            com.byazt.xk.hw.pr().pr("createAdDownloadModel", e);
            return Integer.MIN_VALUE;
        }
    }

    public static String hn(of ofVar) {
        if (ofVar == null) {
            return "";
        }
        com.byazt.hg.c cVarHo = ofVar.ho();
        if (cVarHo != null && !TextUtils.isEmpty(cVarHo.hn())) {
            return cVarHo.hn();
        }
        if (!TextUtils.isEmpty(ofVar.zj())) {
            return ofVar.zj();
        }
        if (!TextUtils.isEmpty(ofVar.jv())) {
            return ofVar.jv();
        }
        if (TextUtils.isEmpty(ofVar.ic())) {
            return "";
        }
        return ofVar.ic();
    }

    private static boolean fw(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        return zo(ofVar);
    }

    private static boolean zo(of ofVar) {
        uc ucVarLb = ofVar.lb();
        if (ucVarLb == null || TextUtils.isEmpty(ucVarLb.g()) || TextUtils.isEmpty(ucVarLb.c()) || TextUtils.isEmpty(ucVarLb.fw()) || ucVarLb.pr() == null || ucVarLb.pr().size() <= 0 || TextUtils.isEmpty(ucVarLb.zo()) || TextUtils.isEmpty(ucVarLb.aj())) {
            return false;
        }
        return true;
    }

    public static void pr(final Context context, of ofVar, String str) {
        if (context == null) {
            context = a.getContext();
        }
        pr(ofVar, str);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b.pr(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            lb.uc().post(new fw("tt_download_toast") { // from class: com.byazt.ri.c.1
                @Override // java.lang.Runnable
                public void run() {
                    b.pr(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }

    public static void pr(of ofVar, String str) {
        if (ofVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reqId", ofVar.ny());
                jSONObject.putOpt("cid", ofVar.x());
                jSONObject.putOpt("adId", ofVar.fo());
                jSONObject.putOpt("dlscene", str);
                com.byazt.qe.hw hwVarP = ofVar.p();
                JSONObject jSONObjectV_ = ofVar.v_();
                if (jSONObjectV_ != null) {
                    jSONObject.putOpt("landing_type", Integer.valueOf(jSONObjectV_.optInt("landing_type", -1)));
                }
                if (hwVarP != null) {
                    jSONObject.putOpt("slotType", Integer.valueOf(hwVarP.a()));
                }
            } catch (Exception e) {
            }
            com.byazt.xk.hw.pr().pr("download_no_response", jSONObject, (Throwable) null);
        }
    }

    public static uc pr(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
        }
        return com.byazt.sd.pr.c(jSONObject);
    }

    public static boolean x(of ofVar) {
        if (ofVar != null && ofVar.rk() != null && ie.pr(ofVar) != 1 && ofVar.rf() == 1) {
            switch (ls.k(ofVar)) {
                case 1:
                case 2:
                case 5:
                case 6:
                    return false;
                case 3:
                case 4:
                default:
                    return true;
            }
        }
        return false;
    }

    public static void pr(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectQv = a.hw().qv();
            int iOptInt = jSONObjectQv != null ? jSONObjectQv.optInt("resume_download_max_count", 5) : 5;
            if ((i & 1) != 0) {
                jSONObject.put("failed_resume_max_count", iOptInt);
            }
            if ((i & 2) != 0) {
                jSONObject.put("paused_resume_max_count", iOptInt);
                jSONObject.put("enable_notification_ui", 2);
            }
            if ((i & 4) != 0) {
                jSONObject.put("uninstall_resume_max_count", iOptInt);
            }
            if ((i & 8) != 0) {
                jSONObject.put("install_queue_enable", 1);
            }
        } catch (Exception e) {
        }
    }

    public static boolean c(of ofVar) {
        qa qaVarZ_;
        if (ofVar == null || (qaVarZ_ = ofVar.z_()) == null || !qaVarZ_.hn() || ofVar.rf() != 1) {
            return false;
        }
        return x(ofVar);
    }

    public static boolean uc(of ofVar) {
        return (ofVar == null || ofVar.z_() == null || ofVar.rf() != 1 || !c(ofVar) || com.byazt.hg.lb.m(ofVar)) ? false : true;
    }

    public static FrameLayout pr(final Context context, final of ofVar, com.byazt.hg.x xVar, int i) {
        String strPr;
        String strHn;
        String strHw;
        String strW;
        String str;
        String strC;
        int i2;
        if (context == null) {
            return null;
        }
        uc ucVarLb = ofVar.lb();
        final String strHw2 = ls.hw(ofVar);
        if (xVar != null) {
            strPr = xVar.pr();
            strHn = xVar.hn();
            strHw = xVar.hw();
            strW = xVar.uc();
            String strZo = xVar.zo();
            strC = xVar.c();
            str = strZo;
        } else if (ucVarLb == null) {
            strPr = null;
            strHn = null;
            strHw = null;
            strW = null;
            str = null;
            strC = null;
        } else {
            String strG = ucVarLb.g();
            String strFw = ucVarLb.fw();
            String strC2 = ucVarLb.c();
            str = null;
            strC = null;
            strW = ucVarLb.w();
            strPr = strG;
            strHn = strFw;
            strHw = strC2;
        }
        if (TextUtils.isEmpty(strPr) || TextUtils.isEmpty(strHn)) {
            return null;
        }
        final int color = Color.parseColor("#99FFFFFF");
        StringBuilder sb = new StringBuilder();
        sb.append("点击" + (i == 8 ? "下" : "上") + "方按钮 立即下载应用").append("\n应用名称：").append(strPr).append("   |   开发者：").append(strHn).append("\n版本号：").append(strHw);
        if (TextUtils.isEmpty(strW)) {
            sb.append("  |  功能  |  权限  |  隐私  ");
        } else {
            sb.append("  |  功能  |  权限  |  隐私  |  备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i3 = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i4 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i5 = iIndexOf3 + 2;
        if (TextUtils.isEmpty(strW)) {
            i2 = 34;
        } else {
            int iIndexOf4 = sb.indexOf("备案");
            int i6 = iIndexOf4 + 2;
            spannableString.setSpan(new StyleSpan(1), iIndexOf4, i6, 34);
            i2 = 34;
            final String str2 = str;
            spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.ri.c.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    c.pr(ofVar, str2, context, strHw2);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(color);
                        textPaint.setUnderlineText(false);
                        textPaint.bgColor = 0;
                    }
                }
            }, iIndexOf4, i6, 34);
        }
        spannableString.setSpan(new StyleSpan(1), iIndexOf, i3, i2);
        final String str3 = strC;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.ri.c.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                c.hw(ofVar, str3, context, strHw2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf, i3, i2);
        spannableString.setSpan(new StyleSpan(1), iIndexOf2, i4, i2);
        final String str4 = str;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.ri.c.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                c.uc(ofVar, str4, context, strHw2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf2, i4, i2);
        spannableString.setSpan(new StyleSpan(1), iIndexOf3, i5, i2);
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.ri.c.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                c.c(ofVar, str4, context, strHw2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf3, i5, i2);
        TextView textView = new TextView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextColor(color);
        textView.setTextSize(1, 10.0f);
        textView.setLineSpacing(9.0f, 1.0f);
        textView.setText(spannableString);
        textView.setGravity(17);
        textView.setHighlightColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(textView, layoutParams);
        return frameLayout;
    }

    private static void pr(Context context, of ofVar) {
        HashMap map = new HashMap();
        map.put("downloadstatuscontroller_type", 2);
        String strHw = ls.hw(ofVar);
        aj.pr prVar = new aj.pr();
        float fFw = er.fw(context);
        int iA = ((g) com.byazt.zs.uc.pr("device_info_new")).a();
        com.byazt.pj.pr.pr("click", ofVar, prVar.pr(fFw).hw(iA).pr((byte) 3).hw(er.zo(context)).pr(hw(ofVar)).pr(), strHw, true, (Map<String, Object>) map, 1, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(of ofVar, String str, Context context, String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        pr(context, ofVar);
        com.byazt.wt.c.hn(ofVar, str, context, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uc(of ofVar, String str, Context context, String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        pr(context, ofVar);
        com.byazt.wt.c.hw(ofVar, str, context, str2);
    }

    public static void pr(of ofVar, String str, Context context, String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        pr(context, ofVar);
        com.byazt.wt.c.pr(ofVar, str, context, str2);
    }

    public static void hw(of ofVar, String str, Context context, String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        pr(context, ofVar);
        com.byazt.wt.c.pr(context, str, ofVar, str2);
    }

    public static void hw(of ofVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (ofVar == null) {
                jSONObject.put("message", "meta is null");
            } else {
                qa qaVarZ_ = ofVar.z_();
                if (qaVarZ_ == null) {
                    jSONObject.put("message", "download_conf is null");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    qaVarZ_.pr(jSONObject2);
                    jSONObject.put("message", jSONObject2);
                }
                jSONObject.put("req_id", ofVar.ny());
                jSONObject.put("cid", ofVar.x());
                jSONObject.put("rit", ls.pr(ofVar, ""));
            }
            jSONObject.put("dl_type", str);
        } catch (Exception e) {
        }
        com.byazt.xk.hw.pr().pr("download_no_suspend", jSONObject, (Throwable) null);
    }
}
