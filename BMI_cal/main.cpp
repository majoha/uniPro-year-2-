#include <iostream>
#include <cstdlib>


using namespace std;

int main()
{
       
    float height = 0;
    float weight = 0;
    float BMI = 0;

    cout << "This program will calculate the BMI from the values given... \n";
    cout << "\n";
    cout << "Please enter a height value, units must be in metres, eg., 1.8\n";

    cin >> height;

    cout << "Please enter a weight value, units must be in kilograms, eg., 69 \n";

    cin >> weight;
    
    BMI = weight / (height * height);
    
    cout << "The BMI has been calculated as " << BMI << "\n";  
  
    return 0;        
}