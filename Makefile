BUILD_TYPE ?= Debug

.PHONY: all assemble bundle clean coverage dependencies format lint local publish test

all: clean format lint test coverage assemble

assemble:
	./gradlew assemble${BUILD_TYPE} ${GRADLE_ARGS}

bundle:
	./gradlew bundle${BUILD_TYPE} ${GRADLE_ARGS}

clean:
	./gradlew clean ${GRADLE_ARGS}

coverage:
	./gradlew koverMergedReport

dependencies:
	./gradlew dependencyUpdates ${GRADLE_ARGS}

format:
	./gradlew formatKotlin ${GRADLE_ARGS}

lint:
	./gradlew lint${BUILD_TYPE} lintKotlin detekt ${GRADLE_ARGS}

local:
	./gradlew publishToMavenLocal ${GRADLE_ARGS}

publish:
	./gradlew publish

test:
	./gradlew test${BUILD_TYPE}UnitTest ${GRADLE_ARGS}
