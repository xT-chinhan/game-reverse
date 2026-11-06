package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static void a(File file, String str, String str2, Map<String, String> map, a aVar) throws Throwable {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.HF().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + string);
                httpURLConnection2.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.gN(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", j.z + w.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), string));
                    }
                    byte[] bytes = ("\r\n--" + string + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(string);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = dataInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else {
                                outputStream.write(bArr, 0, i2);
                            }
                        }
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(bytes);
                        outputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        cVar.code = responseCode;
                        cVar.aEi = responseCode;
                        if (responseCode == 200) {
                            cVar.aEk = h.inputStream2String(httpURLConnection2.getInputStream());
                            try {
                                if (new JSONObject(cVar.aEk).optInt("result", -1) == 1) {
                                    aVar.LY();
                                } else {
                                    e eVar = e.aQK;
                                    aVar.LX();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.aQL;
                                e eVar3 = e.aQL;
                                aVar.LX();
                            }
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aEk);
                        } else {
                            e eVar4 = e.aQJ;
                            new StringBuilder().append(e.aQJ.zb());
                            aVar.LX();
                            com.kwad.sdk.core.network.idc.a.HF().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar5 = e.aQJ;
                            e.getCause();
                            aVar.LX();
                            com.kwad.sdk.core.network.idc.a aVarHF = com.kwad.sdk.core.network.idc.a.HF();
                            if (cVar.code != 0) {
                                i = cVar.code;
                            }
                            aVarHF.a(str3, i, e);
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.aQU)) {
            map.put("uploadToken", fVar.aQU);
        }
        if (!TextUtils.isEmpty(fVar.aQR)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, fVar.aQR);
        }
        if (!TextUtils.isEmpty(fVar.aQQ)) {
            map.put("did", fVar.aQQ);
        }
        if (!TextUtils.isEmpty(fVar.aQP)) {
            map.put("sid", fVar.aQP);
        }
        if (!TextUtils.isEmpty(fVar.aPl)) {
            map.put("appver", fVar.aPl);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.mToken)) {
            map.put("token", fVar.mToken);
        }
        if (!TextUtils.isEmpty(fVar.aQO)) {
            map.put("uid", fVar.aQO);
        }
        if (!TextUtils.isEmpty(fVar.aQS)) {
            map.put(MediationConstant.KEY_EXTRA_INFO, fVar.aQS);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.aQQ, fVar.mToken, a(fVar), aVar);
    }
}
