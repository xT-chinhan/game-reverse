package com.byazt.h;

import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.os.DeepLink;
import com.byazt.ug.d;
import com.byazt.y.AdDownloadController;
import com.byazt.y.AdDownloadEventConfig;
import com.byazt.y.AdDownloadModel;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 878, 26})
public class qg implements n {
    public String a;
    public String ae;
    public boolean an;
    public boolean b;
    public long bb;
    public String cd;
    public boolean ci;
    public String cp;
    public boolean cx;
    public int cy;
    public String d;
    public boolean df;
    public String dg;
    public boolean dh;
    public boolean dn;
    public boolean e;
    public String el;
    public boolean f;
    public boolean fi;
    public String fs;
    public int h;
    public int hd;
    public boolean he;
    public boolean hf;
    public boolean hu;
    public transient boolean ic;
    public String j;
    public int k;
    public boolean kc;
    public final AtomicBoolean l;
    public int lh;
    public long ln;
    public long lq;
    public int m;
    public boolean n;
    public long nf;
    public String oa;
    public String oj;
    public long ou;
    public String pe;
    public boolean pk;
    public boolean py;
    public final AtomicBoolean q;
    public boolean qg;
    public long rf;
    public long ri;
    public int rv;
    public final AtomicBoolean s;
    public int sh;
    public int sz;
    public int t;
    public String tj;
    public boolean u;
    public String um;
    public long ur;
    public int v;
    public long vb;
    public long w;
    public JSONObject wm;
    public int wo;
    public long x;
    public long y;
    public boolean yw;
    public boolean z;

    @Override // com.byazt.h.n
    public int a() {
        return -1;
    }

    @Override // com.byazt.h.n
    public JSONObject cd() {
        return null;
    }

    @Override // com.byazt.h.n
    public JSONObject cp() {
        return null;
    }

    @Override // com.byazt.h.n
    public JSONObject cy() {
        return null;
    }

    @Override // com.byazt.h.n
    public Object k() {
        return null;
    }

    @Override // com.byazt.h.n
    public List<String> sz() {
        return null;
    }

    private qg() {
        this.rv = 1;
        this.py = true;
        this.hu = false;
        this.h = 0;
        this.t = 0;
        this.an = false;
        this.f = false;
        this.fi = true;
        this.df = true;
        this.n = true;
        this.qg = true;
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.sh = 1;
        this.dh = true;
        this.lq = -1L;
    }

    public qg(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public qg(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.rv = 1;
        this.py = true;
        this.hu = false;
        this.h = 0;
        this.t = 0;
        this.an = false;
        this.f = false;
        this.fi = true;
        this.df = true;
        this.n = true;
        this.qg = true;
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.sh = 1;
        this.dh = true;
        this.lq = -1L;
        this.w = downloadModel.getId();
        this.x = downloadModel.getExtraValue();
        this.fs = downloadModel.getLogExtra();
        this.tj = downloadModel.getPackageName();
        this.wm = downloadModel.getExtra();
        this.py = downloadModel.isAd();
        this.hd = downloadModel.getVersionCode();
        this.cd = downloadModel.getVersionName();
        this.cp = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.d = downloadModel.getDeepLink().getOpenUrl();
            this.oa = downloadModel.getDeepLink().getWebUrl();
        }
        this.sz = downloadModel.getModelType();
        this.um = downloadModel.getName();
        this.a = downloadModel.getAppIcon();
        this.ae = downloadModel.getMimeType();
        this.oj = downloadEventConfig.getClickButtonTag();
        this.dg = downloadEventConfig.getRefer();
        this.u = downloadEventConfig.isEnableV3Event();
        this.hu = downloadController.isEnableBackDialog();
        this.k = downloadController.getLinkMode();
        this.cy = downloadController.getDownloadMode();
        this.dh = downloadController.enableShowComplianceDialog();
        this.b = downloadController.isAutoDownloadOnCardShow();
        this.fi = downloadController.enableNewActivity();
        this.n = downloadController.enableAH();
        this.qg = downloadController.enableAM();
        this.m = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ou = jCurrentTimeMillis;
        this.ur = jCurrentTimeMillis;
        this.f = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.el = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }

    public int m() {
        return this.h;
    }

    public void n(int i) {
        this.h = i;
    }

    public synchronized void hu() {
        this.h++;
    }

    public int h() {
        return this.t;
    }

    public void qg(int i) {
        this.t = i;
    }

    public synchronized void t() {
        this.t++;
    }

    public long ur() {
        long j = this.ur;
        return j == 0 ? this.ou : j;
    }

    public void n(long j) {
        this.ur = j;
    }

    public long bb() {
        return this.bb;
    }

    public void qg(long j) {
        this.bb = j;
    }

    public void s(long j) {
        this.ln = j;
    }

    public int ln() {
        return this.lh;
    }

    public void s(int i) {
        this.lh = i;
    }

    public int lh() {
        return this.v;
    }

    public void q(int i) {
        this.v = i;
    }

    public String v() {
        return this.j;
    }

    public void n(String str) {
        this.j = str;
    }

    @Override // com.byazt.h.n
    public long qg() {
        return this.w;
    }

    public void q(long j) {
        this.w = j;
    }

    @Override // com.byazt.h.n
    public long d() {
        return this.x;
    }

    public void l(long j) {
        this.x = j;
    }

    public int j() {
        return this.rv;
    }

    public void l(int i) {
        this.rv = i;
    }

    @Override // com.byazt.h.n
    public String l() {
        return this.tj;
    }

    public void qg(String str) {
        this.tj = str;
    }

    public long an() {
        return this.ou;
    }

    public void w(long j) {
        if (j > 0) {
            this.ou = j;
        }
    }

    @Override // com.byazt.h.n
    public String q() {
        return this.fs;
    }

    public void s(String str) {
        this.fs = str;
    }

    @Override // com.byazt.h.n
    public boolean s() {
        return this.py;
    }

    public void n(boolean z) {
        this.py = z;
    }

    @Override // com.byazt.h.n
    public JSONObject x() {
        return this.wm;
    }

    public void n(JSONObject jSONObject) {
        this.wm = jSONObject;
    }

    public void w(int i) {
        this.hd = i;
    }

    public void q(String str) {
        this.cd = str;
    }

    public int ae() {
        return this.hd;
    }

    public String f() {
        return this.cd;
    }

    public void x(int i) {
        this.m = i;
    }

    @Override // com.byazt.h.n
    public int um() {
        return this.m;
    }

    public void qg(boolean z) {
        this.u = z;
    }

    @Override // com.byazt.h.n
    public boolean oa() {
        return this.u;
    }

    public void fs(int i) {
        this.wo = i;
    }

    public int fi() {
        return this.wo;
    }

    public void rv(int i) {
        this.sh = i;
    }

    public void l(String str) {
        this.oa = str;
    }

    @Override // com.byazt.h.n
    public int fs() {
        return this.sh;
    }

    public void s(boolean z) {
        this.hu = z;
    }

    public boolean df() {
        return this.hu;
    }

    public void w(String str) {
        this.oj = str;
    }

    @Override // com.byazt.h.n
    public String tj() {
        return this.oj;
    }

    public void x(String str) {
        this.dg = str;
    }

    @Override // com.byazt.h.n
    public String rv() {
        return this.dg;
    }

    public void fs(String str) {
        this.cp = str;
    }

    @Override // com.byazt.h.n
    public String n() {
        return this.cp;
    }

    public void rv(String str) {
        this.d = str;
    }

    @Override // com.byazt.h.n
    public String w() {
        return this.d;
    }

    public void x(long j) {
        this.lq = j;
    }

    public long oj() {
        return this.lq;
    }

    public void tj(String str) {
        this.um = str;
    }

    public String dg() {
        return this.um;
    }

    public void cp(String str) {
        this.a = str;
    }

    public void tj(int i) {
        this.k = i;
    }

    public int u() {
        return this.k;
    }

    public void cp(int i) {
        this.cy = i;
    }

    public void d(int i) {
        this.sz = i;
    }

    public void q(boolean z) {
        this.e = z;
    }

    public String pk() {
        return this.pe;
    }

    public void d(String str) {
        this.pe = str;
    }

    public boolean wo() {
        return this.yw;
    }

    public void l(boolean z) {
        this.yw = z;
    }

    public boolean sh() {
        return this.pk;
    }

    public void w(boolean z) {
        this.pk = z;
    }

    public boolean y() {
        return this.cx;
    }

    public void x(boolean z) {
        this.cx = z;
    }

    public long rf() {
        return this.y;
    }

    public void fs(long j) {
        this.y = j;
    }

    public long dh() {
        return this.rf;
    }

    public void rv(long j) {
        this.rf = j;
    }

    public boolean b() {
        return this.an;
    }

    public void fs(boolean z) {
        this.an = z;
    }

    public String ri() {
        return this.ae;
    }

    public void oa(String str) {
        this.ae = str;
    }

    public boolean nf() {
        return this.f;
    }

    public void rv(boolean z) {
        this.f = z;
    }

    public boolean pe() {
        return this.ic;
    }

    public void tj(boolean z) {
        this.ic = z;
    }

    public boolean e() {
        return this.ci;
    }

    public void cp(boolean z) {
        this.ci = z;
    }

    public boolean yw() {
        return this.kc;
    }

    public void d(boolean z) {
        this.kc = z;
    }

    public boolean cx() {
        return this.hf;
    }

    public void oa(boolean z) {
        this.hf = z;
    }

    public boolean lq() {
        return this.z;
    }

    public void sz(boolean z) {
        this.z = z;
    }

    public boolean ic() {
        return this.dn;
    }

    public void k(boolean z) {
        this.dn = z;
    }

    public void cy(boolean z) {
        this.dh = z;
    }

    public void hd(boolean z) {
        this.b = z;
    }

    @Override // com.byazt.h.n
    public boolean hd() {
        return this.fi;
    }

    public void cd(boolean z) {
        this.fi = z;
    }

    public void um(boolean z) {
        this.df = z;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void py(boolean z) {
        this.qg = z;
    }

    public boolean ci() {
        return this.he;
    }

    public void ou(boolean z) {
        this.he = z;
    }

    public String hf() {
        return this.el;
    }

    public void sz(String str) {
        this.el = str;
    }

    public long kc() {
        return this.vb;
    }

    public void tj(long j) {
        this.vb = j;
    }

    public void cp(long j) {
        this.ri = j;
    }

    public void d(long j) {
        this.nf = j;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.w);
            jSONObject.put("mExtValue", this.x);
            jSONObject.put("mLogExtra", this.fs);
            jSONObject.put("mDownloadStatus", this.rv);
            jSONObject.put("mPackageName", this.tj);
            jSONObject.put("mIsAd", this.py);
            jSONObject.put("mTimeStamp", this.ou);
            jSONObject.put("mExtras", this.wm);
            jSONObject.put("mVersionCode", this.hd);
            jSONObject.put("mVersionName", this.cd);
            jSONObject.put("mDownloadId", this.m);
            jSONObject.put("mIsV3Event", this.u);
            jSONObject.put("mScene", this.wo);
            jSONObject.put("mEventTag", this.oj);
            jSONObject.put("mEventRefer", this.dg);
            jSONObject.put("mDownloadUrl", this.cp);
            jSONObject.put("mEnableBackDialog", this.hu);
            jSONObject.put("hasSendInstallFinish", this.s.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.q.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.l.get());
            jSONObject.put("mLastFailedErrCode", this.v);
            jSONObject.put("mLastFailedErrMsg", this.j);
            jSONObject.put("mOpenUrl", this.d);
            jSONObject.put("mLinkMode", this.k);
            jSONObject.put("mDownloadMode", this.cy);
            jSONObject.put("mModelType", this.sz);
            jSONObject.put("mAppName", this.um);
            jSONObject.put("mAppIcon", this.a);
            jSONObject.put("mDownloadFailedTimes", this.h);
            long j = this.ur;
            if (j == 0) {
                j = this.ou;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.t);
            jSONObject.put("mJumpInstallTime", this.bb);
            jSONObject.put("mCancelInstallTime", this.ln);
            jSONObject.put("mLastFailedResumeCount", this.lh);
            jSONObject.put("mIsUpdateDownload", this.an);
            jSONObject.put("mOriginMimeType", this.ae);
            jSONObject.put("mIsPatchApplyHandled", this.f);
            jSONObject.put("downloadFinishReason", this.pe);
            jSONObject.put("clickDownloadTime", this.y);
            jSONObject.put("clickDownloadSize", this.rf);
            jSONObject.put("installAfterCleanSpace", this.pk);
            jSONObject.put("funnelType", this.sh);
            jSONObject.put("webUrl", this.oa);
            jSONObject.put("enableShowComplianceDialog", this.dh);
            jSONObject.put("isAutoDownloadOnCardShow", this.b);
            int i = 1;
            jSONObject.put("enable_new_activity", this.fi ? 1 : 0);
            jSONObject.put("enable_pause", this.df ? 1 : 0);
            jSONObject.put("enable_ah", this.n ? 1 : 0);
            if (!this.qg) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.he));
            jSONObject.put("task_key", this.el);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.vb));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.ri));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.nf));
        } catch (Exception e) {
            d.a().n(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public static qg qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qg qgVar = new qg();
        try {
            qgVar.q(com.byazt.es.qg.n(jSONObject, "mId"));
            qgVar.l(com.byazt.es.qg.n(jSONObject, "mExtValue"));
            qgVar.s(jSONObject.optString("mLogExtra"));
            qgVar.l(jSONObject.optInt("mDownloadStatus"));
            qgVar.qg(jSONObject.optString("mPackageName"));
            boolean z = true;
            qgVar.n(jSONObject.optBoolean("mIsAd", true));
            qgVar.w(com.byazt.es.qg.n(jSONObject, "mTimeStamp"));
            qgVar.w(jSONObject.optInt("mVersionCode"));
            qgVar.q(jSONObject.optString("mVersionName"));
            qgVar.x(jSONObject.optInt("mDownloadId"));
            qgVar.qg(jSONObject.optBoolean("mIsV3Event"));
            qgVar.fs(jSONObject.optInt("mScene"));
            qgVar.w(jSONObject.optString("mEventTag"));
            qgVar.x(jSONObject.optString("mEventRefer"));
            qgVar.fs(jSONObject.optString("mDownloadUrl"));
            qgVar.s(jSONObject.optBoolean("mEnableBackDialog"));
            qgVar.s.set(jSONObject.optBoolean("hasSendInstallFinish"));
            qgVar.q.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            qgVar.l.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            qgVar.q(jSONObject.optInt("mLastFailedErrCode"));
            qgVar.n(jSONObject.optString("mLastFailedErrMsg"));
            qgVar.rv(jSONObject.optString("mOpenUrl"));
            qgVar.tj(jSONObject.optInt("mLinkMode"));
            qgVar.cp(jSONObject.optInt("mDownloadMode"));
            qgVar.d(jSONObject.optInt("mModelType"));
            qgVar.tj(jSONObject.optString("mAppName"));
            qgVar.cp(jSONObject.optString("mAppIcon"));
            qgVar.n(jSONObject.optInt("mDownloadFailedTimes", 0));
            qgVar.n(com.byazt.es.qg.n(jSONObject, "mRecentDownloadResumeTime"));
            qgVar.qg(jSONObject.optInt("mClickPauseTimes"));
            qgVar.qg(com.byazt.es.qg.n(jSONObject, "mJumpInstallTime"));
            qgVar.s(com.byazt.es.qg.n(jSONObject, "mCancelInstallTime"));
            qgVar.s(jSONObject.optInt("mLastFailedResumeCount"));
            qgVar.d(jSONObject.optString("downloadFinishReason"));
            qgVar.rv(jSONObject.optLong("clickDownloadSize"));
            qgVar.fs(jSONObject.optLong("clickDownloadTime"));
            qgVar.fs(jSONObject.optBoolean("mIsUpdateDownload"));
            qgVar.oa(jSONObject.optString("mOriginMimeType"));
            qgVar.rv(jSONObject.optBoolean("mIsPatchApplyHandled"));
            qgVar.w(jSONObject.optBoolean("installAfterCleanSpace"));
            qgVar.rv(jSONObject.optInt("funnelType", 1));
            qgVar.l(jSONObject.optString("webUrl"));
            qgVar.cy(jSONObject.optBoolean("enableShowComplianceDialog", true));
            qgVar.hd(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            qgVar.cd(jSONObject.optInt("enable_new_activity", 1) == 1);
            qgVar.um(jSONObject.optInt("enable_pause", 1) == 1);
            qgVar.a(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            qgVar.py(z);
            qgVar.n(jSONObject.optJSONObject("mExtras"));
            qgVar.ou(jSONObject.optBoolean("intent_jump_browser_success"));
            qgVar.sz(jSONObject.optString("task_key"));
            qgVar.tj(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            qgVar.cp(jSONObject.optLong("download_pause_timestamp", 0L));
            qgVar.d(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            d.a().n(e, "NativeDownloadModel fromJson");
        }
        return qgVar;
    }

    @Override // com.byazt.h.n
    public DownloadModel py() {
        return dn();
    }

    @Override // com.byazt.h.n
    public DownloadEventConfig ou() {
        return he();
    }

    @Override // com.byazt.h.n
    public DownloadController wm() {
        return el();
    }

    public AdDownloadModel dn() {
        return new AdDownloadModel.Builder().setAdId(this.w).setExtraValue(this.x).setLogExtra(this.fs).setPackageName(this.tj).setExtra(this.wm).setIsAd(this.py).setVersionCode(this.hd).setVersionName(this.cd).setDownloadUrl(this.cp).setModelType(this.sz).setMimeType(this.ae).setAppName(this.um).setAppIcon(this.a).setTaskKey(this.el).setDeepLink(new DeepLink(this.d, this.oa, null)).build();
    }

    public AdDownloadEventConfig he() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.oj).setRefer(this.dg).setIsEnableV3Event(this.u).build();
    }

    public AdDownloadController el() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.hu).setLinkMode(this.k).setDownloadMode(this.cy).setEnableShowComplianceDialog(this.dh).setEnableAH(this.n).setEnableAM(this.qg).build();
    }
}
