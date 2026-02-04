#!/bin/bash

add() {
    result=$(( numb1 + numb2 ))
    echo "$numb1 + $numb2 = $result"
}

difference() {
    result=$(( numb1 - numb2 ))
    echo "$numb1 - $numb2 = $result"
}

multiply() {
    result=$(( numb1 * numb2 ))
    echo "$numb1 * $numb2 = $result"
}

divide() {
    if [ "$numb2" -eq 0 ]; then
        echo "Zero is not divisible."
    else
        result=$(( numb1 / numb2 ))
        echo "$numb1 / $numb2 = $result"
    fi
}
