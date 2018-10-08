#!/usr/bin/env bash
PROCESS=`ps -ef|grep "coupons-server-deploy-prod.jar"|grep -v grep|grep -v PPID|awk '{ print $2}'`
for i in $PROCESS
do
  sudo kill -15 $i
done