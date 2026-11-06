package com.byazt.oh;

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
import com.byazt.gct.cd;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.h;
import com.byazt.vf.oa;
import com.byazt.vgx.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, 18})
public class l {
    public static int n(pk pkVar) {
        if (pkVar == null || pkVar.xa() != 1) {
            return 0;
        }
        if (pkVar.lx() == 0) {
            return 1;
        }
        if (pkVar.lx() == 1) {
            return x(pkVar) ? 0 : 1;
        }
        return pkVar.lx() == 2 ? 2 : 1;
    }

    public static String n(pk pkVar, String str, boolean z) {
        int iCp = um.cp(pkVar);
        String strN = com.byazt.vyf.s.cy().n(pkVar);
        if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(str) && iCp > 0) {
            strN = strN + File.separator + com.byazt.tk.l.qg(str);
        }
        if (TextUtils.isEmpty(str) && !z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", "download_url is null");
                if (pkVar != null) {
                    jSONObject.put("reqId", pkVar.ou());
                    jSONObject.put("cid", pkVar.q());
                    jSONObject.put("rit", w.n(pkVar, ""));
                }
            } catch (Exception unused) {
            }
            com.byazt.eji.s.n().n("dl_download_url_empty", jSONObject, (Throwable) null);
        }
        return strN;
    }

    public static int qg(pk pkVar) {
        DownloadInfo downloadInfoQg;
        if (pkVar == null) {
            return Integer.MIN_VALUE;
        }
        try {
            tj tjVarHu = com.byazt.xv.s.hu();
            if (tjVarHu == null) {
                return Integer.MIN_VALUE;
            }
            if (pkVar.k() == null || TextUtils.isEmpty(pkVar.k().qg())) {
                String strLn = w.ln(pkVar);
                List<DownloadInfo> listQg = tjVarHu.qg();
                if (listQg == null) {
                    downloadInfoQg = null;
                    break;
                }
                Iterator<DownloadInfo> it = listQg.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        downloadInfoQg = null;
                        break;
                    }
                    DownloadInfo next = it.next();
                    if (next != null && TextUtils.equals(strLn, next.getPackageName())) {
                        downloadInfoQg = next;
                        break;
                    }
                }
            } else {
                String strQg = pkVar.k().qg();
                downloadInfoQg = tjVarHu.qg(com.byazt.xv.s.n(strQg, n(pkVar, strQg, true)));
            }
            if (downloadInfoQg == null) {
                return Integer.MIN_VALUE;
            }
            int status = downloadInfoQg.getStatus();
            downloadInfoQg.getStatusAtDbInit();
            downloadInfoQg.getRealStatus();
            return status;
        } catch (Exception e) {
            com.byazt.eji.s.n().n("createAdDownloadModel", e);
            return Integer.MIN_VALUE;
        }
    }

    public static String s(pk pkVar) {
        if (pkVar == null) {
            return "";
        }
        com.byazt.gct.l lVarK = pkVar.k();
        if (lVarK != null && !TextUtils.isEmpty(lVarK.s())) {
            return lVarK.s();
        }
        if (!TextUtils.isEmpty(pkVar.yr())) {
            return pkVar.yr();
        }
        if (TextUtils.isEmpty(pkVar.m19if())) {
            return !TextUtils.isEmpty(pkVar.em()) ? pkVar.em() : "";
        }
        return pkVar.m19if();
    }

    private static boolean x(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        return fs(pkVar);
    }

    private static boolean fs(pk pkVar) {
        com.byazt.gct.w wVarCd = pkVar.cd();
        return (wVarCd == null || TextUtils.isEmpty(wVarCd.sz()) || TextUtils.isEmpty(wVarCd.l()) || TextUtils.isEmpty(wVarCd.x()) || wVarCd.n() == null || wVarCd.n().size() <= 0 || TextUtils.isEmpty(wVarCd.fs()) || TextUtils.isEmpty(wVarCd.rv())) ? false : true;
    }

    public static void n(final Context context, pk pkVar, String str) {
        if (context == null) {
            context = rv.getContext();
        }
        n(pkVar, str);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            h.n(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            com.byazt.vyf.l.q().post(new x("tt_download_toast") { // from class: com.byazt.oh.l.1
                @Override // java.lang.Runnable
                public void run() {
                    h.n(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }

    public static void n(pk pkVar, String str) {
        if (pkVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reqId", pkVar.ou());
                jSONObject.putOpt("cid", pkVar.q());
                jSONObject.putOpt("adId", pkVar.wm());
                jSONObject.putOpt("dlscene", str);
                com.byazt.zq.qg qgVarXd = pkVar.xd();
                JSONObject jSONObjectA_ = pkVar.A_();
                if (jSONObjectA_ != null) {
                    jSONObject.putOpt("landing_type", Integer.valueOf(jSONObjectA_.optInt("landing_type", -1)));
                }
                if (qgVarXd != null) {
                    jSONObject.putOpt("slotType", Integer.valueOf(qgVarXd.a()));
                }
            } catch (Exception unused) {
            }
            com.byazt.eji.s.n().n("download_no_response", jSONObject, (Throwable) null);
        }
    }

    public static com.byazt.gct.w n(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        return com.byazt.vgx.qg.l(jSONObject);
    }

    public static boolean q(pk pkVar) {
        int iD;
        return (pkVar == null || pkVar.nk() == null || nf.n(pkVar) == 1 || pkVar.ys() != 1 || (iD = w.d(pkVar)) == 1 || iD == 2 || iD == 5 || iD == 6) ? false : true;
    }

    public static void n(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectNp = rv.qg().np();
            int iOptInt = jSONObjectNp != null ? jSONObjectNp.optInt("resume_download_max_count", 5) : 5;
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
        } catch (Exception unused) {
        }
    }

    public static boolean l(pk pkVar) {
        um umVarD_;
        if (pkVar != null && (umVarD_ = pkVar.D_()) != null && umVarD_.s() && pkVar.ys() == 1) {
            return q(pkVar);
        }
        return false;
    }

    public static boolean w(pk pkVar) {
        return (pkVar == null || pkVar.D_() == null || pkVar.ys() != 1 || !l(pkVar) || cd.oa(pkVar)) ? false : true;
    }

    public static FrameLayout n(final Context context, final pk pkVar, com.byazt.gct.q qVar, int i) {
        String strN;
        String strS;
        String strQg;
        String strCp;
        String str;
        String strL;
        int i2;
        int i3;
        if (context == null) {
            return null;
        }
        com.byazt.gct.w wVarCd = pkVar.cd();
        final String strQg2 = w.qg(pkVar);
        if (qVar != null) {
            strN = qVar.n();
            strS = qVar.s();
            strQg = qVar.qg();
            strCp = qVar.w();
            String strFs = qVar.fs();
            strL = qVar.l();
            str = strFs;
        } else if (wVarCd != null) {
            String strSz = wVarCd.sz();
            String strX = wVarCd.x();
            String strL2 = wVarCd.l();
            str = null;
            strL = null;
            strCp = wVarCd.cp();
            strN = strSz;
            strS = strX;
            strQg = strL2;
        } else {
            strN = null;
            strS = null;
            strQg = null;
            strCp = null;
            str = null;
            strL = null;
        }
        if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(strS)) {
            return null;
        }
        final int color = Color.parseColor("#99FFFFFF");
        StringBuilder sb = new StringBuilder();
        sb.append("点击" + (i == 8 ? "下" : "上") + "方按钮 立即下载应用").append("\n应用名称：").append(strN).append("   |   开发者：").append(strS).append("\n版本号：").append(strQg);
        if (TextUtils.isEmpty(strCp)) {
            sb.append("  |  功能  |  权限  |  隐私  ");
        } else {
            sb.append("  |  功能  |  权限  |  隐私  |  备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i4 = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i5 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i6 = iIndexOf3 + 2;
        if (TextUtils.isEmpty(strCp)) {
            i2 = i6;
            i3 = 34;
        } else {
            int iIndexOf4 = sb.indexOf("备案");
            int i7 = iIndexOf4 + 2;
            spannableString.setSpan(new StyleSpan(1), iIndexOf4, i7, 34);
            i3 = 34;
            final String str2 = str;
            i2 = i6;
            spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.oh.l.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    l.n(pkVar, str2, context, strQg2);
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
            }, iIndexOf4, i7, 34);
        }
        spannableString.setSpan(new StyleSpan(1), iIndexOf, i4, i3);
        final String str3 = strL;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.oh.l.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                l.qg(pkVar, str3, context, strQg2);
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
        }, iIndexOf, i4, i3);
        spannableString.setSpan(new StyleSpan(1), iIndexOf2, i5, i3);
        final String str4 = str;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.oh.l.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                l.w(pkVar, str4, context, strQg2);
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
        }, iIndexOf2, i5, i3);
        int i8 = i2;
        spannableString.setSpan(new StyleSpan(1), iIndexOf3, i8, i3);
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.oh.l.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                l.l(pkVar, str4, context, strQg2);
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
        }, iIndexOf3, i8, i3);
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

    private static void n(Context context, pk pkVar) {
        HashMap map = new HashMap();
        map.put("downloadstatuscontroller_type", 2);
        String strQg = w.qg(pkVar);
        com.byazt.gct.rv.n nVar = new com.byazt.gct.rv.n();
        float fX = com.byazt.okk.s.x(context);
        int iA = ((oa) com.byazt.qp.q.n("device_info_new")).a();
        com.byazt.hm.n.n("click", pkVar, nVar.n(fX).qg(iA).n((byte) 3).qg(com.byazt.okk.s.fs(context)).n(qg(pkVar)).n(), strQg, true, (Map<String, Object>) map, 1, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(pk pkVar, String str, Context context, String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        n(context, pkVar);
        com.byazt.okk.n.s(pkVar, str, context, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(pk pkVar, String str, Context context, String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        n(context, pkVar);
        com.byazt.okk.n.qg(pkVar, str, context, str2);
    }

    public static void n(pk pkVar, String str, Context context, String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        n(context, pkVar);
        com.byazt.okk.n.n(pkVar, str, context, str2);
    }

    public static void qg(pk pkVar, String str, Context context, String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        n(context, pkVar);
        com.byazt.okk.n.n(context, str, pkVar, str2);
    }

    public static void qg(pk pkVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (pkVar == null) {
                jSONObject.put("message", "meta is null");
            } else {
                um umVarD_ = pkVar.D_();
                if (umVarD_ == null) {
                    jSONObject.put("message", "download_conf is null");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    umVarD_.n(jSONObject2);
                    jSONObject.put("message", jSONObject2);
                }
                jSONObject.put("req_id", pkVar.ou());
                jSONObject.put("cid", pkVar.q());
                jSONObject.put("rit", w.n(pkVar, ""));
            }
            jSONObject.put("dl_type", str);
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().n("download_no_suspend", jSONObject, (Throwable) null);
    }
}
