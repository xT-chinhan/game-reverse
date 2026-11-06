package com.byazt.uk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fi.BaseConstants;
import com.byazt.km.AdDownloadController;
import com.byazt.okf.JumpKllkActivity;
import com.byazt.zv.DownloadMarketInterceptor;
import com.byazt.zv.qa;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static final String pr = zo.class.getSimpleName();

    public static com.byazt.shh.fw pr(Context context, Uri uri) {
        Intent intent;
        if (!com.byazt.now.c.hn() && (context == null || uri == null)) {
            return new com.byazt.shh.fw(6, 12);
        }
        try {
            String strVk = com.byazt.now.c.vk();
            if (com.byazt.now.c.yb() && (TextUtils.isEmpty(strVk) || !m.c(context, strVk))) {
                strVk = "com.huawei.appmarket";
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme(BaseConstants.SCHEME_MARKET);
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!m.pr(context, intent)) {
                return new com.byazt.shh.fw(6, 13);
            }
            if (m.c(context, strVk) && !com.byazt.now.c.fw()) {
                intent.setPackage(strVk);
            }
            if (com.byazt.ew.pr.hn().pr("fix_jump_market")) {
                if (!(context instanceof Activity)) {
                    intent.addFlags(335544320);
                }
            } else if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (com.byazt.ew.pr.hn().hw("test_jump_market_failed") == 1) {
                com.byazt.vi.hn.pr().pr(false, "jump market error");
                return new com.byazt.shh.fw(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.byazt.shh.fw(5);
        } catch (Exception e) {
            return new com.byazt.shh.fw(6, 14);
        }
    }

    public static com.byazt.shh.fw pr(final Context context, Uri uri, com.byazt.shh.c cVar) {
        if (context == null || !com.byazt.ds.vk.pr(uri)) {
            return new com.byazt.shh.fw(6, 12);
        }
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!m.pr(context, intent)) {
                return new com.byazt.shh.fw(6, 13);
            }
            String strVk = com.byazt.now.c.vk();
            if (m.c(context, strVk)) {
                intent.setPackage(strVk);
            }
            intent.addFlags(335544320);
            if (com.byazt.ew.pr.hn().hw("test_jump_market_failed") == 1 && "local_test".equals(com.byazt.eld.k.vk().hn)) {
                com.byazt.vi.hn.pr().pr(false, "jump market error");
                return new com.byazt.shh.fw(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long jOptLong = com.byazt.eld.k.aj().optLong("market_jump_delay", 1000L);
            if (jOptLong > 0 && cVar != null && cVar.c != null && !cVar.c.sv()) {
                com.byazt.cvl.zo.pr().hw().post(new Runnable() { // from class: com.byazt.uk.zo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.eld.k.hn().pr(8, com.byazt.eld.k.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                    }
                });
            }
            com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.zo.2
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            return new com.byazt.shh.fw(5);
        } catch (Exception e) {
            return new com.byazt.shh.fw(6, 14);
        }
    }

    public static com.byazt.shh.fw pr(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.byazt.shh.fw(6, 11);
        }
        if (com.byazt.now.c.fw() && m.c(context, "com.sec.android.app.samsungapps")) {
            return x(context, str);
        }
        return pr(context, com.byazt.snv.pr.pr(context, str));
    }

    public static com.byazt.shh.fw pr(Context context, com.byazt.shh.c cVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.byazt.shh.fw(6, 11);
        }
        if (com.byazt.now.c.fw() && m.c(context, "com.sec.android.app.samsungapps")) {
            return x(context, str);
        }
        if (!cVar.hw.isAd() || !cVar.x.enableAM()) {
            return pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        JSONArray jSONArrayOptJSONArray = com.byazt.eld.k.aj().optJSONArray("am_plans");
        if (com.byazt.now.c.c() && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_3")) {
            return hw(context, cVar, str);
        }
        if (com.byazt.now.c.uc() && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_2")) {
            c(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_m2");
        }
        if (com.byazt.now.c.x() && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_5")) {
            zo(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_v1");
        }
        if (com.byazt.now.c.c() && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_7") && (cVar.x instanceof AdDownloadController) && ((AdDownloadController) cVar.x).enableOppoAutoDownload()) {
            return x(context, cVar, str);
        }
        if (com.byazt.now.c.x() && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_8") && m.pr(m.hn(context, "com.bbk.appstore"), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) >= 0) {
            aj(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_v2");
        }
        if ((com.byazt.now.c.pr() || com.byazt.now.c.hw()) && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_9")) {
            uc(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_hr");
        }
        if ((com.byazt.now.c.pr() || com.byazt.now.c.hw()) && com.byazt.now.pr.pr(jSONArrayOptJSONArray, "am_10")) {
            fw(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_hr2");
        }
        if ((cVar.x instanceof AdDownloadController) && ((AdDownloadController) cVar.x).enableOppoAutoDownload() && ((AdDownloadController) cVar.x).getDownloadMarketInterceptor() != null && cVar.hw.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
            hn(context, cVar, str);
            return new com.byazt.shh.fw(7, "am_kllk4");
        }
        return pr(context, com.byazt.snv.pr.pr(context, str));
    }

    private static com.byazt.shh.fw x(Context context, String str) {
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
            return new com.byazt.shh.fw(5);
        } catch (Exception e) {
            return new com.byazt.shh.fw(6, 14);
        }
    }

    public static boolean pr(Context context, com.byazt.shh.c cVar, String str, JSONObject jSONObject, boolean z, int i) {
        m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
        cVar.x.getMarketStatusChangeListener();
        com.byazt.mf.pr.pr().hw("market_click_open", jSONObject, cVar);
        com.byazt.shh.fw fwVarPr = pr(context, Uri.parse(str));
        String strPr = m.pr(fwVarPr.hw(), "open_market");
        switch (fwVarPr.getType()) {
            case 5:
                com.byazt.ds.pr.pr(strPr, jSONObject, cVar, true);
                break;
            case 6:
                m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVarPr.pr()));
                m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
                com.byazt.mf.pr.pr().hw("market_open_failed", jSONObject, cVar);
                return false;
            case 7:
                break;
            default:
                return false;
        }
        if (z) {
            com.byazt.mf.pr.pr().pr(cVar.pr, i);
        }
        return true;
    }

    private static com.byazt.shh.fw hw(Context context, com.byazt.shh.c cVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(an.ax, str);
        intent.putExtra("id", cVar.pr);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.byazt.shh.fw(7, "am_kllk2");
        } catch (Throwable th) {
            hw(cVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    private static void hn(Context context, com.byazt.shh.c cVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            pr(context, str, cVar.pr);
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
            hw(cVar, jSONObject, 14, 11, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static com.byazt.shh.fw x(Context context, com.byazt.shh.c cVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("dl", true);
        intent.putExtra(an.ax, str);
        intent.putExtra("id", cVar.pr);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO);
        } else if (m.c(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
        } else if (m.c(context, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO);
        } else {
            return pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.byazt.shh.fw(7, "am_kllk3");
        } catch (Throwable th) {
            hw(cVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    public static void pr(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        try {
            JSONObject jSONObjectAj = com.byazt.eld.k.aj();
            String strOptString = jSONObjectAj.optString(an.aB);
            String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("aa"), strOptString);
            String strPr2 = com.byazt.now.hn.pr(jSONObjectAj.optString("ac"), strOptString);
            String strPr3 = com.byazt.now.hn.pr(jSONObjectAj.optString("af"), strOptString);
            boolean zPr = com.byazt.now.pr.pr(jSONObjectAj, context, strPr2);
            StringBuilder sb = new StringBuilder(String.format(strPr, str, strPr3, strPr2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strVk = com.byazt.now.c.vk();
            if (m.c(context, strVk)) {
                intent.setPackage(strVk);
            }
            if (z) {
                sb.append(com.byazt.now.hn.pr(jSONObjectAj.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            m.pr(jSONObject, "mf", Boolean.valueOf(zPr));
            m.pr(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.byazt.ds.pr.pr("am_kllk2", jSONObject, cVarC, true);
            if (zPr) {
                hw(cVarC, jSONObject, -1, 3, sb.toString());
            } else {
                hw(cVarC, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(com.byazt.eld.k.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
            hw(cVarC, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void pr(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        try {
            JSONObject jSONObjectAj = com.byazt.eld.k.aj();
            String strOptString = jSONObjectAj.optString(an.aB);
            String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("br"), strOptString);
            String strPr2 = com.byazt.now.hn.pr(jSONObjectAj.optString("bs_1"), strOptString);
            String strPr3 = com.byazt.now.hn.pr(jSONObjectAj.optString("bs_2"), strOptString);
            String strPr4 = com.byazt.now.hn.pr(jSONObjectAj.optString("bs_3"), strOptString);
            String strPr5 = com.byazt.now.hn.pr(jSONObjectAj.optString("bt"), strOptString);
            String strPr6 = com.byazt.now.hn.pr(jSONObjectAj.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strPr).append(strPr2).append(strPr3).append(strPr4).append(strPr5).append(strPr6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            m.pr(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long jOptLong = com.byazt.eld.k.aj().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.byazt.cvl.zo.pr().hw().post(new Runnable() { // from class: com.byazt.uk.zo.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.eld.k.hn().pr(12, com.byazt.eld.k.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.zo.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            if (cVarC.c != null) {
                cVarC.c.ny(true);
            }
            com.byazt.ds.pr.pr("am_kllk3", jSONObject, cVarC, true);
            hw(cVarC, jSONObject, -1, 7, sb.toString());
        } catch (Exception e) {
            if (cVarC.c != null) {
                cVarC.c.ny(false);
            }
            com.byazt.ds.pr.pr(pr(com.byazt.eld.k.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str), cVarC), cVarC, true);
            hw(cVarC, jSONObject, 2, 7, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean pr(Activity activity, String str, HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", map);
        String strVk = com.byazt.now.c.vk();
        if (m.c(com.byazt.eld.k.getContext(), strVk)) {
            intent.setPackage(strVk);
        }
        if (m.pr(com.byazt.eld.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.byazt.vi.hn.pr().pr(e, "start v1");
                return false;
            }
        }
        return false;
    }

    private static void c(final Context context, final com.byazt.shh.c cVar, final String str) {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.zo.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ds.pr.pr(zo.pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectAj = com.byazt.eld.k.aj();
                    Thread.sleep(jSONObjectAj.optInt("m2_delay_millis", 1000));
                    com.byazt.xfv.pr.pr().pr(context, true);
                    com.byazt.xfv.hw hwVar = new com.byazt.xfv.hw();
                    hwVar.pr = 1;
                    hwVar.hw = 0;
                    String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString(an.aE), jSONObjectAj.optString(an.aB));
                    hwVar.hn = String.format(strPr, str);
                    com.byazt.xfv.pr.pr().pr(hwVar, (com.byazt.xfv.x) null);
                    com.byazt.xfv.pr.pr().hw();
                    zo.hw(cVar, jSONObject, -1, 2, String.format(strPr, str));
                } catch (Throwable th) {
                    zo.hw(cVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void uc(final Context context, final com.byazt.shh.c cVar, final String str) {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.zo.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectAj = com.byazt.eld.k.aj();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectAj.optString(an.aB);
                    String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("bw"), strOptString);
                    String strPr2 = com.byazt.now.hn.pr(jSONObjectAj.optString("bx"), strOptString);
                    String strPr3 = com.byazt.now.hn.pr(jSONObjectAj.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(BaseConstants.SCHEME_HTTPS).authority(strPr).appendPath(strPr2).appendQueryParameter(strPr3, str);
                    com.byazt.eld.k.x().pr(TapHttp.METHOD_GET, builder.build().toString(), null, new qa() { // from class: com.byazt.uk.zo.6.1
                        /* JADX WARN: Code duplicated, block: B:9:0x002e  */
                        @Override // com.byazt.zv.qa
                        public void pr(String str2) {
                            boolean z;
                            if (!TextUtils.isEmpty(str2)) {
                                String strHn = zo.hn(str2);
                                if (!TextUtils.isEmpty(strHn)) {
                                    String strX = zo.x(strHn);
                                    if (!TextUtils.isEmpty(strX)) {
                                        zo.hw(context, cVar, str, strX);
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            if (!z) {
                                com.byazt.ds.pr.pr(zo.pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
                                zo.hw(cVar, jSONObject, 10, 9, BaseConstants.MARKET_PREFIX + str);
                            }
                        }

                        @Override // com.byazt.zv.qa
                        public void pr(Throwable th) {
                            com.byazt.ds.pr.pr(zo.pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
                            m.pr(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                            zo.hw(cVar, jSONObject, 11, 9, BaseConstants.MARKET_PREFIX + str);
                        }
                    });
                } catch (Exception e) {
                    zo.hw(cVar, jSONObject, 4, 9, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void fw(Context context, com.byazt.shh.c cVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.pr(str, cVar.pr);
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
            hw(cVar, jSONObject, 13, 10, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static void zo(final Context context, final com.byazt.shh.c cVar, final String str) {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.zo.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectAj = com.byazt.eld.k.aj();
                String strOptString = jSONObjectAj.optString(an.aB);
                final JSONObject jSONObject = new JSONObject();
                String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                m.pr(jSONObject2, an.aI, an.aE);
                m.pr(jSONObject2, an.ax, str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.byazt.eld.k.x().pr(strPr, com.byazt.eld.k.lb().pr(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new qa() { // from class: com.byazt.uk.zo.7.1
                    @Override // com.byazt.zv.qa
                    public void pr(String str2) {
                        zo.hw(context, str, str2, cVar, jSONObject);
                    }

                    @Override // com.byazt.zv.qa
                    public void pr(Throwable th) {
                        com.byazt.ds.pr.pr(zo.pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
                        m.pr(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                        zo.hw(cVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    private static void aj(Context context, com.byazt.shh.c cVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.pr(str, cVar.pr, BaseConstants.VIVO_MARKET_NEED_COMMENT);
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
            hw(cVar, jSONObject, 9, 8, BaseConstants.MARKET_PREFIX + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Context context, String str, String str2, com.byazt.shh.c cVar, JSONObject jSONObject) {
        m.pr(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strPr = com.byazt.now.hn.pr(new JSONObject(str2).optString(an.av));
            if (TextUtils.isEmpty(strPr)) {
                com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
                hw(cVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
            } else {
                TTDelegateActivity.pr(str, cVar.pr, strPr, jSONObject);
            }
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
            hw(cVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void pr(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            jSONObject = new JSONObject();
        }
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        try {
            JSONObject jSONObjectAj = com.byazt.eld.k.aj();
            boolean zPr = com.byazt.now.pr.pr(jSONObjectAj, activity, com.byazt.now.hn.pr(jSONObjectAj.optString("bg"), jSONObjectAj.optString(an.aB)));
            HashMap<String, String> mapHw = m.hw(new JSONObject(str2));
            if (zPr && !mapHw.isEmpty() && pr(activity, str, mapHw)) {
                hw(cVarC, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.byazt.ds.pr.pr("am_v1", jSONObject, cVarC, true);
                return;
            }
            if (zPr) {
                i = mapHw.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            hw(cVarC, jSONObject, i, 5, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr(pr((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
        } catch (Exception e2) {
            com.byazt.ds.pr.pr(pr(com.byazt.eld.k.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
            hw(cVarC, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void pr(Activity activity, String str, long j, String str2) {
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectAj = com.byazt.eld.k.aj();
        String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("bv"), jSONObjectAj.optString(an.aB));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.SCHEME_MARKET).authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strPr)) {
            builder.appendQueryParameter(strPr, str2);
        }
        if (pr(activity, builder.build())) {
            hw(cVarC, jSONObject, -1, 8, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr("am_v2", jSONObject, cVarC, true);
        } else {
            hw(cVarC, jSONObject, 2, 8, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr(pr((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
        }
    }

    public static boolean pr(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strVk = com.byazt.now.c.vk();
        if (m.c(com.byazt.eld.k.getContext(), strVk)) {
            intent.setPackage(strVk);
        }
        if (m.pr(com.byazt.eld.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.byazt.vi.hn.pr().pr(e, "start v2");
                return false;
            }
        }
        return false;
    }

    public static boolean hw(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strVk = com.byazt.now.c.vk();
        if (m.c(com.byazt.eld.k.getContext(), strVk)) {
            intent.setPackage(strVk);
        }
        if (m.pr(com.byazt.eld.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.byazt.vi.hn.pr().pr(e, "start HM1");
                return false;
            }
        }
        return false;
    }

    public static boolean hn(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strVk = com.byazt.now.c.vk();
        if (m.c(com.byazt.eld.k.getContext(), strVk)) {
            intent.setPackage(strVk);
        }
        if (m.pr(com.byazt.eld.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.byazt.vi.hn.pr().pr(e, "start HM2");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(com.byazt.shh.c cVar, JSONObject jSONObject, int i, int i2, String str) {
        m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        m.pr(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        m.pr(jSONObject, "rmu", str);
        m.pr(jSONObject, com.byazt.now.c.vk(), Integer.valueOf(m.hw(com.byazt.eld.k.getContext(), com.byazt.now.c.vk())));
        com.byazt.mf.pr.pr().hw("am_result", jSONObject, cVar);
    }

    public static com.byazt.shh.fw hw(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.byazt.shh.fw(4, 11);
        }
        if (context == null) {
            context = com.byazt.eld.k.getContext();
        }
        Intent intentFw = m.fw(context, str);
        if (intentFw == null) {
            return new com.byazt.shh.fw(4, 22);
        }
        intentFw.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentFw);
            return new com.byazt.shh.fw(3);
        } catch (Exception e) {
            return new com.byazt.shh.fw(4, 23);
        }
    }

    public static com.byazt.shh.fw pr(Context context, String str, com.byazt.tia.pr prVar) {
        Intent intentPr = pr(context, prVar, str, 1, (String) null);
        if (intentPr != null) {
            k.pr().pr(pr, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.byazt.shh.fw fwVarPr = pr(intentPr, true, context, str, prVar);
            if (fwVarPr.getType() == 3) {
                return fwVarPr;
            }
        }
        Intent intentFw = m.fw(context, str);
        if (intentFw == null) {
            return new com.byazt.shh.fw(4, 22);
        }
        return pr(intentFw, false, context, str, prVar);
    }

    private static com.byazt.shh.fw pr(Intent intent, boolean z, Context context, String str, com.byazt.tia.pr prVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.byazt.eld.k.aj().optInt("open_package_mode") == 1 && com.byazt.eld.k.k() != null && com.byazt.eld.k.k().pr() && prVar.yb() && !z) {
            TTDelegateActivity.hw(str, prVar);
            return new com.byazt.shh.fw(3);
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intent);
            return new com.byazt.shh.fw(3);
        } catch (Exception e) {
            if (z) {
                k.pr().hw(pr, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.byazt.shh.fw(8, 23);
            }
            k.pr().hw(pr, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.byazt.shh.fw(4, 23);
        }
    }

    public static com.byazt.shh.fw pr(String str, com.byazt.tia.pr prVar) {
        return pr(com.byazt.eld.k.getContext(), str, prVar);
    }

    public static com.byazt.shh.fw hw(String str, com.byazt.tia.pr prVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.byazt.shh.fw(2, 21);
        }
        Context context = com.byazt.eld.k.getContext();
        String packageName = prVar.cz().getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            k.pr().pr(pr, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent intentPr = pr(context, prVar, packageName, 2, str);
            if (intentPr != null) {
                com.byazt.shh.fw fwVarPr = pr(context, intentPr, prVar, true, str);
                if (fwVarPr.getType() == 1) {
                    return fwVarPr;
                }
            }
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.byazt.ew.pr.hn().pr("fix_app_link_flag")) {
            intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        return pr(context, intent, prVar, false, str);
    }

    private static com.byazt.shh.fw pr(Context context, Intent intent, com.byazt.tia.pr prVar, boolean z, String str) {
        if (context == null) {
            context = com.byazt.eld.k.getContext();
        }
        if (m.hw(context, intent)) {
            if (com.byazt.eld.k.aj().optInt("open_url_mode") == 0 && com.byazt.eld.k.k() != null && com.byazt.eld.k.k().pr() && Build.VERSION.SDK_INT >= 26 && prVar.yb() && !z) {
                TTDelegateActivity.pr(str, prVar);
                return new com.byazt.shh.fw(1);
            }
            try {
                context.startActivity(intent);
                return new com.byazt.shh.fw(1);
            } catch (Exception e) {
                if (z) {
                    k.pr().hw(pr, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.byazt.shh.fw(9);
                }
                k.pr().hw(pr, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.byazt.shh.fw(2);
            }
        }
        return new com.byazt.shh.fw(2, 24);
    }

    public static com.byazt.shh.fw pr(com.byazt.tia.hw hwVar, String str, String str2) {
        com.byazt.shh.fw fwVarHw = hw(str, hwVar);
        if (com.byazt.ds.uc.pr(hwVar) && fwVarHw.getType() == 2) {
            return pr(str2, hwVar);
        }
        return fwVarHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Context context, com.byazt.shh.c cVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.hw(str, cVar.pr, str2);
        } catch (Exception e) {
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVar, true);
            hw(cVar, jSONObject, 12, 9, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void hw(Activity activity, String str, long j, String str2) {
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectAj = com.byazt.eld.k.aj();
        String strOptString = jSONObjectAj.optString(an.aB);
        String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("bz"), strOptString);
        String strPr2 = com.byazt.now.hn.pr(jSONObjectAj.optString("ca"), strOptString);
        String strPr3 = com.byazt.now.hn.pr(jSONObjectAj.optString("cb"), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.MARKET_SCHEME_HW_HONOR).authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strPr)) {
            builder.appendQueryParameter(strPr, str2);
        }
        if (!TextUtils.isEmpty(strPr2) && !TextUtils.isEmpty(strPr3)) {
            builder.appendQueryParameter(strPr2, strPr3);
        }
        if (hw(activity, builder.build())) {
            hw(cVarC, jSONObject, -1, 9, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr("am_hr", jSONObject, cVarC, true);
        } else {
            hw(cVarC, jSONObject, 2, 9, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr(pr((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
        }
    }

    public static void pr(Activity activity, String str, long j) {
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectAj = com.byazt.eld.k.aj();
        String strOptString = jSONObjectAj.optString(an.aB);
        String strPr = com.byazt.now.hn.pr(jSONObjectAj.optString("ca"), strOptString);
        String strPr2 = com.byazt.now.hn.pr(jSONObjectAj.optString("cc"), strOptString);
        StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
        if (!TextUtils.isEmpty(strPr) && !TextUtils.isEmpty(strPr2)) {
            sb.append(str).append("&").append(strPr).append("=").append(strPr2);
        }
        if (hn(activity, Uri.parse(sb.toString()))) {
            hw(cVarC, jSONObject, -1, 10, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr("am_hr2", jSONObject, cVarC, true);
        } else {
            hw(cVarC, jSONObject, 2, 10, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr(pr((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
        }
    }

    public static void pr(Context context, String str, long j) {
        com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(j);
        JSONObject jSONObject = new JSONObject();
        if (cVarC.x instanceof AdDownloadController) {
            boolean zEnableOppoAutoDownload = ((AdDownloadController) cVarC.x).enableOppoAutoDownload();
            HashMap map = new HashMap();
            map.put("is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            m.pr(jSONObject, "is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            DownloadMarketInterceptor downloadMarketInterceptor = ((AdDownloadController) cVarC.x).getDownloadMarketInterceptor();
            if (downloadMarketInterceptor != null) {
                Map<String, Object> mapInterceptObmMarket = downloadMarketInterceptor.interceptObmMarket(map);
                if (mapInterceptObmMarket != null && mapInterceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(mapInterceptObmMarket.get("convert_result").toString())) {
                    hw(cVarC, jSONObject, -1, 11, BaseConstants.MARKET_PREFIX + str);
                    com.byazt.ds.pr.pr("am_kllk4", jSONObject, cVarC, true);
                    return;
                } else {
                    hw(cVarC, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
                    com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
                    return;
                }
            }
            hw(cVarC, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
            com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
            return;
        }
        hw(cVarC, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
        com.byazt.ds.pr.pr(pr(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), cVarC, true);
    }

    public static boolean hn(Context context, String str) {
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
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hn(String str) {
        String strGroup;
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        if (!matcher.find()) {
            strGroup = "";
        } else {
            strGroup = matcher.group();
        }
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(Constants.VALUE_FIELD)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String x(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static Intent pr(Context context, com.byazt.tia.pr prVar, String str, int i, String str2) {
        if (prVar.hn() && prVar.fo() != null && prVar.fo().getDownloadMode() == 2 && prVar.cz() != null && c.pr(prVar).pr("app_link_market_open_add_info", 0) == 1) {
            String strHn = com.byazt.eld.aj.hn(prVar.cz());
            String strX = com.byazt.eld.aj.x(prVar.cz());
            Intent intent = new Intent();
            intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (!TextUtils.isEmpty(strHn) && resolveInfoResolveActivity != null) {
                intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, strHn);
                if (!(context instanceof Activity)) {
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                }
                if (!TextUtils.isEmpty(strX)) {
                    intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, strX);
                }
                if (i == 2 && !TextUtils.isEmpty(str2)) {
                    intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
                }
                return intent;
            }
            return null;
        }
        return null;
    }
}
