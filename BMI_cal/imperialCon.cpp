#include <iostream>
#include <cstdlib>

int footInchCon();
int stonePoundCon(float);
int bmiCal();
int main();

using namespace std;

int footInchCon()
{
    
    const float foot = 0.083;
    const float metre = 0.3;
    
    float userFoot = 0;
    float userInch = 0;
    float a = 0;
    float b = 0;
    float impConverted = 0;
    
    
    cout << "Please enter the foot value \n";
   
    cin >> userFoot;
    
    cout << "Please enter the inch value \n";
    
    cin >> userInch;
    
    a = userFoot * metre;
    b = (userInch * foot) * metre;
    
    impConverted = a + b;
    
    cout << "The height measurement converted to metres is " << impConverted << "\n";
    cout << "\n";
   
    stonePoundCon(impConverted);
    
};

int stonePoundCon(float impConverted)
{
    const float kg = 6.35;
    const float stone = 0.07;
    
    float userStone = 0;
    float userPound = 0;
    float x = 0;
    float y = 0;;
    float convertedTwo = 0;
    float bmi;
    
    cout << "Please enter the stone value \n";
   
    cin >> userStone;
    
    cout << "Please enter the pound value \n";
    
    cin >> userPound;
    
    x = userStone * kg;
    y = (userPound * stone) * kg;
    
    convertedTwo = x + y;
    
    cout << "The converted measurement to kilogram's is " << convertedTwo <<"\n";
    cout << "\n";
    cout << "\n";
    
    bmi = convertedTwo / (impConverted * impConverted);
    
    cout << "The Body Mass Index has been worked out at **" << bmi << "**\n";
    cout << "\n";
    cout << "\n";
    
    main();
};