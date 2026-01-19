#include <iostream>
using namespace std;

int main()
{
    int number, count = 0;
    cout << "Enter any number chek is prime or not\n";
    // a prime number is divide by itself number or 1 only and 1 is not a prime number

    cin >> number;
    if (number <= 1)
    {
        cout << "Enter only positive number or greater than 1\n";
    }

    for (int i = 2; i <= number; i++)
    {
        if (number % i == 0)
            count++;
        }
    }
    if (count == 1)
    {
        cout << "Prime number = " << number;
    }
    else
    {
        cout << "Not a prime number = " << number;
    }
    return 0;
}