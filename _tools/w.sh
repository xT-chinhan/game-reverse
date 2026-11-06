#!/bin/bash
# chạy lệnh trong Waydroid; đi qua pipe để lxc-attach không chown file output
# mật khẩu sudo lấy từ biến PW (không đặt thì sudo tự hỏi)
S(){ if [ -n "$PW" ]; then echo "$PW" | sudo -S -p '' "$@"; else sudo "$@"; fi; }
S waydroid shell -- "$@" 2>&1 | cat
