#include <complex.h>
#include <stdio.h>

void main() {
  double _Complex a = 1.2 + 3.4i;
  printf("%f%+fi\n", creal(a), cimag(a));
}
