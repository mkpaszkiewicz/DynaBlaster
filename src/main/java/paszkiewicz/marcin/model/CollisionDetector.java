package paszkiewicz.marcin.model;

import paszkiewicz.marcin.model.map.TiledMap;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;

public interface CollisionDetector
{
    void detectCollision(DynamicGraphic dynamicGraphic, TiledMap tiledMap);

    boolean isCollision(AnimatedGraphic animatedGraphic1, AnimatedGraphic animatedGraphic2);

    boolean isCollision(AnimatedGraphic animatedGraphic, DynamicGraphic dynamicGraphic);

    boolean isCollision(DynamicGraphic dynamicGraphic1, DynamicGraphic dynamicGraphic2);
}
