#!/usr/bin/env bash

set -o pipefail

BUILD_TYPE="${1-Release}"

REPO_DIR="$(cd "$(dirname "$0")/../" && pwd)"

# Create Version
git fetch --force --tags
TAG=$(git tag --sort=committerdate | tail -1)

export VERSION="$TAG"
echo "Publishing Release: $VERSION"

# Publish
"${REPO_DIR}"/gradlew assemble"${BUILD_TYPE}" publish
