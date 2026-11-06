package com.mar.sdk.utils;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class BASE64Decoder extends CharacterDecoder {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] pem_convert_array = new byte[256];
    byte[] decode_buffer = new byte[4];

    @Override // com.mar.sdk.utils.CharacterDecoder
    protected int bytesPerAtom() {
        return 4;
    }

    @Override // com.mar.sdk.utils.CharacterDecoder
    protected int bytesPerLine() {
        return 72;
    }

    static {
        for (int i = 0; i < 255; i++) {
            pem_convert_array[i] = -1;
        }
        for (int i2 = 0; i2 < pem_array.length; i2++) {
            pem_convert_array[pem_array[i2]] = (byte) i2;
        }
    }

    @Override // com.mar.sdk.utils.CharacterDecoder
    protected void decodeAtom(PushbackInputStream inStream, OutputStream outStream, int rem) throws IOException {
        byte a = -1;
        byte b = -1;
        byte c = -1;
        byte d = -1;
        if (rem < 2) {
            throw new CEFormatException("BASE64Decoder: Not enough bytes for an atom.");
        }
        while (true) {
            int i = inStream.read();
            if (i == -1) {
                throw new CEStreamExhausted();
            }
            if (i != 10 && i != 13) {
                this.decode_buffer[0] = (byte) i;
                if (readFully(inStream, this.decode_buffer, 1, rem - 1) == -1) {
                    throw new CEStreamExhausted();
                }
                if (rem > 3 && this.decode_buffer[3] == 61) {
                    rem = 3;
                }
                if (rem > 2 && this.decode_buffer[2] == 61) {
                    rem = 2;
                }
                switch (rem) {
                    case 4:
                        d = pem_convert_array[this.decode_buffer[3] & UByte.MAX_VALUE];
                    case 3:
                        c = pem_convert_array[this.decode_buffer[2] & UByte.MAX_VALUE];
                    case 2:
                        b = pem_convert_array[this.decode_buffer[1] & UByte.MAX_VALUE];
                        a = pem_convert_array[this.decode_buffer[0] & UByte.MAX_VALUE];
                        break;
                }
                switch (rem) {
                    case 2:
                        outStream.write((byte) (((a << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b >>> 4) & 3)));
                        return;
                    case 3:
                        outStream.write((byte) (((a << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b >>> 4) & 3)));
                        outStream.write((byte) (((b << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((c >>> 2) & 15)));
                        return;
                    case 4:
                        outStream.write((byte) (((a << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b >>> 4) & 3)));
                        outStream.write((byte) (((b << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((c >>> 2) & 15)));
                        outStream.write((byte) (((c << 6) & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) | (d & 63)));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
