package com.efs.sdk.base.core.model;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class LogDto {
    private a a;
    private b b = new b();
    private byte[] c;
    private File d;

    public LogDto(String str, byte b) {
        this.a = new a(str, b);
    }

    public void setUid(String str) {
        this.a.h = str;
    }

    public String getUid() {
        return this.a.h;
    }

    public void setDid(String str) {
        this.a.i = str;
    }

    public String getDid() {
        return this.a.i;
    }

    public void setBeginTime(long j) {
        this.a.j = j;
    }

    public long getBeginTime() {
        return this.a.j;
    }

    public void setEndTime(long j) {
        this.a.k = j;
    }

    public long getEndTime() {
        return this.a.k;
    }

    public int getLogCnt() {
        return this.a.g;
    }

    public void setLogCnt(int i) {
        this.a.g = i;
    }

    public long getBodySize() {
        a();
        return this.a.f;
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.a.f = getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.a.f = getFile().length();
        }
    }

    public boolean isCp() {
        return !"none".equals(this.a.d);
    }

    public void setCp(String str) {
        this.a.d = str;
    }

    public String getCp() {
        return this.a.d;
    }

    public boolean isDe() {
        return 1 != this.a.e;
    }

    public void setDe(int i) {
        this.a.e = i;
        a();
    }

    public int getDe() {
        return this.a.e;
    }

    public byte getLogProtocol() {
        return this.a.b;
    }

    public int getLogBodyType() {
        return this.a.c;
    }

    public void setLogBodyType(int i) {
        this.a.c = i;
    }

    public String getLogType() {
        return this.a.a;
    }

    public byte[] getData() {
        return this.c;
    }

    public void setData(byte[] bArr) {
        this.c = bArr;
        a();
    }

    public File getFile() {
        return this.d;
    }

    public void setFile(File file) {
        this.d = file;
    }

    public void setSendImediately(boolean z) {
        this.b.a = z;
    }

    public boolean isSendImediately() {
        return this.b.a;
    }

    public void setLimitByFlow(boolean z) {
        this.b.b = z;
    }

    public boolean isLimitByFlow() {
        return this.b.b;
    }

    public void setResponseDto(HttpResponse httpResponse) {
        this.b.c = httpResponse;
    }

    public HttpResponse getResponseDto() {
        return this.b.c;
    }

    public static LogDto buildLogDto(ILogProtocol iLogProtocol) {
        LogDto logDto = null;
        try {
            LogDto logDto2 = new LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    logDto2.setLogBodyType(0);
                    logDto2.setData(iLogProtocol.generate());
                    if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto2.getLogType())) {
                        logDto2.setUid(ControllerCenter.getGlobalEnvStruct().getLogUid());
                        logDto2.setDid(ControllerCenter.getGlobalEnvStruct().getLogDid());
                        logDto2.setBeginTime(iLogProtocol.getLogBeginTime());
                        logDto2.setEndTime(iLogProtocol.getLogEndTime());
                    }
                } else if (bodyType == 1) {
                    logDto2.setLogBodyType(1);
                    logDto2.setFile(new File(iLogProtocol.getFilePath()));
                } else {
                    Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                }
                return logDto2;
            } catch (Exception e) {
                e = e;
                logDto = logDto2;
                Log.e("efs.base", "log send error", e);
                return logDto;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
