package com.byazt.ry;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.vkw.qi;
import com.byazt.xlm.zo;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, 37})
public class pr implements qi.pr {
    public static ThreadPoolExecutor aj = null;
    public static boolean zo;
    public int m;
    public final Context w;
    public volatile boolean hn = false;
    public boolean x = true;
    public boolean c = false;
    public long uc = 0;
    public long fw = 0;
    public AtomicBoolean vk = new AtomicBoolean(false);
    public volatile boolean k = false;
    public final Handler pr = ((qi) com.byazt.zs.uc.pr("thread_service")).x();
    public final boolean hw = ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr();

    public pr(Context context, int i) {
        this.w = context;
        this.m = i;
    }

    public void pr() {
        pr(false);
    }

    public synchronized void pr(boolean z) {
        if (this.hw) {
            x(z);
            return;
        }
        if (this.uc <= 0) {
            try {
                zo().execute(new Runnable() { // from class: com.byazt.ry.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw();
                    }
                });
            } catch (Throwable th) {
            }
        }
    }

    public static void hw(boolean z) {
        zo = z;
    }

    public Context getContext() {
        return this.w;
    }

    public static void pr(Context context, int i) {
        pr prVarPr;
        if (zo && (prVarPr = fw.pr().pr(i, context)) != null) {
            if (((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr()) {
                prVarPr.pr(true);
            } else {
                prVarPr.pr();
            }
        }
    }

    public synchronized void hw() {
        if (System.currentTimeMillis() - this.uc > 3600000) {
            this.uc = System.currentTimeMillis();
            try {
                if (fw.pr().pr(this.m).zo() != null) {
                    fw.pr().pr(this.m).zo().hw();
                }
            } catch (Exception e) {
            }
        }
    }

    private void x(boolean z) {
        if (this.c) {
            return;
        }
        if (this.x) {
            this.x = false;
            this.uc = 0L;
            this.fw = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.uc > j) {
            if (jCurrentTimeMillis - this.fw > 120000 || !this.k) {
                hn();
            }
        }
    }

    public boolean hn() {
        this.vk.get();
        zo().execute(new Runnable() { // from class: com.byazt.ry.pr.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zPr = com.byazt.am.x.pr(pr.this.w);
                if (zPr) {
                    pr.this.fw = System.currentTimeMillis();
                    if (!pr.this.vk.compareAndSet(false, true)) {
                        return;
                    }
                    pr.this.hn(zPr);
                }
            }
        });
        return true;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 101:
                this.c = false;
                this.uc = System.currentTimeMillis();
                if (this.x) {
                    pr();
                }
                this.vk.set(false);
                break;
            case 102:
                this.c = false;
                if (this.x) {
                    pr();
                }
                this.vk.set(false);
                break;
        }
    }

    public synchronized void x() {
        if (this.k) {
            return;
        }
        this.k = true;
        long j = com.byazt.mg.hw.hw(this.w, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.uc = j;
        try {
            if (fw.pr().pr(this.m).zo() != null) {
                fw.pr().pr(this.m).zo().pr();
            }
        } catch (Exception e) {
        }
    }

    public void c() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.hw) {
                x();
            } else {
                hw();
            }
        } catch (Throwable th) {
        }
    }

    public void hn(boolean z) {
        x();
        this.c = true;
        if (!z) {
            this.pr.sendEmptyMessage(102);
            return;
        }
        try {
            fw();
        } catch (Exception e) {
            this.vk.set(false);
        }
    }

    public String[] uc() {
        String[] strArrUc;
        if (fw.pr().pr(this.m).x() == null) {
            strArrUc = null;
        } else {
            strArrUc = fw.pr().pr(this.m).x().uc();
        }
        if (strArrUc == null || strArrUc.length <= 0) {
            return new String[0];
        }
        return strArrUc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.byazt.mg.hw.hw(this.w, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        x xVarZo = fw.pr().pr(this.m).zo();
        if (xVarZo != null) {
            xVarZo.pr(jSONObject2);
            return true;
        }
        return true;
    }

    public boolean fw() {
        String[] strArrUc = uc();
        if (strArrUc == null || strArrUc.length == 0) {
            return false;
        }
        pr(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final int i) {
        String[] strArrUc = uc();
        if (strArrUc == null || strArrUc.length <= i) {
            hw(102);
            return;
        }
        String str = strArrUc[i];
        if (TextUtils.isEmpty(str)) {
            hw(102);
            return;
        }
        try {
            String strPr = pr(str);
            if (TextUtils.isEmpty(strPr)) {
                hw(102);
                return;
            }
            aj ajVarHw = com.byazt.tf.hn.hw(strPr);
            pr(ajVarHw);
            ajVarHw.pr(new com.byazt.hcx.fw() { // from class: com.byazt.ry.pr.3
                @Override // com.byazt.hcx.fw
                public void pr(m mVar) {
                    JSONObject jSONObjectC;
                    if (mVar == null || !mVar.fw()) {
                        pr.this.pr(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObjectC = mVar.c();
                    } catch (Exception e) {
                        jSONObjectC = null;
                    }
                    if (jSONObjectC == null) {
                        pr.this.pr(i + 1);
                        return;
                    }
                    try {
                        string = jSONObjectC.getString("message");
                    } catch (Exception e2) {
                    }
                    if (!TrackAction.SUCCESS.equals(string)) {
                        pr.this.pr(i + 1);
                        return;
                    }
                    try {
                        if (pr.this.pr(jSONObjectC)) {
                            pr.this.hw(101);
                        } else {
                            pr.this.pr(i + 1);
                        }
                    } catch (Exception e3) {
                    }
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i2, String str2, Throwable th) {
                    pr.this.pr(i + 1);
                }
            });
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i) {
        Handler handler = this.pr;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    private String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://").append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void pr(aj ajVar) {
        String str;
        if (ajVar == null) {
            return;
        }
        Address addressPr = null;
        if (fw.pr().pr(this.m).x() != null) {
            addressPr = fw.pr().pr(this.m).x().pr(this.w);
        }
        if (addressPr != null && addressPr.hasLatitude() && addressPr.hasLongitude()) {
            ajVar.hw("latitude", new StringBuilder().append(addressPr.getLatitude()).toString());
            ajVar.hw("longitude", new StringBuilder().append(addressPr.getLongitude()).toString());
            String locality = addressPr.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                ajVar.hw("city", Uri.encode(locality));
            }
        }
        if (this.hn) {
            ajVar.hw("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            ajVar.hw("abi", str);
        } catch (Throwable th) {
        }
        if (fw.pr().pr(this.m).x() != null) {
            ajVar.hw("aid", new StringBuilder().append(fw.pr().pr(this.m).x().pr()).toString());
            ajVar.hw("device_platform", fw.pr().pr(this.m).x().hn());
            ajVar.hw("channel", fw.pr().pr(this.m).x().hw());
            ajVar.hw("version_code", new StringBuilder().append(fw.pr().pr(this.m).x().x()).toString());
            ajVar.hw("custom_info_1", fw.pr().pr(this.m).x().c());
        }
    }

    public static ThreadPoolExecutor zo() {
        if (aj == null) {
            synchronized (pr.class) {
                if (aj == null) {
                    com.byazt.fr.x xVar = new com.byazt.fr.x(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zo("tnc/AppConfig"));
                    aj = xVar;
                    xVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return aj;
    }

    public static void pr(ThreadPoolExecutor threadPoolExecutor) {
        aj = threadPoolExecutor;
    }
}
