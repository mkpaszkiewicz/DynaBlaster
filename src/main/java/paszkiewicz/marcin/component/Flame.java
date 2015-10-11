package paszkiewicz.marcin.component;

import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Flame extends AnimatedGraphicElement
{
    protected int priority = 0;

    public Flame()
    {
        super();
    }

    @Override
    public Flame clone()
    {
        Flame flame = new Flame();
        flame.setAnimation(animation.copy());
        flame.setImage(image);
        flame.setState(state);
        flame.setAnimationLength(animationLength);
        flame.setPriority(priority);

        return flame;
    }

    public boolean hasHigherPriority(Flame explosion)
    {
        if (getPriority() > explosion.getPriority())
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
