#!/usr/bin/env bash

set -euo pipefail

BUILD_TYPE="${1:-Release}"

REPO_DIR="$(cd "$(dirname "$0")/../" && pwd)"

echo "Publishing Library Version: ${VERSION:-local}"
"${REPO_DIR}"/gradlew -p "$REPO_DIR" assemble"${BUILD_TYPE}" publishAndReleaseToMavenCentral
