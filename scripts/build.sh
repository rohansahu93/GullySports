#!/bin/bash
set -e
./gradlew -x test check
./gradlew runUnitTests
./gradlew -x test build
mkdir -p dist/libs
cp build/libs/pricing*jar dist/libs/pricing.jar
