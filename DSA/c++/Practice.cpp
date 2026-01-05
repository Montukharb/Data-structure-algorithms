#include <iostream>
#include <string>
using namespace std;

int main()
{
    cout << "hello c++\n";
    bool status = true;
    cout << status << " f = " << false;
    cout << "\n"
         << sizeof(int);
    cout << "\n"
         << sizeof(float);
    cout << "\n"
         << sizeof(double);
    cout << "\n"
         << sizeof(char);
    cout << "\n"
         << sizeof(long double);
    cout << "\n"
         << sizeof(string);

    string str = "Hello this";
    char ch[24] = "\nhello this is 24 char";
    cout << ch;
    cout << "\nlenth of string count by alias of length size " << str.size()<<endl;
    cout<<str.at(0)<<endl;
    str.at(0) = 'M';
    cout<<str<<endl;
    cout<<"Enter your name\n";
    string name;
    // cin >> name;
    getline(cin, name);
    cout<<"Hello "<<name;
    cout<<"\nEnter any char \n";
    auto x = cin.get();
    cout<<x;
    cout<<endl<<(char)x<<endl;
    
    // if(true)
    // cout<<"true";
    // else
    // cout<<"False";

  int day = 1;
  bool t = false;

  switch (day) {
  case 1: if(!t)
    cout << "Monday";
    else
      cout<<"not monday";
    break;
  case 2:
    cout << "Tuesday";
    break;
  case 3:
    cout << "Wednesday";
    break;
  case 4:
    cout << "Thursday";
    break;
  case 5:
    cout << "Friday";
    break;
  case 6:
    cout << "Saturday";
    break;
  case 7:
    cout << "Sunday";
    break;
   default:
   cout<<"noa a valid day";
   break;
  }


    return 0;
}