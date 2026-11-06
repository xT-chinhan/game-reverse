package com.tapsdk.tapad.internal.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public final class RustResolvedAsset {
    public static final int MAX_HTML_BYTES = 33554432;
    public static final int MAX_LOTTIE_JSON_BYTES = 4194304;

    private RustResolvedAsset() {
    }

    public static boolean isLocalFileUri(String str) {
        try {
            requireLocalFile(str);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String mediaDataSource(String str) {
        try {
            return requireLocalFile(str).getAbsolutePath();
        } catch (IOException e) {
            return str;
        }
    }

    public static byte[] readBounded(String str, int i) throws IOException {
        if (i <= 0) {
            throw new IOException("invalid asset bound");
        }
        File fileRequireLocalFile = requireLocalFile(str);
        long length = fileRequireLocalFile.length();
        if (!fileRequireLocalFile.isFile() || length <= 0 || length > i || length > 2147483647L) {
            throw new IOException("invalid local asset");
        }
        int i2 = (int) length;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        FileInputStream fileInputStream = new FileInputStream(fileRequireLocalFile);
        while (i3 < i2) {
            try {
                int i4 = fileInputStream.read(bArr, i3, i2 - i3);
                if (i4 < 0) {
                    throw new IOException("truncated local asset");
                }
                i3 += i4;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (fileInputStream.read() >= 0) {
            throw new IOException("local asset grew while reading");
        }
        fileInputStream.close();
        return bArr;
    }

    public static String readUtf8Bounded(String str, int i) throws IOException {
        byte[] bounded = readBounded(str, i);
        try {
            CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bounded)).toString();
        } catch (CharacterCodingException e) {
            throw new IOException("invalid UTF-8 asset", e);
        }
    }

    public static File requireLocalFile(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            throw new IOException("empty asset URI");
        }
        try {
            URI uri = new URI(str);
            if ("file".equalsIgnoreCase(uri.getScheme()) && uri.getRawAuthority() == null && uri.getRawQuery() == null && uri.getRawFragment() == null && uri.getPath() != null && !uri.getPath().isEmpty()) {
                return new File(uri);
            }
            throw new IOException("not a canonical local asset URI");
        } catch (IllegalArgumentException | URISyntaxException e) {
            throw new IOException("invalid local asset URI", e);
        }
    }
}
