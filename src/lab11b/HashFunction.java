package lab11b;
class HashFunction
{

  // (d)Use the same name as the key for
  //sfold function in HashFunction class
  // to create the hash code for the table entry.
  int sfold(String s, int M)
  {
    int intLength = s.length() / 4;
    int sum = 0;
    for (int j = 0; j < intLength; j++)
    {
      char c[] = s.substring(j * 4, (j * 4) + 4).toCharArray();
      int mult = 1;
      for (int k = 0; k < c.length; k++)
      {
        sum += c[k] * mult;
        mult *= 256;
      }
    }
    char c[] = s.substring(intLength * 4).toCharArray();
    int mult = 1;
    for (int k = 0; k < c.length; k++)
    {
      sum += c[k] * mult;
      mult *= 256;
    }
    return (Math.abs(sum) % M);
  }

}

