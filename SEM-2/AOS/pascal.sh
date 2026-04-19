#!/bin/bash

# Pascal's Triangle
read -p "Enter number of rows: " n

for ((i=0; i<n; i++)); do
    val=1
    for ((j=0; j<=i; j++)); do
        printf "%d " $val
        val=$((val * (i - j) / (j + 1)))
    done
    echo
done