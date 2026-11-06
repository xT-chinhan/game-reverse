package com.bytedance.sdk.openadsdk.ats.ms;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.d.ah {
    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(5)
    public void ms(String str, String str2) {
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(1)
    public String ms(String str) {
        return ka(str);
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(2)
    public int xr(String str) {
        String strKa = ka(str);
        if (TextUtils.isEmpty(strKa)) {
            return 0;
        }
        try {
            return Integer.parseInt(strKa);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(3)
    public long ah(String str) {
        String strKa = ka(str);
        if (TextUtils.isEmpty(strKa)) {
            return 0L;
        }
        try {
            return Long.parseLong(strKa);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(4)
    public boolean d(String str) {
        String strKa = ka(str);
        if (TextUtils.isEmpty(strKa)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(strKa);
        } catch (Exception unused) {
            return false;
        }
    }

    private String ka(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        sl.ah("SystemPropAdb", "Exception while closing InputStream", e);
                    }
                    if (processExec != null) {
                        try {
                            processExec.destroy();
                        } catch (Throwable unused) {
                        }
                    }
                    return line;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        sl.ah("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                        if (processExec == null) {
                            return "";
                        }
                        try {
                            return "";
                        } catch (Throwable unused2) {
                            return "";
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                sl.ah("SystemPropAdb", "Exception while closing InputStream", e2);
                            }
                        }
                        if (processExec != null) {
                            try {
                                processExec.destroy();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
    }
}
