
public class Exponentiation
{
  public static void main(String[] args)
  {
    test(0, 1);
    test(0, 2);
    test(0, 3);

    test(1, 1);
    test(1, 2);
    test(1, 3);

    test(2, 1);
    test(2, 2);
    test(2, 3);

    test(5, 6);
    test(7, 8);
    test(10, 11);

  }

  public static void test(int base, int exponent)
  {
    int expected = powerLinear(base, exponent);
    int result = powerLogarithmic(base, exponent);

    if(result != expected)
    {
      System.out.println(base + "^" + exponent + ": expected = " + expected + ", result = " + result);
    }
  }

  //O(N)
  public static int powerLinear(int base, int exponent)
  {
    int power = 1;
    for(int i = 0; i < exponent; i++)
      power *= base;
    return power;
  }

  //O(Log n)
  public static int powerLogarithmic(int base, int exponent)
  {
    if(exponent == 0)
      return 1;
    int power = powerLogarithmic(base*base, exponent / 2);
    if((exponent & 1) == 1)
      power = power * base;
    return power;
  }
}
