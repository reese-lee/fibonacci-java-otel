#!/bin/bash

while :
do
  echo "Calling fibonacci-java with n=24"
  curl http://localhost:8080/fibonacci?n=24 || true
  echo

  echo "Calling fibonacci-java with n=99"
  curl http://localhost:8080/fibonacci?n=99 || true
  echo

  echo "Calling fibonacci-java with n=47"
  curl http://localhost:8080/fibonacci?n=47 || true
  echo

  echo "Calling fibonacci-java with n=63"
  curl http://localhost:8080/fibonacci?n=63 || true
  echo

  sleep 2
done