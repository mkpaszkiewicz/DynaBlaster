package paszkiewicz.marcin.view.graphic;

public interface DynamicGraphic
{
    enum Movement
    {
        LEFT, RIGHT, UP, DOWN, NONE;
    }

    float getSpeed();

    void setSpeed(float speed);
    
    void stop();
    
    void move(Movement movement);

    boolean isMoving();

    boolean isMovingLeft();

    boolean isMovingRight();

    boolean isMovingUp();

    boolean isMovingDown();
}
