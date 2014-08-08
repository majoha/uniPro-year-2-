#include <iostream>
#include <cstdlib>

int footInchCon();
int metricCal();


using namespace std;

int main()
{
    string choice;
    int i;
    int m;
    //This is a test
    
    cout << "This program will find the BMI from the values given \n";
    cout << "\n";
    cout << "This program will accept values in (i)mperial (ft & in or stone & lb) and (m)etric (m & kg) \n";
    cout << "\n";
           
    cout << "Please enter your choice \n";
    
    cin >> choice;
    
   
    if (choice == "i")
    {
        cout << "You have chosen the imperial unit... \n";
        cout << "This uses the units foot and inches for height and stone and pounds for weight \n";
        cout << "You will be asked for the height measurements first and then the weight\n";
        cout << "\n";
        
        footInchCon();
    }

    
    if (choice == "m")
    {
        cout << "You have chosen the metric unit... \n";
        cout << "This uses the units metres for height and kilograms for weight \n";
        cout << "You will be asked for the height measurements first\n";
        cout << "\n";
        
        metricCal();
    }
    
    else if (choice != "i", "m")
    {
        cout << "Please enter a valid choice! \n";
        cout << "\n";
        
        main();
        
    };
    
    return 0;
};
