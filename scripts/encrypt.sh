#!/usr/bin/env bash

set -o pipefail

IN=$1
OUT=$2

# Start encrypting
echo "Encrypting ${IN} to ${OUT}"

gpg -o "${OUT}" --symmetric --cipher-algo AES256 "${IN}"
