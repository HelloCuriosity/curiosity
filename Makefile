BUILD_TYPE ?= Debug
GRADLE_ARGS ?= --build-cache

.PHONY: all assemble bundle clean dependencies format lint local publish \
release report signing test

all: clean format lint test report assemble

assemble:
	./gradlew assemble${BUILD_TYPE} ${GRADLE_ARGS}

bundle:
	./gradlew bundle${BUILD_TYPE} ${GRADLE_ARGS}

clean:
	./gradlew clean ${GRADLE_ARGS}

dependencies:
	./gradlew dependencyUpdates ${GRADLE_ARGS}

format:
	./gradlew formatKotlin ${GRADLE_ARGS}

lint:
	./gradlew lint${BUILD_TYPE} lintKotlin detekt ${GRADLE_ARGS}

local:
	./gradlew publishToMavenLocal ${GRADLE_ARGS}

publish:
	./scripts/publish.sh ${BUILD_TYPE} ${PLAY_PUBLISH_PASSWORD}

release:
	./scripts/release.sh ${BUMP}

report:
	./gradlew koverMergedReport

signing:
	./scripts/signing.sh

test:
	./gradlew test${BUILD_TYPE}UnitTest ${GRADLE_ARGS}
