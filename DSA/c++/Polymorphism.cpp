#include <iostream>
#include <string>
using namespace std;


class Base{
    public:
    void Display()  //virtual keyword is used to avoid base class method to be called
    {
        cout<<"Base class method\n";
    }
};

class Derived: public Base{
    public:
    void Display()
    {
        cout<<"Derived class method";
    }
};
int main()
{
    
    Derived obj;
    // obj.Base::Display();   // first method to be called base class method
    //  obj.Display(); //normal object call our class method not base class method
    Base* B1;
    B1 = &obj;
    // (*B1).Display(); //using dot operator and derefrence pointer 
    // B1->Display(); //using arrow operator 
    return 0;
}