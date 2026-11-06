package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag = false;

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildStateless() {
        if (!getTransmissionSendFlag()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    private static boolean isRet(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType, boolean z) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            boolean zIsOnline = UMFrUtils.isOnline(applicationContext);
            int iEnvelopeFileNumber = UMFrUtils.envelopeFileNumber(applicationContext);
            if (zIsOnline) {
                if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
                    if (UMFrUtils.hasEnvelopeFile(applicationContext, uMBusinessType)) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    if (a.a()) {
                        UMWorkDispatch.sendDelayProcessMsg(a.b());
                    } else if (!UMFrUtils.hasEnvelopeFile(applicationContext, uMBusinessType) && !UMConfigure.needSendZcfgEnv(context)) {
                        z = true;
                    }
                    z = false;
                }
            }
            if (zIsOnline && iEnvelopeFileNumber > 0) {
                a.d();
            }
        }
        return z;
    }

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        i iVarA = i.a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        UUID uuidRandomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.e, str2);
        contentValues.put(ar.f, iVarA.c(jSONObject.toString()));
        contentValues.put(ar.g, iVarA.c(jSONObject2.toString()));
        contentValues.put(ar.h, String.valueOf(jCurrentTimeMillis));
        contentValues.put(ar.i, uuidRandomUUID.toString());
        contentValues.put(ar.j, str);
        contentValues.put(ar.k, str3);
        ap.a(context).a(ar.c, contentValues);
        if (an.aC.equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if (an.aB.equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException e) {
            }
        } else if (!an.ax.equalsIgnoreCase(str2)) {
            if (an.aI.equalsIgnoreCase(str2)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(b.a("header"), new JSONObject());
                    jSONObject4.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                } catch (JSONException e2) {
                }
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put(b.a("header"), new JSONObject());
                    jSONObject5.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject5;
                } catch (JSONException e3) {
                }
            }
            return jSONObject2;
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        String str = an.av;
        if (jSONObject.has("st")) {
            str = an.aI;
        } else if (jSONObject2.has(an.au)) {
            str = an.aC;
        }
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, str, "9.5.3");
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 121);
                    return jSONObject3;
                } catch (JSONException e) {
                    return jSONObject3;
                }
            } catch (JSONException e2) {
                return null;
            }
        }
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 120);
                    return jSONObject4;
                } catch (JSONException e3) {
                    return jSONObject4;
                }
            } catch (JSONException e4) {
                return null;
            }
        }
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
        if (ap.a(context).c()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
        JSONObject jSONObjectAdd2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.t)) {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context).a(), null);
        }
        return jSONObjectAdd2CacheTable;
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 120);
                    return jSONObject3;
                } catch (JSONException e) {
                    return jSONObject3;
                }
            } catch (JSONException e2) {
                return null;
            }
        }
        return new b().b(context.getApplicationContext(), jSONObject, jSONObject2, str);
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 120);
                    return jSONObject3;
                } catch (JSONException e) {
                    return jSONObject3;
                }
            } catch (JSONException e2) {
                return null;
            }
        }
        return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str);
    }

    public static String imprintProperty(Context context, String str, String str2) {
        if (context == null) {
            return str2;
        }
        return ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        return transmissionSendFlag;
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        transmissionSendFlag = z;
    }

    public static void sendProcessNextMsgOnce() {
        a.d();
    }

    public static void registerNetReceiver(Context context) {
        a.b(context);
    }
}
