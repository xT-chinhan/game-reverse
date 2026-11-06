package com.byazt.rwn;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 568, 5})
public class uc {
    public static volatile uc pr;
    public hn c;
    public hw uc;
    public Context x;
    public int fw = 30;
    public boolean zo = false;
    public final Map<String, List<WeakReference<fw>>> hw = new ConcurrentHashMap();
    public final Map<String, c> hn = new ConcurrentHashMap();

    private uc() {
    }

    public static uc pr() {
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    pr = new uc();
                }
            }
        }
        return pr;
    }

    public void pr(Context context) {
        if (context == null || this.x != null) {
            return;
        }
        this.x = context.getApplicationContext();
        zo.pr().pr(context);
        zo.pr().pr(this.fw);
        pr.pr().pr(context);
    }

    public void pr(hn hnVar) {
        this.c = hnVar;
    }

    public void pr(hw hwVar) {
        this.uc = hwVar;
    }

    public hw hw() {
        return this.uc;
    }

    public void pr(int i) {
        if (this.fw == i) {
            return;
        }
        this.fw = i;
        zo.pr().pr(i);
    }

    public void pr(boolean z) {
        this.zo = z;
    }

    public boolean hn() {
        return this.zo;
    }

    public void pr(final x xVar, final fw fwVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.pr())) {
            pr(fwVar, xVar, 1001, "Invalid zip config");
        } else if (this.zo) {
            pr(fwVar, xVar, 1001, "Zip download is disabled");
        } else {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("") { // from class: com.byazt.rwn.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.hw(xVar, fwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(x xVar, fw fwVar) {
        final String strPr = xVar.pr();
        if (pr(xVar)) {
            pr(fwVar, xVar);
            return;
        }
        synchronized (this) {
            List<WeakReference<fw>> list = this.hw.get(strPr);
            if (list != null && !list.isEmpty()) {
                list.add(new WeakReference<>(fwVar));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeakReference(fwVar));
            this.hw.put(strPr, arrayList);
            c cVar = new c(this.x);
            this.hn.put(strPr, cVar);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            cVar.pr(xVar, new fw() { // from class: com.byazt.rwn.uc.2
                @Override // com.byazt.rwn.fw
                public void pr(x xVar2) {
                    uc.this.pr(xVar2, true, System.currentTimeMillis() - jCurrentTimeMillis, 0, (String) null);
                    uc.this.pr(strPr, true, xVar2, 0, (String) null);
                    uc.this.pr(strPr);
                }

                @Override // com.byazt.rwn.fw
                public void pr(x xVar2, int i, String str) {
                    uc.this.pr(xVar2, false, System.currentTimeMillis() - jCurrentTimeMillis, i, str);
                    uc.this.pr(strPr, false, xVar2, i, str);
                    uc.this.pr(strPr);
                }
            });
        }
    }

    public static boolean pr(x xVar) {
        Context context;
        File fileHw;
        if (xVar == null || TextUtils.isEmpty(xVar.pr()) || (context = pr().x) == null || (fileHw = com.byazt.mg.hw.hw(context)) == null) {
            return false;
        }
        String strX = zo.x(xVar.pr());
        String strHn = xVar.hn();
        if (TextUtils.isEmpty(strHn)) {
            strHn = "img_0.png";
        }
        return new File(fileHw, "tt_lottie_imgcac" + File.separator + strX + File.separator + strHn).exists();
    }

    private void pr(final fw fwVar, final x xVar) {
        if (fwVar != null) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.rwn.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    fwVar.pr(xVar);
                }
            });
        }
    }

    private void pr(final fw fwVar, final x xVar, final int i, final String str) {
        if (fwVar != null) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.rwn.uc.4
                @Override // java.lang.Runnable
                public void run() {
                    fwVar.pr(xVar, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, boolean z, x xVar, int i, String str2) {
        List<WeakReference<fw>> listRemove;
        synchronized (this) {
            listRemove = this.hw.remove(str);
        }
        if (listRemove == null || listRemove.isEmpty()) {
            return;
        }
        Iterator<WeakReference<fw>> it = listRemove.iterator();
        while (it.hasNext()) {
            fw fwVar = it.next().get();
            if (fwVar != null) {
                if (z) {
                    pr(fwVar, xVar);
                } else {
                    pr(fwVar, xVar, i, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str) {
        this.hn.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(x xVar, boolean z, long j, int i, String str) {
        if (this.c == null || xVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackAction.SUCCESS, z);
            jSONObject.put("duration_ms", j);
            jSONObject.put(BreakpointSQLiteKey.URL, xVar.pr());
            if (!z) {
                jSONObject.put(Constants.ERROR_CODE_FIELD, i);
                jSONObject.put("error_desc", str);
            }
            this.c.pr("lot_download", jSONObject);
        } catch (Exception e) {
        }
    }
}
