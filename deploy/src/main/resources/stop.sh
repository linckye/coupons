#!/usr/bin/env bash
nohup java -Xmx2G -Xms2G -XX:-OmitStackTraceInFastThrow -XX:-HeapDumpOnOutOfMemoryError -jar coupons-server-deploy-prod.jar &