package com.ss.android.downloadad.api.ms;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.hi;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements ms {
    private long ab;
    public final AtomicBoolean ah;
    private boolean am;
    private int ao;
    private boolean az;
    private long b;
    private long c;
    private String ch;
    private long cv;
    public final AtomicBoolean d;
    private String e;
    private boolean eg;
    private String f;
    private int fm;
    private long g;
    private boolean gy;
    private int h;
    private String hi;
    private int i;
    private long il;
    private boolean jw;
    private boolean k;
    public final AtomicBoolean ka;
    private boolean l;
    private long le;
    private String lm;
    private boolean m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f4335ms;
    private boolean nw;
    private int ny;
    private int of;
    private int op;
    private int p;
    private String pc;
    private long qf;
    private transient boolean qk;
    private long qr;
    private String qv;
    private JSONObject re;
    private boolean rt;
    private boolean s;
    private String sa;
    private boolean sk;
    private String sl;
    private String t;
    private boolean ti;
    private boolean tz;
    private int u;
    private int ub;
    private boolean ul;
    private long v;
    private String vl;
    private boolean vm;
    private boolean vy;
    private boolean w;
    private String x;
    private int xn;
    protected boolean xr;
    private String y;
    private int yu;
    private String zb;
    private boolean zf;

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject ao() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject hi() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject qv() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public int t() {
        return -1;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public List<String> u() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public Object ub() {
        return null;
    }

    private xr() {
        this.ny = 1;
        this.nw = true;
        this.w = false;
        this.yu = 0;
        this.op = 0;
        this.jw = false;
        this.ul = false;
        this.az = true;
        this.m = true;
        this.f4335ms = true;
        this.xr = true;
        this.ah = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.ka = new AtomicBoolean(false);
        this.xn = 1;
        this.l = true;
        this.v = -1L;
    }

    public xr(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public xr(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.ny = 1;
        this.nw = true;
        this.w = false;
        this.yu = 0;
        this.op = 0;
        this.jw = false;
        this.ul = false;
        this.az = true;
        this.m = true;
        this.f4335ms = true;
        this.xr = true;
        this.ah = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.ka = new AtomicBoolean(false);
        this.xn = 1;
        this.l = true;
        this.v = -1L;
        this.c = downloadModel.getId();
        this.ab = downloadModel.getExtraValue();
        this.x = downloadModel.getLogExtra();
        this.ch = downloadModel.getPackageName();
        this.re = downloadModel.getExtra();
        this.nw = downloadModel.isAd();
        this.h = downloadModel.getVersionCode();
        this.qv = downloadModel.getVersionName();
        this.hi = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.sl = downloadModel.getDeepLink().getOpenUrl();
            this.zb = downloadModel.getDeepLink().getWebUrl();
        }
        this.u = downloadModel.getModelType();
        this.y = downloadModel.getName();
        this.t = downloadModel.getAppIcon();
        this.f = downloadModel.getMimeType();
        this.lm = downloadEventConfig.getClickButtonTag();
        this.e = downloadEventConfig.getRefer();
        this.k = downloadEventConfig.isEnableV3Event();
        this.w = downloadController.isEnableBackDialog();
        this.ub = downloadController.getLinkMode();
        this.ao = downloadController.getDownloadMode();
        this.l = downloadController.enableShowComplianceDialog();
        this.am = downloadController.isAutoDownloadOnCardShow();
        this.az = downloadController.enableNewActivity();
        this.f4335ms = downloadController.enableAH();
        this.xr = downloadController.enableAM();
        this.i = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = jCurrentTimeMillis;
        this.le = jCurrentTimeMillis;
        this.ul = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.vl = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }

    public int i() {
        return this.yu;
    }

    public void ms(int i) {
        this.yu = i;
    }

    public synchronized void w() {
        this.yu++;
    }

    public int yu() {
        return this.op;
    }

    public void xr(int i) {
        this.op = i;
    }

    public synchronized void op() {
        this.op++;
    }

    public long le() {
        long j = this.le;
        return j == 0 ? this.b : j;
    }

    public void ms(long j) {
        this.le = j;
    }

    public long cv() {
        return this.cv;
    }

    public void xr(long j) {
        this.cv = j;
    }

    public void ah(long j) {
        this.g = j;
    }

    public int g() {
        return this.of;
    }

    public void ah(int i) {
        this.of = i;
    }

    public int of() {
        return this.p;
    }

    public void d(int i) {
        this.p = i;
    }

    public String p() {
        return this.pc;
    }

    public void ms(String str) {
        this.pc = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public long xr() {
        return this.c;
    }

    public void d(long j) {
        this.c = j;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public long sl() {
        return this.ab;
    }

    public void ka(long j) {
        this.ab = j;
    }

    public int pc() {
        return this.ny;
    }

    public void ka(int i) {
        this.ny = i;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ka() {
        return this.ch;
    }

    public void xr(String str) {
        this.ch = str;
    }

    public long jw() {
        return this.b;
    }

    public void c(long j) {
        if (j > 0) {
            this.b = j;
        }
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String d() {
        return this.x;
    }

    public void ah(String str) {
        this.x = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean ah() {
        return this.nw;
    }

    public void ms(boolean z) {
        this.nw = z;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject ab() {
        return this.re;
    }

    public void ms(JSONObject jSONObject) {
        this.re = jSONObject;
    }

    public void c(int i) {
        this.h = i;
    }

    public void d(String str) {
        this.qv = str;
    }

    public int f() {
        return this.h;
    }

    public String ul() {
        return this.qv;
    }

    public void ab(int i) {
        this.i = i;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public int y() {
        return this.i;
    }

    public void xr(boolean z) {
        this.k = z;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean zb() {
        return this.k;
    }

    public void x(int i) {
        this.fm = i;
    }

    public int az() {
        return this.fm;
    }

    public void ny(int i) {
        this.xn = i;
    }

    public void ka(String str) {
        this.zb = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public int x() {
        return this.xn;
    }

    public void ah(boolean z) {
        this.w = z;
    }

    public boolean m() {
        return this.w;
    }

    public void c(String str) {
        this.lm = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ch() {
        return this.lm;
    }

    public void ab(String str) {
        this.e = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ny() {
        return this.e;
    }

    public void x(String str) {
        this.hi = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ms() {
        return this.hi;
    }

    public void ny(String str) {
        this.sl = str;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String c() {
        return this.sl;
    }

    public void ab(long j) {
        this.v = j;
    }

    public long lm() {
        return this.v;
    }

    public void ch(String str) {
        this.y = str;
    }

    public String e() {
        return this.y;
    }

    public void hi(String str) {
        this.t = str;
    }

    public void ch(int i) {
        this.ub = i;
    }

    public int k() {
        return this.ub;
    }

    public void hi(int i) {
        this.ao = i;
    }

    public void sl(int i) {
        this.u = i;
    }

    public void d(boolean z) {
        this.tz = z;
    }

    public String eg() {
        return this.sa;
    }

    public void sl(String str) {
        this.sa = str;
    }

    public boolean fm() {
        return this.ti;
    }

    public void ka(boolean z) {
        this.ti = z;
    }

    public boolean xn() {
        return this.eg;
    }

    public void c(boolean z) {
        this.eg = z;
    }

    public boolean il() {
        return this.s;
    }

    public void ab(boolean z) {
        this.s = z;
    }

    public long qf() {
        return this.il;
    }

    public void x(long j) {
        this.il = j;
    }

    public long l() {
        return this.qf;
    }

    public void ny(long j) {
        this.qf = j;
    }

    public boolean am() {
        return this.jw;
    }

    public void x(boolean z) {
        this.jw = z;
    }

    public String sa() {
        return this.f;
    }

    public void zb(String str) {
        this.f = str;
    }

    public boolean tz() {
        return this.ul;
    }

    public void ny(boolean z) {
        this.ul = z;
    }

    public boolean ti() {
        return this.qk;
    }

    public void ch(boolean z) {
        this.qk = z;
    }

    public boolean s() {
        return this.vm;
    }

    public void hi(boolean z) {
        this.vm = z;
    }

    public boolean v() {
        return this.rt;
    }

    public void sl(boolean z) {
        this.rt = z;
    }

    public boolean qk() {
        return this.zf;
    }

    public void zb(boolean z) {
        this.zf = z;
    }

    public boolean vm() {
        return this.vy;
    }

    public void u(boolean z) {
        this.vy = z;
    }

    public boolean zf() {
        return this.sk;
    }

    public void ub(boolean z) {
        this.sk = z;
    }

    public void ao(boolean z) {
        this.l = z;
    }

    public void h(boolean z) {
        this.am = z;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean h() {
        return this.az;
    }

    public void qv(boolean z) {
        this.az = z;
    }

    public void y(boolean z) {
        this.m = z;
    }

    public void t(boolean z) {
        this.f4335ms = z;
    }

    public void nw(boolean z) {
        this.xr = z;
    }

    public boolean rt() {
        return this.gy;
    }

    public void b(boolean z) {
        this.gy = z;
    }

    public String vy() {
        return this.vl;
    }

    public void u(String str) {
        this.vl = str;
    }

    public long sk() {
        return this.qr;
    }

    public void ch(long j) {
        this.qr = j;
    }

    public JSONObject gy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.c);
            jSONObject.put("mExtValue", this.ab);
            jSONObject.put("mLogExtra", this.x);
            jSONObject.put("mDownloadStatus", this.ny);
            jSONObject.put("mPackageName", this.ch);
            jSONObject.put("mIsAd", this.nw);
            jSONObject.put("mTimeStamp", this.b);
            jSONObject.put("mExtras", this.re);
            jSONObject.put("mVersionCode", this.h);
            jSONObject.put("mVersionName", this.qv);
            jSONObject.put("mDownloadId", this.i);
            jSONObject.put("mIsV3Event", this.k);
            jSONObject.put("mScene", this.fm);
            jSONObject.put("mEventTag", this.lm);
            jSONObject.put("mEventRefer", this.e);
            jSONObject.put("mDownloadUrl", this.hi);
            jSONObject.put("mEnableBackDialog", this.w);
            jSONObject.put("hasSendInstallFinish", this.ah.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.d.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.ka.get());
            jSONObject.put("mLastFailedErrCode", this.p);
            jSONObject.put("mLastFailedErrMsg", this.pc);
            jSONObject.put("mOpenUrl", this.sl);
            jSONObject.put("mLinkMode", this.ub);
            jSONObject.put("mDownloadMode", this.ao);
            jSONObject.put("mModelType", this.u);
            jSONObject.put("mAppName", this.y);
            jSONObject.put("mAppIcon", this.t);
            jSONObject.put("mDownloadFailedTimes", this.yu);
            long j = this.le;
            if (j == 0) {
                j = this.b;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.op);
            jSONObject.put("mJumpInstallTime", this.cv);
            jSONObject.put("mCancelInstallTime", this.g);
            jSONObject.put("mLastFailedResumeCount", this.of);
            jSONObject.put("mIsUpdateDownload", this.jw);
            jSONObject.put("mOriginMimeType", this.f);
            jSONObject.put("mIsPatchApplyHandled", this.ul);
            jSONObject.put("downloadFinishReason", this.sa);
            jSONObject.put("clickDownloadTime", this.il);
            jSONObject.put("clickDownloadSize", this.qf);
            jSONObject.put("installAfterCleanSpace", this.eg);
            jSONObject.put(TTDownloadField.TT_FUNNEL_TYPE, this.xn);
            jSONObject.put(TTDownloadField.TT_WEB_URL, this.zb);
            jSONObject.put(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.l);
            jSONObject.put(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.am);
            int i = 1;
            jSONObject.put("enable_new_activity", this.az ? 1 : 0);
            jSONObject.put("enable_pause", this.m ? 1 : 0);
            jSONObject.put("enable_ah", this.f4335ms ? 1 : 0);
            if (!this.xr) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.gy));
            jSONObject.put("task_key", this.vl);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.qr));
        } catch (Exception e) {
            hi.t().ms(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public static xr xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xr xrVar = new xr();
        try {
            xrVar.d(com.ss.android.download.api.ah.xr.ms(jSONObject, "mId"));
            xrVar.ka(com.ss.android.download.api.ah.xr.ms(jSONObject, "mExtValue"));
            xrVar.ah(jSONObject.optString("mLogExtra"));
            xrVar.ka(jSONObject.optInt("mDownloadStatus"));
            xrVar.xr(jSONObject.optString("mPackageName"));
            boolean z = true;
            xrVar.ms(jSONObject.optBoolean("mIsAd", true));
            xrVar.c(com.ss.android.download.api.ah.xr.ms(jSONObject, "mTimeStamp"));
            xrVar.c(jSONObject.optInt("mVersionCode"));
            xrVar.d(jSONObject.optString("mVersionName"));
            xrVar.ab(jSONObject.optInt("mDownloadId"));
            xrVar.xr(jSONObject.optBoolean("mIsV3Event"));
            xrVar.x(jSONObject.optInt("mScene"));
            xrVar.c(jSONObject.optString("mEventTag"));
            xrVar.ab(jSONObject.optString("mEventRefer"));
            xrVar.x(jSONObject.optString("mDownloadUrl"));
            xrVar.ah(jSONObject.optBoolean("mEnableBackDialog"));
            xrVar.ah.set(jSONObject.optBoolean("hasSendInstallFinish"));
            xrVar.d.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            xrVar.ka.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            xrVar.d(jSONObject.optInt("mLastFailedErrCode"));
            xrVar.ms(jSONObject.optString("mLastFailedErrMsg"));
            xrVar.ny(jSONObject.optString("mOpenUrl"));
            xrVar.ch(jSONObject.optInt("mLinkMode"));
            xrVar.hi(jSONObject.optInt("mDownloadMode"));
            xrVar.sl(jSONObject.optInt("mModelType"));
            xrVar.ch(jSONObject.optString("mAppName"));
            xrVar.hi(jSONObject.optString("mAppIcon"));
            xrVar.ms(jSONObject.optInt("mDownloadFailedTimes", 0));
            xrVar.ms(com.ss.android.download.api.ah.xr.ms(jSONObject, "mRecentDownloadResumeTime"));
            xrVar.xr(jSONObject.optInt("mClickPauseTimes"));
            xrVar.xr(com.ss.android.download.api.ah.xr.ms(jSONObject, "mJumpInstallTime"));
            xrVar.ah(com.ss.android.download.api.ah.xr.ms(jSONObject, "mCancelInstallTime"));
            xrVar.ah(jSONObject.optInt("mLastFailedResumeCount"));
            xrVar.sl(jSONObject.optString("downloadFinishReason"));
            xrVar.ny(jSONObject.optLong("clickDownloadSize"));
            xrVar.x(jSONObject.optLong("clickDownloadTime"));
            xrVar.x(jSONObject.optBoolean("mIsUpdateDownload"));
            xrVar.zb(jSONObject.optString("mOriginMimeType"));
            xrVar.ny(jSONObject.optBoolean("mIsPatchApplyHandled"));
            xrVar.c(jSONObject.optBoolean("installAfterCleanSpace"));
            xrVar.ny(jSONObject.optInt(TTDownloadField.TT_FUNNEL_TYPE, 1));
            xrVar.ka(jSONObject.optString(TTDownloadField.TT_WEB_URL));
            xrVar.ao(jSONObject.optBoolean(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            xrVar.h(jSONObject.optBoolean(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            xrVar.qv(jSONObject.optInt("enable_new_activity", 1) == 1);
            xrVar.y(jSONObject.optInt("enable_pause", 1) == 1);
            xrVar.t(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            xrVar.nw(z);
            xrVar.ms(jSONObject.optJSONObject("mExtras"));
            xrVar.b(jSONObject.optBoolean("intent_jump_browser_success"));
            xrVar.u(jSONObject.optString("task_key"));
            xrVar.ch(jSONObject.optLong("market_install_finish_check_start_timestamp"));
        } catch (Exception e) {
            hi.t().ms(e, "NativeDownloadModel fromJson");
        }
        return xrVar;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadModel nw() {
        return vl();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadEventConfig b() {
        return qr();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadController re() {
        return ce();
    }

    public AdDownloadModel vl() {
        return new AdDownloadModel.Builder().setAdId(this.c).setExtraValue(this.ab).setLogExtra(this.x).setPackageName(this.ch).setExtra(this.re).setIsAd(this.nw).setVersionCode(this.h).setVersionName(this.qv).setDownloadUrl(this.hi).setModelType(this.u).setMimeType(this.f).setAppName(this.y).setAppIcon(this.t).setTaskKey(this.vl).setDeepLink(new DeepLink(this.sl, this.zb, null)).build();
    }

    public AdDownloadEventConfig qr() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.lm).setRefer(this.e).setIsEnableV3Event(this.k).build();
    }

    public AdDownloadController ce() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.w).setLinkMode(this.ub).setDownloadMode(this.ao).setEnableShowComplianceDialog(this.l).setEnableAH(this.f4335ms).setEnableAM(this.xr).build();
    }
}
