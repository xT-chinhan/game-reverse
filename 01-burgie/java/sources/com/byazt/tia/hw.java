package com.byazt.tia;

import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.cxa.DeepLink;
import com.byazt.eld.k;
import com.byazt.km.AdDownloadController;
import com.byazt.km.AdDownloadEventConfig;
import com.byazt.km.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 13})
public class hw implements pr {
    public String a;
    public String aa;
    public int aj;
    public int b;
    public long bm;
    public final AtomicBoolean c;
    public boolean cz;
    public boolean d;
    public boolean e;
    public boolean er;
    public long f;
    public JSONObject fo;
    public long fw;
    public int g;
    public boolean gu;
    public long gz;
    public final AtomicBoolean hn;
    public int ho;
    public long hs;
    public boolean hw;
    public int i;
    public boolean ie;
    public boolean ii;
    public int iu;
    public long iy;
    public String jn;
    public boolean jw;
    public String k;
    public boolean l;
    public String lb;
    public boolean ls;
    public boolean lv;
    public String m;
    public transient boolean mw;
    public String n;
    public long nl;
    public int nt;
    public long nw;
    public long ny;
    public boolean o;
    public boolean od;
    public boolean of;
    public boolean pq;
    public boolean pr;
    public String qa;
    public String qi;
    public String qn;
    public int r;
    public int rc;
    public String s;
    public boolean sv;
    public long uc;
    public boolean v;
    public long ve;
    public long vj;
    public String vk;
    public String w;
    public boolean wt;
    public int ww;
    public final AtomicBoolean x;
    public int y;
    public int yb;
    public boolean z;
    public String zo;

    private hw() {
        this.aj = 1;
        this.cz = true;
        this.z = false;
        this.b = 0;
        this.iu = 0;
        this.e = false;
        this.ls = false;
        this.er = true;
        this.v = true;
        this.pr = true;
        this.hw = true;
        this.hn = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.r = 1;
        this.ie = true;
        this.vj = -1L;
    }

    public hw(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public hw(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.aj = 1;
        this.cz = true;
        this.z = false;
        this.b = 0;
        this.iu = 0;
        this.e = false;
        this.ls = false;
        this.er = true;
        this.v = true;
        this.pr = true;
        this.hw = true;
        this.hn = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.r = 1;
        this.ie = true;
        this.vj = -1L;
        this.uc = downloadModel.getId();
        this.fw = downloadModel.getExtraValue();
        this.zo = downloadModel.getLogExtra();
        this.vk = downloadModel.getPackageName();
        this.fo = downloadModel.getExtra();
        this.cz = downloadModel.isAd();
        this.yb = downloadModel.getVersionCode();
        this.lb = downloadModel.getVersionName();
        this.w = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.k = downloadModel.getDeepLink().getOpenUrl();
            this.m = downloadModel.getDeepLink().getWebUrl();
        }
        this.g = downloadModel.getModelType();
        this.qa = downloadModel.getName();
        this.a = downloadModel.getAppIcon();
        this.s = downloadModel.getMimeType();
        this.qi = downloadEventConfig.getClickButtonTag();
        this.qn = downloadEventConfig.getRefer();
        this.of = downloadEventConfig.isEnableV3Event();
        this.z = downloadController.isEnableBackDialog();
        this.ho = downloadController.getLinkMode();
        this.nt = downloadController.getDownloadMode();
        this.ie = downloadController.enableShowComplianceDialog();
        this.o = downloadController.isAutoDownloadOnCardShow();
        this.er = downloadController.enableNewActivity();
        this.pr = downloadController.enableAH();
        this.hw = downloadController.enableAM();
        this.rc = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ny = jCurrentTimeMillis;
        this.ve = jCurrentTimeMillis;
        this.ls = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.aa = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }

    public int rc() {
        return this.b;
    }

    public void pr(int i) {
        this.b = i;
    }

    public synchronized void z() {
        this.b++;
    }

    public int b() {
        return this.iu;
    }

    public void hw(int i) {
        this.iu = i;
    }

    public synchronized void iu() {
        this.iu++;
    }

    public long ve() {
        long j = this.ve;
        if (j == 0) {
            return this.ny;
        }
        return j;
    }

    public void pr(long j) {
        this.ve = j;
    }

    public long gz() {
        return this.gz;
    }

    public void hw(long j) {
        this.gz = j;
    }

    public void hn(long j) {
        this.nl = j;
    }

    public int nl() {
        return this.y;
    }

    public void hn(int i) {
        this.y = i;
    }

    public int y() {
        return this.ww;
    }

    public void x(int i) {
        this.ww = i;
    }

    public String ww() {
        return this.n;
    }

    public void pr(String str) {
        this.n = str;
    }

    @Override // com.byazt.tia.pr
    public long hw() {
        return this.uc;
    }

    public void x(long j) {
        this.uc = j;
    }

    @Override // com.byazt.tia.pr
    public long k() {
        return this.fw;
    }

    public void c(long j) {
        this.fw = j;
    }

    public int n() {
        return this.aj;
    }

    public void c(int i) {
        this.aj = i;
    }

    @Override // com.byazt.tia.pr
    public String c() {
        return this.vk;
    }

    public void hw(String str) {
        this.vk = str;
    }

    public long e() {
        return this.ny;
    }

    public void uc(long j) {
        if (j > 0) {
            this.ny = j;
        }
    }

    @Override // com.byazt.tia.pr
    public String x() {
        return this.zo;
    }

    public void hn(String str) {
        this.zo = str;
    }

    @Override // com.byazt.tia.pr
    public boolean hn() {
        return this.cz;
    }

    public void pr(boolean z) {
        this.cz = z;
    }

    @Override // com.byazt.tia.pr
    public JSONObject fw() {
        return this.fo;
    }

    public void pr(JSONObject jSONObject) {
        this.fo = jSONObject;
    }

    public void uc(int i) {
        this.yb = i;
    }

    public void x(String str) {
        this.lb = str;
    }

    public int s() {
        return this.yb;
    }

    public String ls() {
        return this.lb;
    }

    public void fw(int i) {
        this.rc = i;
    }

    @Override // com.byazt.tia.pr
    public int qa() {
        return this.rc;
    }

    public void hw(boolean z) {
        this.of = z;
    }

    @Override // com.byazt.tia.pr
    public boolean m() {
        return this.of;
    }

    @Override // com.byazt.tia.pr
    public List<String> g() {
        return null;
    }

    @Override // com.byazt.tia.pr
    public JSONObject lb() {
        return null;
    }

    @Override // com.byazt.tia.pr
    public Object ho() {
        return null;
    }

    @Override // com.byazt.tia.pr
    public JSONObject nt() {
        return null;
    }

    @Override // com.byazt.tia.pr
    public JSONObject w() {
        return null;
    }

    public void zo(int i) {
        this.i = i;
    }

    public int er() {
        return this.i;
    }

    public void aj(int i) {
        this.r = i;
    }

    public void c(String str) {
        this.m = str;
    }

    @Override // com.byazt.tia.pr
    public int zo() {
        return this.r;
    }

    public void hn(boolean z) {
        this.z = z;
    }

    public boolean v() {
        return this.z;
    }

    public void uc(String str) {
        this.qi = str;
    }

    @Override // com.byazt.tia.pr
    public String vk() {
        return this.qi;
    }

    public void fw(String str) {
        this.qn = str;
    }

    @Override // com.byazt.tia.pr
    public String aj() {
        return this.qn;
    }

    public void zo(String str) {
        this.w = str;
    }

    @Override // com.byazt.tia.pr
    public String pr() {
        return this.w;
    }

    public void aj(String str) {
        this.k = str;
    }

    @Override // com.byazt.tia.pr
    public String uc() {
        return this.k;
    }

    public void fw(long j) {
        this.vj = j;
    }

    public long qi() {
        return this.vj;
    }

    public void vk(String str) {
        this.qa = str;
    }

    public String qn() {
        return this.qa;
    }

    public void w(String str) {
        this.a = str;
    }

    public void vk(int i) {
        this.ho = i;
    }

    public int of() {
        return this.ho;
    }

    public void w(int i) {
        this.nt = i;
    }

    public void k(int i) {
        this.g = i;
    }

    @Override // com.byazt.tia.pr
    public int a() {
        return -1;
    }

    public void x(boolean z) {
        this.l = z;
    }

    public String ii() {
        return this.jn;
    }

    public void k(String str) {
        this.jn = str;
    }

    public boolean i() {
        return this.lv;
    }

    public void c(boolean z) {
        this.lv = z;
    }

    public boolean r() {
        return this.ii;
    }

    public void uc(boolean z) {
        this.ii = z;
    }

    public boolean hs() {
        return this.od;
    }

    public void fw(boolean z) {
        this.od = z;
    }

    public long nw() {
        return this.hs;
    }

    public void zo(long j) {
        this.hs = j;
    }

    public long ie() {
        return this.nw;
    }

    public void aj(long j) {
        this.nw = j;
    }

    public boolean o() {
        return this.e;
    }

    public void zo(boolean z) {
        this.e = z;
    }

    public String f() {
        return this.s;
    }

    public void m(String str) {
        this.s = str;
    }

    public boolean bm() {
        return this.ls;
    }

    public void aj(boolean z) {
        this.ls = z;
    }

    public boolean jn() {
        return this.mw;
    }

    public void vk(boolean z) {
        this.mw = z;
    }

    public boolean l() {
        return this.sv;
    }

    public void w(boolean z) {
        this.sv = z;
    }

    public boolean lv() {
        return this.d;
    }

    public void k(boolean z) {
        this.d = z;
    }

    public boolean od() {
        return this.gu;
    }

    public void m(boolean z) {
        this.gu = z;
    }

    public boolean vj() {
        return this.pq;
    }

    public void g(boolean z) {
        this.pq = z;
    }

    public boolean mw() {
        return this.jw;
    }

    public void ho(boolean z) {
        this.jw = z;
    }

    public void nt(boolean z) {
        this.ie = z;
    }

    public void yb(boolean z) {
        this.o = z;
    }

    @Override // com.byazt.tia.pr
    public boolean yb() {
        return this.er;
    }

    public void lb(boolean z) {
        this.er = z;
    }

    public void qa(boolean z) {
        this.v = z;
    }

    public void a(boolean z) {
        this.pr = z;
    }

    public void cz(boolean z) {
        this.hw = z;
    }

    public boolean sv() {
        return this.wt;
    }

    public void ny(boolean z) {
        this.wt = z;
    }

    public String gu() {
        return this.aa;
    }

    public void g(String str) {
        this.aa = str;
    }

    public long d() {
        return this.iy;
    }

    public void vk(long j) {
        this.iy = j;
    }

    public void w(long j) {
        this.f = j;
    }

    public void k(long j) {
        this.bm = j;
    }

    public JSONObject pq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.uc);
            jSONObject.put("mExtValue", this.fw);
            jSONObject.put("mLogExtra", this.zo);
            jSONObject.put("mDownloadStatus", this.aj);
            jSONObject.put("mPackageName", this.vk);
            jSONObject.put("mIsAd", this.cz);
            jSONObject.put("mTimeStamp", this.ny);
            jSONObject.put("mExtras", this.fo);
            jSONObject.put("mVersionCode", this.yb);
            jSONObject.put("mVersionName", this.lb);
            jSONObject.put("mDownloadId", this.rc);
            jSONObject.put("mIsV3Event", this.of);
            jSONObject.put("mScene", this.i);
            jSONObject.put("mEventTag", this.qi);
            jSONObject.put("mEventRefer", this.qn);
            jSONObject.put("mDownloadUrl", this.w);
            jSONObject.put("mEnableBackDialog", this.z);
            jSONObject.put("hasSendInstallFinish", this.hn.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.x.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.c.get());
            jSONObject.put("mLastFailedErrCode", this.ww);
            jSONObject.put("mLastFailedErrMsg", this.n);
            jSONObject.put("mOpenUrl", this.k);
            jSONObject.put("mLinkMode", this.ho);
            jSONObject.put("mDownloadMode", this.nt);
            jSONObject.put("mModelType", this.g);
            jSONObject.put("mAppName", this.qa);
            jSONObject.put("mAppIcon", this.a);
            jSONObject.put("mDownloadFailedTimes", this.b);
            long j = this.ve;
            if (j == 0) {
                j = this.ny;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.iu);
            jSONObject.put("mJumpInstallTime", this.gz);
            jSONObject.put("mCancelInstallTime", this.nl);
            jSONObject.put("mLastFailedResumeCount", this.y);
            jSONObject.put("mIsUpdateDownload", this.e);
            jSONObject.put("mOriginMimeType", this.s);
            jSONObject.put("mIsPatchApplyHandled", this.ls);
            jSONObject.put("downloadFinishReason", this.jn);
            jSONObject.put("clickDownloadTime", this.hs);
            jSONObject.put("clickDownloadSize", this.nw);
            jSONObject.put("installAfterCleanSpace", this.ii);
            jSONObject.put("funnelType", this.r);
            jSONObject.put("webUrl", this.m);
            jSONObject.put("enableShowComplianceDialog", this.ie);
            jSONObject.put("isAutoDownloadOnCardShow", this.o);
            int i = 1;
            jSONObject.put("enable_new_activity", this.er ? 1 : 0);
            jSONObject.put("enable_pause", this.v ? 1 : 0);
            jSONObject.put("enable_ah", this.pr ? 1 : 0);
            if (!this.hw) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.wt));
            jSONObject.put("task_key", this.aa);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.iy));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.f));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.bm));
        } catch (Exception e) {
            k.a().pr(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public static hw hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hw hwVar = new hw();
        try {
            hwVar.x(com.byazt.snv.hw.pr(jSONObject, "mId"));
            hwVar.c(com.byazt.snv.hw.pr(jSONObject, "mExtValue"));
            hwVar.hn(jSONObject.optString("mLogExtra"));
            hwVar.c(jSONObject.optInt("mDownloadStatus"));
            hwVar.hw(jSONObject.optString("mPackageName"));
            boolean z = true;
            hwVar.pr(jSONObject.optBoolean("mIsAd", true));
            hwVar.uc(com.byazt.snv.hw.pr(jSONObject, "mTimeStamp"));
            hwVar.uc(jSONObject.optInt("mVersionCode"));
            hwVar.x(jSONObject.optString("mVersionName"));
            hwVar.fw(jSONObject.optInt("mDownloadId"));
            hwVar.hw(jSONObject.optBoolean("mIsV3Event"));
            hwVar.zo(jSONObject.optInt("mScene"));
            hwVar.uc(jSONObject.optString("mEventTag"));
            hwVar.fw(jSONObject.optString("mEventRefer"));
            hwVar.zo(jSONObject.optString("mDownloadUrl"));
            hwVar.hn(jSONObject.optBoolean("mEnableBackDialog"));
            hwVar.hn.set(jSONObject.optBoolean("hasSendInstallFinish"));
            hwVar.x.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            hwVar.c.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            hwVar.x(jSONObject.optInt("mLastFailedErrCode"));
            hwVar.pr(jSONObject.optString("mLastFailedErrMsg"));
            hwVar.aj(jSONObject.optString("mOpenUrl"));
            hwVar.vk(jSONObject.optInt("mLinkMode"));
            hwVar.w(jSONObject.optInt("mDownloadMode"));
            hwVar.k(jSONObject.optInt("mModelType"));
            hwVar.vk(jSONObject.optString("mAppName"));
            hwVar.w(jSONObject.optString("mAppIcon"));
            hwVar.pr(jSONObject.optInt("mDownloadFailedTimes", 0));
            hwVar.pr(com.byazt.snv.hw.pr(jSONObject, "mRecentDownloadResumeTime"));
            hwVar.hw(jSONObject.optInt("mClickPauseTimes"));
            hwVar.hw(com.byazt.snv.hw.pr(jSONObject, "mJumpInstallTime"));
            hwVar.hn(com.byazt.snv.hw.pr(jSONObject, "mCancelInstallTime"));
            hwVar.hn(jSONObject.optInt("mLastFailedResumeCount"));
            hwVar.k(jSONObject.optString("downloadFinishReason"));
            hwVar.aj(jSONObject.optLong("clickDownloadSize"));
            hwVar.zo(jSONObject.optLong("clickDownloadTime"));
            hwVar.zo(jSONObject.optBoolean("mIsUpdateDownload"));
            hwVar.m(jSONObject.optString("mOriginMimeType"));
            hwVar.aj(jSONObject.optBoolean("mIsPatchApplyHandled"));
            hwVar.uc(jSONObject.optBoolean("installAfterCleanSpace"));
            hwVar.aj(jSONObject.optInt("funnelType", 1));
            hwVar.c(jSONObject.optString("webUrl"));
            hwVar.nt(jSONObject.optBoolean("enableShowComplianceDialog", true));
            hwVar.yb(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            hwVar.lb(jSONObject.optInt("enable_new_activity", 1) == 1);
            hwVar.qa(jSONObject.optInt("enable_pause", 1) == 1);
            hwVar.a(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            hwVar.cz(z);
            hwVar.pr(jSONObject.optJSONObject("mExtras"));
            hwVar.ny(jSONObject.optBoolean("intent_jump_browser_success"));
            hwVar.g(jSONObject.optString("task_key"));
            hwVar.vk(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            hwVar.w(jSONObject.optLong("download_pause_timestamp", 0L));
            hwVar.k(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            k.a().pr(e, "NativeDownloadModel fromJson");
        }
        return hwVar;
    }

    @Override // com.byazt.tia.pr
    public DownloadModel cz() {
        return jw();
    }

    @Override // com.byazt.tia.pr
    public DownloadEventConfig ny() {
        return wt();
    }

    @Override // com.byazt.tia.pr
    public DownloadController fo() {
        return aa();
    }

    public AdDownloadModel jw() {
        return new AdDownloadModel.Builder().setAdId(this.uc).setExtraValue(this.fw).setLogExtra(this.zo).setPackageName(this.vk).setExtra(this.fo).setIsAd(this.cz).setVersionCode(this.yb).setVersionName(this.lb).setDownloadUrl(this.w).setModelType(this.g).setMimeType(this.s).setAppName(this.qa).setAppIcon(this.a).setTaskKey(this.aa).setDeepLink(new DeepLink(this.k, this.m, null)).build();
    }

    public AdDownloadEventConfig wt() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.qi).setRefer(this.qn).setIsEnableV3Event(this.of).build();
    }

    public AdDownloadController aa() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.z).setLinkMode(this.ho).setDownloadMode(this.nt).setEnableShowComplianceDialog(this.ie).setEnableAH(this.pr).setEnableAM(this.hw).build();
    }
}
