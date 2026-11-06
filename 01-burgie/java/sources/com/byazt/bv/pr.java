package com.byazt.bv;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.ca.fw;
import com.byazt.ca.uc;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.py.c;
import com.byazt.sd.a;
import com.byazt.wt.ny;
import com.byazt.zp.x;
import com.mar.sdk.IAction;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 431, 37})
public class pr {
    public static volatile pr pr;
    public final hw hn;
    public final Context hw;
    public long x;

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr(a.getContext());
                }
            }
        }
        return pr;
    }

    private pr(Context context) {
        this.hw = context == null ? a.getContext() : context.getApplicationContext();
        this.hn = new hw();
    }

    public void hw() {
        File fileX;
        File[] fileArrListFiles;
        c.pr(7).pr();
        c.pr(8).pr();
        if (("mounted".equals(x.pr()) || !Environment.isExternalStorageRemovable()) && uc.x(this.hw, false, null) != null) {
            fileX = uc.x(this.hw, false, null);
        } else {
            fileX = uc.hw(this.hw, false, null);
        }
        if (fileX != null && fileX.exists() && fileX.isDirectory() && (fileArrListFiles = fileX.listFiles(new FileFilter() { // from class: com.byazt.bv.pr.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                try {
                    fw.hn(file);
                } catch (Throwable th) {
                }
            }
        }
    }

    public String pr(boolean z, String str) {
        long jHn = a.hw().hn(str);
        if (jHn > 0 && System.currentTimeMillis() - this.x < jHn) {
            return "1";
        }
        int i = z ? 7 : 8;
        of ofVarHw = hw(z, str);
        if (ofVarHw == null) {
            return "0";
        }
        if (ofVarHw.iy() + ofVarHw.l() < System.currentTimeMillis()) {
            c.pr(i).pr(str);
            return "1";
        }
        JSONObject jSONObjectPr = pr(ofVarHw);
        if (jSONObjectPr != null) {
            this.x = System.currentTimeMillis();
            return jSONObjectPr.toString();
        }
        return "0";
    }

    private JSONObject pr(of ofVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", ofVar.gu());
            jSONObject.put("aid", Long.valueOf(ofVar.fo()));
            jSONObject.put("cid", Long.valueOf(ofVar.x()));
            jSONObject.put(IAction.PurchaseKey.Price, ofVar.aa());
            jSONObject.put("material_key", ofVar.jw());
            jSONObject.put("s_send_ts", ofVar.iy());
            jSONObject.put("cache_time", ofVar.l());
            jSONObject.put("ext", ofVar.lv());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public void pr(com.byazt.qe.hw hwVar, String str) {
        this.hn.pr(str, hwVar);
    }

    public com.byazt.qe.hw pr(of ofVar, String str) {
        return this.hn.pr(ofVar == null ? null : ofVar.yn(), str);
    }

    public void hw(com.byazt.qe.hw hwVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            pr(hwVar, str);
        }
    }

    public synchronized of hw(boolean z, String str) {
        try {
            of ofVarPr = z ? com.byazt.vh.fw.pr().pr(str, 0) : com.byazt.vh.hw.pr().pr(str, 0);
            if (ofVarPr == null) {
                return null;
            }
            if (ny.hn(ofVarPr)) {
                if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                    return ofVarPr;
                }
                return null;
            }
            if (com.byazt.lpk.pr.pr(ofVarPr)) {
                return ofVarPr;
            }
            if (qv.ho(ofVarPr) == null) {
                return null;
            }
            return ofVarPr;
        } catch (Throwable th) {
            throw th;
        }
    }
}
