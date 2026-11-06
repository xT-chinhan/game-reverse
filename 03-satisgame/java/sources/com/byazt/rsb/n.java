package com.byazt.rsb;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.byazt.vf.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 590, 19})
public class n implements u {
    @Override // com.byazt.vf.u
    public void n(String str, String str2) {
    }

    @Override // com.byazt.vf.u
    public String n(String str) {
        return l(str);
    }

    @Override // com.byazt.vf.u
    public int qg(String str) {
        String strL = l(str);
        if (TextUtils.isEmpty(strL)) {
            return 0;
        }
        try {
            return Integer.parseInt(strL);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.byazt.vf.u
    public long s(String str) {
        String strL = l(str);
        if (TextUtils.isEmpty(strL)) {
            return 0L;
        }
        try {
            return Long.parseLong(strL);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.byazt.vf.u
    public boolean q(String str) {
        String strL = l(str);
        if (TextUtils.isEmpty(strL)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(strL);
        } catch (Exception unused) {
            return false;
        }
    }

    private String l(String str) {
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
                        k.n("SystemPropAdb", "Exception while closing InputStream", e);
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
                        k.n("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
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
                                k.n("SystemPropAdb", "Exception while closing InputStream", e2);
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
