#!/usr/bin/env bash

set -euo pipefail

BUILD_TYPE="${1:-Release}"
PLAY_PUBLISH_PASSWORD="${2:-}"

REPO_DIR="$(cd "$(dirname "$0")/../" && pwd)"

# Read by the Play Publisher plugin via rootProject.file(...) in app/build.gradle.kts
PLAY_CREDENTIALS="pc-api-6516078326128720260-777-76bc229fe079.json"

# Verify decrypting password
if [[ -z "${PLAY_PUBLISH_PASSWORD}" ]]; then
	echo "No password given. Abort"
	exit 1
fi

# Create Google Play json for publishing
echo "Creating Google Play Publish json"
"${REPO_DIR}"/scripts/decrypt.sh \
    "${REPO_DIR}/${PLAY_CREDENTIALS}.aes-256-cbc.enc.b64" \
    "${REPO_DIR}/${PLAY_CREDENTIALS}" \
    "${PLAY_PUBLISH_PASSWORD}"

echo "Publishing Bundle Version: ${VERSION:-local}"
"${REPO_DIR}"/gradlew -p "$REPO_DIR" publish"${BUILD_TYPE}"Bundle --info
