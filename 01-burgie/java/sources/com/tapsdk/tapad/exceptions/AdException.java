package com.tapsdk.tapad.exceptions;

import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class AdException extends Throwable {
    public int code;
    public String detail;
    public String message;
    public ServerErrorDetail serverError;
    public String sessionId;
    public long timestamp;

    public static class ServerErrorDetail {
        public final Map<String, Object> extra;
        public final int serverCode;
        public final String serverMessage;

        public ServerErrorDetail(int i, String str, Map<String, Object> map) {
            this.serverCode = i;
            this.serverMessage = str;
            this.extra = (map == null || map.isEmpty()) ? null : map;
        }

        public String toString() {
            return "ServerErrorDetail{serverCode=" + this.serverCode + ", serverMessage='" + this.serverMessage + "', extra=" + this.extra + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public AdException(int i, String str) {
        this(i, str, null, null, System.currentTimeMillis(), null);
    }

    private static String resolveTopLevelMessage(Throwable th) {
        if (th == null) {
            return ErrorCodeEnum.UNKNOWN_ERROR.getDesc();
        }
        String message = th.getMessage();
        return (message == null || message.length() <= 0) ? th.toString() : message;
    }

    private static String stackTraceAsString(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        } catch (Throwable th2) {
            return th.toString();
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AdException{code=" + this.code + ", message='" + this.message + "', detail='" + this.detail + "', sessionId='" + this.sessionId + "', timestamp=" + this.timestamp + ", serverError=" + this.serverError + AbstractJsonLexerKt.END_OBJ;
    }

    public AdException(int i, String str, String str2, String str3, long j, ServerErrorDetail serverErrorDetail) {
        super(str);
        this.code = i;
        this.message = str == null ? ErrorCodeEnum.fromCode(i).getDesc() : str;
        this.detail = str2;
        this.sessionId = str3;
        this.timestamp = j;
        this.serverError = serverErrorDetail;
    }

    public AdException(Throwable th) {
        String strResolveTopLevelMessage;
        super(resolveTopLevelMessage(th));
        this.timestamp = System.currentTimeMillis();
        this.code = Constants.AdError.ERROR_CODE_UNKNOWN;
        if (th != null && th.getMessage() != null) {
            strResolveTopLevelMessage = th.getMessage();
        } else {
            strResolveTopLevelMessage = resolveTopLevelMessage(th);
        }
        this.message = strResolveTopLevelMessage;
        this.detail = stackTraceAsString(th);
        this.serverError = null;
        this.sessionId = null;
    }
}
