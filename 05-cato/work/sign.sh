#!/bin/bash
# sign.sh <unsigned.apk> <out.apk>
set -e
zipalign -p -f 4 "$1" "$1.al" && apksigner sign --ks ~/game/_tools/debug.keystore --ks-pass pass:android --key-pass pass:android --out "$2" "$1.al" && rm -f "$1" "$1.al" "$2.idsig"; apksigner verify "$2" && echo SIGNED "$2"
