#include <iostream>
#include <string>
using namespace std;

// template are used to create generic class or function
// example of generic function
template <typename T, typename T2>
T add(T a, T2 b)
{
    T c = a + " " + to_string(b);
    return c;
}

// Generic class

template <typename T, typename T2>
class Bluetooth
{
public:
    T a;
    T2 b;
    Bluetooth(T a, T2 b)
    {

        //(*this) this pointer point to current object we assing second way to this pointer
        // this -> a = a;
        (*this).a = a;
        (*this).b = b;
    }

    T display()
    {  
        return a + b;
    }
};
int main()
{

    cout << add<string, int>("hello", 45) << endl;
    // class object
    Bluetooth<string, string> obj("hello", "world");
    cout << obj.display() << endl;
    Bluetooth<int , int>obj1(856, 4625);
    cout<< obj1.display()<<endl;
    return 0;
}