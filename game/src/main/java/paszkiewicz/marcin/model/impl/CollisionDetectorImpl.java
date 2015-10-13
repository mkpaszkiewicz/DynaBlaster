package paszkiewicz.marcin.model.impl;

import paszkiewicz.marcin.model.CollisionDetector;
import paszkiewicz.marcin.model.map.TiledMap;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.TiledGraphic;

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
    public boolean isCollision(TiledGraphic animatedGraphic1, TiledGraphic animatedGraphic2)
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
}
