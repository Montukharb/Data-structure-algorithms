#include <iostream>
using namespace std;
#include <string>
#include <typeinfo>
#include <cmath>

int main()
{
    int item = 10;
    do
    {
        cout << "item value = " << item;
        item++;
    } while (item < 5);

    int i = 0;
    for (; i <= 10;)
    {

        cout << i << " ";
        i++;
    }
    int arr[] = {10, 654, 66, 48, 5, 95, 6, 48};
    int length = 0;
    for (auto x : arr)
    {
        ++length;
                    
         cout << x << " ";
    }
cout<<"The length is array = "<<length;
 
// reverse some number 123456 to 654321

int origNumber = 123456;
int number = origNumber;
int revNumber = 0;

while(number)
{
    // find the last number of number variable and assign revNumber; 
    revNumber = revNumber * 10 + number % 10;

    //remove the last digit from number;
    number /= 10; 
}
cout<<"\nThe original numbers are = "<<origNumber;
cout<<"\nThe reverse numbers is = "<<revNumber;

//even and odd numbers find;
int num = 46;
// cout<<"Enter number = ";
// cin>>num;
if(num % 2 == 0)
{
    cout<<"\neven number";
}
else
{
    cout<<"\nodd number";
}

// find all even number between to 1 to 50;
int count = 0;
for(int i = 2; i<=50; i += 2)
{
    count++;
    cout<<" "<<i;
}
cout<<"\nThe total number are find between 1 and 50 are = "<<count;
    return 0;
}

// namespace spaceVechile{

//     class vechile{
//     public:
//         void vechileType(){
//             cout<<"offroad vechile";
//         }
//     };

// }

// namespace operations{
//     class bitsmainpulation{
//         public: void oddEven()
//         {
//             int x = 0;
//             cout<<"\nEnter any number = ";
//             cin>>x;
//             if(x & 1)
//             {
//                 cout<<"\nOdd number = "<<x;
//             }
//             else
//             {
//                 cout<<"\nEven number = "<<x;
//             }
//         }
//     };
// }
// namespace My_name_space
// {
//     int x = 100;
//     void disp()
//     {
//         cout << "\ni am myname space funtion";
//     }
//     class samp
//     {

//     public:
//         void demo()
//         {
//             cout << "its working class function";
//             demo2();
//         }

//     private:
//         void demo2()
//         {
//             cout << "\nsecond method";
//         }
//     };
// }

// namespace user
// {
//     class details
//     {
//     public:
//         string datainput()
//         {
//             string name;
//             int age = 0;
//             cout << "Enter the user basic details";
//             cout << "\nName = ";
//             getline(cin, name);
//             cout << "\nEnter user age = ";
//             cin >> age;

//             return "Name = " + name + "\nAge = " + to_string(age);
//         }

//     public:
//         void showdata()
//         {
//             cout << datainput();
//         }
//     };
// }

// int main()
// {
//     cout << My_name_space::x;
//     My_name_space::disp();
//     My_name_space::samp obj;
//     obj.demo();
//     user::details uobj;
//     uobj.showdata();
//     spaceVechile :: vechile objvec;
//     objvec.vechileType();
//     string str = "hello";
//     //find data type

//     cout<<endl<<"size of string"<<sizeof(str);
//     auto x = 45.5f;
//     auto ss = string("hello");
//     cout<<endl<<typeid(x).name();
//     cout<<endl<<typeid(ss).name();
//    for(int i = 10; i>=0; i--)
//    {
//     cout<<" "<<i;
//    }
//    int inc = 5;

//    cout<<endl<<--inc;

//    operations::bitsmainpulation bitobject;
//    bitobject.oddEven();

//    cout<<"\n max value = "<<max(4,5);
//    cout<<"\n min value = "<<min(-8,-15);
//    cout<<"\n log value = "<<log10l(10);
//    cout<<boolalpha;    //boolalpha is a mainpulator show true false instead of 1 and 0 for output;
//    bool b = true;
//    cout<<b;

//    // if you want to go back to the default behaviour (printing 1 and 0), you can use noboolalpha;
//    cout<<noboolalpha; //this mainpulation nothing to print our screen but change the method of our bool representation by default behaviour 1 and 0.
//    int bd = 10;
//    cout<<((bd == 10) ? "\nyes bd is 10": "b is not 10");

//    return 0;
// }

void fun()
{
     cout<<"dsf";
}
class Simple{
      public: 
      void fun()
      {
        cout<<"method";
      }
      
      
};