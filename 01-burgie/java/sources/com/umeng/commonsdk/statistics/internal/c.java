package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;
    private b d;

    public c(Context context) {
        this.c = context;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_p", "");
        String strImprintProperty4 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(strImprintProperty3);
        }
        if (!TextUtils.isEmpty(strImprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(strImprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (!TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
                AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
            }
        }
    }

    private void c() {
        if (!g) {
            ImprintHandler.getImprintService(this.c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    if (FieldManager.b()) {
                        FieldManager.a().a(c.this.c, str2);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                        UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    }
                }
            });
            g = true;
        }
    }

    private void d() {
        if (!f) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
            ImprintHandler.getImprintService(this.c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
                public boolean onPreProcessImprintKey(String str, String str2) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.c);
                    UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    ImprintHandler.getImprintService(c.this.c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                    return true;
                }
            });
            ImprintHandler.getImprintService(this.c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.c, str2);
                    UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                        if (!UMWorkDispatch.eventHasExist()) {
                            UMWorkDispatch.sendEventEx(c.this.c, o.a.D, CoreProtocol.getInstance(c.this.c), null, 0L);
                        }
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                        l.a(c.this.c).b(c.this.c);
                    }
                    ImprintHandler.getImprintService(c.this.c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
                }
            });
            f = true;
        }
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, String str) throws Throwable {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArrA = null;
        for (int i = 0; i < AnalyticsConstants.APPLOG_URL_LIST.length; i++) {
            String str2 = AnalyticsConstants.APPLOG_URL_LIST[i];
            if (z2) {
                d();
            } else {
                c();
            }
            bArrA = a(bArr, str2 + File.separator + str);
            if (bArrA != null) {
                if (this.d == null) {
                    break;
                }
                this.d.onRequestSucceed(z);
                break;
            }
            if (this.d != null) {
                this.d.onRequestFailed();
            }
        }
        return bArrA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0192: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:109:0x0192 */
    /* JADX WARN: Type inference failed for: r9v10, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public byte[] a(byte[] bArr, String str) throws Throwable {
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3 = null;
        try {
            try {
                if (this.d != null) {
                    this.d.onRequestStart();
                }
                str = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    if (!e) {
                        str.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        str.setSSLSocketFactory(sSLContext.getSocketFactory());
                        e = true;
                    }
                    str.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    str.setRequestProperty("X-Umeng-Sdk", a.a(this.c).b());
                    str.setRequestProperty("Content-Type", a.a(this.c).a());
                    str.setRequestProperty("Msg-Type", "envelope/json");
                    str.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    str.setRequestProperty("SM-IMP", "1");
                    str.setConnectTimeout(30000);
                    str.setReadTimeout(30000);
                    str.setRequestMethod(TapHttp.METHOD_POST);
                    str.setDoOutput(true);
                    str.setDoInput(true);
                    boolean z = false;
                    str.setUseCaches(false);
                    outputStream = str.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        str.connect();
                        if (this.d != null) {
                            this.d.onRequestEnd();
                        }
                        int responseCode = str.getResponseCode();
                        String headerField = str.getHeaderField("Content-Type");
                        if (!TextUtils.isEmpty(headerField) && headerField.equalsIgnoreCase("application/thrift")) {
                            z = true;
                        }
                        boolean z2 = AnalyticsConstants.UM_DEBUG;
                        if (responseCode != 200 || !z) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e2) {
                                    UMCrashManager.reportCrash(this.c, e2);
                                }
                            }
                            if (str != 0) {
                                try {
                                    str.getInputStream().close();
                                } catch (IOException e3) {
                                }
                                str.disconnect();
                            }
                            return null;
                        }
                        InputStream inputStream = str.getInputStream();
                        try {
                            byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                            HelperUtils.safeClose(inputStream);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e4) {
                                    UMCrashManager.reportCrash(this.c, e4);
                                }
                            }
                            if (str != 0) {
                                try {
                                    str.getInputStream().close();
                                } catch (IOException e5) {
                                }
                                str.disconnect();
                            }
                            return streamToByteArray;
                        } catch (Throwable th) {
                            HelperUtils.safeClose(inputStream);
                            throw th;
                        }
                    } catch (UnknownHostException e6) {
                        UMLog.aq("A_10200", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e7) {
                                UMCrashManager.reportCrash(this.c, e7);
                            }
                        }
                        if (str != 0) {
                            try {
                                str.getInputStream().close();
                            } catch (IOException e8) {
                            }
                            str.disconnect();
                        }
                        return null;
                    } catch (SSLHandshakeException e9) {
                        UMLog.aq("A_10201", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e10) {
                                UMCrashManager.reportCrash(this.c, e10);
                            }
                        }
                        if (str != 0) {
                            try {
                                str.getInputStream().close();
                            } catch (IOException e11) {
                            }
                            str.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e12) {
                                UMCrashManager.reportCrash(this.c, e12);
                            }
                        }
                        if (str != 0) {
                            try {
                                str.getInputStream().close();
                            } catch (IOException e13) {
                            }
                            str.disconnect();
                        }
                        return null;
                    }
                } catch (UnknownHostException e14) {
                    outputStream = null;
                } catch (SSLHandshakeException e15) {
                    outputStream = null;
                } catch (Throwable th3) {
                    outputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream3 = outputStream2;
            }
        } catch (UnknownHostException e16) {
            str = 0;
            outputStream = null;
        } catch (SSLHandshakeException e17) {
            str = 0;
            outputStream = null;
        } catch (Throwable th5) {
            str = 0;
            outputStream = null;
        }
    }
}
