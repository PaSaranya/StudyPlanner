#!/bin/bash

set -ex

pushd repo
  echo "Fetching Dependencies"
  mvn clean compile > /dev/null

  echo "Running Tests"
  mvn test
popd

exit 0