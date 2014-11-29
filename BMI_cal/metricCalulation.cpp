#include <iostream>
#include <cstdlib>

int footInchCon();
int stonePoundCon();
int bmiCal();
int main();

using namespace std;

int metricCal()
{
    
    float userMetre = 0;
    float userkg = 0;
    float bmi = 0;
    
    cout << "Please enter the metre value \n";
   
    cin >> userMetre;
    
    cout << "Please enter the kg value \n";
    
    cin >> userkg;

    bmi = userkg / (userMetre * userMetre);
    
    cout << "The Body Mass Index has been worked out at **" << bmi << "**\n";
    cout << "\n";
    cout << "\n";
    
    main();
    
};