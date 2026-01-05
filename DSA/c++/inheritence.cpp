#include <iostream>
using namespace std;
#include <string>


class MyClass {
  public:
    void myFunction() {
      cout << "Some content in parent class." ;
    }
};

// Derived class (child)
class MyChild: public MyClass {
    public:
    MyChild()
    {
    myFunction();
    }
};

// Derived class (grandchild)
class MyGrandChild: public MyChild {
};
int main()
{
 MyGrandChild myObj;
  myObj.myFunction();
  

    return 0;
}