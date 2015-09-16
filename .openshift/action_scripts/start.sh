#!/bin/bash
cd $OPENSHIFT_REPO_DIR
nohup java -jar target/Airline-1.0-SNAPSHOT.jar --server.port=${OPENSHIFT_DIY_PORT} --server.address=${OPENSHIFT_DIY_IP} &