package paszkiewicz.marcin.view.graphic;

public interface DynamicGraphic extends TiledGraphic
{
    enum Movement
    {
        LEFT, RIGHT, UP, DOWN, NONE;
    }

    float getSpeed();

    void setSpeed(float speed);
    
    boolean isPassingThroughBlockedTile();
    
    void stop();

    void move(Movement movement);

    boolean isMoving();

    boolean isMovingLeft();

    boolean isMovingRight();

    boolean isMovingUp();

    boolean isMovingDown();

    float getxShift();

    void setxShift(float xShift);

    float getyShift();

    void setyShift(float yShift);
}
