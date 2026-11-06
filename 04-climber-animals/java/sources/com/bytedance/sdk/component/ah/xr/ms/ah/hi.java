package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.i;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class hi {
    public final String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final i f1062ms;
    public final int xr;

    public hi(i iVar, int i, String str) {
        this.f1062ms = iVar;
        this.xr = i;
        this.ah = str;
    }

    public static hi ms(String str) throws IOException {
        i iVar;
        int i;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                iVar = i.HTTP_1_0;
            } else if (iCharAt == 1) {
                iVar = i.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            iVar = i.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new hi(iVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1062ms == i.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ').append(this.xr);
        if (this.ah != null) {
            sb.append(' ').append(this.ah);
        }
        return sb.toString();
    }
}
