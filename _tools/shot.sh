#!/bin/bash
# chụp màn Waydroid -> $1 (mật khẩu sudo lấy từ biến PW)
S(){ if [ -n "$PW" ]; then echo "$PW" | sudo -S -p '' "$@"; else sudo "$@"; fi; }
~/game/_tools/w.sh screencap -p /data/local/tmp/s.png >/dev/null
S cp "$HOME/.local/share/waydroid/data/local/tmp/s.png" "$1"
S chown "$(id -un)" "$1"
