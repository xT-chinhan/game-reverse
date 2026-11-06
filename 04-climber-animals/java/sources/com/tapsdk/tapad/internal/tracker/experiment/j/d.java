package com.tapsdk.tapad.internal.tracker.experiment.j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static <T> List<T> a(byte[] bArr) throws IOException, ClassNotFoundException {
        return (List) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }

    public static <T> boolean a(List<T> list) {
        return list == null || list.isEmpty();
    }

    public static <T> byte[] b(List<T> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(list);
        return byteArrayOutputStream.toByteArray();
    }
}
