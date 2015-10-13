package paszkiewicz.marcin.model;

import paszkiewicz.marcin.model.map.TiledMap;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.TiledGraphic;

public interface CollisionDetector
{
    void detectCollision(DynamicGraphic dynamicGraphic, TiledMap tiledMap);

    boolean isCollision(TiledGraphic animatedGraphic1, TiledGraphic animatedGraphic2);
}
