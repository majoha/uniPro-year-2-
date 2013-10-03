#include <iostream>
#include <cstdlib>

#include "converFuncs.cpp"
#include "converFuncs.h"


using namespace std;

int footInchCon();
int stonePoundCon();
int conversion();
int main();

//Main loop
int main()
{
                    
    int choice;
    int choiceTwo;
    
    
    cout << "This program will find the BMI from the values given \n";
    cout << "\n";
    cout << "This program will accept values in (1)imperial (ft & in or stone & lb) and (2)metric (m & kg) \n";
           
    cout << "Please enter your choice \n";
    
    cin >> choice;
    
    if (choice == 1)
    {
        cout << "1)Foot and inchs or 2)stone and pounds \n";
        cout << "please enter a number; 1 or 2 \n";
        
        cin >> choiceTwo;
        
        if (choiceTwo == 1)
        {
            footInchCon();
        }
        
        if (choiceTwo == 2)
        {
            stonePoundCon();
        }
        
        else if (choiceTwo != 1, 2)
        {
            cout << "Please enter a valid integer \n";
            cout << "\n";
            main();
        };
    }
    
    if (choice == 2)
        {
            conversion();
        }
    else if (choice != 1, 2)
        {
            cout << "Please enter a valid integer \n";
            main();
        };

    return 0;        
};