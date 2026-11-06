package com.tapsdk.tapad.lottie.parser;

/* JADX INFO: loaded from: classes3.dex */
class CircleShapeParser {
    private CircleShapeParser() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0023  */
    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x006a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0068 -> B:35:0x006a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:41:0x005a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static com.tapsdk.tapad.lottie.model.content.CircleShape parse(android.util.JsonReader r9, com.tapsdk.tapad.lottie.LottieComposition r10, int r11) {
        /*
            r0 = 0
            r1 = 1
            r2 = 3
            r3 = 0
            if (r11 != r2) goto La
            r11 = r3
            r4 = r11
            goto L6a
        La:
            r11 = r3
            r4 = r11
        Lc:
            r5 = r0
        Ld:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L6c
            java.lang.String r6 = r9.nextName()
            r6.getClass()
            r7 = -1
            int r8 = r6.hashCode()
            switch(r8) {
                case 100: goto L44;
                case 112: goto L39;
                case 115: goto L2e;
                case 3519: goto L23;
                default: goto L22;
            }
        L22:
            goto L4e
        L23:
            java.lang.String r8 = "nm"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L2c
            goto L22
        L2c:
            r7 = r2
            goto L4e
        L2e:
            java.lang.String r8 = "s"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L37
            goto L22
        L37:
            r7 = 2
            goto L4e
        L39:
            java.lang.String r8 = "p"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L42
            goto L22
        L42:
            r7 = r1
            goto L4e
        L44:
            java.lang.String r8 = "d"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L4d
            goto L22
        L4d:
            r7 = r0
        L4e:
            switch(r7) {
                case 0: goto L64;
                case 1: goto L5f;
                case 2: goto L5a;
                case 3: goto L55;
                default: goto L51;
            }
        L51:
            r9.skipValue()
            goto Ld
        L55:
            java.lang.String r3 = r9.nextString()
            goto Ld
        L5a:
            com.tapsdk.tapad.lottie.model.animatable.AnimatablePointValue r4 = com.tapsdk.tapad.lottie.parser.AnimatableValueParser.parsePoint(r9, r10)
            goto Ld
        L5f:
            com.tapsdk.tapad.lottie.model.animatable.AnimatableValue r11 = com.tapsdk.tapad.lottie.parser.AnimatablePathValueParser.parseSplitPath(r9, r10)
            goto Ld
        L64:
            int r5 = r9.nextInt()
            if (r5 != r2) goto Lc
        L6a:
            r5 = r1
            goto Ld
        L6c:
            com.tapsdk.tapad.lottie.model.content.CircleShape r9 = new com.tapsdk.tapad.lottie.model.content.CircleShape
            r9.<init>(r3, r11, r4, r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapsdk.tapad.lottie.parser.CircleShapeParser.parse(android.util.JsonReader, com.tapsdk.tapad.lottie.LottieComposition, int):com.tapsdk.tapad.lottie.model.content.CircleShape");
    }
}
