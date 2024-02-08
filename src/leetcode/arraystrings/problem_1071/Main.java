package leetcode.arraystrings.problem_1071;

public class Main {

  public static void main(final String[] args) {
    gcdOfStrings("ABCABC", "ABC");
  }

  public static String gcdOfStrings(String str1, String str2) {
    final char[] ch1 = str1.toCharArray();
    final char[] ch2 = str2.toCharArray();
    final int gcd = gcd(ch1.length, ch2.length);
    final String substr = str1.length() < str2.length() ? str1.substring(0, gcd) : str2.substring(0, gcd);
    if (!str1.replaceAll(substr, "").isEmpty() || !str2.replaceAll(substr, "").isEmpty()) {
      return "";
    }
    if (str1.contains(substr) && str2.contains(substr)) {
      return substr;
    }
    return "";
  }

  static int gcd(int a, int b) {
    // stores minimum(a, b)
    int i;
    if (a < b)
      i = a;
    else
      i = b;

    // take a loop iterating through smaller number to 1
    for (i = i; i > 1; i--) {

      // check if the current value of i divides both
      // numbers with remainder 0 if yes, then i is
      // the GCD of a and b
      if (a % i == 0 && b % i == 0)
        return i;
    }

    // if there are no common factors for a and b other
    // than 1, then GCD of a and b is 1
    return 1;
  }

}
