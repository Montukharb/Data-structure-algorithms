#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main()
{
    ifstream infile; 
    infile.open("testing.txt");
    string linebyline;
  //read line by line file
    while( getline(infile , linebyline) )
    {
        cout<<linebyline;
    }
    
    infile.close();

    return 0;
}