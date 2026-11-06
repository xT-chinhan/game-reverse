package com.byazt.rz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.anythink.core.common.l.f;
import com.byazt.ho.BaseConstants;
import com.byazt.ky.DownloadMarketInterceptor;
import com.byazt.ky.um;
import com.byazt.q.AdBaseConstants;
import com.byazt.td.JumpKllkActivity;
import com.byazt.y.AdDownloadController;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 101})
public class fs {
    public static final String n = "fs";

    public static com.byazt.vl.x n(Context context, Uri uri) {
        Intent intent;
        if (!com.byazt.bk.l.s() && (context == null || uri == null)) {
            return new com.byazt.vl.x(6, 12);
        }
        try {
            String strTj = com.byazt.bk.l.tj();
            if (com.byazt.bk.l.hd() && (TextUtils.isEmpty(strTj) || !oa.l(context, strTj))) {
                strTj = "com.huawei.appmarket";
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!oa.n(context, intent)) {
                return new com.byazt.vl.x(6, 13);
            }
            if (oa.l(context, strTj) && !com.byazt.bk.l.x()) {
                intent.setPackage(strTj);
            }
            if (com.byazt.f.n.s().n("fix_jump_market")) {
                if (!(context instanceof Activity)) {
                    intent.addFlags(335544320);
                }
            } else if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (com.byazt.f.n.s().qg("test_jump_market_failed") == 1) {
                com.byazt.ch.s.n().n(false, "jump market error");
                return new com.byazt.vl.x(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.byazt.vl.x(5);
        } catch (Exception unused) {
            return new com.byazt.vl.x(6, 14);
        }
    }

    public static com.byazt.vl.x n(final Context context, Uri uri, com.byazt.vl.l lVar) {
        if (context == null || !com.byazt.t.tj.n(uri)) {
            return new com.byazt.vl.x(6, 12);
        }
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!oa.n(context, intent)) {
                return new com.byazt.vl.x(6, 13);
            }
            String strTj = com.byazt.bk.l.tj();
            if (oa.l(context, strTj)) {
                intent.setPackage(strTj);
            }
            intent.addFlags(335544320);
            if (com.byazt.f.n.s().qg("test_jump_market_failed") == 1 && "local_test".equals(com.byazt.ug.d.tj().s)) {
                com.byazt.ch.s.n().n(false, "jump market error");
                return new com.byazt.vl.x(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long jOptLong = com.byazt.ug.d.rv().optLong("market_jump_delay", 1000L);
            if (jOptLong > 0 && lVar != null && lVar.l != null && !lVar.l.ci()) {
                com.byazt.s.fs.n().qg().post(new Runnable() { // from class: com.byazt.rz.fs.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.ug.d.s().n(8, com.byazt.ug.d.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                    }
                });
            }
            com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.rz.fs.2
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            return new com.byazt.vl.x(5);
        } catch (Exception unused) {
            return new com.byazt.vl.x(6, 14);
        }
    }

    public static com.byazt.vl.x n(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.byazt.vl.x(6, 11);
        }
        if (com.byazt.bk.l.x() && oa.l(context, "com.sec.android.app.samsungapps")) {
            return q(context, str);
        }
        return n(context, com.byazt.es.n.n(context, str));
    }

    public static com.byazt.vl.x n(Context context, com.byazt.vl.l lVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.byazt.vl.x(6, 11);
        }
        if (com.byazt.bk.l.x() && oa.l(context, "com.sec.android.app.samsungapps")) {
            return q(context, str);
        }
        if (!lVar.qg.isAd() || !lVar.q.enableAM()) {
            return n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        JSONArray jSONArrayOptJSONArray = com.byazt.ug.d.rv().optJSONArray("am_plans");
        if (com.byazt.bk.l.l() && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_3")) {
            return qg(context, lVar, str);
        }
        if (com.byazt.bk.l.w() && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_2")) {
            l(context, lVar, str);
            return new com.byazt.vl.x(7, "am_m2");
        }
        if (com.byazt.bk.l.q() && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_5")) {
            fs(context, lVar, str);
            return new com.byazt.vl.x(7, "am_v1");
        }
        if (com.byazt.bk.l.l() && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_7") && (lVar.q instanceof AdDownloadController) && ((AdDownloadController) lVar.q).enableOppoAutoDownload()) {
            return q(context, lVar, str);
        }
        if (com.byazt.bk.l.q() && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_8") && oa.n(oa.s(context, "com.bbk.appstore"), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) >= 0) {
            rv(context, lVar, str);
            return new com.byazt.vl.x(7, "am_v2");
        }
        if ((com.byazt.bk.l.n() || com.byazt.bk.l.qg()) && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_9")) {
            w(context, lVar, str);
            return new com.byazt.vl.x(7, "am_hr");
        }
        if ((com.byazt.bk.l.n() || com.byazt.bk.l.qg()) && com.byazt.bk.n.n(jSONArrayOptJSONArray, "am_10")) {
            x(context, lVar, str);
            return new com.byazt.vl.x(7, "am_hr2");
        }
        if ((lVar.q instanceof AdDownloadController) && ((AdDownloadController) lVar.q).enableOppoAutoDownload() && ((AdDownloadController) lVar.q).getDownloadMarketInterceptor() != null && lVar.qg.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
            s(context, lVar, str);
            return new com.byazt.vl.x(7, "am_kllk4");
        }
        return n(context, com.byazt.es.n.n(context, str));
    }

    private static com.byazt.vl.x q(Context context, String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.byazt.vl.x(5);
        } catch (Exception unused) {
            return new com.byazt.vl.x(6, 14);
        }
    }

    public static boolean n(Context context, com.byazt.vl.l lVar, String str, JSONObject jSONObject, boolean z, int i) {
        oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
        lVar.q.getMarketStatusChangeListener();
        com.byazt.vj.n.n().qg("market_click_open", jSONObject, lVar);
        com.byazt.vl.x xVarN = n(context, Uri.parse(str));
        String strN = oa.n(xVarN.qg(), "open_market");
        int type = xVarN.getType();
        if (type == 5) {
            com.byazt.t.n.n(strN, jSONObject, lVar, true);
        } else {
            if (type == 6) {
                oa.n(jSONObject, "error_code", Integer.valueOf(xVarN.n()));
                oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
                com.byazt.vj.n.n().qg("market_open_failed", jSONObject, lVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.byazt.vj.n.n().n(lVar.n, i);
        }
        return true;
    }

    private static com.byazt.vl.x qg(Context context, com.byazt.vl.l lVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(f.W, str);
        intent.putExtra("id", lVar.n);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.byazt.vl.x(7, "am_kllk2");
        } catch (Throwable unused) {
            qg(lVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    private static void s(Context context, com.byazt.vl.l lVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            n(context, str, lVar.n);
        } catch (Exception unused) {
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
            qg(lVar, jSONObject, 14, 11, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static com.byazt.vl.x q(Context context, com.byazt.vl.l lVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("dl", true);
        intent.putExtra(f.W, str);
        intent.putExtra("id", lVar.n);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO);
        } else if (oa.l(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
        } else if (oa.l(context, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO);
        } else {
            return n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.byazt.vl.x(7, "am_kllk3");
        } catch (Throwable unused) {
            qg(lVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    public static void n(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        try {
            JSONObject jSONObjectRv = com.byazt.ug.d.rv();
            String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
            String strN = com.byazt.bk.s.n(jSONObjectRv.optString("aa"), strOptString);
            String strN2 = com.byazt.bk.s.n(jSONObjectRv.optString("ac"), strOptString);
            String strN3 = com.byazt.bk.s.n(jSONObjectRv.optString("af"), strOptString);
            boolean zN = com.byazt.bk.n.n(jSONObjectRv, context, strN2);
            StringBuilder sb = new StringBuilder(String.format(strN, str, strN3, strN2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strTj = com.byazt.bk.l.tj();
            if (oa.l(context, strTj)) {
                intent.setPackage(strTj);
            }
            if (z) {
                sb.append(com.byazt.bk.s.n(jSONObjectRv.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            oa.n(jSONObject, "mf", Boolean.valueOf(zN));
            oa.n(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.byazt.t.n.n("am_kllk2", jSONObject, lVarL, true);
            if (zN) {
                qg(lVarL, jSONObject, -1, 3, sb.toString());
            } else {
                qg(lVarL, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.byazt.t.n.n(n(com.byazt.ug.d.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
            qg(lVarL, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void n(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        try {
            JSONObject jSONObjectRv = com.byazt.ug.d.rv();
            String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
            String strN = com.byazt.bk.s.n(jSONObjectRv.optString("br"), strOptString);
            String strN2 = com.byazt.bk.s.n(jSONObjectRv.optString("bs_1"), strOptString);
            String strN3 = com.byazt.bk.s.n(jSONObjectRv.optString("bs_2"), strOptString);
            String strN4 = com.byazt.bk.s.n(jSONObjectRv.optString("bs_3"), strOptString);
            String strN5 = com.byazt.bk.s.n(jSONObjectRv.optString("bt"), strOptString);
            String strN6 = com.byazt.bk.s.n(jSONObjectRv.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strN).append(strN2).append(strN3).append(strN4).append(strN5).append(strN6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            oa.n(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long jOptLong = com.byazt.ug.d.rv().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.byazt.s.fs.n().qg().post(new Runnable() { // from class: com.byazt.rz.fs.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.ug.d.s().n(12, com.byazt.ug.d.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.rz.fs.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            if (lVarL.l != null) {
                lVarL.l.ou(true);
            }
            com.byazt.t.n.n("am_kllk3", jSONObject, lVarL, true);
            qg(lVarL, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            if (lVarL.l != null) {
                lVarL.l.ou(false);
            }
            com.byazt.t.n.n(n(com.byazt.ug.d.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str), lVarL), lVarL, true);
            qg(lVarL, jSONObject, 2, 7, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean n(Activity activity, String str, HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", map);
        String strTj = com.byazt.bk.l.tj();
        if (oa.l(com.byazt.ug.d.getContext(), strTj)) {
            intent.setPackage(strTj);
        }
        if (!oa.n(com.byazt.ug.d.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "start v1");
            return false;
        }
    }

    private static void l(final Context context, final com.byazt.vl.l lVar, final String str) {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.rz.fs.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.t.n.n(fs.n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectRv = com.byazt.ug.d.rv();
                    Thread.sleep(jSONObjectRv.optInt("m2_delay_millis", 1000));
                    com.byazt.xy.n.n().n(context, true);
                    com.byazt.xy.qg qgVar = new com.byazt.xy.qg();
                    qgVar.n = 1;
                    qgVar.qg = 0;
                    String strN = com.byazt.bk.s.n(jSONObjectRv.optString("v"), jSONObjectRv.optString(com.anythink.core.common.s.a));
                    qgVar.s = String.format(strN, str);
                    com.byazt.xy.n.n().n(qgVar, (com.byazt.xy.q) null);
                    com.byazt.xy.n.n().qg();
                    fs.qg(lVar, jSONObject, -1, 2, String.format(strN, str));
                } catch (Throwable unused) {
                    fs.qg(lVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void w(final Context context, final com.byazt.vl.l lVar, final String str) {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.rz.fs.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectRv = com.byazt.ug.d.rv();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
                    String strN = com.byazt.bk.s.n(jSONObjectRv.optString("bw"), strOptString);
                    String strN2 = com.byazt.bk.s.n(jSONObjectRv.optString("bx"), strOptString);
                    String strN3 = com.byazt.bk.s.n(jSONObjectRv.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(BaseConstants.SCHEME_HTTPS).authority(strN).appendPath(strN2).appendQueryParameter(strN3, str);
                    com.byazt.ug.d.q().n(TapHttp.METHOD_GET, builder.build().toString(), null, new um() { // from class: com.byazt.rz.fs.6.1
                        /* JADX WARN: Code duplicated, block: B:9:0x002c  */
                        @Override // com.byazt.ky.um
                        public void n(String str2) {
                            boolean z;
                            if (TextUtils.isEmpty(str2)) {
                                z = false;
                            } else {
                                String strS = fs.s(str2);
                                if (TextUtils.isEmpty(strS)) {
                                    z = false;
                                } else {
                                    String strQ = fs.q(strS);
                                    if (TextUtils.isEmpty(strQ)) {
                                        z = false;
                                    } else {
                                        fs.qg(context, lVar, str, strQ);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                return;
                            }
                            com.byazt.t.n.n(fs.n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
                            fs.qg(lVar, jSONObject, 10, 9, BaseConstants.MARKET_PREFIX + str);
                        }

                        @Override // com.byazt.ky.um
                        public void n(Throwable th) {
                            com.byazt.t.n.n(fs.n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
                            oa.n(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                            fs.qg(lVar, jSONObject, 11, 9, BaseConstants.MARKET_PREFIX + str);
                        }
                    });
                } catch (Exception unused) {
                    fs.qg(lVar, jSONObject, 4, 9, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void x(Context context, com.byazt.vl.l lVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.n(str, lVar.n);
        } catch (Exception unused) {
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
            qg(lVar, jSONObject, 13, 10, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static void fs(final Context context, final com.byazt.vl.l lVar, final String str) {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.rz.fs.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectRv = com.byazt.ug.d.rv();
                String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
                final JSONObject jSONObject = new JSONObject();
                String strN = com.byazt.bk.s.n(jSONObjectRv.optString(com.byazt.af.x.n), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                oa.n(jSONObject2, "t", "v");
                oa.n(jSONObject2, f.W, str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.byazt.ug.d.q().n(strN, com.byazt.ug.d.cd().n(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new um() { // from class: com.byazt.rz.fs.7.1
                    @Override // com.byazt.ky.um
                    public void n(String str2) {
                        fs.qg(context, str, str2, lVar, jSONObject);
                    }

                    @Override // com.byazt.ky.um
                    public void n(Throwable th) {
                        com.byazt.t.n.n(fs.n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
                        oa.n(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                        fs.qg(lVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    private static void rv(Context context, com.byazt.vl.l lVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.n(str, lVar.n, BaseConstants.VIVO_MARKET_NEED_COMMENT);
        } catch (Exception unused) {
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
            qg(lVar, jSONObject, 9, 8, BaseConstants.MARKET_PREFIX + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Context context, String str, String str2, com.byazt.vl.l lVar, JSONObject jSONObject) {
        oa.n(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strN = com.byazt.bk.s.n(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strN)) {
                TTDelegateActivity.n(str, lVar.n, strN, jSONObject);
            } else {
                com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
                qg(lVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
            }
        } catch (Exception unused) {
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
            qg(lVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void n(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        try {
            JSONObject jSONObjectRv = com.byazt.ug.d.rv();
            boolean zN = com.byazt.bk.n.n(jSONObjectRv, activity, com.byazt.bk.s.n(jSONObjectRv.optString("bg"), jSONObjectRv.optString(com.anythink.core.common.s.a)));
            HashMap<String, String> mapQg = oa.qg(new JSONObject(str2));
            if (zN && !mapQg.isEmpty() && n(activity, str, mapQg)) {
                qg(lVarL, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.byazt.t.n.n("am_v1", jSONObject, lVarL, true);
                return;
            }
            if (zN) {
                i = mapQg.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            qg(lVarL, jSONObject, i, 5, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n(n((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
        } catch (Exception unused2) {
            com.byazt.t.n.n(n(com.byazt.ug.d.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
            qg(lVarL, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void n(Activity activity, String str, long j, String str2) {
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectRv = com.byazt.ug.d.rv();
        String strN = com.byazt.bk.s.n(jSONObjectRv.optString("bv"), jSONObjectRv.optString(com.anythink.core.common.s.a));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strN)) {
            builder.appendQueryParameter(strN, str2);
        }
        if (n(activity, builder.build())) {
            qg(lVarL, jSONObject, -1, 8, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n("am_v2", jSONObject, lVarL, true);
        } else {
            qg(lVarL, jSONObject, 2, 8, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n(n((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
        }
    }

    public static boolean n(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strTj = com.byazt.bk.l.tj();
        if (oa.l(com.byazt.ug.d.getContext(), strTj)) {
            intent.setPackage(strTj);
        }
        if (!oa.n(com.byazt.ug.d.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "start v2");
            return false;
        }
    }

    public static boolean qg(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strTj = com.byazt.bk.l.tj();
        if (oa.l(com.byazt.ug.d.getContext(), strTj)) {
            intent.setPackage(strTj);
        }
        if (!oa.n(com.byazt.ug.d.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "start HM1");
            return false;
        }
    }

    public static boolean s(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strTj = com.byazt.bk.l.tj();
        if (oa.l(com.byazt.ug.d.getContext(), strTj)) {
            intent.setPackage(strTj);
        }
        if (!oa.n(com.byazt.ug.d.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "start HM2");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.vl.l lVar, JSONObject jSONObject, int i, int i2, String str) {
        oa.n(jSONObject, "error_code", Integer.valueOf(i));
        oa.n(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        oa.n(jSONObject, "rmu", str);
        oa.n(jSONObject, com.byazt.bk.l.tj(), Integer.valueOf(oa.qg(com.byazt.ug.d.getContext(), com.byazt.bk.l.tj())));
        com.byazt.vj.n.n().qg("am_result", jSONObject, lVar);
    }

    public static com.byazt.vl.x qg(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.byazt.vl.x(4, 11);
        }
        if (context == null) {
            context = com.byazt.ug.d.getContext();
        }
        Intent intentX = oa.x(context, str);
        if (intentX == null) {
            return new com.byazt.vl.x(4, 22);
        }
        intentX.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentX);
            return new com.byazt.vl.x(3);
        } catch (Exception unused) {
            return new com.byazt.vl.x(4, 23);
        }
    }

    public static com.byazt.vl.x n(Context context, String str, com.byazt.h.n nVar) {
        Intent intentN = n(context, nVar, str, 1, (String) null);
        if (intentN != null) {
            d.n().n(n, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.byazt.vl.x xVarN = n(intentN, true, context, str, nVar);
            if (xVarN.getType() == 3) {
                return xVarN;
            }
        }
        Intent intentX = oa.x(context, str);
        if (intentX == null) {
            return new com.byazt.vl.x(4, 22);
        }
        return n(intentX, false, context, str, nVar);
    }

    private static com.byazt.vl.x n(Intent intent, boolean z, Context context, String str, com.byazt.h.n nVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.byazt.ug.d.rv().optInt("open_package_mode") == 1 && com.byazt.ug.d.d() != null && com.byazt.ug.d.d().n() && nVar.hd() && !z) {
            TTDelegateActivity.qg(str, nVar);
            return new com.byazt.vl.x(3);
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intent);
            return new com.byazt.vl.x(3);
        } catch (Exception e) {
            if (z) {
                d.n().qg(n, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.byazt.vl.x(8, 23);
            }
            d.n().qg(n, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.byazt.vl.x(4, 23);
        }
    }

    public static com.byazt.vl.x n(String str, com.byazt.h.n nVar) {
        return n(com.byazt.ug.d.getContext(), str, nVar);
    }

    public static com.byazt.vl.x qg(String str, com.byazt.h.n nVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.byazt.vl.x(2, 21);
        }
        Context context = com.byazt.ug.d.getContext();
        String packageName = nVar.py().getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            d.n().n(n, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent intentN = n(context, nVar, packageName, 2, str);
            if (intentN != null) {
                com.byazt.vl.x xVarN = n(context, intentN, nVar, true, str);
                if (xVarN.getType() == 1) {
                    return xVarN;
                }
            }
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.byazt.f.n.s().n("fix_app_link_flag")) {
            intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        return n(context, intent, nVar, false, str);
    }

    private static com.byazt.vl.x n(Context context, Intent intent, com.byazt.h.n nVar, boolean z, String str) {
        if (context == null) {
            context = com.byazt.ug.d.getContext();
        }
        if (oa.qg(context, intent)) {
            if (com.byazt.ug.d.rv().optInt("open_url_mode") == 0 && com.byazt.ug.d.d() != null && com.byazt.ug.d.d().n() && Build.VERSION.SDK_INT >= 26 && nVar.hd() && !z) {
                TTDelegateActivity.n(str, nVar);
                return new com.byazt.vl.x(1);
            }
            try {
                context.startActivity(intent);
                return new com.byazt.vl.x(1);
            } catch (Exception e) {
                if (z) {
                    d.n().qg(n, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.byazt.vl.x(9);
                }
                d.n().qg(n, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.byazt.vl.x(2);
            }
        }
        return new com.byazt.vl.x(2, 24);
    }

    public static com.byazt.vl.x n(com.byazt.h.qg qgVar, String str, String str2) {
        com.byazt.vl.x xVarQg = qg(str, qgVar);
        return (com.byazt.t.w.n(qgVar) && xVarQg.getType() == 2) ? n(str2, qgVar) : xVarQg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Context context, com.byazt.vl.l lVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.qg(str, lVar.n, str2);
        } catch (Exception unused) {
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVar, true);
            qg(lVar, jSONObject, 12, 9, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void qg(Activity activity, String str, long j, String str2) {
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectRv = com.byazt.ug.d.rv();
        String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
        String strN = com.byazt.bk.s.n(jSONObjectRv.optString("bz"), strOptString);
        String strN2 = com.byazt.bk.s.n(jSONObjectRv.optString("ca"), strOptString);
        String strN3 = com.byazt.bk.s.n(jSONObjectRv.optString("cb"), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.MARKET_SCHEME_HW_HONOR).authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strN)) {
            builder.appendQueryParameter(strN, str2);
        }
        if (!TextUtils.isEmpty(strN2) && !TextUtils.isEmpty(strN3)) {
            builder.appendQueryParameter(strN2, strN3);
        }
        if (qg(activity, builder.build())) {
            qg(lVarL, jSONObject, -1, 9, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n("am_hr", jSONObject, lVarL, true);
        } else {
            qg(lVarL, jSONObject, 2, 9, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n(n((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
        }
    }

    public static void n(Activity activity, String str, long j) {
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectRv = com.byazt.ug.d.rv();
        String strOptString = jSONObjectRv.optString(com.anythink.core.common.s.a);
        String strN = com.byazt.bk.s.n(jSONObjectRv.optString("ca"), strOptString);
        String strN2 = com.byazt.bk.s.n(jSONObjectRv.optString("cc"), strOptString);
        StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
        if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(strN2)) {
            sb.append(str).append("&").append(strN).append("=").append(strN2);
        }
        if (s(activity, Uri.parse(sb.toString()))) {
            qg(lVarL, jSONObject, -1, 10, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n("am_hr2", jSONObject, lVarL, true);
        } else {
            qg(lVarL, jSONObject, 2, 10, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n(n((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
        }
    }

    public static void n(Context context, String str, long j) {
        com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(j);
        JSONObject jSONObject = new JSONObject();
        if (lVarL.q instanceof AdDownloadController) {
            boolean zEnableOppoAutoDownload = ((AdDownloadController) lVarL.q).enableOppoAutoDownload();
            HashMap map = new HashMap();
            map.put("is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            oa.n(jSONObject, "is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            DownloadMarketInterceptor downloadMarketInterceptor = ((AdDownloadController) lVarL.q).getDownloadMarketInterceptor();
            if (downloadMarketInterceptor != null) {
                Map<String, Object> mapInterceptObmMarket = downloadMarketInterceptor.interceptObmMarket(map);
                if (mapInterceptObmMarket != null && mapInterceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(mapInterceptObmMarket.get("convert_result").toString())) {
                    qg(lVarL, jSONObject, -1, 11, BaseConstants.MARKET_PREFIX + str);
                    com.byazt.t.n.n("am_kllk4", jSONObject, lVarL, true);
                    return;
                } else {
                    qg(lVarL, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
                    com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
                    return;
                }
            }
            qg(lVarL, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
            com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
            return;
        }
        qg(lVarL, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
        com.byazt.t.n.n(n(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), lVarL, true);
    }

    public static boolean s(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(e.a.d)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static Intent n(Context context, com.byazt.h.n nVar, String str, int i, String str2) {
        if (!nVar.s() || nVar.wm() == null || nVar.wm().getDownloadMode() != 2 || nVar.py() == null || l.n(nVar).n("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String strS = com.byazt.ug.rv.s(nVar.py());
        String strQ = com.byazt.ug.rv.q(nVar.py());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(strS) || resolveInfoResolveActivity == null) {
            return null;
        }
        intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, strS);
        if (!(context instanceof Activity)) {
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (!TextUtils.isEmpty(strQ)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, strQ);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
