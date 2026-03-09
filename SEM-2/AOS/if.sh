read -p "Enter a number : " num1
if [ $num1 -gt 0 ]; then
    echo "Number is positive"
elif [ $num1 -lt 0  ]; then
    echo "Number is negative"
else
    echo "Number is zero"
fi