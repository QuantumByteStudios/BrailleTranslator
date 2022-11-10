#!/bin/bash

# NOTE : YOU CAN MANUALLY COMPILE AND RUN

if ! [ -x "$(command -v java)" ]; then
  echo 'Error: java is not installed.' >&2
  exit 1
fi
if ! [ -x "$(command -v javac)" ]; then
  echo 'Error: javac is not installed.' >&2
  exit 1
fi
clear
javac main.java
java main
