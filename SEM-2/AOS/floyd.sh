#!/bin/bash

# Floyd's Triangle
read -p "Enter number of rows: " n

num=1
for ((i=1; i<=n; i++)); do
    for ((j=1; j<=i; j++)); do
        printf "%d " $num
        ((num++))
    done
    echo
done