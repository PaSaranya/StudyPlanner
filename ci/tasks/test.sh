#!/bin/bash

set -ex
apt-get update && apt-get install -y maven
pushd repo
  echo "Fetching Dependencies"
  mvn clean compile > /dev/null

  echo "Running Tests"
  mvn test
popd

exit 0