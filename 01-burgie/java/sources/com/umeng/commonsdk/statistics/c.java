package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bo;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX INFO: compiled from: NetWorkManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    String a;
    private com.umeng.commonsdk.statistics.internal.c f;
    private ImprintHandler g;
    private e h;
    private ImprintHandler.a i;
    private Defcon k;
    private long l;
    private int m;
    private int n;
    private Context r;
    private final int e = 1;
    private ABTest j = null;

    public c(Context context) {
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.a = null;
        this.r = context;
        this.i = ImprintHandler.getImprintService(this.r).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        this.g = ImprintHandler.getImprintService(this.r);
        this.g.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.k.onImprintChanged(aVar);
                c.this.a = UMEnvelopeBuild.imprintProperty(c.this.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.h = e.a(this.r);
        }
        this.f = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        String strC;
        int iA;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a aVarA = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            aVarA.e(name);
            boolean zA = aVarA.a(name);
            boolean zB = aVarA.b(name);
            boolean zC = aVarA.c(name);
            boolean zD = aVarA.d(name);
            String strD = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(strD)) {
                strC = com.umeng.commonsdk.stateless.d.c(strD);
            } else if (zD) {
                strC = UMServerURL.SILENT_HEART_BEAT;
            } else if (zC) {
                strC = UMServerURL.ZCFG_PATH;
            } else {
                strC = UMServerURL.PATH_ANALYTICS;
            }
            byte[] bArrA = this.f.a(byteArray, zA, zC, strC);
            if (bArrA != null) {
                iA = a(bArrA);
            } else {
                iA = 1;
            }
            if (UMConfigure.isDebugLog()) {
                if (zD && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (zC && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (zB && iA == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (zA && iA == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            switch (iA) {
                case 2:
                    if (this.h != null) {
                        this.h.e();
                    }
                    StatTracer.getInstance(this.r).saveSate();
                    if (zD) {
                        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                        if (!TextUtils.isEmpty(strImprintProperty)) {
                            if ("1".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                                com.umeng.commonsdk.utils.c.a(this.r, System.currentTimeMillis());
                            } else if ("0".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                                com.umeng.commonsdk.utils.c.a(this.r, 0L);
                                com.umeng.commonsdk.utils.c.d(this.r);
                            }
                        }
                    }
                    break;
                case 3:
                    StatTracer.getInstance(this.r).saveSate();
                    if (zC) {
                        FieldManager.a().a(this.r);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                        UMWorkDispatch.sendEvent(this.r, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(this.r).a(), null);
                        return true;
                    }
                    break;
            }
            if (iA != 2) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new az(new bo.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        if (response.resp_code == 1) {
            return 2;
        }
        return 3;
    }
}
