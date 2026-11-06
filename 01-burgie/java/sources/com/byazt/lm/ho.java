package com.byazt.lm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.edb.IDownloadHttpService;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.gz;
import com.byazt.lj.DownloaderBuilder;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.wt.ls;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.cz;
import com.byazt.zv.lb;
import com.byazt.zv.qa;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 19})
public class ho {
    public static final com.byazt.mgh.pr aj;
    public static Map<Integer, com.byazt.lm.hn.pr> fw;
    public static com.byazt.lm.x hn;
    public static volatile String pr;
    public static Context uc;
    public static com.byazt.rkl.hw zo;
    public static final AtomicBoolean x = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static boolean hw = true;

    static {
        try {
            pr = com.byazt.ca.uc.pr(getContext(), Environment.DIRECTORY_DOWNLOADS, false, null).getPath();
        } catch (Throwable th) {
        }
        aj = new com.byazt.mgh.pr() { // from class: com.byazt.lm.ho.2
            @Override // com.byazt.mgh.pr
            public void pr(DownloadInfo downloadInfo, String str) {
                ho.hn(str);
            }
        };
    }

    public static void pr(com.byazt.rkl.hw hwVar) {
        zo = hwVar;
    }

    public static com.byazt.rkl.hw pr() {
        return zo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.lm.x fw() {
        if (hn == null) {
            hn = m.x();
        }
        return hn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(String str) {
        com.byazt.tia.hw hwVarPr;
        JSONObject jSONObjectFw;
        if (!TextUtils.isEmpty(str) && (hwVarPr = com.byazt.shh.uc.pr().pr(str)) != null && (jSONObjectFw = hwVarPr.fw()) != null && fw() != null) {
            fw().pr(jSONObjectFw, str);
        }
    }

    public static void pr(Context context) {
        if (context == null) {
            context = a.getContext();
        }
        if (context == null) {
            return;
        }
        String strHw = ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).hw();
        if (strHw != null && strHw.contains(":downloader") && iu.x >= 7000) {
            com.byazt.lj.hn.pr(new uc());
        }
        AtomicBoolean atomicBoolean = x;
        if (!atomicBoolean.get()) {
            synchronized (ho.class) {
                if (!atomicBoolean.get()) {
                    uc = context.getApplicationContext();
                    if (fw() != null) {
                        String strPr = fw().pr(hw);
                        if (!TextUtils.isEmpty(strPr)) {
                            pr = strPr;
                        }
                    }
                    atomicBoolean.set(hw(uc));
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = c;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((fw() != null ? fw().hw() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    public static void pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            pr = str;
        }
    }

    public static com.byazt.cvl.vk hw() {
        pr(getContext());
        return com.byazt.cvl.vk.pr(getContext());
    }

    public static boolean pr(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return hw().c().pr(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean pr(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return hw().c().pr(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean pr(Uri uri) {
        return com.byazt.ds.vk.pr(uri);
    }

    public static void hn() {
        hw().fw();
        if (fw() != null) {
            fw().hw(pr);
        }
    }

    public static void pr(int i) {
        Map<Integer, com.byazt.lm.hn.pr> map = fw;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void pr(int i, com.byazt.lm.hn.pr prVar) {
        if (prVar != null) {
            if (fw == null) {
                fw = Collections.synchronizedMap(new WeakHashMap());
            }
            fw.put(Integer.valueOf(i), prVar);
        }
    }

    public static Map<Integer, com.byazt.lm.hn.pr> x() {
        return fw;
    }

    public static boolean pr(String str, String str2, JSONObject jSONObject, Object obj) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) {
            return false;
        }
        Map<Integer, com.byazt.lm.hn.pr> mapX = x();
        if (mapX != null) {
            for (Map.Entry<Integer, com.byazt.lm.hn.pr> entry : mapX.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                com.byazt.lm.hn.pr value = entry.getValue();
                if (value != null) {
                    boolean zPr = value.pr(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zPr) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean zo() {
        if (UMModuleRegister.INNER.equals(iu.zo)) {
            return true;
        }
        return false;
    }

    private static boolean hw(final Context context) {
        com.byazt.vb.pr prVarPr;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (zo()) {
            try {
                prVarPr = com.byazt.cvl.vk.pr(applicationContext).pr(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable th) {
                prVarPr = com.byazt.cvl.vk.pr(applicationContext).pr();
            }
        } else {
            prVarPr = com.byazt.cvl.vk.pr(applicationContext).pr();
        }
        if (prVarPr == null) {
            return false;
        }
        prVarPr.pr(new x()).pr(new hw()).pr(new c(applicationContext)).pr(new hn()).pr(new com.byazt.zkm.fw() { // from class: com.byazt.lm.ho.9
            @Override // com.byazt.zkm.fw
            public Uri pr(int i, String str, String str2) {
                return nt.pr(context).pr(str, str2);
            }
        }).pr(new com.byazt.zkm.hn() { // from class: com.byazt.lm.ho.8
            @Override // com.byazt.zkm.hn
            public Map<String, Object> pr(Object obj) {
                return nt.pr(context).pr(obj);
            }
        }).pr(new com.byazt.zv.w() { // from class: com.byazt.lm.ho.7
            @Override // com.byazt.zv.w
            public JSONObject pr() {
                return ho.aj();
            }
        }).pr(new pr()).pr(new com.byazt.zv.hw() { // from class: com.byazt.lm.ho.6
            @Override // com.byazt.zv.hw
            public boolean pr() {
                if (ho.fw() != null) {
                    return ho.fw().hn();
                }
                return false;
            }
        }).pr(new com.byazt.cxa.pr.C0037pr().hw("143").pr("open_news").hn(iu.c).x(String.valueOf(iu.x)).pr()).pr(new lb() { // from class: com.byazt.lm.ho.5
            @Override // com.byazt.zv.lb
            public byte[] pr(byte[] bArr, int i) {
                return new byte[0];
            }
        }).pr(packageName + ".TTFileProvider").pr(new com.byazt.zv.a() { // from class: com.byazt.lm.ho.4
            @Override // com.byazt.zv.a
            public void pr(Context context2, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i) {
                ho.hw(downloadModel);
            }
        }).pr(new com.byazt.zv.hn() { // from class: com.byazt.lm.ho.1
            @Override // com.byazt.zv.hn
            public void pr(Context context2, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                ho.hw(downloadModel);
            }
        }).pr(pr(applicationContext, aj())).pr();
        com.byazt.uk.pr.pr();
        if (!iu.zo.equals(UMModuleRegister.INNER)) {
            com.byazt.cvl.vk.pr(applicationContext).x().pr(1);
            com.byazt.cvl.vk.pr(applicationContext).pr(aj);
            com.byazt.mdu.x.w().pr(new gz() { // from class: com.byazt.lm.ho.10
                @Override // com.byazt.fn.gz
                public boolean pr(Intent intent) {
                    return false;
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(DownloadModel downloadModel) {
        JSONObject extra;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null || (extra = downloadModel.getExtra()) == null || (jSONObjectOptJSONObject = extra.optJSONObject("open_ad_sdk_download_extra")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("material_meta");
        String strOptString2 = jSONObjectOptJSONObject.optString("tag");
        if (!TextUtils.isEmpty(strOptString) && strOptString.contains("self_reward_callback") && com.byazt.uk.m.pr(downloadModel)) {
            com.byazt.zq.c cVarHn = com.byazt.sd.hw.hn();
            cVarHn.pr("save_jump_success_time", System.currentTimeMillis());
            cVarHn.pr("save_jump_success_ad_tag", strOptString2);
            cVarHn.pr("save_download_open_app_success_meta", strOptString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aj() {
        try {
            com.byazt.lm.x xVarFw = fw();
            if (xVarFw != null) {
                JSONObject jSONObjectPr = xVarFw.pr();
                if (jSONObjectPr.optInt("enable_app_install_receiver", 1) == 0) {
                    jSONObjectPr.put("enable_app_install_receiver", 0);
                }
                return jSONObjectPr;
            }
        } catch (Exception e) {
        }
        return new JSONObject();
    }

    private static DownloaderBuilder pr(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new com.byazt.fn.iu() { // from class: com.byazt.lm.ho.11
            @Override // com.byazt.fn.iu
            public JSONObject pr() {
                return ho.aj();
            }
        }).httpService(new uc());
    }

    public static boolean pr(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List<DownloadInfo> listHw = com.byazt.mdu.x.w().hw(context);
        if (!listHw.isEmpty()) {
            for (DownloadInfo downloadInfo : listHw) {
                if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Context getContext() {
        Context context = uc;
        return context == null ? a.getContext() : context;
    }

    public static Bundle pr(com.byazt.vo.pr prVar, int i) {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        try {
            if (i == 101) {
                boolean zHw = ls.hw(prVar.hn());
                String str3 = zHw ? "open" : "install";
                boolean zPr = true;
                if (zHw) {
                    com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(prVar.hn());
                    String str4 = fwVarPr.getType() + "_" + fwVarPr.pr() + "_" + fwVarPr.hw();
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "open ".concat(String.valueOf(str4)));
                    str2 = str4;
                } else {
                    boolean zPr2 = com.byazt.mdu.x.pr(uc, prVar.x());
                    if (!zPr2) {
                        str = "cache install";
                        zPr = com.byazt.mdu.x.pr(uc, pr(prVar.vk(), prVar.aj()));
                    } else {
                        str = "mem install";
                        zPr = zPr2;
                    }
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "install ".concat(String.valueOf(zPr)));
                    str2 = str;
                }
                com.byazt.jx.c.pr(prVar.fw(), prVar, str3, "media_install", str2, zPr ? TrackAction.SUCCESS : "failure");
            } else {
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "event_type:" + i + " not support");
                com.byazt.jx.c.pr(prVar.fw(), prVar, "notSupport_".concat(String.valueOf(i)), "media_install", "error", "failure");
            }
        } catch (Exception e) {
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
        }
        return bundle;
    }

    private static int pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strC = com.byazt.tuy.uc.c(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strC)) {
            return 0;
        }
        return strC.hashCode();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1959})
    private static class x implements com.byazt.zv.aj {
        @Override // com.byazt.zv.aj
        public void pr(Activity activity, String[] strArr, final cz czVar) {
            if (ho.fw() != null) {
                ho.fw().pr(activity, strArr, new com.byazt.lm.uc() { // from class: com.byazt.lm.ho.x.1
                    @Override // com.byazt.lm.uc
                    public void pr() {
                        cz czVar2 = czVar;
                        if (czVar2 != null) {
                            czVar2.pr();
                        }
                    }

                    @Override // com.byazt.lm.uc
                    public void pr(String str) {
                        cz czVar2 = czVar;
                        if (czVar2 != null) {
                            czVar2.pr(str);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.zv.aj
        public boolean pr(Context context, String str) {
            if (ho.fw() != null) {
                return ho.fw().pr(context, str);
            }
            return false;
        }

        @Override // com.byazt.zv.aj
        public void pr(Activity activity, int i, String[] strArr, int[] iArr) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1255})
    private static class pr implements com.byazt.zv.vk {
        private pr() {
        }

        @Override // com.byazt.zv.vk
        public boolean pr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.byazt.lm.x xVarFw = ho.fw();
            if (xVarFw != null) {
                return xVarFw.pr(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.byazt.zv.vk
        public boolean hw(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.byazt.lm.x xVarFw = ho.fw();
            if (xVarFw != null) {
                return xVarFw.hw(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.byazt.zv.vk
        public boolean pr(DownloadModel downloadModel) {
            com.byazt.lm.x xVarFw = ho.fw();
            if (xVarFw != null) {
                return xVarFw.pr(downloadModel);
            }
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1273})
    private static class hn implements com.byazt.zv.zo {
        private hn() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: switch over string: strings are not added: [[GET]] */
        @Override // com.byazt.zv.zo
        public void pr(String str, String str2, Map<String, Object> map, final qa qaVar) {
            int i = 1;
            switch (str) {
                case "POST":
                    i = 2;
                    break;
            }
            if (ho.fw() != null) {
                ho.fw().pr(i, str2, map, new com.byazt.lm.c() { // from class: com.byazt.lm.ho.hn.1
                    @Override // com.byazt.lm.c
                    public void pr(String str3) {
                        qa qaVar2 = qaVar;
                        if (qaVar2 != null) {
                            qaVar2.pr(str3);
                        }
                    }

                    @Override // com.byazt.lm.c
                    public void pr(Throwable th) {
                        qa qaVar2 = qaVar;
                        if (qaVar2 != null) {
                            qaVar2.pr(th);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.zv.zo
        public void pr(String str, byte[] bArr, String str2, int i, final qa qaVar) {
            if (ho.fw() != null) {
                ho.fw().pr(str, bArr, str2, new com.byazt.lm.c() { // from class: com.byazt.lm.ho.hn.2
                    @Override // com.byazt.lm.c
                    public void pr(String str3) {
                        qa qaVar2 = qaVar;
                        if (qaVar2 != null) {
                            qaVar2.pr(str3);
                        }
                    }

                    @Override // com.byazt.lm.c
                    public void pr(Throwable th) {
                        qa qaVar2 = qaVar;
                        if (qaVar2 != null) {
                            qaVar2.pr(th);
                        }
                    }
                });
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1198})
    public static class uc implements IDownloadHttpService {
        @Override // com.byazt.edb.IDownloadHttpService
        public com.byazt.edb.aj downloadWithConnection(int i, String str, List<com.byazt.auw.hn> list) throws IOException {
            final g.pr prVarPr = g.pr(str, list);
            if (prVarPr != null) {
                return new com.byazt.edb.aj() { // from class: com.byazt.lm.ho.uc.1
                    @Override // com.byazt.edb.aj
                    public InputStream pr() {
                        return prVarPr.pr;
                    }

                    @Override // com.byazt.edb.fw
                    public String pr(String str2) {
                        if (prVarPr.hw != null) {
                            return prVarPr.hw.get(str2);
                        }
                        return null;
                    }

                    @Override // com.byazt.edb.fw
                    public int hw() {
                        return prVarPr.hn;
                    }

                    @Override // com.byazt.edb.fw
                    public void hn() {
                    }

                    @Override // com.byazt.edb.aj
                    public void x() {
                        try {
                            prVarPr.x.disconnect();
                        } catch (Exception e) {
                        }
                    }
                };
            }
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1960})
    public static class c implements com.byazt.zv.m {
        public final WeakReference<Context> pr;

        public c(Context context) {
            this.pr = new WeakReference<>(context);
        }

        @Override // com.byazt.zv.m
        public void pr(int i, final Context context, DownloadModel downloadModel, final String str, Drawable drawable, int i2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.byazt.zp.zo.pr((Runnable) new com.byazt.xlm.fw("tt_download_toast") { // from class: com.byazt.lm.ho.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, str, 0).show();
                        }
                    });
                } catch (Exception e) {
                    com.byazt.ca.ho.hw("LibUIFactory", "showToastWithDuration e " + e.getMessage());
                }
            }
        }

        @Override // com.byazt.zv.m
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public AlertDialog hw(com.byazt.cxa.hw hwVar) {
            if (hwVar != null && ho.fw() != null) {
                if (hwVar.pr != null && (hwVar.pr instanceof Activity)) {
                    return ho.fw().pr((Activity) hwVar.pr, hwVar.vk == 1, hn(hwVar));
                }
                ho.fw().pr(this.pr, hwVar.vk == 1, hn(hwVar));
            }
            return null;
        }

        private com.byazt.lm.pr hn(final com.byazt.cxa.hw hwVar) {
            return com.byazt.lm.pr.pr().pr(hwVar.hw).hw(hwVar.hn).x(hwVar.c).hn(hwVar.x).pr(hwVar.fw).pr(new com.byazt.lm.hw() { // from class: com.byazt.lm.ho.c.2
                @Override // com.byazt.lm.hw
                public void pr(DialogInterface dialogInterface) {
                    if (hwVar.zo != null) {
                        hwVar.zo.pr(dialogInterface);
                    }
                }

                @Override // com.byazt.lm.hw
                public void hw(DialogInterface dialogInterface) {
                    if (hwVar.zo != null) {
                        try {
                            hwVar.zo.hw(dialogInterface);
                        } catch (Exception e) {
                        }
                    }
                }

                @Override // com.byazt.lm.hw
                public void hn(DialogInterface dialogInterface) {
                    if (hwVar.zo != null) {
                        hwVar.zo.hn(dialogInterface);
                    }
                }
            });
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1278})
    public static class hw implements com.byazt.zv.fw {
        @Override // com.byazt.zv.fw
        public void pr(com.byazt.cxa.hn hnVar) {
            pr(hnVar, true);
        }

        @Override // com.byazt.zv.fw
        public void hw(com.byazt.cxa.hn hnVar) {
            pr(hnVar, false);
            hn(hnVar);
        }

        private void hn(com.byazt.cxa.hn hnVar) {
            if (hnVar == null) {
                return;
            }
            Object objK = hnVar.k();
            JSONObject jSONObject = null;
            if (objK instanceof JSONObject) {
                jSONObject = (JSONObject) objK;
            }
            zo zoVarHw = zo.pr().pr(hnVar.hw()).hw(hnVar.zo()).pr(jSONObject).hw(hnVar.hn());
            boolean z = "download_notification".equals(hnVar.hw()) || "landing_h5_download_ad_button".equals(hnVar.hw());
            if (ho.fw() != null) {
                ho.fw().pr(zoVarHw, z);
            }
        }

        private void pr(com.byazt.cxa.hn hnVar, boolean z) {
            fw fwVarHw;
            if (ho.fw() == null || (fwVarHw = ho.fw().hw()) == null || hnVar == null) {
                return;
            }
            if (fwVarHw.pr() && ho.fw().pr(hnVar.toString())) {
                return;
            }
            if (z) {
                ho.hw(hnVar);
            } else {
                ho.hw(hnVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject hw(com.byazt.cxa.hn hnVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", hnVar.pr());
            jSONObject.put("tag", hnVar.hw());
            jSONObject.put("label", hnVar.hn());
            jSONObject.put("isAd", hnVar.x());
            jSONObject.put("adId", hnVar.c());
            jSONObject.put("logExtra", hnVar.uc());
            jSONObject.put("extValue", hnVar.fw());
            jSONObject.put("extJson", hnVar.zo());
            jSONObject.put("paramsJson", hnVar.aj());
            jSONObject.put("eventSource", hnVar.w());
            jSONObject.put("extraObject", hnVar.k());
            jSONObject.put("clickTrackUrl", hnVar.vk());
            jSONObject.put("isV3", hnVar.m());
            jSONObject.put("V3EventName", hnVar.g());
            jSONObject.put("V3EventParams", hnVar.ho());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static boolean pr(Activity activity, final com.byazt.rkl.pr prVar) {
        return com.byazt.wc.pr.pr().pr(activity, false, new com.byazt.wc.pr.InterfaceC0221pr() { // from class: com.byazt.lm.ho.3
            @Override // com.byazt.wc.pr.InterfaceC0221pr
            public void pr() {
                com.byazt.rkl.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr();
                }
            }
        });
    }
}
