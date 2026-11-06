package c1m.m2a.m1g;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public final class l implements f {
    private static final Handler a = new Handler(Looper.getMainLooper());

    class a implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ k b;

        a(l lVar, e eVar, k kVar) {
            this.a = eVar;
            this.b = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    class b implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ k b;

        b(l lVar, e eVar, k kVar) {
            this.a = eVar;
            this.b = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b.b(), this.b.a());
        }
    }

    private static class c {
        private static final l a = new l(null);
    }

    private l() {
    }

    /* synthetic */ l(a aVar) {
        this();
    }

    public static f a() {
        return c.a;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x01e8 A[PHI: r4 r5 r8 r12 r13
      0x01e8: PHI (r4v7 java.net.HttpURLConnection) = (r4v5 java.net.HttpURLConnection), (r4v8 java.net.HttpURLConnection) binds: [B:125:0x01c2, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE]
      0x01e8: PHI (r5v7 java.io.OutputStream) = (r5v5 java.io.OutputStream), (r5v8 java.io.OutputStream) binds: [B:125:0x01c2, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE]
      0x01e8: PHI (r8v5 java.io.BufferedReader) = (r8v3 java.io.BufferedReader), (r8v6 java.io.BufferedReader) binds: [B:125:0x01c2, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE]
      0x01e8: PHI (r12v13 int) = (r12v11 int), (r12v17 int) binds: [B:125:0x01c2, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE]
      0x01e8: PHI (r13v5 java.lang.String) = (r13v3 java.lang.String), (r13v6 java.lang.String) binds: [B:125:0x01c2, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:162:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x018b  */
    private <T> k<T> a(i iVar, h<T> hVar) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        int i;
        String str;
        String strF;
        String string;
        Object objA;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(iVar.b()).openConnection();
                try {
                    httpURLConnection.setRequestMethod(iVar.c());
                    httpURLConnection.setConnectTimeout(iVar.d());
                    httpURLConnection.setReadTimeout(iVar.a());
                    Map<String, String> mapE = iVar.e();
                    if (mapE != null && mapE.size() > 0) {
                        for (Map.Entry<String, String> entry : mapE.entrySet()) {
                            if (entry.getKey() != null && entry.getValue() != null) {
                                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    boolean z = false;
                    if ("POST".equals(iVar.c())) {
                        strF = iVar.f();
                        if (strF != null) {
                            httpURLConnection.setDoOutput(true);
                            z = true;
                        }
                    } else {
                        httpURLConnection.setDoOutput(false);
                        strF = null;
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    if (z) {
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(strF.getBytes());
                            outputStream.flush();
                        } catch (ClassCastException e) {
                            e = e;
                            bufferedReader = null;
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            i = 1001;
                            str = "parse data exception";
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return new n(i, str, null);
                        } catch (JSONException e4) {
                            e = e4;
                            bufferedReader = null;
                            e.printStackTrace();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            i = 1001;
                            str = "parse data exception";
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return new n(i, str, null);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            th.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            i = 1000;
                            str = "network abnormal";
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return new n(i, str, null);
                        }
                    } else {
                        outputStream = null;
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        try {
                            if (responseCode == 200) {
                                StringBuilder sb = new StringBuilder();
                                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Charset.forName("UTF-8")));
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    sb.append(line);
                                }
                                string = sb.toString();
                                if (!string.isEmpty()) {
                                    Object objNextValue = new JSONTokener(string).nextValue();
                                    if (objNextValue instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) objNextValue;
                                        if (jSONObject.has("return_code")) {
                                            responseCode = jSONObject.optInt("return_code");
                                            string = jSONObject.has("return_msg") ? jSONObject.optString("return_msg") : "";
                                            if (jSONObject.has("data")) {
                                                if (hVar != null) {
                                                    String strOptString = jSONObject.optString("data");
                                                    if (hVar.a()) {
                                                        Object objNextValue2 = new JSONTokener(strOptString).nextValue();
                                                        if (objNextValue2 instanceof JSONObject) {
                                                            objA = hVar.a((JSONObject) objNextValue2);
                                                        } else if (objNextValue2 instanceof JSONArray) {
                                                            objA = hVar.a((JSONArray) objNextValue2);
                                                        }
                                                    } else {
                                                        objA = hVar.a(strOptString);
                                                    }
                                                } else {
                                                    try {
                                                        objA = jSONObject.opt("data");
                                                    } catch (Throwable th2) {
                                                        th2.printStackTrace();
                                                        objA = null;
                                                    }
                                                }
                                            }
                                        } else if (hVar != null) {
                                            objA = hVar.a(jSONObject);
                                        }
                                    } else if (objNextValue instanceof JSONArray) {
                                        JSONArray jSONArray = (JSONArray) objNextValue;
                                        if (hVar != null) {
                                            objA = hVar.a(jSONArray);
                                        }
                                    }
                                }
                                n nVar = new n(responseCode, string, objA);
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                bufferedReader.close();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return nVar;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), Charset.forName("UTF-8")));
                            while (true) {
                                String line2 = bufferedReader.readLine();
                                if (line2 == null) {
                                    break;
                                }
                                sb2.append(line2);
                            }
                            string = sb2.toString();
                            bufferedReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        objA = null;
                        n nVar2 = new n(responseCode, string, objA);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return nVar2;
                    } catch (ClassCastException e9) {
                        e = e9;
                        e.printStackTrace();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i = 1001;
                        str = "parse data exception";
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return new n(i, str, null);
                    } catch (JSONException e10) {
                        e = e10;
                        e.printStackTrace();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i = 1001;
                        str = "parse data exception";
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return new n(i, str, null);
                    } catch (Throwable th3) {
                        th = th3;
                        th.printStackTrace();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i = 1000;
                        str = "network abnormal";
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return new n(i, str, null);
                    }
                } catch (ClassCastException e11) {
                    e = e11;
                    outputStream = null;
                    bufferedReader = null;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    i = 1001;
                    str = "parse data exception";
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new n(i, str, null);
                } catch (JSONException e12) {
                    e = e12;
                    outputStream = null;
                    bufferedReader = null;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    i = 1001;
                    str = "parse data exception";
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new n(i, str, null);
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                if (httpURLConnection == null) {
                    throw th5;
                }
                httpURLConnection.disconnect();
                throw th5;
            }
        } catch (ClassCastException e15) {
            e = e15;
            httpURLConnection = null;
            outputStream = null;
            bufferedReader = null;
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            i = 1001;
            str = "parse data exception";
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return new n(i, str, null);
        } catch (JSONException e16) {
            e = e16;
            httpURLConnection = null;
            outputStream = null;
            bufferedReader = null;
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            i = 1001;
            str = "parse data exception";
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return new n(i, str, null);
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            outputStream = null;
        }
    }

    @Override // c1m.m2a.m1g.f
    public <T> void a(j jVar, e<k<T>> eVar) {
        Handler handler;
        Runnable bVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new UnsupportedOperationException("can't request in main thread");
        }
        k<T> kVarA = a(jVar.a(), (h) null);
        if (eVar != null) {
            if (kVarA.b() == 200) {
                handler = a;
                bVar = new a(this, eVar, kVarA);
            } else {
                handler = a;
                bVar = new b(this, eVar, kVarA);
            }
            handler.post(bVar);
        }
    }
}
