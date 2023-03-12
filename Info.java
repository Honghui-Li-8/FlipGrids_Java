



public class Info
{
  private boolean[] info = new boolean[9];

  public Info()
  {
    for(int i = 0; i<9;i++)
    {
      info[i] = 1 == (int)(Math.random()*2);
    }
  }

  public void flip(int i)
  {
    info[i] = !info[i];
  }
}
