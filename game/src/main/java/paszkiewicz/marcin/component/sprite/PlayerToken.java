package paszkiewicz.marcin.component.sprite;

public class PlayerToken
{
    private int rememberedAllAvailableBombs;
    
    private int rememberedBombRange;
    
    private float rememberedSpeed;

    public int getRememberedAllAvailableBombs()
    {
        return rememberedAllAvailableBombs;
    }

    public void setRememberedAllAvailableBombs(int rememberedAllAvailableBombs)
    {
        this.rememberedAllAvailableBombs = rememberedAllAvailableBombs;
    }

    public int getRememberedBombRange()
    {
        return rememberedBombRange;
    }

    public void setRememberedBombRange(int rememberedBombRange)
    {
        this.rememberedBombRange = rememberedBombRange;
    }

    public float getRememberedSpeed()
    {
        return rememberedSpeed;
    }

    public void setRememberedSpeed(float rememberedSpeed)
    {
        this.rememberedSpeed = rememberedSpeed;
    }
}
