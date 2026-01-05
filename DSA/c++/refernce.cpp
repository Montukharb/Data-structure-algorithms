#include <iostream>
using namespace std;

class Person;
void func(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << endl;
    }
}

void dynamic(int size)
{
    if (size <= 0)
    {
        cout << "size should be greater than 0" << endl;
    }
    else
    {
        int *arr = new int[size];
        cout << "Enter value\n";
        for (int i = 0; i < size; i++)
        {
            cin >> arr[i];
        }

        cout << "print dynamic array value" << endl;
        for (int i = 0; i < size; i++)
        {
            cout << arr[i] << " ";
        }

        delete[] arr; // free memory
    }
}

// auto add = [](){

// };

// return specified lambda funciton
// auto add2 = [](int a, int b) -> double{
//     return (double)a/b;
// };
void createPerson();
int main()
/*************  ✨ Windsurf Command ⭐  *************/
/**
 * @brief Main function
 *
 * This function is the main entry point of the program.
 * It demonstrates the usage of arrays, dynamic memory allocation, pointers, and references.
 * It also tests the equality of addresses and values of variables.
 */
/*******  8ab7e974-95aa-4f7e-b44e-a9bc6bdb02fb  *******/ {
    int arra[5] = {10, 20, 30, 40, 50};
    int size = sizeof(arra) / sizeof(int);

    func(arra, size);
    cout << "Enter the how many memory allocate ";
    int num;
    cin >> num;
    dynamic(num);
    //     int a = 10;

    //     int &b = a;
    //      int pntr = NULL;
    //       cout<<"null pointer value "<<pntr<<endl;
    //     cout<<&b<<endl;
    //     cout<<&a<<endl;
    //     b = 4656;
    //    if(&b == &a)
    //    {
    //     cout<<"yes both address are equal"<<endl;
    //     cout<<a<<endl<<b<<endl;
    //    }
    //    else
    //    {
    //     cout<<"no both address are not equal"<<endl;
    //    }

    string food = "pizza";
    string *ptr = nullptr;
    ptr = &food;
    cout << "value of food " << food << endl;

    cout << "address point to food  = " << &food << endl;
    cout << "address point to food ptr = " << ptr << endl;
    cout << "value of food *ptr = " << *ptr << endl;
    cout << "address of ptr &ptr = " << &ptr << endl;

    int a = 100;
    int *p = &a;
    int **pp = &p;

    cout << "a=" << a << endl;
    cout << "address of a = " << &a << endl;
    cout << p << endl;
    cout << &p << endl;
    cout << **pp << endl;

    **pp = 500;
    cout << a << endl;

    createPerson();
    return 0;
}
class Person
{
public:
    string name = "Montu kharb";

Person()
{
        cout << name << endl;
}
friend void display(Person per);

};

void display(Person per)
{
    cout<<"Name is "<<per.name<<endl;
}
void createPerson()
{
    cout << "person class";
    Person obj;
    display(obj);
};