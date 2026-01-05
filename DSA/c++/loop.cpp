#include <iostream>
#include <vector>
using namespace std;

void display();

// we can create structure using named structure 
// it is possible to create instace of structure n numbers of times
struct structurename{
    int num;    
    float ss;
    string name;
} name2,name1;
// name2 and name2 are variable of structue direct access using this variable can't be create instance of variabele



int main()
{
    cout << "loop started\n";
    int count = 0;

    for (int i = 0; i < 5; i++)
    {
        count++;
    }
    cout << "Count = " << count << endl;

   cout<<"even or odd number\n";
  cout<<"Enter your number\n";
  int num;
  cin>>num;

  if(num%2==0)
    cout<<"Number is even\n";
  else
    cout<<"Number is odd\n";

  vector<int> arr = {10,20,30,40};

  arr.push_back(50);
  int last = arr.size()-1;
  swap(arr[1],arr[last]);
  for(int item: arr)
  {
    cout<<item<<endl;
  }
 
  display();
  return 0;
}

void display()
{
    cout<<"display function";
    structurename s1;
    s1.num = 10;
    s1.ss = 20.5;
    s1.name = "Montu";
    
    cout<<s1.num<<endl;
    cout<<s1.ss<<endl;
    cout<<s1.name<<endl;
    
    name2.num = 20;
    name2.ss = 30.5;
    name2.name = "Monu";
    
    cout<<name2.num<<endl;
    cout<<name2.ss<<endl;
    cout<<name2.name<<endl;
    // const int a = 101;
    // a = 102; can't change value

}

