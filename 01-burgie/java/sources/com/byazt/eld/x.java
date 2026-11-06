package com.byazt.eld;

import android.os.Handler;
import com.byazt.auw.DownloadInfo;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 121})
public class x {
    public com.byazt.shh.c hw;
    public Handler pr;
    public AtomicBoolean hn = new AtomicBoolean(false);
    public AtomicBoolean x = new AtomicBoolean(false);

    public x(Handler handler) {
        this.pr = handler;
    }

    public void pr(com.byazt.shh.c cVar) {
        this.hw = cVar;
    }

    public boolean pr() {
        return this.x.get();
    }

    public void pr(boolean z) {
        this.x.set(z);
    }

    public void pr(final int i, final long j, long j2, final c.pr prVar) {
        com.byazt.tia.hw hwVar;
        this.x.set(false);
        if (prVar == null) {
            return;
        }
        if (!com.byazt.uk.c.uc(i) || !com.byazt.uk.c.c(i)) {
            prVar.pr();
            return;
        }
        long jHn = com.byazt.uk.c.hn(i);
        this.hn.set(false);
        final String downloadUrl = this.hw.hw.getDownloadUrl();
        com.byazt.tia.hw hwVarHw = com.byazt.shh.uc.pr().hw(downloadUrl);
        if (hwVarHw != null) {
            hwVar = hwVarHw;
        } else {
            com.byazt.tia.hw hwVar2 = new com.byazt.tia.hw(this.hw.hw, this.hw.hn, this.hw.x, 0);
            com.byazt.shh.uc.pr().pr(hwVar2);
            hwVar = hwVar2;
        }
        hwVar.c(false);
        if (k.m() != null) {
            k.m();
            hwVar.hw();
        }
        com.byazt.ute.x.pr().pr(hwVar.pr());
        boolean zX = com.byazt.uk.c.x(i);
        if (j2 > 0) {
            pr(i, downloadUrl, j2, hwVar, j, prVar);
        } else if (zX) {
            final com.byazt.tia.hw hwVar3 = hwVar;
            pr(downloadUrl, hwVar, new c.hw() { // from class: com.byazt.eld.x.1
                @Override // com.byazt.eld.c.hw
                public void pr(long j3) throws Throwable {
                    x.this.pr(i, downloadUrl, j3, hwVar3, j, prVar);
                }
            });
        } else {
            jHn = 0;
        }
        this.pr.postDelayed(new Runnable() { // from class: com.byazt.eld.x.2
            @Override // java.lang.Runnable
            public void run() {
                if (!x.this.hn.get()) {
                    x.this.hn.set(true);
                    prVar.pr();
                }
            }
        }, jHn);
    }

    private void pr(String str, com.byazt.tia.hw hwVar, final c.hw hwVar2) {
        if (hwVar2 == null) {
            return;
        }
        com.byazt.udn.hw.pr(str, new com.byazt.edb.vk() { // from class: com.byazt.eld.x.3
            @Override // com.byazt.edb.vk
            public void pr(Map<String, String> map) {
                if (!x.this.hn.get()) {
                    x.this.hn.set(true);
                    long jPr = x.this.pr(map);
                    if (jPr > 0) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt(Constants.APK_SIZE_FIELD, Long.valueOf(jPr));
                            jSONObject.putOpt("available_space", Long.valueOf(x.x()));
                        } catch (JSONException e) {
                        }
                    }
                    hwVar2.pr(jPr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long pr(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return 0L;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("content-length".equalsIgnoreCase(key)) {
                    return Long.parseLong(value);
                }
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str, long j, final com.byazt.tia.hw hwVar, long j2, final c.pr prVar) throws Throwable {
        this.hn.set(true);
        boolean zPr = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Constants.APK_SIZE_FIELD, Long.valueOf(j));
            } catch (JSONException e) {
            }
            long jLongValue = (Double.valueOf((com.byazt.uk.c.pr(i) + 1.0d) * j).longValue() + com.byazt.uk.c.hw(i)) - j2;
            long jX = x();
            if (jX < jLongValue) {
                pr(hwVar, jSONObject, jLongValue, jX);
                pr(hwVar);
                long jX2 = x();
                if (jX2 < jLongValue) {
                    hwVar.x(true);
                    final String strPr = hwVar.pr();
                    com.byazt.ute.x.pr().pr(strPr, new com.byazt.ute.c() { // from class: com.byazt.eld.x.4
                    });
                    zPr = pr(i, hwVar, str, jLongValue);
                    if (zPr) {
                        hwVar.c(true);
                    }
                } else {
                    hw(hwVar, jSONObject, jX, jX2);
                }
            }
        }
        if (!zPr) {
            this.pr.post(new Runnable() { // from class: com.byazt.eld.x.5
                @Override // java.lang.Runnable
                public void run() {
                    prVar.pr();
                }
            });
        }
    }

    private boolean pr(int i, com.byazt.tia.hw hwVar, String str, long j) {
        if (!com.byazt.uk.c.uc(i)) {
            return false;
        }
        if (k.m() != null) {
            return k.m().pr(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("cleanspace_window_show", jSONObject, hwVar);
        return false;
    }

    public static boolean pr(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean zPr = false;
        if (!com.byazt.uk.c.uc(id)) {
            return false;
        }
        if (k.m() != null && (zPr = k.m().pr(id, downloadInfo.getUrl(), false, j))) {
            com.byazt.ute.x.pr().pr(downloadInfo.getUrl(), new com.byazt.ute.c() { // from class: com.byazt.eld.x.6
            });
        }
        return zPr;
    }

    public static JSONObject pr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static void pr(int i) {
        if (com.byazt.uk.c.uc(i) && k.m() != null && k.m().hw()) {
            k.m();
        }
    }

    public static long hw() {
        if (k.m() != null) {
            return k.m().pr();
        }
        return 0L;
    }

    private static void pr(com.byazt.tia.hw hwVar) throws Throwable {
        long jX = x();
        if (k.m() != null) {
            k.m();
        }
        com.byazt.ute.hn.pr();
        com.byazt.ute.hn.hw();
        if (com.byazt.uk.c.fw(hwVar.qa())) {
            com.byazt.ute.hn.pr(k.getContext());
        }
        long jX2 = x();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jX2 - jX));
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("clean_quite_finish", jSONObject, hwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long x() {
        return com.byazt.uk.m.hw(0L);
    }

    private void pr(com.byazt.tia.hw hwVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("clean_space_no_enough_for_download", jSONObject, hwVar);
    }

    private void hw(com.byazt.tia.hw hwVar, JSONObject jSONObject, long j, long j2) {
        hwVar.k("1");
        com.byazt.shh.aj.pr().pr(hwVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("cleanspace_download_after_quite_clean", jSONObject, hwVar);
    }
}
