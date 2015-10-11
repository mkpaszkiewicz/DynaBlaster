package paszkiewicz.marcin.model.map;

public interface TiledMap
{
    boolean isForbiddenTile(int xTile, int yTile);
    
    boolean isBlockedTile(int xTile, int yTile);
}
