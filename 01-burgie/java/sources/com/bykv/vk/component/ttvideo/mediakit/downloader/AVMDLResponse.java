package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.text.TextUtils;
import com.byazt.nzn.hw;
import com.byazt.nzn.nt;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public hw call;
    public long readOff;
    public AVMDLRequest request;
    public nt response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, nt ntVar, hw hwVar) {
        this.request = aVMDLRequest;
        this.response = ntVar;
        this.call = hwVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        nt ntVar = this.response;
        if (ntVar == null) {
            return;
        }
        int iHn = ntVar.hn();
        this.statusCode = iHn;
        if (iHn == 200) {
            this.contentlength = toInt(this.response.pr(Util.CONTENT_LENGTH));
            return;
        }
        if (iHn == 206) {
            String strPr = this.response.pr(Util.CONTENT_RANGE);
            if (!TextUtils.isEmpty(strPr) && (iLastIndexOf = strPr.lastIndexOf("/")) >= 0 && iLastIndexOf < strPr.length() - 1) {
                this.contentlength = toInt(strPr.substring(iLastIndexOf + 1), -1);
            }
        }
    }

    public int readData(byte[] bArr) {
        if (this.response.uc() == null) {
            return 0;
        }
        try {
            int i = this.response.uc().hn().read(bArr);
            if (i > 0) {
                String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
                long j = i;
                this.readOff += j;
                this.request.reqOff += j;
                if (this.request.size > 0) {
                    this.request.size -= j;
                }
                String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
                return i;
            }
            return -1;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        hw hwVar = this.call;
        if (hwVar != null) {
            hwVar.hn();
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
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
