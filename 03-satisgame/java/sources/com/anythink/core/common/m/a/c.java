package com.anythink.core.common.m.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

/* JADX INFO: loaded from: classes.dex */
final class c extends b {
    private final int i;
    private final String j;

    final int a() {
        return this.i;
    }

    private String c() {
        return this.j;
    }

    c(short s, int i, String str) {
        this(s, i, str, (byte) 0);
    }

    private c(short s, int i, String str, byte b) {
        this.e = s;
        this.f = 0;
        this.g = 1;
        this.i = i;
        this.j = str;
    }

    final byte[] b() throws IOException {
        String str = this.j;
        if (str == null || str.length() == 0) {
            throw new IOException("host can not empty");
        }
        if (this.f != 0 && this.f != 1 && this.f != 2 && this.f != 5) {
            throw new IOException("opCode is not valid");
        }
        if (this.g != 0 && this.g != 1) {
            throw new IOException("rd is not valid");
        }
        int i = this.i;
        if (i != 1 && i != 28 && i != 5 && i != 16) {
            throw new IOException("recordType is not valid");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(this.e);
        dataOutputStream.writeByte((this.f << 3) + this.g);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        for (String str2 : this.j.split("[.。．｡]")) {
            if (str2.length() > 63) {
                throw new IOException("host part is too long");
            }
            byte[] bytes = IDN.toASCII(str2).getBytes();
            dataOutputStream.write(bytes.length);
            dataOutputStream.write(bytes, 0, bytes.length);
        }
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(this.i);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        return byteArrayOutputStream.toByteArray();
    }
}
