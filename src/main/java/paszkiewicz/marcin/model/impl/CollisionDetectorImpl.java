package paszkiewicz.marcin.model.impl;

import paszkiewicz.marcin.model.CollisionDetector;
import paszkiewicz.marcin.model.map.TiledMap;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;

public class CollisionDetectorImpl implements CollisionDetector
{
    @Override
    public void detectCollision(DynamicGraphic dynamicGraphic, TiledMap tiledMap)
    {
        if (!dynamicGraphic.isMoving())
        {
            return;
        }

        int xTileAim = dynamicGraphic.getxTile();
        int yTileAim = dynamicGraphic.getyTile();
        if (dynamicGraphic.isMovingRight())
        {
            xTileAim += 1;
        }
        else if (dynamicGraphic.isMovingLeft())
        {
            xTileAim += -1;
        }
        else if (dynamicGraphic.isMovingDown())
        {
            yTileAim += 1;
        }
        else if (dynamicGraphic.isMovingUp())
        {
            yTileAim += -1;
        }

        if (tiledMap.isForbiddenTile(xTileAim, yTileAim)
                || !dynamicGraphic.isPassingThroughBlockedTile() && tiledMap.isBlockedTile(xTileAim, yTileAim))
        {
            dynamicGraphic.stop();
        }
    }

    @Override
    public boolean isCollision(AnimatedGraphic animatedGraphic1, AnimatedGraphic animatedGraphic2)
    {
        if (animatedGraphic1.getxTile() == animatedGraphic2.getxTile() && animatedGraphic1.getyTile() == animatedGraphic2.getyTile())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean isCollision(AnimatedGraphic animatedGraphic, DynamicGraphic dynamicGraphic)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCollision(DynamicGraphic dynamicGraphic1, DynamicGraphic dynamicGraphic2)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
