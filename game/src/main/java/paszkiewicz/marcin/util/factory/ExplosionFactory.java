package paszkiewicz.marcin.util.factory;

import java.util.LinkedList;
import java.util.List;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.model.map.Map;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class ExplosionFactory
{
    private static Bomb bomb;
    private static Map map;

    public static List<AnimatedGraphic> createExplosion(Bomb bomb, Map map)
    {
        ExplosionFactory.bomb = bomb;
        ExplosionFactory.map = map;

        List<AnimatedGraphic> flames = new LinkedList<AnimatedGraphic>();

        flames.add(createCentreFlame());
        flames.addAll(createHorizontalFlames());
        flames.addAll(createVerticalFlames());

        return flames;
    }

    private static AnimatedGraphic createCentreFlame()
    {
        AnimatedGraphic centreExplosion = AnimatatedGraphicPrototypeFactory.createCentreFlame();
        centreExplosion.setxTile(bomb.getxTile());
        centreExplosion.setyTile(bomb.getyTile());

        return centreExplosion;
    }

    private static List<AnimatedGraphic> createHorizontalFlames()
    {
        List<AnimatedGraphic> flames = new LinkedList<AnimatedGraphic>();
        AnimatedGraphic flame;

        int xTile = bomb.getxTile();
        int yTile = bomb.getyTile();
        for (int i = 1; i <= bomb.getOwner().getBombRange(); i++)
        {
            xTile++;

            if (map.isBlockedTile(xTile, yTile))
            {
                if(!map.isForbiddenTile(xTile, yTile))
                {
                    map.destroyWall(xTile, yTile);
                }
                break;
            }

            if (i == bomb.getOwner().getBombRange())
            {
                flame = AnimatatedGraphicPrototypeFactory.createRightFlame();
            }
            else
            {
                flame = AnimatatedGraphicPrototypeFactory.createHorizontalFlame();
            }

            flame.setxTile(xTile);
            flame.setyTile(yTile);

            flames.add(flame);

        }

        xTile = bomb.getxTile();
        for (int i = 1; i <= bomb.getOwner().getBombRange(); i++)
        {
            xTile--;

            if (map.isBlockedTile(xTile, yTile))
            {
                if(!map.isForbiddenTile(xTile, yTile))
                {
                    map.destroyWall(xTile, yTile);
                }
                break;
            }

            if (i == bomb.getOwner().getBombRange())
            {
                flame = AnimatatedGraphicPrototypeFactory.createLeftFlame();
            }
            else
            {
                flame = AnimatatedGraphicPrototypeFactory.createHorizontalFlame();
            }

            flame.setxTile(xTile);
            flame.setyTile(yTile);

            flames.add(flame);

        }

        return flames;
    }

    private static List<AnimatedGraphic> createVerticalFlames()
    {
        List<AnimatedGraphic> flames = new LinkedList<AnimatedGraphic>();
        AnimatedGraphic flame;

        int xTile = bomb.getxTile();
        int yTile = bomb.getyTile();
        for (int i = 1; i <= bomb.getOwner().getBombRange(); i++)
        {
            yTile++;

            if (map.isBlockedTile(xTile, yTile))
            {
                if(!map.isForbiddenTile(xTile, yTile))
                {
                    map.destroyWall(xTile, yTile);
                }
                break;
            }

            if (i == bomb.getOwner().getBombRange())
            {
                flame = AnimatatedGraphicPrototypeFactory.createBottomFlame();
            }
            else
            {
                flame = AnimatatedGraphicPrototypeFactory.createVerticalFlame();
            }

            flame.setxTile(xTile);
            flame.setyTile(yTile);
            flames.add(flame);
        }

        yTile = bomb.getyTile();
        for (int i = 1; i <= bomb.getOwner().getBombRange(); i++)
        {
            yTile--;

            if (map.isBlockedTile(xTile, yTile))
            {
                if(!map.isForbiddenTile(xTile, yTile))
                {
                    map.destroyWall(xTile, yTile);
                }
                break;
            }

            if (i == bomb.getOwner().getBombRange())
            {
                flame = AnimatatedGraphicPrototypeFactory.createTopFlame();
            }
            else
            {
                flame = AnimatatedGraphicPrototypeFactory.createVerticalFlame();
            }

            flame.setxTile(xTile);
            flame.setyTile(yTile);
            flames.add(flame);
        }

        return flames;

    }
}