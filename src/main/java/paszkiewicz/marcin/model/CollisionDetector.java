package paszkiewicz.marcin.model;

import paszkiewicz.marcin.model.map.TiledMap;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;

public interface CollisionDetector
{
    void detectCollision(DynamicGraphic dynamicGraphic, TiledMap tiledMap);
}
