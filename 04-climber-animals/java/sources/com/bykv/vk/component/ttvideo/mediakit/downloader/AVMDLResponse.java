package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.xr;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public xr call;
    public long readOff;
    public AVMDLRequest request;
    public ao response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, ao aoVar, xr xrVar) {
        this.request = aVMDLRequest;
        this.response = aoVar;
        this.call = xrVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        ao aoVar = this.response;
        if (aoVar == null) {
            return;
        }
        int iAh = aoVar.ah();
        this.statusCode = iAh;
        if (iAh == 200) {
            this.contentlength = toInt(this.response.ms("Content-Length"));
            return;
        }
        if (iAh == 206) {
            String strMs = this.response.ms("Content-Range");
            if (TextUtils.isEmpty(strMs) || (iLastIndexOf = strMs.lastIndexOf("/")) < 0 || iLastIndexOf >= strMs.length() - 1) {
                return;
            }
            this.contentlength = toInt(strMs.substring(iLastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) {
        if (this.response.c() == null) {
            return 0;
        }
        try {
            int i = this.response.c().ah().read(bArr);
            if (i <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j = i;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return i;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        xr xrVar = this.call;
        if (xrVar != null) {
            xrVar.xr();
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isFinish() {
        long j = this.request.size >= 0 ? this.request.reqOff + this.request.size : this.contentlength;
        long j2 = this.contentlength;
        if (j > j2) {
            j = j2;
        }
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j));
        return this.readOff >= j;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
