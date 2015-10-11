package paszkiewicz.marcin.component;

import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Explosion extends AnimatedGraphicElement
{
    protected int priority = 0;

    public Explosion()
    {
        super();
    }

    public boolean hasHigherPriority(Explosion explosion)
    {
        if (getPriority() >= explosion.getPriority())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
