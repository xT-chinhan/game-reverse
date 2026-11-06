package com.tapadn.protobuf;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int i);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(final ByteString byteString) {
        return escapeBytes(new ByteSequence() { // from class: com.tapadn.protobuf.TextFormatEscaper.1
            @Override // com.tapadn.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i) {
                return byteString.byteAt(i);
            }

            @Override // com.tapadn.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return byteString.size();
            }
        });
    }

    static String escapeBytes(ByteSequence byteSequence) {
        String str;
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i = 0; i < byteSequence.size(); i++) {
            int iByteAt = byteSequence.byteAt(i);
            if (iByteAt == 34) {
                str = "\\\"";
            } else if (iByteAt == 39) {
                str = "\\'";
            } else if (iByteAt != 92) {
                switch (iByteAt) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (iByteAt < 32 || iByteAt > 126) {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((iByteAt >>> 6) & 3) + 48));
                            sb.append((char) (((iByteAt >>> 3) & 7) + 48));
                            iByteAt = (iByteAt & 7) + 48;
                        }
                        sb.append((char) iByteAt);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static String escapeBytes(final byte[] bArr) {
        return escapeBytes(new ByteSequence() { // from class: com.tapadn.protobuf.TextFormatEscaper.2
            @Override // com.tapadn.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i) {
                return bArr[i];
            }

            @Override // com.tapadn.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return bArr.length;
            }
        });
    }

    static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }
}
