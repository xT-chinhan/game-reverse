package com.byazt.cm;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.vkw.er;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1395, 37})
public class pr implements er {
    @Override // com.byazt.vkw.er
    public String pr(String str) {
        return c(str);
    }

    @Override // com.byazt.vkw.er
    public int hw(String str) {
        String strC = c(str);
        if (!TextUtils.isEmpty(strC)) {
            try {
                return Integer.parseInt(strC);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    @Override // com.byazt.vkw.er
    public long hn(String str) {
        String strC = c(str);
        if (!TextUtils.isEmpty(strC)) {
            try {
                return Long.parseLong(strC);
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.byazt.vkw.er
    public boolean x(String str) {
        String strC = c(str);
        if (!TextUtils.isEmpty(strC)) {
            try {
                return Boolean.parseBoolean(strC);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // com.byazt.vkw.er
    public void pr(String str, String str2) {
    }

    private String c(String str) {
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
                        ho.pr("SystemPropAdb", "Exception while closing InputStream", e);
                    }
                    if (processExec != null) {
                        try {
                            processExec.destroy();
                        } catch (Throwable th2) {
                        }
                    }
                    return line;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        ho.pr("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                        if (processExec != null) {
                            try {
                                return "";
                            } catch (Throwable th4) {
                                return "";
                            }
                        }
                        return "";
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                ho.pr("SystemPropAdb", "Exception while closing InputStream", e2);
                            }
                        }
                        if (processExec != null) {
                            try {
                                processExec.destroy();
                            } catch (Throwable th5) {
                            }
                        }
                    }
                }
            } catch (Throwable th6) {
                bufferedReader = null;
                th = th6;
            }
        } catch (Throwable th7) {
            bufferedReader = null;
            th = th7;
            processExec = null;
        }
    }
}
