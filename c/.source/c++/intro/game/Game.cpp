#include <cstdlib>
#include <ctime>
#include <iostream>
using namespace std;

class Hero {
  int power;

public:
  Hero() : power(100) {}
  void attack(int n);
  void attacked(int n);
};
