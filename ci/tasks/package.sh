#!/bin/bash

set -e +x
apt-get update && apt-get install -y maven
pushd repo
  echo "Packaging WAR"
  mvn clean package
popd

war_count=`find repo/target -type f -name *.war | wc -l`

if [ $war_count -gt 1 ]; then
  echo "More than one war found, don't know which one to deploy. Exiting"
  exit 1
fi

find repo/target -type f -name *.war -exec cp "{}" package-output/jStudyPlanner.war \;

echo "Done packaging"
exit 0