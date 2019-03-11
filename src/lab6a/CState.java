package lab6a;

public class CState {

private String Prefix = new String();
private String Suffix = new String();
public CState (String Pre, String Suff)
{
 Prefix = Pre;
 Suffix = Suff;
}
public String pre()
{
 return Prefix;
}
public String suff()
{
  return Suffix;
 }
}